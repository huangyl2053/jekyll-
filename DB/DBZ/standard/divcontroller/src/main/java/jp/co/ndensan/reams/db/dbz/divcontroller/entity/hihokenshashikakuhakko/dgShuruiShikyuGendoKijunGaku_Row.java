package jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshashikakuhakko;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Dec 25 20:20:45 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShuruiShikyuGendoKijunGaku_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShuruiShikyuGendoKijunGaku_Row extends DataRow {

    private RString serviceShurui;
    private RString gendoGaku;

    public dgShuruiShikyuGendoKijunGaku_Row() {
        super();
        this.serviceShurui = RString.EMPTY;
        this.gendoGaku = RString.EMPTY;
    }

    public dgShuruiShikyuGendoKijunGaku_Row(RString serviceShurui, RString gendoGaku) {
        super();
        this.setOriginalData("serviceShurui", serviceShurui);
        this.setOriginalData("gendoGaku", gendoGaku);
        this.serviceShurui = serviceShurui;
        this.gendoGaku = gendoGaku;
    }

    public RString getServiceShurui() {
        return serviceShurui;
    }

    public RString getGendoGaku() {
        return gendoGaku;
    }

    public void setServiceShurui(RString serviceShurui) {
        this.setOriginalData("serviceShurui", serviceShurui);
        this.serviceShurui = serviceShurui;
    }

    public void setGendoGaku(RString gendoGaku) {
        this.setOriginalData("gendoGaku", gendoGaku);
        this.gendoGaku = gendoGaku;
    }

}