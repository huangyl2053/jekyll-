package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001.IryohokenshaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * N2Hihokensha のクラスファイル 
 * 
 * @author 自動生成
 */
public class N2HihokenshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Iryohokensha")
    private IryohokenshaDiv Iryohokensha;
    @JsonProperty("lblTokuteiShippei")
    private Label lblTokuteiShippei;
    @JsonProperty("txtTokuteiShippei")
    private TextBox txtTokuteiShippei;
    @JsonProperty("imgToSearchTokuteiShippei")
    private StaticImage imgToSearchTokuteiShippei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("Iryohokensha")
    public IryohokenshaDiv getIryohokensha() {
        return Iryohokensha;
    }

    @JsonProperty("Iryohokensha")
    public void setIryohokensha(IryohokenshaDiv Iryohokensha) {
        this.Iryohokensha=Iryohokensha;
    }

    @JsonProperty("lblTokuteiShippei")
    public Label getLblTokuteiShippei() {
        return lblTokuteiShippei;
    }

    @JsonProperty("lblTokuteiShippei")
    public void setLblTokuteiShippei(Label lblTokuteiShippei) {
        this.lblTokuteiShippei=lblTokuteiShippei;
    }

    @JsonProperty("txtTokuteiShippei")
    public TextBox getTxtTokuteiShippei() {
        return txtTokuteiShippei;
    }

    @JsonProperty("txtTokuteiShippei")
    public void setTxtTokuteiShippei(TextBox txtTokuteiShippei) {
        this.txtTokuteiShippei=txtTokuteiShippei;
    }

    @JsonProperty("imgToSearchTokuteiShippei")
    public StaticImage getImgToSearchTokuteiShippei() {
        return imgToSearchTokuteiShippei;
    }

    @JsonProperty("imgToSearchTokuteiShippei")
    public void setImgToSearchTokuteiShippei(StaticImage imgToSearchTokuteiShippei) {
        this.imgToSearchTokuteiShippei=imgToSearchTokuteiShippei;
    }

}
