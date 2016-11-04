package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010013;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Oct 21 20:52:34 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgJigyoshaServiceList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgJigyoshaServiceList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">

    private RString kyufuBunrui;
    private RString serviceBunrui;
    private RString shuruiCode;
    private RString serviceMei;

    public dgJigyoshaServiceList_Row() {
        super();
        this.kyufuBunrui = RString.EMPTY;
        this.serviceBunrui = RString.EMPTY;
        this.shuruiCode = RString.EMPTY;
        this.serviceMei = RString.EMPTY;
        this.setOriginalData("kyufuBunrui", kyufuBunrui);
        this.setOriginalData("serviceBunrui", serviceBunrui);
        this.setOriginalData("shuruiCode", shuruiCode);
        this.setOriginalData("serviceMei", serviceMei);
    }

    public dgJigyoshaServiceList_Row(RString kyufuBunrui, RString serviceBunrui, RString shuruiCode, RString serviceMei) {
        super();
        this.setOriginalData("kyufuBunrui", kyufuBunrui);
        this.setOriginalData("serviceBunrui", serviceBunrui);
        this.setOriginalData("shuruiCode", shuruiCode);
        this.setOriginalData("serviceMei", serviceMei);
        this.kyufuBunrui = kyufuBunrui;
        this.serviceBunrui = serviceBunrui;
        this.shuruiCode = shuruiCode;
        this.serviceMei = serviceMei;
    }

    public RString getKyufuBunrui() {
        return kyufuBunrui;
    }

    public RString getServiceBunrui() {
        return serviceBunrui;
    }

    public RString getShuruiCode() {
        return shuruiCode;
    }

    public RString getServiceMei() {
        return serviceMei;
    }

    public void setKyufuBunrui(RString kyufuBunrui) {
        this.setOriginalData("kyufuBunrui", kyufuBunrui);
        this.kyufuBunrui = kyufuBunrui;
    }

    public void setServiceBunrui(RString serviceBunrui) {
        this.setOriginalData("serviceBunrui", serviceBunrui);
        this.serviceBunrui = serviceBunrui;
    }

    public void setShuruiCode(RString shuruiCode) {
        this.setOriginalData("shuruiCode", shuruiCode);
        this.shuruiCode = shuruiCode;
    }

    public void setServiceMei(RString serviceMei) {
        this.setOriginalData("serviceMei", serviceMei);
        this.serviceMei = serviceMei;
    }

    // </editor-fold>
}
