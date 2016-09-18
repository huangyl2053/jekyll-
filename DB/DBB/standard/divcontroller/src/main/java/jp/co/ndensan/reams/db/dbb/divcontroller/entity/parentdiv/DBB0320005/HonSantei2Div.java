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
 * HonSantei2 のクラスファイル
 *
 * @author 自動生成
 */
public class HonSantei2Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendoHon2")
    private TextBoxFlexibleYear txtChoteiNendoHon2;
    @JsonProperty("txtFukaNendoHon2")
    private TextBoxFlexibleYear txtFukaNendoHon2;
    @JsonProperty("txtTsuchiNoHon2")
    private TextBox txtTsuchiNoHon2;
    @JsonProperty("txtKoseiYMDHon2")
    private TextBox txtKoseiYMDHon2;
    @JsonProperty("txtKoseiTimeHon2")
    private TextBoxTime txtKoseiTimeHon2;
    @JsonProperty("txtKoseiYMHon2")
    private TextBox txtKoseiYMHon2;
    @JsonProperty("txtShimeiHon2")
    private TextBox txtShimeiHon2;
    @JsonProperty("tblChoteiJiyuHon2")
    private tblChoteiJiyuHon2Div tblChoteiJiyuHon2;
    @JsonProperty("FukakijunHon2")
    private FukakijunHon2Div FukakijunHon2;
    @JsonProperty("HokenryoHon2")
    private HokenryoHon2Div HokenryoHon2;
    @JsonProperty("KibetsugakuHon2")
    private KibetsugakuHon2Div KibetsugakuHon2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChoteiNendoHon2
     * @return txtChoteiNendoHon2
     */
    @JsonProperty("txtChoteiNendoHon2")
    public TextBoxFlexibleYear getTxtChoteiNendoHon2() {
        return txtChoteiNendoHon2;
    }

    /*
     * settxtChoteiNendoHon2
     * @param txtChoteiNendoHon2 txtChoteiNendoHon2
     */
    @JsonProperty("txtChoteiNendoHon2")
    public void setTxtChoteiNendoHon2(TextBoxFlexibleYear txtChoteiNendoHon2) {
        this.txtChoteiNendoHon2 = txtChoteiNendoHon2;
    }

    /*
     * gettxtFukaNendoHon2
     * @return txtFukaNendoHon2
     */
    @JsonProperty("txtFukaNendoHon2")
    public TextBoxFlexibleYear getTxtFukaNendoHon2() {
        return txtFukaNendoHon2;
    }

    /*
     * settxtFukaNendoHon2
     * @param txtFukaNendoHon2 txtFukaNendoHon2
     */
    @JsonProperty("txtFukaNendoHon2")
    public void setTxtFukaNendoHon2(TextBoxFlexibleYear txtFukaNendoHon2) {
        this.txtFukaNendoHon2 = txtFukaNendoHon2;
    }

    /*
     * gettxtTsuchiNoHon2
     * @return txtTsuchiNoHon2
     */
    @JsonProperty("txtTsuchiNoHon2")
    public TextBox getTxtTsuchiNoHon2() {
        return txtTsuchiNoHon2;
    }

    /*
     * settxtTsuchiNoHon2
     * @param txtTsuchiNoHon2 txtTsuchiNoHon2
     */
    @JsonProperty("txtTsuchiNoHon2")
    public void setTxtTsuchiNoHon2(TextBox txtTsuchiNoHon2) {
        this.txtTsuchiNoHon2 = txtTsuchiNoHon2;
    }

    /*
     * gettxtKoseiYMDHon2
     * @return txtKoseiYMDHon2
     */
    @JsonProperty("txtKoseiYMDHon2")
    public TextBox getTxtKoseiYMDHon2() {
        return txtKoseiYMDHon2;
    }

    /*
     * settxtKoseiYMDHon2
     * @param txtKoseiYMDHon2 txtKoseiYMDHon2
     */
    @JsonProperty("txtKoseiYMDHon2")
    public void setTxtKoseiYMDHon2(TextBox txtKoseiYMDHon2) {
        this.txtKoseiYMDHon2 = txtKoseiYMDHon2;
    }

    /*
     * gettxtKoseiTimeHon2
     * @return txtKoseiTimeHon2
     */
    @JsonProperty("txtKoseiTimeHon2")
    public TextBoxTime getTxtKoseiTimeHon2() {
        return txtKoseiTimeHon2;
    }

    /*
     * settxtKoseiTimeHon2
     * @param txtKoseiTimeHon2 txtKoseiTimeHon2
     */
    @JsonProperty("txtKoseiTimeHon2")
    public void setTxtKoseiTimeHon2(TextBoxTime txtKoseiTimeHon2) {
        this.txtKoseiTimeHon2 = txtKoseiTimeHon2;
    }

    /*
     * gettxtKoseiYMHon2
     * @return txtKoseiYMHon2
     */
    @JsonProperty("txtKoseiYMHon2")
    public TextBox getTxtKoseiYMHon2() {
        return txtKoseiYMHon2;
    }

    /*
     * settxtKoseiYMHon2
     * @param txtKoseiYMHon2 txtKoseiYMHon2
     */
    @JsonProperty("txtKoseiYMHon2")
    public void setTxtKoseiYMHon2(TextBox txtKoseiYMHon2) {
        this.txtKoseiYMHon2 = txtKoseiYMHon2;
    }

    /*
     * gettxtShimeiHon2
     * @return txtShimeiHon2
     */
    @JsonProperty("txtShimeiHon2")
    public TextBox getTxtShimeiHon2() {
        return txtShimeiHon2;
    }

    /*
     * settxtShimeiHon2
     * @param txtShimeiHon2 txtShimeiHon2
     */
    @JsonProperty("txtShimeiHon2")
    public void setTxtShimeiHon2(TextBox txtShimeiHon2) {
        this.txtShimeiHon2 = txtShimeiHon2;
    }

    /*
     * gettblChoteiJiyuHon2
     * @return tblChoteiJiyuHon2
     */
    @JsonProperty("tblChoteiJiyuHon2")
    public tblChoteiJiyuHon2Div getTblChoteiJiyuHon2() {
        return tblChoteiJiyuHon2;
    }

    /*
     * settblChoteiJiyuHon2
     * @param tblChoteiJiyuHon2 tblChoteiJiyuHon2
     */
    @JsonProperty("tblChoteiJiyuHon2")
    public void setTblChoteiJiyuHon2(tblChoteiJiyuHon2Div tblChoteiJiyuHon2) {
        this.tblChoteiJiyuHon2 = tblChoteiJiyuHon2;
    }

    /*
     * getFukakijunHon2
     * @return FukakijunHon2
     */
    @JsonProperty("FukakijunHon2")
    public FukakijunHon2Div getFukakijunHon2() {
        return FukakijunHon2;
    }

    /*
     * setFukakijunHon2
     * @param FukakijunHon2 FukakijunHon2
     */
    @JsonProperty("FukakijunHon2")
    public void setFukakijunHon2(FukakijunHon2Div FukakijunHon2) {
        this.FukakijunHon2 = FukakijunHon2;
    }

    /*
     * getHokenryoHon2
     * @return HokenryoHon2
     */
    @JsonProperty("HokenryoHon2")
    public HokenryoHon2Div getHokenryoHon2() {
        return HokenryoHon2;
    }

    /*
     * setHokenryoHon2
     * @param HokenryoHon2 HokenryoHon2
     */
    @JsonProperty("HokenryoHon2")
    public void setHokenryoHon2(HokenryoHon2Div HokenryoHon2) {
        this.HokenryoHon2 = HokenryoHon2;
    }

    /*
     * getKibetsugakuHon2
     * @return KibetsugakuHon2
     */
    @JsonProperty("KibetsugakuHon2")
    public KibetsugakuHon2Div getKibetsugakuHon2() {
        return KibetsugakuHon2;
    }

    /*
     * setKibetsugakuHon2
     * @param KibetsugakuHon2 KibetsugakuHon2
     */
    @JsonProperty("KibetsugakuHon2")
    public void setKibetsugakuHon2(KibetsugakuHon2Div KibetsugakuHon2) {
        this.KibetsugakuHon2 = KibetsugakuHon2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblChoteiJiyuHon2() {
        return this.getTblChoteiJiyuHon2().getLblChoteiJiyuHon2();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuHon21() {
        return this.getTblChoteiJiyuHon2().getTxtChoteiJiyuHon21();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuHon22() {
        return this.getTblChoteiJiyuHon2().getTxtChoteiJiyuHon22();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuHon23() {
        return this.getTblChoteiJiyuHon2().getTxtChoteiJiyuHon23();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuHon24() {
        return this.getTblChoteiJiyuHon2().getTxtChoteiJiyuHon24();
    }

    @JsonIgnore
    public Label getLblShikakushutokuYMDHon2() {
        return this.getFukakijunHon2().getLblShikakushutokuYMDHon2();
    }

    @JsonIgnore
    public void setLblShikakushutokuYMDHon2(Label lblShikakushutokuYMDHon2) {
        this.getFukakijunHon2().setLblShikakushutokuYMDHon2(lblShikakushutokuYMDHon2);
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuShutokuYMDHon2() {
        return this.getFukakijunHon2().getTxtShikakuShutokuYMDHon2();
    }

    @JsonIgnore
    public void setTxtShikakuShutokuYMDHon2(TextBoxDate txtShikakuShutokuYMDHon2) {
        this.getFukakijunHon2().setTxtShikakuShutokuYMDHon2(txtShikakuShutokuYMDHon2);
    }

    @JsonIgnore
    public Label getLblShikakusoshitsuYMDHon2() {
        return this.getFukakijunHon2().getLblShikakusoshitsuYMDHon2();
    }

    @JsonIgnore
    public void setLblShikakusoshitsuYMDHon2(Label lblShikakusoshitsuYMDHon2) {
        this.getFukakijunHon2().setLblShikakusoshitsuYMDHon2(lblShikakusoshitsuYMDHon2);
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuSoshitsuYMDHon2() {
        return this.getFukakijunHon2().getTxtShikakuSoshitsuYMDHon2();
    }

    @JsonIgnore
    public void setTxtShikakuSoshitsuYMDHon2(TextBoxDate txtShikakuSoshitsuYMDHon2) {
        this.getFukakijunHon2().setTxtShikakuSoshitsuYMDHon2(txtShikakuSoshitsuYMDHon2);
    }

    @JsonIgnore
    public Label getLblGoukeiShotokuHon2() {
        return this.getFukakijunHon2().getLblGoukeiShotokuHon2();
    }

    @JsonIgnore
    public void setLblGoukeiShotokuHon2(Label lblGoukeiShotokuHon2) {
        this.getFukakijunHon2().setLblGoukeiShotokuHon2(lblGoukeiShotokuHon2);
    }

    @JsonIgnore
    public TextBoxNum getTxtGoukeiShotokuHon2() {
        return this.getFukakijunHon2().getTxtGoukeiShotokuHon2();
    }

    @JsonIgnore
    public void setTxtGoukeiShotokuHon2(TextBoxNum txtGoukeiShotokuHon2) {
        this.getFukakijunHon2().setTxtGoukeiShotokuHon2(txtGoukeiShotokuHon2);
    }

    @JsonIgnore
    public Label getLblNenkinShunyuHon2() {
        return this.getFukakijunHon2().getLblNenkinShunyuHon2();
    }

    @JsonIgnore
    public void setLblNenkinShunyuHon2(Label lblNenkinShunyuHon2) {
        this.getFukakijunHon2().setLblNenkinShunyuHon2(lblNenkinShunyuHon2);
    }

    @JsonIgnore
    public TextBoxNum getTxtNenkinShunyuHon2() {
        return this.getFukakijunHon2().getTxtNenkinShunyuHon2();
    }

    @JsonIgnore
    public void setTxtNenkinShunyuHon2(TextBoxNum txtNenkinShunyuHon2) {
        this.getFukakijunHon2().setTxtNenkinShunyuHon2(txtNenkinShunyuHon2);
    }

    @JsonIgnore
    public Label getLblHonninKazeiHon2() {
        return this.getFukakijunHon2().getLblHonninKazeiHon2();
    }

    @JsonIgnore
    public void setLblHonninKazeiHon2(Label lblHonninKazeiHon2) {
        this.getFukakijunHon2().setLblHonninKazeiHon2(lblHonninKazeiHon2);
    }

    @JsonIgnore
    public TextBox getTxtHonninKazeiHon2() {
        return this.getFukakijunHon2().getTxtHonninKazeiHon2();
    }

    @JsonIgnore
    public void setTxtHonninKazeiHon2(TextBox txtHonninKazeiHon2) {
        this.getFukakijunHon2().setTxtHonninKazeiHon2(txtHonninKazeiHon2);
    }

    @JsonIgnore
    public Label getLblSetaiKazeiHon2() {
        return this.getFukakijunHon2().getLblSetaiKazeiHon2();
    }

    @JsonIgnore
    public void setLblSetaiKazeiHon2(Label lblSetaiKazeiHon2) {
        this.getFukakijunHon2().setLblSetaiKazeiHon2(lblSetaiKazeiHon2);
    }

    @JsonIgnore
    public TextBox getTxtSetaiKazeiHon2() {
        return this.getFukakijunHon2().getTxtSetaiKazeiHon2();
    }

    @JsonIgnore
    public void setTxtSetaiKazeiHon2(TextBox txtSetaiKazeiHon2) {
        this.getFukakijunHon2().setTxtSetaiKazeiHon2(txtSetaiKazeiHon2);
    }

    @JsonIgnore
    public Label getLblSetaiinSuHon2() {
        return this.getFukakijunHon2().getLblSetaiinSuHon2();
    }

    @JsonIgnore
    public void setLblSetaiinSuHon2(Label lblSetaiinSuHon2) {
        this.getFukakijunHon2().setLblSetaiinSuHon2(lblSetaiinSuHon2);
    }

    @JsonIgnore
    public TextBox getTxtSetaiinSuHon2() {
        return this.getFukakijunHon2().getTxtSetaiinSuHon2();
    }

    @JsonIgnore
    public void setTxtSetaiinSuHon2(TextBox txtSetaiinSuHon2) {
        this.getFukakijunHon2().setTxtSetaiinSuHon2(txtSetaiinSuHon2);
    }

    @JsonIgnore
    public Label getLblKeisanHokenryogakuHon2() {
        return this.getHokenryoHon2().getLblKeisanHokenryogakuHon2();
    }

    @JsonIgnore
    public void setLblKeisanHokenryogakuHon2(Label lblKeisanHokenryogakuHon2) {
        this.getHokenryoHon2().setLblKeisanHokenryogakuHon2(lblKeisanHokenryogakuHon2);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeisanHokenryogakuHon2() {
        return this.getHokenryoHon2().getTxtKeisanHokenryogakuHon2();
    }

    @JsonIgnore
    public void setTxtKeisanHokenryogakuHon2(TextBoxNum txtKeisanHokenryogakuHon2) {
        this.getHokenryoHon2().setTxtKeisanHokenryogakuHon2(txtKeisanHokenryogakuHon2);
    }

    @JsonIgnore
    public Label getLblGemmenGakuHon2() {
        return this.getHokenryoHon2().getLblGemmenGakuHon2();
    }

    @JsonIgnore
    public void setLblGemmenGakuHon2(Label lblGemmenGakuHon2) {
        this.getHokenryoHon2().setLblGemmenGakuHon2(lblGemmenGakuHon2);
    }

    @JsonIgnore
    public TextBoxNum getTxtGemmenGakuHon2() {
        return this.getHokenryoHon2().getTxtGemmenGakuHon2();
    }

    @JsonIgnore
    public void setTxtGemmenGakuHon2(TextBoxNum txtGemmenGakuHon2) {
        this.getHokenryoHon2().setTxtGemmenGakuHon2(txtGemmenGakuHon2);
    }

    @JsonIgnore
    public Label getLblKakuteiHokenryoHon2() {
        return this.getHokenryoHon2().getLblKakuteiHokenryoHon2();
    }

    @JsonIgnore
    public void setLblKakuteiHokenryoHon2(Label lblKakuteiHokenryoHon2) {
        this.getHokenryoHon2().setLblKakuteiHokenryoHon2(lblKakuteiHokenryoHon2);
    }

    @JsonIgnore
    public TextBoxNum getTxtKakuteiHokenryoHon2() {
        return this.getHokenryoHon2().getTxtKakuteiHokenryoHon2();
    }

    @JsonIgnore
    public void setTxtKakuteiHokenryoHon2(TextBoxNum txtKakuteiHokenryoHon2) {
        this.getHokenryoHon2().setTxtKakuteiHokenryoHon2(txtKakuteiHokenryoHon2);
    }

    @JsonIgnore
    public Label getLblHokenryoDankaiHon2() {
        return this.getHokenryoHon2().getLblHokenryoDankaiHon2();
    }

    @JsonIgnore
    public void setLblHokenryoDankaiHon2(Label lblHokenryoDankaiHon2) {
        this.getHokenryoHon2().setLblHokenryoDankaiHon2(lblHokenryoDankaiHon2);
    }

    @JsonIgnore
    public TextBox getTxtHokenryoDankaiHon2() {
        return this.getHokenryoHon2().getTxtHokenryoDankaiHon2();
    }

    @JsonIgnore
    public void setTxtHokenryoDankaiHon2(TextBox txtHokenryoDankaiHon2) {
        this.getHokenryoHon2().setTxtHokenryoDankaiHon2(txtHokenryoDankaiHon2);
    }

    @JsonIgnore
    public Label getLblKyokaisoHon2() {
        return this.getHokenryoHon2().getLblKyokaisoHon2();
    }

    @JsonIgnore
    public void setLblKyokaisoHon2(Label lblKyokaisoHon2) {
        this.getHokenryoHon2().setLblKyokaisoHon2(lblKyokaisoHon2);
    }

    @JsonIgnore
    public TextBox getTxtKyokaisoHon2() {
        return this.getHokenryoHon2().getTxtKyokaisoHon2();
    }

    @JsonIgnore
    public void setTxtKyokaisoHon2(TextBox txtKyokaisoHon2) {
        this.getHokenryoHon2().setTxtKyokaisoHon2(txtKyokaisoHon2);
    }

    @JsonIgnore
    public IKiwarigakuDiv getCcdKiwarigakuHon2() {
        return this.getKibetsugakuHon2().getCcdKiwarigakuHon2();
    }

    // </editor-fold>
}
