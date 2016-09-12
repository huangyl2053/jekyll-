package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4940001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.IKaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.KaigoNinteiAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.IKaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoninteiShikakuInfo.IKaigoninteiShikakuInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoninteiShikakuInfo.KaigoninteiShikakuInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.INinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.NinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.IShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.ShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho.IZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiShinseiTorokuTorikeshiShosai のクラスファイル
 *
 * @author 自動生成
 */
public class NinteiShinseiTorokuTorikeshiShosaiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnIryohokenGuide")
    private ButtonDialog btnIryohokenGuide;
    @JsonProperty("btnNyuinAndShisetsuNyusho")
    private ButtonDialog btnNyuinAndShisetsuNyusho;
    @JsonProperty("btnChosaJokyo")
    private ButtonDialog btnChosaJokyo;
    @JsonProperty("btnTainoJokyo")
    private ButtonDialog btnTainoJokyo;
    @JsonProperty("ShujiiAndShujiiIryoKikan")
    private ShujiiAndShujiiIryoKikanDiv ShujiiAndShujiiIryoKikan;
    @JsonProperty("ccdKaigoNinteiAtenaInfo")
    private KaigoNinteiAtenaInfoDiv ccdKaigoNinteiAtenaInfo;
    @JsonProperty("ccdKaigoNinteiShinseiKihon")
    private KaigoNinteiShinseiKihonJohoInputDiv ccdKaigoNinteiShinseiKihon;
    @JsonProperty("ccdZenkaiNinteiKekkaJoho")
    private ZenkaiNinteiKekkaJohoDiv ccdZenkaiNinteiKekkaJoho;
    @JsonProperty("ccdNinteiInput")
    private NinteiInputDiv ccdNinteiInput;
    @JsonProperty("ccdKaigoNinteiShikakuInfo")
    private KaigoninteiShikakuInfoDiv ccdKaigoNinteiShikakuInfo;
    @JsonProperty("ccdSonotaJoho")
    private ShinseiSonotaJohoInputDiv ccdSonotaJoho;
    @JsonProperty("hdnKaigoJimuCode")
    private RString hdnKaigoJimuCode;
    @JsonProperty("hdnKaigoNinteiCode")
    private RString hdnKaigoNinteiCode;
    @JsonProperty("hdnSyokikaMode")
    private RString hdnSyokikaMode;
    @JsonProperty("hdnShikibetsuKey")
    private RString hdnShikibetsuKey;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnIryohokenGuide
     * @return btnIryohokenGuide
     */
    @JsonProperty("btnIryohokenGuide")
    public ButtonDialog getBtnIryohokenGuide() {
        return btnIryohokenGuide;
    }

    /*
     * setbtnIryohokenGuide
     * @param btnIryohokenGuide btnIryohokenGuide
     */
    @JsonProperty("btnIryohokenGuide")
    public void setBtnIryohokenGuide(ButtonDialog btnIryohokenGuide) {
        this.btnIryohokenGuide = btnIryohokenGuide;
    }

    /*
     * getbtnNyuinAndShisetsuNyusho
     * @return btnNyuinAndShisetsuNyusho
     */
    @JsonProperty("btnNyuinAndShisetsuNyusho")
    public ButtonDialog getBtnNyuinAndShisetsuNyusho() {
        return btnNyuinAndShisetsuNyusho;
    }

    /*
     * setbtnNyuinAndShisetsuNyusho
     * @param btnNyuinAndShisetsuNyusho btnNyuinAndShisetsuNyusho
     */
    @JsonProperty("btnNyuinAndShisetsuNyusho")
    public void setBtnNyuinAndShisetsuNyusho(ButtonDialog btnNyuinAndShisetsuNyusho) {
        this.btnNyuinAndShisetsuNyusho = btnNyuinAndShisetsuNyusho;
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
     * getbtnTainoJokyo
     * @return btnTainoJokyo
     */
    @JsonProperty("btnTainoJokyo")
    public ButtonDialog getBtnTainoJokyo() {
        return btnTainoJokyo;
    }

    /*
     * setbtnTainoJokyo
     * @param btnTainoJokyo btnTainoJokyo
     */
    @JsonProperty("btnTainoJokyo")
    public void setBtnTainoJokyo(ButtonDialog btnTainoJokyo) {
        this.btnTainoJokyo = btnTainoJokyo;
    }

    /*
     * getShujiiAndShujiiIryoKikan
     * @return ShujiiAndShujiiIryoKikan
     */
    @JsonProperty("ShujiiAndShujiiIryoKikan")
    public ShujiiAndShujiiIryoKikanDiv getShujiiAndShujiiIryoKikan() {
        return ShujiiAndShujiiIryoKikan;
    }

    /*
     * setShujiiAndShujiiIryoKikan
     * @param ShujiiAndShujiiIryoKikan ShujiiAndShujiiIryoKikan
     */
    @JsonProperty("ShujiiAndShujiiIryoKikan")
    public void setShujiiAndShujiiIryoKikan(ShujiiAndShujiiIryoKikanDiv ShujiiAndShujiiIryoKikan) {
        this.ShujiiAndShujiiIryoKikan = ShujiiAndShujiiIryoKikan;
    }

    /*
     * getccdKaigoNinteiAtenaInfo
     * @return ccdKaigoNinteiAtenaInfo
     */
    @JsonProperty("ccdKaigoNinteiAtenaInfo")
    public IKaigoNinteiAtenaInfoDiv getCcdKaigoNinteiAtenaInfo() {
        return ccdKaigoNinteiAtenaInfo;
    }

    /*
     * getccdKaigoNinteiShinseiKihon
     * @return ccdKaigoNinteiShinseiKihon
     */
    @JsonProperty("ccdKaigoNinteiShinseiKihon")
    public IKaigoNinteiShinseiKihonJohoInputDiv getCcdKaigoNinteiShinseiKihon() {
        return ccdKaigoNinteiShinseiKihon;
    }

    /*
     * getccdZenkaiNinteiKekkaJoho
     * @return ccdZenkaiNinteiKekkaJoho
     */
    @JsonProperty("ccdZenkaiNinteiKekkaJoho")
    public IZenkaiNinteiKekkaJohoDiv getCcdZenkaiNinteiKekkaJoho() {
        return ccdZenkaiNinteiKekkaJoho;
    }

    /*
     * getccdNinteiInput
     * @return ccdNinteiInput
     */
    @JsonProperty("ccdNinteiInput")
    public INinteiInputDiv getCcdNinteiInput() {
        return ccdNinteiInput;
    }

    /*
     * getccdKaigoNinteiShikakuInfo
     * @return ccdKaigoNinteiShikakuInfo
     */
    @JsonProperty("ccdKaigoNinteiShikakuInfo")
    public IKaigoninteiShikakuInfoDiv getCcdKaigoNinteiShikakuInfo() {
        return ccdKaigoNinteiShikakuInfo;
    }

    /*
     * getccdSonotaJoho
     * @return ccdSonotaJoho
     */
    @JsonProperty("ccdSonotaJoho")
    public IShinseiSonotaJohoInputDiv getCcdSonotaJoho() {
        return ccdSonotaJoho;
    }

    /*
     * gethdnKaigoJimuCode
     * @return hdnKaigoJimuCode
     */
    @JsonProperty("hdnKaigoJimuCode")
    public RString getHdnKaigoJimuCode() {
        return hdnKaigoJimuCode;
    }

    /*
     * sethdnKaigoJimuCode
     * @param hdnKaigoJimuCode hdnKaigoJimuCode
     */
    @JsonProperty("hdnKaigoJimuCode")
    public void setHdnKaigoJimuCode(RString hdnKaigoJimuCode) {
        this.hdnKaigoJimuCode = hdnKaigoJimuCode;
    }

    /*
     * gethdnKaigoNinteiCode
     * @return hdnKaigoNinteiCode
     */
    @JsonProperty("hdnKaigoNinteiCode")
    public RString getHdnKaigoNinteiCode() {
        return hdnKaigoNinteiCode;
    }

    /*
     * sethdnKaigoNinteiCode
     * @param hdnKaigoNinteiCode hdnKaigoNinteiCode
     */
    @JsonProperty("hdnKaigoNinteiCode")
    public void setHdnKaigoNinteiCode(RString hdnKaigoNinteiCode) {
        this.hdnKaigoNinteiCode = hdnKaigoNinteiCode;
    }

    /*
     * gethdnSyokikaMode
     * @return hdnSyokikaMode
     */
    @JsonProperty("hdnSyokikaMode")
    public RString getHdnSyokikaMode() {
        return hdnSyokikaMode;
    }

    /*
     * sethdnSyokikaMode
     * @param hdnSyokikaMode hdnSyokikaMode
     */
    @JsonProperty("hdnSyokikaMode")
    public void setHdnSyokikaMode(RString hdnSyokikaMode) {
        this.hdnSyokikaMode = hdnSyokikaMode;
    }

    /*
     * gethdnShikibetsuKey
     * @return hdnShikibetsuKey
     */
    @JsonProperty("hdnShikibetsuKey")
    public RString getHdnShikibetsuKey() {
        return hdnShikibetsuKey;
    }

    /*
     * sethdnShikibetsuKey
     * @param hdnShikibetsuKey hdnShikibetsuKey
     */
    @JsonProperty("hdnShikibetsuKey")
    public void setHdnShikibetsuKey(RString hdnShikibetsuKey) {
        this.hdnShikibetsuKey = hdnShikibetsuKey;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryokikanAndShujiiInput() {
        return this.getShujiiAndShujiiIryoKikan().getCcdShujiiIryokikanAndShujiiInput();
    }

    // </editor-fold>
}
