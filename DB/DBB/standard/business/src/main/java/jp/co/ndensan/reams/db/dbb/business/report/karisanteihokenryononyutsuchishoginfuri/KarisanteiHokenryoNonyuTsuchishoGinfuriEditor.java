/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishoginfuri;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.NotsuReportEditorUtil;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriSource;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKoza;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;

/**
 *
 * 帳票設計_DBBRP00007_3_保険料納入通知書（仮算定）【銀振タイプ】KarisanteiHokenryoNonyuTsuchishoGinfuriEditor
 *
 * @reamsid_L DBB-9110-030 wangjie2
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class KarisanteiHokenryoNonyuTsuchishoGinfuriEditor implements IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor {

    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT6 = 6;
    private static final RString 星2 = new RString("**");
    private static final RString 星10 = new RString("**********");
    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;
    private final EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報;
    private final List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト;
    private final int 連番;

    /**
     * インスタンスを生成します。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @param 納入通知書期情報リスト 納入通知書期情報リスト
     */
    protected KarisanteiHokenryoNonyuTsuchishoGinfuriEditor(
            KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報,
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト) {
        this.仮算定納入通知書情報 = 仮算定納入通知書情報;
        this.編集後仮算定通知書共通情報 = null == 仮算定納入通知書情報.get編集後仮算定通知書共通情報()
                ? new EditedKariSanteiTsuchiShoKyotsu() : 仮算定納入通知書情報.get編集後仮算定通知書共通情報();
        this.納入通知書期情報リスト = 納入通知書期情報リスト;
        this.連番 = 仮算定納入通知書情報.get連番();
    }

    @Override
    public KarisanteiHokenryoNonyuTsuchishoGinfuriSource edit(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        EditedKojin 編集後個人 = 編集後仮算定通知書共通情報.get編集後個人();
        EditedKoza 編集後口座 = 編集後仮算定通知書共通情報.get編集後口座();
        if (編集後個人 != null) {
            editHihokenshaName(source, 編集後個人);
            editSetaiCode(source, 編集後個人);
            editSetaiNushiName(source, 編集後個人);
        }
        if (編集後口座 != null) {
            editBankCode(source, 編集後口座);
            editBankName(source, 編集後口座);
            editKozaMeigi(source, 編集後口座);
            editKozaShurui(source, 編集後口座);
            editkozaNo(source, 編集後口座);
        }
        editHokenryoGaku(source);
        editHokenshaName(source);
        editHyojicode1(source);
        editHyojicode13(source);
        editHyojicode2(source);
        editHyojicodeName1(source);
        editHyojicodeName2(source);
        editHyojicodeName3(source);
        editNendo1(source);
        editRyoshushoNendo(source);
        editSanteiKisoGenmenGaku(source);
        if (仮算定納入通知書情報.get出力期リスト() != null && !仮算定納入通知書情報.get出力期リスト().isEmpty()) {
            editSanteiKisoKiTitle1(source);
            editSanteiKisoZanteikiHokenryoGaku1(source);
            editSanteiKisoKiTitle2(source);
            editSanteiKisoZanteikiHokenryoGaku2(source);
        }
        if (編集後仮算定通知書共通情報.get前年度情報() != null) {
            editSanteiKisoNendo1(source);
            editSanteiKisoShutokuDankai(source);
        }
        if (仮算定納入通知書情報.get算定の基礎() != null) {
            if (仮算定納入通知書情報.get算定の基礎().get基礎1() != null) {
                editSanteiKisoNendo2(source);
                editSanteiKisoKomokuTitle1(source);
                editSanteiKisoKinGaku1(source);
                editSanteiKisoYen1(source);
            }
            if (仮算定納入通知書情報.get算定の基礎().get基礎3() != null) {
                editSanteiKisoNendo4(source);
                editSanteiKisoKomokuTitle3(source);
                editSanteiKisoKinGaku3(source);
                editSanteiKisoYen3(source);
            }
            if (仮算定納入通知書情報.get算定の基礎().get基礎2() != null) {
                editSanteiKisoNendo3(source);
                editSanteiKisoKomokuTitle2(source);
                editSanteiKisoKinGaku2(source);
                editSanteiKisoYen2(source);
            }
        }
        editSanteiKisoTokuchoKariGokeiGaku(source);
        editTitleNendo(source);
        editTsuchiKaishiKi(source);
        editTsuchiShuryoKi(source);
        editTsuchishoNo(source);
        editRenban(source);
        editSanteiKisoNokisu(source);
        edit納入通知書期情報(source);
        return source;
    }

    private void editTitleNendo(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        if (null == 編集後仮算定通知書共通情報.get調定年度_年度なし()) {
            return;
        }
        source.titleNendo = RStringUtil.convert半角to全角(編集後仮算定通知書共通情報.get調定年度_年度なし());
    }

    private void editHyojicodeName1(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.hyojicodeName1 = 編集後仮算定通知書共通情報.get表示コード１名();
    }

    private void editHyojicodeName2(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.hyojicodeName2 = 編集後仮算定通知書共通情報.get表示コード２名();
    }

    private void editHyojicodeName3(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.hyojicodeName3 = 編集後仮算定通知書共通情報.get表示コード３名();
    }

    private void editHyojicode1(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.hyojicode1 = 編集後仮算定通知書共通情報.get表示コード1();
    }

    private void editHyojicode2(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.hyojicode2 = 編集後仮算定通知書共通情報.get表示コード２();
    }

    private void editHyojicode13(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.hyojicode3 = 編集後仮算定通知書共通情報.get表示コード３();
    }

    private void editTsuchishoNo(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        if (null == 編集後仮算定通知書共通情報.get通知書番号()) {
            return;
        }
        source.tsuchishoNo = 編集後仮算定通知書共通情報.get通知書番号().getColumnValue();
    }

    private void editSetaiCode(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source, EditedKojin 編集後個人) {
        source.setaiCode = 編集後個人.get世帯コード().getColumnValue();
    }

    private void editHihokenshaName(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source, EditedKojin 編集後個人) {
        source.hihokenshaName = 編集後個人.get名称().getName().getColumnValue();
    }

    private void editSetaiNushiName(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source, EditedKojin 編集後個人) {
        source.setaiNushiName = 編集後個人.get世帯主名().getColumnValue();
    }

    private void editNendo1(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.nendo1 = 編集後仮算定通知書共通情報.get賦課年度_年度なし();
    }

    private void editHokenryoGaku(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        if (null == 編集後仮算定通知書共通情報.get更正後()) {
            return;
        }
        source.hokenryoGaku = NotsuReportEditorUtil
                .get共通ポリシー金額1(編集後仮算定通知書共通情報.get更正後().get更正後介護保険料仮徴収額合計());
    }

    private void editSanteiKisoNendo1(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoNendo1 = 編集後仮算定通知書共通情報.get前年度情報().get前年度賦課年度();
    }

    private void editSanteiKisoShutokuDankai(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        if (編集後仮算定通知書共通情報.get前年度情報().get前年度保険料段階() != null) {
            source.santeiKisoShutokuDankai = RStringUtil.convert半角to全角(編集後仮算定通知書共通情報.get前年度情報().get前年度保険料段階());
        }
    }

    private void editSanteiKisoNendo2(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoNendo2 = 仮算定納入通知書情報.get算定の基礎().get基礎1().get年度();
    }

    private void editSanteiKisoKomokuTitle1(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoKomokuTitle1 = 仮算定納入通知書情報.get算定の基礎().get基礎1().get名称();
    }

    private void editSanteiKisoKinGaku1(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoKinGaku1 = 仮算定納入通知書情報.get算定の基礎().get基礎1().get金額();
    }

    private void editSanteiKisoYen1(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoYen1 = 仮算定納入通知書情報.get算定の基礎().get基礎1().get単位();
    }

    private void editSanteiKisoNendo3(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoNendo3 = 仮算定納入通知書情報.get算定の基礎().get基礎2().get年度();
    }

    private void editSanteiKisoKomokuTitle2(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoKomokuTitle2 = 仮算定納入通知書情報.get算定の基礎().get基礎2().get名称();
    }

    private void editSanteiKisoKinGaku2(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoKinGaku2 = 仮算定納入通知書情報.get算定の基礎().get基礎2().get金額();
    }

    private void editSanteiKisoYen2(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoYen2 = 仮算定納入通知書情報.get算定の基礎().get基礎2().get単位();
    }

    private void editSanteiKisoNendo4(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoNendo4 = 仮算定納入通知書情報.get算定の基礎().get基礎3().get年度();
    }

    private void editSanteiKisoKomokuTitle3(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoKomokuTitle3 = 仮算定納入通知書情報.get算定の基礎().get基礎3().get名称();
    }

    private void editSanteiKisoKinGaku3(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoKinGaku3 = 仮算定納入通知書情報.get算定の基礎().get基礎3().get金額();
    }

    private void editSanteiKisoYen3(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoYen3 = 仮算定納入通知書情報.get算定の基礎().get基礎3().get単位();
    }

    private void editSanteiKisoNokisu(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoNokisu = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴期数()));
    }

    private void editSanteiKisoGenmenGaku(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        if (null == 編集後仮算定通知書共通情報.get更正後()) {
            return;
        }
        source.santeiKisoGenmenGaku = NotsuReportEditorUtil
                .get共通ポリシー金額1(編集後仮算定通知書共通情報.get更正後().get更正後介護保険料減免額());
    }

    private void editSanteiKisoTokuchoKariGokeiGaku(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        if (null == 編集後仮算定通知書共通情報.get更正後()) {
            return;
        }
        source.santeiKisoTokuchoKariGokeiGaku = NotsuReportEditorUtil
                .get共通ポリシー金額1(編集後仮算定通知書共通情報.get更正後().get更正後特徴期別金額合計());
    }

    private void editSanteiKisoKiTitle1(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoKiTitle1 = new RString("第").concat(仮算定納入通知書情報.get出力期リスト().get(0).get期()).concat("期");
    }

    private void editSanteiKisoZanteikiHokenryoGaku1(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        if (null == 編集後仮算定通知書共通情報.get更正後()) {
            return;
        }
        source.santeiKisoZanteikiHokenryoGaku1
                = get金額(編集後仮算定通知書共通情報.get更正後().get更正後普徴期別金額リスト(), 仮算定納入通知書情報.get出力期リスト().get(0).get期AsInt());
    }

    private void editSanteiKisoKiTitle2(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoKiTitle2
                = 仮算定納入通知書情報.get出力期リスト().size() >= 2 ? new RString("次期以降") : RString.EMPTY;
    }

    private void editSanteiKisoZanteikiHokenryoGaku2(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        if (null == 編集後仮算定通知書共通情報.get更正後()) {
            return;
        }
        source.santeiKisoZanteikiHokenryoGaku2 = 仮算定納入通知書情報.get出力期リスト().size() >= 2
                ? get金額(編集後仮算定通知書共通情報.get更正後().get更正後普徴期別金額リスト(), 仮算定納入通知書情報.get出力期リスト().get(1).get期AsInt())
                : RString.EMPTY;
    }

    private void editRyoshushoNendo(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        if (null == 編集後仮算定通知書共通情報.get調定年度_年度なし()) {
            return;
        }
        source.ryoshushoNendo = RStringUtil.convert半角to全角(編集後仮算定通知書共通情報.get調定年度_年度なし());
    }

    private void edit納入通知書期情報(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        boolean 納入通知書期情報1有無 = false;
        boolean 納入通知書期情報2有無 = false;
        boolean 納入通知書期情報3有無 = false;
        boolean 納入通知書期情報4有無 = false;
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            int 銀振印字位置 = 納入通知書期情報.get銀振印字位置();
            switch (銀振印字位置) {
                case 1:
                    set納入通知書期情報1(source, 納入通知書期情報);
                    納入通知書期情報1有無 = true;
                    break;
                case 2:
                    set納入通知書期情報2(source, 納入通知書期情報);
                    納入通知書期情報2有無 = true;
                    break;
                case INT3:
                    set納入通知書期情報3(source, 納入通知書期情報);
                    納入通知書期情報3有無 = true;
                    break;
                case INT4:
                    set納入通知書期情報4(source, 納入通知書期情報);
                    納入通知書期情報4有無 = true;
                    break;
                default:
                    break;
            }
        }
        if (!納入通知書期情報1有無) {
            set納入通知書期情報1無(source);
        }
        if (!納入通知書期情報2有無) {
            set納入通知書期情報2無(source);
        }
        if (!納入通知書期情報3有無) {
            set納入通知書期情報3無(source);
        }
        if (!納入通知書期情報4有無) {
            set納入通知書期情報4無(source);
        }
    }

    private void set納入通知書期情報1(
            KarisanteiHokenryoNonyuTsuchishoGinfuriSource source,
            NonyuTsuchiShoKiJoho 納入通知書期情報) {
        source.ki1 = 納入通知書期情報.get期表記();
        source.tsuki1 = 納入通知書期情報.get月表記();
        source.nokiKaishi1 = 納入通知書期情報.get納期開始日表記();
        source.nokiShuryo1 = 納入通知書期情報.get納期終了日表記();
        source.ryoshushoKi1 = 納入通知書期情報.get領収書日付欄期月();
        source.ryoshushoNofuGaku1 = 納入通知書期情報.get領収証書納付額欄();
        source.ryoshushoNofuin1 = 納入通知書期情報.get領収日付印欄();
        source.ryoshushoRyoshuHizukein1 = 納入通知書期情報.get領収証書領収印欄();
        source.ryoshushoZuiji1 = 納入通知書期情報.get随時表記();
    }

    private void set納入通知書期情報1無(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.ki1 = RString.EMPTY;
        source.tsuki1 = RString.EMPTY;
        source.ryoshushoKi1 = 星2;
        source.ryoshushoNofuGaku1 = 星10;
        source.ryoshushoNofuin1 = 星2;
        source.ryoshushoRyoshuHizukein1 = RString.EMPTY;
        source.ryoshushoZuiji1 = RString.EMPTY;
    }

    private void set納入通知書期情報2(
            KarisanteiHokenryoNonyuTsuchishoGinfuriSource source,
            NonyuTsuchiShoKiJoho 納入通知書期情報) {
        source.ki2 = 納入通知書期情報.get期表記();
        source.tsuki2 = 納入通知書期情報.get月表記();
        source.nokiKaishi2 = 納入通知書期情報.get納期開始日表記();
        source.nokiShuryo2 = 納入通知書期情報.get納期終了日表記();
        source.ryoshushoKi2 = 納入通知書期情報.get領収書日付欄期月();
        source.ryoshushoNofuGaku2 = 納入通知書期情報.get領収証書納付額欄();
        source.ryoshushoNofuin2 = 納入通知書期情報.get領収日付印欄();
        source.ryoshushoRyoshuHizukein2 = 納入通知書期情報.get領収証書領収印欄();
        source.ryoshushoZuiji2 = 納入通知書期情報.get随時表記();
    }

    private void set納入通知書期情報2無(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.ki2 = RString.EMPTY;
        source.tsuki2 = RString.EMPTY;
        source.ryoshushoKi2 = 星2;
        source.ryoshushoNofuGaku2 = 星10;
        source.ryoshushoNofuin2 = 星2;
        source.ryoshushoRyoshuHizukein2 = RString.EMPTY;
        source.ryoshushoZuiji2 = RString.EMPTY;
    }

    private void set納入通知書期情報3(
            KarisanteiHokenryoNonyuTsuchishoGinfuriSource source,
            NonyuTsuchiShoKiJoho 納入通知書期情報) {
        source.ki3 = 納入通知書期情報.get期表記();
        source.tsuki3 = 納入通知書期情報.get月表記();
        source.nokiKaishi3 = 納入通知書期情報.get納期開始日表記();
        source.nokiShuryo3 = 納入通知書期情報.get納期終了日表記();
        source.ryoshushoKi3 = 納入通知書期情報.get領収書日付欄期月();
        source.ryoshushoNofuGaku3 = 納入通知書期情報.get領収証書納付額欄();
        source.ryoshushoNofuin3 = 納入通知書期情報.get領収日付印欄();
        source.ryoshushoRyoshuHizukein3 = 納入通知書期情報.get領収証書領収印欄();
        source.ryoshushoZuiji3 = 納入通知書期情報.get随時表記();
    }

    private void set納入通知書期情報3無(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.ki3 = RString.EMPTY;
        source.tsuki3 = RString.EMPTY;
        source.ryoshushoKi3 = 星2;
        source.ryoshushoNofuGaku3 = 星10;
        source.ryoshushoNofuin3 = 星2;
        source.ryoshushoRyoshuHizukein3 = RString.EMPTY;
        source.ryoshushoZuiji3 = RString.EMPTY;
    }

    private void set納入通知書期情報4(
            KarisanteiHokenryoNonyuTsuchishoGinfuriSource source,
            NonyuTsuchiShoKiJoho 納入通知書期情報) {
        source.ki4 = 納入通知書期情報.get期表記();
        source.tsuki4 = 納入通知書期情報.get月表記();
        source.nokiKaishi4 = 納入通知書期情報.get納期開始日表記();
        source.nokiShuryo4 = 納入通知書期情報.get納期終了日表記();
        source.ryoshushoKi4 = 納入通知書期情報.get領収書日付欄期月();
        source.ryoshushoNofuGaku4 = 納入通知書期情報.get領収証書納付額欄();
        source.ryoshushoNofuin4 = 納入通知書期情報.get領収日付印欄();
        source.ryoshushoRyoshuHizukein4 = 納入通知書期情報.get領収証書領収印欄();
        source.ryoshushoZuiji4 = 納入通知書期情報.get随時表記();
    }

    private void set納入通知書期情報4無(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.ki4 = RString.EMPTY;
        source.tsuki4 = RString.EMPTY;
        source.ryoshushoKi4 = 星2;
        source.ryoshushoNofuGaku4 = 星10;
        source.ryoshushoNofuin4 = 星2;
        source.ryoshushoRyoshuHizukein4 = RString.EMPTY;
        source.ryoshushoZuiji4 = RString.EMPTY;
    }

    private void editBankCode(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source, EditedKoza 編集後口座) {
        source.bankCode = 編集後口座.get金融機関コードCombinedWith支店コード();
    }

    private void editKozaMeigi(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source, EditedKoza 編集後口座) {
        source.kozaMeigi = 編集後口座.get口座名義人優先();
    }

    private void editKozaShurui(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source, EditedKoza 編集後口座) {
        source.kozaShurui = 編集後口座.get口座種別略称();
    }

    private void editkozaNo(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source, EditedKoza 編集後口座) {
        source.kozaNo = 編集後口座.get口座番号Or通帳記号番号();
    }

    private void editBankName(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source, EditedKoza 編集後口座) {
        source.bankName = 編集後口座.get金融機関名CombinedWith支店名();
    }

    private void editTsuchiKaishiKi(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        List<Kitsuki> 出力期リスト = 仮算定納入通知書情報.get出力期リスト();
        if (null == 出力期リスト) {
            return;
        }
        int 最小期 = 出力期リスト.get(0).get期AsInt();
        RString 最小の期 = 出力期リスト.get(0).get期();
        for (Kitsuki 出力期 : 出力期リスト) {
            if (最小期 > 出力期.get期AsInt()) {
                最小期 = 出力期.get期AsInt();
                最小の期 = 出力期.get期();
            }
        }
        source.tsuchiKaishiKi = 最小の期;
    }

    private void editTsuchiShuryoKi(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        List<Kitsuki> 出力期リスト = 仮算定納入通知書情報.get出力期リスト();
        if (null == 出力期リスト) {
            return;
        }
        int 最大期 = 出力期リスト.get(0).get期AsInt();
        RString 最大の期 = 出力期リスト.get(0).get期();
        for (Kitsuki 出力期 : 出力期リスト) {
            if (最大期 < 出力期.get期AsInt()) {
                最大期 = 出力期.get期AsInt();
                最大の期 = 出力期.get期();
            }
        }
        source.tsuchiShuryoKi = 最大の期;
    }

    private void editHokenshaName(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.hokenshaName = 編集後仮算定通知書共通情報.get保険者名();
    }

    private void editRenban(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        RString 連番 = new RString(String.valueOf(this.連番));
        if (ShoriKubun.バッチ.equals(仮算定納入通知書情報.get処理区分())) {
            source.renban = 連番.padLeft("0", INT6);
        } else {
            source.renban = RString.EMPTY;
        }
    }

    private RString get金額(List<UniversalPhase> 更正後普徴期別金額リスト, int 期) {
        if (null == 更正後普徴期別金額リスト) {
            return RString.EMPTY;
        }
        for (UniversalPhase 更正後普徴期別金額 : 更正後普徴期別金額リスト) {
            if (期 == 更正後普徴期別金額.get期()) {
                return NotsuReportEditorUtil.get共通ポリシー金額1(更正後普徴期別金額.get金額());
            }
        }
        return RString.EMPTY;
    }

}
