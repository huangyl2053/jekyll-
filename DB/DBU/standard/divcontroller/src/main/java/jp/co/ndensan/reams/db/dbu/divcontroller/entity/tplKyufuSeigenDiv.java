package jp.co.ndensan.reams.db.dbu.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.tblKyuhuSeigenDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplKyufuSeigen のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplKyufuSeigenDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblKyufuSeigen")
    private Label lblKyufuSeigen;
    @JsonProperty("tblKyuhuSeigen")
    private tblKyuhuSeigenDiv tblKyuhuSeigen;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblKyufuSeigen")
    public Label getLblKyufuSeigen() {
        return lblKyufuSeigen;
    }

    @JsonProperty("lblKyufuSeigen")
    public void setLblKyufuSeigen(Label lblKyufuSeigen) {
        this.lblKyufuSeigen=lblKyufuSeigen;
    }

    @JsonProperty("tblKyuhuSeigen")
    public tblKyuhuSeigenDiv getTblKyuhuSeigen() {
        return tblKyuhuSeigen;
    }

    @JsonProperty("tblKyuhuSeigen")
    public void setTblKyuhuSeigen(tblKyuhuSeigenDiv tblKyuhuSeigen) {
        this.tblKyuhuSeigen=tblKyuhuSeigen;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblKyufuSeigenNaiyo() {
        return this.getTblKyuhuSeigen().getLblKyufuSeigenNaiyo();
    }

    @JsonIgnore
    public Label getLblKyufuSeigenKikan() {
        return this.getTblKyuhuSeigen().getLblKyufuSeigenKikan();
    }

    @JsonIgnore
    public TextBox getTxtKyufuSeigenNaiyo1() {
        return this.getTblKyuhuSeigen().getTxtKyufuSeigenNaiyo1();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKyufuSeigenKikan1() {
        return this.getTblKyuhuSeigen().getTxtKyufuSeigenKikan1();
    }

    @JsonIgnore
    public TextBox getTxtKyufuSeigenNaiyo2() {
        return this.getTblKyuhuSeigen().getTxtKyufuSeigenNaiyo2();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKyufuSeigenKikan2() {
        return this.getTblKyuhuSeigen().getTxtKyufuSeigenKikan2();
    }

    @JsonIgnore
    public TextBox getTxtKyufuSeigenNaiyo3() {
        return this.getTblKyuhuSeigen().getTxtKyufuSeigenNaiyo3();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKyufuSeigenKikan3() {
        return this.getTblKyuhuSeigen().getTxtKyufuSeigenKikan3();
    }

}
