package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBE5100002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Dec 16 18:23:55 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;


/**
 * dgShinsakaiIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsakaiIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">

    private RString kaisaino;
    private RString shinsakainame;
    private RString gogitainame;
    private RString shurui;
    private RString shinsakaikaijyo;
    private TextBoxDate kaisaibi;
    private TextBoxTime strattime;
    private TextBoxTime endtime;
    private RString waritsukeninzu;
    private RString shinchokuJokyo;
    private Boolean dammyflag;
    private RString shinsakaiJidoWariateTeiin;

    public dgShinsakaiIchiran_Row() {
        super();
        this.kaisaino = RString.EMPTY;
        this.shinsakainame = RString.EMPTY;
        this.gogitainame = RString.EMPTY;
        this.shurui = RString.EMPTY;
        this.shinsakaikaijyo = RString.EMPTY;
        this.kaisaibi = new TextBoxDate();
        this.strattime = new TextBoxTime();
        this.endtime = new TextBoxTime();
        this.waritsukeninzu = RString.EMPTY;
        this.shinchokuJokyo = RString.EMPTY;
        this.dammyflag = false;
        this.shinsakaiJidoWariateTeiin = RString.EMPTY;
        this.setOriginalData("kaisaino", kaisaino);
        this.setOriginalData("shinsakainame", shinsakainame);
        this.setOriginalData("gogitainame", gogitainame);
        this.setOriginalData("shurui", shurui);
        this.setOriginalData("shinsakaikaijyo", shinsakaikaijyo);
        this.setOriginalData("kaisaibi", kaisaibi);
        this.setOriginalData("strattime", strattime);
        this.setOriginalData("endtime", endtime);
        this.setOriginalData("waritsukeninzu", waritsukeninzu);
        this.setOriginalData("shinchokuJokyo", shinchokuJokyo);
        this.setOriginalData("dammyflag", dammyflag);
        this.setOriginalData("shinsakaiJidoWariateTeiin", shinsakaiJidoWariateTeiin);
    }

    public dgShinsakaiIchiran_Row(RString kaisaino, RString shinsakainame, RString gogitainame, RString shurui, RString shinsakaikaijyo, TextBoxDate kaisaibi, TextBoxTime strattime, TextBoxTime endtime, RString waritsukeninzu, RString shinchokuJokyo, Boolean dammyflag, RString shinsakaiJidoWariateTeiin) {
        super();
        this.setOriginalData("kaisaino", kaisaino);
        this.setOriginalData("shinsakainame", shinsakainame);
        this.setOriginalData("gogitainame", gogitainame);
        this.setOriginalData("shurui", shurui);
        this.setOriginalData("shinsakaikaijyo", shinsakaikaijyo);
        this.setOriginalData("kaisaibi", kaisaibi);
        this.setOriginalData("strattime", strattime);
        this.setOriginalData("endtime", endtime);
        this.setOriginalData("waritsukeninzu", waritsukeninzu);
        this.setOriginalData("shinchokuJokyo", shinchokuJokyo);
        this.setOriginalData("dammyflag", dammyflag);
        this.setOriginalData("shinsakaiJidoWariateTeiin", shinsakaiJidoWariateTeiin);
        this.kaisaino = kaisaino;
        this.shinsakainame = shinsakainame;
        this.gogitainame = gogitainame;
        this.shurui = shurui;
        this.shinsakaikaijyo = shinsakaikaijyo;
        this.kaisaibi = kaisaibi;
        this.strattime = strattime;
        this.endtime = endtime;
        this.waritsukeninzu = waritsukeninzu;
        this.shinchokuJokyo = shinchokuJokyo;
        this.dammyflag = dammyflag;
        this.shinsakaiJidoWariateTeiin = shinsakaiJidoWariateTeiin;
    }

    public RString getKaisaino() {
        return kaisaino;
    }

    public RString getShinsakainame() {
        return shinsakainame;
    }

    public RString getGogitainame() {
        return gogitainame;
    }

    public RString getShurui() {
        return shurui;
    }

    public RString getShinsakaikaijyo() {
        return shinsakaikaijyo;
    }

    public TextBoxDate getKaisaibi() {
        return kaisaibi;
    }

    public TextBoxTime getStrattime() {
        return strattime;
    }

    public TextBoxTime getEndtime() {
        return endtime;
    }

    public RString getWaritsukeninzu() {
        return waritsukeninzu;
    }

    public RString getShinchokuJokyo() {
        return shinchokuJokyo;
    }

    public Boolean getDammyflag() {
        return dammyflag;
    }

    public RString getShinsakaiJidoWariateTeiin() {
        return shinsakaiJidoWariateTeiin;
    }

    public void setKaisaino(RString kaisaino) {
        this.setOriginalData("kaisaino", kaisaino);
        this.kaisaino = kaisaino;
    }

    public void setShinsakainame(RString shinsakainame) {
        this.setOriginalData("shinsakainame", shinsakainame);
        this.shinsakainame = shinsakainame;
    }

    public void setGogitainame(RString gogitainame) {
        this.setOriginalData("gogitainame", gogitainame);
        this.gogitainame = gogitainame;
    }

    public void setShurui(RString shurui) {
        this.setOriginalData("shurui", shurui);
        this.shurui = shurui;
    }

    public void setShinsakaikaijyo(RString shinsakaikaijyo) {
        this.setOriginalData("shinsakaikaijyo", shinsakaikaijyo);
        this.shinsakaikaijyo = shinsakaikaijyo;
    }

    public void setKaisaibi(TextBoxDate kaisaibi) {
        this.setOriginalData("kaisaibi", kaisaibi);
        this.kaisaibi = kaisaibi;
    }

    public void setStrattime(TextBoxTime strattime) {
        this.setOriginalData("strattime", strattime);
        this.strattime = strattime;
    }

    public void setEndtime(TextBoxTime endtime) {
        this.setOriginalData("endtime", endtime);
        this.endtime = endtime;
    }

    public void setWaritsukeninzu(RString waritsukeninzu) {
        this.setOriginalData("waritsukeninzu", waritsukeninzu);
        this.waritsukeninzu = waritsukeninzu;
    }

    public void setShinchokuJokyo(RString shinchokuJokyo) {
        this.setOriginalData("shinchokuJokyo", shinchokuJokyo);
        this.shinchokuJokyo = shinchokuJokyo;
    }

    public void setDammyflag(Boolean dammyflag) {
        this.setOriginalData("dammyflag", dammyflag);
        this.dammyflag = dammyflag;
    }

    public void setShinsakaiJidoWariateTeiin(RString shinsakaiJidoWariateTeiin) {
        this.setOriginalData("shinsakaiJidoWariateTeiin", shinsakaiJidoWariateTeiin);
        this.shinsakaiJidoWariateTeiin = shinsakaiJidoWariateTeiin;
    }

    // </editor-fold>
}
