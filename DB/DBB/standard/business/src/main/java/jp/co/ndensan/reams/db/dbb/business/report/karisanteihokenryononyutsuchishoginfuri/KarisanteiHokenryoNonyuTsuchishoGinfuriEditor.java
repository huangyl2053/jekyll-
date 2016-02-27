/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishoginfuri;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriSource;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;

/**
 *
 * 帳票設計_DBBRP00007_3_保険料納入通知書（仮算定）【銀振タイプ】KarisanteiHokenryoNonyuTsuchishoGinfuriEditor
 */
public class KarisanteiHokenryoNonyuTsuchishoGinfuriEditor implements IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor {

    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;
    private final EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報;
    private final KariSanteiNonyuTsuchiShoSeigyoJoho 仮算定納入通知書制御情報;
    private final NonyuTsuchiShoSeigyoJoho 納入通知書制御情報;
    private final List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト;
    private final int 連番;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KarisanteiHokenryoNonyuTsuchishoGinfuriItem}
     * @param 納入通知書期情報リスト
     * @param 連番
     */
    protected KarisanteiHokenryoNonyuTsuchishoGinfuriEditor(
            KarisanteiHokenryoNonyuTsuchishoGinfuriItem item,
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト,
            int 連番) {
        this.仮算定納入通知書情報 = item.get仮算定納入通知書情報();
        this.編集後仮算定通知書共通情報 = 仮算定納入通知書情報.get編集後仮算定通知書共通情報();
        this.仮算定納入通知書制御情報 = 仮算定納入通知書情報.get仮算定納入通知書制御情報();
        this.納入通知書制御情報 = 仮算定納入通知書制御情報.get納入通知書制御情報();
        this.納入通知書期情報リスト = 納入通知書期情報リスト;
        this.連番 = 連番;
    }

    @Override
    public KarisanteiHokenryoNonyuTsuchishoGinfuriSource edit(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        editBankCode(source);
        editBankName(source);
        editHihokenshaName(source);
        editHokenryoGaku(source);
        editHokenshaName(source);
        editHyojicode1(source);
        editHyojicode13(source);
        editHyojicode2(source);
        editHyojicodeName1(source);
        editHyojicodeName2(source);
        editHyojicodeName3(source);
        editKozaMeigi(source);
        editKozaShurui(source);
        editNendo1(source);
        editRyoshushoNendo(source);
        editSanteiKisoGenmenGaku(source);
        editSanteiKisoKiTitle1(source);
        editSanteiKisoKinGaku1(source);
        editSanteiKisoKinGaku2(source);
        editSanteiKisoKinGaku3(source);
        editSanteiKisoKomokuTitle1(source);
        editSanteiKisoKomokuTitle2(source);
        editSanteiKisoKomokuTitle3(source);
        editSanteiKisoNendo1(source);
        editSanteiKisoNendo2(source);
        editSanteiKisoNendo4(source);
        editSanteiKisoNendo3(source);
        editSanteiKisoShutokuDankai(source);
        editSanteiKisoTokuchoKariGokeiGaku(source);
        editSanteiKisoYen1(source);
        editSanteiKisoYen2(source);
        editSanteiKisoYen3(source);
        editSanteiKisoKiTitle2(source);
        editSanteiKisoZanteikiHokenryoGaku1(source);
        editSanteiKisoZanteikiHokenryoGaku2(source);
        editSetaiCode(source);
        editSetaiNushiName(source);
        editTitleNendo(source);
        editTsuchiKaishiKi(source);
        editTsuchiShuryoKi(source);
        editTsuchishoNo(source);
        editkozaNo(source);
        editRenban(source);
        edit納入通知書期情報(source);
        return source;
    }

    private void editTitleNendo(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.titleNendo = RStringUtil.convert半角to全角(編集後仮算定通知書共通情報.get調定年度_年度なし());
    }

    private void editHyojicodeName1(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.HyojicodeName1 = 編集後仮算定通知書共通情報.get表示コード１名();
    }

    private void editHyojicodeName2(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.HyojicodeName2 = 編集後仮算定通知書共通情報.get表示コード２名();
    }

    private void editHyojicodeName3(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.HyojicodeName3 = 編集後仮算定通知書共通情報.get表示コード３名();
    }

    private void editHyojicode1(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.Hyojicode1 = 編集後仮算定通知書共通情報.get表示コード1();
    }

    private void editHyojicode2(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.Hyojicode2 = 編集後仮算定通知書共通情報.get表示コード２();
    }

    private void editHyojicode13(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.Hyojicode3 = 編集後仮算定通知書共通情報.get表示コード３();
    }

    private void editTsuchishoNo(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.tsuchishoNo = 編集後仮算定通知書共通情報.get通知書番号().getColumnValue();
    }

    private void editSetaiCode(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.setaiCode = null;//TODO 仮算定納入通知書情報.編集後仮算定通知書共通情報.編集後個人.get世帯コード()
    }

    private void editHihokenshaName(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.hihokenshaName = null;//TODO 仮算定納入通知書情報.編集後仮算定通知書共通情報.編集後個人.getName()
    }

    private void editSetaiNushiName(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.setaiNushiName = null;//TODO 仮算定納入通知書情報.編集後仮算定通知書共通情報.編集後個人.get世帯主名()
    }

    private void editNendo1(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.nendo1 = 編集後仮算定通知書共通情報.get賦課年度_年度なし();
    }

    private void editHokenryoGaku(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.hokenryoGaku = new RString(編集後仮算定通知書共通情報.get更正後().get更正後介護保険料仮徴収額合計().toString());
    }

    private void editSanteiKisoNendo1(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoNendo1 = 編集後仮算定通知書共通情報.get前年度情報().get前年度賦課年度();
    }

    private void editSanteiKisoShutokuDankai(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoShutokuDankai = RStringUtil.convert半角to全角(編集後仮算定通知書共通情報.get前年度情報().get前年度保険料段階());
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
        source.santeiKisoGenmenGaku = new RString(編集後仮算定通知書共通情報.get更正後().get更正後介護保険料減免額().toString());
    }

    private void editSanteiKisoTokuchoKariGokeiGaku(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoGenmenGaku = new RString(編集後仮算定通知書共通情報.get更正後().get更正後普徴期別金額合計().toString());
    }

    private void editSanteiKisoKiTitle1(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoKiTitle1 = new RString("第").concat(仮算定納入通知書情報.get出力期リスト().get(0).get期()).concat("期");
    }

    private void editSanteiKisoZanteikiHokenryoGaku1(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoZanteikiHokenryoGaku1
                = get金額(編集後仮算定通知書共通情報.get更正後().get更正後普徴期別金額リスト(), 仮算定納入通知書情報.get出力期リスト().get(0).get期AsInt());
    }

    private void editSanteiKisoKiTitle2(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoKiTitle2
                = 仮算定納入通知書情報.get出力期リスト().size() >= 2 ? new RString("次期以降") : RString.EMPTY;
    }

    private void editSanteiKisoZanteikiHokenryoGaku2(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.santeiKisoZanteikiHokenryoGaku2 = 仮算定納入通知書情報.get出力期リスト().size() >= 2
                ? get金額(編集後仮算定通知書共通情報.get更正後().get更正後普徴期別金額リスト(), 仮算定納入通知書情報.get出力期リスト().get(1).get期AsInt())
                : RString.EMPTY;
    }

    private void editRyoshushoNendo(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
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
                case 3:
                    set納入通知書期情報3(source, 納入通知書期情報);
                    納入通知書期情報3有無 = true;
                    break;
                case 4:
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
        source.ryoshushoKi1 = new RString("**");
        source.ryoshushoNofuGaku1 = new RString("**********");
        source.ryoshushoNofuin1 = new RString("**");
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
        source.ryoshushoKi2 = new RString("**");
        source.ryoshushoNofuGaku2 = new RString("**********");
        source.ryoshushoNofuin2 = new RString("**");
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
        source.ryoshushoKi3 = new RString("**");
        source.ryoshushoNofuGaku3 = new RString("**********");
        source.ryoshushoNofuin3 = new RString("**");
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
        source.ryoshushoKi4 = new RString("**");
        source.ryoshushoNofuGaku4 = new RString("**********");
        source.ryoshushoNofuin4 = new RString("**");
        source.ryoshushoRyoshuHizukein4 = RString.EMPTY;
        source.ryoshushoZuiji4 = RString.EMPTY;
    }

    private void editBankCode(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.bankCode = null;//TODO 編集後口座
    }

    private void editKozaMeigi(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.kozaMeigi = null;//TODO 編集後口座
    }

    private void editKozaShurui(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.kozaNo = null;//TODO 編集後口座
    }

    private void editkozaNo(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.bankCode = null;//TODO 編集後口座
    }

    private void editBankName(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.bankName = null;//TODO 編集後口座
    }

    private void editTsuchiKaishiKi(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        int 最小期 = 0;
        RString 最小の期 = RString.EMPTY;
        List<Kitsuki> 出力期リスト = 仮算定納入通知書情報.get出力期リスト();
        for (Kitsuki 出力期 : 出力期リスト) {
            if (最小期 > 出力期.get期AsInt()) {
                最小期 = 出力期.get期AsInt();
                最小の期 = 出力期.get期();
            }
        }
        source.tsuchiKaishiKi = 最小の期;
    }

    private void editTsuchiShuryoKi(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        int 最大期 = 0;
        RString 最大の期 = RString.EMPTY;
        List<Kitsuki> 出力期リスト = 仮算定納入通知書情報.get出力期リスト();
        for (Kitsuki 出力期 : 出力期リスト) {
            if (最大期 > 出力期.get期AsInt()) {
                最大期 = 出力期.get期AsInt();
                最大の期 = 出力期.get期();
            }
        }
        source.tsuchiShuryoKi = 最大の期;
    }

    private void editHokenshaName(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        source.hokenshaName = new RString(編集後仮算定通知書共通情報.get保険者名().getText());
    }

    private void editRenban(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        RString 連番 = new RString(String.valueOf(this.連番));
        if (ShoriKubun.バッチ.equals(仮算定納入通知書情報.get処理区分())) {
            連番.padLeft(連番, 6);
        }
        source.renban = 連番;
    }

    private RString get金額(List<UniversalPhase> 更正後普徴期別金額リスト, int 期) {
        for (UniversalPhase 更正後普徴期別金額 : 更正後普徴期別金額リスト) {
            if (期 == 更正後普徴期別金額.get期()) {
                return new RString(更正後普徴期別金額.get金額().toString());
            }
        }
        return RString.EMPTY;
    }

}
