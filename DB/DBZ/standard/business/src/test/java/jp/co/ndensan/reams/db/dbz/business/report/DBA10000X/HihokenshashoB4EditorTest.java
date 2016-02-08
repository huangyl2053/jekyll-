/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X;

import jp.co.ndensan.reams.db.dbx.definition.core.util.Lists;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.jushohenshu.ChohyoKyotsuJushoEditConfig;
import jp.co.ndensan.reams.db.dbz.business.config.shikaku.HihokenshashoJushoEditConfig;
import jp.co.ndensan.reams.db.dbz.business.config.shikaku.HihokenshashoPrintConfig;
import jp.co.ndensan.reams.db.dbz.business.hihokenshashikakuhakko.HihokenshaShikakuHakkoModel;
import jp.co.ndensan.reams.db.dbz.business.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.DateOfBirthEditorB4Base;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.GenderEditorB4Base;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.KyufuSeigenEditorBase;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.NinteiEditorBase;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.SeiDoitsuShogaiEditorBase;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.ShikakuKihonEditorBase;
import jp.co.ndensan.reams.db.dbz.business.report.NinteiAndKyotakuShienOutputChecker;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.HihokenshashoPrintPosition;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configvalues.HihokenshaNoPrintType;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * {@link jp.co.ndensan.reams.db.dba.business.report.DBA10000X.HihokenshashoB4Editor}のテストです。
 *
 * @author n8178 城間篤人
 */
@Ignore
@RunWith(Enclosed.class)
public class HihokenshashoB4EditorTest {

    private static HihokenshashoB4Editor sut;
    private static HihokenshashoB4 result;

    public static class constructor extends DbzTestBase {

        private HihokenshashoModel model;
        private Association association;

