package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5140011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Sep 14 14:30:49 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;

/**
 * dgServiceShuruiList_Row のクラスファイル
 *
 * @reamsid_L DBC-3330-010 lihang
 */
public class dgServiceShuruiList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    private RString serviceShuruiName;
    private RString serviceShuruiCode;
    private RString hdnServiceBunruiCode;

    public dgServiceShuruiList_Row() {
        super();
        this.serviceShuruiName = RString.EMPTY;
        this.serviceShuruiCode = RString.EMPTY;
        this.hdnServiceBunruiCode = RString.EMPTY;
        this.setOriginalData("serviceShuruiName", serviceShuruiName);
        this.setOriginalData("serviceShuruiCode", serviceShuruiCode);
        this.setOriginalData("hdnServiceBunruiCode", hdnServiceBunruiCode);
    }

    public dgServiceShuruiList_Row(RString serviceShuruiName, RString serviceShuruiCode, RString hdnServiceBunruiCode) {
        super();
        this.setOriginalData("serviceShuruiName", serviceShuruiName);
        this.setOriginalData("serviceShuruiCode", serviceShuruiCode);
        this.setOriginalData("hdnServiceBunruiCode", hdnServiceBunruiCode);
        this.serviceShuruiName = serviceShuruiName;
        this.serviceShuruiCode = serviceShuruiCode;
        this.hdnServiceBunruiCode = hdnServiceBunruiCode;
    }

    public RString getServiceShuruiName() {
        return serviceShuruiName;
    }

    public RString getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    public RString getHdnServiceBunruiCode() {
        return hdnServiceBunruiCode;
    }

    public void setServiceShuruiName(RString serviceShuruiName) {
        this.setOriginalData("serviceShuruiName", serviceShuruiName);
        this.serviceShuruiName = serviceShuruiName;
    }

    public void setServiceShuruiCode(RString serviceShuruiCode) {
        this.setOriginalData("serviceShuruiCode", serviceShuruiCode);
        this.serviceShuruiCode = serviceShuruiCode;
    }

    public void setHdnServiceBunruiCode(RString hdnServiceBunruiCode) {
        this.setOriginalData("hdnServiceBunruiCode", hdnServiceBunruiCode);
        this.hdnServiceBunruiCode = hdnServiceBunruiCode;
    }

    // </editor-fold>
}
