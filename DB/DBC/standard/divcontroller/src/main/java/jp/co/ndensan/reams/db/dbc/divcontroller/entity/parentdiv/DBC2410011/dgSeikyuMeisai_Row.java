package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Oct 31 16:57:54 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridColumnCheckBox;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgSeikyuMeisai_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSeikyuMeisai_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">

    private DataGridColumnCheckBox chkTaishogaiFlag;
    private RString hihokenshaNo;
    private RString hihokenshaShimei;
    private TextBoxDate riyushoSakuseiYMD;
    private RString riyushoSakuseishaMei;
    private TextBoxDate shikyushinseiYMD;
    private TextBoxDate chakkoYMD;

    public dgSeikyuMeisai_Row() {
        super();
        this.chkTaishogaiFlag = new DataGridColumnCheckBox();
        this.hihokenshaNo = RString.EMPTY;
        this.hihokenshaShimei = RString.EMPTY;
        this.riyushoSakuseiYMD = new TextBoxDate();
        this.riyushoSakuseishaMei = RString.EMPTY;
        this.shikyushinseiYMD = new TextBoxDate();
        this.chakkoYMD = new TextBoxDate();
        this.setOriginalData("chkTaishogaiFlag", chkTaishogaiFlag);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("hihokenshaShimei", hihokenshaShimei);
        this.setOriginalData("riyushoSakuseiYMD", riyushoSakuseiYMD);
        this.setOriginalData("riyushoSakuseishaMei", riyushoSakuseishaMei);
        this.setOriginalData("shikyushinseiYMD", shikyushinseiYMD);
        this.setOriginalData("chakkoYMD", chakkoYMD);
    }

    public dgSeikyuMeisai_Row(DataGridColumnCheckBox chkTaishogaiFlag, RString hihokenshaNo, RString hihokenshaShimei, TextBoxDate riyushoSakuseiYMD, RString riyushoSakuseishaMei, TextBoxDate shikyushinseiYMD, TextBoxDate chakkoYMD) {
        super();
        this.setOriginalData("chkTaishogaiFlag", chkTaishogaiFlag);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("hihokenshaShimei", hihokenshaShimei);
        this.setOriginalData("riyushoSakuseiYMD", riyushoSakuseiYMD);
        this.setOriginalData("riyushoSakuseishaMei", riyushoSakuseishaMei);
        this.setOriginalData("shikyushinseiYMD", shikyushinseiYMD);
        this.setOriginalData("chakkoYMD", chakkoYMD);
        this.chkTaishogaiFlag = chkTaishogaiFlag;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaShimei = hihokenshaShimei;
        this.riyushoSakuseiYMD = riyushoSakuseiYMD;
        this.riyushoSakuseishaMei = riyushoSakuseishaMei;
        this.shikyushinseiYMD = shikyushinseiYMD;
        this.chakkoYMD = chakkoYMD;
    }

    public dgSeikyuMeisai_Row(DataGridSetting gridSetting) {
        super();
        this.chkTaishogaiFlag = DataGridColumnCheckBox.createInstance(gridSetting.getColumn("chkTaishogaiFlag").getCellDetails());
        this.hihokenshaNo = RString.EMPTY;
        this.hihokenshaShimei = RString.EMPTY;
        this.riyushoSakuseiYMD = new TextBoxDate();
        this.riyushoSakuseishaMei = RString.EMPTY;
        this.shikyushinseiYMD = new TextBoxDate();
        this.chakkoYMD = new TextBoxDate();
        this.setOriginalData("chkTaishogaiFlag", chkTaishogaiFlag);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("hihokenshaShimei", hihokenshaShimei);
        this.setOriginalData("riyushoSakuseiYMD", riyushoSakuseiYMD);
        this.setOriginalData("riyushoSakuseishaMei", riyushoSakuseishaMei);
        this.setOriginalData("shikyushinseiYMD", shikyushinseiYMD);
        this.setOriginalData("chakkoYMD", chakkoYMD);
    }

    public DataGridColumnCheckBox getChkTaishogaiFlag() {
        return chkTaishogaiFlag;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getHihokenshaShimei() {
        return hihokenshaShimei;
    }

    public TextBoxDate getRiyushoSakuseiYMD() {
        return riyushoSakuseiYMD;
    }

    public RString getRiyushoSakuseishaMei() {
        return riyushoSakuseishaMei;
    }

    public TextBoxDate getShikyushinseiYMD() {
        return shikyushinseiYMD;
    }

    public TextBoxDate getChakkoYMD() {
        return chakkoYMD;
    }

    public void setChkTaishogaiFlag(DataGridColumnCheckBox chkTaishogaiFlag) {
        this.setOriginalData("chkTaishogaiFlag", chkTaishogaiFlag);
        this.chkTaishogaiFlag = chkTaishogaiFlag;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setHihokenshaShimei(RString hihokenshaShimei) {
        this.setOriginalData("hihokenshaShimei", hihokenshaShimei);
        this.hihokenshaShimei = hihokenshaShimei;
    }

    public void setRiyushoSakuseiYMD(TextBoxDate riyushoSakuseiYMD) {
        this.setOriginalData("riyushoSakuseiYMD", riyushoSakuseiYMD);
        this.riyushoSakuseiYMD = riyushoSakuseiYMD;
    }

    public void setRiyushoSakuseishaMei(RString riyushoSakuseishaMei) {
        this.setOriginalData("riyushoSakuseishaMei", riyushoSakuseishaMei);
        this.riyushoSakuseishaMei = riyushoSakuseishaMei;
    }

    public void setShikyushinseiYMD(TextBoxDate shikyushinseiYMD) {
        this.setOriginalData("shikyushinseiYMD", shikyushinseiYMD);
        this.shikyushinseiYMD = shikyushinseiYMD;
    }

    public void setChakkoYMD(TextBoxDate chakkoYMD) {
        this.setOriginalData("chakkoYMD", chakkoYMD);
        this.chakkoYMD = chakkoYMD;
    }

    // </editor-fold>
}
