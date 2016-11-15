package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820012;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * pnlShinsei のクラスファイル 
 * 
 * @author 自動生成
 */
public class pnlShinseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiYMD")
    private TextBoxDate txtShinseiYMD;
    @JsonProperty("txtUketsukeYMD")
    private TextBoxDate txtUketsukeYMD;
    @JsonProperty("rdoShinseisyaKubun")
    private RadioButton rdoShinseisyaKubun;
    @JsonProperty("txtKisaiHokensyaBango")
    private TextBoxCode txtKisaiHokensyaBango;
    @JsonProperty("chkKokuhorenSaiso")
    private CheckBoxList chkKokuhorenSaiso;
    @JsonProperty("txtShimeiKanji")
    private TextBoxAtenaMeisho txtShimeiKanji;
    @JsonProperty("txtShimeikana")
    private TextBoxAtenaKanaMeisho txtShimeikana;
    @JsonProperty("txtTelNo")
    private TextBoxTelNo txtTelNo;
    @JsonProperty("txtMulShinseiRiyu")
    private TextBoxMultiLine txtMulShinseiRiyu;
    @JsonProperty("txtNumShiharaKingakuGk")
    private TextBoxNum txtNumShiharaKingakuGk;
    @JsonProperty("txtNumHokentaisyoHiyouGaku")
    private TextBoxNum txtNumHokentaisyoHiyouGaku;
    @JsonProperty("txtNumHokenKyufuGaku")
    private TextBoxNum txtNumHokenKyufuGaku;

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
     * gettxtUketsukeYMD
     * @return txtUketsukeYMD
     */
    @JsonProperty("txtUketsukeYMD")
    public TextBoxDate getTxtUketsukeYMD() {
        return txtUketsukeYMD;
    }

    /*
     * settxtUketsukeYMD
     * @param txtUketsukeYMD txtUketsukeYMD
     */
    @JsonProperty("txtUketsukeYMD")
    public void setTxtUketsukeYMD(TextBoxDate txtUketsukeYMD) {
        this.txtUketsukeYMD = txtUketsukeYMD;
    }

    /*
     * getrdoShinseisyaKubun
     * @return rdoShinseisyaKubun
     */
    @JsonProperty("rdoShinseisyaKubun")
    public RadioButton getRdoShinseisyaKubun() {
        return rdoShinseisyaKubun;
    }

    /*
     * setrdoShinseisyaKubun
     * @param rdoShinseisyaKubun rdoShinseisyaKubun
     */
    @JsonProperty("rdoShinseisyaKubun")
    public void setRdoShinseisyaKubun(RadioButton rdoShinseisyaKubun) {
        this.rdoShinseisyaKubun = rdoShinseisyaKubun;
    }

    /*
     * gettxtKisaiHokensyaBango
     * @return txtKisaiHokensyaBango
     */
    @JsonProperty("txtKisaiHokensyaBango")
    public TextBoxCode getTxtKisaiHokensyaBango() {
        return txtKisaiHokensyaBango;
    }

    /*
     * settxtKisaiHokensyaBango
     * @param txtKisaiHokensyaBango txtKisaiHokensyaBango
     */
    @JsonProperty("txtKisaiHokensyaBango")
    public void setTxtKisaiHokensyaBango(TextBoxCode txtKisaiHokensyaBango) {
        this.txtKisaiHokensyaBango = txtKisaiHokensyaBango;
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
    public TextBoxAtenaMeisho getTxtShimeiKanji() {
        return txtShimeiKanji;
    }

    /*
     * settxtShimeiKanji
     * @param txtShimeiKanji txtShimeiKanji
     */
    @JsonProperty("txtShimeiKanji")
    public void setTxtShimeiKanji(TextBoxAtenaMeisho txtShimeiKanji) {
        this.txtShimeiKanji = txtShimeiKanji;
    }

    /*
     * gettxtShimeikana
     * @return txtShimeikana
     */
    @JsonProperty("txtShimeikana")
    public TextBoxAtenaKanaMeisho getTxtShimeikana() {
        return txtShimeikana;
    }

    /*
     * settxtShimeikana
     * @param txtShimeikana txtShimeikana
     */
    @JsonProperty("txtShimeikana")
    public void setTxtShimeikana(TextBoxAtenaKanaMeisho txtShimeikana) {
        this.txtShimeikana = txtShimeikana;
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
     * gettxtMulShinseiRiyu
     * @return txtMulShinseiRiyu
     */
    @JsonProperty("txtMulShinseiRiyu")
    public TextBoxMultiLine getTxtMulShinseiRiyu() {
        return txtMulShinseiRiyu;
    }

    /*
     * settxtMulShinseiRiyu
     * @param txtMulShinseiRiyu txtMulShinseiRiyu
     */
    @JsonProperty("txtMulShinseiRiyu")
    public void setTxtMulShinseiRiyu(TextBoxMultiLine txtMulShinseiRiyu) {
        this.txtMulShinseiRiyu = txtMulShinseiRiyu;
    }

    /*
     * gettxtNumShiharaKingakuGk
     * @return txtNumShiharaKingakuGk
     */
    @JsonProperty("txtNumShiharaKingakuGk")
    public TextBoxNum getTxtNumShiharaKingakuGk() {
        return txtNumShiharaKingakuGk;
    }

    /*
     * settxtNumShiharaKingakuGk
     * @param txtNumShiharaKingakuGk txtNumShiharaKingakuGk
     */
    @JsonProperty("txtNumShiharaKingakuGk")
    public void setTxtNumShiharaKingakuGk(TextBoxNum txtNumShiharaKingakuGk) {
        this.txtNumShiharaKingakuGk = txtNumShiharaKingakuGk;
    }

    /*
     * gettxtNumHokentaisyoHiyouGaku
     * @return txtNumHokentaisyoHiyouGaku
     */
    @JsonProperty("txtNumHokentaisyoHiyouGaku")
    public TextBoxNum getTxtNumHokentaisyoHiyouGaku() {
        return txtNumHokentaisyoHiyouGaku;
    }

    /*
     * settxtNumHokentaisyoHiyouGaku
     * @param txtNumHokentaisyoHiyouGaku txtNumHokentaisyoHiyouGaku
     */
    @JsonProperty("txtNumHokentaisyoHiyouGaku")
    public void setTxtNumHokentaisyoHiyouGaku(TextBoxNum txtNumHokentaisyoHiyouGaku) {
        this.txtNumHokentaisyoHiyouGaku = txtNumHokentaisyoHiyouGaku;
    }

    /*
     * gettxtNumHokenKyufuGaku
     * @return txtNumHokenKyufuGaku
     */
    @JsonProperty("txtNumHokenKyufuGaku")
    public TextBoxNum getTxtNumHokenKyufuGaku() {
        return txtNumHokenKyufuGaku;
    }

    /*
     * settxtNumHokenKyufuGaku
     * @param txtNumHokenKyufuGaku txtNumHokenKyufuGaku
     */
    @JsonProperty("txtNumHokenKyufuGaku")
    public void setTxtNumHokenKyufuGaku(TextBoxNum txtNumHokenKyufuGaku) {
        this.txtNumHokenKyufuGaku = txtNumHokenKyufuGaku;
    }

    // </editor-fold>
}
