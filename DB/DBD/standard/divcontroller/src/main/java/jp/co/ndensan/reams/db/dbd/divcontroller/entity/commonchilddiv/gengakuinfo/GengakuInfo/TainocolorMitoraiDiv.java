package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gengakuinfo.GengakuInfo;
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
 * TainocolorMitorai のクラスファイル 
 * 
 * @author 自動生成
 */
public class TainocolorMitoraiDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celDummyYellow")
    private celDummyYellowAtTainocolorMitorai celDummyYellow;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblDummyYellow() {
        return this.celDummyYellow.getLblDummyYellow();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelDummyYellow
     * @return celDummyYellow
     */
    @JsonProperty("celDummyYellow")
    private celDummyYellowAtTainocolorMitorai getCelDummyYellow() {
        return celDummyYellow;
    }

    /*
     * setcelDummyYellow
     * @param celDummyYellow celDummyYellow
     */
    @JsonProperty("celDummyYellow")
    private void setCelDummyYellow(celDummyYellowAtTainocolorMitorai celDummyYellow) {
        this.celDummyYellow = celDummyYellow;
    }

    // </editor-fold>
}
/**
 * celDummyYellow のクラスファイル 
 * 
 * @author 自動生成
 */
class celDummyYellowAtTainocolorMitorai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblDummyYellow")
    private Label lblDummyYellow;

    /*
     * getlblDummyYellow
     * @return lblDummyYellow
     */
    @JsonProperty("lblDummyYellow")
    public Label getLblDummyYellow() {
        return lblDummyYellow;
    }

    /*
     * setlblDummyYellow
     * @param lblDummyYellow lblDummyYellow
     */
    @JsonProperty("lblDummyYellow")
    public void setLblDummyYellow(Label lblDummyYellow) {
        this.lblDummyYellow = lblDummyYellow;
    }

    // </editor-fold>
}
