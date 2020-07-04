package com.altimetrik.stackoverflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.stackoverflow.domain.Question;
import com.altimetrik.stackoverflow.service.StackOverflowService;
import com.altimetrik.stackoverflow.uijson.QuestionJson;

@RestController
public class StackOverflowController {
	
	@Autowired
	StackOverflowService stackOverflowService;
	
	@PostMapping("/api/question/save")
	public QuestionJson saveQuestion(@RequestBody QuestionJson questionJson) {
		Question question = stackOverflowService.saveQuestion(questionJson.toQuestion());
		return new QuestionJson().toQuestionJson(question);
	}
	
	@GetMapping("api/fetch/question/{questionId}")
	public QuestionJson getQuestion(@PathVariable Long questionId) {
		Question question = stackOverflowService.getQuestion(questionId);
		return new QuestionJson().toQuestionJson(question);
	}
	

}
