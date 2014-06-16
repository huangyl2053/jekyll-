package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 16 19:20:45 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShinsakaiIinJoho_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsakaiIinJoho_Row extends DataRow {

    private RString shinsakaiIin;
    private RString shinsainKbn;
    private RString gogitaichoKbn;
    private RString shukketsuKbn;

    public dgShinsakaiIinJoho_Row() {
        super();
        this.shinsakaiIin = RString.EMPTY;
        this.shinsainKbn = RString.EMPTY;
        this.gogitaichoKbn = RString.EMPTY;
        this.shukketsuKbn = RString.EMPTY;
    }

    public dgShinsakaiIinJoho_Row(RString shinsakaiIin, RString shinsainKbn, RString gogitaichoKbn, RString shukketsuKbn) {
        super();
        this.setOriginalData("shinsakaiIin", shinsakaiIin);
        this.setOriginalData("shinsainKbn", shinsainKbn);
        this.setOriginalData("gogitaichoKbn", gogitaichoKbn);
        this.setOriginalData("shukketsuKbn", shukketsuKbn);
        this.shinsakaiIin = shinsakaiIin;
        this.shinsainKbn = shinsainKbn;
        this.gogitaichoKbn = gogitaichoKbn;
        this.shukketsuKbn = shukketsuKbn;
    }

    public RString getShinsakaiIin() {
        return shinsakaiIin;
    }

    public RString getShinsainKbn() {
        return shinsainKbn;
    }

    public RString getGogitaichoKbn() {
        return gogitaichoKbn;
    }

    public RString getShukketsuKbn() {
        return shukketsuKbn;
    }

    public void setShinsakaiIin(RString shinsakaiIin) {
        this.setOriginalData("shinsakaiIin", shinsakaiIin);
        this.shinsakaiIin = shinsakaiIin;
    }

    public void setShinsainKbn(RString shinsainKbn) {
        this.setOriginalData("shinsainKbn", shinsainKbn);
        this.shinsainKbn = shinsainKbn;
    }

    public void setGogitaichoKbn(RString gogitaichoKbn) {
        this.setOriginalData("gogitaichoKbn", gogitaichoKbn);
        this.gogitaichoKbn = gogitaichoKbn;
    }

    public void setShukketsuKbn(RString shukketsuKbn) {
        this.setOriginalData("shukketsuKbn", shukketsuKbn);
        this.shukketsuKbn = shukketsuKbn;
    }

}