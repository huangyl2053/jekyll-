package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokubetsuKyufuJigyoshaDetailServiceInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokubetsuKyufuJigyoshaDetailServiceInfoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-21_20-30-14">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlService")
    private DropDownList ddlService;
    @JsonProperty("TokubetsuKyufuJigyoshaDetailKanrisha")
    private TokubetsuKyufuJigyoshaDetailKanrishaDiv TokubetsuKyufuJigyoshaDetailKanrisha;
    @JsonProperty("TokubetsuKyufuJigyoshaDetailJigyosha")
    private TokubetsuKyufuJigyoshaDetailJigyoshaDiv TokubetsuKyufuJigyoshaDetailJigyosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlService
     * @return ddlService
     */
    @JsonProperty("ddlService")
    public DropDownList getDdlService() {
        return ddlService;
    }

    /*
     * setddlService
     * @param ddlService ddlService
     */
    @JsonProperty("ddlService")
    public void setDdlService(DropDownList ddlService) {
        this.ddlService = ddlService;
    }

    /*
     * getTokubetsuKyufuJigyoshaDetailKanrisha
     * @return TokubetsuKyufuJigyoshaDetailKanrisha
     */
    @JsonProperty("TokubetsuKyufuJigyoshaDetailKanrisha")
    public TokubetsuKyufuJigyoshaDetailKanrishaDiv getTokubetsuKyufuJigyoshaDetailKanrisha() {
        return TokubetsuKyufuJigyoshaDetailKanrisha;
    }

    /*
     * setTokubetsuKyufuJigyoshaDetailKanrisha
     * @param TokubetsuKyufuJigyoshaDetailKanrisha TokubetsuKyufuJigyoshaDetailKanrisha
     */
    @JsonProperty("TokubetsuKyufuJigyoshaDetailKanrisha")
    public void setTokubetsuKyufuJigyoshaDetailKanrisha(TokubetsuKyufuJigyoshaDetailKanrishaDiv TokubetsuKyufuJigyoshaDetailKanrisha) {
        this.TokubetsuKyufuJigyoshaDetailKanrisha = TokubetsuKyufuJigyoshaDetailKanrisha;
    }

    /*
     * getTokubetsuKyufuJigyoshaDetailJigyosha
     * @return TokubetsuKyufuJigyoshaDetailJigyosha
     */
    @JsonProperty("TokubetsuKyufuJigyoshaDetailJigyosha")
    public TokubetsuKyufuJigyoshaDetailJigyoshaDiv getTokubetsuKyufuJigyoshaDetailJigyosha() {
        return TokubetsuKyufuJigyoshaDetailJigyosha;
    }

    /*
     * setTokubetsuKyufuJigyoshaDetailJigyosha
     * @param TokubetsuKyufuJigyoshaDetailJigyosha TokubetsuKyufuJigyoshaDetailJigyosha
     */
    @JsonProperty("TokubetsuKyufuJigyoshaDetailJigyosha")
    public void setTokubetsuKyufuJigyoshaDetailJigyosha(TokubetsuKyufuJigyoshaDetailJigyoshaDiv TokubetsuKyufuJigyoshaDetailJigyosha) {
        this.TokubetsuKyufuJigyoshaDetailJigyosha = TokubetsuKyufuJigyoshaDetailJigyosha;
    }

    // </editor-fold>
}
