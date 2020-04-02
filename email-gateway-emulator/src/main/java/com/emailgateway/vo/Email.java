package com.emailgateway.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "email")
public class Email implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("template")
	@NotNull
	private String template;
	
	@JsonProperty("from")
	private String from;
	
	@JsonProperty("recipientEmailAddress")
	@NotNull
	private String recipientEmailAddress;
	
	@JsonProperty("emailTopic")
	@NotNull
	private String emailTopic;
	
	@JsonProperty("emailBody")
	@NotNull
	private String emailBody;

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getRecipientEmailAddress() {
		return recipientEmailAddress;
	}

	public void setRecipientEmailAddress(String recipientEmailAddress) {
		this.recipientEmailAddress = recipientEmailAddress;
	}

	public String getEmailTopic() {
		return emailTopic;
	}

	public void setEmailTopic(String emailTopic) {
		this.emailTopic = emailTopic;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(from);
		sb.append("\n");
		sb.append(recipientEmailAddress);
		sb.append("\n\n");
		sb.append(emailTopic);
		sb.append("\n");
		sb.append(emailBody);
		sb.append("\n");
		
		return sb.toString();
	}

}
