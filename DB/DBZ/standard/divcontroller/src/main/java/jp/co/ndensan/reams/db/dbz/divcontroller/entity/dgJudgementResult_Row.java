package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jul 08 15:14:22 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgJudgementResult_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgJudgementResult_Row extends DataRow {

    private RString txtJigyosha;
    private RString txtServiceShurui;
    private TextBoxNum txtServiceHiyoTotal;
    private TextBoxNum txtRiyoshaFutanTotalAmount;
    private TextBoxNum txtSanteiKijunAmount;
    private TextBoxNum txtShiharaizumiAmount;
    private TextBoxNum txtKogakuShikyuAmount;

    public dgJudgementResult_Row() {
        super();
        this.txtJigyosha = RString.EMPTY;
        this.txtServiceShurui = RString.EMPTY;
        this.txtServiceHiyoTotal = new TextBoxNum();
        this.txtRiyoshaFutanTotalAmount = new TextBoxNum();
        this.txtSanteiKijunAmount = new TextBoxNum();
        this.txtShiharaizumiAmount = new TextBoxNum();
        this.txtKogakuShikyuAmount = new TextBoxNum();
    }

    public dgJudgementResult_Row(RString txtJigyosha, RString txtServiceShurui, TextBoxNum txtServiceHiyoTotal, TextBoxNum txtRiyoshaFutanTotalAmount, TextBoxNum txtSanteiKijunAmount, TextBoxNum txtShiharaizumiAmount, TextBoxNum txtKogakuShikyuAmount) {
        super();
        this.setOriginalData("txtJigyosha", txtJigyosha);
        this.setOriginalData("txtServiceShurui", txtServiceShurui);
        this.setOriginalData("txtServiceHiyoTotal", txtServiceHiyoTotal);
        this.setOriginalData("txtRiyoshaFutanTotalAmount", txtRiyoshaFutanTotalAmount);
        this.setOriginalData("txtSanteiKijunAmount", txtSanteiKijunAmount);
        this.setOriginalData("txtShiharaizumiAmount", txtShiharaizumiAmount);
        this.setOriginalData("txtKogakuShikyuAmount", txtKogakuShikyuAmount);
        this.txtJigyosha = txtJigyosha;
        this.txtServiceShurui = txtServiceShurui;
        this.txtServiceHiyoTotal = txtServiceHiyoTotal;
        this.txtRiyoshaFutanTotalAmount = txtRiyoshaFutanTotalAmount;
        this.txtSanteiKijunAmount = txtSanteiKijunAmount;
        this.txtShiharaizumiAmount = txtShiharaizumiAmount;
        this.txtKogakuShikyuAmount = txtKogakuShikyuAmount;
    }

    public RString getTxtJigyosha() {
        return txtJigyosha;
    }

    public RString getTxtServiceShurui() {
        return txtServiceShurui;
    }

    public TextBoxNum getTxtServiceHiyoTotal() {
        return txtServiceHiyoTotal;
    }

    public TextBoxNum getTxtRiyoshaFutanTotalAmount() {
        return txtRiyoshaFutanTotalAmount;
    }

    public TextBoxNum getTxtSanteiKijunAmount() {
        return txtSanteiKijunAmount;
    }

    public TextBoxNum getTxtShiharaizumiAmount() {
        return txtShiharaizumiAmount;
    }

    public TextBoxNum getTxtKogakuShikyuAmount() {
        return txtKogakuShikyuAmount;
    }

    public void setTxtJigyosha(RString txtJigyosha) {
        this.setOriginalData("txtJigyosha", txtJigyosha);
        this.txtJigyosha = txtJigyosha;
    }

    public void setTxtServiceShurui(RString txtServiceShurui) {
        this.setOriginalData("txtServiceShurui", txtServiceShurui);
        this.txtServiceShurui = txtServiceShurui;
    }

    public void setTxtServiceHiyoTotal(TextBoxNum txtServiceHiyoTotal) {
        this.setOriginalData("txtServiceHiyoTotal", txtServiceHiyoTotal);
        this.txtServiceHiyoTotal = txtServiceHiyoTotal;
    }

    public void setTxtRiyoshaFutanTotalAmount(TextBoxNum txtRiyoshaFutanTotalAmount) {
        this.setOriginalData("txtRiyoshaFutanTotalAmount", txtRiyoshaFutanTotalAmount);
        this.txtRiyoshaFutanTotalAmount = txtRiyoshaFutanTotalAmount;
    }

    public void setTxtSanteiKijunAmount(TextBoxNum txtSanteiKijunAmount) {
        this.setOriginalData("txtSanteiKijunAmount", txtSanteiKijunAmount);
        this.txtSanteiKijunAmount = txtSanteiKijunAmount;
    }

    public void setTxtShiharaizumiAmount(TextBoxNum txtShiharaizumiAmount) {
        this.setOriginalData("txtShiharaizumiAmount", txtShiharaizumiAmount);
        this.txtShiharaizumiAmount = txtShiharaizumiAmount;
    }

    public void setTxtKogakuShikyuAmount(TextBoxNum txtKogakuShikyuAmount) {
        this.setOriginalData("txtKogakuShikyuAmount", txtKogakuShikyuAmount);
        this.txtKogakuShikyuAmount = txtKogakuShikyuAmount;
    }

}