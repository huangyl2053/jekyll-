package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * FuyoKojo のクラスファイル
 *
 * @reamsid_L DBC-4620-010 wangkanglei
 */
public class FuyoKojoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ButtonPanel")
    private ButtonPanelDiv ButtonPanel;
    @JsonProperty("lblKojoTaisho")
    private Label lblKojoTaisho;
    @JsonProperty("ZennenKojoTaisho")
    private ZennenKojoTaishoDiv ZennenKojoTaisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getButtonPanel
     * @return ButtonPanel
     */
    @JsonProperty("ButtonPanel")
    public ButtonPanelDiv getButtonPanel() {
        return ButtonPanel;
    }

    /*
     * setButtonPanel
     * @param ButtonPanel ButtonPanel
     */
    @JsonProperty("ButtonPanel")
    public void setButtonPanel(ButtonPanelDiv ButtonPanel) {
        this.ButtonPanel = ButtonPanel;
    }

    /*
     * getlblKojoTaisho
     * @return lblKojoTaisho
     */
    @JsonProperty("lblKojoTaisho")
    public Label getLblKojoTaisho() {
        return lblKojoTaisho;
    }

    /*
     * setlblKojoTaisho
     * @param lblKojoTaisho lblKojoTaisho
     */
    @JsonProperty("lblKojoTaisho")
    public void setLblKojoTaisho(Label lblKojoTaisho) {
        this.lblKojoTaisho = lblKojoTaisho;
    }

    /*
     * getZennenKojoTaisho
     * @return ZennenKojoTaisho
     */
    @JsonProperty("ZennenKojoTaisho")
    public ZennenKojoTaishoDiv getZennenKojoTaisho() {
        return ZennenKojoTaisho;
    }

    /*
     * setZennenKojoTaisho
     * @param ZennenKojoTaisho ZennenKojoTaisho
     */
    @JsonProperty("ZennenKojoTaisho")
    public void setZennenKojoTaisho(ZennenKojoTaishoDiv ZennenKojoTaisho) {
        this.ZennenKojoTaisho = ZennenKojoTaisho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnSetaiSaiSanshutsu() {
        return this.getButtonPanel().getBtnSetaiSaiSanshutsu();
    }

    @JsonIgnore
    public void setBtnSetaiSaiSanshutsu(Button btnSetaiSaiSanshutsu) {
        this.getButtonPanel().setBtnSetaiSaiSanshutsu(btnSetaiSaiSanshutsu);
    }

    @JsonIgnore
    public Button getBtnKojoSaiSanshutsu() {
        return this.getButtonPanel().getBtnKojoSaiSanshutsu();
    }

    @JsonIgnore
    public void setBtnKojoSaiSanshutsu(Button btnKojoSaiSanshutsu) {
        this.getButtonPanel().setBtnKojoSaiSanshutsu(btnKojoSaiSanshutsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtUnder16() {
        return this.getZennenKojoTaisho().getTxtUnder16();
    }

    @JsonIgnore
    public void setTxtUnder16(TextBoxNum txtUnder16) {
        this.getZennenKojoTaisho().setTxtUnder16(txtUnder16);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver16() {
        return this.getZennenKojoTaisho().getTxtOver16();
    }

    @JsonIgnore
    public void setTxtOver16(TextBoxNum txtOver16) {
        this.getZennenKojoTaisho().setTxtOver16(txtOver16);
    }

    // </editor-fold>
}
