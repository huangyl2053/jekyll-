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
 * TainocolorTaishoGai のクラスファイル 
 * 
 * @author 自動生成
 */
public class TainocolorTaishoGaiDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celLightSalmon")
    private celLightSalmonAtTainocolorTaishoGai celLightSalmon;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblLightSalmon() {
        return this.celLightSalmon.getLblLightSalmon();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelLightSalmon
     * @return celLightSalmon
     */
    @JsonProperty("celLightSalmon")
    private celLightSalmonAtTainocolorTaishoGai getCelLightSalmon() {
        return celLightSalmon;
    }

    /*
     * setcelLightSalmon
     * @param celLightSalmon celLightSalmon
     */
    @JsonProperty("celLightSalmon")
    private void setCelLightSalmon(celLightSalmonAtTainocolorTaishoGai celLightSalmon) {
        this.celLightSalmon = celLightSalmon;
    }

    // </editor-fold>
}
/**
 * celLightSalmon のクラスファイル 
 * 
 * @author 自動生成
 */
class celLightSalmonAtTainocolorTaishoGai extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblLightSalmon")
    private Label lblLightSalmon;

    /*
     * getlblLightSalmon
     * @return lblLightSalmon
     */
    @JsonProperty("lblLightSalmon")
    public Label getLblLightSalmon() {
        return lblLightSalmon;
    }

    /*
     * setlblLightSalmon
     * @param lblLightSalmon lblLightSalmon
     */
    @JsonProperty("lblLightSalmon")
    public void setLblLightSalmon(Label lblLightSalmon) {
        this.lblLightSalmon = lblLightSalmon;
    }

    // </editor-fold>
}
