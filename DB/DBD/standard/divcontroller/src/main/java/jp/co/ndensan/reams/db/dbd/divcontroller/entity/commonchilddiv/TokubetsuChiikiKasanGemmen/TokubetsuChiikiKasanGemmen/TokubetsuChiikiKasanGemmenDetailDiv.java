package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.TokubetsuChiikiKasanGemmen.TokubetsuChiikiKasanGemmen;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokubetsuChiikiKasanGemmenDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokubetsuChiikiKasanGemmenDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiDate")
    private TextBoxFlexibleDate txtShinseiDate;
    @JsonProperty("TokubetsuChiikiKasanGemmenRiyoshaFutan")
    private TokubetsuChiikiKasanGemmenRiyoshaFutanDiv TokubetsuChiikiKasanGemmenRiyoshaFutan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseiDate
     * @return txtShinseiDate
     */
    @JsonProperty("txtShinseiDate")
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    /*
     * settxtShinseiDate
     * @param txtShinseiDate txtShinseiDate
     */
    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.txtShinseiDate = txtShinseiDate;
    }

    /*
     * getTokubetsuChiikiKasanGemmenRiyoshaFutan
     * @return TokubetsuChiikiKasanGemmenRiyoshaFutan
     */
    @JsonProperty("TokubetsuChiikiKasanGemmenRiyoshaFutan")
    public TokubetsuChiikiKasanGemmenRiyoshaFutanDiv getTokubetsuChiikiKasanGemmenRiyoshaFutan() {
        return TokubetsuChiikiKasanGemmenRiyoshaFutan;
    }

    /*
     * setTokubetsuChiikiKasanGemmenRiyoshaFutan
     * @param TokubetsuChiikiKasanGemmenRiyoshaFutan TokubetsuChiikiKasanGemmenRiyoshaFutan
     */
    @JsonProperty("TokubetsuChiikiKasanGemmenRiyoshaFutan")
    public void setTokubetsuChiikiKasanGemmenRiyoshaFutan(TokubetsuChiikiKasanGemmenRiyoshaFutanDiv TokubetsuChiikiKasanGemmenRiyoshaFutan) {
        this.TokubetsuChiikiKasanGemmenRiyoshaFutan = TokubetsuChiikiKasanGemmenRiyoshaFutan;
    }

    // </editor-fold>
}
