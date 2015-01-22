package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 27 13:48:27 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgSearchResultService_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSearchResultService_Row extends DataRow {

    private TextBoxCode serviceCode;
    private RString serviceMeisho;

    public dgSearchResultService_Row() {
        super();
        this.serviceCode = new TextBoxCode();
        this.serviceMeisho = RString.EMPTY;
    }

    public dgSearchResultService_Row(TextBoxCode serviceCode, RString serviceMeisho) {
        super();
        this.setOriginalData("serviceCode", serviceCode);
        this.setOriginalData("serviceMeisho", serviceMeisho);
        this.serviceCode = serviceCode;
        this.serviceMeisho = serviceMeisho;
    }

    public TextBoxCode getServiceCode() {
        return serviceCode;
    }

    public RString getServiceMeisho() {
        return serviceMeisho;
    }

    public void setServiceCode(TextBoxCode serviceCode) {
        this.setOriginalData("serviceCode", serviceCode);
        this.serviceCode = serviceCode;
    }

    public void setServiceMeisho(RString serviceMeisho) {
        this.setOriginalData("serviceMeisho", serviceMeisho);
        this.serviceMeisho = serviceMeisho;
    }

}