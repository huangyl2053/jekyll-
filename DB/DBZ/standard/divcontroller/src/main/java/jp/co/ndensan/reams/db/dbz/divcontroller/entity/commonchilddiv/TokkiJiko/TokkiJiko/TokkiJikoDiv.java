package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.TokkiJiko.TokkiJiko;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.TokkiJiko.TokkiJiko.ITokkiJikoDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokkiJiko のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokkiJikoDiv extends Panel implements ITokkiJikoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblTokki")
    private Label lblTokki;
    @JsonProperty("imgTokkiJiko")
    private StaticImage imgTokkiJiko;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnMasking")
    private Button btnMasking;
    @JsonProperty("btnCancel")
    private Button btnCancel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblTokki")
    public Label getLblTokki() {
        return lblTokki;
    }

    @JsonProperty("lblTokki")
    public void setLblTokki(Label lblTokki) {
        this.lblTokki=lblTokki;
    }

    @JsonProperty("imgTokkiJiko")
    public StaticImage getImgTokkiJiko() {
        return imgTokkiJiko;
    }

    @JsonProperty("imgTokkiJiko")
    public void setImgTokkiJiko(StaticImage imgTokkiJiko) {
        this.imgTokkiJiko=imgTokkiJiko;
    }

    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei=btnKakutei;
    }

    @JsonProperty("btnMasking")
    public Button getBtnMasking() {
        return btnMasking;
    }

    @JsonProperty("btnMasking")
    public void setBtnMasking(Button btnMasking) {
        this.btnMasking=btnMasking;
    }

    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel=btnCancel;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
