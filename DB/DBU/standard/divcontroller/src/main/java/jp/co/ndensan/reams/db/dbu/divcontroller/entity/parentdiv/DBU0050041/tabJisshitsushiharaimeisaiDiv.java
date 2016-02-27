package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050041;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tabJisshitsushiharaimeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabJisshitsushiharaimeisaiDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabJisshitsushiharai")
    private tabJisshitsushiharaiDiv tabJisshitsushiharai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabJisshitsushiharai
     * @return tabJisshitsushiharai
     */
    @JsonProperty("tabJisshitsushiharai")
    public tabJisshitsushiharaiDiv getTabJisshitsushiharai() {
        return tabJisshitsushiharai;
    }

    /*
     * settabJisshitsushiharai
     * @param tabJisshitsushiharai tabJisshitsushiharai
     */
    @JsonProperty("tabJisshitsushiharai")
    public void setTabJisshitsushiharai(tabJisshitsushiharaiDiv tabJisshitsushiharai) {
        this.tabJisshitsushiharai = tabJisshitsushiharai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblshitsusainyugokei() {
        return this.getTabJisshitsushiharai().getLblshitsusainyugokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtshitsusainyugokei() {
        return this.getTabJisshitsushiharai().getTxtshitsusainyugokei();
    }

    @JsonIgnore
    public Label getLblshitsusaishutsugokei() {
        return this.getTabJisshitsushiharai().getLblshitsusaishutsugokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtshitsusaishutsugokei() {
        return this.getTabJisshitsushiharai().getTxtshitsusaishutsugokei();
    }

    @JsonIgnore
    public Label getLblshitsusainyusaishutsusa() {
        return this.getTabJisshitsushiharai().getLblshitsusainyusaishutsusa();
    }

    @JsonIgnore
    public TextBoxNum getTxtshitsusainyusaishutsusa() {
        return this.getTabJisshitsushiharai().getTxtshitsusainyusaishutsusa();
    }

    @JsonIgnore
    public Label getLblshitsuseisangozangaku() {
        return this.getTabJisshitsushiharai().getLblshitsuseisangozangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtshitsuseisangozangaku() {
        return this.getTabJisshitsushiharai().getTxtshitsuseisangozangaku();
    }

    // </editor-fold>
}
