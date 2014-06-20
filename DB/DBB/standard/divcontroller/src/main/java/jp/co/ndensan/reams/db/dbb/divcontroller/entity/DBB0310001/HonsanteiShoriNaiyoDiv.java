package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001;
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
 * HonsanteiShoriNaiyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class HonsanteiShoriNaiyoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendo")
    private TextBox txtChoteiNendo;
    @JsonProperty("txtFukaNendo")
    private TextBox txtFukaNendo;
    @JsonProperty("ddlChoteiKi")
    private DropDownList ddlChoteiKi;
    @JsonProperty("txtShotokuKijunYMD")
    private TextBoxDate txtShotokuKijunYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtChoteiNendo")
    public TextBox getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    @JsonProperty("txtChoteiNendo")
    public void setTxtChoteiNendo(TextBox txtChoteiNendo) {
        this.txtChoteiNendo=txtChoteiNendo;
    }

    @JsonProperty("txtFukaNendo")
    public TextBox getTxtFukaNendo() {
        return txtFukaNendo;
    }

    @JsonProperty("txtFukaNendo")
    public void setTxtFukaNendo(TextBox txtFukaNendo) {
        this.txtFukaNendo=txtFukaNendo;
    }

    @JsonProperty("ddlChoteiKi")
    public DropDownList getDdlChoteiKi() {
        return ddlChoteiKi;
    }

    @JsonProperty("ddlChoteiKi")
    public void setDdlChoteiKi(DropDownList ddlChoteiKi) {
        this.ddlChoteiKi=ddlChoteiKi;
    }

    @JsonProperty("txtShotokuKijunYMD")
    public TextBoxDate getTxtShotokuKijunYMD() {
        return txtShotokuKijunYMD;
    }

    @JsonProperty("txtShotokuKijunYMD")
    public void setTxtShotokuKijunYMD(TextBoxDate txtShotokuKijunYMD) {
        this.txtShotokuKijunYMD=txtShotokuKijunYMD;
    }

}
