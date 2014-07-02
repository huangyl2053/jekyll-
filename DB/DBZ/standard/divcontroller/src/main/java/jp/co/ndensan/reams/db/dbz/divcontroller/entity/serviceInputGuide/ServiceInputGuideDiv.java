package jp.co.ndensan.reams.db.dbz.divcontroller.entity.serviceInputGuide;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.serviceInputGuide.SearchResultServiceDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ServiceInputGuide のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceInputGuideDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtServiceShuruiCode")
    private TextBoxCode txtServiceShuruiCode;
    @JsonProperty("txtServiceCode")
    private TextBoxCode txtServiceCode;
    @JsonProperty("txtKijyunYM")
    private TextBoxDate txtKijyunYM;
    @JsonProperty("btnSearchJService")
    private Button btnSearchJService;
    @JsonProperty("SearchResultService")
    private SearchResultServiceDiv SearchResultService;
    @JsonProperty("btnServiceInputGuideReturn")
    private Button btnServiceInputGuideReturn;
    @JsonProperty("serviceCode")
    private RString serviceCode;
    @JsonProperty("serviceMeisho")
    private RString serviceMeisho;
    @JsonProperty("serviceTaishoYM")
    private RString serviceTaishoYM;
    @JsonProperty("serviceCodeMeisho")
    private RString serviceCodeMeisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtServiceShuruiCode")
    public TextBoxCode getTxtServiceShuruiCode() {
        return txtServiceShuruiCode;
    }

    @JsonProperty("txtServiceShuruiCode")
    public void setTxtServiceShuruiCode(TextBoxCode txtServiceShuruiCode) {
        this.txtServiceShuruiCode=txtServiceShuruiCode;
    }

    @JsonProperty("txtServiceCode")
    public TextBoxCode getTxtServiceCode() {
        return txtServiceCode;
    }

    @JsonProperty("txtServiceCode")
    public void setTxtServiceCode(TextBoxCode txtServiceCode) {
        this.txtServiceCode=txtServiceCode;
    }

    @JsonProperty("txtKijyunYM")
    public TextBoxDate getTxtKijyunYM() {
        return txtKijyunYM;
    }

    @JsonProperty("txtKijyunYM")
    public void setTxtKijyunYM(TextBoxDate txtKijyunYM) {
        this.txtKijyunYM=txtKijyunYM;
    }

    @JsonProperty("btnSearchJService")
    public Button getBtnSearchJService() {
        return btnSearchJService;
    }

    @JsonProperty("btnSearchJService")
    public void setBtnSearchJService(Button btnSearchJService) {
        this.btnSearchJService=btnSearchJService;
    }

    @JsonProperty("SearchResultService")
    public SearchResultServiceDiv getSearchResultService() {
        return SearchResultService;
    }

    @JsonProperty("SearchResultService")
    public void setSearchResultService(SearchResultServiceDiv SearchResultService) {
        this.SearchResultService=SearchResultService;
    }

    @JsonProperty("btnServiceInputGuideReturn")
    public Button getBtnServiceInputGuideReturn() {
        return btnServiceInputGuideReturn;
    }

    @JsonProperty("btnServiceInputGuideReturn")
    public void setBtnServiceInputGuideReturn(Button btnServiceInputGuideReturn) {
        this.btnServiceInputGuideReturn=btnServiceInputGuideReturn;
    }

    @JsonProperty("serviceCode")
    public RString getServiceCode() {
        return serviceCode;
    }

    @JsonProperty("serviceCode")
    public void setServiceCode(RString serviceCode) {
        this.serviceCode=serviceCode;
    }

    @JsonProperty("serviceMeisho")
    public RString getServiceMeisho() {
        return serviceMeisho;
    }

    @JsonProperty("serviceMeisho")
    public void setServiceMeisho(RString serviceMeisho) {
        this.serviceMeisho=serviceMeisho;
    }

    @JsonProperty("serviceTaishoYM")
    public RString getServiceTaishoYM() {
        return serviceTaishoYM;
    }

    @JsonProperty("serviceTaishoYM")
    public void setServiceTaishoYM(RString serviceTaishoYM) {
        this.serviceTaishoYM=serviceTaishoYM;
    }

    @JsonProperty("serviceCodeMeisho")
    public RString getServiceCodeMeisho() {
        return serviceCodeMeisho;
    }

    @JsonProperty("serviceCodeMeisho")
    public void setServiceCodeMeisho(RString serviceCodeMeisho) {
        this.serviceCodeMeisho=serviceCodeMeisho;
    }

}
