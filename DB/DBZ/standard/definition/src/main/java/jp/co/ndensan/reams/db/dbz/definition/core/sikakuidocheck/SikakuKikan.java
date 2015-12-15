/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.sikakuidocheck;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

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

    /**
     * コンストラクタです。
     *
     * @param kaishiYMD 取得日
     * @param shuryoYMD 喪失日
     */
    public SikakuKikan(FlexibleDate kaishiYMD, FlexibleDate shuryoYMD) {
        this.kaishiYMD = kaishiYMD;
        this.shuryoYMD = shuryoYMD;
    }
}
