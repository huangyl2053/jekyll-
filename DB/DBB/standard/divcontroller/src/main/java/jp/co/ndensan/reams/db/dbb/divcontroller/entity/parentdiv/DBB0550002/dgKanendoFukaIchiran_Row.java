package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Mar 28 14:37:44 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * dgKanendoFukaIchiran_Row のクラスファイル
 *
 * @reamsid_L DBB-0680-010 wangkanglei
 */
public class dgKanendoFukaIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    private TextBox txtKetsugoKomoku1;
    private TextBox txtTuchishoNo;
    private TextBox txtHihokenshaNo;
    private TextBox txtShikibetsuCode;
    private TextBox txtChoteiNendo;
    private TextBoxDate txtChoteiNendoMae;
    private TextBoxDate txtChoteiNendoAto;
    private TextBox txtFukaNendo;
    private TextBoxDate txtFukaNendoMae;
    private TextBoxDate txtFukaNendoAto;
    private TextBox txtKakuteiHokenryo;
    private TextBoxNum txtKakuteiHokenryoMae;
    private TextBoxNum txtKakuteiHokenryoAto;
    private TextBox txtNengakuHokenryo;
    private TextBoxNum txtNengakuHokenryoMae;
    private TextBoxNum txtNengakuHokenryoAto;
    private TextBox txtGenmenGaku;
    private TextBoxNum txtGenmenGakuMae;
    private TextBoxNum txtGenmenGakuAto;
    private TextBox txtShotokuDankai;
    private TextBox txtShotokuDankaiMae;
    private TextBox txtShotokuDankaiAto;
    private TextBoxNum txtKanendoGaku;
    private TextBoxDate txtKanendoNokiGen;

    public dgKanendoFukaIchiran_Row() {
        super();
        this.txtKetsugoKomoku1 = new TextBox();
        this.txtTuchishoNo = new TextBox();
        this.txtHihokenshaNo = new TextBox();
        this.txtShikibetsuCode = new TextBox();
        this.txtChoteiNendo = new TextBox();
        this.txtChoteiNendoMae = new TextBoxDate();
        this.txtChoteiNendoAto = new TextBoxDate();
        this.txtFukaNendo = new TextBox();
        this.txtFukaNendoMae = new TextBoxDate();
        this.txtFukaNendoAto = new TextBoxDate();
        this.txtKakuteiHokenryo = new TextBox();
        this.txtKakuteiHokenryoMae = new TextBoxNum();
        this.txtKakuteiHokenryoAto = new TextBoxNum();
        this.txtNengakuHokenryo = new TextBox();
        this.txtNengakuHokenryoMae = new TextBoxNum();
        this.txtNengakuHokenryoAto = new TextBoxNum();
        this.txtGenmenGaku = new TextBox();
        this.txtGenmenGakuMae = new TextBoxNum();
        this.txtGenmenGakuAto = new TextBoxNum();
        this.txtShotokuDankai = new TextBox();
        this.txtShotokuDankaiMae = new TextBox();
        this.txtShotokuDankaiAto = new TextBox();
        this.txtKanendoGaku = new TextBoxNum();
        this.txtKanendoNokiGen = new TextBoxDate();
        this.setOriginalData("txtKetsugoKomoku1", txtKetsugoKomoku1);
        this.setOriginalData("txtTuchishoNo", txtTuchishoNo);
        this.setOriginalData("txtHihokenshaNo", txtHihokenshaNo);
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.setOriginalData("txtChoteiNendo", txtChoteiNendo);
        this.setOriginalData("txtChoteiNendoMae", txtChoteiNendoMae);
        this.setOriginalData("txtChoteiNendoAto", txtChoteiNendoAto);
        this.setOriginalData("txtFukaNendo", txtFukaNendo);
        this.setOriginalData("txtFukaNendoMae", txtFukaNendoMae);
        this.setOriginalData("txtFukaNendoAto", txtFukaNendoAto);
        this.setOriginalData("txtKakuteiHokenryo", txtKakuteiHokenryo);
        this.setOriginalData("txtKakuteiHokenryoMae", txtKakuteiHokenryoMae);
        this.setOriginalData("txtKakuteiHokenryoAto", txtKakuteiHokenryoAto);
        this.setOriginalData("txtNengakuHokenryo", txtNengakuHokenryo);
        this.setOriginalData("txtNengakuHokenryoMae", txtNengakuHokenryoMae);
        this.setOriginalData("txtNengakuHokenryoAto", txtNengakuHokenryoAto);
        this.setOriginalData("txtGenmenGaku", txtGenmenGaku);
        this.setOriginalData("txtGenmenGakuMae", txtGenmenGakuMae);
        this.setOriginalData("txtGenmenGakuAto", txtGenmenGakuAto);
        this.setOriginalData("txtShotokuDankai", txtShotokuDankai);
        this.setOriginalData("txtShotokuDankaiMae", txtShotokuDankaiMae);
        this.setOriginalData("txtShotokuDankaiAto", txtShotokuDankaiAto);
        this.setOriginalData("txtKanendoGaku", txtKanendoGaku);
        this.setOriginalData("txtKanendoNokiGen", txtKanendoNokiGen);
    }

    public dgKanendoFukaIchiran_Row(TextBox txtKetsugoKomoku1, TextBox txtTuchishoNo, TextBox txtHihokenshaNo, TextBox txtShikibetsuCode, TextBox txtChoteiNendo, TextBoxDate txtChoteiNendoMae, TextBoxDate txtChoteiNendoAto, TextBox txtFukaNendo, TextBoxDate txtFukaNendoMae, TextBoxDate txtFukaNendoAto, TextBox txtKakuteiHokenryo, TextBoxNum txtKakuteiHokenryoMae, TextBoxNum txtKakuteiHokenryoAto, TextBox txtNengakuHokenryo, TextBoxNum txtNengakuHokenryoMae, TextBoxNum txtNengakuHokenryoAto, TextBox txtGenmenGaku, TextBoxNum txtGenmenGakuMae, TextBoxNum txtGenmenGakuAto, TextBox txtShotokuDankai, TextBox txtShotokuDankaiMae, TextBox txtShotokuDankaiAto, TextBoxNum txtKanendoGaku, TextBoxDate txtKanendoNokiGen) {
        super();
        this.setOriginalData("txtKetsugoKomoku1", txtKetsugoKomoku1);
        this.setOriginalData("txtTuchishoNo", txtTuchishoNo);
        this.setOriginalData("txtHihokenshaNo", txtHihokenshaNo);
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.setOriginalData("txtChoteiNendo", txtChoteiNendo);
        this.setOriginalData("txtChoteiNendoMae", txtChoteiNendoMae);
        this.setOriginalData("txtChoteiNendoAto", txtChoteiNendoAto);
        this.setOriginalData("txtFukaNendo", txtFukaNendo);
        this.setOriginalData("txtFukaNendoMae", txtFukaNendoMae);
        this.setOriginalData("txtFukaNendoAto", txtFukaNendoAto);
        this.setOriginalData("txtKakuteiHokenryo", txtKakuteiHokenryo);
        this.setOriginalData("txtKakuteiHokenryoMae", txtKakuteiHokenryoMae);
        this.setOriginalData("txtKakuteiHokenryoAto", txtKakuteiHokenryoAto);
        this.setOriginalData("txtNengakuHokenryo", txtNengakuHokenryo);
        this.setOriginalData("txtNengakuHokenryoMae", txtNengakuHokenryoMae);
        this.setOriginalData("txtNengakuHokenryoAto", txtNengakuHokenryoAto);
        this.setOriginalData("txtGenmenGaku", txtGenmenGaku);
        this.setOriginalData("txtGenmenGakuMae", txtGenmenGakuMae);
        this.setOriginalData("txtGenmenGakuAto", txtGenmenGakuAto);
        this.setOriginalData("txtShotokuDankai", txtShotokuDankai);
        this.setOriginalData("txtShotokuDankaiMae", txtShotokuDankaiMae);
        this.setOriginalData("txtShotokuDankaiAto", txtShotokuDankaiAto);
        this.setOriginalData("txtKanendoGaku", txtKanendoGaku);
        this.setOriginalData("txtKanendoNokiGen", txtKanendoNokiGen);
        this.txtKetsugoKomoku1 = txtKetsugoKomoku1;
        this.txtTuchishoNo = txtTuchishoNo;
        this.txtHihokenshaNo = txtHihokenshaNo;
        this.txtShikibetsuCode = txtShikibetsuCode;
        this.txtChoteiNendo = txtChoteiNendo;
        this.txtChoteiNendoMae = txtChoteiNendoMae;
        this.txtChoteiNendoAto = txtChoteiNendoAto;
        this.txtFukaNendo = txtFukaNendo;
        this.txtFukaNendoMae = txtFukaNendoMae;
        this.txtFukaNendoAto = txtFukaNendoAto;
        this.txtKakuteiHokenryo = txtKakuteiHokenryo;
        this.txtKakuteiHokenryoMae = txtKakuteiHokenryoMae;
        this.txtKakuteiHokenryoAto = txtKakuteiHokenryoAto;
        this.txtNengakuHokenryo = txtNengakuHokenryo;
        this.txtNengakuHokenryoMae = txtNengakuHokenryoMae;
        this.txtNengakuHokenryoAto = txtNengakuHokenryoAto;
        this.txtGenmenGaku = txtGenmenGaku;
        this.txtGenmenGakuMae = txtGenmenGakuMae;
        this.txtGenmenGakuAto = txtGenmenGakuAto;
        this.txtShotokuDankai = txtShotokuDankai;
        this.txtShotokuDankaiMae = txtShotokuDankaiMae;
        this.txtShotokuDankaiAto = txtShotokuDankaiAto;
        this.txtKanendoGaku = txtKanendoGaku;
        this.txtKanendoNokiGen = txtKanendoNokiGen;
    }

    public TextBox getTxtKetsugoKomoku1() {
        return txtKetsugoKomoku1;
    }

    public TextBox getTxtTuchishoNo() {
        return txtTuchishoNo;
    }

    public TextBox getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    public TextBox getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    public TextBox getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    public TextBoxDate getTxtChoteiNendoMae() {
        return txtChoteiNendoMae;
    }

    public TextBoxDate getTxtChoteiNendoAto() {
        return txtChoteiNendoAto;
    }

    public TextBox getTxtFukaNendo() {
        return txtFukaNendo;
    }

    public TextBoxDate getTxtFukaNendoMae() {
        return txtFukaNendoMae;
    }

    public TextBoxDate getTxtFukaNendoAto() {
        return txtFukaNendoAto;
    }

    public TextBox getTxtKakuteiHokenryo() {
        return txtKakuteiHokenryo;
    }

    public TextBoxNum getTxtKakuteiHokenryoMae() {
        return txtKakuteiHokenryoMae;
    }

    public TextBoxNum getTxtKakuteiHokenryoAto() {
        return txtKakuteiHokenryoAto;
    }

    public TextBox getTxtNengakuHokenryo() {
        return txtNengakuHokenryo;
    }

    public TextBoxNum getTxtNengakuHokenryoMae() {
        return txtNengakuHokenryoMae;
    }

    public TextBoxNum getTxtNengakuHokenryoAto() {
        return txtNengakuHokenryoAto;
    }

    public TextBox getTxtGenmenGaku() {
        return txtGenmenGaku;
    }

    public TextBoxNum getTxtGenmenGakuMae() {
        return txtGenmenGakuMae;
    }

    public TextBoxNum getTxtGenmenGakuAto() {
        return txtGenmenGakuAto;
    }

    public TextBox getTxtShotokuDankai() {
        return txtShotokuDankai;
    }

    public TextBox getTxtShotokuDankaiMae() {
        return txtShotokuDankaiMae;
    }

    public TextBox getTxtShotokuDankaiAto() {
        return txtShotokuDankaiAto;
    }

    public TextBoxNum getTxtKanendoGaku() {
        return txtKanendoGaku;
    }

    public TextBoxDate getTxtKanendoNokiGen() {
        return txtKanendoNokiGen;
    }

    public void setTxtKetsugoKomoku1(TextBox txtKetsugoKomoku1) {
        this.setOriginalData("txtKetsugoKomoku1", txtKetsugoKomoku1);
        this.txtKetsugoKomoku1 = txtKetsugoKomoku1;
    }

    public void setTxtTuchishoNo(TextBox txtTuchishoNo) {
        this.setOriginalData("txtTuchishoNo", txtTuchishoNo);
        this.txtTuchishoNo = txtTuchishoNo;
    }

    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.setOriginalData("txtHihokenshaNo", txtHihokenshaNo);
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    public void setTxtShikibetsuCode(TextBox txtShikibetsuCode) {
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    public void setTxtChoteiNendo(TextBox txtChoteiNendo) {
        this.setOriginalData("txtChoteiNendo", txtChoteiNendo);
        this.txtChoteiNendo = txtChoteiNendo;
    }

    public void setTxtChoteiNendoMae(TextBoxDate txtChoteiNendoMae) {
        this.setOriginalData("txtChoteiNendoMae", txtChoteiNendoMae);
        this.txtChoteiNendoMae = txtChoteiNendoMae;
    }

    public void setTxtChoteiNendoAto(TextBoxDate txtChoteiNendoAto) {
        this.setOriginalData("txtChoteiNendoAto", txtChoteiNendoAto);
        this.txtChoteiNendoAto = txtChoteiNendoAto;
    }

    public void setTxtFukaNendo(TextBox txtFukaNendo) {
        this.setOriginalData("txtFukaNendo", txtFukaNendo);
        this.txtFukaNendo = txtFukaNendo;
    }

    public void setTxtFukaNendoMae(TextBoxDate txtFukaNendoMae) {
        this.setOriginalData("txtFukaNendoMae", txtFukaNendoMae);
        this.txtFukaNendoMae = txtFukaNendoMae;
    }

    public void setTxtFukaNendoAto(TextBoxDate txtFukaNendoAto) {
        this.setOriginalData("txtFukaNendoAto", txtFukaNendoAto);
        this.txtFukaNendoAto = txtFukaNendoAto;
    }

    public void setTxtKakuteiHokenryo(TextBox txtKakuteiHokenryo) {
        this.setOriginalData("txtKakuteiHokenryo", txtKakuteiHokenryo);
        this.txtKakuteiHokenryo = txtKakuteiHokenryo;
    }

    public void setTxtKakuteiHokenryoMae(TextBoxNum txtKakuteiHokenryoMae) {
        this.setOriginalData("txtKakuteiHokenryoMae", txtKakuteiHokenryoMae);
        this.txtKakuteiHokenryoMae = txtKakuteiHokenryoMae;
    }

    public void setTxtKakuteiHokenryoAto(TextBoxNum txtKakuteiHokenryoAto) {
        this.setOriginalData("txtKakuteiHokenryoAto", txtKakuteiHokenryoAto);
        this.txtKakuteiHokenryoAto = txtKakuteiHokenryoAto;
    }

    public void setTxtNengakuHokenryo(TextBox txtNengakuHokenryo) {
        this.setOriginalData("txtNengakuHokenryo", txtNengakuHokenryo);
        this.txtNengakuHokenryo = txtNengakuHokenryo;
    }

    public void setTxtNengakuHokenryoMae(TextBoxNum txtNengakuHokenryoMae) {
        this.setOriginalData("txtNengakuHokenryoMae", txtNengakuHokenryoMae);
        this.txtNengakuHokenryoMae = txtNengakuHokenryoMae;
    }

    public void setTxtNengakuHokenryoAto(TextBoxNum txtNengakuHokenryoAto) {
        this.setOriginalData("txtNengakuHokenryoAto", txtNengakuHokenryoAto);
        this.txtNengakuHokenryoAto = txtNengakuHokenryoAto;
    }

    public void setTxtGenmenGaku(TextBox txtGenmenGaku) {
        this.setOriginalData("txtGenmenGaku", txtGenmenGaku);
        this.txtGenmenGaku = txtGenmenGaku;
    }

    public void setTxtGenmenGakuMae(TextBoxNum txtGenmenGakuMae) {
        this.setOriginalData("txtGenmenGakuMae", txtGenmenGakuMae);
        this.txtGenmenGakuMae = txtGenmenGakuMae;
    }

    public void setTxtGenmenGakuAto(TextBoxNum txtGenmenGakuAto) {
        this.setOriginalData("txtGenmenGakuAto", txtGenmenGakuAto);
        this.txtGenmenGakuAto = txtGenmenGakuAto;
    }

    public void setTxtShotokuDankai(TextBox txtShotokuDankai) {
        this.setOriginalData("txtShotokuDankai", txtShotokuDankai);
        this.txtShotokuDankai = txtShotokuDankai;
    }

    public void setTxtShotokuDankaiMae(TextBox txtShotokuDankaiMae) {
        this.setOriginalData("txtShotokuDankaiMae", txtShotokuDankaiMae);
        this.txtShotokuDankaiMae = txtShotokuDankaiMae;
    }

    public void setTxtShotokuDankaiAto(TextBox txtShotokuDankaiAto) {
        this.setOriginalData("txtShotokuDankaiAto", txtShotokuDankaiAto);
        this.txtShotokuDankaiAto = txtShotokuDankaiAto;
    }

    public void setTxtKanendoGaku(TextBoxNum txtKanendoGaku) {
        this.setOriginalData("txtKanendoGaku", txtKanendoGaku);
        this.txtKanendoGaku = txtKanendoGaku;
    }

    public void setTxtKanendoNokiGen(TextBoxDate txtKanendoNokiGen) {
        this.setOriginalData("txtKanendoNokiGen", txtKanendoNokiGen);
        this.txtKanendoNokiGen = txtKanendoNokiGen;
    }

    // </editor-fold>
}
