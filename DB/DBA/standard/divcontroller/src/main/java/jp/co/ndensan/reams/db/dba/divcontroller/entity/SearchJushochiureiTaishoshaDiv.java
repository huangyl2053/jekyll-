package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.MaeShorishaRirekiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.SearchDBCommonInfoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.SearchReamsCommonInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SearchJushochiureiTaishosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchJushochiureiTaishoshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchReamsCommonInfo")
    private SearchReamsCommonInfoDiv SearchReamsCommonInfo;
    @JsonProperty("SearchDBCommonInfo")
    private SearchDBCommonInfoDiv SearchDBCommonInfo;
    @JsonProperty("MaeShorishaRireki")
    private MaeShorishaRirekiDiv MaeShorishaRireki;
    @JsonProperty("btnSearchJushochiTokureiTaishosha")
    private Button btnSearchJushochiTokureiTaishosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SearchReamsCommonInfo")
    public SearchReamsCommonInfoDiv getSearchReamsCommonInfo() {
        return SearchReamsCommonInfo;
    }

    @JsonProperty("SearchReamsCommonInfo")
    public void setSearchReamsCommonInfo(SearchReamsCommonInfoDiv SearchReamsCommonInfo) {
        this.SearchReamsCommonInfo=SearchReamsCommonInfo;
    }

    @JsonProperty("SearchDBCommonInfo")
    public SearchDBCommonInfoDiv getSearchDBCommonInfo() {
        return SearchDBCommonInfo;
    }

    @JsonProperty("SearchDBCommonInfo")
    public void setSearchDBCommonInfo(SearchDBCommonInfoDiv SearchDBCommonInfo) {
        this.SearchDBCommonInfo=SearchDBCommonInfo;
    }

    @JsonProperty("MaeShorishaRireki")
    public MaeShorishaRirekiDiv getMaeShorishaRireki() {
        return MaeShorishaRireki;
    }

    @JsonProperty("MaeShorishaRireki")
    public void setMaeShorishaRireki(MaeShorishaRirekiDiv MaeShorishaRireki) {
        this.MaeShorishaRireki=MaeShorishaRireki;
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
