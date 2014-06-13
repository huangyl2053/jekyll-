package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
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
 * SogoShokaiGenmenGengakuTecho のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiGenmenGengakuTechoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtGenmenTechoUmu")
    private TextBox txtGenmenTechoUmu;
    @JsonProperty("txtGenmenTechoTokyu")
    private TextBox txtGenmenTechoTokyu;
    @JsonProperty("txtGenmenTechoNo")
    private TextBox txtGenmenTechoNo;
    @JsonProperty("txtGenmenTechoKofuYMD")
    private TextBoxDate txtGenmenTechoKofuYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtGenmenTechoUmu")
    public TextBox getTxtGenmenTechoUmu() {
        return txtGenmenTechoUmu;
    }

    @JsonProperty("txtGenmenTechoUmu")
    public void setTxtGenmenTechoUmu(TextBox txtGenmenTechoUmu) {
        this.txtGenmenTechoUmu=txtGenmenTechoUmu;
    }

    @JsonProperty("txtGenmenTechoTokyu")
    public TextBox getTxtGenmenTechoTokyu() {
        return txtGenmenTechoTokyu;
    }

    @JsonProperty("txtGenmenTechoTokyu")
    public void setTxtGenmenTechoTokyu(TextBox txtGenmenTechoTokyu) {
        this.txtGenmenTechoTokyu=txtGenmenTechoTokyu;
    }

    @JsonProperty("txtGenmenTechoNo")
    public TextBox getTxtGenmenTechoNo() {
        return txtGenmenTechoNo;
    }

    @JsonProperty("txtGenmenTechoNo")
    public void setTxtGenmenTechoNo(TextBox txtGenmenTechoNo) {
        this.txtGenmenTechoNo=txtGenmenTechoNo;
    }

    @JsonProperty("txtGenmenTechoKofuYMD")
    public TextBoxDate getTxtGenmenTechoKofuYMD() {
        return txtGenmenTechoKofuYMD;
    }

    @JsonProperty("txtGenmenTechoKofuYMD")
    public void setTxtGenmenTechoKofuYMD(TextBoxDate txtGenmenTechoKofuYMD) {
        this.txtGenmenTechoKofuYMD=txtGenmenTechoKofuYMD;
    }

}
