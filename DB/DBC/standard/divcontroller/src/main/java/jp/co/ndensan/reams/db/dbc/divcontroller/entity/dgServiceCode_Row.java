package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue May 27 18:04:19 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgServiceCode_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgServiceCode_Row extends DataRow {

    private Button btnModifyRow;
    private Button btnDeleteRow;
    private TextBoxDate txtKaishiYM;
    private TextBoxDate txtShuryoYM;
    private TextBoxCode txtServiceCode;
    private TextBoxNum txtTani;
    private RString txtTanisuShikibetsu;
    private Boolean txtGendogakuTaishogai;
    private Boolean txtGaibuRiyo;
    private Boolean txtTokubetsuChiki;

    public dgServiceCode_Row() {
        super();
    }

    public dgServiceCode_Row(Button btnModifyRow, Button btnDeleteRow, TextBoxDate txtKaishiYM, TextBoxDate txtShuryoYM, TextBoxCode txtServiceCode, TextBoxNum txtTani, RString txtTanisuShikibetsu, Boolean txtGendogakuTaishogai, Boolean txtGaibuRiyo, Boolean txtTokubetsuChiki) {
        super();
        this.setOriginalData("btnModifyRow", btnModifyRow);
        this.setOriginalData("btnDeleteRow", btnDeleteRow);
        this.setOriginalData("txtKaishiYM", txtKaishiYM);
        this.setOriginalData("txtShuryoYM", txtShuryoYM);
        this.setOriginalData("txtServiceCode", txtServiceCode);
        this.setOriginalData("txtTani", txtTani);
        this.setOriginalData("txtTanisuShikibetsu", txtTanisuShikibetsu);
        this.setOriginalData("txtGendogakuTaishogai", txtGendogakuTaishogai);
        this.setOriginalData("txtGaibuRiyo", txtGaibuRiyo);
        this.setOriginalData("txtTokubetsuChiki", txtTokubetsuChiki);
        this.btnModifyRow = btnModifyRow;
        this.btnDeleteRow = btnDeleteRow;
        this.txtKaishiYM = txtKaishiYM;
        this.txtShuryoYM = txtShuryoYM;
        this.txtServiceCode = txtServiceCode;
        this.txtTani = txtTani;
        this.txtTanisuShikibetsu = txtTanisuShikibetsu;
        this.txtGendogakuTaishogai = txtGendogakuTaishogai;
        this.txtGaibuRiyo = txtGaibuRiyo;
        this.txtTokubetsuChiki = txtTokubetsuChiki;
    }

    public Button getBtnModifyRow() {
        return btnModifyRow;
    }

    public Button getBtnDeleteRow() {
        return btnDeleteRow;
    }

    public TextBoxDate getTxtKaishiYM() {
        return txtKaishiYM;
    }

    public TextBoxDate getTxtShuryoYM() {
        return txtShuryoYM;
    }

    public TextBoxCode getTxtServiceCode() {
        return txtServiceCode;
    }

    public TextBoxNum getTxtTani() {
        return txtTani;
    }

    public RString getTxtTanisuShikibetsu() {
        return txtTanisuShikibetsu;
    }

    public Boolean getTxtGendogakuTaishogai() {
        return txtGendogakuTaishogai;
    }

    public Boolean getTxtGaibuRiyo() {
        return txtGaibuRiyo;
    }

    public Boolean getTxtTokubetsuChiki() {
        return txtTokubetsuChiki;
    }

    public void setBtnModifyRow(Button btnModifyRow) {
        this.setOriginalData("btnModifyRow", btnModifyRow);
        this.btnModifyRow = btnModifyRow;
    }

    public void setBtnDeleteRow(Button btnDeleteRow) {
        this.setOriginalData("btnDeleteRow", btnDeleteRow);
        this.btnDeleteRow = btnDeleteRow;
    }

    public void setTxtKaishiYM(TextBoxDate txtKaishiYM) {
        this.setOriginalData("txtKaishiYM", txtKaishiYM);
        this.txtKaishiYM = txtKaishiYM;
    }

    public void setTxtShuryoYM(TextBoxDate txtShuryoYM) {
        this.setOriginalData("txtShuryoYM", txtShuryoYM);
        this.txtShuryoYM = txtShuryoYM;
    }

    public void setTxtServiceCode(TextBoxCode txtServiceCode) {
        this.setOriginalData("txtServiceCode", txtServiceCode);
        this.txtServiceCode = txtServiceCode;
    }

    public void setTxtTani(TextBoxNum txtTani) {
        this.setOriginalData("txtTani", txtTani);
        this.txtTani = txtTani;
    }

    public void setTxtTanisuShikibetsu(RString txtTanisuShikibetsu) {
        this.setOriginalData("txtTanisuShikibetsu", txtTanisuShikibetsu);
        this.txtTanisuShikibetsu = txtTanisuShikibetsu;
    }

    public void setTxtGendogakuTaishogai(Boolean txtGendogakuTaishogai) {
        this.setOriginalData("txtGendogakuTaishogai", txtGendogakuTaishogai);
        this.txtGendogakuTaishogai = txtGendogakuTaishogai;
    }

    public void setTxtGaibuRiyo(Boolean txtGaibuRiyo) {
        this.setOriginalData("txtGaibuRiyo", txtGaibuRiyo);
        this.txtGaibuRiyo = txtGaibuRiyo;
    }

    public void setTxtTokubetsuChiki(Boolean txtTokubetsuChiki) {
        this.setOriginalData("txtTokubetsuChiki", txtTokubetsuChiki);
        this.txtTokubetsuChiki = txtTokubetsuChiki;
    }

}