package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.JushochiTokureiDialogButton.IJushochiTokureiDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.JushochiTokureiDialogButton.JushochiTokureiDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShikakuHenkoRirekiDialogButton.IShikakuHenkoRirekiDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShikakuHenkoRirekiDialogButton.ShikakuHenkoRirekiDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoDialogButton.IShisetsuNyutaishoDialogButtonDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoDialogButton.ShisetsuNyutaishoDialogButtonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HihokenshaShisakuPanal のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaShisakuPanalDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KihonJoho")
    private KihonJohoDiv KihonJoho;
    @JsonProperty("ShikakuShosai")
    private ShikakuShosaiDiv ShikakuShosai;
    @JsonProperty("HiddenDonyuKeitaiCode")
    private RString HiddenDonyuKeitaiCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKihonJoho
     * @return KihonJoho
     */
    @JsonProperty("KihonJoho")
    public KihonJohoDiv getKihonJoho() {
        return KihonJoho;
    }

    /*
     * setKihonJoho
     * @param KihonJoho KihonJoho
     */
    @JsonProperty("KihonJoho")
    public void setKihonJoho(KihonJohoDiv KihonJoho) {
        this.KihonJoho = KihonJoho;
    }

    /*
     * getShikakuShosai
     * @return ShikakuShosai
     */
    @JsonProperty("ShikakuShosai")
    public ShikakuShosaiDiv getShikakuShosai() {
        return ShikakuShosai;
    }

    /*
     * setShikakuShosai
     * @param ShikakuShosai ShikakuShosai
     */
    @JsonProperty("ShikakuShosai")
    public void setShikakuShosai(ShikakuShosaiDiv ShikakuShosai) {
        this.ShikakuShosai = ShikakuShosai;
    }

    /*
     * getHiddenDonyuKeitaiCode
     * @return HiddenDonyuKeitaiCode
     */
    @JsonProperty("HiddenDonyuKeitaiCode")
    public RString getHiddenDonyuKeitaiCode() {
        return HiddenDonyuKeitaiCode;
    }

    /*
     * setHiddenDonyuKeitaiCode
     * @param HiddenDonyuKeitaiCode HiddenDonyuKeitaiCode
     */
    @JsonProperty("HiddenDonyuKeitaiCode")
    public void setHiddenDonyuKeitaiCode(RString HiddenDonyuKeitaiCode) {
        this.HiddenDonyuKeitaiCode = HiddenDonyuKeitaiCode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return this.getKihonJoho().getCcdKaigoShikakuKihon();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return this.getKihonJoho().getCcdKaigoAtenaInfo();
    }

    @JsonIgnore
    public tblShikakuShosaiDiv getTblShikakuShosai() {
        return this.getShikakuShosai().getTblShikakuShosai();
    }

    @JsonIgnore
    public void  setTblShikakuShosai(tblShikakuShosaiDiv tblShikakuShosai) {
        this.getShikakuShosai().setTblShikakuShosai(tblShikakuShosai);
    }

    @JsonIgnore
    public Label getLblShutokuDate() {
        return this.getShikakuShosai().getTblShikakuShosai().getLblShutokuDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShutokuDate() {
        return this.getShikakuShosai().getTblShikakuShosai().getTxtShutokuDate();
    }

    @JsonIgnore
    public Label getLblShutokuTodokedeDate() {
        return this.getShikakuShosai().getTblShikakuShosai().getLblShutokuTodokedeDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShutokuTodokedeDate() {
        return this.getShikakuShosai().getTblShikakuShosai().getTxtShutokuTodokedeDate();
    }

    @JsonIgnore
    public Label getLblShutokuJiyu() {
        return this.getShikakuShosai().getTblShikakuShosai().getLblShutokuJiyu();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuJiyu() {
        return this.getShikakuShosai().getTblShikakuShosai().getDdlShutokuJiyu();
    }

    @JsonIgnore
    public Label getLblHihoKubun() {
        return this.getShikakuShosai().getTblShikakuShosai().getLblHihoKubun();
    }

    @JsonIgnore
    public DropDownList getDdlHihoKubun() {
        return this.getShikakuShosai().getTblShikakuShosai().getDdlHihoKubun();
    }

    @JsonIgnore
    public Label getLblShutokuShozaiHokensha() {
        return this.getShikakuShosai().getTblShikakuShosai().getLblShutokuShozaiHokensha();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuShozaiHokensha() {
        return this.getShikakuShosai().getTblShikakuShosai().getDdlShutokuShozaiHokensha();
    }

    @JsonIgnore
    public Label getLblShutokuSochimotoHokensha() {
        return this.getShikakuShosai().getTblShikakuShosai().getLblShutokuSochimotoHokensha();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuSochimotoHokensha() {
        return this.getShikakuShosai().getTblShikakuShosai().getDdlShutokuSochimotoHokensha();
    }

    @JsonIgnore
    public Label getLblKyuHokensha() {
        return this.getShikakuShosai().getTblShikakuShosai().getLblKyuHokensha();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuKyuHokensha() {
        return this.getShikakuShosai().getTblShikakuShosai().getDdlShutokuKyuHokensha();
    }

    @JsonIgnore
    public Label getLblShutokuShoriDate() {
        return this.getShikakuShosai().getTblShikakuShosai().getLblShutokuShoriDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShutokuShoriDate() {
        return this.getShikakuShosai().getTblShikakuShosai().getTxtShutokuShoriDate();
    }

    @JsonIgnore
    public Label getLblSoshitsuDate() {
        return this.getShikakuShosai().getTblShikakuShosai().getLblSoshitsuDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSoshitsuDate() {
        return this.getShikakuShosai().getTblShikakuShosai().getTxtSoshitsuDate();
    }

    @JsonIgnore
    public Label getLblSoshitsuTodokedeDate() {
        return this.getShikakuShosai().getTblShikakuShosai().getLblSoshitsuTodokedeDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSoshitsuTodokedeDate() {
        return this.getShikakuShosai().getTblShikakuShosai().getTxtSoshitsuTodokedeDate();
    }

    @JsonIgnore
    public Label getLblSoshitsuJiyu() {
        return this.getShikakuShosai().getTblShikakuShosai().getLblSoshitsuJiyu();
    }

    @JsonIgnore
    public DropDownList getDdlSoshitsuJiyu() {
        return this.getShikakuShosai().getTblShikakuShosai().getDdlSoshitsuJiyu();
    }

    @JsonIgnore
    public Label getLblSoshitsuShoriDate() {
        return this.getShikakuShosai().getTblShikakuShosai().getLblSoshitsuShoriDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSoshitsuShoriDate() {
        return this.getShikakuShosai().getTblShikakuShosai().getTxtSoshitsuShoriDate();
    }

    @JsonIgnore
    public ShikakuShosaiDialogsDiv getShikakuShosaiDialogs() {
        return this.getShikakuShosai().getShikakuShosaiDialogs();
    }

    @JsonIgnore
    public void  setShikakuShosaiDialogs(ShikakuShosaiDialogsDiv ShikakuShosaiDialogs) {
        this.getShikakuShosai().setShikakuShosaiDialogs(ShikakuShosaiDialogs);
    }

    @JsonIgnore
    public IShikakuHenkoRirekiDialogButtonDiv getCcdShikakuHenkoDialogButton() {
        return this.getShikakuShosai().getShikakuShosaiDialogs().getCcdShikakuHenkoDialogButton();
    }

    @JsonIgnore
    public IJushochiTokureiDialogButtonDiv getCcdJutokuDialogButton() {
        return this.getShikakuShosai().getShikakuShosaiDialogs().getCcdJutokuDialogButton();
    }

    @JsonIgnore
    public IShisetsuNyutaishoDialogButtonDiv getCcdShisetsuNyutaishoDialogButton() {
        return this.getShikakuShosai().getShikakuShosaiDialogs().getCcdShisetsuNyutaishoDialogButton();
    }

    // </editor-fold>
}