        @Test(expected = NullPointerException.class)
        public void 被保険者証Modelにnullが渡された場合_NullPointerExceptionが発生する() {
            model = null;
            association = mock(Association.class);
            sut = new HihokenshashoB4Editor(model, association);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 全国住所にnullが渡された場合_NullPointerExceptionが発生する() {
            model = mock(HihokenshashoModel.class);
            association = null;
            sut = new HihokenshashoB4Editor(model, association);
            fail();
        }

        @Test(expected = IllegalArgumentException.class)
        public void 被保険者証Modelに設定されている印字位置が_指定無しの場合_IllegalArgumentExceptionが発生する() {
            model = mock(HihokenshashoModel.class);
            when(model.getPosition()).thenReturn(HihokenshashoPrintPosition.指定無し);
            association = null;
            sut = new HihokenshashoB4Editor(model, association);
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
        public void 印字位置に上部が指定されていた場合_帳票ソースの上部の被保険者証に含まれている項目に値が入る() {
            HihokenshashoModel model = createMockModel(hihokenshaNo, ninteiDate, HihokenshashoPrintPosition.上部, shienJigyosha, todokedeDate);
            sut = createSut(model, createChecker(NinteiInput.有り, KyotakuShienInput.有り));
            result = sut.edit(new HihokenshashoB4());
            assertThat(result.hihokenshanno1, is(hihokenshaNo));
        }

        @Test
        public void 印字位置に上部が指定されていた場合_帳票ソースの下部の被保険者証に含まれている項目には値が入らない() {
            HihokenshashoModel model = createMockModel(hihokenshaNo, ninteiDate, HihokenshashoPrintPosition.上部, shienJigyosha, todokedeDate);
            sut = createSut(model, createChecker(NinteiInput.有り, KyotakuShienInput.有り));
            result = sut.edit(new HihokenshashoB4());
            assertThat(result.hihokenshanno2, is(nullValue()));
        }

        @Test
        public void 印字位置に下部が指定されていた場合_帳票ソースの上部の被保険者証に含まれている項目には値が入らない() {
            HihokenshashoModel model = createMockModel(hihokenshaNo, ninteiDate, HihokenshashoPrintPosition.下部, shienJigyosha, todokedeDate);
            sut = createSut(model, createChecker(NinteiInput.有り, KyotakuShienInput.有り));
            result = sut.edit(new HihokenshashoB4());
            assertThat(result.hihokenshanno1, is(nullValue()));
        }

        @Test
        public void 印字位置に下部が指定されていた場合_帳票ソースの下部の被保険者証に含まれている項目に値が入る() {
            HihokenshashoModel model = createMockModel(hihokenshaNo, ninteiDate, HihokenshashoPrintPosition.下部, shienJigyosha, todokedeDate);
            sut = createSut(model, createChecker(NinteiInput.有り, KyotakuShienInput.有り));
            result = sut.edit(new HihokenshashoB4());
            assertThat(result.hihokenshanno2, is(hihokenshaNo));
        }

        @Test
        public void 印字位置が上部_is認定情報表示がtrueを返す場合_認定情報の設定が行われ_ninteiymd1に値が設定される() {
            HihokenshashoModel model = createMockModel(hihokenshaNo, ninteiDate, HihokenshashoPrintPosition.上部, shienJigyosha, todokedeDate);
            sut = createSut(model, createChecker(NinteiInput.有り, KyotakuShienInput.有り));
            result = sut.edit(new HihokenshashoB4());
            assertThat(result.ninteiymd1, is(toWarekiString(ninteiDate)));
        }

        @Test
        public void 印字位置が上部_is認定情報表示がfalseを返す場合_認定情報の設定は行われず_ninteiymd1は何も設定されない() {
            HihokenshashoModel model = createMockModel(hihokenshaNo, ninteiDate, HihokenshashoPrintPosition.上部, shienJigyosha, todokedeDate);
            sut = createSut(model, createChecker(NinteiInput.無し, KyotakuShienInput.有り));
            result = sut.edit(new HihokenshashoB4());
            assertThat(result.ninteiymd1, is(nullValue()));
        }

        @Test
        public void 印字位置が上部_is居宅支援事業者表示がtrueを返す場合_居宅支援事業者の設定が行われ_gyosha1に値が設定される() {
            HihokenshashoModel model = createMockModel(hihokenshaNo, ninteiDate, HihokenshashoPrintPosition.上部, shienJigyosha, todokedeDate);
            sut = createSut(model, createChecker(NinteiInput.有り, KyotakuShienInput.有り));
            result = sut.edit(new HihokenshashoB4());
            assertThat(result.gyosha1, is(shienJigyosha));
        }

        @Test
        public void 印字位置が上部_is居宅支援事業者表示がfalseを返す場合_認定情報の設定は行われず_gyosha1は何も設定されない() {
            HihokenshashoModel model = createMockModel(hihokenshaNo, ninteiDate, HihokenshashoPrintPosition.上部, shienJigyosha, todokedeDate);
            sut = createSut(model, createChecker(NinteiInput.有り, KyotakuShienInput.無し));
            result = sut.edit(new HihokenshashoB4());
            assertThat(result.gyosha1, is(nullValue()));
        }

        private HihokenshashoB4Editor createSut(HihokenshashoModel model, NinteiAndKyotakuShienOutputChecker checker) {
            return new HihokenshashoB4Editor(
                    model,
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

            DbT1001HihokenshaDaichoEntity daicho = mock(DbT1001HihokenshaDaichoEntity.class);
            when(daicho.getHihokenshaNo()).thenReturn(new HihokenshaNo(hihokenshaNo));

            HihokenshashoModel hihokenshashoModel = mock(HihokenshashoModel.class);
            when(hihokenshashoModel.getShikakuHakko()).thenReturn(shikakuHakko);
            //TODO
//            when(hihokenshashoModel.getHihokenshaDaicho()).thenReturn(daicho);
            when(hihokenshashoModel.getPosition()).thenReturn(印字位置);
            return hihokenshashoModel;
        }

        private HihokenshashoPrintConfig createMockPrintConfig() {
            HihokenshashoPrintConfig printConfigMock = mock(HihokenshashoPrintConfig.class);
            when(printConfigMock.get被保険者番号表示書式()).thenReturn(HihokenshaNoPrintType.そのまま);
            return printConfigMock;
        }

        private ShikakuKihonEditorBase createMockShikakuKihonEditor(HihokenshashoModel model, HihokenshashoPrintConfig printConfig,
                HihokenshashoJushoEditConfig hihoJushoEditConfig, ChohyoKyotsuJushoEditConfig kyotsuJushoEditConfig) {
            Association association = mock(Association.class);
            ShikakuKihonEditorBase editorBase = spy(new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEditConfig, kyotsuJushoEditConfig));
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

        private GenderEditorB4Base createMockGenderEditor(HihokenshashoModel model) {
            GenderEditorB4Base editorBase = spy(new GenderEditorB4Base(model));
            doNothing().when(editorBase).set性別(any(IHihokenshashoB4CommonEditData.class));
            return editorBase;
        }

        private DateOfBirthEditorB4Base createMockDateOfBirthEditor(HihokenshashoModel model) {
            DateOfBirthEditorB4Base editorBase = spy(new DateOfBirthEditorB4Base(model));
            doNothing().when(editorBase).set生年月日(any(IHihokenshashoB4CommonEditData.class));
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
