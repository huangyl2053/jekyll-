package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.HonSantei1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.HonSantei2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.KariSantei1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.KariSantei2Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * FukaJohoHikaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaJohoHikakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KariSantei1")
    private KariSantei1Div KariSantei1;
    @JsonProperty("KariSantei2")
    private KariSantei2Div KariSantei2;
    @JsonProperty("HonSantei1")
    private HonSantei1Div HonSantei1;
    @JsonProperty("HonSantei2")
    private HonSantei2Div HonSantei2;
    @JsonProperty("kariButton")
    private Button kariButton;
    @JsonProperty("kariLoad")
    private Button kariLoad;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KariSantei1")
    public KariSantei1Div getKariSantei1() {
        return KariSantei1;
    }

    @JsonProperty("KariSantei1")
    public void setKariSantei1(KariSantei1Div KariSantei1) {
        this.KariSantei1=KariSantei1;
    }

    @JsonProperty("KariSantei2")
    public KariSantei2Div getKariSantei2() {
        return KariSantei2;
    }

    @JsonProperty("KariSantei2")
    public void setKariSantei2(KariSantei2Div KariSantei2) {
        this.KariSantei2=KariSantei2;
    }

    @JsonProperty("HonSantei1")
    public HonSantei1Div getHonSantei1() {
        return HonSantei1;
    }

    @JsonProperty("HonSantei1")
    public void setHonSantei1(HonSantei1Div HonSantei1) {
        this.HonSantei1=HonSantei1;
    }

    @JsonProperty("HonSantei2")
    public HonSantei2Div getHonSantei2() {
        return HonSantei2;
    }

    @JsonProperty("HonSantei2")
    public void setHonSantei2(HonSantei2Div HonSantei2) {
        this.HonSantei2=HonSantei2;
    }

    @JsonProperty("kariButton")
    public Button getKariButton() {
        return kariButton;
    }

    @JsonProperty("kariButton")
    public void setKariButton(Button kariButton) {
        this.kariButton=kariButton;
    }

    @JsonProperty("kariLoad")
    public Button getKariLoad() {
        return kariLoad;
    }

    @JsonProperty("kariLoad")
    public void setKariLoad(Button kariLoad) {
        this.kariLoad=kariLoad;
    }

}
