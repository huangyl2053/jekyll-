package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0610011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * YoguKonyuhiShikyuShinseiMishinsaResultList のクラスファイル
 *
 * @reamsid_L DBC-1020-040 gongliang
 */
public class YoguKonyuhiShikyuShinseiMishinsaResultListDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKetteiYMD")
    private TextBoxDate txtKetteiYMD;
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
