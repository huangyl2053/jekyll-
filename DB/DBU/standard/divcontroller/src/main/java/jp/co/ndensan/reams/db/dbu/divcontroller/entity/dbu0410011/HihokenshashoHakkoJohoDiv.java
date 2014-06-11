package jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.HihokenshaShikakuHakkoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HihokenshashoHakkoJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshashoHakkoJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HihokenshashoHakkoShosaiJoho")
    private HihokenshaShikakuHakkoDiv HihokenshashoHakkoShosaiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("HihokenshashoHakkoShosaiJoho")
    public HihokenshaShikakuHakkoDiv getHihokenshashoHakkoShosaiJoho() {
        return HihokenshashoHakkoShosaiJoho;
    }

    @JsonProperty("HihokenshashoHakkoShosaiJoho")
    public void setHihokenshashoHakkoShosaiJoho(HihokenshaShikakuHakkoDiv HihokenshashoHakkoShosaiJoho) {
        this.HihokenshashoHakkoShosaiJoho=HihokenshashoHakkoShosaiJoho;
    }

}
