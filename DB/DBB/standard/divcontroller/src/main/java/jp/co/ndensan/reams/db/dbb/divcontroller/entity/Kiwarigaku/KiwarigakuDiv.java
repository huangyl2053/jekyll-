package jp.co.ndensan.reams.db.dbb.divcontroller.entity.Kiwarigaku;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.Kiwarigaku.tblKiwariGakuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Kiwarigaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KiwarigakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblKiwariGaku")
    private tblKiwariGakuDiv tblKiwariGaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblKiwariGaku")
    public tblKiwariGakuDiv getTblKiwariGaku() {
        return tblKiwariGaku;
    }

    @JsonProperty("tblKiwariGaku")
    public void setTblKiwariGaku(tblKiwariGakuDiv tblKiwariGaku) {
        this.tblKiwariGaku=tblKiwariGaku;
    }

}
