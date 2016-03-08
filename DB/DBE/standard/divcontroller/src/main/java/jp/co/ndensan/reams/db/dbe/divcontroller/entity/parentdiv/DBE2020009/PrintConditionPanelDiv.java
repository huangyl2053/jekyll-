package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020009;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PrintConditionPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class PrintConditionPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlTaishoChiku")
    private DropDownList ddlTaishoChiku;
    @JsonProperty("ddlTaishoShichoson")
    private DropDownList ddlTaishoShichoson;
    @JsonProperty("ddlTaishoNinteiChosainShozokuKikan")
    private DropDownList ddlTaishoNinteiChosainShozokuKikan;
    @JsonProperty("txtNinteiChosaYoteiYMDFrom")
    private TextBoxFlexibleDate txtNinteiChosaYoteiYMDFrom;
    @JsonProperty("txtNinteiChosaYoteiYMDTo")
    private TextBoxFlexibleDate txtNinteiChosaYoteiYMDTo;
    @JsonProperty("radJokyo")
    private RadioButton radJokyo;
    @JsonProperty("ddlTaishoNinteiChosain")
    private DropDownList ddlTaishoNinteiChosain;
    @JsonProperty("radPrintselect")
    private RadioButton radPrintselect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlTaishoChiku
     * @return ddlTaishoChiku
     */
    @JsonProperty("ddlTaishoChiku")
    public DropDownList getDdlTaishoChiku() {
        return ddlTaishoChiku;
    }

    /*
     * setddlTaishoChiku
     * @param ddlTaishoChiku ddlTaishoChiku
     */
    @JsonProperty("ddlTaishoChiku")
    public void setDdlTaishoChiku(DropDownList ddlTaishoChiku) {
        this.ddlTaishoChiku = ddlTaishoChiku;
    }

    /*
     * getddlTaishoShichoson
     * @return ddlTaishoShichoson
     */
    @JsonProperty("ddlTaishoShichoson")
    public DropDownList getDdlTaishoShichoson() {
        return ddlTaishoShichoson;
    }

    /*
     * setddlTaishoShichoson
     * @param ddlTaishoShichoson ddlTaishoShichoson
     */
    @JsonProperty("ddlTaishoShichoson")
    public void setDdlTaishoShichoson(DropDownList ddlTaishoShichoson) {
        this.ddlTaishoShichoson = ddlTaishoShichoson;
    }

    /*
     * getddlTaishoNinteiChosainShozokuKikan
     * @return ddlTaishoNinteiChosainShozokuKikan
     */
    @JsonProperty("ddlTaishoNinteiChosainShozokuKikan")
    public DropDownList getDdlTaishoNinteiChosainShozokuKikan() {
        return ddlTaishoNinteiChosainShozokuKikan;
    }

    /*
     * setddlTaishoNinteiChosainShozokuKikan
     * @param ddlTaishoNinteiChosainShozokuKikan ddlTaishoNinteiChosainShozokuKikan
     */
    @JsonProperty("ddlTaishoNinteiChosainShozokuKikan")
    public void setDdlTaishoNinteiChosainShozokuKikan(DropDownList ddlTaishoNinteiChosainShozokuKikan) {
        this.ddlTaishoNinteiChosainShozokuKikan = ddlTaishoNinteiChosainShozokuKikan;
    }

    /*
     * gettxtNinteiChosaYoteiYMDFrom
     * @return txtNinteiChosaYoteiYMDFrom
     */
    @JsonProperty("txtNinteiChosaYoteiYMDFrom")
    public TextBoxFlexibleDate getTxtNinteiChosaYoteiYMDFrom() {
        return txtNinteiChosaYoteiYMDFrom;
    }

    /*
     * settxtNinteiChosaYoteiYMDFrom
     * @param txtNinteiChosaYoteiYMDFrom txtNinteiChosaYoteiYMDFrom
     */
    @JsonProperty("txtNinteiChosaYoteiYMDFrom")
    public void setTxtNinteiChosaYoteiYMDFrom(TextBoxFlexibleDate txtNinteiChosaYoteiYMDFrom) {
        this.txtNinteiChosaYoteiYMDFrom = txtNinteiChosaYoteiYMDFrom;
    }

    /*
     * gettxtNinteiChosaYoteiYMDTo
     * @return txtNinteiChosaYoteiYMDTo
     */
    @JsonProperty("txtNinteiChosaYoteiYMDTo")
    public TextBoxFlexibleDate getTxtNinteiChosaYoteiYMDTo() {
        return txtNinteiChosaYoteiYMDTo;
    }

    /*
     * settxtNinteiChosaYoteiYMDTo
     * @param txtNinteiChosaYoteiYMDTo txtNinteiChosaYoteiYMDTo
     */
    @JsonProperty("txtNinteiChosaYoteiYMDTo")
    public void setTxtNinteiChosaYoteiYMDTo(TextBoxFlexibleDate txtNinteiChosaYoteiYMDTo) {
        this.txtNinteiChosaYoteiYMDTo = txtNinteiChosaYoteiYMDTo;
    }

    /*
     * getradJokyo
     * @return radJokyo
     */
    @JsonProperty("radJokyo")
    public RadioButton getRadJokyo() {
        return radJokyo;
    }

    /*
     * setradJokyo
     * @param radJokyo radJokyo
     */
    @JsonProperty("radJokyo")
    public void setRadJokyo(RadioButton radJokyo) {
        this.radJokyo = radJokyo;
    }

    /*
     * getddlTaishoNinteiChosain
     * @return ddlTaishoNinteiChosain
     */
    @JsonProperty("ddlTaishoNinteiChosain")
    public DropDownList getDdlTaishoNinteiChosain() {
        return ddlTaishoNinteiChosain;
    }

    /*
     * setddlTaishoNinteiChosain
     * @param ddlTaishoNinteiChosain ddlTaishoNinteiChosain
     */
    @JsonProperty("ddlTaishoNinteiChosain")
    public void setDdlTaishoNinteiChosain(DropDownList ddlTaishoNinteiChosain) {
        this.ddlTaishoNinteiChosain = ddlTaishoNinteiChosain;
    }

    /*
     * getradPrintselect
     * @return radPrintselect
     */
    @JsonProperty("radPrintselect")
    public RadioButton getRadPrintselect() {
        return radPrintselect;
    }

    /*
     * setradPrintselect
     * @param radPrintselect radPrintselect
     */
    @JsonProperty("radPrintselect")
    public void setRadPrintselect(RadioButton radPrintselect) {
        this.radPrintselect = radPrintselect;
    }

    // </editor-fold>
}
