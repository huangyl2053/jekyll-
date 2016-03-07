package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KaigoKyufuKokuhorenJohoTorikomi;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.kaigoKyufuKokuhorenJohoTorikomi.KaigoKyufuKokuhorenJohoTorikomiHandler;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * KaigoKyufuKokuhorenJohoTorikomi のクラスファイル
 *
 * @author 自動生成
 */
public class KaigoKyufuKokuhorenJohoTorikomiDiv extends Panel implements IKaigoKyufuKokuhorenJohoTorikomiDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblChushutsuJoken")
    private Label lblChushutsuJoken;
    @JsonProperty("txtShoriYmd")
    private TextBoxDate txtShoriYmd;
    @JsonProperty("txtSaishoriKubun")
    private TextBox txtSaishoriKubun;
    @JsonProperty("ShoriTaishoJoho")
    private ShoriTaishoJohoDiv ShoriTaishoJoho;
    @JsonProperty("KakuninJikoMsg")
    private KakuninJikoMsgDiv KakuninJikoMsg;
    @JsonProperty("ShutsuRyokujun")
    private ShutsuRyokujunDiv ShutsuRyokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblChushutsuJoken
     * @return lblChushutsuJoken
     */
    @JsonProperty("lblChushutsuJoken")
    public Label getLblChushutsuJoken() {
        return lblChushutsuJoken;
    }

    /*
     * setlblChushutsuJoken
     * @param lblChushutsuJoken lblChushutsuJoken
     */
    @JsonProperty("lblChushutsuJoken")
    public void setLblChushutsuJoken(Label lblChushutsuJoken) {
        this.lblChushutsuJoken = lblChushutsuJoken;
    }

    /*
     * gettxtShoriYmd
     * @return txtShoriYmd
     */
    @JsonProperty("txtShoriYmd")
    public TextBoxDate getTxtShoriYmd() {
        return txtShoriYmd;
    }

    /*
     * settxtShoriYmd
     * @param txtShoriYmd txtShoriYmd
     */
    @JsonProperty("txtShoriYmd")
    public void setTxtShoriYmd(TextBoxDate txtShoriYmd) {
        this.txtShoriYmd = txtShoriYmd;
    }

    /*
     * gettxtSaishoriKubun
     * @return txtSaishoriKubun
     */
    @JsonProperty("txtSaishoriKubun")
    public TextBox getTxtSaishoriKubun() {
        return txtSaishoriKubun;
    }

    /*
     * settxtSaishoriKubun
     * @param txtSaishoriKubun txtSaishoriKubun
     */
    @JsonProperty("txtSaishoriKubun")
    public void setTxtSaishoriKubun(TextBox txtSaishoriKubun) {
        this.txtSaishoriKubun = txtSaishoriKubun;
    }

    /*
     * getShoriTaishoJoho
     * @return ShoriTaishoJoho
     */
    @JsonProperty("ShoriTaishoJoho")
    public ShoriTaishoJohoDiv getShoriTaishoJoho() {
        return ShoriTaishoJoho;
    }

    /*
     * setShoriTaishoJoho
     * @param ShoriTaishoJoho ShoriTaishoJoho
     */
    @JsonProperty("ShoriTaishoJoho")
    public void setShoriTaishoJoho(ShoriTaishoJohoDiv ShoriTaishoJoho) {
        this.ShoriTaishoJoho = ShoriTaishoJoho;
    }

    /*
     * getKakuninJikoMsg
     * @return KakuninJikoMsg
     */
    @JsonProperty("KakuninJikoMsg")
    public KakuninJikoMsgDiv getKakuninJikoMsg() {
        return KakuninJikoMsg;
    }

    /*
     * setKakuninJikoMsg
     * @param KakuninJikoMsg KakuninJikoMsg
     */
    @JsonProperty("KakuninJikoMsg")
    public void setKakuninJikoMsg(KakuninJikoMsgDiv KakuninJikoMsg) {
        this.KakuninJikoMsg = KakuninJikoMsg;
    }

    /*
     * getShutsuRyokujun
     * @return ShutsuRyokujun
     */
    @JsonProperty("ShutsuRyokujun")
    public ShutsuRyokujunDiv getShutsuRyokujun() {
        return ShutsuRyokujun;
    }

    /*
     * setShutsuRyokujun
     * @param ShutsuRyokujun ShutsuRyokujun
     */
    @JsonProperty("ShutsuRyokujun")
    public void setShutsuRyokujun(ShutsuRyokujunDiv ShutsuRyokujun) {
        this.ShutsuRyokujun = ShutsuRyokujun;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum 表示モード implements ICommonChildDivMode {

        Mode1("Mode1"),
        ModeShutsuryokujunJoken2("ModeShutsuryokujunJoken2"),
        ModeKakuninMsgJoken3("ModeKakuninMsgJoken3");

        private final String name;

        private 表示モード(final String name) {
            this.name = name;
        }

        public static 表示モード getEnum(String str) {
            表示モード[] enumArray = 表示モード.values();

            for (表示モード enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())) {
                    return enumStr;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    @JsonIgnore
    public 表示モード getMode_表示モード() {
        return (表示モード) _CommonChildDivModeUtil.getMode(this.modes, 表示モード.class);
    }

    @JsonIgnore
    public void setMode_表示モード(表示モード value) {
        _CommonChildDivModeUtil.setMode(this.modes, 表示モード.class, value);
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblShoriTaishoJoho() {
        return this.getShoriTaishoJoho().getLblShoriTaishoJoho();
    }

    @JsonIgnore
    public void setLblShoriTaishoJoho(Label lblShoriTaishoJoho) {
        this.getShoriTaishoJoho().setLblShoriTaishoJoho(lblShoriTaishoJoho);
    }

    @JsonIgnore
    public CheckBoxList getChkTsuJobun() {
        return this.getShoriTaishoJoho().getChkTsuJobun();
    }

    @JsonIgnore
    public void setChkTsuJobun(CheckBoxList chkTsuJobun) {
        this.getShoriTaishoJoho().setChkTsuJobun(chkTsuJobun);
    }

    @JsonIgnore
    public Label getLblKakuninJohoMsg() {
        return this.getKakuninJikoMsg().getLblKakuninJohoMsg();
    }

    @JsonIgnore
    public void setLblKakuninJohoMsg(Label lblKakuninJohoMsg) {
        this.getKakuninJikoMsg().setLblKakuninJohoMsg(lblKakuninJohoMsg);
    }

    @JsonIgnore
    public Label getLblAruBaiMsg() {
        return this.getKakuninJikoMsg().getLblAruBaiMsg();
    }

    @JsonIgnore
    public void setLblAruBaiMsg(Label lblAruBaiMsg) {
        this.getKakuninJikoMsg().setLblAruBaiMsg(lblAruBaiMsg);
    }

    @JsonIgnore
    public Label getLblNaiBaiMsg() {
        return this.getKakuninJikoMsg().getLblNaiBaiMsg();
    }

    @JsonIgnore
    public void setLblNaiBaiMsg(Label lblNaiBaiMsg) {
        this.getKakuninJikoMsg().setLblNaiBaiMsg(lblNaiBaiMsg);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return this.getShutsuRyokujun().getCcdChohyoShutsuryokujun();
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @JsonIgnore
    @Override
    public void onLoadMode1() {
        KaigoKyufuKokuhorenJohoTorikomiHandler.of(this).onLoadMode1();
    }

    @JsonIgnore
    @Override
    public List<RString> get処理対象情報() {
        return this.getShoriTaishoJoho().getChkTsuJobun().getSelectedKeys();
    }

    @JsonIgnore
    @Override
    public void onLoadModeShutsuryokujunJoken2(SubGyomuCode サブ業務コード, ReportId 帳票ID) {
        KaigoKyufuKokuhorenJohoTorikomiHandler.of(this).onLoadModeShutsuryokujunJoken2(サブ業務コード, 帳票ID);
    }

    @JsonIgnore
    @Override
    public void onLoadModeKakuninMsgJoken3(SubGyomuCode サブ業務コード, ReportId 帳票ID) {
        KaigoKyufuKokuhorenJohoTorikomiHandler.of(this).onLoadModeKakuninMsgJoken3(サブ業務コード, 帳票ID);
    }

}
