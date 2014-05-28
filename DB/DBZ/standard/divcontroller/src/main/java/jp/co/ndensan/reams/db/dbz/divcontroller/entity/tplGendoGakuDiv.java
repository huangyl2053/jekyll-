package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShuruiShikyuGendoKijungakuDiv;
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
    @JsonProperty("lblKubunShikyuGendoGaku")
    private Label lblKubunShikyuGendoGaku;
    @JsonProperty("txtKyuhuYukoKikan")
    private TextBoxDateRange txtKyuhuYukoKikan;
    @JsonProperty("txtKubunShikyuGendoKijunGaku")
    private TextBoxNum txtKubunShikyuGendoKijunGaku;
    @JsonProperty("ShuruiShikyuGendoKijungaku")
    private ShuruiShikyuGendoKijungakuDiv ShuruiShikyuGendoKijungaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblKubunShikyuGendoGaku")
    public Label getLblKubunShikyuGendoGaku() {
        return lblKubunShikyuGendoGaku;
    }

    @JsonProperty("lblKubunShikyuGendoGaku")
    public void setLblKubunShikyuGendoGaku(Label lblKubunShikyuGendoGaku) {
        this.lblKubunShikyuGendoGaku=lblKubunShikyuGendoGaku;
    }

    @JsonProperty("txtKyuhuYukoKikan")
    public TextBoxDateRange getTxtKyuhuYukoKikan() {
        return txtKyuhuYukoKikan;
    }

    @JsonProperty("txtKyuhuYukoKikan")
    public void setTxtKyuhuYukoKikan(TextBoxDateRange txtKyuhuYukoKikan) {
        this.txtKyuhuYukoKikan=txtKyuhuYukoKikan;
    }

    @JsonProperty("txtKubunShikyuGendoKijunGaku")
    public TextBoxNum getTxtKubunShikyuGendoKijunGaku() {
        return txtKubunShikyuGendoKijunGaku;
    }

    @JsonProperty("txtKubunShikyuGendoKijunGaku")
    public void setTxtKubunShikyuGendoKijunGaku(TextBoxNum txtKubunShikyuGendoKijunGaku) {
        this.txtKubunShikyuGendoKijunGaku=txtKubunShikyuGendoKijunGaku;
    }

    @JsonProperty("ShuruiShikyuGendoKijungaku")
    public ShuruiShikyuGendoKijungakuDiv getShuruiShikyuGendoKijungaku() {
        return ShuruiShikyuGendoKijungaku;
    }

    @JsonProperty("ShuruiShikyuGendoKijungaku")
    public void setShuruiShikyuGendoKijungaku(ShuruiShikyuGendoKijungakuDiv ShuruiShikyuGendoKijungaku) {
        this.ShuruiShikyuGendoKijungaku=ShuruiShikyuGendoKijungaku;
    }

}
