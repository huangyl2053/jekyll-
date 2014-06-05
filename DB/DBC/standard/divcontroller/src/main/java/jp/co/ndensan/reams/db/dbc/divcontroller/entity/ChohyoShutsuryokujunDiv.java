package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ChohyoShutsuryokujun のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChohyoShutsuryokujunDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnSortSettei")
    private ButtonDialog btnSortSettei;
    @JsonProperty("txtSortName")
    private TextBox txtSortName;
    @JsonProperty("txtKaiPage")
    private TextBox txtKaiPage;
    @JsonProperty("txtSort")
    private TextBox txtSort;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnSortSettei")
    public ButtonDialog getBtnSortSettei() {
        return btnSortSettei;
    }

    @JsonProperty("btnSortSettei")
    public void setBtnSortSettei(ButtonDialog btnSortSettei) {
        this.btnSortSettei=btnSortSettei;
    }

    @JsonProperty("txtSortName")
    public TextBox getTxtSortName() {
        return txtSortName;
    }

    @JsonProperty("txtSortName")
    public void setTxtSortName(TextBox txtSortName) {
        this.txtSortName=txtSortName;
    }

    @JsonProperty("txtKaiPage")
    public TextBox getTxtKaiPage() {
        return txtKaiPage;
    }

    @JsonProperty("txtKaiPage")
    public void setTxtKaiPage(TextBox txtKaiPage) {
        this.txtKaiPage=txtKaiPage;
    }

    @JsonProperty("txtSort")
    public TextBox getTxtSort() {
        return txtSort;
    }

    @JsonProperty("txtSort")
    public void setTxtSort(TextBox txtSort) {
        this.txtSort=txtSort;
    }

}
