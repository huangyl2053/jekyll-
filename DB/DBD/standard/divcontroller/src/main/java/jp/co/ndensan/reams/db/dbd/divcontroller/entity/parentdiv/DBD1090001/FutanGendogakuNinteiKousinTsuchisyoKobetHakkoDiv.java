package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FutanGendogakuNinteiKousinTsuchisyoKobetHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("LineHorizontal1")
    private HorizontalLine LineHorizontal1;
    @JsonProperty("btnShotaiJohou")
    private ButtonDialog btnShotaiJohou;
    @JsonProperty("HihokenshashoHakkoTaishoshaJoho")
    private HihokenshashoHakkoTaishoshaJohoDiv HihokenshashoHakkoTaishoshaJoho;
    @JsonProperty("ccdKaigoShikakuKihonDiv")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihonDiv;
    @JsonProperty("ccdKaigoAtenaInfoDiv")
    private KaigoAtenaInfoDiv ccdKaigoAtenaInfoDiv;
    @JsonProperty("listIndex")
    private RString listIndex;
    @JsonProperty("shikibetsuCode")
    private RString shikibetsuCode;
    @JsonProperty("nowDate")
    private RString nowDate;
    @JsonProperty("rirekiNo")
    private RString rirekiNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getLineHorizontal1
     * @return LineHorizontal1
     */
    @JsonProperty("LineHorizontal1")
    public HorizontalLine getLineHorizontal1() {
        return LineHorizontal1;
    }

    /*
     * setLineHorizontal1
     * @param LineHorizontal1 LineHorizontal1
     */
    @JsonProperty("LineHorizontal1")
    public void setLineHorizontal1(HorizontalLine LineHorizontal1) {
        this.LineHorizontal1 = LineHorizontal1;
    }

    /*
     * getbtnShotaiJohou
     * @return btnShotaiJohou
     */
    @JsonProperty("btnShotaiJohou")
    public ButtonDialog getBtnShotaiJohou() {
        return btnShotaiJohou;
    }

    /*
     * setbtnShotaiJohou
     * @param btnShotaiJohou btnShotaiJohou
     */
    @JsonProperty("btnShotaiJohou")
    public void setBtnShotaiJohou(ButtonDialog btnShotaiJohou) {
        this.btnShotaiJohou = btnShotaiJohou;
    }

    /*
     * getHihokenshashoHakkoTaishoshaJoho
     * @return HihokenshashoHakkoTaishoshaJoho
     */
    @JsonProperty("HihokenshashoHakkoTaishoshaJoho")
    public HihokenshashoHakkoTaishoshaJohoDiv getHihokenshashoHakkoTaishoshaJoho() {
        return HihokenshashoHakkoTaishoshaJoho;
    }

    /*
     * setHihokenshashoHakkoTaishoshaJoho
     * @param HihokenshashoHakkoTaishoshaJoho HihokenshashoHakkoTaishoshaJoho
     */
    @JsonProperty("HihokenshashoHakkoTaishoshaJoho")
    public void setHihokenshashoHakkoTaishoshaJoho(HihokenshashoHakkoTaishoshaJohoDiv HihokenshashoHakkoTaishoshaJoho) {
        this.HihokenshashoHakkoTaishoshaJoho = HihokenshashoHakkoTaishoshaJoho;
    }

    /*
     * getccdKaigoShikakuKihonDiv
     * @return ccdKaigoShikakuKihonDiv
     */
    @JsonProperty("ccdKaigoShikakuKihonDiv")
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihonDiv() {
        return ccdKaigoShikakuKihonDiv;
    }

    /*
     * getccdKaigoAtenaInfoDiv
     * @return ccdKaigoAtenaInfoDiv
     */
    @JsonProperty("ccdKaigoAtenaInfoDiv")
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfoDiv() {
        return ccdKaigoAtenaInfoDiv;
    }

    /*
     * getlistIndex
     * @return listIndex
     */
    @JsonProperty("listIndex")
    public RString getListIndex() {
        return listIndex;
    }

    /*
     * setlistIndex
     * @param listIndex listIndex
     */
    @JsonProperty("listIndex")
    public void setListIndex(RString listIndex) {
        this.listIndex = listIndex;
    }

    /*
     * getshikibetsuCode
     * @return shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    /*
     * setshikibetsuCode
     * @param shikibetsuCode shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public void setShikibetsuCode(RString shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /*
     * getnowDate
     * @return nowDate
     */
    @JsonProperty("nowDate")
    public RString getNowDate() {
        return nowDate;
    }

    /*
     * setnowDate
     * @param nowDate nowDate
     */
    @JsonProperty("nowDate")
    public void setNowDate(RString nowDate) {
        this.nowDate = nowDate;
    }

    /*
     * getrirekiNo
     * @return rirekiNo
     */
    @JsonProperty("rirekiNo")
    public RString getRirekiNo() {
        return rirekiNo;
    }

    /*
     * setrirekiNo
     * @param rirekiNo rirekiNo
     */
    @JsonProperty("rirekiNo")
    public void setRirekiNo(RString rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBttZenRireki() {
        return this.getHihokenshashoHakkoTaishoshaJoho().getZengoRireki().getBttZenRireki();
    }

    @JsonIgnore
    public void  setBttZenRireki(Button bttZenRireki) {
        this.getHihokenshashoHakkoTaishoshaJoho().getZengoRireki().setBttZenRireki(bttZenRireki);
    }

    @JsonIgnore
    public Button getBttGoRireki() {
        return this.getHihokenshashoHakkoTaishoshaJoho().getZengoRireki().getBttGoRireki();
    }

    @JsonIgnore
    public void  setBttGoRireki(Button bttGoRireki) {
        this.getHihokenshashoHakkoTaishoshaJoho().getZengoRireki().setBttGoRireki(bttGoRireki);
    }

    // </editor-fold>
}
