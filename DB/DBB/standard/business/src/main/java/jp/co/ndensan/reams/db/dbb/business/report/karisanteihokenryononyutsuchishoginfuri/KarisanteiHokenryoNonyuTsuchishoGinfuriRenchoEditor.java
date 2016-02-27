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
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NofuShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;

/**
 *
 * 帳票設計_DBBRP00007_3_保険料納入通知書（仮算定）【銀振タイプ】連帳 KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoEditor
 */
public class KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoEditor implements IKarisanteiHokenryoNonyuTsuchishoGinfuriRenchoEditor {

    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;
    private final EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報;
    private final KariSanteiNonyuTsuchiShoSeigyoJoho 仮算定納入通知書制御情報;
    private final NonyuTsuchiShoSeigyoJoho 納入通知書制御情報;
    private final List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト;
    private final int 連番;
    //private final NinshoshaSource ninshoshaSource;
    private final SofubutsuAtesakiSource sofubutsuAtesakiSource;
    private final NofuShoKyotsu 納付書共通;
    private final ShoriKubun 処理区分;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KarisanteiHokenryoNonyuTsuchishoGinfuriItem}
     * @param 納入通知書期情報リスト
     * @param 連番
     * @param sofubutsuAtesakiSource
     */
    protected KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoEditor(
            KarisanteiHokenryoNonyuTsuchishoGinfuriItem item,
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト,
            int 連番,
            //NinshoshaSource ninshoshaSource,
            SofubutsuAtesakiSource sofubutsuAtesakiSource) {
        this.仮算定納入通知書情報 = item.get仮算定納入通知書情報();
        this.編集後仮算定通知書共通情報 = 仮算定納入通知書情報.get編集後仮算定通知書共通情報();
        this.仮算定納入通知書制御情報 = 仮算定納入通知書情報.get仮算定納入通知書制御情報();
        this.納入通知書制御情報 = 仮算定納入通知書制御情報.get納入通知書制御情報();
        this.納入通知書期情報リスト = 納入通知書期情報リスト;
        this.連番 = 連番;
        //this.ninshoshaSource = ninshoshaSource;
        this.sofubutsuAtesakiSource = sofubutsuAtesakiSource;
        this.納付書共通 = 仮算定納入通知書情報.get納付書共通();
        this.処理区分 = 仮算定納入通知書情報.get処理区分();
    }

    @Override
    public KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource edit(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
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
        editERenban(source);
        edit納入通知書期情報(source);
        //editCompNinshosha(source);
        editDBBCompNofushoItem(source);
        editCompSofubutsuAtesaki(source);
        editCompSofubutsuAtesaki2(source);
        return source;
    }

    private void editCompSofubutsuAtesaki2(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.customerBarCode1 = sofubutsuAtesakiSource.customerBarCode;
        source.dainoKubunMei1 = sofubutsuAtesakiSource.dainoKubunMei;
        source.gyoseiku2 = sofubutsuAtesakiSource.gyoseiku;
        source.jusho4 = sofubutsuAtesakiSource.jusho1;
        source.jusho5 = sofubutsuAtesakiSource.jusho2;
        source.jusho6 = sofubutsuAtesakiSource.jusho3;
        source.jushoText1 = sofubutsuAtesakiSource.jushoText;
        source.kakkoLeft3 = sofubutsuAtesakiSource.kakkoLeft1;
        source.kakkoLeft4 = sofubutsuAtesakiSource.kakkoLeft2;
        source.kakkoRight3 = sofubutsuAtesakiSource.kakkoRight1;
        source.kakkoRight4 = sofubutsuAtesakiSource.kakkoRight2;
        source.katagaki3 = sofubutsuAtesakiSource.katagaki1;
        source.katagaki4 = sofubutsuAtesakiSource.katagaki2;
        source.katagakiSmall3 = sofubutsuAtesakiSource.katagakiSmall1;
        source.katagakiSmall4 = sofubutsuAtesakiSource.katagakiSmall2;
        source.katagakiText1 = sofubutsuAtesakiSource.katagakiText;
        source.meishoFuyo3 = sofubutsuAtesakiSource.meishoFuyo1;
        source.meishoFuyo4 = sofubutsuAtesakiSource.meishoFuyo2;
        source.samaBun3 = sofubutsuAtesakiSource.samaBun1;
        source.samaBun4 = sofubutsuAtesakiSource.samaBun2;
        source.samabunShimei3 = sofubutsuAtesakiSource.samabunShimei1;
        source.samabunShimei4 = sofubutsuAtesakiSource.samabunShimei2;
        source.samabunShimeiSmall3 = sofubutsuAtesakiSource.samabunShimeiSmall1;
        source.samabunShimeiSmall4 = sofubutsuAtesakiSource.samabunShimeiSmall2;
        source.samabunShimeiText1 = sofubutsuAtesakiSource.samabunShimeiText;
        source.shimei3 = sofubutsuAtesakiSource.shimei1;
        source.shimei4 = sofubutsuAtesakiSource.shimei2;
        source.shimeiSmall3 = sofubutsuAtesakiSource.shimeiSmall1;
        source.shimeiSmall4 = sofubutsuAtesakiSource.shimeiSmall2;
        source.shimeiText1 = sofubutsuAtesakiSource.shimeiText;
        source.yubinNo2 = sofubutsuAtesakiSource.yubinNo;
    }

    private void editCompSofubutsuAtesaki(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
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
    }

    private void editDBBCompNofushoItem(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        //source.nofushoKanendo3 = RString.EMPTY;
        source.nofushoNendo4
                = RStringUtil.convert半角to全角(is銀振印字位置の納入通知書期情報がある(4) ? 納付書共通.get調定年度表記() : new RString("******"));
        //source.nofushoKanendo2 = RString.EMPTY;
        //source.nofushoKanendo1 = RString.EMPTY;
        //source.nofushoKanendo4 = RString.EMPTY;
        source.nofushoNendo3
                = RStringUtil.convert半角to全角(is銀振印字位置の納入通知書期情報がある(3) ? 納付書共通.get調定年度表記() : new RString("******"));
        source.nofushoNendo2
                = RStringUtil.convert半角to全角(is銀振印字位置の納入通知書期情報がある(2) ? 納付書共通.get調定年度表記() : new RString("******"));
        source.nofushoNendo1
                = RStringUtil.convert半角to全角(is銀振印字位置の納入通知書期情報がある(1) ? 納付書共通.get調定年度表記() : new RString("******"));
        //source.nofushoKanendobun2 = RString.EMPTY;
        //source.nofushoKanendobun3 = RString.EMPTY;
        //source.nofushoKanendobun4 = RString.EMPTY;
        //source.nofushoKanendobun1 = RString.EMPTY;
        edit納入通知書期情報1(source);
        source.nofushoSofusakiName1 = 納付書共通.get納付者氏名();
        source.nofushoSofusakiName2 = 納付書共通.get納付者氏名();
        source.nofushoSofusakiName3 = 納付書共通.get納付者氏名();
        source.nofushoSofusakiName4 = 納付書共通.get納付者氏名();
        source.nofushoHonninName1 = 納付書共通.get被代納人氏名();
        source.nofushoHonninName2 = 納付書共通.get被代納人氏名();
        source.nofushoHonninName3 = 納付書共通.get被代納人氏名();
        source.nofushoHonninName4 = 納付書共通.get被代納人氏名();
        source.nofushoKakko11 = RString.isNullOrEmpty(source.nofushoHonninName1) ? RString.EMPTY : new RString("(");
        source.nofushoKakko12 = RString.isNullOrEmpty(source.nofushoHonninName2) ? RString.EMPTY : new RString("(");
        source.nofushoKakko13 = RString.isNullOrEmpty(source.nofushoHonninName3) ? RString.EMPTY : new RString("(");
        source.nofushoKakko14 = RString.isNullOrEmpty(source.nofushoHonninName4) ? RString.EMPTY : new RString("(");
        source.nofushoKakko21 = RString.EMPTY;
        source.nofushoKakko31 = RString.isNullOrEmpty(source.nofushoHonninName1) ? RString.EMPTY : 納付書共通.get被代納人敬称().concat(")");
        source.nofushoKakko22 = RString.EMPTY;
        source.nofushoKakko32 = RString.isNullOrEmpty(source.nofushoHonninName2) ? RString.EMPTY : 納付書共通.get被代納人敬称().concat(")");
        source.nofushoKakko23 = RString.EMPTY;
        source.nofushoKakko33 = RString.isNullOrEmpty(source.nofushoHonninName3) ? RString.EMPTY : 納付書共通.get被代納人敬称().concat(")");
        source.nofushoKakko24 = RString.EMPTY;
        source.nofushoKakko34 = RString.isNullOrEmpty(source.nofushoHonninName4) ? RString.EMPTY : 納付書共通.get被代納人敬称().concat(")");
        source.nofushoTsuchishoNo1 = 納付書共通.get通知書番号().getColumnValue();
        source.nofushoTsuchishoNo2 = 納付書共通.get通知書番号().getColumnValue();
        source.nofushoTsuchishoNo3 = 納付書共通.get通知書番号().getColumnValue();
        source.nofushoTsuchishoNo4 = 納付書共通.get通知書番号().getColumnValue();
        source.nofushoSetaiCode1 = 納付書共通.get世帯コード().getColumnValue();
        source.nofushoSetaiCode2 = 納付書共通.get世帯コード().getColumnValue();
        source.nofushoSetaiCode3 = 納付書共通.get世帯コード().getColumnValue();
        source.nofushoSetaiCode4 = 納付書共通.get世帯コード().getColumnValue();
        source.nofushohyojicodeName11 = 納付書共通.get表示コード().get表示コード名１();
        source.nofushohyojicode11 = 納付書共通.get表示コード().get表示コード１();
        source.nofushohyojicodeName12 = 納付書共通.get表示コード().get表示コード名１();
        source.nofushohyojicode12 = 納付書共通.get表示コード().get表示コード１();
        source.nofushohyojicodeName13 = 納付書共通.get表示コード().get表示コード名１();
        source.nofushohyojicode13 = 納付書共通.get表示コード().get表示コード１();
        source.nofushohyojicodeName14 = 納付書共通.get表示コード().get表示コード名１();
        source.nofushohyojicode14 = 納付書共通.get表示コード().get表示コード１();
        source.nofushohyojicodeName21 = 納付書共通.get表示コード().get表示コード名２();
        source.nofushohyojicode21 = 納付書共通.get表示コード().get表示コード２();
        source.nofushohyojicodeName22 = 納付書共通.get表示コード().get表示コード名２();
        source.nofushohyojicode22 = 納付書共通.get表示コード().get表示コード２();
        source.nofushohyojicodeName23 = 納付書共通.get表示コード().get表示コード名２();
        source.nofushohyojicode23 = 納付書共通.get表示コード().get表示コード２();
        source.nofushohyojicodeName24 = 納付書共通.get表示コード().get表示コード名２();
        source.nofushohyojicode24 = 納付書共通.get表示コード().get表示コード２();
        source.nofushohyojicodeName31 = 納付書共通.get表示コード().get表示コード名３();
        source.nofushohyojicode31 = 納付書共通.get表示コード().get表示コード３();
        source.nofushohyojicodeName32 = 納付書共通.get表示コード().get表示コード名３();
        source.nofushohyojicode32 = 納付書共通.get表示コード().get表示コード３();
        source.nofushohyojicodeName33 = 納付書共通.get表示コード().get表示コード名３();
        source.nofushohyojicode33 = 納付書共通.get表示コード().get表示コード３();
        source.nofushohyojicodeName34 = 納付書共通.get表示コード().get表示コード名３();
        source.nofushohyojicode34 = 納付書共通.get表示コード().get表示コード３();
        editMRenban(source);
        source.nofushoShichosonMei11 = 納付書共通.get納付書市町村名();
        source.nofushoShichosonMei12 = 納付書共通.get納付書市町村名();
        source.nofushoShichosonMei13 = 納付書共通.get納付書市町村名();
        source.nofushoShichosonMei14 = 納付書共通.get納付書市町村名();
    }

