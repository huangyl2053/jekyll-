package jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuhiKashitsukekinInfo;
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
 * KashitsukeShinseiHoshoninKinmu のクラスファイル 
 * 
 * @author 自動生成
 */
public class KashitsukeShinseiHoshoninKinmuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHoshoninKinmuName")
    private TextBox txtHoshoninKinmuName;
    @JsonProperty("txtHoshoninKinmuTelNo")
    private TextBox txtHoshoninKinmuTelNo;
    @JsonProperty("txtHoshoninKinmuJusho")
    private TextBox txtHoshoninKinmuJusho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHoshoninKinmuName")
    public TextBox getTxtHoshoninKinmuName() {
        return txtHoshoninKinmuName;
    }

    @JsonProperty("txtHoshoninKinmuName")
    public void setTxtHoshoninKinmuName(TextBox txtHoshoninKinmuName) {
        this.txtHoshoninKinmuName=txtHoshoninKinmuName;
    }

    @JsonProperty("txtHoshoninKinmuTelNo")
    public TextBox getTxtHoshoninKinmuTelNo() {
        return txtHoshoninKinmuTelNo;
    }

    @JsonProperty("txtHoshoninKinmuTelNo")
    public void setTxtHoshoninKinmuTelNo(TextBox txtHoshoninKinmuTelNo) {
        this.txtHoshoninKinmuTelNo=txtHoshoninKinmuTelNo;
    }

    @JsonProperty("txtHoshoninKinmuJusho")
    public TextBox getTxtHoshoninKinmuJusho() {
        return txtHoshoninKinmuJusho;
    }

    @JsonProperty("txtHoshoninKinmuJusho")
    public void setTxtHoshoninKinmuJusho(TextBox txtHoshoninKinmuJusho) {
        this.txtHoshoninKinmuJusho=txtHoshoninKinmuJusho;
    }

}
