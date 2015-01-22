package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8110001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ChoshuYuyoTsuchiKobetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChoshuYuyoTsuchiKobetsuDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoshuYuyoHakkoYMD")
    private TextBoxDate txtChoshuYuyoHakkoYMD;
    @JsonProperty("lblChoshuYuyoTsuchiBunshoNo")
    private Label lblChoshuYuyoTsuchiBunshoNo;
    @JsonProperty("txtChoshuYuyoTsuchiBunshoNo")
    private TextBox txtChoshuYuyoTsuchiBunshoNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtChoshuYuyoHakkoYMD")
    public TextBoxDate getTxtChoshuYuyoHakkoYMD() {
        return txtChoshuYuyoHakkoYMD;
    }

    @JsonProperty("txtChoshuYuyoHakkoYMD")
    public void setTxtChoshuYuyoHakkoYMD(TextBoxDate txtChoshuYuyoHakkoYMD) {
        this.txtChoshuYuyoHakkoYMD=txtChoshuYuyoHakkoYMD;
    }

    @JsonProperty("lblChoshuYuyoTsuchiBunshoNo")
    public Label getLblChoshuYuyoTsuchiBunshoNo() {
        return lblChoshuYuyoTsuchiBunshoNo;
    }

    @JsonProperty("lblChoshuYuyoTsuchiBunshoNo")
    public void setLblChoshuYuyoTsuchiBunshoNo(Label lblChoshuYuyoTsuchiBunshoNo) {
        this.lblChoshuYuyoTsuchiBunshoNo=lblChoshuYuyoTsuchiBunshoNo;
    }

    @JsonProperty("txtChoshuYuyoTsuchiBunshoNo")
    public TextBox getTxtChoshuYuyoTsuchiBunshoNo() {
        return txtChoshuYuyoTsuchiBunshoNo;
    }

    @JsonProperty("txtChoshuYuyoTsuchiBunshoNo")
    public void setTxtChoshuYuyoTsuchiBunshoNo(TextBox txtChoshuYuyoTsuchiBunshoNo) {
        this.txtChoshuYuyoTsuchiBunshoNo=txtChoshuYuyoTsuchiBunshoNo;
    }

}
