/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.roreifukushinenkinjukyusha;

import jp.co.ndensan.reams.db.dbu.definition.core.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaMapperParameter;
import jp.co.ndensan.reams.db.dbu.service.core.roreifukushinenkinjukyushajohn.RorenFukushiNenkinJohoKanrishi;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7006RoreiFukushiNenkinJukyushaDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestDacBase;
import jp.co.ndensan.reams.ur.urz.testhelper.helper.CSVDataUtilForUseSession;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dbu.service.core.roreifukushinenkinjukyushajohn.RorenFukushiNenkinJohoKanrishi}のテストです。
 *
 */
@RunWith(Enclosed.class)
public class RorenFukushiNenkinJohoKanriTest extends DbaTestBase {

    private static RorenFukushiNenkinJohoKanrishi service;
    private static DbT7006RoreiFukushiNenkinJukyushaDac dbT7006dac;
    public static final ShikibetsuCode 識別コード = new ShikibetsuCode("123456789000001");
    public static final FlexibleDate 受給開始年月日1 = new FlexibleDate("20010410");
    public static final FlexibleDate 受給終了年月日1 = new FlexibleDate("20011212");
    public static final FlexibleDate 受給開始年月日2 = new FlexibleDate("20010110");
    public static final FlexibleDate 受給終了年月日2 = new FlexibleDate("20010707");
    public static final FlexibleDate 受給開始年月日3 = new FlexibleDate("20010410");
    public static final FlexibleDate 受給終了年月日3 = new FlexibleDate("20010909");
    public static final FlexibleDate 受給開始年月日4 = new FlexibleDate("20050505");
    public static final FlexibleDate 受給終了年月日4 = new FlexibleDate("20050825");
    public static final HihokenshaNo 被保険者番号 = new HihokenshaNo(new RString("12"));

    @BeforeClass
    public static void setUpClass() {
        dbT7006dac = InstanceProvider.create(DbT7006RoreiFukushiNenkinJukyushaDac.class);
        service = InstanceProvider.create(RorenFukushiNenkinJohoKanrishi.class);
    }

    public static class JukyuKikanJufukuCheckTest extends DbaTestDacBase {

        private static void clearTable() {
            CSVDataUtilForUseSession csvDataUtil = new CSVDataUtilForUseSession();
            csvDataUtil.clearTable(sqlSession, "DbT7006RoreiFukushiNenkinJukyusha");
        }

        @Before
        public void setUp() {
            clearTable();
            dbT7006dac = InstanceProvider.create(DbT7006RoreiFukushiNenkinJukyushaDac.class);
        }

        @Test(expected = NullPointerException.class)
        public void 検索パラメータがnullの場合_jukyuKikanJufukuCheckは_NullPointerExceptionを発生させる() {
            service.jukyuKikanJufukuCheck(null);
        }

        @Test
        public void 老齢福祉年金受給者台帳管理重複情報1する場合_jukyuKikanJufukuCheckTestは_trueを返すこと() {
            insert1_DbT7006RoreiFukushiNenkinJukyushaEntity();
            RoreiFukushiNenkinJukyushaMapperParameter param = RoreiFukushiNenkinJukyushaMapperParameter.createRoreiFukushiParam(識別コード, 受給開始年月日1, 被保険者番号, 受給終了年月日1, false);
            Boolean flag = service.jukyuKikanJufukuCheck(param);
            assertEquals(true, flag);
        }

        @Test
        public void 老齢福祉年金受給者台帳管理重複情報2する場合_jukyuKikanJufukuCheckTestは_trueを返すこと() {
            insert2_DbT7006RoreiFukushiNenkinJukyushaEntity();
            RoreiFukushiNenkinJukyushaMapperParameter param = RoreiFukushiNenkinJukyushaMapperParameter.createRoreiFukushiParam(識別コード, 受給開始年月日2, 被保険者番号, 受給終了年月日2, false);
            Boolean flag = service.jukyuKikanJufukuCheck(param);
            assertEquals(true, flag);
        }

