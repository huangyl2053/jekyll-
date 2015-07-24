/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1800000.DBC1800000StateName.申請登録;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1800000.KashitsukeShinseiTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuhiKashitsukekinList.dgKyufuhiKashitsukekinList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * １つのKashitsukeShinseiTorokuDivに対して２つのコントローラ（KashitsukeShinseiList・KashitsukeShinseiInfo）がある
 * 昔は１つのrequestSettingsに２つのコントローラの書いていたが、今はできないので、画面遷移用にこれを作成。
 * ここに２つのコントローラを統合するか、２つのパネルをまとめているKashitsukeShinseiTorokuDivをなくすかする。
 *
 * @author N3317 塚田 萌
 */
public class KashitsukeShinseiToroku {

    public ResponseData<KashitsukeShinseiTorokuDiv> onLoad(KashitsukeShinseiTorokuDiv panel) {
        List<dgKyufuhiKashitsukekinList_Row> dgRowList = panel.getKashitsukeShinseiList().getKashitsukeShinseiListInfo().getDgKyufuhiKashitsukekinList().getDataSource();
        dgRowList.add(new dgKyufuhiKashitsukekinList_Row());

        return ResponseData.of(panel).respond();
    }

    public ResponseData<KashitsukeShinseiTorokuDiv> toTorokuDiv(KashitsukeShinseiTorokuDiv panel) {

        List<dgKyufuhiKashitsukekinList_Row> list = panel.getKashitsukeShinseiList().getKashitsukeShinseiListInfo().getDgKyufuhiKashitsukekinList().getDataSource();
        list.add(new dgKyufuhiKashitsukekinList_Row());

        return ResponseData.of(panel).setState(申請登録);
    }
}
