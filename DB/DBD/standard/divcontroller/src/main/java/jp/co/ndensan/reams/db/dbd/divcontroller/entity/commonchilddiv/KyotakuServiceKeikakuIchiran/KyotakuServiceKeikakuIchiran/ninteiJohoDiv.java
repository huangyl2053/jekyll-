package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.KyotakuServiceKeikakuIchiran.KyotakuServiceKeikakuIchiran;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ninteiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ninteiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtYokaigodo")
    private TextBox txtYokaigodo;
    @JsonProperty("txtNinteiYukokikan")
    private TextBoxDateRange txtNinteiYukokikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtYokaigodo
     * @return txtYokaigodo
     */
    @JsonProperty("txtYokaigodo")
    public TextBox getTxtYokaigodo() {
        return txtYokaigodo;
    }

    /*
     * settxtYokaigodo
     * @param txtYokaigodo txtYokaigodo
     */
    @JsonProperty("txtYokaigodo")
    public void setTxtYokaigodo(TextBox txtYokaigodo) {
        this.txtYokaigodo = txtYokaigodo;
    }

    /*
     * gettxtNinteiYukokikan
     * @return txtNinteiYukokikan
     */
    @JsonProperty("txtNinteiYukokikan")
    public TextBoxDateRange getTxtNinteiYukokikan() {
        return txtNinteiYukokikan;
    }

    /*
     * settxtNinteiYukokikan
     * @param txtNinteiYukokikan txtNinteiYukokikan
     */
    @JsonProperty("txtNinteiYukokikan")
    public void setTxtNinteiYukokikan(TextBoxDateRange txtNinteiYukokikan) {
        this.txtNinteiYukokikan = txtNinteiYukokikan;
    }

    // </editor-fold>
}
