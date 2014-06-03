package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoShokujiMeisaiH1503Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0800000.ShokanShikyuTorokuShomeishoShokujiMeisaiH1504Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShokanShikyuTorokuShomeishoShokujiMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuTorokuShomeishoShokujiMeisaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoShokujiMeisaiH1503")
    private ShokanShikyuTorokuShomeishoShokujiMeisaiH1503Div ShokanShikyuTorokuShomeishoShokujiMeisaiH1503;
    @JsonProperty("ShokanShikyuTorokuShomeishoShokujiMeisaiH1504")
    private ShokanShikyuTorokuShomeishoShokujiMeisaiH1504Div ShokanShikyuTorokuShomeishoShokujiMeisaiH1504;
    @JsonProperty("btnShokujihiKakutei")
    private Button btnShokujihiKakutei;
    @JsonProperty("txtShokujiSelectedIndex")
    private TextBox txtShokujiSelectedIndex;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuTorokuShomeishoShokujiMeisaiH1503")
    public ShokanShikyuTorokuShomeishoShokujiMeisaiH1503Div getShokanShikyuTorokuShomeishoShokujiMeisaiH1503() {
        return ShokanShikyuTorokuShomeishoShokujiMeisaiH1503;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShokujiMeisaiH1503")
    public void setShokanShikyuTorokuShomeishoShokujiMeisaiH1503(ShokanShikyuTorokuShomeishoShokujiMeisaiH1503Div ShokanShikyuTorokuShomeishoShokujiMeisaiH1503) {
        this.ShokanShikyuTorokuShomeishoShokujiMeisaiH1503=ShokanShikyuTorokuShomeishoShokujiMeisaiH1503;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShokujiMeisaiH1504")
    public ShokanShikyuTorokuShomeishoShokujiMeisaiH1504Div getShokanShikyuTorokuShomeishoShokujiMeisaiH1504() {
        return ShokanShikyuTorokuShomeishoShokujiMeisaiH1504;
    }

    @JsonProperty("ShokanShikyuTorokuShomeishoShokujiMeisaiH1504")
    public void setShokanShikyuTorokuShomeishoShokujiMeisaiH1504(ShokanShikyuTorokuShomeishoShokujiMeisaiH1504Div ShokanShikyuTorokuShomeishoShokujiMeisaiH1504) {
        this.ShokanShikyuTorokuShomeishoShokujiMeisaiH1504=ShokanShikyuTorokuShomeishoShokujiMeisaiH1504;
    }

    @JsonProperty("btnShokujihiKakutei")
    public Button getBtnShokujihiKakutei() {
        return btnShokujihiKakutei;
    }

    @JsonProperty("btnShokujihiKakutei")
    public void setBtnShokujihiKakutei(Button btnShokujihiKakutei) {
        this.btnShokujihiKakutei=btnShokujihiKakutei;
    }

    @JsonProperty("txtShokujiSelectedIndex")
    public TextBox getTxtShokujiSelectedIndex() {
        return txtShokujiSelectedIndex;
    }

    @JsonProperty("txtShokujiSelectedIndex")
    public void setTxtShokujiSelectedIndex(TextBox txtShokujiSelectedIndex) {
        this.txtShokujiSelectedIndex=txtShokujiSelectedIndex;
    }

}
