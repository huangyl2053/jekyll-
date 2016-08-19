package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0110011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * ShinkiToroku のクラスファイル
 *
 * @reamsid_L DBC-1920-010 tianshuai
 */
public class ShinkiTorokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTorokuState")
    private TextBox txtTorokuState;
    @JsonProperty("txtNinteiShinseiShinki")
    private TextBox txtNinteiShinseiShinki;
    @JsonProperty("txtNinteiShinseiSaishinsei")
    private TextBox txtNinteiShinseiSaishinsei;
    @JsonProperty("txtNinteiShinseiHenkoShinsei")
    private TextBox txtNinteiShinseiHenkoShinsei;
    @JsonProperty("txtNinteiShinseiServiceHenko")
    private TextBox txtNinteiShinseiServiceHenko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTorokuState
     * @return txtTorokuState
     */
    @JsonProperty("txtTorokuState")
    public TextBox getTxtTorokuState() {
        return txtTorokuState;
    }

    /*
     * settxtTorokuState
     * @param txtTorokuState txtTorokuState
     */
    @JsonProperty("txtTorokuState")
    public void setTxtTorokuState(TextBox txtTorokuState) {
        this.txtTorokuState = txtTorokuState;
    }

    /*
     * gettxtNinteiShinseiShinki
     * @return txtNinteiShinseiShinki
     */
    @JsonProperty("txtNinteiShinseiShinki")
    public TextBox getTxtNinteiShinseiShinki() {
        return txtNinteiShinseiShinki;
    }

    /*
     * settxtNinteiShinseiShinki
     * @param txtNinteiShinseiShinki txtNinteiShinseiShinki
     */
    @JsonProperty("txtNinteiShinseiShinki")
    public void setTxtNinteiShinseiShinki(TextBox txtNinteiShinseiShinki) {
        this.txtNinteiShinseiShinki = txtNinteiShinseiShinki;
    }

    /*
     * gettxtNinteiShinseiSaishinsei
     * @return txtNinteiShinseiSaishinsei
     */
    @JsonProperty("txtNinteiShinseiSaishinsei")
    public TextBox getTxtNinteiShinseiSaishinsei() {
        return txtNinteiShinseiSaishinsei;
    }

    /*
     * settxtNinteiShinseiSaishinsei
     * @param txtNinteiShinseiSaishinsei txtNinteiShinseiSaishinsei
     */
    @JsonProperty("txtNinteiShinseiSaishinsei")
    public void setTxtNinteiShinseiSaishinsei(TextBox txtNinteiShinseiSaishinsei) {
        this.txtNinteiShinseiSaishinsei = txtNinteiShinseiSaishinsei;
    }

    /*
     * gettxtNinteiShinseiHenkoShinsei
     * @return txtNinteiShinseiHenkoShinsei
     */
    @JsonProperty("txtNinteiShinseiHenkoShinsei")
    public TextBox getTxtNinteiShinseiHenkoShinsei() {
        return txtNinteiShinseiHenkoShinsei;
    }

    /*
     * settxtNinteiShinseiHenkoShinsei
     * @param txtNinteiShinseiHenkoShinsei txtNinteiShinseiHenkoShinsei
     */
    @JsonProperty("txtNinteiShinseiHenkoShinsei")
    public void setTxtNinteiShinseiHenkoShinsei(TextBox txtNinteiShinseiHenkoShinsei) {
        this.txtNinteiShinseiHenkoShinsei = txtNinteiShinseiHenkoShinsei;
    }

    /*
     * gettxtNinteiShinseiServiceHenko
     * @return txtNinteiShinseiServiceHenko
     */
    @JsonProperty("txtNinteiShinseiServiceHenko")
    public TextBox getTxtNinteiShinseiServiceHenko() {
        return txtNinteiShinseiServiceHenko;
    }

    /*
     * settxtNinteiShinseiServiceHenko
     * @param txtNinteiShinseiServiceHenko txtNinteiShinseiServiceHenko
     */
    @JsonProperty("txtNinteiShinseiServiceHenko")
    public void setTxtNinteiShinseiServiceHenko(TextBox txtNinteiShinseiServiceHenko) {
        this.txtNinteiShinseiServiceHenko = txtNinteiShinseiServiceHenko;
    }

    // </editor-fold>
}
