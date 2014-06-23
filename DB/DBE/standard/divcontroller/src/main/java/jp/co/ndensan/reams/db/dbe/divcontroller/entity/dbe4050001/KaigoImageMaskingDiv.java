package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4050001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.imageMasking.ImageMaskingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KaigoImageMasking のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoImageMaskingDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblBairitsu")
    private Label lblBairitsu;
    @JsonProperty("ddlHyojiBairitsu")
    private DropDownList ddlHyojiBairitsu;
    @JsonProperty("btnShokiModoshi")
    private Button btnShokiModoshi;
    @JsonProperty("ImageMaskingTool")
    private ImageMaskingDiv ImageMaskingTool;
    @JsonProperty("btnImageToroku")
    private Button btnImageToroku;
    @JsonProperty("btnBackIchiran")
    private Button btnBackIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblBairitsu")
    public Label getLblBairitsu() {
        return lblBairitsu;
    }

    @JsonProperty("lblBairitsu")
    public void setLblBairitsu(Label lblBairitsu) {
        this.lblBairitsu=lblBairitsu;
    }

    @JsonProperty("ddlHyojiBairitsu")
    public DropDownList getDdlHyojiBairitsu() {
        return ddlHyojiBairitsu;
    }

    @JsonProperty("ddlHyojiBairitsu")
    public void setDdlHyojiBairitsu(DropDownList ddlHyojiBairitsu) {
        this.ddlHyojiBairitsu=ddlHyojiBairitsu;
    }

    @JsonProperty("btnShokiModoshi")
    public Button getBtnShokiModoshi() {
        return btnShokiModoshi;
    }

    @JsonProperty("btnShokiModoshi")
    public void setBtnShokiModoshi(Button btnShokiModoshi) {
        this.btnShokiModoshi=btnShokiModoshi;
    }

    @JsonProperty("ImageMaskingTool")
    public ImageMaskingDiv getImageMaskingTool() {
        return ImageMaskingTool;
    }

    @JsonProperty("ImageMaskingTool")
    public void setImageMaskingTool(ImageMaskingDiv ImageMaskingTool) {
        this.ImageMaskingTool=ImageMaskingTool;
    }

    @JsonProperty("btnImageToroku")
    public Button getBtnImageToroku() {
        return btnImageToroku;
    }

    @JsonProperty("btnImageToroku")
    public void setBtnImageToroku(Button btnImageToroku) {
        this.btnImageToroku=btnImageToroku;
    }

    @JsonProperty("btnBackIchiran")
    public Button getBtnBackIchiran() {
        return btnBackIchiran;
    }

    @JsonProperty("btnBackIchiran")
    public void setBtnBackIchiran(Button btnBackIchiran) {
        this.btnBackIchiran=btnBackIchiran;
    }

}
