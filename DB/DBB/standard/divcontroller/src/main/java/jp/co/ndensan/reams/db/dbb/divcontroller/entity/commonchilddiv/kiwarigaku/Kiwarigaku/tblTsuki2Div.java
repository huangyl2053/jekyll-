package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kiwarigaku.Kiwarigaku;
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
 * tblTsuki2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblTsuki2Div extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celTsuki13")
    private celTsuki13AttblTsuki2 celTsuki13;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblTsuki13() {
        return this.celTsuki13.getLblTsuki13();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelTsuki13
     * @return celTsuki13
     */
    @JsonProperty("celTsuki13")
    private celTsuki13AttblTsuki2 getCelTsuki13() {
        return celTsuki13;
    }

    /*
     * setcelTsuki13
     * @param celTsuki13 celTsuki13
     */
    @JsonProperty("celTsuki13")
    private void setCelTsuki13(celTsuki13AttblTsuki2 celTsuki13) {
        this.celTsuki13 = celTsuki13;
    }

    // </editor-fold>
}
/**
 * celTsuki13 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTsuki13AttblTsuki2 extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblTsuki13")
    private Label lblTsuki13;

    /*
     * getlblTsuki13
     * @return lblTsuki13
     */
    @JsonProperty("lblTsuki13")
    public Label getLblTsuki13() {
        return lblTsuki13;
    }

    /*
     * setlblTsuki13
     * @param lblTsuki13 lblTsuki13
     */
    @JsonProperty("lblTsuki13")
    public void setLblTsuki13(Label lblTsuki13) {
        this.lblTsuki13 = lblTsuki13;
    }

    // </editor-fold>
}
