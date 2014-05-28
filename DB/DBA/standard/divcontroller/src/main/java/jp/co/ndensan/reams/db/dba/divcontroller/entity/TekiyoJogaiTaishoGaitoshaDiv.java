package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dgTekiyoJogaiTaishoGaitosha_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TekiyoJogaiTaishoGaitosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class TekiyoJogaiTaishoGaitoshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnSelectGaitosha")
    private Button btnSelectGaitosha;
    @JsonProperty("dgTekiyoJogaiTaishoGaitosha")
    private DataGrid<dgTekiyoJogaiTaishoGaitosha_Row> dgTekiyoJogaiTaishoGaitosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnSelectGaitosha")
    public Button getBtnSelectGaitosha() {
        return btnSelectGaitosha;
    }

    @JsonProperty("btnSelectGaitosha")
    public void setBtnSelectGaitosha(Button btnSelectGaitosha) {
        this.btnSelectGaitosha=btnSelectGaitosha;
    }

    @JsonProperty("dgTekiyoJogaiTaishoGaitosha")
    public DataGrid<dgTekiyoJogaiTaishoGaitosha_Row> getDgTekiyoJogaiTaishoGaitosha() {
        return dgTekiyoJogaiTaishoGaitosha;
    }

    @JsonProperty("dgTekiyoJogaiTaishoGaitosha")
    public void setDgTekiyoJogaiTaishoGaitosha(DataGrid<dgTekiyoJogaiTaishoGaitosha_Row> dgTekiyoJogaiTaishoGaitosha) {
        this.dgTekiyoJogaiTaishoGaitosha=dgTekiyoJogaiTaishoGaitosha;
    }

}
