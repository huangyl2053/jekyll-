package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshashikakuhakko.HihokenshaShikakuHakko;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * tplShinsakaiIken のクラスファイル
 *
 * @author 自動生成
 */
public class tplShinsakaiIkenDiv extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShinsakaiIken")
    private Label lblShinsakaiIken;
    @JsonProperty("txtShinsakaiIken")
    private TextBoxMultiLine txtShinsakaiIken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblShinsakaiIken
     * @return lblShinsakaiIken
     */
    @JsonProperty("lblShinsakaiIken")
    public Label getLblShinsakaiIken() {
        return lblShinsakaiIken;
    }

    /*
     * setlblShinsakaiIken
     * @param lblShinsakaiIken lblShinsakaiIken
     */
    @JsonProperty("lblShinsakaiIken")
    public void setLblShinsakaiIken(Label lblShinsakaiIken) {
        this.lblShinsakaiIken = lblShinsakaiIken;
    }

    /*
     * gettxtShinsakaiIken
     * @return txtShinsakaiIken
     */
    @JsonProperty("txtShinsakaiIken")
    public TextBoxMultiLine getTxtShinsakaiIken() {
        return txtShinsakaiIken;
    }

    /*
     * settxtShinsakaiIken
     * @param txtShinsakaiIken txtShinsakaiIken
     */
    @JsonProperty("txtShinsakaiIken")
    public void setTxtShinsakaiIken(TextBoxMultiLine txtShinsakaiIken) {
        this.txtShinsakaiIken = txtShinsakaiIken;
    }

    // </editor-fold>
}
