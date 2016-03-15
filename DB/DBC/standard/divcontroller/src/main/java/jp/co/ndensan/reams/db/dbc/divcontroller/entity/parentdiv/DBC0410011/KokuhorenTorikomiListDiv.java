package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KokuhorenTorikomiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class KokuhorenTorikomiListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShoriYM")
    private TextBoxDate txtShoriYM;
    @JsonProperty("btnScheduleSetting")
    private Button btnScheduleSetting;
    @JsonProperty("dgKokuhorenTorikomiList")
    private DataGrid<dgKokuhorenTorikomiList_Row> dgKokuhorenTorikomiList;
    @JsonProperty("lblUketoriTorikomi")
    private Label lblUketoriTorikomi;
    @JsonProperty("lblKokuhorenTorikomiList")
    private Label lblKokuhorenTorikomiList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShoriYM
     * @return txtShoriYM
     */
    @JsonProperty("txtShoriYM")
    public TextBoxDate getTxtShoriYM() {
        return txtShoriYM;
    }

    /*
     * settxtShoriYM
     * @param txtShoriYM txtShoriYM
     */
    @JsonProperty("txtShoriYM")
    public void setTxtShoriYM(TextBoxDate txtShoriYM) {
        this.txtShoriYM = txtShoriYM;
    }

    /*
     * getbtnScheduleSetting
     * @return btnScheduleSetting
     */
    @JsonProperty("btnScheduleSetting")
    public Button getBtnScheduleSetting() {
        return btnScheduleSetting;
    }

    /*
     * setbtnScheduleSetting
     * @param btnScheduleSetting btnScheduleSetting
     */
    @JsonProperty("btnScheduleSetting")
    public void setBtnScheduleSetting(Button btnScheduleSetting) {
        this.btnScheduleSetting = btnScheduleSetting;
    }

    /*
     * getdgKokuhorenTorikomiList
     * @return dgKokuhorenTorikomiList
     */
    @JsonProperty("dgKokuhorenTorikomiList")
    public DataGrid<dgKokuhorenTorikomiList_Row> getDgKokuhorenTorikomiList() {
        return dgKokuhorenTorikomiList;
    }

    /*
     * setdgKokuhorenTorikomiList
     * @param dgKokuhorenTorikomiList dgKokuhorenTorikomiList
     */
    @JsonProperty("dgKokuhorenTorikomiList")
    public void setDgKokuhorenTorikomiList(DataGrid<dgKokuhorenTorikomiList_Row> dgKokuhorenTorikomiList) {
        this.dgKokuhorenTorikomiList = dgKokuhorenTorikomiList;
    }

    /*
     * getlblUketoriTorikomi
     * @return lblUketoriTorikomi
     */
    @JsonProperty("lblUketoriTorikomi")
    public Label getLblUketoriTorikomi() {
        return lblUketoriTorikomi;
    }

    /*
     * setlblUketoriTorikomi
     * @param lblUketoriTorikomi lblUketoriTorikomi
     */
    @JsonProperty("lblUketoriTorikomi")
    public void setLblUketoriTorikomi(Label lblUketoriTorikomi) {
        this.lblUketoriTorikomi = lblUketoriTorikomi;
    }

    /*
     * getlblKokuhorenTorikomiList
     * @return lblKokuhorenTorikomiList
     */
    @JsonProperty("lblKokuhorenTorikomiList")
    public Label getLblKokuhorenTorikomiList() {
        return lblKokuhorenTorikomiList;
    }

    /*
     * setlblKokuhorenTorikomiList
     * @param lblKokuhorenTorikomiList lblKokuhorenTorikomiList
     */
    @JsonProperty("lblKokuhorenTorikomiList")
    public void setLblKokuhorenTorikomiList(Label lblKokuhorenTorikomiList) {
        this.lblKokuhorenTorikomiList = lblKokuhorenTorikomiList;
    }

    // </editor-fold>
}
