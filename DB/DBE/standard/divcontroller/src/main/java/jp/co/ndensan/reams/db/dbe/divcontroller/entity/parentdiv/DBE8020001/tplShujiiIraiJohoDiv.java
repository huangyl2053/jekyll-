package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE8020001.KonkaiShujiiIraiJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE8020001.ZenkaiShujiiIraiJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplShujiiIraiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplShujiiIraiJohoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KonkaiShujiiIraiJoho")
    private KonkaiShujiiIraiJohoDiv KonkaiShujiiIraiJoho;
    @JsonProperty("ZenkaiShujiiIraiJoho")
    private ZenkaiShujiiIraiJohoDiv ZenkaiShujiiIraiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KonkaiShujiiIraiJoho")
    public KonkaiShujiiIraiJohoDiv getKonkaiShujiiIraiJoho() {
        return KonkaiShujiiIraiJoho;
    }

    @JsonProperty("KonkaiShujiiIraiJoho")
    public void setKonkaiShujiiIraiJoho(KonkaiShujiiIraiJohoDiv KonkaiShujiiIraiJoho) {
        this.KonkaiShujiiIraiJoho=KonkaiShujiiIraiJoho;
    }

    @JsonProperty("ZenkaiShujiiIraiJoho")
    public ZenkaiShujiiIraiJohoDiv getZenkaiShujiiIraiJoho() {
        return ZenkaiShujiiIraiJoho;
    }

    @JsonProperty("ZenkaiShujiiIraiJoho")
    public void setZenkaiShujiiIraiJoho(ZenkaiShujiiIraiJohoDiv ZenkaiShujiiIraiJoho) {
        this.ZenkaiShujiiIraiJoho=ZenkaiShujiiIraiJoho;
    }

}
