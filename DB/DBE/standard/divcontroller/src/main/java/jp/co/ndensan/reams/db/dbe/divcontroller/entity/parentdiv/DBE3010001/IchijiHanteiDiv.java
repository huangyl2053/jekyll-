package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IchijiHantei のクラスファイル 
 * 
 * @author 自動生成
 */
public class IchijiHanteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("IchijiHanteiKensakuJoken")
    private IchijiHanteiKensakuJokenDiv IchijiHanteiKensakuJoken;
    @JsonProperty("IchijiHanteiShoriTaishoshaIchiran")
    private IchijiHanteiShoriTaishoshaIchiranDiv IchijiHanteiShoriTaishoshaIchiran;
    @JsonProperty("torikomiPanel")
    private torikomiPanelDiv torikomiPanel;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("インデックス")
    private RString インデックス;
    @JsonProperty("ファイルID")
    private RString ファイルID;
    @JsonProperty("modeType")
    private RString modeType;
    @JsonProperty("ichijiHanteiKekka")
    private RString ichijiHanteiKekka;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getIchijiHanteiKensakuJoken
     * @return IchijiHanteiKensakuJoken
     */
    @JsonProperty("IchijiHanteiKensakuJoken")
    public IchijiHanteiKensakuJokenDiv getIchijiHanteiKensakuJoken() {
        return IchijiHanteiKensakuJoken;
    }

    /*
     * setIchijiHanteiKensakuJoken
     * @param IchijiHanteiKensakuJoken IchijiHanteiKensakuJoken
     */
    @JsonProperty("IchijiHanteiKensakuJoken")
    public void setIchijiHanteiKensakuJoken(IchijiHanteiKensakuJokenDiv IchijiHanteiKensakuJoken) {
        this.IchijiHanteiKensakuJoken = IchijiHanteiKensakuJoken;
    }

    /*
     * getIchijiHanteiShoriTaishoshaIchiran
     * @return IchijiHanteiShoriTaishoshaIchiran
     */
    @JsonProperty("IchijiHanteiShoriTaishoshaIchiran")
    public IchijiHanteiShoriTaishoshaIchiranDiv getIchijiHanteiShoriTaishoshaIchiran() {
        return IchijiHanteiShoriTaishoshaIchiran;
    }

    /*
     * setIchijiHanteiShoriTaishoshaIchiran
     * @param IchijiHanteiShoriTaishoshaIchiran IchijiHanteiShoriTaishoshaIchiran
     */
    @JsonProperty("IchijiHanteiShoriTaishoshaIchiran")
    public void setIchijiHanteiShoriTaishoshaIchiran(IchijiHanteiShoriTaishoshaIchiranDiv IchijiHanteiShoriTaishoshaIchiran) {
        this.IchijiHanteiShoriTaishoshaIchiran = IchijiHanteiShoriTaishoshaIchiran;
    }

    /*
     * gettorikomiPanel
     * @return torikomiPanel
     */
    @JsonProperty("torikomiPanel")
    public torikomiPanelDiv getTorikomiPanel() {
        return torikomiPanel;
    }

    /*
     * settorikomiPanel
     * @param torikomiPanel torikomiPanel
     */
    @JsonProperty("torikomiPanel")
    public void setTorikomiPanel(torikomiPanelDiv torikomiPanel) {
        this.torikomiPanel = torikomiPanel;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * getインデックス
     * @return インデックス
     */
    @JsonProperty("インデックス")
    public RString getインデックス() {
        return インデックス;
    }

    /*
     * setインデックス
     * @param インデックス インデックス
     */
    @JsonProperty("インデックス")
    public void setインデックス(RString インデックス) {
        this.インデックス = インデックス;
    }

    /*
     * getファイルID
     * @return ファイルID
     */
    @JsonProperty("ファイルID")
    public RString getファイルID() {
        return ファイルID;
    }

    /*
     * setファイルID
     * @param ファイルID ファイルID
     */
    @JsonProperty("ファイルID")
    public void setファイルID(RString ファイルID) {
        this.ファイルID = ファイルID;
    }

    /*
     * getmodeType
     * @return modeType
     */
    @JsonProperty("modeType")
    public RString getModeType() {
        return modeType;
    }

    /*
     * setmodeType
     * @param modeType modeType
     */
    @JsonProperty("modeType")
    public void setModeType(RString modeType) {
        this.modeType = modeType;
    }

    /*
     * getichijiHanteiKekka
     * @return ichijiHanteiKekka
     */
    @JsonProperty("ichijiHanteiKekka")
    public RString getIchijiHanteiKekka() {
        return ichijiHanteiKekka;
    }

    /*
     * setichijiHanteiKekka
     * @param ichijiHanteiKekka ichijiHanteiKekka
     */
    @JsonProperty("ichijiHanteiKekka")
    public void setIchijiHanteiKekka(RString ichijiHanteiKekka) {
        this.ichijiHanteiKekka = ichijiHanteiKekka;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public UploadPanel getUplHanteiKekka() {
        return this.getTorikomiPanel().getUplHanteiKekka();
    }

    @JsonIgnore
    public void  setUplHanteiKekka(UploadPanel uplHanteiKekka) {
        this.getTorikomiPanel().setUplHanteiKekka(uplHanteiKekka);
    }

    @JsonIgnore
    public Button getUploadButton() {
        return this.getTorikomiPanel().getUploadButton();
    }

    @JsonIgnore
    public void  setUploadButton(Button uploadButton) {
        this.getTorikomiPanel().setUploadButton(uploadButton);
    }

    // </editor-fold>
}
