/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaikekkatoroku;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会内容検索パラメータクラス
 *
 * @reamsid_L DBE-0170-010 wangkun
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShinsakaiKekkaTorokuParameter {

    private final RString 処理状態区分_通常 = ShoriJotaiKubun.通常.getコード();
    private final RString 処理状態区分_延期 = ShoriJotaiKubun.延期.getコード();
    private final RString 開催番号;

    /**
     * コンストラクタです。
     *
     * @param 開催番号 開催番号
     */
    private ShinsakaiKekkaTorokuParameter(RString 開催番号) {
        this.開催番号 = 開催番号;
    }

    /**
     * 審査会内容検索パラメータークラス作成
     *
     * @param kaisaiNo 開催番号
     * @return 審査会内容検索パラメータークラス
     */
    public static ShinsakaiKekkaTorokuParameter createShinsakaiKekkaTorokuParameter(
            RString kaisaiNo) {
        return new ShinsakaiKekkaTorokuParameter(kaisaiNo);
    }
}
