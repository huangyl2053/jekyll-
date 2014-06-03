package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgIkenshoTorikomiKekka_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShujiiIkenshoImageTorikomi のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIkenshoImageTorikomiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnIkenshoTorikomi")
    private Button btnIkenshoTorikomi;
    @JsonProperty("radIkenshoShubetsu")
    private RadioButton radIkenshoShubetsu;
    @JsonProperty("lblTorikomiKekka")
    private Label lblTorikomiKekka;
    @JsonProperty("txtErrKensu")
    private TextBoxNum txtErrKensu;
    @JsonProperty("dgIkenshoTorikomiKekka")
    private DataGrid<dgIkenshoTorikomiKekka_Row> dgIkenshoTorikomiKekka;
    @JsonProperty("btnSave")
    private Button btnSave;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnIkenshoTorikomi")
    public Button getBtnIkenshoTorikomi() {
        return btnIkenshoTorikomi;
    }

    @JsonProperty("btnIkenshoTorikomi")
    public void setBtnIkenshoTorikomi(Button btnIkenshoTorikomi) {
        this.btnIkenshoTorikomi=btnIkenshoTorikomi;
    }

    @JsonProperty("radIkenshoShubetsu")
    public RadioButton getRadIkenshoShubetsu() {
        return radIkenshoShubetsu;
    }

    @JsonProperty("radIkenshoShubetsu")
    public void setRadIkenshoShubetsu(RadioButton radIkenshoShubetsu) {
        this.radIkenshoShubetsu=radIkenshoShubetsu;
    }

    @JsonProperty("lblTorikomiKekka")
    public Label getLblTorikomiKekka() {
        return lblTorikomiKekka;
    }

    @JsonProperty("lblTorikomiKekka")
    public void setLblTorikomiKekka(Label lblTorikomiKekka) {
        this.lblTorikomiKekka=lblTorikomiKekka;
    }

    @JsonProperty("txtErrKensu")
    public TextBoxNum getTxtErrKensu() {
        return txtErrKensu;
    }

    @JsonProperty("txtErrKensu")
    public void setTxtErrKensu(TextBoxNum txtErrKensu) {
        this.txtErrKensu=txtErrKensu;
    }

    @JsonProperty("dgIkenshoTorikomiKekka")
    public DataGrid<dgIkenshoTorikomiKekka_Row> getDgIkenshoTorikomiKekka() {
        return dgIkenshoTorikomiKekka;
    }

    @JsonProperty("dgIkenshoTorikomiKekka")
    public void setDgIkenshoTorikomiKekka(DataGrid<dgIkenshoTorikomiKekka_Row> dgIkenshoTorikomiKekka) {
        this.dgIkenshoTorikomiKekka=dgIkenshoTorikomiKekka;
    }

    @JsonProperty("btnSave")
    public Button getBtnSave() {
        return btnSave;
    }

    @JsonProperty("btnSave")
    public void setBtnSave(Button btnSave) {
        this.btnSave=btnSave;
    }

}
