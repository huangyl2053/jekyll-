/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.report;

import java.util.Iterator;
import jp.co.ndensan.reams.db.dbz.business.config.shikaku.HihokenshashoPrintConfig;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoPrintPosition;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.HihokenshashoPrintType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshaShikakuHakkoModel;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceData;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

/**
 * {@link jp.co.ndensan.reams.db.dbz.realservice.report.HihokenshashoPrinter}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshashoPrinterTest {

    private static HihokenshashoPrinter sut;

    private static HihokenshashoPrintConfig printConfig;
    private static HihokenshashoA4Printer a4Printer;
    private static HihokenshashoB4Printer b4Printer;

    private static final RString REPORT_ID_B4 = new RString("DBA100001");
    private static final RString REPORT_ID_A4 = new RString("DBA100002");

    public static class print extends DbzTestBase {

        private HihokenshaNo hihoNo;
        private HihokenshaShikakuHakkoModel shikakuHakko;
        private HihokenshashoPrintPosition position;

        @Before
        public void setUp() {
            a4Printer = createA4Printer();
            b4Printer = createB4Printer();

            hihoNo = new HihokenshaNo("0123456789");
            shikakuHakko = mock(HihokenshaShikakuHakkoModel.class);
            position = HihokenshashoPrintPosition.上部;
        }

        @Test
        public void 被保険者証表示方法の証表示タイプがA4横の場合_戻り値の帳票IDにREPORT_ID_A4の値が設定されている() {
            printConfig = createPrintConfig(HihokenshashoPrintType.A4横);
            sut = new HihokenshashoPrinter(printConfig, a4Printer, b4Printer);

            SourceData result = sut.print(hihoNo, shikakuHakko, position).iterator().next();

            assertThat(result.getReportId(), is(REPORT_ID_A4));
        }

        @Test
        public void 被保険者証表示方法の証表示タイプがB4横の場合_戻り値の帳票IDにREPORT_ID_B4の値が設定されている() {
            printConfig = createPrintConfig(HihokenshashoPrintType.B4横);
            sut = new HihokenshashoPrinter(printConfig, a4Printer, b4Printer);

            SourceData result = sut.print(hihoNo, shikakuHakko, position).iterator().next();

            assertThat(result.getReportId(), is(REPORT_ID_B4));
        }

        private HihokenshashoA4Printer createA4Printer() {
            SourceData source = mock(SourceData.class);
            when(source.getReportId()).thenReturn(REPORT_ID_A4);
            Iterator iterator = mock(Iterator.class);
            when(iterator.next()).thenReturn(source);
            SourceDataCollection collection = mock(SourceDataCollection.class);
            when(collection.iterator()).thenReturn(iterator);
            HihokenshashoA4Printer printer = mock(HihokenshashoA4Printer.class);
//            when(printer.print(any(HihokenshaNo.class), any(HihokenshaShikakuHakkoModel.class), any(HihokenshashoPrintPosition.class))).thenReturn(collection);
            return printer;
        }

        private HihokenshashoB4Printer createB4Printer() {
            SourceData source = mock(SourceData.class);
            when(source.getReportId()).thenReturn(REPORT_ID_B4);
            Iterator iterator = mock(Iterator.class);
            when(iterator.next()).thenReturn(source);
            SourceDataCollection collection = mock(SourceDataCollection.class);
            when(collection.iterator()).thenReturn(iterator);
            HihokenshashoB4Printer printer = mock(HihokenshashoB4Printer.class);
            when(printer.print(any(HihokenshaNo.class), any(HihokenshaShikakuHakkoModel.class), any(HihokenshashoPrintPosition.class))).thenReturn(collection);
            return printer;
        }

        private HihokenshashoPrintConfig createPrintConfig(HihokenshashoPrintType type) {
            HihokenshashoPrintConfig config = mock(HihokenshashoPrintConfig.class);
            when(config.get証表示タイプ()).thenReturn(type);
            return config;
        }
    }

}
