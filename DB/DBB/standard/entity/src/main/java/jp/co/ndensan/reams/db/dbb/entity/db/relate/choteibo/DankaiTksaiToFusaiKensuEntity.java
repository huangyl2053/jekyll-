/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 段階の特徴/普徴者数Entityです。
 */
@lombok.Getter
@lombok.Setter
public class DankaiTksaiToFusaiKensuEntity {

    /**
     * 調定年度
     */
    private FlexibleYear choteiNendo;
    /**
     * 徴収方法
     */
    private RString choshuHouhou;
    /**
     * 段階
     */
    private RString dankai;
    /**
     * 該当する段階の特徴者数の件数
     */
    private Decimal tokuchosyaKensuCount;
    /**
     * 該当する段階の普徴者数の件数
     */
    private Decimal fuchosyaKensuCount;
    /**
     * 該当する段階の内併徴者数の件数
     */
    private Decimal naiheisyaKensuCount;
}
