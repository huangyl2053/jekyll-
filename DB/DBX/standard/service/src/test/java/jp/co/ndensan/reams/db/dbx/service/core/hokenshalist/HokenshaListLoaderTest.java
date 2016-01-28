/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.hokenshalist;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.gappeijohokanri.GappeiJohoKanriConfig;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.gappeijohokanri.GappeiJohoKubun;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonJoho;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.koseishichoson.GappeiKyuShichosonKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.koseishichoson.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho.KyuShichosonJohoEntities;
import jp.co.ndensan.reams.db.dbx.service.core.gappeijoho.KyuShichosonCodeFinder;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * {@link HokenshaListLoader}のテストです。
 */
@RunWith(Enclosed.class)
public class HokenshaListLoaderTest {

    private static ShichosonSecurityJohoFinder shichosonSecurityJohoFinder;
    private static KyuShichosonCodeFinder kyuShichosonCodeFinder;
    private static KoseiShichosonJohoFinder koseiShichosonJohoFinder;
    private static GappeiJohoKanriConfig gappeiJohoKanriConfig;
    private static HokenshaListLoader sut;

    public HokenshaListLoaderTest() {
    }

    @RunWith(PowerMockRunner.class)
    @PrepareForTest({HokenshaListLoader.class, KyuShichosonCodeFinder.class})
    public static class testCreateInstance extends DbxTestDacBase {

        @Before
        public void setUp() throws Exception {
            GappeiJohoKanriConfig config = mock(GappeiJohoKanriConfig.class);
            when(config.has合併()).thenReturn(false);
            PowerMockito.whenNew(GappeiJohoKanriConfig.class)
                    .withNoArguments().thenReturn(config);
        }

        @Test
        public void createInstanceにより_ShichosonListのインスタンスが生成できる() {
            assertThat(HokenshaListLoader.createInstance(), isA(HokenshaListLoader.class));
        }
    }

    public static class 広域_合併あり extends DbxTestBase {

        @BeforeClass
        public static void setUpClass() {
            shichosonSecurityJohoFinder = mock(ShichosonSecurityJohoFinder.class);
            kyuShichosonCodeFinder = mock(KyuShichosonCodeFinder.class);
            koseiShichosonJohoFinder = mock(KoseiShichosonJohoFinder.class);
            gappeiJohoKanriConfig = mock(GappeiJohoKanriConfig.class);
        }

        private final GyomuBunrui gyomuBunrui = GyomuBunrui.介護事務;
        private List<KoseiShichosonMaster> zenShichosonJohoList;

        @Before
        public void setUp() {
            when(gappeiJohoKanriConfig.get合併情報区分()).thenReturn(GappeiJohoKubun.合併あり);

            zenShichosonJohoList = new ArrayList<>();
            when(koseiShichosonJohoFinder.get全市町村情報()).thenReturn(zenShichosonJohoList);

            sut = new HokenshaListLoader(shichosonSecurityJohoFinder, kyuShichosonCodeFinder, koseiShichosonJohoFinder, gappeiJohoKanriConfig);
        }

        @Test(expected = ApplicationException.class)
        public void 市町村セキュリティ情報が取得できなかった場合_ApplicationExceptionがスローされる() {
            when(shichosonSecurityJohoFinder.getShichosonSecurityJoho(gyomuBunrui)).thenReturn(null);
            sut.getShichosonCodeNameList(gyomuBunrui);
        }

        @Test(expected = ApplicationException.class)
        public void 取得した市町村セキュリティ情報の市町村識別コードが_00_以外の場合_ApplicationExceptionがスローされる() {
            ShichosonSecurityJoho ssj = createShichosonSecurityJoho(DonyuKeitaiCode.事務広域, "010102", "テスト町", "010103", "01");
            when(shichosonSecurityJohoFinder.getShichosonSecurityJoho(gyomuBunrui)).thenReturn(ssj);
            sut.getShichosonCodeNameList(gyomuBunrui);
        }

        @Test(expected = ApplicationException.class)
        public void 構成市町村情報が取得できなかった場合_ApplicationExceptionがスローされる() {
            ShichosonSecurityJoho ssj = createShichosonSecurityJoho(DonyuKeitaiCode.事務広域, "010102", "テスト町", "010103", "00");
            when(shichosonSecurityJohoFinder.getShichosonSecurityJoho(gyomuBunrui)).thenReturn(ssj);
            this.zenShichosonJohoList.clear();
            sut.getShichosonCodeNameList(gyomuBunrui);
        }

