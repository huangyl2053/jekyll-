package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jun 06 16:04:03 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKokuhorenTorikomiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKokuhorenTorikomiList_Row extends DataRow {

    private Button btnSelect;
    private RString txtUketoriTorikomi;
    private RString txtSofuJoho;
    private RString txtZenZengetsu;
    private RString txtZengetsu;
    private RString txtTogetsuJotai;
    private RString txtShoriNichiji;

    public dgKokuhorenTorikomiList_Row() {
        super();
    }

    public dgKokuhorenTorikomiList_Row(Button btnSelect, RString txtUketoriTorikomi, RString txtSofuJoho, RString txtZenZengetsu, RString txtZengetsu, RString txtTogetsuJotai, RString txtShoriNichiji) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("txtUketoriTorikomi", txtUketoriTorikomi);
        this.setOriginalData("txtSofuJoho", txtSofuJoho);
        this.setOriginalData("txtZenZengetsu", txtZenZengetsu);
        this.setOriginalData("txtZengetsu", txtZengetsu);
        this.setOriginalData("txtTogetsuJotai", txtTogetsuJotai);
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
        this.btnSelect = btnSelect;
        this.txtUketoriTorikomi = txtUketoriTorikomi;
        this.txtSofuJoho = txtSofuJoho;
        this.txtZenZengetsu = txtZenZengetsu;
        this.txtZengetsu = txtZengetsu;
        this.txtTogetsuJotai = txtTogetsuJotai;
        this.txtShoriNichiji = txtShoriNichiji;
    }

    public Button getBtnSelect() {
        return btnSelect;
    }

    public RString getTxtUketoriTorikomi() {
        return txtUketoriTorikomi;
    }

    public RString getTxtSofuJoho() {
        return txtSofuJoho;
    }

    public RString getTxtZenZengetsu() {
        return txtZenZengetsu;
    }

    public RString getTxtZengetsu() {
        return txtZengetsu;
    }

    public RString getTxtTogetsuJotai() {
        return txtTogetsuJotai;
    }

    public RString getTxtShoriNichiji() {
        return txtShoriNichiji;
    }

    public void setBtnSelect(Button btnSelect) {
        this.setOriginalData("btnSelect", btnSelect);
        this.btnSelect = btnSelect;
    }

    public void setTxtUketoriTorikomi(RString txtUketoriTorikomi) {
        this.setOriginalData("txtUketoriTorikomi", txtUketoriTorikomi);
        this.txtUketoriTorikomi = txtUketoriTorikomi;
    }

    public void setTxtSofuJoho(RString txtSofuJoho) {
        this.setOriginalData("txtSofuJoho", txtSofuJoho);
        this.txtSofuJoho = txtSofuJoho;
    }

    public void setTxtZenZengetsu(RString txtZenZengetsu) {
        this.setOriginalData("txtZenZengetsu", txtZenZengetsu);
        this.txtZenZengetsu = txtZenZengetsu;
    }

    public void setTxtZengetsu(RString txtZengetsu) {
        this.setOriginalData("txtZengetsu", txtZengetsu);
        this.txtZengetsu = txtZengetsu;
    }

    public void setTxtTogetsuJotai(RString txtTogetsuJotai) {
        this.setOriginalData("txtTogetsuJotai", txtTogetsuJotai);
        this.txtTogetsuJotai = txtTogetsuJotai;
    }

    public void setTxtShoriNichiji(RString txtShoriNichiji) {
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
        this.txtShoriNichiji = txtShoriNichiji;
    }

}