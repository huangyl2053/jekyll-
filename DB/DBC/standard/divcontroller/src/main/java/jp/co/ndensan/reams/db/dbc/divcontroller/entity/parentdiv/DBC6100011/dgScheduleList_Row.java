package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC6100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jul 21 20:50:52 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;

/**
 * dgScheduleList_Row のクラスファイル
 *
 * @reamsid_L DBC-2010-010 wangkanglei
 */
public class dgScheduleList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString shoriNengetsu;
    private RString shinsaNengetsuFrom;
    private RString shinsaNengetsuTo;
    private DropDownList ddlShoriJokyo;
    private RString shoriTimestamp;

    public dgScheduleList_Row() {
        super();
        this.shoriNengetsu = RString.EMPTY;
        this.shinsaNengetsuFrom = RString.EMPTY;
        this.shinsaNengetsuTo = RString.EMPTY;
        this.ddlShoriJokyo = new DropDownList();
        this.shoriTimestamp = RString.EMPTY;
        this.setOriginalData("shoriNengetsu", shoriNengetsu);
        this.setOriginalData("shinsaNengetsuFrom", shinsaNengetsuFrom);
        this.setOriginalData("shinsaNengetsuTo", shinsaNengetsuTo);
        this.setOriginalData("ddlShoriJokyo", ddlShoriJokyo);
        this.setOriginalData("shoriTimestamp", shoriTimestamp);
    }

    public dgScheduleList_Row(RString shoriNengetsu, RString shinsaNengetsuFrom, RString shinsaNengetsuTo, DropDownList ddlShoriJokyo, RString shoriTimestamp) {
        super();
        this.setOriginalData("shoriNengetsu", shoriNengetsu);
        this.setOriginalData("shinsaNengetsuFrom", shinsaNengetsuFrom);
        this.setOriginalData("shinsaNengetsuTo", shinsaNengetsuTo);
        this.setOriginalData("ddlShoriJokyo", ddlShoriJokyo);
        this.setOriginalData("shoriTimestamp", shoriTimestamp);
        this.shoriNengetsu = shoriNengetsu;
        this.shinsaNengetsuFrom = shinsaNengetsuFrom;
        this.shinsaNengetsuTo = shinsaNengetsuTo;
        this.ddlShoriJokyo = ddlShoriJokyo;
        this.shoriTimestamp = shoriTimestamp;
    }

    public dgScheduleList_Row(DataGridSetting gridSetting) {
        super();
        this.shoriNengetsu = RString.EMPTY;
        this.shinsaNengetsuFrom = RString.EMPTY;
        this.shinsaNengetsuTo = RString.EMPTY;
        this.ddlShoriJokyo = DropDownList.createInstance(gridSetting.getColumn("ddlShoriJokyo").getCellDetails());
        this.shoriTimestamp = RString.EMPTY;
        this.setOriginalData("shoriNengetsu", shoriNengetsu);
        this.setOriginalData("shinsaNengetsuFrom", shinsaNengetsuFrom);
        this.setOriginalData("shinsaNengetsuTo", shinsaNengetsuTo);
        this.setOriginalData("ddlShoriJokyo", ddlShoriJokyo);
        this.setOriginalData("shoriTimestamp", shoriTimestamp);
    }

    public RString getShoriNengetsu() {
        return shoriNengetsu;
    }

    public RString getShinsaNengetsuFrom() {
        return shinsaNengetsuFrom;
    }

    public RString getShinsaNengetsuTo() {
        return shinsaNengetsuTo;
    }

    public DropDownList getDdlShoriJokyo() {
        return ddlShoriJokyo;
    }

    public RString getShoriTimestamp() {
        return shoriTimestamp;
    }

    public void setShoriNengetsu(RString shoriNengetsu) {
        this.setOriginalData("shoriNengetsu", shoriNengetsu);
        this.shoriNengetsu = shoriNengetsu;
    }

    public void setShinsaNengetsuFrom(RString shinsaNengetsuFrom) {
        this.setOriginalData("shinsaNengetsuFrom", shinsaNengetsuFrom);
        this.shinsaNengetsuFrom = shinsaNengetsuFrom;
    }

    public void setShinsaNengetsuTo(RString shinsaNengetsuTo) {
        this.setOriginalData("shinsaNengetsuTo", shinsaNengetsuTo);
        this.shinsaNengetsuTo = shinsaNengetsuTo;
    }

    public void setDdlShoriJokyo(DropDownList ddlShoriJokyo) {
        this.setOriginalData("ddlShoriJokyo", ddlShoriJokyo);
        this.ddlShoriJokyo = ddlShoriJokyo;
    }

    public void setShoriTimestamp(RString shoriTimestamp) {
        this.setOriginalData("shoriTimestamp", shoriTimestamp);
        this.shoriTimestamp = shoriTimestamp;
    }

    // </editor-fold>
}
