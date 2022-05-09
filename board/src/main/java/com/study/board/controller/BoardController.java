package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardSercie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
=======
>>>>>>> 34d741d976c06846346f9aeaea0b5450ab5a8d13
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {


   @Autowired
   private BoardSercie boardService;

    @GetMapping("/board/write") //localhost:8090/board/write
    public String boardwriteForm(){

        return "boardwrite";
    }

    @PostMapping("/board/writepro")
<<<<<<< HEAD
    public String boardWritePro(Board board ,Model model){
        model.addAttribute("message" , "글 작성이 완료 되었습니다.");
        model.addAttribute("SearchUrl" , "/board/list");
        boardService.write(board);

        return "Message";
=======
    public String boardWritePro(Board board){

        boardService.write(board);

        return "";
>>>>>>> 34d741d976c06846346f9aeaea0b5450ab5a8d13
    }

    @GetMapping("/board/list")
    public String boardList(Model model){
        System.out.println(boardService.boardList());
        model.addAttribute("list",boardService.boardList());
        return "boardList";
    }

    @GetMapping("/board/view")
    public String boardView(Model model , Integer id){

        model.addAttribute("board",boardService.boardView(id));
        return "boardview";
    }

    @GetMapping("/board/delete")
<<<<<<< HEAD
    public String boardDelete(Integer id ,Model model){
        boardService.boardDelete(id);

        model.addAttribute("message" , "글 삭제 완료.");
        model.addAttribute("SearchUrl" , "/board/list");

        return "Message";
    }

    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id , Model model){
        System.out.println("제발류");
        model.addAttribute("board",boardService.boardView(id));

        return "boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id , Board board , Model model){

        Board boardTemp = boardService.boardView(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        model.addAttribute("message" , "글 수정 완료.");
        model.addAttribute("SearchUrl" , "/board/list");

        // 절대 이렇게 하면 안되고 Jpa에서 제공하는 변경감지나 Merge 기능을 따로 공부하자.
        boardService.write(boardTemp);

        return "Message";
    }
=======
    public String boardDelete(Integer id){
        boardService.boardDelete(id);

        return "redirect:/board/list";
    }

>>>>>>> 34d741d976c06846346f9aeaea0b5450ab5a8d13
}
