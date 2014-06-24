package jp.co.ndensan.reams.db.dbz.divcontroller.entity.tekiyojogaishisetsuinputguide;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 23 19:47:13 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgTekiyoJogaiShisetsu_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTekiyoJogaiShisetsu_Row extends DataRow {

    private RString jigyoshaNo;
    private RString jigyoshaMeisho;
    private RString jigyosha;
    private RString jusho;

    public dgTekiyoJogaiShisetsu_Row() {
        super();
        this.jigyoshaNo = RString.EMPTY;
        this.jigyoshaMeisho = RString.EMPTY;
        this.jigyosha = RString.EMPTY;
        this.jusho = RString.EMPTY;
    }

    public dgTekiyoJogaiShisetsu_Row(RString jigyoshaNo, RString jigyoshaMeisho, RString jigyosha, RString jusho) {
        super();
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.setOriginalData("jigyoshaMeisho", jigyoshaMeisho);
        this.setOriginalData("jigyosha", jigyosha);
        this.setOriginalData("jusho", jusho);
        this.jigyoshaNo = jigyoshaNo;
        this.jigyoshaMeisho = jigyoshaMeisho;
        this.jigyosha = jigyosha;
        this.jusho = jusho;
    }

    public RString getJigyoshaNo() {
        return jigyoshaNo;
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

    public void setJigyoshaNo(RString jigyoshaNo) {
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.jigyoshaNo = jigyoshaNo;
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