package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IKaigoBunshoBangoInputDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KaigoBunshoBangoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoBunshoBangoInputDiv extends Panel implements IKaigoBunshoBangoInputDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtBunshoShurui")
    private TextBox txtBunshoShurui;
    @JsonProperty("txtBunshoHeader")
    private TextBox txtBunshoHeader;
    @JsonProperty("txtBunshoNo")
    private TextBox txtBunshoNo;
    @JsonProperty("BunshoFoot")
    private TextBox BunshoFoot;
    @JsonProperty("btnBunshoNoGet")
    private Button btnBunshoNoGet;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtBunshoShurui")
    public TextBox getTxtBunshoShurui() {
        return txtBunshoShurui;
    }

    @JsonProperty("txtBunshoShurui")
    public void setTxtBunshoShurui(TextBox txtBunshoShurui) {
        this.txtBunshoShurui=txtBunshoShurui;
    }

    @JsonProperty("txtBunshoHeader")
    public TextBox getTxtBunshoHeader() {
        return txtBunshoHeader;
    }

    @JsonProperty("txtBunshoHeader")
    public void setTxtBunshoHeader(TextBox txtBunshoHeader) {
        this.txtBunshoHeader=txtBunshoHeader;
    }

    @JsonProperty("txtBunshoNo")
    public TextBox getTxtBunshoNo() {
        return txtBunshoNo;
    }

    @JsonProperty("txtBunshoNo")
    public void setTxtBunshoNo(TextBox txtBunshoNo) {
        this.txtBunshoNo=txtBunshoNo;
    }

    @JsonProperty("BunshoFoot")
    public TextBox getBunshoFoot() {
        return BunshoFoot;
    }

    @JsonProperty("BunshoFoot")
    public void setBunshoFoot(TextBox BunshoFoot) {
        this.BunshoFoot=BunshoFoot;
    }

    @JsonProperty("btnBunshoNoGet")
    public Button getBtnBunshoNoGet() {
        return btnBunshoNoGet;
    }

    @JsonProperty("btnBunshoNoGet")
    public void setBtnBunshoNoGet(Button btnBunshoNoGet) {
        this.btnBunshoNoGet=btnBunshoNoGet;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
