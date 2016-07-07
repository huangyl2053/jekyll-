package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gengakuinfo.GengakuInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TainoNendo のクラスファイル 
 * 
 * @author 自動生成
 */
public class TainoNendoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHanteiKijunYMD")
    private TextBoxDate txtHanteiKijunYMD;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;
    @JsonProperty("dgGenGaku")
    private DataGrid<dgGenGaku_Row> dgGenGaku;
    @JsonProperty("GenGakuKeisan")
    private GenGakuKeisanDiv GenGakuKeisan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHanteiKijunYMD
     * @return txtHanteiKijunYMD
     */
    @JsonProperty("txtHanteiKijunYMD")
    public TextBoxDate getTxtHanteiKijunYMD() {
        return txtHanteiKijunYMD;
    }

    /*
     * settxtHanteiKijunYMD
     * @param txtHanteiKijunYMD txtHanteiKijunYMD
     */
    @JsonProperty("txtHanteiKijunYMD")
    public void setTxtHanteiKijunYMD(TextBoxDate txtHanteiKijunYMD) {
        this.txtHanteiKijunYMD = txtHanteiKijunYMD;
    }

    /*
     * getbtnKensaku
     * @return btnKensaku
     */
    @JsonProperty("btnKensaku")
    public Button getBtnKensaku() {
        return btnKensaku;
    }

    /*
     * setbtnKensaku
     * @param btnKensaku btnKensaku
     */
    @JsonProperty("btnKensaku")
    public void setBtnKensaku(Button btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    /*
     * getdgGenGaku
     * @return dgGenGaku
     */
    @JsonProperty("dgGenGaku")
    public DataGrid<dgGenGaku_Row> getDgGenGaku() {
        return dgGenGaku;
    }

    /*
     * setdgGenGaku
     * @param dgGenGaku dgGenGaku
     */
    @JsonProperty("dgGenGaku")
    public void setDgGenGaku(DataGrid<dgGenGaku_Row> dgGenGaku) {
        this.dgGenGaku = dgGenGaku;
    }

    /*
     * getGenGakuKeisan
     * @return GenGakuKeisan
     */
    @JsonProperty("GenGakuKeisan")
    public GenGakuKeisanDiv getGenGakuKeisan() {
        return GenGakuKeisan;
    }

    /*
     * setGenGakuKeisan
     * @param GenGakuKeisan GenGakuKeisan
     */
    @JsonProperty("GenGakuKeisan")
    public void setGenGakuKeisan(GenGakuKeisanDiv GenGakuKeisan) {
        this.GenGakuKeisan = GenGakuKeisan;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ChoshuKenKeimetsuKikan1Div getChoshuKenKeimetsuKikan1() {
        return this.getGenGakuKeisan().getChoshuKenKeimetsuKikan1();
    }

    @JsonIgnore
    public void  setChoshuKenKeimetsuKikan1(ChoshuKenKeimetsuKikan1Div ChoshuKenKeimetsuKikan1) {
        this.getGenGakuKeisan().setChoshuKenKeimetsuKikan1(ChoshuKenKeimetsuKikan1);
    }

    @JsonIgnore
    public Label getLblChoShushometsu1() {
        return this.getGenGakuKeisan().getChoshuKenKeimetsuKikan1().getLblChoShushometsu1();
    }

    @JsonIgnore
    public void  setLblChoShushometsu1(Label lblChoShushometsu1) {
        this.getGenGakuKeisan().getChoshuKenKeimetsuKikan1().setLblChoShushometsu1(lblChoShushometsu1);
    }

    @JsonIgnore
    public TextBoxNum getTxtChoShushometsu1() {
        return this.getGenGakuKeisan().getChoshuKenKeimetsuKikan1().getTxtChoShushometsu1();
    }

    @JsonIgnore
    public void  setTxtChoShushometsu1(TextBoxNum txtChoShushometsu1) {
        this.getGenGakuKeisan().getChoshuKenKeimetsuKikan1().setTxtChoShushometsu1(txtChoShushometsu1);
    }

    @JsonIgnore
    public KakesanDiv getKakesan() {
        return this.getGenGakuKeisan().getChoshuKenKeimetsuKikan1().getKakesan();
    }

    @JsonIgnore
    public void  setKakesan(KakesanDiv Kakesan) {
        this.getGenGakuKeisan().getChoshuKenKeimetsuKikan1().setKakesan(Kakesan);
    }

    @JsonIgnore
    public Label getLblKakesan() {
        return this.getGenGakuKeisan().getChoshuKenKeimetsuKikan1().getKakesan().getLblKakesan();
    }

    @JsonIgnore
    public void  setLblKakesan(Label lblKakesan) {
        this.getGenGakuKeisan().getChoshuKenKeimetsuKikan1().getKakesan().setLblKakesan(lblKakesan);
    }

    @JsonIgnore
    public ChoshuKenKeimetsuKikan2Div getChoshuKenKeimetsuKikan2() {
        return this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2();
    }

    @JsonIgnore
    public void  setChoshuKenKeimetsuKikan2(ChoshuKenKeimetsuKikan2Div ChoshuKenKeimetsuKikan2) {
        this.getGenGakuKeisan().setChoshuKenKeimetsuKikan2(ChoshuKenKeimetsuKikan2);
    }

    @JsonIgnore
    public ChoshuKenKeimetsuKikan3Div getChoshuKenKeimetsuKikan3() {
        return this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan3();
    }

    @JsonIgnore
    public void  setChoshuKenKeimetsuKikan3(ChoshuKenKeimetsuKikan3Div ChoshuKenKeimetsuKikan3) {
        this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().setChoshuKenKeimetsuKikan3(ChoshuKenKeimetsuKikan3);
    }

    @JsonIgnore
    public Label getLblChoShushometsu2() {
        return this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan3().getLblChoShushometsu2();
    }

    @JsonIgnore
    public void  setLblChoShushometsu2(Label lblChoShushometsu2) {
        this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan3().setLblChoShushometsu2(lblChoShushometsu2);
    }

    @JsonIgnore
    public TextBoxNum getTxtChoShushometsu2() {
        return this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan3().getTxtChoShushometsu2();
    }

    @JsonIgnore
    public void  setTxtChoShushometsu2(TextBoxNum txtChoShushometsu2) {
        this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan3().setTxtChoShushometsu2(txtChoShushometsu2);
    }

    @JsonIgnore
    public Label getLblLine() {
        return this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan3().getLblLine();
    }

    @JsonIgnore
    public void  setLblLine(Label lblLine) {
        this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan3().setLblLine(lblLine);
    }

    @JsonIgnore
    public ChoshuKenKeimetsuKikan4Div getChoshuKenKeimetsuKikan4() {
        return this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan4();
    }

    @JsonIgnore
    public void  setChoshuKenKeimetsuKikan4(ChoshuKenKeimetsuKikan4Div ChoshuKenKeimetsuKikan4) {
        this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().setChoshuKenKeimetsuKikan4(ChoshuKenKeimetsuKikan4);
    }

    @JsonIgnore
    public Label getLblChoShushometsu3() {
        return this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan4().getLblChoShushometsu3();
    }

    @JsonIgnore
    public void  setLblChoShushometsu3(Label lblChoShushometsu3) {
        this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan4().setLblChoShushometsu3(lblChoShushometsu3);
    }

    @JsonIgnore
    public TextBoxNum getTxtChoShushometsu3() {
        return this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan4().getTxtChoShushometsu3();
    }

    @JsonIgnore
    public void  setTxtChoShushometsu3(TextBoxNum txtChoShushometsu3) {
        this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getChoshuKenKeimetsuKikan4().setTxtChoShushometsu3(txtChoShushometsu3);
    }

    @JsonIgnore
    public KasanDiv getKasan() {
        return this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getKasan();
    }

    @JsonIgnore
    public void  setKasan(KasanDiv Kasan) {
        this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().setKasan(Kasan);
    }

    @JsonIgnore
    public Label getLblKasan() {
        return this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getKasan().getLblKasan();
    }

    @JsonIgnore
    public void  setLblKasan(Label lblKasan) {
        this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getKasan().setLblKasan(lblKasan);
    }

    @JsonIgnore
    public NofuZumiKikanDiv getNofuZumiKikan() {
        return this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getNofuZumiKikan();
    }

    @JsonIgnore
    public void  setNofuZumiKikan(NofuZumiKikanDiv NofuZumiKikan) {
        this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().setNofuZumiKikan(NofuZumiKikan);
    }

    @JsonIgnore
    public Label getLblNofuZumiKikan() {
        return this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getNofuZumiKikan().getLblNofuZumiKikan();
    }

    @JsonIgnore
    public void  setLblNofuZumiKikan(Label lblNofuZumiKikan) {
        this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getNofuZumiKikan().setLblNofuZumiKikan(lblNofuZumiKikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtNofuZumiKikan() {
        return this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getNofuZumiKikan().getTxtNofuZumiKikan();
    }

    @JsonIgnore
    public void  setTxtNofuZumiKikan(TextBoxNum txtNofuZumiKikan) {
        this.getGenGakuKeisan().getChoshuKenKeimetsuKikan2().getNofuZumiKikan().setTxtNofuZumiKikan(txtNofuZumiKikan);
    }

    @JsonIgnore
    public GnegakuKikanDiv getGnegakuKikan() {
        return this.getGenGakuKeisan().getGnegakuKikan();
    }

    @JsonIgnore
    public void  setGnegakuKikan(GnegakuKikanDiv GnegakuKikan) {
        this.getGenGakuKeisan().setGnegakuKikan(GnegakuKikan);
    }

    @JsonIgnore
    public Label getLblKeisanShiki() {
        return this.getGenGakuKeisan().getGnegakuKikan().getLblKeisanShiki();
    }

    @JsonIgnore
    public void  setLblKeisanShiki(Label lblKeisanShiki) {
        this.getGenGakuKeisan().getGnegakuKikan().setLblKeisanShiki(lblKeisanShiki);
    }

    @JsonIgnore
    public GenGakuKikan2Div getGenGakuKikan2() {
        return this.getGenGakuKeisan().getGnegakuKikan().getGenGakuKikan2();
    }

    @JsonIgnore
    public void  setGenGakuKikan2(GenGakuKikan2Div GenGakuKikan2) {
        this.getGenGakuKeisan().getGnegakuKikan().setGenGakuKikan2(GenGakuKikan2);
    }

    @JsonIgnore
    public Label getLblGenGakuKikan() {
        return this.getGenGakuKeisan().getGnegakuKikan().getGenGakuKikan2().getLblGenGakuKikan();
    }

    @JsonIgnore
    public void  setLblGenGakuKikan(Label lblGenGakuKikan) {
        this.getGenGakuKeisan().getGnegakuKikan().getGenGakuKikan2().setLblGenGakuKikan(lblGenGakuKikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtGenGakuKikan() {
        return this.getGenGakuKeisan().getGnegakuKikan().getGenGakuKikan2().getTxtGenGakuKikan();
    }

    @JsonIgnore
    public void  setTxtGenGakuKikan(TextBoxNum txtGenGakuKikan) {
        this.getGenGakuKeisan().getGnegakuKikan().getGenGakuKikan2().setTxtGenGakuKikan(txtGenGakuKikan);
    }

    // </editor-fold>
}
