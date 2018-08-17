package com.wmp.api.base.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wmp.common.constants.ApiDocTypeEnum;
import com.wmp.common.util.SwaggerApiDocUtils;

import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;

/**
 * @ClassName: SwaggerController
 * @Description: TODO(swagger2 接口文档下载控制器)
 * @author chenaonan
 * @date 2018年8月8日 上午11:50:45
 */
@Controller
@RequestMapping("/swagger")
@ApiIgnore
public class SwaggerController {

	@RequestMapping(value = "/markdown", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> downloadFile() throws IOException {
		return SwaggerApiDocUtils.downloadApiDoc(ApiDocTypeEnum.MARKDOWN);
	}

	@RequestMapping(value = "/confluence", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> downloadConfluence() throws IOException {
		return SwaggerApiDocUtils.downloadApiDoc(ApiDocTypeEnum.CONFLUENCE);
	}

	@RequestMapping(value = "/asciidoc", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> downloadAsciidoc() throws IOException {
		return SwaggerApiDocUtils.downloadApiDoc(ApiDocTypeEnum.ASCIIDOC);
	}

	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> downloadJsondoc() throws Exception {
		return SwaggerApiDocUtils.downloadApiDocJson();
	}

	@RequestMapping(value = "/html", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> downloadHtmldoc() throws Exception {
		return SwaggerApiDocUtils.downloadHtmlDoc();
	}
}
