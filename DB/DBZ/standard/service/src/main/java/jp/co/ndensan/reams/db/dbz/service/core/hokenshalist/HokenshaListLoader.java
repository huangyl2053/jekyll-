/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.hokenshalist;

import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;

/**
 * 保険者の一覧を取得します。
 */
public class HokenshaListLoader {

    HokenshaListLoader() {
    }

    public static HokenshaListLoader createInstance() {
        return new HokenshaListLoader();
    }

    /**
     * 市町村コード・名称リストを取得します。
     *
     * @param gyomuBunrui 業務分類
     * @return 市町村Entiyリスト
     */
    public HokenshaList getShichosonCodeNameList(GyomuBunrui gyomuBunrui) {
        switch (gyomuBunrui) {
            case 介護認定:
                return KaigoNinteiHokenshaListLoader.createInstance().getShichosonCodeNameList();
            default:
                return jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader
                        .createInstance().getShichosonCodeNameList(gyomuBunrui); // 呼び出し元で業務分類つかってない
        }
    }
}
