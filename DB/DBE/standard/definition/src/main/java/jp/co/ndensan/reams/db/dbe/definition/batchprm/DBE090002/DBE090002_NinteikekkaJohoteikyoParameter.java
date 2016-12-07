/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE090002;

import jp.co.ndensan.reams.db.dbe.definition.processprm.yokaigoninteijohoteikyo.YokaigoBatchProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定情報提供batch用パラメータクラスです。
 *
 * @reamsid_L DBE-0230-010 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBE090002_NinteikekkaJohoteikyoParameter extends BatchParameterBase {

    private static final long serialVersionUID = -1572924779386182816L;
    private static final String SHINSEISHOKANRINO = "shinseishoKanriNo";
    private static final String CHKNINTEICHOSAHYO = "chkNinteiChosahyo";
    private static final String CHKTOKKIJIKO = "chkTokkiJiko";
    private static final String CHKSHUJIIIKENSHO = "chkShujiiIkensho";
    private static final String CHKSONOTASHIRYO = "chkSonotaShiryo";
    private static final String CHKICHIJIHANTEIKEKKA = "chkIchijiHanteiKekka";
    private static final String RADNINTEICHOSAMASKING = "radNinteiChosaMasking";
    private static final String RADTOKKIJIKOMASKING = "radTokkiJikoMasking";
    private static final String RADSHUJII = "radShujii";
    private static final String RADSOHOTASHIRYOMASKING = "radSohotaShiryoMasking";
    private static final String RADICHIJIHANTEIMASKING = "radIchijiHanteiMasking";

    @BatchParameter(key = SHINSEISHOKANRINO, name = "申請書管理番号")
    private RString shinseishoKanriNo;
    @BatchParameter(key = CHKNINTEICHOSAHYO, name = "認定調査票")
    private RString chkNinteiChosahyo;
    @BatchParameter(key = CHKTOKKIJIKO, name = "特記事項")
    private RString chkTokkiJiko;
    @BatchParameter(key = CHKSHUJIIIKENSHO, name = "主治医意見書")
    private RString chkShujiiIkensho;
    @BatchParameter(key = CHKSONOTASHIRYO, name = "その他資料")
    private RString chkSonotaShiryo;
    @BatchParameter(key = CHKICHIJIHANTEIKEKKA, name = "一次判定結果")
    private RString chkIchijiHanteiKekka;
    @BatchParameter(key = RADNINTEICHOSAMASKING, name = "マスキング_認定調査票")
    private RString radNinteiChosaMasking;
    @BatchParameter(key = RADTOKKIJIKOMASKING, name = "マスキング_特記事項")
    private RString radTokkiJikoMasking;
    @BatchParameter(key = RADSHUJII, name = "マスキング_主治医意見書")
    private RString radShujii;
    @BatchParameter(key = RADSOHOTASHIRYOMASKING, name = "マスキング_その他資料")
    private RString radSohotaShiryoMasking;
    @BatchParameter(key = RADICHIJIHANTEIMASKING, name = "マスキング_一次判定結果")
    private RString radIchijiHanteiMasking;

    /**
     * コンストラクタです。
     *
     */
    public DBE090002_NinteikekkaJohoteikyoParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @param chkNinteiChosahyo 認定調査票チェックフラグ
     * @param chkTokkiJiko 特記事項チェックフラグ
     * @param chkShujiiIkensho 主治医意見書チェックフラグ
     * @param chkSonotaShiryo その他資料チェックフラグ
     * @param chkIchijiHanteiKekka 一次判定結果チェックフラグ
     * @param radNinteiChosaMasking マスキング(認定調査票)フラグ
     * @param radTokkiJikoMasking マスキング(特記事項)フラグ
     * @param radShujii マスキング(主治医意見書)フラグ
     * @param radSohotaShiryoMasking マスキング(その他資料)フラグ
     * @param radIchijiHanteiMasking マスキング(一次判定結果)フラグ
     */
    public DBE090002_NinteikekkaJohoteikyoParameter(RString shinseishoKanriNo, RString chkNinteiChosahyo,
            RString chkTokkiJiko, RString chkShujiiIkensho, RString chkSonotaShiryo,
            RString chkIchijiHanteiKekka, RString radNinteiChosaMasking, RString radTokkiJikoMasking,
            RString radShujii, RString radSohotaShiryoMasking, RString radIchijiHanteiMasking) {
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.chkNinteiChosahyo = chkNinteiChosahyo;
        this.chkTokkiJiko = chkTokkiJiko;
        this.chkShujiiIkensho = chkShujiiIkensho;
        this.chkSonotaShiryo = chkSonotaShiryo;
        this.chkIchijiHanteiKekka = chkIchijiHanteiKekka;
        this.radNinteiChosaMasking = radNinteiChosaMasking;
        this.radTokkiJikoMasking = radTokkiJikoMasking;
        this.radShujii = radShujii;
        this.radSohotaShiryoMasking = radSohotaShiryoMasking;
        this.radIchijiHanteiMasking = radIchijiHanteiMasking;
    }

    /**
     * 要介護認定情報提供作成プロセスパラメータークラス作成
     *
     * @return 要介護認定情報提供作成プロセスパラメータークラス
     */
    public YokaigoBatchProcessParamter toYokaigoBatchProcessParamter() {
        return new YokaigoBatchProcessParamter(shinseishoKanriNo, chkNinteiChosahyo, chkTokkiJiko, chkShujiiIkensho, chkSonotaShiryo,
                chkIchijiHanteiKekka, radNinteiChosaMasking, radTokkiJikoMasking, radShujii, radSohotaShiryoMasking, radIchijiHanteiMasking);
    }
}
