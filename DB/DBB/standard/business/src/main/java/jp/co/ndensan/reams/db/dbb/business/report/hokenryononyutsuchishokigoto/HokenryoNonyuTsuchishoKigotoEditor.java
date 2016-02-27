/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishokigoto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.AfterEditInformation;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NofuShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NokigenShutsuryokuHoho;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishokigoto.HokenryoNonyuTsuchishoKigotoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 保険料納入通知書（本算定）【期毎タイプ】HokenryoNonyuTsuchishoKigotoEditor
 */
public class HokenryoNonyuTsuchishoKigotoEditor implements IHokenryoNonyuTsuchishoKigotoEditor {

    private final HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報;
    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final HonSanteiNonyuTsuchiShoSeigyoJoho 本算定納入通知書制御情報;
    private final NonyuTsuchiShoKiJoho 納入通知書期情報;
    private final NofuShoKyotsu 納付書共通;
    private final int 連番;
    //private final NinshoshaSource ninshoshaSource;
    private final SofubutsuAtesakiSource sofubutsuAtesakiSource;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link HokenryoNonyuTsuchishoKigotoItem}
     * @param 納入通知書期情報
     * @param 連番
     * @param sofubutsuAtesakiSource
     */
    protected HokenryoNonyuTsuchishoKigotoEditor(HokenryoNonyuTsuchishoKigotoItem item,
            NonyuTsuchiShoKiJoho 納入通知書期情報,
            int 連番,
            //NinshoshaSource ninshoshaSource,
            SofubutsuAtesakiSource sofubutsuAtesakiSource) {
        this.本算定納入通知書情報 = null == item.get本算定納入通知書情報() ? new HonSanteiNonyuTsuchiShoJoho() : item.get本算定納入通知書情報();
        this.編集後本算定通知書共通情報 = null == 本算定納入通知書情報.get編集後本算定通知書共通情報()
                ? new EditedHonSanteiTsuchiShoKyotsu() : 本算定納入通知書情報.get編集後本算定通知書共通情報();
        this.本算定納入通知書制御情報 = null == 本算定納入通知書情報.get本算定納入通知書制御情報()
                ? new HonSanteiNonyuTsuchiShoSeigyoJoho() : 本算定納入通知書情報.get本算定納入通知書制御情報();
        this.納入通知書期情報 = 納入通知書期情報;
        this.納付書共通 = null == 本算定納入通知書情報.get納付書共通() ? new NofuShoKyotsu() : 本算定納入通知書情報.get納付書共通();
        this.連番 = 連番;
        //this.ninshoshaSource = ninshoshaSource;
        this.sofubutsuAtesakiSource = sofubutsuAtesakiSource;
    }

    @Override
    public HokenryoNonyuTsuchishoKigotoSource edit(HokenryoNonyuTsuchishoKigotoSource source) {
        editレイヤ１(source);
        //editCompNinshosha(source);
        editCompNofushoItem(source);
        editCompRyoshushoItem(source);
        editCompSofubutsuAtesaki(source);
        return source;
    }

    private void editCompSofubutsuAtesaki(HokenryoNonyuTsuchishoKigotoSource source) {
        source.customerBarCode = sofubutsuAtesakiSource.customerBarCode;
        source.dainoKubunMei = sofubutsuAtesakiSource.dainoKubunMei;
        source.gyoseiku = sofubutsuAtesakiSource.gyoseiku;
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
        source.yubinNo = sofubutsuAtesakiSource.yubinNo;
    }

    private void editCompRyoshushoItem(HokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoKanendo = RString.EMPTY;
        source.ryoshushoNendo = RStringUtil.convert半角to全角(納付書共通.get調定年度表記());
        source.ryoshushoKanendobun = RString.EMPTY;
        source.ryoshushoKi = 納入通知書期情報.get期表記();
        source.ryoshushoTsuki = 納入通知書期情報.get月表記();
        source.ryoshushoYubinNo = 納付書共通.get郵便番号();
        source.ryoshushoGyoseikuName = 納付書共通.get行政区名();
        source.ryoshushoJusho = 納付書共通.get住所();
        source.ryoshushoKatagaki = 納付書共通.get方書();
        source.ryoshushoSofusakiName = 納付書共通.get納付者氏名();
        RString 被代納人氏名 = 納付書共通.get被代納人氏名();
        if (!被代納人氏名.isNullOrEmpty()) {
            source.ryoshushoKakko1 = new RString("(");
            source.ryoshushoHonninName = 被代納人氏名;
            source.ryoshushoKakko2 = RString.EMPTY;
            source.ryoshushoKakko3 = 納付書共通.get被代納人敬称().concat(")");
        }
        source.ryoshushoTsuchishoNo = 納付書共通.get通知書番号().getColumnValue();
        source.ryoshushoSetaiCode = 納付書共通.get世帯コード().getColumnValue();
        HyojiCodes 表示コード = null == 納付書共通.get表示コード() ? new HyojiCodes() : 納付書共通.get表示コード();
        source.ryoshushohyojicodeName1 = 表示コード.get表示コード名１();
        source.ryoshushohyojicode1 = 表示コード.get表示コード１();
        source.ryoshushohyojicodeName2 = 表示コード.get表示コード名２();
        source.ryoshushohyojicode2 = 表示コード.get表示コード２();
        source.ryoshushohyojicodeName3 = 表示コード.get表示コード名３();
        source.ryoshushoHyojicode3 = 表示コード.get表示コード３();
        source.ryoshushoNokigen = 納入通知書期情報.get納期限表記();
        source.ryoshushoNofugaku = 納入通知書期情報.get領収証書納付額欄();
        source.ryoshushoNofuin = 納入通知書期情報.get領収日付印欄();
        source.ryoshushoRyoshuHizukein = 納入通知書期情報.get領収証書領収印欄();
        source.ryoshushoZuiji = 納入通知書期情報.get随時表記();
        source.ryoshushoRenban = new RString(String.valueOf(連番)).padLeft("0", 6);
        source.ryoshushoShichosonMei1 = 納付書共通.get納付書市町村名();
        source.ryoshushoShichosonMei2 = RString.EMPTY;
    }

    private void editCompNofushoItem(HokenryoNonyuTsuchishoKigotoSource source) {
        Map<Integer, RString> ocr = 納入通知書期情報.getOCR();
        if (ocr.isEmpty()) {
            ocr = new HashMap<>();
        }
        source.nofushoKanendo = RString.EMPTY;
        source.nofushoNendo = RStringUtil.convert半角to全角(納付書共通.get調定年度表記());
        source.nofushoKanendobun = RString.EMPTY;
        source.nofushoKi = 納入通知書期情報.get期表記();
        source.nofushoTsuki = 納入通知書期情報.get月表記();
        source.nofushoOcr1 = ocr.get(1);
        source.nofushoOcr2 = ocr.get(2);
        source.nofushoOcr3 = ocr.get(3);
        source.nofushoOcr4 = ocr.get(4);
        source.nofushoNofugaku = 納入通知書期情報.get納付書納付額欄();
        source.nofushoSofusakiName = 納付書共通.get納付者氏名();
        RString 被代納人氏名 = 納付書共通.get被代納人氏名();
        if (!被代納人氏名.isNullOrEmpty()) {
            source.nofushoKakko1 = new RString("(");
            source.nofushoHonninName1 = 被代納人氏名;
            source.nofushoKakko2 = RString.EMPTY;
            source.nofushoKakko3 = 納付書共通.get被代納人敬称().concat(")");
        }
        source.nofushoTsuchishoNo = 納付書共通.get通知書番号().getColumnValue();
        source.nofushoSetaiCode = 納付書共通.get世帯コード().getColumnValue();
        HyojiCodes 表示コード = null == 納付書共通.get表示コード() ? new HyojiCodes() : 納付書共通.get表示コード();
        source.nofushohyojicodeName1 = 表示コード.get表示コード名１();
        source.nofushohyojicode1 = 表示コード.get表示コード１();
        source.nofushohyojicodeName2 = 表示コード.get表示コード名２();
        source.nofushohyojicode2 = 表示コード.get表示コード２();
        source.nofushohyojicodeName3 = 表示コード.get表示コード名３();
        source.nofushohyojicode3 = 表示コード.get表示コード３();
        source.nofushoNokigen = 納入通知書期情報.get納期限表記();
        source.nofushoNofuin = 納入通知書期情報.get領収日付欄();
        source.nofushoRyoshuHizukein = 納入通知書期情報.get納付書領収印欄();
        source.nofushoZuiji = 納入通知書期情報.get随時表記();
        source.nofushoShichosonMei = 納付書共通.get納付書市町村名();
    }

