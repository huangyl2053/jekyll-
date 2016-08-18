package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * JukyushaIdoRenrakuhyo のクラスファイル
 *
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoDiv extends Panel implements IJukyushaIdoRenrakuhyoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JukyushaIdoRenrakuhyoKihonJoho")
    private JukyushaIdoRenrakuhyoKihonJohoDiv JukyushaIdoRenrakuhyoKihonJoho;
    @JsonProperty("JukyushaIdoRenrakuhyoTeisei")
    private JukyushaIdoRenrakuhyoTeiseiDiv JukyushaIdoRenrakuhyoTeisei;
    @JsonProperty("YokaigoNinteiPanel")
    private YokaigoNinteiPanelDiv YokaigoNinteiPanel;
    @JsonProperty("ShikyuGendoKijungakuPanel")
    private ShikyuGendoKijungakuPanelDiv ShikyuGendoKijungakuPanel;
    @JsonProperty("KyotakuServicePlanPanel")
    private KyotakuServicePlanPanelDiv KyotakuServicePlanPanel;
    @JsonProperty("JushochiTokureiPanel")
    private JushochiTokureiPanelDiv JushochiTokureiPanel;
    @JsonProperty("GemmenGengakuPanel")
    private GemmenGengakuPanelDiv GemmenGengakuPanel;
    @JsonProperty("KokiKoureiIryoHokenshaPanel")
    private KokiKoureiIryoHokenshaPanelDiv KokiKoureiIryoHokenshaPanel;
    @JsonProperty("KyufuSeigenPanel")
    private KyufuSeigenPanelDiv KyufuSeigenPanel;
    @JsonProperty("RiyosyaFutanWariaiPanel")
    private RiyosyaFutanWariaiPanelDiv RiyosyaFutanWariaiPanel;
    @JsonProperty("NijiyoboJigyoPanel")
    private NijiyoboJigyoPanelDiv NijiyoboJigyoPanel;
    @JsonProperty("RojinHokenPanel")
    private RojinHokenPanelDiv RojinHokenPanel;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJukyushaIdoRenrakuhyoKihonJoho
     * @return JukyushaIdoRenrakuhyoKihonJoho
     */
    @JsonProperty("JukyushaIdoRenrakuhyoKihonJoho")
    public JukyushaIdoRenrakuhyoKihonJohoDiv getJukyushaIdoRenrakuhyoKihonJoho() {
        return JukyushaIdoRenrakuhyoKihonJoho;
    }

    /*
     * setJukyushaIdoRenrakuhyoKihonJoho
     * @param JukyushaIdoRenrakuhyoKihonJoho JukyushaIdoRenrakuhyoKihonJoho
     */
    @JsonProperty("JukyushaIdoRenrakuhyoKihonJoho")
    public void setJukyushaIdoRenrakuhyoKihonJoho(JukyushaIdoRenrakuhyoKihonJohoDiv JukyushaIdoRenrakuhyoKihonJoho) {
        this.JukyushaIdoRenrakuhyoKihonJoho = JukyushaIdoRenrakuhyoKihonJoho;
    }

    /*
     * getJukyushaIdoRenrakuhyoTeisei
     * @return JukyushaIdoRenrakuhyoTeisei
     */
    @JsonProperty("JukyushaIdoRenrakuhyoTeisei")
    public JukyushaIdoRenrakuhyoTeiseiDiv getJukyushaIdoRenrakuhyoTeisei() {
        return JukyushaIdoRenrakuhyoTeisei;
    }

    /*
     * setJukyushaIdoRenrakuhyoTeisei
     * @param JukyushaIdoRenrakuhyoTeisei JukyushaIdoRenrakuhyoTeisei
     */
    @JsonProperty("JukyushaIdoRenrakuhyoTeisei")
    public void setJukyushaIdoRenrakuhyoTeisei(JukyushaIdoRenrakuhyoTeiseiDiv JukyushaIdoRenrakuhyoTeisei) {
        this.JukyushaIdoRenrakuhyoTeisei = JukyushaIdoRenrakuhyoTeisei;
    }

    /*
     * getYokaigoNinteiPanel
     * @return YokaigoNinteiPanel
     */
    @JsonProperty("YokaigoNinteiPanel")
    public YokaigoNinteiPanelDiv getYokaigoNinteiPanel() {
        return YokaigoNinteiPanel;
    }

    /*
     * setYokaigoNinteiPanel
     * @param YokaigoNinteiPanel YokaigoNinteiPanel
     */
    @JsonProperty("YokaigoNinteiPanel")
    public void setYokaigoNinteiPanel(YokaigoNinteiPanelDiv YokaigoNinteiPanel) {
        this.YokaigoNinteiPanel = YokaigoNinteiPanel;
    }

    /*
     * getShikyuGendoKijungakuPanel
     * @return ShikyuGendoKijungakuPanel
     */
    @JsonProperty("ShikyuGendoKijungakuPanel")
    public ShikyuGendoKijungakuPanelDiv getShikyuGendoKijungakuPanel() {
        return ShikyuGendoKijungakuPanel;
    }

    /*
     * setShikyuGendoKijungakuPanel
     * @param ShikyuGendoKijungakuPanel ShikyuGendoKijungakuPanel
     */
    @JsonProperty("ShikyuGendoKijungakuPanel")
    public void setShikyuGendoKijungakuPanel(ShikyuGendoKijungakuPanelDiv ShikyuGendoKijungakuPanel) {
        this.ShikyuGendoKijungakuPanel = ShikyuGendoKijungakuPanel;
    }

    /*
     * getKyotakuServicePlanPanel
     * @return KyotakuServicePlanPanel
     */
    @JsonProperty("KyotakuServicePlanPanel")
    public KyotakuServicePlanPanelDiv getKyotakuServicePlanPanel() {
        return KyotakuServicePlanPanel;
    }

    /*
     * setKyotakuServicePlanPanel
     * @param KyotakuServicePlanPanel KyotakuServicePlanPanel
     */
    @JsonProperty("KyotakuServicePlanPanel")
    public void setKyotakuServicePlanPanel(KyotakuServicePlanPanelDiv KyotakuServicePlanPanel) {
        this.KyotakuServicePlanPanel = KyotakuServicePlanPanel;
    }

    /*
     * getJushochiTokureiPanel
     * @return JushochiTokureiPanel
     */
    @JsonProperty("JushochiTokureiPanel")
    public JushochiTokureiPanelDiv getJushochiTokureiPanel() {
        return JushochiTokureiPanel;
    }

    /*
     * setJushochiTokureiPanel
     * @param JushochiTokureiPanel JushochiTokureiPanel
     */
    @JsonProperty("JushochiTokureiPanel")
    public void setJushochiTokureiPanel(JushochiTokureiPanelDiv JushochiTokureiPanel) {
        this.JushochiTokureiPanel = JushochiTokureiPanel;
    }

    /*
     * getGemmenGengakuPanel
     * @return GemmenGengakuPanel
     */
    @JsonProperty("GemmenGengakuPanel")
    public GemmenGengakuPanelDiv getGemmenGengakuPanel() {
        return GemmenGengakuPanel;
    }

    /*
     * setGemmenGengakuPanel
     * @param GemmenGengakuPanel GemmenGengakuPanel
     */
    @JsonProperty("GemmenGengakuPanel")
    public void setGemmenGengakuPanel(GemmenGengakuPanelDiv GemmenGengakuPanel) {
        this.GemmenGengakuPanel = GemmenGengakuPanel;
    }

    /*
     * getKokiKoureiIryoHokenshaPanel
     * @return KokiKoureiIryoHokenshaPanel
     */
    @JsonProperty("KokiKoureiIryoHokenshaPanel")
    public KokiKoureiIryoHokenshaPanelDiv getKokiKoureiIryoHokenshaPanel() {
        return KokiKoureiIryoHokenshaPanel;
    }

    /*
     * setKokiKoureiIryoHokenshaPanel
     * @param KokiKoureiIryoHokenshaPanel KokiKoureiIryoHokenshaPanel
     */
    @JsonProperty("KokiKoureiIryoHokenshaPanel")
    public void setKokiKoureiIryoHokenshaPanel(KokiKoureiIryoHokenshaPanelDiv KokiKoureiIryoHokenshaPanel) {
        this.KokiKoureiIryoHokenshaPanel = KokiKoureiIryoHokenshaPanel;
    }

    /*
     * getKyufuSeigenPanel
     * @return KyufuSeigenPanel
     */
    @JsonProperty("KyufuSeigenPanel")
    public KyufuSeigenPanelDiv getKyufuSeigenPanel() {
        return KyufuSeigenPanel;
    }

    /*
     * setKyufuSeigenPanel
     * @param KyufuSeigenPanel KyufuSeigenPanel
     */
    @JsonProperty("KyufuSeigenPanel")
    public void setKyufuSeigenPanel(KyufuSeigenPanelDiv KyufuSeigenPanel) {
        this.KyufuSeigenPanel = KyufuSeigenPanel;
    }

    /*
     * getRiyosyaFutanWariaiPanel
     * @return RiyosyaFutanWariaiPanel
     */
    @JsonProperty("RiyosyaFutanWariaiPanel")
    public RiyosyaFutanWariaiPanelDiv getRiyosyaFutanWariaiPanel() {
        return RiyosyaFutanWariaiPanel;
    }

    /*
     * setRiyosyaFutanWariaiPanel
     * @param RiyosyaFutanWariaiPanel RiyosyaFutanWariaiPanel
     */
    @JsonProperty("RiyosyaFutanWariaiPanel")
    public void setRiyosyaFutanWariaiPanel(RiyosyaFutanWariaiPanelDiv RiyosyaFutanWariaiPanel) {
        this.RiyosyaFutanWariaiPanel = RiyosyaFutanWariaiPanel;
    }

    /*
     * getNijiyoboJigyoPanel
     * @return NijiyoboJigyoPanel
     */
    @JsonProperty("NijiyoboJigyoPanel")
    public NijiyoboJigyoPanelDiv getNijiyoboJigyoPanel() {
        return NijiyoboJigyoPanel;
    }

    /*
     * setNijiyoboJigyoPanel
     * @param NijiyoboJigyoPanel NijiyoboJigyoPanel
     */
    @JsonProperty("NijiyoboJigyoPanel")
    public void setNijiyoboJigyoPanel(NijiyoboJigyoPanelDiv NijiyoboJigyoPanel) {
        this.NijiyoboJigyoPanel = NijiyoboJigyoPanel;
    }

    /*
     * getRojinHokenPanel
     * @return RojinHokenPanel
     */
    @JsonProperty("RojinHokenPanel")
    public RojinHokenPanelDiv getRojinHokenPanel() {
        return RojinHokenPanel;
    }

    /*
     * setRojinHokenPanel
     * @param RojinHokenPanel RojinHokenPanel
     */
    @JsonProperty("RojinHokenPanel")
    public void setRojinHokenPanel(RojinHokenPanelDiv RojinHokenPanel) {
        this.RojinHokenPanel = RojinHokenPanel;
    }

    /*
     * gethihokenshaNo
     * @return hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /*
     * sethihokenshaNo
     * @param hihokenshaNo hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DisplayMode implements ICommonChildDivMode {

        shinki("shinki"),
        teisei("teisei"),
        saihakko("saihakko"),
        shokai("shokai");

        private final String name;

        private DisplayMode(final String name) {
            this.name = name;
        }

        public static DisplayMode getEnum(String str) {
            DisplayMode[] enumArray = DisplayMode.values();

            for (DisplayMode enumStr : enumArray) {
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

    public DisplayMode getMode_DisplayMode() {
        return (DisplayMode) _CommonChildDivModeUtil.getMode(this.modes, DisplayMode.class);
    }

    public void setMode_DisplayMode(DisplayMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, DisplayMode.class, value);
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtTeiseiYMD() {
        return this.getJukyushaIdoRenrakuhyoTeisei().getTxtTeiseiYMD();
    }

    @JsonIgnore
    public void setTxtTeiseiYMD(TextBoxDate txtTeiseiYMD) {
        this.getJukyushaIdoRenrakuhyoTeisei().setTxtTeiseiYMD(txtTeiseiYMD);
    }

    @JsonIgnore
    public RadioButton getRadTeiseiKubunCode() {
        return this.getJukyushaIdoRenrakuhyoTeisei().getRadTeiseiKubunCode();
    }

    @JsonIgnore
    public void setRadTeiseiKubunCode(RadioButton radTeiseiKubunCode) {
        this.getJukyushaIdoRenrakuhyoTeisei().setRadTeiseiKubunCode(radTeiseiKubunCode);
    }

    @JsonIgnore
    public HorizontalLine getLin3() {
        return this.getJukyushaIdoRenrakuhyoTeisei().getLin3();
    }

    @JsonIgnore
    public void setLin3(HorizontalLine lin3) {
        this.getJukyushaIdoRenrakuhyoTeisei().setLin3(lin3);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @JsonIgnore
    @Override
    public void initialize(RString 処理モード, ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号,
            int 履歴番号, boolean 論理削除フラグ, FlexibleDate 異動日) {
        JukyushaIdoRenrakuhyo 受給者異動送付
                = JukyushaIdoRenrakuhyoHandler.of(this).initialize(処理モード, 識別コード, 被保険者番号, 履歴番号, 論理削除フラグ, 異動日);
        ViewStateHolder.put(ViewStateKeys.履歴番号, 履歴番号);
        ViewStateHolder.put(ViewStateKeys.受給者異動送付, 受給者異動送付);
    }

    /**
     * 「事業区分」操作制御のメソッドです。
     *
     */
    @JsonIgnore
    @Override
    public void onClick_radNijiyoboJigyoKubun() {
        JukyushaIdoRenrakuhyoHandler.of(this).onClick_事業区分();
    }

    /**
     * 異動日focus outのメソッドです。
     *
     */
    @JsonIgnore
    @Override
    public void onBlur_txtIdoYMD() {
        JukyushaIdoRenrakuhyoHandler.of(this).onBlur_異動日();
    }

    /**
     * (共有子Div)受給者異動連絡票バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs
     */
    @JsonIgnore
    @Override
    public ValidationMessageControlPairs validateCheck() {
        return getValidationHandler().validate入力チェック();
    }

    /**
     * 受給者異動送付をを取得の。メソッドです。
     *
     * @return JukyushaIdoRenrakuhyo
     */
    @JsonIgnore
    @Override
    public JukyushaIdoRenrakuhyo get受給者異動送付() {
        int 履歴番号 = ViewStateHolder.get(ViewStateKeys.履歴番号, Integer.class) + 1;
        return JukyushaIdoRenrakuhyoHandler.of(this).get受給者異動送付(履歴番号);
    }

    private JukyushaIdoRenrakuhyoValidationHandler getValidationHandler() {
        return new JukyushaIdoRenrakuhyoValidationHandler(this);
    }

}
