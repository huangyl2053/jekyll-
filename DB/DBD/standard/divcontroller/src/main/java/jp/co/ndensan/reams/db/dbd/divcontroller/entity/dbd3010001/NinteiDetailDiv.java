package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.ButtonsBottomOfDetailDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.IryoHokenDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.NinteiResultDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.NinteichosaDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.ShujiiIkenshoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteiDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiDetailDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNinteiShinseiYMD")
    private TextBoxFlexibleDate txtNinteiShinseiYMD;
    @JsonProperty("txtNinteiShinseiKubunShinseiji")
    private TextBox txtNinteiShinseiKubunShinseiji;
    @JsonProperty("txtNinteiShinseiKubunHorei")
    private TextBox txtNinteiShinseiKubunHorei;
    @JsonProperty("txtNinteiShinseiYukoKubun")
    private TextBox txtNinteiShinseiYukoKubun;
    @JsonProperty("txtIchijiHanteiYMD")
    private TextBoxFlexibleDate txtIchijiHanteiYMD;
    @JsonProperty("txtIchijiHanteiResult")
    private TextBox txtIchijiHanteiResult;
    @JsonProperty("txtIchijiHanteiKanryoYMD")
    private TextBoxFlexibleDate txtIchijiHanteiKanryoYMD;
    @JsonProperty("NinteiResult")
    private NinteiResultDiv NinteiResult;
    @JsonProperty("Ninteichosa")
    private NinteichosaDiv Ninteichosa;
    @JsonProperty("ShujiiIkensho")
    private ShujiiIkenshoDiv ShujiiIkensho;
    @JsonProperty("IryoHoken")
    private IryoHokenDiv IryoHoken;
    @JsonProperty("ButtonsBottomOfDetail")
    private ButtonsBottomOfDetailDiv ButtonsBottomOfDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtNinteiShinseiYMD")
    public TextBoxFlexibleDate getTxtNinteiShinseiYMD() {
        return txtNinteiShinseiYMD;
    }

    @JsonProperty("txtNinteiShinseiYMD")
    public void setTxtNinteiShinseiYMD(TextBoxFlexibleDate txtNinteiShinseiYMD) {
        this.txtNinteiShinseiYMD=txtNinteiShinseiYMD;
    }

    @JsonProperty("txtNinteiShinseiKubunShinseiji")
    public TextBox getTxtNinteiShinseiKubunShinseiji() {
        return txtNinteiShinseiKubunShinseiji;
    }

    @JsonProperty("txtNinteiShinseiKubunShinseiji")
    public void setTxtNinteiShinseiKubunShinseiji(TextBox txtNinteiShinseiKubunShinseiji) {
        this.txtNinteiShinseiKubunShinseiji=txtNinteiShinseiKubunShinseiji;
    }

    @JsonProperty("txtNinteiShinseiKubunHorei")
    public TextBox getTxtNinteiShinseiKubunHorei() {
        return txtNinteiShinseiKubunHorei;
    }

    @JsonProperty("txtNinteiShinseiKubunHorei")
    public void setTxtNinteiShinseiKubunHorei(TextBox txtNinteiShinseiKubunHorei) {
        this.txtNinteiShinseiKubunHorei=txtNinteiShinseiKubunHorei;
    }

    @JsonProperty("txtNinteiShinseiYukoKubun")
    public TextBox getTxtNinteiShinseiYukoKubun() {
        return txtNinteiShinseiYukoKubun;
    }

    @JsonProperty("txtNinteiShinseiYukoKubun")
    public void setTxtNinteiShinseiYukoKubun(TextBox txtNinteiShinseiYukoKubun) {
        this.txtNinteiShinseiYukoKubun=txtNinteiShinseiYukoKubun;
    }

    @JsonProperty("txtIchijiHanteiYMD")
    public TextBoxFlexibleDate getTxtIchijiHanteiYMD() {
        return txtIchijiHanteiYMD;
    }

    @JsonProperty("txtIchijiHanteiYMD")
    public void setTxtIchijiHanteiYMD(TextBoxFlexibleDate txtIchijiHanteiYMD) {
        this.txtIchijiHanteiYMD=txtIchijiHanteiYMD;
    }

    @JsonProperty("txtIchijiHanteiResult")
    public TextBox getTxtIchijiHanteiResult() {
        return txtIchijiHanteiResult;
    }

    @JsonProperty("txtIchijiHanteiResult")
    public void setTxtIchijiHanteiResult(TextBox txtIchijiHanteiResult) {
        this.txtIchijiHanteiResult=txtIchijiHanteiResult;
    }

    @JsonProperty("txtIchijiHanteiKanryoYMD")
    public TextBoxFlexibleDate getTxtIchijiHanteiKanryoYMD() {
        return txtIchijiHanteiKanryoYMD;
    }

    @JsonProperty("txtIchijiHanteiKanryoYMD")
    public void setTxtIchijiHanteiKanryoYMD(TextBoxFlexibleDate txtIchijiHanteiKanryoYMD) {
        this.txtIchijiHanteiKanryoYMD=txtIchijiHanteiKanryoYMD;
    }

    @JsonProperty("NinteiResult")
    public NinteiResultDiv getNinteiResult() {
        return NinteiResult;
    }

    @JsonProperty("NinteiResult")
    public void setNinteiResult(NinteiResultDiv NinteiResult) {
        this.NinteiResult=NinteiResult;
    }

    @JsonProperty("Ninteichosa")
    public NinteichosaDiv getNinteichosa() {
        return Ninteichosa;
    }

    @JsonProperty("Ninteichosa")
    public void setNinteichosa(NinteichosaDiv Ninteichosa) {
        this.Ninteichosa=Ninteichosa;
    }

    @JsonProperty("ShujiiIkensho")
    public ShujiiIkenshoDiv getShujiiIkensho() {
        return ShujiiIkensho;
    }

    @JsonProperty("ShujiiIkensho")
    public void setShujiiIkensho(ShujiiIkenshoDiv ShujiiIkensho) {
        this.ShujiiIkensho=ShujiiIkensho;
    }

    @JsonProperty("IryoHoken")
    public IryoHokenDiv getIryoHoken() {
        return IryoHoken;
    }

    @JsonProperty("IryoHoken")
    public void setIryoHoken(IryoHokenDiv IryoHoken) {
        this.IryoHoken=IryoHoken;
    }

    @JsonProperty("ButtonsBottomOfDetail")
    public ButtonsBottomOfDetailDiv getButtonsBottomOfDetail() {
        return ButtonsBottomOfDetail;
    }

    @JsonProperty("ButtonsBottomOfDetail")
    public void setButtonsBottomOfDetail(ButtonsBottomOfDetailDiv ButtonsBottomOfDetail) {
        this.ButtonsBottomOfDetail=ButtonsBottomOfDetail;
    }

}
