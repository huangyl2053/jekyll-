package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0100000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Jun 25 09:49:38 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKyotakuKeikakuTodokedeRirekiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKyotakuKeikakuTodokedeRirekiList_Row extends DataRow {

    private Button btnSelect;
    private RString txtKeikakuTekiyoKaishiYMD;
    private RString txtKeikakuTekiyoShuryoYMD;
    private RString txtTodokedeYMD;
    private RString txtTodokedeKubun;
    private RString txtKeikakuIraiJigyosha;

    public dgKyotakuKeikakuTodokedeRirekiList_Row() {
        super();
        this.btnSelect = new Button();
        this.txtKeikakuTekiyoKaishiYMD = RString.EMPTY;
        this.txtKeikakuTekiyoShuryoYMD = RString.EMPTY;
        this.txtTodokedeYMD = RString.EMPTY;
        this.txtTodokedeKubun = RString.EMPTY;
        this.txtKeikakuIraiJigyosha = RString.EMPTY;
    }

    public dgKyotakuKeikakuTodokedeRirekiList_Row(Button btnSelect, RString txtKeikakuTekiyoKaishiYMD, RString txtKeikakuTekiyoShuryoYMD, RString txtTodokedeYMD, RString txtTodokedeKubun, RString txtKeikakuIraiJigyosha) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("txtKeikakuTekiyoKaishiYMD", txtKeikakuTekiyoKaishiYMD);
        this.setOriginalData("txtKeikakuTekiyoShuryoYMD", txtKeikakuTekiyoShuryoYMD);
        this.setOriginalData("txtTodokedeYMD", txtTodokedeYMD);
        this.setOriginalData("txtTodokedeKubun", txtTodokedeKubun);
        this.setOriginalData("txtKeikakuIraiJigyosha", txtKeikakuIraiJigyosha);
        this.btnSelect = btnSelect;
        this.txtKeikakuTekiyoKaishiYMD = txtKeikakuTekiyoKaishiYMD;
        this.txtKeikakuTekiyoShuryoYMD = txtKeikakuTekiyoShuryoYMD;
        this.txtTodokedeYMD = txtTodokedeYMD;
        this.txtTodokedeKubun = txtTodokedeKubun;
        this.txtKeikakuIraiJigyosha = txtKeikakuIraiJigyosha;
    }

    public Button getBtnSelect() {
        return btnSelect;
    }

    public RString getTxtKeikakuTekiyoKaishiYMD() {
        return txtKeikakuTekiyoKaishiYMD;
    }

    public RString getTxtKeikakuTekiyoShuryoYMD() {
        return txtKeikakuTekiyoShuryoYMD;
    }

    public RString getTxtTodokedeYMD() {
        return txtTodokedeYMD;
    }

    public RString getTxtTodokedeKubun() {
        return txtTodokedeKubun;
    }

    public RString getTxtKeikakuIraiJigyosha() {
        return txtKeikakuIraiJigyosha;
    }

    public void setBtnSelect(Button btnSelect) {
        this.setOriginalData("btnSelect", btnSelect);
        this.btnSelect = btnSelect;
    }

    public void setTxtKeikakuTekiyoKaishiYMD(RString txtKeikakuTekiyoKaishiYMD) {
        this.setOriginalData("txtKeikakuTekiyoKaishiYMD", txtKeikakuTekiyoKaishiYMD);
        this.txtKeikakuTekiyoKaishiYMD = txtKeikakuTekiyoKaishiYMD;
    }

    public void setTxtKeikakuTekiyoShuryoYMD(RString txtKeikakuTekiyoShuryoYMD) {
        this.setOriginalData("txtKeikakuTekiyoShuryoYMD", txtKeikakuTekiyoShuryoYMD);
        this.txtKeikakuTekiyoShuryoYMD = txtKeikakuTekiyoShuryoYMD;
    }

    public void setTxtTodokedeYMD(RString txtTodokedeYMD) {
        this.setOriginalData("txtTodokedeYMD", txtTodokedeYMD);
        this.txtTodokedeYMD = txtTodokedeYMD;
    }

    public void setTxtTodokedeKubun(RString txtTodokedeKubun) {
        this.setOriginalData("txtTodokedeKubun", txtTodokedeKubun);
        this.txtTodokedeKubun = txtTodokedeKubun;
    }

    public void setTxtKeikakuIraiJigyosha(RString txtKeikakuIraiJigyosha) {
        this.setOriginalData("txtKeikakuIraiJigyosha", txtKeikakuIraiJigyosha);
        this.txtKeikakuIraiJigyosha = txtKeikakuIraiJigyosha;
    }

}