package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0720011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchConditionToMishinsaShikyuShinseiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchConditionToMishinsaShikyuShinseiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShikyuShinseiDate")
    private TextBoxDateRange txtShikyuShinseiDate;
    @JsonProperty("btnSearchMishinsa")
    private Button btnSearchMishinsa;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShikyuShinseiDate
     * @return txtShikyuShinseiDate
     */
    @JsonProperty("txtShikyuShinseiDate")
    public TextBoxDateRange getTxtShikyuShinseiDate() {
        return txtShikyuShinseiDate;
    }

    /*
     * settxtShikyuShinseiDate
     * @param txtShikyuShinseiDate txtShikyuShinseiDate
     */
    @JsonProperty("txtShikyuShinseiDate")
    public void setTxtShikyuShinseiDate(TextBoxDateRange txtShikyuShinseiDate) {
        this.txtShikyuShinseiDate = txtShikyuShinseiDate;
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

    // </editor-fold>
}