        @Test
        public void 構成市町村情報が取得できた場合_結果のShichosonCodeNameResultsは_取得した構成市町村と広域保険者1つを合わせた数の要素を持つ() {
            ShichosonSecurityJoho ssj = createShichosonSecurityJoho(DonyuKeitaiCode.事務広域, "010102", "テスト町", "010103", "00");
            when(shichosonSecurityJohoFinder.getShichosonSecurityJoho(gyomuBunrui)).thenReturn(ssj);
            this.zenShichosonJohoList.add(createKoseiShichosonMaster("101010", "テスト市", "101010", GappeiKyuShichosonKubun.合併旧市町村));
            this.zenShichosonJohoList.add(createKoseiShichosonMaster("101020", "テスト村", "101020", GappeiKyuShichosonKubun.構成市町村));
            HokenshaList result = sut.getShichosonCodeNameList(gyomuBunrui);
            assertThat(result.is広域(), is(true));
            assertThat(result.size(), is(zenShichosonJohoList.size() + 1));
            //GappeiKyuShichosonKubun.旧市町村分　→ TokeiTaishoKubun.旧市町村分 の確認
            assertThat(result.get(zenShichosonJohoList.get(0).get市町村コード()).get保険者区分(), is(TokeiTaishoKubun.旧市町村分));
            //GappeiKyuShichosonKubun.構成市町村　→ TokeiTaishoKubun.構成市町村分 の確認
            assertThat(result.get(zenShichosonJohoList.get(1).get市町村コード()).get保険者区分(), is(TokeiTaishoKubun.構成市町村分));
        }
    }

