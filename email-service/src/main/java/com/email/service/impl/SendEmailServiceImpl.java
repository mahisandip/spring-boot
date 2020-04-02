package com.email.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.email.common.MsgLogger;
import com.email.exception.MailSenderException;
import com.email.jpa.CustomerEntity;
import com.email.jpa.EmailEntity;
import com.email.jpa.OrdersEntity;
import com.email.repository.EmailJpaRepository;
import com.email.repository.OrdersJpaRepoistory;
import com.email.service.SendEmailService;
import com.email.vo.Email;
import com.email.vo.OrderDetails;
import com.email.vo.Request;

@Component
@Transactional(rollbackFor = Exception.class)
public class SendEmailServiceImpl extends MsgLogger implements SendEmailService {

	@Autowired
	private OrdersJpaRepoistory ordersJpaRepository;

	@Autowired
	private EmailJpaRepository emailJpaRepository;

	@Override
	public Email sendNormalEmail(Request request) {
		Email email = request.getEmail();
		email.setFrom("system@domain.com");
		return send(email);
	}

	@Override
	public Email sendEmailWithTemplates(Request request) {

		Email email = request.getEmail();
		email.setFrom("system@domain.com");
		OrderDetails orderDetails = request.getOrderDetails();

		OrdersEntity ordersEntity = ordersJpaRepository.findByOrderId(orderDetails.getOrderId());
		if (ObjectUtils.isEmpty(ordersEntity)) {
			logger.debug("No Order details found for order id :" + orderDetails.getOrderId());
			throw new MailSenderException("No Order details found for order id :" + orderDetails.getOrderId());
		}

		CustomerEntity customerEntity = ordersEntity.getCustomer();
		if (ObjectUtils.isEmpty(customerEntity)) {
			logger.debug("No Customer Id for this order");
			throw new IllegalArgumentException("No Customer Id for this order");
		}

		if (!email.getRecipientEmailAddress().equalsIgnoreCase(customerEntity.getEmail())) {
			logger.debug("No Customer details found for email :" + email.getRecipientEmailAddress());
			throw new MailSenderException("No Customer details found for email :" + email.getRecipientEmailAddress());
		}

		String customerName = customerEntity.getFirstName().concat(" ").concat(customerEntity.getLastName());
		logger.debug("Customer name = " + customerName);
		if (!customerName.equalsIgnoreCase(orderDetails.getCustomerName())) {
			logger.debug("Customer Name not valid");
			throw new MailSenderException("Customer Name not valid");
		}

		if (email.getTemplate().equalsIgnoreCase("Received")) {
			email.setEmailTopic("Order Received");
			email.setEmailBody(this.buildMessageBodyforReceived(customerEntity, ordersEntity));

		} else if (email.getTemplate().equalsIgnoreCase("Shipped")) {
			email.setEmailTopic("Order Shipped");
			email.setEmailBody(this.buildMessageBodyforShipped(customerEntity, ordersEntity));

		} else if (email.getTemplate().equalsIgnoreCase("Cancelled")) {
			email.setEmailTopic("Order Cancelled");
			email.setEmailBody(this.buildMessageBodyforCancelled(customerEntity, ordersEntity));
		}

		return send(email);
	}

	private Email send(Email email) {
		
		EmailEntity emailEntity = new EmailEntity();
		emailEntity.setRecipientEmailAddress(email.getRecipientEmailAddress());
		emailEntity.setEmailSubject(email.getEmailTopic());
		emailEntity.setEmailBody(email.getEmailBody());
		emailEntity.setCreatedBy("SYSTEM");
		emailEntity.setCreatedTime(new Date());

		emailJpaRepository.save(emailEntity);

		return email;
	}

	private String buildMessageBodyforReceived(CustomerEntity customerEntity, OrdersEntity ordersEntity) {

		StringBuilder msgBuilder = new StringBuilder();
		msgBuilder.append("Hi ");
		msgBuilder.append(customerEntity.getFirstName());
		msgBuilder.append(",\n\r");
		msgBuilder.append("Your order has been received. \n\r");
		msgBuilder.append("\tOrder Details\n");
		msgBuilder.append("Name: ");
		msgBuilder.append(customerEntity.getFirstName());
		msgBuilder.append(" ");
		msgBuilder.append(customerEntity.getLastName());
		msgBuilder.append("\n");
		msgBuilder.append("Order Id: ");
		msgBuilder.append(ordersEntity.getOrderId());
		msgBuilder.append("\n");
		msgBuilder.append("Order Time: ");
		msgBuilder.append(ordersEntity.getOrderTime());
		return msgBuilder.toString();
	}

	private String buildMessageBodyforCancelled(CustomerEntity customerEntity, OrdersEntity ordersEntity) {

		StringBuilder msgBuilder = new StringBuilder();
		msgBuilder.append("Hi ");
		msgBuilder.append(customerEntity.getFirstName());
		msgBuilder.append(",\n\r");
		msgBuilder.append("Your order has been cancelled. \n\r");
		msgBuilder.append("\tCancelled Order Details\n");
		msgBuilder.append("Name: ");
		msgBuilder.append(customerEntity.getFirstName());
		msgBuilder.append(" ");
		msgBuilder.append(customerEntity.getLastName());
		msgBuilder.append("\n");
		msgBuilder.append("Order Id: ");
		msgBuilder.append(ordersEntity.getOrderId());
		msgBuilder.append("\n");
		msgBuilder.append("Cancel Time: ");
		msgBuilder.append(ordersEntity.getCancelTime());
		msgBuilder.append("\n");
		msgBuilder.append("Cancel Reason: ");
		msgBuilder.append(ordersEntity.getCancelReason());
		return msgBuilder.toString();
	}

	private String buildMessageBodyforShipped(CustomerEntity customerEntity, OrdersEntity ordersEntity) {

		StringBuilder msgBuilder = new StringBuilder();
		msgBuilder.append("Hi ");
		msgBuilder.append(customerEntity.getFirstName());
		msgBuilder.append(",\n\r");
		msgBuilder.append("Your order has been shipped. \n\r");
		msgBuilder.append("\tOrder Details\n");
		msgBuilder.append("Name: ");
		msgBuilder.append(customerEntity.getFirstName());
		msgBuilder.append(" ");
		msgBuilder.append(customerEntity.getLastName());
		msgBuilder.append("\n");
		msgBuilder.append("Order Id: ");
		msgBuilder.append(ordersEntity.getOrderId());
		msgBuilder.append("\n");
		msgBuilder.append("Shipped Time: ");
		msgBuilder.append(ordersEntity.getShipTime());
		return msgBuilder.toString();
	}

}
