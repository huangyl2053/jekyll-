package jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuhiRireki;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 16 11:13:04 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgJutakuKaishuRireki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgJutakuKaishuRireki_Row extends DataRow {

    private TextBoxDate txtTeikyoYM;
    private TextBoxDate txtShinseiDate;
    private TextBoxDate txtKetteiDate;
    private RString txtShinsaResult;
    private TextBoxNum txtHiyogakuTotal;
    private TextBoxNum txtHokenTaishoHiyogaku;
    private TextBoxNum txtHokenKyufugaku;
    private TextBoxNum txtRiyoshaFutangaku;
    private Boolean txtTenkyoReset;
    private Boolean txt3DantaiReset;
    private RString txtTaishoJutakuAddress;

    public dgJutakuKaishuRireki_Row() {
        super();
        this.txtTeikyoYM = new TextBoxDate();
        this.txtShinseiDate = new TextBoxDate();
        this.txtKetteiDate = new TextBoxDate();
        this.txtShinsaResult = RString.EMPTY;
        this.txtHiyogakuTotal = new TextBoxNum();
        this.txtHokenTaishoHiyogaku = new TextBoxNum();
        this.txtHokenKyufugaku = new TextBoxNum();
        this.txtRiyoshaFutangaku = new TextBoxNum();
        this.txtTenkyoReset = false;
        this.txt3DantaiReset = false;
        this.txtTaishoJutakuAddress = RString.EMPTY;
    }

    public dgJutakuKaishuRireki_Row(TextBoxDate txtTeikyoYM, TextBoxDate txtShinseiDate, TextBoxDate txtKetteiDate, RString txtShinsaResult, TextBoxNum txtHiyogakuTotal, TextBoxNum txtHokenTaishoHiyogaku, TextBoxNum txtHokenKyufugaku, TextBoxNum txtRiyoshaFutangaku, Boolean txtTenkyoReset, Boolean txt3DantaiReset, RString txtTaishoJutakuAddress) {
        super();
        this.setOriginalData("txtTeikyoYM", txtTeikyoYM);
        this.setOriginalData("txtShinseiDate", txtShinseiDate);
        this.setOriginalData("txtKetteiDate", txtKetteiDate);
        this.setOriginalData("txtShinsaResult", txtShinsaResult);
        this.setOriginalData("txtHiyogakuTotal", txtHiyogakuTotal);
        this.setOriginalData("txtHokenTaishoHiyogaku", txtHokenTaishoHiyogaku);
        this.setOriginalData("txtHokenKyufugaku", txtHokenKyufugaku);
        this.setOriginalData("txtRiyoshaFutangaku", txtRiyoshaFutangaku);
        this.setOriginalData("txtTenkyoReset", txtTenkyoReset);
        this.setOriginalData("txt3DantaiReset", txt3DantaiReset);
        this.setOriginalData("txtTaishoJutakuAddress", txtTaishoJutakuAddress);
        this.txtTeikyoYM = txtTeikyoYM;
        this.txtShinseiDate = txtShinseiDate;
        this.txtKetteiDate = txtKetteiDate;
        this.txtShinsaResult = txtShinsaResult;
        this.txtHiyogakuTotal = txtHiyogakuTotal;
        this.txtHokenTaishoHiyogaku = txtHokenTaishoHiyogaku;
        this.txtHokenKyufugaku = txtHokenKyufugaku;
        this.txtRiyoshaFutangaku = txtRiyoshaFutangaku;
        this.txtTenkyoReset = txtTenkyoReset;
        this.txt3DantaiReset = txt3DantaiReset;
        this.txtTaishoJutakuAddress = txtTaishoJutakuAddress;
    }

    public TextBoxDate getTxtTeikyoYM() {
        return txtTeikyoYM;
    }

    public TextBoxDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    public TextBoxDate getTxtKetteiDate() {
        return txtKetteiDate;
    }

    public RString getTxtShinsaResult() {
        return txtShinsaResult;
    }

    public TextBoxNum getTxtHiyogakuTotal() {
        return txtHiyogakuTotal;
    }

    public TextBoxNum getTxtHokenTaishoHiyogaku() {
        return txtHokenTaishoHiyogaku;
    }

    public TextBoxNum getTxtHokenKyufugaku() {
        return txtHokenKyufugaku;
    }

    public TextBoxNum getTxtRiyoshaFutangaku() {
        return txtRiyoshaFutangaku;
    }

    public Boolean getTxtTenkyoReset() {
        return txtTenkyoReset;
    }

    public Boolean getTxt3DantaiReset() {
        return txt3DantaiReset;
    }

    public RString getTxtTaishoJutakuAddress() {
        return txtTaishoJutakuAddress;
    }

    public void setTxtTeikyoYM(TextBoxDate txtTeikyoYM) {
        this.setOriginalData("txtTeikyoYM", txtTeikyoYM);
        this.txtTeikyoYM = txtTeikyoYM;
    }

    public void setTxtShinseiDate(TextBoxDate txtShinseiDate) {
        this.setOriginalData("txtShinseiDate", txtShinseiDate);
        this.txtShinseiDate = txtShinseiDate;
    }

    public void setTxtKetteiDate(TextBoxDate txtKetteiDate) {
        this.setOriginalData("txtKetteiDate", txtKetteiDate);
        this.txtKetteiDate = txtKetteiDate;
    }

    public void setTxtShinsaResult(RString txtShinsaResult) {
        this.setOriginalData("txtShinsaResult", txtShinsaResult);
        this.txtShinsaResult = txtShinsaResult;
    }

    public void setTxtHiyogakuTotal(TextBoxNum txtHiyogakuTotal) {
        this.setOriginalData("txtHiyogakuTotal", txtHiyogakuTotal);
        this.txtHiyogakuTotal = txtHiyogakuTotal;
    }

    public void setTxtHokenTaishoHiyogaku(TextBoxNum txtHokenTaishoHiyogaku) {
        this.setOriginalData("txtHokenTaishoHiyogaku", txtHokenTaishoHiyogaku);
        this.txtHokenTaishoHiyogaku = txtHokenTaishoHiyogaku;
    }

    public void setTxtHokenKyufugaku(TextBoxNum txtHokenKyufugaku) {
        this.setOriginalData("txtHokenKyufugaku", txtHokenKyufugaku);
        this.txtHokenKyufugaku = txtHokenKyufugaku;
    }

    public void setTxtRiyoshaFutangaku(TextBoxNum txtRiyoshaFutangaku) {
        this.setOriginalData("txtRiyoshaFutangaku", txtRiyoshaFutangaku);
        this.txtRiyoshaFutangaku = txtRiyoshaFutangaku;
    }

    public void setTxtTenkyoReset(Boolean txtTenkyoReset) {
        this.setOriginalData("txtTenkyoReset", txtTenkyoReset);
        this.txtTenkyoReset = txtTenkyoReset;
    }

    public void setTxt3DantaiReset(Boolean txt3DantaiReset) {
        this.setOriginalData("txt3DantaiReset", txt3DantaiReset);
        this.txt3DantaiReset = txt3DantaiReset;
    }

    public void setTxtTaishoJutakuAddress(RString txtTaishoJutakuAddress) {
        this.setOriginalData("txtTaishoJutakuAddress", txtTaishoJutakuAddress);
        this.txtTaishoJutakuAddress = txtTaishoJutakuAddress;
    }

}