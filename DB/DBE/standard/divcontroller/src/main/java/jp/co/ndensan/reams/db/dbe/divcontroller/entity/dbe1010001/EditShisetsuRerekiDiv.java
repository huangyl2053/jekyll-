package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001;
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
 * EditShisetsuRereki のクラスファイル 
 * 
 * @author 自動生成
 */
public class EditShisetsuRerekiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShisetsuName")
    private TextBox txtShisetsuName;
    @JsonProperty("btnSearchShisetsu")
    private ButtonDialog btnSearchShisetsu;
    @JsonProperty("txtShisetsuNyushoDate")
    private TextBoxFlexibleDate txtShisetsuNyushoDate;
    @JsonProperty("txtShisetsuTaishoDate")
    private TextBoxFlexibleDate txtShisetsuTaishoDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShisetsuName")
    public TextBox getTxtShisetsuName() {
        return txtShisetsuName;
    }

    @JsonProperty("txtShisetsuName")
    public void setTxtShisetsuName(TextBox txtShisetsuName) {
        this.txtShisetsuName=txtShisetsuName;
    }

    @JsonProperty("btnSearchShisetsu")
    public ButtonDialog getBtnSearchShisetsu() {
        return btnSearchShisetsu;
    }

    @JsonProperty("btnSearchShisetsu")
    public void setBtnSearchShisetsu(ButtonDialog btnSearchShisetsu) {
        this.btnSearchShisetsu=btnSearchShisetsu;
    }

    @JsonProperty("txtShisetsuNyushoDate")
    public TextBoxFlexibleDate getTxtShisetsuNyushoDate() {
        return txtShisetsuNyushoDate;
    }

    @JsonProperty("txtShisetsuNyushoDate")
    public void setTxtShisetsuNyushoDate(TextBoxFlexibleDate txtShisetsuNyushoDate) {
        this.txtShisetsuNyushoDate=txtShisetsuNyushoDate;
    }

    @JsonProperty("txtShisetsuTaishoDate")
    public TextBoxFlexibleDate getTxtShisetsuTaishoDate() {
        return txtShisetsuTaishoDate;
    }

    @JsonProperty("txtShisetsuTaishoDate")
    public void setTxtShisetsuTaishoDate(TextBoxFlexibleDate txtShisetsuTaishoDate) {
        this.txtShisetsuTaishoDate=txtShisetsuTaishoDate;
    }

}
