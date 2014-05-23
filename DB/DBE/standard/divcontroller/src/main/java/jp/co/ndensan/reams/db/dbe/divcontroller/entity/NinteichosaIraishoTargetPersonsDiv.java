package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.SerachButtonsForNinteichosaIraishoTargetPersonsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.SerachCriteriaForNinteichosaIraishoTargetPersonsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgNinteichosaIraishoTargetPersons_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteichosaIraishoTargetPersons のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraishoTargetPersonsDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SerachCriteriaForNinteichosaIraishoTargetPersons")
    private SerachCriteriaForNinteichosaIraishoTargetPersonsDiv SerachCriteriaForNinteichosaIraishoTargetPersons;
    @JsonProperty("SerachButtonsForNinteichosaIraishoTargetPersons")
    private SerachButtonsForNinteichosaIraishoTargetPersonsDiv SerachButtonsForNinteichosaIraishoTargetPersons;
    @JsonProperty("dgNinteichosaIraishoTargetPersons")
    private DataGrid<dgNinteichosaIraishoTargetPersons_Row> dgNinteichosaIraishoTargetPersons;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SerachCriteriaForNinteichosaIraishoTargetPersons")
    public SerachCriteriaForNinteichosaIraishoTargetPersonsDiv getSerachCriteriaForNinteichosaIraishoTargetPersons() {
        return SerachCriteriaForNinteichosaIraishoTargetPersons;
    }

    @JsonProperty("SerachCriteriaForNinteichosaIraishoTargetPersons")
    public void setSerachCriteriaForNinteichosaIraishoTargetPersons(SerachCriteriaForNinteichosaIraishoTargetPersonsDiv SerachCriteriaForNinteichosaIraishoTargetPersons) {
        this.SerachCriteriaForNinteichosaIraishoTargetPersons=SerachCriteriaForNinteichosaIraishoTargetPersons;
    }

    @JsonProperty("SerachButtonsForNinteichosaIraishoTargetPersons")
    public SerachButtonsForNinteichosaIraishoTargetPersonsDiv getSerachButtonsForNinteichosaIraishoTargetPersons() {
        return SerachButtonsForNinteichosaIraishoTargetPersons;
    }

    @JsonProperty("SerachButtonsForNinteichosaIraishoTargetPersons")
    public void setSerachButtonsForNinteichosaIraishoTargetPersons(SerachButtonsForNinteichosaIraishoTargetPersonsDiv SerachButtonsForNinteichosaIraishoTargetPersons) {
        this.SerachButtonsForNinteichosaIraishoTargetPersons=SerachButtonsForNinteichosaIraishoTargetPersons;
    }

    @JsonProperty("dgNinteichosaIraishoTargetPersons")
    public DataGrid<dgNinteichosaIraishoTargetPersons_Row> getDgNinteichosaIraishoTargetPersons() {
        return dgNinteichosaIraishoTargetPersons;
    }

    @JsonProperty("dgNinteichosaIraishoTargetPersons")
    public void setDgNinteichosaIraishoTargetPersons(DataGrid<dgNinteichosaIraishoTargetPersons_Row> dgNinteichosaIraishoTargetPersons) {
        this.dgNinteichosaIraishoTargetPersons=dgNinteichosaIraishoTargetPersons;
    }

}
