package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KaigoKyufuKokuhorenJohoTorikomi;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * KaigoKyufuKokuhorenJohoTorikomi のクラスファイル
 *
 * @reamsid_L DBC-0980-290 wangkanglei
 */
public class KaigoKyufuKokuhorenJohoTorikomiDiv extends Panel implements IKaigoKyufuKokuhorenJohoTorikomiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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

    public static enum HyojiMode implements ICommonChildDivMode {

        Mode1("Mode1"),
        ModeShutsuryokujunJoken2("ModeShutsuryokujunJoken2"),
        ModeKakuninMsgJoken3("ModeKakuninMsgJoken3");

        private final String name;

        private HyojiMode(final String name) {
            this.name = name;
        }

        public static HyojiMode getEnum(String str) {
            HyojiMode[] enumArray = HyojiMode.values();

            for (HyojiMode enumStr : enumArray) {
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

    public HyojiMode getMode_HyojiMode() {
        return (HyojiMode) _CommonChildDivModeUtil.getMode( this.modes, HyojiMode.class );
    }

    public void setMode_HyojiMode( HyojiMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, HyojiMode.class , value );
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblShoriTaishoJoho() {
        return this.getShoriTaishoJoho().getLblShoriTaishoJoho();
    }

    @JsonIgnore
    public void  setLblShoriTaishoJoho(Label lblShoriTaishoJoho) {
        this.getShoriTaishoJoho().setLblShoriTaishoJoho(lblShoriTaishoJoho);
    }

    @JsonIgnore
    public CheckBoxList getChkTsuJobun() {
        return this.getShoriTaishoJoho().getChkTsuJobun();
    }

    @JsonIgnore
    public void  setChkTsuJobun(CheckBoxList chkTsuJobun) {
        this.getShoriTaishoJoho().setChkTsuJobun(chkTsuJobun);
    }

    @JsonIgnore
    public Label getLblKakuninJohoMsg() {
        return this.getKakuninJikoMsg().getLblKakuninJohoMsg();
    }

    @JsonIgnore
    public void  setLblKakuninJohoMsg(Label lblKakuninJohoMsg) {
        this.getKakuninJikoMsg().setLblKakuninJohoMsg(lblKakuninJohoMsg);
    }

    @JsonIgnore
    public Label getLblAruBaiMsg() {
        return this.getKakuninJikoMsg().getLblAruBaiMsg();
    }

    @JsonIgnore
    public void  setLblAruBaiMsg(Label lblAruBaiMsg) {
        this.getKakuninJikoMsg().setLblAruBaiMsg(lblAruBaiMsg);
    }

    @JsonIgnore
    public Label getLblNaiBaiMsg() {
        return this.getKakuninJikoMsg().getLblNaiBaiMsg();
    }

    @JsonIgnore
    public void  setLblNaiBaiMsg(Label lblNaiBaiMsg) {
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

    @JsonIgnore
    @Override
    public RDate get処理年月() {
        return this.getTxtShoriYmd().getValue();
    }

    @JsonIgnore
    @Override
    public RString get再処理区分() {
        return this.getTxtSaishoriKubun().getValue();
    }

    @JsonIgnore
    @Override
    public Long get出力順ID() {
        return this.getCcdChohyoShutsuryokujun().get出力順ID();
    }
}
