package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TokuKaishiTsuchiKobetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuKaishiTsuchiKobetsuDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTokuKaishiTsuchiHakkoYMD")
    private TextBoxDate txtTokuKaishiTsuchiHakkoYMD;
    @JsonProperty("lblTokuKaishiInjiType")
    private Label lblTokuKaishiInjiType;
    @JsonProperty("radTokuKaishiInjiType")
    private RadioButton radTokuKaishiInjiType;
    @JsonProperty("lblTokuKaishiTsuchiType")
    private Label lblTokuKaishiTsuchiType;
    @JsonProperty("radTokuKaishiTsuchiType")
    private RadioButton radTokuKaishiTsuchiType;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtTokuKaishiTsuchiHakkoYMD")
    public TextBoxDate getTxtTokuKaishiTsuchiHakkoYMD() {
        return txtTokuKaishiTsuchiHakkoYMD;
    }

    @JsonProperty("txtTokuKaishiTsuchiHakkoYMD")
    public void setTxtTokuKaishiTsuchiHakkoYMD(TextBoxDate txtTokuKaishiTsuchiHakkoYMD) {
        this.txtTokuKaishiTsuchiHakkoYMD=txtTokuKaishiTsuchiHakkoYMD;
    }

    @JsonProperty("lblTokuKaishiInjiType")
    public Label getLblTokuKaishiInjiType() {
        return lblTokuKaishiInjiType;
    }

    @JsonProperty("lblTokuKaishiInjiType")
    public void setLblTokuKaishiInjiType(Label lblTokuKaishiInjiType) {
        this.lblTokuKaishiInjiType=lblTokuKaishiInjiType;
    }

    @JsonProperty("radTokuKaishiInjiType")
    public RadioButton getRadTokuKaishiInjiType() {
        return radTokuKaishiInjiType;
    }

    @JsonProperty("radTokuKaishiInjiType")
    public void setRadTokuKaishiInjiType(RadioButton radTokuKaishiInjiType) {
        this.radTokuKaishiInjiType=radTokuKaishiInjiType;
    }

    @JsonProperty("lblTokuKaishiTsuchiType")
    public Label getLblTokuKaishiTsuchiType() {
        return lblTokuKaishiTsuchiType;
    }

    @JsonProperty("lblTokuKaishiTsuchiType")
    public void setLblTokuKaishiTsuchiType(Label lblTokuKaishiTsuchiType) {
        this.lblTokuKaishiTsuchiType=lblTokuKaishiTsuchiType;
    }

    @JsonProperty("radTokuKaishiTsuchiType")
    public RadioButton getRadTokuKaishiTsuchiType() {
        return radTokuKaishiTsuchiType;
    }

    @JsonProperty("radTokuKaishiTsuchiType")
    public void setRadTokuKaishiTsuchiType(RadioButton radTokuKaishiTsuchiType) {
        this.radTokuKaishiTsuchiType=radTokuKaishiTsuchiType;
    }

}
