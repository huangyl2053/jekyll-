package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kiwarigaku.KiwarigakuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FukaHikakuKibetsuGaku1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaHikakuKibetsuGaku1Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblFukaHikakuKibetsuGaku1")
    private KiwarigakuDiv tblFukaHikakuKibetsuGaku1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblFukaHikakuKibetsuGaku1")
    public KiwarigakuDiv getTblFukaHikakuKibetsuGaku1() {
        return tblFukaHikakuKibetsuGaku1;
    }

    @JsonProperty("tblFukaHikakuKibetsuGaku1")
    public void setTblFukaHikakuKibetsuGaku1(KiwarigakuDiv tblFukaHikakuKibetsuGaku1) {
        this.tblFukaHikakuKibetsuGaku1=tblFukaHikakuKibetsuGaku1;
    }

}
