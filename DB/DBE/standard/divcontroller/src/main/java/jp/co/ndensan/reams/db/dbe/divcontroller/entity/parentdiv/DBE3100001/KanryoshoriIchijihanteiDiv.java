package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3100001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KanryoshoriIchijihantei のクラスファイル 
 * 
 * @author 自動生成
 */
public class KanryoshoriIchijihanteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("IchijiHanteiShoriTaishoshaIchiran")
    private IchijiHanteiShoriTaishoshaIchiranDiv IchijiHanteiShoriTaishoshaIchiran;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("ichijiHanteiArgument")
    private RString ichijiHanteiArgument;
    @JsonProperty("ichijiHanteiResult")
    private RString ichijiHanteiResult;
    @JsonProperty("modeType")
    private RString modeType;
    @JsonProperty("ichijiHanteiKekka")
    private RString ichijiHanteiKekka;
    @JsonProperty("radStatusBefore")
    private RString radStatusBefore;
    @JsonProperty("txtMaxCountBefore")
    private RString txtMaxCountBefore;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * getichijiHanteiArgument
     * @return ichijiHanteiArgument
     */
    @JsonProperty("ichijiHanteiArgument")
    public RString getIchijiHanteiArgument() {
        return ichijiHanteiArgument;
    }

    /*
     * setichijiHanteiArgument
     * @param ichijiHanteiArgument ichijiHanteiArgument
     */
    @JsonProperty("ichijiHanteiArgument")
    public void setIchijiHanteiArgument(RString ichijiHanteiArgument) {
        this.ichijiHanteiArgument = ichijiHanteiArgument;
    }

    /*
     * getichijiHanteiResult
     * @return ichijiHanteiResult
     */
    @JsonProperty("ichijiHanteiResult")
    public RString getIchijiHanteiResult() {
        return ichijiHanteiResult;
    }

    /*
     * setichijiHanteiResult
     * @param ichijiHanteiResult ichijiHanteiResult
     */
    @JsonProperty("ichijiHanteiResult")
    public void setIchijiHanteiResult(RString ichijiHanteiResult) {
        this.ichijiHanteiResult = ichijiHanteiResult;
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
     * getradStatusBefore
     * @return radStatusBefore
     */
    @JsonProperty("radStatusBefore")
    public RString getRadStatusBefore() {
        return radStatusBefore;
    }

    /*
     * setradStatusBefore
     * @param radStatusBefore radStatusBefore
     */
    @JsonProperty("radStatusBefore")
    public void setRadStatusBefore(RString radStatusBefore) {
        this.radStatusBefore = radStatusBefore;
    }

    /*
     * gettxtMaxCountBefore
     * @return txtMaxCountBefore
     */
    @JsonProperty("txtMaxCountBefore")
    public RString getTxtMaxCountBefore() {
        return txtMaxCountBefore;
    }

    /*
     * settxtMaxCountBefore
     * @param txtMaxCountBefore txtMaxCountBefore
     */
    @JsonProperty("txtMaxCountBefore")
    public void setTxtMaxCountBefore(RString txtMaxCountBefore) {
        this.txtMaxCountBefore = txtMaxCountBefore;
    }

    // </editor-fold>
}
