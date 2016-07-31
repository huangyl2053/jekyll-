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
 * TainocolorKanno のクラスファイル 
 * 
 * @author 自動生成
 */
public class TainocolorKannoDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celWhite")
    private celWhiteAtTainocolorKanno celWhite;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblColorWhite() {
        return this.celWhite.getLblColorWhite();
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
    private celWhiteAtTainocolorKanno getCelWhite() {
        return celWhite;
    }

    /*
     * setcelWhite
     * @param celWhite celWhite
     */
    @JsonProperty("celWhite")
    private void setCelWhite(celWhiteAtTainocolorKanno celWhite) {
        this.celWhite = celWhite;
    }

    // </editor-fold>
}
/**
 * celWhite のクラスファイル 
 * 
 * @author 自動生成
 */
class celWhiteAtTainocolorKanno extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblColorWhite")
    private Label lblColorWhite;

    /*
     * getlblColorWhite
     * @return lblColorWhite
     */
    @JsonProperty("lblColorWhite")
    public Label getLblColorWhite() {
        return lblColorWhite;
    }

    /*
     * setlblColorWhite
     * @param lblColorWhite lblColorWhite
     */
    @JsonProperty("lblColorWhite")
    public void setLblColorWhite(Label lblColorWhite) {
        this.lblColorWhite = lblColorWhite;
    }

    // </editor-fold>
}
