package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011.dgSeikatsuHogoRireki_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HihokenshaShokaiSeikatsuHogo のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaShokaiSeikatsuHogoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSeikatsuHogoRireki")
    private DataGrid<dgSeikatsuHogoRireki_Row> dgSeikatsuHogoRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgSeikatsuHogoRireki")
    public DataGrid<dgSeikatsuHogoRireki_Row> getDgSeikatsuHogoRireki() {
        return dgSeikatsuHogoRireki;
    }

    @JsonProperty("dgSeikatsuHogoRireki")
    public void setDgSeikatsuHogoRireki(DataGrid<dgSeikatsuHogoRireki_Row> dgSeikatsuHogoRireki) {
        this.dgSeikatsuHogoRireki=dgSeikatsuHogoRireki;
    }

}
