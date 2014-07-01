package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002;
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
 * NinteiResultIdo のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiResultIdoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("linShinsakaiIken")
    private HorizontalLine linShinsakaiIken;
    @JsonProperty("txtNinteiResultIdoJiyu")
    private TextBox txtNinteiResultIdoJiyu;
    @JsonProperty("txtNinteiResultIdoYMD")
    private TextBoxFlexibleDate txtNinteiResultIdoYMD;
    @JsonProperty("txtNinteiSoshitsuYMD")
    private TextBoxFlexibleDate txtNinteiSoshitsuYMD;
    @JsonProperty("linIdoJiyu")
    private HorizontalLine linIdoJiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("linShinsakaiIken")
    public HorizontalLine getLinShinsakaiIken() {
        return linShinsakaiIken;
    }

    @JsonProperty("linShinsakaiIken")
    public void setLinShinsakaiIken(HorizontalLine linShinsakaiIken) {
        this.linShinsakaiIken=linShinsakaiIken;
    }

    @JsonProperty("txtNinteiResultIdoJiyu")
    public TextBox getTxtNinteiResultIdoJiyu() {
        return txtNinteiResultIdoJiyu;
    }

    @JsonProperty("txtNinteiResultIdoJiyu")
    public void setTxtNinteiResultIdoJiyu(TextBox txtNinteiResultIdoJiyu) {
        this.txtNinteiResultIdoJiyu=txtNinteiResultIdoJiyu;
    }

    @JsonProperty("txtNinteiResultIdoYMD")
    public TextBoxFlexibleDate getTxtNinteiResultIdoYMD() {
        return txtNinteiResultIdoYMD;
    }

    @JsonProperty("txtNinteiResultIdoYMD")
    public void setTxtNinteiResultIdoYMD(TextBoxFlexibleDate txtNinteiResultIdoYMD) {
        this.txtNinteiResultIdoYMD=txtNinteiResultIdoYMD;
    }

    @JsonProperty("txtNinteiSoshitsuYMD")
    public TextBoxFlexibleDate getTxtNinteiSoshitsuYMD() {
        return txtNinteiSoshitsuYMD;
    }

    @JsonProperty("txtNinteiSoshitsuYMD")
    public void setTxtNinteiSoshitsuYMD(TextBoxFlexibleDate txtNinteiSoshitsuYMD) {
        this.txtNinteiSoshitsuYMD=txtNinteiSoshitsuYMD;
    }

    @JsonProperty("linIdoJiyu")
    public HorizontalLine getLinIdoJiyu() {
        return linIdoJiyu;
    }

    @JsonProperty("linIdoJiyu")
    public void setLinIdoJiyu(HorizontalLine linIdoJiyu) {
        this.linIdoJiyu=linIdoJiyu;
    }

}
