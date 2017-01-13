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

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
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
    @JsonProperty("btnWaritsukeru")
    private Button btnWaritsukeru;
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
     * getbtnWaritsukeru
     * @return btnWaritsukeru
     */
    @JsonProperty("btnWaritsukeru")
    public Button getBtnWaritsukeru() {
        return btnWaritsukeru;
    }

    /*
     * setbtnWaritsukeru
     * @param btnWaritsukeru btnWaritsukeru
     */
    @JsonProperty("btnWaritsukeru")
    public void setBtnWaritsukeru(Button btnWaritsukeru) {
        this.btnWaritsukeru = btnWaritsukeru;
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
