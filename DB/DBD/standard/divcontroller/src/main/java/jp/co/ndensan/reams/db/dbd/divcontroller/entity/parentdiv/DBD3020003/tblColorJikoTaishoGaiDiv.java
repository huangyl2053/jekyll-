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
 * tblColorJikoTaishoGai のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblColorJikoTaishoGaiDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-02_13-24-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celColorTaishoGai")
    private celColorTaishoGaiAttblColorJikoTaishoGai celColorTaishoGai;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblDummyJikoTaishoGai() {
        return this.celColorTaishoGai.getLblDummyJikoTaishoGai();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelColorTaishoGai
     * @return celColorTaishoGai
     */
    @JsonProperty("celColorTaishoGai")
    private celColorTaishoGaiAttblColorJikoTaishoGai getCelColorTaishoGai() {
        return celColorTaishoGai;
    }

    /*
     * setcelColorTaishoGai
     * @param celColorTaishoGai celColorTaishoGai
     */
    @JsonProperty("celColorTaishoGai")
    private void setCelColorTaishoGai(celColorTaishoGaiAttblColorJikoTaishoGai celColorTaishoGai) {
        this.celColorTaishoGai = celColorTaishoGai;
    }

    // </editor-fold>
}
/**
 * celColorTaishoGai のクラスファイル 
 * 
 * @author 自動生成
 */
class celColorTaishoGaiAttblColorJikoTaishoGai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-02_13-24-25">
    @JsonProperty("lblDummyJikoTaishoGai")
    private Label lblDummyJikoTaishoGai;

    /*
     * getlblDummyJikoTaishoGai
     * @return lblDummyJikoTaishoGai
     */
    @JsonProperty("lblDummyJikoTaishoGai")
    public Label getLblDummyJikoTaishoGai() {
        return lblDummyJikoTaishoGai;
    }

    /*
     * setlblDummyJikoTaishoGai
     * @param lblDummyJikoTaishoGai lblDummyJikoTaishoGai
     */
    @JsonProperty("lblDummyJikoTaishoGai")
    public void setLblDummyJikoTaishoGai(Label lblDummyJikoTaishoGai) {
        this.lblDummyJikoTaishoGai = lblDummyJikoTaishoGai;
    }

    // </editor-fold>
}
