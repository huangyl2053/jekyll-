package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IchijiHantei のクラスファイル 
 * 
 * @author 自動生成
 */
public class IchijiHanteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
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
    @JsonProperty("インデックス")
    private RString インデックス;
    @JsonProperty("ファイルID")
    private RString ファイルID;

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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public UploadPanel getUploadPanel() {
        return this.getTorikomiPanel().getUploadPanel();
    }

    @JsonIgnore
    public void  setUploadPanel(UploadPanel UploadPanel) {
        this.getTorikomiPanel().setUploadPanel(UploadPanel);
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
