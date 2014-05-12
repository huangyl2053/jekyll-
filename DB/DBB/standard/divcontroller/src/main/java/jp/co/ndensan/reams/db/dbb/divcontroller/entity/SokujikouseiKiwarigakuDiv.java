package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dgSokujiKouseiKiwariGaku_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SokujikouseiKiwarigaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class SokujikouseiKiwarigakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSokujiKouseiKiwariGaku")
    private DataGrid<dgSokujiKouseiKiwariGaku_Row> dgSokujiKouseiKiwariGaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgSokujiKouseiKiwariGaku")
    public DataGrid<dgSokujiKouseiKiwariGaku_Row> getDgSokujiKouseiKiwariGaku() {
        return dgSokujiKouseiKiwariGaku;
    }

    @JsonProperty("dgSokujiKouseiKiwariGaku")
    public void setDgSokujiKouseiKiwariGaku(DataGrid<dgSokujiKouseiKiwariGaku_Row> dgSokujiKouseiKiwariGaku) {
        this.dgSokujiKouseiKiwariGaku=dgSokujiKouseiKiwariGaku;
    }

}
