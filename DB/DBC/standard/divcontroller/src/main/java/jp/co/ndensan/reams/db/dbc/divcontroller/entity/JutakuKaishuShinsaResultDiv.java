package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JutakuKaishuShinsaResult のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuShinsaResultDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("spcShinsaResultTop")
    private Space spcShinsaResultTop;
    @JsonProperty("lblShinseiContents")
    private Label lblShinseiContents;
    @JsonProperty("radShonin")
    private RadioButton radShonin;
    @JsonProperty("spcShinsaResultBottom")
    private Space spcShinsaResultBottom;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("spcShinsaResultTop")
    public Space getSpcShinsaResultTop() {
        return spcShinsaResultTop;
    }

    @JsonProperty("spcShinsaResultTop")
    public void setSpcShinsaResultTop(Space spcShinsaResultTop) {
        this.spcShinsaResultTop=spcShinsaResultTop;
    }

    @JsonProperty("lblShinseiContents")
    public Label getLblShinseiContents() {
        return lblShinseiContents;
    }

    @JsonProperty("lblShinseiContents")
    public void setLblShinseiContents(Label lblShinseiContents) {
        this.lblShinseiContents=lblShinseiContents;
    }

    @JsonProperty("radShonin")
    public RadioButton getRadShonin() {
        return radShonin;
    }

    @JsonProperty("radShonin")
    public void setRadShonin(RadioButton radShonin) {
        this.radShonin=radShonin;
    }

    @JsonProperty("spcShinsaResultBottom")
    public Space getSpcShinsaResultBottom() {
        return spcShinsaResultBottom;
    }

    @JsonProperty("spcShinsaResultBottom")
    public void setSpcShinsaResultBottom(Space spcShinsaResultBottom) {
        this.spcShinsaResultBottom=spcShinsaResultBottom;
    }

}
