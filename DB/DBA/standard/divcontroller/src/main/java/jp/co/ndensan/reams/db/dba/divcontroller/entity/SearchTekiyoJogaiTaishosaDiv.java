package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.MaeShoriTekiyoJogaishaDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.SearchTekiyoJogaishaCommonJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.SearchTekiyoJogaishaDbJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SearchTekiyoJogaiTaishosa のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchTekiyoJogaiTaishosaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchTekiyoJogaishaCommonJoho")
    private SearchTekiyoJogaishaCommonJohoDiv SearchTekiyoJogaishaCommonJoho;
    @JsonProperty("SearchTekiyoJogaishaDbJoho")
    private SearchTekiyoJogaishaDbJohoDiv SearchTekiyoJogaishaDbJoho;
    @JsonProperty("MaeShoriTekiyoJogaisha")
    private MaeShoriTekiyoJogaishaDiv MaeShoriTekiyoJogaisha;
    @JsonProperty("btnSearchGaitosha")
    private Button btnSearchGaitosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SearchTekiyoJogaishaCommonJoho")
    public SearchTekiyoJogaishaCommonJohoDiv getSearchTekiyoJogaishaCommonJoho() {
        return SearchTekiyoJogaishaCommonJoho;
    }

    @JsonProperty("SearchTekiyoJogaishaCommonJoho")
    public void setSearchTekiyoJogaishaCommonJoho(SearchTekiyoJogaishaCommonJohoDiv SearchTekiyoJogaishaCommonJoho) {
        this.SearchTekiyoJogaishaCommonJoho=SearchTekiyoJogaishaCommonJoho;
    }

    @JsonProperty("SearchTekiyoJogaishaDbJoho")
    public SearchTekiyoJogaishaDbJohoDiv getSearchTekiyoJogaishaDbJoho() {
        return SearchTekiyoJogaishaDbJoho;
    }

    @JsonProperty("SearchTekiyoJogaishaDbJoho")
    public void setSearchTekiyoJogaishaDbJoho(SearchTekiyoJogaishaDbJohoDiv SearchTekiyoJogaishaDbJoho) {
        this.SearchTekiyoJogaishaDbJoho=SearchTekiyoJogaishaDbJoho;
    }

    @JsonProperty("MaeShoriTekiyoJogaisha")
    public MaeShoriTekiyoJogaishaDiv getMaeShoriTekiyoJogaisha() {
        return MaeShoriTekiyoJogaisha;
    }

    @JsonProperty("MaeShoriTekiyoJogaisha")
    public void setMaeShoriTekiyoJogaisha(MaeShoriTekiyoJogaishaDiv MaeShoriTekiyoJogaisha) {
        this.MaeShoriTekiyoJogaisha=MaeShoriTekiyoJogaisha;
    }

    @JsonProperty("btnSearchGaitosha")
    public Button getBtnSearchGaitosha() {
        return btnSearchGaitosha;
    }

    @JsonProperty("btnSearchGaitosha")
    public void setBtnSearchGaitosha(Button btnSearchGaitosha) {
        this.btnSearchGaitosha=btnSearchGaitosha;
    }

}
