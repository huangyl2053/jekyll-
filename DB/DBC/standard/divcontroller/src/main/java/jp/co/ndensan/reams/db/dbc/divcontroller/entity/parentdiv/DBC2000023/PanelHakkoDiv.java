package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000023;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * PanelHakko のクラスファイル
 *
 * @reamsid_L DBC-5010-012 lijian
 */
public class PanelHakkoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHakkobi")
    private TextBoxDate txtHakkobi;
    @JsonProperty("txtKofubi")
    private TextBoxDate txtKofubi;
    @JsonProperty("ddlKofuJiyu")
    private DropDownList ddlKofuJiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHakkobi
     * @return txtHakkobi
     */
    @JsonProperty("txtHakkobi")
    public TextBoxDate getTxtHakkobi() {
        return txtHakkobi;
    }

    /*
     * settxtHakkobi
     * @param txtHakkobi txtHakkobi
     */
    @JsonProperty("txtHakkobi")
    public void setTxtHakkobi(TextBoxDate txtHakkobi) {
        this.txtHakkobi = txtHakkobi;
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
