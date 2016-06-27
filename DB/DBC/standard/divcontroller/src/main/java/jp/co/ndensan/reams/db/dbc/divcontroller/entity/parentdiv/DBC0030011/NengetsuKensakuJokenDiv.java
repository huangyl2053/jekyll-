package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * NengetsuKensakuJoken のクラスファイル
 *
 * @reamsid_L DBC-3000-010 gongliang
 */
public class NengetsuKensakuJokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTeikyoYM")
    private TextBoxDate txtTeikyoYM;
    @JsonProperty("txtShinseiYM")
    private TextBoxDate txtShinseiYM;
    @JsonProperty("txtKetteiYM")
    private TextBoxDate txtKetteiYM;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTeikyoYM
     * @return txtTeikyoYM
     */
    @JsonProperty("txtTeikyoYM")
    public TextBoxDate getTxtTeikyoYM() {
        return txtTeikyoYM;
    }

    /*
     * settxtTeikyoYM
     * @param txtTeikyoYM txtTeikyoYM
     */
    @JsonProperty("txtTeikyoYM")
    public void setTxtTeikyoYM(TextBoxDate txtTeikyoYM) {
        this.txtTeikyoYM = txtTeikyoYM;
    }

    /*
     * gettxtShinseiYM
     * @return txtShinseiYM
     */
    @JsonProperty("txtShinseiYM")
    public TextBoxDate getTxtShinseiYM() {
        return txtShinseiYM;
    }

    /*
     * settxtShinseiYM
     * @param txtShinseiYM txtShinseiYM
     */
    @JsonProperty("txtShinseiYM")
    public void setTxtShinseiYM(TextBoxDate txtShinseiYM) {
        this.txtShinseiYM = txtShinseiYM;
    }

    /*
     * gettxtKetteiYM
     * @return txtKetteiYM
     */
    @JsonProperty("txtKetteiYM")
    public TextBoxDate getTxtKetteiYM() {
        return txtKetteiYM;
    }

    /*
     * settxtKetteiYM
     * @param txtKetteiYM txtKetteiYM
     */
    @JsonProperty("txtKetteiYM")
    public void setTxtKetteiYM(TextBoxDate txtKetteiYM) {
        this.txtKetteiYM = txtKetteiYM;
    }

    // </editor-fold>
}
