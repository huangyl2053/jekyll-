package jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011.dgHihokenshashoHakkoTaishoGaitosha_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HihokenshashoHakkoTaishoGaitosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshashoHakkoTaishoGaitoshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgHihokenshashoHakkoTaishoGaitosha")
    private DataGrid<dgHihokenshashoHakkoTaishoGaitosha_Row> dgHihokenshashoHakkoTaishoGaitosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgHihokenshashoHakkoTaishoGaitosha")
    public DataGrid<dgHihokenshashoHakkoTaishoGaitosha_Row> getDgHihokenshashoHakkoTaishoGaitosha() {
        return dgHihokenshashoHakkoTaishoGaitosha;
    }

    @JsonProperty("dgHihokenshashoHakkoTaishoGaitosha")
    public void setDgHihokenshashoHakkoTaishoGaitosha(DataGrid<dgHihokenshashoHakkoTaishoGaitosha_Row> dgHihokenshashoHakkoTaishoGaitosha) {
        this.dgHihokenshashoHakkoTaishoGaitosha=dgHihokenshashoHakkoTaishoGaitosha;
    }

}
