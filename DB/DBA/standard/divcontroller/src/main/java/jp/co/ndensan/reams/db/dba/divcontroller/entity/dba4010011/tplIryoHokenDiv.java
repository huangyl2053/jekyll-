package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.iryohokenrireki.IryoHokenRirekiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplIryoHoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplIryoHokenDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("IryoHokenRireki")
    private IryoHokenRirekiDiv IryoHokenRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("IryoHokenRireki")
    public IryoHokenRirekiDiv getIryoHokenRireki() {
        return IryoHokenRireki;
    }

    @JsonProperty("IryoHokenRireki")
    public void setIryoHokenRireki(IryoHokenRirekiDiv IryoHokenRireki) {
        this.IryoHokenRireki=IryoHokenRireki;
    }

}
