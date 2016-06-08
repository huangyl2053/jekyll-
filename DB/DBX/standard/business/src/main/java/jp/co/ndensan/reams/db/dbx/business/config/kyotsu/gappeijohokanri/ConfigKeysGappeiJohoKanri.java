/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.config.kyotsu.gappeijohokanri;

import jp.co.ndensan.reams.db.dbx.business.config.util.IConfigKeys;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

/**
 * 業務コンフィグ「合併情報管理」に関連するキーの列挙です。
 */
enum ConfigKeysGappeiJohoKanri implements IConfigKeys {

    合併情報管理_合併情報区分;

    @Override
    public SubGyomuCode subGyomuCode() {
        return SubGyomuCode.DBU介護統計報告;
    }
}
