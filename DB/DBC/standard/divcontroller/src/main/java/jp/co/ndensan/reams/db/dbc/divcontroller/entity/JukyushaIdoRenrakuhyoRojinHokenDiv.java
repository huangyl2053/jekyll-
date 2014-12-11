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
 * JukyushaIdoRenrakuhyoRojinHoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoRojinHokenDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("RokenShichosonNo")
    private TextBoxCode RokenShichosonNo;
    @JsonProperty("RokenJukyushaNo")
    private TextBoxCode RokenJukyushaNo;
    @JsonProperty("RokenKohiFutanshaNo")
    private TextBoxCode RokenKohiFutanshaNo;
    @JsonProperty("Button8")
    private Button Button8;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("RokenShichosonNo")
    public TextBoxCode getRokenShichosonNo() {
        return RokenShichosonNo;
    }

    @JsonProperty("RokenShichosonNo")
    public void setRokenShichosonNo(TextBoxCode RokenShichosonNo) {
        this.RokenShichosonNo=RokenShichosonNo;
    }

    @JsonProperty("RokenJukyushaNo")
    public TextBoxCode getRokenJukyushaNo() {
        return RokenJukyushaNo;
    }

    @JsonProperty("RokenJukyushaNo")
    public void setRokenJukyushaNo(TextBoxCode RokenJukyushaNo) {
        this.RokenJukyushaNo=RokenJukyushaNo;
    }

    @JsonProperty("RokenKohiFutanshaNo")
    public TextBoxCode getRokenKohiFutanshaNo() {
        return RokenKohiFutanshaNo;
    }

    @JsonProperty("RokenKohiFutanshaNo")
    public void setRokenKohiFutanshaNo(TextBoxCode RokenKohiFutanshaNo) {
        this.RokenKohiFutanshaNo=RokenKohiFutanshaNo;
    }

    @JsonProperty("Button8")
    public Button getButton8() {
        return Button8;
    }

    @JsonProperty("Button8")
    public void setButton8(Button Button8) {
        this.Button8=Button8;
    }

}
