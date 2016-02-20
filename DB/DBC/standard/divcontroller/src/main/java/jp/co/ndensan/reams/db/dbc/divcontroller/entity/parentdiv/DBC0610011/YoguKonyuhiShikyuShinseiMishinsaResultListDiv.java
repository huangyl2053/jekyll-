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
 * YoguKonyuhiShikyuShinseiMishinsaResultList のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoguKonyuhiShikyuShinseiMishinsaResultListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TextBoxDate2")
    private TextBoxDate TextBoxDate2;
    @JsonProperty("dgYoguKonyuhiShisaMishinsaShikyuShinseiList")
    private DataGrid<dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row> dgYoguKonyuhiShisaMishinsaShikyuShinseiList;
    @JsonProperty("btnIkkatsuShinsa")
    private Button btnIkkatsuShinsa;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTextBoxDate2
     * @return TextBoxDate2
     */
    @JsonProperty("TextBoxDate2")
    public TextBoxDate getTextBoxDate2() {
        return TextBoxDate2;
    }

    /*
     * setTextBoxDate2
     * @param TextBoxDate2 TextBoxDate2
     */
    @JsonProperty("TextBoxDate2")
    public void setTextBoxDate2(TextBoxDate TextBoxDate2) {
        this.TextBoxDate2 = TextBoxDate2;
    }

    /*
     * getdgYoguKonyuhiShisaMishinsaShikyuShinseiList
     * @return dgYoguKonyuhiShisaMishinsaShikyuShinseiList
     */
    @JsonProperty("dgYoguKonyuhiShisaMishinsaShikyuShinseiList")
    public DataGrid<dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row> getDgYoguKonyuhiShisaMishinsaShikyuShinseiList() {
        return dgYoguKonyuhiShisaMishinsaShikyuShinseiList;
    }

    /*
     * setdgYoguKonyuhiShisaMishinsaShikyuShinseiList
     * @param dgYoguKonyuhiShisaMishinsaShikyuShinseiList dgYoguKonyuhiShisaMishinsaShikyuShinseiList
     */
    @JsonProperty("dgYoguKonyuhiShisaMishinsaShikyuShinseiList")
    public void setDgYoguKonyuhiShisaMishinsaShikyuShinseiList(DataGrid<dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row> dgYoguKonyuhiShisaMishinsaShikyuShinseiList) {
        this.dgYoguKonyuhiShisaMishinsaShikyuShinseiList = dgYoguKonyuhiShisaMishinsaShikyuShinseiList;
    }

    /*
     * getbtnIkkatsuShinsa
     * @return btnIkkatsuShinsa
     */
    @JsonProperty("btnIkkatsuShinsa")
    public Button getBtnIkkatsuShinsa() {
        return btnIkkatsuShinsa;
    }

    /*
     * setbtnIkkatsuShinsa
     * @param btnIkkatsuShinsa btnIkkatsuShinsa
     */
    @JsonProperty("btnIkkatsuShinsa")
    public void setBtnIkkatsuShinsa(Button btnIkkatsuShinsa) {
        this.btnIkkatsuShinsa = btnIkkatsuShinsa;
    }

    // </editor-fold>
}
