package jp.co.ndensan.reams.db.dbe.divcontroller.entity.serviceWithCountCom;
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
    @JsonProperty("txtNum")
    private TextBoxNum txtNum;
    @JsonProperty("radKaigoOrYobo")
    private RadioButton radKaigoOrYobo;

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

    @JsonProperty("txtNum")
    public TextBoxNum getTxtNum() {
        return txtNum;
    }

    @JsonProperty("txtNum")
    public void setTxtNum(TextBoxNum txtNum) {
        this.txtNum=txtNum;
    }

    @JsonProperty("radKaigoOrYobo")
    public RadioButton getRadKaigoOrYobo() {
        return radKaigoOrYobo;
    }

    @JsonProperty("radKaigoOrYobo")
    public void setRadKaigoOrYobo(RadioButton radKaigoOrYobo) {
        this.radKaigoOrYobo=radKaigoOrYobo;
    }

}