        @Test
        public void 老齢福祉年金受給者台帳管理重複情報3する場合_jukyuKikanJufukuCheckTestは_trueを返すこと() {
            insert3_DbT7006RoreiFukushiNenkinJukyushaEntity();
            RoreiFukushiNenkinJukyushaMapperParameter param = RoreiFukushiNenkinJukyushaMapperParameter.createRoreiFukushiParam(識別コード, 受給開始年月日3, 被保険者番号, 受給終了年月日3, false);
            Boolean flag = service.jukyuKikanJufukuCheck(param);
            assertEquals(true, flag);
        }

        @Test
        public void 老齢福祉年金受給者台帳管理情報重複しない場合_jukyuKikanJufukuCheckTestは_falseを返すこと() {
            insert3_DbT7006RoreiFukushiNenkinJukyushaEntity();
            RoreiFukushiNenkinJukyushaMapperParameter param = RoreiFukushiNenkinJukyushaMapperParameter.createRoreiFukushiParam(識別コード, 受給開始年月日4, 被保険者番号, 受給終了年月日4, false);
            Boolean flag = service.jukyuKikanJufukuCheck(param);
            assertEquals(false, flag);
        }
    }

    public static void insert1_DbT7006RoreiFukushiNenkinJukyushaEntity() {
        DbT7006RoreiFukushiNenkinJukyushaEntity dbT7006entity = new DbT7006RoreiFukushiNenkinJukyushaEntity();
        dbT7006entity.setShikibetsuCode(new ShikibetsuCode(new RString(("123456789000001"))));
        dbT7006entity.setJukyuKaishiYMD(new FlexibleDate(new RString(("20010101"))));
        dbT7006entity.setJukyuShuryoYMD(new FlexibleDate(new RString(("20010606"))));
        dbT7006entity.setHihokenshaNo(new HihokenshaNo(new RString(("12"))));
        dbT7006entity.setIsDeleted(false);
        dbT7006dac.save(dbT7006entity);
    }

    public static void insert2_DbT7006RoreiFukushiNenkinJukyushaEntity() {
        DbT7006RoreiFukushiNenkinJukyushaEntity dbT7006entity = new DbT7006RoreiFukushiNenkinJukyushaEntity();
        dbT7006entity.setShikibetsuCode(new ShikibetsuCode(new RString(("123456789000001"))));
        dbT7006entity.setJukyuKaishiYMD(new FlexibleDate(new RString(("20010505"))));
        dbT7006entity.setJukyuShuryoYMD(new FlexibleDate(new RString(("20010808"))));
        dbT7006entity.setHihokenshaNo(new HihokenshaNo(new RString(("12"))));
        dbT7006entity.setIsDeleted(false);
        dbT7006dac.save(dbT7006entity);
    }

    public static void insert3_DbT7006RoreiFukushiNenkinJukyushaEntity() {
        DbT7006RoreiFukushiNenkinJukyushaEntity dbT7006entity = new DbT7006RoreiFukushiNenkinJukyushaEntity();
        dbT7006entity.setShikibetsuCode(new ShikibetsuCode(new RString(("123456789000001"))));
        dbT7006entity.setJukyuKaishiYMD(new FlexibleDate(new RString(("20010101"))));
        dbT7006entity.setJukyuShuryoYMD(new FlexibleDate(new RString(("20011212"))));
        dbT7006entity.setHihokenshaNo(new HihokenshaNo(new RString(("12"))));
        dbT7006entity.setIsDeleted(false);
        dbT7006dac.save(dbT7006entity);
    }

    public static void insert4_DbT7006RoreiFukushiNenkinJukyushaEntity() {
        DbT7006RoreiFukushiNenkinJukyushaEntity dbT7006entity = new DbT7006RoreiFukushiNenkinJukyushaEntity();
        dbT7006entity.setShikibetsuCode(new ShikibetsuCode(new RString(("123456789000001"))));
        dbT7006entity.setJukyuKaishiYMD(new FlexibleDate(new RString(("20050202"))));
        dbT7006entity.setJukyuShuryoYMD(new FlexibleDate(new RString(("20050410"))));
        dbT7006entity.setHihokenshaNo(new HihokenshaNo(new RString(("12"))));
        dbT7006entity.setIsDeleted(false);
        dbT7006dac.save(dbT7006entity);
    }
}
