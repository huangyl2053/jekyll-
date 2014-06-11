package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001;
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
 * IryoHokenDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class IryoHokenDetailDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIryoHokenShubetsu")
    private TextBox txtIryoHokenShubetsu;
    @JsonProperty("txtHokenshaNo")
    private TextBoxNum txtHokenshaNo;
    @JsonProperty("txtHokenshaMeisho")
    private TextBox txtHokenshaMeisho;
    @JsonProperty("txtKigoBango")
    private TextBox txtKigoBango;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtIryoHokenShubetsu")
    public TextBox getTxtIryoHokenShubetsu() {
        return txtIryoHokenShubetsu;
    }

    @JsonProperty("txtIryoHokenShubetsu")
    public void setTxtIryoHokenShubetsu(TextBox txtIryoHokenShubetsu) {
        this.txtIryoHokenShubetsu=txtIryoHokenShubetsu;
    }

    @JsonProperty("txtHokenshaNo")
    public TextBoxNum getTxtHokenshaNo() {
        return txtHokenshaNo;
    }

    @JsonProperty("txtHokenshaNo")
    public void setTxtHokenshaNo(TextBoxNum txtHokenshaNo) {
        this.txtHokenshaNo=txtHokenshaNo;
    }

    @JsonProperty("txtHokenshaMeisho")
    public TextBox getTxtHokenshaMeisho() {
        return txtHokenshaMeisho;
    }

    @JsonProperty("txtHokenshaMeisho")
    public void setTxtHokenshaMeisho(TextBox txtHokenshaMeisho) {
        this.txtHokenshaMeisho=txtHokenshaMeisho;
    }

    @JsonProperty("txtKigoBango")
    public TextBox getTxtKigoBango() {
        return txtKigoBango;
    }

    @JsonProperty("txtKigoBango")
    public void setTxtKigoBango(TextBox txtKigoBango) {
        this.txtKigoBango=txtKigoBango;
    }

}
