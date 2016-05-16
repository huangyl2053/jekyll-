/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.yokaigoninteijohoteikyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定情報提供batch用パラメータクラスです。
 *
 * @reamsid_L DBE-0230-010 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class YokaigoBatchParameter {

    private RString shinseishoKanriNo;
    private RString chkNinteiChosahyo;
    private RString chkTokkiJiko;
    private RString chkShujiiIkensho;
    private RString chkSonotaShiryo;
    private RString chkIchijiHanteiKekka;
    private RString radTokkiJikoMasking;
    private RString radShujii;
    private RString radSohotaShiryoMasking;
}
