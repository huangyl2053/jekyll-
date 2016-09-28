package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RirekiShusei;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.IKaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.INinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.NinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.INinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.NinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.IShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.ShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho.IZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RirekiShusei のクラスファイル
 *
 * @author 自動生成
 */
public class RirekiShuseiDiv extends Panel implements IRirekiShuseiDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
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
    @JsonProperty("ShijiiIryokikanAndShijiiInput")
    private ShijiiIryokikanAndShijiiInputDiv ShijiiIryokikanAndShijiiInput;
    @JsonProperty("ChsaItakusakiAndChosainInput")
    private ChsaItakusakiAndChosainInputDiv ChsaItakusakiAndChosainInput;
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
    @JsonProperty("hdnShinseishoKanriNo")
    private RString hdnShinseishoKanriNo;
    @JsonProperty("hdnDisplayModeKey")
    private RString hdnDisplayModeKey;
    @JsonProperty("hdnKonkaiJohoSerialized")
    private RString hdnKonkaiJohoSerialized;
    @JsonProperty("hdnZenkaiJohoSerialized")
    private RString hdnZenkaiJohoSerialized;
    @JsonProperty("hdnJikaiJohoSerialized")
    private RString hdnJikaiJohoSerialized;
    @JsonProperty("hdnDeleteKey")
    private RString hdnDeleteKey;
    @JsonProperty("hdnSubGyomuCd")
    private RString hdnSubGyomuCd;
    @JsonProperty("hdnKonkaiJoho")
    private RString hdnKonkaiJoho;
    @JsonProperty("hdnZenkaiJoho")
    private RString hdnZenkaiJoho;
    @JsonProperty("hdnInput")
    private RString hdnInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdKaigoNinteiShinseiKihonJohoInput
     * @return ccdKaigoNinteiShinseiKihonJohoInput
     */
    @JsonProperty("ccdKaigoNinteiShinseiKihonJohoInput")
    public IKaigoNinteiShinseiKihonJohoInputDiv getCcdKaigoNinteiShinseiKihonJohoInput() {
        return ccdKaigoNinteiShinseiKihonJohoInput;
    }

    /*
     * getccdNinteiShinseiTodokedesha
     * @return ccdNinteiShinseiTodokedesha
     */
    @JsonProperty("ccdNinteiShinseiTodokedesha")
    public INinteiShinseiTodokedeshaDiv getCcdNinteiShinseiTodokedesha() {
        return ccdNinteiShinseiTodokedesha;
    }

    /*
     * getShijiiIryokikanAndShijiiInput
     * @return ShijiiIryokikanAndShijiiInput
     */
    @JsonProperty("ShijiiIryokikanAndShijiiInput")
    public ShijiiIryokikanAndShijiiInputDiv getShijiiIryokikanAndShijiiInput() {
        return ShijiiIryokikanAndShijiiInput;
    }

    /*
     * setShijiiIryokikanAndShijiiInput
     * @param ShijiiIryokikanAndShijiiInput ShijiiIryokikanAndShijiiInput
     */
    @JsonProperty("ShijiiIryokikanAndShijiiInput")
    public void setShijiiIryokikanAndShijiiInput(ShijiiIryokikanAndShijiiInputDiv ShijiiIryokikanAndShijiiInput) {
        this.ShijiiIryokikanAndShijiiInput = ShijiiIryokikanAndShijiiInput;
    }

    /*
     * getChsaItakusakiAndChosainInput
     * @return ChsaItakusakiAndChosainInput
     */
    @JsonProperty("ChsaItakusakiAndChosainInput")
    public ChsaItakusakiAndChosainInputDiv getChsaItakusakiAndChosainInput() {
        return ChsaItakusakiAndChosainInput;
    }

    /*
     * setChsaItakusakiAndChosainInput
     * @param ChsaItakusakiAndChosainInput ChsaItakusakiAndChosainInput
     */
    @JsonProperty("ChsaItakusakiAndChosainInput")
    public void setChsaItakusakiAndChosainInput(ChsaItakusakiAndChosainInputDiv ChsaItakusakiAndChosainInput) {
        this.ChsaItakusakiAndChosainInput = ChsaItakusakiAndChosainInput;
    }

    /*
     * getccdNinteiJohoInput
     * @return ccdNinteiJohoInput
     */
    @JsonProperty("ccdNinteiJohoInput")
    public INinteiInputDiv getCcdNinteiJohoInput() {
        return ccdNinteiJohoInput;
    }

    /*
     * getccdZenkaiNinteiKekka
     * @return ccdZenkaiNinteiKekka
     */
    @JsonProperty("ccdZenkaiNinteiKekka")
    public IZenkaiNinteiKekkaJohoDiv getCcdZenkaiNinteiKekka() {
        return ccdZenkaiNinteiKekka;
    }

    /*
     * getccdShinseiSonotaJohoInput
     * @return ccdShinseiSonotaJohoInput
     */
    @JsonProperty("ccdShinseiSonotaJohoInput")
    public IShinseiSonotaJohoInputDiv getCcdShinseiSonotaJohoInput() {
        return ccdShinseiSonotaJohoInput;
    }

    /*
     * getbtnChosaJokyo
     * @return btnChosaJokyo
     */
    @JsonProperty("btnChosaJokyo")
    public ButtonDialog getBtnChosaJokyo() {
        return btnChosaJokyo;
    }

    /*
     * setbtnChosaJokyo
     * @param btnChosaJokyo btnChosaJokyo
     */
    @JsonProperty("btnChosaJokyo")
    public void setBtnChosaJokyo(ButtonDialog btnChosaJokyo) {
        this.btnChosaJokyo = btnChosaJokyo;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
    }

    /*
     * gethdnShinseishoKanriNo
     * @return hdnShinseishoKanriNo
     */
    @JsonProperty("hdnShinseishoKanriNo")
    public RString getHdnShinseishoKanriNo() {
        return hdnShinseishoKanriNo;
    }

    /*
     * sethdnShinseishoKanriNo
     * @param hdnShinseishoKanriNo hdnShinseishoKanriNo
     */
    @JsonProperty("hdnShinseishoKanriNo")
    public void setHdnShinseishoKanriNo(RString hdnShinseishoKanriNo) {
        this.hdnShinseishoKanriNo = hdnShinseishoKanriNo;
    }

    /*
     * gethdnDisplayModeKey
     * @return hdnDisplayModeKey
     */
    @JsonProperty("hdnDisplayModeKey")
    public RString getHdnDisplayModeKey() {
        return hdnDisplayModeKey;
    }

    /*
     * sethdnDisplayModeKey
     * @param hdnDisplayModeKey hdnDisplayModeKey
     */
    @JsonProperty("hdnDisplayModeKey")
    public void setHdnDisplayModeKey(RString hdnDisplayModeKey) {
        this.hdnDisplayModeKey = hdnDisplayModeKey;
    }

    /*
     * gethdnKonkaiJohoSerialized
     * @return hdnKonkaiJohoSerialized
     */
    @JsonProperty("hdnKonkaiJohoSerialized")
    public RString getHdnKonkaiJohoSerialized() {
        return hdnKonkaiJohoSerialized;
    }

    /*
     * sethdnKonkaiJohoSerialized
     * @param hdnKonkaiJohoSerialized hdnKonkaiJohoSerialized
     */
    @JsonProperty("hdnKonkaiJohoSerialized")
    public void setHdnKonkaiJohoSerialized(RString hdnKonkaiJohoSerialized) {
        this.hdnKonkaiJohoSerialized = hdnKonkaiJohoSerialized;
    }

    /*
     * gethdnZenkaiJohoSerialized
     * @return hdnZenkaiJohoSerialized
     */
    @JsonProperty("hdnZenkaiJohoSerialized")
    public RString getHdnZenkaiJohoSerialized() {
        return hdnZenkaiJohoSerialized;
    }

    /*
     * sethdnZenkaiJohoSerialized
     * @param hdnZenkaiJohoSerialized hdnZenkaiJohoSerialized
     */
    @JsonProperty("hdnZenkaiJohoSerialized")
    public void setHdnZenkaiJohoSerialized(RString hdnZenkaiJohoSerialized) {
        this.hdnZenkaiJohoSerialized = hdnZenkaiJohoSerialized;
    }

    /*
     * gethdnJikaiJohoSerialized
     * @return hdnJikaiJohoSerialized
     */
    @JsonProperty("hdnJikaiJohoSerialized")
    public RString getHdnJikaiJohoSerialized() {
        return hdnJikaiJohoSerialized;
    }

    /*
     * sethdnJikaiJohoSerialized
     * @param hdnJikaiJohoSerialized hdnJikaiJohoSerialized
     */
    @JsonProperty("hdnJikaiJohoSerialized")
    public void setHdnJikaiJohoSerialized(RString hdnJikaiJohoSerialized) {
        this.hdnJikaiJohoSerialized = hdnJikaiJohoSerialized;
    }

    /*
     * gethdnDeleteKey
     * @return hdnDeleteKey
     */
    @JsonProperty("hdnDeleteKey")
    public RString getHdnDeleteKey() {
        return hdnDeleteKey;
    }

    /*
     * sethdnDeleteKey
     * @param hdnDeleteKey hdnDeleteKey
     */
    @JsonProperty("hdnDeleteKey")
    public void setHdnDeleteKey(RString hdnDeleteKey) {
        this.hdnDeleteKey = hdnDeleteKey;
    }

    /*
     * gethdnSubGyomuCd
     * @return hdnSubGyomuCd
     */
    @JsonProperty("hdnSubGyomuCd")
    public RString getHdnSubGyomuCd() {
        return hdnSubGyomuCd;
    }

    /*
     * sethdnSubGyomuCd
     * @param hdnSubGyomuCd hdnSubGyomuCd
     */
    @JsonProperty("hdnSubGyomuCd")
    public void setHdnSubGyomuCd(RString hdnSubGyomuCd) {
        this.hdnSubGyomuCd = hdnSubGyomuCd;
    }

    /*
     * gethdnKonkaiJoho
     * @return hdnKonkaiJoho
     */
    @JsonProperty("hdnKonkaiJoho")
    public RString getHdnKonkaiJoho() {
        return hdnKonkaiJoho;
    }

    /*
     * sethdnKonkaiJoho
     * @param hdnKonkaiJoho hdnKonkaiJoho
     */
    @JsonProperty("hdnKonkaiJoho")
    public void setHdnKonkaiJoho(RString hdnKonkaiJoho) {
        this.hdnKonkaiJoho = hdnKonkaiJoho;
    }

    /*
     * gethdnZenkaiJoho
     * @return hdnZenkaiJoho
     */
    @JsonProperty("hdnZenkaiJoho")
    public RString getHdnZenkaiJoho() {
        return hdnZenkaiJoho;
    }

    /*
     * sethdnZenkaiJoho
     * @param hdnZenkaiJoho hdnZenkaiJoho
     */
    @JsonProperty("hdnZenkaiJoho")
    public void setHdnZenkaiJoho(RString hdnZenkaiJoho) {
        this.hdnZenkaiJoho = hdnZenkaiJoho;
    }

    /*
     * gethdnInput
     * @return hdnInput
     */
    @JsonProperty("hdnInput")
    public RString getHdnInput() {
        return hdnInput;
    }

    /*
     * sethdnInput
     * @param hdnInput hdnInput
     */
    @JsonProperty("hdnInput")
    public void setHdnInput(RString hdnInput) {
        this.hdnInput = hdnInput;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryokikanAndShujiiInput() {
        return this.getShijiiIryokikanAndShijiiInput().getCcdShujiiIryokikanAndShujiiInput();
    }

    @JsonIgnore
    public IChosaItakusakiAndChosainInputDiv getCcdChosaItakusakiAndChosainInput() {
        return this.getChsaItakusakiAndChosainInput().getCcdChosaItakusakiAndChosainInput();
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
}
