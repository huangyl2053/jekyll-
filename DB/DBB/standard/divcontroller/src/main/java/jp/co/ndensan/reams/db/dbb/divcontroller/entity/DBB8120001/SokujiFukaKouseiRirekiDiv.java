package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001.dgSokujiFukaKouseiRireki_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SokujiFukaKouseiRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class SokujiFukaKouseiRirekiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSokujiFukaKouseiRireki")
    private DataGrid<dgSokujiFukaKouseiRireki_Row> dgSokujiFukaKouseiRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgSokujiFukaKouseiRireki")
    public DataGrid<dgSokujiFukaKouseiRireki_Row> getDgSokujiFukaKouseiRireki() {
        return dgSokujiFukaKouseiRireki;
    }

    @JsonProperty("dgSokujiFukaKouseiRireki")
    public void setDgSokujiFukaKouseiRireki(DataGrid<dgSokujiFukaKouseiRireki_Row> dgSokujiFukaKouseiRireki) {
        this.dgSokujiFukaKouseiRireki=dgSokujiFukaKouseiRireki;
    }

}
