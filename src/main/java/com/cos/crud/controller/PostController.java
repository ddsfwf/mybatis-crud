package com.cos.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cos.crud.model.Post;
import com.cos.crud.repository.PostRepository;

	// Model은 데이터를 Controller에서 Presentation 계층까지
	// 들고 간다.

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostRepository postRepository;
	
	// GET => http://localhost:8080/post
	// GET => http://localhost:8080/post/
	@GetMapping("")
	public String postList(Model model) {
		List<Post> posts = postRepository.findAll();
		model.addAttribute("posts", posts);
		// webapp/WEB-INF/views/post/list.jsp
		return "/post/list";
	}
	
	// GET => http://localhost:8080/post/writeForm
		@GetMapping("writeForm")
		public String writeForm() {
			return "post/writeForm";
		}
	
	// POST => http://localhost:8080/post/update
	@PostMapping("/update")
	public String update(Post post) { //param, form
		try {
			postRepository.update(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/post";  //함수를 호출한다.
	}
	
	// @RequestParam("id")
	//@RequestBody => JSON
	// POST => http://localhost:8080/post/delete/1
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		try {
			postRepository.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/post";
	}
	
	// POST => http://localhost:8080/post/save
	@PostMapping("/save")
	public String save(Post post) { //id = 0, createDate = null, userId = 0
		try {
			postRepository.save(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/post";
	}
	
	// GET => http://localhost:8080/post/1
	@GetMapping("/{id}")
	public String post(@PathVariable int id, Model model) {
		Post post = postRepository.findById(id);
		model.addAttribute("post", post);
		return "post/detail";
	}
	
	// http://localhost:8080/post/updateForm
	@GetMapping("/updateForm/{id}")
	public String updateForm(@PathVariable int id, Model model) {
		Post post = postRepository.findById(id);
		model.addAttribute("post", post);
		return "post/updateForm";
	}
	
}




