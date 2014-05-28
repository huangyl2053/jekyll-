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
 * KyotakuJikoTodokedeKihon のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuJikoTodokedeKihonDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblKihon1")
    private Label lblKihon1;
    @JsonProperty("lblKihon2")
    private Label lblKihon2;
    @JsonProperty("lblKihon3")
    private Label lblKihon3;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblKihon1")
    public Label getLblKihon1() {
        return lblKihon1;
    }

    @JsonProperty("lblKihon1")
    public void setLblKihon1(Label lblKihon1) {
        this.lblKihon1=lblKihon1;
    }

    @JsonProperty("lblKihon2")
    public Label getLblKihon2() {
        return lblKihon2;
    }

    @JsonProperty("lblKihon2")
    public void setLblKihon2(Label lblKihon2) {
        this.lblKihon2=lblKihon2;
    }

    @JsonProperty("lblKihon3")
    public Label getLblKihon3() {
        return lblKihon3;
    }

    @JsonProperty("lblKihon3")
    public void setLblKihon3(Label lblKihon3) {
        this.lblKihon3=lblKihon3;
    }

}
