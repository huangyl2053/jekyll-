package jp.co.ndensan.reams.db.dbz.divcontroller.entity.SaishinsaMoshitate;
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
 * SaishinsaTaisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class SaishinsaTaishoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlServiceShuruiCode")
    private DropDownList ddlServiceShuruiCode;
    @JsonProperty("btnTokuteiShinryoShikibetsuCodeInputGuide")
    private ButtonDialog btnTokuteiShinryoShikibetsuCodeInputGuide;
    @JsonProperty("txtShinsaTaishoCode")
    private TextBoxCode txtShinsaTaishoCode;
    @JsonProperty("txtShinsaTaishoName")
    private TextBox txtShinsaTaishoName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlServiceShuruiCode")
    public DropDownList getDdlServiceShuruiCode() {
        return ddlServiceShuruiCode;
    }

    @JsonProperty("ddlServiceShuruiCode")
    public void setDdlServiceShuruiCode(DropDownList ddlServiceShuruiCode) {
        this.ddlServiceShuruiCode=ddlServiceShuruiCode;
    }

    @JsonProperty("btnTokuteiShinryoShikibetsuCodeInputGuide")
    public ButtonDialog getBtnTokuteiShinryoShikibetsuCodeInputGuide() {
        return btnTokuteiShinryoShikibetsuCodeInputGuide;
    }

    @JsonProperty("btnTokuteiShinryoShikibetsuCodeInputGuide")
    public void setBtnTokuteiShinryoShikibetsuCodeInputGuide(ButtonDialog btnTokuteiShinryoShikibetsuCodeInputGuide) {
        this.btnTokuteiShinryoShikibetsuCodeInputGuide=btnTokuteiShinryoShikibetsuCodeInputGuide;
    }

    @JsonProperty("txtShinsaTaishoCode")
    public TextBoxCode getTxtShinsaTaishoCode() {
        return txtShinsaTaishoCode;
    }

    @JsonProperty("txtShinsaTaishoCode")
    public void setTxtShinsaTaishoCode(TextBoxCode txtShinsaTaishoCode) {
        this.txtShinsaTaishoCode=txtShinsaTaishoCode;
    }

    @JsonProperty("txtShinsaTaishoName")
    public TextBox getTxtShinsaTaishoName() {
        return txtShinsaTaishoName;
    }

    @JsonProperty("txtShinsaTaishoName")
    public void setTxtShinsaTaishoName(TextBox txtShinsaTaishoName) {
        this.txtShinsaTaishoName=txtShinsaTaishoName;
    }

}
