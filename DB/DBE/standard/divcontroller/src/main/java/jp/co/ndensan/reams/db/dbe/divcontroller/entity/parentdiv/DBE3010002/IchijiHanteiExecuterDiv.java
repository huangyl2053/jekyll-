package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJoho.IIchijiHanteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.INinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.NinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IchijiHanteiExecuter のクラスファイル 
 * 
 * @author 自動生成
 */
public class IchijiHanteiExecuterDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("shoriSelectPanel")
    private shoriSelectPanelDiv shoriSelectPanel;
    @JsonProperty("shinseishaInfo")
    private shinseishaInfoDiv shinseishaInfo;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("ccdHanteiKekka")
    private IchijiHanteiKekkaJohoDiv ccdHanteiKekka;
    @JsonProperty("hanteiMae")
    private RString hanteiMae;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getshoriSelectPanel
     * @return shoriSelectPanel
     */
    @JsonProperty("shoriSelectPanel")
    public shoriSelectPanelDiv getShoriSelectPanel() {
        return shoriSelectPanel;
    }

    /*
     * setshoriSelectPanel
     * @param shoriSelectPanel shoriSelectPanel
     */
    @JsonProperty("shoriSelectPanel")
    public void setShoriSelectPanel(shoriSelectPanelDiv shoriSelectPanel) {
        this.shoriSelectPanel = shoriSelectPanel;
    }

    /*
     * getshinseishaInfo
     * @return shinseishaInfo
     */
    @JsonProperty("shinseishaInfo")
    public shinseishaInfoDiv getShinseishaInfo() {
        return shinseishaInfo;
    }

    /*
     * setshinseishaInfo
     * @param shinseishaInfo shinseishaInfo
     */
    @JsonProperty("shinseishaInfo")
    public void setShinseishaInfo(shinseishaInfoDiv shinseishaInfo) {
        this.shinseishaInfo = shinseishaInfo;
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
     * getccdHanteiKekka
     * @return ccdHanteiKekka
     */
    @JsonProperty("ccdHanteiKekka")
    public IIchijiHanteiKekkaJohoDiv getCcdHanteiKekka() {
        return ccdHanteiKekka;
    }

    /*
     * gethanteiMae
     * @return hanteiMae
     */
    @JsonProperty("hanteiMae")
    public RString getHanteiMae() {
        return hanteiMae;
    }

    /*
     * sethanteiMae
     * @param hanteiMae hanteiMae
     */
    @JsonProperty("hanteiMae")
    public void setHanteiMae(RString hanteiMae) {
        this.hanteiMae = hanteiMae;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadShoriSelect() {
        return this.getShoriSelectPanel().getRadShoriSelect();
    }

    @JsonIgnore
    public void  setRadShoriSelect(RadioButton radShoriSelect) {
        this.getShoriSelectPanel().setRadShoriSelect(radShoriSelect);
    }

    @JsonIgnore
    public INinteiShinseishaKihonInfoDiv getCcdShinseishaInfo() {
        return this.getShinseishaInfo().getCcdShinseishaInfo();
    }

    // </editor-fold>
}
