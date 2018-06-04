package com.abcinstitute.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

@Controller
public class ForumController {
	protected Map<String, String> referenceData(HttpServletRequest request) throws Exception {
		Map<String, Map<String, String>> referenceData = new HashMap<String, Map<String, String>>();
		Map<String,String> states = new LinkedHashMap<String,String>();
		states.put("NSW", "New South Wales");
		states.put("SA", "South Australia");
		states.put("WA", "West Australia");
		states.put("ACT", "Australian Capital Teroteries");
		states.put("NT","Northen Terroteries");
		referenceData.put("stateList", states);
		return states;
	}

}
