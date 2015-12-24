/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.jushohenshu.ChohyoKyotsuJushoEditConfig;
import jp.co.ndensan.reams.db.dbz.business.config.shikaku.HihokenshashoJushoEditConfig;
import jp.co.ndensan.reams.db.dbz.business.config.shikaku.HihokenshashoPrintConfig;
import jp.co.ndensan.reams.db.dbz.business.hihokenshashikakuhakko.HihokenshaShikakuHakkoModel;
import jp.co.ndensan.reams.db.dbz.business.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.HihokenshashoA4;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.HihokenshashoA4EditData;
import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.IHihokenshashoCommonEditData;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configvalues.HihokenshaNoPrintType;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase.ShikakuKihonEditorBase}のテストです。
 *
 * @author n8178 城間篤人
 */
@Ignore
@RunWith(Enclosed.class)
public class ShikakuKihonEditorBaseTest {

    private static IHihokenshashoCommonEditData target;
    private static ShikakuKihonEditorBase sut;
    private static HihokenshashoModel model;
    private static Association association;
    private static HihokenshashoPrintConfig printConfig;
    private static HihokenshashoJushoEditConfig hihoJushoEdit;
    private static ChohyoKyotsuJushoEditConfig kyotsuJushoEdit;

    public static class constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 被保険者証Modelにnullが渡された場合_NullPointerExceptionが発生する() {
            model = null;
            association = mock(Association.class);
            printConfig = mock(HihokenshashoPrintConfig.class);
            hihoJushoEdit = mock(HihokenshashoJushoEditConfig.class);
            kyotsuJushoEdit = mock(ChohyoKyotsuJushoEditConfig.class);
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 全国住所にnullが渡された場合_NullPointerExceptionが発生する() {
            model = mock(HihokenshashoModel.class);
            association = null;
            printConfig = mock(HihokenshashoPrintConfig.class);
            hihoJushoEdit = mock(HihokenshashoJushoEditConfig.class);
            kyotsuJushoEdit = mock(ChohyoKyotsuJushoEditConfig.class);
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者証表示方法コンフィグにnullが渡された場合_NullPointerExceptionが発生する() {
            model = mock(HihokenshashoModel.class);
            association = mock(Association.class);
            printConfig = null;
            hihoJushoEdit = mock(HihokenshashoJushoEditConfig.class);
            kyotsuJushoEdit = mock(ChohyoKyotsuJushoEditConfig.class);
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者証住所編集方法コンフィグにnullが渡された場合_NullPointerExceptionが発生する() {
            model = mock(HihokenshashoModel.class);
            association = mock(Association.class);
            printConfig = mock(HihokenshashoPrintConfig.class);
            hihoJushoEdit = null;
            kyotsuJushoEdit = mock(ChohyoKyotsuJushoEditConfig.class);
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 帳票共通住所編集方法コンフィグにnullが渡された場合_NullPointerExceptionが発生する() {
            model = mock(HihokenshashoModel.class);
            association = mock(Association.class);
            printConfig = mock(HihokenshashoPrintConfig.class);
            hihoJushoEdit = mock(HihokenshashoJushoEditConfig.class);
            kyotsuJushoEdit = null;
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
            fail();
        }
    }

    public static class set被保険者番号 extends DbzTestBase {

        private RString hihoNoStringZero;
        private RString hihoNoStringSpace;

        @Before
        public void setUp() {
            target = createTarget();

            hihoNoStringZero = new RString("0000012345");
            hihoNoStringSpace = new RString("     12345");

            model = createMockModel(hihoNoStringZero);
            association = mock(Association.class);
            hihoJushoEdit = mock(HihokenshashoJushoEditConfig.class);
            kyotsuJushoEdit = mock(ChohyoKyotsuJushoEditConfig.class);
        }

        @Test
        public void 被保険者番号表示書式が_前ゼロをスペースに変換の場合_被保険者番号の前ゼロがスペースに変換されて_Hihokenshannoに設定される() {
            printConfig = createMockPrintConfig(HihokenshaNoPrintType.前ゼロをスペースに変換);
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);

            sut.set被保険者番号(target);
            assertThat(target.getHihokenshanno(), is(hihoNoStringSpace));
        }

        @Test
        public void 被保険者番号表示書式が_そのままの場合_被保険者番号の前ゼロがスペースに変換されて_Hihokenshannoに設定される() {
            printConfig = createMockPrintConfig(HihokenshaNoPrintType.そのまま);
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);

            sut.set被保険者番号(target);
            assertThat(target.getHihokenshanno(), is(hihoNoStringZero));
        }

        private HihokenshashoModel createMockModel(RString hihoNo) {
            DbT1001HihokenshaDaichoEntity daicho = mock(DbT1001HihokenshaDaichoEntity.class);
            when(daicho.getHihokenshaNo()).thenReturn(new HihokenshaNo(hihoNo));
            HihokenshashoModel hihokenshashoModel = mock(HihokenshashoModel.class);
            // TODO
//            when(hihokenshashoModel.getHihokenshaDaicho()).thenReturn(daicho);
            return hihokenshashoModel;
        }

        private HihokenshashoPrintConfig createMockPrintConfig(HihokenshaNoPrintType 被保険者番号表示書式) {
            HihokenshashoPrintConfig printConfig = mock(HihokenshashoPrintConfig.class);
            when(printConfig.get被保険者番号表示書式()).thenReturn(被保険者番号表示書式);
            return printConfig;
        }
    }

