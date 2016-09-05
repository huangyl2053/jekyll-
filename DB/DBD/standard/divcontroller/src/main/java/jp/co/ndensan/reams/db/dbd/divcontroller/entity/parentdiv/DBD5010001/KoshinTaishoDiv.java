package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5010001;
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
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KoshinTaisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class KoshinTaishoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KoshinTaishoIchiran")
    private KoshinTaishoIchiranDiv KoshinTaishoIchiran;
    @JsonProperty("chosairaiselect")
    private chosairaiselectDiv chosairaiselect;
    @JsonProperty("pnlTsuchisho")
    private pnlTsuchishoDiv pnlTsuchisho;
    @JsonProperty("ccdChohyoShutsuryokuJun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokuJun;
    @JsonProperty("ccdKanryoMessege")
    private KanryoMessageDiv ccdKanryoMessege;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKoshinTaishoIchiran
     * @return KoshinTaishoIchiran
     */
    @JsonProperty("KoshinTaishoIchiran")
    public KoshinTaishoIchiranDiv getKoshinTaishoIchiran() {
        return KoshinTaishoIchiran;
    }

    /*
     * setKoshinTaishoIchiran
     * @param KoshinTaishoIchiran KoshinTaishoIchiran
     */
    @JsonProperty("KoshinTaishoIchiran")
    public void setKoshinTaishoIchiran(KoshinTaishoIchiranDiv KoshinTaishoIchiran) {
        this.KoshinTaishoIchiran = KoshinTaishoIchiran;
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
     * getpnlTsuchisho
     * @return pnlTsuchisho
     */
    @JsonProperty("pnlTsuchisho")
    public pnlTsuchishoDiv getPnlTsuchisho() {
        return pnlTsuchisho;
    }

    /*
     * setpnlTsuchisho
     * @param pnlTsuchisho pnlTsuchisho
     */
    @JsonProperty("pnlTsuchisho")
    public void setPnlTsuchisho(pnlTsuchishoDiv pnlTsuchisho) {
        this.pnlTsuchisho = pnlTsuchisho;
    }

    /*
     * getccdChohyoShutsuryokuJun
     * @return ccdChohyoShutsuryokuJun
     */
    @JsonProperty("ccdChohyoShutsuryokuJun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokuJun() {
        return ccdChohyoShutsuryokuJun;
    }

    /*
     * getccdKanryoMessege
     * @return ccdKanryoMessege
     */
    @JsonProperty("ccdKanryoMessege")
    public IKanryoMessageDiv getCcdKanryoMessege() {
        return ccdKanryoMessege;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IYokaigoNinteiTaskListDiv getCcdKoshinTaisho() {
        return this.getKoshinTaishoIchiran().getCcdKoshinTaisho();
    }

    @JsonIgnore
    public Button getBtndataoutput() {
        return this.getChosairaiselect().getBtndataoutput();
    }

    @JsonIgnore
    public void  setBtndataoutput(Button btndataoutput) {
        this.getChosairaiselect().setBtndataoutput(btndataoutput);
    }

    @JsonIgnore
    public CheckBoxList getChkOutPutSelect() {
        return this.getPnlTsuchisho().getChkOutPutSelect();
    }

    @JsonIgnore
    public void  setChkOutPutSelect(CheckBoxList chkOutPutSelect) {
        this.getPnlTsuchisho().setChkOutPutSelect(chkOutPutSelect);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKikan() {
        return this.getPnlTsuchisho().getTxtKikan();
    }

    @JsonIgnore
    public void  setTxtKikan(TextBoxDateRange txtKikan) {
        this.getPnlTsuchisho().setTxtKikan(txtKikan);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHakobi() {
        return this.getPnlTsuchisho().getTxtHakobi();
    }

    @JsonIgnore
    public void  setTxtHakobi(TextBoxFlexibleDate txtHakobi) {
        this.getPnlTsuchisho().setTxtHakobi(txtHakobi);
    }

    // </editor-fold>
}
