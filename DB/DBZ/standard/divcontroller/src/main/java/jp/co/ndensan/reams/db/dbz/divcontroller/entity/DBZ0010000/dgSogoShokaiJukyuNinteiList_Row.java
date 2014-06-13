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
 * dgSogoShokaiJukyuNinteiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSogoShokaiJukyuNinteiList_Row extends DataRow {

    private ButtonDialog btnSelect;
    private RString txtShinseiYMD;
    private RString txtShinseiKubun;
    private RString txtShinseiYukoKubun;
    private RString txtNinteiYMD;
    private RString txtJotaiKubun;
    private RString txtYukoKaishiYMD;
    private RString txtYukoShuryoYMD;

    public dgSogoShokaiJukyuNinteiList_Row() {
        super();
        this.btnSelect = new ButtonDialog();
        this.txtShinseiYMD = RString.EMPTY;
        this.txtShinseiKubun = RString.EMPTY;
        this.txtShinseiYukoKubun = RString.EMPTY;
        this.txtNinteiYMD = RString.EMPTY;
        this.txtJotaiKubun = RString.EMPTY;
        this.txtYukoKaishiYMD = RString.EMPTY;
        this.txtYukoShuryoYMD = RString.EMPTY;
    }

    public dgSogoShokaiJukyuNinteiList_Row(ButtonDialog btnSelect, RString txtShinseiYMD, RString txtShinseiKubun, RString txtShinseiYukoKubun, RString txtNinteiYMD, RString txtJotaiKubun, RString txtYukoKaishiYMD, RString txtYukoShuryoYMD) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("txtShinseiYMD", txtShinseiYMD);
        this.setOriginalData("txtShinseiKubun", txtShinseiKubun);
        this.setOriginalData("txtShinseiYukoKubun", txtShinseiYukoKubun);
        this.setOriginalData("txtNinteiYMD", txtNinteiYMD);
        this.setOriginalData("txtJotaiKubun", txtJotaiKubun);
        this.setOriginalData("txtYukoKaishiYMD", txtYukoKaishiYMD);
        this.setOriginalData("txtYukoShuryoYMD", txtYukoShuryoYMD);
        this.btnSelect = btnSelect;
        this.txtShinseiYMD = txtShinseiYMD;
        this.txtShinseiKubun = txtShinseiKubun;
        this.txtShinseiYukoKubun = txtShinseiYukoKubun;
        this.txtNinteiYMD = txtNinteiYMD;
        this.txtJotaiKubun = txtJotaiKubun;
        this.txtYukoKaishiYMD = txtYukoKaishiYMD;
        this.txtYukoShuryoYMD = txtYukoShuryoYMD;
    }

    public ButtonDialog getBtnSelect() {
        return btnSelect;
    }

    public RString getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    public RString getTxtShinseiKubun() {
        return txtShinseiKubun;
    }

    public RString getTxtShinseiYukoKubun() {
        return txtShinseiYukoKubun;
    }

    public RString getTxtNinteiYMD() {
        return txtNinteiYMD;
    }

    public RString getTxtJotaiKubun() {
        return txtJotaiKubun;
    }

    public RString getTxtYukoKaishiYMD() {
        return txtYukoKaishiYMD;
    }

    public RString getTxtYukoShuryoYMD() {
        return txtYukoShuryoYMD;
    }

    public void setBtnSelect(ButtonDialog btnSelect) {
        this.setOriginalData("btnSelect", btnSelect);
        this.btnSelect = btnSelect;
    }

    public void setTxtShinseiYMD(RString txtShinseiYMD) {
        this.setOriginalData("txtShinseiYMD", txtShinseiYMD);
        this.txtShinseiYMD = txtShinseiYMD;
    }

    public void setTxtShinseiKubun(RString txtShinseiKubun) {
        this.setOriginalData("txtShinseiKubun", txtShinseiKubun);
        this.txtShinseiKubun = txtShinseiKubun;
    }

    public void setTxtShinseiYukoKubun(RString txtShinseiYukoKubun) {
        this.setOriginalData("txtShinseiYukoKubun", txtShinseiYukoKubun);
        this.txtShinseiYukoKubun = txtShinseiYukoKubun;
    }

    public void setTxtNinteiYMD(RString txtNinteiYMD) {
        this.setOriginalData("txtNinteiYMD", txtNinteiYMD);
        this.txtNinteiYMD = txtNinteiYMD;
    }

    public void setTxtJotaiKubun(RString txtJotaiKubun) {
        this.setOriginalData("txtJotaiKubun", txtJotaiKubun);
        this.txtJotaiKubun = txtJotaiKubun;
    }

    public void setTxtYukoKaishiYMD(RString txtYukoKaishiYMD) {
        this.setOriginalData("txtYukoKaishiYMD", txtYukoKaishiYMD);
        this.txtYukoKaishiYMD = txtYukoKaishiYMD;
    }

    public void setTxtYukoShuryoYMD(RString txtYukoShuryoYMD) {
        this.setOriginalData("txtYukoShuryoYMD", txtYukoShuryoYMD);
        this.txtYukoShuryoYMD = txtYukoShuryoYMD;
    }

}