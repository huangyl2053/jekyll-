package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.IDataOutputInfomationDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * DataOutputInfomation のクラスファイル 
 * 
 * @author 自動生成
 */
public class DataOutputInfomationDiv extends Panel implements IDataOutputInfomationDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("icnKanryo")
    private Icon icnKanryo;
    @JsonProperty("lblMessage")
    private Label lblMessage;
    @JsonProperty("btnKakunin")
    private Button btnKakunin;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("icnKanryo")
    public Icon getIcnKanryo() {
        return icnKanryo;
    }

    @JsonProperty("icnKanryo")
    public void setIcnKanryo(Icon icnKanryo) {
        this.icnKanryo=icnKanryo;
    }

    @JsonProperty("lblMessage")
    public Label getLblMessage() {
        return lblMessage;
    }

    @JsonProperty("lblMessage")
    public void setLblMessage(Label lblMessage) {
        this.lblMessage=lblMessage;
    }

    @JsonProperty("btnKakunin")
    public Button getBtnKakunin() {
        return btnKakunin;
    }

    @JsonProperty("btnKakunin")
    public void setBtnKakunin(Button btnKakunin) {
        this.btnKakunin=btnKakunin;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
