/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.dbd5910001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.dbe5910001.IkenshoShujiiIchiranBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.dbe5910001.IkenshoShujiiIchiranHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.dbe5910001.IkenshoShujiiIchiranReportJoho;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * このテストを実行するとgetTestPrintItemに設定した内容を印刷した帳票を出力する。 結果の確認は目視で行う。
 *
 * @author n3420
 */
@RunWith(Enclosed.class)
public class IkenshoShujiiIchiranPrintServiceTest extends DbeTestDacBase {

    public static class printerTest extends DbeTestDacBase {

        @BeforeClass
        public static void test() {
        }

        @Test
        public void testSpool() {
            IkenshoShujiiIchiranPrintService printer = new IkenshoShujiiIchiranPrintService();
            RString iryoKikanCodeFrom = new RString("3333");
            RString iryoKikanCodeTo = new RString("4444");
            RString shujiiCodeFrom = new RString("111111");
            RString shujiiCodeTo = new RString("222222");
            RString shujiiJokyo = new RString("1");
            RString cityCode = new RString("123");
            RString cityName = new RString("市町村名称");
            RString sort1 = new RString("1");
            RString page1 = new RString("1");
            IkenshoShujiiIchiranHeadItem headItem = new IkenshoShujiiIchiranHeadItem(cityCode, cityName, iryoKikanCodeFrom, iryoKikanCodeTo, shujiiCodeFrom, shujiiCodeTo, shujiiJokyo, sort1, page1);
            IkenshoShujiiIchiranReportJoho ichiranReportJoho = new IkenshoShujiiIchiranReportJoho(headItem, getTestPrintItem());
            printer.print(ichiranReportJoho);
        }

        private List<IkenshoShujiiIchiranBodyItem> getTestPrintItem() {
            List<IkenshoShujiiIchiranBodyItem> items = new ArrayList<>();
            for (int i = 0; i < 56; i++) {

                items.add(createIkenshoShujiiIchiranItem(new RString(String.valueOf(i))));
            }
            return items;
        }

        private IkenshoShujiiIchiranBodyItem createIkenshoShujiiIchiranItem(RString i) {
            RString listIchiranhyoUpper_1 = i;
            RString listIchiranhyoUpper_2 = new RString("医療機関名称(ｶﾅ)");
            RString listIchiranhyoUpper_3 = new RString("代表者名(ｶﾅ)");
            RString listIchiranhyoUpper_4 = new RString("999-9999");
            RString listIchiranhyoUpper_5 = new RString("1868888");
            RString listIchiranhyoUpper_6 = new RString("False");
            RString listIchiranhyoUpper_7 = new RString("12131415");
            RString listIchiranhyoUpper_8 = new RString("主治医氏名(ｶﾅ)");
            RString listIchiranhyoUpper_9 = new RString("1");
            RString listIchiranhyoUpper_10 = new RString("True");
            RString listIchiranhyoLower1_1 = new RString("医療機関名称");
            RString listIchiranhyoLower1_2 = new RString("代表者名");
            RString listIchiranhyoLower1_3 = new RString("住所");
            RString listIchiranhyoLower2_1 = new RString("主治医氏名");
            RString listIchiranhyoLower2_2 = new RString("所属名");
            IkenshoShujiiIchiranBodyItem item = new IkenshoShujiiIchiranBodyItem(listIchiranhyoUpper_1, listIchiranhyoUpper_2, listIchiranhyoUpper_3, listIchiranhyoUpper_4, listIchiranhyoUpper_5, listIchiranhyoUpper_6, listIchiranhyoUpper_7, listIchiranhyoUpper_8, listIchiranhyoUpper_9, listIchiranhyoUpper_10, listIchiranhyoLower1_1, listIchiranhyoLower1_2, listIchiranhyoLower1_3, listIchiranhyoLower2_1, listIchiranhyoLower2_2);
            return item;
        }
    }
}
