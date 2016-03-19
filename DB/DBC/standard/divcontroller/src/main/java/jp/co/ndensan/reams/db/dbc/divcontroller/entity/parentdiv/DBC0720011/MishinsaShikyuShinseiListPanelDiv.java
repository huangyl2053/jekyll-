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
 * MishinsaShikyuShinseiListPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class MishinsaShikyuShinseiListPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKetteiYMD")
    private TextBoxDate txtKetteiYMD;
    @JsonProperty("dgMishinsaShikyuShinsei")
    private DataGrid<dgMishinsaShikyuShinsei_Row> dgMishinsaShikyuShinsei;
    @JsonProperty("ShinsaButton")
    private ShinsaButtonDiv ShinsaButton;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKetteiYMD
     * @return txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public TextBoxDate getTxtKetteiYMD() {
        return txtKetteiYMD;
    }

    /*
     * settxtKetteiYMD
     * @param txtKetteiYMD txtKetteiYMD
     */
    @JsonProperty("txtKetteiYMD")
    public void setTxtKetteiYMD(TextBoxDate txtKetteiYMD) {
        this.txtKetteiYMD = txtKetteiYMD;
    }

    /*
     * getdgMishinsaShikyuShinsei
     * @return dgMishinsaShikyuShinsei
     */
    @JsonProperty("dgMishinsaShikyuShinsei")
    public DataGrid<dgMishinsaShikyuShinsei_Row> getDgMishinsaShikyuShinsei() {
        return dgMishinsaShikyuShinsei;
    }

    /*
     * setdgMishinsaShikyuShinsei
     * @param dgMishinsaShikyuShinsei dgMishinsaShikyuShinsei
     */
    @JsonProperty("dgMishinsaShikyuShinsei")
    public void setDgMishinsaShikyuShinsei(DataGrid<dgMishinsaShikyuShinsei_Row> dgMishinsaShikyuShinsei) {
        this.dgMishinsaShikyuShinsei = dgMishinsaShikyuShinsei;
    }

    /*
     * getShinsaButton
     * @return ShinsaButton
     */
    @JsonProperty("ShinsaButton")
    public ShinsaButtonDiv getShinsaButton() {
        return ShinsaButton;
    }

    /*
     * setShinsaButton
     * @param ShinsaButton ShinsaButton
     */
    @JsonProperty("ShinsaButton")
    public void setShinsaButton(ShinsaButtonDiv ShinsaButton) {
        this.ShinsaButton = ShinsaButton;
    }

    // </editor-fold>
}
