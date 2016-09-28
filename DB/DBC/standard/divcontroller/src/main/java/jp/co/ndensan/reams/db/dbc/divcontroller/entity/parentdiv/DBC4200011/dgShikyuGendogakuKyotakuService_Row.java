package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4200011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。 Tue Jun 10 11:12:23 JST 2014
 */
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * dgShikyuGendogakuKyotakuService_Row のクラスファイル
 *
 * @reamsid_L DBC-3410-010 jianglaisheng
 */
public class dgShikyuGendogakuKyotakuService_Row extends DataRow {

    private Button btnModifyRow;
    private Button btnDeleteRow;
    private RString txtKubunOrShurui;
    private TextBoxDate txtYukoKaishiDate;
    private TextBoxDate txtYukoShuryoDate;
    private RString txtIdoKubun;

    public dgShikyuGendogakuKyotakuService_Row() {
        super();
    }

    public dgShikyuGendogakuKyotakuService_Row(Button btnModifyRow, Button btnDeleteRow, RString txtKubunOrShurui, TextBoxDate txtYukoKaishiDate, TextBoxDate txtYukoShuryoDate, RString txtIdoKubun) {
        super();
        this.setOriginalData("btnModifyRow", btnModifyRow);
        this.setOriginalData("btnDeleteRow", btnDeleteRow);
        this.setOriginalData("txtKubunOrShurui", txtKubunOrShurui);
        this.setOriginalData("txtYukoKaishiDate", txtYukoKaishiDate);
        this.setOriginalData("txtYukoShuryoDate", txtYukoShuryoDate);
        this.setOriginalData("txtIdoKubun", txtIdoKubun);
        this.btnModifyRow = btnModifyRow;
        this.btnDeleteRow = btnDeleteRow;
        this.txtKubunOrShurui = txtKubunOrShurui;
        this.txtYukoKaishiDate = txtYukoKaishiDate;
        this.txtYukoShuryoDate = txtYukoShuryoDate;
        this.txtIdoKubun = txtIdoKubun;
    }

    public Button getBtnModifyRow() {
        return btnModifyRow;
    }

    public Button getBtnDeleteRow() {
        return btnDeleteRow;
    }

    public RString getTxtKubunOrShurui() {
        return txtKubunOrShurui;
    }

    public TextBoxDate getTxtYukoKaishiDate() {
        return txtYukoKaishiDate;
    }

    public TextBoxDate getTxtYukoShuryoDate() {
        return txtYukoShuryoDate;
    }

    public RString getTxtIdoKubun() {
        return txtIdoKubun;
    }

    public void setBtnModifyRow(Button btnModifyRow) {
        this.setOriginalData("btnModifyRow", btnModifyRow);
        this.btnModifyRow = btnModifyRow;
    }

    public void setBtnDeleteRow(Button btnDeleteRow) {
        this.setOriginalData("btnDeleteRow", btnDeleteRow);
        this.btnDeleteRow = btnDeleteRow;
    }

    public void setTxtKubunOrShurui(RString txtKubunOrShurui) {
        this.setOriginalData("txtKubunOrShurui", txtKubunOrShurui);
        this.txtKubunOrShurui = txtKubunOrShurui;
    }

    public void setTxtYukoKaishiDate(TextBoxDate txtYukoKaishiDate) {
        this.setOriginalData("txtYukoKaishiDate", txtYukoKaishiDate);
        this.txtYukoKaishiDate = txtYukoKaishiDate;
    }

    public void setTxtYukoShuryoDate(TextBoxDate txtYukoShuryoDate) {
        this.setOriginalData("txtYukoShuryoDate", txtYukoShuryoDate);
        this.txtYukoShuryoDate = txtYukoShuryoDate;
    }

    public void setTxtIdoKubun(RString txtIdoKubun) {
        this.setOriginalData("txtIdoKubun", txtIdoKubun);
        this.txtIdoKubun = txtIdoKubun;
    }

}
