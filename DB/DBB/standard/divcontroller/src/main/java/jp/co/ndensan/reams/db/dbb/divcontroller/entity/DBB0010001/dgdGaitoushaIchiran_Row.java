package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 27 20:05:17 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgdGaitoushaIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgdGaitoushaIchiran_Row extends DataRow {

    private RString txtChoteiNendo;
    private RString txtTsuchiNo;
    private RString txtHihoNo;
    private RString txtName;
    private TextBoxFlexibleDate txtUmareYmd;
    private RString txtSeibetsu;
    private RString txtShubetsu;
    private RString txtJusho;
    private RString txtShikbetsuCode;

    public dgdGaitoushaIchiran_Row() {
        super();
        this.txtChoteiNendo = RString.EMPTY;
        this.txtTsuchiNo = RString.EMPTY;
        this.txtHihoNo = RString.EMPTY;
        this.txtName = RString.EMPTY;
        this.txtUmareYmd = new TextBoxFlexibleDate();
        this.txtSeibetsu = RString.EMPTY;
        this.txtShubetsu = RString.EMPTY;
        this.txtJusho = RString.EMPTY;
        this.txtShikbetsuCode = RString.EMPTY;
    }

    public dgdGaitoushaIchiran_Row(RString txtChoteiNendo, RString txtTsuchiNo, RString txtHihoNo, RString txtName, TextBoxFlexibleDate txtUmareYmd, RString txtSeibetsu, RString txtShubetsu, RString txtJusho, RString txtShikbetsuCode) {
        super();
        this.setOriginalData("txtChoteiNendo", txtChoteiNendo);
        this.setOriginalData("txtTsuchiNo", txtTsuchiNo);
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.setOriginalData("txtName", txtName);
        this.setOriginalData("txtUmareYmd", txtUmareYmd);
        this.setOriginalData("txtSeibetsu", txtSeibetsu);
        this.setOriginalData("txtShubetsu", txtShubetsu);
        this.setOriginalData("txtJusho", txtJusho);
        this.setOriginalData("txtShikbetsuCode", txtShikbetsuCode);
        this.txtChoteiNendo = txtChoteiNendo;
        this.txtTsuchiNo = txtTsuchiNo;
        this.txtHihoNo = txtHihoNo;
        this.txtName = txtName;
        this.txtUmareYmd = txtUmareYmd;
        this.txtSeibetsu = txtSeibetsu;
        this.txtShubetsu = txtShubetsu;
        this.txtJusho = txtJusho;
        this.txtShikbetsuCode = txtShikbetsuCode;
    }

    public RString getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    public RString getTxtTsuchiNo() {
        return txtTsuchiNo;
    }

    public RString getTxtHihoNo() {
        return txtHihoNo;
    }

    public RString getTxtName() {
        return txtName;
    }

    public TextBoxFlexibleDate getTxtUmareYmd() {
        return txtUmareYmd;
    }

    public RString getTxtSeibetsu() {
        return txtSeibetsu;
    }

    public RString getTxtShubetsu() {
        return txtShubetsu;
    }

    public RString getTxtJusho() {
        return txtJusho;
    }

    public RString getTxtShikbetsuCode() {
        return txtShikbetsuCode;
    }

    public void setTxtChoteiNendo(RString txtChoteiNendo) {
        this.setOriginalData("txtChoteiNendo", txtChoteiNendo);
        this.txtChoteiNendo = txtChoteiNendo;
    }

    public void setTxtTsuchiNo(RString txtTsuchiNo) {
        this.setOriginalData("txtTsuchiNo", txtTsuchiNo);
        this.txtTsuchiNo = txtTsuchiNo;
    }

    public void setTxtHihoNo(RString txtHihoNo) {
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.txtHihoNo = txtHihoNo;
    }

    public void setTxtName(RString txtName) {
        this.setOriginalData("txtName", txtName);
        this.txtName = txtName;
    }

    public void setTxtUmareYmd(TextBoxFlexibleDate txtUmareYmd) {
        this.setOriginalData("txtUmareYmd", txtUmareYmd);
        this.txtUmareYmd = txtUmareYmd;
    }

    public void setTxtSeibetsu(RString txtSeibetsu) {
        this.setOriginalData("txtSeibetsu", txtSeibetsu);
        this.txtSeibetsu = txtSeibetsu;
    }

    public void setTxtShubetsu(RString txtShubetsu) {
        this.setOriginalData("txtShubetsu", txtShubetsu);
        this.txtShubetsu = txtShubetsu;
    }

    public void setTxtJusho(RString txtJusho) {
        this.setOriginalData("txtJusho", txtJusho);
        this.txtJusho = txtJusho;
    }

    public void setTxtShikbetsuCode(RString txtShikbetsuCode) {
        this.setOriginalData("txtShikbetsuCode", txtShikbetsuCode);
        this.txtShikbetsuCode = txtShikbetsuCode;
    }

}