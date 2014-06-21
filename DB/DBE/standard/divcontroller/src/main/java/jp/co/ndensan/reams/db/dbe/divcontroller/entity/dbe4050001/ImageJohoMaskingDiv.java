package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4050001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4050001.ImageMaskTaishoShijiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.KaigoHihokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.KaigoHihokenshaJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ImageJohoMasking のクラスファイル 
 * 
 * @author 自動生成
 */
public class ImageJohoMaskingDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShoriTaishoshaKensakuShiji")
    private ShoriTaishoshaKensakuShijiDiv ShoriTaishoshaKensakuShiji;
    @JsonProperty("ShoriTaishoshaIchiran")
    private ShoriTaishoshaIchiranDiv ShoriTaishoshaIchiran;
    @JsonProperty("HihokenshaJoho")
    private KaigoHihokenshaJohoDiv HihokenshaJoho;
    @JsonProperty("ImageMaskTaishoShiji")
    private ImageMaskTaishoShijiDiv ImageMaskTaishoShiji;
    @JsonProperty("KaigoImageMasking")
    private KaigoImageMaskingDiv KaigoImageMasking;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShoriTaishoshaKensakuShiji")
    public ShoriTaishoshaKensakuShijiDiv getShoriTaishoshaKensakuShiji() {
        return ShoriTaishoshaKensakuShiji;
    }

    @JsonProperty("ShoriTaishoshaKensakuShiji")
    public void setShoriTaishoshaKensakuShiji(ShoriTaishoshaKensakuShijiDiv ShoriTaishoshaKensakuShiji) {
        this.ShoriTaishoshaKensakuShiji=ShoriTaishoshaKensakuShiji;
    }

    @JsonProperty("ShoriTaishoshaIchiran")
    public ShoriTaishoshaIchiranDiv getShoriTaishoshaIchiran() {
        return ShoriTaishoshaIchiran;
    }

    @JsonProperty("ShoriTaishoshaIchiran")
    public void setShoriTaishoshaIchiran(ShoriTaishoshaIchiranDiv ShoriTaishoshaIchiran) {
        this.ShoriTaishoshaIchiran=ShoriTaishoshaIchiran;
    }

    @JsonProperty("HihokenshaJoho")
    public KaigoHihokenshaJohoDiv getHihokenshaJoho() {
        return HihokenshaJoho;
    }

    @JsonProperty("HihokenshaJoho")
    public void setHihokenshaJoho(KaigoHihokenshaJohoDiv HihokenshaJoho) {
        this.HihokenshaJoho=HihokenshaJoho;
    }

    @JsonProperty("ImageMaskTaishoShiji")
    public ImageMaskTaishoShijiDiv getImageMaskTaishoShiji() {
        return ImageMaskTaishoShiji;
    }

    @JsonProperty("ImageMaskTaishoShiji")
    public void setImageMaskTaishoShiji(ImageMaskTaishoShijiDiv ImageMaskTaishoShiji) {
        this.ImageMaskTaishoShiji=ImageMaskTaishoShiji;
    }

    @JsonProperty("KaigoImageMasking")
    public KaigoImageMaskingDiv getKaigoImageMasking() {
        return KaigoImageMasking;
    }

    @JsonProperty("KaigoImageMasking")
    public void setKaigoImageMasking(KaigoImageMaskingDiv KaigoImageMasking) {
        this.KaigoImageMasking=KaigoImageMasking;
    }

}
