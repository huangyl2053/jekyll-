package jp.co.ndensan.reams.db.dbx.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Apr 06 11:24:09 JST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKaigoJigyoshaService_Row のクラスファイル 
 * 
 * @author 自動生成
 * @jpName
 * @bizDomain 介護
 * @category DAメニュー
 * @subCategory 介護事業者登録
 * @mainClass
 * @reference
 */

public class dgKaigoJigyoshaService_Row extends DataRow {

    private RString kyufuBunrui;
    private RString serviceBunrui;
    private RString shuruiCode;
    private RString serviceMei;

    public dgKaigoJigyoshaService_Row() {
        super();
        this.kyufuBunrui = RString.EMPTY;
        this.serviceBunrui = RString.EMPTY;
        this.shuruiCode = RString.EMPTY;
        this.serviceMei = RString.EMPTY;
    }

    public dgKaigoJigyoshaService_Row(RString kyufuBunrui, RString serviceBunrui, RString shuruiCode, RString serviceMei) {
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

}
