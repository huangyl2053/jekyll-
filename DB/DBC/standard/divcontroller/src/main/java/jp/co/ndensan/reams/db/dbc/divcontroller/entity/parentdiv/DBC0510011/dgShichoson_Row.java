package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sun Oct 09 10:56:16 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;

/**
 * dgShichoson_Row のクラスファイル
 *
 * @reamsid_L DBC-3020-010 chenyadong
 */
public class dgShichoson_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString bango;
    private RString shichosonMei;
    private ButtonDialog baitai;
    private RString fileNitiji;
    private RString fileKakunoShoriNitiji;
    private RString koikiTorikomiNitiji;
    private RString shichosonShikibetuID;

    public dgShichoson_Row() {
        super();
        this.bango = RString.EMPTY;
        this.shichosonMei = RString.EMPTY;
        this.baitai = new ButtonDialog();
        this.fileNitiji = RString.EMPTY;
        this.fileKakunoShoriNitiji = RString.EMPTY;
        this.koikiTorikomiNitiji = RString.EMPTY;
        this.shichosonShikibetuID = RString.EMPTY;
        this.setOriginalData("bango", bango);
        this.setOriginalData("shichosonMei", shichosonMei);
        this.setOriginalData("baitai", baitai);
        this.setOriginalData("fileNitiji", fileNitiji);
        this.setOriginalData("fileKakunoShoriNitiji", fileKakunoShoriNitiji);
        this.setOriginalData("koikiTorikomiNitiji", koikiTorikomiNitiji);
        this.setOriginalData("shichosonShikibetuID", shichosonShikibetuID);
    }

    public dgShichoson_Row(RString bango, RString shichosonMei, ButtonDialog baitai, RString fileNitiji, RString fileKakunoShoriNitiji, RString koikiTorikomiNitiji, RString shichosonShikibetuID) {
        super();
        this.setOriginalData("bango", bango);
        this.setOriginalData("shichosonMei", shichosonMei);
        this.setOriginalData("baitai", baitai);
        this.setOriginalData("fileNitiji", fileNitiji);
        this.setOriginalData("fileKakunoShoriNitiji", fileKakunoShoriNitiji);
        this.setOriginalData("koikiTorikomiNitiji", koikiTorikomiNitiji);
        this.setOriginalData("shichosonShikibetuID", shichosonShikibetuID);
        this.bango = bango;
        this.shichosonMei = shichosonMei;
        this.baitai = baitai;
        this.fileNitiji = fileNitiji;
        this.fileKakunoShoriNitiji = fileKakunoShoriNitiji;
        this.koikiTorikomiNitiji = koikiTorikomiNitiji;
        this.shichosonShikibetuID = shichosonShikibetuID;
    }

    public RString getBango() {
        return bango;
    }

    public RString getShichosonMei() {
        return shichosonMei;
    }

    public ButtonDialog getBaitai() {
        return baitai;
    }

    public RString getFileNitiji() {
        return fileNitiji;
    }

    public RString getFileKakunoShoriNitiji() {
        return fileKakunoShoriNitiji;
    }

    public RString getKoikiTorikomiNitiji() {
        return koikiTorikomiNitiji;
    }

    public RString getShichosonShikibetuID() {
        return shichosonShikibetuID;
    }

    public void setBango(RString bango) {
        this.setOriginalData("bango", bango);
        this.bango = bango;
    }

    public void setShichosonMei(RString shichosonMei) {
        this.setOriginalData("shichosonMei", shichosonMei);
        this.shichosonMei = shichosonMei;
    }

    public void setBaitai(ButtonDialog baitai) {
        this.setOriginalData("baitai", baitai);
        this.baitai = baitai;
    }

    public void setFileNitiji(RString fileNitiji) {
        this.setOriginalData("fileNitiji", fileNitiji);
        this.fileNitiji = fileNitiji;
    }

    public void setFileKakunoShoriNitiji(RString fileKakunoShoriNitiji) {
        this.setOriginalData("fileKakunoShoriNitiji", fileKakunoShoriNitiji);
        this.fileKakunoShoriNitiji = fileKakunoShoriNitiji;
    }

    public void setKoikiTorikomiNitiji(RString koikiTorikomiNitiji) {
        this.setOriginalData("koikiTorikomiNitiji", koikiTorikomiNitiji);
        this.koikiTorikomiNitiji = koikiTorikomiNitiji;
    }

    public void setShichosonShikibetuID(RString shichosonShikibetuID) {
        this.setOriginalData("shichosonShikibetuID", shichosonShikibetuID);
        this.shichosonShikibetuID = shichosonShikibetuID;
    }

    // </editor-fold>
}
