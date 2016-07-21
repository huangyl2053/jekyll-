package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuServicehiDetail;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplShinseisha のクラスファイル
 *
 * @reamsid_L DBC-4380-010 quxiaodong
 */
public class tplShinseishaDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiYMD")
    private TextBoxDate txtShinseiYMD;
    @JsonProperty("rdbShinseisyaKubun")
    private RadioButton rdbShinseisyaKubun;
    @JsonProperty("txtHokenJyaBango")
    private TextBoxCode txtHokenJyaBango;
    @JsonProperty("chkKokuhorenSaiso")
    private CheckBoxList chkKokuhorenSaiso;
    @JsonProperty("txtShimeiKanji")
    private TextBox txtShimeiKanji;
    @JsonProperty("txtShimeiKana")
    private TextBoxKana txtShimeiKana;
    @JsonProperty("txtTelNo")
    private TextBoxTelNo txtTelNo;
    @JsonProperty("txtShinseiRiyu")
    private TextBoxMultiLine txtShinseiRiyu;
    @JsonProperty("txtShiharaiTotalAmount")
    private TextBoxNum txtShiharaiTotalAmount;
    @JsonProperty("txtKotei")
    private TextBoxMultiLine txtKotei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseiYMD
     * @return txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public TextBoxDate getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    /*
     * settxtShinseiYMD
     * @param txtShinseiYMD txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.txtShinseiYMD = txtShinseiYMD;
    }

    /*
     * getrdbShinseisyaKubun
     * @return rdbShinseisyaKubun
     */
    @JsonProperty("rdbShinseisyaKubun")
    public RadioButton getRdbShinseisyaKubun() {
        return rdbShinseisyaKubun;
    }

    /*
     * setrdbShinseisyaKubun
     * @param rdbShinseisyaKubun rdbShinseisyaKubun
     */
    @JsonProperty("rdbShinseisyaKubun")
    public void setRdbShinseisyaKubun(RadioButton rdbShinseisyaKubun) {
        this.rdbShinseisyaKubun = rdbShinseisyaKubun;
    }

    /*
     * gettxtHokenJyaBango
     * @return txtHokenJyaBango
     */
    @JsonProperty("txtHokenJyaBango")
    public TextBoxCode getTxtHokenJyaBango() {
        return txtHokenJyaBango;
    }

    /*
     * settxtHokenJyaBango
     * @param txtHokenJyaBango txtHokenJyaBango
     */
    @JsonProperty("txtHokenJyaBango")
    public void setTxtHokenJyaBango(TextBoxCode txtHokenJyaBango) {
        this.txtHokenJyaBango = txtHokenJyaBango;
    }

    /*
     * getchkKokuhorenSaiso
     * @return chkKokuhorenSaiso
     */
    @JsonProperty("chkKokuhorenSaiso")
    public CheckBoxList getChkKokuhorenSaiso() {
        return chkKokuhorenSaiso;
    }

    /*
     * setchkKokuhorenSaiso
     * @param chkKokuhorenSaiso chkKokuhorenSaiso
     */
    @JsonProperty("chkKokuhorenSaiso")
    public void setChkKokuhorenSaiso(CheckBoxList chkKokuhorenSaiso) {
        this.chkKokuhorenSaiso = chkKokuhorenSaiso;
    }

    /*
     * gettxtShimeiKanji
     * @return txtShimeiKanji
     */
    @JsonProperty("txtShimeiKanji")
    public TextBox getTxtShimeiKanji() {
        return txtShimeiKanji;
    }

    /*
     * settxtShimeiKanji
     * @param txtShimeiKanji txtShimeiKanji
     */
    @JsonProperty("txtShimeiKanji")
    public void setTxtShimeiKanji(TextBox txtShimeiKanji) {
        this.txtShimeiKanji = txtShimeiKanji;
    }

    /*
     * gettxtShimeiKana
     * @return txtShimeiKana
     */
    @JsonProperty("txtShimeiKana")
    public TextBoxKana getTxtShimeiKana() {
        return txtShimeiKana;
    }

    /*
     * settxtShimeiKana
     * @param txtShimeiKana txtShimeiKana
     */
    @JsonProperty("txtShimeiKana")
    public void setTxtShimeiKana(TextBoxKana txtShimeiKana) {
        this.txtShimeiKana = txtShimeiKana;
    }

    /*
     * gettxtTelNo
     * @return txtTelNo
     */
    @JsonProperty("txtTelNo")
    public TextBoxTelNo getTxtTelNo() {
        return txtTelNo;
    }

    /*
     * settxtTelNo
     * @param txtTelNo txtTelNo
     */
    @JsonProperty("txtTelNo")
    public void setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.txtTelNo = txtTelNo;
    }

    /*
     * gettxtShinseiRiyu
     * @return txtShinseiRiyu
     */
    @JsonProperty("txtShinseiRiyu")
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return txtShinseiRiyu;
    }

    /*
     * settxtShinseiRiyu
     * @param txtShinseiRiyu txtShinseiRiyu
     */
    @JsonProperty("txtShinseiRiyu")
    public void setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.txtShinseiRiyu = txtShinseiRiyu;
    }

    /*
     * gettxtShiharaiTotalAmount
     * @return txtShiharaiTotalAmount
     */
    @JsonProperty("txtShiharaiTotalAmount")
    public TextBoxNum getTxtShiharaiTotalAmount() {
        return txtShiharaiTotalAmount;
    }

    /*
     * settxtShiharaiTotalAmount
     * @param txtShiharaiTotalAmount txtShiharaiTotalAmount
     */
    @JsonProperty("txtShiharaiTotalAmount")
    public void setTxtShiharaiTotalAmount(TextBoxNum txtShiharaiTotalAmount) {
        this.txtShiharaiTotalAmount = txtShiharaiTotalAmount;
    }

    /*
     * gettxtKotei
     * @return txtKotei
     */
    @JsonProperty("txtKotei")
    public TextBoxMultiLine getTxtKotei() {
        return txtKotei;
    }

    /*
     * settxtKotei
     * @param txtKotei txtKotei
     */
    @JsonProperty("txtKotei")
    public void setTxtKotei(TextBoxMultiLine txtKotei) {
        this.txtKotei = txtKotei;
    }

    // </editor-fold>
}
