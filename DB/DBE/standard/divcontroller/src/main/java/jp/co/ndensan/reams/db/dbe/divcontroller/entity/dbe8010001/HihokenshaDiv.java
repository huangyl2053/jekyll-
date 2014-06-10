package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * Hihokensha のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihokenshaNo")
    private TextBoxCode txtHihokenshaNo;
    @JsonProperty("txtShikibetsuCode")
    private TextBoxCode txtShikibetsuCode;
    @JsonProperty("txtHihokenshaShimei")
    private TextBox txtHihokenshaShimei;
    @JsonProperty("radShimeiSearchType")
    private RadioButton radShimeiSearchType;
    @JsonProperty("lblShimeiSearchType")
    private Label lblShimeiSearchType;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBoxCode getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.txtHihokenshaNo=txtHihokenshaNo;
    }

    @JsonProperty("txtShikibetsuCode")
    public TextBoxCode getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBoxCode txtShikibetsuCode) {
        this.txtShikibetsuCode=txtShikibetsuCode;
    }

    @JsonProperty("txtHihokenshaShimei")
    public TextBox getTxtHihokenshaShimei() {
        return txtHihokenshaShimei;
    }

    @JsonProperty("txtHihokenshaShimei")
    public void setTxtHihokenshaShimei(TextBox txtHihokenshaShimei) {
        this.txtHihokenshaShimei=txtHihokenshaShimei;
    }

    @JsonProperty("radShimeiSearchType")
    public RadioButton getRadShimeiSearchType() {
        return radShimeiSearchType;
    }

    @JsonProperty("radShimeiSearchType")
    public void setRadShimeiSearchType(RadioButton radShimeiSearchType) {
        this.radShimeiSearchType=radShimeiSearchType;
    }

    @JsonProperty("lblShimeiSearchType")
    public Label getLblShimeiSearchType() {
        return lblShimeiSearchType;
    }

    @JsonProperty("lblShimeiSearchType")
    public void setLblShimeiSearchType(Label lblShimeiSearchType) {
        this.lblShimeiSearchType=lblShimeiSearchType;
    }

}
