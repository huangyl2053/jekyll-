/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 要介護認定個人進捗状況票ボディのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KojinShinchokuJokyohyoBodyItem {

    private final RString listJokyo_1;
    private final RString listJokyo_2;
    private final RString listJokyo_3;
    private final RString listJokyo_4;
    private final RString listJokyo_5;

    /**
     * インスタンスを生成します。
     *
     * @param listJokyo_1 番号
     * @param listJokyo_2 名
     * @param listJokyo_3 今回日付
     * @param listJokyo_4 前回日付
     * @param listJokyo_5 前々回日付
     */
    public KojinShinchokuJokyohyoBodyItem(
            RString listJokyo_1,
            RString listJokyo_2,
            RString listJokyo_3,
            RString listJokyo_4,
            RString listJokyo_5) {
        this.listJokyo_1 = listJokyo_1;
        this.listJokyo_2 = listJokyo_2;
        this.listJokyo_3 = listJokyo_3;
        this.listJokyo_4 = listJokyo_4;
        this.listJokyo_5 = listJokyo_5;
    }
}
