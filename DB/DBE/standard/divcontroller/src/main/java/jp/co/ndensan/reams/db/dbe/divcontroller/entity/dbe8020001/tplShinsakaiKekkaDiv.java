package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.KonkaiShinsaKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.NinteiTsuchiJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.ZenkaiShinsaKekkaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplShinsakaiKekka のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplShinsakaiKekkaDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KonkaiShinsaKekka")
    private KonkaiShinsaKekkaDiv KonkaiShinsaKekka;
    @JsonProperty("NinteiTsuchiJoho")
    private NinteiTsuchiJohoDiv NinteiTsuchiJoho;
    @JsonProperty("ZenkaiShinsaKekka")
    private ZenkaiShinsaKekkaDiv ZenkaiShinsaKekka;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KonkaiShinsaKekka")
    public KonkaiShinsaKekkaDiv getKonkaiShinsaKekka() {
        return KonkaiShinsaKekka;
    }

    @JsonProperty("KonkaiShinsaKekka")
    public void setKonkaiShinsaKekka(KonkaiShinsaKekkaDiv KonkaiShinsaKekka) {
        this.KonkaiShinsaKekka=KonkaiShinsaKekka;
    }

    @JsonProperty("NinteiTsuchiJoho")
    public NinteiTsuchiJohoDiv getNinteiTsuchiJoho() {
        return NinteiTsuchiJoho;
    }

    @JsonProperty("NinteiTsuchiJoho")
    public void setNinteiTsuchiJoho(NinteiTsuchiJohoDiv NinteiTsuchiJoho) {
        this.NinteiTsuchiJoho=NinteiTsuchiJoho;
    }

    @JsonProperty("ZenkaiShinsaKekka")
    public ZenkaiShinsaKekkaDiv getZenkaiShinsaKekka() {
        return ZenkaiShinsaKekka;
    }

    @JsonProperty("ZenkaiShinsaKekka")
    public void setZenkaiShinsaKekka(ZenkaiShinsaKekkaDiv ZenkaiShinsaKekka) {
        this.ZenkaiShinsaKekka=ZenkaiShinsaKekka;
    }

}
