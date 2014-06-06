package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.dgShinsakaiIinJoho_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinsakaiIinJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiIinJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShinsakaiIinJoho")
    private DataGrid<dgShinsakaiIinJoho_Row> dgShinsakaiIinJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgShinsakaiIinJoho")
    public DataGrid<dgShinsakaiIinJoho_Row> getDgShinsakaiIinJoho() {
        return dgShinsakaiIinJoho;
    }

    @JsonProperty("dgShinsakaiIinJoho")
    public void setDgShinsakaiIinJoho(DataGrid<dgShinsakaiIinJoho_Row> dgShinsakaiIinJoho) {
        this.dgShinsakaiIinJoho=dgShinsakaiIinJoho;
    }

}
