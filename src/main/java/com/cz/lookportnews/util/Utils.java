//package com.cz.lookportnews.util;
//
//import com.qzxy.entity.Apply;
//import com.qzxy.exception.NotNullException;
//import org.apache.http.util.TextUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//
//
//public class Utils {
//
//
//    /**
//     * 检查长传的Apply实体 必填项是否为空
//     * @param apply
//     */
//    public static void checkApply ( Apply apply) {
//         if(apply==null)
//             throw new NotNullException("上传列表为null");
//         if( TextUtils.isEmpty(apply.getRepair()))
//                 throw new NotNullException("维修人姓名有误");
//        if( TextUtils.isEmpty(apply.getTel()))
//            throw new NotNullException("请输入正确的号码");
//        if( apply.getClasss()==null||apply.getClasss()==0)
//            throw new NotNullException("维修类型有误");
//        if( apply.getArea()==null||apply.getArea()==0)
//            throw new NotNullException("维修地址有误");
//        if( apply.getRepairTime()==null)
//            throw new NotNullException("日期格式错误");
//    }
//
//    /**
//     * 保存上传的文件
//     * @param file
//     * @param
//     * @return
//     */
//    public static boolean saveFile ( MultipartFile file ,String saveFilePath) {
//        if ( !file.isEmpty() ) {
////            String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"  
////                        + file.getOriginalFilename();  
//            try {
//                file.transferTo(new File(saveFilePath));
//                return true;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return false;
//    }
//
//}
