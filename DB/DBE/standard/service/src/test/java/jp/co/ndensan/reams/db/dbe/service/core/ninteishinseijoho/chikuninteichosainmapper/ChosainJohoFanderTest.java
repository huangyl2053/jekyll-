/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.chikuninteichosainmapper;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChikuNinteiChosain;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChikuNinteiKoseiShichoson;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.ChikuNinteiNinteichosa;
import jp.co.ndensan.reams.db.dbe.business.core.chikuninteichosain.NinteichosaSchedule;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.chikuninteichosain.ChosainJohoParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5222NinteiChosaScheduleMemoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5910NinteichosaItakusakiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5913ChosainJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5910NinteichosaItakusakiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5913ChosainJohoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5222NinteiChosaScheduleMemoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5223ChikuNinteiChosainEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5221NinteichosaScheduleDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5222NinteiChosaScheduleMemoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5223ChikuNinteiChosainDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import jp.co.ndensan.reams.ur.urz.testhelper.helper.CSVDataUtilForUseSession;

/**
 * {link ChosainJohoFander}のテストクラスです。
 */
@RunWith(Enclosed.class)
//@Ignore
public class ChosainJohoFanderTest {

    private static ChosainJohoFander sut;
    private static DbT5221NinteichosaScheduleDac dbT5221dac;
    private static DbT5222NinteiChosaScheduleMemoDac dbT5222dac;
    private static DbT5223ChikuNinteiChosainDac dbT5223dac;
    private static DbT5910NinteichosaItakusakiJohoDac dbT5910dac;
    private static DbT5913ChosainJohoDac dbT5913dac;
    private static DbT7051KoseiShichosonMasterDac dbT7051dac;

    public static final FlexibleDate 認定調査予定年月日1 = new FlexibleDate("20141030");
    public static final RString 認定調査予定開始時間1 = new RString("1211");
    public static final RString 認定調査予定終了時間1 = new RString("1211");
    public static final Code 認定調査時間枠1 = new Code("01");
    public static final Code 調査地区コード1 = new Code("01");
    public static final RString 認定調査委託先コード1 = new RString("000001");
    public static final RString 認定調査員コード1 = new RString("000001");
    public static final LasdecCode 市町村コード1 = new LasdecCode("202010");
    public static final FlexibleDate 認定調査予定年月日2 = new FlexibleDate("20141031");
    public static final RString 認定調査予定開始時間2 = new RString("1210");
    public static final RString 認定調査予定終了時間2 = new RString("1211");
    public static final Code 認定調査時間枠2 = new Code("02");
    public static final Code 調査地区コード2 = new Code("02");
    public static final RString 認定調査委託先コード2 = new RString("000002");
    public static final RString 認定調査員コード2 = new RString("000002");
    public static final LasdecCode 市町村コード2 = new LasdecCode("202011");

    public static final FlexibleDate メモ年月日 = new FlexibleDate("20150402");
    public static final Code 調査地区コード = new Code("3");
    public static final Code メモ区分 = new Code("3");
    public static final int 連番 = 3;

    public static final RString 市町村識別ID1 = new RString("05");
    public static final RString 市町村識別ID2 = new RString("06");

    @BeforeClass
    public static void setUpClass() {
        sut = new ChosainJohoFander();
        dbT5221dac = new DbT5221NinteichosaScheduleDac();
        dbT5222dac = new DbT5222NinteiChosaScheduleMemoDac();
        dbT5223dac = new DbT5223ChikuNinteiChosainDac();
        dbT5910dac = new DbT5910NinteichosaItakusakiJohoDac();
        dbT5913dac = new DbT5913ChosainJohoDac();
        dbT7051dac = new DbT7051KoseiShichosonMasterDac();
        dbT5910dac = new DbT5910NinteichosaItakusakiJohoDac();
    }

    public static class get認定調査スケジュール詳細情報1のテスト extends DbaTestDacBase {

        @Before
        public void setUp() {
            dbT5221dac = InstanceProvider.create(DbT5221NinteichosaScheduleDac.class);
            dbT5223dac = InstanceProvider.create(DbT5223ChikuNinteiChosainDac.class);
            dbT5913dac = InstanceProvider.create(DbT5913ChosainJohoDac.class);
        }

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get認定調査スケジュール詳細情報1(null);
        }

