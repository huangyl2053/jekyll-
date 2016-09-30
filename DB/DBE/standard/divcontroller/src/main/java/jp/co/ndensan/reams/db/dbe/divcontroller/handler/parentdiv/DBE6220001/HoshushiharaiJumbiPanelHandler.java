/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6220001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE622001.DBE622001_ShiharaidataSakuseiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6220001.HoshushiharaiJumbiDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBE6220001_報酬支払いHandlerクラスです
 *
 * @reamsid_L DBE-1990-010 lizhuoxuan
 */
public class HoshushiharaiJumbiPanelHandler {

    private final HoshushiharaiJumbiDiv div;
    private static final RString TRUE = new RString("True");

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public HoshushiharaiJumbiPanelHandler(HoshushiharaiJumbiDiv div) {
        this.div = div;
    }

    /**
     * 発行するボタン処理です
     *
     * @return DBE622001_ShiharaidataSakuseiParameter
     */
    public DBE622001_ShiharaidataSakuseiParameter onClick_btnHakkou() {
        DBE622001_ShiharaidataSakuseiParameter batchParameter = new DBE622001_ShiharaidataSakuseiParameter();
        FlexibleDate fbFrom = new FlexibleDate(div.getTxtJissekiDateRange().getFromValue().toDateString());
        FlexibleDate fbTo = new FlexibleDate(div.getTxtJissekiDateRange().getToValue().toDateString());
        batchParameter.setJissekidaterangefrom(fbFrom);
        batchParameter.setJissekidaterangeto(fbTo);
        batchParameter.setFurikomishiteiday(div.getTxtFurikomiShiteiDay().getValue());
        if (div.getChkSakuseiTaisho().getSelectedKeys().contains(new RString("key1"))) {
            batchParameter.setSakusedate(TRUE);
        }
        if (div.getChkSakuseiTaisho().getSelectedKeys().contains(new RString("key2"))) {
            batchParameter.setChkshujii(TRUE);
        }
        if (div.getChkSakuseiTaisho().getSelectedKeys().contains(new RString("key3"))) {
            batchParameter.setChkshinsakai(TRUE);
        }

        return batchParameter;
    }

}
