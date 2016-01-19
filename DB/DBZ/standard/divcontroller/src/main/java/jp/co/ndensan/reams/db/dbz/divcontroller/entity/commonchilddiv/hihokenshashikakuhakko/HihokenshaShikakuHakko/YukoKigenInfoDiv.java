package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshashikakuhakko.HihokenshaShikakuHakko;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YukoKigenInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class YukoKigenInfoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtYukoKigen")
    private TextBoxDate txtYukoKigen;
    @JsonProperty("txtKofuDate")
    private TextBoxFlexibleDate txtKofuDate;
    @JsonProperty("txtHokensha")
    private TextBox txtHokensha;
    @JsonProperty("ddlKofuJiyu")
    private DropDownList ddlKofuJiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtYukoKigen
     * @return txtYukoKigen
     */
    @JsonProperty("txtYukoKigen")
    public TextBoxDate getTxtYukoKigen() {
        return txtYukoKigen;
    }

    /*
     * settxtYukoKigen
     * @param txtYukoKigen txtYukoKigen
     */
    @JsonProperty("txtYukoKigen")
    public void setTxtYukoKigen(TextBoxDate txtYukoKigen) {
        this.txtYukoKigen = txtYukoKigen;
    }

    /*
     * gettxtKofuDate
     * @return txtKofuDate
     */
    @JsonProperty("txtKofuDate")
    public TextBoxFlexibleDate getTxtKofuDate() {
        return txtKofuDate;
    }

    /*
     * settxtKofuDate
     * @param txtKofuDate txtKofuDate
     */
    @JsonProperty("txtKofuDate")
    public void setTxtKofuDate(TextBoxFlexibleDate txtKofuDate) {
        this.txtKofuDate = txtKofuDate;
    }

    /*
     * gettxtHokensha
     * @return txtHokensha
     */
    @JsonProperty("txtHokensha")
    public TextBox getTxtHokensha() {
        return txtHokensha;
    }

    /*
     * settxtHokensha
     * @param txtHokensha txtHokensha
     */
    @JsonProperty("txtHokensha")
    public void setTxtHokensha(TextBox txtHokensha) {
        this.txtHokensha = txtHokensha;
    }

    /*
     * getddlKofuJiyu
     * @return ddlKofuJiyu
     */
    @JsonProperty("ddlKofuJiyu")
    public DropDownList getDdlKofuJiyu() {
        return ddlKofuJiyu;
    }

    /*
     * setddlKofuJiyu
     * @param ddlKofuJiyu ddlKofuJiyu
     */
    @JsonProperty("ddlKofuJiyu")
    public void setDdlKofuJiyu(DropDownList ddlKofuJiyu) {
        this.ddlKofuJiyu = ddlKofuJiyu;
    }

    // </editor-fold>
}
