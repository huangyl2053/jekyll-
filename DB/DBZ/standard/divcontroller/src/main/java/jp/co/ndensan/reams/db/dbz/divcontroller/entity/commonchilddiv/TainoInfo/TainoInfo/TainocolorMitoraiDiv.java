package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.TainoInfo.TainoInfo;
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("YellowCell")
    private YellowCellAtTainocolorMitorai YellowCell;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblDummyYellow() {
        return this.YellowCell.getLblDummyYellow();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getYellowCell
     * @return YellowCell
     */
    @JsonProperty("YellowCell")
    private YellowCellAtTainocolorMitorai getYellowCell() {
        return YellowCell;
    }

    /*
     * setYellowCell
     * @param YellowCell YellowCell
     */
    @JsonProperty("YellowCell")
    private void setYellowCell(YellowCellAtTainocolorMitorai YellowCell) {
        this.YellowCell = YellowCell;
    }

    // </editor-fold>
}
/**
 * YellowCell のクラスファイル 
 * 
 * @author 自動生成
 */
class YellowCellAtTainocolorMitorai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
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
