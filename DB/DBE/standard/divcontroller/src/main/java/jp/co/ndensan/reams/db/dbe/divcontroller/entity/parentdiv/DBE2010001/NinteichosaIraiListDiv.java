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
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteichosaIraiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraiListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chosairaitaishoshaichiran")
    private chosairaitaishoshaichiranDiv chosairaitaishoshaichiran;
    @JsonProperty("chosairaiselect")
    private chosairaiselectDiv chosairaiselect;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchosairaitaishoshaichiran
     * @return chosairaitaishoshaichiran
     */
    @JsonProperty("chosairaitaishoshaichiran")
    public chosairaitaishoshaichiranDiv getChosairaitaishoshaichiran() {
        return chosairaitaishoshaichiran;
    }

    /*
     * setchosairaitaishoshaichiran
     * @param chosairaitaishoshaichiran chosairaitaishoshaichiran
     */
    @JsonProperty("chosairaitaishoshaichiran")
    public void setChosairaitaishoshaichiran(chosairaitaishoshaichiranDiv chosairaitaishoshaichiran) {
        this.chosairaitaishoshaichiran = chosairaitaishoshaichiran;
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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IYokaigoNinteiTaskListDiv getCcdTaskList() {
        return this.getChosairaitaishoshaichiran().getCcdTaskList();
    }

    @JsonIgnore
    public ButtonDownLoad getBtndataoutput() {
        return this.getChosairaiselect().getBtndataoutput();
    }

    @JsonIgnore
    public void  setBtndataoutput(ButtonDownLoad btndataoutput) {
        this.getChosairaiselect().setBtndataoutput(btndataoutput);
    }

    @JsonIgnore
    public Button getBtniraiauto() {
        return this.getChosairaiselect().getBtniraiauto();
    }

    @JsonIgnore
    public void  setBtniraiauto(Button btniraiauto) {
        this.getChosairaiselect().setBtniraiauto(btniraiauto);
    }

    @JsonIgnore
    public ButtonDownLoad getBtnchosadataoutput() {
        return this.getChosairaiselect().getBtnchosadataoutput();
    }

    @JsonIgnore
    public void  setBtnchosadataoutput(ButtonDownLoad btnchosadataoutput) {
        this.getChosairaiselect().setBtnchosadataoutput(btnchosadataoutput);
    }

    @JsonIgnore
    public ButtonDialog getBtnTaOutput() {
        return this.getChosairaiselect().getBtnTaOutput();
    }

    @JsonIgnore
    public void  setBtnTaOutput(ButtonDialog btnTaOutput) {
        this.getChosairaiselect().setBtnTaOutput(btnTaOutput);
    }

    // </editor-fold>
}
