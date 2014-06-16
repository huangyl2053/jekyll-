package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 16 11:44:43 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgFukaRirekiAll_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgFukaRirekiAll_Row extends DataRow {

    private RString txtChoteiNendo;
    private RString txtFukaNendo;
    private RString txtHokenryoDankai;
    private RString txtHokenryoNengaku;
    private RString txtTsuchishoNo;

    public dgFukaRirekiAll_Row() {
        super();
        this.txtChoteiNendo = RString.EMPTY;
        this.txtFukaNendo = RString.EMPTY;
        this.txtHokenryoDankai = RString.EMPTY;
        this.txtHokenryoNengaku = RString.EMPTY;
        this.txtTsuchishoNo = RString.EMPTY;
    }

    public dgFukaRirekiAll_Row(RString txtChoteiNendo, RString txtFukaNendo, RString txtHokenryoDankai, RString txtHokenryoNengaku, RString txtTsuchishoNo) {
        super();
        this.setOriginalData("txtChoteiNendo", txtChoteiNendo);
        this.setOriginalData("txtFukaNendo", txtFukaNendo);
        this.setOriginalData("txtHokenryoDankai", txtHokenryoDankai);
        this.setOriginalData("txtHokenryoNengaku", txtHokenryoNengaku);
        this.setOriginalData("txtTsuchishoNo", txtTsuchishoNo);
        this.txtChoteiNendo = txtChoteiNendo;
        this.txtFukaNendo = txtFukaNendo;
        this.txtHokenryoDankai = txtHokenryoDankai;
        this.txtHokenryoNengaku = txtHokenryoNengaku;
        this.txtTsuchishoNo = txtTsuchishoNo;
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