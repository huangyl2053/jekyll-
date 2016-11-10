package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 10 10:47:14 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgTokubetsuKyufuJigyoshaDetailServiceList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTokubetsuKyufuJigyoshaDetailServiceList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">

    private RString hdnServiceCode;
    private RString txtService;
    private RString txtKanrisha;
    private TextBoxDate txtJigyoKaishiYMD;
    private TextBoxDate txtJigyoKyushiYMD;
    private TextBoxDate txtJigyoHaishiYMD;
    private TextBoxDate txtJigyoSaikaiYMD;
    private TextBoxDate txtTorokuKaishiYMD;
    private TextBoxDate txtTorokuShuryoYMD;
    private RString txtJuryoInin;
    private RString txtSeikatsuHogo;
    private RString txtServiceId;

    public dgTokubetsuKyufuJigyoshaDetailServiceList_Row() {
        super();
        this.hdnServiceCode = RString.EMPTY;
        this.txtService = RString.EMPTY;
        this.txtKanrisha = RString.EMPTY;
        this.txtJigyoKaishiYMD = new TextBoxDate();
        this.txtJigyoKyushiYMD = new TextBoxDate();
        this.txtJigyoHaishiYMD = new TextBoxDate();
        this.txtJigyoSaikaiYMD = new TextBoxDate();
        this.txtTorokuKaishiYMD = new TextBoxDate();
        this.txtTorokuShuryoYMD = new TextBoxDate();
        this.txtJuryoInin = RString.EMPTY;
        this.txtSeikatsuHogo = RString.EMPTY;
        this.txtServiceId = RString.EMPTY;
        this.setOriginalData("hdnServiceCode", hdnServiceCode);
        this.setOriginalData("txtService", txtService);
        this.setOriginalData("txtKanrisha", txtKanrisha);
        this.setOriginalData("txtJigyoKaishiYMD", txtJigyoKaishiYMD);
        this.setOriginalData("txtJigyoKyushiYMD", txtJigyoKyushiYMD);
        this.setOriginalData("txtJigyoHaishiYMD", txtJigyoHaishiYMD);
        this.setOriginalData("txtJigyoSaikaiYMD", txtJigyoSaikaiYMD);
        this.setOriginalData("txtTorokuKaishiYMD", txtTorokuKaishiYMD);
        this.setOriginalData("txtTorokuShuryoYMD", txtTorokuShuryoYMD);
        this.setOriginalData("txtJuryoInin", txtJuryoInin);
        this.setOriginalData("txtSeikatsuHogo", txtSeikatsuHogo);
        this.setOriginalData("txtServiceId", txtServiceId);
    }

    public dgTokubetsuKyufuJigyoshaDetailServiceList_Row(RString hdnServiceCode, RString txtService, RString txtKanrisha, TextBoxDate txtJigyoKaishiYMD, TextBoxDate txtJigyoKyushiYMD, TextBoxDate txtJigyoHaishiYMD, TextBoxDate txtJigyoSaikaiYMD, TextBoxDate txtTorokuKaishiYMD, TextBoxDate txtTorokuShuryoYMD, RString txtJuryoInin, RString txtSeikatsuHogo, RString txtServiceId) {
        super();
        this.setOriginalData("hdnServiceCode", hdnServiceCode);
        this.setOriginalData("txtService", txtService);
        this.setOriginalData("txtKanrisha", txtKanrisha);
        this.setOriginalData("txtJigyoKaishiYMD", txtJigyoKaishiYMD);
        this.setOriginalData("txtJigyoKyushiYMD", txtJigyoKyushiYMD);
        this.setOriginalData("txtJigyoHaishiYMD", txtJigyoHaishiYMD);
        this.setOriginalData("txtJigyoSaikaiYMD", txtJigyoSaikaiYMD);
        this.setOriginalData("txtTorokuKaishiYMD", txtTorokuKaishiYMD);
        this.setOriginalData("txtTorokuShuryoYMD", txtTorokuShuryoYMD);
        this.setOriginalData("txtJuryoInin", txtJuryoInin);
        this.setOriginalData("txtSeikatsuHogo", txtSeikatsuHogo);
        this.setOriginalData("txtServiceId", txtServiceId);
        this.hdnServiceCode = hdnServiceCode;
        this.txtService = txtService;
        this.txtKanrisha = txtKanrisha;
        this.txtJigyoKaishiYMD = txtJigyoKaishiYMD;
        this.txtJigyoKyushiYMD = txtJigyoKyushiYMD;
        this.txtJigyoHaishiYMD = txtJigyoHaishiYMD;
        this.txtJigyoSaikaiYMD = txtJigyoSaikaiYMD;
        this.txtTorokuKaishiYMD = txtTorokuKaishiYMD;
        this.txtTorokuShuryoYMD = txtTorokuShuryoYMD;
        this.txtJuryoInin = txtJuryoInin;
        this.txtSeikatsuHogo = txtSeikatsuHogo;
        this.txtServiceId = txtServiceId;
    }

    public RString getHdnServiceCode() {
        return hdnServiceCode;
    }

    public RString getTxtService() {
        return txtService;
    }

    public RString getTxtKanrisha() {
        return txtKanrisha;
    }

    public TextBoxDate getTxtJigyoKaishiYMD() {
        return txtJigyoKaishiYMD;
    }

    public TextBoxDate getTxtJigyoKyushiYMD() {
        return txtJigyoKyushiYMD;
    }

    public TextBoxDate getTxtJigyoHaishiYMD() {
        return txtJigyoHaishiYMD;
    }

    public TextBoxDate getTxtJigyoSaikaiYMD() {
        return txtJigyoSaikaiYMD;
    }

    public TextBoxDate getTxtTorokuKaishiYMD() {
        return txtTorokuKaishiYMD;
    }

    public TextBoxDate getTxtTorokuShuryoYMD() {
        return txtTorokuShuryoYMD;
    }

    public RString getTxtJuryoInin() {
        return txtJuryoInin;
    }

    public RString getTxtSeikatsuHogo() {
        return txtSeikatsuHogo;
    }

    public RString getTxtServiceId() {
        return txtServiceId;
    }

    public void setHdnServiceCode(RString hdnServiceCode) {
        this.setOriginalData("hdnServiceCode", hdnServiceCode);
        this.hdnServiceCode = hdnServiceCode;
    }

    public void setTxtService(RString txtService) {
        this.setOriginalData("txtService", txtService);
        this.txtService = txtService;
    }

    public void setTxtKanrisha(RString txtKanrisha) {
        this.setOriginalData("txtKanrisha", txtKanrisha);
        this.txtKanrisha = txtKanrisha;
    }

    public void setTxtJigyoKaishiYMD(TextBoxDate txtJigyoKaishiYMD) {
        this.setOriginalData("txtJigyoKaishiYMD", txtJigyoKaishiYMD);
        this.txtJigyoKaishiYMD = txtJigyoKaishiYMD;
    }

    public void setTxtJigyoKyushiYMD(TextBoxDate txtJigyoKyushiYMD) {
        this.setOriginalData("txtJigyoKyushiYMD", txtJigyoKyushiYMD);
        this.txtJigyoKyushiYMD = txtJigyoKyushiYMD;
    }

    public void setTxtJigyoHaishiYMD(TextBoxDate txtJigyoHaishiYMD) {
        this.setOriginalData("txtJigyoHaishiYMD", txtJigyoHaishiYMD);
        this.txtJigyoHaishiYMD = txtJigyoHaishiYMD;
    }

    public void setTxtJigyoSaikaiYMD(TextBoxDate txtJigyoSaikaiYMD) {
        this.setOriginalData("txtJigyoSaikaiYMD", txtJigyoSaikaiYMD);
        this.txtJigyoSaikaiYMD = txtJigyoSaikaiYMD;
    }

    public void setTxtTorokuKaishiYMD(TextBoxDate txtTorokuKaishiYMD) {
        this.setOriginalData("txtTorokuKaishiYMD", txtTorokuKaishiYMD);
        this.txtTorokuKaishiYMD = txtTorokuKaishiYMD;
    }

    public void setTxtTorokuShuryoYMD(TextBoxDate txtTorokuShuryoYMD) {
        this.setOriginalData("txtTorokuShuryoYMD", txtTorokuShuryoYMD);
        this.txtTorokuShuryoYMD = txtTorokuShuryoYMD;
    }

    public void setTxtJuryoInin(RString txtJuryoInin) {
        this.setOriginalData("txtJuryoInin", txtJuryoInin);
        this.txtJuryoInin = txtJuryoInin;
    }

    public void setTxtSeikatsuHogo(RString txtSeikatsuHogo) {
        this.setOriginalData("txtSeikatsuHogo", txtSeikatsuHogo);
        this.txtSeikatsuHogo = txtSeikatsuHogo;
    }

    public void setTxtServiceId(RString txtServiceId) {
        this.setOriginalData("txtServiceId", txtServiceId);
        this.txtServiceId = txtServiceId;
    }

    // </editor-fold>
}
