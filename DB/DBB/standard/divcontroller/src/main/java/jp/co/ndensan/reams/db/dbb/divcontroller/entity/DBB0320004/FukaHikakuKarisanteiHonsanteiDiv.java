package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.HonSantei1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.KariSantei1Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FukaHikakuKarisanteiHonsantei のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaHikakuKarisanteiHonsanteiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KariSantei1")
    private KariSantei1Div KariSantei1;
    @JsonProperty("HonSantei1")
    private HonSantei1Div HonSantei1;

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

    @JsonProperty("HonSantei1")
    public HonSantei1Div getHonSantei1() {
        return HonSantei1;
    }

    @JsonProperty("HonSantei1")
    public void setHonSantei1(HonSantei1Div HonSantei1) {
        this.HonSantei1=HonSantei1;
    }

}
