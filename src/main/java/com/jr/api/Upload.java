package com.jr.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FileUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/files")
public class Upload {
	private static final String ARTICLE_IMAGES_PATH = "e:/tmp_images/";

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
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
	public void showImg(@PathParam("name") String imageName, @PathParam("type") String type,
			@Context HttpServletResponse response) {
		try {
			FileUtils.copyFile(new File(ARTICLE_IMAGES_PATH + imageName + "." + type), response.getOutputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
