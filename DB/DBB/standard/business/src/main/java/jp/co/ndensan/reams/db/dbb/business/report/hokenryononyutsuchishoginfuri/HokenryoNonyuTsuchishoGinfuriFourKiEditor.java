/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishoginfuri;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.NotsuReportEditorUtil;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NofuShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NofugakuSanshutsuHoho;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFourKiSource;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKoza;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 保険料納入通知書（本算定）【銀振タイプ】帳票項目定義_4期 HokenryoNonyuTsuchishoGinfuriFourKiEditor
 *
 * @reamsid_L DBB-9110-090 huangh
 */
public class HokenryoNonyuTsuchishoGinfuriFourKiEditor implements IHokenryoNonyuTsuchishoGinfuriFourKiEditor {

    private final HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報;
    private final NinshoshaSource ninshoshaSource;
    private final List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト;
    private final int 連番;
    private final RString 円 = new RString("円");
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_6 = 6;
    private final RString 星_2 = new RString("**");
    private final RString 星_10 = new RString("**********");
    private final RString 星_6 = new RString("******");
    private final RString 星_9 = new RString("*********");
    private final RString 星_16 = new RString("****************");
    private final RString 星_17 = new RString("*****************");
    private final RString 星_12 = new RString("************");
    private final RString 星_11 = new RString("***********");
    private final RString 左括弧 = new RString("(");
    private final RString 右括弧 = new RString(")");
    private final RString 次期以降 = new RString("次期以降");

    /**
     * インスタンスを生成します。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @param ninshoshaSource 認証者情報
     * @param 納入通知書期情報リスト 納入通知書期情報リスト
     */
    public HokenryoNonyuTsuchishoGinfuriFourKiEditor(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報,
            NinshoshaSource ninshoshaSource, List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト) {
        this.本算定納入通知書情報 = 本算定納入通知書情報;
        this.ninshoshaSource = ninshoshaSource;
        this.納入通知書期情報リスト = 納入通知書期情報リスト;
        this.連番 = 本算定納入通知書情報.get連番();
    }

    @Override
    public HokenryoNonyuTsuchishoGinfuriFourKiSource edit(HokenryoNonyuTsuchishoGinfuriFourKiSource source) {
        NonyuTsuchiShoKiJoho 納入通知書期情報印字位置1 = get納入通知書期情報By印字位置(INT_1);
        NonyuTsuchiShoKiJoho 納入通知書期情報印字位置2 = get納入通知書期情報By印字位置(INT_2);
        NonyuTsuchiShoKiJoho 納入通知書期情報印字位置3 = get納入通知書期情報By印字位置(INT_3);
        NonyuTsuchiShoKiJoho 納入通知書期情報印字位置4 = get納入通知書期情報By印字位置(INT_4);
        editレイヤ１(source, 納入通知書期情報印字位置1,
                納入通知書期情報印字位置2, 納入通知書期情報印字位置3, 納入通知書期情報印字位置4);
        editCompNinshosha(source);
        editDBBCompNofushoItem(source, 納入通知書期情報印字位置1,
                納入通知書期情報印字位置2, 納入通知書期情報印字位置3, 納入通知書期情報印字位置4);
        editCompSofubutsuAtesaki(source);
        return source;
    }

    private void editCompSofubutsuAtesaki(HokenryoNonyuTsuchishoGinfuriFourKiSource source) {
        if (本算定納入通知書情報.get編集後本算定通知書共通情報() != null
                && 本算定納入通知書情報.get編集後本算定通知書共通情報().get編集後宛先() != null
                && 本算定納入通知書情報.get編集後本算定通知書共通情報().get編集後宛先().getSofubutsuAtesakiSource() != null) {
            SofubutsuAtesakiSource 送付物宛先ソース
                    = 本算定納入通知書情報.get編集後本算定通知書共通情報().get編集後宛先().getSofubutsuAtesakiSource().get送付物宛先ソース();
            if (null == 送付物宛先ソース) {
                return;
            }
            editCompSofubutsuAtesaki1(source, 送付物宛先ソース);
            editCompSofubutsuAtesaki2(source, 送付物宛先ソース);
        }
    }

