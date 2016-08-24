package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * 画面設計_DBBGM21004_段階別被保険者数一覧表作成
 *
 * @reamsid_L DBB-1820-010 chenyadong
 */
public class ChushutsuJokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkChosaJoken")
    private CheckBoxList chkChosaJoken;
    @JsonProperty("txtShikakuKijunYMD")
    private TextBoxDate txtShikakuKijunYMD;
    @JsonProperty("txtChoteiKijunYMD")
    private TextBoxDate txtChoteiKijunYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkChosaJoken
     * @return chkChosaJoken
     */
    @JsonProperty("chkChosaJoken")
    public CheckBoxList getChkChosaJoken() {
        return chkChosaJoken;
    }

    /*
     * setchkChosaJoken
     * @param chkChosaJoken chkChosaJoken
     */
    @JsonProperty("chkChosaJoken")
    public void setChkChosaJoken(CheckBoxList chkChosaJoken) {
        this.chkChosaJoken = chkChosaJoken;
    }

    /*
     * gettxtShikakuKijunYMD
     * @return txtShikakuKijunYMD
     */
    @JsonProperty("txtShikakuKijunYMD")
    public TextBoxDate getTxtShikakuKijunYMD() {
        return txtShikakuKijunYMD;
    }

    /*
     * settxtShikakuKijunYMD
     * @param txtShikakuKijunYMD txtShikakuKijunYMD
     */
    @JsonProperty("txtShikakuKijunYMD")
    public void setTxtShikakuKijunYMD(TextBoxDate txtShikakuKijunYMD) {
        this.txtShikakuKijunYMD = txtShikakuKijunYMD;
    }

    /*
     * gettxtChoteiKijunYMD
     * @return txtChoteiKijunYMD
     */
    @JsonProperty("txtChoteiKijunYMD")
    public TextBoxDate getTxtChoteiKijunYMD() {
        return txtChoteiKijunYMD;
    }

    /*
     * settxtChoteiKijunYMD
     * @param txtChoteiKijunYMD txtChoteiKijunYMD
     */
    @JsonProperty("txtChoteiKijunYMD")
    public void setTxtChoteiKijunYMD(TextBoxDate txtChoteiKijunYMD) {
        this.txtChoteiKijunYMD = txtChoteiKijunYMD;
    }

    // </editor-fold>
}