    //TODO n8178 城間篤人 住所編集の方法を確認できた後に改めて修正する。　2015年2月末
    public static class 住所の表示切替 extends DbzTestBase {

        @Test
        public void dummy() {

        }
//
//        private YubinNo yubinNo;
//        private RString gyoseiku;
//        private RString kannaiJusho;
//        private RString kangaiJusho;
//        private AtenaBanchi banchi;
//
//        @Before
//        public void setUp() {
//            target = createTarget();
//
//            printConfig = createMockPrintConfig(YubinNoInput.有り);
//            hihoJushoEdit = createMockHihoJushoEditConfig(true, TodofukenNamePrint.印字する, GunNamePrint.印字する, ShichosonNamePrint.印字する, HowToEditJusho.住所と番地, KatagakiPrint.印字する);
//            kyotsuJushoEdit = createMockKyotsuJushoEditConfig(TodofukenNamePrint.印字する, GunNamePrint.印字する, ShichosonNamePrint.印字する, HowToEditJusho.住所と番地, KatagakiPrint.印字する);
//
//            yubinNo = new YubinNo("900-9999");
//            gyoseiku = new RString("行政区01234567890");
//            kannaiJusho = new RString("りいむす");
//            kangaiJusho = new RString("でんさん県でんさん市りいむす町りいむす１－２－３");
//            banchi = new AtenaBanchi("１－１２－７");
//        }
//
//        @Test
//        public void is郵便番号表示有りがtrueの場合_Yubinnoに郵便番号が設定される() {
//            model = createMockKannaiJushoModel(yubinNo, gyoseiku, kannaiJusho);
//            printConfig = createMockPrintConfig(YubinNoInput.有り);
//            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
//            sut.set住所(target);
//            assertThat(target.getYubinno(), is(yubinNo.getEditedYubinNo()));
//        }
//
//        @Test
//        public void is郵便番号表示有りがfalseの場合_Yubinnoには何も設定されない() {
//            model = createMockKannaiJushoModel(yubinNo, gyoseiku, kannaiJusho);
//            printConfig = createMockPrintConfig(YubinNoInput.無し);
//            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
//            sut.set住所(target);
//            assertThat(target.getYubinno(), is(nullValue()));
//        }
//
//        @Test
//        public void 住所が管内の場合_かつ行政区が13文字以内の場合_Gyoseikuに行政区の情報が入る() {
//            model = createMockKannaiJushoModel(yubinNo, gyoseiku, kannaiJusho);
//            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
//            sut.set住所(target);
//            assertThat(target.getGyoseiku(), is(gyoseiku));
//        }
//
//        @Test
//        public void 住所が管内の場合_かつ行政区が13文字以内の場合_GyoseikuSには何も設定されない() {
//            model = createMockKannaiJushoModel(yubinNo, gyoseiku, kannaiJusho);
//            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
//            sut.set住所(target);
//            assertThat(target.getGyoseikuS(), is(nullValue()));
//        }
//
//        @Test
//        public void 住所が管内の場合_かつ行政区が14文字以上の場合_Gyoseikuには何も設定されない() {
//            gyoseiku = new RString("行政区012345678901");
//            model = createMockKannaiJushoModel(yubinNo, gyoseiku, kannaiJusho);
//            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
//            sut.set住所(target);
//            assertThat(target.getGyoseiku(), is(nullValue()));
//        }
//
//        @Test
//        public void 住所が管内の場合_かつ行政区が14文字以上の場合_GyoseikuSに行政区の情報が入る() {
//            gyoseiku = new RString("行政区012345678901");
//            model = createMockKannaiJushoModel(yubinNo, gyoseiku, kannaiJusho);
//            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
//            sut.set住所(target);
//            assertThat(target.getGyoseikuS(), is(gyoseiku));
//        }
//
//        @Test
//        public void 住所が管外の場合_Gyoseikuには何も設定されない() {
//            model = createMockKangaiJushoModel(yubinNo, gyoseiku, kannaiJusho);
//            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
//            sut.set住所(target);
//            assertThat(target.getGyoseiku(), is(nullValue()));
//        }
//
//        @Test
//        public void 住所が管外の場合_GyoseikuSには何も設定されない() {
//            model = createMockKangaiJushoModel(yubinNo, gyoseiku, kannaiJusho);
//            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
//            sut.set住所(target);
//            assertThat(target.getGyoseikuS(), is(nullValue()));
//        }
//
//        //TODO
//        //1, 以下の業務コンフィグを取得する。
//        //  DBA業務コンフィグ
//        //      被保険者証表示方法_管内住所編集_帳票独自区分
//        //      被保険者証表示方法_管内住所編集_都道府県名付与有無
//        //      被保険者証表示方法_管内住所編集_群名付与有無
//        //      被保険者証表示方法_管内住所編集_市町村名付与有無
//        //      被保険者証表示方法_管内住所編集_編集方法
//        //      被保険者証表示方法_管内住所編集_方書表示有無
//        //  DBU業務コンフィグ
//        //      帳票共通住所編集方法_管内住所編集_都道府県名付与有無
//        //      帳票共通住所編集方法_管内住所編集_群名付与有無
//        //      帳票共通住所編集方法_管内住所編集_市町村名付与有無
//        //      帳票共通住所編集方法_管内住所編集_編集方法
//        //      帳票共通住所編集方法_管内住所編集_方書表示有無
//        //2, 以下のテストを行う。
//        //  2-1, 被保険者証表示方法_管内住所編集_帳票独自区分が1の場合
//        //       帳票独自区分が1の場合、DBAスタンダードコンフィグの値が判定で使用される。
//        //      2-1-1, 被保険者証表示方法_管内住所編集_都道府県名付与有無
//        //          2-1-1-1, 都道府県名付与有無が1の場合、住所に都道府県の情報が追加される。
//        //          2-1-1-2, 都道府県名付与有無が0の場合、住所に都道府県の情報を付与しない。
//        //      2-1-2, 被保険者証表示方法_管内住所編集_群名付与有無
//        //          2-1-2-1, 群名付与有無が1の場合、住所に群名の情報が追加される。
//        //          2-1-2-2, 群名付与有無が0の場合、住所に群名の情報を付与しない。
//        //      2-1-3, 被保険者証表示方法_管内住所編集_市町村名付与有無
//        //          2-1-3-1, 市町村名付与有無が1の場合、住所に市町村名の情報が追加される。
//        //          2-1-3-2, 市町村名付与有無が0の場合、住所に市町村名の情報を付与しない。
//        //      2-1-4, 被保険者証表示方法_管内住所編集_編集方法
//        //          2-1-4-1, 編集方法が1の場合、[住所＋番地]というように住所を編集する。
//        //          2-1-4-2, 編集方法が2の場合、[行政区＋番地]というように住所を編集する。
//        //          2-1-4-3, 編集方法が3の場合、[住所＋番地、（行政区）]というように住所を編集する。
//        //          2-1-4-4, 編集方法が4の場合、[番地]のみを住所に持つ。
//        //          2-1-4-5, 編集方法が5の場合、住所は印字されない（EMPTYになる）。
//        //      2-1-5, 被保険者証表示方法_管内住所編集_方書表示有無
//        //          2-1-5-1, 方書表示有無が1の場合、住所に方書の情報が追加される。
//        //          2-1-5-2, 方書表示有無が0の場合、住所に方書の情報を付与しない。
//        //  2-2, 被保険者証表示方法_管内住所編集_帳票独自区分が0の場合
//        //       帳票独自区分が0の場合、DBUスタンダードコンフィグの値が判定で使用される。
//        //      2-2-1, 帳票共通住所編集方法_管内住所編集_都道府県名付与有無
//        //          2-2-1-1, 都道府県名付与有無が1の場合、住所に都道府県の情報が追加される。
//        //          2-2-1-2, 都道府県名付与有無が0の場合、住所に都道府県の情報を付与しない。
//        //      2-2-2, 帳票共通住所編集方法_管内住所編集_群名付与有無
//        //          2-2-2-1, 群名付与有無が1の場合、住所に群名の情報が追加される。
//        //          2-2-2-2, 群名付与有無が0の場合、住所に群名の情報を付与しない。
//        //      2-2-3, 帳票共通住所編集方法_管内住所編集_市町村名付与有無
//        //          2-2-3-1, 市町村名付与有無が1の場合、住所に市町村名の情報が追加される。
//        //          2-2-3-2, 市町村名付与有無が0の場合、住所に市町村名の情報を付与しない。
//        //      2-2-4, 帳票共通住所編集方法_管内住所編集_編集方法
//        //          2-2-4-1, 編集方法が1の場合、[住所＋番地]というように住所を編集する。
//        //          2-2-4-2, 編集方法が2の場合、[行政区＋番地]というように住所を編集する。
//        //          2-2-4-3, 編集方法が3の場合、[住所＋番地、（行政区）]というように住所を編集する。
//        //          2-2-4-4, 編集方法が4の場合、[番地]のみを住所に持つ。
//        //          2-2-4-5, 編集方法が5の場合、住所は印字されない（EMPTYになる）。
//        //      2-2-5, 帳票共通住所編集方法_管内住所編集_方書表示有無
//        //          2-2-5-1, 方書表示有無が1の場合、住所に方書の情報が追加される。
//        //          2-2-5-2, 方書表示有無が0の場合、住所に方書の情報を付与しない。
//        private HihokenshashoModel createMockKannaiJushoModel(YubinNo yubinNo, RString gyoseikuStr, RString jushoStr) {
//            IBanchi banchi = mock(IBanchi.class);
//            when(banchi.getBanchi()).thenReturn(new AtenaBanchi("１－１２－７"));
//
//            IJusho jusho = mock(IJusho.class);
//            when(jusho.get郵便番号()).thenReturn(yubinNo);
//            when(jusho.get住所()).thenReturn(jushoStr);
//            when(jusho.get全国住所コード()).thenReturn(null);
//            when(jusho.get方書()).thenReturn(null);
//            when(jusho.get番地()).thenReturn(banchi);
//            when(jusho.get管内管外()).thenReturn(KannaiKangai.管内);
//            when(jusho.get行政区()).thenReturn(gyoseikuStr);
//            IKojin kojin = mock(IKojin.class);
//            when(kojin.get住所()).thenReturn(jusho);
//            HihokenshashoModel hihokenshashoModel = mock(HihokenshashoModel.class);
//            when(hihokenshashoModel.getKojinJoho()).thenReturn(kojin);
//            return hihokenshashoModel;
//        }
//
//        private HihokenshashoModel createMockKannaiJushoShosaiEditModel(YubinNo yubinNo, RString gyoseikuStr, RString jushoStr) {
//            IBanchi banchi = mock(IBanchi.class);
//            when(banchi.getBanchi()).thenReturn(new AtenaBanchi("１－１２－７"));
//
//            IJusho jusho = mock(IJusho.class);
//            when(jusho.get郵便番号()).thenReturn(yubinNo);
//            when(jusho.get住所()).thenReturn(jushoStr);
//            when(jusho.get全国住所コード()).thenReturn(null);
//            when(jusho.get方書()).thenReturn(null);
//            when(jusho.get番地()).thenReturn(banchi);
//            when(jusho.get管内管外()).thenReturn(KannaiKangai.管内);
//            when(jusho.get行政区()).thenReturn(gyoseikuStr);
//            IKojin kojin = mock(IKojin.class);
//            when(kojin.get住所()).thenReturn(jusho);
//            HihokenshashoModel hihokenshashoModel = mock(HihokenshashoModel.class);
//            when(hihokenshashoModel.getKojinJoho()).thenReturn(kojin);
//            return hihokenshashoModel;
//        }
//
//        private HihokenshashoModel createMockKangaiJushoModel(YubinNo yubinNo, RString gyoseikuStr, RString jushoStr) {
//            IJusho jusho = mock(IJusho.class);
//            when(jusho.get郵便番号()).thenReturn(yubinNo);
//            when(jusho.get住所()).thenReturn(jushoStr);
//            when(jusho.get全国住所コード()).thenReturn(null);
//            when(jusho.get方書()).thenReturn(null);
//            when(jusho.get町域コード()).thenReturn(null);
//            when(jusho.get番地()).thenReturn(null);
//            when(jusho.get管内管外()).thenReturn(KannaiKangai.管外);
//            when(jusho.get行政区()).thenReturn(gyoseikuStr);
//            IKojin kojin = mock(IKojin.class);
//            when(kojin.get住所()).thenReturn(jusho);
//            HihokenshashoModel hihokenshashoModel = mock(HihokenshashoModel.class);
//            when(hihokenshashoModel.getKojinJoho()).thenReturn(kojin);
//            return hihokenshashoModel;
//        }
//
//        private HihokenshashoPrintConfig createMockPrintConfig(YubinNoInput yubinNoInput) {
//            HihokenshashoPrintConfig printConfig = mock(HihokenshashoPrintConfig.class);
//            when(printConfig.is郵便番号表示有り()).thenReturn(yubinNoInput.getValue());
//            return printConfig;
//        }
//
//        private HihokenshashoJushoEditConfig createMockHihoJushoEditConfig(boolean is帳票独自区分を使用, TodofukenNamePrint todofuken,
//                GunNamePrint gunName, ShichosonNamePrint shichosonName, HowToEditJusho howToEditJusho, KatagakiPrint katagaki) {
//            HihokenshashoJushoEditConfig editConfig = mock(HihokenshashoJushoEditConfig.class);
//            when(editConfig.uses帳票独自区分()).thenReturn(is帳票独自区分を使用);
//            when(editConfig.get都道府県名付与有無()).thenReturn(todofuken);
//            when(editConfig.get郡名付与有無()).thenReturn(gunName);
//            when(editConfig.get市町村名付与有無()).thenReturn(shichosonName);
//            when(editConfig.get住所編集方法()).thenReturn(howToEditJusho);
//            when(editConfig.get方書表示有無()).thenReturn(katagaki);
//            return editConfig;
//        }
//
//        private ChohyoKyotsuJushoEditConfig createMockKyotsuJushoEditConfig(TodofukenNamePrint todofuken,
//                GunNamePrint gunName, ShichosonNamePrint shichosonName, HowToEditJusho howToEditJusho, KatagakiPrint katagaki) {
//            ChohyoKyotsuJushoEditConfig editConfig = mock(ChohyoKyotsuJushoEditConfig.class);
//            when(editConfig.get都道府県名付与有無()).thenReturn(todofuken);
//            when(editConfig.get郡名付与有無()).thenReturn(gunName);
//            when(editConfig.get市町村名付与有無()).thenReturn(shichosonName);
//            when(editConfig.get住所編集方法()).thenReturn(howToEditJusho);
//            when(editConfig.get方書表示有無()).thenReturn(katagaki);
//            return editConfig;
//        }
//
//        private enum YubinNoInput {
//
//            有り(true),
//            無し(false);
//            private final boolean value;
//
//            private YubinNoInput(boolean value) {
//                this.value = value;
//            }
//
//            public boolean getValue() {
//                return value;
//            }
//        }
    }

