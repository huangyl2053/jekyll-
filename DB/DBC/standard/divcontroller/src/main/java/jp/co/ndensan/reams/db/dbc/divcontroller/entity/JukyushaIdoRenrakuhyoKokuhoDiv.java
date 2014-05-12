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
 * JukyushaIdoRenrakuhyoKokuho のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoKokuhoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKokuhoHokenshaNo")
    private TextBoxCode txtKokuhoHokenshaNo;
    @JsonProperty("txtKokuhoHihokenshashoNo")
    private TextBoxCode txtKokuhoHihokenshashoNo;
    @JsonProperty("txtKokuhoKojinNo")
    private TextBoxCode txtKokuhoKojinNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKokuhoHokenshaNo")
    public TextBoxCode getTxtKokuhoHokenshaNo() {
        return txtKokuhoHokenshaNo;
    }

    @JsonProperty("txtKokuhoHokenshaNo")
    public void setTxtKokuhoHokenshaNo(TextBoxCode txtKokuhoHokenshaNo) {
        this.txtKokuhoHokenshaNo=txtKokuhoHokenshaNo;
    }

    @JsonProperty("txtKokuhoHihokenshashoNo")
    public TextBoxCode getTxtKokuhoHihokenshashoNo() {
        return txtKokuhoHihokenshashoNo;
    }

    @JsonProperty("txtKokuhoHihokenshashoNo")
    public void setTxtKokuhoHihokenshashoNo(TextBoxCode txtKokuhoHihokenshashoNo) {
        this.txtKokuhoHihokenshashoNo=txtKokuhoHihokenshashoNo;
    }

    @JsonProperty("txtKokuhoKojinNo")
    public TextBoxCode getTxtKokuhoKojinNo() {
        return txtKokuhoKojinNo;
    }

    @JsonProperty("txtKokuhoKojinNo")
    public void setTxtKokuhoKojinNo(TextBoxCode txtKokuhoKojinNo) {
        this.txtKokuhoKojinNo=txtKokuhoKojinNo;
    }

}
