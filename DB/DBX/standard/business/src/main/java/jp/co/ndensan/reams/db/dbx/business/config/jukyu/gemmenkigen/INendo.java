/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.config.jukyu.gemmenkigen;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 年度であることを表します。
 */
public interface INendo {

    /**
     * 前年度の情報を取得します。
     *
     * @return 前年度
     */
    INendo before();

    /**
     * 指定の日付がこの年度の範囲内であることが明らかな場合、{@code true}を返却します。
     *
     * @param 基準日 この年度の範囲内であるか判定する対象の日付
     * @return 指定の日付がこの年度の範囲内であることが明らかな場合、{@code true}.
     * 範囲内と言えない場合、{@code false}.
     */
    boolean between(FlexibleDate 基準日);

    /**
     * 年度の「年」を{@link FlexibleYear}で返却します。
     *
     * @return 年度の「年」
     */
    FlexibleYear getYear();

    /**
     * 年度の開始日を返却します。
     *
     * @return 年度の開始日
     */
    FlexibleDate get開始日();

    /**
     * 年度の終了日を返却します。
     *
     * @return 年度の終了日
     */
    FlexibleDate get終了日();

}
