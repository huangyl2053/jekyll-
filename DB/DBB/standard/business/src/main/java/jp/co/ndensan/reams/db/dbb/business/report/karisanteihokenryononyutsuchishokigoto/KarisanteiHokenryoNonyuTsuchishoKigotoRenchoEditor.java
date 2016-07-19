/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishokigoto;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.NotsuReportEditorUtil;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NofuShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalSignDeliveryInformation;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NokigenShutsuryokuHoho;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishokigoto.KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource;
import jp.co.ndensan.reams.db.dbz.business.core.kaigosofubutsuatesakisource.KaigoSofubutsuAtesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;

/**
 *
 * 帳票設計_DBBRP00007_2_保険料納入通知書（仮算定）【期毎タイプ】連帳 KarisanteiHokenryoNonyuTsuchishoKigotoRenchoEditor
 *
 * @reamsid_L DBB-9110-020 wangjie2
 */
public class KarisanteiHokenryoNonyuTsuchishoKigotoRenchoEditor implements IKarisanteiHokenryoNonyuTsuchishoKigotoRenchoEditor {

    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;
    private final EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報;
    private final KariSanteiNonyuTsuchiShoSeigyoJoho 仮算定納入通知書制御情報;
    private final NonyuTsuchiShoSeigyoJoho 納入通知書制御情報;
    private final NonyuTsuchiShoKiJoho 納入通知書期情報;
    private final NofuShoKyotsu 納付書共通;
    private final int 連番;
    private final NinshoshaSource ninshoshaSource;
    private final RString 領収書連番;
    private static final int OCR_3 = 3;
    private static final int OCR_4 = 4;
    private static final int 連番_6 = 6;
    private static final int 期_3 = 3;
    private static final int 期_4 = 4;
    private static final int 期_5 = 5;
    private static final int 期_6 = 6;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;

    /**
     * インスタンスを生成します。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @param 連番 連番
     * @param ninshoshaSource 雛形部品CompNinshosha
     * @param 領収書連番 領収書連番
     * @param 納入通知書期情報 納入通知書期情報
     */
    protected KarisanteiHokenryoNonyuTsuchishoKigotoRenchoEditor(
            KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報,
            NonyuTsuchiShoKiJoho 納入通知書期情報,
            int 連番,
            NinshoshaSource ninshoshaSource,
            int 領収書連番) {
        this.仮算定納入通知書情報 = 仮算定納入通知書情報;
        this.編集後仮算定通知書共通情報 = null == 仮算定納入通知書情報.get編集後仮算定通知書共通情報()
                ? new EditedKariSanteiTsuchiShoKyotsu() : 仮算定納入通知書情報.get編集後仮算定通知書共通情報();
        this.仮算定納入通知書制御情報 = null == 仮算定納入通知書情報.get仮算定納入通知書制御情報()
                ? new KariSanteiNonyuTsuchiShoSeigyoJoho() : 仮算定納入通知書情報.get仮算定納入通知書制御情報();
        this.納入通知書制御情報 = null == 仮算定納入通知書制御情報.get納入通知書制御情報()
                ? new NonyuTsuchiShoSeigyoJoho() : 仮算定納入通知書制御情報.get納入通知書制御情報();
        this.納入通知書期情報 = 納入通知書期情報;
        this.納付書共通 = null == 仮算定納入通知書情報.get納付書共通() ? new NofuShoKyotsu() : 仮算定納入通知書情報.get納付書共通();
        this.連番 = 連番;
        this.ninshoshaSource = ninshoshaSource;
        this.領収書連番 = new RString(String.valueOf(領収書連番));
    }

