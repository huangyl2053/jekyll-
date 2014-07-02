package jp.co.ndensan.reams.db.dbz.divcontroller.entity.dbz0010000;
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
 * SogoShokaiKagoMoshitateKohi のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiKagoMoshitateKohiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKagoKohiJukyushaNo")
    private TextBoxCode txtKagoKohiJukyushaNo;
    @JsonProperty("txtKagoKohiJukyushaName")
    private TextBox txtKagoKohiJukyushaName;
    @JsonProperty("txtKagoKohiHokenshaNo")
    private TextBoxCode txtKagoKohiHokenshaNo;
    @JsonProperty("txtKagoKohiTanisu")
    private TextBoxNum txtKagoKohiTanisu;
    @JsonProperty("txtKagoKohiFutangaku")
    private TextBoxNum txtKagoKohiFutangaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKagoKohiJukyushaNo")
    public TextBoxCode getTxtKagoKohiJukyushaNo() {
        return txtKagoKohiJukyushaNo;
    }

    @JsonProperty("txtKagoKohiJukyushaNo")
    public void setTxtKagoKohiJukyushaNo(TextBoxCode txtKagoKohiJukyushaNo) {
        this.txtKagoKohiJukyushaNo=txtKagoKohiJukyushaNo;
    }

    @JsonProperty("txtKagoKohiJukyushaName")
    public TextBox getTxtKagoKohiJukyushaName() {
        return txtKagoKohiJukyushaName;
    }

    @JsonProperty("txtKagoKohiJukyushaName")
    public void setTxtKagoKohiJukyushaName(TextBox txtKagoKohiJukyushaName) {
        this.txtKagoKohiJukyushaName=txtKagoKohiJukyushaName;
    }

    @JsonProperty("txtKagoKohiHokenshaNo")
    public TextBoxCode getTxtKagoKohiHokenshaNo() {
        return txtKagoKohiHokenshaNo;
    }

    @JsonProperty("txtKagoKohiHokenshaNo")
    public void setTxtKagoKohiHokenshaNo(TextBoxCode txtKagoKohiHokenshaNo) {
        this.txtKagoKohiHokenshaNo=txtKagoKohiHokenshaNo;
    }

    @JsonProperty("txtKagoKohiTanisu")
    public TextBoxNum getTxtKagoKohiTanisu() {
        return txtKagoKohiTanisu;
    }

    @JsonProperty("txtKagoKohiTanisu")
    public void setTxtKagoKohiTanisu(TextBoxNum txtKagoKohiTanisu) {
        this.txtKagoKohiTanisu=txtKagoKohiTanisu;
    }

    @JsonProperty("txtKagoKohiFutangaku")
    public TextBoxNum getTxtKagoKohiFutangaku() {
        return txtKagoKohiFutangaku;
    }

    @JsonProperty("txtKagoKohiFutangaku")
    public void setTxtKagoKohiFutangaku(TextBoxNum txtKagoKohiFutangaku) {
        this.txtKagoKohiFutangaku=txtKagoKohiFutangaku;
    }

}
