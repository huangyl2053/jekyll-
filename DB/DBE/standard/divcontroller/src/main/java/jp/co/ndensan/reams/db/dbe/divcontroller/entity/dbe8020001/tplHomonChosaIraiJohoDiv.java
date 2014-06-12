package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.KonkaiHomonChosaIraiJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.ZenkaiHomonChosaIraiJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplHomonChosaIraiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplHomonChosaIraiJohoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KonkaiHomonChosaIraiJoho")
    private KonkaiHomonChosaIraiJohoDiv KonkaiHomonChosaIraiJoho;
    @JsonProperty("ZenkaiHomonChosaIraiJoho")
    private ZenkaiHomonChosaIraiJohoDiv ZenkaiHomonChosaIraiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KonkaiHomonChosaIraiJoho")
    public KonkaiHomonChosaIraiJohoDiv getKonkaiHomonChosaIraiJoho() {
        return KonkaiHomonChosaIraiJoho;
    }

    @JsonProperty("KonkaiHomonChosaIraiJoho")
    public void setKonkaiHomonChosaIraiJoho(KonkaiHomonChosaIraiJohoDiv KonkaiHomonChosaIraiJoho) {
        this.KonkaiHomonChosaIraiJoho=KonkaiHomonChosaIraiJoho;
    }

    @JsonProperty("ZenkaiHomonChosaIraiJoho")
    public ZenkaiHomonChosaIraiJohoDiv getZenkaiHomonChosaIraiJoho() {
        return ZenkaiHomonChosaIraiJoho;
    }

    @JsonProperty("ZenkaiHomonChosaIraiJoho")
    public void setZenkaiHomonChosaIraiJoho(ZenkaiHomonChosaIraiJohoDiv ZenkaiHomonChosaIraiJoho) {
        this.ZenkaiHomonChosaIraiJoho=ZenkaiHomonChosaIraiJoho;
    }

}
