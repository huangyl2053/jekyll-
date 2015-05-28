/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

/**
 * {@link IChosaItakusakiManager}を生成するクラスです。
 *
 * @author n8223　朴義一
 */
public final class ChosaItakusakiFactory {

    private ChosaItakusakiFactory() {
    }

    /**
     * 業務コード{@code SubGyomuCode}で介護受給・認定情報を取得します。
     *
     * @param subGyomuCode 業務コード
     * @return {@link IChosaItakusakiManager}
     */
    public static IChosaItakusakiManager getInstance(SubGyomuCode subGyomuCode) {

        if (subGyomuCode.equals(SubGyomuCode.DBD介護受給)) {
            return new HokenshaChosaltakusakiJohoManager();
        }
        return new ShinsakaiChosaItakusakiManager();
    }

}
