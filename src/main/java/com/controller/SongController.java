package com.controller;

import com.model.Song;
import com.model.SongForm;
import com.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;
@Controller
@RequestMapping("song")
public class SongController {
    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String index(Model model) {
        List<Song> songList = songService.findAll();
        model.addAttribute("songs", songList);
        return "index";
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("songs", new SongForm());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView saveProduct(@ModelAttribute SongForm songForm) {
        MultipartFile multipartFile = songForm.getLink();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getLink().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Song song = new Song(songForm.getId(), songForm.getName(),
                songForm.getSinger(), fileName);
        songService.save(song);
        ModelAndView modelAndView = new ModelAndView("redirect:/song");
//        modelAndView.addObject("songs", songForm);
        modelAndView.addObject("message", "Created new song successfully !");
        return modelAndView;
    }
    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id){
        songService.remove(id);
        return "redirect:/song";
    }
}
