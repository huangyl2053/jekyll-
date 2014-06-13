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
 * dgSogoShokaiKyufuKyotakuServiceKeikakuList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSogoShokaiKyufuKyotakuServiceKeikakuList_Row extends DataRow {

    private ButtonDialog btnSelect;
    private RString txtTodokedeYMD;
    private RString txtTekiyoKaishiYMD;
    private RString txtTekiyoShuryoYMD;
    private RString txtHenkoYMD;

    public dgSogoShokaiKyufuKyotakuServiceKeikakuList_Row() {
        super();
        this.btnSelect = new ButtonDialog();
        this.txtTodokedeYMD = RString.EMPTY;
        this.txtTekiyoKaishiYMD = RString.EMPTY;
        this.txtTekiyoShuryoYMD = RString.EMPTY;
        this.txtHenkoYMD = RString.EMPTY;
    }

    public dgSogoShokaiKyufuKyotakuServiceKeikakuList_Row(ButtonDialog btnSelect, RString txtTodokedeYMD, RString txtTekiyoKaishiYMD, RString txtTekiyoShuryoYMD, RString txtHenkoYMD) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("txtTodokedeYMD", txtTodokedeYMD);
        this.setOriginalData("txtTekiyoKaishiYMD", txtTekiyoKaishiYMD);
        this.setOriginalData("txtTekiyoShuryoYMD", txtTekiyoShuryoYMD);
        this.setOriginalData("txtHenkoYMD", txtHenkoYMD);
        this.btnSelect = btnSelect;
        this.txtTodokedeYMD = txtTodokedeYMD;
        this.txtTekiyoKaishiYMD = txtTekiyoKaishiYMD;
        this.txtTekiyoShuryoYMD = txtTekiyoShuryoYMD;
        this.txtHenkoYMD = txtHenkoYMD;
    }

    public ButtonDialog getBtnSelect() {
        return btnSelect;
    }

    public RString getTxtTodokedeYMD() {
        return txtTodokedeYMD;
    }

    public RString getTxtTekiyoKaishiYMD() {
        return txtTekiyoKaishiYMD;
    }

    public RString getTxtTekiyoShuryoYMD() {
        return txtTekiyoShuryoYMD;
    }

    public RString getTxtHenkoYMD() {
        return txtHenkoYMD;
    }

    public void setBtnSelect(ButtonDialog btnSelect) {
        this.setOriginalData("btnSelect", btnSelect);
        this.btnSelect = btnSelect;
    }

    public void setTxtTodokedeYMD(RString txtTodokedeYMD) {
        this.setOriginalData("txtTodokedeYMD", txtTodokedeYMD);
        this.txtTodokedeYMD = txtTodokedeYMD;
    }

    public void setTxtTekiyoKaishiYMD(RString txtTekiyoKaishiYMD) {
        this.setOriginalData("txtTekiyoKaishiYMD", txtTekiyoKaishiYMD);
        this.txtTekiyoKaishiYMD = txtTekiyoKaishiYMD;
    }

    public void setTxtTekiyoShuryoYMD(RString txtTekiyoShuryoYMD) {
        this.setOriginalData("txtTekiyoShuryoYMD", txtTekiyoShuryoYMD);
        this.txtTekiyoShuryoYMD = txtTekiyoShuryoYMD;
    }

    public void setTxtHenkoYMD(RString txtHenkoYMD) {
        this.setOriginalData("txtHenkoYMD", txtHenkoYMD);
        this.txtHenkoYMD = txtHenkoYMD;
    }

}