package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320005;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kiwarigaku.Kiwarigaku.IKiwarigakuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HonSantei1 のクラスファイル
 *
 * @author 自動生成
 */
public class HonSantei1Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendoHon1")
    private TextBoxFlexibleYear txtChoteiNendoHon1;
    @JsonProperty("txtFukaNendoHon1")
    private TextBoxFlexibleYear txtFukaNendoHon1;
    @JsonProperty("txtTsuchiNoHon1")
    private TextBox txtTsuchiNoHon1;
    @JsonProperty("txtKoseiYMDHon1")
    private TextBox txtKoseiYMDHon1;
    @JsonProperty("txtKoseiTimeHon1")
    private TextBoxTime txtKoseiTimeHon1;
    @JsonProperty("txtKoseiYMHon1")
    private TextBox txtKoseiYMHon1;
    @JsonProperty("txtShimeiHon1")
    private TextBox txtShimeiHon1;
    @JsonProperty("tblChoteiJiyuHon1")
    private tblChoteiJiyuHon1Div tblChoteiJiyuHon1;
    @JsonProperty("FukakijunHon1")
    private FukakijunHon1Div FukakijunHon1;
    @JsonProperty("HokenryoHon1")
    private HokenryoHon1Div HokenryoHon1;
    @JsonProperty("KibetsugakuHon1")
    private KibetsugakuHon1Div KibetsugakuHon1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChoteiNendoHon1
     * @return txtChoteiNendoHon1
     */
    @JsonProperty("txtChoteiNendoHon1")
    public TextBoxFlexibleYear getTxtChoteiNendoHon1() {
        return txtChoteiNendoHon1;
    }

    /*
     * settxtChoteiNendoHon1
     * @param txtChoteiNendoHon1 txtChoteiNendoHon1
     */
    @JsonProperty("txtChoteiNendoHon1")
    public void setTxtChoteiNendoHon1(TextBoxFlexibleYear txtChoteiNendoHon1) {
        this.txtChoteiNendoHon1 = txtChoteiNendoHon1;
    }

    /*
     * gettxtFukaNendoHon1
     * @return txtFukaNendoHon1
     */
    @JsonProperty("txtFukaNendoHon1")
    public TextBoxFlexibleYear getTxtFukaNendoHon1() {
        return txtFukaNendoHon1;
    }

    /*
     * settxtFukaNendoHon1
     * @param txtFukaNendoHon1 txtFukaNendoHon1
     */
    @JsonProperty("txtFukaNendoHon1")
    public void setTxtFukaNendoHon1(TextBoxFlexibleYear txtFukaNendoHon1) {
        this.txtFukaNendoHon1 = txtFukaNendoHon1;
    }

    /*
     * gettxtTsuchiNoHon1
     * @return txtTsuchiNoHon1
     */
    @JsonProperty("txtTsuchiNoHon1")
    public TextBox getTxtTsuchiNoHon1() {
        return txtTsuchiNoHon1;
    }

    /*
     * settxtTsuchiNoHon1
     * @param txtTsuchiNoHon1 txtTsuchiNoHon1
     */
    @JsonProperty("txtTsuchiNoHon1")
    public void setTxtTsuchiNoHon1(TextBox txtTsuchiNoHon1) {
        this.txtTsuchiNoHon1 = txtTsuchiNoHon1;
    }

    /*
     * gettxtKoseiYMDHon1
     * @return txtKoseiYMDHon1
     */
    @JsonProperty("txtKoseiYMDHon1")
    public TextBox getTxtKoseiYMDHon1() {
        return txtKoseiYMDHon1;
    }

    /*
     * settxtKoseiYMDHon1
     * @param txtKoseiYMDHon1 txtKoseiYMDHon1
     */
    @JsonProperty("txtKoseiYMDHon1")
    public void setTxtKoseiYMDHon1(TextBox txtKoseiYMDHon1) {
        this.txtKoseiYMDHon1 = txtKoseiYMDHon1;
    }

    /*
     * gettxtKoseiTimeHon1
     * @return txtKoseiTimeHon1
     */
    @JsonProperty("txtKoseiTimeHon1")
    public TextBoxTime getTxtKoseiTimeHon1() {
        return txtKoseiTimeHon1;
    }

    /*
     * settxtKoseiTimeHon1
     * @param txtKoseiTimeHon1 txtKoseiTimeHon1
     */
    @JsonProperty("txtKoseiTimeHon1")
    public void setTxtKoseiTimeHon1(TextBoxTime txtKoseiTimeHon1) {
        this.txtKoseiTimeHon1 = txtKoseiTimeHon1;
    }

    /*
     * gettxtKoseiYMHon1
     * @return txtKoseiYMHon1
     */
    @JsonProperty("txtKoseiYMHon1")
    public TextBox getTxtKoseiYMHon1() {
        return txtKoseiYMHon1;
    }

    /*
     * settxtKoseiYMHon1
     * @param txtKoseiYMHon1 txtKoseiYMHon1
     */
    @JsonProperty("txtKoseiYMHon1")
    public void setTxtKoseiYMHon1(TextBox txtKoseiYMHon1) {
        this.txtKoseiYMHon1 = txtKoseiYMHon1;
    }

    /*
     * gettxtShimeiHon1
     * @return txtShimeiHon1
     */
    @JsonProperty("txtShimeiHon1")
    public TextBox getTxtShimeiHon1() {
        return txtShimeiHon1;
    }

    /*
     * settxtShimeiHon1
     * @param txtShimeiHon1 txtShimeiHon1
     */
    @JsonProperty("txtShimeiHon1")
    public void setTxtShimeiHon1(TextBox txtShimeiHon1) {
        this.txtShimeiHon1 = txtShimeiHon1;
    }

    /*
     * gettblChoteiJiyuHon1
     * @return tblChoteiJiyuHon1
     */
    @JsonProperty("tblChoteiJiyuHon1")
    public tblChoteiJiyuHon1Div getTblChoteiJiyuHon1() {
        return tblChoteiJiyuHon1;
    }

    /*
     * settblChoteiJiyuHon1
     * @param tblChoteiJiyuHon1 tblChoteiJiyuHon1
     */
    @JsonProperty("tblChoteiJiyuHon1")
    public void setTblChoteiJiyuHon1(tblChoteiJiyuHon1Div tblChoteiJiyuHon1) {
        this.tblChoteiJiyuHon1 = tblChoteiJiyuHon1;
    }

    /*
     * getFukakijunHon1
     * @return FukakijunHon1
     */
    @JsonProperty("FukakijunHon1")
    public FukakijunHon1Div getFukakijunHon1() {
        return FukakijunHon1;
    }

    /*
     * setFukakijunHon1
     * @param FukakijunHon1 FukakijunHon1
     */
    @JsonProperty("FukakijunHon1")
    public void setFukakijunHon1(FukakijunHon1Div FukakijunHon1) {
        this.FukakijunHon1 = FukakijunHon1;
    }

    /*
     * getHokenryoHon1
     * @return HokenryoHon1
     */
    @JsonProperty("HokenryoHon1")
    public HokenryoHon1Div getHokenryoHon1() {
        return HokenryoHon1;
    }

    /*
     * setHokenryoHon1
     * @param HokenryoHon1 HokenryoHon1
     */
    @JsonProperty("HokenryoHon1")
    public void setHokenryoHon1(HokenryoHon1Div HokenryoHon1) {
        this.HokenryoHon1 = HokenryoHon1;
    }

    /*
     * getKibetsugakuHon1
     * @return KibetsugakuHon1
     */
    @JsonProperty("KibetsugakuHon1")
    public KibetsugakuHon1Div getKibetsugakuHon1() {
        return KibetsugakuHon1;
    }

    /*
     * setKibetsugakuHon1
     * @param KibetsugakuHon1 KibetsugakuHon1
     */
    @JsonProperty("KibetsugakuHon1")
    public void setKibetsugakuHon1(KibetsugakuHon1Div KibetsugakuHon1) {
        this.KibetsugakuHon1 = KibetsugakuHon1;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblChoteiJiyuHon1() {
        return this.getTblChoteiJiyuHon1().getLblChoteiJiyuHon1();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuHon11() {
        return this.getTblChoteiJiyuHon1().getTxtChoteiJiyuHon11();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuHon12() {
        return this.getTblChoteiJiyuHon1().getTxtChoteiJiyuHon12();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuHon13() {
        return this.getTblChoteiJiyuHon1().getTxtChoteiJiyuHon13();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuHon14() {
        return this.getTblChoteiJiyuHon1().getTxtChoteiJiyuHon14();
    }

    @JsonIgnore
    public Label getLblShikakushutokuYMDHon1() {
        return this.getFukakijunHon1().getLblShikakushutokuYMDHon1();
    }

    @JsonIgnore
    public void setLblShikakushutokuYMDHon1(Label lblShikakushutokuYMDHon1) {
        this.getFukakijunHon1().setLblShikakushutokuYMDHon1(lblShikakushutokuYMDHon1);
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuShutokuYMDHon1() {
        return this.getFukakijunHon1().getTxtShikakuShutokuYMDHon1();
    }

    @JsonIgnore
    public void setTxtShikakuShutokuYMDHon1(TextBoxDate txtShikakuShutokuYMDHon1) {
        this.getFukakijunHon1().setTxtShikakuShutokuYMDHon1(txtShikakuShutokuYMDHon1);
    }

    @JsonIgnore
    public Label getLblShikakusoshitsuYMDHon1() {
        return this.getFukakijunHon1().getLblShikakusoshitsuYMDHon1();
    }

    @JsonIgnore
    public void setLblShikakusoshitsuYMDHon1(Label lblShikakusoshitsuYMDHon1) {
        this.getFukakijunHon1().setLblShikakusoshitsuYMDHon1(lblShikakusoshitsuYMDHon1);
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakusoshitsuYMDHon1() {
        return this.getFukakijunHon1().getTxtShikakusoshitsuYMDHon1();
    }

    @JsonIgnore
    public void setTxtShikakusoshitsuYMDHon1(TextBoxDate txtShikakusoshitsuYMDHon1) {
        this.getFukakijunHon1().setTxtShikakusoshitsuYMDHon1(txtShikakusoshitsuYMDHon1);
    }

    @JsonIgnore
    public Label getLblGoukeiShotokuHon1() {
        return this.getFukakijunHon1().getLblGoukeiShotokuHon1();
    }

    @JsonIgnore
    public void setLblGoukeiShotokuHon1(Label lblGoukeiShotokuHon1) {
        this.getFukakijunHon1().setLblGoukeiShotokuHon1(lblGoukeiShotokuHon1);
    }

    @JsonIgnore
    public TextBoxNum getTxtGoukeiShotokuHon1() {
        return this.getFukakijunHon1().getTxtGoukeiShotokuHon1();
    }

    @JsonIgnore
    public void setTxtGoukeiShotokuHon1(TextBoxNum txtGoukeiShotokuHon1) {
        this.getFukakijunHon1().setTxtGoukeiShotokuHon1(txtGoukeiShotokuHon1);
    }

    @JsonIgnore
    public Label getLblNenkinShunyuHon1() {
        return this.getFukakijunHon1().getLblNenkinShunyuHon1();
    }

    @JsonIgnore
    public void setLblNenkinShunyuHon1(Label lblNenkinShunyuHon1) {
        this.getFukakijunHon1().setLblNenkinShunyuHon1(lblNenkinShunyuHon1);
    }

    @JsonIgnore
    public TextBoxNum getTxtNenkinShunyuHon1() {
        return this.getFukakijunHon1().getTxtNenkinShunyuHon1();
    }

    @JsonIgnore
    public void setTxtNenkinShunyuHon1(TextBoxNum txtNenkinShunyuHon1) {
        this.getFukakijunHon1().setTxtNenkinShunyuHon1(txtNenkinShunyuHon1);
    }

    @JsonIgnore
    public Label getLblHonninKazeiHon1() {
        return this.getFukakijunHon1().getLblHonninKazeiHon1();
    }

    @JsonIgnore
    public void setLblHonninKazeiHon1(Label lblHonninKazeiHon1) {
        this.getFukakijunHon1().setLblHonninKazeiHon1(lblHonninKazeiHon1);
    }

    @JsonIgnore
    public TextBox getTxtHonninKazeiHon1() {
        return this.getFukakijunHon1().getTxtHonninKazeiHon1();
    }

    @JsonIgnore
    public void setTxtHonninKazeiHon1(TextBox txtHonninKazeiHon1) {
        this.getFukakijunHon1().setTxtHonninKazeiHon1(txtHonninKazeiHon1);
    }

    @JsonIgnore
    public Label getLblSetaiKazeiHon1() {
        return this.getFukakijunHon1().getLblSetaiKazeiHon1();
    }

    @JsonIgnore
    public void setLblSetaiKazeiHon1(Label lblSetaiKazeiHon1) {
        this.getFukakijunHon1().setLblSetaiKazeiHon1(lblSetaiKazeiHon1);
    }

    @JsonIgnore
    public TextBox getTxtSetaiKazeiHon1() {
        return this.getFukakijunHon1().getTxtSetaiKazeiHon1();
    }

    @JsonIgnore
    public void setTxtSetaiKazeiHon1(TextBox txtSetaiKazeiHon1) {
        this.getFukakijunHon1().setTxtSetaiKazeiHon1(txtSetaiKazeiHon1);
    }

    @JsonIgnore
    public Label getLblSetaiinSuHon1() {
        return this.getFukakijunHon1().getLblSetaiinSuHon1();
    }

    @JsonIgnore
    public void setLblSetaiinSuHon1(Label lblSetaiinSuHon1) {
        this.getFukakijunHon1().setLblSetaiinSuHon1(lblSetaiinSuHon1);
    }

    @JsonIgnore
    public TextBox getTxtSetaiinSuHon1() {
        return this.getFukakijunHon1().getTxtSetaiinSuHon1();
    }

    @JsonIgnore
    public void setTxtSetaiinSuHon1(TextBox txtSetaiinSuHon1) {
        this.getFukakijunHon1().setTxtSetaiinSuHon1(txtSetaiinSuHon1);
    }

    @JsonIgnore
    public Label getLblKeisanHokenryogakuHon1() {
        return this.getHokenryoHon1().getLblKeisanHokenryogakuHon1();
    }

    @JsonIgnore
    public void setLblKeisanHokenryogakuHon1(Label lblKeisanHokenryogakuHon1) {
        this.getHokenryoHon1().setLblKeisanHokenryogakuHon1(lblKeisanHokenryogakuHon1);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeisanHokenryogakuHon1() {
        return this.getHokenryoHon1().getTxtKeisanHokenryogakuHon1();
    }

    @JsonIgnore
    public void setTxtKeisanHokenryogakuHon1(TextBoxNum txtKeisanHokenryogakuHon1) {
        this.getHokenryoHon1().setTxtKeisanHokenryogakuHon1(txtKeisanHokenryogakuHon1);
    }

    @JsonIgnore
    public Label getLblGemmenGakuHon1() {
        return this.getHokenryoHon1().getLblGemmenGakuHon1();
    }

    @JsonIgnore
    public void setLblGemmenGakuHon1(Label lblGemmenGakuHon1) {
        this.getHokenryoHon1().setLblGemmenGakuHon1(lblGemmenGakuHon1);
    }

    @JsonIgnore
    public TextBoxNum getTxtGemmenGakuHon1() {
        return this.getHokenryoHon1().getTxtGemmenGakuHon1();
    }

    @JsonIgnore
    public void setTxtGemmenGakuHon1(TextBoxNum txtGemmenGakuHon1) {
        this.getHokenryoHon1().setTxtGemmenGakuHon1(txtGemmenGakuHon1);
    }

    @JsonIgnore
    public Label getLblKakuteiHokenryoHon1() {
        return this.getHokenryoHon1().getLblKakuteiHokenryoHon1();
    }

    @JsonIgnore
    public void setLblKakuteiHokenryoHon1(Label lblKakuteiHokenryoHon1) {
        this.getHokenryoHon1().setLblKakuteiHokenryoHon1(lblKakuteiHokenryoHon1);
    }

    @JsonIgnore
    public TextBoxNum getTxtKakuteiHokenryoHon1() {
        return this.getHokenryoHon1().getTxtKakuteiHokenryoHon1();
    }

    @JsonIgnore
    public void setTxtKakuteiHokenryoHon1(TextBoxNum txtKakuteiHokenryoHon1) {
        this.getHokenryoHon1().setTxtKakuteiHokenryoHon1(txtKakuteiHokenryoHon1);
    }

    @JsonIgnore
    public Label getLblHokenryoDankaiHon1() {
        return this.getHokenryoHon1().getLblHokenryoDankaiHon1();
    }

    @JsonIgnore
    public void setLblHokenryoDankaiHon1(Label lblHokenryoDankaiHon1) {
        this.getHokenryoHon1().setLblHokenryoDankaiHon1(lblHokenryoDankaiHon1);
    }

    @JsonIgnore
    public TextBox getTxtHokenryoDankaiHon1() {
        return this.getHokenryoHon1().getTxtHokenryoDankaiHon1();
    }

    @JsonIgnore
    public void setTxtHokenryoDankaiHon1(TextBox txtHokenryoDankaiHon1) {
        this.getHokenryoHon1().setTxtHokenryoDankaiHon1(txtHokenryoDankaiHon1);
    }

    @JsonIgnore
    public Label getLblKyokaisoHon1() {
        return this.getHokenryoHon1().getLblKyokaisoHon1();
    }

    @JsonIgnore
    public void setLblKyokaisoHon1(Label lblKyokaisoHon1) {
        this.getHokenryoHon1().setLblKyokaisoHon1(lblKyokaisoHon1);
    }

    @JsonIgnore
    public TextBox getTxtKyokaisoHon1() {
        return this.getHokenryoHon1().getTxtKyokaisoHon1();
    }

    @JsonIgnore
    public void setTxtKyokaisoHon1(TextBox txtKyokaisoHon1) {
        this.getHokenryoHon1().setTxtKyokaisoHon1(txtKyokaisoHon1);
    }

    @JsonIgnore
    public IKiwarigakuDiv getCcdKiwarigakuHon1() {
        return this.getKibetsugakuHon1().getCcdKiwarigakuHon1();
    }

    // </editor-fold>
}
