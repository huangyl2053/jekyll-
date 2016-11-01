package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokubetsuKyufuJigyoshaSearch のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokubetsuKyufuJigyoshaSearchDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TokubetsuKyufuSearchJigyoshaCode")
    private TokubetsuKyufuSearchJigyoshaCodeDiv TokubetsuKyufuSearchJigyoshaCode;
    @JsonProperty("TokubetsuKyufuJigyoshaSearchBottonArea")
    private TokubetsuKyufuJigyoshaSearchBottonAreaDiv TokubetsuKyufuJigyoshaSearchBottonArea;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTokubetsuKyufuSearchJigyoshaCode
     * @return TokubetsuKyufuSearchJigyoshaCode
     */
    @JsonProperty("TokubetsuKyufuSearchJigyoshaCode")
    public TokubetsuKyufuSearchJigyoshaCodeDiv getTokubetsuKyufuSearchJigyoshaCode() {
        return TokubetsuKyufuSearchJigyoshaCode;
    }

    /*
     * setTokubetsuKyufuSearchJigyoshaCode
     * @param TokubetsuKyufuSearchJigyoshaCode TokubetsuKyufuSearchJigyoshaCode
     */
    @JsonProperty("TokubetsuKyufuSearchJigyoshaCode")
    public void setTokubetsuKyufuSearchJigyoshaCode(TokubetsuKyufuSearchJigyoshaCodeDiv TokubetsuKyufuSearchJigyoshaCode) {
        this.TokubetsuKyufuSearchJigyoshaCode = TokubetsuKyufuSearchJigyoshaCode;
    }

    /*
     * getTokubetsuKyufuJigyoshaSearchBottonArea
     * @return TokubetsuKyufuJigyoshaSearchBottonArea
     */
    @JsonProperty("TokubetsuKyufuJigyoshaSearchBottonArea")
    public TokubetsuKyufuJigyoshaSearchBottonAreaDiv getTokubetsuKyufuJigyoshaSearchBottonArea() {
        return TokubetsuKyufuJigyoshaSearchBottonArea;
    }

    /*
     * setTokubetsuKyufuJigyoshaSearchBottonArea
     * @param TokubetsuKyufuJigyoshaSearchBottonArea TokubetsuKyufuJigyoshaSearchBottonArea
     */
    @JsonProperty("TokubetsuKyufuJigyoshaSearchBottonArea")
    public void setTokubetsuKyufuJigyoshaSearchBottonArea(TokubetsuKyufuJigyoshaSearchBottonAreaDiv TokubetsuKyufuJigyoshaSearchBottonArea) {
        this.TokubetsuKyufuJigyoshaSearchBottonArea = TokubetsuKyufuJigyoshaSearchBottonArea;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Space getSpc01() {
        return this.getTokubetsuKyufuJigyoshaSearchBottonArea().getSpc01();
    }

    @JsonIgnore
    public void  setSpc01(Space spc01) {
        this.getTokubetsuKyufuJigyoshaSearchBottonArea().setSpc01(spc01);
    }

    @JsonIgnore
    public Button getBtnSearch() {
        return this.getTokubetsuKyufuJigyoshaSearchBottonArea().getBtnSearch();
    }

    @JsonIgnore
    public void  setBtnSearch(Button btnSearch) {
        this.getTokubetsuKyufuJigyoshaSearchBottonArea().setBtnSearch(btnSearch);
    }

    // </editor-fold>
}
