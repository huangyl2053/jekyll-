/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得引出のコンフィグキーです。
 */
public enum ConfigKeysShotokuHikidashi {

    /**
     * コンフィグキーが「所得引出_住民税減免前後表示区分」であることを表します。
     */
    所得引出_住民税減免前後表示区分,
    /**
     * コンフィグキーが「所得引出_64歳未満所得金額表示区分」であることを表します。
     */
    所得引出_６４歳未満所得金額表示区分;

    /**
     * 列挙対に対応するコンフィグキーを返します。
     */
    public RString getKet() {
        return new RString(this.toString());
    }
}
