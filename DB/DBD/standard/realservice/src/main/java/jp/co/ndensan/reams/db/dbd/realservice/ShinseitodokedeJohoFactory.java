/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

/**
 * {@link IShinseitodokedeJohoManager}を生成するクラスです。
 *
 * @author n8223 朴義一
 */
public final class ShinseitodokedeJohoFactory {

    private ShinseitodokedeJohoFactory() {
    }

    /**
     * {@link IShinseitodokedeJohoManager}を生成します。
     *
     * @param subGyomuCode サブ業務コード
     * @return IShinseitodokedeJohoManager
     */
    public static IShinseitodokedeJohoManager getInstance(SubGyomuCode subGyomuCode) {

        if (subGyomuCode.equals(SubGyomuCode.DBD介護受給)) {
            return new HokenshaShinseitodokedeJohoManager();
        }
        return new ShinsakaiShinseitodokedeJohoManager();
    }

}
