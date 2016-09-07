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
 * tblColorKano のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblColorKanoDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celColorKano")
    private celColorKanoAttblColorKano celColorKano;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblDummyKano() {
        return this.celColorKano.getLblDummyKano();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelColorKano
     * @return celColorKano
     */
    @JsonProperty("celColorKano")
    private celColorKanoAttblColorKano getCelColorKano() {
        return celColorKano;
    }

    /*
     * setcelColorKano
     * @param celColorKano celColorKano
     */
    @JsonProperty("celColorKano")
    private void setCelColorKano(celColorKanoAttblColorKano celColorKano) {
        this.celColorKano = celColorKano;
    }

    // </editor-fold>
}
/**
 * celColorKano のクラスファイル 
 * 
 * @author 自動生成
 */
class celColorKanoAttblColorKano extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    @JsonProperty("lblDummyKano")
    private Label lblDummyKano;

    /*
     * getlblDummyKano
     * @return lblDummyKano
     */
    @JsonProperty("lblDummyKano")
    public Label getLblDummyKano() {
        return lblDummyKano;
    }

    /*
     * setlblDummyKano
     * @param lblDummyKano lblDummyKano
     */
    @JsonProperty("lblDummyKano")
    public void setLblDummyKano(Label lblDummyKano) {
        this.lblDummyKano = lblDummyKano;
    }

    // </editor-fold>
}