//    private void editCompNinshosha(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
//        source.denshiKoin = ninshoshaSource.denshiKoin;
//        source.hakkoYMD = ninshoshaSource.hakkoYMD;
//        source.koinMojiretsu = ninshoshaSource.koinMojiretsu;
//        source.ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
//        source.ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
//        source.ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
//        source.koinShoryaku = ninshoshaSource.koinShoryaku;
//    }
    private void editTitleNendo(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.titleNendo = RStringUtil.convert半角to全角(編集後仮算定通知書共通情報.get調定年度_年度なし());
    }

    private void editHyojicodeName1(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.HyojicodeName1 = 編集後仮算定通知書共通情報.get表示コード１名();
    }

    private void editHyojicodeName2(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.HyojicodeName2 = 編集後仮算定通知書共通情報.get表示コード２名();
    }

    private void editHyojicodeName3(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.HyojicodeName3 = 編集後仮算定通知書共通情報.get表示コード３名();
    }

    private void editHyojicode1(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.Hyojicode1 = 編集後仮算定通知書共通情報.get表示コード1();
    }

    private void editHyojicode2(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.Hyojicode2 = 編集後仮算定通知書共通情報.get表示コード２();
    }

    private void editHyojicode13(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.Hyojicode3 = 編集後仮算定通知書共通情報.get表示コード３();
    }

    private void editTsuchishoNo(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.tsuchishoNo = 編集後仮算定通知書共通情報.get通知書番号().getColumnValue();
    }

    private void editSetaiCode(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.setaiCode = null;//TODO 仮算定納入通知書情報.編集後仮算定通知書共通情報.編集後個人.get世帯コード()
    }

    private void editHihokenshaName(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.hihokenshaName = null;//TODO 仮算定納入通知書情報.編集後仮算定通知書共通情報.編集後個人.getName()
    }

    private void editSetaiNushiName(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.setaiNushiName = null;//TODO 仮算定納入通知書情報.編集後仮算定通知書共通情報.編集後個人.get世帯主名()
    }

    private void editNendo1(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.nendo1 = 編集後仮算定通知書共通情報.get賦課年度_年度なし();
    }

    private void editHokenryoGaku(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.hokenryoGaku = new RString(編集後仮算定通知書共通情報.get更正後().get更正後介護保険料仮徴収額合計().toString());
    }

    private void editSanteiKisoNendo1(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.santeiKisoNendo1 = 編集後仮算定通知書共通情報.get前年度情報().get前年度賦課年度();
    }

    private void editSanteiKisoShutokuDankai(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.santeiKisoShutokuDankai = RStringUtil.convert半角to全角(編集後仮算定通知書共通情報.get前年度情報().get前年度保険料段階());
    }

    private void editSanteiKisoNendo2(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.santeiKisoNendo2 = 仮算定納入通知書情報.get算定の基礎().get基礎1().get年度();
    }

    private void editSanteiKisoKomokuTitle1(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.santeiKisoKomokuTitle1 = 仮算定納入通知書情報.get算定の基礎().get基礎1().get名称();
    }

    private void editSanteiKisoKinGaku1(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.santeiKisoKinGaku1 = 仮算定納入通知書情報.get算定の基礎().get基礎1().get金額();
    }

    private void editSanteiKisoYen1(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.santeiKisoYen1 = 仮算定納入通知書情報.get算定の基礎().get基礎1().get単位();
    }

    private void editSanteiKisoNendo3(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.santeiKisoNendo3 = 仮算定納入通知書情報.get算定の基礎().get基礎2().get年度();
    }

    private void editSanteiKisoKomokuTitle2(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.santeiKisoKomokuTitle2 = 仮算定納入通知書情報.get算定の基礎().get基礎2().get名称();
    }

    private void editSanteiKisoKinGaku2(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.santeiKisoKinGaku2 = 仮算定納入通知書情報.get算定の基礎().get基礎2().get金額();
    }

    private void editSanteiKisoYen2(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.santeiKisoYen2 = 仮算定納入通知書情報.get算定の基礎().get基礎2().get単位();
    }

    private void editSanteiKisoNendo4(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.santeiKisoNendo4 = 仮算定納入通知書情報.get算定の基礎().get基礎3().get年度();
    }

    private void editSanteiKisoKomokuTitle3(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.santeiKisoKomokuTitle3 = 仮算定納入通知書情報.get算定の基礎().get基礎3().get名称();
    }

    private void editSanteiKisoKinGaku3(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.santeiKisoKinGaku3 = 仮算定納入通知書情報.get算定の基礎().get基礎3().get金額();
    }

    private void editSanteiKisoYen3(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.santeiKisoYen3 = 仮算定納入通知書情報.get算定の基礎().get基礎3().get単位();
    }

    private void editSanteiKisoNokisu(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.santeiKisoNokisu = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴期数()));
    }

    private void editSanteiKisoGenmenGaku(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.santeiKisoGenmenGaku = new RString(編集後仮算定通知書共通情報.get更正後().get更正後介護保険料減免額().toString());
    }

    private void editSanteiKisoTokuchoKariGokeiGaku(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.santeiKisoGenmenGaku = new RString(編集後仮算定通知書共通情報.get更正後().get更正後普徴期別金額合計().toString());
    }

    private void editSanteiKisoKiTitle1(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.santeiKisoKiTitle1 = new RString("第").concat(仮算定納入通知書情報.get出力期リスト().get(0).get期()).concat("期");
    }

    private void editSanteiKisoZanteikiHokenryoGaku1(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.santeiKisoZanteikiHokenryoGaku1
                = get金額(編集後仮算定通知書共通情報.get更正後().get更正後普徴期別金額リスト(), 仮算定納入通知書情報.get出力期リスト().get(0).get期AsInt());
    }

    private void editSanteiKisoKiTitle2(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.santeiKisoKiTitle2
                = 仮算定納入通知書情報.get出力期リスト().size() >= 2 ? new RString("次期以降") : RString.EMPTY;
    }

    private void editSanteiKisoZanteikiHokenryoGaku2(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.santeiKisoZanteikiHokenryoGaku2 = 仮算定納入通知書情報.get出力期リスト().size() >= 2
                ? get金額(編集後仮算定通知書共通情報.get更正後().get更正後普徴期別金額リスト(), 仮算定納入通知書情報.get出力期リスト().get(1).get期AsInt())
                : RString.EMPTY;
    }

    private void editRyoshushoNendo(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.ryoshushoNendo = RStringUtil.convert半角to全角(編集後仮算定通知書共通情報.get調定年度_年度なし());
    }

    private void edit納入通知書期情報(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
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
            KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source,
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

    private void set納入通知書期情報1無(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.ki1 = RString.EMPTY;
        source.tsuki1 = RString.EMPTY;
        source.ryoshushoKi1 = new RString("**");
        source.ryoshushoNofuGaku1 = new RString("**********");
        source.ryoshushoNofuin1 = new RString("**");
        source.ryoshushoRyoshuHizukein1 = RString.EMPTY;
        source.ryoshushoZuiji1 = RString.EMPTY;
    }

    private void set納入通知書期情報2(
            KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source,
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

    private void set納入通知書期情報2無(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.ki2 = RString.EMPTY;
        source.tsuki2 = RString.EMPTY;
        source.ryoshushoKi2 = new RString("**");
        source.ryoshushoNofuGaku2 = new RString("**********");
        source.ryoshushoNofuin2 = new RString("**");
        source.ryoshushoRyoshuHizukein2 = RString.EMPTY;
        source.ryoshushoZuiji2 = RString.EMPTY;
    }

    private void set納入通知書期情報3(
            KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source,
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

    private void set納入通知書期情報3無(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.ki3 = RString.EMPTY;
        source.tsuki3 = RString.EMPTY;
        source.ryoshushoKi3 = new RString("**");
        source.ryoshushoNofuGaku3 = new RString("**********");
        source.ryoshushoNofuin3 = new RString("**");
        source.ryoshushoRyoshuHizukein3 = RString.EMPTY;
        source.ryoshushoZuiji3 = RString.EMPTY;
    }

    private void set納入通知書期情報4(
            KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source,
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

    private void set納入通知書期情報4無(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.ki4 = RString.EMPTY;
        source.tsuki4 = RString.EMPTY;
        source.ryoshushoKi4 = new RString("**");
        source.ryoshushoNofuGaku4 = new RString("**********");
        source.ryoshushoNofuin4 = new RString("**");
        source.ryoshushoRyoshuHizukein4 = RString.EMPTY;
        source.ryoshushoZuiji4 = RString.EMPTY;
    }

    private void editBankCode(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.bankCode = null;//TODO 編集後口座
    }

    private void editKozaMeigi(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.kozaMeigi = null;//TODO 編集後口座
    }

    private void editKozaShurui(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.kozaNo = null;//TODO 編集後口座
    }

    private void editkozaNo(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.bankCode = null;//TODO 編集後口座
    }

    private void editBankName(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.bankName = null;//TODO 編集後口座
    }

    private void editTsuchiKaishiKi(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
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

    private void editTsuchiShuryoKi(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
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

    private void editHokenshaName(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        source.hihokenshaName = new RString(編集後仮算定通知書共通情報.get保険者名().getText());
    }

    private void editERenban(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        RString 連番 = new RString(String.valueOf(this.連番));
        if (ShoriKubun.バッチ.equals(仮算定納入通知書情報.get処理区分())) {
            連番.padLeft(連番, 6);
        }
        source.eRenban = 連番;
    }

    private RString get金額(List<UniversalPhase> 更正後普徴期別金額リスト, int 期) {
        for (UniversalPhase 更正後普徴期別金額 : 更正後普徴期別金額リスト) {
            if (期 == 更正後普徴期別金額.get期()) {
                return new RString(更正後普徴期別金額.get金額().toString());
            }
        }
        return RString.EMPTY;
    }

    private void editMRenban(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        RString 連番 = new RString(String.valueOf(this.連番));
        if (ShoriKubun.バッチ.equals(処理区分)) {
            連番.padLeft(連番, 6);
        }
        source.mRenban1 = 連番;
    }

    private boolean is銀振印字位置の納入通知書期情報がある(int 銀振印字位置) {
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            if (銀振印字位置 == 納入通知書期情報.get銀振印字位置()) {
                return true;
            }
        }
        return false;
    }

    private void edit納入通知書期情報1(KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource source) {
        boolean 納入通知書期情報1有無 = false;
        boolean 納入通知書期情報2有無 = false;
        boolean 納入通知書期情報3有無 = false;
        boolean 納入通知書期情報4有無 = false;
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            int 銀振印字位置 = 納入通知書期情報.get銀振印字位置();
            switch (銀振印字位置) {
                case 1:
                    source.nofushoKi1 = 納入通知書期情報.get期表記();
                    source.nofushoTsuki1 = 納入通知書期情報.get月表記();
                    source.nofushoOcr11 = 納入通知書期情報.getOCR().get(1);
                    source.nofushoOcr21 = 納入通知書期情報.getOCR().get(2);
                    source.nofushoOcr31 = 納入通知書期情報.getOCR().get(3);
                    source.nofushoOcr41 = 納入通知書期情報.getOCR().get(4);
                    source.nofushoNofugaku1 = 納入通知書期情報.get納付書納付額欄();
                    source.nofushoNokigen1 = 納入通知書期情報.get納期限表記();
                    source.nofushoNofuin1 = 納入通知書期情報.get領収日付欄();
                    source.nofushoRyoshuHizukein1 = 納入通知書期情報.get納付書領収印欄();
                    source.nofushoZuiji1 = 納入通知書期情報.get随時表記();
                    納入通知書期情報1有無 = true;
                    break;
                case 2:
                    source.nofushoKi2 = 納入通知書期情報.get期表記();
                    source.nofushoTsuki2 = 納入通知書期情報.get月表記();
                    source.nofushoOcr12 = 納入通知書期情報.getOCR().get(1);
                    source.nofushoOcr22 = 納入通知書期情報.getOCR().get(2);
                    source.nofushoOcr32 = 納入通知書期情報.getOCR().get(3);
                    source.nofushoOcr42 = 納入通知書期情報.getOCR().get(4);
                    source.nofushoNofugaku2 = 納入通知書期情報.get納付書納付額欄();
                    source.nofushoNokigen2 = 納入通知書期情報.get納期限表記();
                    source.nofushoNofuin2 = 納入通知書期情報.get領収日付欄();
                    source.nofushoRyoshuHizukein2 = 納入通知書期情報.get納付書領収印欄();
                    source.nofushoZuiji2 = 納入通知書期情報.get随時表記();
                    納入通知書期情報2有無 = true;
                    break;
                case 3:
                    source.nofushoKi3 = 納入通知書期情報.get期表記();
                    source.nofushoTsuki3 = 納入通知書期情報.get月表記();
                    source.nofushoOcr13 = 納入通知書期情報.getOCR().get(1);
                    source.nofushoOcr23 = 納入通知書期情報.getOCR().get(2);
                    source.nofushoOcr33 = 納入通知書期情報.getOCR().get(3);
                    source.nofushoOcr43 = 納入通知書期情報.getOCR().get(4);
                    source.nofushoNofugaku3 = 納入通知書期情報.get納付書納付額欄();
                    source.nofushoNokigen3 = 納入通知書期情報.get納期限表記();
                    source.nofushoNofuin3 = 納入通知書期情報.get領収日付欄();
                    source.nofushoRyoshuHizukein3 = 納入通知書期情報.get納付書領収印欄();
                    source.nofushoZuiji3 = 納入通知書期情報.get随時表記();
                    納入通知書期情報3有無 = true;
                    break;
                case 4:
                    source.nofushoKi4 = 納入通知書期情報.get期表記();
                    source.nofushoTsuki4 = 納入通知書期情報.get月表記();
                    source.nofushoOcr14 = 納入通知書期情報.getOCR().get(1);
                    source.nofushoOcr24 = 納入通知書期情報.getOCR().get(2);
                    source.nofushoOcr34 = 納入通知書期情報.getOCR().get(3);
                    source.nofushoOcr44 = 納入通知書期情報.getOCR().get(4);
                    source.nofushoNofugaku4 = 納入通知書期情報.get納付書納付額欄();
                    source.nofushoNokigen4 = 納入通知書期情報.get納期限表記();
                    source.nofushoNofuin4 = 納入通知書期情報.get領収日付欄();
                    source.nofushoRyoshuHizukein4 = 納入通知書期情報.get納付書領収印欄();
                    source.nofushoZuiji4 = 納入通知書期情報.get随時表記();
                    納入通知書期情報4有無 = true;
                    break;
                default:
                    break;
            }
        }
        if (!納入通知書期情報1有無) {
            source.nofushoKi1 = new RString("**");
            source.nofushoTsuki1 = new RString("**");
            source.nofushoOcr11 = new RString("******");
            source.nofushoOcr21 = new RString("****************");
            source.nofushoOcr31 = new RString("*****************");
            source.nofushoOcr41 = new RString("************");
            source.nofushoNofugaku1 = new RString("**********");
            source.nofushoNokigen1 = new RString("***********");
            source.nofushoNofuin1 = new RString("**");
            source.nofushoRyoshuHizukein1 = RString.EMPTY;
            source.nofushoZuiji1 = RString.EMPTY;
        }
        if (!納入通知書期情報2有無) {
            source.nofushoKi2 = new RString("**");
            source.nofushoTsuki2 = new RString("**");
            source.nofushoOcr12 = new RString("******");
            source.nofushoOcr22 = new RString("****************");
            source.nofushoOcr32 = new RString("*****************");
            source.nofushoOcr42 = new RString("************");
            source.nofushoNofugaku2 = new RString("**********");
            source.nofushoNokigen2 = new RString("***********");
            source.nofushoNofuin2 = new RString("**");
            source.nofushoRyoshuHizukein2 = RString.EMPTY;
            source.nofushoZuiji2 = RString.EMPTY;
        }
        if (!納入通知書期情報3有無) {
            source.nofushoKi3 = new RString("**");
            source.nofushoTsuki3 = new RString("**");
            source.nofushoOcr13 = new RString("******");
            source.nofushoOcr23 = new RString("****************");
            source.nofushoOcr33 = new RString("*****************");
            source.nofushoOcr43 = new RString("************");
            source.nofushoNofugaku3 = new RString("**********");
            source.nofushoNokigen3 = new RString("***********");
            source.nofushoNofuin3 = new RString("**");
            source.nofushoRyoshuHizukein3 = RString.EMPTY;
            source.nofushoZuiji3 = RString.EMPTY;
        }
        if (!納入通知書期情報4有無) {
            source.nofushoKi4 = new RString("**");
            source.nofushoTsuki4 = new RString("**");
            source.nofushoOcr14 = new RString("******");
            source.nofushoOcr24 = new RString("****************");
            source.nofushoOcr34 = new RString("*****************");
            source.nofushoOcr44 = new RString("************");
            source.nofushoNofugaku4 = new RString("**********");
            source.nofushoNokigen4 = new RString("***********");
            source.nofushoNofuin4 = new RString("**");
            source.nofushoRyoshuHizukein4 = RString.EMPTY;
            source.nofushoZuiji4 = RString.EMPTY;
        }
    }

}
