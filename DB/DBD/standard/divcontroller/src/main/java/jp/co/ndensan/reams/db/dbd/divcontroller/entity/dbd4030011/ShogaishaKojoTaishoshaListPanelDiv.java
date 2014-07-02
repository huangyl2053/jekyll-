package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4030011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShogaishaKojoTaishoshaListPanel のクラスファイル
 *
 * @author 自動生成
 */
public class ShogaishaKojoTaishoshaListPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("txtKijunDate")
    private TextBoxDate txtKijunDate;
    @JsonProperty("txtHaakuCondition")
    private TextBox txtHaakuCondition;
    @JsonProperty("txtHaakuDate")
    private TextBoxDate txtHaakuDate;
    @JsonProperty("dgShogaishaKojoTahishosha")
    private DataGrid<dgShogaishaKojoTahishosha_Row> dgShogaishaKojoTahishosha;
    @JsonProperty("txtTaishosha")
    private TextBoxNum txtTaishosha;
    @JsonProperty("txtNinteisha")
    private TextBoxNum txtNinteisha;
    @JsonProperty("txtHigaitosha")
    private TextBoxNum txtHigaitosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKijunDate")
    public TextBoxDate getTxtKijunDate() {
        return txtKijunDate;
    }

    @JsonProperty("txtKijunDate")
    public void setTxtKijunDate(TextBoxDate txtKijunDate) {
        this.txtKijunDate = txtKijunDate;
    }

    @JsonProperty("txtHaakuCondition")
    public TextBox getTxtHaakuCondition() {
        return txtHaakuCondition;
    }

    @JsonProperty("txtHaakuCondition")
    public void setTxtHaakuCondition(TextBox txtHaakuCondition) {
        this.txtHaakuCondition = txtHaakuCondition;
    }

    @JsonProperty("txtHaakuDate")
    public TextBoxDate getTxtHaakuDate() {
        return txtHaakuDate;
    }

    @JsonProperty("txtHaakuDate")
    public void setTxtHaakuDate(TextBoxDate txtHaakuDate) {
        this.txtHaakuDate = txtHaakuDate;
    }

    @JsonProperty("dgShogaishaKojoTahishosha")
    public DataGrid<dgShogaishaKojoTahishosha_Row> getDgShogaishaKojoTahishosha() {
        return dgShogaishaKojoTahishosha;
    }

    @JsonProperty("dgShogaishaKojoTahishosha")
    public void setDgShogaishaKojoTahishosha(DataGrid<dgShogaishaKojoTahishosha_Row> dgShogaishaKojoTahishosha) {
        this.dgShogaishaKojoTahishosha = dgShogaishaKojoTahishosha;
    }

    @JsonProperty("txtTaishosha")
    public TextBoxNum getTxtTaishosha() {
        return txtTaishosha;
    }

    @JsonProperty("txtTaishosha")
    public void setTxtTaishosha(TextBoxNum txtTaishosha) {
        this.txtTaishosha = txtTaishosha;
    }

    @JsonProperty("txtNinteisha")
    public TextBoxNum getTxtNinteisha() {
        return txtNinteisha;
    }

    @JsonProperty("txtNinteisha")
    public void setTxtNinteisha(TextBoxNum txtNinteisha) {
        this.txtNinteisha = txtNinteisha;
    }

    @JsonProperty("txtHigaitosha")
    public TextBoxNum getTxtHigaitosha() {
        return txtHigaitosha;
    }

    @JsonProperty("txtHigaitosha")
    public void setTxtHigaitosha(TextBoxNum txtHigaitosha) {
        this.txtHigaitosha = txtHigaitosha;
    }

}
