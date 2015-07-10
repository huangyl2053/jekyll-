/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

/**
 * {@link INinteiKekkaJohoManager}を生成する機能を持ちます。
 *
 * @author n8223 朴義一
 */
public final class NinteiKekkaJohoFactory {

    private NinteiKekkaJohoFactory() {
    }

    /**
     * 業務コード{@code SubGyomuCode}で{@link INinteiKekkaJohoManager}を生成します。
     *
     * @param subGyomuCode サブ業務コード
     * @return {@link INinteiKekkaJohoManager}
     */
    public static INinteiKekkaJohoManager getInstance(SubGyomuCode subGyomuCode) {

        if (subGyomuCode.equals(SubGyomuCode.DBD介護受給)) {
            return new HokenshaNinteiKekkaJohoManager();
        }
        return new ShinsakaiNinteiKekkaJohoManager();
    }
}
