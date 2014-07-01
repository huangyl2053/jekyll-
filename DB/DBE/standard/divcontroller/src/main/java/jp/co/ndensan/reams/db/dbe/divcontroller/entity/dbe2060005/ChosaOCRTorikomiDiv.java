package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060005;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060005.dgChosahyoTorikomiKekka_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ChosaOCRTorikomi のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaOCRTorikomiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnOCRTorikomi")
    private Button btnOCRTorikomi;
    @JsonProperty("lblTorikomiKekka")
    private Label lblTorikomiKekka;
    @JsonProperty("txtErrKensu")
    private TextBoxNum txtErrKensu;
    @JsonProperty("dgChosahyoTorikomiKekka")
    private DataGrid<dgChosahyoTorikomiKekka_Row> dgChosahyoTorikomiKekka;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnOCRTorikomi")
    public Button getBtnOCRTorikomi() {
        return btnOCRTorikomi;
    }

    @JsonProperty("btnOCRTorikomi")
    public void setBtnOCRTorikomi(Button btnOCRTorikomi) {
        this.btnOCRTorikomi=btnOCRTorikomi;
    }

    @JsonProperty("lblTorikomiKekka")
    public Label getLblTorikomiKekka() {
        return lblTorikomiKekka;
    }

    @JsonProperty("lblTorikomiKekka")
    public void setLblTorikomiKekka(Label lblTorikomiKekka) {
        this.lblTorikomiKekka=lblTorikomiKekka;
    }

    @JsonProperty("txtErrKensu")
    public TextBoxNum getTxtErrKensu() {
        return txtErrKensu;
    }

    @JsonProperty("txtErrKensu")
    public void setTxtErrKensu(TextBoxNum txtErrKensu) {
        this.txtErrKensu=txtErrKensu;
    }

    @JsonProperty("dgChosahyoTorikomiKekka")
    public DataGrid<dgChosahyoTorikomiKekka_Row> getDgChosahyoTorikomiKekka() {
        return dgChosahyoTorikomiKekka;
    }

    @JsonProperty("dgChosahyoTorikomiKekka")
    public void setDgChosahyoTorikomiKekka(DataGrid<dgChosahyoTorikomiKekka_Row> dgChosahyoTorikomiKekka) {
        this.dgChosahyoTorikomiKekka=dgChosahyoTorikomiKekka;
    }

}
