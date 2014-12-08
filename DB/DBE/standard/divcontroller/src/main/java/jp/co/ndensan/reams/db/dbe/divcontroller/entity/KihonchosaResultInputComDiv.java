package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.IKihonchosaResultInputComDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KihonchosaResultInputCom のクラスファイル 
 * 
 * @author 自動生成
 */
public class KihonchosaResultInputComDiv extends Panel implements IKihonchosaResultInputComDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblItemNo")
    private Label lblItemNo;
    @JsonProperty("lblItemName")
    private Label lblItemName;
    @JsonProperty("txtAnswer")
    private TextBox txtAnswer;
    @JsonProperty("radChoices")
    private RadioButton radChoices;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblItemNo")
    public Label getLblItemNo() {
        return lblItemNo;
    }

    @JsonProperty("lblItemNo")
    public void setLblItemNo(Label lblItemNo) {
        this.lblItemNo=lblItemNo;
    }

    @JsonProperty("lblItemName")
    public Label getLblItemName() {
        return lblItemName;
    }

    @JsonProperty("lblItemName")
    public void setLblItemName(Label lblItemName) {
        this.lblItemName=lblItemName;
    }

    @JsonProperty("txtAnswer")
    public TextBox getTxtAnswer() {
        return txtAnswer;
    }

    @JsonProperty("txtAnswer")
    public void setTxtAnswer(TextBox txtAnswer) {
        this.txtAnswer=txtAnswer;
    }

    @JsonProperty("radChoices")
    public RadioButton getRadChoices() {
        return radChoices;
    }

    @JsonProperty("radChoices")
    public void setRadChoices(RadioButton radChoices) {
        this.radChoices=radChoices;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
