package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810014;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * panelTwo のクラスファイル
 *
 * @reamsid_L DBC-1010-020 gongliang
 */
public class panelTwoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("hlUp")
    private HorizontalLine hlUp;
    @JsonProperty("btnShinseiInfo")
    private Button btnShinseiInfo;
    @JsonProperty("btnKouzaInfo")
    private Button btnKouzaInfo;
    @JsonProperty("btnServiceTeikyoInfo")
    private Button btnServiceTeikyoInfo;
    @JsonProperty("btnShokanKeteiInfo")
    private Button btnShokanKeteiInfo;
    @JsonProperty("hlDown")
    private HorizontalLine hlDown;
    @JsonProperty("txtServiceTeikyoYM")
    private TextBoxDate txtServiceTeikyoYM;
    @JsonProperty("txtSeiriBango")
    private TextBoxCode txtSeiriBango;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gethlUp
     * @return hlUp
     */
    @JsonProperty("hlUp")
    public HorizontalLine getHlUp() {
        return hlUp;
    }

    /*
     * sethlUp
     * @param hlUp hlUp
     */
    @JsonProperty("hlUp")
    public void setHlUp(HorizontalLine hlUp) {
        this.hlUp = hlUp;
    }

    /*
     * getbtnShinseiInfo
     * @return btnShinseiInfo
     */
    @JsonProperty("btnShinseiInfo")
    public Button getBtnShinseiInfo() {
        return btnShinseiInfo;
    }

    /*
     * setbtnShinseiInfo
     * @param btnShinseiInfo btnShinseiInfo
     */
    @JsonProperty("btnShinseiInfo")
    public void setBtnShinseiInfo(Button btnShinseiInfo) {
        this.btnShinseiInfo = btnShinseiInfo;
    }

    /*
     * getbtnKouzaInfo
     * @return btnKouzaInfo
     */
    @JsonProperty("btnKouzaInfo")
    public Button getBtnKouzaInfo() {
        return btnKouzaInfo;
    }

    /*
     * setbtnKouzaInfo
     * @param btnKouzaInfo btnKouzaInfo
     */
    @JsonProperty("btnKouzaInfo")
    public void setBtnKouzaInfo(Button btnKouzaInfo) {
        this.btnKouzaInfo = btnKouzaInfo;
    }

    /*
     * getbtnServiceTeikyoInfo
     * @return btnServiceTeikyoInfo
     */
    @JsonProperty("btnServiceTeikyoInfo")
    public Button getBtnServiceTeikyoInfo() {
        return btnServiceTeikyoInfo;
    }

    /*
     * setbtnServiceTeikyoInfo
     * @param btnServiceTeikyoInfo btnServiceTeikyoInfo
     */
    @JsonProperty("btnServiceTeikyoInfo")
    public void setBtnServiceTeikyoInfo(Button btnServiceTeikyoInfo) {
        this.btnServiceTeikyoInfo = btnServiceTeikyoInfo;
    }

    /*
     * getbtnShokanKeteiInfo
     * @return btnShokanKeteiInfo
     */
    @JsonProperty("btnShokanKeteiInfo")
    public Button getBtnShokanKeteiInfo() {
        return btnShokanKeteiInfo;
    }

    /*
     * setbtnShokanKeteiInfo
     * @param btnShokanKeteiInfo btnShokanKeteiInfo
     */
    @JsonProperty("btnShokanKeteiInfo")
    public void setBtnShokanKeteiInfo(Button btnShokanKeteiInfo) {
        this.btnShokanKeteiInfo = btnShokanKeteiInfo;
    }

    /*
     * gethlDown
     * @return hlDown
     */
    @JsonProperty("hlDown")
    public HorizontalLine getHlDown() {
        return hlDown;
    }

    /*
     * sethlDown
     * @param hlDown hlDown
     */
    @JsonProperty("hlDown")
    public void setHlDown(HorizontalLine hlDown) {
        this.hlDown = hlDown;
    }

    /*
     * gettxtServiceTeikyoYM
     * @return txtServiceTeikyoYM
     */
    @JsonProperty("txtServiceTeikyoYM")
    public TextBoxDate getTxtServiceTeikyoYM() {
        return txtServiceTeikyoYM;
    }

    /*
     * settxtServiceTeikyoYM
     * @param txtServiceTeikyoYM txtServiceTeikyoYM
     */
    @JsonProperty("txtServiceTeikyoYM")
    public void setTxtServiceTeikyoYM(TextBoxDate txtServiceTeikyoYM) {
        this.txtServiceTeikyoYM = txtServiceTeikyoYM;
    }

    /*
     * gettxtSeiriBango
     * @return txtSeiriBango
     */
    @JsonProperty("txtSeiriBango")
    public TextBoxCode getTxtSeiriBango() {
        return txtSeiriBango;
    }

    /*
     * settxtSeiriBango
     * @param txtSeiriBango txtSeiriBango
     */
    @JsonProperty("txtSeiriBango")
    public void setTxtSeiriBango(TextBoxCode txtSeiriBango) {
        this.txtSeiriBango = txtSeiriBango;
    }

    // </editor-fold>
}
