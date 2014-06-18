package jp.co.ndensan.reams.db.dbb.divcontroller.entity.dbb0130001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dbb0130001.Heijunka8KeisanHohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dbb0130001.Heijunka8ShoriKakuninDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dbb0130001.Heijunka8ShoriNaiyoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HeijunkaAugustKeisan のクラスファイル 
 * 
 * @author 自動生成
 */
public class HeijunkaAugustKeisanDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Heijunka8ShoriNaiyo")
    private Heijunka8ShoriNaiyoDiv Heijunka8ShoriNaiyo;
    @JsonProperty("Heijunka8ShoriKakunin")
    private Heijunka8ShoriKakuninDiv Heijunka8ShoriKakunin;
    @JsonProperty("Heijunka8KeisanHoho")
    private Heijunka8KeisanHohoDiv Heijunka8KeisanHoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("Heijunka8ShoriNaiyo")
    public Heijunka8ShoriNaiyoDiv getHeijunka8ShoriNaiyo() {
        return Heijunka8ShoriNaiyo;
    }

    @JsonProperty("Heijunka8ShoriNaiyo")
    public void setHeijunka8ShoriNaiyo(Heijunka8ShoriNaiyoDiv Heijunka8ShoriNaiyo) {
        this.Heijunka8ShoriNaiyo=Heijunka8ShoriNaiyo;
    }

    @JsonProperty("Heijunka8ShoriKakunin")
    public Heijunka8ShoriKakuninDiv getHeijunka8ShoriKakunin() {
        return Heijunka8ShoriKakunin;
    }

    @JsonProperty("Heijunka8ShoriKakunin")
    public void setHeijunka8ShoriKakunin(Heijunka8ShoriKakuninDiv Heijunka8ShoriKakunin) {
        this.Heijunka8ShoriKakunin=Heijunka8ShoriKakunin;
    }

    @JsonProperty("Heijunka8KeisanHoho")
    public Heijunka8KeisanHohoDiv getHeijunka8KeisanHoho() {
        return Heijunka8KeisanHoho;
    }

    @JsonProperty("Heijunka8KeisanHoho")
    public void setHeijunka8KeisanHoho(Heijunka8KeisanHohoDiv Heijunka8KeisanHoho) {
        this.Heijunka8KeisanHoho=Heijunka8KeisanHoho;
    }

}
