package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteichosaIraiToroku のクラスファイル
 *
 * @author 自動生成
 */
public class NinteichosaIraiTorokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-02_13-24-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlIraiKubun")
    private DropDownList ddlIraiKubun;
    @JsonProperty("txtChosaIraiYmd")
    private TextBoxDate txtChosaIraiYmd;
    @JsonProperty("btnWaritsukeKakutei")
    private Button btnWaritsukeKakutei;
    @JsonProperty("btnWaritukenaideModoru")
    private Button btnWaritukenaideModoru;
    @JsonProperty("ccdItakusakiAndChosainInput")
    private ChosaItakusakiAndChosainInputDiv ccdItakusakiAndChosainInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlIraiKubun
     * @return ddlIraiKubun
     */
    @JsonProperty("ddlIraiKubun")
    public DropDownList getDdlIraiKubun() {
        return ddlIraiKubun;
    }

    /*
     * setddlIraiKubun
     * @param ddlIraiKubun ddlIraiKubun
     */
    @JsonProperty("ddlIraiKubun")
    public void setDdlIraiKubun(DropDownList ddlIraiKubun) {
        this.ddlIraiKubun = ddlIraiKubun;
    }

    /*
     * gettxtChosaIraiYmd
     * @return txtChosaIraiYmd
     */
    @JsonProperty("txtChosaIraiYmd")
    public TextBoxDate getTxtChosaIraiYmd() {
        return txtChosaIraiYmd;
    }

    /*
     * settxtChosaIraiYmd
     * @param txtChosaIraiYmd txtChosaIraiYmd
     */
    @JsonProperty("txtChosaIraiYmd")
    public void setTxtChosaIraiYmd(TextBoxDate txtChosaIraiYmd) {
        this.txtChosaIraiYmd = txtChosaIraiYmd;
    }

    /*
     * getbtnWaritsukeKakutei
     * @return btnWaritsukeKakutei
     */
    @JsonProperty("btnWaritsukeKakutei")
    public Button getBtnWaritsukeKakutei() {
        return btnWaritsukeKakutei;
    }

    /*
     * setbtnWaritsukeKakutei
     * @param btnWaritsukeKakutei btnWaritsukeKakutei
     */
    @JsonProperty("btnWaritsukeKakutei")
    public void setBtnWaritsukeKakutei(Button btnWaritsukeKakutei) {
        this.btnWaritsukeKakutei = btnWaritsukeKakutei;
    }

    /*
     * getbtnWaritukenaideModoru
     * @return btnWaritukenaideModoru
     */
    @JsonProperty("btnWaritukenaideModoru")
    public Button getBtnWaritukenaideModoru() {
        return btnWaritukenaideModoru;
    }

    /*
     * setbtnWaritukenaideModoru
     * @param btnWaritukenaideModoru btnWaritukenaideModoru
     */
    @JsonProperty("btnWaritukenaideModoru")
    public void setBtnWaritukenaideModoru(Button btnWaritukenaideModoru) {
        this.btnWaritukenaideModoru = btnWaritukenaideModoru;
    }

    /*
     * getccdItakusakiAndChosainInput
     * @return ccdItakusakiAndChosainInput
     */
    @JsonProperty("ccdItakusakiAndChosainInput")
    public IChosaItakusakiAndChosainInputDiv getCcdItakusakiAndChosainInput() {
        return ccdItakusakiAndChosainInput;
    }

    // </editor-fold>
}
