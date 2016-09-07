package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ServiceShuruiShousai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceShuruiShousaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtServiceCode")
    private TextBox txtServiceCode;
    @JsonProperty("txtTeikyoKaishiYM")
    private TextBoxDate txtTeikyoKaishiYM;
    @JsonProperty("txtTeikyoShuryoYM")
    private TextBoxDate txtTeikyoShuryoYM;
    @JsonProperty("txtServiceMeisho")
    private TextBox txtServiceMeisho;
    @JsonProperty("txtServiceRyakusho")
    private TextBox txtServiceRyakusho;
    @JsonProperty("ddlServiceBunruiCode")
    private DropDownList ddlServiceBunruiCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtServiceCode
     * @return txtServiceCode
     */
    @JsonProperty("txtServiceCode")
    public TextBox getTxtServiceCode() {
        return txtServiceCode;
    }

    /*
     * settxtServiceCode
     * @param txtServiceCode txtServiceCode
     */
    @JsonProperty("txtServiceCode")
    public void setTxtServiceCode(TextBox txtServiceCode) {
        this.txtServiceCode = txtServiceCode;
    }

    /*
     * gettxtTeikyoKaishiYM
     * @return txtTeikyoKaishiYM
     */
    @JsonProperty("txtTeikyoKaishiYM")
    public TextBoxDate getTxtTeikyoKaishiYM() {
        return txtTeikyoKaishiYM;
    }

    /*
     * settxtTeikyoKaishiYM
     * @param txtTeikyoKaishiYM txtTeikyoKaishiYM
     */
    @JsonProperty("txtTeikyoKaishiYM")
    public void setTxtTeikyoKaishiYM(TextBoxDate txtTeikyoKaishiYM) {
        this.txtTeikyoKaishiYM = txtTeikyoKaishiYM;
    }

    /*
     * gettxtTeikyoShuryoYM
     * @return txtTeikyoShuryoYM
     */
    @JsonProperty("txtTeikyoShuryoYM")
    public TextBoxDate getTxtTeikyoShuryoYM() {
        return txtTeikyoShuryoYM;
    }

    /*
     * settxtTeikyoShuryoYM
     * @param txtTeikyoShuryoYM txtTeikyoShuryoYM
     */
    @JsonProperty("txtTeikyoShuryoYM")
    public void setTxtTeikyoShuryoYM(TextBoxDate txtTeikyoShuryoYM) {
        this.txtTeikyoShuryoYM = txtTeikyoShuryoYM;
    }

    /*
     * gettxtServiceMeisho
     * @return txtServiceMeisho
     */
    @JsonProperty("txtServiceMeisho")
    public TextBox getTxtServiceMeisho() {
        return txtServiceMeisho;
    }

    /*
     * settxtServiceMeisho
     * @param txtServiceMeisho txtServiceMeisho
     */
    @JsonProperty("txtServiceMeisho")
    public void setTxtServiceMeisho(TextBox txtServiceMeisho) {
        this.txtServiceMeisho = txtServiceMeisho;
    }

    /*
     * gettxtServiceRyakusho
     * @return txtServiceRyakusho
     */
    @JsonProperty("txtServiceRyakusho")
    public TextBox getTxtServiceRyakusho() {
        return txtServiceRyakusho;
    }

    /*
     * settxtServiceRyakusho
     * @param txtServiceRyakusho txtServiceRyakusho
     */
    @JsonProperty("txtServiceRyakusho")
    public void setTxtServiceRyakusho(TextBox txtServiceRyakusho) {
        this.txtServiceRyakusho = txtServiceRyakusho;
    }

    /*
     * getddlServiceBunruiCode
     * @return ddlServiceBunruiCode
     */
    @JsonProperty("ddlServiceBunruiCode")
    public DropDownList getDdlServiceBunruiCode() {
        return ddlServiceBunruiCode;
    }

    /*
     * setddlServiceBunruiCode
     * @param ddlServiceBunruiCode ddlServiceBunruiCode
     */
    @JsonProperty("ddlServiceBunruiCode")
    public void setDdlServiceBunruiCode(DropDownList ddlServiceBunruiCode) {
        this.ddlServiceBunruiCode = ddlServiceBunruiCode;
    }

    // </editor-fold>
}
