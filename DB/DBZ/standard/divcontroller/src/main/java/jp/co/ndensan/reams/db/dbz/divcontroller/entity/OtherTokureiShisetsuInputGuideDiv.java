package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SearchResultOtherShisetsuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * OtherTokureiShisetsuInputGuide のクラスファイル 
 * 
 * @author 自動生成
 */
public class OtherTokureiShisetsuInputGuideDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radkannaiKubun")
    private RadioButton radkannaiKubun;
    @JsonProperty("btnSearchOtherShisetsu")
    private Button btnSearchOtherShisetsu;
    @JsonProperty("SearchResultOtherShisetsu")
    private SearchResultOtherShisetsuDiv SearchResultOtherShisetsu;
    @JsonProperty("btnOtherShisetsuReturn")
    private Button btnOtherShisetsuReturn;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radkannaiKubun")
    public RadioButton getRadkannaiKubun() {
        return radkannaiKubun;
    }

    @JsonProperty("radkannaiKubun")
    public void setRadkannaiKubun(RadioButton radkannaiKubun) {
        this.radkannaiKubun=radkannaiKubun;
    }

    @JsonProperty("btnSearchOtherShisetsu")
    public Button getBtnSearchOtherShisetsu() {
        return btnSearchOtherShisetsu;
    }

    @JsonProperty("btnSearchOtherShisetsu")
    public void setBtnSearchOtherShisetsu(Button btnSearchOtherShisetsu) {
        this.btnSearchOtherShisetsu=btnSearchOtherShisetsu;
    }

    @JsonProperty("SearchResultOtherShisetsu")
    public SearchResultOtherShisetsuDiv getSearchResultOtherShisetsu() {
        return SearchResultOtherShisetsu;
    }

    @JsonProperty("SearchResultOtherShisetsu")
    public void setSearchResultOtherShisetsu(SearchResultOtherShisetsuDiv SearchResultOtherShisetsu) {
        this.SearchResultOtherShisetsu=SearchResultOtherShisetsu;
    }

    @JsonProperty("btnOtherShisetsuReturn")
    public Button getBtnOtherShisetsuReturn() {
        return btnOtherShisetsuReturn;
    }

    @JsonProperty("btnOtherShisetsuReturn")
    public void setBtnOtherShisetsuReturn(Button btnOtherShisetsuReturn) {
        this.btnOtherShisetsuReturn=btnOtherShisetsuReturn;
    }

}