    @Override
    public KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource edit(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        editTitleNendo(source);
        editKi1(source);
        editTsuki1(source);
        editNokiKaishi1(source);
        editNokiShuryo1(source);
        editKi2(source);
        editTsuki2(source);
        editNokiKaishi2(source);
        editNokiShuryo2(source);
        editKi3(source);
        editTsuki3(source);
        editNokiKaishi3(source);
        editNokiShuryo3(source);
        editKi4(source);
        editTsuki4(source);
        editNokiKaishi4(source);
        editNokiShuryo4(source);
        editKi5(source);
        editTsuki5(source);
        editNokiKaishi5(source);
        editNokiShuryo5(source);
        editKi6(source);
        editTsuki6(source);
        editNokiKaishi6(source);
        editNokiShuryo6(source);
        if (編集後仮算定通知書共通情報.get編集後口座() != null) {
            editBankCode(source);
            editKozaMeigi(source);
            editKozaShurui(source);
            editKozaNo(source);
            editBankName(source);
        }
        editHyojicodeName1(source);
        editHyojicodeName2(source);
        editHyojicodeName3(source);
        editHyojiKomoku11(source);
        editHyojiKomoku21(source);
        editHyojiKomoku31(source);
        editHyojicode1(source);
        editHyojicode2(source);
        editHyojicode3(source);
        editTsuchishoNo(source);
        if (編集後仮算定通知書共通情報.get編集後個人() != null) {
            editSetaiCode(source);
            editHihokenshaName(source);
            editSetaiNushiName(source);
        }
        editNendo1(source);
        editHokenryoGaku(source);
        if (編集後仮算定通知書共通情報.get前年度情報() != null) {
            editNendo2(source);
            editShotokuDankai(source);
        }
        if (仮算定納入通知書情報.get算定の基礎() != null) {
            if (仮算定納入通知書情報.get算定の基礎().get基礎1() != null) {
                editNendo3(source);
                editKomokuTitle1(source);
                editSanteiKisoKingaku1(source);
                editYen1(source);
            }
            if (仮算定納入通知書情報.get算定の基礎().get基礎2() != null) {
                editNendo4(source);
                editKomokuTitle2(source);
                editSanteiKisoKingaku2(source);
                editYen2(source);
            }
            if (仮算定納入通知書情報.get算定の基礎().get基礎3() != null) {
                editNendo5(source);
                editKomokuTitle3(source);
                editSanteiKisoKingaku3(source);
                editYen3(source);
            }
        }
        editSanteiKisoKi(source);
        if (編集後仮算定通知書共通情報.get更正後() != null) {
            if (編集後仮算定通知書共通情報.get更正後().get更正後特徴期別金額合計() != null) {
                editSanteiKisoKariGokeiGaku(source);
            }
            if (編集後仮算定通知書共通情報.get更正後().get更正後介護保険料減免額() != null) {
                editSanteiKisoGenmenGaku(source);
            }
        }
        editSanteiKisoKiTitle1(source);
        editSanteiKisoZanteikiHokenryoGaku1(source);
        editSanteiKisoKiTitle2(source);
        editSanteiKisoZanteikiHokenryoGaku2(source);
        editRenban(source);
        editHokenshaName(source);
        editCompNinshosha(source);
        editCompSofubutsuAtesaki(source);
        editDBBCompNofusho(source);
        editDBBCompRyoshusho(source);
        return source;
    }

    private void editDBBCompRyoshusho(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        editRyoshushoGyoseikuName(source);
        editRyoshushoHonninName(source);
        editRyoshushoJusho(source);
        editRyoshushoKakko1(source);
        editRyoshushoKakko2(source);
        editRyoshushoKakko3(source);
        editRyoshushoKanendo(source);
        editRyoshushoKanendobun(source);
        editRyoshushoKatagaki(source);
        editRyoshushoKi(source);
        editRyoshushoNendo(source);
        editRyoshushoNofugaku(source);
        editRyoshushoNofuin(source);
        editRyoshushoNokigen(source);
        editRyoshushoRenban(source);
        editRyoshushoRyoshuHizukein(source);
        editRyoshushoShichosonMei1(source);
        editRyoshushoShichosonMei2(source);
        editRyoshushoSofusakiName(source);
        editRyoshushoTsuchishoNo(source);
        editRyoshushoTsuki(source);
        editRyoshushoYubinNo(source);
        editRyoshushoZuiji(source);
        if (納付書共通.get世帯コード() != null) {
            editRyoshushoSetaiCode(source);
            editRyoshushohyojicode1(source);
            editRyoshushohyojicode2(source);
            editRyoshushohyojicode3(source);
            editRyoshushohyojicodeName1(source);
            editRyoshushohyojicodeName2(source);
            editRyoshushohyojicodeName3(source);
        }
    }

    private void editRyoshushoKanendo(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoKanendo = RString.EMPTY;
    }

    private void editRyoshushoNendo(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (null == 納付書共通.get調定年度表記()) {
            return;
        }
        source.ryoshushoNendo = RStringUtil.convert半角to全角(納付書共通.get調定年度表記());
    }

    private void editRyoshushoKanendobun(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoKanendobun = RString.EMPTY;
    }

