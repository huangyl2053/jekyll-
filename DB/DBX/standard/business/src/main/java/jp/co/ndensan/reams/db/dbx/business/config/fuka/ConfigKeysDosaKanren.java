/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.config.fuka;

import jp.co.ndensan.reams.db.dbx.business.config.util.IConfigKeys;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

/**
 * 業務コンフィグ「動作関連」のキーです。
 */
public enum ConfigKeysDosaKanren implements IConfigKeys {

    /**
     * 収納システム区分
     */
    動作関連_収納システム区分,
    /**
     * 口座システム区分
     */
    動作関連_口座システム区分,
    /**
     * コンビニ収納実施区分
     */
    動作関連_コンビニ収納実施区分,
    /**
     * 公示送達実施区分
     */
    動作関連_公示送達実施区分,
    /**
     * 特徴分配集約システム
     */
    動作関連_特徴分配集約システム,
    /**
     * 過年度賦課対象
     */
    動作関連_過年度賦課対象,
    /**
     * 所得調査中賦課保留有無
     */
    動作関連_所得調査中賦課保留有無;

    @Override
    public SubGyomuCode subGyomuCode() {
        return SubGyomuCode.DBB介護賦課;
    }
}
