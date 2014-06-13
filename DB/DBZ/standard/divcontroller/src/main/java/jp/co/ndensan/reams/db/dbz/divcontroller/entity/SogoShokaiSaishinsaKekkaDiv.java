package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SogoShokaiSaishinsaHokenshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SogoShokaiSaishinsaKohiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SogoShokaiSaishinsaKekka のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiSaishinsaKekkaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SogoShokaiSaishinsaHokensha")
    private SogoShokaiSaishinsaHokenshaDiv SogoShokaiSaishinsaHokensha;
    @JsonProperty("SogoShokaiSaishinsaKohi")
    private SogoShokaiSaishinsaKohiDiv SogoShokaiSaishinsaKohi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SogoShokaiSaishinsaHokensha")
    public SogoShokaiSaishinsaHokenshaDiv getSogoShokaiSaishinsaHokensha() {
        return SogoShokaiSaishinsaHokensha;
    }

    @JsonProperty("SogoShokaiSaishinsaHokensha")
    public void setSogoShokaiSaishinsaHokensha(SogoShokaiSaishinsaHokenshaDiv SogoShokaiSaishinsaHokensha) {
        this.SogoShokaiSaishinsaHokensha=SogoShokaiSaishinsaHokensha;
    }

    @JsonProperty("SogoShokaiSaishinsaKohi")
    public SogoShokaiSaishinsaKohiDiv getSogoShokaiSaishinsaKohi() {
        return SogoShokaiSaishinsaKohi;
    }

    @JsonProperty("SogoShokaiSaishinsaKohi")
    public void setSogoShokaiSaishinsaKohi(SogoShokaiSaishinsaKohiDiv SogoShokaiSaishinsaKohi) {
        this.SogoShokaiSaishinsaKohi=SogoShokaiSaishinsaKohi;
    }

}
