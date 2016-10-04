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
 * tblColorMino のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblColorMinoDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celColorMino")
    private celColorMinoAttblColorMino celColorMino;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblDummyMino() {
        return this.celColorMino.getLblDummyMino();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelColorMino
     * @return celColorMino
     */
    @JsonProperty("celColorMino")
    private celColorMinoAttblColorMino getCelColorMino() {
        return celColorMino;
    }

    /*
     * setcelColorMino
     * @param celColorMino celColorMino
     */
    @JsonProperty("celColorMino")
    private void setCelColorMino(celColorMinoAttblColorMino celColorMino) {
        this.celColorMino = celColorMino;
    }

    // </editor-fold>
}
/**
 * celColorMino のクラスファイル 
 * 
 * @author 自動生成
 */
class celColorMinoAttblColorMino extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblDummyMino")
    private Label lblDummyMino;

    /*
     * getlblDummyMino
     * @return lblDummyMino
     */
    @JsonProperty("lblDummyMino")
    public Label getLblDummyMino() {
        return lblDummyMino;
    }

    /*
     * setlblDummyMino
     * @param lblDummyMino lblDummyMino
     */
    @JsonProperty("lblDummyMino")
    public void setLblDummyMino(Label lblDummyMino) {
        this.lblDummyMino = lblDummyMino;
    }

    // </editor-fold>
}