    private void editRyoshushoKi(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoKi = 納入通知書期情報.get期表記();
    }

    private void editRyoshushoTsuki(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoTsuki = 納入通知書期情報.get月表記();
    }

    private void editRyoshushoYubinNo(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoYubinNo = 納付書共通.get郵便番号();
    }

    private void editRyoshushoGyoseikuName(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoGyoseikuName = 納付書共通.get行政区名();
    }

    private void editRyoshushoJusho(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoJusho = 納付書共通.get住所();
    }

    private void editRyoshushoKatagaki(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoKatagaki = 納付書共通.get方書();
    }

    private void editRyoshushoSofusakiName(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoSofusakiName = 納付書共通.get納付者氏名();
    }

    private void editRyoshushoKakko1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoKakko1 = RString.isNullOrEmpty(納付書共通.get被代納人氏名()) ? RString.EMPTY : new RString("(");
    }

    private void editRyoshushoHonninName(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoHonninName = 納付書共通.get被代納人氏名();
    }

    private void editRyoshushoKakko2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoKakko2 = RString.EMPTY;
    }

    private void editRyoshushoKakko3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoKakko3
                = RString.isNullOrEmpty(納付書共通.get被代納人氏名()) ? RString.EMPTY : 納付書共通.get被代納人敬称().concat(")");
    }

    private void editRyoshushoTsuchishoNo(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (null == 納付書共通.get通知書番号()) {
            return;
        }
        source.ryoshushoTsuchishoNo = 納付書共通.get通知書番号().getColumnValue();
    }

    private void editRyoshushoSetaiCode(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoSetaiCode = 納付書共通.get世帯コード().getColumnValue();
    }

    private void editRyoshushohyojicodeName1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushohyojicodeName1 = 納付書共通.get表示コード().get表示コード名１();
    }

    private void editRyoshushohyojicode1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushohyojicode1 = 納付書共通.get表示コード().get表示コード１();
    }

    private void editRyoshushohyojicodeName2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushohyojicodeName2 = 納付書共通.get表示コード().get表示コード名２();
    }

    private void editRyoshushohyojicode2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushohyojicode2 = 納付書共通.get表示コード().get表示コード２();
    }

    private void editRyoshushohyojicodeName3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushohyojicodeName3 = 納付書共通.get表示コード().get表示コード名３();
    }

    private void editRyoshushohyojicode3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushohyojicode1 = 納付書共通.get表示コード().get表示コード３();
    }

    private void editRyoshushoNokigen(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoNokigen = 納入通知書期情報.get納期限表記();
    }

    private void editRyoshushoNofugaku(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoNofugaku = 納入通知書期情報.get領収証書納付額欄();
    }

    private void editRyoshushoNofuin(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoNofuin = 納入通知書期情報.get領収日付印欄();
    }

    private void editRyoshushoRyoshuHizukein(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoRyoshuHizukein = 納入通知書期情報.get領収証書領収印欄();
    }

    private void editRyoshushoZuiji(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoZuiji = 納入通知書期情報.get随時表記();
    }

    private void editRyoshushoRenban(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoRenban = 領収書連番;
    }

    private void editRyoshushoShichosonMei1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoShichosonMei1 = 納付書共通.get納付書市町村名();
    }

    private void editRyoshushoShichosonMei2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoShichosonMei2 = RString.EMPTY;
    }

    private void editCompSofubutsuAtesaki(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        EditedAtesaki 編集後宛先 = null == 編集後仮算定通知書共通情報 ? null : 編集後仮算定通知書共通情報.get編集後宛先();
        KaigoSofubutsuAtesakiSource kaigoSofubutsuAtesakiSource = null;
        if (編集後宛先 != null) {
            kaigoSofubutsuAtesakiSource = 編集後宛先.getSofubutsuAtesakiSource();
        }
        if (kaigoSofubutsuAtesakiSource != null) {
            SofubutsuAtesakiSource sofubutsuAtesakiSource = kaigoSofubutsuAtesakiSource.get送付物宛先ソース();
            if (sofubutsuAtesakiSource != null) {
                source.customerBarCode = sofubutsuAtesakiSource.customerBarCode;
                source.dainoKubunMei = sofubutsuAtesakiSource.dainoKubunMei;
                source.gyoseiku1 = sofubutsuAtesakiSource.gyoseiku;
                source.jusho1 = sofubutsuAtesakiSource.jusho1;
                source.jusho2 = sofubutsuAtesakiSource.jusho2;
                source.jusho3 = sofubutsuAtesakiSource.jusho3;
                source.jushoText = sofubutsuAtesakiSource.jushoText;
                source.kakkoLeft1 = sofubutsuAtesakiSource.kakkoLeft1;
                source.kakkoLeft2 = sofubutsuAtesakiSource.kakkoLeft2;
                source.kakkoRight1 = sofubutsuAtesakiSource.kakkoRight1;
                source.kakkoRight2 = sofubutsuAtesakiSource.kakkoRight2;
                source.katagaki1 = sofubutsuAtesakiSource.katagaki1;
                source.katagaki2 = sofubutsuAtesakiSource.katagaki2;
                source.katagakiSmall1 = sofubutsuAtesakiSource.katagakiSmall1;
                source.katagakiSmall2 = sofubutsuAtesakiSource.katagakiSmall2;
                source.katagakiText = sofubutsuAtesakiSource.katagakiText;
                source.meishoFuyo1 = sofubutsuAtesakiSource.meishoFuyo1;
                source.meishoFuyo2 = sofubutsuAtesakiSource.meishoFuyo2;
                source.samaBun1 = sofubutsuAtesakiSource.samaBun1;
                source.samaBun2 = sofubutsuAtesakiSource.samaBun2;
                source.samabunShimei1 = sofubutsuAtesakiSource.samabunShimei1;
                source.samabunShimei2 = sofubutsuAtesakiSource.samabunShimei2;
                source.samabunShimeiSmall1 = sofubutsuAtesakiSource.samabunShimeiSmall1;
                source.samabunShimeiSmall2 = sofubutsuAtesakiSource.samabunShimeiSmall2;
                source.samabunShimeiText = sofubutsuAtesakiSource.samabunShimeiText;
                source.shimei1 = sofubutsuAtesakiSource.shimei1;
                source.shimei2 = sofubutsuAtesakiSource.shimei2;
                source.shimeiSmall1 = sofubutsuAtesakiSource.shimeiSmall1;
                source.shimeiSmall2 = sofubutsuAtesakiSource.shimeiSmall2;
                source.shimeiText = sofubutsuAtesakiSource.shimeiText;
                source.yubinNo1 = sofubutsuAtesakiSource.yubinNo;
                //世帯主名 様方
            }
        }
    }

    private void editDBBCompNofusho(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        editNofushoHonninName1(source);
        editNofushoKakko11(source);
        editNofushoKakko21(source);
        editNofushoKakko31(source);
        editNofushoKanendo1(source);
        editNofushoKanendobun1(source);
        editNofushoKi1(source);
        editNofushoNendo1(source);
        editNofushoNofugaku1(source);
        editNofushoNofuin1(source);
        editNofushoNokigen1(source);
        if (納入通知書期情報.getOcr() != null) {
            editNofushoOcr11(source);
            editNofushoOcr21(source);
            editNofushoOcr31(source);
            editNofushoOcr41(source);
        }
        editNofushoRyoshuHizukein1(source);
        editNofushoSetaiCode1(source);
        editNofushoShichosonMei11(source);
        editNofushoSofusakiName1(source);
        editNofushoTsuchishoNo1(source);
        editNofushoTsuki1(source);
        editNofushoZuiji1(source);
        if (納付書共通.get表示コード() != null) {
            editNofushohyojicode11(source);
            editNofushohyojicode21(source);
            editNofushohyojicode31(source);
            editNofushohyojicodeName11(source);
            editNofushohyojicodeName21(source);
            editNofushohyojicodeName31(source);
        }
    }

    private void editNofushoNendo1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (null == 納付書共通.get調定年度表記()) {
            return;
        }
        source.nofushoNendo1 = RStringUtil.convert半角to全角(納付書共通.get調定年度表記());
    }

    private void editNofushoKanendo1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoKanendo1 = RString.EMPTY;
    }

    private void editNofushoKanendobun1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoKanendobun1 = RString.EMPTY;
    }

    private void editNofushoTsuki1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoTsuki1 = 納入通知書期情報.get月表記();
    }

    private void editNofushoKi1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoKi1 = 納入通知書期情報.get期表記();
    }

    private void editNofushoOcr11(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoOcr11 = 納入通知書期情報.getOcr().get(1);
    }

    private void editNofushoOcr21(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoOcr21 = 納入通知書期情報.getOcr().get(2);
    }

    private void editNofushoOcr31(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoOcr31 = 納入通知書期情報.getOcr().get(OCR_3);
    }

    private void editNofushoOcr41(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoOcr41 = 納入通知書期情報.getOcr().get(OCR_4);
    }

    private void editNofushoNofugaku1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoNofugaku1 = 納入通知書期情報.get納付書納付額欄();
    }

    private void editNofushoSofusakiName1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoSofusakiName1 = 納付書共通.get納付者氏名();
    }

    private void editNofushoHonninName1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoHonninName1 = 納付書共通.get被代納人氏名();
    }

    private void editNofushoKakko11(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoKakko11 = RString.isNullOrEmpty(納付書共通.get被代納人氏名()) ? RString.EMPTY : new RString(("("));
    }

    private void editNofushoKakko21(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoKakko21 = RString.EMPTY;
    }

    private void editNofushoKakko31(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoKakko31 = RString.isNullOrEmpty(納付書共通.get被代納人氏名()) ? RString.EMPTY : 納付書共通.get被代納人敬称().concat(")");
    }

    private void editNofushoTsuchishoNo1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (null == 納付書共通.get通知書番号()) {
            return;
        }
        source.nofushoTsuchishoNo1 = 納付書共通.get通知書番号().getColumnValue();
    }

    private void editNofushoSetaiCode1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (納付書共通.get世帯コード() != null) {
            source.nofushoSetaiCode1 = 納付書共通.get世帯コード().getColumnValue();
        }
    }

    private void editNofushohyojicodeName11(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushohyojicodeName11 = 納付書共通.get表示コード().get表示コード名１();
    }

    private void editNofushohyojicode11(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushohyojicode11 = 納付書共通.get表示コード().get表示コード１();
    }

    private void editNofushohyojicodeName21(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushohyojicodeName21 = 納付書共通.get表示コード().get表示コード名２();
    }

    private void editNofushohyojicode21(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushohyojicode21 = 納付書共通.get表示コード().get表示コード２();
    }

    private void editNofushohyojicodeName31(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushohyojicodeName31 = 納付書共通.get表示コード().get表示コード名３();
    }

    private void editNofushohyojicode31(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushohyojicode31 = 納付書共通.get表示コード().get表示コード３();
    }

    private void editNofushoNokigen1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoNokigen1 = 納入通知書期情報.get納期限表記();
    }

    private void editNofushoNofuin1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoNofuin1 = 納入通知書期情報.get領収日付欄();
    }

    private void editNofushoRyoshuHizukein1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoRyoshuHizukein1 = 納入通知書期情報.get納付書領収印欄();
    }

    private void editNofushoZuiji1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoZuiji1 = 納入通知書期情報.get随時表記();
    }

    private void editNofushoShichosonMei11(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoShichosonMei11 = 納付書共通.get納付書市町村名();
    }

    private void editCompNinshosha(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.denshiKoin = ninshoshaSource.denshiKoin;
        source.hakkoYMD = ninshoshaSource.hakkoYMD;
        source.koinMojiretsu = ninshoshaSource.koinMojiretsu;
        source.ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
        source.ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
        source.ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
        source.koinShoryaku = ninshoshaSource.koinShoryaku;
    }

    private void editTitleNendo(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (編集後仮算定通知書共通情報.get調定年度_年度なし() != null) {
            source.titleNendo = RStringUtil.convert半角to全角(編集後仮算定通知書共通情報.get調定年度_年度なし());
        }
    }

    private void editKi1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.ki1 = 納入通知書期情報.get期表記();
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴収入情報リスト() || 編集後仮算定通知書共通情報.get普徴収入情報リスト().isEmpty()) {
            return;
        }
        source.ki1
                = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(0).get期月().get期AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editTsuki1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.tsuki1 = 納入通知書期情報.get月表記();
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴収入情報リスト() || 編集後仮算定通知書共通情報.get普徴収入情報リスト().isEmpty()) {
            return;
        }
        source.tsuki1 = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(0).get期月().get月AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editNokiKaishi1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiKaishi1 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? 納入通知書期情報.get納期開始日表記() : get納期開始日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 1);
    }

    private void editNokiShuryo1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiShuryo1 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? 納入通知書期情報.get納期終了日表記() : get納期終了日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 1);
    }

    private void editKi2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.ki2 = RString.EMPTY;
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴収入情報リスト() || 編集後仮算定通知書共通情報.get普徴収入情報リスト().size() < INT_2) {
            return;
        }
        source.ki2 = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(1).get期月().get期AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editTsuki2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.tsuki2 = RString.EMPTY;
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴収入情報リスト() || 編集後仮算定通知書共通情報.get普徴収入情報リスト().size() < INT_2) {
            return;
        }
        source.tsuki2 = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(1).get期月().get月AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editNokiKaishi2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiKaishi2 = RString.EMPTY.equals(source.ki2) ? RString.EMPTY : get納期開始日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 2);
    }

    private void editNokiShuryo2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiShuryo2 = RString.EMPTY.equals(source.ki2) ? RString.EMPTY : get納期終了日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 2);
    }

    private void editKi3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.ki3 = RString.EMPTY;
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴収入情報リスト() || 編集後仮算定通知書共通情報.get普徴収入情報リスト().size() < INT_3) {
            return;
        }
        source.ki3 = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(2).get期月().get期AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editTsuki3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.tsuki3 = RString.EMPTY;
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴収入情報リスト() || 編集後仮算定通知書共通情報.get普徴収入情報リスト().size() < INT_3) {
            return;
        }
        source.tsuki3 = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(2).get期月().get月AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editNokiKaishi3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiKaishi3 = RString.EMPTY.equals(source.ki3) ? RString.EMPTY : get納期開始日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_3);
    }

    private void editNokiShuryo3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiShuryo3 = RString.EMPTY.equals(source.ki3) ? RString.EMPTY : get納期終了日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_3);
    }

    private void editKi4(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.ki4 = RString.EMPTY;
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴収入情報リスト() || 編集後仮算定通知書共通情報.get普徴収入情報リスト().size() < INT_4) {
            return;
        }
        source.ki4 = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(期_3).get期月().get期AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editTsuki4(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.tsuki4 = RString.EMPTY;
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴収入情報リスト() || 編集後仮算定通知書共通情報.get普徴収入情報リスト().size() < INT_4) {
            return;
        }
        source.tsuki4 = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(期_3).get期月().get月AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editNokiKaishi4(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiKaishi4 = RString.EMPTY.equals(source.ki4) ? RString.EMPTY : get納期開始日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_4);
    }

    private void editNokiShuryo4(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiShuryo4 = RString.EMPTY.equals(source.ki4) ? RString.EMPTY : get納期終了日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_4);
    }

    private void editKi5(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.ki5 = RString.EMPTY;
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴収入情報リスト() || 編集後仮算定通知書共通情報.get普徴収入情報リスト().size() < INT_5) {
            return;
        }
        source.ki5 = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(期_4).get期月().get期AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editTsuki5(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.tsuki5 = RString.EMPTY;
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴収入情報リスト() || 編集後仮算定通知書共通情報.get普徴収入情報リスト().size() < INT_5) {
            return;
        }
        source.tsuki5 = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(期_4).get期月().get月AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editNokiKaishi5(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {

        source.nokiKaishi5 = RString.EMPTY.equals(source.ki5) ? RString.EMPTY : get納期開始日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_5);
    }

    private void editNokiShuryo5(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiShuryo5 = RString.EMPTY.equals(source.ki5) ? RString.EMPTY : get納期終了日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_5);
    }

    private void editKi6(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.ki6 = RString.EMPTY;
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴収入情報リスト() || 編集後仮算定通知書共通情報.get普徴収入情報リスト().size() < INT_6) {
            return;
        }
        source.ki6 = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(期_5).get期月().get期AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editTsuki6(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())) {
            source.tsuki6 = RString.EMPTY;
            return;
        }
        if (null == 編集後仮算定通知書共通情報.get普徴収入情報リスト() || 編集後仮算定通知書共通情報.get普徴収入情報リスト().size() < INT_6) {
            return;
        }
        source.tsuki6 = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴収入情報リスト().get(期_5).get期月().get月AsInt()))
                .padLeft(RString.HALF_SPACE, 2);
    }

    private void editNokiKaishi6(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiKaishi6 = RString.EMPTY.equals(source.ki6) ? RString.EMPTY : get納期開始日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_6);
    }

    private void editNokiShuryo6(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiShuryo6 = RString.EMPTY.equals(source.ki6) ? RString.EMPTY : get納期終了日(編集後仮算定通知書共通情報.get普徴納期情報リスト(), 期_6);
    }

    private void editBankCode(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.bankCode = 編集後仮算定通知書共通情報.get編集後口座().get金融機関コードCombinedWith支店コード();
    }

    private void editKozaMeigi(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.kozaMeigi = 編集後仮算定通知書共通情報.get編集後口座().get口座名義人優先();
    }

    private void editKozaShurui(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.kozaShurui = 編集後仮算定通知書共通情報.get編集後口座().get口座種別略称();
    }

    private void editKozaNo(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.kozaNo = 編集後仮算定通知書共通情報.get編集後口座().get口座番号Or通帳記号番号();
    }

    private void editBankName(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.bankName = 編集後仮算定通知書共通情報.get編集後口座().get金融機関名CombinedWith支店名();
    }

    private void editHyojicodeName1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.hyojicodeName1 = RString.EMPTY;
    }

    private void editHyojicodeName2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.hyojicodeName2 = RString.EMPTY;
    }

    private void editHyojicodeName3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.hyojicodeName3 = RString.EMPTY;
    }

    private void editHyojiKomoku11(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.hyojiKomoku11 = 編集後仮算定通知書共通情報.get表示コード１名();
    }

    private void editHyojiKomoku21(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.hyojiKomoku21 = 編集後仮算定通知書共通情報.get表示コード２名();
    }

    private void editHyojiKomoku31(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.hyojiKomoku31 = 編集後仮算定通知書共通情報.get表示コード３名();
    }

    private void editHyojicode1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.hyojicode1 = 編集後仮算定通知書共通情報.get表示コード1();
    }

    private void editHyojicode2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.hyojicode2 = 編集後仮算定通知書共通情報.get表示コード２();
    }

    private void editHyojicode3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.hyojicode3 = 編集後仮算定通知書共通情報.get表示コード１名();
    }

    private void editTsuchishoNo(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (null == 編集後仮算定通知書共通情報.get通知書番号()) {
            return;
        }
        source.tsuchishoNo = 編集後仮算定通知書共通情報.get通知書番号().getColumnValue();
    }

    private void editSetaiCode(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.setaiCode = 編集後仮算定通知書共通情報.get編集後個人().get世帯コード().getColumnValue();
    }

    private void editHihokenshaName(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.hihokenshaName = 編集後仮算定通知書共通情報.get編集後個人().get名称().getName().getColumnValue();
    }

    private void editSetaiNushiName(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.setaiNushiName = 編集後仮算定通知書共通情報.get編集後個人().get世帯主名().getColumnValue();
    }

    private void editNendo1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (null == 編集後仮算定通知書共通情報.get賦課年度()) {
            return;
        }
        source.nendo1 = 編集後仮算定通知書共通情報.get賦課年度().toDateString();
    }

    private void editHokenryoGaku(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (null == 編集後仮算定通知書共通情報.get更正後()) {
            return;
        }
        source.hokenryoGaku = NotsuReportEditorUtil
                .get共通ポリシー金額1(編集後仮算定通知書共通情報.get更正後().get更正後介護保険料仮徴収額合計());
    }

    private void editNendo2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nendo2 = 編集後仮算定通知書共通情報.get前年度情報().get前年度賦課年度();
    }

    private void editShotokuDankai(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.shotokuDankai = 編集後仮算定通知書共通情報.get前年度情報().get前年度保険料段階();
    }

    private void editNendo3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nendo3 = 仮算定納入通知書情報.get算定の基礎().get基礎1().get年度();
    }

    private void editKomokuTitle1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.komokuTitle1 = 仮算定納入通知書情報.get算定の基礎().get基礎1().get名称();
    }

    private void editSanteiKisoKingaku1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.santeiKisoKingaku1 = 仮算定納入通知書情報.get算定の基礎().get基礎1().get金額();
    }

    private void editYen1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.yen1 = 仮算定納入通知書情報.get算定の基礎().get基礎1().get単位();
    }

    private void editNendo4(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nendo4 = 仮算定納入通知書情報.get算定の基礎().get基礎2().get年度();
    }

    private void editKomokuTitle2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.komokuTitle2 = 仮算定納入通知書情報.get算定の基礎().get基礎2().get名称();
    }

    private void editSanteiKisoKingaku2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.santeiKisoKingaku2 = 仮算定納入通知書情報.get算定の基礎().get基礎2().get金額();
    }

    private void editYen2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.yen2 = 仮算定納入通知書情報.get算定の基礎().get基礎2().get単位();
    }

    private void editNendo5(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nendo5 = 仮算定納入通知書情報.get算定の基礎().get基礎3().get年度();
    }

    private void editKomokuTitle3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.komokuTitle3 = 仮算定納入通知書情報.get算定の基礎().get基礎3().get名称();
    }

    private void editSanteiKisoKingaku3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.santeiKisoKingaku3 = 仮算定納入通知書情報.get算定の基礎().get基礎3().get金額();
    }

    private void editYen3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.yen3 = 仮算定納入通知書情報.get算定の基礎().get基礎3().get単位();
    }

    private void editSanteiKisoKi(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.santeiKisoKi = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴期数()));
    }

    private void editSanteiKisoGenmenGaku(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.santeiKisoGenmenGaku = new RString(編集後仮算定通知書共通情報.get更正後().get更正後介護保険料減免額().toString());
    }

    private void editSanteiKisoKariGokeiGaku(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.santeiKisoKariGokeiGaku = NotsuReportEditorUtil
                .get共通ポリシー金額1(編集後仮算定通知書共通情報.get更正後().get更正後特徴期別金額合計());
    }

    private void editSanteiKisoKiTitle1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (null == 仮算定納入通知書情報.get出力期リスト() || 仮算定納入通知書情報.get出力期リスト().isEmpty()) {
            return;
        }
        source.santeiKisoKiTitle1 = new RString("第").concat(仮算定納入通知書情報.get出力期リスト().get(0).get期()).concat("期");
    }

    private void editSanteiKisoZanteikiHokenryoGaku1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (null == 編集後仮算定通知書共通情報.get更正後()
                || null == 仮算定納入通知書情報.get出力期リスト()
                || 仮算定納入通知書情報.get出力期リスト().isEmpty()) {
            return;
        }
        source.santeiKisoZanteikiHokenryoGaku1
                = get金額(編集後仮算定通知書共通情報.get更正後().get更正後普徴期別金額リスト(), 仮算定納入通知書情報.get出力期リスト().get(0).get期AsInt());
    }

    private void editSanteiKisoKiTitle2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (null == 仮算定納入通知書情報.get出力期リスト()) {
            return;
        }
        source.santeiKisoKiTitle2 = 仮算定納入通知書情報.get出力期リスト().size() >= 2 ? new RString("次期以降") : RString.EMPTY;
    }

    private void editSanteiKisoZanteikiHokenryoGaku2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (null == 仮算定納入通知書情報.get出力期リスト() || 仮算定納入通知書情報.get出力期リスト().size() < INT_2) {
            return;
        }
        source.santeiKisoZanteikiHokenryoGaku2 = 仮算定納入通知書情報.get出力期リスト().size() >= 2
                ? get金額(編集後仮算定通知書共通情報.get更正後().get更正後普徴期別金額リスト(), 仮算定納入通知書情報.get出力期リスト().get(1).get期AsInt())
                : RString.EMPTY;
    }

    private void editRenban(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        RString 連番 = new RString(String.valueOf(this.連番));
        if (ShoriKubun.バッチ.equals(仮算定納入通知書情報.get処理区分())) {
            source.renban = 連番.padLeft("0", 連番_6);
        } else {
            source.renban = RString.EMPTY;
        }
    }

    private void editHokenshaName(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.hokenshaName = 編集後仮算定通知書共通情報.get保険者名();
    }

    private RString get納期開始日(List<UniversalSignDeliveryInformation> 普徴納期情報リスト, int 期) {
        if (null == 普徴納期情報リスト) {
            return RString.EMPTY;
        }
        for (UniversalSignDeliveryInformation 普徴納期情報 : 普徴納期情報リスト) {
            if (期 == 普徴納期情報.get期月().get期AsInt()) {
                return 普徴納期情報.get納期開始日();
            }
        }
        return RString.EMPTY;
    }

    private RString get納期終了日(List<UniversalSignDeliveryInformation> 普徴納期情報リスト, int 期) {
        if (null == 普徴納期情報リスト) {
            return RString.EMPTY;
        }
        for (UniversalSignDeliveryInformation 普徴納期情報 : 普徴納期情報リスト) {
            if (期 == 普徴納期情報.get期月().get期AsInt()) {
                return 普徴納期情報.get納期終了日();
            }
        }
        return RString.EMPTY;
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
