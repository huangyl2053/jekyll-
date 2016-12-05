package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Dec 05 18:55:12 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;


/**
 * dgShinsakaiIinIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsakaiIinIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">

    private TextBoxNum number;
    private RString shinsakjaiIinCode;
    private RString shimei;
    private RString seibetsu;
    private RString shikaku;
    private RString gogitaichoKubun;
    private DropDownList gichoKubun;
    private DropDownList shukketsuKubun;
    private RString shozokuKikan;
    private DropDownList chikokuUmu;
    private TextBoxTime shussekiTime;
    private DropDownList sotaiUmu;
    private TextBoxTime taisekiTime;

    public dgShinsakaiIinIchiran_Row() {
        super();
        this.number = new TextBoxNum();
        this.shinsakjaiIinCode = RString.EMPTY;
        this.shimei = RString.EMPTY;
        this.seibetsu = RString.EMPTY;
        this.shikaku = RString.EMPTY;
        this.gogitaichoKubun = RString.EMPTY;
        this.gichoKubun = new DropDownList();
        this.shukketsuKubun = new DropDownList();
        this.shozokuKikan = RString.EMPTY;
        this.chikokuUmu = new DropDownList();
        this.shussekiTime = new TextBoxTime();
        this.sotaiUmu = new DropDownList();
        this.taisekiTime = new TextBoxTime();
        this.setOriginalData("number", number);
        this.setOriginalData("shinsakjaiIinCode", shinsakjaiIinCode);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("shikaku", shikaku);
        this.setOriginalData("gogitaichoKubun", gogitaichoKubun);
        this.setOriginalData("gichoKubun", gichoKubun);
        this.setOriginalData("shukketsuKubun", shukketsuKubun);
        this.setOriginalData("shozokuKikan", shozokuKikan);
        this.setOriginalData("chikokuUmu", chikokuUmu);
        this.setOriginalData("shussekiTime", shussekiTime);
        this.setOriginalData("sotaiUmu", sotaiUmu);
        this.setOriginalData("taisekiTime", taisekiTime);
    }

    public dgShinsakaiIinIchiran_Row(TextBoxNum number, RString shinsakjaiIinCode, RString shimei, RString seibetsu, RString shikaku, RString gogitaichoKubun, DropDownList gichoKubun, DropDownList shukketsuKubun, RString shozokuKikan, DropDownList chikokuUmu, TextBoxTime shussekiTime, DropDownList sotaiUmu, TextBoxTime taisekiTime) {
        super();
        this.setOriginalData("number", number);
        this.setOriginalData("shinsakjaiIinCode", shinsakjaiIinCode);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("shikaku", shikaku);
        this.setOriginalData("gogitaichoKubun", gogitaichoKubun);
        this.setOriginalData("gichoKubun", gichoKubun);
        this.setOriginalData("shukketsuKubun", shukketsuKubun);
        this.setOriginalData("shozokuKikan", shozokuKikan);
        this.setOriginalData("chikokuUmu", chikokuUmu);
        this.setOriginalData("shussekiTime", shussekiTime);
        this.setOriginalData("sotaiUmu", sotaiUmu);
        this.setOriginalData("taisekiTime", taisekiTime);
        this.number = number;
        this.shinsakjaiIinCode = shinsakjaiIinCode;
        this.shimei = shimei;
        this.seibetsu = seibetsu;
        this.shikaku = shikaku;
        this.gogitaichoKubun = gogitaichoKubun;
        this.gichoKubun = gichoKubun;
        this.shukketsuKubun = shukketsuKubun;
        this.shozokuKikan = shozokuKikan;
        this.chikokuUmu = chikokuUmu;
        this.shussekiTime = shussekiTime;
        this.sotaiUmu = sotaiUmu;
        this.taisekiTime = taisekiTime;
    }

    public dgShinsakaiIinIchiran_Row(DataGridSetting gridSetting) {
        super();
        this.number = new TextBoxNum();
        this.shinsakjaiIinCode = RString.EMPTY;
        this.shimei = RString.EMPTY;
        this.seibetsu = RString.EMPTY;
        this.shikaku = RString.EMPTY;
        this.gogitaichoKubun = RString.EMPTY;
        this.gichoKubun = DropDownList.createInstance(gridSetting.getColumn("gichoKubun").getCellDetails());
        this.shukketsuKubun = DropDownList.createInstance(gridSetting.getColumn("shukketsuKubun").getCellDetails());
        this.shozokuKikan = RString.EMPTY;
        this.chikokuUmu = DropDownList.createInstance(gridSetting.getColumn("chikokuUmu").getCellDetails());
        this.shussekiTime = new TextBoxTime();
        this.sotaiUmu = DropDownList.createInstance(gridSetting.getColumn("sotaiUmu").getCellDetails());
        this.taisekiTime = new TextBoxTime();
        this.setOriginalData("number", number);
        this.setOriginalData("shinsakjaiIinCode", shinsakjaiIinCode);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("shikaku", shikaku);
        this.setOriginalData("gogitaichoKubun", gogitaichoKubun);
        this.setOriginalData("gichoKubun", gichoKubun);
        this.setOriginalData("shukketsuKubun", shukketsuKubun);
        this.setOriginalData("shozokuKikan", shozokuKikan);
        this.setOriginalData("chikokuUmu", chikokuUmu);
        this.setOriginalData("shussekiTime", shussekiTime);
        this.setOriginalData("sotaiUmu", sotaiUmu);
        this.setOriginalData("taisekiTime", taisekiTime);
    }

    public TextBoxNum getNumber() {
        return number;
    }

    public RString getShinsakjaiIinCode() {
        return shinsakjaiIinCode;
    }

    public RString getShimei() {
        return shimei;
    }

    public RString getSeibetsu() {
        return seibetsu;
    }

    public RString getShikaku() {
        return shikaku;
    }

    public RString getGogitaichoKubun() {
        return gogitaichoKubun;
    }

    public DropDownList getGichoKubun() {
        return gichoKubun;
    }

    public DropDownList getShukketsuKubun() {
        return shukketsuKubun;
    }

    public RString getShozokuKikan() {
        return shozokuKikan;
    }

    public DropDownList getChikokuUmu() {
        return chikokuUmu;
    }

    public TextBoxTime getShussekiTime() {
        return shussekiTime;
    }

    public DropDownList getSotaiUmu() {
        return sotaiUmu;
    }

    public TextBoxTime getTaisekiTime() {
        return taisekiTime;
    }

    public void setNumber(TextBoxNum number) {
        this.setOriginalData("number", number);
        this.number = number;
    }

    public void setShinsakjaiIinCode(RString shinsakjaiIinCode) {
        this.setOriginalData("shinsakjaiIinCode", shinsakjaiIinCode);
        this.shinsakjaiIinCode = shinsakjaiIinCode;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setSeibetsu(RString seibetsu) {
        this.setOriginalData("seibetsu", seibetsu);
        this.seibetsu = seibetsu;
    }

    public void setShikaku(RString shikaku) {
        this.setOriginalData("shikaku", shikaku);
        this.shikaku = shikaku;
    }

    public void setGogitaichoKubun(RString gogitaichoKubun) {
        this.setOriginalData("gogitaichoKubun", gogitaichoKubun);
        this.gogitaichoKubun = gogitaichoKubun;
    }

    public void setGichoKubun(DropDownList gichoKubun) {
        this.setOriginalData("gichoKubun", gichoKubun);
        this.gichoKubun = gichoKubun;
    }

    public void setShukketsuKubun(DropDownList shukketsuKubun) {
        this.setOriginalData("shukketsuKubun", shukketsuKubun);
        this.shukketsuKubun = shukketsuKubun;
    }

    public void setShozokuKikan(RString shozokuKikan) {
        this.setOriginalData("shozokuKikan", shozokuKikan);
        this.shozokuKikan = shozokuKikan;
    }

    public void setChikokuUmu(DropDownList chikokuUmu) {
        this.setOriginalData("chikokuUmu", chikokuUmu);
        this.chikokuUmu = chikokuUmu;
    }

    public void setShussekiTime(TextBoxTime shussekiTime) {
        this.setOriginalData("shussekiTime", shussekiTime);
        this.shussekiTime = shussekiTime;
    }

    public void setSotaiUmu(DropDownList sotaiUmu) {
        this.setOriginalData("sotaiUmu", sotaiUmu);
        this.sotaiUmu = sotaiUmu;
    }

    public void setTaisekiTime(TextBoxTime taisekiTime) {
        this.setOriginalData("taisekiTime", taisekiTime);
        this.taisekiTime = taisekiTime;
    }

    // </editor-fold>
}