    private void editCompSofubutsuAtesaki2(HokenryoNonyuTsuchishoGinfuriFourKiSource source, SofubutsuAtesakiSource 送付物宛先ソース) {
        source.yubinNo2 = 送付物宛先ソース.yubinNo;
        source.gyoseiku2 = 送付物宛先ソース.gyoseiku;
        source.jusho32 = 送付物宛先ソース.jusho3;
        source.jushoText2 = 送付物宛先ソース.jushoText;
        source.jusho22 = 送付物宛先ソース.jusho2;
        source.jusho12 = 送付物宛先ソース.jusho1;
        source.katagaki4 = 送付物宛先ソース.katagaki2;
        source.katagakiText2 = 送付物宛先ソース.katagakiText;
        source.katagakiSmall22 = 送付物宛先ソース.katagakiSmall2;
        source.katagaki3 = 送付物宛先ソース.katagaki1;
        source.katagakiSmall12 = 送付物宛先ソース.katagakiSmall1;
        source.shimei22 = 送付物宛先ソース.shimei2;
        source.shimeiSmall22 = 送付物宛先ソース.shimeiSmall2;
        source.shimeiText2 = 送付物宛先ソース.shimeiText;
        source.meishoFuyo22 = 送付物宛先ソース.meishoFuyo2;
        source.dainoKubunMei2 = 送付物宛先ソース.dainoKubunMei;
        source.shimei12 = 送付物宛先ソース.shimei1;
        source.shimeiSmall12 = 送付物宛先ソース.shimeiSmall1;
        source.meishoFuyo12 = 送付物宛先ソース.meishoFuyo1;
        source.kakkoLeft22 = 送付物宛先ソース.kakkoLeft2;
        source.samabunShimei22 = 送付物宛先ソース.samabunShimei2;
        source.samabunShimeiSmall22 = 送付物宛先ソース.samabunShimeiSmall2;
        source.samabunShimeiText2 = 送付物宛先ソース.samabunShimeiText;
        source.samaBun22 = 送付物宛先ソース.samaBun2;
        source.kakkoRight22 = 送付物宛先ソース.kakkoRight2;
        source.kakkoLeft12 = 送付物宛先ソース.kakkoLeft1;
        source.samabunShimei12 = 送付物宛先ソース.samabunShimei1;
        source.samabunShimeiSmall12 = 送付物宛先ソース.samabunShimeiSmall1;
        source.samaBun12 = 送付物宛先ソース.samaBun1;
        source.kakkoRight12 = 送付物宛先ソース.kakkoRight1;
        source.customerBarCode2 = 送付物宛先ソース.customerBarCode;
        //TODO 世帯主名  様方
    }

    private void editCompSofubutsuAtesaki1(HokenryoNonyuTsuchishoGinfuriFourKiSource source, SofubutsuAtesakiSource 送付物宛先ソース) {
        source.yubinNo1 = 送付物宛先ソース.yubinNo;
        source.gyoseiku1 = 送付物宛先ソース.gyoseiku;
        source.jusho31 = 送付物宛先ソース.jusho3;
        source.jushoText1 = 送付物宛先ソース.jushoText;
        source.jusho21 = 送付物宛先ソース.jusho2;
        source.jusho11 = 送付物宛先ソース.jusho1;
        source.katagaki2 = 送付物宛先ソース.katagaki2;
        source.katagakiText1 = 送付物宛先ソース.katagakiText;
        source.katagakiSmall21 = 送付物宛先ソース.katagakiSmall2;
        source.katagaki1 = 送付物宛先ソース.katagaki1;
        source.katagakiSmall11 = 送付物宛先ソース.katagakiSmall1;
        source.shimei21 = 送付物宛先ソース.shimei2;
        source.shimeiSmall21 = 送付物宛先ソース.shimeiSmall2;
        source.shimeiText1 = 送付物宛先ソース.shimeiText;
        source.meishoFuyo21 = 送付物宛先ソース.meishoFuyo2;
        source.dainoKubunMei1 = 送付物宛先ソース.dainoKubunMei;
        source.shimei11 = 送付物宛先ソース.shimei1;
        source.shimeiSmall11 = 送付物宛先ソース.shimeiSmall1;
        source.meishoFuyo11 = 送付物宛先ソース.meishoFuyo1;
        source.kakkoLeft21 = 送付物宛先ソース.kakkoLeft2;
        source.samabunShimei21 = 送付物宛先ソース.samabunShimei2;
        source.samabunShimeiSmall21 = 送付物宛先ソース.samabunShimeiSmall2;
        source.samabunShimeiText1 = 送付物宛先ソース.samabunShimeiText;
        source.samaBun21 = 送付物宛先ソース.samaBun2;
        source.kakkoRight21 = 送付物宛先ソース.kakkoRight2;
        source.kakkoLeft11 = 送付物宛先ソース.kakkoLeft1;
        source.samabunShimei11 = 送付物宛先ソース.samabunShimei1;
        source.samabunShimeiSmall11 = 送付物宛先ソース.samabunShimeiSmall1;
        source.samaBun11 = 送付物宛先ソース.samaBun1;
        source.kakkoRight11 = 送付物宛先ソース.kakkoRight1;
        source.customerBarCode1 = 送付物宛先ソース.customerBarCode;
        //TODO 世帯主名  様方
    }

