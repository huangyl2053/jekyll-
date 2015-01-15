/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase;

import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.NinteiEditorBase;
import com.google.common.collect.Lists;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.HihokenshashoA4;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.HihokenshashoA4EditData;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.IHihokenshashoCommonEditData;
import jp.co.ndensan.reams.db.dbz.business.config.shikaku.HihokenshashoPrintConfig;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshaShikakuHakkoModel;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import static jp.co.ndensan.reams.uz.uza.lang.cast._CastDataTypeFactory.DataType.Decimal;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase.NinteiEditorBase}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteiEditorBaseTest {

    private static NinteiEditorBase sut;
    private static IHihokenshashoCommonEditData target;
    private static HihokenshashoModel hihokenshasho;
    private static HihokenshashoPrintConfig printConfig;

    public static class constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡された場合_NullPointerExceptionが発生する() {
            sut = new NinteiEditorBase(null);
        }
    }

    public static class set要介護状態区分等 extends DbzTestBase {

        private RString yokaigoKubun;

        @Before
        public void setUp() {
            target = createTarget();

            yokaigoKubun = new RString("要介護1");
        }

        @Test
        public void KaigoKbnに_要介護状態が設定される() {
            hihokenshasho = createMockModel(yokaigoKubun);
            sut = new NinteiEditorBase(hihokenshasho);
            sut.set要介護状態区分等(target);

            assertThat(target.getKaigokbn(), is(yokaigoKubun));
        }

        private HihokenshashoModel createMockModel(RString yokaigoKubun) {
            HihokenshaShikakuHakkoModel shikakuHakko = mock(HihokenshaShikakuHakkoModel.class);
            when(shikakuHakko.get要介護状態()).thenReturn(yokaigoKubun);
            HihokenshashoModel hihokenshashoModel = mock(HihokenshashoModel.class);
            when(hihokenshashoModel.getShikakuHakko()).thenReturn(shikakuHakko);
            return hihokenshashoModel;
        }

    }

    public static class set認定年月日 extends DbzTestBase {

        private RDate ninteiDate;

        @Before
        public void setUp() {
            target = createTarget();

            ninteiDate = new RDate("20140101");
        }

        @Test
        public void getNinteiymdに_認定年月日が設定される() {
            hihokenshasho = createMockModel(ninteiDate);
            sut = new NinteiEditorBase(hihokenshasho);
            sut.set認定年月日(target);
            RString ninteiString = ninteiDate.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

            assertThat(target.getNinteiymd(), is(ninteiString));
        }

        private HihokenshashoModel createMockModel(RDate ninteiDate) {
            HihokenshaShikakuHakkoModel shikakuHakko = mock(HihokenshaShikakuHakkoModel.class);
            when(shikakuHakko.get認定日()).thenReturn(ninteiDate);
            HihokenshashoModel hihokenshashoModel = mock(HihokenshashoModel.class);
            when(hihokenshashoModel.getShikakuHakko()).thenReturn(shikakuHakko);
            return hihokenshashoModel;
        }

    }

    public static class set認定有効期間 extends DbzTestBase {

        private RDate kaishiDate;
        private RDate shuryoDate;

        @Before
        public void setUp() {
            target = createTarget();

            kaishiDate = new RDate("20140101");
            shuryoDate = new RDate("20141231");
        }

        @Test
        public void Yukokikanstに_認定期間開始日が設定される() {
            hihokenshasho = createMockModel(kaishiDate, shuryoDate);
            sut = new NinteiEditorBase(hihokenshasho);
            sut.set認定有効期間(target);
            RString kaishiDateString = kaishiDate.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

            assertThat(target.getYukokikanst(), is(kaishiDateString));
        }

        @Test
        public void Yukokikanedに_認定期間終了日が設定される() {
            hihokenshasho = createMockModel(kaishiDate, shuryoDate);
            sut = new NinteiEditorBase(hihokenshasho);
            sut.set認定有効期間(target);
            RString shuryoDateString = shuryoDate.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

            assertThat(target.getYukokikaned(), is(shuryoDateString));
        }

        private HihokenshashoModel createMockModel(RDate kaishiDate, RDate shuryoDate) {
            HihokenshaShikakuHakkoModel shikakuHakko = mock(HihokenshaShikakuHakkoModel.class);
            when(shikakuHakko.get有効期間開始日()).thenReturn(kaishiDate);
            when(shikakuHakko.get有効期間終了日()).thenReturn(shuryoDate);
            HihokenshashoModel hihokenshashoModel = mock(HihokenshashoModel.class);
            when(hihokenshashoModel.getShikakuHakko()).thenReturn(shikakuHakko);
            return hihokenshashoModel;
        }

    }

    public static class set居宅サービス extends DbzTestBase {

        private RDate gendoKaishiDate;
        private RDate gendoShuryoDate;
        private int gendoKijunGaku;
        private RString gendoKijunGakuStr;

        @Before
        public void setUp() {
            target = createTarget();

            gendoKaishiDate = new RDate("20140101");
            gendoShuryoDate = new RDate("20141231");
            gendoKijunGaku = 10000;
            gendoKijunGakuStr = new RString("10,000");
        }

        @Test
        public void Homonkikanstに_限度額有効期間開始日が設定される() {
            hihokenshasho = createMockModel(gendoKaishiDate, gendoShuryoDate, gendoKijunGaku);
            sut = new NinteiEditorBase(hihokenshasho);
            sut.set居宅サービス(target);
            RString kaishiDateString = gendoKaishiDate.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

            assertThat(target.getHomonkikanst(), is(kaishiDateString));
        }

        @Test
        public void Homonkikanedに_限度額有効期間終了日が設定される() {
            hihokenshasho = createMockModel(gendoKaishiDate, gendoShuryoDate, gendoKijunGaku);
            sut = new NinteiEditorBase(hihokenshasho);
            sut.set居宅サービス(target);
            RString shuryoDateString = gendoShuryoDate.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

            assertThat(target.getHomonkikaned(), is(shuryoDateString));
        }

        @Test
        public void Service1に_限度基準額が設定される() {
            hihokenshasho = createMockModel(gendoKaishiDate, gendoShuryoDate, gendoKijunGaku);
            sut = new NinteiEditorBase(hihokenshasho);
            sut.set居宅サービス(target);

            assertThat(target.getService1(), is(gendoKijunGakuStr));
        }

        private HihokenshashoModel createMockModel(RDate gendoKaishiDate, RDate gendoShuryoDate, int gendoKijunGaku) {
            HihokenshaShikakuHakkoModel shikakuHakko = mock(HihokenshaShikakuHakkoModel.class);
            when(shikakuHakko.get限度額有効期間開始日()).thenReturn(gendoKaishiDate);
            when(shikakuHakko.get限度額有効期間終了日()).thenReturn(gendoShuryoDate);
            when(shikakuHakko.get限度基準額()).thenReturn(new Decimal(gendoKijunGaku));
            HihokenshashoModel hihokenshashoModel = mock(HihokenshashoModel.class);
            when(hihokenshashoModel.getShikakuHakko()).thenReturn(shikakuHakko);
            return hihokenshashoModel;
        }

    }

    public static class setうち種類支給限度基準額 extends DbzTestBase {

        List<RString> serviceShu;
        List<RString> serviceGaku;

        @Before
        public void setUp() {
            target = createTarget();

            serviceShu = Lists.newArrayList(new RString("serviceShu1"), new RString("serviceShu2"), new RString("serviceShu3"),
                    new RString("serviceShu4"), new RString("serviceShu5"), new RString("serviceShu6"));
            serviceGaku = Lists.newArrayList(new RString("16,000"), new RString("15,000"), new RString("14,000"),
                    new RString("13,000"), new RString("12,000"), new RString("11,000"));

            hihokenshasho = createMockModel(serviceShu, serviceGaku);
            sut = new NinteiEditorBase(hihokenshasho);
            sut.setうち種類支給限度基準額(target);
        }

        @Test
        public void Shurui1に_限度基準額サービス種類の0番目の要素が設定される() {
            assertThat(target.getShurui1(), is(serviceShu.get(0)));
        }

        @Test
        public void Shuruigendo1に_get限度基準額サービス額の0番目の要素が設定される() {
            assertThat(target.getShuruigendo1(), is(serviceGaku.get(0)));
        }

        @Test
        public void Shurui2に_限度基準額サービス種類の1番目の要素が設定される() {
            assertThat(target.getShurui2(), is(serviceShu.get(1)));
        }

        @Test
        public void Shuruigendo2に_get限度基準額サービス額の1番目の要素が設定される() {
            assertThat(target.getShuruigendo2(), is(serviceGaku.get(1)));
        }

        @Test
        public void Shurui3に_限度基準額サービス種類の2番目の要素が設定される() {
            assertThat(target.getShurui3(), is(serviceShu.get(2)));
        }

        @Test
        public void Shuruigendo3に_get限度基準額サービス額の2番目の要素が設定される() {
            assertThat(target.getShuruigendo3(), is(serviceGaku.get(2)));
        }

        @Test
        public void Shurui4に_限度基準額サービス種類の3番目の要素が設定される() {
            assertThat(target.getShurui4(), is(serviceShu.get(3)));
        }

        @Test
        public void Shuruigendo4に_get限度基準額サービス額の3番目の要素が設定される() {
            assertThat(target.getShuruigendo4(), is(serviceGaku.get(3)));
        }

        @Test
        public void Shurui5に_限度基準額サービス種類の4番目の要素が設定される() {
            assertThat(target.getShurui5(), is(serviceShu.get(4)));
        }

        @Test
        public void Shuruigendo5に_get限度基準額サービス額の4番目の要素が設定される() {
            assertThat(target.getShuruigendo5(), is(serviceGaku.get(4)));
        }

        @Test
        public void Shurui6に_限度基準額サービス種類の5番目の要素が設定される() {
            assertThat(target.getShurui6(), is(serviceShu.get(5)));
        }

        @Test
        public void Shuruigendo6に_get限度基準額サービス額の5番目の要素が設定される() {
            assertThat(target.getShuruigendo6(), is(serviceGaku.get(5)));
        }

        @Test
        public void 限度基準額サービスが7つ以上あっても_6番目以降は無視される() {
            serviceShu = Lists.newArrayList(new RString("serviceShu1"), new RString("serviceShu2"), new RString("serviceShu3"),
                    new RString("serviceShu4"), new RString("serviceShu5"), new RString("serviceShu6"), new RString("serviceShu7"));
            serviceGaku = Lists.newArrayList(new RString("16,000"), new RString("15,000"), new RString("14,000"),
                    new RString("13,000"), new RString("12,000"), new RString("11,000"), new RString("10,000"));

            hihokenshasho = createMockModel(serviceShu, serviceGaku);
            sut = new NinteiEditorBase(hihokenshasho);
            sut.setうち種類支給限度基準額(target);
            assertThat(target.getShurui6(), is(not(serviceShu.get(6))));
        }

        private HihokenshashoModel createMockModel(List<RString> shuList, List<RString> gakuList) {
            HihokenshaShikakuHakkoModel shikakuHakko = mock(HihokenshaShikakuHakkoModel.class);
            when(shikakuHakko.get限度基準額サービス種類()).thenReturn(shuList);
            when(shikakuHakko.get限度基準額サービス額()).thenReturn(gakuList);
            HihokenshashoModel hihokenshashoModel = mock(HihokenshashoModel.class);
            when(hihokenshashoModel.getShikakuHakko()).thenReturn(shikakuHakko);
            return hihokenshashoModel;
        }

    }

    public static class set認定審査会の意見等 extends DbzTestBase {

        private RString shinsakaiIken;

        @Before
        public void setUp() {
            target = createTarget();

            shinsakaiIken = new RString("あえいうえおあお、かけきくけこかこ、させしすせそさそ、たてちつてとたと");
        }

        @Test
        public void Ryuiに_審査会意見等が設定される() {
            hihokenshasho = createMockModel(shinsakaiIken);
            sut = new NinteiEditorBase(hihokenshasho);
            sut.set認定審査会の意見等(target);

            assertThat(target.getRyui(), is(shinsakaiIken));
        }

        private HihokenshashoModel createMockModel(RString shinsakaiIken) {
            HihokenshaShikakuHakkoModel shikakuHakko = mock(HihokenshaShikakuHakkoModel.class);
            when(shikakuHakko.get審査会意見()).thenReturn(shinsakaiIken);
            HihokenshashoModel hihokenshashoModel = mock(HihokenshashoModel.class);
            when(hihokenshashoModel.getShikakuHakko()).thenReturn(shikakuHakko);
            return hihokenshashoModel;
        }

    }

    private static IHihokenshashoCommonEditData createTarget() {
        HihokenshashoA4 a4 = new HihokenshashoA4();
        return new HihokenshashoA4EditData(a4);
    }

}
