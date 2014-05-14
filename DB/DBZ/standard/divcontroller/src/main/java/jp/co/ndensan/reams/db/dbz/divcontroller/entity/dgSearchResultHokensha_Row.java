package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon May 12 19:07:57 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgSearchResultHokensha_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSearchResultHokensha_Row extends DataRow {

    private Button select;
    private RString hokenshaNo;
    private RString hokenshaMeisho;
    private RString hokensha;

    public dgSearchResultHokensha_Row() {
        super();
    }

    public dgSearchResultHokensha_Row(Button select, RString hokenshaNo, RString hokenshaMeisho, RString hokensha) {
        super();
        this.setOriginalData("select", select);
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.setOriginalData("hokenshaMeisho", hokenshaMeisho);
        this.setOriginalData("hokensha", hokensha);
        this.select = select;
        this.hokenshaNo = hokenshaNo;
        this.hokenshaMeisho = hokenshaMeisho;
        this.hokensha = hokensha;
    }

    public Button getSelect() {
        return select;
    }

    public RString getHokenshaNo() {
        return hokenshaNo;
    }

    public RString getHokenshaMeisho() {
        return hokenshaMeisho;
    }

    public RString getHokensha() {
        return hokensha;
    }

    public void setSelect(Button select) {
        this.setOriginalData("select", select);
        this.select = select;
    }

    public void setHokenshaNo(RString hokenshaNo) {
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.hokenshaNo = hokenshaNo;
    }

    public void setHokenshaMeisho(RString hokenshaMeisho) {
        this.setOriginalData("hokenshaMeisho", hokenshaMeisho);
        this.hokenshaMeisho = hokenshaMeisho;
    }

    public void setHokensha(RString hokensha) {
        this.setOriginalData("hokensha", hokensha);
        this.hokensha = hokensha;
    }

}