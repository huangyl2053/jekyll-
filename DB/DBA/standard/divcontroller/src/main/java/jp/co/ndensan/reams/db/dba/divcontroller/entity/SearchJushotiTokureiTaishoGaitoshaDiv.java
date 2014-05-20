package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dgJushochiTokureiTaishoGaitosha_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SearchJushotiTokureiTaishoGaitosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchJushotiTokureiTaishoGaitoshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnSelectJushochiTokureiTaishosha")
    private Button btnSelectJushochiTokureiTaishosha;
    @JsonProperty("dgJushochiTokureiTaishoGaitosha")
    private DataGrid<dgJushochiTokureiTaishoGaitosha_Row> dgJushochiTokureiTaishoGaitosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnSelectJushochiTokureiTaishosha")
    public Button getBtnSelectJushochiTokureiTaishosha() {
        return btnSelectJushochiTokureiTaishosha;
    }

    @JsonProperty("btnSelectJushochiTokureiTaishosha")
    public void setBtnSelectJushochiTokureiTaishosha(Button btnSelectJushochiTokureiTaishosha) {
        this.btnSelectJushochiTokureiTaishosha=btnSelectJushochiTokureiTaishosha;
    }

    @JsonProperty("dgJushochiTokureiTaishoGaitosha")
    public DataGrid<dgJushochiTokureiTaishoGaitosha_Row> getDgJushochiTokureiTaishoGaitosha() {
        return dgJushochiTokureiTaishoGaitosha;
    }

    @JsonProperty("dgJushochiTokureiTaishoGaitosha")
    public void setDgJushochiTokureiTaishoGaitosha(DataGrid<dgJushochiTokureiTaishoGaitosha_Row> dgJushochiTokureiTaishoGaitosha) {
        this.dgJushochiTokureiTaishoGaitosha=dgJushochiTokureiTaishoGaitosha;
    }

}
