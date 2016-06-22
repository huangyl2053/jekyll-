package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.IYokaigoNinteiTaskListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.YokaigoNinteiTaskListDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteichosaIrai のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteichosaIraiList")
    private NinteichosaIraiListDiv NinteichosaIraiList;
    @JsonProperty("KanryoMsg")
    private KanryoMsgDiv KanryoMsg;
    @JsonProperty("hiddenIuputModel")
    private RString hiddenIuputModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNinteichosaIraiList
     * @return NinteichosaIraiList
     */
    @JsonProperty("NinteichosaIraiList")
    public NinteichosaIraiListDiv getNinteichosaIraiList() {
        return NinteichosaIraiList;
    }

    /*
     * setNinteichosaIraiList
     * @param NinteichosaIraiList NinteichosaIraiList
     */
    @JsonProperty("NinteichosaIraiList")
    public void setNinteichosaIraiList(NinteichosaIraiListDiv NinteichosaIraiList) {
        this.NinteichosaIraiList = NinteichosaIraiList;
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
     * gethiddenIuputModel
     * @return hiddenIuputModel
     */
    @JsonProperty("hiddenIuputModel")
    public RString getHiddenIuputModel() {
        return hiddenIuputModel;
    }

    /*
     * sethiddenIuputModel
     * @param hiddenIuputModel hiddenIuputModel
     */
    @JsonProperty("hiddenIuputModel")
    public void setHiddenIuputModel(RString hiddenIuputModel) {
        this.hiddenIuputModel = hiddenIuputModel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public chosairaitaishoshaichiranDiv getChosairaitaishoshaichiran() {
        return this.getNinteichosaIraiList().getChosairaitaishoshaichiran();
    }

    @JsonIgnore
    public void  setChosairaitaishoshaichiran(chosairaitaishoshaichiranDiv chosairaitaishoshaichiran) {
        this.getNinteichosaIraiList().setChosairaitaishoshaichiran(chosairaitaishoshaichiran);
    }

    @JsonIgnore
    public IYokaigoNinteiTaskListDiv getCcdTaskList() {
        return this.getNinteichosaIraiList().getChosairaitaishoshaichiran().getCcdTaskList();
    }

    @JsonIgnore
    public chosairaiselectDiv getChosairaiselect() {
        return this.getNinteichosaIraiList().getChosairaiselect();
    }

    @JsonIgnore
    public void  setChosairaiselect(chosairaiselectDiv chosairaiselect) {
        this.getNinteichosaIraiList().setChosairaiselect(chosairaiselect);
    }

    @JsonIgnore
    public ButtonDownLoad getBtndataoutput() {
        return this.getNinteichosaIraiList().getChosairaiselect().getBtndataoutput();
    }

    @JsonIgnore
    public void  setBtndataoutput(ButtonDownLoad btndataoutput) {
        this.getNinteichosaIraiList().getChosairaiselect().setBtndataoutput(btndataoutput);
    }

    @JsonIgnore
    public Button getBtniraiauto() {
        return this.getNinteichosaIraiList().getChosairaiselect().getBtniraiauto();
    }

    @JsonIgnore
    public void  setBtniraiauto(Button btniraiauto) {
        this.getNinteichosaIraiList().getChosairaiselect().setBtniraiauto(btniraiauto);
    }

    @JsonIgnore
    public ButtonDownLoad getBtnchosadataoutput() {
        return this.getNinteichosaIraiList().getChosairaiselect().getBtnchosadataoutput();
    }

    @JsonIgnore
    public void  setBtnchosadataoutput(ButtonDownLoad btnchosadataoutput) {
        this.getNinteichosaIraiList().getChosairaiselect().setBtnchosadataoutput(btnchosadataoutput);
    }

    @JsonIgnore
    public ButtonDialog getBtnTaOutput() {
        return this.getNinteichosaIraiList().getChosairaiselect().getBtnTaOutput();
    }

    @JsonIgnore
    public void  setBtnTaOutput(ButtonDialog btnTaOutput) {
        this.getNinteichosaIraiList().getChosairaiselect().setBtnTaOutput(btnTaOutput);
    }

    @JsonIgnore
    public IKanryoMessageDiv getCcdKanryoMsg() {
        return this.getKanryoMsg().getCcdKanryoMsg();
    }

    // </editor-fold>
}
