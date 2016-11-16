package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Ninteichosa のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-17_21-01-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtZenkaiYokaigodo")
    private TextBox txtZenkaiYokaigodo;
    @JsonProperty("txtZenkaiNinteiDate")
    private TextBoxFlexibleDate txtZenkaiNinteiDate;
    @JsonProperty("TxtZenkaiYukokikan")
    private TextBoxDateRange TxtZenkaiYukokikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtZenkaiYokaigodo
     * @return txtZenkaiYokaigodo
     */
    @JsonProperty("txtZenkaiYokaigodo")
    public TextBox getTxtZenkaiYokaigodo() {
        return txtZenkaiYokaigodo;
    }

    /*
     * settxtZenkaiYokaigodo
     * @param txtZenkaiYokaigodo txtZenkaiYokaigodo
     */
    @JsonProperty("txtZenkaiYokaigodo")
    public void setTxtZenkaiYokaigodo(TextBox txtZenkaiYokaigodo) {
        this.txtZenkaiYokaigodo = txtZenkaiYokaigodo;
    }

    /*
     * gettxtZenkaiNinteiDate
     * @return txtZenkaiNinteiDate
     */
    @JsonProperty("txtZenkaiNinteiDate")
    public TextBoxFlexibleDate getTxtZenkaiNinteiDate() {
        return txtZenkaiNinteiDate;
    }

    /*
     * settxtZenkaiNinteiDate
     * @param txtZenkaiNinteiDate txtZenkaiNinteiDate
     */
    @JsonProperty("txtZenkaiNinteiDate")
    public void setTxtZenkaiNinteiDate(TextBoxFlexibleDate txtZenkaiNinteiDate) {
        this.txtZenkaiNinteiDate = txtZenkaiNinteiDate;
    }

    /*
     * getTxtZenkaiYukokikan
     * @return TxtZenkaiYukokikan
     */
    @JsonProperty("TxtZenkaiYukokikan")
    public TextBoxDateRange getTxtZenkaiYukokikan() {
        return TxtZenkaiYukokikan;
    }

    /*
     * setTxtZenkaiYukokikan
     * @param TxtZenkaiYukokikan TxtZenkaiYukokikan
     */
    @JsonProperty("TxtZenkaiYukokikan")
    public void setTxtZenkaiYukokikan(TextBoxDateRange TxtZenkaiYukokikan) {
        this.TxtZenkaiYukokikan = TxtZenkaiYukokikan;
    }

    // </editor-fold>
}
