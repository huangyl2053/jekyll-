package jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000.SogoShokaiKagoMoshitateHokenshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000.SogoShokaiKagoMoshitateKohiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SogoShokaiKagoMoshitateKekka のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiKagoMoshitateKekkaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SogoShokaiKagoMoshitateHokensha")
    private SogoShokaiKagoMoshitateHokenshaDiv SogoShokaiKagoMoshitateHokensha;
    @JsonProperty("SogoShokaiKagoMoshitateKohi")
    private SogoShokaiKagoMoshitateKohiDiv SogoShokaiKagoMoshitateKohi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SogoShokaiKagoMoshitateHokensha")
    public SogoShokaiKagoMoshitateHokenshaDiv getSogoShokaiKagoMoshitateHokensha() {
        return SogoShokaiKagoMoshitateHokensha;
    }

    @JsonProperty("SogoShokaiKagoMoshitateHokensha")
    public void setSogoShokaiKagoMoshitateHokensha(SogoShokaiKagoMoshitateHokenshaDiv SogoShokaiKagoMoshitateHokensha) {
        this.SogoShokaiKagoMoshitateHokensha=SogoShokaiKagoMoshitateHokensha;
    }

    @JsonProperty("SogoShokaiKagoMoshitateKohi")
    public SogoShokaiKagoMoshitateKohiDiv getSogoShokaiKagoMoshitateKohi() {
        return SogoShokaiKagoMoshitateKohi;
    }

    @JsonProperty("SogoShokaiKagoMoshitateKohi")
    public void setSogoShokaiKagoMoshitateKohi(SogoShokaiKagoMoshitateKohiDiv SogoShokaiKagoMoshitateKohi) {
        this.SogoShokaiKagoMoshitateKohi=SogoShokaiKagoMoshitateKohi;
    }

}
