package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfoHandler;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;

/**
 * NinteiShinseishaKihonInfoHandler のクラスファイル。
 *
 * @reamsid_L DBE-3000-190 hezhenzhen
 *
 */
public class NinteiShinseishaKihonInfoDiv extends Panel implements INinteiShinseishaKihonInfoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihokenshaNo")
    private TextBoxCode txtHihokenshaNo;
    @JsonProperty("txtHihokenshaKubun")
    private TextBox txtHihokenshaKubun;
    @JsonProperty("txtHokenshaNo")
    private TextBoxNum txtHokenshaNo;
    @JsonProperty("txtHokenshaName")
    private TextBox txtHokenshaName;
    @JsonProperty("txtHihokenshaName")
    private TextBox txtHihokenshaName;
    @JsonProperty("txtHihokenshaKana")
    private TextBox txtHihokenshaKana;
    @JsonProperty("txtSeinenYmd")
    private TextBoxDate txtSeinenYmd;
    @JsonProperty("txtNenrei")
    private TextBoxNum txtNenrei;
    @JsonProperty("txtSeibetsu")
    private TextBox txtSeibetsu;
    @JsonProperty("txtYubibNo")
    private TextBoxYubinNo txtYubibNo;
    @JsonProperty("txtjusho")
    private TextBox txtjusho;
    @JsonProperty("txtTelNo")
    private TextBox txtTelNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHihokenshaNo
     * @return txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBoxCode getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    /*
     * settxtHihokenshaNo
     * @param txtHihokenshaNo txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    /*
     * gettxtHihokenshaKubun
     * @return txtHihokenshaKubun
     */
    @JsonProperty("txtHihokenshaKubun")
    public TextBox getTxtHihokenshaKubun() {
        return txtHihokenshaKubun;
    }

    /*
     * settxtHihokenshaKubun
     * @param txtHihokenshaKubun txtHihokenshaKubun
     */
    @JsonProperty("txtHihokenshaKubun")
    public void setTxtHihokenshaKubun(TextBox txtHihokenshaKubun) {
        this.txtHihokenshaKubun = txtHihokenshaKubun;
    }

    /*
     * gettxtHokenshaNo
     * @return txtHokenshaNo
     */
    @JsonProperty("txtHokenshaNo")
    public TextBoxNum getTxtHokenshaNo() {
        return txtHokenshaNo;
    }

    /*
     * settxtHokenshaNo
     * @param txtHokenshaNo txtHokenshaNo
     */
    @JsonProperty("txtHokenshaNo")
    public void setTxtHokenshaNo(TextBoxNum txtHokenshaNo) {
        this.txtHokenshaNo = txtHokenshaNo;
    }

    /*
     * gettxtHokenshaName
     * @return txtHokenshaName
     */
    @JsonProperty("txtHokenshaName")
    public TextBox getTxtHokenshaName() {
        return txtHokenshaName;
    }

    /*
     * settxtHokenshaName
     * @param txtHokenshaName txtHokenshaName
     */
    @JsonProperty("txtHokenshaName")
    public void setTxtHokenshaName(TextBox txtHokenshaName) {
        this.txtHokenshaName = txtHokenshaName;
    }

    /*
     * gettxtHihokenshaName
     * @return txtHihokenshaName
     */
    @JsonProperty("txtHihokenshaName")
    public TextBox getTxtHihokenshaName() {
        return txtHihokenshaName;
    }

    /*
     * settxtHihokenshaName
     * @param txtHihokenshaName txtHihokenshaName
     */
    @JsonProperty("txtHihokenshaName")
    public void setTxtHihokenshaName(TextBox txtHihokenshaName) {
        this.txtHihokenshaName = txtHihokenshaName;
    }

    /*
     * gettxtHihokenshaKana
     * @return txtHihokenshaKana
     */
    @JsonProperty("txtHihokenshaKana")
    public TextBox getTxtHihokenshaKana() {
        return txtHihokenshaKana;
    }

    /*
     * settxtHihokenshaKana
     * @param txtHihokenshaKana txtHihokenshaKana
     */
    @JsonProperty("txtHihokenshaKana")
    public void setTxtHihokenshaKana(TextBox txtHihokenshaKana) {
        this.txtHihokenshaKana = txtHihokenshaKana;
    }

    /*
     * gettxtSeinenYmd
     * @return txtSeinenYmd
     */
    @JsonProperty("txtSeinenYmd")
    public TextBoxDate getTxtSeinenYmd() {
        return txtSeinenYmd;
    }

    /*
     * settxtSeinenYmd
     * @param txtSeinenYmd txtSeinenYmd
     */
    @JsonProperty("txtSeinenYmd")
    public void setTxtSeinenYmd(TextBoxDate txtSeinenYmd) {
        this.txtSeinenYmd = txtSeinenYmd;
    }

    /*
     * gettxtNenrei
     * @return txtNenrei
     */
    @JsonProperty("txtNenrei")
    public TextBoxNum getTxtNenrei() {
        return txtNenrei;
    }

    /*
     * settxtNenrei
     * @param txtNenrei txtNenrei
     */
    @JsonProperty("txtNenrei")
    public void setTxtNenrei(TextBoxNum txtNenrei) {
        this.txtNenrei = txtNenrei;
    }

    /*
     * gettxtSeibetsu
     * @return txtSeibetsu
     */
    @JsonProperty("txtSeibetsu")
    public TextBox getTxtSeibetsu() {
        return txtSeibetsu;
    }

    /*
     * settxtSeibetsu
     * @param txtSeibetsu txtSeibetsu
     */
    @JsonProperty("txtSeibetsu")
    public void setTxtSeibetsu(TextBox txtSeibetsu) {
        this.txtSeibetsu = txtSeibetsu;
    }

    /*
     * gettxtYubibNo
     * @return txtYubibNo
     */
    @JsonProperty("txtYubibNo")
    public TextBoxYubinNo getTxtYubibNo() {
        return txtYubibNo;
    }

    /*
     * settxtYubibNo
     * @param txtYubibNo txtYubibNo
     */
    @JsonProperty("txtYubibNo")
    public void setTxtYubibNo(TextBoxYubinNo txtYubibNo) {
        this.txtYubibNo = txtYubibNo;
    }

    /*
     * gettxtjusho
     * @return txtjusho
     */
    @JsonProperty("txtjusho")
    public TextBox getTxtjusho() {
        return txtjusho;
    }

    /*
     * settxtjusho
     * @param txtjusho txtjusho
     */
    @JsonProperty("txtjusho")
    public void setTxtjusho(TextBox txtjusho) {
        this.txtjusho = txtjusho;
    }

    /*
     * gettxtTelNo
     * @return txtTelNo
     */
    @JsonProperty("txtTelNo")
    public TextBox getTxtTelNo() {
        return txtTelNo;
    }

    /*
     * settxtTelNo
     * @param txtTelNo txtTelNo
     */
    @JsonProperty("txtTelNo")
    public void setTxtTelNo(TextBox txtTelNo) {
        this.txtTelNo = txtTelNo;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @JsonIgnore
    private NinteiShinseishaKihonInfoHandler getHandler() {
        return new NinteiShinseishaKihonInfoHandler(this);
    }

    /**
     * 認定申請者基本情報の初期化です。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    @Override
    public void initialize(ShinseishoKanriNo 申請書管理番号) {
        getHandler().initialize(申請書管理番号);
    }
}
