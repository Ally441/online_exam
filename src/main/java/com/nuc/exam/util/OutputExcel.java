package com.nuc.exam.util;

import com.nuc.exam.entity.*;
import org.apache.poi.common.usermodel.Fill;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OutputExcel {
    public static String OutStudentExcel(HttpServletRequest request, HttpServletResponse response, List<Student> list) throws Exception {

        String message = "fail";
        String dir = request.getSession().getServletContext().getRealPath("/output");
        File fileLocation = new File(dir);
        if (!fileLocation.exists()) {
            boolean isCreated = fileLocation.mkdir();
            if (!isCreated) {
            }
        }
        String webUrl = request.getSession().getServletContext().getRealPath("/output");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd mm-ss");
        String createExcelname = df.format(new Date()) + "OutputExcel.xls";
        String outputFile = webUrl + File.separator + createExcelname;
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, "emp");
        HSSFRow row1 = sheet.createRow(0);
        HSSFCell cell0 = row1.createCell(0, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell1 = row1.createCell(1, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell2 = row1.createCell(2, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell3 = row1.createCell(3, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell4 = row1.createCell(4, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell5 = row1.createCell(5, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell6 = row1.createCell(6, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell7 = row1.createCell(7, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell8 = row1.createCell(8, HSSFCell.CELL_TYPE_STRING);
        cell0.setCellValue("学生id");
        cell1.setCellValue("学生学号");
        cell2.setCellValue("学生姓名");
        cell3.setCellValue("学生密码");
        cell4.setCellValue("学生班级");
        cell5.setCellValue("学生专业");
        cell6.setCellValue("学生电话");
        cell7.setCellValue("学生邮箱");
        cell8.setCellValue("学生性别");


        for (int j = 0; j < list.size(); j++) {

            Student student = new Student();
            student = list.get(j);
            sheet.autoSizeColumn(j);
            sheet.setColumnWidth(j,sheet.getColumnWidth(j)*17/10);
            HSSFRow row = sheet.createRow(j + 1);
            HSSFCell c0 = row.createCell(0, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c1 = row.createCell(1, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c2 = row.createCell(2, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c3 = row.createCell(3, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c4 = row.createCell(4, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c5 = row.createCell(5, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c6 = row.createCell(6, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c7 = row.createCell(7, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c8 = row.createCell(8, HSSFCell.CELL_TYPE_STRING);
            c0.setCellValue(student.getStudentId());
            c1.setCellValue(student.getStudentNumber());
            c2.setCellValue(student.getStudentName());
            c3.setCellValue(student.getStudentPassword());
            c4.setCellValue(student.getStudentClass());
            c5.setCellValue(student.getStudentClassName());
            c6.setCellValue(student.getStudentPhone());
            c7.setCellValue(student.getStudentEmail());
            if(student.getStudentSex()){
                c8.setCellValue("男");
            }else{
                c8.setCellValue("女");
            }
        }
        FileOutputStream fOut = new FileOutputStream(outputFile);
        workbook.write(fOut);
        fOut.flush();
        fOut.close();
        File f = new File(outputFile);
        if (f.exists() && f.isFile()) {
            try {
                FileInputStream fis = new FileInputStream(f);
                URLEncoder.encode(f.getName(), "utf-8");
                byte[] b = new byte[fis.available()];
                fis.read(b);
                response.setCharacterEncoding("utf-8");
                response.setHeader("Content-Disposition", "attachment; filename=" + createExcelname + "");
                ServletOutputStream out = response.getOutputStream();
                out.write(b);
                out.flush();
                out.close();
                if (fis != null) {
                    fis.close();
                }
                f.delete();
                message = "success";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return message;
    }

    public static String OutMultiquestionExcel(HttpServletRequest request, HttpServletResponse response, List<Multiquestion> list) throws Exception {

        String message = "fail";
        String dir = request.getSession().getServletContext().getRealPath("/output");
        File fileLocation = new File(dir);
        if (!fileLocation.exists()) {
            boolean isCreated = fileLocation.mkdir();
            if (!isCreated) {
            }
        }
        String webUrl = request.getSession().getServletContext().getRealPath("/output");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd mm-ss");
        String createExcelname = df.format(new Date()) + "OutputExcel.xls";
        String outputFile = webUrl + File.separator + createExcelname;
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, "emp");
        HSSFRow row1 = sheet.createRow(0);
        HSSFCell cell0 = row1.createCell(0, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell1 = row1.createCell(1, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell2 = row1.createCell(2, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell3 = row1.createCell(3, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell4 = row1.createCell(4, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell5 = row1.createCell(5, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell6 = row1.createCell(6, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell7 = row1.createCell(7, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell8 = row1.createCell(8, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell9 = row1.createCell(9, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell10 = row1.createCell(10, HSSFCell.CELL_TYPE_STRING);
        cell0.setCellValue("题目id");
        cell1.setCellValue("题目名称");
        cell2.setCellValue("题目内容");
        cell3.setCellValue("题目选项");
        cell4.setCellValue("题目选项");
        cell5.setCellValue("题目选项");
        cell6.setCellValue("题目选项");
        cell7.setCellValue("题目答案");
        cell8.setCellValue("题目分数");
        cell9.setCellValue("题目难度系数");
        cell10.setCellValue("题目章节");
        response.setContentType("text/html;charset=UTF-8");

        for (int j = 0; j < list.size(); j++) {

            Multiquestion multiquestion = new Multiquestion();
            multiquestion = list.get(j);
            sheet.autoSizeColumn(j);
            sheet.setColumnWidth(j,sheet.getColumnWidth(j)*17/10);
            HSSFRow row = sheet.createRow(j + 1);
            HSSFCell c0 = row.createCell(0, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c1 = row.createCell(1, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c2 = row.createCell(2, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c3 = row.createCell(3, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c4 = row.createCell(4, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c5 = row.createCell(5, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c6 = row.createCell(6, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c7 = row.createCell(7, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c8 = row.createCell(8, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c9 = row.createCell(9, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c10 = row.createCell(10, HSSFCell.CELL_TYPE_STRING);
            c0.setCellValue(multiquestion.getQuestionId());
            c1.setCellValue(multiquestion.getQuestionName());
            c2.setCellValue(multiquestion.getQuestionContext());
            c3.setCellValue(multiquestion.getQuestionA());
            c4.setCellValue(multiquestion.getQuestionB());
            c5.setCellValue(multiquestion.getQuestionC());
            c6.setCellValue(multiquestion.getQuestionD());
            c7.setCellValue(multiquestion.getAnswear());
            c8.setCellValue(multiquestion.getScore());
            c9.setCellValue(multiquestion.getLevel());
            c10.setCellValue(multiquestion.getQuestionChapter());
        }
        FileOutputStream fOut = new FileOutputStream(outputFile);
        workbook.write(fOut);
        fOut.flush();
        fOut.close();
        File f = new File(outputFile);
        if (f.exists() && f.isFile()) {
            try {
                FileInputStream fis = new FileInputStream(f);
                URLEncoder.encode(f.getName(), "utf-8");
                byte[] b = new byte[fis.available()];
                fis.read(b);
                response.setCharacterEncoding("utf-8");
                response.setHeader("Content-Disposition", "attachment; filename=" + createExcelname + "");
                ServletOutputStream out = response.getOutputStream();
                out.write(b);
                out.flush();
                out.close();
                if (fis != null) {
                    fis.close();
                }
                f.delete();
                message = "success";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return message;
    }

    public static String OutFillquestionExcel(HttpServletRequest request, HttpServletResponse response, List<Fillquestion> list) throws Exception {

        String message = "fail";
        String dir = request.getSession().getServletContext().getRealPath("/output");
        File fileLocation = new File(dir);
        if (!fileLocation.exists()) {
            boolean isCreated = fileLocation.mkdir();
            if (!isCreated) {
            }
        }
        String webUrl = request.getSession().getServletContext().getRealPath("/output");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd mm-ss");
        String createExcelname = df.format(new Date()) + "OutputExcel.xls";
        String outputFile = webUrl + File.separator + createExcelname;
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, "emp");
        HSSFRow row1 = sheet.createRow(0);
        HSSFCell cell0 = row1.createCell(0, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell1 = row1.createCell(1, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell2 = row1.createCell(2, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell3 = row1.createCell(3, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell4 = row1.createCell(4, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell5 = row1.createCell(5, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell6 = row1.createCell(6, HSSFCell.CELL_TYPE_STRING);
        cell0.setCellValue("题目id");
        cell1.setCellValue("题目名称");
        cell2.setCellValue("题目内容");
        cell3.setCellValue("题目答案");
        cell4.setCellValue("题目分数");
        cell5.setCellValue("题目章节");
        cell6.setCellValue("题目难度系数");
        response.setContentType("text/html;charset=UTF-8");

        for (int j = 0; j < list.size(); j++) {

            Fillquestion fillquestion = new Fillquestion();
            fillquestion = list.get(j);
            sheet.autoSizeColumn(j);
            sheet.setColumnWidth(j,sheet.getColumnWidth(j)*17/10);
            HSSFRow row = sheet.createRow(j + 1);
            HSSFCell c0 = row.createCell(0, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c1 = row.createCell(1, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c2 = row.createCell(2, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c3 = row.createCell(3, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c4 = row.createCell(4, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c5 = row.createCell(5, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c6 = row.createCell(6, HSSFCell.CELL_TYPE_STRING);
            c0.setCellValue(fillquestion.getQuestionId());
            c1.setCellValue(fillquestion.getQuestionName());
            c2.setCellValue(fillquestion.getQuestionContext());
            c3.setCellValue(fillquestion.getAnswear());
            c4.setCellValue(fillquestion.getScore());
            c5.setCellValue(fillquestion.getQuestionChapter());
            c6.setCellValue(fillquestion.getLevel());
        }
        FileOutputStream fOut = new FileOutputStream(outputFile);
        workbook.write(fOut);
        fOut.flush();
        fOut.close();
        File f = new File(outputFile);
        if (f.exists() && f.isFile()) {
            try {
                FileInputStream fis = new FileInputStream(f);
                URLEncoder.encode(f.getName(), "utf-8");
                byte[] b = new byte[fis.available()];
                fis.read(b);
                response.setCharacterEncoding("utf-8");
                response.setHeader("Content-Disposition", "attachment; filename=" + createExcelname + "");
                ServletOutputStream out = response.getOutputStream();
                out.write(b);
                out.flush();
                out.close();
                if (fis != null) {
                    fis.close();
                }
                f.delete();
                message = "success";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return message;
    }

    public static String OutJudgequestionExcel(HttpServletRequest request, HttpServletResponse response, List<Judgequestion> list) throws Exception {

        String message = "fail";
        String dir = request.getSession().getServletContext().getRealPath("/output");
        File fileLocation = new File(dir);
        if (!fileLocation.exists()) {
            boolean isCreated = fileLocation.mkdir();
            if (!isCreated) {
            }
        }
        String webUrl = request.getSession().getServletContext().getRealPath("/output");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd mm-ss");
        String createExcelname = df.format(new Date()) + "OutputExcel.xls";
        String outputFile = webUrl + File.separator + createExcelname;
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, "emp");
        HSSFRow row1 = sheet.createRow(0);
        HSSFCell cell0 = row1.createCell(0, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell1 = row1.createCell(1, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell2 = row1.createCell(2, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell3 = row1.createCell(3, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell4 = row1.createCell(4, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell5 = row1.createCell(5, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell6 = row1.createCell(6, HSSFCell.CELL_TYPE_STRING);
        cell0.setCellValue("题目id");
        cell1.setCellValue("题目名称");
        cell2.setCellValue("题目内容");
        cell3.setCellValue("题目答案");
        cell4.setCellValue("题目分数");
        cell5.setCellValue("题目章节");
        cell6.setCellValue("题目难度系数");
        response.setContentType("text/html;charset=UTF-8");

        for (int j = 0; j < list.size(); j++) {

            Judgequestion judgequestion = new Judgequestion();
            judgequestion = list.get(j);
            sheet.autoSizeColumn(j);
            sheet.setColumnWidth(j,sheet.getColumnWidth(j)*17/10);
            HSSFRow row = sheet.createRow(j + 1);
            HSSFCell c0 = row.createCell(0, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c1 = row.createCell(1, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c2 = row.createCell(2, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c3 = row.createCell(3, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c4 = row.createCell(4, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c5 = row.createCell(5, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c6 = row.createCell(6, HSSFCell.CELL_TYPE_STRING);
            c0.setCellValue(judgequestion.getQuestionId());
            c1.setCellValue(judgequestion.getQuestionName());
            c2.setCellValue(judgequestion.getQuestionContext());
            c3.setCellValue(judgequestion.isAnswear());
            c4.setCellValue(judgequestion.getScore());
            c5.setCellValue(judgequestion.getQuestionChapter());
            c6.setCellValue(judgequestion.getLevel());
        }
        FileOutputStream fOut = new FileOutputStream(outputFile);
        workbook.write(fOut);
        fOut.flush();
        fOut.close();
        File f = new File(outputFile);
        if (f.exists() && f.isFile()) {
            try {
                FileInputStream fis = new FileInputStream(f);
                URLEncoder.encode(f.getName(), "utf-8");
                byte[] b = new byte[fis.available()];
                fis.read(b);
                response.setCharacterEncoding("utf-8");
                response.setHeader("Content-Disposition", "attachment; filename=" + createExcelname + "");
                ServletOutputStream out = response.getOutputStream();
                out.write(b);
                out.flush();
                out.close();
                if (fis != null) {
                    fis.close();
                }
                f.delete();
                message = "success";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return message;
    }

    public static String OutProgramquestionExcel(HttpServletRequest request, HttpServletResponse response, List<Programquestion> list) throws Exception {

        String message = "fail";
        String dir = request.getSession().getServletContext().getRealPath("/output");
        File fileLocation = new File(dir);
        if (!fileLocation.exists()) {
            boolean isCreated = fileLocation.mkdir();
            if (!isCreated) {
            }
        }
        String webUrl = request.getSession().getServletContext().getRealPath("/output");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd mm-ss");
        String createExcelname = df.format(new Date()) + "OutputExcel.xls";
        String outputFile = webUrl + File.separator + createExcelname;
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, "emp");
        HSSFRow row1 = sheet.createRow(0);
        HSSFCell cell0 = row1.createCell(0, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell1 = row1.createCell(1, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell2 = row1.createCell(2, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell3 = row1.createCell(3, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell4 = row1.createCell(4, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell5 = row1.createCell(5, HSSFCell.CELL_TYPE_STRING);
        HSSFCell cell6 = row1.createCell(6, HSSFCell.CELL_TYPE_STRING);
        cell0.setCellValue("题目id");
        cell1.setCellValue("题目名称");
        cell2.setCellValue("题目内容");
        cell3.setCellValue("题目答案");
        cell4.setCellValue("题目分数");
        cell5.setCellValue("题目章节");
        cell6.setCellValue("题目难度系数");
        response.setContentType("text/html;charset=UTF-8");

        for (int j = 0; j < list.size(); j++) {

            Programquestion programquestion = new Programquestion();
            programquestion = list.get(j);
            sheet.autoSizeColumn(j);
            sheet.setColumnWidth(j,sheet.getColumnWidth(j)*17/10);
            HSSFRow row = sheet.createRow(j + 1);
            HSSFCell c0 = row.createCell(0, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c1 = row.createCell(1, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c2 = row.createCell(2, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c3 = row.createCell(3, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c4 = row.createCell(4, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c5 = row.createCell(5, HSSFCell.CELL_TYPE_STRING);
            HSSFCell c6 = row.createCell(6, HSSFCell.CELL_TYPE_STRING);
            c0.setCellValue(programquestion.getQuestionId());
            c1.setCellValue(programquestion.getQuestionName());
            c2.setCellValue(programquestion.getQuestionContext());
            c3.setCellValue(programquestion.getAnswear());
            c4.setCellValue(programquestion.getScore());
            c5.setCellValue(programquestion.getQuestionChapter());
            c6.setCellValue(programquestion.getLevel());
        }
        FileOutputStream fOut = new FileOutputStream(outputFile);
        workbook.write(fOut);
        fOut.flush();
        fOut.close();
        File f = new File(outputFile);
        if (f.exists() && f.isFile()) {
            try {
                FileInputStream fis = new FileInputStream(f);
                URLEncoder.encode(f.getName(), "utf-8");
                byte[] b = new byte[fis.available()];
                fis.read(b);
                response.setCharacterEncoding("utf-8");
                response.setHeader("Content-Disposition", "attachment; filename=" + createExcelname + "");
                ServletOutputStream out = response.getOutputStream();
                out.write(b);
                out.flush();
                out.close();
                if (fis != null) {
                    fis.close();
                }
                f.delete();
                message = "success";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return message;
    }
}
