package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu May 08 20:53:20 JST 2014 
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
    private RString hokensha;

    public dgSearchResultHokensha_Row() {
        super();
    }

    public dgSearchResultHokensha_Row(Button select, RString hokensha) {
        super();
        this.setOriginalData("select", select);
        this.setOriginalData("hokensha", hokensha);
        this.select = select;
        this.hokensha = hokensha;
    }

    public Button getSelect() {
        return select;
    }

    public RString getHokensha() {
        return hokensha;
    }

    public void setSelect(Button select) {
        this.setOriginalData("select", select);
        this.select = select;
    }

    public void setHokensha(RString hokensha) {
        this.setOriginalData("hokensha", hokensha);
        this.hokensha = hokensha;
    }

}