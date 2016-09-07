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
 * tblColorKanno のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblColorKannoDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celWhite")
    private celWhiteAttblColorKanno celWhite;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblDummyKanno() {
        return this.celWhite.getLblDummyKanno();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelWhite
     * @return celWhite
     */
    @JsonProperty("celWhite")
    private celWhiteAttblColorKanno getCelWhite() {
        return celWhite;
    }

    /*
     * setcelWhite
     * @param celWhite celWhite
     */
    @JsonProperty("celWhite")
    private void setCelWhite(celWhiteAttblColorKanno celWhite) {
        this.celWhite = celWhite;
    }

    // </editor-fold>
}
/**
 * celWhite のクラスファイル 
 * 
 * @author 自動生成
 */
class celWhiteAttblColorKanno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblDummyKanno")
    private Label lblDummyKanno;

    /*
     * getlblDummyKanno
     * @return lblDummyKanno
     */
    @JsonProperty("lblDummyKanno")
    public Label getLblDummyKanno() {
        return lblDummyKanno;
    }

    /*
     * setlblDummyKanno
     * @param lblDummyKanno lblDummyKanno
     */
    @JsonProperty("lblDummyKanno")
    public void setLblDummyKanno(Label lblDummyKanno) {
        this.lblDummyKanno = lblDummyKanno;
    }

    // </editor-fold>
}
