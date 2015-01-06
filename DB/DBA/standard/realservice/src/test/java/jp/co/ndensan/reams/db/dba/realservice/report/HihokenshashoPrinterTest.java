/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.realservice.report;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dba.realservice.report.HihokenshashoPrinter}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshashoPrinterTest {

    public static class print extends DbaTestBase {

        @Test
        public void DBA業務コンフィグ_被保険者証表示方法_証表示タイプが01の場合_レポートIDはDBA100002となる() {
            //TODO
            //1, 業務コンフィグのMockを作成し、証表示タイプが01を返すように設定する。
            //2, printを実行し、戻り値のSourceDataCollectionを取得する。
            //3, SourceDataCollectionのiteratorから1件目のSourceDataを取得する。
            //4, SourceDataが持つReportIDについて、DBA100002と同一かをチェックする。
        }

        @Test
        public void DBA業務コンフィグ_被保険者証表示方法_証表示タイプが21の場合_レポートIDはDBA100001となる() {
            //TODO
            //1, 業務コンフィグのMockを作成し、証表示タイプが21を返すように設定する。
            //2, printを実行し、戻り値のSourceDataCollectionを取得する。
            //3, SourceDataCollectionのiteratorから1件目のSourceDataを取得する。
            //4, SourceDataが持つReportIDについて、DBA100001と同一かをチェックする。

        }
    }

}
