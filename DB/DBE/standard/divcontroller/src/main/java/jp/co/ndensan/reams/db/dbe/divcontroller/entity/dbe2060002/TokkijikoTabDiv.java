package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.tokkijikoCom.TokkijikoCom;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.ControlRepeater;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TokkijikoTab のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokkijikoTabDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAddTokkijiko")
    private Button btnAddTokkijiko;
    @JsonProperty("repTokkijikoCom")
    private ControlRepeater<TokkijikoCom> repTokkijikoCom;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnAddTokkijiko")
    public Button getBtnAddTokkijiko() {
        return btnAddTokkijiko;
    }

    @JsonProperty("btnAddTokkijiko")
    public void setBtnAddTokkijiko(Button btnAddTokkijiko) {
        this.btnAddTokkijiko=btnAddTokkijiko;
    }

    @JsonProperty("repTokkijikoCom")
    public ControlRepeater<TokkijikoCom> getRepTokkijikoCom() {
        return repTokkijikoCom;
    }

    @JsonProperty("repTokkijikoCom")
    public void setRepTokkijikoCom(ControlRepeater<TokkijikoCom> repTokkijikoCom) {
        this.repTokkijikoCom=repTokkijikoCom;
    }

}
