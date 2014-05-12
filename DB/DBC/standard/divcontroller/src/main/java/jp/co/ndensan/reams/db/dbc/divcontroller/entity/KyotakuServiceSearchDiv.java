package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
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
 * KyotakuServiceSearch のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyotakuServiceSearchDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSearchName")
    private TextBox txtSearchName;
    @JsonProperty("txtSearchHihokenshaNo")
    private TextBox txtSearchHihokenshaNo;
    @JsonProperty("txtSearchShokisaiHokenshaNo")
    private TextBox txtSearchShokisaiHokenshaNo;
    @JsonProperty("btnKyotakuServiceSearch")
    private Button btnKyotakuServiceSearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtSearchName")
    public TextBox getTxtSearchName() {
        return txtSearchName;
    }

    @JsonProperty("txtSearchName")
    public void setTxtSearchName(TextBox txtSearchName) {
        this.txtSearchName=txtSearchName;
    }

    @JsonProperty("txtSearchHihokenshaNo")
    public TextBox getTxtSearchHihokenshaNo() {
        return txtSearchHihokenshaNo;
    }

    @JsonProperty("txtSearchHihokenshaNo")
    public void setTxtSearchHihokenshaNo(TextBox txtSearchHihokenshaNo) {
        this.txtSearchHihokenshaNo=txtSearchHihokenshaNo;
    }

    @JsonProperty("txtSearchShokisaiHokenshaNo")
    public TextBox getTxtSearchShokisaiHokenshaNo() {
        return txtSearchShokisaiHokenshaNo;
    }

    @JsonProperty("txtSearchShokisaiHokenshaNo")
    public void setTxtSearchShokisaiHokenshaNo(TextBox txtSearchShokisaiHokenshaNo) {
        this.txtSearchShokisaiHokenshaNo=txtSearchShokisaiHokenshaNo;
    }

    @JsonProperty("btnKyotakuServiceSearch")
    public Button getBtnKyotakuServiceSearch() {
        return btnKyotakuServiceSearch;
    }

    @JsonProperty("btnKyotakuServiceSearch")
    public void setBtnKyotakuServiceSearch(Button btnKyotakuServiceSearch) {
        this.btnKyotakuServiceSearch=btnKyotakuServiceSearch;
    }

}
