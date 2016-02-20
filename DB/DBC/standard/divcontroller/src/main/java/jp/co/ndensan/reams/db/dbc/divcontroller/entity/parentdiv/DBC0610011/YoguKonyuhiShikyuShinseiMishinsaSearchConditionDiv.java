package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0610011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YoguKonyuhiShikyuShinseiMishinsaSearchCondition のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoguKonyuhiShikyuShinseiMishinsaSearchConditionDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShikyuShinseiDateRange")
    private TextBoxDateRange txtShikyuShinseiDateRange;
    @JsonProperty("btnSearchMishinsa")
    private Button btnSearchMishinsa;
    @JsonProperty("ddlHokensha")
    private DropDownList ddlHokensha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShikyuShinseiDateRange
     * @return txtShikyuShinseiDateRange
     */
    @JsonProperty("txtShikyuShinseiDateRange")
    public TextBoxDateRange getTxtShikyuShinseiDateRange() {
        return txtShikyuShinseiDateRange;
    }

    /*
     * settxtShikyuShinseiDateRange
     * @param txtShikyuShinseiDateRange txtShikyuShinseiDateRange
     */
    @JsonProperty("txtShikyuShinseiDateRange")
    public void setTxtShikyuShinseiDateRange(TextBoxDateRange txtShikyuShinseiDateRange) {
        this.txtShikyuShinseiDateRange = txtShikyuShinseiDateRange;
    }

    /*
     * getbtnSearchMishinsa
     * @return btnSearchMishinsa
     */
    @JsonProperty("btnSearchMishinsa")
    public Button getBtnSearchMishinsa() {
        return btnSearchMishinsa;
    }

    /*
     * setbtnSearchMishinsa
     * @param btnSearchMishinsa btnSearchMishinsa
     */
    @JsonProperty("btnSearchMishinsa")
    public void setBtnSearchMishinsa(Button btnSearchMishinsa) {
        this.btnSearchMishinsa = btnSearchMishinsa;
    }

    /*
     * getddlHokensha
     * @return ddlHokensha
     */
    @JsonProperty("ddlHokensha")
    public DropDownList getDdlHokensha() {
        return ddlHokensha;
    }

    /*
     * setddlHokensha
     * @param ddlHokensha ddlHokensha
     */
    @JsonProperty("ddlHokensha")
    public void setDdlHokensha(DropDownList ddlHokensha) {
        this.ddlHokensha = ddlHokensha;
    }

    // </editor-fold>
}
