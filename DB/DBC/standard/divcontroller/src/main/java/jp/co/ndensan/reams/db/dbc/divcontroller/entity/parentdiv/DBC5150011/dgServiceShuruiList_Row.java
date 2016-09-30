package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5150011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Sep 05 17:54:33 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;

/**
 * dgServiceShuruiList_Row のクラスファイル
 *
 * @reamsid_L DBC-3310-010 chenyadong
 */
public class dgServiceShuruiList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    private RString hdnServiceBunrui;

    public dgServiceShuruiList_Row() {
        super();
        this.hdnServiceBunrui = RString.EMPTY;
        this.setOriginalData("hdnServiceBunrui", hdnServiceBunrui);
    }

    public dgServiceShuruiList_Row(RString hdnServiceBunrui) {
        super();
        this.setOriginalData("hdnServiceBunrui", hdnServiceBunrui);
        this.hdnServiceBunrui = hdnServiceBunrui;
    }

    public RString getHdnServiceBunrui() {
        return hdnServiceBunrui;
    }

    public void setHdnServiceBunrui(RString hdnServiceBunrui) {
        this.setOriginalData("hdnServiceBunrui", hdnServiceBunrui);
        this.hdnServiceBunrui = hdnServiceBunrui;
    }

    // </editor-fold>
}
