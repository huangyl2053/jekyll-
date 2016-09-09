package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * KaigoShikakuJohoPanel のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class KaigoShikakuJohoPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlKaigoShikakuJoho")
    private DropDownList ddlKaigoShikakuJoho;
    @JsonProperty("txtKaigoShikakuJoho1")
    private TextBox txtKaigoShikakuJoho1;
    @JsonProperty("txtKaigoShikakuJohoKanyuYMD")
    private TextBoxDateRange txtKaigoShikakuJohoKanyuYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlKaigoShikakuJoho
     * @return ddlKaigoShikakuJoho
     */
    @JsonProperty("ddlKaigoShikakuJoho")
    public DropDownList getDdlKaigoShikakuJoho() {
        return ddlKaigoShikakuJoho;
    }

    /*
     * setddlKaigoShikakuJoho
     * @param ddlKaigoShikakuJoho ddlKaigoShikakuJoho
     */
    @JsonProperty("ddlKaigoShikakuJoho")
    public void setDdlKaigoShikakuJoho(DropDownList ddlKaigoShikakuJoho) {
        this.ddlKaigoShikakuJoho = ddlKaigoShikakuJoho;
    }

    /*
     * gettxtKaigoShikakuJoho1
     * @return txtKaigoShikakuJoho1
     */
    @JsonProperty("txtKaigoShikakuJoho1")
    public TextBox getTxtKaigoShikakuJoho1() {
        return txtKaigoShikakuJoho1;
    }

    /*
     * settxtKaigoShikakuJoho1
     * @param txtKaigoShikakuJoho1 txtKaigoShikakuJoho1
     */
    @JsonProperty("txtKaigoShikakuJoho1")
    public void setTxtKaigoShikakuJoho1(TextBox txtKaigoShikakuJoho1) {
        this.txtKaigoShikakuJoho1 = txtKaigoShikakuJoho1;
    }

    /*
     * gettxtKaigoShikakuJohoKanyuYMD
     * @return txtKaigoShikakuJohoKanyuYMD
     */
    @JsonProperty("txtKaigoShikakuJohoKanyuYMD")
    public TextBoxDateRange getTxtKaigoShikakuJohoKanyuYMD() {
        return txtKaigoShikakuJohoKanyuYMD;
    }

    /*
     * settxtKaigoShikakuJohoKanyuYMD
     * @param txtKaigoShikakuJohoKanyuYMD txtKaigoShikakuJohoKanyuYMD
     */
    @JsonProperty("txtKaigoShikakuJohoKanyuYMD")
    public void setTxtKaigoShikakuJohoKanyuYMD(TextBoxDateRange txtKaigoShikakuJohoKanyuYMD) {
        this.txtKaigoShikakuJohoKanyuYMD = txtKaigoShikakuJohoKanyuYMD;
    }

    // </editor-fold>
}
