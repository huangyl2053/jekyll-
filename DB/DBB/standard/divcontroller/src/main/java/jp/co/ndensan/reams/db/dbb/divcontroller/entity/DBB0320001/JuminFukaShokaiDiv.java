package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001;
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
 * JuminFukaShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class JuminFukaShokaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShikibetsuCodeJumin")
    private TextBoxCode txtShikibetsuCodeJumin;
    @JsonProperty("txtNameJumin")
    private TextBoxCode txtNameJumin;
    @JsonProperty("txtSetaiCodeJumin")
    private TextBox txtSetaiCodeJumin;
    @JsonProperty("txtHihokenshaNo")
    private TextBox txtHihokenshaNo;
    @JsonProperty("txtTsuchishoNo")
    private TextBox txtTsuchishoNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShikibetsuCodeJumin")
    public TextBoxCode getTxtShikibetsuCodeJumin() {
        return txtShikibetsuCodeJumin;
    }

    @JsonProperty("txtShikibetsuCodeJumin")
    public void setTxtShikibetsuCodeJumin(TextBoxCode txtShikibetsuCodeJumin) {
        this.txtShikibetsuCodeJumin=txtShikibetsuCodeJumin;
    }

    @JsonProperty("txtNameJumin")
    public TextBoxCode getTxtNameJumin() {
        return txtNameJumin;
    }

    @JsonProperty("txtNameJumin")
    public void setTxtNameJumin(TextBoxCode txtNameJumin) {
        this.txtNameJumin=txtNameJumin;
    }

    @JsonProperty("txtSetaiCodeJumin")
    public TextBox getTxtSetaiCodeJumin() {
        return txtSetaiCodeJumin;
    }

    @JsonProperty("txtSetaiCodeJumin")
    public void setTxtSetaiCodeJumin(TextBox txtSetaiCodeJumin) {
        this.txtSetaiCodeJumin=txtSetaiCodeJumin;
    }

    @JsonProperty("txtHihokenshaNo")
    public TextBox getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.txtHihokenshaNo=txtHihokenshaNo;
    }

    @JsonProperty("txtTsuchishoNo")
    public TextBox getTxtTsuchishoNo() {
        return txtTsuchishoNo;
    }

    @JsonProperty("txtTsuchishoNo")
    public void setTxtTsuchishoNo(TextBox txtTsuchishoNo) {
        this.txtTsuchishoNo=txtTsuchishoNo;
    }

}
