/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

/**
 * {@link IShujiiManager}を生成する機能を持ちます。
 *
 * @author N8235 船山 洋介
 */
public final class ShujiiManagerFactory {

    private ShujiiManagerFactory() {
    }

    /**
     * {@link IShujiiManager}を生成します。
     *
     * @param subGyomuCode サブ業務コード
     * @return {@link IShujiiManager}
     */
    public static IShujiiManager createInstance(SubGyomuCode subGyomuCode) {

        if (subGyomuCode.equals(SubGyomuCode.DBD介護受給)) {
            return new HokenshaShujiiManager();
        }

        return new ShinsakaiShujiiManager();
    }
}
