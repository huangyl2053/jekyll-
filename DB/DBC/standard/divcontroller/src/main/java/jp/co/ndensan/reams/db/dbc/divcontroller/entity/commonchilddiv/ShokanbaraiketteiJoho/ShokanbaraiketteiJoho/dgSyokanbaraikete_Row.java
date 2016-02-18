package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Jan 30 10:36:19 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgSyokanbaraikete_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSyokanbaraikete_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    private RString no;
    private RString jigyoshaNo;
    private RString yoshikiNo;
    private RString shurui;
    private RString serviceShuruiName;
    private RString fukushiYoguName;
    private RString taniKingaku;
    private RString shiharaiKingaku;
    private TextBoxNum sagakuKingaku;
    private RString tableKubun;
    private RString dekidakaKubun;
    private RString meisaiNo;
    private RString renban;

    public dgSyokanbaraikete_Row() {
        super();
        this.no = RString.EMPTY;
        this.jigyoshaNo = RString.EMPTY;
        this.yoshikiNo = RString.EMPTY;
        this.shurui = RString.EMPTY;
        this.serviceShuruiName = RString.EMPTY;
        this.fukushiYoguName = RString.EMPTY;
        this.taniKingaku = RString.EMPTY;
        this.shiharaiKingaku = RString.EMPTY;
        this.sagakuKingaku = new TextBoxNum();
        this.tableKubun = RString.EMPTY;
        this.dekidakaKubun = RString.EMPTY;
        this.meisaiNo = RString.EMPTY;
        this.renban = RString.EMPTY;
        this.setOriginalData("no", no);
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.setOriginalData("yoshikiNo", yoshikiNo);
        this.setOriginalData("shurui", shurui);
        this.setOriginalData("serviceShuruiName", serviceShuruiName);
        this.setOriginalData("fukushiYoguName", fukushiYoguName);
        this.setOriginalData("taniKingaku", taniKingaku);
        this.setOriginalData("shiharaiKingaku", shiharaiKingaku);
        this.setOriginalData("sagakuKingaku", sagakuKingaku);
        this.setOriginalData("tableKubun", tableKubun);
        this.setOriginalData("dekidakaKubun", dekidakaKubun);
        this.setOriginalData("meisaiNo", meisaiNo);
        this.setOriginalData("renban", renban);
    }

    public dgSyokanbaraikete_Row(RString no, RString jigyoshaNo, RString yoshikiNo, RString shurui, RString serviceShuruiName, RString fukushiYoguName, RString taniKingaku, RString shiharaiKingaku, TextBoxNum sagakuKingaku, RString tableKubun, RString dekidakaKubun, RString meisaiNo, RString renban) {
        super();
        this.setOriginalData("no", no);
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.setOriginalData("yoshikiNo", yoshikiNo);
        this.setOriginalData("shurui", shurui);
        this.setOriginalData("serviceShuruiName", serviceShuruiName);
        this.setOriginalData("fukushiYoguName", fukushiYoguName);
        this.setOriginalData("taniKingaku", taniKingaku);
        this.setOriginalData("shiharaiKingaku", shiharaiKingaku);
        this.setOriginalData("sagakuKingaku", sagakuKingaku);
        this.setOriginalData("tableKubun", tableKubun);
        this.setOriginalData("dekidakaKubun", dekidakaKubun);
        this.setOriginalData("meisaiNo", meisaiNo);
        this.setOriginalData("renban", renban);
        this.no = no;
        this.jigyoshaNo = jigyoshaNo;
        this.yoshikiNo = yoshikiNo;
        this.shurui = shurui;
        this.serviceShuruiName = serviceShuruiName;
        this.fukushiYoguName = fukushiYoguName;
        this.taniKingaku = taniKingaku;
        this.shiharaiKingaku = shiharaiKingaku;
        this.sagakuKingaku = sagakuKingaku;
        this.tableKubun = tableKubun;
        this.dekidakaKubun = dekidakaKubun;
        this.meisaiNo = meisaiNo;
        this.renban = renban;
    }

    public RString getNo() {
        return no;
    }

    public RString getJigyoshaNo() {
        return jigyoshaNo;
    }

    public RString getYoshikiNo() {
        return yoshikiNo;
    }

    public RString getShurui() {
        return shurui;
    }

    public RString getServiceShuruiName() {
        return serviceShuruiName;
    }

    public RString getFukushiYoguName() {
        return fukushiYoguName;
    }

    public RString getTaniKingaku() {
        return taniKingaku;
    }

    public RString getShiharaiKingaku() {
        return shiharaiKingaku;
    }

    public TextBoxNum getSagakuKingaku() {
        return sagakuKingaku;
    }

    public RString getTableKubun() {
        return tableKubun;
    }

    public RString getDekidakaKubun() {
        return dekidakaKubun;
    }

    public RString getMeisaiNo() {
        return meisaiNo;
    }

    public RString getRenban() {
        return renban;
    }

    public void setNo(RString no) {
        this.setOriginalData("no", no);
        this.no = no;
    }

    public void setJigyoshaNo(RString jigyoshaNo) {
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.jigyoshaNo = jigyoshaNo;
    }

    public void setYoshikiNo(RString yoshikiNo) {
        this.setOriginalData("yoshikiNo", yoshikiNo);
        this.yoshikiNo = yoshikiNo;
    }

    public void setShurui(RString shurui) {
        this.setOriginalData("shurui", shurui);
        this.shurui = shurui;
    }

    public void setServiceShuruiName(RString serviceShuruiName) {
        this.setOriginalData("serviceShuruiName", serviceShuruiName);
        this.serviceShuruiName = serviceShuruiName;
    }

    public void setFukushiYoguName(RString fukushiYoguName) {
        this.setOriginalData("fukushiYoguName", fukushiYoguName);
        this.fukushiYoguName = fukushiYoguName;
    }

    public void setTaniKingaku(RString taniKingaku) {
        this.setOriginalData("taniKingaku", taniKingaku);
        this.taniKingaku = taniKingaku;
    }

    public void setShiharaiKingaku(RString shiharaiKingaku) {
        this.setOriginalData("shiharaiKingaku", shiharaiKingaku);
        this.shiharaiKingaku = shiharaiKingaku;
    }

    public void setSagakuKingaku(TextBoxNum sagakuKingaku) {
        this.setOriginalData("sagakuKingaku", sagakuKingaku);
        this.sagakuKingaku = sagakuKingaku;
    }

    public void setTableKubun(RString tableKubun) {
        this.setOriginalData("tableKubun", tableKubun);
        this.tableKubun = tableKubun;
    }

    public void setDekidakaKubun(RString dekidakaKubun) {
        this.setOriginalData("dekidakaKubun", dekidakaKubun);
        this.dekidakaKubun = dekidakaKubun;
    }

    public void setMeisaiNo(RString meisaiNo) {
        this.setOriginalData("meisaiNo", meisaiNo);
        this.meisaiNo = meisaiNo;
    }

    public void setRenban(RString renban) {
        this.setOriginalData("renban", renban);
        this.renban = renban;
    }

    // </editor-fold>
}
