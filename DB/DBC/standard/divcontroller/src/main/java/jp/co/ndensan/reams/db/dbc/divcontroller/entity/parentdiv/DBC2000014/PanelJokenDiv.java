package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000014;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PanelJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class PanelJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlNendo")
    private DropDownList ddlNendo;
    @JsonProperty("radKubun")
    private RadioButton radKubun;
    @JsonProperty("radHakkoKubun")
    private RadioButton radHakkoKubun;
    @JsonProperty("txtKofubi")
    private TextBoxDate txtKofubi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlNendo
     * @return ddlNendo
     */
    @JsonProperty("ddlNendo")
    public DropDownList getDdlNendo() {
        return ddlNendo;
    }

    /*
     * setddlNendo
     * @param ddlNendo ddlNendo
     */
    @JsonProperty("ddlNendo")
    public void setDdlNendo(DropDownList ddlNendo) {
        this.ddlNendo = ddlNendo;
    }

    /*
     * getradKubun
     * @return radKubun
     */
    @JsonProperty("radKubun")
    public RadioButton getRadKubun() {
        return radKubun;
    }

    /*
     * setradKubun
     * @param radKubun radKubun
     */
    @JsonProperty("radKubun")
    public void setRadKubun(RadioButton radKubun) {
        this.radKubun = radKubun;
    }

    /*
     * getradHakkoKubun
     * @return radHakkoKubun
     */
    @JsonProperty("radHakkoKubun")
    public RadioButton getRadHakkoKubun() {
        return radHakkoKubun;
    }

    /*
     * setradHakkoKubun
     * @param radHakkoKubun radHakkoKubun
     */
    @JsonProperty("radHakkoKubun")
    public void setRadHakkoKubun(RadioButton radHakkoKubun) {
        this.radHakkoKubun = radHakkoKubun;
    }

    /*
     * gettxtKofubi
     * @return txtKofubi
     */
    @JsonProperty("txtKofubi")
    public TextBoxDate getTxtKofubi() {
        return txtKofubi;
    }

    /*
     * settxtKofubi
     * @param txtKofubi txtKofubi
     */
    @JsonProperty("txtKofubi")
    public void setTxtKofubi(TextBoxDate txtKofubi) {
        this.txtKofubi = txtKofubi;
    }

    // </editor-fold>
}
