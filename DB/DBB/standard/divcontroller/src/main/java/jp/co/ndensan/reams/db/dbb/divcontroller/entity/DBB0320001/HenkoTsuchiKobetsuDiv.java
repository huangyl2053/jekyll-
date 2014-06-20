package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001;
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
 * HenkoTsuchiKobetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class HenkoTsuchiKobetsuDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHenkoTsuchiHakkoYMD")
    private TextBoxDate txtHenkoTsuchiHakkoYMD;
    @JsonProperty("lblHenkoTsuchiBunshoNo")
    private Label lblHenkoTsuchiBunshoNo;
    @JsonProperty("txtHenkoTsuchiBunshoNo")
    private TextBox txtHenkoTsuchiBunshoNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHenkoTsuchiHakkoYMD")
    public TextBoxDate getTxtHenkoTsuchiHakkoYMD() {
        return txtHenkoTsuchiHakkoYMD;
    }

    @JsonProperty("txtHenkoTsuchiHakkoYMD")
    public void setTxtHenkoTsuchiHakkoYMD(TextBoxDate txtHenkoTsuchiHakkoYMD) {
        this.txtHenkoTsuchiHakkoYMD=txtHenkoTsuchiHakkoYMD;
    }

    @JsonProperty("lblHenkoTsuchiBunshoNo")
    public Label getLblHenkoTsuchiBunshoNo() {
        return lblHenkoTsuchiBunshoNo;
    }

    @JsonProperty("lblHenkoTsuchiBunshoNo")
    public void setLblHenkoTsuchiBunshoNo(Label lblHenkoTsuchiBunshoNo) {
        this.lblHenkoTsuchiBunshoNo=lblHenkoTsuchiBunshoNo;
    }

    @JsonProperty("txtHenkoTsuchiBunshoNo")
    public TextBox getTxtHenkoTsuchiBunshoNo() {
        return txtHenkoTsuchiBunshoNo;
    }

    @JsonProperty("txtHenkoTsuchiBunshoNo")
    public void setTxtHenkoTsuchiBunshoNo(TextBox txtHenkoTsuchiBunshoNo) {
        this.txtHenkoTsuchiBunshoNo=txtHenkoTsuchiBunshoNo;
    }

}
