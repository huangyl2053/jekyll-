package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kiwarigaku.KiwarigakuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FukaHikakuKibetsuGaku3 のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaHikakuKibetsuGaku3Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblFukaHikakuKibetsuGaku3")
    private KiwarigakuDiv tblFukaHikakuKibetsuGaku3;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblFukaHikakuKibetsuGaku3")
    public KiwarigakuDiv getTblFukaHikakuKibetsuGaku3() {
        return tblFukaHikakuKibetsuGaku3;
    }

    @JsonProperty("tblFukaHikakuKibetsuGaku3")
    public void setTblFukaHikakuKibetsuGaku3(KiwarigakuDiv tblFukaHikakuKibetsuGaku3) {
        this.tblFukaHikakuKibetsuGaku3=tblFukaHikakuKibetsuGaku3;
    }

}
