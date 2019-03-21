package com.jr.api;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FileUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/files")
//@Api(value="文件上传")
public class Upload {
	private static final String ARTICLE_IMAGES_PATH = "e:/tmp_images/";

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
//	@Produces(MediaType.APPLICATION_JSON)
//	@ApiOperation(value="上传图片",response=String.class)
	public String uploadImage(@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition disposition) {
		String imageName = Calendar.getInstance().getTimeInMillis() + disposition.getFileName();
		try {
			File file = new File(ARTICLE_IMAGES_PATH + imageName);
			FileUtils.copyInputStreamToFile(fileInputStream, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/images/" + imageName;
	}

	@GET
	@Path("/images/{name}.{type}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	@ApiOperation(value="显示图片",response=Void.class)
	public void showImg(@PathParam("name") String imageName, @PathParam("type") String type,
			@Context HttpServletResponse response) {
		try {
			FileUtils.copyFile(new File(ARTICLE_IMAGES_PATH + imageName + "." + type), response.getOutputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