    private void editDBBCompNofushoItem(HokenryoNonyuTsuchishoGinfuriFourKiSource source,
            NonyuTsuchiShoKiJoho 納入通知書期情報印字位置1,
            NonyuTsuchiShoKiJoho 納入通知書期情報印字位置2,
            NonyuTsuchiShoKiJoho 納入通知書期情報印字位置3,
            NonyuTsuchiShoKiJoho 納入通知書期情報印字位置4) {
        NofuShoKyotsu 納付書共通 = 本算定納入通知書情報.get納付書共通();
        if (null == 納付書共通) {
            納付書共通 = new NofuShoKyotsu();
        }
        editDBBCompNofushoItem_納入通知書期情報(source, 納入通知書期情報印字位置1,
                納入通知書期情報印字位置2, 納入通知書期情報印字位置3, 納入通知書期情報印字位置4, 納付書共通);
        source.nofushoNendo4 = RString.EMPTY;
        source.nofushoNendo3 = RString.EMPTY;
        source.nofushoNendo2 = RString.EMPTY;
        source.nofushoNendo1 = RString.EMPTY;
        source.nofushoSofusakiName4 = 納付書共通.get納付者氏名();
        source.nofushoSofusakiName3 = 納付書共通.get納付者氏名();
        source.nofushoSofusakiName2 = 納付書共通.get納付者氏名();
        source.nofushoSofusakiName1 = 納付書共通.get納付者氏名();
        source.nofushoHonninName4 = 納付書共通.get被代納人氏名();
        source.nofushoHonninName3 = 納付書共通.get被代納人氏名();
        source.nofushoHonninName2 = 納付書共通.get被代納人氏名();
        source.nofushoHonninName1 = 納付書共通.get被代納人氏名();
        if (納付書共通.get被代納人氏名() != null && !納付書共通.get被代納人氏名().isEmpty()) {
            source.nofushoKakko14 = 左括弧;
            source.nofushoKakko13 = 左括弧;
            source.nofushoKakko12 = 左括弧;
            source.nofushoKakko11 = 左括弧;
            source.nofushoKakko34 = 納付書共通.get被代納人敬称().concat(右括弧);
            source.nofushoKakko33 = 納付書共通.get被代納人敬称().concat(右括弧);
            source.nofushoKakko32 = 納付書共通.get被代納人敬称().concat(右括弧);
            source.nofushoKakko31 = 納付書共通.get被代納人敬称().concat(右括弧);
        } else {
            source.nofushoKakko14 = RString.EMPTY;
            source.nofushoKakko13 = RString.EMPTY;
            source.nofushoKakko12 = RString.EMPTY;
            source.nofushoKakko11 = RString.EMPTY;
            source.nofushoKakko34 = RString.EMPTY;
            source.nofushoKakko33 = RString.EMPTY;
            source.nofushoKakko32 = RString.EMPTY;
            source.nofushoKakko31 = RString.EMPTY;
        }
        source.nofushoKakko24 = RString.EMPTY;
        source.nofushoKakko23 = RString.EMPTY;
        source.nofushoKakko22 = RString.EMPTY;
        source.nofushoKakko21 = RString.EMPTY;
        if (納付書共通.get通知書番号() != null) {
            source.nofushoTsuchishoNo4 = 納付書共通.get通知書番号().getColumnValue();
            source.nofushoTsuchishoNo3 = 納付書共通.get通知書番号().getColumnValue();
            source.nofushoTsuchishoNo2 = 納付書共通.get通知書番号().getColumnValue();
            source.nofushoTsuchishoNo1 = 納付書共通.get通知書番号().getColumnValue();
        }
        if (納付書共通.get世帯コード() != null) {
            source.nofushoSetaiCode4 = 納付書共通.get世帯コード().getColumnValue();
            source.nofushoSetaiCode3 = 納付書共通.get世帯コード().getColumnValue();
            source.nofushoSetaiCode2 = 納付書共通.get世帯コード().getColumnValue();
            source.nofushoSetaiCode1 = 納付書共通.get世帯コード().getColumnValue();
        }
        HyojiCodes 表示コード = 納付書共通.get表示コード();
        if (表示コード != null) {
            source.nofushohyojicodeName14 = 表示コード.get表示コード名１();
            source.nofushohyojicodeName13 = 表示コード.get表示コード名１();
            source.nofushohyojicodeName12 = 表示コード.get表示コード名１();
            source.nofushohyojicodeName11 = 表示コード.get表示コード名１();
            source.nofushohyojicode14 = 表示コード.get表示コード１();
            source.nofushohyojicode13 = 表示コード.get表示コード１();
            source.nofushohyojicode12 = 表示コード.get表示コード１();
            source.nofushohyojicode11 = 表示コード.get表示コード１();
            source.nofushohyojicodeName24 = 表示コード.get表示コード名２();
            source.nofushohyojicodeName23 = 表示コード.get表示コード名２();
            source.nofushohyojicodeName22 = 表示コード.get表示コード名２();
            source.nofushohyojicodeName21 = 表示コード.get表示コード名２();
            source.nofushohyojicode24 = 表示コード.get表示コード２();
            source.nofushohyojicode23 = 表示コード.get表示コード２();
            source.nofushohyojicode22 = 表示コード.get表示コード２();
            source.nofushohyojicode21 = 表示コード.get表示コード２();
            source.nofushohyojicodeName34 = 表示コード.get表示コード名３();
            source.nofushohyojicodeName33 = 表示コード.get表示コード名３();
            source.nofushohyojicodeName32 = 表示コード.get表示コード名３();
            source.nofushohyojicodeName31 = 表示コード.get表示コード名３();
            source.nofushohyojicode34 = 表示コード.get表示コード３();
            source.nofushohyojicode33 = 表示コード.get表示コード３();
            source.nofushohyojicode32 = 表示コード.get表示コード３();
            source.nofushohyojicode31 = 表示コード.get表示コード３();
        }
        if (ShoriKubun.バッチ.equals(本算定納入通知書情報.get処理区分())) {
            source.mRenban = new RString(連番).padLeft("0", INT_6);
        }
        source.nofushoShichosonMei14 = 納付書共通.get納付書市町村名();
        source.nofushoShichosonMei13 = 納付書共通.get納付書市町村名();
        source.nofushoShichosonMei12 = 納付書共通.get納付書市町村名();
        source.nofushoShichosonMei11 = 納付書共通.get納付書市町村名();
    }

