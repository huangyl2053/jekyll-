package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0430011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * JidoShokanTaishoJohoSettei のクラスファイル
 *
 * @@reamsid_L DBC-4770-011 zhengshenlei
 */
public class JidoShokanTaishoJohoSetteiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiDate")
    private TextBoxFlexibleDate txtShinseiDate;
    @JsonProperty("txtUketsukeDate")
    private TextBoxFlexibleDate txtUketsukeDate;
    @JsonProperty("txtKetteiDate")
    private TextBoxFlexibleDate txtKetteiDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseiDate
     * @return txtShinseiDate
     */
    @JsonProperty("txtShinseiDate")
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    /*
     * settxtShinseiDate
     * @param txtShinseiDate txtShinseiDate
     */
    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.txtShinseiDate = txtShinseiDate;
    }

    /*
     * gettxtUketsukeDate
     * @return txtUketsukeDate
     */
    @JsonProperty("txtUketsukeDate")
    public TextBoxFlexibleDate getTxtUketsukeDate() {
        return txtUketsukeDate;
    }

    /*
     * settxtUketsukeDate
     * @param txtUketsukeDate txtUketsukeDate
     */
    @JsonProperty("txtUketsukeDate")
    public void setTxtUketsukeDate(TextBoxFlexibleDate txtUketsukeDate) {
        this.txtUketsukeDate = txtUketsukeDate;
    }

    /*
     * gettxtKetteiDate
     * @return txtKetteiDate
     */
    @JsonProperty("txtKetteiDate")
    public TextBoxFlexibleDate getTxtKetteiDate() {
        return txtKetteiDate;
    }

    /*
     * settxtKetteiDate
     * @param txtKetteiDate txtKetteiDate
     */
    @JsonProperty("txtKetteiDate")
    public void setTxtKetteiDate(TextBoxFlexibleDate txtKetteiDate) {
        this.txtKetteiDate = txtKetteiDate;
    }

    // </editor-fold>
}
