package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2020011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2020011.SearchShisetsuNyutaishoKanriCommonJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2020011.SearchShisetsuNyutaishoKanriDbJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SearchShisetsuNyutaishoKanriTaishosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchShisetsuNyutaishoKanriTaishoshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchShisetsuNyutaishoKanriCommonJoho")
    private SearchShisetsuNyutaishoKanriCommonJohoDiv SearchShisetsuNyutaishoKanriCommonJoho;
    @JsonProperty("SearchShisetsuNyutaishoKanriDbJoho")
    private SearchShisetsuNyutaishoKanriDbJohoDiv SearchShisetsuNyutaishoKanriDbJoho;
    @JsonProperty("btnSearchJushochiTokureiTaishosha")
    private Button btnSearchJushochiTokureiTaishosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SearchShisetsuNyutaishoKanriCommonJoho")
    public SearchShisetsuNyutaishoKanriCommonJohoDiv getSearchShisetsuNyutaishoKanriCommonJoho() {
        return SearchShisetsuNyutaishoKanriCommonJoho;
    }

    @JsonProperty("SearchShisetsuNyutaishoKanriCommonJoho")
    public void setSearchShisetsuNyutaishoKanriCommonJoho(SearchShisetsuNyutaishoKanriCommonJohoDiv SearchShisetsuNyutaishoKanriCommonJoho) {
        this.SearchShisetsuNyutaishoKanriCommonJoho=SearchShisetsuNyutaishoKanriCommonJoho;
    }

    @JsonProperty("SearchShisetsuNyutaishoKanriDbJoho")
    public SearchShisetsuNyutaishoKanriDbJohoDiv getSearchShisetsuNyutaishoKanriDbJoho() {
        return SearchShisetsuNyutaishoKanriDbJoho;
    }

    @JsonProperty("SearchShisetsuNyutaishoKanriDbJoho")
    public void setSearchShisetsuNyutaishoKanriDbJoho(SearchShisetsuNyutaishoKanriDbJohoDiv SearchShisetsuNyutaishoKanriDbJoho) {
        this.SearchShisetsuNyutaishoKanriDbJoho=SearchShisetsuNyutaishoKanriDbJoho;
    }

    @JsonProperty("btnSearchJushochiTokureiTaishosha")
    public Button getBtnSearchJushochiTokureiTaishosha() {
        return btnSearchJushochiTokureiTaishosha;
    }

    @JsonProperty("btnSearchJushochiTokureiTaishosha")
    public void setBtnSearchJushochiTokureiTaishosha(Button btnSearchJushochiTokureiTaishosha) {
        this.btnSearchJushochiTokureiTaishosha=btnSearchJushochiTokureiTaishosha;
    }

}
