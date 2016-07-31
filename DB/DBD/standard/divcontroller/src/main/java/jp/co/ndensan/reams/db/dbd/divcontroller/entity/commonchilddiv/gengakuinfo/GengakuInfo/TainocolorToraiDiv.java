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
 * TainocolorTorai のクラスファイル 
 * 
 * @author 自動生成
 */
public class TainocolorToraiDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celDummyRed")
    private celDummyRedAtTainocolorTorai celDummyRed;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblDummyRed() {
        return this.celDummyRed.getLblDummyRed();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelDummyRed
     * @return celDummyRed
     */
    @JsonProperty("celDummyRed")
    private celDummyRedAtTainocolorTorai getCelDummyRed() {
        return celDummyRed;
    }

    /*
     * setcelDummyRed
     * @param celDummyRed celDummyRed
     */
    @JsonProperty("celDummyRed")
    private void setCelDummyRed(celDummyRedAtTainocolorTorai celDummyRed) {
        this.celDummyRed = celDummyRed;
    }

    // </editor-fold>
}
/**
 * celDummyRed のクラスファイル 
 * 
 * @author 自動生成
 */
class celDummyRedAtTainocolorTorai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblDummyRed")
    private Label lblDummyRed;

    /*
     * getlblDummyRed
     * @return lblDummyRed
     */
    @JsonProperty("lblDummyRed")
    public Label getLblDummyRed() {
        return lblDummyRed;
    }

    /*
     * setlblDummyRed
     * @param lblDummyRed lblDummyRed
     */
    @JsonProperty("lblDummyRed")
    public void setLblDummyRed(Label lblDummyRed) {
        this.lblDummyRed = lblDummyRed;
    }

    // </editor-fold>
}
