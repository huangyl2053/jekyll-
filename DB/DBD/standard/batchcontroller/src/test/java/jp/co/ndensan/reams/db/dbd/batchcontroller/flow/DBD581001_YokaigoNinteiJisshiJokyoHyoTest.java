/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

//import jp.co.ndensan.reams.uz.uza.auth.manage.mappers._AuthAuthorityDeputyManageMapperTest.テスト.*;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD581001.DBD581001_YokaigoNinteiJisshiJokyoHyoParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestDacBase;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.BatchExitStatus;
import jp.co.ndensan.reams.uz.uza.batch.config.BatchSettings;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchFlowTestHelper;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author n8343
 */
@RunWith(Enclosed.class)
public class DBD581001_YokaigoNinteiJisshiJokyoHyoTest extends DbdTestDacBase {

    private static DbTestHelper dbHelper;
    //private static DBD581001_YokaigoNinteiJisshiJokyoHyoParameter parameter;
    private static BatchExitStatus result;
    private static FlexibleYear 対象年度;
    private static final RString batchID = new RString("DBD581001_YokaigoNinteiJisshiJokyoHyoParameter");
    private static final RString batchName = new RString("要介護認定実施状況表Test");
    private static final RString 月日FROM = new RString("0401");
    private static final RString 月日TO = new RString("0331");
    private static IShikibetsuTaishoPSMSearchKey searchKey;
    private static final RString 要介護認定実施状況表 = new RString("要介護認定実施状況表（その月に申請・認定を受けた受給者の統計）");

    @BeforeClass
    public static void setUpClass() {
        dbHelper = new DbTestHelper();

    }

    public static class 要介護認定実施状況表Test extends DbdTestDacBase {

        @Test
        public void 要介護認定実施状況表test() {
            BatchFlowTestHelper testhelper = new BatchFlowTestHelper();
            BatchSettings bs = new BatchSettings();
            result = testhelper.executeFlow(batchID, batchName, DBD581001_YokaigoNinteiJisshiJokyoHyo.class, 要介護認定実施状況表(), bs);

        }

    }

    @AfterClass
    public static void afterTearDownClass() {

        DbdTestDacBase.tearDownClass();
    }

    private static DBD581001_YokaigoNinteiJisshiJokyoHyoParameter 要介護認定実施状況表() {
        DBD581001_YokaigoNinteiJisshiJokyoHyoParameter parameter = new DBD581001_YokaigoNinteiJisshiJokyoHyoParameter();
        対象年度 = new FlexibleYear("2016");
        parameter.set出力帳票(要介護認定実施状況表);
        parameter.set年齢基準日(new FlexibleDate("20161122"));
        parameter.set年齢From(12);
        parameter.set年齢To(69);
        parameter.set生年月日From(new FlexibleDate(""));
        parameter.set生年月日To(new FlexibleDate(""));
        parameter.set地区区分(new RString("ALL"));
        parameter.set開始地区コード(Code.EMPTY);
        parameter.set終了地区コード(Code.EMPTY);
        parameter.set集計単位(new RString("ZIYU"));
        parameter.set基準日(RString.EMPTY);
        parameter.set対象年度(対象年度);
        return parameter;
    }

}
