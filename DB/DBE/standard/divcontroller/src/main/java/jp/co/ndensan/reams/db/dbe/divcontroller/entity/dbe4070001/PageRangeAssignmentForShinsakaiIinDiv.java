package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001;
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
 * PageRangeAssignmentForShinsakaiIin のクラスファイル 
 * 
 * @author 自動生成
 */
public class PageRangeAssignmentForShinsakaiIinDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblPageRangeForShinsakaiIin")
    private Label lblPageRangeForShinsakaiIin;
    @JsonProperty("txtPageRangeAssignmentForShinsakaiIinFrom")
    private TextBoxNum txtPageRangeAssignmentForShinsakaiIinFrom;
    @JsonProperty("lblPageRangeForShinsakaiIinWave")
    private Label lblPageRangeForShinsakaiIinWave;
    @JsonProperty("txtPageRangeAssignmentForShinsakaiIinTo")
    private TextBoxNum txtPageRangeAssignmentForShinsakaiIinTo;
    @JsonProperty("lblPageRangeForShinsakaiIin2")
    private Label lblPageRangeForShinsakaiIin2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblPageRangeForShinsakaiIin")
    public Label getLblPageRangeForShinsakaiIin() {
        return lblPageRangeForShinsakaiIin;
    }

    @JsonProperty("lblPageRangeForShinsakaiIin")
    public void setLblPageRangeForShinsakaiIin(Label lblPageRangeForShinsakaiIin) {
        this.lblPageRangeForShinsakaiIin=lblPageRangeForShinsakaiIin;
    }

    @JsonProperty("txtPageRangeAssignmentForShinsakaiIinFrom")
    public TextBoxNum getTxtPageRangeAssignmentForShinsakaiIinFrom() {
        return txtPageRangeAssignmentForShinsakaiIinFrom;
    }

    @JsonProperty("txtPageRangeAssignmentForShinsakaiIinFrom")
    public void setTxtPageRangeAssignmentForShinsakaiIinFrom(TextBoxNum txtPageRangeAssignmentForShinsakaiIinFrom) {
        this.txtPageRangeAssignmentForShinsakaiIinFrom=txtPageRangeAssignmentForShinsakaiIinFrom;
    }

    @JsonProperty("lblPageRangeForShinsakaiIinWave")
    public Label getLblPageRangeForShinsakaiIinWave() {
        return lblPageRangeForShinsakaiIinWave;
    }

    @JsonProperty("lblPageRangeForShinsakaiIinWave")
    public void setLblPageRangeForShinsakaiIinWave(Label lblPageRangeForShinsakaiIinWave) {
        this.lblPageRangeForShinsakaiIinWave=lblPageRangeForShinsakaiIinWave;
    }

    @JsonProperty("txtPageRangeAssignmentForShinsakaiIinTo")
    public TextBoxNum getTxtPageRangeAssignmentForShinsakaiIinTo() {
        return txtPageRangeAssignmentForShinsakaiIinTo;
    }

    @JsonProperty("txtPageRangeAssignmentForShinsakaiIinTo")
    public void setTxtPageRangeAssignmentForShinsakaiIinTo(TextBoxNum txtPageRangeAssignmentForShinsakaiIinTo) {
        this.txtPageRangeAssignmentForShinsakaiIinTo=txtPageRangeAssignmentForShinsakaiIinTo;
    }

    @JsonProperty("lblPageRangeForShinsakaiIin2")
    public Label getLblPageRangeForShinsakaiIin2() {
        return lblPageRangeForShinsakaiIin2;
    }

    @JsonProperty("lblPageRangeForShinsakaiIin2")
    public void setLblPageRangeForShinsakaiIin2(Label lblPageRangeForShinsakaiIin2) {
        this.lblPageRangeForShinsakaiIin2=lblPageRangeForShinsakaiIin2;
    }

}
