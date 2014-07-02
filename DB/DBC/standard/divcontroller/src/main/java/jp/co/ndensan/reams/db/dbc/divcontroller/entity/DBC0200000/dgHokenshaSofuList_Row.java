package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0200000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jun 05 19:45:49 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgHokenshaSofuList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgHokenshaSofuList_Row extends DataRow {

    private Button btnSelect;
    private RString txtSofuJoho;
    private RString txtZenZengetsu;
    private RString txtZengetsu;
    private RString txtTogetsuJotai;
    private RString txtShoriNichiji;

    public dgHokenshaSofuList_Row() {
        super();
    }

    public dgHokenshaSofuList_Row(Button btnSelect, RString txtSofuJoho, RString txtZenZengetsu, RString txtZengetsu, RString txtTogetsuJotai, RString txtShoriNichiji) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("txtSofuJoho", txtSofuJoho);
        this.setOriginalData("txtZenZengetsu", txtZenZengetsu);
        this.setOriginalData("txtZengetsu", txtZengetsu);
        this.setOriginalData("txtTogetsuJotai", txtTogetsuJotai);
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
        this.btnSelect = btnSelect;
        this.txtSofuJoho = txtSofuJoho;
        this.txtZenZengetsu = txtZenZengetsu;
        this.txtZengetsu = txtZengetsu;
        this.txtTogetsuJotai = txtTogetsuJotai;
        this.txtShoriNichiji = txtShoriNichiji;
    }

    public Button getBtnSelect() {
        return btnSelect;
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