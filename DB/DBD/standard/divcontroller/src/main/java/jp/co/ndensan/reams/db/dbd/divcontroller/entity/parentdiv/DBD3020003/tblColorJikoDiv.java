package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3020003;
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
 * tblColorJiko のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblColorJikoDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celColorJiko")
    private celColorJikoAttblColorJiko celColorJiko;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblDummyJiko() {
        return this.celColorJiko.getLblDummyJiko();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelColorJiko
     * @return celColorJiko
     */
    @JsonProperty("celColorJiko")
    private celColorJikoAttblColorJiko getCelColorJiko() {
        return celColorJiko;
    }

    /*
     * setcelColorJiko
     * @param celColorJiko celColorJiko
     */
    @JsonProperty("celColorJiko")
    private void setCelColorJiko(celColorJikoAttblColorJiko celColorJiko) {
        this.celColorJiko = celColorJiko;
    }

    // </editor-fold>
}
/**
 * celColorJiko のクラスファイル 
 * 
 * @author 自動生成
 */
class celColorJikoAttblColorJiko extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblDummyJiko")
    private Label lblDummyJiko;

    /*
     * getlblDummyJiko
     * @return lblDummyJiko
     */
    @JsonProperty("lblDummyJiko")
    public Label getLblDummyJiko() {
        return lblDummyJiko;
    }

    /*
     * setlblDummyJiko
     * @param lblDummyJiko lblDummyJiko
     */
    @JsonProperty("lblDummyJiko")
    public void setLblDummyJiko(Label lblDummyJiko) {
        this.lblDummyJiko = lblDummyJiko;
    }

    // </editor-fold>
}
