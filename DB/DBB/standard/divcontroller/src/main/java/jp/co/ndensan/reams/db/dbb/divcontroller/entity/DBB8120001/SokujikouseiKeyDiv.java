package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001;
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
 * SokujikouseiKey のクラスファイル 
 * 
 * @author 自動生成
 */
public class SokujikouseiKeyDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtFukaNendo")
    private TextBox txtFukaNendo;
    @JsonProperty("txtChoteiYMD")
    private TextBoxDate txtChoteiYMD;
    @JsonProperty("ddlKoseiTsuki")
    private DropDownList ddlKoseiTsuki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtFukaNendo")
    public TextBox getTxtFukaNendo() {
        return txtFukaNendo;
    }

    @JsonProperty("txtFukaNendo")
    public void setTxtFukaNendo(TextBox txtFukaNendo) {
        this.txtFukaNendo=txtFukaNendo;
    }

    @JsonProperty("txtChoteiYMD")
    public TextBoxDate getTxtChoteiYMD() {
        return txtChoteiYMD;
    }

    @JsonProperty("txtChoteiYMD")
    public void setTxtChoteiYMD(TextBoxDate txtChoteiYMD) {
        this.txtChoteiYMD=txtChoteiYMD;
    }

    @JsonProperty("ddlKoseiTsuki")
    public DropDownList getDdlKoseiTsuki() {
        return ddlKoseiTsuki;
    }

    @JsonProperty("ddlKoseiTsuki")
    public void setDdlKoseiTsuki(DropDownList ddlKoseiTsuki) {
        this.ddlKoseiTsuki=ddlKoseiTsuki;
    }

}
