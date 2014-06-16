package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 16 14:47:14 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShiteiServiceShurui_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShiteiServiceShurui_Row extends DataRow {

    private TextBoxCode serviceNo;
    private RString serviceType;

    public dgShiteiServiceShurui_Row() {
        super();
        this.serviceNo = new TextBoxCode();
        this.serviceType = RString.EMPTY;
    }

    public dgShiteiServiceShurui_Row(TextBoxCode serviceNo, RString serviceType) {
        super();
        this.setOriginalData("serviceNo", serviceNo);
        this.setOriginalData("serviceType", serviceType);
        this.serviceNo = serviceNo;
        this.serviceType = serviceType;
    }

    public TextBoxCode getServiceNo() {
        return serviceNo;
    }

    public RString getServiceType() {
        return serviceType;
    }

    public void setServiceNo(TextBoxCode serviceNo) {
        this.setOriginalData("serviceNo", serviceNo);
        this.serviceNo = serviceNo;
    }

    public void setServiceType(RString serviceType) {
        this.setOriginalData("serviceType", serviceType);
        this.serviceType = serviceType;
    }

}