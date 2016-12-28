package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001;
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
 * NinteichosaKekkaNyushu のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaKekkaNyushuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ninteichosakekkainput")
    private ninteichosakekkainputDiv ninteichosakekkainput;
    @JsonProperty("KanryoMsg")
    private KanryoMsgDiv KanryoMsg;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getninteichosakekkainput
     * @return ninteichosakekkainput
     */
    @JsonProperty("ninteichosakekkainput")
    public ninteichosakekkainputDiv getNinteichosakekkainput() {
        return ninteichosakekkainput;
    }

    /*
     * setninteichosakekkainput
     * @param ninteichosakekkainput ninteichosakekkainput
     */
    @JsonProperty("ninteichosakekkainput")
    public void setNinteichosakekkainput(ninteichosakekkainputDiv ninteichosakekkainput) {
        this.ninteichosakekkainput = ninteichosakekkainput;
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
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getNinteichosakekkainput().getCcdHokenshaList();
    }

    @JsonIgnore
    public RadioButton getRadJotaiKubun() {
        return this.getNinteichosakekkainput().getRadJotaiKubun();
    }

    @JsonIgnore
    public void  setRadJotaiKubun(RadioButton radJotaiKubun) {
        this.getNinteichosakekkainput().setRadJotaiKubun(radJotaiKubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtGokei() {
        return this.getNinteichosakekkainput().getTxtGokei();
    }

    @JsonIgnore
    public void  setTxtGokei(TextBoxNum txtGokei) {
        this.getNinteichosakekkainput().setTxtGokei(txtGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtKanryoKano() {
        return this.getNinteichosakekkainput().getTxtKanryoKano();
    }

    @JsonIgnore
    public void  setTxtKanryoKano(TextBoxNum txtKanryoKano) {
        this.getNinteichosakekkainput().setTxtKanryoKano(txtKanryoKano);
    }

    @JsonIgnore
    public TextBoxNum getTxtMishori() {
        return this.getNinteichosakekkainput().getTxtMishori();
    }

    @JsonIgnore
    public void  setTxtMishori(TextBoxNum txtMishori) {
        this.getNinteichosakekkainput().setTxtMishori(txtMishori);
    }

    @JsonIgnore
    public DataGrid<dgNinteiTaskList_Row> getDgNinteiTaskList() {
        return this.getNinteichosakekkainput().getDgNinteiTaskList();
    }

    @JsonIgnore
    public void  setDgNinteiTaskList(DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList) {
        this.getNinteichosakekkainput().setDgNinteiTaskList(dgNinteiTaskList);
    }

    @JsonIgnore
    public ButtonDownLoad getBtnchosakekkaoutput() {
        return this.getNinteichosakekkainput().getBtnchosakekkaoutput();
    }

    @JsonIgnore
    public void  setBtnchosakekkaoutput(ButtonDownLoad btnchosakekkaoutput) {
        this.getNinteichosakekkainput().setBtnchosakekkaoutput(btnchosakekkaoutput);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxKensu() {
        return this.getNinteichosakekkainput().getTxtMaxKensu();
    }

    @JsonIgnore
    public void  setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.getNinteichosakekkainput().setTxtMaxKensu(txtMaxKensu);
    }

    @JsonIgnore
    public IKanryoMessageDiv getCcdKanryoMsg() {
        return this.getKanryoMsg().getCcdKanryoMsg();
    }

    // </editor-fold>
}
