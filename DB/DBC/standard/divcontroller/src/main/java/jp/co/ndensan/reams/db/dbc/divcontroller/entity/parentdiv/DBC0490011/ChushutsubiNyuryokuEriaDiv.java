package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0490011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsubiNyuryokuEria のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsubiNyuryokuEriaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtUketukebi")
    private TextBoxDateRange txtUketukebi;
    @JsonProperty("txtKetteibi")
    private TextBoxDateRange txtKetteibi;
    @JsonProperty("txtKetteishaUketukeNengetsu")
    private TextBoxDate txtKetteishaUketukeNengetsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtUketukebi
     * @return txtUketukebi
     */
    @JsonProperty("txtUketukebi")
    public TextBoxDateRange getTxtUketukebi() {
        return txtUketukebi;
    }

    /*
     * settxtUketukebi
     * @param txtUketukebi txtUketukebi
     */
    @JsonProperty("txtUketukebi")
    public void setTxtUketukebi(TextBoxDateRange txtUketukebi) {
        this.txtUketukebi = txtUketukebi;
    }

    /*
     * gettxtKetteibi
     * @return txtKetteibi
     */
    @JsonProperty("txtKetteibi")
    public TextBoxDateRange getTxtKetteibi() {
        return txtKetteibi;
    }

    /*
     * settxtKetteibi
     * @param txtKetteibi txtKetteibi
     */
    @JsonProperty("txtKetteibi")
    public void setTxtKetteibi(TextBoxDateRange txtKetteibi) {
        this.txtKetteibi = txtKetteibi;
    }

    /*
     * gettxtKetteishaUketukeNengetsu
     * @return txtKetteishaUketukeNengetsu
     */
    @JsonProperty("txtKetteishaUketukeNengetsu")
    public TextBoxDate getTxtKetteishaUketukeNengetsu() {
        return txtKetteishaUketukeNengetsu;
    }

    /*
     * settxtKetteishaUketukeNengetsu
     * @param txtKetteishaUketukeNengetsu txtKetteishaUketukeNengetsu
     */
    @JsonProperty("txtKetteishaUketukeNengetsu")
    public void setTxtKetteishaUketukeNengetsu(TextBoxDate txtKetteishaUketukeNengetsu) {
        this.txtKetteishaUketukeNengetsu = txtKetteishaUketukeNengetsu;
    }

    // </editor-fold>
}
