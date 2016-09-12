package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jul 19 14:59:25 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.ImageDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * dgShotokuShokaiHyoHakko_Row のクラスファイル
 *
 * @reamsid_L DBB-1710-010 xuhao
 */
public class dgShotokuShokaiHyoHakko_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString txtShikibetsuCode;
    private RString txtShimei;
    private RString txtKetsugo01;
    private RString txtShubetsu;
    private RString txtSeibetsu;
    private RString txtKetsugo02;
    private RString txtZokugara;
    private TextBoxFlexibleDate txtSeinenGappi;
    private RString txtKetsugo03;
    private RString txtTennyuTodokedeBi;
    private RString txtTennyumaeJusho;
    private RString txtTennyumaeJusho2;
    private RString txtKetsugo04;
    private RString txtTenshutsubi1;
    private TextBoxFlexibleDate txtTenshutsubi2;
    private RString txtKetsugo05x;
    private RString txtTenshutsusakiJusho;
    private RString txtTenshutsusakiJusho2;
    private RString txtKetsugo05;
    private RString txtGenJusho;
    private RString txtSoYubinNo;
    private RString txtSofusaki01;
    private RString txtSofusaki02;
    private RString txtSofusaki03;
    private RString txtSofusakiOnchu;
    private RString txtSofusakisama;
    private ImageDialog btnMemo;
    private RString txtMemoShikibetsuKbn;
    private RString txtMemoShikibetsuTaishoCode;

    public dgShotokuShokaiHyoHakko_Row() {
        super();
        this.txtShikibetsuCode = RString.EMPTY;
        this.txtShimei = RString.EMPTY;
        this.txtKetsugo01 = RString.EMPTY;
        this.txtShubetsu = RString.EMPTY;
        this.txtSeibetsu = RString.EMPTY;
        this.txtKetsugo02 = RString.EMPTY;
        this.txtZokugara = RString.EMPTY;
        this.txtSeinenGappi = new TextBoxFlexibleDate();
        this.txtKetsugo03 = RString.EMPTY;
        this.txtTennyuTodokedeBi = RString.EMPTY;
        this.txtTennyumaeJusho = RString.EMPTY;
        this.txtTennyumaeJusho2 = RString.EMPTY;
        this.txtKetsugo04 = RString.EMPTY;
        this.txtTenshutsubi1 = RString.EMPTY;
        this.txtTenshutsubi2 = new TextBoxFlexibleDate();
        this.txtKetsugo05x = RString.EMPTY;
        this.txtTenshutsusakiJusho = RString.EMPTY;
        this.txtTenshutsusakiJusho2 = RString.EMPTY;
        this.txtKetsugo05 = RString.EMPTY;
        this.txtGenJusho = RString.EMPTY;
        this.txtSoYubinNo = RString.EMPTY;
        this.txtSofusaki01 = RString.EMPTY;
        this.txtSofusaki02 = RString.EMPTY;
        this.txtSofusaki03 = RString.EMPTY;
        this.txtSofusakiOnchu = RString.EMPTY;
        this.txtSofusakisama = RString.EMPTY;
        this.btnMemo = new ImageDialog();
        this.txtMemoShikibetsuKbn = RString.EMPTY;
        this.txtMemoShikibetsuTaishoCode = RString.EMPTY;
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.setOriginalData("txtShimei", txtShimei);
        this.setOriginalData("txtKetsugo01", txtKetsugo01);
        this.setOriginalData("txtShubetsu", txtShubetsu);
        this.setOriginalData("txtSeibetsu", txtSeibetsu);
        this.setOriginalData("txtKetsugo02", txtKetsugo02);
        this.setOriginalData("txtZokugara", txtZokugara);
        this.setOriginalData("txtSeinenGappi", txtSeinenGappi);
        this.setOriginalData("txtKetsugo03", txtKetsugo03);
        this.setOriginalData("txtTennyuTodokedeBi", txtTennyuTodokedeBi);
        this.setOriginalData("txtTennyumaeJusho", txtTennyumaeJusho);
        this.setOriginalData("txtTennyumaeJusho2", txtTennyumaeJusho2);
        this.setOriginalData("txtKetsugo04", txtKetsugo04);
        this.setOriginalData("txtTenshutsubi1", txtTenshutsubi1);
        this.setOriginalData("txtTenshutsubi2", txtTenshutsubi2);
        this.setOriginalData("txtKetsugo05x", txtKetsugo05x);
        this.setOriginalData("txtTenshutsusakiJusho", txtTenshutsusakiJusho);
        this.setOriginalData("txtTenshutsusakiJusho2", txtTenshutsusakiJusho2);
        this.setOriginalData("txtKetsugo05", txtKetsugo05);
        this.setOriginalData("txtGenJusho", txtGenJusho);
        this.setOriginalData("txtSoYubinNo", txtSoYubinNo);
        this.setOriginalData("txtSofusaki01", txtSofusaki01);
        this.setOriginalData("txtSofusaki02", txtSofusaki02);
        this.setOriginalData("txtSofusaki03", txtSofusaki03);
        this.setOriginalData("txtSofusakiOnchu", txtSofusakiOnchu);
        this.setOriginalData("txtSofusakisama", txtSofusakisama);
        this.setOriginalData("btnMemo", btnMemo);
        this.setOriginalData("txtMemoShikibetsuKbn", txtMemoShikibetsuKbn);
        this.setOriginalData("txtMemoShikibetsuTaishoCode", txtMemoShikibetsuTaishoCode);
    }

    public dgShotokuShokaiHyoHakko_Row(RString txtShikibetsuCode, RString txtShimei, RString txtKetsugo01, RString txtShubetsu, RString txtSeibetsu, RString txtKetsugo02, RString txtZokugara, TextBoxFlexibleDate txtSeinenGappi, RString txtKetsugo03, RString txtTennyuTodokedeBi, RString txtTennyumaeJusho, RString txtTennyumaeJusho2, RString txtKetsugo04, RString txtTenshutsubi1, TextBoxFlexibleDate txtTenshutsubi2, RString txtKetsugo05x, RString txtTenshutsusakiJusho, RString txtTenshutsusakiJusho2, RString txtKetsugo05, RString txtGenJusho, RString txtSoYubinNo, RString txtSofusaki01, RString txtSofusaki02, RString txtSofusaki03, RString txtSofusakiOnchu, RString txtSofusakisama, ImageDialog btnMemo, RString txtMemoShikibetsuKbn, RString txtMemoShikibetsuTaishoCode) {
        super();
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.setOriginalData("txtShimei", txtShimei);
        this.setOriginalData("txtKetsugo01", txtKetsugo01);
        this.setOriginalData("txtShubetsu", txtShubetsu);
        this.setOriginalData("txtSeibetsu", txtSeibetsu);
        this.setOriginalData("txtKetsugo02", txtKetsugo02);
        this.setOriginalData("txtZokugara", txtZokugara);
        this.setOriginalData("txtSeinenGappi", txtSeinenGappi);
        this.setOriginalData("txtKetsugo03", txtKetsugo03);
        this.setOriginalData("txtTennyuTodokedeBi", txtTennyuTodokedeBi);
        this.setOriginalData("txtTennyumaeJusho", txtTennyumaeJusho);
        this.setOriginalData("txtTennyumaeJusho2", txtTennyumaeJusho2);
        this.setOriginalData("txtKetsugo04", txtKetsugo04);
        this.setOriginalData("txtTenshutsubi1", txtTenshutsubi1);
        this.setOriginalData("txtTenshutsubi2", txtTenshutsubi2);
        this.setOriginalData("txtKetsugo05x", txtKetsugo05x);
        this.setOriginalData("txtTenshutsusakiJusho", txtTenshutsusakiJusho);
        this.setOriginalData("txtTenshutsusakiJusho2", txtTenshutsusakiJusho2);
        this.setOriginalData("txtKetsugo05", txtKetsugo05);
        this.setOriginalData("txtGenJusho", txtGenJusho);
        this.setOriginalData("txtSoYubinNo", txtSoYubinNo);
        this.setOriginalData("txtSofusaki01", txtSofusaki01);
        this.setOriginalData("txtSofusaki02", txtSofusaki02);
        this.setOriginalData("txtSofusaki03", txtSofusaki03);
        this.setOriginalData("txtSofusakiOnchu", txtSofusakiOnchu);
        this.setOriginalData("txtSofusakisama", txtSofusakisama);
        this.setOriginalData("btnMemo", btnMemo);
        this.setOriginalData("txtMemoShikibetsuKbn", txtMemoShikibetsuKbn);
        this.setOriginalData("txtMemoShikibetsuTaishoCode", txtMemoShikibetsuTaishoCode);
        this.txtShikibetsuCode = txtShikibetsuCode;
        this.txtShimei = txtShimei;
        this.txtKetsugo01 = txtKetsugo01;
        this.txtShubetsu = txtShubetsu;
        this.txtSeibetsu = txtSeibetsu;
        this.txtKetsugo02 = txtKetsugo02;
        this.txtZokugara = txtZokugara;
        this.txtSeinenGappi = txtSeinenGappi;
        this.txtKetsugo03 = txtKetsugo03;
        this.txtTennyuTodokedeBi = txtTennyuTodokedeBi;
        this.txtTennyumaeJusho = txtTennyumaeJusho;
        this.txtTennyumaeJusho2 = txtTennyumaeJusho2;
        this.txtKetsugo04 = txtKetsugo04;
        this.txtTenshutsubi1 = txtTenshutsubi1;
        this.txtTenshutsubi2 = txtTenshutsubi2;
        this.txtKetsugo05x = txtKetsugo05x;
        this.txtTenshutsusakiJusho = txtTenshutsusakiJusho;
        this.txtTenshutsusakiJusho2 = txtTenshutsusakiJusho2;
        this.txtKetsugo05 = txtKetsugo05;
        this.txtGenJusho = txtGenJusho;
        this.txtSoYubinNo = txtSoYubinNo;
        this.txtSofusaki01 = txtSofusaki01;
        this.txtSofusaki02 = txtSofusaki02;
        this.txtSofusaki03 = txtSofusaki03;
        this.txtSofusakiOnchu = txtSofusakiOnchu;
        this.txtSofusakisama = txtSofusakisama;
        this.btnMemo = btnMemo;
        this.txtMemoShikibetsuKbn = txtMemoShikibetsuKbn;
        this.txtMemoShikibetsuTaishoCode = txtMemoShikibetsuTaishoCode;
    }

    public dgShotokuShokaiHyoHakko_Row(DataGridSetting gridSetting) {
        super();
        this.txtShikibetsuCode = RString.EMPTY;
        this.txtShimei = RString.EMPTY;
        this.txtKetsugo01 = RString.EMPTY;
        this.txtShubetsu = RString.EMPTY;
        this.txtSeibetsu = RString.EMPTY;
        this.txtKetsugo02 = RString.EMPTY;
        this.txtZokugara = RString.EMPTY;
        this.txtSeinenGappi = new TextBoxFlexibleDate();
        this.txtKetsugo03 = RString.EMPTY;
        this.txtTennyuTodokedeBi = RString.EMPTY;
        this.txtTennyumaeJusho = RString.EMPTY;
        this.txtTennyumaeJusho2 = RString.EMPTY;
        this.txtKetsugo04 = RString.EMPTY;
        this.txtTenshutsubi1 = RString.EMPTY;
        this.txtTenshutsubi2 = new TextBoxFlexibleDate();
        this.txtKetsugo05x = RString.EMPTY;
        this.txtTenshutsusakiJusho = RString.EMPTY;
        this.txtTenshutsusakiJusho2 = RString.EMPTY;
        this.txtKetsugo05 = RString.EMPTY;
        this.txtGenJusho = RString.EMPTY;
        this.txtSoYubinNo = RString.EMPTY;
        this.txtSofusaki01 = RString.EMPTY;
        this.txtSofusaki02 = RString.EMPTY;
        this.txtSofusaki03 = RString.EMPTY;
        this.txtSofusakiOnchu = RString.EMPTY;
        this.txtSofusakisama = RString.EMPTY;
        this.btnMemo = ImageDialog.createInstance(gridSetting.getColumn("btnMemo").getCellDetails());
        this.txtMemoShikibetsuKbn = RString.EMPTY;
        this.txtMemoShikibetsuTaishoCode = RString.EMPTY;
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.setOriginalData("txtShimei", txtShimei);
        this.setOriginalData("txtKetsugo01", txtKetsugo01);
        this.setOriginalData("txtShubetsu", txtShubetsu);
        this.setOriginalData("txtSeibetsu", txtSeibetsu);
        this.setOriginalData("txtKetsugo02", txtKetsugo02);
        this.setOriginalData("txtZokugara", txtZokugara);
        this.setOriginalData("txtSeinenGappi", txtSeinenGappi);
        this.setOriginalData("txtKetsugo03", txtKetsugo03);
        this.setOriginalData("txtTennyuTodokedeBi", txtTennyuTodokedeBi);
        this.setOriginalData("txtTennyumaeJusho", txtTennyumaeJusho);
        this.setOriginalData("txtTennyumaeJusho2", txtTennyumaeJusho2);
        this.setOriginalData("txtKetsugo04", txtKetsugo04);
        this.setOriginalData("txtTenshutsubi1", txtTenshutsubi1);
        this.setOriginalData("txtTenshutsubi2", txtTenshutsubi2);
        this.setOriginalData("txtKetsugo05x", txtKetsugo05x);
        this.setOriginalData("txtTenshutsusakiJusho", txtTenshutsusakiJusho);
        this.setOriginalData("txtTenshutsusakiJusho2", txtTenshutsusakiJusho2);
        this.setOriginalData("txtKetsugo05", txtKetsugo05);
        this.setOriginalData("txtGenJusho", txtGenJusho);
        this.setOriginalData("txtSoYubinNo", txtSoYubinNo);
        this.setOriginalData("txtSofusaki01", txtSofusaki01);
        this.setOriginalData("txtSofusaki02", txtSofusaki02);
        this.setOriginalData("txtSofusaki03", txtSofusaki03);
        this.setOriginalData("txtSofusakiOnchu", txtSofusakiOnchu);
        this.setOriginalData("txtSofusakisama", txtSofusakisama);
        this.setOriginalData("btnMemo", btnMemo);
        this.setOriginalData("txtMemoShikibetsuKbn", txtMemoShikibetsuKbn);
        this.setOriginalData("txtMemoShikibetsuTaishoCode", txtMemoShikibetsuTaishoCode);
    }

    public RString getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    public RString getTxtShimei() {
        return txtShimei;
    }

    public RString getTxtKetsugo01() {
        return txtKetsugo01;
    }

    public RString getTxtShubetsu() {
        return txtShubetsu;
    }

    public RString getTxtSeibetsu() {
        return txtSeibetsu;
    }

    public RString getTxtKetsugo02() {
        return txtKetsugo02;
    }

    public RString getTxtZokugara() {
        return txtZokugara;
    }

    public TextBoxFlexibleDate getTxtSeinenGappi() {
        return txtSeinenGappi;
    }

    public RString getTxtKetsugo03() {
        return txtKetsugo03;
    }

    public RString getTxtTennyuTodokedeBi() {
        return txtTennyuTodokedeBi;
    }

    public RString getTxtTennyumaeJusho() {
        return txtTennyumaeJusho;
    }

    public RString getTxtTennyumaeJusho2() {
        return txtTennyumaeJusho2;
    }

    public RString getTxtKetsugo04() {
        return txtKetsugo04;
    }

    public RString getTxtTenshutsubi1() {
        return txtTenshutsubi1;
    }

    public TextBoxFlexibleDate getTxtTenshutsubi2() {
        return txtTenshutsubi2;
    }

    public RString getTxtKetsugo05x() {
        return txtKetsugo05x;
    }

    public RString getTxtTenshutsusakiJusho() {
        return txtTenshutsusakiJusho;
    }

    public RString getTxtTenshutsusakiJusho2() {
        return txtTenshutsusakiJusho2;
    }

    public RString getTxtKetsugo05() {
        return txtKetsugo05;
    }

    public RString getTxtGenJusho() {
        return txtGenJusho;
    }

    public RString getTxtSoYubinNo() {
        return txtSoYubinNo;
    }

    public RString getTxtSofusaki01() {
        return txtSofusaki01;
    }

    public RString getTxtSofusaki02() {
        return txtSofusaki02;
    }

    public RString getTxtSofusaki03() {
        return txtSofusaki03;
    }

    public RString getTxtSofusakiOnchu() {
        return txtSofusakiOnchu;
    }

    public RString getTxtSofusakisama() {
        return txtSofusakisama;
    }

    public ImageDialog getBtnMemo() {
        return btnMemo;
    }

    public RString getTxtMemoShikibetsuKbn() {
        return txtMemoShikibetsuKbn;
    }

    public RString getTxtMemoShikibetsuTaishoCode() {
        return txtMemoShikibetsuTaishoCode;
    }

    public void setTxtShikibetsuCode(RString txtShikibetsuCode) {
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    public void setTxtShimei(RString txtShimei) {
        this.setOriginalData("txtShimei", txtShimei);
        this.txtShimei = txtShimei;
    }

    public void setTxtKetsugo01(RString txtKetsugo01) {
        this.setOriginalData("txtKetsugo01", txtKetsugo01);
        this.txtKetsugo01 = txtKetsugo01;
    }

    public void setTxtShubetsu(RString txtShubetsu) {
        this.setOriginalData("txtShubetsu", txtShubetsu);
        this.txtShubetsu = txtShubetsu;
    }

    public void setTxtSeibetsu(RString txtSeibetsu) {
        this.setOriginalData("txtSeibetsu", txtSeibetsu);
        this.txtSeibetsu = txtSeibetsu;
    }

    public void setTxtKetsugo02(RString txtKetsugo02) {
        this.setOriginalData("txtKetsugo02", txtKetsugo02);
        this.txtKetsugo02 = txtKetsugo02;
    }

    public void setTxtZokugara(RString txtZokugara) {
        this.setOriginalData("txtZokugara", txtZokugara);
        this.txtZokugara = txtZokugara;
    }

    public void setTxtSeinenGappi(TextBoxFlexibleDate txtSeinenGappi) {
        this.setOriginalData("txtSeinenGappi", txtSeinenGappi);
        this.txtSeinenGappi = txtSeinenGappi;
    }

    public void setTxtKetsugo03(RString txtKetsugo03) {
        this.setOriginalData("txtKetsugo03", txtKetsugo03);
        this.txtKetsugo03 = txtKetsugo03;
    }

    public void setTxtTennyuTodokedeBi(RString txtTennyuTodokedeBi) {
        this.setOriginalData("txtTennyuTodokedeBi", txtTennyuTodokedeBi);
        this.txtTennyuTodokedeBi = txtTennyuTodokedeBi;
    }

    public void setTxtTennyumaeJusho(RString txtTennyumaeJusho) {
        this.setOriginalData("txtTennyumaeJusho", txtTennyumaeJusho);
        this.txtTennyumaeJusho = txtTennyumaeJusho;
    }

    public void setTxtTennyumaeJusho2(RString txtTennyumaeJusho2) {
        this.setOriginalData("txtTennyumaeJusho2", txtTennyumaeJusho2);
        this.txtTennyumaeJusho2 = txtTennyumaeJusho2;
    }

    public void setTxtKetsugo04(RString txtKetsugo04) {
        this.setOriginalData("txtKetsugo04", txtKetsugo04);
        this.txtKetsugo04 = txtKetsugo04;
    }

    public void setTxtTenshutsubi1(RString txtTenshutsubi1) {
        this.setOriginalData("txtTenshutsubi1", txtTenshutsubi1);
        this.txtTenshutsubi1 = txtTenshutsubi1;
    }

    public void setTxtTenshutsubi2(TextBoxFlexibleDate txtTenshutsubi2) {
        this.setOriginalData("txtTenshutsubi2", txtTenshutsubi2);
        this.txtTenshutsubi2 = txtTenshutsubi2;
    }

    public void setTxtKetsugo05x(RString txtKetsugo05x) {
        this.setOriginalData("txtKetsugo05x", txtKetsugo05x);
        this.txtKetsugo05x = txtKetsugo05x;
    }

    public void setTxtTenshutsusakiJusho(RString txtTenshutsusakiJusho) {
        this.setOriginalData("txtTenshutsusakiJusho", txtTenshutsusakiJusho);
        this.txtTenshutsusakiJusho = txtTenshutsusakiJusho;
    }

    public void setTxtTenshutsusakiJusho2(RString txtTenshutsusakiJusho2) {
        this.setOriginalData("txtTenshutsusakiJusho2", txtTenshutsusakiJusho2);
        this.txtTenshutsusakiJusho2 = txtTenshutsusakiJusho2;
    }

    public void setTxtKetsugo05(RString txtKetsugo05) {
        this.setOriginalData("txtKetsugo05", txtKetsugo05);
        this.txtKetsugo05 = txtKetsugo05;
    }

    public void setTxtGenJusho(RString txtGenJusho) {
        this.setOriginalData("txtGenJusho", txtGenJusho);
        this.txtGenJusho = txtGenJusho;
    }

    public void setTxtSoYubinNo(RString txtSoYubinNo) {
        this.setOriginalData("txtSoYubinNo", txtSoYubinNo);
        this.txtSoYubinNo = txtSoYubinNo;
    }

    public void setTxtSofusaki01(RString txtSofusaki01) {
        this.setOriginalData("txtSofusaki01", txtSofusaki01);
        this.txtSofusaki01 = txtSofusaki01;
    }

    public void setTxtSofusaki02(RString txtSofusaki02) {
        this.setOriginalData("txtSofusaki02", txtSofusaki02);
        this.txtSofusaki02 = txtSofusaki02;
    }

    public void setTxtSofusaki03(RString txtSofusaki03) {
        this.setOriginalData("txtSofusaki03", txtSofusaki03);
        this.txtSofusaki03 = txtSofusaki03;
    }

    public void setTxtSofusakiOnchu(RString txtSofusakiOnchu) {
        this.setOriginalData("txtSofusakiOnchu", txtSofusakiOnchu);
        this.txtSofusakiOnchu = txtSofusakiOnchu;
    }

    public void setTxtSofusakisama(RString txtSofusakisama) {
        this.setOriginalData("txtSofusakisama", txtSofusakisama);
        this.txtSofusakisama = txtSofusakisama;
    }

    public void setBtnMemo(ImageDialog btnMemo) {
        this.setOriginalData("btnMemo", btnMemo);
        this.btnMemo = btnMemo;
    }

    public void setTxtMemoShikibetsuKbn(RString txtMemoShikibetsuKbn) {
        this.setOriginalData("txtMemoShikibetsuKbn", txtMemoShikibetsuKbn);
        this.txtMemoShikibetsuKbn = txtMemoShikibetsuKbn;
    }

    public void setTxtMemoShikibetsuTaishoCode(RString txtMemoShikibetsuTaishoCode) {
        this.setOriginalData("txtMemoShikibetsuTaishoCode", txtMemoShikibetsuTaishoCode);
        this.txtMemoShikibetsuTaishoCode = txtMemoShikibetsuTaishoCode;
    }

    // </editor-fold>
}