//    private void editCompNinshosha(HokenryoNonyuTsuchishoKigotoSource source) {
//        source.denshiKoin = ninshoshaSource.denshiKoin;
//        source.hakkoYMD = ninshoshaSource.hakkoYMD;
//        source.ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
//        source.ninshoshaYakushokuMei1 = ninshoshaSource.ninshoshaYakushokuMei1;
//        source.koinMojiretsu = ninshoshaSource.koinMojiretsu;
//        source.ninshoshaYakushokuMei2 = ninshoshaSource.ninshoshaYakushokuMei2;
//        source.ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
//        source.ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
//        source.koinShoryaku = ninshoshaSource.koinShoryaku;
//    }
    private void editレイヤ１(HokenryoNonyuTsuchishoKigotoSource source) {
        boolean is納期限出力方法が0 = is納期限出力方法が0();
        List<AfterEditInformation> 普徴納期情報リスト = null == 編集後本算定通知書共通情報.get普徴納期情報リスト()
                ? new ArrayList<AfterEditInformation>() : 編集後本算定通知書共通情報.get普徴納期情報リスト();
        EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正後 = null == 編集後本算定通知書共通情報.get更正後()
                ? new EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection() : 編集後本算定通知書共通情報.get更正後();
        AfterEditInformation 普徴納期情報リストの一番目 = get普徴納期情報By番目(普徴納期情報リスト, 0);
        AfterEditInformation 普徴納期情報リストの二番目 = get普徴納期情報By番目(普徴納期情報リスト, 1);
        AfterEditInformation 普徴納期情報リストの三番目 = get普徴納期情報By番目(普徴納期情報リスト, 2);
        AfterEditInformation 普徴納期情報リストの四番目 = get普徴納期情報By番目(普徴納期情報リスト, 3);
        AfterEditInformation 普徴納期情報リストの五番目 = get普徴納期情報By番目(普徴納期情報リスト, 4);
        AfterEditInformation 普徴納期情報リストの六番目 = get普徴納期情報By番目(普徴納期情報リスト, 5);
        AfterEditInformation 普徴納期情報リストの七番目 = get普徴納期情報By番目(普徴納期情報リスト, 6);
        AfterEditInformation 普徴納期情報リストの八番目 = get普徴納期情報By番目(普徴納期情報リスト, 7);
        AfterEditInformation 普徴納期情報リストの九番目 = get普徴納期情報By番目(普徴納期情報リスト, 8);
        AfterEditInformation 普徴納期情報リストの十番目 = get普徴納期情報By番目(普徴納期情報リスト, 9);
        AfterEditInformation 普徴納期情報リスト1期 = get普徴納期情報By期(普徴納期情報リスト, 1);
        AfterEditInformation 普徴納期情報リスト2期 = get普徴納期情報By期(普徴納期情報リスト, 2);
        AfterEditInformation 普徴納期情報リスト3期 = get普徴納期情報By期(普徴納期情報リスト, 3);
        AfterEditInformation 普徴納期情報リスト4期 = get普徴納期情報By期(普徴納期情報リスト, 4);
        AfterEditInformation 普徴納期情報リスト5期 = get普徴納期情報By期(普徴納期情報リスト, 5);
        AfterEditInformation 普徴納期情報リスト6期 = get普徴納期情報By期(普徴納期情報リスト, 6);
        AfterEditInformation 普徴納期情報リスト7期 = get普徴納期情報By期(普徴納期情報リスト, 7);
        AfterEditInformation 普徴納期情報リスト8期 = get普徴納期情報By期(普徴納期情報リスト, 8);
        AfterEditInformation 普徴納期情報リスト9期 = get普徴納期情報By期(普徴納期情報リスト, 9);
        AfterEditInformation 普徴納期情報リスト10期 = get普徴納期情報By期(普徴納期情報リスト, 10);
        source.titleNendo = RStringUtil.convert半角to全角(編集後本算定通知書共通情報.get調定年度_年度なし()).padLeft(RString.HALF_SPACE, 2);
        source.ki1 = is納期限出力方法が0 ? 納入通知書期情報.get期表記() : 普徴納期情報リストの一番目.get期().padLeft(RString.HALF_SPACE, 2);
        source.tsuki1 = is納期限出力方法が0 ? 納入通知書期情報.get月表記() : 普徴納期情報リストの一番目.get月();
        source.nokiKaishi1 = null == 普徴納期情報リスト1期 ? RString.EMPTY : 普徴納期情報リスト1期.get納期開始日();
        source.nokiShuryo1 = null == 普徴納期情報リスト1期 ? RString.EMPTY : 普徴納期情報リスト1期.get納期終了日();
        source.ki2 = is納期限出力方法が0 ? RString.EMPTY : 普徴納期情報リストの二番目.get期().padLeft(RString.HALF_SPACE, 2);
        source.tsuki2 = is納期限出力方法が0 ? RString.EMPTY : 普徴納期情報リストの二番目.get月().padLeft(RString.HALF_SPACE, 2);
        source.nokiKaishi2 = null == 普徴納期情報リスト2期 ? RString.EMPTY : 普徴納期情報リスト2期.get納期開始日();
        source.nokiShuryo2 = null == 普徴納期情報リスト2期 ? RString.EMPTY : 普徴納期情報リスト2期.get納期終了日();
        source.ki3 = is納期限出力方法が0 ? RString.EMPTY : 普徴納期情報リストの三番目.get期().padLeft(RString.HALF_SPACE, 2);
        source.tsuki3 = is納期限出力方法が0 ? RString.EMPTY : 普徴納期情報リストの三番目.get月().padLeft(RString.HALF_SPACE, 2);
        source.nokiKaishi3 = null == 普徴納期情報リスト3期 ? RString.EMPTY : 普徴納期情報リスト3期.get納期開始日();
        source.nokiShuryo3 = null == 普徴納期情報リスト3期 ? RString.EMPTY : 普徴納期情報リスト3期.get納期終了日();
        source.ki4 = is納期限出力方法が0 ? RString.EMPTY : 普徴納期情報リストの四番目.get期().padLeft(RString.HALF_SPACE, 2);
        source.tsuki4 = is納期限出力方法が0 ? RString.EMPTY : 普徴納期情報リストの四番目.get月().padLeft(RString.HALF_SPACE, 2);
        source.nokiKaishi4 = null == 普徴納期情報リスト4期 ? RString.EMPTY : 普徴納期情報リスト4期.get納期開始日();
        source.nokiShuryo4 = null == 普徴納期情報リスト4期 ? RString.EMPTY : 普徴納期情報リスト4期.get納期終了日();
        source.ki5 = is納期限出力方法が0 ? RString.EMPTY : 普徴納期情報リストの五番目.get期().padLeft(RString.HALF_SPACE, 2);
        source.tsuki5 = is納期限出力方法が0 ? RString.EMPTY : 普徴納期情報リストの五番目.get月().padLeft(RString.HALF_SPACE, 2);
        source.nokiKaishi5 = null == 普徴納期情報リスト5期 ? RString.EMPTY : 普徴納期情報リスト5期.get納期開始日();
        source.nokiShuryo5 = null == 普徴納期情報リスト5期 ? RString.EMPTY : 普徴納期情報リスト5期.get納期終了日();
        source.ki6 = is納期限出力方法が0 ? RString.EMPTY : 普徴納期情報リストの六番目.get期().padLeft(RString.HALF_SPACE, 2);
        source.tsuki6 = is納期限出力方法が0 ? RString.EMPTY : 普徴納期情報リストの六番目.get月().padLeft(RString.HALF_SPACE, 2);
        source.nokiKaishi6 = null == 普徴納期情報リスト6期 ? RString.EMPTY : 普徴納期情報リスト6期.get納期開始日();
        source.nokiShuryo6 = null == 普徴納期情報リスト6期 ? RString.EMPTY : 普徴納期情報リスト6期.get納期終了日();
        source.ki7 = is納期限出力方法が0 ? RString.EMPTY : 普徴納期情報リストの七番目.get期().padLeft(RString.HALF_SPACE, 2);
        source.tsuki7 = is納期限出力方法が0 ? RString.EMPTY : 普徴納期情報リストの七番目.get月().padLeft(RString.HALF_SPACE, 2);
        source.nokiKaishi7 = null == 普徴納期情報リスト7期 ? RString.EMPTY : 普徴納期情報リスト7期.get納期開始日();
        source.nokiShuryo7 = null == 普徴納期情報リスト7期 ? RString.EMPTY : 普徴納期情報リスト7期.get納期終了日();
        source.ki8 = is納期限出力方法が0 ? RString.EMPTY : 普徴納期情報リストの八番目.get期().padLeft(RString.HALF_SPACE, 2);
        source.tsuki8 = is納期限出力方法が0 ? RString.EMPTY : 普徴納期情報リストの八番目.get月().padLeft(RString.HALF_SPACE, 2);
        source.nokiKaishi8 = null == 普徴納期情報リスト8期 ? RString.EMPTY : 普徴納期情報リスト8期.get納期開始日();
        source.nokiShuryo8 = null == 普徴納期情報リスト8期 ? RString.EMPTY : 普徴納期情報リスト8期.get納期終了日();
        source.ki9 = is納期限出力方法が0 ? RString.EMPTY : 普徴納期情報リストの九番目.get期().padLeft(RString.HALF_SPACE, 2);
        source.tsuki9 = is納期限出力方法が0 ? RString.EMPTY : 普徴納期情報リストの九番目.get月().padLeft(RString.HALF_SPACE, 2);
        source.nokiKaishi9 = null == 普徴納期情報リスト9期 ? RString.EMPTY : 普徴納期情報リスト9期.get納期開始日();
        source.nokiShuryo9 = null == 普徴納期情報リスト9期 ? RString.EMPTY : 普徴納期情報リスト9期.get納期終了日();
        source.ki10 = is納期限出力方法が0 ? RString.EMPTY : 普徴納期情報リストの十番目.get期().padLeft(RString.HALF_SPACE, 2);
        source.tsuki10 = is納期限出力方法が0 ? RString.EMPTY : 普徴納期情報リストの十番目.get月().padLeft(RString.HALF_SPACE, 2);
        source.nokiKaishi10 = null == 普徴納期情報リスト10期 ? RString.EMPTY : 普徴納期情報リスト10期.get納期開始日();
        source.nokiShuryo10 = null == 普徴納期情報リスト10期 ? RString.EMPTY : 普徴納期情報リスト10期.get納期終了日();
        source.HyojicodeName1 = RString.EMPTY;
        source.HyojicodeName2 = RString.EMPTY;
        source.HyojicodeName3 = RString.EMPTY;
        HyojiCodes 表示コード = null == 編集後本算定通知書共通情報.get表示コード() ? new HyojiCodes() : 編集後本算定通知書共通情報.get表示コード();
        source.hyojiKomoku1 = 表示コード.get表示コード名１();
        source.hyojiKomoku2 = 表示コード.get表示コード名２();
        source.hyojiKomoku3 = 表示コード.get表示コード名３();
        source.Hyojicode1 = 表示コード.get表示コード１();
        source.Hyojicode2 = 表示コード.get表示コード２();
        source.Hyojicode3 = 表示コード.get表示コード３();
        source.tsuchishoNo = 編集後本算定通知書共通情報.get通知書番号().getColumnValue();
        source.setaiCode = null;//編集後個人
        source.hihokenshaName = null;//編集後個人
        source.setaiNushiName = null;//編集後個人
        source.nendo = 編集後本算定通知書共通情報.get賦課年度_年度なし();
        source.nendo1 = 編集後本算定通知書共通情報.get賦課年度_年度あり();
        source.hokenryoGaku = new RString(更正後.get確定保険料_年額().toString());
        source.kisoKikanKaishi = 更正後.get期間_自();
        source.kisoKikanShuryo = 更正後.get期間_至();
        source.kisoTsukisu = 更正後.get月数_ケ月();
        source.kisoShotokuDankai = RStringUtil.convert半角to全角(更正後.get保険料段階());
        source.kisoHokenryoRitsu = new RString(更正後.get保険料率().toString());
        source.kisoCalHokenryoGaku = new RString(更正後.get減免前保険料_年額().toString());
        source.kisoGenmenGaku = new RString(更正後.get減免額().toString());
        source.tokuchoNofuSubekiGaku = new RString(編集後本算定通知書共通情報.get特徴既に納付すべき額().toString());
        source.fuchoNofuSubekiGaku = new RString(編集後本算定通知書共通情報.get普徴既に納付すべき額().toString());
        source.nofuZumiGaku = new RString(編集後本算定通知書共通情報.get納付済額_未到来期含む().toString());
        source.kongoNofuSubekiGaku = new RString(編集後本算定通知書共通情報.get今後納付すべき額().toString());
        source.santeiKisoTokiTitle = 普徴納期情報リストの一番目.get期();
        List<UniversalPhase> 普徴期別金額リスト = 更正後.get普徴期別金額リスト();
        int 期 = 納入通知書期情報.get期();
        source.santeiKisoTokiHokenryoGaku = new RString(get普徴期別金額By期(普徴期別金額リスト, 期).toString());
        source.santeiKisoJikiTitle = new RString("次期以降");
        source.santeiKisoJikoHokenryoGaku = new RString(get普徴期別金額By期(普徴期別金額リスト, 期 + 1).toString());
        source.bankName = null;//編集後口座
        source.kozaMeigi = null;//編集後口座
        source.bankCode = null;//編集後口座
        source.kozaShurui = null;//編集後口座
        source.kozaNo = null;//編集後口座
        source.renban = new RString(String.valueOf(連番)).padLeft("0", 6);
        source.hokenshaName = 編集後本算定通知書共通情報.get保険者名();
    }

    private Decimal get普徴期別金額By期(List<UniversalPhase> 普徴期別金額リスト, int 期) {
        for (UniversalPhase 普徴期別金額 : 普徴期別金額リスト) {
            if (普徴期別金額.get期() == 期) {
                return 普徴期別金額.get金額();
            }
        }
        return Decimal.ZERO;
    }

    private AfterEditInformation get普徴納期情報By期(List<AfterEditInformation> 普徴納期情報リスト, int 期) {
        for (AfterEditInformation 普徴納期情報 : 普徴納期情報リスト) {
            if (Integer.parseInt(普徴納期情報.get期().toString()) == 期) {
                return 普徴納期情報;
            }
        }
        return null;
    }

    private AfterEditInformation get普徴納期情報By番目(List<AfterEditInformation> 普徴納期情報リスト, int 番目) {
        return !普徴納期情報リスト.isEmpty() && 普徴納期情報リスト.size() >= 番目 + 1 ? 普徴納期情報リスト.get(番目) : new AfterEditInformation();
    }

    private boolean is納期限出力方法が0() {
        return NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(本算定納入通知書制御情報.get納入通知書制御情報().get納期限出力方法());
    }

}