    private void editDBBCompNofushoItem_納入通知書期情報(HokenryoNonyuTsuchishoGinfuriFourKiSource source,
            NonyuTsuchiShoKiJoho 納入通知書期情報印字位置1,
            NonyuTsuchiShoKiJoho 納入通知書期情報印字位置2,
            NonyuTsuchiShoKiJoho 納入通知書期情報印字位置3,
            NonyuTsuchiShoKiJoho 納入通知書期情報印字位置4,
            NofuShoKyotsu 納付書共通) {
        if (null == 納入通知書期情報印字位置4) {
            source.nofushoKanendo4 = 星_6;
            source.nofushoKanendobun4 = 星_9;
            source.nofushoKi4 = 星_2;
            source.nofushoTsuki4 = 星_2;
            source.nofushoOcr14 = 星_6;
            source.nofushoOcr24 = 星_16;
            source.nofushoOcr34 = 星_17;
            source.nofushoOcr44 = 星_12;
            source.nofushoNofugaku4 = 星_10;
            source.nofushoNokigen4 = 星_11;
            source.nofushoNofuin4 = 星_2;
            source.nofushoRyoshuHizukein4 = RString.EMPTY;
            source.nofushoZuiji4 = RString.EMPTY;
        } else {
            if (納付書共通.get調定年度表記() != null) {
                source.nofushoKanendo4 = RStringUtil.convert半角to全角(納付書共通.get調定年度表記());
            }
            if (納付書共通.get賦課年度表記() != null) {
                source.nofushoKanendobun4 = 半角to全角(納付書共通.get賦課年度表記());
            }
            source.nofushoKi4 = 納入通知書期情報印字位置4.get期表記();
            source.nofushoTsuki4 = 納入通知書期情報印字位置4.get月表記();
            source.nofushoOcr14 = get印字文字列By行目(INT_1, 納入通知書期情報印字位置4.getOcr());
            source.nofushoOcr24 = get印字文字列By行目(INT_2, 納入通知書期情報印字位置4.getOcr());
            source.nofushoOcr34 = get印字文字列By行目(INT_3, 納入通知書期情報印字位置4.getOcr());
            source.nofushoOcr44 = get印字文字列By行目(INT_4, 納入通知書期情報印字位置4.getOcr());
            source.nofushoNofugaku4 = 納入通知書期情報印字位置4.get納付書納付額欄();
            source.nofushoNokigen4 = 納入通知書期情報印字位置4.get納期限表記();
            source.nofushoNofuin4 = 納入通知書期情報印字位置4.get領収日付欄();
            source.nofushoRyoshuHizukein4 = 納入通知書期情報印字位置4.get納付書領収印欄();
            source.nofushoZuiji4 = 納入通知書期情報印字位置4.get随時表記();
        }
        if (null == 納入通知書期情報印字位置3) {
            source.nofushoKanendo3 = 星_6;
            source.nofushoKanendobun3 = 星_9;
            source.nofushoKi3 = 星_2;
            source.nofushoTsuki3 = 星_2;
            source.nofushoOcr13 = 星_6;
            source.nofushoOcr23 = 星_16;
            source.nofushoOcr33 = 星_17;
            source.nofushoOcr43 = 星_12;
            source.nofushoNofugaku3 = 星_10;
            source.nofushoNokigen3 = 星_11;
            source.nofushoNofuin3 = 星_2;
            source.nofushoRyoshuHizukein3 = RString.EMPTY;
            source.nofushoZuiji3 = RString.EMPTY;
        } else {
            if (納付書共通.get調定年度表記() != null) {
                source.nofushoKanendo3 = RStringUtil.convert半角to全角(納付書共通.get調定年度表記());
            }
            if (納付書共通.get賦課年度表記() != null) {
                source.nofushoKanendobun3 = 半角to全角(納付書共通.get賦課年度表記());
            }
            source.nofushoKi3 = 納入通知書期情報印字位置3.get期表記();
            source.nofushoTsuki3 = 納入通知書期情報印字位置3.get月表記();
            source.nofushoOcr13 = get印字文字列By行目(INT_1, 納入通知書期情報印字位置3.getOcr());
            source.nofushoOcr23 = get印字文字列By行目(INT_2, 納入通知書期情報印字位置3.getOcr());
            source.nofushoOcr33 = get印字文字列By行目(INT_3, 納入通知書期情報印字位置3.getOcr());
            source.nofushoOcr43 = get印字文字列By行目(INT_4, 納入通知書期情報印字位置3.getOcr());
            source.nofushoNofugaku3 = 納入通知書期情報印字位置3.get納付書納付額欄();
            source.nofushoNokigen3 = 納入通知書期情報印字位置3.get納期限表記();
            source.nofushoNofuin3 = 納入通知書期情報印字位置3.get領収日付欄();
            source.nofushoRyoshuHizukein3 = 納入通知書期情報印字位置3.get納付書領収印欄();
            source.nofushoZuiji3 = 納入通知書期情報印字位置3.get随時表記();
        }
        if (null == 納入通知書期情報印字位置2) {
            source.nofushoKanendo2 = 星_6;
            source.nofushoKanendobun2 = 星_9;
            source.nofushoKi2 = 星_2;
            source.nofushoTsuki2 = 星_2;
            source.nofushoOcr12 = 星_6;
            source.nofushoOcr22 = 星_16;
            source.nofushoOcr32 = 星_17;
            source.nofushoOcr42 = 星_12;
            source.nofushoNofugaku2 = 星_10;
            source.nofushoNokigen2 = 星_11;
            source.nofushoNofuin2 = 星_2;
            source.nofushoRyoshuHizukein2 = RString.EMPTY;
            source.nofushoZuiji2 = RString.EMPTY;
        } else {
            if (納付書共通.get調定年度表記() != null) {
                source.nofushoKanendo2 = RStringUtil.convert半角to全角(納付書共通.get調定年度表記());
            }
            if (納付書共通.get賦課年度表記() != null) {
                source.nofushoKanendobun2 = 半角to全角(納付書共通.get賦課年度表記());
            }
            source.nofushoKi2 = 納入通知書期情報印字位置2.get期表記();
            source.nofushoTsuki2 = 納入通知書期情報印字位置2.get月表記();
            source.nofushoOcr12 = get印字文字列By行目(INT_1, 納入通知書期情報印字位置2.getOcr());
            source.nofushoOcr22 = get印字文字列By行目(INT_2, 納入通知書期情報印字位置2.getOcr());
            source.nofushoOcr32 = get印字文字列By行目(INT_3, 納入通知書期情報印字位置2.getOcr());
            source.nofushoOcr42 = get印字文字列By行目(INT_4, 納入通知書期情報印字位置2.getOcr());
            source.nofushoNofugaku2 = 納入通知書期情報印字位置2.get納付書納付額欄();
            source.nofushoNokigen2 = 納入通知書期情報印字位置2.get納期限表記();
            source.nofushoNofuin2 = 納入通知書期情報印字位置2.get領収日付欄();
            source.nofushoRyoshuHizukein2 = 納入通知書期情報印字位置2.get納付書領収印欄();
            source.nofushoZuiji2 = 納入通知書期情報印字位置2.get随時表記();
        }
        if (null == 納入通知書期情報印字位置1) {
            source.nofushoKanendo1 = 星_6;
            source.nofushoKanendobun1 = 星_9;
            source.nofushoKi1 = 星_2;
            source.nofushoTsuki1 = 星_2;
            source.nofushoOcr11 = 星_6;
            source.nofushoOcr21 = 星_16;
            source.nofushoOcr31 = 星_17;
            source.nofushoOcr41 = 星_12;
            source.nofushoNofugaku1 = 星_10;
            source.nofushoNokigen1 = 星_11;
            source.nofushoNofuin1 = 星_2;
            source.nofushoRyoshuHizukein1 = RString.EMPTY;
            source.nofushoZuiji1 = RString.EMPTY;
        } else {
            if (納付書共通.get調定年度表記() != null) {
                source.nofushoKanendo1 = RStringUtil.convert半角to全角(納付書共通.get調定年度表記());
            }
            if (納付書共通.get賦課年度表記() != null) {
                source.nofushoKanendobun1 = 半角to全角(納付書共通.get賦課年度表記());
            }
            source.nofushoKi1 = 納入通知書期情報印字位置1.get期表記();
            source.nofushoTsuki1 = 納入通知書期情報印字位置1.get月表記();
            source.nofushoOcr11 = get印字文字列By行目(INT_1, 納入通知書期情報印字位置1.getOcr());
            source.nofushoOcr21 = get印字文字列By行目(INT_2, 納入通知書期情報印字位置1.getOcr());
            source.nofushoOcr31 = get印字文字列By行目(INT_3, 納入通知書期情報印字位置1.getOcr());
            source.nofushoOcr41 = get印字文字列By行目(INT_4, 納入通知書期情報印字位置1.getOcr());
            source.nofushoNofugaku1 = 納入通知書期情報印字位置1.get納付書納付額欄();
            source.nofushoNokigen1 = 納入通知書期情報印字位置1.get納期限表記();
            source.nofushoNofuin1 = 納入通知書期情報印字位置1.get領収日付欄();
            source.nofushoRyoshuHizukein1 = 納入通知書期情報印字位置1.get納付書領収印欄();
            source.nofushoZuiji1 = 納入通知書期情報印字位置1.get随時表記();
        }
    }