        @Test
        public void テーブルにレコードが存在しない場合_認定調査スケジュール取得処理は_NULLを返すこと() {
            ChosainJohoParameter parameter = ChosainJohoParameter.createSelectByKeyParam(new FlexibleDate("20141030"), true, new Code("01"), new LasdecCode("202010"), new RString("000002"));
            List<ChikuNinteiChosain> ChikuNinteiChosainList = sut.get認定調査スケジュール詳細情報1(parameter);
            assertThat(ChikuNinteiChosainList.size(), is(0));
        }

        @Test
        public void テーブルにレコードが存在する場合_認定調査スケジュール取得処理は_1件を返すこと() {
            insert_DbT5221NinteichosaSchedule(認定調査予定年月日1,
                    認定調査予定開始時間1,
                    認定調査予定終了時間1,
                    認定調査時間枠1,
                    調査地区コード1,
                    認定調査委託先コード1,
                    認定調査員コード1,
                    市町村コード1);
            insert_DbT5223ChikuNinteiChosain(調査地区コード1,
                    認定調査委託先コード1,
                    認定調査員コード1,
                    市町村コード1);
            insert_DbT5913ChosainJoho(市町村コード1,
                    認定調査委託先コード1,
                    認定調査員コード1);
            ChosainJohoParameter parameter = ChosainJohoParameter.createSelectByKeyParam(new FlexibleDate("20141030"), true, new Code("01"), new LasdecCode("202010"), new RString("000001"));
            List<ChikuNinteiChosain> ChikuNinteiChosainList = sut.get認定調査スケジュール詳細情報1(parameter);
            assertThat(ChikuNinteiChosainList.size(), is(1));
        }

