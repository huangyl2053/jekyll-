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
 * KariSantei1 のクラスファイル
 *
 * @author 自動生成
 */
public class KariSantei1Div extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendoKari1")
    private TextBoxFlexibleYear txtChoteiNendoKari1;
    @JsonProperty("txtFukaNendoKari1")
    private TextBoxFlexibleYear txtFukaNendoKari1;
    @JsonProperty("txtTsuchiNoKari1")
    private TextBox txtTsuchiNoKari1;
    @JsonProperty("txtKoseiYMDKari1")
    private TextBox txtKoseiYMDKari1;
    @JsonProperty("txtKoseiTimeKari1")
    private TextBoxTime txtKoseiTimeKari1;
    @JsonProperty("txtKoseiYMKari1")
    private TextBox txtKoseiYMKari1;
    @JsonProperty("txtShimeiKari1")
    private TextBox txtShimeiKari1;
    @JsonProperty("tblChoteiJiyuKari1")
    private tblChoteiJiyuKari1Div tblChoteiJiyuKari1;
    @JsonProperty("FukakijunKari1")
    private FukakijunKari1Div FukakijunKari1;
    @JsonProperty("ZennendoKari1")
    private ZennendoKari1Div ZennendoKari1;
    @JsonProperty("HokenryoKari1")
    private HokenryoKari1Div HokenryoKari1;
    @JsonProperty("KibetsugakuKari1")
    private KibetsugakuKari1Div KibetsugakuKari1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChoteiNendoKari1
     * @return txtChoteiNendoKari1
     */
    @JsonProperty("txtChoteiNendoKari1")
    public TextBoxFlexibleYear getTxtChoteiNendoKari1() {
        return txtChoteiNendoKari1;
    }

    /*
     * settxtChoteiNendoKari1
     * @param txtChoteiNendoKari1 txtChoteiNendoKari1
     */
    @JsonProperty("txtChoteiNendoKari1")
    public void setTxtChoteiNendoKari1(TextBoxFlexibleYear txtChoteiNendoKari1) {
        this.txtChoteiNendoKari1 = txtChoteiNendoKari1;
    }

    /*
     * gettxtFukaNendoKari1
     * @return txtFukaNendoKari1
     */
    @JsonProperty("txtFukaNendoKari1")
    public TextBoxFlexibleYear getTxtFukaNendoKari1() {
        return txtFukaNendoKari1;
    }

    /*
     * settxtFukaNendoKari1
     * @param txtFukaNendoKari1 txtFukaNendoKari1
     */
    @JsonProperty("txtFukaNendoKari1")
    public void setTxtFukaNendoKari1(TextBoxFlexibleYear txtFukaNendoKari1) {
        this.txtFukaNendoKari1 = txtFukaNendoKari1;
    }

    /*
     * gettxtTsuchiNoKari1
     * @return txtTsuchiNoKari1
     */
    @JsonProperty("txtTsuchiNoKari1")
    public TextBox getTxtTsuchiNoKari1() {
        return txtTsuchiNoKari1;
    }

    /*
     * settxtTsuchiNoKari1
     * @param txtTsuchiNoKari1 txtTsuchiNoKari1
     */
    @JsonProperty("txtTsuchiNoKari1")
    public void setTxtTsuchiNoKari1(TextBox txtTsuchiNoKari1) {
        this.txtTsuchiNoKari1 = txtTsuchiNoKari1;
    }

    /*
     * gettxtKoseiYMDKari1
     * @return txtKoseiYMDKari1
     */
    @JsonProperty("txtKoseiYMDKari1")
    public TextBox getTxtKoseiYMDKari1() {
        return txtKoseiYMDKari1;
    }

    /*
     * settxtKoseiYMDKari1
     * @param txtKoseiYMDKari1 txtKoseiYMDKari1
     */
    @JsonProperty("txtKoseiYMDKari1")
    public void setTxtKoseiYMDKari1(TextBox txtKoseiYMDKari1) {
        this.txtKoseiYMDKari1 = txtKoseiYMDKari1;
    }

    /*
     * gettxtKoseiTimeKari1
     * @return txtKoseiTimeKari1
     */
    @JsonProperty("txtKoseiTimeKari1")
    public TextBoxTime getTxtKoseiTimeKari1() {
        return txtKoseiTimeKari1;
    }

    /*
     * settxtKoseiTimeKari1
     * @param txtKoseiTimeKari1 txtKoseiTimeKari1
     */
    @JsonProperty("txtKoseiTimeKari1")
    public void setTxtKoseiTimeKari1(TextBoxTime txtKoseiTimeKari1) {
        this.txtKoseiTimeKari1 = txtKoseiTimeKari1;
    }

    /*
     * gettxtKoseiYMKari1
     * @return txtKoseiYMKari1
     */
    @JsonProperty("txtKoseiYMKari1")
    public TextBox getTxtKoseiYMKari1() {
        return txtKoseiYMKari1;
    }

    /*
     * settxtKoseiYMKari1
     * @param txtKoseiYMKari1 txtKoseiYMKari1
     */
    @JsonProperty("txtKoseiYMKari1")
    public void setTxtKoseiYMKari1(TextBox txtKoseiYMKari1) {
        this.txtKoseiYMKari1 = txtKoseiYMKari1;
    }

    /*
     * gettxtShimeiKari1
     * @return txtShimeiKari1
     */
    @JsonProperty("txtShimeiKari1")
    public TextBox getTxtShimeiKari1() {
        return txtShimeiKari1;
    }

    /*
     * settxtShimeiKari1
     * @param txtShimeiKari1 txtShimeiKari1
     */
    @JsonProperty("txtShimeiKari1")
    public void setTxtShimeiKari1(TextBox txtShimeiKari1) {
        this.txtShimeiKari1 = txtShimeiKari1;
    }

    /*
     * gettblChoteiJiyuKari1
     * @return tblChoteiJiyuKari1
     */
    @JsonProperty("tblChoteiJiyuKari1")
    public tblChoteiJiyuKari1Div getTblChoteiJiyuKari1() {
        return tblChoteiJiyuKari1;
    }

    /*
     * settblChoteiJiyuKari1
     * @param tblChoteiJiyuKari1 tblChoteiJiyuKari1
     */
    @JsonProperty("tblChoteiJiyuKari1")
    public void setTblChoteiJiyuKari1(tblChoteiJiyuKari1Div tblChoteiJiyuKari1) {
        this.tblChoteiJiyuKari1 = tblChoteiJiyuKari1;
    }

    /*
     * getFukakijunKari1
     * @return FukakijunKari1
     */
    @JsonProperty("FukakijunKari1")
    public FukakijunKari1Div getFukakijunKari1() {
        return FukakijunKari1;
    }

    /*
     * setFukakijunKari1
     * @param FukakijunKari1 FukakijunKari1
     */
    @JsonProperty("FukakijunKari1")
    public void setFukakijunKari1(FukakijunKari1Div FukakijunKari1) {
        this.FukakijunKari1 = FukakijunKari1;
    }

    /*
     * getZennendoKari1
     * @return ZennendoKari1
     */
    @JsonProperty("ZennendoKari1")
    public ZennendoKari1Div getZennendoKari1() {
        return ZennendoKari1;
    }

    /*
     * setZennendoKari1
     * @param ZennendoKari1 ZennendoKari1
     */
    @JsonProperty("ZennendoKari1")
    public void setZennendoKari1(ZennendoKari1Div ZennendoKari1) {
        this.ZennendoKari1 = ZennendoKari1;
    }

    /*
     * getHokenryoKari1
     * @return HokenryoKari1
     */
    @JsonProperty("HokenryoKari1")
    public HokenryoKari1Div getHokenryoKari1() {
        return HokenryoKari1;
    }

    /*
     * setHokenryoKari1
     * @param HokenryoKari1 HokenryoKari1
     */
    @JsonProperty("HokenryoKari1")
    public void setHokenryoKari1(HokenryoKari1Div HokenryoKari1) {
        this.HokenryoKari1 = HokenryoKari1;
    }

    /*
     * getKibetsugakuKari1
     * @return KibetsugakuKari1
     */
    @JsonProperty("KibetsugakuKari1")
    public KibetsugakuKari1Div getKibetsugakuKari1() {
        return KibetsugakuKari1;
    }

    /*
     * setKibetsugakuKari1
     * @param KibetsugakuKari1 KibetsugakuKari1
     */
    @JsonProperty("KibetsugakuKari1")
    public void setKibetsugakuKari1(KibetsugakuKari1Div KibetsugakuKari1) {
        this.KibetsugakuKari1 = KibetsugakuKari1;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblChoteiJiyuKari1() {
        return this.getTblChoteiJiyuKari1().getLblChoteiJiyuKari1();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuKari11() {
        return this.getTblChoteiJiyuKari1().getTxtChoteiJiyuKari11();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuKari12() {
        return this.getTblChoteiJiyuKari1().getTxtChoteiJiyuKari12();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuKari13() {
        return this.getTblChoteiJiyuKari1().getTxtChoteiJiyuKari13();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuKari14() {
        return this.getTblChoteiJiyuKari1().getTxtChoteiJiyuKari14();
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuShutokuYMDKari1() {
        return this.getFukakijunKari1().getTxtShikakuShutokuYMDKari1();
    }

    @JsonIgnore
    public void setTxtShikakuShutokuYMDKari1(TextBoxDate txtShikakuShutokuYMDKari1) {
        this.getFukakijunKari1().setTxtShikakuShutokuYMDKari1(txtShikakuShutokuYMDKari1);
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuSoshitsuYMDKari1() {
        return this.getFukakijunKari1().getTxtShikakuSoshitsuYMDKari1();
    }

    @JsonIgnore
    public void setTxtShikakuSoshitsuYMDKari1(TextBoxDate txtShikakuSoshitsuYMDKari1) {
        this.getFukakijunKari1().setTxtShikakuSoshitsuYMDKari1(txtShikakuSoshitsuYMDKari1);
    }

    @JsonIgnore
    public TextBox getTxtZenNendoHokenryoDankaiKari1() {
        return this.getZennendoKari1().getTxtZenNendoHokenryoDankaiKari1();
    }

    @JsonIgnore
    public void setTxtZenNendoHokenryoDankaiKari1(TextBox txtZenNendoHokenryoDankaiKari1) {
        this.getZennendoKari1().setTxtZenNendoHokenryoDankaiKari1(txtZenNendoHokenryoDankaiKari1);
    }

    @JsonIgnore
    public TextBox getTxtZenNendoHokenryoRitsuKari1() {
        return this.getZennendoKari1().getTxtZenNendoHokenryoRitsuKari1();
    }

    @JsonIgnore
    public void setTxtZenNendoHokenryoRitsuKari1(TextBox txtZenNendoHokenryoRitsuKari1) {
        this.getZennendoKari1().setTxtZenNendoHokenryoRitsuKari1(txtZenNendoHokenryoRitsuKari1);
    }

    @JsonIgnore
    public TextBoxNum getTxtZenNendoNengakuHokenryoKari1() {
        return this.getZennendoKari1().getTxtZenNendoNengakuHokenryoKari1();
    }

    @JsonIgnore
    public void setTxtZenNendoNengakuHokenryoKari1(TextBoxNum txtZenNendoNengakuHokenryoKari1) {
        this.getZennendoKari1().setTxtZenNendoNengakuHokenryoKari1(txtZenNendoNengakuHokenryoKari1);
    }

    @JsonIgnore
    public TextBoxNum getTxtKariSanteiHokenryoGakuKari1() {
        return this.getHokenryoKari1().getTxtKariSanteiHokenryoGakuKari1();
    }

    @JsonIgnore
    public void setTxtKariSanteiHokenryoGakuKari1(TextBoxNum txtKariSanteiHokenryoGakuKari1) {
        this.getHokenryoKari1().setTxtKariSanteiHokenryoGakuKari1(txtKariSanteiHokenryoGakuKari1);
    }

    @JsonIgnore
    public TextBoxNum getTxtGemmenGakuKari1() {
        return this.getHokenryoKari1().getTxtGemmenGakuKari1();
    }

    @JsonIgnore
    public void setTxtGemmenGakuKari1(TextBoxNum txtGemmenGakuKari1) {
        this.getHokenryoKari1().setTxtGemmenGakuKari1(txtGemmenGakuKari1);
    }

    @JsonIgnore
    public TextBoxNum getTxtGemmenGoKariSanteiHokenryoGakuKari1() {
        return this.getHokenryoKari1().getTxtGemmenGoKariSanteiHokenryoGakuKari1();
    }

    @JsonIgnore
    public void setTxtGemmenGoKariSanteiHokenryoGakuKari1(TextBoxNum txtGemmenGoKariSanteiHokenryoGakuKari1) {
        this.getHokenryoKari1().setTxtGemmenGoKariSanteiHokenryoGakuKari1(txtGemmenGoKariSanteiHokenryoGakuKari1);
    }

    @JsonIgnore
    public zanteihokenryoHeightKari1Div getZanteihokenryoHeightKari1() {
        return this.getHokenryoKari1().getZanteihokenryoHeightKari1();
    }

    @JsonIgnore
    public void setZanteihokenryoHeightKari1(zanteihokenryoHeightKari1Div zanteihokenryoHeightKari1) {
        this.getHokenryoKari1().setZanteihokenryoHeightKari1(zanteihokenryoHeightKari1);
    }

    @JsonIgnore
    public IKiwarigakuDiv getCcdKiwarigakuKari1() {
        return this.getKibetsugakuKari1().getCcdKiwarigakuKari1();
    }

    // </editor-fold>
}