    private RString get印字文字列By行目(int 行目, Map<Integer, RString> ocr) {
        if (ocr != null) {
            return null == ocr.get(行目) ? RString.EMPTY : ocr.get(行目);
        }
        return RString.EMPTY;
    }

    private RString 半角to全角(RString value) {
        if (null == value) {
            return RString.EMPTY;
        }
        return RStringUtil.convert半角to全角(value);
    }

    private void editCompNinshosha(HokenryoNonyuTsuchishoGinfuriFourKiSource source) {
        source.hakkoYMD = ninshoshaSource.hakkoYMD;
        source.ninshoshaYakushokuMei1 = ninshoshaSource.ninshoshaYakushokuMei1;
        source.ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
        source.denshiKoin = ninshoshaSource.denshiKoin;
        source.ninshoshaYakushokuMei2 = ninshoshaSource.ninshoshaYakushokuMei2;
        source.koinMojiretsu = ninshoshaSource.koinMojiretsu;
        source.ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
        source.ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
        source.koinShoryaku = ninshoshaSource.koinShoryaku;
    }

    private void editレイヤ１(HokenryoNonyuTsuchishoGinfuriFourKiSource source,
            NonyuTsuchiShoKiJoho 納入通知書期情報印字位置1,
            NonyuTsuchiShoKiJoho 納入通知書期情報印字位置2,
            NonyuTsuchiShoKiJoho 納入通知書期情報印字位置3,
            NonyuTsuchiShoKiJoho 納入通知書期情報印字位置4) {
        editレイヤ１_編集後本算定通知書共通情報(source);
        editレイヤ１_納入通知書期情報(source, 納入通知書期情報印字位置1, 納入通知書期情報印字位置2, 納入通知書期情報印字位置3, 納入通知書期情報印字位置4);
        if (ShoriKubun.バッチ.equals(本算定納入通知書情報.get処理区分())) {
            source.renban = new RString(連番).padLeft("0", INT_6);
        }

    }

