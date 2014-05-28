package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030003;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030003.PublishingShinsakaiResultsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030003.dgShinsakaiTargetPersons_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HanteiResultsOutputTargetPersons のクラスファイル 
 * 
 * @author 自動生成
 */
public class HanteiResultsOutputTargetPersonsDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgShinsakaiTargetPersons")
    private DataGrid<dgShinsakaiTargetPersons_Row> dgShinsakaiTargetPersons;
    @JsonProperty("PublishingShinsakaiResults")
    private PublishingShinsakaiResultsDiv PublishingShinsakaiResults;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgShinsakaiTargetPersons")
    public DataGrid<dgShinsakaiTargetPersons_Row> getDgShinsakaiTargetPersons() {
        return dgShinsakaiTargetPersons;
    }

    @JsonProperty("dgShinsakaiTargetPersons")
    public void setDgShinsakaiTargetPersons(DataGrid<dgShinsakaiTargetPersons_Row> dgShinsakaiTargetPersons) {
        this.dgShinsakaiTargetPersons=dgShinsakaiTargetPersons;
    }

    @JsonProperty("PublishingShinsakaiResults")
    public PublishingShinsakaiResultsDiv getPublishingShinsakaiResults() {
        return PublishingShinsakaiResults;
    }

    @JsonProperty("PublishingShinsakaiResults")
    public void setPublishingShinsakaiResults(PublishingShinsakaiResultsDiv PublishingShinsakaiResults) {
        this.PublishingShinsakaiResults=PublishingShinsakaiResults;
    }

}
