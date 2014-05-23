package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.tblShisetsuNyutaishoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplShisetsuNyutaisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplShisetsuNyutaishoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblKaigoHokensha")
    private Label lblKaigoHokensha;
    @JsonProperty("tblShisetsuNyutaisho")
    private tblShisetsuNyutaishoDiv tblShisetsuNyutaisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblKaigoHokensha")
    public Label getLblKaigoHokensha() {
        return lblKaigoHokensha;
    }

    @JsonProperty("lblKaigoHokensha")
    public void setLblKaigoHokensha(Label lblKaigoHokensha) {
        this.lblKaigoHokensha=lblKaigoHokensha;
    }

    @JsonProperty("tblShisetsuNyutaisho")
    public tblShisetsuNyutaishoDiv getTblShisetsuNyutaisho() {
        return tblShisetsuNyutaisho;
    }

    @JsonProperty("tblShisetsuNyutaisho")
    public void setTblShisetsuNyutaisho(tblShisetsuNyutaishoDiv tblShisetsuNyutaisho) {
        this.tblShisetsuNyutaisho=tblShisetsuNyutaisho;
    }

}
