/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.iraisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.HomonChosaIraishoProcessParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.NinteiChosaIraiProcessParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.ShujiiIkenshoSakuseiProcessParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 依頼書一括発行のバッチパラメータクラスです。
 *
 * @reamsid_L DBE-0080-160 duanzhanli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IraishoIkkatsuHakkoBatchParamter extends BatchParameterBase {

    private static final long serialVersionUID = 5290964985893247352L;
    private static final String IRAIFROMYMD = "iraibiFrom";
    private static final String IRAITOYMD = "iraibiTo";
    private static final String NINTEIO_CHOSA_IRAISHO = "ninteioChosaIraisho";
    private static final String NINTEI_CHOSAHYO = "ninteiChosahyo";
    private static final String SHUJIIIKENSHO_SAKUSEI_IRAI = "shujiiIkenshoSakuseiIraisho";
    private static final String SHUJIIIKENSHO = "shujiiIkensho";
    private static final String HAKKOBI = "hakkobi";
    private static final String TEISHUTSU_KIGEN = "teishutsuKigen";
    private static final String KYOTSU_HIZUKE = "kyotsuHizuke";
    private static final String NINTEI_CHOSA_IRAI_CHOHYO = "ninteiChosaIraiChohyo";
    private static final String NINTEI_CHOSA_IRAISHO = "ninteiChosaIraisyo";
    private static final String NINTEI_CHOSAHYO_KIHON = "ninteiChosahyoKihon";
    private static final String NINTEI_CHOSAHYO_TOKKI = "ninteiChosahyoTokki";
    private static final String NINTEI_CHOSAHYO_GAIKYOU = "ninteiChosahyoGaikyou";
    private static final String NINTEI_CHOSAHYO_OCR_KIHON = "ninteiChosahyoOCRKihon";
    private static final String NINTEI_CHOSAHYO_OCR_TOKKI = "ninteiChosahyoOCRTokki";
    private static final String NINTEI_CHOSAHYO_OCR_GAIKYOU = "ninteiChosahyoOCRGaikyou";
    private static final String NINTEI_CHOSA_CHECK_HYO = "ninteiChosaCheckHyo";
    private static final String GAIKYOCHOSA = "gaikyoChosa";
    private static final String GAIKYOCHOSAOCR = "gaikyoChosaOCR";
    private static final String ZENKO_NINTEI_CHOSAHYO = "zenkoNinteiChosahyo";
    private static final String NINTEI_CHOSAIRAI_HAKKOU = "ninteiChosairaiHakkou";
    private static final String IKENSHO_SAKUSEIIRAI = "ikenshoSakuseiirai";
    private static final String IKENSHO_SAKUSEI_SEIKYUU = "ikenshoSakuseiSeikyuu";
    private static final String IKENSHO_SAKUSEI_IRAISHO = "shujiiIkenshoSakuseiIraisho";
    private static final String IKENSHO_KINYUU = "ikenshoKinyuu";
    private static final String IKENSHO_KINYUU_OCR = "ikenshoKinyuuOCR";
    private static final String IKENSHO_SAKUSEI_SEIKYUUSHO = "ikenshoSakuseiSeikyuusho";
    private static final String IKENSHO_TEISHUTU = "ikenshoTeishutu";
    private static final String IKENSHO_SAKUSEI_IRAI_HAKKOU = "ikenshoSakuseiIraiHakkou";
    private static final String NINTEICHOSAIRAILIST = "ninteiChosaIraiList";
    private static final String SHUJIIIKENSHOSAKUSEIIRAILIST = "shujiiIkenshoSakuseiIraiList";

    @BatchParameter(key = NINTEIO_CHOSA_IRAISHO, name = "認定調査依頼書印刷区分")
    private RString ninteioChosaIraisho;
    @BatchParameter(key = NINTEI_CHOSAHYO, name = "認定調査票印刷区分")
    private RString ninteiChosahyo;
    @BatchParameter(key = NINTEICHOSAIRAILIST, name = "認定調査依頼リスト")
    private transient List<GridParameter> ninteiChosaIraiList;
    @BatchParameter(key = NINTEI_CHOSA_IRAI_CHOHYO, name = "認定調査依頼一覧表出力区分")
    private boolean ninteiChosaIraiChohyo;
    @BatchParameter(key = NINTEI_CHOSA_IRAISHO, name = "認定調査依頼書出力区分")
    private boolean ninteiChosaIraisyo;
    @BatchParameter(key = NINTEI_CHOSAHYO_KIHON, name = "認定調査票(基本調査)出力区分")
    private boolean ninteiChosahyoKihon;
    @BatchParameter(key = NINTEI_CHOSAHYO_TOKKI, name = "認定調査票(特記事項)出力区分")
    private boolean ninteiChosahyoTokki;
    @BatchParameter(key = NINTEI_CHOSAHYO_GAIKYOU, name = "認定調査票(概況調査)出力区分")
    private boolean ninteiChosahyoGaikyou;
    @BatchParameter(key = NINTEI_CHOSAHYO_OCR_KIHON, name = "認定調査票OCR(基本調査)出力区分")
    private boolean ninteiChosahyoOCRKihon;
    @BatchParameter(key = NINTEI_CHOSAHYO_OCR_TOKKI, name = "認定調査票OCR(特記事項)出力区分")
    private boolean ninteiChosahyoOCRTokki;
    @BatchParameter(key = NINTEI_CHOSAHYO_OCR_GAIKYOU, name = "認定調査票OCR(概況調査)出力区分")
    private boolean ninteiChosahyoOCRGaikyou;
    @BatchParameter(key = GAIKYOCHOSA, name = "認定調査票(概況特記)出力区分")
    private boolean gaikyoChosa;
    @BatchParameter(key = GAIKYOCHOSAOCR, name = "認定調査票OCR(概況特記)出力区分")
    private boolean gaikyoChosaOCR;
    @BatchParameter(key = NINTEI_CHOSA_CHECK_HYO, name = "認定調査差異チェック表出力区分")
    private boolean ninteiChosaCheckHyo;
    @BatchParameter(key = ZENKO_NINTEI_CHOSAHYO, name = "前回認定調査結果との比較表出力区分")
    private boolean zenkoNinteiChosahyo;
    @BatchParameter(key = NINTEI_CHOSAIRAI_HAKKOU, name = "認定調査依頼発行一覧表出力区分")
    private boolean ninteiChosairaiHakkou;
    @BatchParameter(key = SHUJIIIKENSHO_SAKUSEI_IRAI, name = "主治医意見書作成依頼印刷区分")
    private RString shujiiikenshoSakuseiIrai;
    @BatchParameter(key = SHUJIIIKENSHO, name = "意見書印刷区分")
    private RString shujiiIkensho;
    @BatchParameter(key = SHUJIIIKENSHOSAKUSEIIRAILIST, name = "主治医意見書作成依頼リスト")
    private transient List<GridParameter> shujiiIkenshoSakuseiIraiList;
    @BatchParameter(key = IKENSHO_SAKUSEIIRAI, name = "主治医意見書作成依頼一覧表出力区分")
    private boolean ikenshoSakuseiirai;
    @BatchParameter(key = IKENSHO_SAKUSEI_SEIKYUU, name = "主治医意見書作成料請求一覧表出力区分")
    private boolean ikenshoSakuseiSeikyuu;
    @BatchParameter(key = IKENSHO_SAKUSEI_IRAISHO, name = "主治医意見書作成依頼書出力区分")
    private boolean shujiiIkenshoSakuseiIraisho;
    @BatchParameter(key = IKENSHO_KINYUU, name = "主治医意見書記入用紙出力区分")
    private boolean ikenshoKinyuu;
    @BatchParameter(key = IKENSHO_KINYUU_OCR, name = "主治医意見書記入用紙OCR出力区分")
    private boolean ikenshoKinyuuOCR;
    @BatchParameter(key = IKENSHO_SAKUSEI_SEIKYUUSHO, name = "主治医意見書作成料請求書出力区分")
    private boolean ikenshoSakuseiSeikyuusho;
    @BatchParameter(key = IKENSHO_TEISHUTU, name = "介護保険指定医依頼兼主治医意見書提出意見依頼書出力区分")
    private boolean ikenshoTeishutu;
    @BatchParameter(key = IKENSHO_SAKUSEI_IRAI_HAKKOU, name = "主治医意見書作成依頼発行一覧表出力区分")
    private boolean ikenshoSakuseiIraiHakkou;
    @BatchParameter(key = IRAIFROMYMD, name = "依頼開始日")
    private RString iraiFromYMD;
    @BatchParameter(key = IRAITOYMD, name = "依頼終了日")
    private RString iraiToYMD;
    @BatchParameter(key = HAKKOBI, name = "発行日")
    private RString hakkobi;
    @BatchParameter(key = TEISHUTSU_KIGEN, name = "提出期限")
    private RString teishutsuKigen;
    @BatchParameter(key = KYOTSU_HIZUKE, name = "共通日付")
    private RString kyotsuHizuke;

    /**
     * 主治医意見書作成依頼発行一覧表ですためのprocessのパラメータを生成します。
     *
     * @return ShujiiIkenshoSakuseiProcessParamter
     */
    public ShujiiIkenshoSakuseiProcessParamter toShujiiIkenshoSakuseiProcessParamter() {
        return new ShujiiIkenshoSakuseiProcessParamter(iraiFromYMD,
                iraiToYMD,
                shujiiikenshoSakuseiIrai,
                shujiiIkensho,
                shujiiIkenshoSakuseiIraiList);
    }

    /**
     * 認定調査依頼発行一覧表ですためのprocessのパラメータを生成します。
     *
     * @return NinteiChosaIraiProcessParamter
     */
    public NinteiChosaIraiProcessParamter toNinteiChosaIraiProcessParamter() {
        return new NinteiChosaIraiProcessParamter(iraiFromYMD,
                iraiToYMD,
                ninteioChosaIraisho,
                ninteiChosahyo,
                ninteiChosaIraiList);
    }

    /**
     * 訪問調査依頼書発行ですためのprocessのパラメータを生成します。
     *
     * @return HomonChosaIraishoProcessParamter
     */
    public HomonChosaIraishoProcessParamter toHomonChosaIraishoProcessParamter() {
        return new HomonChosaIraishoProcessParamter(ninteioChosaIraisho,
                ninteiChosahyo,
                ninteiChosaIraiList,
                ninteiChosaIraiChohyo,
                ninteiChosaIraisyo,
                ninteiChosahyoKihon,
                ninteiChosahyoTokki,
                ninteiChosahyoGaikyou,
                ninteiChosahyoOCRKihon,
                ninteiChosahyoOCRTokki,
                ninteiChosahyoOCRGaikyou,
                ninteiChosaCheckHyo,
                zenkoNinteiChosahyo,
                iraiFromYMD,
                iraiToYMD,
                hakkobi,
                teishutsuKigen,
                kyotsuHizuke);
    }

    /**
     * 主治医意見書提出依頼書発行ですためのprocessのパラメータを生成します。
     *
     * @return ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter
     */
    public ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter toShujiiIkenshoTeishutsuIraishoHakkoProcessParamter() {
        return new ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter(shujiiikenshoSakuseiIrai,
                shujiiIkensho,
                shujiiIkenshoSakuseiIraiList,
                ikenshoSakuseiirai,
                ikenshoSakuseiSeikyuu,
                shujiiIkenshoSakuseiIraisho,
                ikenshoKinyuu,
                ikenshoKinyuuOCR,
                ikenshoSakuseiSeikyuusho,
                ikenshoTeishutu,
                iraiFromYMD,
                iraiToYMD,
                hakkobi,
                teishutsuKigen,
                kyotsuHizuke);
    }
}
