package top.sxuet.bootwebthymeleafadmin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-08 15:28
 */

/** 文件上传 */
@Controller
@Slf4j
public class FormController {
  @GetMapping("/form_layouts")
  public String formLayouts() {
    return "form/form_layouts";
  }

  @PostMapping("upload")
  public String upload(
      @RequestParam("email") String email,
      @RequestParam("username") String username,
      @RequestParam("headImg") MultipartFile headImg,
      @RequestParam("photos") MultipartFile[] photos) {
    log.info(
        "上传信息：email={},username={},headImg={},photos={}",
        email,
        username,
        headImg.getSize(),
        photos.length);
    if (!headImg.isEmpty()) {
      try {
        String filename = headImg.getOriginalFilename();
        headImg.transferTo(
            new File(
                "/Users/sxuet/workplace/Java/LearningSource/JavaEE_learing/Javasource_Spring/SpringBoot2/boot-web-thymeleaf-admin/src/main/resources/static/"
                    + filename));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    if (photos.length > 0) {
      for (MultipartFile photo : photos) {
        String filename = photo.getOriginalFilename();
        try {
          photo.transferTo(
              new File(
                  "/Users/sxuet/workplace/Java/LearningSource/JavaEE_learing/Javasource_Spring/SpringBoot2/boot-web-thymeleaf-admin/src/main/resources/static/"
                      + filename));
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return "main";
  }
}
