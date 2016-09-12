/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * タスク一覧共有画面クラスです。
 *
 * @reamsid_L DBE-3000-160 houtianpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class YokaigoNinteiTaskListParameter {

    private final RString 通常;
    private final RString 延期;

    private YokaigoNinteiTaskListParameter(RString 通常, RString 延期) {
        this.通常 = 通常;
        this.延期 = 延期;
    }

    /**
     * 検索処理取得パラメータ設定
     *
     * @param 通常 RString
     * @param 延期 RString
     * @return YokaigoNinteiTaskListParameter
     */
    public static YokaigoNinteiTaskListParameter createParameter(
            RString 通常,
            RString 延期) {
        return new YokaigoNinteiTaskListParameter(
                通常,
                延期);
    }
}
