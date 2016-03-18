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
 * 段階の件数Entityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class DankaiKensuEntity {

    /**
     * 調定年度
     */
    private FlexibleYear choteiNendo;
    /**
     * 賦課年度
     */
    private FlexibleYear fukaNendo;
    /**
     * 段階の件数
     */
    private Decimal dankaiKensu;
    /**
     * 徴収方法
     */
    private RString choshuHouhou;
    /**
     * 段階
     */
    private RString dankai;
    /**
     * 当月フラグ
     */
    private int dogetsuFlag;
}
