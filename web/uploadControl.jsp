<%--
  Created by IntelliJ IDEA.
  User: LZY
  Date: 2020/12/26
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.io.File" %>
<%@page import="java.util.Iterator" %>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach" %>
<%@page import="org.apache.commons.fileupload.FileItem" %>
<%@page import="java.util.List" %>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@page import="org.apache.commons.fileupload.FileItemFactory" %>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //设置请求编码格式
    request.setCharacterEncoding("utf-8");
    //设置上传的文件名
    String uploadFileName = "";
    //表单字段元素的name属性值
    String fieldName = "";
    //请求信息中的内容是否是multipart类型
    boolean isMultipart = ServletFileUpload.isMultipartContent(request);
    //上传文件的存储路径
    String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
    System.out.println("path:" + uploadFilePath);
    if (isMultipart) {
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //获取到表单中所有的文件
        List<FileItem> items = upload.parseRequest(request);
        Iterator<FileItem> iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = iter.next();
            //如果是普通的表单元素
            if (item.isFormField()) {
                fieldName = item.getFieldName();
                if (fieldName.equals("uname")) {
                    System.out.println("这个是用户名的文本框");
                }
            }
            //如果是文件框
            else {
                String fileName = item.getName();
                if (fileName != null && !fileName.equals("")) {
                    //判断上传文件的后缀名
                    //String end = fileName.substring(fileName.lastIndexOf("."));
                    //if(end.equals("png") || end.equals("jpg") || end.equals("gif")){
                    File fullFile = new File(item.getName());
                    File saveFile = new File(uploadFilePath, fullFile.getName());
                    item.write(saveFile);
                    uploadFileName = fullFile.getName();
                    System.out.println("上传成功，文件的名字是：" + uploadFileName);
                    //}else{
                    //	System.out.println("上传文件类型不匹配");
                    //}
                }
            }
        }


			/*for(int i = 0; i < items.size();i ++){
				System.out.println("name:"+items.get(i).getName());
				System.out.println("String:"+items.get(i).getString());
				System.out.println("field:"+items.get(i).getFieldName());
			}	*/
    }

%>
</body>
</html>
