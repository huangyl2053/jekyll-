/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.sikakuidocheck;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格期間のデータアクセスクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SikakuKikan {

    private FlexibleDate kaishiYMD;
    private FlexibleDate shuryoYMD;
    private FlexibleDate idoYMD;
    private RString edaNo;

    /**
     * コンストラクタです。
     *
     * @param kaishiYMD FlexibleDate
     * @param shuryoYMD FlexibleDate
     * @param idoYMD FlexibleDate
     * @param edaNo RString
     */
    public SikakuKikan(FlexibleDate kaishiYMD, FlexibleDate shuryoYMD, FlexibleDate idoYMD, RString edaNo) {
        this.kaishiYMD = kaishiYMD;
        this.shuryoYMD = shuryoYMD;
        this.idoYMD = idoYMD;
        this.edaNo = edaNo;
    }
}
