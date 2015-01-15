/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X;

import jp.co.ndensan.reams.db.dbz.business.config.kyotsutokei.ChohyoKyotsuJushoEditConfig;
import jp.co.ndensan.reams.db.dbz.business.config.shikaku.HihokenshashoJushoEditConfig;
import jp.co.ndensan.reams.db.dbz.business.config.shikaku.HihokenshashoPrintConfig;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.DateOfBirthEditorA4Base;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.GenderEditorA4Base;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.KyufuSeigenEditorBase;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.NinteiEditorBase;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.SeiDoitsuShogaiEditorBase;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.ShikakuKihonEditorBase;
import jp.co.ndensan.reams.db.dbz.business.report.NinteiAndKyotakuShienOutputChecker;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoPrintPosition;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.HihokenshaNoPrintType;
import jp.co.ndensan.reams.db.dbz.definition.util.Lists;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.HihokenshashoA4;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.IHihokenshashoA4CommonEditData;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.IHihokenshashoCommonEditData;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshaShikakuHakkoModel;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.business.IZenkokuJushoItem;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doCallRealMethod;

/**
 * {@link jp.co.ndensan.reams.db.dba.business.report.DBA10000X.HihokenshashoA4Editor}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshashoA4EditorTest {

    private static HihokenshashoA4Editor sut;
    private static HihokenshashoA4 result;

    public static class constructor extends DbzTestBase {

        HihokenshashoModel model;
        IZenkokuJushoItem jusho;

        @Test(expected = NullPointerException.class)
        public void 被保険者証Modelにnullが渡された場合_NullPointerExceptionが発生する() {
            model = null;
            jusho = mock(IZenkokuJushoItem.class);
            sut = new HihokenshashoA4Editor(model, jusho);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 全国住所にnullが渡された場合_NullPointerExceptionが発生する() {
            model = mock(HihokenshashoModel.class);
            jusho = null;
            sut = new HihokenshashoA4Editor(model, jusho);
            fail();
        }
    }

    public static class edit extends DbzTestBase {

        private RString hihokenshaNo;
        private FlexibleDate ninteiDate;
        private RString shienJigyosha;
        private FlexibleDate todokedeDate;
        private HihokenshashoPrintConfig printConfig;
        private HihokenshashoJushoEditConfig hihoJushoEditConfig;
        private ChohyoKyotsuJushoEditConfig kyotsuJushoEditConfig;

        @Before
        public void setUp() {
            hihokenshaNo = new RString("0000012345");
            ninteiDate = new FlexibleDate("20130101");
            shienJigyosha = new RString("居宅支援事業者");
            todokedeDate = new FlexibleDate("20140101");
            printConfig = createMockPrintConfig();
            hihoJushoEditConfig = mock(HihokenshashoJushoEditConfig.class);
            kyotsuJushoEditConfig = mock(ChohyoKyotsuJushoEditConfig.class);
        }

        @Test
        public void 被保険者証の項目である_被保険者番号に値が設定される() {
            HihokenshashoModel model = createMockModel(hihokenshaNo, ninteiDate, HihokenshashoPrintPosition.下部, shienJigyosha, todokedeDate);
            sut = createSut(model, createChecker(NinteiInput.有り, KyotakuShienInput.有り));
            result = sut.edit(new HihokenshashoA4());
            assertThat(result.hihokenshanno, is(hihokenshaNo));
        }

        @Test
        public void is認定情報表示がtrueを返す場合_認定情報の設定が行われ_ninteiymdに値が設定される() {
            HihokenshashoModel model = createMockModel(hihokenshaNo, ninteiDate, HihokenshashoPrintPosition.下部, shienJigyosha, todokedeDate);
            sut = createSut(model, createChecker(NinteiInput.有り, KyotakuShienInput.有り));
            result = sut.edit(new HihokenshashoA4());
            assertThat(result.ninteiymd, is(toWarekiString(ninteiDate)));
        }

        @Test
        public void is認定情報表示がfalseを返す場合_認定情報の設定は行われず_ninteiymdは何も設定されない() {
            HihokenshashoModel model = createMockModel(hihokenshaNo, ninteiDate, HihokenshashoPrintPosition.下部, shienJigyosha, todokedeDate);
            sut = createSut(model, createChecker(NinteiInput.無し, KyotakuShienInput.有り));
            result = sut.edit(new HihokenshashoA4());
            assertThat(result.ninteiymd, is(nullValue()));
        }

        @Test
        public void is居宅支援事業者表示がtrueを返す場合_居宅支援事業者の設定が行われ_gyosha1に値が設定される() {
            HihokenshashoModel model = createMockModel(hihokenshaNo, ninteiDate, HihokenshashoPrintPosition.下部, shienJigyosha, todokedeDate);
            sut = createSut(model, createChecker(NinteiInput.有り, KyotakuShienInput.有り));
            result = sut.edit(new HihokenshashoA4());
            assertThat(result.gyosha1, is(shienJigyosha));
        }

        @Test
        public void is居宅支援事業者表示がfalseを返す場合_認定情報の設定は行われず_gyosha1は何も設定されない() {
            HihokenshashoModel model = createMockModel(hihokenshaNo, ninteiDate, HihokenshashoPrintPosition.下部, shienJigyosha, todokedeDate);
            sut = createSut(model, createChecker(NinteiInput.有り, KyotakuShienInput.無し));
            result = sut.edit(new HihokenshashoA4());
            assertThat(result.gyosha1, is(nullValue()));
        }

        private HihokenshashoA4Editor createSut(HihokenshashoModel model, NinteiAndKyotakuShienOutputChecker checker) {
            return new HihokenshashoA4Editor(
                    createMockPrintConfig(),
                    hihoJushoEditConfig,
                    kyotsuJushoEditConfig,
                    createMockShikakuKihonEditor(model, printConfig, hihoJushoEditConfig, kyotsuJushoEditConfig),
                    createMockNinteiEditor(model),
                    createMockKyufuSeigenEditor(model, printConfig),
                    createMockseiDoitsuEditor(model),
                    createMockGenderEditor(model),
                    createMockDateOfBirthEditor(model),
                    checker
            );
        }

        private HihokenshashoModel createMockModel(RString hihokenshaNo, FlexibleDate nintaiDate, HihokenshashoPrintPosition 印字位置,
                RString shienJigyosha, FlexibleDate todokedeDate) {
            HihokenshaShikakuHakkoModel shikakuHakko = mock(HihokenshaShikakuHakkoModel.class);
            when(shikakuHakko.get認定日()).thenReturn(nintaiDate);
            when(shikakuHakko.get支援事業者名称()).thenReturn(Lists.newArrayList(shienJigyosha));
            when(shikakuHakko.get支援事業者届出日()).thenReturn(Lists.newArrayList(todokedeDate));

            HihokenshaDaichoModel daicho = mock(HihokenshaDaichoModel.class);
            when(daicho.get被保険者番号()).thenReturn(new HihokenshaNo(hihokenshaNo));

            HihokenshashoModel hihokenshashoModel = mock(HihokenshashoModel.class);
            when(hihokenshashoModel.getShikakuHakko()).thenReturn(shikakuHakko);
            when(hihokenshashoModel.getHihokenshaDaicho()).thenReturn(daicho);
            when(hihokenshashoModel.getPosition()).thenReturn(印字位置);
            return hihokenshashoModel;
        }

        private HihokenshashoPrintConfig createMockPrintConfig() {
            HihokenshashoPrintConfig printConfigMock = mock(HihokenshashoPrintConfig.class);
            when(printConfigMock.get被保険者番号表示書式()).thenReturn(HihokenshaNoPrintType.そのまま);
            when(printConfigMock.is届出日の代わりに適用開始日を表示()).thenReturn(false);
            return printConfigMock;
        }

        private ShikakuKihonEditorBase createMockShikakuKihonEditor(HihokenshashoModel model, HihokenshashoPrintConfig printConfig,
                HihokenshashoJushoEditConfig hihoJushoEditConfig, ChohyoKyotsuJushoEditConfig kyotsuJushoEditConfig) {
            IZenkokuJushoItem zenkokuJusho;
            zenkokuJusho = mock(IZenkokuJushoItem.class);
            ShikakuKihonEditorBase editorBase = spy(new ShikakuKihonEditorBase(model, zenkokuJusho, printConfig, hihoJushoEditConfig, kyotsuJushoEditConfig));
            doCallRealMethod().when(editorBase).set被保険者番号(any(IHihokenshashoCommonEditData.class));
            doNothing().when(editorBase).set住所(any(IHihokenshashoCommonEditData.class));
            doNothing().when(editorBase).set被保険者名(any(IHihokenshashoCommonEditData.class));
            doNothing().when(editorBase).set交付日(any(IHihokenshashoCommonEditData.class));
            doNothing().when(editorBase).set再交付情報(any(IHihokenshashoCommonEditData.class));
            doNothing().when(editorBase).set保険者番号(any(IHihokenshashoCommonEditData.class));
            return editorBase;
        }

        private NinteiEditorBase createMockNinteiEditor(HihokenshashoModel model) {
            NinteiEditorBase editorBase = spy(new NinteiEditorBase(model));
            doNothing().when(editorBase).set要介護状態区分等(any(IHihokenshashoCommonEditData.class));
            doCallRealMethod().when(editorBase).set認定年月日(any(IHihokenshashoCommonEditData.class));
            doNothing().when(editorBase).set認定有効期間(any(IHihokenshashoCommonEditData.class));
            doNothing().when(editorBase).set居宅サービス(any(IHihokenshashoCommonEditData.class));
            doNothing().when(editorBase).setうち種類支給限度基準額(any(IHihokenshashoCommonEditData.class));
            doNothing().when(editorBase).set認定審査会の意見等(any(IHihokenshashoCommonEditData.class));
            return editorBase;
        }

        private KyufuSeigenEditorBase createMockKyufuSeigenEditor(HihokenshashoModel model, HihokenshashoPrintConfig printConfig) {
            KyufuSeigenEditorBase editorBase = spy(new KyufuSeigenEditorBase(model, printConfig));
            doNothing().when(editorBase).set給付制限(any(IHihokenshashoCommonEditData.class));
            doCallRealMethod().when(editorBase).set居宅介護支援事業者(any(IHihokenshashoCommonEditData.class));
            doNothing().when(editorBase).set介護保険施設等(any(IHihokenshashoCommonEditData.class));
            return editorBase;
        }

        private SeiDoitsuShogaiEditorBase createMockseiDoitsuEditor(HihokenshashoModel model) {
            SeiDoitsuShogaiEditorBase editorBase = spy(new SeiDoitsuShogaiEditorBase(model));
            doNothing().when(editorBase).set性同一障害考慮(any(IHihokenshashoCommonEditData.class));
            return editorBase;
        }

        private GenderEditorA4Base createMockGenderEditor(HihokenshashoModel model) {
            GenderEditorA4Base editorBase = spy(new GenderEditorA4Base(model));
            doNothing().when(editorBase).set性別(any(IHihokenshashoA4CommonEditData.class));
            return editorBase;
        }

        private DateOfBirthEditorA4Base createMockDateOfBirthEditor(HihokenshashoModel model) {
            DateOfBirthEditorA4Base editorBase = spy(new DateOfBirthEditorA4Base(model));
            doNothing().when(editorBase).set生年月日(any(IHihokenshashoA4CommonEditData.class));
            return editorBase;
        }

        private NinteiAndKyotakuShienOutputChecker createChecker(NinteiInput ninteiInput, KyotakuShienInput kyotakuShienInput) {
            NinteiAndKyotakuShienOutputChecker checker = mock(NinteiAndKyotakuShienOutputChecker.class);
            when(checker.is認定情報表示()).thenReturn(ninteiInput.value);
            when(checker.is居宅支援事業者表示()).thenReturn(kyotakuShienInput.value);
            return checker;
        }

        private enum NinteiInput {

            有り(true),
            無し(false);
            private final boolean value;

            private NinteiInput(boolean value) {
                this.value = value;
            }
        }

        private enum KyotakuShienInput {

            有り(true),
            無し(false);
            private final boolean value;

            private KyotakuShienInput(boolean value) {
                this.value = value;
            }
        }

    }

    private static RString toWarekiString(FlexibleDate date) {
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

}