    private void editレイヤ１_納入通知書期情報(HokenryoNonyuTsuchishoGinfuriFourKiSource source,
            NonyuTsuchiShoKiJoho 納入通知書期情報印字位置1,
            NonyuTsuchiShoKiJoho 納入通知書期情報印字位置2,
            NonyuTsuchiShoKiJoho 納入通知書期情報印字位置3,
            NonyuTsuchiShoKiJoho 納入通知書期情報印字位置4) {
        NonyuTsuchiShoKiJoho 一番目の納入通知書期情報 = 納入通知書期情報リスト.get(0);
        NonyuTsuchiShoKiJoho 二番目の納入通知書期情報 = 納入通知書期情報リスト.size() > INT_1 ? 納入通知書期情報リスト.get(INT_1) : null;
        NonyuTsuchiShoKiJoho 三番目の納入通知書期情報 = 納入通知書期情報リスト.size() > INT_2 ? 納入通知書期情報リスト.get(INT_2) : null;
        NonyuTsuchiShoKiJoho 四番目の納入通知書期情報 = 納入通知書期情報リスト.size() > INT_3 ? 納入通知書期情報リスト.get(INT_3) : null;
        source.ki1 = 一番目の納入通知書期情報.get期表記();
        source.tsuki1 = 一番目の納入通知書期情報.get月表記();
        source.nokiKaishi1 = 一番目の納入通知書期情報.get納期開始日表記();
        source.nokiShuryo1 = 一番目の納入通知書期情報.get納期終了日表記();
        if (二番目の納入通知書期情報 != null) {
            source.ki2 = 二番目の納入通知書期情報.get期表記();
            source.tsuki2 = 二番目の納入通知書期情報.get月表記();
            source.nokiKaishi2 = 二番目の納入通知書期情報.get納期開始日表記();
            source.nokiShuryo2 = 二番目の納入通知書期情報.get納期終了日表記();
        }
        if (三番目の納入通知書期情報 != null) {
            source.ki3 = 三番目の納入通知書期情報.get期表記();
            source.tsuki3 = 三番目の納入通知書期情報.get月表記();
            source.nokiKaishi3 = 三番目の納入通知書期情報.get納期開始日表記();
            source.nokiShuryo3 = 三番目の納入通知書期情報.get納期終了日表記();
        }
        if (四番目の納入通知書期情報 != null) {
            source.ki4 = 四番目の納入通知書期情報.get期表記();
            source.tsuki4 = 四番目の納入通知書期情報.get月表記();
            source.nokiKaishi4 = 四番目の納入通知書期情報.get納期開始日表記();
            source.nokiShuryo4 = 四番目の納入通知書期情報.get納期終了日表記();
        }
        edit通知開始終了期(source);
        if (null == 納入通知書期情報印字位置1) {
            source.ryoshushoKi1 = 星_2;
            source.ryoshushoNofuGaku1 = 星_10;
            source.ryoshushoRyoshuHizukein1 = RString.EMPTY;
            source.ryoshushoNofuin1 = 星_2;
            source.ryoshushoZuiji1 = RString.EMPTY;
        } else {
            source.ryoshushoKi1 = 納入通知書期情報印字位置1.get領収書日付欄期月();
            source.ryoshushoNofuGaku1 = 納入通知書期情報印字位置1.get領収証書納付額欄();
            source.ryoshushoRyoshuHizukein1 = 納入通知書期情報印字位置1.get領収証書領収印欄();
            source.ryoshushoNofuin1 = 納入通知書期情報印字位置1.get領収日付印欄();
            source.ryoshushoZuiji1 = 納入通知書期情報印字位置1.get随時表記();
        }
        if (null == 納入通知書期情報印字位置2) {
            source.ryoshushoKi2 = 星_2;
            source.ryoshushoNofuGaku2 = 星_10;
            source.ryoshushoRyoshuHizukein2 = RString.EMPTY;
            source.ryoshushoNofuin2 = 星_2;
            source.ryoshushoZuiji2 = RString.EMPTY;
        } else {
            source.ryoshushoKi2 = 納入通知書期情報印字位置2.get領収書日付欄期月();
            source.ryoshushoNofuGaku2 = 納入通知書期情報印字位置2.get領収証書納付額欄();
            source.ryoshushoRyoshuHizukein2 = 納入通知書期情報印字位置2.get領収証書領収印欄();
            source.ryoshushoNofuin2 = 納入通知書期情報印字位置2.get領収日付印欄();
            source.ryoshushoZuiji2 = 納入通知書期情報印字位置2.get随時表記();
        }
        if (null == 納入通知書期情報印字位置3) {
            source.ryoshushoKi3 = 星_2;
            source.ryoshushoNofuGaku3 = 星_10;
            source.ryoshushoRyoshuHizukein3 = RString.EMPTY;
            source.ryoshushoNofuin3 = 星_2;
            source.ryoshushoZuiji3 = RString.EMPTY;
        } else {
            source.ryoshushoKi3 = 納入通知書期情報印字位置3.get領収書日付欄期月();
            source.ryoshushoNofuGaku3 = 納入通知書期情報印字位置3.get領収証書納付額欄();
            source.ryoshushoRyoshuHizukein3 = 納入通知書期情報印字位置3.get領収証書領収印欄();
            source.ryoshushoNofuin3 = 納入通知書期情報印字位置3.get領収日付印欄();
            source.ryoshushoZuiji3 = 納入通知書期情報印字位置3.get随時表記();
        }
        if (null == 納入通知書期情報印字位置4) {
            source.ryoshushoKi4 = 星_2;
            source.ryoshushoNofuGaku4 = 星_10;
            source.ryoshushoRyoshuHizukein4 = RString.EMPTY;
            source.ryoshushoNofuin4 = 星_2;
            source.ryoshushoZuiji4 = RString.EMPTY;
        } else {
            source.ryoshushoKi4 = 納入通知書期情報印字位置4.get領収書日付欄期月();
            source.ryoshushoNofuGaku4 = 納入通知書期情報印字位置4.get領収証書納付額欄();
            source.ryoshushoRyoshuHizukein4 = 納入通知書期情報印字位置4.get領収証書領収印欄();
            source.ryoshushoNofuin4 = 納入通知書期情報印字位置4.get領収日付印欄();
            source.ryoshushoZuiji4 = 納入通知書期情報印字位置4.get随時表記();
        }
    }

