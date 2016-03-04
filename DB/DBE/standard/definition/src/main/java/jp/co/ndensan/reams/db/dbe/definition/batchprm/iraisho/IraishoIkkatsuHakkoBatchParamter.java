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
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IraishoIkkatsuHakkoBatchParamter extends BatchParameterBase {

    private static final String IRAIFROMYMD = "iraibiFrom";
    private static final String IRAITOYMD = "iraibiTo";
    private static final String HIHOKENSHANO = "hihokenshaNo";
    private static final String NINTEIO_CHOSA_IRAISHO = "ninteioChosaIraisho";
    private static final String NINTEI_CHOSAHYO = "ninteiChosahyo";
    private static final String SHUJIIIKENSHO_SAKUSEI_IRAI = "shujiiIkenshoSakuseiIraisho";
    private static final String SHUJIIIKENSHO = "shujiiIkensho";
    private static final String HAKKOBI = "hakkobi";
    private static final String TEISHUTSU_KIGEN = "teishutsuKigen";
    private static final String KYOTSU_HIZUKE = "kyotsuHizuke";
    private static final String NINTEI_CHOSAITAKUSAKI = "ninteiChosaitakusaki";
    private static final String NINTEI_CHOSAIN_NO = "ninteiChosainNo";
    private static final String SHUJIIIRYOKIKANCODE = "shujiiIryokikanCodeList";
    private static final String SHUJIICODELIST = "shujiiCodeList";
    private static final String NINTEI_CHOSA_IRAI_CHOHYO = "ninteiChosaIraiChohyo";
    private static final String NINTEI_CHOSA_IRAISHO = "ninteiChosaIraisyo";
    private static final String NINTEI_CHOSAHYO_KIHON = "ninteiChosahyoKihon";
    private static final String NINTEI_CHOSAHYO_TOKKI = "ninteiChosahyoTokki";
    private static final String NINTEI_CHOSAHYO_GAIKYOU = "ninteiChosahyoGaikyou";
    private static final String NINTEI_CHOSAHYO_OCR_KIHON = "ninteiChosahyoOCRKihon";
    private static final String NINTEI_CHOSAHYO_OCR_TOKKI = "ninteiChosahyoOCRTokki";
    private static final String NINTEI_CHOSAHYO_OCR_GAIKYOU = "ninteiChosahyoOCRGaikyou";
    private static final String NINTEI_CHOSA_CHECK_HYO = "ninteiChosaCheckHyo";
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

    @BatchParameter(key = IRAIFROMYMD, name = "依頼日From")
    private RString iraiFromYMD;
    @BatchParameter(key = IRAITOYMD, name = "依頼日To")
    private RString iraiToYMD;
    @BatchParameter(key = HIHOKENSHANO, name = "保険者番号")
    private RString hihokenshaNo;
    @BatchParameter(key = NINTEIO_CHOSA_IRAISHO, name = "認定調査依頼書")
    private RString ninteioChosaIraisho;
    @BatchParameter(key = NINTEI_CHOSAHYO, name = "認定調査票")
    private RString ninteiChosahyo;
    @BatchParameter(key = SHUJIIIKENSHO_SAKUSEI_IRAI, name = "主治医意見書作成依頼書")
    private RString shujiiikenshoSakuseiIrai;
    @BatchParameter(key = SHUJIIIKENSHO, name = "主治医意見書")
    private RString shujiiIkensho;
    @BatchParameter(key = HAKKOBI, name = "発行日")
    private RString hakkobi;
    @BatchParameter(key = TEISHUTSU_KIGEN, name = "提出期限")
    private RString teishutsuKigen;
    @BatchParameter(key = KYOTSU_HIZUKE, name = "共通日付")
    private RString kyotsuHizuke;
    @BatchParameter(key = NINTEI_CHOSAITAKUSAKI, name = "認定調査委託先コード")
    private List<RString> ninteiChosaItakusakiCodeList;
    @BatchParameter(key = NINTEI_CHOSAIN_NO, name = "認定調査員コード")
    private List<RString> ninteiChosainNoList;
    @BatchParameter(key = SHUJIIIRYOKIKANCODE, name = "主治医医療機関コード")
    private List<RString> shujiiIryokikanCodeList;
    @BatchParameter(key = SHUJIICODELIST, name = "主治医コード")
    private List<RString> shujiiCodeList;
    @BatchParameter(key = NINTEI_CHOSA_IRAI_CHOHYO, name = "認定調査依頼一覧表")
    private RString ninteiChosaIraiChohyo;
    @BatchParameter(key = NINTEI_CHOSA_IRAISHO, name = "認定調査依頼書")
    private RString ninteiChosaIraisyo;
    @BatchParameter(key = NINTEI_CHOSAHYO_KIHON, name = "認定調査票(基本調査)")
    private RString ninteiChosahyoKihon;
    @BatchParameter(key = NINTEI_CHOSAHYO_TOKKI, name = "認定調査票(特記事項)")
    private RString ninteiChosahyoTokki;
    @BatchParameter(key = NINTEI_CHOSAHYO_GAIKYOU, name = "認定調査票(概況調査)")
    private RString ninteiChosahyoGaikyou;
    @BatchParameter(key = NINTEI_CHOSAHYO_OCR_KIHON, name = "認定調査票OCR(基本調査)")
    private RString ninteiChosahyoOCRKihon;
    @BatchParameter(key = NINTEI_CHOSAHYO_OCR_TOKKI, name = "認定調査票OCR(特記事項)")
    private RString ninteiChosahyoOCRTokki;
    @BatchParameter(key = NINTEI_CHOSAHYO_OCR_GAIKYOU, name = "認定調査票OCR(概況調査)")
    private RString ninteiChosahyoOCRGaikyou;
    @BatchParameter(key = NINTEI_CHOSA_CHECK_HYO, name = "認定調査差異チェック表")
    private RString ninteiChosaCheckHyo;
    @BatchParameter(key = ZENKO_NINTEI_CHOSAHYO, name = "前回認定調査結果との比較表")
    private RString zenkoNinteiChosahyo;
    @BatchParameter(key = NINTEI_CHOSAIRAI_HAKKOU, name = "認定調査依頼発行一覧表")
    private RString ninteiChosairaiHakkou;
    @BatchParameter(key = IKENSHO_SAKUSEIIRAI, name = "主治医意見書作成依頼一覧表")
    private RString ikenshoSakuseiirai;
    @BatchParameter(key = IKENSHO_SAKUSEI_SEIKYUU, name = "主治医意見書作成料請求一覧表")
    private RString ikenshoSakuseiSeikyuu;
    @BatchParameter(key = IKENSHO_SAKUSEI_IRAISHO, name = "主治医意見書作成依頼書")
    private RString shujiiIkenshoSakuseiIraisho;
    @BatchParameter(key = IKENSHO_KINYUU, name = "主治医意見書記入用紙")
    private RString ikenshoKinyuu;
    @BatchParameter(key = IKENSHO_KINYUU_OCR, name = "主治医意見書記入用紙OCR")
    private RString ikenshoKinyuuOCR;
    @BatchParameter(key = IKENSHO_SAKUSEI_SEIKYUUSHO, name = "主治医意見書作成料請求書")
    private RString ikenshoSakuseiSeikyuusho;
    @BatchParameter(key = IKENSHO_TEISHUTU, name = "介護保険指定医依頼兼主治医意見書提出依頼書")
    private RString ikenshoTeishutu;
    @BatchParameter(key = IKENSHO_SAKUSEI_IRAI_HAKKOU, name = "主治医意見書作成依頼発行一覧表")
    private RString ikenshoSakuseiIraiHakkou;

    /**
     * 主治医意見書作成依頼発行一覧表ですためのprocessのパラメータを生成します。
     *
     * @return ShujiiIkenshoSakuseiProcessParamter
     */
    public ShujiiIkenshoSakuseiProcessParamter toShujiiIkenshoSakuseiProcessParamter() {
        return new ShujiiIkenshoSakuseiProcessParamter(iraiFromYMD,
                iraiToYMD,
                hihokenshaNo,
                shujiiikenshoSakuseiIrai,
                shujiiIkensho,
                shujiiIryokikanCodeList,
                shujiiCodeList);
    }

    /**
     * 認定調査依頼発行一覧表ですためのprocessのパラメータを生成します。
     *
     * @return NinteiChosaIraiProcessParamter
     */
    public NinteiChosaIraiProcessParamter toNinteiChosaIraiProcessParamter() {
        return new NinteiChosaIraiProcessParamter(iraiFromYMD,
                iraiToYMD,
                hihokenshaNo,
                ninteioChosaIraisho,
                ninteiChosahyo,
                ninteiChosaItakusakiCodeList,
                ninteiChosainNoList);
    }

    /**
     * 訪問調査依頼書発行ですためのprocessのパラメータを生成します。
     *
     * @return HomonChosaIraishoProcessParamter
     */
    public HomonChosaIraishoProcessParamter toHomonChosaIraishoProcessParamter() {
        return new HomonChosaIraishoProcessParamter(iraiFromYMD,
                iraiToYMD,
                hihokenshaNo,
                ninteioChosaIraisho,
                ninteiChosahyo,
                ninteiChosaItakusakiCodeList,
                ninteiChosainNoList,
                hakkobi,
                teishutsuKigen,
                kyotsuHizuke,
                ninteiChosaIraiChohyo,
                ninteiChosaIraisyo);
    }

    /**
     * 主治医意見書提出依頼書発行ですためのprocessのパラメータを生成します。
     *
     * @return ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter
     */
    public ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter toShujiiIkenshoTeishutsuIraishoHakkoProcessParamter() {
        return new ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter(iraiFromYMD,
                iraiToYMD,
                hihokenshaNo,
                shujiiikenshoSakuseiIrai,
                shujiiIkensho,
                shujiiIryokikanCodeList,
                shujiiCodeList,
                hakkobi,
                teishutsuKigen,
                kyotsuHizuke,
                ikenshoKinyuu,
                ikenshoKinyuuOCR,
                ikenshoSakuseiSeikyuusho,
                ikenshoTeishutu,
                ikenshoSakuseiIraiHakkou);
    }
}