    public static class set被保険者名 extends DbzTestBase {

        private RString name;
        private RString nameKana;

        @Before
        public void setUp() {
            target = createTarget();

            name = new RString("田中 プルートゥ");
            nameKana = new RString("ﾀﾅｶ ﾌﾟﾙｰﾄｩ");

            model = createMockModel(name, nameKana);
            association = mock(Association.class);
            hihoJushoEdit = mock(HihokenshashoJushoEditConfig.class);
            kyotsuJushoEdit = mock(ChohyoKyotsuJushoEditConfig.class);
        }

        @Test
        public void is氏名カナ表示有りがtrueの場合_Hihokanaにカナ氏名が設定される() {
            printConfig = createMockPrintConfig(true);
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);

            sut.set被保険者名(target);
            assertThat(target.getHihokana(), is(nameKana));
        }

        @Test
        public void is氏名カナ表示有りがfalseの場合_Hihokanaに空文字が設定される() {
            printConfig = createMockPrintConfig(false);
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);

            sut.set被保険者名(target);
            assertThat(target.getHihokana(), is(RString.EMPTY));
        }

        @Test
        public void Hihonameに氏名が設定される() {
            printConfig = createMockPrintConfig(false);
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);

            sut.set被保険者名(target);
            assertThat(target.getHihoname(), is(name));
        }

        private HihokenshashoModel createMockModel(RString nameStr, RString kanaNameStr) {
            IName mockName = mock(IName.class);
            when(mockName.getName()).thenReturn(new AtenaMeisho(nameStr));
            when(mockName.getKana()).thenReturn(new AtenaKanaMeisho(kanaNameStr));
            IKojin kojin = mock(IKojin.class);
            when(kojin.get名称()).thenReturn(mockName);
            HihokenshashoModel hihokenshashoModel = mock(HihokenshashoModel.class);
            when(hihokenshashoModel.getKojinJoho()).thenReturn(kojin);
            return hihokenshashoModel;
        }

        private HihokenshashoPrintConfig createMockPrintConfig(boolean is氏名カナ表示有り) {
            HihokenshashoPrintConfig printConfig = mock(HihokenshashoPrintConfig.class);
            when(printConfig.is氏名カナ表示有り()).thenReturn(is氏名カナ表示有り);
            return printConfig;
        }
    }

    public static class set交付日 extends DbzTestBase {

        private FlexibleDate kofuDate;
        private RString gengoStr;
        private RString nendoStr;
        private RString monthStr;
        private RString dayStr;

        @Before
        public void setUp() {
            target = createTarget();
            kofuDate = new FlexibleDate("20150107");
            gengoStr = new RString("平成");
            nendoStr = new RString("27");
            monthStr = new RString(" 1");
            dayStr = new RString(" 7");

            model = createMockModel(kofuDate);
            association = mock(Association.class);
            printConfig = mock(HihokenshashoPrintConfig.class);
            hihoJushoEdit = mock(HihokenshashoJushoEditConfig.class);
            kyotsuJushoEdit = mock(ChohyoKyotsuJushoEditConfig.class);
        }

        @Test
        public void 発効日が2015年01月07日の場合_KofuymdGengoに平成が設定される() {
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
            sut.set交付日(target);
            assertThat(target.getKofuymdGengo(), is(gengoStr));
        }

        @Test
        public void 発効日が2015年01月07日の場合_KofuymdYyに27が設定される() {
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
            sut.set交付日(target);
            assertThat(target.getKofuymdYy(), is(nendoStr));
        }

        @Test
        public void 発効日が2015年01月07日の場合_KofuymdMmに_1が設定される() {
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
            sut.set交付日(target);
            assertThat(target.getKofuymdMm(), is(monthStr));
        }

        @Test
        public void 発効日が2015年01月07日の場合_KofuymdDdに_7が設定される() {
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
            sut.set交付日(target);
            assertThat(target.getKofuymdDd(), is(dayStr));
        }

        private HihokenshashoModel createMockModel(FlexibleDate kofuDateStr) {
            HihokenshaShikakuHakkoModel shikakuHakko = mock(HihokenshaShikakuHakkoModel.class);
            when(shikakuHakko.get交付日()).thenReturn(kofuDateStr);
            HihokenshashoModel hihokenshashoModel = mock(HihokenshashoModel.class);
            when(hihokenshashoModel.getShikakuHakko()).thenReturn(shikakuHakko);
            return hihokenshashoModel;
        }
    }

    public static class set再交付情報 extends DbzTestBase {

        private RString otherJiyu;
        private RString saikofuJiyu;
        private final RString saikofuText = new RString("再交付");

        @Before
        public void setUp() {
            target = createTarget();
            //TODO n8178 城間 DBAのコードマスタに対応するEnumをkyotsu-productにて作成後、Enumから値を取得するように修正。 2015年1月8日
            otherJiyu = new RString("01");
            saikofuJiyu = new RString("90");

            association = mock(Association.class);
            printConfig = mock(HihokenshashoPrintConfig.class);
            hihoJushoEdit = mock(HihokenshashoJushoEditConfig.class);
            kyotsuJushoEdit = mock(ChohyoKyotsuJushoEditConfig.class);
        }

        @Test
        public void 交付事由が再交付の場合_Saikofu1に再交付が設定される() {
            HihokenshashoModel model = createMockModel(saikofuJiyu);
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
            sut.set再交付情報(target);

            assertThat(target.getSaikofu1(), is(saikofuText));
        }

        @Test
        public void 交付事由が再交付の場合_Saikofu2に再交付が設定される() {
            HihokenshashoModel model = createMockModel(saikofuJiyu);
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
            sut.set再交付情報(target);

            assertThat(target.getSaikofu2(), is(saikofuText));
        }

        @Test
        public void 交付事由が再交付以外の場合_Saikofu1に何も設定されない() {
            HihokenshashoModel model = createMockModel(otherJiyu);
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
            sut.set再交付情報(target);

            assertThat(target.getSaikofu1(), is(nullValue()));
        }

        @Test
        public void 交付事由が再交付以外の場合_Saikofu2に何も設定されない() {
            HihokenshashoModel model = createMockModel(otherJiyu);
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
            sut.set再交付情報(target);

            assertThat(target.getSaikofu2(), is(nullValue()));
        }

        private HihokenshashoModel createMockModel(RString codeValue) {
            HihokenshaShikakuHakkoModel shikakuHakko = mock(HihokenshaShikakuHakkoModel.class);
            when(shikakuHakko.get交付事由コード()).thenReturn(codeValue);
            HihokenshashoModel hihokenshashoModel = mock(HihokenshashoModel.class);
            when(hihokenshashoModel.getShikakuHakko()).thenReturn(shikakuHakko);
            return hihokenshashoModel;
        }
    }

    public static class set保険者番号 extends DbzTestBase {

        private RString hokenshaNo;

        @Before
        public void setUp() {
            target = createTarget();
            //TODO n8178 城間 DBAのコードマスタに対応するEnumをkyotsu-productにて作成後、Enumから値を取得するように修正。 2015年1月8日
            hokenshaNo = new RString("123456");

            association = mock(Association.class);
            printConfig = mock(HihokenshashoPrintConfig.class);
            hihoJushoEdit = mock(HihokenshashoJushoEditConfig.class);
            kyotsuJushoEdit = mock(ChohyoKyotsuJushoEditConfig.class);
        }

        @Test
        public void 保険者番号の1桁目が_Hokenshano1に設定される() {
            model = createMockModel(hokenshaNo);
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
            sut.set保険者番号(target);

            assertThat(target.getHokenshano1(), is(hokenshaNo.stringAt(0)));
        }

        @Test
        public void 保険者番号の2桁目が_Hokenshano2に設定される() {
            HihokenshashoModel model = createMockModel(hokenshaNo);
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
            sut.set保険者番号(target);

            assertThat(target.getHokenshano2(), is(hokenshaNo.stringAt(1)));
        }

        @Test
        public void 保険者番号の3桁目が_Hokenshano3に設定される() {
            HihokenshashoModel model = createMockModel(hokenshaNo);
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
            sut.set保険者番号(target);

            assertThat(target.getHokenshano3(), is(hokenshaNo.stringAt(2)));
        }

        @Test
        public void 保険者番号の4桁目が_Hokenshano4に設定される() {
            HihokenshashoModel model = createMockModel(hokenshaNo);
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
            sut.set保険者番号(target);

            assertThat(target.getHokenshano4(), is(hokenshaNo.stringAt(3)));
        }

        @Test
        public void 保険者番号の5桁目が_Hokenshano5に設定される() {
            HihokenshashoModel model = createMockModel(hokenshaNo);
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
            sut.set保険者番号(target);

            assertThat(target.getHokenshano5(), is(hokenshaNo.stringAt(4)));
        }

        @Test
        public void 保険者番号の6桁目が_Hokenshano6に設定される() {
            HihokenshashoModel model = createMockModel(hokenshaNo);
            sut = new ShikakuKihonEditorBase(model, association, printConfig, hihoJushoEdit, kyotsuJushoEdit);
            sut.set保険者番号(target);

            assertThat(target.getHokenshano6(), is(hokenshaNo.stringAt(5)));
        }

        private HihokenshashoModel createMockModel(RString hokenshaNo) {
            HihokenshaShikakuHakkoModel shikakuHakko = mock(HihokenshaShikakuHakkoModel.class);
            when(shikakuHakko.get保険者番号()).thenReturn(hokenshaNo);
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
