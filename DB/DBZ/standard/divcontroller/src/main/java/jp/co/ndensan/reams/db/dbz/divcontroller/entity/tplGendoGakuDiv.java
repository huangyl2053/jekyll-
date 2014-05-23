package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgShuruiShikyuGendoKijunGaku_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplGendoGaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplGendoGakuDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtServiceShurui")
    private TextBox txtServiceShurui;
    @JsonProperty("txtYukoKikan")
    private TextBoxDateRange txtYukoKikan;
    @JsonProperty("txtKubunShikyuGendoKijunGaku")
    private TextBoxNum txtKubunShikyuGendoKijunGaku;
    @JsonProperty("lblShuruiShikyuGendoKijunGaku")
    private Label lblShuruiShikyuGendoKijunGaku;
    @JsonProperty("dgShuruiShikyuGendoKijunGaku")
    private DataGrid<dgShuruiShikyuGendoKijunGaku_Row> dgShuruiShikyuGendoKijunGaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtServiceShurui")
    public TextBox getTxtServiceShurui() {
        return txtServiceShurui;
    }

    @JsonProperty("txtServiceShurui")
    public void setTxtServiceShurui(TextBox txtServiceShurui) {
        this.txtServiceShurui=txtServiceShurui;
    }

    @JsonProperty("txtYukoKikan")
    public TextBoxDateRange getTxtYukoKikan() {
        return txtYukoKikan;
    }

    @JsonProperty("txtYukoKikan")
    public void setTxtYukoKikan(TextBoxDateRange txtYukoKikan) {
        this.txtYukoKikan=txtYukoKikan;
    }

    @JsonProperty("txtKubunShikyuGendoKijunGaku")
    public TextBoxNum getTxtKubunShikyuGendoKijunGaku() {
        return txtKubunShikyuGendoKijunGaku;
    }

    @JsonProperty("txtKubunShikyuGendoKijunGaku")
    public void setTxtKubunShikyuGendoKijunGaku(TextBoxNum txtKubunShikyuGendoKijunGaku) {
        this.txtKubunShikyuGendoKijunGaku=txtKubunShikyuGendoKijunGaku;
    }

    @JsonProperty("lblShuruiShikyuGendoKijunGaku")
    public Label getLblShuruiShikyuGendoKijunGaku() {
        return lblShuruiShikyuGendoKijunGaku;
    }

    @JsonProperty("lblShuruiShikyuGendoKijunGaku")
    public void setLblShuruiShikyuGendoKijunGaku(Label lblShuruiShikyuGendoKijunGaku) {
        this.lblShuruiShikyuGendoKijunGaku=lblShuruiShikyuGendoKijunGaku;
    }

    @JsonProperty("dgShuruiShikyuGendoKijunGaku")
    public DataGrid<dgShuruiShikyuGendoKijunGaku_Row> getDgShuruiShikyuGendoKijunGaku() {
        return dgShuruiShikyuGendoKijunGaku;
    }

    @JsonProperty("dgShuruiShikyuGendoKijunGaku")
    public void setDgShuruiShikyuGendoKijunGaku(DataGrid<dgShuruiShikyuGendoKijunGaku_Row> dgShuruiShikyuGendoKijunGaku) {
        this.dgShuruiShikyuGendoKijunGaku=dgShuruiShikyuGendoKijunGaku;
    }

}
