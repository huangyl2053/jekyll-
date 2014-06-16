package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KazokuRenrakusaki のクラスファイル 
 * 
 * @author 自動生成
 */
public class KazokuRenrakusakiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKazokuYubinNo")
    private TextBoxYubinNo txtKazokuYubinNo;
    @JsonProperty("txtKazokuJusho")
    private TextBox txtKazokuJusho;
    @JsonProperty("txtKazokuTel")
    private TextBox txtKazokuTel;
    @JsonProperty("txtKazokuShimei")
    private TextBox txtKazokuShimei;
    @JsonProperty("txtChosaTaishoshaKankei")
    private TextBox txtChosaTaishoshaKankei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKazokuYubinNo")
    public TextBoxYubinNo getTxtKazokuYubinNo() {
        return txtKazokuYubinNo;
    }

    @JsonProperty("txtKazokuYubinNo")
    public void setTxtKazokuYubinNo(TextBoxYubinNo txtKazokuYubinNo) {
        this.txtKazokuYubinNo=txtKazokuYubinNo;
    }

    @JsonProperty("txtKazokuJusho")
    public TextBox getTxtKazokuJusho() {
        return txtKazokuJusho;
    }

    @JsonProperty("txtKazokuJusho")
    public void setTxtKazokuJusho(TextBox txtKazokuJusho) {
        this.txtKazokuJusho=txtKazokuJusho;
    }

    @JsonProperty("txtKazokuTel")
    public TextBox getTxtKazokuTel() {
        return txtKazokuTel;
    }

    @JsonProperty("txtKazokuTel")
    public void setTxtKazokuTel(TextBox txtKazokuTel) {
        this.txtKazokuTel=txtKazokuTel;
    }

    @JsonProperty("txtKazokuShimei")
    public TextBox getTxtKazokuShimei() {
        return txtKazokuShimei;
    }

    @JsonProperty("txtKazokuShimei")
    public void setTxtKazokuShimei(TextBox txtKazokuShimei) {
        this.txtKazokuShimei=txtKazokuShimei;
    }

    @JsonProperty("txtChosaTaishoshaKankei")
    public TextBox getTxtChosaTaishoshaKankei() {
        return txtChosaTaishoshaKankei;
    }

    @JsonProperty("txtChosaTaishoshaKankei")
    public void setTxtChosaTaishoshaKankei(TextBox txtChosaTaishoshaKankei) {
        this.txtChosaTaishoshaKankei=txtChosaTaishoshaKankei;
    }

}
