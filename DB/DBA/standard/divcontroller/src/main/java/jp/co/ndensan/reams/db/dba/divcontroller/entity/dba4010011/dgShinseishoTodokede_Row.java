package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 30 18:39:13 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgShinseishoTodokede_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinseishoTodokede_Row extends DataRow {

    private RString shinseishoKanriNo;
    private TextBoxFlexibleDate todokedeYMD;
    private RString todokedeShubetsu;
    private RString daikoKubun;
    private RString shimei;
    private RString kanaShimei;
    private RString shimeiAndKanaShimei;
    private RString tsuzukigara;
    private RString jigyoshaNo;
    private RString jigyoshaMeisho;
    private RString jigyosha;
    private RString jigyoshaKubun;
    private RString yubinNo;
    private RString jusho;
    private RString telNo;

    public dgShinseishoTodokede_Row() {
        super();
        this.shinseishoKanriNo = RString.EMPTY;
        this.todokedeYMD = new TextBoxFlexibleDate();
        this.todokedeShubetsu = RString.EMPTY;
        this.daikoKubun = RString.EMPTY;
        this.shimei = RString.EMPTY;
        this.kanaShimei = RString.EMPTY;
        this.shimeiAndKanaShimei = RString.EMPTY;
        this.tsuzukigara = RString.EMPTY;
        this.jigyoshaNo = RString.EMPTY;
        this.jigyoshaMeisho = RString.EMPTY;
        this.jigyosha = RString.EMPTY;
        this.jigyoshaKubun = RString.EMPTY;
        this.yubinNo = RString.EMPTY;
        this.jusho = RString.EMPTY;
        this.telNo = RString.EMPTY;
    }

    public dgShinseishoTodokede_Row(RString shinseishoKanriNo, TextBoxFlexibleDate todokedeYMD, RString todokedeShubetsu, RString daikoKubun, RString shimei, RString kanaShimei, RString shimeiAndKanaShimei, RString tsuzukigara, RString jigyoshaNo, RString jigyoshaMeisho, RString jigyosha, RString jigyoshaKubun, RString yubinNo, RString jusho, RString telNo) {
        super();
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("todokedeYMD", todokedeYMD);
        this.setOriginalData("todokedeShubetsu", todokedeShubetsu);
        this.setOriginalData("daikoKubun", daikoKubun);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("kanaShimei", kanaShimei);
        this.setOriginalData("shimeiAndKanaShimei", shimeiAndKanaShimei);
        this.setOriginalData("tsuzukigara", tsuzukigara);
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.setOriginalData("jigyoshaMeisho", jigyoshaMeisho);
        this.setOriginalData("jigyosha", jigyosha);
        this.setOriginalData("jigyoshaKubun", jigyoshaKubun);
        this.setOriginalData("yubinNo", yubinNo);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("telNo", telNo);
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.todokedeYMD = todokedeYMD;
        this.todokedeShubetsu = todokedeShubetsu;
        this.daikoKubun = daikoKubun;
        this.shimei = shimei;
        this.kanaShimei = kanaShimei;
        this.shimeiAndKanaShimei = shimeiAndKanaShimei;
        this.tsuzukigara = tsuzukigara;
        this.jigyoshaNo = jigyoshaNo;
        this.jigyoshaMeisho = jigyoshaMeisho;
        this.jigyosha = jigyosha;
        this.jigyoshaKubun = jigyoshaKubun;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.telNo = telNo;
    }

    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    public TextBoxFlexibleDate getTodokedeYMD() {
        return todokedeYMD;
    }

    public RString getTodokedeShubetsu() {
        return todokedeShubetsu;
    }

    public RString getDaikoKubun() {
        return daikoKubun;
    }

    public RString getShimei() {
        return shimei;
    }

    public RString getKanaShimei() {
        return kanaShimei;
    }

    public RString getShimeiAndKanaShimei() {
        return shimeiAndKanaShimei;
    }

    public RString getTsuzukigara() {
        return tsuzukigara;
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

    public RString getJigyoshaKubun() {
        return jigyoshaKubun;
    }

    public RString getYubinNo() {
        return yubinNo;
    }

    public RString getJusho() {
        return jusho;
    }

    public RString getTelNo() {
        return telNo;
    }

    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    public void setTodokedeYMD(TextBoxFlexibleDate todokedeYMD) {
        this.setOriginalData("todokedeYMD", todokedeYMD);
        this.todokedeYMD = todokedeYMD;
    }

    public void setTodokedeShubetsu(RString todokedeShubetsu) {
        this.setOriginalData("todokedeShubetsu", todokedeShubetsu);
        this.todokedeShubetsu = todokedeShubetsu;
    }

    public void setDaikoKubun(RString daikoKubun) {
        this.setOriginalData("daikoKubun", daikoKubun);
        this.daikoKubun = daikoKubun;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setKanaShimei(RString kanaShimei) {
        this.setOriginalData("kanaShimei", kanaShimei);
        this.kanaShimei = kanaShimei;
    }

    public void setShimeiAndKanaShimei(RString shimeiAndKanaShimei) {
        this.setOriginalData("shimeiAndKanaShimei", shimeiAndKanaShimei);
        this.shimeiAndKanaShimei = shimeiAndKanaShimei;
    }

    public void setTsuzukigara(RString tsuzukigara) {
        this.setOriginalData("tsuzukigara", tsuzukigara);
        this.tsuzukigara = tsuzukigara;
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

    public void setJigyoshaKubun(RString jigyoshaKubun) {
        this.setOriginalData("jigyoshaKubun", jigyoshaKubun);
        this.jigyoshaKubun = jigyoshaKubun;
    }

    public void setYubinNo(RString yubinNo) {
        this.setOriginalData("yubinNo", yubinNo);
        this.yubinNo = yubinNo;
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
