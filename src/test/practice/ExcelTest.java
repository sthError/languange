//import com.alibaba.excel.EasyExcel;
//import com.alibaba.excel.ExcelWriter;
//import com.alibaba.excel.metadata.Head;
//import com.alibaba.excel.write.merge.AbstractMergeStrategy;
//import com.alibaba.excel.write.metadata.WriteSheet;
//import com.alibaba.excel.write.metadata.fill.FillConfig;
//import com.alibaba.excel.write.metadata.fill.FillWrapper;
//import io.swagger.annotations.ApiOperation;
//import lombok.Data;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.util.CellRangeAddress;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
//@ApiOperation("excel控制表格导出")
////@Slf4j
////@RunWith(SpringRunner.class)
////@SpringBootTest(classes = WebApp.class)
//public class ExcelTest {
//
//    public static void main(String[] args) {
//        OutUser outUser = new OutUser();
//        ArrayList<PerUserPO> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            PerUserPO po = PerUserPO.builder().id(Long.valueOf(i)).name(i + "").build();
//            list.add(po);
//        }
//        outUser.setList(list);
//        outUser.setTotal(String.valueOf(list.size()));
//
//        WriteSheet sheet = EasyExcel.writerSheet(0)
//                .build();
//        FillConfig fillConfig = FillConfig.builder()
////                .direction(WriteDirectionEnum.HORIZONTAL)
//                .autoStyle(true)
//                .forceNewRow(true).build();
//        File outFile = new File(System.currentTimeMillis() + ".xlsx");
//
//        ExcelWriter excelWriter = EasyExcel.write(outFile)
//                .withTemplate("D:\\github\\language\\src\\main\\resources\\template\\out模板.xlsx")
//                .registerWriteHandler(new AbstractMergeStrategy() {
//                    @Override
//                    protected void merge(Sheet sheet, Cell cell, Head head, Integer integer) {
////                        sheet.addMergedRegion(new CellRangeAddress(3, 5, 0, 0));
//                        sheet.addMergedRegionUnsafe(new CellRangeAddress(2, 2 + list.size(), 0, 0));
//                    }
//                })
//                .build();
//        excelWriter.writeContext().writeWorkbookHolder().getWorkbook().setForceFormulaRecalculation(true);
//
//        excelWriter.fill(new FillWrapper("user", list), fillConfig, sheet);
//        excelWriter.fill(outUser, sheet);
//        excelWriter.finish();
//    }
//}
//
//@Data
//class OutUser {
//
//    public List<PerUserPO> list;
//
//    private String total;
//}
//
//
//
