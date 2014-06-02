package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001;
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
 * HonTokuKaishiTsuchi のクラスファイル 
 * 
 * @author 自動生成
 */
public class HonTokuKaishiTsuchiDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTokuKaishiTsuchiHakkoYMD")
    private TextBoxDate txtTokuKaishiTsuchiHakkoYMD;
    @JsonProperty("lblTokuKaishiTsuchiDaikou")
    private Label lblTokuKaishiTsuchiDaikou;
    @JsonProperty("radTokuKaishiTsuchiTaisho")
    private RadioButton radTokuKaishiTsuchiTaisho;
    @JsonProperty("Shuturyokujun2")
    private Shuturyokujun2Div Shuturyokujun2;

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

    @JsonProperty("lblTokuKaishiTsuchiDaikou")
    public Label getLblTokuKaishiTsuchiDaikou() {
        return lblTokuKaishiTsuchiDaikou;
    }

    @JsonProperty("lblTokuKaishiTsuchiDaikou")
    public void setLblTokuKaishiTsuchiDaikou(Label lblTokuKaishiTsuchiDaikou) {
        this.lblTokuKaishiTsuchiDaikou=lblTokuKaishiTsuchiDaikou;
    }

    @JsonProperty("radTokuKaishiTsuchiTaisho")
    public RadioButton getRadTokuKaishiTsuchiTaisho() {
        return radTokuKaishiTsuchiTaisho;
    }

    @JsonProperty("radTokuKaishiTsuchiTaisho")
    public void setRadTokuKaishiTsuchiTaisho(RadioButton radTokuKaishiTsuchiTaisho) {
        this.radTokuKaishiTsuchiTaisho=radTokuKaishiTsuchiTaisho;
    }

    @JsonProperty("Shuturyokujun2")
    public Shuturyokujun2Div getShuturyokujun2() {
        return Shuturyokujun2;
    }

    @JsonProperty("Shuturyokujun2")
    public void setShuturyokujun2(Shuturyokujun2Div Shuturyokujun2) {
        this.Shuturyokujun2=Shuturyokujun2;
    }

}
