package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.rirekishusei.RirekiShusei;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.rirekishusei.RirekiShusei.IRirekiShuseiDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoNinteiShinseiKihonJohoInput.IKaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiInput.INinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiInput.NinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiShinseiTodokedesha.INinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiShinseiTodokedesha.NinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinseisonotaJohoInput.IShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinseisonotaJohoInput.ShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ZenkaiNinteiKekkaJoho.IZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shujiiIryokikanandshujiiinput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RirekiShusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class RirekiShuseiDiv extends Panel implements IRirekiShuseiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdKaigoNinteiShinseiKihonJohoInput")
    private KaigoNinteiShinseiKihonJohoInputDiv ccdKaigoNinteiShinseiKihonJohoInput;
    @JsonProperty("ccdNinteiShinseiTodokedesha")
    private NinteiShinseiTodokedeshaDiv ccdNinteiShinseiTodokedesha;
    @JsonProperty("ccdShujiiIryokikanAndShujiiInput")
    private ShujiiIryokikanAndShujiiInputDiv ccdShujiiIryokikanAndShujiiInput;
    @JsonProperty("ccdNinteiJohoInput")
    private NinteiInputDiv ccdNinteiJohoInput;
    @JsonProperty("ccdZenkaiNinteiKekka")
    private ZenkaiNinteiKekkaJohoDiv ccdZenkaiNinteiKekka;
    @JsonProperty("ccdShinseiSonotaJohoInput")
    private ShinseiSonotaJohoInputDiv ccdShinseiSonotaJohoInput;
    @JsonProperty("btnChosaJokyo")
    private ButtonDialog btnChosaJokyo;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnCancel")
    private Button btnCancel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdKaigoNinteiShinseiKihonJohoInput")
    public IKaigoNinteiShinseiKihonJohoInputDiv getCcdKaigoNinteiShinseiKihonJohoInput() {
        return ccdKaigoNinteiShinseiKihonJohoInput;
    }

    @JsonProperty("ccdNinteiShinseiTodokedesha")
    public INinteiShinseiTodokedeshaDiv getCcdNinteiShinseiTodokedesha() {
        return ccdNinteiShinseiTodokedesha;
    }

    @JsonProperty("ccdShujiiIryokikanAndShujiiInput")
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryokikanAndShujiiInput() {
        return ccdShujiiIryokikanAndShujiiInput;
    }

    @JsonProperty("ccdNinteiJohoInput")
    public INinteiInputDiv getCcdNinteiJohoInput() {
        return ccdNinteiJohoInput;
    }

    @JsonProperty("ccdZenkaiNinteiKekka")
    public IZenkaiNinteiKekkaJohoDiv getCcdZenkaiNinteiKekka() {
        return ccdZenkaiNinteiKekka;
    }

    @JsonProperty("ccdShinseiSonotaJohoInput")
    public IShinseiSonotaJohoInputDiv getCcdShinseiSonotaJohoInput() {
        return ccdShinseiSonotaJohoInput;
    }

    @JsonProperty("btnChosaJokyo")
    public ButtonDialog getBtnChosaJokyo() {
        return btnChosaJokyo;
    }

    @JsonProperty("btnChosaJokyo")
    public void setBtnChosaJokyo(ButtonDialog btnChosaJokyo) {
        this.btnChosaJokyo=btnChosaJokyo;
    }

    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei=btnKakutei;
    }

    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel=btnCancel;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
