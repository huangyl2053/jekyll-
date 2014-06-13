package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.ButtonsForNinteichosaResultEntryTargetDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001.dgNinteichosaResultTaishosha_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteichosaResultEntryTarget のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaResultEntryTargetDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgNinteichosaResultTaishosha")
    private DataGrid<dgNinteichosaResultTaishosha_Row> dgNinteichosaResultTaishosha;
    @JsonProperty("ButtonsForNinteichosaResultEntryTarget")
    private ButtonsForNinteichosaResultEntryTargetDiv ButtonsForNinteichosaResultEntryTarget;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgNinteichosaResultTaishosha")
    public DataGrid<dgNinteichosaResultTaishosha_Row> getDgNinteichosaResultTaishosha() {
        return dgNinteichosaResultTaishosha;
    }

    @JsonProperty("dgNinteichosaResultTaishosha")
    public void setDgNinteichosaResultTaishosha(DataGrid<dgNinteichosaResultTaishosha_Row> dgNinteichosaResultTaishosha) {
        this.dgNinteichosaResultTaishosha=dgNinteichosaResultTaishosha;
    }

    @JsonProperty("ButtonsForNinteichosaResultEntryTarget")
    public ButtonsForNinteichosaResultEntryTargetDiv getButtonsForNinteichosaResultEntryTarget() {
        return ButtonsForNinteichosaResultEntryTarget;
    }

    @JsonProperty("ButtonsForNinteichosaResultEntryTarget")
    public void setButtonsForNinteichosaResultEntryTarget(ButtonsForNinteichosaResultEntryTargetDiv ButtonsForNinteichosaResultEntryTarget) {
        this.ButtonsForNinteichosaResultEntryTarget=ButtonsForNinteichosaResultEntryTarget;
    }

}
