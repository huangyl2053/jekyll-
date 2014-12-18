package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KashitsukekinKetteiShoninDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplKashitsukekinKettei のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplKashitsukekinKetteiDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKetteiShoninKubun")
    private TextBox txtKetteiShoninKubun;
    @JsonProperty("txtKetteiYMD")
    private TextBoxDate txtKetteiYMD;
    @JsonProperty("KashitsukekinKetteiShonin")
    private KashitsukekinKetteiShoninDiv KashitsukekinKetteiShonin;
    @JsonProperty("txtKetteiFushoninRiyu")
    private TextBox txtKetteiFushoninRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKetteiShoninKubun")
    public TextBox getTxtKetteiShoninKubun() {
        return txtKetteiShoninKubun;
    }

    @JsonProperty("txtKetteiShoninKubun")
    public void setTxtKetteiShoninKubun(TextBox txtKetteiShoninKubun) {
        this.txtKetteiShoninKubun=txtKetteiShoninKubun;
    }

    @JsonProperty("txtKetteiYMD")
    public TextBoxDate getTxtKetteiYMD() {
        return txtKetteiYMD;
    }

    @JsonProperty("txtKetteiYMD")
    public void setTxtKetteiYMD(TextBoxDate txtKetteiYMD) {
        this.txtKetteiYMD=txtKetteiYMD;
    }

    @JsonProperty("KashitsukekinKetteiShonin")
    public KashitsukekinKetteiShoninDiv getKashitsukekinKetteiShonin() {
        return KashitsukekinKetteiShonin;
    }

    @JsonProperty("KashitsukekinKetteiShonin")
    public void setKashitsukekinKetteiShonin(KashitsukekinKetteiShoninDiv KashitsukekinKetteiShonin) {
        this.KashitsukekinKetteiShonin=KashitsukekinKetteiShonin;
    }

    @JsonProperty("txtKetteiFushoninRiyu")
    public TextBox getTxtKetteiFushoninRiyu() {
        return txtKetteiFushoninRiyu;
    }

    @JsonProperty("txtKetteiFushoninRiyu")
    public void setTxtKetteiFushoninRiyu(TextBox txtKetteiFushoninRiyu) {
        this.txtKetteiFushoninRiyu=txtKetteiFushoninRiyu;
    }

}
