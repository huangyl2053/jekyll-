package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8010001.DateRangesDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8010001.IchijiHanteiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8010001.NinteichosaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8010001.ShinsakaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8010001.ShujiiIkenshoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * StateOfProgress のクラスファイル 
 * 
 * @author 自動生成
 */
public class StateOfProgressDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("DateRanges")
    private DateRangesDiv DateRanges;
    @JsonProperty("Ninteichosa")
    private NinteichosaDiv Ninteichosa;
    @JsonProperty("ShujiiIkensho")
    private ShujiiIkenshoDiv ShujiiIkensho;
    @JsonProperty("IchijiHantei")
    private IchijiHanteiDiv IchijiHantei;
    @JsonProperty("Shinsakai")
    private ShinsakaiDiv Shinsakai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("DateRanges")
    public DateRangesDiv getDateRanges() {
        return DateRanges;
    }

    @JsonProperty("DateRanges")
    public void setDateRanges(DateRangesDiv DateRanges) {
        this.DateRanges=DateRanges;
    }

    @JsonProperty("Ninteichosa")
    public NinteichosaDiv getNinteichosa() {
        return Ninteichosa;
    }

    @JsonProperty("Ninteichosa")
    public void setNinteichosa(NinteichosaDiv Ninteichosa) {
        this.Ninteichosa=Ninteichosa;
    }

    @JsonProperty("ShujiiIkensho")
    public ShujiiIkenshoDiv getShujiiIkensho() {
        return ShujiiIkensho;
    }

    @JsonProperty("ShujiiIkensho")
    public void setShujiiIkensho(ShujiiIkenshoDiv ShujiiIkensho) {
        this.ShujiiIkensho=ShujiiIkensho;
    }

    @JsonProperty("IchijiHantei")
    public IchijiHanteiDiv getIchijiHantei() {
        return IchijiHantei;
    }

    @JsonProperty("IchijiHantei")
    public void setIchijiHantei(IchijiHanteiDiv IchijiHantei) {
        this.IchijiHantei=IchijiHantei;
    }

    @JsonProperty("Shinsakai")
    public ShinsakaiDiv getShinsakai() {
        return Shinsakai;
    }

    @JsonProperty("Shinsakai")
    public void setShinsakai(ShinsakaiDiv Shinsakai) {
        this.Shinsakai=Shinsakai;
    }

}
