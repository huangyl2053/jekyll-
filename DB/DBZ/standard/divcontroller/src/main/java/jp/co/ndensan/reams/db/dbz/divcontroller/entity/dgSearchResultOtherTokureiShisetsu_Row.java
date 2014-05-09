package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu May 08 21:12:50 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgSearchResultOtherTokureiShisetsu_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSearchResultOtherTokureiShisetsu_Row extends DataRow {

    private Button select;
    private RString jigyosha;
    private RString jusho;

    public dgSearchResultOtherTokureiShisetsu_Row() {
        super();
    }

    public dgSearchResultOtherTokureiShisetsu_Row(Button select, RString jigyosha, RString jusho) {
        super();
        this.setOriginalData("select", select);
        this.setOriginalData("jigyosha", jigyosha);
        this.setOriginalData("jusho", jusho);
        this.select = select;
        this.jigyosha = jigyosha;
        this.jusho = jusho;
    }

    public Button getSelect() {
        return select;
    }

    public RString getJigyosha() {
        return jigyosha;
    }

    public RString getJusho() {
        return jusho;
    }

    public void setSelect(Button select) {
        this.setOriginalData("select", select);
        this.select = select;
    }

    public void setJigyosha(RString jigyosha) {
        this.setOriginalData("jigyosha", jigyosha);
        this.jigyosha = jigyosha;
    }

    public void setJusho(RString jusho) {
        this.setOriginalData("jusho", jusho);
        this.jusho = jusho;
    }

}