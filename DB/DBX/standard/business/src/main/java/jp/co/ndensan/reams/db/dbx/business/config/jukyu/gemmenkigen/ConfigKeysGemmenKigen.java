/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.config.jukyu.gemmenkigen;

import jp.co.ndensan.reams.db.dbx.business.config.util.IConfigKeys;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

/**
 * 業務コンフィグ「減免期限」のキーです。
 */
enum ConfigKeysGemmenKigen implements IConfigKeys {

    /**
     * 減免期限_特別減免
     */
    減免期限_特別減免,
    /**
     * 減免期限_標準減額
     */
    減免期限_標準減額,
    /**
     * 減免期限_利用減免
     */
    減免期限_利用減免,
    /**
     * 減免期限_法人減免
     */
    減免期限_法人減免,
    /**
     * 減免期限_特地減免
     */
    減免期限_特地減免,
    /**
     * 減免期限_特定入所者
     */
    減免期限_特定入所者,
    /**
     * 減免期限_法人軽減
     */
    減免期限_法人軽減;

    @Override
    public SubGyomuCode subGyomuCode() {
        return SubGyomuCode.DBD介護受給;
    }
}
