package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002.ChosaItakusakiAndChosainListDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002.RequestContentsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ninteichosaIraiListForByHandCom.NinteichosaIraiListForByHandCom;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tblChosaIraiWaritsuke のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblChosaIraiWaritsukeDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celMiwaritsuke")
    private celMiwaritsukeAttblChosaIraiWaritsuke celMiwaritsuke;
    @JsonProperty("celWaritsukezumi")
    private celWaritsukezumiAttblChosaIraiWaritsuke celWaritsukezumi;
    @JsonProperty("celButtons")
    private celButtonsAttblChosaIraiWaritsuke celButtons;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public NinteichosaIraiListForByHandCom getComMiwarituskeList() {
        return this.celMiwaritsuke.getComMiwarituskeList();
    }

    @JsonIgnore
    public ChosaItakusakiAndChosainListDiv getChosaItakusakiAndChosainList() {
        return this.celWaritsukezumi.getChosaItakusakiAndChosainList();
    }

    @JsonIgnore
    public RequestContentsDiv getRequestContents() {
        return this.celWaritsukezumi.getRequestContents();
    }

    @JsonIgnore
    public NinteichosaIraiListForByHandCom getComWaritukezumiList() {
        return this.celWaritsukezumi.getComWaritukezumiList();
    }

    @JsonIgnore
    public Space getSpaButtons1() {
        return this.celButtons.getSpaButtons1();
    }

    @JsonIgnore
    public Button getBtnToBind() {
        return this.celButtons.getBtnToBind();
    }

    @JsonIgnore
    public Space getSpaButtons2() {
        return this.celButtons.getSpaButtons2();
    }

    @JsonIgnore
    public Button getBtnToFree() {
        return this.celButtons.getBtnToFree();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celMiwaritsuke")
    private celMiwaritsukeAttblChosaIraiWaritsuke getCelMiwaritsuke() {
        return celMiwaritsuke;
    }

    @JsonProperty("celMiwaritsuke")
    private void setCelMiwaritsuke(celMiwaritsukeAttblChosaIraiWaritsuke celMiwaritsuke) {
        this.celMiwaritsuke=celMiwaritsuke;
    }

    @JsonProperty("celWaritsukezumi")
    private celWaritsukezumiAttblChosaIraiWaritsuke getCelWaritsukezumi() {
        return celWaritsukezumi;
    }

    @JsonProperty("celWaritsukezumi")
    private void setCelWaritsukezumi(celWaritsukezumiAttblChosaIraiWaritsuke celWaritsukezumi) {
        this.celWaritsukezumi=celWaritsukezumi;
    }

    @JsonProperty("celButtons")
    private celButtonsAttblChosaIraiWaritsuke getCelButtons() {
        return celButtons;
    }

    @JsonProperty("celButtons")
    private void setCelButtons(celButtonsAttblChosaIraiWaritsuke celButtons) {
        this.celButtons=celButtons;
    }

}
/**
 * celMiwaritsuke のクラスファイル 
 * 
 * @author 自動生成
 */
class celMiwaritsukeAttblChosaIraiWaritsuke extends TableCell {
    @JsonProperty("comMiwarituskeList")
    private NinteichosaIraiListForByHandCom comMiwarituskeList;

    @JsonProperty("comMiwarituskeList")
    public NinteichosaIraiListForByHandCom getComMiwarituskeList() {
        return comMiwarituskeList;
    }

    @JsonProperty("comMiwarituskeList")
    public void setComMiwarituskeList(NinteichosaIraiListForByHandCom comMiwarituskeList) {
        this.comMiwarituskeList=comMiwarituskeList;
    }

}
/**
 * celWaritsukezumi のクラスファイル 
 * 
 * @author 自動生成
 */
class celWaritsukezumiAttblChosaIraiWaritsuke extends TableCell {
    @JsonProperty("ChosaItakusakiAndChosainList")
    private ChosaItakusakiAndChosainListDiv ChosaItakusakiAndChosainList;
    @JsonProperty("RequestContents")
    private RequestContentsDiv RequestContents;
    @JsonProperty("comWaritukezumiList")
    private NinteichosaIraiListForByHandCom comWaritukezumiList;

    @JsonProperty("ChosaItakusakiAndChosainList")
    public ChosaItakusakiAndChosainListDiv getChosaItakusakiAndChosainList() {
        return ChosaItakusakiAndChosainList;
    }

    @JsonProperty("ChosaItakusakiAndChosainList")
    public void setChosaItakusakiAndChosainList(ChosaItakusakiAndChosainListDiv ChosaItakusakiAndChosainList) {
        this.ChosaItakusakiAndChosainList=ChosaItakusakiAndChosainList;
    }

    @JsonProperty("RequestContents")
    public RequestContentsDiv getRequestContents() {
        return RequestContents;
    }

    @JsonProperty("RequestContents")
    public void setRequestContents(RequestContentsDiv RequestContents) {
        this.RequestContents=RequestContents;
    }

    @JsonProperty("comWaritukezumiList")
    public NinteichosaIraiListForByHandCom getComWaritukezumiList() {
        return comWaritukezumiList;
    }

    @JsonProperty("comWaritukezumiList")
    public void setComWaritukezumiList(NinteichosaIraiListForByHandCom comWaritukezumiList) {
        this.comWaritukezumiList=comWaritukezumiList;
    }

}
/**
 * celButtons のクラスファイル 
 * 
 * @author 自動生成
 */
class celButtonsAttblChosaIraiWaritsuke extends TableCell {
    @JsonProperty("spaButtons1")
    private Space spaButtons1;
    @JsonProperty("btnToBind")
    private Button btnToBind;
    @JsonProperty("spaButtons2")
    private Space spaButtons2;
    @JsonProperty("btnToFree")
    private Button btnToFree;

    @JsonProperty("spaButtons1")
    public Space getSpaButtons1() {
        return spaButtons1;
    }

    @JsonProperty("spaButtons1")
    public void setSpaButtons1(Space spaButtons1) {
        this.spaButtons1=spaButtons1;
    }

    @JsonProperty("btnToBind")
    public Button getBtnToBind() {
        return btnToBind;
    }

    @JsonProperty("btnToBind")
    public void setBtnToBind(Button btnToBind) {
        this.btnToBind=btnToBind;
    }

    @JsonProperty("spaButtons2")
    public Space getSpaButtons2() {
        return spaButtons2;
    }

    @JsonProperty("spaButtons2")
    public void setSpaButtons2(Space spaButtons2) {
        this.spaButtons2=spaButtons2;
    }

    @JsonProperty("btnToFree")
    public Button getBtnToFree() {
        return btnToFree;
    }

    @JsonProperty("btnToFree")
    public void setBtnToFree(Button btnToFree) {
        this.btnToFree=btnToFree;
    }

}
