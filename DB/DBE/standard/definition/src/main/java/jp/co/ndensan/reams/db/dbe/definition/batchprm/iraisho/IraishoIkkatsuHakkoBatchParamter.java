/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.iraisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 依頼書一括発行のバッチパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IraishoIkkatsuHakkoBatchParamter extends BatchParameterBase {

    private static final String IRAIBI_FROM = "iraibiFrom";
    private static final String IRAIBI_TO = "iraibiTo";
    private static final String SHO_KISAI_HOKENSHA_NO = "shoKisaiHokenshaNo";
    private static final String NINTEIO_CHOSA_IRAISHO = "ninteioChosaIraisho";
    private static final String NINTEI_CHOSAHYO = "ninteiChosahyo";
    private static final String SHUJIIIKENSHO_SAKUSEI_IRAI = "shujiiikenshoSakuseiIrai";
    private static final String SHUJIIIKENSHO = "shujiiIkensho";
    private static final String HAKKOBI = "hakkobi";
    private static final String TEISHUTSU_KIGEN = "teishutsuKigen";
    private static final String KYOTSU_HIZUKE = "kyotsuHizuke";
    private static final String NINTEI_CHOSAITAKUSAKI = "ninteiChosaitakusaki";
    private static final String NINTEI_CHOSAIN_NO = "ninteiChosainNo";
    private static final String SHUJII_IRYO_KIKAN_CODE = "shujiiIryoKikanCode";
    private static final String ISHI_NO = "ishiNo";
    private static final String NINTEI_CHOSA_IRAI_CHOHYO = "ninteiChosaIraiChohyo";
    private static final String NINTEI_CHOSA_IRAISHO = "ninteiChosaIraisho";
    private static final String NINTEI_CHOSAHYO_KIHON = "ninteiChosahyoKihon";
    private static final String NINTEI_CHOSAHYO_TOKKI = "ninteiChosahyoTokki";
    private static final String NINTEI_CHOSAHYO_GAIKYOU = "ninteiChosahyoGaikyou";
    private static final String NINTEI_CHOSAHYO_OCR_KIHON = "ninteiChosahyoOCRKihon";
    private static final String NINTEI_CHOSAHYO_OCR_TOKKI = "ninteiChosahyoOCRTokki";
    private static final String NINTEI_CHOSAHYO_OCR_GAIKYOU = "ninteiChosahyoOCRGaikyou";
    private static final String NINTEI_CHOSA_CHECK_HYO = "ninteiChosaCheckHyo";
    private static final String ZENKO_NINTEI_CHOSAHYO = "zenkoNinteiChosahyo";
    private static final String NINTEI_CHOSAIRAI_HAKKOU = "ninteiChosairaiHakkou";
    private static final String SHUJII_IKENSHO_SAKUSEIIRAI = "shujiiIkenshoSakuseiirai";
    private static final String SHUJII_IKENSHO_SAKUSEI_SEIKYUU = "shujiiIkenshoSakuseiSeikyuu";
    private static final String SHUJII_IKENSHO_SAKUSEI_IRAISHO = "shujiiIkenshoSakuseiIraisho";
    private static final String SHUJII_IKENSHO_KINYUU = "shujiiIkenshoKinyuu";
    private static final String SHUJII_IKENSHO_KINYUU_OCR = "shujiiIkenshoKinyuuOCR";
    private static final String SHUJII_IKENSHO_SAKUSEI_SEIKYUUSHO = "shujiiIkenshoSakuseiSeikyuusho";
    private static final String SHUJII_IKENSHO_TEISHUTU = "shujiiIkenshoTeishutu";
    private static final String SHUJII_IKENSHO_SAKUSEI_IRAI_HAKKOU = "shujiiIkenshoSakuseiIraiHakkou";

    @BatchParameter(key = IRAIBI_FROM, name = "依頼日From")
    private RDate iraibiFrom;
    @BatchParameter(key = IRAIBI_TO, name = "依頼日To")
    private RDate iraibiTo;
    @BatchParameter(key = SHO_KISAI_HOKENSHA_NO, name = "保険者番号")
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
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
    private RString ninteiChosaitakusaki;
    @BatchParameter(key = NINTEI_CHOSAIN_NO, name = "認定調査員コード")
    private RString ninteiChosainNo;
    @BatchParameter(key = SHUJII_IRYO_KIKAN_CODE, name = "主治医医療機関コード")
    private RString shujiiIryoKikanCode;
    @BatchParameter(key = ISHI_NO, name = "主治医コード")
    private RString ishiNo;
    @BatchParameter(key = NINTEI_CHOSA_IRAI_CHOHYO, name = "認定調査依頼一覧表")
    private RString ninteiChosaIraiChohyo;
    @BatchParameter(key = NINTEI_CHOSA_IRAISHO, name = "認定調査依頼書")
    private RString ninteiChosaIraisho;
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
    @BatchParameter(key = SHUJII_IKENSHO_SAKUSEIIRAI, name = "主治医意見書作成依頼一覧表")
    private RString shujiiIkenshoSakuseiirai;
    @BatchParameter(key = SHUJII_IKENSHO_SAKUSEI_SEIKYUU, name = "主治医意見書作成料請求一覧表")
    private RString shujiiIkenshoSakuseiSeikyuu;
    @BatchParameter(key = SHUJII_IKENSHO_SAKUSEI_IRAISHO, name = "主治医意見書作成依頼書")
    private RString shujiiIkenshoSakuseiIraisho;
    @BatchParameter(key = SHUJII_IKENSHO_KINYUU, name = "主治医意見書記入用紙")
    private RString shujiiIkenshoKinyuu;
    @BatchParameter(key = SHUJII_IKENSHO_KINYUU_OCR, name = "主治医意見書記入用紙OCR")
    private RString shujiiIkenshoKinyuuOCR;
    @BatchParameter(key = SHUJII_IKENSHO_SAKUSEI_SEIKYUUSHO, name = "主治医意見書作成料請求書")
    private RString shujiiIkenshoSakuseiSeikyuusho;
    @BatchParameter(key = SHUJII_IKENSHO_TEISHUTU, name = "介護保険指定医依頼兼主治医意見書提出依頼書")
    private RString shujiiIkenshoTeishutu;
    @BatchParameter(key = SHUJII_IKENSHO_SAKUSEI_IRAI_HAKKOU, name = "主治医意見書作成依頼発行一覧表")
    private RString shujiiIkenshoSakuseiIraiHakkou;

}
