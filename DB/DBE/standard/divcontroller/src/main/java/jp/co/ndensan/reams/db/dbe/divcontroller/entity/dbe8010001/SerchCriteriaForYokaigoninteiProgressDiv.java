package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8010001.HihokenshaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8010001.LatestPersonDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8010001.SearchButtonDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8010001.StateOfProgressDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SerchCriteriaForYokaigoninteiProgress のクラスファイル 
 * 
 * @author 自動生成
 */
public class SerchCriteriaForYokaigoninteiProgressDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShichoson")
    private DropDownList ddlShichoson;
    @JsonProperty("radSearchType")
    private RadioButton radSearchType;
    @JsonProperty("Hihokensha")
    private HihokenshaDiv Hihokensha;
    @JsonProperty("StateOfProgress")
    private StateOfProgressDiv StateOfProgress;
    @JsonProperty("SearchButton")
    private SearchButtonDiv SearchButton;
    @JsonProperty("LatestPerson")
    private LatestPersonDiv LatestPerson;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlShichoson")
    public DropDownList getDdlShichoson() {
        return ddlShichoson;
    }

    @JsonProperty("ddlShichoson")
    public void setDdlShichoson(DropDownList ddlShichoson) {
        this.ddlShichoson=ddlShichoson;
    }

    @JsonProperty("radSearchType")
    public RadioButton getRadSearchType() {
        return radSearchType;
    }

    @JsonProperty("radSearchType")
    public void setRadSearchType(RadioButton radSearchType) {
        this.radSearchType=radSearchType;
    }

    @JsonProperty("Hihokensha")
    public HihokenshaDiv getHihokensha() {
        return Hihokensha;
    }

    @JsonProperty("Hihokensha")
    public void setHihokensha(HihokenshaDiv Hihokensha) {
        this.Hihokensha=Hihokensha;
    }

    @JsonProperty("StateOfProgress")
    public StateOfProgressDiv getStateOfProgress() {
        return StateOfProgress;
    }

    @JsonProperty("StateOfProgress")
    public void setStateOfProgress(StateOfProgressDiv StateOfProgress) {
        this.StateOfProgress=StateOfProgress;
    }

    @JsonProperty("SearchButton")
    public SearchButtonDiv getSearchButton() {
        return SearchButton;
    }

    @JsonProperty("SearchButton")
    public void setSearchButton(SearchButtonDiv SearchButton) {
        this.SearchButton=SearchButton;
    }

    @JsonProperty("LatestPerson")
    public LatestPersonDiv getLatestPerson() {
        return LatestPerson;
    }

    @JsonProperty("LatestPerson")
    public void setLatestPerson(LatestPersonDiv LatestPerson) {
        this.LatestPerson=LatestPerson;
    }

}
