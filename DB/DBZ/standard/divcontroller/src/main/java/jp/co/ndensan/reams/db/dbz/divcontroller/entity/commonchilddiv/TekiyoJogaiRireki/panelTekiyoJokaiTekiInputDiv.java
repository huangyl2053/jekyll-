package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.IShisetsuJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * panelTekiyoJokaiTekiInput のクラスファイル
 *
 * @author 自動生成
 */
public class panelTekiyoJokaiTekiInputDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelJogaisyaTekiyo")
    private panelJogaisyaTekiyoDiv panelJogaisyaTekiyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelJogaisyaTekiyo
     * @return panelJogaisyaTekiyo
     */
    @JsonProperty("panelJogaisyaTekiyo")
    public panelJogaisyaTekiyoDiv getPanelJogaisyaTekiyo() {
        return panelJogaisyaTekiyo;
    }

    /*
     * setpanelJogaisyaTekiyo
     * @param panelJogaisyaTekiyo panelJogaisyaTekiyo
     */
    @JsonProperty("panelJogaisyaTekiyo")
    public void setPanelJogaisyaTekiyo(panelJogaisyaTekiyoDiv panelJogaisyaTekiyo) {
        this.panelJogaisyaTekiyo = panelJogaisyaTekiyo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtNyusyoDateInput() {
        return this.getPanelJogaisyaTekiyo().getTxtNyusyoDateInput();
    }

    @JsonIgnore
    public void setTxtNyusyoDateInput(TextBoxDate txtNyusyoDateInput) {
        this.getPanelJogaisyaTekiyo().setTxtNyusyoDateInput(txtNyusyoDateInput);
    }

    @JsonIgnore
    public TextBoxDate getTxtTekiyoDateInput() {
        return this.getPanelJogaisyaTekiyo().getTxtTekiyoDateInput();
    }

    @JsonIgnore
    public void setTxtTekiyoDateInput(TextBoxDate txtTekiyoDateInput) {
        this.getPanelJogaisyaTekiyo().setTxtTekiyoDateInput(txtTekiyoDateInput);
    }

    @JsonIgnore
    public TextBoxDate getTxtTkyoTododkDateIn() {
        return this.getPanelJogaisyaTekiyo().getTxtTkyoTododkDateIn();
    }

    @JsonIgnore
    public void setTxtTkyoTododkDateIn(TextBoxDate txtTkyoTododkDateIn) {
        this.getPanelJogaisyaTekiyo().setTxtTkyoTododkDateIn(txtTkyoTododkDateIn);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoJiyuInput() {
        return this.getPanelJogaisyaTekiyo().getDdlTekiyoJiyuInput();
    }

    @JsonIgnore
    public void setDdlTekiyoJiyuInput(DropDownList ddlTekiyoJiyuInput) {
        this.getPanelJogaisyaTekiyo().setDdlTekiyoJiyuInput(ddlTekiyoJiyuInput);
    }

    @JsonIgnore
    public IShisetsuJohoDiv getCcdShisetsuJoho() {
        return this.getPanelJogaisyaTekiyo().getCcdShisetsuJoho();
    }

    // </editor-fold>
}
