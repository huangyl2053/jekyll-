package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;

/**
 * tabkaigokyufuhijunhoyu のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabkaigokyufuhijunhoyuDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("cellkaigokyufuhijunhoyu")
    private cellkaigokyufuhijunhoyuAttabkaigokyufuhijunhoyu cellkaigokyufuhijunhoyu;
    @JsonProperty("tab")
    private tabAttabkaigokyufuhijunhoyu tab;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblkaigokyufuhijunhoyu() {
        return this.cellkaigokyufuhijunhoyu.getLblkaigokyufuhijunhoyu();
    }

    @JsonIgnore
    public TextBoxNum getTxtkaigokyufuhijunhoyu() {
        return this.tab.getTxtkaigokyufuhijunhoyu();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcellkaigokyufuhijunhoyu
     * @return cellkaigokyufuhijunhoyu
     */
    @JsonProperty("cellkaigokyufuhijunhoyu")
    private cellkaigokyufuhijunhoyuAttabkaigokyufuhijunhoyu getCellkaigokyufuhijunhoyu() {
        return cellkaigokyufuhijunhoyu;
    }

    /*
     * setcellkaigokyufuhijunhoyu
     * @param cellkaigokyufuhijunhoyu cellkaigokyufuhijunhoyu
     */
    @JsonProperty("cellkaigokyufuhijunhoyu")
    private void setCellkaigokyufuhijunhoyu(cellkaigokyufuhijunhoyuAttabkaigokyufuhijunhoyu cellkaigokyufuhijunhoyu) {
        this.cellkaigokyufuhijunhoyu = cellkaigokyufuhijunhoyu;
    }

    /*
     * gettab
     * @return tab
     */
    @JsonProperty("tab")
    private tabAttabkaigokyufuhijunhoyu getTab() {
        return tab;
    }

    /*
     * settab
     * @param tab tab
     */
    @JsonProperty("tab")
    private void setTab(tabAttabkaigokyufuhijunhoyu tab) {
        this.tab = tab;
    }

    // </editor-fold>
}
/**
 * cellkaigokyufuhijunhoyu のクラスファイル 
 * 
 * @author 自動生成
 */
class cellkaigokyufuhijunhoyuAttabkaigokyufuhijunhoyu extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("lblkaigokyufuhijunhoyu")
    private Label lblkaigokyufuhijunhoyu;

    /*
     * getlblkaigokyufuhijunhoyu
     * @return lblkaigokyufuhijunhoyu
     */
    @JsonProperty("lblkaigokyufuhijunhoyu")
    public Label getLblkaigokyufuhijunhoyu() {
        return lblkaigokyufuhijunhoyu;
    }

    /*
     * setlblkaigokyufuhijunhoyu
     * @param lblkaigokyufuhijunhoyu lblkaigokyufuhijunhoyu
     */
    @JsonProperty("lblkaigokyufuhijunhoyu")
    public void setLblkaigokyufuhijunhoyu(Label lblkaigokyufuhijunhoyu) {
        this.lblkaigokyufuhijunhoyu = lblkaigokyufuhijunhoyu;
    }

    // </editor-fold>
}
/**
 * tab のクラスファイル 
 * 
 * @author 自動生成
 */
class tabAttabkaigokyufuhijunhoyu extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    @JsonProperty("txtkaigokyufuhijunhoyu")
    private TextBoxNum txtkaigokyufuhijunhoyu;

    /*
     * gettxtkaigokyufuhijunhoyu
     * @return txtkaigokyufuhijunhoyu
     */
    @JsonProperty("txtkaigokyufuhijunhoyu")
    public TextBoxNum getTxtkaigokyufuhijunhoyu() {
        return txtkaigokyufuhijunhoyu;
    }

    /*
     * settxtkaigokyufuhijunhoyu
     * @param txtkaigokyufuhijunhoyu txtkaigokyufuhijunhoyu
     */
    @JsonProperty("txtkaigokyufuhijunhoyu")
    public void setTxtkaigokyufuhijunhoyu(TextBoxNum txtkaigokyufuhijunhoyu) {
        this.txtkaigokyufuhijunhoyu = txtkaigokyufuhijunhoyu;
    }

    // </editor-fold>
}
