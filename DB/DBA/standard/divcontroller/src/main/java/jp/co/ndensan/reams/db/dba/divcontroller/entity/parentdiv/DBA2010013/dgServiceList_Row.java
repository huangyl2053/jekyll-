package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010013;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue May 17 11:33:44 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgServiceList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgServiceList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">

    private RString serviceShuruiCode;
    private RString serviceType;
    private TextBoxFlexibleDate kaishiDate;
    private TextBoxFlexibleDate shuryoDate;
    private RString jigyoshaMei;
    private RString kanrishaMei;

    public dgServiceList_Row() {
        super();
        this.serviceShuruiCode = RString.EMPTY;
        this.serviceType = RString.EMPTY;
        this.kaishiDate = new TextBoxFlexibleDate();
        this.shuryoDate = new TextBoxFlexibleDate();
        this.jigyoshaMei = RString.EMPTY;
        this.kanrishaMei = RString.EMPTY;
        this.setOriginalData("serviceShuruiCode", serviceShuruiCode);
        this.setOriginalData("serviceType", serviceType);
        this.setOriginalData("kaishiDate", kaishiDate);
        this.setOriginalData("shuryoDate", shuryoDate);
        this.setOriginalData("jigyoshaMei", jigyoshaMei);
        this.setOriginalData("kanrishaMei", kanrishaMei);
    }

    public dgServiceList_Row(RString serviceShuruiCode, RString serviceType, TextBoxFlexibleDate kaishiDate, TextBoxFlexibleDate shuryoDate, RString jigyoshaMei, RString kanrishaMei) {
        super();
        this.setOriginalData("serviceShuruiCode", serviceShuruiCode);
        this.setOriginalData("serviceType", serviceType);
        this.setOriginalData("kaishiDate", kaishiDate);
        this.setOriginalData("shuryoDate", shuryoDate);
        this.setOriginalData("jigyoshaMei", jigyoshaMei);
        this.setOriginalData("kanrishaMei", kanrishaMei);
        this.serviceShuruiCode = serviceShuruiCode;
        this.serviceType = serviceType;
        this.kaishiDate = kaishiDate;
        this.shuryoDate = shuryoDate;
        this.jigyoshaMei = jigyoshaMei;
        this.kanrishaMei = kanrishaMei;
    }

    public RString getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    public RString getServiceType() {
        return serviceType;
    }

    public TextBoxFlexibleDate getKaishiDate() {
        return kaishiDate;
    }

    public TextBoxFlexibleDate getShuryoDate() {
        return shuryoDate;
    }

    public RString getJigyoshaMei() {
        return jigyoshaMei;
    }

    public RString getKanrishaMei() {
        return kanrishaMei;
    }

    public void setServiceShuruiCode(RString serviceShuruiCode) {
        this.setOriginalData("serviceShuruiCode", serviceShuruiCode);
        this.serviceShuruiCode = serviceShuruiCode;
    }

    public void setServiceType(RString serviceType) {
        this.setOriginalData("serviceType", serviceType);
        this.serviceType = serviceType;
    }

    public void setKaishiDate(TextBoxFlexibleDate kaishiDate) {
        this.setOriginalData("kaishiDate", kaishiDate);
        this.kaishiDate = kaishiDate;
    }

    public void setShuryoDate(TextBoxFlexibleDate shuryoDate) {
        this.setOriginalData("shuryoDate", shuryoDate);
        this.shuryoDate = shuryoDate;
    }

    public void setJigyoshaMei(RString jigyoshaMei) {
        this.setOriginalData("jigyoshaMei", jigyoshaMei);
        this.jigyoshaMei = jigyoshaMei;
    }

    public void setKanrishaMei(RString kanrishaMei) {
        this.setOriginalData("kanrishaMei", kanrishaMei);
        this.kanrishaMei = kanrishaMei;
    }

    // </editor-fold>
}