    private static ShichosonSecurityJoho createShichosonSecurityJoho(
            DonyuKeitaiCode donyuKeitai, String shichosonCode, String shichosonName, String shokisaiHokenshaNo, String shichosonShikibetsuId) {
        ShichosonJoho shichosonJoho = new ShichosonJoho();
        shichosonJoho.setShichosonCode(new LasdecCode(shichosonCode));
        shichosonJoho.setShichosonMeisho(new RString(shichosonName));
        shichosonJoho.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(shokisaiHokenshaNo));
        shichosonJoho.setShichosonShokibetsuID(new ShichosonShikibetsuID(shichosonShikibetsuId));
        return new ShichosonSecurityJoho.Builder(donyuKeitai)
                .set市町村情報(shichosonJoho)
                .build();
    }

    private static KoseiShichosonMaster createKoseiShichosonMaster(
            String shichosonCode, String shichosonName, String shoKisaiHokenshaNo, GappeiKyuShichosonKubun gappeiKyuShichosonKubun) {
        KoseiShichosonMaster koseiShichosonMaster = mock(KoseiShichosonMaster.class);
        when(koseiShichosonMaster.get市町村コード()).thenReturn(new LasdecCode(shichosonCode));
        when(koseiShichosonMaster.get市町村名称()).thenReturn(new RString(shichosonName));
        when(koseiShichosonMaster.get証記載保険者番号()).thenReturn(new ShoKisaiHokenshaNo(shoKisaiHokenshaNo));
        when(koseiShichosonMaster.get合併旧市町村区分()).thenReturn(gappeiKyuShichosonKubun);
        return koseiShichosonMaster;
    }

    public static class 広域_合併なし extends DbxTestBase {

        @BeforeClass
        public static void setUpClass() {
            shichosonSecurityJohoFinder = mock(ShichosonSecurityJohoFinder.class);
            kyuShichosonCodeFinder = mock(KyuShichosonCodeFinder.class);
            koseiShichosonJohoFinder = mock(KoseiShichosonJohoFinder.class);
            gappeiJohoKanriConfig = mock(GappeiJohoKanriConfig.class);
        }

        private final GyomuBunrui gyomuBunrui = GyomuBunrui.介護事務;
        private List<KoseiShichosonMaster> genShichosonJohoList;

        @Before
        public void setUp() {
            when(gappeiJohoKanriConfig.get合併情報区分()).thenReturn(GappeiJohoKubun.合併なし);

            genShichosonJohoList = new ArrayList<>();
            when(koseiShichosonJohoFinder.get現市町村情報()).thenReturn(genShichosonJohoList);

            sut = new HokenshaListLoader(shichosonSecurityJohoFinder, kyuShichosonCodeFinder, koseiShichosonJohoFinder, gappeiJohoKanriConfig);
        }

        @Test(expected = ApplicationException.class)
        public void 市町村セキュリティ情報が取得できなかった場合_ApplicationExceptionがスローされる() {
            when(shichosonSecurityJohoFinder.getShichosonSecurityJoho(gyomuBunrui)).thenReturn(null);
            sut.getShichosonCodeNameList(gyomuBunrui);
        }

        @Test(expected = ApplicationException.class)
        public void 取得した市町村セキュリティ情報の市町村識別コードが_00_以外の場合_ApplicationExceptionがスローされる() {
            ShichosonSecurityJoho ssj = createShichosonSecurityJoho(DonyuKeitaiCode.事務広域, "010102", "テスト町", "010103", "01");
            when(shichosonSecurityJohoFinder.getShichosonSecurityJoho(gyomuBunrui)).thenReturn(ssj);
            sut.getShichosonCodeNameList(gyomuBunrui);
        }

        @Test(expected = ApplicationException.class)
        public void 構成市町村情報が取得できなかった場合_ApplicationExceptionがスローされる() {
            ShichosonSecurityJoho ssj = createShichosonSecurityJoho(DonyuKeitaiCode.事務広域, "010102", "テスト町", "010103", "00");
            when(shichosonSecurityJohoFinder.getShichosonSecurityJoho(gyomuBunrui)).thenReturn(ssj);
            this.genShichosonJohoList.clear();
            sut.getShichosonCodeNameList(gyomuBunrui);
        }

        @Test
        public void 構成市町村情報が取得できた場合_結果のShichosonCodeNameResultsは_取得した構成市町村と広域保険者1つを合わせた数の要素を持つ() {
            ShichosonSecurityJoho ssj = createShichosonSecurityJoho(DonyuKeitaiCode.事務広域, "010102", "テスト町", "010103", "00");
            when(shichosonSecurityJohoFinder.getShichosonSecurityJoho(gyomuBunrui)).thenReturn(ssj);
            this.genShichosonJohoList.add(createKoseiShichosonMaster("101010", "テスト市", "101010", GappeiKyuShichosonKubun.構成市町村));
            this.genShichosonJohoList.add(createKoseiShichosonMaster("101020", "テスト村", "101020", GappeiKyuShichosonKubun.構成市町村));
            HokenshaList result = sut.getShichosonCodeNameList(gyomuBunrui);
            assertThat(result.is広域(), is(true));
            assertThat(result.size(), is(genShichosonJohoList.size() + 1));
            //全要素 TokeiTaishoKubun.構成市町村分
            assertThat(result.get(genShichosonJohoList.get(0).get市町村コード()).get保険者区分(), is(TokeiTaishoKubun.構成市町村分));
            assertThat(result.get(genShichosonJohoList.get(1).get市町村コード()).get保険者区分(), is(TokeiTaishoKubun.構成市町村分));
        }
    }

    public static class 単一_合併あり extends DbxTestBase {

        @BeforeClass
        public static void setUpClass() {
            shichosonSecurityJohoFinder = mock(ShichosonSecurityJohoFinder.class);
            kyuShichosonCodeFinder = mock(KyuShichosonCodeFinder.class);
            koseiShichosonJohoFinder = mock(KoseiShichosonJohoFinder.class);
            gappeiJohoKanriConfig = mock(GappeiJohoKanriConfig.class);
        }

        private final GyomuBunrui gyomuBunrui = GyomuBunrui.介護事務;
        private final DonyuKeitaiCode donyuKeitai = DonyuKeitaiCode.事務単一;

        @Before
        public void setUp() {
            when(gappeiJohoKanriConfig.get合併情報区分()).thenReturn(GappeiJohoKubun.合併あり);

            sut = new HokenshaListLoader(shichosonSecurityJohoFinder, kyuShichosonCodeFinder, koseiShichosonJohoFinder, gappeiJohoKanriConfig);
        }

        @Test(expected = ApplicationException.class)
        public void 市町村セキュリティ情報が取得できなかった場合_ApplicationExceptionがスローされる() {
            when(shichosonSecurityJohoFinder.getShichosonSecurityJoho(gyomuBunrui)).thenReturn(null);
            sut.getShichosonCodeNameList(gyomuBunrui);
        }

        @Test(expected = ApplicationException.class)
        public void 旧市町村情報が取得できなかった場合_ApplicationExceptionがスローされる() {
            ShichosonSecurityJoho ssj = createShichosonSecurityJoho(donyuKeitai, "010102", "テスト町", "010103", "00");
            when(shichosonSecurityJohoFinder.getShichosonSecurityJoho(gyomuBunrui)).thenReturn(ssj);

            List<DbT7056GappeiShichosonEntity> gappeiShichosonEntities = new ArrayList<>();
            KyuShichosonJohoEntities kyuShichosons = new KyuShichosonJohoEntities(gappeiShichosonEntities, true);
            when(kyuShichosonCodeFinder.getKyuShichosonCodeJoho(ssj.get市町村情報().getShichosonCode(), donyuKeitai))
                    .thenReturn(kyuShichosons);

            sut.getShichosonCodeNameList(gyomuBunrui);
        }

        @Test
        public void 旧市町村情報が取得できた場合_結果のShichosonCodeNameResultsは_取得した構成市町村と広域保険者1つを合わせた数の要素を持つ() {
            ShichosonSecurityJoho ssj = createShichosonSecurityJoho(donyuKeitai, "010102", "テスト町", "010103", "00");
            when(shichosonSecurityJohoFinder.getShichosonSecurityJoho(gyomuBunrui)).thenReturn(ssj);

            List<DbT7056GappeiShichosonEntity> gappeiShichosonEntities = new ArrayList<>();
            gappeiShichosonEntities.add(createGappeiShichoson("010081", "南テスト村", "010081"));
            gappeiShichosonEntities.add(createGappeiShichoson("010091", "北テスト村", "010091"));
            KyuShichosonJohoEntities kyuShichosons = new KyuShichosonJohoEntities(gappeiShichosonEntities, true);
            when(kyuShichosonCodeFinder.getKyuShichosonCodeJoho(ssj.get市町村情報().getShichosonCode(), donyuKeitai))
                    .thenReturn(kyuShichosons);

            HokenshaList result = sut.getShichosonCodeNameList(gyomuBunrui);
            assertThat(result.is広域(), is(false));
            assertThat(result.size(), is(gappeiShichosonEntities.size() + 1));
            //全要素 TokeiTaishoKubun.旧市町村分 の確認
            assertThat(result.get(gappeiShichosonEntities.get(0).getKyuShichosonCode()).get保険者区分(), is(TokeiTaishoKubun.旧市町村分));
            assertThat(result.get(gappeiShichosonEntities.get(1).getKyuShichosonCode()).get保険者区分(), is(TokeiTaishoKubun.旧市町村分));
        }
    }

    private static DbT7056GappeiShichosonEntity createGappeiShichoson(String kyuShichosonCode, String kyuShichosonMeisho, String kyuHokenshaNo) {
        DbT7056GappeiShichosonEntity entity = new DbT7056GappeiShichosonEntity();
        entity.setKyuShichosonCode(new LasdecCode(kyuShichosonCode));
        entity.setKyuShichosonMeisho(new RString(kyuShichosonMeisho));
        entity.setKyuHokenshaNo(new HokenshaNo(kyuHokenshaNo));
        return entity;
    }

    public static class 単一_合併なし extends DbxTestBase {

        @BeforeClass
        public static void setUpClass() {
            shichosonSecurityJohoFinder = mock(ShichosonSecurityJohoFinder.class);
            kyuShichosonCodeFinder = mock(KyuShichosonCodeFinder.class);
            koseiShichosonJohoFinder = mock(KoseiShichosonJohoFinder.class);
            gappeiJohoKanriConfig = mock(GappeiJohoKanriConfig.class);
        }

        private final GyomuBunrui gyomuBunrui = GyomuBunrui.介護事務;
        private final DonyuKeitaiCode donyuKeitai = DonyuKeitaiCode.事務単一;

        @Before
        public void setUp() {
            when(gappeiJohoKanriConfig.get合併情報区分()).thenReturn(GappeiJohoKubun.合併なし);

            sut = new HokenshaListLoader(shichosonSecurityJohoFinder, kyuShichosonCodeFinder, koseiShichosonJohoFinder, gappeiJohoKanriConfig);
        }

        @Test(expected = ApplicationException.class)
        public void 市町村セキュリティ情報が取得できなかった場合_ApplicationExceptionがスローされる() {
            when(shichosonSecurityJohoFinder.getShichosonSecurityJoho(gyomuBunrui)).thenReturn(null);
            sut.getShichosonCodeNameList(gyomuBunrui);
        }

        @Test
        public void 単一市町村で合併なしの場合_結果は1件_市町村セキュリティから取得した保険者となる() {
            ShichosonSecurityJoho ssj = createShichosonSecurityJoho(donyuKeitai, "010102", "テスト町", "010103", "00");
            when(shichosonSecurityJohoFinder.getShichosonSecurityJoho(gyomuBunrui)).thenReturn(ssj);

            HokenshaList result = sut.getShichosonCodeNameList(gyomuBunrui);
            assertThat(result.is広域(), is(false));
            assertThat(result.size(), is(1));
            assertThat(result.get(ssj.get市町村情報().getShichosonCode()).get保険者区分(), is(TokeiTaishoKubun.保険者分));
        }
    }
}
