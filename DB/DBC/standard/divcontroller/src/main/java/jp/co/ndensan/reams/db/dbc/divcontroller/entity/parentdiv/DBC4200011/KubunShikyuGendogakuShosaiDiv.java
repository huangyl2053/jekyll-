package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4200011;
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
 * KubunShikyuGendogakuShosai のクラスファイル
 *
 * @reamsid_L DBC-3410-010 jianglaisheng
 */
public class KubunShikyuGendogakuShosaiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTekiyoKikanRange")
    private TextBoxDateRange txtTekiyoKikanRange;
    @JsonProperty("lin01")
    private HorizontalLine lin01;
    @JsonProperty("lbl01")
    private Label lbl01;
    @JsonProperty("radTableKubun")
    private RadioButton radTableKubun;
    @JsonProperty("spc01")
    private Space spc01;
    @JsonProperty("tblGendogaku")
    private tblGendogakuDiv tblGendogaku;
    @JsonProperty("KubunShikyuGendogakuShosaiFooter")
    private KubunShikyuGendogakuShosaiFooterDiv KubunShikyuGendogakuShosaiFooter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTekiyoKikanRange
     * @return txtTekiyoKikanRange
     */
    @JsonProperty("txtTekiyoKikanRange")
    public TextBoxDateRange getTxtTekiyoKikanRange() {
        return txtTekiyoKikanRange;
    }

    /*
     * settxtTekiyoKikanRange
     * @param txtTekiyoKikanRange txtTekiyoKikanRange
     */
    @JsonProperty("txtTekiyoKikanRange")
    public void setTxtTekiyoKikanRange(TextBoxDateRange txtTekiyoKikanRange) {
        this.txtTekiyoKikanRange = txtTekiyoKikanRange;
    }

    /*
     * getlin01
     * @return lin01
     */
    @JsonProperty("lin01")
    public HorizontalLine getLin01() {
        return lin01;
    }

    /*
     * setlin01
     * @param lin01 lin01
     */
    @JsonProperty("lin01")
    public void setLin01(HorizontalLine lin01) {
        this.lin01 = lin01;
    }

    /*
     * getlbl01
     * @return lbl01
     */
    @JsonProperty("lbl01")
    public Label getLbl01() {
        return lbl01;
    }

    /*
     * setlbl01
     * @param lbl01 lbl01
     */
    @JsonProperty("lbl01")
    public void setLbl01(Label lbl01) {
        this.lbl01 = lbl01;
    }

    /*
     * getradTableKubun
     * @return radTableKubun
     */
    @JsonProperty("radTableKubun")
    public RadioButton getRadTableKubun() {
        return radTableKubun;
    }

    /*
     * setradTableKubun
     * @param radTableKubun radTableKubun
     */
    @JsonProperty("radTableKubun")
    public void setRadTableKubun(RadioButton radTableKubun) {
        this.radTableKubun = radTableKubun;
    }

    /*
     * getspc01
     * @return spc01
     */
    @JsonProperty("spc01")
    public Space getSpc01() {
        return spc01;
    }

    /*
     * setspc01
     * @param spc01 spc01
     */
    @JsonProperty("spc01")
    public void setSpc01(Space spc01) {
        this.spc01 = spc01;
    }

    /*
     * gettblGendogaku
     * @return tblGendogaku
     */
    @JsonProperty("tblGendogaku")
    public tblGendogakuDiv getTblGendogaku() {
        return tblGendogaku;
    }

    /*
     * settblGendogaku
     * @param tblGendogaku tblGendogaku
     */
    @JsonProperty("tblGendogaku")
    public void setTblGendogaku(tblGendogakuDiv tblGendogaku) {
        this.tblGendogaku = tblGendogaku;
    }

    /*
     * getKubunShikyuGendogakuShosaiFooter
     * @return KubunShikyuGendogakuShosaiFooter
     */
    @JsonProperty("KubunShikyuGendogakuShosaiFooter")
    public KubunShikyuGendogakuShosaiFooterDiv getKubunShikyuGendogakuShosaiFooter() {
        return KubunShikyuGendogakuShosaiFooter;
    }

    /*
     * setKubunShikyuGendogakuShosaiFooter
     * @param KubunShikyuGendogakuShosaiFooter KubunShikyuGendogakuShosaiFooter
     */
    @JsonProperty("KubunShikyuGendogakuShosaiFooter")
    public void setKubunShikyuGendogakuShosaiFooter(KubunShikyuGendogakuShosaiFooterDiv KubunShikyuGendogakuShosaiFooter) {
        this.KubunShikyuGendogakuShosaiFooter = KubunShikyuGendogakuShosaiFooter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblYokaigo1() {
        return this.getTblGendogaku().getLblYokaigo1();
    }

    @JsonIgnore
    public Label getLblYokaigo2() {
        return this.getTblGendogaku().getLblYokaigo2();
    }

    @JsonIgnore
    public Label getLblYokaigo3() {
        return this.getTblGendogaku().getLblYokaigo3();
    }

    @JsonIgnore
    public Label getLblYokaigo4() {
        return this.getTblGendogaku().getLblYokaigo4();
    }

    @JsonIgnore
    public Label getLblYokaigo5() {
        return this.getTblGendogaku().getLblYokaigo5();
    }

    @JsonIgnore
    public Label getLblKeikaKaigo() {
        return this.getTblGendogaku().getLblKeikaKaigo();
    }

    @JsonIgnore
    public Label getLblYoshien1() {
        return this.getTblGendogaku().getLblYoshien1();
    }

    @JsonIgnore
    public Label getLblYoshien2() {
        return this.getTblGendogaku().getLblYoshien2();
    }

    @JsonIgnore
    public TextBoxNum getTxtYokaigo1ShikyuGendogaku() {
        return this.getTblGendogaku().getTxtYokaigo1ShikyuGendogaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtYokaigo2ShikyuGendogaku() {
        return this.getTblGendogaku().getTxtYokaigo2ShikyuGendogaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtYokaigo3ShikyuGendogaku() {
        return this.getTblGendogaku().getTxtYokaigo3ShikyuGendogaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtYokaigo4ShikyuGendogaku() {
        return this.getTblGendogaku().getTxtYokaigo4ShikyuGendogaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtYokaigo5ShikyuGendogaku() {
        return this.getTblGendogaku().getTxtYokaigo5ShikyuGendogaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtKeikaKaigoShikyuGendogaku() {
        return this.getTblGendogaku().getTxtKeikaKaigoShikyuGendogaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoshien1ShikyuGendogaku() {
        return this.getTblGendogaku().getTxtYoshien1ShikyuGendogaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtYoshien2ShikyuGendogaku() {
        return this.getTblGendogaku().getTxtYoshien2ShikyuGendogaku();
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getKubunShikyuGendogakuShosaiFooter().getBtnCancel();
    }

    @JsonIgnore
    public void setBtnCancel(Button btnCancel) {
        this.getKubunShikyuGendogakuShosaiFooter().setBtnCancel(btnCancel);
    }

    // </editor-fold>
}
