package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1211011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * KogakuGassanShikyuKetteiTsuchishoSakusei のクラスファイル
 *
 * @reamsid_L DBC-2300-010 wangxingpeng
 */
public class KogakuGassanShikyuKetteiTsuchishoSakuseiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblZenkaiHizuke")
    private Label lblZenkaiHizuke;
    @JsonProperty("txtZenkaiKaishiYMD")
    private TextBoxDate txtZenkaiKaishiYMD;
    @JsonProperty("lblKara")
    private Label lblKara;
    @JsonProperty("txtZenkaiShuryoYMD")
    private TextBoxDate txtZenkaiShuryoYMD;
    @JsonProperty("radUketoriYM")
    private RadioButton radUketoriYM;
    @JsonProperty("txtUketoriYM")
    private TextBoxDate txtUketoriYM;
    @JsonProperty("radKetteiYMD")
    private RadioButton radKetteiYMD;
    @JsonProperty("txtKetteiYMD")
    private TextBoxDateRange txtKetteiYMD;
    @JsonProperty("radShinseiYMD")
    private RadioButton radShinseiYMD;
    @JsonProperty("txtShinseiYMD")
    private TextBoxDateRange txtShinseiYMD;
    @JsonProperty("ddlInsho")
    private DropDownList ddlInsho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblZenkaiHizuke
     * @return lblZenkaiHizuke
     */
    @JsonProperty("lblZenkaiHizuke")
    public Label getLblZenkaiHizuke() {
        return lblZenkaiHizuke;
    }

    /*
     * setlblZenkaiHizuke
     * @param lblZenkaiHizuke lblZenkaiHizuke
     */
    @JsonProperty("lblZenkaiHizuke")
    public void setLblZenkaiHizuke(Label lblZenkaiHizuke) {
        this.lblZenkaiHizuke = lblZenkaiHizuke;
    }

    /*
     * gettxtZenkaiKaishiYMD
     * @return txtZenkaiKaishiYMD
     */
    @JsonProperty("txtZenkaiKaishiYMD")
    public TextBoxDate getTxtZenkaiKaishiYMD() {
        return txtZenkaiKaishiYMD;
    }

    /*
     * settxtZenkaiKaishiYMD
     * @param txtZenkaiKaishiYMD txtZenkaiKaishiYMD
     */
    @JsonProperty("txtZenkaiKaishiYMD")
    public void setTxtZenkaiKaishiYMD(TextBoxDate txtZenkaiKaishiYMD) {
        this.txtZenkaiKaishiYMD = txtZenkaiKaishiYMD;
    }

    /*
     * getlblKara
     * @return lblKara
     */
    @JsonProperty("lblKara")
    public Label getLblKara() {
        return lblKara;
    }

    /*
     * setlblKara
     * @param lblKara lblKara
     */
    @JsonProperty("lblKara")
    public void setLblKara(Label lblKara) {
        this.lblKara = lblKara;
    }

    /*
     * gettxtZenkaiShuryoYMD
     * @return txtZenkaiShuryoYMD
     */
    @JsonProperty("txtZenkaiShuryoYMD")
    public TextBoxDate getTxtZenkaiShuryoYMD() {
        return txtZenkaiShuryoYMD;
    }

    /*
     * settxtZenkaiShuryoYMD
     * @param txtZenkaiShuryoYMD txtZenkaiShuryoYMD
     */
    @JsonProperty("txtZenkaiShuryoYMD")
    public void setTxtZenkaiShuryoYMD(TextBoxDate txtZenkaiShuryoYMD) {
        this.txtZenkaiShuryoYMD = txtZenkaiShuryoYMD;
    }

    /*
     * getradUketoriYM
     * @return radUketoriYM
     */
    @JsonProperty("radUketoriYM")
    public RadioButton getRadUketoriYM() {
        return radUketoriYM;
    }

    /*
     * setradUketoriYM
     * @param radUketoriYM radUketoriYM
     */
    @JsonProperty("radUketoriYM")
    public void setRadUketoriYM(RadioButton radUketoriYM) {
        this.radUketoriYM = radUketoriYM;
    }

    /*
     * gettxtUketoriYM
     * @return txtUketoriYM
     */
    @JsonProperty("txtUketoriYM")
    public TextBoxDate getTxtUketoriYM() {
        return txtUketoriYM;
    }

    /*
     * settxtUketoriYM
     * @param txtUketoriYM txtUketoriYM
     */
    @JsonProperty("txtUketoriYM")
    public void setTxtUketoriYM(TextBoxDate txtUketoriYM) {
        this.txtUketoriYM = txtUketoriYM;
    }

    /*
     * getradKetteiYMD
     * @return radKetteiYMD
     */
    @JsonProperty("radKetteiYMD")
    public RadioButton getRadKetteiYMD() {
        return radKetteiYMD;
    }

    /*
     * setradKetteiYMD
     * @param radKetteiYMD radKetteiYMD
     */
    @JsonProperty("radKetteiYMD")
    public void setRadKetteiYMD(RadioButton radKetteiYMD) {
        this.radKetteiYMD = radKetteiYMD;
    }

    /*
     * gettxtKetteiYMD
     * @return txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public TextBoxDateRange getTxtKetteiYMD() {
        return txtKetteiYMD;
    }

    /*
     * settxtKetteiYMD
     * @param txtKetteiYMD txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public void setTxtKetteiYMD(TextBoxDateRange txtKetteiYMD) {
        this.txtKetteiYMD = txtKetteiYMD;
    }

    /*
     * getradShinseiYMD
     * @return radShinseiYMD
     */
    @JsonProperty("radShinseiYMD")
    public RadioButton getRadShinseiYMD() {
        return radShinseiYMD;
    }

    /*
     * setradShinseiYMD
     * @param radShinseiYMD radShinseiYMD
     */
    @JsonProperty("radShinseiYMD")
    public void setRadShinseiYMD(RadioButton radShinseiYMD) {
        this.radShinseiYMD = radShinseiYMD;
    }

    /*
     * gettxtShinseiYMD
     * @return txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public TextBoxDateRange getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    /*
     * settxtShinseiYMD
     * @param txtShinseiYMD txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public void setTxtShinseiYMD(TextBoxDateRange txtShinseiYMD) {
        this.txtShinseiYMD = txtShinseiYMD;
    }

    /*
     * getddlInsho
     * @return ddlInsho
     */
    @JsonProperty("ddlInsho")
    public DropDownList getDdlInsho() {
        return ddlInsho;
    }

    /*
     * setddlInsho
     * @param ddlInsho ddlInsho
     */
    @JsonProperty("ddlInsho")
    public void setDdlInsho(DropDownList ddlInsho) {
        this.ddlInsho = ddlInsho;
    }

    // </editor-fold>
}