    private NonyuTsuchiShoKiJoho get納入通知書期情報By印字位置(int 印字位置) {
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            if (納入通知書期情報.get銀振印字位置() == 印字位置) {
                return 納入通知書期情報;
            }
        }
        return null;
    }

    private void edit通知開始終了期(HokenryoNonyuTsuchishoGinfuriFourKiSource source) {
        List<Kitsuki> 出力期リスト = 本算定納入通知書情報.get出力期リスト();
        if (出力期リスト != null && !出力期リスト.isEmpty()) {
            int 最小の期 = 出力期リスト.get(0).get期AsInt();
            int 最大の期 = 出力期リスト.get(0).get期AsInt();
            for (Kitsuki 出力期 : 出力期リスト) {
                if (出力期.get期AsInt() < 最小の期) {
                    最小の期 = 出力期.get期AsInt();
                }
                if (出力期.get期AsInt() > 最大の期) {
                    最大の期 = 出力期.get期AsInt();
                }
            }
            source.tsuchiKaishiKi = new RString(最小の期);
            source.tsuchiShuryoKi = new RString(最大の期);
        }
    }

    private void editレイヤ１_編集後本算定通知書共通情報(HokenryoNonyuTsuchishoGinfuriFourKiSource source) {
        source.titleNendo = RString.EMPTY;
        source.nendo1 = RString.EMPTY;
        source.santeiKisoKomokuTitle2 = RString.EMPTY;
        source.santeiKisoTokiHokenryoGaku2 = RString.EMPTY;
        source.gekihenTitle = RString.EMPTY;
        source.santeiKisoKomokuTitle4 = RString.EMPTY;
        source.gekihenMongon = RString.EMPTY;
        source.santeiKisoJikiHokenryoGaku2 = RString.EMPTY;
        source.ryoshushoNendo = RString.EMPTY;
        source.santeiKisoYen1 = 円;
        source.santeiKisoYen2 = 円;
        List<Kitsuki> 出力期リスト = 本算定納入通知書情報.get出力期リスト();
        EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 = 本算定納入通知書情報.get編集後本算定通知書共通情報();
        EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正後 = null;
        if (編集後本算定通知書共通情報 != null) {
            更正後 = 編集後本算定通知書共通情報.get更正後();
        }
        edit算定基礎保険料額(source, 出力期リスト, 更正後);
        if (null == 編集後本算定通知書共通情報) {
            return;
        }
        if (編集後本算定通知書共通情報.get調定年度_年度なし() != null) {
            source.titleKanendo = 半角to全角(編集後本算定通知書共通情報.get調定年度_年度なし());
            source.ryoshushoKanendo = 半角to全角(編集後本算定通知書共通情報.get調定年度_年度なし());
        }
        source.titleKanendoBun = RString.EMPTY;
        source.ryoshushoKanendoBun = RString.EMPTY;
        HyojiCodes 表示コード = 編集後本算定通知書共通情報.get表示コード();
        if (表示コード != null) {
            source.hyojicodeName1 = 表示コード.get表示コード名１();
            source.hyojicodeName2 = 表示コード.get表示コード名２();
            source.hyojicodeName3 = 表示コード.get表示コード名３();
            source.hyojicode1 = 表示コード.get表示コード１();
            source.hyojicode2 = 表示コード.get表示コード２();
            source.hyojicode3 = 表示コード.get表示コード３();
        }
        if (編集後本算定通知書共通情報.get通知書番号() != null) {
            source.tsuchishoNo = 編集後本算定通知書共通情報.get通知書番号().getColumnValue();
        }
        source.nendoKa = 編集後本算定通知書共通情報.get賦課年度_年度なし();
        if (更正後 != null) {
            source.hokenryoGaku = NotsuReportEditorUtil.get共通ポリシー金額1(更正後.get確定保険料_年額());
            source.santeiKisoCalHokenryoGaku = NotsuReportEditorUtil.get共通ポリシー金額1(更正後.get確定保険料_年額());
            source.santeiKisoKikanKaishi = 更正後.get期間_自();
            source.santeiKisoKiaknShuryo = 更正後.get期間_至();
            if (更正後.get月数_ケ月() != null) {
                source.santeiKisoNokisu = 半角to全角(更正後.get月数_ケ月());
            }
            if (更正後.get保険料段階() != null) {
                source.santeiKisoShotokuDankai = 半角to全角(更正後.get保険料段階());
            }
            source.santeiKisoHokenryoRitsu = NotsuReportEditorUtil.get共通ポリシー金額1(更正後.get保険料率());
            source.santeiKisoGenmenGaku = NotsuReportEditorUtil.get共通ポリシー金額1(更正後.get減免額());
            source.santeiKisoTokuchoNofuSubekiGaku = NotsuReportEditorUtil.get共通ポリシー金額1(更正後.get特別徴収額合計());
            source.santeiKisoFuchoNofuSubekiGaku = NotsuReportEditorUtil.get共通ポリシー金額1(更正後.get普通徴収額合計());
        }
        HonSanteiNonyuTsuchiShoSeigyoJoho 本算定納入通知書制御情報 = 本算定納入通知書情報.get本算定納入通知書制御情報();
        if (本算定納入通知書制御情報 != null && 本算定納入通知書制御情報.get納入通知書制御情報() != null) {
            if (NofugakuSanshutsuHoho.収入額をもとに算出.equals(本算定納入通知書制御情報.get納入通知書制御情報().get納付額算出方法())) {
                source.santeiKisoNofuzumiGaku
                        = NotsuReportEditorUtil.get共通ポリシー金額1(編集後本算定通知書共通情報.get普徴納付済額_未到来期含む());
                source.santeiKisoKongoNofuSubekiGaku
                        = NotsuReportEditorUtil.get共通ポリシー金額1(編集後本算定通知書共通情報.get普徴今後納付すべき額_収入元に());
            } else if (NofugakuSanshutsuHoho.調定額をもとに算出.equals(本算定納入通知書制御情報.get納入通知書制御情報().get納付額算出方法())) {
                source.santeiKisoNofuzumiGaku
                        = NotsuReportEditorUtil.get共通ポリシー金額1(編集後本算定通知書共通情報.get普徴既に納付すべき額());
                source.santeiKisoKongoNofuSubekiGaku
                        = NotsuReportEditorUtil.get共通ポリシー金額1(編集後本算定通知書共通情報.get普徴今後納付すべき額_調定元に());
            }
        }
        EditedKojin 編集後個人 = 編集後本算定通知書共通情報.get編集後個人();
        EditedKoza 編集後口座 = 編集後本算定通知書共通情報.get編集後口座();
        edit編集後口座And編集後個人(source, 編集後個人, 編集後口座);
        source.hokenshaName = 編集後本算定通知書共通情報.get保険者名();
    }

    private void edit算定基礎保険料額(HokenryoNonyuTsuchishoGinfuriFourKiSource source, List<Kitsuki> 出力期リスト,
            EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正後) {
        if (出力期リスト != null && !出力期リスト.isEmpty()) {
            Kitsuki 出力期リストの一番目 = 出力期リスト.get(0);
            if (出力期リストの一番目 != null && 出力期リストの一番目.get期() != null) {
                source.santeiKisoKomokuTitle1 = new RString("第").concat(出力期リストの一番目.get期()).concat("期");
            }
            List<UniversalPhase> 普徴期別金額リスト = new ArrayList<>();
            if (更正後 != null) {
                普徴期別金額リスト = 更正後.get普徴期別金額リスト();
            }
            if (出力期リストの一番目 != null) {
                source.santeiKisoTokiHokenryoGaku1
                        = NotsuReportEditorUtil.get共通ポリシー金額1(get金額From普徴期別金額リスト(普徴期別金額リスト, 出力期リストの一番目.get期AsInt()));
            }
            if (出力期リスト.size() > 1 && 出力期リスト.get(1) != null) {
                source.santeiKisoKomokuTitle3 = 次期以降;
                source.santeiKisoJikiHokenryoGaku1 = NotsuReportEditorUtil
                        .get共通ポリシー金額1(get金額From普徴期別金額リスト(普徴期別金額リスト, 出力期リスト.get(1).get期AsInt()));
            }
        }
    }

    private void edit編集後口座And編集後個人(
            HokenryoNonyuTsuchishoGinfuriFourKiSource source, EditedKojin 編集後個人, EditedKoza 編集後口座) {
        if (編集後個人 != null) {
            source.hihokenshaName = 編集後個人.get名称().getKana().getColumnValue();
            source.setaiCode = 編集後個人.get世帯コード().getColumnValue();
            source.setaiNushiName = 編集後個人.get世帯主名().getColumnValue();
        }
        if (編集後口座 != null) {
            source.bankCode = 編集後口座.get金融機関コードCombinedWith支店コード();
            source.bankName = 編集後口座.get金融機関名CombinedWith支店名();
            source.kozaMeigi = 編集後口座.get口座名義人優先();
            source.kozaShurui = 編集後口座.get口座種別略称();
            source.kozaNo = 編集後口座.get口座番号Or通帳記号番号();
        }
    }

    private Decimal get金額From普徴期別金額リスト(List<UniversalPhase> 普徴期別金額リスト, int 期) {
        if (null == 普徴期別金額リスト) {
            return null;
        }
        for (UniversalPhase 普徴期別金額 : 普徴期別金額リスト) {
            if (普徴期別金額.get期() == 期) {
                return 普徴期別金額.get金額();
            }
        }
        return null;
    }

}
