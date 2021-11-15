package com.saraya.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.saraya.model.Fan;
import com.saraya.service.FanService;


@Controller
public class FanController {

	@Autowired
	FanService fs;
	//@Autowired
	//UserValidation uv;
	@RequestMapping(value="/list-fan", method=RequestMethod.GET)
	public String ShowList(ModelMap model) {
		model.addAttribute("fans", fs.getAllFans());
		return "fanList";
	}
	
	//------------------ADDING METHOD----------------------------
	
	@RequestMapping(value="/add-fan", method=RequestMethod.GET)
			public String addFanForm(ModelMap model) {
		model.addAttribute("fa", new Fan());
		return "addFan";
	}
	
	@RequestMapping(value="/add-fan", method=RequestMethod.POST)
	public String fanAdded(ModelMap model, @Valid @ModelAttribute("fa") Fan f, BindingResult result) {
		if(result.hasErrors()) {
			return "addFan";
		}
		fs.addFan(f.getYear(), f.getMake(), f.getModel(), f.getImage());
		model.clear();
		return "redirect:/list-fan";
	}
	
	//----------------------------------------------------------------
	
	
	
	//--------------UPDATE METHOD-----------------------------
	
	@RequestMapping(value="/update-fan", method=RequestMethod.GET)
	public String updateFanForm(ModelMap model, @RequestParam int id) {
		model.addAttribute("fa", fs.findById(id));
		return "addFan";
	}
	//-------------------------------------------------
	@RequestMapping(value="/update-fan", method=RequestMethod.POST)
	public String fanListUpdate(ModelMap model, @Valid @ModelAttribute("fa") Fan f,
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "addFan";
		}
		
		fs.updateByFan(f);
		model.clear();
		return "redirect:/list-fan";
	}
	//-----------------------------------------------------
	
	@RequestMapping(value="/delete-fan", method=RequestMethod.GET)
	public String deleteList(ModelMap model, @RequestParam int id ) {
		fs.deleteFan(id);
		model.clear();
		return "redirect:/list-fan";
		
	}
}