package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dgJushochiTokureiRireki_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TekiyoInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class TekiyoInfoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgJushochiTokureiRireki")
    private DataGrid<dgJushochiTokureiRireki_Row> dgJushochiTokureiRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgJushochiTokureiRireki")
    public DataGrid<dgJushochiTokureiRireki_Row> getDgJushochiTokureiRireki() {
        return dgJushochiTokureiRireki;
    }

    @JsonProperty("dgJushochiTokureiRireki")
    public void setDgJushochiTokureiRireki(DataGrid<dgJushochiTokureiRireki_Row> dgJushochiTokureiRireki) {
        this.dgJushochiTokureiRireki=dgJushochiTokureiRireki;
    }

}
