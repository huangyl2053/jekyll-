package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TainocolorTaishoGai のクラスファイル 
 * 
 * @author 自動生成
 */
public class TainocolorTaishoGaiDiv extends TablePanel {
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
    @JsonProperty("celLightSalmon")
    private celLightSalmonAtTainocolorTaishoGai getCelLightSalmon() {
        return celLightSalmon;
    }

    @JsonProperty("celLightSalmon")
    private void setCelLightSalmon(celLightSalmonAtTainocolorTaishoGai celLightSalmon) {
        this.celLightSalmon=celLightSalmon;
    }

}
/**
 * celLightSalmon のクラスファイル 
 * 
 * @author 自動生成
 */
class celLightSalmonAtTainocolorTaishoGai extends TableCell {
    @JsonProperty("lblLightSalmon")
    private Label lblLightSalmon;

    @JsonProperty("lblLightSalmon")
    public Label getLblLightSalmon() {
        return lblLightSalmon;
    }

    @JsonProperty("lblLightSalmon")
    public void setLblLightSalmon(Label lblLightSalmon) {
        this.lblLightSalmon=lblLightSalmon;
    }

}
