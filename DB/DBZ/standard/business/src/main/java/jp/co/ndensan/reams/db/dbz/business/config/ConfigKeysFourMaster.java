/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定の四マスタ関連のコンフィグキークラスです。
 */
public enum ConfigKeysFourMaster {

    /**
     * 四マスタ管理方法
     */
    四マスタ管理方法;

    /**
     * コンフィグキーを返します。
     *
     * @return コンフィグキー
     */
    public RString getKey() {
        return new RString(this.toString());
    }
}
