package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.IKinyuKikanInputDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.KinyuKikanInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JutakuTesuryoSeikyuShosaiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuTesuryoSeikyuShosaiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtUketsukeYMD")
    private TextBoxDate txtUketsukeYMD;
    @JsonProperty("txtShinseiYMD")
    private TextBoxDate txtShinseiYMD;
    @JsonProperty("txtJigyoshaNo")
    private TextBoxCode txtJigyoshaNo;
    @JsonProperty("txtJigyoshaName")
    private TextBox txtJigyoshaName;
    @JsonProperty("txtSeikyuSakuseiYMD")
    private TextBoxDate txtSeikyuSakuseiYMD;
    @JsonProperty("txtHdnShikibetsuCode")
    private TextBoxCode txtHdnShikibetsuCode;
    @JsonProperty("ddlKozaShubetsu")
    private DropDownList ddlKozaShubetsu;
    @JsonProperty("txtKozaNo")
    private TextBoxCode txtKozaNo;
    @JsonProperty("txtKozaNameKana")
    private TextBoxKana txtKozaNameKana;
    @JsonProperty("txtKozaName")
    private TextBox txtKozaName;
    @JsonProperty("ccdKinyuKikanInput")
    private KinyuKikanInputDiv ccdKinyuKikanInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * gettxtJigyoshaNo
     * @return txtJigyoshaNo
     */
    @JsonProperty("txtJigyoshaNo")
    public TextBoxCode getTxtJigyoshaNo() {
        return txtJigyoshaNo;
    }

    /*
     * settxtJigyoshaNo
     * @param txtJigyoshaNo txtJigyoshaNo
     */
    @JsonProperty("txtJigyoshaNo")
    public void setTxtJigyoshaNo(TextBoxCode txtJigyoshaNo) {
        this.txtJigyoshaNo = txtJigyoshaNo;
    }

    /*
     * gettxtJigyoshaName
     * @return txtJigyoshaName
     */
    @JsonProperty("txtJigyoshaName")
    public TextBox getTxtJigyoshaName() {
        return txtJigyoshaName;
    }

    /*
     * settxtJigyoshaName
     * @param txtJigyoshaName txtJigyoshaName
     */
    @JsonProperty("txtJigyoshaName")
    public void setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.txtJigyoshaName = txtJigyoshaName;
    }

    /*
     * gettxtSeikyuSakuseiYMD
     * @return txtSeikyuSakuseiYMD
     */
    @JsonProperty("txtSeikyuSakuseiYMD")
    public TextBoxDate getTxtSeikyuSakuseiYMD() {
        return txtSeikyuSakuseiYMD;
    }

    /*
     * settxtSeikyuSakuseiYMD
     * @param txtSeikyuSakuseiYMD txtSeikyuSakuseiYMD
     */
    @JsonProperty("txtSeikyuSakuseiYMD")
    public void setTxtSeikyuSakuseiYMD(TextBoxDate txtSeikyuSakuseiYMD) {
        this.txtSeikyuSakuseiYMD = txtSeikyuSakuseiYMD;
    }

    /*
     * gettxtHdnShikibetsuCode
     * @return txtHdnShikibetsuCode
     */
    @JsonProperty("txtHdnShikibetsuCode")
    public TextBoxCode getTxtHdnShikibetsuCode() {
        return txtHdnShikibetsuCode;
    }

    /*
     * settxtHdnShikibetsuCode
     * @param txtHdnShikibetsuCode txtHdnShikibetsuCode
     */
    @JsonProperty("txtHdnShikibetsuCode")
    public void setTxtHdnShikibetsuCode(TextBoxCode txtHdnShikibetsuCode) {
        this.txtHdnShikibetsuCode = txtHdnShikibetsuCode;
    }

    /*
     * getddlKozaShubetsu
     * @return ddlKozaShubetsu
     */
    @JsonProperty("ddlKozaShubetsu")
    public DropDownList getDdlKozaShubetsu() {
        return ddlKozaShubetsu;
    }

    /*
     * setddlKozaShubetsu
     * @param ddlKozaShubetsu ddlKozaShubetsu
     */
    @JsonProperty("ddlKozaShubetsu")
    public void setDdlKozaShubetsu(DropDownList ddlKozaShubetsu) {
        this.ddlKozaShubetsu = ddlKozaShubetsu;
    }

    /*
     * gettxtKozaNo
     * @return txtKozaNo
     */
    @JsonProperty("txtKozaNo")
    public TextBoxCode getTxtKozaNo() {
        return txtKozaNo;
    }

    /*
     * settxtKozaNo
     * @param txtKozaNo txtKozaNo
     */
    @JsonProperty("txtKozaNo")
    public void setTxtKozaNo(TextBoxCode txtKozaNo) {
        this.txtKozaNo = txtKozaNo;
    }

    /*
     * gettxtKozaNameKana
     * @return txtKozaNameKana
     */
    @JsonProperty("txtKozaNameKana")
    public TextBoxKana getTxtKozaNameKana() {
        return txtKozaNameKana;
    }

    /*
     * settxtKozaNameKana
     * @param txtKozaNameKana txtKozaNameKana
     */
    @JsonProperty("txtKozaNameKana")
    public void setTxtKozaNameKana(TextBoxKana txtKozaNameKana) {
        this.txtKozaNameKana = txtKozaNameKana;
    }

    /*
     * gettxtKozaName
     * @return txtKozaName
     */
    @JsonProperty("txtKozaName")
    public TextBox getTxtKozaName() {
        return txtKozaName;
    }

    /*
     * settxtKozaName
     * @param txtKozaName txtKozaName
     */
    @JsonProperty("txtKozaName")
    public void setTxtKozaName(TextBox txtKozaName) {
        this.txtKozaName = txtKozaName;
    }

    /*
     * getccdKinyuKikanInput
     * @return ccdKinyuKikanInput
     */
    @JsonProperty("ccdKinyuKikanInput")
    public IKinyuKikanInputDiv getCcdKinyuKikanInput() {
        return ccdKinyuKikanInput;
    }

    // </editor-fold>
}
