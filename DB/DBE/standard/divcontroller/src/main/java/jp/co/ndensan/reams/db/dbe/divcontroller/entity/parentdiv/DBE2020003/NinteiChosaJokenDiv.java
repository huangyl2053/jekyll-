package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosaJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlNinteiChosaItakusaki")
    private DropDownList ddlNinteiChosaItakusaki;
    @JsonProperty("ddlNinteiChosain")
    private DropDownList ddlNinteiChosain;
    @JsonProperty("txtNinteiChosaYMDFrom")
    private TextBoxFlexibleDate txtNinteiChosaYMDFrom;
    @JsonProperty("txtNinteiChosaYMDTo")
    private TextBoxFlexibleDate txtNinteiChosaYMDTo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlNinteiChosaItakusaki
     * @return ddlNinteiChosaItakusaki
     */
    @JsonProperty("ddlNinteiChosaItakusaki")
    public DropDownList getDdlNinteiChosaItakusaki() {
        return ddlNinteiChosaItakusaki;
    }

    /*
     * setddlNinteiChosaItakusaki
     * @param ddlNinteiChosaItakusaki ddlNinteiChosaItakusaki
     */
    @JsonProperty("ddlNinteiChosaItakusaki")
    public void setDdlNinteiChosaItakusaki(DropDownList ddlNinteiChosaItakusaki) {
        this.ddlNinteiChosaItakusaki = ddlNinteiChosaItakusaki;
    }

    /*
     * getddlNinteiChosain
     * @return ddlNinteiChosain
     */
    @JsonProperty("ddlNinteiChosain")
    public DropDownList getDdlNinteiChosain() {
        return ddlNinteiChosain;
    }

    /*
     * setddlNinteiChosain
     * @param ddlNinteiChosain ddlNinteiChosain
     */
    @JsonProperty("ddlNinteiChosain")
    public void setDdlNinteiChosain(DropDownList ddlNinteiChosain) {
        this.ddlNinteiChosain = ddlNinteiChosain;
    }

    /*
     * gettxtNinteiChosaYMDFrom
     * @return txtNinteiChosaYMDFrom
     */
    @JsonProperty("txtNinteiChosaYMDFrom")
    public TextBoxFlexibleDate getTxtNinteiChosaYMDFrom() {
        return txtNinteiChosaYMDFrom;
    }

    /*
     * settxtNinteiChosaYMDFrom
     * @param txtNinteiChosaYMDFrom txtNinteiChosaYMDFrom
     */
    @JsonProperty("txtNinteiChosaYMDFrom")
    public void setTxtNinteiChosaYMDFrom(TextBoxFlexibleDate txtNinteiChosaYMDFrom) {
        this.txtNinteiChosaYMDFrom = txtNinteiChosaYMDFrom;
    }

    /*
     * gettxtNinteiChosaYMDTo
     * @return txtNinteiChosaYMDTo
     */
    @JsonProperty("txtNinteiChosaYMDTo")
    public TextBoxFlexibleDate getTxtNinteiChosaYMDTo() {
        return txtNinteiChosaYMDTo;
    }

    /*
     * settxtNinteiChosaYMDTo
     * @param txtNinteiChosaYMDTo txtNinteiChosaYMDTo
     */
    @JsonProperty("txtNinteiChosaYMDTo")
    public void setTxtNinteiChosaYMDTo(TextBoxFlexibleDate txtNinteiChosaYMDTo) {
        this.txtNinteiChosaYMDTo = txtNinteiChosaYMDTo;
    }

    // </editor-fold>
}
