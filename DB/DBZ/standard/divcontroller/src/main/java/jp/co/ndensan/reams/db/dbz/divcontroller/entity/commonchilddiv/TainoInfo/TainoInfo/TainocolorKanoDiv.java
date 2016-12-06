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
 * TainocolorKano のクラスファイル 
 * 
 * @author 自動生成
 */
public class TainocolorKanoDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("GreenCell1")
    private GreenCell1AtTainocolorKano GreenCell1;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblDummyGreen() {
        return this.GreenCell1.getLblDummyGreen();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getGreenCell1
     * @return GreenCell1
     */
    @JsonProperty("GreenCell1")
    private GreenCell1AtTainocolorKano getGreenCell1() {
        return GreenCell1;
    }

    /*
     * setGreenCell1
     * @param GreenCell1 GreenCell1
     */
    @JsonProperty("GreenCell1")
    private void setGreenCell1(GreenCell1AtTainocolorKano GreenCell1) {
        this.GreenCell1 = GreenCell1;
    }

    // </editor-fold>
}
/**
 * GreenCell1 のクラスファイル 
 * 
 * @author 自動生成
 */
class GreenCell1AtTainocolorKano extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    @JsonProperty("lblDummyGreen")
    private Label lblDummyGreen;

    /*
     * getlblDummyGreen
     * @return lblDummyGreen
     */
    @JsonProperty("lblDummyGreen")
    public Label getLblDummyGreen() {
        return lblDummyGreen;
    }

    /*
     * setlblDummyGreen
     * @param lblDummyGreen lblDummyGreen
     */
    @JsonProperty("lblDummyGreen")
    public void setLblDummyGreen(Label lblDummyGreen) {
        this.lblDummyGreen = lblDummyGreen;
    }

    // </editor-fold>
}
