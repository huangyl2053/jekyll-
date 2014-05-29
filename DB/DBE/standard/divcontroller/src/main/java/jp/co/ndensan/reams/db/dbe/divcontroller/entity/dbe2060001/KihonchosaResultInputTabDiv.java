package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.IchjiHanteiFromInputedChosaResultDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.Kihonchosa09Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.KihonchosaResultGuidanceDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * KihonchosaResultInputTab のクラスファイル 
 * 
 * @author 自動生成
 */
public class KihonchosaResultInputTabDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KihonchosaResultGuidance")
    private KihonchosaResultGuidanceDiv KihonchosaResultGuidance;
    @JsonProperty("IchjiHanteiFromInputedChosaResult")
    private IchjiHanteiFromInputedChosaResultDiv IchjiHanteiFromInputedChosaResult;
    @JsonProperty("Kihonchosa09")
    private Kihonchosa09Div Kihonchosa09;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KihonchosaResultGuidance")
    public KihonchosaResultGuidanceDiv getKihonchosaResultGuidance() {
        return KihonchosaResultGuidance;
    }

    @JsonProperty("KihonchosaResultGuidance")
    public void setKihonchosaResultGuidance(KihonchosaResultGuidanceDiv KihonchosaResultGuidance) {
        this.KihonchosaResultGuidance=KihonchosaResultGuidance;
    }

    @JsonProperty("IchjiHanteiFromInputedChosaResult")
    public IchjiHanteiFromInputedChosaResultDiv getIchjiHanteiFromInputedChosaResult() {
        return IchjiHanteiFromInputedChosaResult;
    }

    @JsonProperty("IchjiHanteiFromInputedChosaResult")
    public void setIchjiHanteiFromInputedChosaResult(IchjiHanteiFromInputedChosaResultDiv IchjiHanteiFromInputedChosaResult) {
        this.IchjiHanteiFromInputedChosaResult=IchjiHanteiFromInputedChosaResult;
    }

    @JsonProperty("Kihonchosa09")
    public Kihonchosa09Div getKihonchosa09() {
        return Kihonchosa09;
    }

    @JsonProperty("Kihonchosa09")
    public void setKihonchosa09(Kihonchosa09Div Kihonchosa09) {
        this.Kihonchosa09=Kihonchosa09;
    }

}
