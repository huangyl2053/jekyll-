/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.config.kyotsu.rojinhokenjoho;

import jp.co.ndensan.reams.db.dbx.business.config.util.IConfigKeys;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

/**
 *
 */
enum ConfigKeysRokenJoho implements IConfigKeys {

    老人保健情報_市町村番号(SubGyomuCode.DBU介護統計報告),
    老人保健情報_管理体系(SubGyomuCode.DBD介護受給);

    private final SubGyomuCode aSubGyomuCode;

    private ConfigKeysRokenJoho(SubGyomuCode subGyomuCode) {
        this.aSubGyomuCode = subGyomuCode;
    }

    @Override
    public SubGyomuCode subGyomuCode() {
        return this.aSubGyomuCode;
    }
}
