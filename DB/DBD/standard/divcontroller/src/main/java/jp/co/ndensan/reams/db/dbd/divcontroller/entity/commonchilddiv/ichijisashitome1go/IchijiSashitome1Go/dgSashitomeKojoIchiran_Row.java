package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ichijisashitome1go.IchijiSashitome1Go;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Aug 16 12:02:02 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgSashitomeKojoIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSashitomeKojoIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    private Button kaijo;
    private RString sashitome;
    private RString kojo;
    private RString sashitome2;
    private RString seiriNo;
    private TextBoxFlexibleDate txtTeikyoYM;
    private TextBoxFlexibleDate txtSashitomeTorokuYMD;
    private TextBoxFlexibleDate txtSashitomeKaijoYMD;
    private TextBoxFlexibleDate txtNofuKigenYMD;
    private RString sashitomeTsuchi;
    private RString kojoNo;
    private TextBoxFlexibleDate txtKojoTorokuYMD;
    private TextBoxFlexibleDate txtShoTeishutsuKigenYMD;
    private RString kaijoTsuchi;

    public dgSashitomeKojoIchiran_Row() {
        super();
        this.kaijo = new Button();
        this.sashitome = RString.EMPTY;
        this.kojo = RString.EMPTY;
        this.sashitome2 = RString.EMPTY;
        this.seiriNo = RString.EMPTY;
        this.txtTeikyoYM = new TextBoxFlexibleDate();
        this.txtSashitomeTorokuYMD = new TextBoxFlexibleDate();
        this.txtSashitomeKaijoYMD = new TextBoxFlexibleDate();
        this.txtNofuKigenYMD = new TextBoxFlexibleDate();
        this.sashitomeTsuchi = RString.EMPTY;
        this.kojoNo = RString.EMPTY;
        this.txtKojoTorokuYMD = new TextBoxFlexibleDate();
        this.txtShoTeishutsuKigenYMD = new TextBoxFlexibleDate();
        this.kaijoTsuchi = RString.EMPTY;
        this.setOriginalData("kaijo", kaijo);
        this.setOriginalData("sashitome", sashitome);
        this.setOriginalData("kojo", kojo);
        this.setOriginalData("sashitome2", sashitome2);
        this.setOriginalData("seiriNo", seiriNo);
        this.setOriginalData("txtTeikyoYM", txtTeikyoYM);
        this.setOriginalData("txtSashitomeTorokuYMD", txtSashitomeTorokuYMD);
        this.setOriginalData("txtSashitomeKaijoYMD", txtSashitomeKaijoYMD);
        this.setOriginalData("txtNofuKigenYMD", txtNofuKigenYMD);
        this.setOriginalData("sashitomeTsuchi", sashitomeTsuchi);
        this.setOriginalData("kojoNo", kojoNo);
        this.setOriginalData("txtKojoTorokuYMD", txtKojoTorokuYMD);
        this.setOriginalData("txtShoTeishutsuKigenYMD", txtShoTeishutsuKigenYMD);
        this.setOriginalData("kaijoTsuchi", kaijoTsuchi);
    }

    public dgSashitomeKojoIchiran_Row(Button kaijo, RString sashitome, RString kojo, RString sashitome2, RString seiriNo, TextBoxFlexibleDate txtTeikyoYM, TextBoxFlexibleDate txtSashitomeTorokuYMD, TextBoxFlexibleDate txtSashitomeKaijoYMD, TextBoxFlexibleDate txtNofuKigenYMD, RString sashitomeTsuchi, RString kojoNo, TextBoxFlexibleDate txtKojoTorokuYMD, TextBoxFlexibleDate txtShoTeishutsuKigenYMD, RString kaijoTsuchi) {
        super();
        this.setOriginalData("kaijo", kaijo);
        this.setOriginalData("sashitome", sashitome);
        this.setOriginalData("kojo", kojo);
        this.setOriginalData("sashitome2", sashitome2);
        this.setOriginalData("seiriNo", seiriNo);
        this.setOriginalData("txtTeikyoYM", txtTeikyoYM);
        this.setOriginalData("txtSashitomeTorokuYMD", txtSashitomeTorokuYMD);
        this.setOriginalData("txtSashitomeKaijoYMD", txtSashitomeKaijoYMD);
        this.setOriginalData("txtNofuKigenYMD", txtNofuKigenYMD);
        this.setOriginalData("sashitomeTsuchi", sashitomeTsuchi);
        this.setOriginalData("kojoNo", kojoNo);
        this.setOriginalData("txtKojoTorokuYMD", txtKojoTorokuYMD);
        this.setOriginalData("txtShoTeishutsuKigenYMD", txtShoTeishutsuKigenYMD);
        this.setOriginalData("kaijoTsuchi", kaijoTsuchi);
        this.kaijo = kaijo;
        this.sashitome = sashitome;
        this.kojo = kojo;
        this.sashitome2 = sashitome2;
        this.seiriNo = seiriNo;
        this.txtTeikyoYM = txtTeikyoYM;
        this.txtSashitomeTorokuYMD = txtSashitomeTorokuYMD;
        this.txtSashitomeKaijoYMD = txtSashitomeKaijoYMD;
        this.txtNofuKigenYMD = txtNofuKigenYMD;
        this.sashitomeTsuchi = sashitomeTsuchi;
        this.kojoNo = kojoNo;
        this.txtKojoTorokuYMD = txtKojoTorokuYMD;
        this.txtShoTeishutsuKigenYMD = txtShoTeishutsuKigenYMD;
        this.kaijoTsuchi = kaijoTsuchi;
    }

    public Button getKaijo() {
        return kaijo;
    }

    public RString getSashitome() {
        return sashitome;
    }

    public RString getKojo() {
        return kojo;
    }

    public RString getSashitome2() {
        return sashitome2;
    }

    public RString getSeiriNo() {
        return seiriNo;
    }

    public TextBoxFlexibleDate getTxtTeikyoYM() {
        return txtTeikyoYM;
    }

    public TextBoxFlexibleDate getTxtSashitomeTorokuYMD() {
        return txtSashitomeTorokuYMD;
    }

    public TextBoxFlexibleDate getTxtSashitomeKaijoYMD() {
        return txtSashitomeKaijoYMD;
    }

    public TextBoxFlexibleDate getTxtNofuKigenYMD() {
        return txtNofuKigenYMD;
    }

    public RString getSashitomeTsuchi() {
        return sashitomeTsuchi;
    }

    public RString getKojoNo() {
        return kojoNo;
    }

    public TextBoxFlexibleDate getTxtKojoTorokuYMD() {
        return txtKojoTorokuYMD;
    }

    public TextBoxFlexibleDate getTxtShoTeishutsuKigenYMD() {
        return txtShoTeishutsuKigenYMD;
    }

    public RString getKaijoTsuchi() {
        return kaijoTsuchi;
    }

    public void setKaijo(Button kaijo) {
        this.setOriginalData("kaijo", kaijo);
        this.kaijo = kaijo;
    }

    public void setSashitome(RString sashitome) {
        this.setOriginalData("sashitome", sashitome);
        this.sashitome = sashitome;
    }

    public void setKojo(RString kojo) {
        this.setOriginalData("kojo", kojo);
        this.kojo = kojo;
    }

    public void setSashitome2(RString sashitome2) {
        this.setOriginalData("sashitome2", sashitome2);
        this.sashitome2 = sashitome2;
    }

    public void setSeiriNo(RString seiriNo) {
        this.setOriginalData("seiriNo", seiriNo);
        this.seiriNo = seiriNo;
    }

    public void setTxtTeikyoYM(TextBoxFlexibleDate txtTeikyoYM) {
        this.setOriginalData("txtTeikyoYM", txtTeikyoYM);
        this.txtTeikyoYM = txtTeikyoYM;
    }

    public void setTxtSashitomeTorokuYMD(TextBoxFlexibleDate txtSashitomeTorokuYMD) {
        this.setOriginalData("txtSashitomeTorokuYMD", txtSashitomeTorokuYMD);
        this.txtSashitomeTorokuYMD = txtSashitomeTorokuYMD;
    }

    public void setTxtSashitomeKaijoYMD(TextBoxFlexibleDate txtSashitomeKaijoYMD) {
        this.setOriginalData("txtSashitomeKaijoYMD", txtSashitomeKaijoYMD);
        this.txtSashitomeKaijoYMD = txtSashitomeKaijoYMD;
    }

    public void setTxtNofuKigenYMD(TextBoxFlexibleDate txtNofuKigenYMD) {
        this.setOriginalData("txtNofuKigenYMD", txtNofuKigenYMD);
        this.txtNofuKigenYMD = txtNofuKigenYMD;
    }

    public void setSashitomeTsuchi(RString sashitomeTsuchi) {
        this.setOriginalData("sashitomeTsuchi", sashitomeTsuchi);
        this.sashitomeTsuchi = sashitomeTsuchi;
    }

    public void setKojoNo(RString kojoNo) {
        this.setOriginalData("kojoNo", kojoNo);
        this.kojoNo = kojoNo;
    }

    public void setTxtKojoTorokuYMD(TextBoxFlexibleDate txtKojoTorokuYMD) {
        this.setOriginalData("txtKojoTorokuYMD", txtKojoTorokuYMD);
        this.txtKojoTorokuYMD = txtKojoTorokuYMD;
    }

    public void setTxtShoTeishutsuKigenYMD(TextBoxFlexibleDate txtShoTeishutsuKigenYMD) {
        this.setOriginalData("txtShoTeishutsuKigenYMD", txtShoTeishutsuKigenYMD);
        this.txtShoTeishutsuKigenYMD = txtShoTeishutsuKigenYMD;
    }

    public void setKaijoTsuchi(RString kaijoTsuchi) {
        this.setOriginalData("kaijoTsuchi", kaijoTsuchi);
        this.kaijoTsuchi = kaijoTsuchi;
    }

    // </editor-fold>
}
