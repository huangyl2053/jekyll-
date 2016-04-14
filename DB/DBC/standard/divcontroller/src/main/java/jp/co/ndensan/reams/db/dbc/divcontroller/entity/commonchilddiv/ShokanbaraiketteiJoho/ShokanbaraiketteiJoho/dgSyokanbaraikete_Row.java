package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Mar 30 19:09:00 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * dgSyokanbaraikete_Row のクラスファイル
 *
 */
public class dgSyokanbaraikete_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    private RString no;
    private RString jigyoshaNo;
    private RString yoshikiNo;
    private RString shurui;
    private RString serviceShuruiName;
    private RString fukushiYoguName;
    private TextBoxNum taniKingaku;
    private TextBoxNum shiharaiKingaku;
    private TextBoxNum sagakuKingaku;
    private RString tableKubun;
    private RString dekidakaKubun;
    private RString meisaiNo;
    private RString renban;
    private RString updateCount;

    public dgSyokanbaraikete_Row() {
        super();
        this.no = RString.EMPTY;
        this.jigyoshaNo = RString.EMPTY;
        this.yoshikiNo = RString.EMPTY;
        this.shurui = RString.EMPTY;
        this.serviceShuruiName = RString.EMPTY;
        this.fukushiYoguName = RString.EMPTY;
        this.taniKingaku = new TextBoxNum();
        this.shiharaiKingaku = new TextBoxNum();
        this.sagakuKingaku = new TextBoxNum();
        this.tableKubun = RString.EMPTY;
        this.dekidakaKubun = RString.EMPTY;
        this.meisaiNo = RString.EMPTY;
        this.renban = RString.EMPTY;
        this.updateCount = RString.EMPTY;
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
        this.setOriginalData("updateCount", updateCount);
    }

    public dgSyokanbaraikete_Row(RString no, RString jigyoshaNo, RString yoshikiNo, RString shurui, RString serviceShuruiName, RString fukushiYoguName, TextBoxNum taniKingaku, TextBoxNum shiharaiKingaku, TextBoxNum sagakuKingaku, RString tableKubun, RString dekidakaKubun, RString meisaiNo, RString renban, RString updateCount) {
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
        this.setOriginalData("updateCount", updateCount);
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
        this.updateCount = updateCount;
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

    public TextBoxNum getTaniKingaku() {
        return taniKingaku;
    }

    public TextBoxNum getShiharaiKingaku() {
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

    public RString getUpdateCount() {
        return updateCount;
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

    public void setTaniKingaku(TextBoxNum taniKingaku) {
        this.setOriginalData("taniKingaku", taniKingaku);
        this.taniKingaku = taniKingaku;
    }

    public void setShiharaiKingaku(TextBoxNum shiharaiKingaku) {
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

    public void setUpdateCount(RString updateCount) {
        this.setOriginalData("updateCount", updateCount);
        this.updateCount = updateCount;
    }

    // </editor-fold>
}
