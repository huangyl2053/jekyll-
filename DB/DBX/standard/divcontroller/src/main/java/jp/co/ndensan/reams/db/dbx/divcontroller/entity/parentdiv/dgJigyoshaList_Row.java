package jp.co.ndensan.reams.db.dbx.divcontroller.entity.parentdiv;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Apr 06 11:19:14 JST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgJigyoshaList_Row のクラスファイル 
 * 
 * @author 自動生成
 * @jpName
 * @bizDomain 介護
 * @category DAメニュー
 * @subCategory 介護事業者登録
 * @mainClass
 * @reference
 */

public class dgJigyoshaList_Row extends DataRow {

    private RString jigyoshaNo;
    private TextBoxFlexibleDate kaishiDate;
    private TextBoxFlexibleDate haishiDate;
    private RString meisho;
    private RString kanaMeisho;
    private RString meishoAndKanaMeisho;
    private RString serviceType;
    private RString jusho;
    private RString telNo;

    public dgJigyoshaList_Row() {
        super();
        this.jigyoshaNo = RString.EMPTY;
        this.kaishiDate = new TextBoxFlexibleDate();
        this.haishiDate = new TextBoxFlexibleDate();
        this.meisho = RString.EMPTY;
        this.kanaMeisho = RString.EMPTY;
        this.meishoAndKanaMeisho = RString.EMPTY;
        this.serviceType = RString.EMPTY;
        this.jusho = RString.EMPTY;
        this.telNo = RString.EMPTY;
    }

    public dgJigyoshaList_Row(RString jigyoshaNo, TextBoxFlexibleDate kaishiDate, TextBoxFlexibleDate haishiDate, RString meisho, RString kanaMeisho, RString meishoAndKanaMeisho, RString serviceType, RString jusho, RString telNo) {
        super();
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.setOriginalData("kaishiDate", kaishiDate);
        this.setOriginalData("haishiDate", haishiDate);
        this.setOriginalData("meisho", meisho);
        this.setOriginalData("kanaMeisho", kanaMeisho);
        this.setOriginalData("meishoAndKanaMeisho", meishoAndKanaMeisho);
        this.setOriginalData("serviceType", serviceType);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("telNo", telNo);
        this.jigyoshaNo = jigyoshaNo;
        this.kaishiDate = kaishiDate;
        this.haishiDate = haishiDate;
        this.meisho = meisho;
        this.kanaMeisho = kanaMeisho;
        this.meishoAndKanaMeisho = meishoAndKanaMeisho;
        this.serviceType = serviceType;
        this.jusho = jusho;
        this.telNo = telNo;
    }

    public RString getJigyoshaNo() {
        return jigyoshaNo;
    }

    public TextBoxFlexibleDate getKaishiDate() {
        return kaishiDate;
    }

    public TextBoxFlexibleDate getHaishiDate() {
        return haishiDate;
    }

    public RString getMeisho() {
        return meisho;
    }

    public RString getKanaMeisho() {
        return kanaMeisho;
    }

    public RString getMeishoAndKanaMeisho() {
        return meishoAndKanaMeisho;
    }

    public RString getServiceType() {
        return serviceType;
    }

    public RString getJusho() {
        return jusho;
    }

    public RString getTelNo() {
        return telNo;
    }

    public void setJigyoshaNo(RString jigyoshaNo) {
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.jigyoshaNo = jigyoshaNo;
    }

    public void setKaishiDate(TextBoxFlexibleDate kaishiDate) {
        this.setOriginalData("kaishiDate", kaishiDate);
        this.kaishiDate = kaishiDate;
    }

    public void setHaishiDate(TextBoxFlexibleDate haishiDate) {
        this.setOriginalData("haishiDate", haishiDate);
        this.haishiDate = haishiDate;
    }

    public void setMeisho(RString meisho) {
        this.setOriginalData("meisho", meisho);
        this.meisho = meisho;
    }

    public void setKanaMeisho(RString kanaMeisho) {
        this.setOriginalData("kanaMeisho", kanaMeisho);
        this.kanaMeisho = kanaMeisho;
    }

    public void setMeishoAndKanaMeisho(RString meishoAndKanaMeisho) {
        this.setOriginalData("meishoAndKanaMeisho", meishoAndKanaMeisho);
        this.meishoAndKanaMeisho = meishoAndKanaMeisho;
    }

    public void setServiceType(RString serviceType) {
        this.setOriginalData("serviceType", serviceType);
        this.serviceType = serviceType;
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
