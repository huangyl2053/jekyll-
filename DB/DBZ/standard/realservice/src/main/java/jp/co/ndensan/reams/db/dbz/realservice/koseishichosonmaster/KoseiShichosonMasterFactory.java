/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.koseishichosonmaster;

import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

/**
 * {@link IChosainManager}を生成するクラスです。
 *
 * @author n8223　朴義一
 */
public final class KoseiShichosonMasterFactory {

    private KoseiShichosonMasterFactory() {
    }

    /**
     * 業務コード{@code SubGyomuCode}で構成市町村マスタ情報を取得します。
     *
     * @param subGyomuCode
     * @return {@link IChosainManager}
     */
    public static IKoseiShichosonMasterManager getInstance(SubGyomuCode subGyomuCode) {

        if (subGyomuCode.equals(SubGyomuCode.DBD介護受給)) {
            return new ShinsakaiKoseiShichosonMasterManager();
        }//else {
        //return new KaigoiKoseiShichosonMasterManager();
        return new ShinsakaiKoseiShichosonMasterManager();
        // }
    }

}
