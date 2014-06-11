package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jun 10 16:28:33 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgFukaRirekiAll_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgFukaRirekiAll_Row extends DataRow {

    private Button btnKakunin;
    private RString txtChoteiNendo;
    private RString txtFukaNendo;
    private RString txtHokenryoDankai;
    private RString txtHokenryoNengaku;
    private RString txtTsuchishoNo;

    public dgFukaRirekiAll_Row() {
        super();
    }

    public dgFukaRirekiAll_Row(Button btnKakunin, RString txtChoteiNendo, RString txtFukaNendo, RString txtHokenryoDankai, RString txtHokenryoNengaku, RString txtTsuchishoNo) {
        super();
        this.setOriginalData("btnKakunin", btnKakunin);
        this.setOriginalData("txtChoteiNendo", txtChoteiNendo);
        this.setOriginalData("txtFukaNendo", txtFukaNendo);
        this.setOriginalData("txtHokenryoDankai", txtHokenryoDankai);
        this.setOriginalData("txtHokenryoNengaku", txtHokenryoNengaku);
        this.setOriginalData("txtTsuchishoNo", txtTsuchishoNo);
        this.btnKakunin = btnKakunin;
        this.txtChoteiNendo = txtChoteiNendo;
        this.txtFukaNendo = txtFukaNendo;
        this.txtHokenryoDankai = txtHokenryoDankai;
        this.txtHokenryoNengaku = txtHokenryoNengaku;
        this.txtTsuchishoNo = txtTsuchishoNo;
    }

    public Button getBtnKakunin() {
        return btnKakunin;
    }

    public RString getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    public RString getTxtFukaNendo() {
        return txtFukaNendo;
    }

    public RString getTxtHokenryoDankai() {
        return txtHokenryoDankai;
    }

    public RString getTxtHokenryoNengaku() {
        return txtHokenryoNengaku;
    }

    public RString getTxtTsuchishoNo() {
        return txtTsuchishoNo;
    }

    public void setBtnKakunin(Button btnKakunin) {
        this.setOriginalData("btnKakunin", btnKakunin);
        this.btnKakunin = btnKakunin;
    }

    public void setTxtChoteiNendo(RString txtChoteiNendo) {
        this.setOriginalData("txtChoteiNendo", txtChoteiNendo);
        this.txtChoteiNendo = txtChoteiNendo;
    }

    public void setTxtFukaNendo(RString txtFukaNendo) {
        this.setOriginalData("txtFukaNendo", txtFukaNendo);
        this.txtFukaNendo = txtFukaNendo;
    }

    public void setTxtHokenryoDankai(RString txtHokenryoDankai) {
        this.setOriginalData("txtHokenryoDankai", txtHokenryoDankai);
        this.txtHokenryoDankai = txtHokenryoDankai;
    }

    public void setTxtHokenryoNengaku(RString txtHokenryoNengaku) {
        this.setOriginalData("txtHokenryoNengaku", txtHokenryoNengaku);
        this.txtHokenryoNengaku = txtHokenryoNengaku;
    }

    public void setTxtTsuchishoNo(RString txtTsuchishoNo) {
        this.setOriginalData("txtTsuchishoNo", txtTsuchishoNo);
        this.txtTsuchishoNo = txtTsuchishoNo;
    }

}