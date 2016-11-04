package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ccdSetaiKazei のクラスファイル 
 * 
 * @author 自動生成
 */
public class ccdSetaiKazeiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Header")
    private HeaderDiv Header;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHeader
     * @return Header
     */
    @JsonProperty("Header")
    public HeaderDiv getHeader() {
        return Header;
    }

    /*
     * setHeader
     * @param Header Header
     */
    @JsonProperty("Header")
    public void setHeader(HeaderDiv Header) {
        this.Header = Header;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getHeader().getLin1();
    }

    @JsonIgnore
    public void  setLin1(HorizontalLine lin1) {
        this.getHeader().setLin1(lin1);
    }

    @JsonIgnore
    public TextBox getTxtSetaiKazeiJokyo() {
        return this.getHeader().getTxtSetaiKazeiJokyo();
    }

    @JsonIgnore
    public void  setTxtSetaiKazeiJokyo(TextBox txtSetaiKazeiJokyo) {
        this.getHeader().setTxtSetaiKazeiJokyo(txtSetaiKazeiJokyo);
    }

    @JsonIgnore
    public Button getBtnShowSetaiJoho() {
        return this.getHeader().getBtnShowSetaiJoho();
    }

    @JsonIgnore
    public void  setBtnShowSetaiJoho(Button btnShowSetaiJoho) {
        this.getHeader().setBtnShowSetaiJoho(btnShowSetaiJoho);
    }

    @JsonIgnore
    public Button getBtnCloseSetaiJoho() {
        return this.getHeader().getBtnCloseSetaiJoho();
    }

    @JsonIgnore
    public void  setBtnCloseSetaiJoho(Button btnCloseSetaiJoho) {
        this.getHeader().setBtnCloseSetaiJoho(btnCloseSetaiJoho);
    }

    @JsonIgnore
    public ButtonDialog getBtnShowGemmenJoho() {
        return this.getHeader().getBtnShowGemmenJoho();
    }

    @JsonIgnore
    public void  setBtnShowGemmenJoho(ButtonDialog btnShowGemmenJoho) {
        this.getHeader().setBtnShowGemmenJoho(btnShowGemmenJoho);
    }

    @JsonIgnore
    public IKaigoShikakuKihonDiv getCcdKaigoKihon() {
        return this.getHeader().getCcdKaigoKihon();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getCcdAtenaInfo() {
        return this.getHeader().getCcdAtenaInfo();
    }

    // </editor-fold>
}
