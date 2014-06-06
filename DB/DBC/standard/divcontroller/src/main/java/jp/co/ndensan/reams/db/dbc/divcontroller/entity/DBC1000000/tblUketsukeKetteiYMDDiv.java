package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1000000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tblUketsukeKetteiYMD のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblUketsukeKetteiYMDDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celUketsukeKetteiRadio")
    private celUketsukeKetteiRadioAttblUketsukeKetteiYMD celUketsukeKetteiRadio;
    @JsonProperty("celUketsukeKetteiText")
    private celUketsukeKetteiTextAttblUketsukeKetteiYMD celUketsukeKetteiText;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public RadioButton getRadUketsukeKetteiYMD() {
        return this.celUketsukeKetteiRadio.getRadUketsukeKetteiYMD();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtUketsukeYMD() {
        return this.celUketsukeKetteiText.getTxtUketsukeYMD();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKetteiYMD() {
        return this.celUketsukeKetteiText.getTxtKetteiYMD();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celUketsukeKetteiRadio")
    private celUketsukeKetteiRadioAttblUketsukeKetteiYMD getCelUketsukeKetteiRadio() {
        return celUketsukeKetteiRadio;
    }

    @JsonProperty("celUketsukeKetteiRadio")
    private void setCelUketsukeKetteiRadio(celUketsukeKetteiRadioAttblUketsukeKetteiYMD celUketsukeKetteiRadio) {
        this.celUketsukeKetteiRadio=celUketsukeKetteiRadio;
    }

    @JsonProperty("celUketsukeKetteiText")
    private celUketsukeKetteiTextAttblUketsukeKetteiYMD getCelUketsukeKetteiText() {
        return celUketsukeKetteiText;
    }

    @JsonProperty("celUketsukeKetteiText")
    private void setCelUketsukeKetteiText(celUketsukeKetteiTextAttblUketsukeKetteiYMD celUketsukeKetteiText) {
        this.celUketsukeKetteiText=celUketsukeKetteiText;
    }

}
/**
 * celUketsukeKetteiRadio のクラスファイル 
 * 
 * @author 自動生成
 */
class celUketsukeKetteiRadioAttblUketsukeKetteiYMD extends TableCell {
    @JsonProperty("radUketsukeKetteiYMD")
    private RadioButton radUketsukeKetteiYMD;

    @JsonProperty("radUketsukeKetteiYMD")
    public RadioButton getRadUketsukeKetteiYMD() {
        return radUketsukeKetteiYMD;
    }

    @JsonProperty("radUketsukeKetteiYMD")
    public void setRadUketsukeKetteiYMD(RadioButton radUketsukeKetteiYMD) {
        this.radUketsukeKetteiYMD=radUketsukeKetteiYMD;
    }

}
/**
 * celUketsukeKetteiText のクラスファイル 
 * 
 * @author 自動生成
 */
class celUketsukeKetteiTextAttblUketsukeKetteiYMD extends TableCell {
    @JsonProperty("txtUketsukeYMD")
    private TextBoxDateRange txtUketsukeYMD;
    @JsonProperty("txtKetteiYMD")
    private TextBoxDateRange txtKetteiYMD;

    @JsonProperty("txtUketsukeYMD")
    public TextBoxDateRange getTxtUketsukeYMD() {
        return txtUketsukeYMD;
    }

    @JsonProperty("txtUketsukeYMD")
    public void setTxtUketsukeYMD(TextBoxDateRange txtUketsukeYMD) {
        this.txtUketsukeYMD=txtUketsukeYMD;
    }

    @JsonProperty("txtKetteiYMD")
    public TextBoxDateRange getTxtKetteiYMD() {
        return txtKetteiYMD;
    }

    @JsonProperty("txtKetteiYMD")
    public void setTxtKetteiYMD(TextBoxDateRange txtKetteiYMD) {
        this.txtKetteiYMD=txtKetteiYMD;
    }

}
