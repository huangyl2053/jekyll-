package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * KubunShikyuGendogaku のクラスファイル
 *
 * @reamsid_L DBC-3350-010 jiangzongyue
 */
public class KubunShikyuGendogakuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTsuika")
    private Button btnTsuika;
    @JsonProperty("dgServiceShurui")
    private DataGrid<dgServiceShurui_Row> dgServiceShurui;
    @JsonProperty("ServiceShuruiShousai")
    private ServiceShuruiShousaiDiv ServiceShuruiShousai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnTsuika
     * @return btnTsuika
     */
    @JsonProperty("btnTsuika")
    public Button getBtnTsuika() {
        return btnTsuika;
    }

    /*
     * setbtnTsuika
     * @param btnTsuika btnTsuika
     */
    @JsonProperty("btnTsuika")
    public void setBtnTsuika(Button btnTsuika) {
        this.btnTsuika = btnTsuika;
    }

    /*
     * getdgServiceShurui
     * @return dgServiceShurui
     */
    @JsonProperty("dgServiceShurui")
    public DataGrid<dgServiceShurui_Row> getDgServiceShurui() {
        return dgServiceShurui;
    }

    /*
     * setdgServiceShurui
     * @param dgServiceShurui dgServiceShurui
     */
    @JsonProperty("dgServiceShurui")
    public void setDgServiceShurui(DataGrid<dgServiceShurui_Row> dgServiceShurui) {
        this.dgServiceShurui = dgServiceShurui;
    }

    /*
     * getServiceShuruiShousai
     * @return ServiceShuruiShousai
     */
    @JsonProperty("ServiceShuruiShousai")
    public ServiceShuruiShousaiDiv getServiceShuruiShousai() {
        return ServiceShuruiShousai;
    }

    /*
     * setServiceShuruiShousai
     * @param ServiceShuruiShousai ServiceShuruiShousai
     */
    @JsonProperty("ServiceShuruiShousai")
    public void setServiceShuruiShousai(ServiceShuruiShousaiDiv ServiceShuruiShousai) {
        this.ServiceShuruiShousai = ServiceShuruiShousai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtServiceCode() {
        return this.getServiceShuruiShousai().getTxtServiceCode();
    }

    @JsonIgnore
    public void setTxtServiceCode(TextBox txtServiceCode) {
        this.getServiceShuruiShousai().setTxtServiceCode(txtServiceCode);
    }

    @JsonIgnore
    public TextBoxDate getTxtTeikyoKaishiYM() {
        return this.getServiceShuruiShousai().getTxtTeikyoKaishiYM();
    }

    @JsonIgnore
    public void setTxtTeikyoKaishiYM(TextBoxDate txtTeikyoKaishiYM) {
        this.getServiceShuruiShousai().setTxtTeikyoKaishiYM(txtTeikyoKaishiYM);
    }

    @JsonIgnore
    public TextBoxDate getTxtTeikyoShuryoYM() {
        return this.getServiceShuruiShousai().getTxtTeikyoShuryoYM();
    }

    @JsonIgnore
    public void setTxtTeikyoShuryoYM(TextBoxDate txtTeikyoShuryoYM) {
        this.getServiceShuruiShousai().setTxtTeikyoShuryoYM(txtTeikyoShuryoYM);
    }

    @JsonIgnore
    public TextBox getTxtServiceMeisho() {
        return this.getServiceShuruiShousai().getTxtServiceMeisho();
    }

    @JsonIgnore
    public void setTxtServiceMeisho(TextBox txtServiceMeisho) {
        this.getServiceShuruiShousai().setTxtServiceMeisho(txtServiceMeisho);
    }

    @JsonIgnore
    public TextBox getTxtServiceRyakusho() {
        return this.getServiceShuruiShousai().getTxtServiceRyakusho();
    }

    @JsonIgnore
    public void setTxtServiceRyakusho(TextBox txtServiceRyakusho) {
        this.getServiceShuruiShousai().setTxtServiceRyakusho(txtServiceRyakusho);
    }

    @JsonIgnore
    public DropDownList getDdlServiceBunruiCode() {
        return this.getServiceShuruiShousai().getDdlServiceBunruiCode();
    }

    @JsonIgnore
    public void setDdlServiceBunruiCode(DropDownList ddlServiceBunruiCode) {
        this.getServiceShuruiShousai().setDdlServiceBunruiCode(ddlServiceBunruiCode);
    }

    // </editor-fold>
}
