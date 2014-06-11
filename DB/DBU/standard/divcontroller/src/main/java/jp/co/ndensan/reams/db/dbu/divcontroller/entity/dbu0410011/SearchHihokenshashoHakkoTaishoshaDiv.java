package jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011.SearchHihokenshashoHakkoTaishoshaCommonJohoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011.SearchHihokenshashoHakkoTaishoshaDbJohoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011.SearchHihokenshashoHakkoTaishoshaMaeShorishaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SearchHihokenshashoHakkoTaishosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchHihokenshashoHakkoTaishoshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchHihokenshashoHakkoTaishoshaCommonJoho")
    private SearchHihokenshashoHakkoTaishoshaCommonJohoDiv SearchHihokenshashoHakkoTaishoshaCommonJoho;
    @JsonProperty("SearchHihokenshashoHakkoTaishoshaDbJoho")
    private SearchHihokenshashoHakkoTaishoshaDbJohoDiv SearchHihokenshashoHakkoTaishoshaDbJoho;
    @JsonProperty("SearchHihokenshashoHakkoTaishoshaMaeShorisha")
    private SearchHihokenshashoHakkoTaishoshaMaeShorishaDiv SearchHihokenshashoHakkoTaishoshaMaeShorisha;
    @JsonProperty("btnSearchHihokenshashoHakkoTaishosha")
    private Button btnSearchHihokenshashoHakkoTaishosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SearchHihokenshashoHakkoTaishoshaCommonJoho")
    public SearchHihokenshashoHakkoTaishoshaCommonJohoDiv getSearchHihokenshashoHakkoTaishoshaCommonJoho() {
        return SearchHihokenshashoHakkoTaishoshaCommonJoho;
    }

    @JsonProperty("SearchHihokenshashoHakkoTaishoshaCommonJoho")
    public void setSearchHihokenshashoHakkoTaishoshaCommonJoho(SearchHihokenshashoHakkoTaishoshaCommonJohoDiv SearchHihokenshashoHakkoTaishoshaCommonJoho) {
        this.SearchHihokenshashoHakkoTaishoshaCommonJoho=SearchHihokenshashoHakkoTaishoshaCommonJoho;
    }

    @JsonProperty("SearchHihokenshashoHakkoTaishoshaDbJoho")
    public SearchHihokenshashoHakkoTaishoshaDbJohoDiv getSearchHihokenshashoHakkoTaishoshaDbJoho() {
        return SearchHihokenshashoHakkoTaishoshaDbJoho;
    }

    @JsonProperty("SearchHihokenshashoHakkoTaishoshaDbJoho")
    public void setSearchHihokenshashoHakkoTaishoshaDbJoho(SearchHihokenshashoHakkoTaishoshaDbJohoDiv SearchHihokenshashoHakkoTaishoshaDbJoho) {
        this.SearchHihokenshashoHakkoTaishoshaDbJoho=SearchHihokenshashoHakkoTaishoshaDbJoho;
    }

    @JsonProperty("SearchHihokenshashoHakkoTaishoshaMaeShorisha")
    public SearchHihokenshashoHakkoTaishoshaMaeShorishaDiv getSearchHihokenshashoHakkoTaishoshaMaeShorisha() {
        return SearchHihokenshashoHakkoTaishoshaMaeShorisha;
    }

    @JsonProperty("SearchHihokenshashoHakkoTaishoshaMaeShorisha")
    public void setSearchHihokenshashoHakkoTaishoshaMaeShorisha(SearchHihokenshashoHakkoTaishoshaMaeShorishaDiv SearchHihokenshashoHakkoTaishoshaMaeShorisha) {
        this.SearchHihokenshashoHakkoTaishoshaMaeShorisha=SearchHihokenshashoHakkoTaishoshaMaeShorisha;
    }

    @JsonProperty("btnSearchHihokenshashoHakkoTaishosha")
    public Button getBtnSearchHihokenshashoHakkoTaishosha() {
        return btnSearchHihokenshashoHakkoTaishosha;
    }

    @JsonProperty("btnSearchHihokenshashoHakkoTaishosha")
    public void setBtnSearchHihokenshashoHakkoTaishosha(Button btnSearchHihokenshashoHakkoTaishosha) {
        this.btnSearchHihokenshashoHakkoTaishosha=btnSearchHihokenshashoHakkoTaishosha;
    }

}
