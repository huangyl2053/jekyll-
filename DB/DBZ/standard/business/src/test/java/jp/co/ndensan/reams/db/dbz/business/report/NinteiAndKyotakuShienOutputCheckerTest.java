/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report;

import com.google.common.collect.Lists;
import jp.co.ndensan.reams.db.dbz.business.config.shikaku.HihokenshashoPrintConfig;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshaShikakuHakkoModel;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link jp.co.ndensan.reams.db.dbz.business.report.NinteiAndKyotakuShienOutputChecker}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteiAndKyotakuShienOutputCheckerTest {

    private static NinteiAndKyotakuShienOutputChecker sut;
    private static HihokenshashoModel hihokenshashoModel;
    private static HihokenshashoPrintConfig printConfig;

    public static class constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 被保険者証Modelにnullが渡された場合_NullPointerExceptionが発生する() {
            hihokenshashoModel = null;
            printConfig = mock(HihokenshashoPrintConfig.class);
            sut = new NinteiAndKyotakuShienOutputChecker(hihokenshashoModel, printConfig);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者証表示方法コンフィグにnullが渡された場合_NullPointerExceptionが発生する() {
            hihokenshashoModel = mock(HihokenshashoModel.class);
            printConfig = null;
            sut = new NinteiAndKyotakuShienOutputChecker(hihokenshashoModel, printConfig);
            fail();
        }
    }

    public static class is居宅支援事業者表示 extends DbzTestBase {

        @Test
        public void is居宅支援事業者適用切れ表示有りがtrueであり_居宅支援事業者適用が継続中の場合_trueが返る() {
            printConfig = createPrintConfig(configValue.有り);
            hihokenshashoModel = createKyotakuHanteiHihoshoModel("20120101", "20120506", "20121231");
            sut = new NinteiAndKyotakuShienOutputChecker(hihokenshashoModel, printConfig);
            assertThat(sut.is居宅支援事業者表示(), is(true));
        }

        @Test
        public void is居宅支援事業者適用切れ表示有りがtrueであり_居宅支援事業者適用が継続していないの場合_trueが返る() {
            printConfig = createPrintConfig(configValue.有り);
            hihokenshashoModel = createKyotakuHanteiHihoshoModel("20120101", "20130506", "20121231");
            sut = new NinteiAndKyotakuShienOutputChecker(hihokenshashoModel, printConfig);
            assertThat(sut.is居宅支援事業者表示(), is(true));
        }

        @Test
        public void is居宅支援事業者適用切れ表示有りがfalseであり_居宅支援事業者適用が継続中の場合_trueが返る() {
            printConfig = createPrintConfig(configValue.無し);
            hihokenshashoModel = createKyotakuHanteiHihoshoModel("20120101", "20120506", "20121231");
            sut = new NinteiAndKyotakuShienOutputChecker(hihokenshashoModel, printConfig);
            assertThat(sut.is居宅支援事業者表示(), is(true));
        }

        @Test
        public void is居宅支援事業者適用切れ表示有りがfalseであり_居宅支援事業者適用が継続していないの場合_falseが返る() {
            printConfig = createPrintConfig(configValue.無し);
            hihokenshashoModel = createKyotakuHanteiHihoshoModel("20120101", "20130506", "20121231");
            sut = new NinteiAndKyotakuShienOutputChecker(hihokenshashoModel, printConfig);
            assertThat(sut.is居宅支援事業者表示(), is(false));
        }

        private HihokenshashoModel createKyotakuHanteiHihoshoModel(String kaishiDate, String hakkoDate, String shuryoDate) {
            HihokenshaShikakuHakkoModel shikakuHakko = mock(HihokenshaShikakuHakkoModel.class);
            when(shikakuHakko.get交付日()).thenReturn(new FlexibleDate(hakkoDate));
            when(shikakuHakko.get支援事業者適用開始日()).thenReturn(Lists.newArrayList(new FlexibleDate(kaishiDate)));
            when(shikakuHakko.get支援事業者適用終了日()).thenReturn(Lists.newArrayList(new FlexibleDate(shuryoDate)));
            HihokenshashoModel hihokenshasho = mock(HihokenshashoModel.class);
            when(hihokenshasho.getShikakuHakko()).thenReturn(shikakuHakko);
            return hihokenshasho;
        }

        private HihokenshashoPrintConfig createPrintConfig(configValue kyotakuHyoji) {
            HihokenshashoPrintConfig printConfigMock = mock(HihokenshashoPrintConfig.class);
            when(printConfigMock.is居宅支援事業者適用切れ表示有り()).thenReturn(kyotakuHyoji.value);
            return printConfigMock;
        }
    }

    public static class is認定情報表示 extends DbzTestBase {

        @Test
        public void is要介護認定期限切れ表示有りがtrueであり_認定が継続中の場合_trueが返る() {
            printConfig = createPrintConfig(configValue.有り);
            hihokenshashoModel = createNinteiHanteiHihoshoModel("20120101", "20120506", "20121231");
            sut = new NinteiAndKyotakuShienOutputChecker(hihokenshashoModel, printConfig);
            assertThat(sut.is認定情報表示(), is(true));
        }

        @Test
        public void is要介護認定期限切れ表示有りがtrueであり_認定が継続していないの場合_trueが返る() {
            printConfig = createPrintConfig(configValue.有り);
            hihokenshashoModel = createNinteiHanteiHihoshoModel("20120101", "20130506", "20121231");
            sut = new NinteiAndKyotakuShienOutputChecker(hihokenshashoModel, printConfig);
            assertThat(sut.is認定情報表示(), is(true));
        }

        @Test
        public void is要介護認定期限切れ表示有りがfalseであり_認定が継続中の場合_trueが返る() {
            printConfig = createPrintConfig(configValue.無し);
            hihokenshashoModel = createNinteiHanteiHihoshoModel("20120101", "20120506", "20121231");
            sut = new NinteiAndKyotakuShienOutputChecker(hihokenshashoModel, printConfig);
            assertThat(sut.is認定情報表示(), is(true));
        }

        @Test
        public void is要介護認定期限切れ表示有りがfalseであり_認定が継続していないの場合_falseが返る() {
            printConfig = createPrintConfig(configValue.無し);
            hihokenshashoModel = createNinteiHanteiHihoshoModel("20120101", "20130506", "20121231");
            sut = new NinteiAndKyotakuShienOutputChecker(hihokenshashoModel, printConfig);
            assertThat(sut.is認定情報表示(), is(false));
        }

        private HihokenshashoModel createNinteiHanteiHihoshoModel(String kaishiDate, String hakkoDate, String shuryoDate) {
            HihokenshaShikakuHakkoModel shikakuHakko = mock(HihokenshaShikakuHakkoModel.class);
            when(shikakuHakko.get交付日()).thenReturn(new FlexibleDate(hakkoDate));
            when(shikakuHakko.get有効期間開始日()).thenReturn(new RDate(kaishiDate));
            when(shikakuHakko.get有効期間終了日()).thenReturn(new RDate(shuryoDate));
            HihokenshashoModel hihokenshasho = mock(HihokenshashoModel.class);
            when(hihokenshasho.getShikakuHakko()).thenReturn(shikakuHakko);
            return hihokenshasho;
        }

        private static HihokenshashoPrintConfig createPrintConfig(configValue kyotakuHyoji) {
            HihokenshashoPrintConfig printConfigMock = mock(HihokenshashoPrintConfig.class);
            when(printConfigMock.is要介護認定期限切れ表示有り()).thenReturn(kyotakuHyoji.value);
            return printConfigMock;
        }
    }

    private enum configValue {

        有り(true),
        無し(false);
        private final boolean value;

        private configValue(boolean value) {
            this.value = value;
        }
    }

}
