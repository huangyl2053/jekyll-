package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 27 19:30:58 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgServiceRiyohyoRirekiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgServiceRiyohyoRirekiList_Row extends DataRow {

    private Button btnSelect;
    private RString txtJotai;
    private RString txtTodokedeYMD;
    private RString txtTodokedeKubun;
    private RString txtTekiyoKaishiYMD;
    private RString txtTekiyoShuryoYMD;
    private RString txtIraiJigyosha;

    public dgServiceRiyohyoRirekiList_Row() {
        super();
        this.btnSelect = new Button();
        this.txtJotai = RString.EMPTY;
        this.txtTodokedeYMD = RString.EMPTY;
        this.txtTodokedeKubun = RString.EMPTY;
        this.txtTekiyoKaishiYMD = RString.EMPTY;
        this.txtTekiyoShuryoYMD = RString.EMPTY;
        this.txtIraiJigyosha = RString.EMPTY;
    }

    public dgServiceRiyohyoRirekiList_Row(Button btnSelect, RString txtJotai, RString txtTodokedeYMD, RString txtTodokedeKubun, RString txtTekiyoKaishiYMD, RString txtTekiyoShuryoYMD, RString txtIraiJigyosha) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("txtJotai", txtJotai);
        this.setOriginalData("txtTodokedeYMD", txtTodokedeYMD);
        this.setOriginalData("txtTodokedeKubun", txtTodokedeKubun);
        this.setOriginalData("txtTekiyoKaishiYMD", txtTekiyoKaishiYMD);
        this.setOriginalData("txtTekiyoShuryoYMD", txtTekiyoShuryoYMD);
        this.setOriginalData("txtIraiJigyosha", txtIraiJigyosha);
        this.btnSelect = btnSelect;
        this.txtJotai = txtJotai;
        this.txtTodokedeYMD = txtTodokedeYMD;
        this.txtTodokedeKubun = txtTodokedeKubun;
        this.txtTekiyoKaishiYMD = txtTekiyoKaishiYMD;
        this.txtTekiyoShuryoYMD = txtTekiyoShuryoYMD;
        this.txtIraiJigyosha = txtIraiJigyosha;
    }

    public Button getBtnSelect() {
        return btnSelect;
    }

    public RString getTxtJotai() {
        return txtJotai;
    }

    public RString getTxtTodokedeYMD() {
        return txtTodokedeYMD;
    }

    public RString getTxtTodokedeKubun() {
        return txtTodokedeKubun;
    }

    public RString getTxtTekiyoKaishiYMD() {
        return txtTekiyoKaishiYMD;
    }

    public RString getTxtTekiyoShuryoYMD() {
        return txtTekiyoShuryoYMD;
    }

    public RString getTxtIraiJigyosha() {
        return txtIraiJigyosha;
    }

    public void setBtnSelect(Button btnSelect) {
        this.setOriginalData("btnSelect", btnSelect);
        this.btnSelect = btnSelect;
    }

    public void setTxtJotai(RString txtJotai) {
        this.setOriginalData("txtJotai", txtJotai);
        this.txtJotai = txtJotai;
    }

    public void setTxtTodokedeYMD(RString txtTodokedeYMD) {
        this.setOriginalData("txtTodokedeYMD", txtTodokedeYMD);
        this.txtTodokedeYMD = txtTodokedeYMD;
    }

    public void setTxtTodokedeKubun(RString txtTodokedeKubun) {
        this.setOriginalData("txtTodokedeKubun", txtTodokedeKubun);
        this.txtTodokedeKubun = txtTodokedeKubun;
    }

    public void setTxtTekiyoKaishiYMD(RString txtTekiyoKaishiYMD) {
        this.setOriginalData("txtTekiyoKaishiYMD", txtTekiyoKaishiYMD);
        this.txtTekiyoKaishiYMD = txtTekiyoKaishiYMD;
    }

    public void setTxtTekiyoShuryoYMD(RString txtTekiyoShuryoYMD) {
        this.setOriginalData("txtTekiyoShuryoYMD", txtTekiyoShuryoYMD);
        this.txtTekiyoShuryoYMD = txtTekiyoShuryoYMD;
    }

    public void setTxtIraiJigyosha(RString txtIraiJigyosha) {
        this.setOriginalData("txtIraiJigyosha", txtIraiJigyosha);
        this.txtIraiJigyosha = txtIraiJigyosha;
    }

}