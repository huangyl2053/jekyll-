package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Jun 21 15:39:13 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;


/**
 * dgIdoTaishoshaIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgIdoTaishoshaIchiran_Row extends DataRow {

    private RString txtGaitoRenban;
    private RString txtHihoNo;
    private RString txtShikibetsuCode;
    private RString txtTsuchishoNo;
    private RString txtShimei;
    private RString txtIdoYMD;
    private RString txtIdoZiyu;
    private DropDownList ddlNextSagyo;

    public dgIdoTaishoshaIchiran_Row() {
        super();
        this.txtGaitoRenban = RString.EMPTY;
        this.txtHihoNo = RString.EMPTY;
        this.txtShikibetsuCode = RString.EMPTY;
        this.txtTsuchishoNo = RString.EMPTY;
        this.txtShimei = RString.EMPTY;
        this.txtIdoYMD = RString.EMPTY;
        this.txtIdoZiyu = RString.EMPTY;
        this.ddlNextSagyo = new DropDownList();
    }

    public dgIdoTaishoshaIchiran_Row(RString txtGaitoRenban, RString txtHihoNo, RString txtShikibetsuCode, RString txtTsuchishoNo, RString txtShimei, RString txtIdoYMD, RString txtIdoZiyu, DropDownList ddlNextSagyo) {
        super();
        this.setOriginalData("txtGaitoRenban", txtGaitoRenban);
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.setOriginalData("txtTsuchishoNo", txtTsuchishoNo);
        this.setOriginalData("txtShimei", txtShimei);
        this.setOriginalData("txtIdoYMD", txtIdoYMD);
        this.setOriginalData("txtIdoZiyu", txtIdoZiyu);
        this.setOriginalData("ddlNextSagyo", ddlNextSagyo);
        this.txtGaitoRenban = txtGaitoRenban;
        this.txtHihoNo = txtHihoNo;
        this.txtShikibetsuCode = txtShikibetsuCode;
        this.txtTsuchishoNo = txtTsuchishoNo;
        this.txtShimei = txtShimei;
        this.txtIdoYMD = txtIdoYMD;
        this.txtIdoZiyu = txtIdoZiyu;
        this.ddlNextSagyo = ddlNextSagyo;
    }

//    public dgIdoTaishoshaIchiran_Row(DataGridSetting gridSetting) {
//        super();
//        this.txtGaitoRenban = RString.EMPTY;
//        this.txtHihoNo = RString.EMPTY;
//        this.txtShikibetsuCode = RString.EMPTY;
//        this.txtTsuchishoNo = RString.EMPTY;
//        this.txtShimei = RString.EMPTY;
//        this.txtIdoYMD = RString.EMPTY;
//        this.txtIdoZiyu = RString.EMPTY;
//        this.ddlNextSagyo = DropDownList.createInstance(gridSetting.getColumn("ddlNextSagyo").getCellDetails());
//        this.setOriginalData("ddlNextSagyo", ddlNextSagyo);
//    }

    public RString getTxtGaitoRenban() {
        return txtGaitoRenban;
    }

    public RString getTxtHihoNo() {
        return txtHihoNo;
    }

    public RString getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    public RString getTxtTsuchishoNo() {
        return txtTsuchishoNo;
    }

    public RString getTxtShimei() {
        return txtShimei;
    }

    public RString getTxtIdoYMD() {
        return txtIdoYMD;
    }

    public RString getTxtIdoZiyu() {
        return txtIdoZiyu;
    }

    public DropDownList getDdlNextSagyo() {
        return ddlNextSagyo;
    }

    public void setTxtGaitoRenban(RString txtGaitoRenban) {
        this.setOriginalData("txtGaitoRenban", txtGaitoRenban);
        this.txtGaitoRenban = txtGaitoRenban;
    }

    public void setTxtHihoNo(RString txtHihoNo) {
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.txtHihoNo = txtHihoNo;
    }

    public void setTxtShikibetsuCode(RString txtShikibetsuCode) {
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    public void setTxtTsuchishoNo(RString txtTsuchishoNo) {
        this.setOriginalData("txtTsuchishoNo", txtTsuchishoNo);
        this.txtTsuchishoNo = txtTsuchishoNo;
    }

    public void setTxtShimei(RString txtShimei) {
        this.setOriginalData("txtShimei", txtShimei);
        this.txtShimei = txtShimei;
    }

    public void setTxtIdoYMD(RString txtIdoYMD) {
        this.setOriginalData("txtIdoYMD", txtIdoYMD);
        this.txtIdoYMD = txtIdoYMD;
    }

    public void setTxtIdoZiyu(RString txtIdoZiyu) {
        this.setOriginalData("txtIdoZiyu", txtIdoZiyu);
        this.txtIdoZiyu = txtIdoZiyu;
    }

    public void setDdlNextSagyo(DropDownList ddlNextSagyo) {
        this.setOriginalData("ddlNextSagyo", ddlNextSagyo);
        this.ddlNextSagyo = ddlNextSagyo;
    }

}