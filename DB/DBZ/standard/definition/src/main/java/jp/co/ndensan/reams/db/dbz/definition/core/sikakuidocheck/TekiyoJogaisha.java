/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.sikakuidocheck;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 適用除外者のデータアクセスクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TekiyoJogaisha {

    private FlexibleDate kaishiYMD;
    private FlexibleDate shuryoYMD;

    /**
     * コンストラクタです。
     *
     * @param kaishiYMD 開始日
     * @param shuryoYMD 終了日
     */
    public TekiyoJogaisha(FlexibleDate kaishiYMD, FlexibleDate shuryoYMD) {
        this.kaishiYMD = kaishiYMD;
        this.shuryoYMD = shuryoYMD;
    }
}
