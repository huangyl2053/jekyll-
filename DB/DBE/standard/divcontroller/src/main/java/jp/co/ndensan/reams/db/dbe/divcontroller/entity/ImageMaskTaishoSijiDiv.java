package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.tabImageJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ImageMaskTaishoSiji のクラスファイル 
 * 
 * @author 自動生成
 */
public class ImageMaskTaishoSijiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HihokenshaJoho")
    private KaigoHihokenshaJohoDiv HihokenshaJoho;
    @JsonProperty("tabImageJoho")
    private tabImageJohoDiv tabImageJoho;
    @JsonProperty("btnUpdate")
    private Button btnUpdate;
    @JsonProperty("btnCancel")
    private Button btnCancel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("HihokenshaJoho")
    public KaigoHihokenshaJohoDiv getHihokenshaJoho() {
        return HihokenshaJoho;
    }

    @JsonProperty("HihokenshaJoho")
    public void setHihokenshaJoho(KaigoHihokenshaJohoDiv HihokenshaJoho) {
        this.HihokenshaJoho=HihokenshaJoho;
    }

    @JsonProperty("tabImageJoho")
    public tabImageJohoDiv getTabImageJoho() {
        return tabImageJoho;
    }

    @JsonProperty("tabImageJoho")
    public void setTabImageJoho(tabImageJohoDiv tabImageJoho) {
        this.tabImageJoho=tabImageJoho;
    }

    @JsonProperty("btnUpdate")
    public Button getBtnUpdate() {
        return btnUpdate;
    }

    @JsonProperty("btnUpdate")
    public void setBtnUpdate(Button btnUpdate) {
        this.btnUpdate=btnUpdate;
    }

    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel=btnCancel;
    }

}