        @Test
        public void テーブルにレコードが存在する場合_認定調査スケジュール取得処理は_2件を返すこと() {
            insert_DbT5221NinteichosaSchedule(認定調査予定年月日1,
                    認定調査予定開始時間1,
                    認定調査予定終了時間1,
                    認定調査時間枠1,
                    調査地区コード1,
                    認定調査委託先コード1,
                    認定調査員コード1,
                    市町村コード1);
            insert_DbT5223ChikuNinteiChosain(調査地区コード1,
                    認定調査委託先コード1,
                    認定調査員コード1,
                    市町村コード1);
            insert_DbT5913ChosainJoho(市町村コード1,
                    認定調査委託先コード1,
                    認定調査員コード1);
            insert_DbT5221NinteichosaSchedule(認定調査予定年月日2,
                    認定調査予定開始時間2,
                    認定調査予定終了時間2,
                    認定調査時間枠2,
                    調査地区コード2,
                    認定調査委託先コード1,
                    認定調査員コード1,
                    市町村コード1);
            insert_DbT5223ChikuNinteiChosain(調査地区コード1,
                    認定調査委託先コード1,
                    認定調査員コード2,
                    市町村コード1);
            insert_DbT5913ChosainJoho(市町村コード2,
                    認定調査委託先コード2,
                    認定調査員コード2);
            ChosainJohoParameter parameter = ChosainJohoParameter.createSelectByKeyParam(new FlexibleDate("20141030"), true, new Code("01"), new LasdecCode("202010"), new RString("000001"));
            List<ChikuNinteiChosain> hokenjaNoList = sut.get認定調査スケジュール詳細情報1(parameter);
            assertThat(hokenjaNoList.size(), is(2));
        }
    }

    public static class get保険者のテスト extends DbaTestDacBase {

        @Before
        public void setUp() {
            dbT5223dac = InstanceProvider.create(DbT5223ChikuNinteiChosainDac.class);
            dbT5910dac = InstanceProvider.create(DbT5910NinteichosaItakusakiJohoDac.class);
        }

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get保険者(null);
        }

        @Test
        public void テーブルにレコードが存在しない場合_保険者取得処理は_NULLを返すこと() {

            ChosainJohoParameter parameter = ChosainJohoParameter.createSelectByKeyParam(調査地区コード1, 市町村コード1);
            List<ChikuNinteiNinteichosa> chikuninteininteichosa = sut.get保険者(parameter);
            assertThat(chikuninteininteichosa.size(), is(0));
        }

        @Test
        public void テーブルにレコードが存在する場合_保険者取得処理は_1件を返すこと() {
            insert_DbT5223ChikuNinteiChosain(調査地区コード1,
                    認定調査委託先コード1,
                    認定調査員コード1,
                    市町村コード1);
            insert_DbT5910NinteichosaItakusakiJoho(市町村コード1, 認定調査委託先コード1);
            ChosainJohoParameter parameter = ChosainJohoParameter.createSelectByKeyParam(調査地区コード1, 市町村コード1);
            List<ChikuNinteiNinteichosa> chikuninteininteichosa = sut.get保険者(parameter);
            assertThat(chikuninteininteichosa.size(), is(1));
        }

        @Test
        public void テーブルにレコードが存在する場合_保険者取得処理は_2件を返すこと() {
            insert_DbT5223ChikuNinteiChosain(調査地区コード1,
                    認定調査委託先コード1,
                    認定調査員コード1,
                    市町村コード1);
            insert_DbT5910NinteichosaItakusakiJoho(市町村コード1, 認定調査委託先コード1);
            insert_DbT5223ChikuNinteiChosain(調査地区コード1,
                    認定調査委託先コード2,
                    認定調査員コード1,
                    市町村コード1);
            insert_DbT5910NinteichosaItakusakiJoho(市町村コード1, 認定調査委託先コード2);
            ChosainJohoParameter parameter = ChosainJohoParameter.createSelectByKeyParam(調査地区コード1, 市町村コード1);
            List<ChikuNinteiNinteichosa> chikuninteininteichosa = sut.get保険者(parameter);
            assertThat(chikuninteininteichosa.size(), is(2));
        }
    }

    public static class get対象地区のテスト extends DbaTestDacBase {

        private static void clearTable() {
            CSVDataUtilForUseSession csvDataUtil = new CSVDataUtilForUseSession();
            csvDataUtil.clearTable(sqlSession, "DbT5223ChikuNinteiChosain");
            csvDataUtil.clearTable(sqlSession, "DbT7051KoseiShichosonMaster");
        }

        @Before
        public void setUp() {
            clearTable();
            dbT5223dac = InstanceProvider.create(DbT5223ChikuNinteiChosainDac.class);
            dbT7051dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        }

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get対象地区(null);
        }

        @Test
        public void テーブルにレコードが存在しない場合_対象地区取得処理は_NULLを返すこと() {
            ChosainJohoParameter parameter = ChosainJohoParameter.createSelectByKeyParam1(Code.EMPTY);
            List<ChikuNinteiKoseiShichoson> chikuninteininteichosa = sut.get対象地区(parameter);
            assertThat(chikuninteininteichosa.size(), is(0));
        }

        @Test
        public void テーブルにレコードが存在する場合_対象地区取得処理は_1件を返すこと() {
            insert_DbT5223ChikuNinteiChosain(調査地区コード1,
                    認定調査委託先コード1,
                    認定調査員コード1,
                    市町村コード1);
            insert_DbT7051KoseiShichosonMaster(市町村識別ID1, 市町村コード1);
            ChosainJohoParameter parameter = ChosainJohoParameter.createSelectByKeyParam1(調査地区コード1);
            List<ChikuNinteiKoseiShichoson> chikuninteininteichosa = sut.get対象地区(parameter);
            assertThat(chikuninteininteichosa.size(), is(1));
        }

        @Test
        public void テーブルにレコードが存在する場合_対象地区取得処理は_2件を返すこと() {
            insert_DbT5223ChikuNinteiChosain(調査地区コード1,
                    認定調査委託先コード1,
                    認定調査員コード1,
                    市町村コード1);
            insert_DbT7051KoseiShichosonMaster(市町村識別ID1, 市町村コード1);
            insert_DbT5223ChikuNinteiChosain(調査地区コード1,
                    認定調査委託先コード2,
                    認定調査員コード2,
                    市町村コード2);
            insert_DbT7051KoseiShichosonMaster(市町村識別ID2, 市町村コード2);
            ChosainJohoParameter parameter = ChosainJohoParameter.createSelectByKeyParam1(調査地区コード1);
            List<ChikuNinteiKoseiShichoson> chikuninteininteichosa = sut.get対象地区(parameter);
            assertThat(chikuninteininteichosa.size(), is(2));
        }
    }

    public static class get申請書管理番号のテスト extends DbaTestDacBase {

        @Before
        public void setUp() {
            dbT5221dac = InstanceProvider.create(DbT5221NinteichosaScheduleDac.class);
        }

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get申請書管理番号(null);
        }

        @Test
        public void テーブルにレコードが存在しない場合_対象地区取得処理は_NULLを返すこと() {
            ChosainJohoParameter parameter = ChosainJohoParameter.createSelectByKeyParam(認定調査時間枠1, 市町村コード1, 認定調査予定開始時間1, 認定調査予定開始時間1, 認定調査予定年月日1, 認定調査予定開始時間1, 認定調査予定開始時間1, 認定調査時間枠1);
            NinteichosaSchedule ninteichosaschedule = sut.get申請書管理番号(parameter);
            assertThat(ninteichosaschedule, is(nullValue()));
        }

        @Test
        public void テーブルにレコードが存在する場合_対象地区取得処理は_1件を返すこと() {
            insert_DbT5221NinteichosaSchedule(認定調査予定年月日1,
                    認定調査予定開始時間1,
                    認定調査予定終了時間1,
                    認定調査時間枠1,
                    調査地区コード1,
                    認定調査委託先コード1,
                    認定調査員コード1,
                    市町村コード1
            );
            ChosainJohoParameter parameter = ChosainJohoParameter.createSelectByKeyParam(認定調査時間枠1, 市町村コード1, 認定調査予定開始時間1, 認定調査予定開始時間1, 認定調査予定年月日1, 認定調査予定開始時間1, 認定調査予定開始時間1, 認定調査時間枠1);
            NinteichosaSchedule chikuninteininteichosa = sut.get申請書管理番号(parameter);
            assertThat(chikuninteininteichosa.getTemp_申請書管理番号2(), is(new ShinseishoKanriNo(new RString("900001"))));
        }

    }

    public static void insert_DbT5221NinteichosaSchedule(
            FlexibleDate 認定調査予定年月日,
            RString 認定調査予定開始時間,
            RString 認定調査予定終了時間,
            Code 認定調査時間枠,
            Code 調査地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            LasdecCode 市町村コード) {
        DbT5221NinteichosaScheduleEntity entity = new DbT5221NinteichosaScheduleEntity();
        entity.setNinteiChosaYoteiYMD(認定調査予定年月日);
        entity.setNinteiChosaYoteiKaishiTime(認定調査予定開始時間);
        entity.setNinteiChosaYoteiShuryoTime(認定調査予定終了時間);
        entity.setNinteiChosaJikanWaku(認定調査時間枠);
        entity.setChosaChikuCode(調査地区コード);
        entity.setNinteiChosaItakusakiCode(認定調査委託先コード);
        entity.setNinteiChosainCode(認定調査員コード);
        entity.setShichosonCode(市町村コード);
        entity.setShinseishoKanriNo(new ShinseishoKanriNo("900001"));
        entity.setYoyakuJokyo(new Code("01"));
        entity.setYoyakuKaoFlag(false);
        entity.setBiko(new RString("名称"));
        entity.setBasho(new RString("名称"));
        entity.setChushajo(new RString("名称"));
        entity.setTachiainin1(new RString("名称"));
        entity.setRenrakusaki1(new TelNo("0123456789"));
        entity.setTachiainin2(new RString("名称"));
        entity.setRenrakusaki2(new TelNo("0123456789"));
        entity.setTaishoshaMemo(new RString("名称"));
        dbT5221dac.save(entity);
    }

    public static void insert_DbT5223ChikuNinteiChosain(
            Code 調査地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            LasdecCode 市町村コード) {
        DbT5223ChikuNinteiChosainEntity entity = new DbT5223ChikuNinteiChosainEntity();
        entity.setChosaChikuCode(調査地区コード);
        entity.setNinteiChosaItakusakiCode(認定調査委託先コード);
        entity.setNinteiChosainCode(認定調査員コード);
        entity.setShichosonCode(市町村コード);
        entity.setYusenNo(1);
        entity.setBiko(new RString("名称"));
        dbT5223dac.save(entity);
    }

    public static void insert_DbT5913ChosainJoho(LasdecCode 市町村コード, RString 認定調査委託先コード, RString 認定調査員コード) {
        DbT5913ChosainJohoEntity entity = DbT5913ChosainJohoEntityGenerator.createDbT5913ChosainJohoEntity();
        entity.setShichosonCode(市町村コード);
        entity.setNinteichosaItakusakiCode(認定調査委託先コード);
        entity.setNinteiChosainNo(認定調査員コード);
        dbT5913dac.save(entity);
    }

    public static void insert_DbT7051KoseiShichosonMaster(RString 市町村識別ID, LasdecCode 市町村コード) {
        DbT7051KoseiShichosonMasterEntity entity = new DbT7051KoseiShichosonMasterEntity();
        entity.setShichosonShokibetsuID(市町村識別ID);
        entity.setShichosonCode(市町村コード);
        entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo("203456"));
        entity.setKokuhorenKoikiShichosonNo(new RString("010"));
        entity.setShichosonMeisho(new RString("あいうえおか"));
        entity.setTodofukenMeisho(new RString("1234"));
        entity.setGunMeisho(new RString("あいうえ"));
        entity.setYubinNo(new YubinNo("111-1111"));
        entity.setJusho(new AtenaJusho("テスト住所"));
        entity.setTelNo(new TelNo("111-222-3344"));
        entity.setYusenChikuCode(new RString("1"));
        entity.setTyohyoTodoufukenHyojiUmu(new RString("1"));
        entity.setTyohyoGunHyojiUmu(new RString("1"));
        entity.setTyohyoShichosonHyojiUmu(new RString("1"));
        entity.setTyohyoJushoHenshuHouhou(new RString("1"));
        entity.setTyohyoKatagakiHyojiUmu(new RString("1"));
        entity.setGaikokujinHyojiHouhou(new RString("1"));
        entity.setRojinhokenShichosonNo(new RString("あいうえ"));
        entity.setRokenJukyushaNoTaikei(new RString("1"));
        entity.setTokuchoBunpaishuyaku(new RString("1"));
        entity.setIkoYMD(new FlexibleDate("20141216"));
        entity.setKanyuYMD(new FlexibleDate("20141216"));
        entity.setRidatsuYMD(new FlexibleDate("20141216"));
        entity.setGappeiKyuShichosonKubun(new RString("1"));
        entity.setGappeiKyuShichosonHyojiUmu(new RString("1"));
        entity.setGappeiChiikiNo(new RString("01"));
        entity.setUnyoHokenshaNo(new ShoKisaiHokenshaNo("203456"));
        entity.setUnyoKaishiYMD(new FlexibleDate("20141216"));
        entity.setUnyoShuryoYMD(new FlexibleDate("20141216"));
        entity.setUnyoKeitaiKubun(new RString("1"));
        dbT7051dac.save(entity);
    }

    public static void insert_DbT5910NinteichosaItakusakiJoho(LasdecCode 市町村コード, RString 認定調査委託先コード) {
        DbT5910NinteichosaItakusakiJohoEntity entity = DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity();
        entity.setShichosonCode(市町村コード);
        entity.setNinteichosaItakusakiCode(認定調査委託先コード);
        dbT5910dac.save(entity);
    }

    public static void insert_DbT5222NinteiChosaScheduleMemo(FlexibleDate メモ年月日, Code 調査地区コード, Code メモ区分, int 連番) {
        DbT5222NinteiChosaScheduleMemoEntity entity = DbT5222NinteiChosaScheduleMemoEntityGenerator.createDbT5222NinteiChosaScheduleMemoEntity();
        entity.setMemoYMD(メモ年月日);
        entity.setChosachikucode(調査地区コード);
        entity.setMemoKubun(メモ区分);
        entity.setRemban(連番);
        dbT5222dac.save(entity);
    }
}
