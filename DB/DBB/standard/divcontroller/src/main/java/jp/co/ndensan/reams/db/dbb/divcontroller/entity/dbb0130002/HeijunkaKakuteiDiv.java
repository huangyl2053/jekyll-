package jp.co.ndensan.reams.db.dbb.divcontroller.entity.dbb0130002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dbb0130002.HeijunkaKakuteiShoriNaiyoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dbb0130002.HeijunkaSagakuKakuninDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HeijunkaKakutei のクラスファイル 
 * 
 * @author 自動生成
 */
public class HeijunkaKakuteiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblHeijunkaMsg1")
    private Label lblHeijunkaMsg1;
    @JsonProperty("HeijunkaKakuteiShoriNaiyo")
    private HeijunkaKakuteiShoriNaiyoDiv HeijunkaKakuteiShoriNaiyo;
    @JsonProperty("HeijunkaSagakuKakunin")
    private HeijunkaSagakuKakuninDiv HeijunkaSagakuKakunin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblHeijunkaMsg1")
    public Label getLblHeijunkaMsg1() {
        return lblHeijunkaMsg1;
    }

    @JsonProperty("lblHeijunkaMsg1")
    public void setLblHeijunkaMsg1(Label lblHeijunkaMsg1) {
        this.lblHeijunkaMsg1=lblHeijunkaMsg1;
    }

    @JsonProperty("HeijunkaKakuteiShoriNaiyo")
    public HeijunkaKakuteiShoriNaiyoDiv getHeijunkaKakuteiShoriNaiyo() {
        return HeijunkaKakuteiShoriNaiyo;
    }

    @JsonProperty("HeijunkaKakuteiShoriNaiyo")
    public void setHeijunkaKakuteiShoriNaiyo(HeijunkaKakuteiShoriNaiyoDiv HeijunkaKakuteiShoriNaiyo) {
        this.HeijunkaKakuteiShoriNaiyo=HeijunkaKakuteiShoriNaiyo;
    }

    @JsonProperty("HeijunkaSagakuKakunin")
    public HeijunkaSagakuKakuninDiv getHeijunkaSagakuKakunin() {
        return HeijunkaSagakuKakunin;
    }

    @JsonProperty("HeijunkaSagakuKakunin")
    public void setHeijunkaSagakuKakunin(HeijunkaSagakuKakuninDiv HeijunkaSagakuKakunin) {
        this.HeijunkaSagakuKakunin=HeijunkaSagakuKakunin;
    }

}
