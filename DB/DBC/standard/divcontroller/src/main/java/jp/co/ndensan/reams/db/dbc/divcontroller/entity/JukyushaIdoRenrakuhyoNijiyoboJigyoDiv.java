package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
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
 * JukyushaIdoRenrakuhyoNijiyoboJigyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoNijiyoboJigyoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radNijiyoboJigyoKubun")
    private RadioButton radNijiyoboJigyoKubun;
    @JsonProperty("txtNijiyoboJigyoYukoDateRange")
    private TextBoxDateRange txtNijiyoboJigyoYukoDateRange;
    @JsonProperty("Button7")
    private Button Button7;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radNijiyoboJigyoKubun")
    public RadioButton getRadNijiyoboJigyoKubun() {
        return radNijiyoboJigyoKubun;
    }

    @JsonProperty("radNijiyoboJigyoKubun")
    public void setRadNijiyoboJigyoKubun(RadioButton radNijiyoboJigyoKubun) {
        this.radNijiyoboJigyoKubun=radNijiyoboJigyoKubun;
    }

    @JsonProperty("txtNijiyoboJigyoYukoDateRange")
    public TextBoxDateRange getTxtNijiyoboJigyoYukoDateRange() {
        return txtNijiyoboJigyoYukoDateRange;
    }

    @JsonProperty("txtNijiyoboJigyoYukoDateRange")
    public void setTxtNijiyoboJigyoYukoDateRange(TextBoxDateRange txtNijiyoboJigyoYukoDateRange) {
        this.txtNijiyoboJigyoYukoDateRange=txtNijiyoboJigyoYukoDateRange;
    }

    @JsonProperty("Button7")
    public Button getButton7() {
        return Button7;
    }

    @JsonProperty("Button7")
    public void setButton7(Button Button7) {
        this.Button7=Button7;
    }

}
