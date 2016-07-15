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
 * TainocolorKano のクラスファイル 
 * 
 * @author 自動生成
 */
public class TainocolorKanoDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celDummyGreen")
    private celDummyGreenAtTainocolorKano celDummyGreen;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblDummyGreen() {
        return this.celDummyGreen.getLblDummyGreen();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelDummyGreen
     * @return celDummyGreen
     */
    @JsonProperty("celDummyGreen")
    private celDummyGreenAtTainocolorKano getCelDummyGreen() {
        return celDummyGreen;
    }

    /*
     * setcelDummyGreen
     * @param celDummyGreen celDummyGreen
     */
    @JsonProperty("celDummyGreen")
    private void setCelDummyGreen(celDummyGreenAtTainocolorKano celDummyGreen) {
        this.celDummyGreen = celDummyGreen;
    }

    // </editor-fold>
}
/**
 * celDummyGreen のクラスファイル 
 * 
 * @author 自動生成
 */
class celDummyGreenAtTainocolorKano extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
