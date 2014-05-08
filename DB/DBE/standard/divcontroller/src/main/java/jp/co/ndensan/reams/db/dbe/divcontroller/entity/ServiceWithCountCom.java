package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.CompositeControl;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * defaultLayout のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceWithCountCom extends CompositeControl {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblServiceName")
    private Label lblServiceName;
    @JsonProperty("lblFrequency")
    private Label lblFrequency;
    @JsonProperty("txtNum")
    private TextBoxNum txtNum;
    @JsonProperty("lblUnit")
    private Label lblUnit;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblServiceName")
    public Label getLblServiceName() {
        return lblServiceName;
    }

    @JsonProperty("lblServiceName")
    public void setLblServiceName(Label lblServiceName) {
        this.lblServiceName=lblServiceName;
    }

    @JsonProperty("lblFrequency")
    public Label getLblFrequency() {
        return lblFrequency;
    }

    @JsonProperty("lblFrequency")
    public void setLblFrequency(Label lblFrequency) {
        this.lblFrequency=lblFrequency;
    }

    @JsonProperty("txtNum")
    public TextBoxNum getTxtNum() {
        return txtNum;
    }

    @JsonProperty("txtNum")
    public void setTxtNum(TextBoxNum txtNum) {
        this.txtNum=txtNum;
    }

    @JsonProperty("lblUnit")
    public Label getLblUnit() {
        return lblUnit;
    }

    @JsonProperty("lblUnit")
    public void setLblUnit(Label lblUnit) {
        this.lblUnit=lblUnit;
    }

}
