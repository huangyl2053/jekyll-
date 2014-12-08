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
 * KetteiTsuchiKobetsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class KetteiTsuchiKobetsuDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKetteiTsuchiHakkoYMD")
    private TextBoxDate txtKetteiTsuchiHakkoYMD;
    @JsonProperty("lblKetteiTsuchiBunshoNo")
    private Label lblKetteiTsuchiBunshoNo;
    @JsonProperty("txtKetteiTsuchiBunshoNo")
    private TextBox txtKetteiTsuchiBunshoNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKetteiTsuchiHakkoYMD")
    public TextBoxDate getTxtKetteiTsuchiHakkoYMD() {
        return txtKetteiTsuchiHakkoYMD;
    }

    @JsonProperty("txtKetteiTsuchiHakkoYMD")
    public void setTxtKetteiTsuchiHakkoYMD(TextBoxDate txtKetteiTsuchiHakkoYMD) {
        this.txtKetteiTsuchiHakkoYMD=txtKetteiTsuchiHakkoYMD;
    }

    @JsonProperty("lblKetteiTsuchiBunshoNo")
    public Label getLblKetteiTsuchiBunshoNo() {
        return lblKetteiTsuchiBunshoNo;
    }

    @JsonProperty("lblKetteiTsuchiBunshoNo")
    public void setLblKetteiTsuchiBunshoNo(Label lblKetteiTsuchiBunshoNo) {
        this.lblKetteiTsuchiBunshoNo=lblKetteiTsuchiBunshoNo;
    }

    @JsonProperty("txtKetteiTsuchiBunshoNo")
    public TextBox getTxtKetteiTsuchiBunshoNo() {
        return txtKetteiTsuchiBunshoNo;
    }

    @JsonProperty("txtKetteiTsuchiBunshoNo")
    public void setTxtKetteiTsuchiBunshoNo(TextBox txtKetteiTsuchiBunshoNo) {
        this.txtKetteiTsuchiBunshoNo=txtKetteiTsuchiBunshoNo;
    }

}
