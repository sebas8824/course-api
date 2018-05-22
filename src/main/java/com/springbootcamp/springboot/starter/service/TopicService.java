package com.springbootcamp.springboot.starter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootcamp.springboot.starter.model.Topic;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "Spring Framework", "Spring Framework Description"),
			new Topic("java", "Core Java", "Core Java"),
			new Topic("javascript", "Javascript", "Javascript Description")
			));
	
	public List<Topic> getAllTopics() {
		return topics;
	} 
	
	public Topic getTopicById(String id) {
		return topics.stream().filter(
				t -> t.getId().equals(id)
				).findFirst().get();
	}
	
	public void deleteTopicById(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	public void updateTopic(Topic topic, String id) {
		for (Topic t : topics) {
			if(t.getId().equals(id)) {
				topics.set(topics.indexOf(t), t);
				return;
			}
		}
	}
}
