package jp.co.ndensan.reams.db.dbz.divcontroller.entity.othertokureishisetsuinputguide;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 23 19:46:30 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgSearchResultOtherTokureiShisetsu_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSearchResultOtherTokureiShisetsu_Row extends DataRow {

    private RString jigyoshaCode;
    private RString jigyoshaMeisho;
    private RString jigyosha;
    private RString jusho;

    public dgSearchResultOtherTokureiShisetsu_Row() {
        super();
        this.jigyoshaCode = RString.EMPTY;
        this.jigyoshaMeisho = RString.EMPTY;
        this.jigyosha = RString.EMPTY;
        this.jusho = RString.EMPTY;
    }

    public dgSearchResultOtherTokureiShisetsu_Row(RString jigyoshaCode, RString jigyoshaMeisho, RString jigyosha, RString jusho) {
        super();
        this.setOriginalData("jigyoshaCode", jigyoshaCode);
        this.setOriginalData("jigyoshaMeisho", jigyoshaMeisho);
        this.setOriginalData("jigyosha", jigyosha);
        this.setOriginalData("jusho", jusho);
        this.jigyoshaCode = jigyoshaCode;
        this.jigyoshaMeisho = jigyoshaMeisho;
        this.jigyosha = jigyosha;
        this.jusho = jusho;
    }

    public RString getJigyoshaCode() {
        return jigyoshaCode;
    }

    public RString getJigyoshaMeisho() {
        return jigyoshaMeisho;
    }

    public RString getJigyosha() {
        return jigyosha;
    }

    public RString getJusho() {
        return jusho;
    }

    public void setJigyoshaCode(RString jigyoshaCode) {
        this.setOriginalData("jigyoshaCode", jigyoshaCode);
        this.jigyoshaCode = jigyoshaCode;
    }

    public void setJigyoshaMeisho(RString jigyoshaMeisho) {
        this.setOriginalData("jigyoshaMeisho", jigyoshaMeisho);
        this.jigyoshaMeisho = jigyoshaMeisho;
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