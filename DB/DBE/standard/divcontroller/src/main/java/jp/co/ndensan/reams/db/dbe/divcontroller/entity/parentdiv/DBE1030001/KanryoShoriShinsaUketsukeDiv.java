package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KanryoShoriShinsaUketsuke のクラスファイル 
 * 
 * @author 自動生成
 */
public class KanryoShoriShinsaUketsukeDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteiShinseiJohoTorokuKanryo")
    private NinteiShinseiJohoTorokuKanryoDiv NinteiShinseiJohoTorokuKanryo;
    @JsonProperty("chosairaiselect")
    private chosairaiselectDiv chosairaiselect;
    @JsonProperty("KanryoMsg")
    private KanryoMsgDiv KanryoMsg;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNinteiShinseiJohoTorokuKanryo
     * @return NinteiShinseiJohoTorokuKanryo
     */
    @JsonProperty("NinteiShinseiJohoTorokuKanryo")
    public NinteiShinseiJohoTorokuKanryoDiv getNinteiShinseiJohoTorokuKanryo() {
        return NinteiShinseiJohoTorokuKanryo;
    }

    /*
     * setNinteiShinseiJohoTorokuKanryo
     * @param NinteiShinseiJohoTorokuKanryo NinteiShinseiJohoTorokuKanryo
     */
    @JsonProperty("NinteiShinseiJohoTorokuKanryo")
    public void setNinteiShinseiJohoTorokuKanryo(NinteiShinseiJohoTorokuKanryoDiv NinteiShinseiJohoTorokuKanryo) {
        this.NinteiShinseiJohoTorokuKanryo = NinteiShinseiJohoTorokuKanryo;
    }

    /*
     * getchosairaiselect
     * @return chosairaiselect
     */
    @JsonProperty("chosairaiselect")
    public chosairaiselectDiv getChosairaiselect() {
        return chosairaiselect;
    }

    /*
     * setchosairaiselect
     * @param chosairaiselect chosairaiselect
     */
    @JsonProperty("chosairaiselect")
    public void setChosairaiselect(chosairaiselectDiv chosairaiselect) {
        this.chosairaiselect = chosairaiselect;
    }

    /*
     * getKanryoMsg
     * @return KanryoMsg
     */
    @JsonProperty("KanryoMsg")
    public KanryoMsgDiv getKanryoMsg() {
        return KanryoMsg;
    }

    /*
     * setKanryoMsg
     * @param KanryoMsg KanryoMsg
     */
    @JsonProperty("KanryoMsg")
    public void setKanryoMsg(KanryoMsgDiv KanryoMsg) {
        this.KanryoMsg = KanryoMsg;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxNum getTxtCompleteCount() {
        return this.getNinteiShinseiJohoTorokuKanryo().getTxtCompleteCount();
    }

    @JsonIgnore
    public void  setTxtCompleteCount(TextBoxNum txtCompleteCount) {
        this.getNinteiShinseiJohoTorokuKanryo().setTxtCompleteCount(txtCompleteCount);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokensya() {
        return this.getNinteiShinseiJohoTorokuKanryo().getCcdHokensya();
    }

    @JsonIgnore
    public DataGrid<dgNinteiTaskList_Row> getDgNinteiTaskList() {
        return this.getNinteiShinseiJohoTorokuKanryo().getDgNinteiTaskList();
    }

    @JsonIgnore
    public void  setDgNinteiTaskList(DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList) {
        this.getNinteiShinseiJohoTorokuKanryo().setDgNinteiTaskList(dgNinteiTaskList);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxCount() {
        return this.getNinteiShinseiJohoTorokuKanryo().getTxtMaxCount();
    }

    @JsonIgnore
    public void  setTxtMaxCount(TextBoxNum txtMaxCount) {
        this.getNinteiShinseiJohoTorokuKanryo().setTxtMaxCount(txtMaxCount);
    }

    @JsonIgnore
    public ButtonDownLoad getDataoutput() {
        return this.getChosairaiselect().getDataoutput();
    }

    @JsonIgnore
    public void  setDataoutput(ButtonDownLoad Dataoutput) {
        this.getChosairaiselect().setDataoutput(Dataoutput);
    }

    @JsonIgnore
    public IKanryoMessageDiv getCcdKanryoMsg() {
        return this.getKanryoMsg().getCcdKanryoMsg();
    }

    // </editor-fold>
}
