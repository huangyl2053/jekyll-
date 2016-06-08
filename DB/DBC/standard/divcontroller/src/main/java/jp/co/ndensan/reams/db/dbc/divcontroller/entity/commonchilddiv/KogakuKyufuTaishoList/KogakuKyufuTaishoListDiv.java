package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * 画面設計_DBCKD00006_高額給付対象一覧共有子Div
 *
 * @reamsid_L DBC-2020-030 quxiaodong
 */
public class KogakuKyufuTaishoListDiv extends Panel implements IKogakuKyufuTaishoListDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnTsuika")
    private Button btnTsuika;
    @JsonProperty("dgTaishoshaIchiran")
    private DataGrid<dgTaishoshaIchiran_Row> dgTaishoshaIchiran;
    @JsonProperty("MeisaiGokeiHenshuPanel")
    private MeisaiGokeiHenshuPanelDiv MeisaiGokeiHenshuPanel;
    @JsonProperty("rowId")
    private TextBoxNum rowId;
    @JsonProperty("jigyoshaCode")
    private RString jigyoshaCode;
    @JsonProperty("jigyoshaMeisho ")
    private RString jigyoshaMeisho;
    @JsonProperty("serviceCode")
    private RString serviceCode;
    @JsonProperty("serviceMeisho")
    private RString serviceMeisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnTsuika
     * @return btnTsuika
     */
    @JsonProperty("btnTsuika")
    public Button getBtnTsuika() {
        return btnTsuika;
    }

    /*
     * setbtnTsuika
     * @param btnTsuika btnTsuika
     */
    @JsonProperty("btnTsuika")
    public void setBtnTsuika(Button btnTsuika) {
        this.btnTsuika = btnTsuika;
    }

    /*
     * getdgTaishoshaIchiran
     * @return dgTaishoshaIchiran
     */
    @JsonProperty("dgTaishoshaIchiran")
    public DataGrid<dgTaishoshaIchiran_Row> getDgTaishoshaIchiran() {
        return dgTaishoshaIchiran;
    }

    /*
     * setdgTaishoshaIchiran
     * @param dgTaishoshaIchiran dgTaishoshaIchiran
     */
    @JsonProperty("dgTaishoshaIchiran")
    public void setDgTaishoshaIchiran(DataGrid<dgTaishoshaIchiran_Row> dgTaishoshaIchiran) {
        this.dgTaishoshaIchiran = dgTaishoshaIchiran;
    }

    /*
     * getMeisaiGokeiHenshuPanel
     * @return MeisaiGokeiHenshuPanel
     */
    @JsonProperty("MeisaiGokeiHenshuPanel")
    public MeisaiGokeiHenshuPanelDiv getMeisaiGokeiHenshuPanel() {
        return MeisaiGokeiHenshuPanel;
    }

    /*
     * setMeisaiGokeiHenshuPanel
     * @param MeisaiGokeiHenshuPanel MeisaiGokeiHenshuPanel
     */
    @JsonProperty("MeisaiGokeiHenshuPanel")
    public void setMeisaiGokeiHenshuPanel(MeisaiGokeiHenshuPanelDiv MeisaiGokeiHenshuPanel) {
        this.MeisaiGokeiHenshuPanel = MeisaiGokeiHenshuPanel;
    }

    /*
     * getrowId
     * @return rowId
     */
    @JsonProperty("rowId")
    public TextBoxNum getRowId() {
        return rowId;
    }

    /*
     * setrowId
     * @param rowId rowId
     */
    @JsonProperty("rowId")
    public void setRowId(TextBoxNum rowId) {
        this.rowId = rowId;
    }

    /*
     * getjigyoshaCode
     * @return jigyoshaCode
     */
    @JsonProperty("jigyoshaCode")
    public RString getJigyoshaCode() {
        return jigyoshaCode;
    }

    /*
     * setjigyoshaCode
     * @param jigyoshaCode jigyoshaCode
     */
    @JsonProperty("jigyoshaCode")
    public void setJigyoshaCode(RString jigyoshaCode) {
        this.jigyoshaCode = jigyoshaCode;
    }

    /*
     * getjigyoshaMeisho
     * @return jigyoshaMeisho
     */
    @JsonProperty("jigyoshaMeisho ")
    public RString getJigyoshaMeisho() {
        return jigyoshaMeisho;
    }

    /*
     * setjigyoshaMeisho
     * @param jigyoshaMeisho  jigyoshaMeisho
     */
    @JsonProperty("jigyoshaMeisho ")
    public void setJigyoshaMeisho(RString jigyoshaMeisho) {
        this.jigyoshaMeisho = jigyoshaMeisho;
    }

    /*
     * getserviceCode
     * @return serviceCode
     */
    @JsonProperty("serviceCode")
    public RString getServiceCode() {
        return serviceCode;
    }

    /*
     * setserviceCode
     * @param serviceCode serviceCode
     */
    @JsonProperty("serviceCode")
    public void setServiceCode(RString serviceCode) {
        this.serviceCode = serviceCode;
    }

    /*
     * getserviceMeisho
     * @return serviceMeisho
     */
    @JsonProperty("serviceMeisho")
    public RString getServiceMeisho() {
        return serviceMeisho;
    }

    /*
     * setserviceMeisho
     * @param serviceMeisho serviceMeisho
     */
    @JsonProperty("serviceMeisho")
    public void setServiceMeisho(RString serviceMeisho) {
        this.serviceMeisho = serviceMeisho;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DisplayMode implements ICommonChildDivMode {

        shokai("shokai"),
        toroku("toroku");

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
    public RadioButton getRdbMisaiGkeiKbun() {
        return this.getMeisaiGokeiHenshuPanel().getRdbMisaiGkeiKbun();
    }

    @JsonIgnore
    public void setRdbMisaiGkeiKbun(RadioButton rdbMisaiGkeiKbun) {
        this.getMeisaiGokeiHenshuPanel().setRdbMisaiGkeiKbun(rdbMisaiGkeiKbun);
    }

    @JsonIgnore
    public TextBox getTxtJgyoshaCode() {
        return this.getMeisaiGokeiHenshuPanel().getTxtJgyoshaCode();
    }

    @JsonIgnore
    public void setTxtJgyoshaCode(TextBox txtJgyoshaCode) {
        this.getMeisaiGokeiHenshuPanel().setTxtJgyoshaCode(txtJgyoshaCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnJgyosha() {
        return this.getMeisaiGokeiHenshuPanel().getBtnJgyosha();
    }

    @JsonIgnore
    public void setBtnJgyosha(ButtonDialog btnJgyosha) {
        this.getMeisaiGokeiHenshuPanel().setBtnJgyosha(btnJgyosha);
    }

    @JsonIgnore
    public TextBox getTxtJgyoshaName() {
        return this.getMeisaiGokeiHenshuPanel().getTxtJgyoshaName();
    }

    @JsonIgnore
    public void setTxtJgyoshaName(TextBox txtJgyoshaName) {
        this.getMeisaiGokeiHenshuPanel().setTxtJgyoshaName(txtJgyoshaName);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceSyurui() {
        return this.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui();
    }

    @JsonIgnore
    public void setTxtServiceSyurui(TextBoxCode txtServiceSyurui) {
        this.getMeisaiGokeiHenshuPanel().setTxtServiceSyurui(txtServiceSyurui);
    }

    @JsonIgnore
    public ButtonDialog getBtnServiceSyurui() {
        return this.getMeisaiGokeiHenshuPanel().getBtnServiceSyurui();
    }

    @JsonIgnore
    public void setBtnServiceSyurui(ButtonDialog btnServiceSyurui) {
        this.getMeisaiGokeiHenshuPanel().setBtnServiceSyurui(btnServiceSyurui);
    }

    @JsonIgnore
    public TextBox getTxtServiceSyuruiName() {
        return this.getMeisaiGokeiHenshuPanel().getTxtServiceSyuruiName();
    }

    @JsonIgnore
    public void setTxtServiceSyuruiName(TextBox txtServiceSyuruiName) {
        this.getMeisaiGokeiHenshuPanel().setTxtServiceSyuruiName(txtServiceSyuruiName);
    }

    @JsonIgnore
    public TextBoxNum getTxtHyoGkei() {
        return this.getMeisaiGokeiHenshuPanel().getTxtHyoGkei();
    }

    @JsonIgnore
    public void setTxtHyoGkei(TextBoxNum txtHyoGkei) {
        this.getMeisaiGokeiHenshuPanel().setTxtHyoGkei(txtHyoGkei);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshafutanGokei() {
        return this.getMeisaiGokeiHenshuPanel().getTxtRiyoshafutanGokei();
    }

    @JsonIgnore
    public void setTxtRiyoshafutanGokei(TextBoxNum txtRiyoshafutanGokei) {
        this.getMeisaiGokeiHenshuPanel().setTxtRiyoshafutanGokei(txtRiyoshafutanGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtSanteiKijunGaku() {
        return this.getMeisaiGokeiHenshuPanel().getTxtSanteiKijunGaku();
    }

    @JsonIgnore
    public void setTxtSanteiKijunGaku(TextBoxNum txtSanteiKijunGaku) {
        this.getMeisaiGokeiHenshuPanel().setTxtSanteiKijunGaku(txtSanteiKijunGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtSiharaiZumiGaku() {
        return this.getMeisaiGokeiHenshuPanel().getTxtSiharaiZumiGaku();
    }

    @JsonIgnore
    public void setTxtSiharaiZumiGaku(TextBoxNum txtSiharaiZumiGaku) {
        this.getMeisaiGokeiHenshuPanel().setTxtSiharaiZumiGaku(txtSiharaiZumiGaku);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getMeisaiGokeiHenshuPanel().getLin1();
    }

    @JsonIgnore
    public void setLin1(HorizontalLine lin1) {
        this.getMeisaiGokeiHenshuPanel().setLin1(lin1);
    }

    @JsonIgnore
    public RadioButton getRdbTsukiOkure() {
        return this.getMeisaiGokeiHenshuPanel().getRdbTsukiOkure();
    }

    @JsonIgnore
    public void setRdbTsukiOkure(RadioButton rdbTsukiOkure) {
        this.getMeisaiGokeiHenshuPanel().setRdbTsukiOkure(rdbTsukiOkure);
    }

    @JsonIgnore
    public RadioButton getRabSetaiShotokuKubun() {
        return this.getMeisaiGokeiHenshuPanel().getRabSetaiShotokuKubun();
    }

    @JsonIgnore
    public void setRabSetaiShotokuKubun(RadioButton rabSetaiShotokuKubun) {
        this.getMeisaiGokeiHenshuPanel().setRabSetaiShotokuKubun(rabSetaiShotokuKubun);
    }

    @JsonIgnore
    public RadioButton getRdbShotokuKubun() {
        return this.getMeisaiGokeiHenshuPanel().getRdbShotokuKubun();
    }

    @JsonIgnore
    public void setRdbShotokuKubun(RadioButton rdbShotokuKubun) {
        this.getMeisaiGokeiHenshuPanel().setRdbShotokuKubun(rdbShotokuKubun);
    }

    @JsonIgnore
    public RadioButton getRdbGassan() {
        return this.getMeisaiGokeiHenshuPanel().getRdbGassan();
    }

    @JsonIgnore
    public void setRdbGassan(RadioButton rdbGassan) {
        this.getMeisaiGokeiHenshuPanel().setRdbGassan(rdbGassan);
    }

    @JsonIgnore
    public RadioButton getRdbRoreiFukushiNenkin() {
        return this.getMeisaiGokeiHenshuPanel().getRdbRoreiFukushiNenkin();
    }

    @JsonIgnore
    public void setRdbRoreiFukushiNenkin(RadioButton rdbRoreiFukushiNenkin) {
        this.getMeisaiGokeiHenshuPanel().setRdbRoreiFukushiNenkin(rdbRoreiFukushiNenkin);
    }

    @JsonIgnore
    public RadioButton getRdbRiyoshafutanDai2dankai() {
        return this.getMeisaiGokeiHenshuPanel().getRdbRiyoshafutanDai2dankai();
    }

    @JsonIgnore
    public void setRdbRiyoshafutanDai2dankai(RadioButton rdbRiyoshafutanDai2dankai) {
        this.getMeisaiGokeiHenshuPanel().setRdbRiyoshafutanDai2dankai(rdbRiyoshafutanDai2dankai);
    }

    @JsonIgnore
    public RadioButton getRdbGekihenkanwaKubun() {
        return this.getMeisaiGokeiHenshuPanel().getRdbGekihenkanwaKubun();
    }

    @JsonIgnore
    public void setRdbGekihenkanwaKubun(RadioButton rdbGekihenkanwaKubun) {
        this.getMeisaiGokeiHenshuPanel().setRdbGekihenkanwaKubun(rdbGekihenkanwaKubun);
    }

    @JsonIgnore
    public Button getBtnTorikeshi() {
        return this.getMeisaiGokeiHenshuPanel().getBtnTorikeshi();
    }

    @JsonIgnore
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.getMeisaiGokeiHenshuPanel().setBtnTorikeshi(btnTorikeshi);
    }

    @JsonIgnore
    public Button getBtnkakutei() {
        return this.getMeisaiGokeiHenshuPanel().getBtnkakutei();
    }

    @JsonIgnore
    public void setBtnkakutei(Button btnkakutei) {
        this.getMeisaiGokeiHenshuPanel().setBtnkakutei(btnkakutei);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 画面初期化
     *
     * @param メニューID RString
     * @param 画面モード RString
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 履歴番号 RString
     */
    @Override
    public void initialize(RString メニューID, RString 画面モード, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 履歴番号) {
        KogakuKyufuTaishoListHandler.of(this).画面初期化(メニューID, 画面モード, 被保険者番号, サービス提供年月, 履歴番号);
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, サービス提供年月);
    }
}
