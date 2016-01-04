/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.gappeijoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.gappeijohokanri.GappeiJohoKanriConfig;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.koseishichoson.GappeiKyuShichosonKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7051KoseiShichosonMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7055GappeiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7056GappeiShichosonEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho.KyuShichosonJohoEntities;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7055GappeiJohoDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7056GappeiShichosonDac;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * {link KyuShichosonCodeFinder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyuShichosonCodeFinderTest extends DbxTestBase {

    private static KyuShichosonCodeFinder sut;
    private static KoseiShichosonJohoFinder koseiShichosonJohoFinder;
    private static DbT7055GappeiJohoDac dbT7055GappeiJohoDac;
    private static DbT7056GappeiShichosonDac dbT7056GappeiShichosonDac;

    public KyuShichosonCodeFinderTest() {
    }

    @RunWith(PowerMockRunner.class)
    @PrepareForTest({KyuShichosonCodeFinder.class})
    public static class createInstace extends DbxTestDacBase {

        @Before
        public void setUp() throws Exception {
            GappeiJohoKanriConfig config = mock(GappeiJohoKanriConfig.class);
            when(config.has合併()).thenReturn(false);
            PowerMockito.whenNew(GappeiJohoKanriConfig.class)
                    .withNoArguments().thenReturn(config);
        }

        @Test
        public void createInstaceにより_インスタンスが生成される() {
            assertThat(KyuShichosonCodeFinder.createInstance(), isA(KyuShichosonCodeFinder.class));
        }
    }

    public static class 単一市町村_合併あり extends DbxTestBase {

        @BeforeClass
        public static void setUpClass() {
            koseiShichosonJohoFinder = Mockito.mock(KoseiShichosonJohoFinder.class);
            dbT7055GappeiJohoDac = Mockito.mock(DbT7055GappeiJohoDac.class);
            dbT7056GappeiShichosonDac = Mockito.mock(DbT7056GappeiShichosonDac.class);
        }

        private final LasdecCode lasdecCode = new LasdecCode("152201");
        private List<DbT7056GappeiShichosonEntity> dbT7056GappeiShichosonEntitys;
        private DbT7055GappeiJohoEntity gappeiJohoOfMaxChikiNo;

        @Before
        public void setUp() {
            gappeiJohoOfMaxChikiNo = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            gappeiJohoOfMaxChikiNo.setShichosonCode(lasdecCode);
            when(dbT7055GappeiJohoDac.selectTopOneByShichosonCode(lasdecCode)).thenReturn(gappeiJohoOfMaxChikiNo);

            dbT7056GappeiShichosonEntitys = new ArrayList<>();
            when(dbT7056GappeiShichosonDac.selectAllOrderbyChikiNoDesc()).thenReturn(dbT7056GappeiShichosonEntitys);

            sut = KyuShichosonCodeFinder.createInstanceForTest(
                    koseiShichosonJohoFinder, dbT7055GappeiJohoDac, dbT7056GappeiShichosonDac, true);
        }

        @Test
        public void 合併市町村情報が取得できない場合_結果は_旧市町村情報が空で合併市町村を含むとなる() {
            gappeiJohoOfMaxChikiNo.setChiikiNo(new RString("10"));

            KyuShichosonJohoEntities result = sut.getKyuShichosonCodeJoho(lasdecCode, DonyuKeitaiCode.事務単一);
            assertThat(result.isEmpty(), is(true));
            assertThat(result.contains合併市町村(), is(true));
        }

        @Test
        public void 過去に合併が1度のみの場合_結果は_すべての旧市町村情報を保持する() {
            final RString maxChikiNo = new RString("11");
            gappeiJohoOfMaxChikiNo.setChiikiNo(maxChikiNo);

            dbT7056GappeiShichosonEntitys.add(createDbT7056GappeiShichosonEntity(new LasdecCode("152199"), maxChikiNo));
            dbT7056GappeiShichosonEntitys.add(createDbT7056GappeiShichosonEntity(new LasdecCode("152200"), maxChikiNo));

            KyuShichosonJohoEntities result = sut.getKyuShichosonCodeJoho(lasdecCode, DonyuKeitaiCode.事務単一);
            assertThat(result.size(), is(2));
            assertThat(result.contains合併市町村(), is(true));
        }

        @Test
        public void 合併が2回以上ある場合_結果は_過去の合併により生じた市町村を除いた_旧市町村情報を保持する() {
            final RString maxChikiNo = new RString("12");
            gappeiJohoOfMaxChikiNo.setChiikiNo(maxChikiNo);

            final List<DbT7055GappeiJohoEntity> havingSmallerChikiNoThenMax = new ArrayList<>();
            when(dbT7055GappeiJohoDac.selectByLtChiikiNo(maxChikiNo)).thenReturn(havingSmallerChikiNoThenMax);
            final RString chiki1No = new RString("11");
            final LasdecCode lasdecCodeChiki1 = new LasdecCode("152200");
            havingSmallerChikiNoThenMax.add(createDbT7055GappeiJohoEntity(lasdecCodeChiki1, chiki1No));

            dbT7056GappeiShichosonEntitys.add(createDbT7056GappeiShichosonEntity(new LasdecCode("152198"), chiki1No));
            dbT7056GappeiShichosonEntitys.add(createDbT7056GappeiShichosonEntity(new LasdecCode("152199"), chiki1No));
            dbT7056GappeiShichosonEntitys.add(createDbT7056GappeiShichosonEntity(lasdecCodeChiki1, maxChikiNo));
            dbT7056GappeiShichosonEntitys.add(createDbT7056GappeiShichosonEntity(new LasdecCode("152197"), maxChikiNo));

            KyuShichosonJohoEntities result = sut.getKyuShichosonCodeJoho(lasdecCode, DonyuKeitaiCode.事務単一);
            assertThat(result.size(), is(3));
            assertThat(result.contains合併市町村(), is(true));
        }
    }

    private static DbT7056GappeiShichosonEntity createDbT7056GappeiShichosonEntity(LasdecCode 市町村コード, RString 合併地域番号) {
        DbT7056GappeiShichosonEntity entity = DbT7056GappeiShichosonEntityGenerator.createDbT7056GappeiShichosonEntity();
        entity.setKyuShichosonCode(市町村コード);
        entity.setChiikiNo(合併地域番号);
        return entity;
    }

    private static DbT7055GappeiJohoEntity createDbT7055GappeiJohoEntity(LasdecCode 市町村コード, RString 合併地域番号) {
        DbT7055GappeiJohoEntity entity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
        entity.setChiikiNo(合併地域番号);
        entity.setShichosonCode(市町村コード);
        return entity;
    }

    public static class 単一市町村_合併なし extends DbxTestBase {

        @BeforeClass
        public static void setUpClass() {
            koseiShichosonJohoFinder = Mockito.mock(KoseiShichosonJohoFinder.class);
            dbT7055GappeiJohoDac = Mockito.mock(DbT7055GappeiJohoDac.class);
            dbT7056GappeiShichosonDac = Mockito.mock(DbT7056GappeiShichosonDac.class);

        }

        @Test
        public void 合併していない場合_結果は空になる() {
            sut = KyuShichosonCodeFinder.createInstanceForTest(
                    koseiShichosonJohoFinder, dbT7055GappeiJohoDac, dbT7056GappeiShichosonDac, false);

            KyuShichosonJohoEntities result = sut.getKyuShichosonCodeJoho(new LasdecCode("152201"), DonyuKeitaiCode.事務単一);
            assertThat(result.isEmpty(), is(true));
            assertThat(result.contains合併市町村(), is(false));
        }
    }

    public static class 広域_合併あり extends DbxTestBase {

        @BeforeClass
        public static void setUpClass() {
            koseiShichosonJohoFinder = Mockito.mock(KoseiShichosonJohoFinder.class);
            dbT7055GappeiJohoDac = Mockito.mock(DbT7055GappeiJohoDac.class);
            dbT7056GappeiShichosonDac = Mockito.mock(DbT7056GappeiShichosonDac.class);
        }

        private final LasdecCode lasdecCode = new LasdecCode("152201");
        private DbT7055GappeiJohoEntity gappeiJohoOfMaxChikiNo;

        @Before
        public void setUp() {
            gappeiJohoOfMaxChikiNo = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            gappeiJohoOfMaxChikiNo.setShichosonCode(lasdecCode);
            when(dbT7055GappeiJohoDac.selectTopOneByShichosonCode(lasdecCode)).thenReturn(gappeiJohoOfMaxChikiNo);

            sut = KyuShichosonCodeFinder.createInstanceForTest(
                    koseiShichosonJohoFinder, dbT7055GappeiJohoDac, dbT7056GappeiShichosonDac, true);
        }

        @Test
        public void 合併市町村情報が取得できない場合_結果は_旧市町村情報が空で合併市町村を含むとなる() {
            gappeiJohoOfMaxChikiNo.setChiikiNo(new RString("10"));

            KyuShichosonJohoEntities result = sut.getKyuShichosonCodeJoho(lasdecCode, DonyuKeitaiCode.事務広域);
            assertThat(result.isEmpty(), is(true));
            assertThat(result.contains合併市町村(), is(true));
        }

        @Test
        public void 広域運用時_過去に合併が1度のみの場合_結果は_すべての旧市町村情報を保持する() {
            final RString maxChikiNo = new RString("11");
            gappeiJohoOfMaxChikiNo.setChiikiNo(maxChikiNo);
            final List<KoseiShichosonMaster> koseiShichosons = new ArrayList<>();
            when(koseiShichosonJohoFinder.get合併旧市町村sBy地域番号(gappeiJohoOfMaxChikiNo.getChiikiNo()))
                    .thenReturn(koseiShichosons);
            koseiShichosons.add(createKoseiShichosonMasterOfKyuShichoson(new LasdecCode("152199"), maxChikiNo));
            koseiShichosons.add(createKoseiShichosonMasterOfKyuShichoson(new LasdecCode("152200"), maxChikiNo));

            KyuShichosonJohoEntities result = sut.getKyuShichosonCodeJoho(lasdecCode, DonyuKeitaiCode.事務広域);
            assertThat(result.size(), is(2));
            assertThat(result.contains合併市町村(), is(true));
        }

        @Test
        public void 広域運用時_同じ市町村を含む合併が2回以上ある場合_結果は_合併により生じた市町村を除いた_旧市町村情報を保持する() {
            final RString maxChikiNo = new RString("12");
            gappeiJohoOfMaxChikiNo.setChiikiNo(new RString("12"));
            final List<KoseiShichosonMaster> koseiShichosons = new ArrayList<>();
            when(koseiShichosonJohoFinder.get合併旧市町村sBy地域番号(gappeiJohoOfMaxChikiNo.getChiikiNo()))
                    .thenReturn(koseiShichosons);

            final List<DbT7055GappeiJohoEntity> havingSmallerChikiNoThenMax = new ArrayList<>();
            when(dbT7055GappeiJohoDac.selectByLtChiikiNo(maxChikiNo)).thenReturn(havingSmallerChikiNoThenMax);
            final RString chiki1No = new RString("11");
            final LasdecCode lasdecCodeChiki1 = new LasdecCode("152200");
            havingSmallerChikiNoThenMax.add(createDbT7055GappeiJohoEntity(lasdecCodeChiki1, chiki1No));

            koseiShichosons.add(createKoseiShichosonMasterOfKyuShichoson(new LasdecCode("152198"), chiki1No));
            koseiShichosons.add(createKoseiShichosonMasterOfKyuShichoson(new LasdecCode("152199"), chiki1No));
            koseiShichosons.add(createKoseiShichosonMasterOfKyuShichoson(lasdecCodeChiki1, maxChikiNo));
            koseiShichosons.add(createKoseiShichosonMasterOfKyuShichoson(new LasdecCode("152197"), maxChikiNo));

            KyuShichosonJohoEntities result = sut.getKyuShichosonCodeJoho(lasdecCode, DonyuKeitaiCode.事務広域);
            assertThat(result.size(), is(3));
            assertThat(result.contains合併市町村(), is(true));
        }
    }

    private static KoseiShichosonMaster createKoseiShichosonMasterOfKyuShichoson(LasdecCode 市町村コード, RString 合併地域番号) {
        DbT7051KoseiShichosonMasterEntity entity1 = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
        entity1.setShichosonCode(市町村コード);
        entity1.setGappeiChiikiNo(合併地域番号);
        entity1.setGappeiKyuShichosonKubun(GappeiKyuShichosonKubun.合併旧市町村.code());
        return new KoseiShichosonMaster(entity1);
    }

    public static class 広域_合併なし extends DbxTestBase {

        @BeforeClass
        public static void setUpClass() {
            koseiShichosonJohoFinder = Mockito.mock(KoseiShichosonJohoFinder.class);
            dbT7055GappeiJohoDac = Mockito.mock(DbT7055GappeiJohoDac.class);
            dbT7056GappeiShichosonDac = Mockito.mock(DbT7056GappeiShichosonDac.class);

        }

        @Test
        public void 合併していない場合_結果は空になる() {
            sut = KyuShichosonCodeFinder.createInstanceForTest(
                    koseiShichosonJohoFinder, dbT7055GappeiJohoDac, dbT7056GappeiShichosonDac, false);

            KyuShichosonJohoEntities result = sut.getKyuShichosonCodeJoho(new LasdecCode("152201"), DonyuKeitaiCode.事務広域);
            assertThat(result.isEmpty(), is(true));
            assertThat(result.contains合併市町村(), is(false));
        }
    }
}
