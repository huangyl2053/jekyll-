package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IKoshinKakuninDialogDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KoshinKakuninDialog のクラスファイル 
 * 
 * @author 自動生成
 */
public class KoshinKakuninDialogDiv extends Panel implements IKoshinKakuninDialogDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblKoshinMassage")
    private Label lblKoshinMassage;
    @JsonProperty("btnYes")
    private Button btnYes;
    @JsonProperty("btnNo")
    private Button btnNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblKoshinMassage")
    public Label getLblKoshinMassage() {
        return lblKoshinMassage;
    }

    @JsonProperty("lblKoshinMassage")
    public void setLblKoshinMassage(Label lblKoshinMassage) {
        this.lblKoshinMassage=lblKoshinMassage;
    }

    @JsonProperty("btnYes")
    public Button getBtnYes() {
        return btnYes;
    }

    @JsonProperty("btnYes")
    public void setBtnYes(Button btnYes) {
        this.btnYes=btnYes;
    }

    @JsonProperty("btnNo")
    public Button getBtnNo() {
        return btnNo;
    }

    @JsonProperty("btnNo")
    public void setBtnNo(Button btnNo) {
        this.btnNo=btnNo;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
