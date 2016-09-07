package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jun 24 09:42:46 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * dgHokenryoDankai_Row のクラスファイル
 *
 * @reamsid_L DBB-1770-010 wangkanglei
 */
public class dgHokenryoDankai_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private TextBox txtHokenryoDankaiIndex;
    private DropDownList ddlHokenryoDankai;
    private TextBox txtTokureiHyoji;
    private TextBoxNum txtHokenryoRitsu;
    private TextBoxNum txtKijunShotokuKingaku;

    public dgHokenryoDankai_Row() {
        super();
        this.txtHokenryoDankaiIndex = new TextBox();
        this.ddlHokenryoDankai = new DropDownList();
        this.txtTokureiHyoji = new TextBox();
        this.txtHokenryoRitsu = new TextBoxNum();
        this.txtKijunShotokuKingaku = new TextBoxNum();
        this.setOriginalData("txtHokenryoDankaiIndex", txtHokenryoDankaiIndex);
        this.setOriginalData("ddlHokenryoDankai", ddlHokenryoDankai);
        this.setOriginalData("txtTokureiHyoji", txtTokureiHyoji);
        this.setOriginalData("txtHokenryoRitsu", txtHokenryoRitsu);
        this.setOriginalData("txtKijunShotokuKingaku", txtKijunShotokuKingaku);
    }

    public dgHokenryoDankai_Row(TextBox txtHokenryoDankaiIndex, DropDownList ddlHokenryoDankai, TextBox txtTokureiHyoji, TextBoxNum txtHokenryoRitsu, TextBoxNum txtKijunShotokuKingaku) {
        super();
        this.setOriginalData("txtHokenryoDankaiIndex", txtHokenryoDankaiIndex);
        this.setOriginalData("ddlHokenryoDankai", ddlHokenryoDankai);
        this.setOriginalData("txtTokureiHyoji", txtTokureiHyoji);
        this.setOriginalData("txtHokenryoRitsu", txtHokenryoRitsu);
        this.setOriginalData("txtKijunShotokuKingaku", txtKijunShotokuKingaku);
        this.txtHokenryoDankaiIndex = txtHokenryoDankaiIndex;
        this.ddlHokenryoDankai = ddlHokenryoDankai;
        this.txtTokureiHyoji = txtTokureiHyoji;
        this.txtHokenryoRitsu = txtHokenryoRitsu;
        this.txtKijunShotokuKingaku = txtKijunShotokuKingaku;
    }

    public dgHokenryoDankai_Row(DataGridSetting gridSetting) {
        super();
        this.txtHokenryoDankaiIndex = new TextBox();
        this.ddlHokenryoDankai = DropDownList.createInstance(gridSetting.getColumn("ddlHokenryoDankai").getCellDetails());
        this.txtTokureiHyoji = new TextBox();
        this.txtHokenryoRitsu = new TextBoxNum();
        this.txtKijunShotokuKingaku = new TextBoxNum();
        this.setOriginalData("txtHokenryoDankaiIndex", txtHokenryoDankaiIndex);
        this.setOriginalData("ddlHokenryoDankai", ddlHokenryoDankai);
        this.setOriginalData("txtTokureiHyoji", txtTokureiHyoji);
        this.setOriginalData("txtHokenryoRitsu", txtHokenryoRitsu);
        this.setOriginalData("txtKijunShotokuKingaku", txtKijunShotokuKingaku);
    }

    public TextBox getTxtHokenryoDankaiIndex() {
        return txtHokenryoDankaiIndex;
    }

    public DropDownList getDdlHokenryoDankai() {
        return ddlHokenryoDankai;
    }

    public TextBox getTxtTokureiHyoji() {
        return txtTokureiHyoji;
    }

    public TextBoxNum getTxtHokenryoRitsu() {
        return txtHokenryoRitsu;
    }

    public TextBoxNum getTxtKijunShotokuKingaku() {
        return txtKijunShotokuKingaku;
    }

    public void setTxtHokenryoDankaiIndex(TextBox txtHokenryoDankaiIndex) {
        this.setOriginalData("txtHokenryoDankaiIndex", txtHokenryoDankaiIndex);
        this.txtHokenryoDankaiIndex = txtHokenryoDankaiIndex;
    }

    public void setDdlHokenryoDankai(DropDownList ddlHokenryoDankai) {
        this.setOriginalData("ddlHokenryoDankai", ddlHokenryoDankai);
        this.ddlHokenryoDankai = ddlHokenryoDankai;
    }

    public void setTxtTokureiHyoji(TextBox txtTokureiHyoji) {
        this.setOriginalData("txtTokureiHyoji", txtTokureiHyoji);
        this.txtTokureiHyoji = txtTokureiHyoji;
    }

    public void setTxtHokenryoRitsu(TextBoxNum txtHokenryoRitsu) {
        this.setOriginalData("txtHokenryoRitsu", txtHokenryoRitsu);
        this.txtHokenryoRitsu = txtHokenryoRitsu;
    }

    public void setTxtKijunShotokuKingaku(TextBoxNum txtKijunShotokuKingaku) {
        this.setOriginalData("txtKijunShotokuKingaku", txtKijunShotokuKingaku);
        this.txtKijunShotokuKingaku = txtKijunShotokuKingaku;
    }

    // </editor-fold>
}
