/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.yokaigoninteijohoteikyo;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteijohoteikyo.YokaigoBatchMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 要介護認定申請者を特定するためのProcess用パラメータクラスです。
 *
 * @reamsid_L DBE-0230-030 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class YokaigoBatchProcessParamter implements IBatchProcessParameter {

    private final RString 申請書管理番号;
    private final RString chkNinteiChosahyo;
    private final RString chkTokkiJiko;
    private final RString chkShujiiIkensho;
    private final RString chkSonotaShiryo;
    private final RString chkIchijiHanteiKekka;
    private final RString radNinteiChosaMasking;
    private final RString radTokkiJikoMasking;
    private final RString radShujii;
    private final RString radSohotaShiryoMasking;
    private final RString radIchijiHanteiMasking;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
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
    public YokaigoBatchProcessParamter(RString 申請書管理番号, RString chkNinteiChosahyo,
            RString chkTokkiJiko, RString chkShujiiIkensho, RString chkSonotaShiryo,
            RString chkIchijiHanteiKekka, RString radNinteiChosaMasking, RString radTokkiJikoMasking, RString radShujii,
            RString radSohotaShiryoMasking, RString radIchijiHanteiMasking) {
        this.申請書管理番号 = 申請書管理番号;
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
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public YokaigoBatchMybitisParamter toYokaigoBatchMybitisParamter() {
        return YokaigoBatchMybitisParamter.createParam(申請書管理番号, radTokkiJikoMasking);
    }
}
