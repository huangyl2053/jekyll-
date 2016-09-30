package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5520001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Sep 22 20:00:07 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridColumnCheckBox;


/**
 * dgRirekiIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgRirekiIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private ButtonDialog shusei;
    private ButtonDialog sakujo;
    private Button kaihuku;
    private RString kubun;
    private RString ninteiNaiyo;
    private RString dataKubun;
    private TextBoxDate niteiDay;
    private RString yokaigodo;
    private TextBoxDate yukoKaishi;
    private TextBoxDate yukoShuryo;
    private Boolean kyusochi;
    private RString shinsakaiIken;
    private RString shinseishoKanriNo;
    private RString deserializedBusiness;
    private RString dataPass;
    private RString rirekiNo;
    private RString shinseirirekiJoho;
    private RString maeGoKubun;
    private DataGridColumnCheckBox tsuikaKubun;

    public dgRirekiIchiran_Row() {
        super();
        this.shusei = new ButtonDialog();
        this.sakujo = new ButtonDialog();
        this.kaihuku = new Button();
        this.kubun = RString.EMPTY;
        this.ninteiNaiyo = RString.EMPTY;
        this.dataKubun = RString.EMPTY;
        this.niteiDay = new TextBoxDate();
        this.yokaigodo = RString.EMPTY;
        this.yukoKaishi = new TextBoxDate();
        this.yukoShuryo = new TextBoxDate();
        this.kyusochi = false;
        this.shinsakaiIken = RString.EMPTY;
        this.shinseishoKanriNo = RString.EMPTY;
        this.deserializedBusiness = RString.EMPTY;
        this.dataPass = RString.EMPTY;
        this.rirekiNo = RString.EMPTY;
        this.shinseirirekiJoho = RString.EMPTY;
        this.maeGoKubun = RString.EMPTY;
        this.tsuikaKubun = new DataGridColumnCheckBox();
        this.setOriginalData("shusei", shusei);
        this.setOriginalData("sakujo", sakujo);
        this.setOriginalData("kaihuku", kaihuku);
        this.setOriginalData("kubun", kubun);
        this.setOriginalData("ninteiNaiyo", ninteiNaiyo);
        this.setOriginalData("dataKubun", dataKubun);
        this.setOriginalData("niteiDay", niteiDay);
        this.setOriginalData("yokaigodo", yokaigodo);
        this.setOriginalData("yukoKaishi", yukoKaishi);
        this.setOriginalData("yukoShuryo", yukoShuryo);
        this.setOriginalData("kyusochi", kyusochi);
        this.setOriginalData("shinsakaiIken", shinsakaiIken);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("deserializedBusiness", deserializedBusiness);
        this.setOriginalData("dataPass", dataPass);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("shinseirirekiJoho", shinseirirekiJoho);
        this.setOriginalData("maeGoKubun", maeGoKubun);
        this.setOriginalData("tsuikaKubun", tsuikaKubun);
    }

    public dgRirekiIchiran_Row(ButtonDialog shusei, ButtonDialog sakujo, Button kaihuku, RString kubun, RString ninteiNaiyo, RString dataKubun, TextBoxDate niteiDay, RString yokaigodo, TextBoxDate yukoKaishi, TextBoxDate yukoShuryo, Boolean kyusochi, RString shinsakaiIken, RString shinseishoKanriNo, RString deserializedBusiness, RString dataPass, RString rirekiNo, RString shinseirirekiJoho, RString maeGoKubun, DataGridColumnCheckBox tsuikaKubun) {
        super();
        this.setOriginalData("shusei", shusei);
        this.setOriginalData("sakujo", sakujo);
        this.setOriginalData("kaihuku", kaihuku);
        this.setOriginalData("kubun", kubun);
        this.setOriginalData("ninteiNaiyo", ninteiNaiyo);
        this.setOriginalData("dataKubun", dataKubun);
        this.setOriginalData("niteiDay", niteiDay);
        this.setOriginalData("yokaigodo", yokaigodo);
        this.setOriginalData("yukoKaishi", yukoKaishi);
        this.setOriginalData("yukoShuryo", yukoShuryo);
        this.setOriginalData("kyusochi", kyusochi);
        this.setOriginalData("shinsakaiIken", shinsakaiIken);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("deserializedBusiness", deserializedBusiness);
        this.setOriginalData("dataPass", dataPass);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("shinseirirekiJoho", shinseirirekiJoho);
        this.setOriginalData("maeGoKubun", maeGoKubun);
        this.setOriginalData("tsuikaKubun", tsuikaKubun);
        this.shusei = shusei;
        this.sakujo = sakujo;
        this.kaihuku = kaihuku;
        this.kubun = kubun;
        this.ninteiNaiyo = ninteiNaiyo;
        this.dataKubun = dataKubun;
        this.niteiDay = niteiDay;
        this.yokaigodo = yokaigodo;
        this.yukoKaishi = yukoKaishi;
        this.yukoShuryo = yukoShuryo;
        this.kyusochi = kyusochi;
        this.shinsakaiIken = shinsakaiIken;
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.deserializedBusiness = deserializedBusiness;
        this.dataPass = dataPass;
        this.rirekiNo = rirekiNo;
        this.shinseirirekiJoho = shinseirirekiJoho;
        this.maeGoKubun = maeGoKubun;
        this.tsuikaKubun = tsuikaKubun;
    }

    public dgRirekiIchiran_Row(DataGridSetting gridSetting) {
        super();
        this.shusei = new ButtonDialog();
        this.sakujo = new ButtonDialog();
        this.kaihuku = new Button();
        this.kubun = RString.EMPTY;
        this.ninteiNaiyo = RString.EMPTY;
        this.dataKubun = RString.EMPTY;
        this.niteiDay = new TextBoxDate();
        this.yokaigodo = RString.EMPTY;
        this.yukoKaishi = new TextBoxDate();
        this.yukoShuryo = new TextBoxDate();
        this.kyusochi = false;
        this.shinsakaiIken = RString.EMPTY;
        this.shinseishoKanriNo = RString.EMPTY;
        this.deserializedBusiness = RString.EMPTY;
        this.dataPass = RString.EMPTY;
        this.rirekiNo = RString.EMPTY;
        this.shinseirirekiJoho = RString.EMPTY;
        this.maeGoKubun = RString.EMPTY;
        this.tsuikaKubun = DataGridColumnCheckBox.createInstance(gridSetting.getColumn("tsuikaKubun").getCellDetails());
        this.setOriginalData("shusei", shusei);
        this.setOriginalData("sakujo", sakujo);
        this.setOriginalData("kaihuku", kaihuku);
        this.setOriginalData("kubun", kubun);
        this.setOriginalData("ninteiNaiyo", ninteiNaiyo);
        this.setOriginalData("dataKubun", dataKubun);
        this.setOriginalData("niteiDay", niteiDay);
        this.setOriginalData("yokaigodo", yokaigodo);
        this.setOriginalData("yukoKaishi", yukoKaishi);
        this.setOriginalData("yukoShuryo", yukoShuryo);
        this.setOriginalData("kyusochi", kyusochi);
        this.setOriginalData("shinsakaiIken", shinsakaiIken);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("deserializedBusiness", deserializedBusiness);
        this.setOriginalData("dataPass", dataPass);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("shinseirirekiJoho", shinseirirekiJoho);
        this.setOriginalData("maeGoKubun", maeGoKubun);
        this.setOriginalData("tsuikaKubun", tsuikaKubun);
    }

    public ButtonDialog getShusei() {
        return shusei;
    }

    public ButtonDialog getSakujo() {
        return sakujo;
    }

    public Button getKaihuku() {
        return kaihuku;
    }

    public RString getKubun() {
        return kubun;
    }

    public RString getNinteiNaiyo() {
        return ninteiNaiyo;
    }

    public RString getDataKubun() {
        return dataKubun;
    }

    public TextBoxDate getNiteiDay() {
        return niteiDay;
    }

    public RString getYokaigodo() {
        return yokaigodo;
    }

    public TextBoxDate getYukoKaishi() {
        return yukoKaishi;
    }

    public TextBoxDate getYukoShuryo() {
        return yukoShuryo;
    }

    public Boolean getKyusochi() {
        return kyusochi;
    }

    public RString getShinsakaiIken() {
        return shinsakaiIken;
    }

    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    public RString getDeserializedBusiness() {
        return deserializedBusiness;
    }

    public RString getDataPass() {
        return dataPass;
    }

    public RString getRirekiNo() {
        return rirekiNo;
    }

    public RString getShinseirirekiJoho() {
        return shinseirirekiJoho;
    }

    public RString getMaeGoKubun() {
        return maeGoKubun;
    }

    public DataGridColumnCheckBox getTsuikaKubun() {
        return tsuikaKubun;
    }

    public void setShusei(ButtonDialog shusei) {
        this.setOriginalData("shusei", shusei);
        this.shusei = shusei;
    }

    public void setSakujo(ButtonDialog sakujo) {
        this.setOriginalData("sakujo", sakujo);
        this.sakujo = sakujo;
    }

    public void setKaihuku(Button kaihuku) {
        this.setOriginalData("kaihuku", kaihuku);
        this.kaihuku = kaihuku;
    }

    public void setKubun(RString kubun) {
        this.setOriginalData("kubun", kubun);
        this.kubun = kubun;
    }

    public void setNinteiNaiyo(RString ninteiNaiyo) {
        this.setOriginalData("ninteiNaiyo", ninteiNaiyo);
        this.ninteiNaiyo = ninteiNaiyo;
    }

    public void setDataKubun(RString dataKubun) {
        this.setOriginalData("dataKubun", dataKubun);
        this.dataKubun = dataKubun;
    }

    public void setNiteiDay(TextBoxDate niteiDay) {
        this.setOriginalData("niteiDay", niteiDay);
        this.niteiDay = niteiDay;
    }

    public void setYokaigodo(RString yokaigodo) {
        this.setOriginalData("yokaigodo", yokaigodo);
        this.yokaigodo = yokaigodo;
    }

    public void setYukoKaishi(TextBoxDate yukoKaishi) {
        this.setOriginalData("yukoKaishi", yukoKaishi);
        this.yukoKaishi = yukoKaishi;
    }

    public void setYukoShuryo(TextBoxDate yukoShuryo) {
        this.setOriginalData("yukoShuryo", yukoShuryo);
        this.yukoShuryo = yukoShuryo;
    }

    public void setKyusochi(Boolean kyusochi) {
        this.setOriginalData("kyusochi", kyusochi);
        this.kyusochi = kyusochi;
    }

    public void setShinsakaiIken(RString shinsakaiIken) {
        this.setOriginalData("shinsakaiIken", shinsakaiIken);
        this.shinsakaiIken = shinsakaiIken;
    }

    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    public void setDeserializedBusiness(RString deserializedBusiness) {
        this.setOriginalData("deserializedBusiness", deserializedBusiness);
        this.deserializedBusiness = deserializedBusiness;
    }

    public void setDataPass(RString dataPass) {
        this.setOriginalData("dataPass", dataPass);
        this.dataPass = dataPass;
    }

    public void setRirekiNo(RString rirekiNo) {
        this.setOriginalData("rirekiNo", rirekiNo);
        this.rirekiNo = rirekiNo;
    }

    public void setShinseirirekiJoho(RString shinseirirekiJoho) {
        this.setOriginalData("shinseirirekiJoho", shinseirirekiJoho);
        this.shinseirirekiJoho = shinseirirekiJoho;
    }

    public void setMaeGoKubun(RString maeGoKubun) {
        this.setOriginalData("maeGoKubun", maeGoKubun);
        this.maeGoKubun = maeGoKubun;
    }

    public void setTsuikaKubun(DataGridColumnCheckBox tsuikaKubun) {
        this.setOriginalData("tsuikaKubun", tsuikaKubun);
        this.tsuikaKubun = tsuikaKubun;
    }

    // </editor-fold>
}
