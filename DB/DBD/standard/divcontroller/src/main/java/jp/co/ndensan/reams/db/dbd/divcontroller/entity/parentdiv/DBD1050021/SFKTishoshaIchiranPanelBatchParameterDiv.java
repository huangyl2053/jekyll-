package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1050021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * SFKTishoshaIchiranPanelBatchParameter のクラスファイル 
 * 
 * @author 自動生成
 */
public class SFKTishoshaIchiranPanelBatchParameterDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChutsutsuJoken")
    private ChutsutsuJokenDiv ChutsutsuJoken;
    @JsonProperty("ChushutsuSetsumei")
    private ChushutsuSetsumeiDiv ChushutsuSetsumei;
    @JsonProperty("jigyoshaCode")
    private RString jigyoshaCode;
    @JsonProperty("jigyoshaMeisho")
    private RString jigyoshaMeisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChutsutsuJoken
     * @return ChutsutsuJoken
     */
    @JsonProperty("ChutsutsuJoken")
    public ChutsutsuJokenDiv getChutsutsuJoken() {
        return ChutsutsuJoken;
    }

    /*
     * setChutsutsuJoken
     * @param ChutsutsuJoken ChutsutsuJoken
     */
    @JsonProperty("ChutsutsuJoken")
    public void setChutsutsuJoken(ChutsutsuJokenDiv ChutsutsuJoken) {
        this.ChutsutsuJoken = ChutsutsuJoken;
    }

    /*
     * getChushutsuSetsumei
     * @return ChushutsuSetsumei
     */
    @JsonProperty("ChushutsuSetsumei")
    public ChushutsuSetsumeiDiv getChushutsuSetsumei() {
        return ChushutsuSetsumei;
    }

    /*
     * setChushutsuSetsumei
     * @param ChushutsuSetsumei ChushutsuSetsumei
     */
    @JsonProperty("ChushutsuSetsumei")
    public void setChushutsuSetsumei(ChushutsuSetsumeiDiv ChushutsuSetsumei) {
        this.ChushutsuSetsumei = ChushutsuSetsumei;
    }

    /*
     * getjigyoshaCode
     * @return jigyoshaCode
     */
    @JsonProperty("jigyoshaCode")
    public RString getJigyoshaCode() {
        return jigyoshaCode;
    }

    /*
     * setjigyoshaCode
     * @param jigyoshaCode jigyoshaCode
     */
    @JsonProperty("jigyoshaCode")
    public void setJigyoshaCode(RString jigyoshaCode) {
        this.jigyoshaCode = jigyoshaCode;
    }

    /*
     * getjigyoshaMeisho
     * @return jigyoshaMeisho
     */
    @JsonProperty("jigyoshaMeisho")
    public RString getJigyoshaMeisho() {
        return jigyoshaMeisho;
    }

    /*
     * setjigyoshaMeisho
     * @param jigyoshaMeisho jigyoshaMeisho
     */
    @JsonProperty("jigyoshaMeisho")
    public void setJigyoshaMeisho(RString jigyoshaMeisho) {
        this.jigyoshaMeisho = jigyoshaMeisho;
    }

    // </editor-fold>
}
