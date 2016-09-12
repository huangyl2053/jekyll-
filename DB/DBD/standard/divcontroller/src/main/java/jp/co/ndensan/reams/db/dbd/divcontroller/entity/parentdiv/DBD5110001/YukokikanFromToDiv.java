package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * YukokikanFromTo のクラスファイル 
 * 
 * @author 自動生成
 */
public class YukokikanFromToDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("spSpace3")
    private Space spSpace3;
    @JsonProperty("txtInsatsuDateFrom")
    private TextBoxYearMonth txtInsatsuDateFrom;
    @JsonProperty("txtInsatsuDateTo")
    private TextBoxYearMonth txtInsatsuDateTo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getspSpace3
     * @return spSpace3
     */
    @JsonProperty("spSpace3")
    public Space getSpSpace3() {
        return spSpace3;
    }

    /*
     * setspSpace3
     * @param spSpace3 spSpace3
     */
    @JsonProperty("spSpace3")
    public void setSpSpace3(Space spSpace3) {
        this.spSpace3 = spSpace3;
    }

    /*
     * gettxtInsatsuDateFrom
     * @return txtInsatsuDateFrom
     */
    @JsonProperty("txtInsatsuDateFrom")
    public TextBoxYearMonth getTxtInsatsuDateFrom() {
        return txtInsatsuDateFrom;
    }

    /*
     * settxtInsatsuDateFrom
     * @param txtInsatsuDateFrom txtInsatsuDateFrom
     */
    @JsonProperty("txtInsatsuDateFrom")
    public void setTxtInsatsuDateFrom(TextBoxYearMonth txtInsatsuDateFrom) {
        this.txtInsatsuDateFrom = txtInsatsuDateFrom;
    }

    /*
     * gettxtInsatsuDateTo
     * @return txtInsatsuDateTo
     */
    @JsonProperty("txtInsatsuDateTo")
    public TextBoxYearMonth getTxtInsatsuDateTo() {
        return txtInsatsuDateTo;
    }

    /*
     * settxtInsatsuDateTo
     * @param txtInsatsuDateTo txtInsatsuDateTo
     */
    @JsonProperty("txtInsatsuDateTo")
    public void setTxtInsatsuDateTo(TextBoxYearMonth txtInsatsuDateTo) {
        this.txtInsatsuDateTo = txtInsatsuDateTo;
    }

    // </editor-fold>
}
