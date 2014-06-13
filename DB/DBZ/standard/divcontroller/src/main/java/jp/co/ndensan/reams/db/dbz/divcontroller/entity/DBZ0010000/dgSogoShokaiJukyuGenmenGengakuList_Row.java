package jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jun 12 10:13:46 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgSogoShokaiJukyuGenmenGengakuList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSogoShokaiJukyuGenmenGengakuList_Row extends DataRow {

    private ButtonDialog btnSelect;
    private RString txtTekiyoKaishiYMD;
    private RString txtYukoKigen;
    private RString txtKetteiYMD;
    private RString txtKetteiKubun;
    private RString txtShinseiYMD;
    private RString txtGenmenGengakuShurui;

    public dgSogoShokaiJukyuGenmenGengakuList_Row() {
        super();
        this.btnSelect = new ButtonDialog();
        this.txtTekiyoKaishiYMD = RString.EMPTY;
        this.txtYukoKigen = RString.EMPTY;
        this.txtKetteiYMD = RString.EMPTY;
        this.txtKetteiKubun = RString.EMPTY;
        this.txtShinseiYMD = RString.EMPTY;
        this.txtGenmenGengakuShurui = RString.EMPTY;
    }

    public dgSogoShokaiJukyuGenmenGengakuList_Row(ButtonDialog btnSelect, RString txtTekiyoKaishiYMD, RString txtYukoKigen, RString txtKetteiYMD, RString txtKetteiKubun, RString txtShinseiYMD, RString txtGenmenGengakuShurui) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("txtTekiyoKaishiYMD", txtTekiyoKaishiYMD);
        this.setOriginalData("txtYukoKigen", txtYukoKigen);
        this.setOriginalData("txtKetteiYMD", txtKetteiYMD);
        this.setOriginalData("txtKetteiKubun", txtKetteiKubun);
        this.setOriginalData("txtShinseiYMD", txtShinseiYMD);
        this.setOriginalData("txtGenmenGengakuShurui", txtGenmenGengakuShurui);
        this.btnSelect = btnSelect;
        this.txtTekiyoKaishiYMD = txtTekiyoKaishiYMD;
        this.txtYukoKigen = txtYukoKigen;
        this.txtKetteiYMD = txtKetteiYMD;
        this.txtKetteiKubun = txtKetteiKubun;
        this.txtShinseiYMD = txtShinseiYMD;
        this.txtGenmenGengakuShurui = txtGenmenGengakuShurui;
    }

    public ButtonDialog getBtnSelect() {
        return btnSelect;
    }

    public RString getTxtTekiyoKaishiYMD() {
        return txtTekiyoKaishiYMD;
    }

    public RString getTxtYukoKigen() {
        return txtYukoKigen;
    }

    public RString getTxtKetteiYMD() {
        return txtKetteiYMD;
    }

    public RString getTxtKetteiKubun() {
        return txtKetteiKubun;
    }

    public RString getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    public RString getTxtGenmenGengakuShurui() {
        return txtGenmenGengakuShurui;
    }

    public void setBtnSelect(ButtonDialog btnSelect) {
        this.setOriginalData("btnSelect", btnSelect);
        this.btnSelect = btnSelect;
    }

    public void setTxtTekiyoKaishiYMD(RString txtTekiyoKaishiYMD) {
        this.setOriginalData("txtTekiyoKaishiYMD", txtTekiyoKaishiYMD);
        this.txtTekiyoKaishiYMD = txtTekiyoKaishiYMD;
    }

    public void setTxtYukoKigen(RString txtYukoKigen) {
        this.setOriginalData("txtYukoKigen", txtYukoKigen);
        this.txtYukoKigen = txtYukoKigen;
    }

    public void setTxtKetteiYMD(RString txtKetteiYMD) {
        this.setOriginalData("txtKetteiYMD", txtKetteiYMD);
        this.txtKetteiYMD = txtKetteiYMD;
    }

    public void setTxtKetteiKubun(RString txtKetteiKubun) {
        this.setOriginalData("txtKetteiKubun", txtKetteiKubun);
        this.txtKetteiKubun = txtKetteiKubun;
    }

    public void setTxtShinseiYMD(RString txtShinseiYMD) {
        this.setOriginalData("txtShinseiYMD", txtShinseiYMD);
        this.txtShinseiYMD = txtShinseiYMD;
    }

    public void setTxtGenmenGengakuShurui(RString txtGenmenGengakuShurui) {
        this.setOriginalData("txtGenmenGengakuShurui", txtGenmenGengakuShurui);
        this.txtGenmenGengakuShurui = txtGenmenGengakuShurui;
    }

}