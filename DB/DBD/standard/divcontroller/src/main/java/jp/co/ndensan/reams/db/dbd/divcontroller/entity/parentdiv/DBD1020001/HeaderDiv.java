package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Header のクラスファイル 
 * 
 * @author 自動生成
 */
public class HeaderDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("txtSetaiKazeiJokyo")
    private TextBox txtSetaiKazeiJokyo;
    @JsonProperty("btnShowSetaiJoho")
    private Button btnShowSetaiJoho;
    @JsonProperty("btnCloseSetaiJoho")
    private Button btnCloseSetaiJoho;
    @JsonProperty("btnShowGemmenJoho")
    private ButtonDialog btnShowGemmenJoho;
    @JsonProperty("ccdKaigoKihon")
    private KaigoShikakuKihonDiv ccdKaigoKihon;
    @JsonProperty("ccdAtenaInfo")
    private KaigoAtenaInfoDiv ccdAtenaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * gettxtSetaiKazeiJokyo
     * @return txtSetaiKazeiJokyo
     */
    @JsonProperty("txtSetaiKazeiJokyo")
    public TextBox getTxtSetaiKazeiJokyo() {
        return txtSetaiKazeiJokyo;
    }

    /*
     * settxtSetaiKazeiJokyo
     * @param txtSetaiKazeiJokyo txtSetaiKazeiJokyo
     */
    @JsonProperty("txtSetaiKazeiJokyo")
    public void setTxtSetaiKazeiJokyo(TextBox txtSetaiKazeiJokyo) {
        this.txtSetaiKazeiJokyo = txtSetaiKazeiJokyo;
    }

    /*
     * getbtnShowSetaiJoho
     * @return btnShowSetaiJoho
     */
    @JsonProperty("btnShowSetaiJoho")
    public Button getBtnShowSetaiJoho() {
        return btnShowSetaiJoho;
    }

    /*
     * setbtnShowSetaiJoho
     * @param btnShowSetaiJoho btnShowSetaiJoho
     */
    @JsonProperty("btnShowSetaiJoho")
    public void setBtnShowSetaiJoho(Button btnShowSetaiJoho) {
        this.btnShowSetaiJoho = btnShowSetaiJoho;
    }

    /*
     * getbtnCloseSetaiJoho
     * @return btnCloseSetaiJoho
     */
    @JsonProperty("btnCloseSetaiJoho")
    public Button getBtnCloseSetaiJoho() {
        return btnCloseSetaiJoho;
    }

    /*
     * setbtnCloseSetaiJoho
     * @param btnCloseSetaiJoho btnCloseSetaiJoho
     */
    @JsonProperty("btnCloseSetaiJoho")
    public void setBtnCloseSetaiJoho(Button btnCloseSetaiJoho) {
        this.btnCloseSetaiJoho = btnCloseSetaiJoho;
    }

    /*
     * getbtnShowGemmenJoho
     * @return btnShowGemmenJoho
     */
    @JsonProperty("btnShowGemmenJoho")
    public ButtonDialog getBtnShowGemmenJoho() {
        return btnShowGemmenJoho;
    }

    /*
     * setbtnShowGemmenJoho
     * @param btnShowGemmenJoho btnShowGemmenJoho
     */
    @JsonProperty("btnShowGemmenJoho")
    public void setBtnShowGemmenJoho(ButtonDialog btnShowGemmenJoho) {
        this.btnShowGemmenJoho = btnShowGemmenJoho;
    }

    /*
     * getccdKaigoKihon
     * @return ccdKaigoKihon
     */
    @JsonProperty("ccdKaigoKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoKihon() {
        return ccdKaigoKihon;
    }

    /*
     * getccdAtenaInfo
     * @return ccdAtenaInfo
     */
    @JsonProperty("ccdAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdAtenaInfo() {
        return ccdAtenaInfo;
    }

    // </editor-fold>
}
