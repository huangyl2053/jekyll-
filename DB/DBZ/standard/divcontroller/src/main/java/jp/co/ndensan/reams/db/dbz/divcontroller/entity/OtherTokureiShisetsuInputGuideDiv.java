package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IOtherTokureiShisetsuInputGuideDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SearchResultOtherShisetsuDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * OtherTokureiShisetsuInputGuide のクラスファイル 
 * 
 * @author 自動生成
 */
public class OtherTokureiShisetsuInputGuideDiv extends Panel implements IOtherTokureiShisetsuInputGuideDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radKannaiKubun")
    private RadioButton radKannaiKubun;
    @JsonProperty("btnSearchOtherShisetsu")
    private Button btnSearchOtherShisetsu;
    @JsonProperty("lblOtherShisetsuShurui")
    private Label lblOtherShisetsuShurui;
    @JsonProperty("SearchResultOtherShisetsu")
    private SearchResultOtherShisetsuDiv SearchResultOtherShisetsu;
    @JsonProperty("btnOtherShisetsuReturn")
    private Button btnOtherShisetsuReturn;
    @JsonProperty("shisetsuCode")
    private RString shisetsuCode;
    @JsonProperty("shisetsuMeisho")
    private RString shisetsuMeisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radKannaiKubun")
    public RadioButton getRadKannaiKubun() {
        return radKannaiKubun;
    }

    @JsonProperty("radKannaiKubun")
    public void setRadKannaiKubun(RadioButton radKannaiKubun) {
        this.radKannaiKubun=radKannaiKubun;
    }

    @JsonProperty("btnSearchOtherShisetsu")
    public Button getBtnSearchOtherShisetsu() {
        return btnSearchOtherShisetsu;
    }

    @JsonProperty("btnSearchOtherShisetsu")
    public void setBtnSearchOtherShisetsu(Button btnSearchOtherShisetsu) {
        this.btnSearchOtherShisetsu=btnSearchOtherShisetsu;
    }

    @JsonProperty("lblOtherShisetsuShurui")
    public Label getLblOtherShisetsuShurui() {
        return lblOtherShisetsuShurui;
    }

    @JsonProperty("lblOtherShisetsuShurui")
    public void setLblOtherShisetsuShurui(Label lblOtherShisetsuShurui) {
        this.lblOtherShisetsuShurui=lblOtherShisetsuShurui;
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

    @JsonProperty("shisetsuCode")
    public RString getShisetsuCode() {
        return shisetsuCode;
    }

    @JsonProperty("shisetsuCode")
    public void setShisetsuCode(RString shisetsuCode) {
        this.shisetsuCode=shisetsuCode;
    }

    @JsonProperty("shisetsuMeisho")
    public RString getShisetsuMeisho() {
        return shisetsuMeisho;
    }

    @JsonProperty("shisetsuMeisho")
    public void setShisetsuMeisho(RString shisetsuMeisho) {
        this.shisetsuMeisho=shisetsuMeisho;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
