package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Jun 18 11:50:45 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgSokujiFukaKouseiRireki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSokujiFukaKouseiRireki_Row extends DataRow {

    private RString txtChoteiNendo;
    private RString txtFukaNendo;
    private RString txtHokenryoDankai;
    private RString txtHokenryoNengaku;
    private RString txtTokuchoGaku;
    private RString txtFuchiGaku;

    public dgSokujiFukaKouseiRireki_Row() {
        super();
        this.txtChoteiNendo = RString.EMPTY;
        this.txtFukaNendo = RString.EMPTY;
        this.txtHokenryoDankai = RString.EMPTY;
        this.txtHokenryoNengaku = RString.EMPTY;
        this.txtTokuchoGaku = RString.EMPTY;
        this.txtFuchiGaku = RString.EMPTY;
    }

    public dgSokujiFukaKouseiRireki_Row(RString txtChoteiNendo, RString txtFukaNendo, RString txtHokenryoDankai, RString txtHokenryoNengaku, RString txtTokuchoGaku, RString txtFuchiGaku) {
        super();
        this.setOriginalData("txtChoteiNendo", txtChoteiNendo);
        this.setOriginalData("txtFukaNendo", txtFukaNendo);
        this.setOriginalData("txtHokenryoDankai", txtHokenryoDankai);
        this.setOriginalData("txtHokenryoNengaku", txtHokenryoNengaku);
        this.setOriginalData("txtTokuchoGaku", txtTokuchoGaku);
        this.setOriginalData("txtFuchiGaku", txtFuchiGaku);
        this.txtChoteiNendo = txtChoteiNendo;
        this.txtFukaNendo = txtFukaNendo;
        this.txtHokenryoDankai = txtHokenryoDankai;
        this.txtHokenryoNengaku = txtHokenryoNengaku;
        this.txtTokuchoGaku = txtTokuchoGaku;
        this.txtFuchiGaku = txtFuchiGaku;
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

    public RString getTxtTokuchoGaku() {
        return txtTokuchoGaku;
    }

    public RString getTxtFuchiGaku() {
        return txtFuchiGaku;
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

    public void setTxtTokuchoGaku(RString txtTokuchoGaku) {
        this.setOriginalData("txtTokuchoGaku", txtTokuchoGaku);
        this.txtTokuchoGaku = txtTokuchoGaku;
    }

    public void setTxtFuchiGaku(RString txtFuchiGaku) {
        this.setOriginalData("txtFuchiGaku", txtFuchiGaku);
        this.txtFuchiGaku = txtFuchiGaku;
    }

}