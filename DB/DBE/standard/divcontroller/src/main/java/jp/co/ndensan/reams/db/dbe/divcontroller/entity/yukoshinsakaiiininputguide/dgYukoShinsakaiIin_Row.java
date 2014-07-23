package jp.co.ndensan.reams.db.dbe.divcontroller.entity.yukoshinsakaiiininputguide;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jul 22 15:58:10 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgYukoShinsakaiIin_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgYukoShinsakaiIin_Row extends DataRow {

    private RString shinsakaiIinCode;
    private TextBoxFlexibleDate kaishiDate;
    private RString jigyosha;
    private RString shimei;
    private RString gender;
    private RString jusho;
    private RString telNo;

    public dgYukoShinsakaiIin_Row() {
        super();
        this.shinsakaiIinCode = RString.EMPTY;
        this.kaishiDate = new TextBoxFlexibleDate();
        this.jigyosha = RString.EMPTY;
        this.shimei = RString.EMPTY;
        this.gender = RString.EMPTY;
        this.jusho = RString.EMPTY;
        this.telNo = RString.EMPTY;
    }

    public dgYukoShinsakaiIin_Row(RString shinsakaiIinCode, TextBoxFlexibleDate kaishiDate, RString jigyosha, RString shimei, RString gender, RString jusho, RString telNo) {
        super();
        this.setOriginalData("shinsakaiIinCode", shinsakaiIinCode);
        this.setOriginalData("kaishiDate", kaishiDate);
        this.setOriginalData("jigyosha", jigyosha);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("gender", gender);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("telNo", telNo);
        this.shinsakaiIinCode = shinsakaiIinCode;
        this.kaishiDate = kaishiDate;
        this.jigyosha = jigyosha;
        this.shimei = shimei;
        this.gender = gender;
        this.jusho = jusho;
        this.telNo = telNo;
    }

    public RString getShinsakaiIinCode() {
        return shinsakaiIinCode;
    }

    public TextBoxFlexibleDate getKaishiDate() {
        return kaishiDate;
    }

    public RString getJigyosha() {
        return jigyosha;
    }

    public RString getShimei() {
        return shimei;
    }

    public RString getGender() {
        return gender;
    }

    public RString getJusho() {
        return jusho;
    }

    public RString getTelNo() {
        return telNo;
    }

    public void setShinsakaiIinCode(RString shinsakaiIinCode) {
        this.setOriginalData("shinsakaiIinCode", shinsakaiIinCode);
        this.shinsakaiIinCode = shinsakaiIinCode;
    }

    public void setKaishiDate(TextBoxFlexibleDate kaishiDate) {
        this.setOriginalData("kaishiDate", kaishiDate);
        this.kaishiDate = kaishiDate;
    }

    public void setJigyosha(RString jigyosha) {
        this.setOriginalData("jigyosha", jigyosha);
        this.jigyosha = jigyosha;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setGender(RString gender) {
        this.setOriginalData("gender", gender);
        this.gender = gender;
    }

    public void setJusho(RString jusho) {
        this.setOriginalData("jusho", jusho);
        this.jusho = jusho;
    }

    public void setTelNo(RString telNo) {
        this.setOriginalData("telNo", telNo);
        this.telNo = telNo;
    }

}