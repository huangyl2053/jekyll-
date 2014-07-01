package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010002;
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
 * EditShinsakaiIin のクラスファイル 
 * 
 * @author 自動生成
 */
public class EditShinsakaiIinDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKankeiIinCode")
    private TextBoxCode txtKankeiIinCode;
    @JsonProperty("btnSearchShinsakaiIin")
    private ButtonDialog btnSearchShinsakaiIin;
    @JsonProperty("txtKankeiIinName")
    private TextBox txtKankeiIinName;
    @JsonProperty("txtShozokuKikan")
    private TextBox txtShozokuKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKankeiIinCode")
    public TextBoxCode getTxtKankeiIinCode() {
        return txtKankeiIinCode;
    }

    @JsonProperty("txtKankeiIinCode")
    public void setTxtKankeiIinCode(TextBoxCode txtKankeiIinCode) {
        this.txtKankeiIinCode=txtKankeiIinCode;
    }

    @JsonProperty("btnSearchShinsakaiIin")
    public ButtonDialog getBtnSearchShinsakaiIin() {
        return btnSearchShinsakaiIin;
    }

    @JsonProperty("btnSearchShinsakaiIin")
    public void setBtnSearchShinsakaiIin(ButtonDialog btnSearchShinsakaiIin) {
        this.btnSearchShinsakaiIin=btnSearchShinsakaiIin;
    }

    @JsonProperty("txtKankeiIinName")
    public TextBox getTxtKankeiIinName() {
        return txtKankeiIinName;
    }

    @JsonProperty("txtKankeiIinName")
    public void setTxtKankeiIinName(TextBox txtKankeiIinName) {
        this.txtKankeiIinName=txtKankeiIinName;
    }

    @JsonProperty("txtShozokuKikan")
    public TextBox getTxtShozokuKikan() {
        return txtShozokuKikan;
    }

    @JsonProperty("txtShozokuKikan")
    public void setTxtShozokuKikan(TextBox txtShozokuKikan) {
        this.txtShozokuKikan=txtShozokuKikan;
    }

}
