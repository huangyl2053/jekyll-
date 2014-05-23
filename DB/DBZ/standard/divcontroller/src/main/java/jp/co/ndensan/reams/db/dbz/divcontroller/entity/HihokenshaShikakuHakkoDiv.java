package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tabHihokenshaShikakuShosaiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HihokenshaShikakuHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaShikakuHakkoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radInjiIchi")
    private RadioButton radInjiIchi;
    @JsonProperty("txtKofuDate")
    private TextBoxFlexibleDate txtKofuDate;
    @JsonProperty("ddlKofuJiyu")
    private DropDownList ddlKofuJiyu;
    @JsonProperty("txtYukoKigen")
    private TextBoxFlexibleDate txtYukoKigen;
    @JsonProperty("txtHokensha")
    private TextBox txtHokensha;
    @JsonProperty("txtYokaigodo")
    private TextBox txtYokaigodo;
    @JsonProperty("txtNinteiYukoKikan")
    private TextBoxDateRange txtNinteiYukoKikan;
    @JsonProperty("txtShinseiDate")
    private TextBoxFlexibleDate txtShinseiDate;
    @JsonProperty("tabHihokenshaShikakuShosai")
    private tabHihokenshaShikakuShosaiDiv tabHihokenshaShikakuShosai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radInjiIchi")
    public RadioButton getRadInjiIchi() {
        return radInjiIchi;
    }

    @JsonProperty("radInjiIchi")
    public void setRadInjiIchi(RadioButton radInjiIchi) {
        this.radInjiIchi=radInjiIchi;
    }

    @JsonProperty("txtKofuDate")
    public TextBoxFlexibleDate getTxtKofuDate() {
        return txtKofuDate;
    }

    @JsonProperty("txtKofuDate")
    public void setTxtKofuDate(TextBoxFlexibleDate txtKofuDate) {
        this.txtKofuDate=txtKofuDate;
    }

    @JsonProperty("ddlKofuJiyu")
    public DropDownList getDdlKofuJiyu() {
        return ddlKofuJiyu;
    }

    @JsonProperty("ddlKofuJiyu")
    public void setDdlKofuJiyu(DropDownList ddlKofuJiyu) {
        this.ddlKofuJiyu=ddlKofuJiyu;
    }

    @JsonProperty("txtYukoKigen")
    public TextBoxFlexibleDate getTxtYukoKigen() {
        return txtYukoKigen;
    }

    @JsonProperty("txtYukoKigen")
    public void setTxtYukoKigen(TextBoxFlexibleDate txtYukoKigen) {
        this.txtYukoKigen=txtYukoKigen;
    }

    @JsonProperty("txtHokensha")
    public TextBox getTxtHokensha() {
        return txtHokensha;
    }

    @JsonProperty("txtHokensha")
    public void setTxtHokensha(TextBox txtHokensha) {
        this.txtHokensha=txtHokensha;
    }

    @JsonProperty("txtYokaigodo")
    public TextBox getTxtYokaigodo() {
        return txtYokaigodo;
    }

    @JsonProperty("txtYokaigodo")
    public void setTxtYokaigodo(TextBox txtYokaigodo) {
        this.txtYokaigodo=txtYokaigodo;
    }

    @JsonProperty("txtNinteiYukoKikan")
    public TextBoxDateRange getTxtNinteiYukoKikan() {
        return txtNinteiYukoKikan;
    }

    @JsonProperty("txtNinteiYukoKikan")
    public void setTxtNinteiYukoKikan(TextBoxDateRange txtNinteiYukoKikan) {
        this.txtNinteiYukoKikan=txtNinteiYukoKikan;
    }

    @JsonProperty("txtShinseiDate")
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.txtShinseiDate=txtShinseiDate;
    }

    @JsonProperty("tabHihokenshaShikakuShosai")
    public tabHihokenshaShikakuShosaiDiv getTabHihokenshaShikakuShosai() {
        return tabHihokenshaShikakuShosai;
    }

    @JsonProperty("tabHihokenshaShikakuShosai")
    public void setTabHihokenshaShikakuShosai(tabHihokenshaShikakuShosaiDiv tabHihokenshaShikakuShosai) {
        this.tabHihokenshaShikakuShosai=tabHihokenshaShikakuShosai;
    }

}
