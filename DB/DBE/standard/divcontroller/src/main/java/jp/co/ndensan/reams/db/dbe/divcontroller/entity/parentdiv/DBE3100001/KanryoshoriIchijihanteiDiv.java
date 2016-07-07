package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3100001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.IYokaigoNinteiTaskListDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDownLoad;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KanryoshoriIchijihantei のクラスファイル
 *
 * @author 自動生成
 */
public class KanryoshoriIchijihanteiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("IchijiHanteiIchiren")
    private IchijiHanteiIchirenDiv IchijiHanteiIchiren;
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
     * getIchijiHanteiIchiren
     * @return IchijiHanteiIchiren
     */
    @JsonProperty("IchijiHanteiIchiren")
    public IchijiHanteiIchirenDiv getIchijiHanteiIchiren() {
        return IchijiHanteiIchiren;
    }

    /*
     * setIchijiHanteiIchiren
     * @param IchijiHanteiIchiren IchijiHanteiIchiren
     */
    @JsonProperty("IchijiHanteiIchiren")
    public void setIchijiHanteiIchiren(IchijiHanteiIchirenDiv IchijiHanteiIchiren) {
        this.IchijiHanteiIchiren = IchijiHanteiIchiren;
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
    public IYokaigoNinteiTaskListDiv getCcdNinteiTaskList() {
        return this.getIchijiHanteiIchiren().getCcdNinteiTaskList();
    }

    @JsonIgnore
    public ButtonDownLoad getBtndataoutput() {
        return this.getChosairaiselect().getBtndataoutput();
    }

    @JsonIgnore
    public void setBtndataoutput(ButtonDownLoad btndataoutput) {
        this.getChosairaiselect().setBtndataoutput(btndataoutput);
    }

    @JsonIgnore
    public IKanryoMessageDiv getCcdKanryoMsg() {
        return this.getKanryoMsg().getCcdKanryoMsg();
    }

    // </editor-fold>
}
