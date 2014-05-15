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
 * KyotakuKeikakuTodokedeKaigoKihon のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuKeikakuTodokedeKaigoKihonDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblKaigoKihon1")
    private Label lblKaigoKihon1;
    @JsonProperty("lblKaigoKihon2")
    private Label lblKaigoKihon2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblKaigoKihon1")
    public Label getLblKaigoKihon1() {
        return lblKaigoKihon1;
    }

    @JsonProperty("lblKaigoKihon1")
    public void setLblKaigoKihon1(Label lblKaigoKihon1) {
        this.lblKaigoKihon1=lblKaigoKihon1;
    }

    @JsonProperty("lblKaigoKihon2")
    public Label getLblKaigoKihon2() {
        return lblKaigoKihon2;
    }

    @JsonProperty("lblKaigoKihon2")
    public void setLblKaigoKihon2(Label lblKaigoKihon2) {
        this.lblKaigoKihon2=lblKaigoKihon2;
    }

}
