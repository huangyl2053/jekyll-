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
 * tblTsuki3 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblTsuki3Div extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celTsuki14")
    private celTsuki14AttblTsuki3 celTsuki14;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblTsuki14() {
        return this.celTsuki14.getLblTsuki14();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelTsuki14
     * @return celTsuki14
     */
    @JsonProperty("celTsuki14")
    private celTsuki14AttblTsuki3 getCelTsuki14() {
        return celTsuki14;
    }

    /*
     * setcelTsuki14
     * @param celTsuki14 celTsuki14
     */
    @JsonProperty("celTsuki14")
    private void setCelTsuki14(celTsuki14AttblTsuki3 celTsuki14) {
        this.celTsuki14 = celTsuki14;
    }

    // </editor-fold>
}
/**
 * celTsuki14 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTsuki14AttblTsuki3 extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblTsuki14")
    private Label lblTsuki14;

    /*
     * getlblTsuki14
     * @return lblTsuki14
     */
    @JsonProperty("lblTsuki14")
    public Label getLblTsuki14() {
        return lblTsuki14;
    }

    /*
     * setlblTsuki14
     * @param lblTsuki14 lblTsuki14
     */
    @JsonProperty("lblTsuki14")
    public void setLblTsuki14(Label lblTsuki14) {
        this.lblTsuki14 = lblTsuki14;
    }

    // </editor-fold>
}
