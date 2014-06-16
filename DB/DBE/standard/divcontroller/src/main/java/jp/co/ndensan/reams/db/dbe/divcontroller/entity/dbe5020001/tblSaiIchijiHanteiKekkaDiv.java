package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tblSaiIchijiHanteiKekka のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblSaiIchijiHanteiKekkaDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ichigojiHantei")
    private ichigojiHanteiAttblSaiIchijiHanteiKekka ichigojiHantei;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public ButtonDialog getBtnIchigojijiHanteiKakunin() {
        return this.ichigojiHantei.getBtnIchigojijiHanteiKakunin();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ichigojiHantei")
    private ichigojiHanteiAttblSaiIchijiHanteiKekka getIchigojiHantei() {
        return ichigojiHantei;
    }

    @JsonProperty("ichigojiHantei")
    private void setIchigojiHantei(ichigojiHanteiAttblSaiIchijiHanteiKekka ichigojiHantei) {
        this.ichigojiHantei=ichigojiHantei;
    }

}
/**
 * ichigojiHantei のクラスファイル 
 * 
 * @author 自動生成
 */
class ichigojiHanteiAttblSaiIchijiHanteiKekka extends TableCell {
    @JsonProperty("btnIchigojijiHanteiKakunin")
    private ButtonDialog btnIchigojijiHanteiKakunin;

    @JsonProperty("btnIchigojijiHanteiKakunin")
    public ButtonDialog getBtnIchigojijiHanteiKakunin() {
        return btnIchigojijiHanteiKakunin;
    }

    @JsonProperty("btnIchigojijiHanteiKakunin")
    public void setBtnIchigojijiHanteiKakunin(ButtonDialog btnIchigojijiHanteiKakunin) {
        this.btnIchigojijiHanteiKakunin=btnIchigojijiHanteiKakunin;
    }

}
