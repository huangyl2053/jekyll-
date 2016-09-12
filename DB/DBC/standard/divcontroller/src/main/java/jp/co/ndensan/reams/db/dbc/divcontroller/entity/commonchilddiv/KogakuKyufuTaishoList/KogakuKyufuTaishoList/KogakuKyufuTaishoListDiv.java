package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList.KogakuKyufuTaishoList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * KogakuKyufuTaishoList のクラスファイル 
 * 
 * @author 自動生成
 */
public class KogakuKyufuTaishoListDiv extends Panel implements IKogakuKyufuTaishoListDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
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
    @JsonProperty("JigyoshaMode")
    private RString JigyoshaMode;
    @JsonProperty("hdnServiceType")
    private RString hdnServiceType;
    @JsonProperty("hdnServiceTypeName")
    private RString hdnServiceTypeName;
    @JsonProperty("hdnServiceRyakusho")
    private RString hdnServiceRyakusho;

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
     * getJigyoshaMode
     * @return JigyoshaMode
     */
    @JsonProperty("JigyoshaMode")
    public RString getJigyoshaMode() {
        return JigyoshaMode;
    }

    /*
     * setJigyoshaMode
     * @param JigyoshaMode JigyoshaMode
     */
    @JsonProperty("JigyoshaMode")
    public void setJigyoshaMode(RString JigyoshaMode) {
        this.JigyoshaMode = JigyoshaMode;
    }

    /*
     * gethdnServiceType
     * @return hdnServiceType
     */
    @JsonProperty("hdnServiceType")
    public RString getHdnServiceType() {
        return hdnServiceType;
    }

    /*
     * sethdnServiceType
     * @param hdnServiceType hdnServiceType
     */
    @JsonProperty("hdnServiceType")
    public void setHdnServiceType(RString hdnServiceType) {
        this.hdnServiceType = hdnServiceType;
    }

    /*
     * gethdnServiceTypeName
     * @return hdnServiceTypeName
     */
    @JsonProperty("hdnServiceTypeName")
    public RString getHdnServiceTypeName() {
        return hdnServiceTypeName;
    }

    /*
     * sethdnServiceTypeName
     * @param hdnServiceTypeName hdnServiceTypeName
     */
    @JsonProperty("hdnServiceTypeName")
    public void setHdnServiceTypeName(RString hdnServiceTypeName) {
        this.hdnServiceTypeName = hdnServiceTypeName;
    }

    /*
     * gethdnServiceRyakusho
     * @return hdnServiceRyakusho
     */
    @JsonProperty("hdnServiceRyakusho")
    public RString getHdnServiceRyakusho() {
        return hdnServiceRyakusho;
    }

    /*
     * sethdnServiceRyakusho
     * @param hdnServiceRyakusho hdnServiceRyakusho
     */
    @JsonProperty("hdnServiceRyakusho")
    public void setHdnServiceRyakusho(RString hdnServiceRyakusho) {
        this.hdnServiceRyakusho = hdnServiceRyakusho;
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
        return (DisplayMode) _CommonChildDivModeUtil.getMode( this.modes, DisplayMode.class );
    }

    public void setMode_DisplayMode( DisplayMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, DisplayMode.class , value );
    }

    public static enum MeisaiGokeiKubunMode implements ICommonChildDivMode {

        Meisai("Meisai"),
        Gokei("Gokei");

        private final String name;

        private MeisaiGokeiKubunMode(final String name) {
            this.name = name;
        }

        public static MeisaiGokeiKubunMode getEnum(String str) {
            MeisaiGokeiKubunMode[] enumArray = MeisaiGokeiKubunMode.values();

            for (MeisaiGokeiKubunMode enumStr : enumArray) {
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

    public MeisaiGokeiKubunMode getMode_MeisaiGokeiKubunMode() {
        return (MeisaiGokeiKubunMode) _CommonChildDivModeUtil.getMode( this.modes, MeisaiGokeiKubunMode.class );
    }

    public void setMode_MeisaiGokeiKubunMode( MeisaiGokeiKubunMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, MeisaiGokeiKubunMode.class , value );
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRdbMisaiGkeiKbun() {
        return this.getMeisaiGokeiHenshuPanel().getRdbMisaiGkeiKbun();
    }

    @JsonIgnore
    public void  setRdbMisaiGkeiKbun(RadioButton rdbMisaiGkeiKbun) {
        this.getMeisaiGokeiHenshuPanel().setRdbMisaiGkeiKbun(rdbMisaiGkeiKbun);
    }

    @JsonIgnore
    public TextBox getTxtJgyoshaCode() {
        return this.getMeisaiGokeiHenshuPanel().getTxtJgyoshaCode();
    }

    @JsonIgnore
    public void  setTxtJgyoshaCode(TextBox txtJgyoshaCode) {
        this.getMeisaiGokeiHenshuPanel().setTxtJgyoshaCode(txtJgyoshaCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnJgyosha() {
        return this.getMeisaiGokeiHenshuPanel().getBtnJgyosha();
    }

    @JsonIgnore
    public void  setBtnJgyosha(ButtonDialog btnJgyosha) {
        this.getMeisaiGokeiHenshuPanel().setBtnJgyosha(btnJgyosha);
    }

    @JsonIgnore
    public TextBox getTxtJgyoshaName() {
        return this.getMeisaiGokeiHenshuPanel().getTxtJgyoshaName();
    }

    @JsonIgnore
    public void  setTxtJgyoshaName(TextBox txtJgyoshaName) {
        this.getMeisaiGokeiHenshuPanel().setTxtJgyoshaName(txtJgyoshaName);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceSyurui() {
        return this.getMeisaiGokeiHenshuPanel().getTxtServiceSyurui();
    }

    @JsonIgnore
    public void  setTxtServiceSyurui(TextBoxCode txtServiceSyurui) {
        this.getMeisaiGokeiHenshuPanel().setTxtServiceSyurui(txtServiceSyurui);
    }

    @JsonIgnore
    public ButtonDialog getBtnServiceSyurui() {
        return this.getMeisaiGokeiHenshuPanel().getBtnServiceSyurui();
    }

    @JsonIgnore
    public void  setBtnServiceSyurui(ButtonDialog btnServiceSyurui) {
        this.getMeisaiGokeiHenshuPanel().setBtnServiceSyurui(btnServiceSyurui);
    }

    @JsonIgnore
    public TextBox getTxtServiceSyuruiName() {
        return this.getMeisaiGokeiHenshuPanel().getTxtServiceSyuruiName();
    }

    @JsonIgnore
    public void  setTxtServiceSyuruiName(TextBox txtServiceSyuruiName) {
        this.getMeisaiGokeiHenshuPanel().setTxtServiceSyuruiName(txtServiceSyuruiName);
    }

    @JsonIgnore
    public TextBoxNum getTxtHyoGkei() {
        return this.getMeisaiGokeiHenshuPanel().getTxtHyoGkei();
    }

    @JsonIgnore
    public void  setTxtHyoGkei(TextBoxNum txtHyoGkei) {
        this.getMeisaiGokeiHenshuPanel().setTxtHyoGkei(txtHyoGkei);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshafutanGokei() {
        return this.getMeisaiGokeiHenshuPanel().getTxtRiyoshafutanGokei();
    }

    @JsonIgnore
    public void  setTxtRiyoshafutanGokei(TextBoxNum txtRiyoshafutanGokei) {
        this.getMeisaiGokeiHenshuPanel().setTxtRiyoshafutanGokei(txtRiyoshafutanGokei);
    }

    @JsonIgnore
    public GokeiPanelDiv getGokeiPanel() {
        return this.getMeisaiGokeiHenshuPanel().getGokeiPanel();
    }

    @JsonIgnore
    public void  setGokeiPanel(GokeiPanelDiv GokeiPanel) {
        this.getMeisaiGokeiHenshuPanel().setGokeiPanel(GokeiPanel);
    }

    @JsonIgnore
    public TextBoxNum getTxtSanteiKijunGaku() {
        return this.getMeisaiGokeiHenshuPanel().getGokeiPanel().getTxtSanteiKijunGaku();
    }

    @JsonIgnore
    public void  setTxtSanteiKijunGaku(TextBoxNum txtSanteiKijunGaku) {
        this.getMeisaiGokeiHenshuPanel().getGokeiPanel().setTxtSanteiKijunGaku(txtSanteiKijunGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtSiharaiZumiGaku() {
        return this.getMeisaiGokeiHenshuPanel().getGokeiPanel().getTxtSiharaiZumiGaku();
    }

    @JsonIgnore
    public void  setTxtSiharaiZumiGaku(TextBoxNum txtSiharaiZumiGaku) {
        this.getMeisaiGokeiHenshuPanel().getGokeiPanel().setTxtSiharaiZumiGaku(txtSiharaiZumiGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtKogakuShikyuGaku() {
        return this.getMeisaiGokeiHenshuPanel().getGokeiPanel().getTxtKogakuShikyuGaku();
    }

    @JsonIgnore
    public void  setTxtKogakuShikyuGaku(TextBoxNum txtKogakuShikyuGaku) {
        this.getMeisaiGokeiHenshuPanel().getGokeiPanel().setTxtKogakuShikyuGaku(txtKogakuShikyuGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtSetaiSyuyakuBango() {
        return this.getMeisaiGokeiHenshuPanel().getGokeiPanel().getTxtSetaiSyuyakuBango();
    }

    @JsonIgnore
    public void  setTxtSetaiSyuyakuBango(TextBoxNum txtSetaiSyuyakuBango) {
        this.getMeisaiGokeiHenshuPanel().getGokeiPanel().setTxtSetaiSyuyakuBango(txtSetaiSyuyakuBango);
    }

    @JsonIgnore
    public RadioButton getRdbKogakuJidoSyokanTaisyo() {
        return this.getMeisaiGokeiHenshuPanel().getGokeiPanel().getRdbKogakuJidoSyokanTaisyo();
    }

    @JsonIgnore
    public void  setRdbKogakuJidoSyokanTaisyo(RadioButton rdbKogakuJidoSyokanTaisyo) {
        this.getMeisaiGokeiHenshuPanel().getGokeiPanel().setRdbKogakuJidoSyokanTaisyo(rdbKogakuJidoSyokanTaisyo);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getMeisaiGokeiHenshuPanel().getLin1();
    }

    @JsonIgnore
    public void  setLin1(HorizontalLine lin1) {
        this.getMeisaiGokeiHenshuPanel().setLin1(lin1);
    }

    @JsonIgnore
    public KogakuKyufuKonkyoPanelDiv getKogakuKyufuKonkyoPanel() {
        return this.getMeisaiGokeiHenshuPanel().getKogakuKyufuKonkyoPanel();
    }

    @JsonIgnore
    public void  setKogakuKyufuKonkyoPanel(KogakuKyufuKonkyoPanelDiv KogakuKyufuKonkyoPanel) {
        this.getMeisaiGokeiHenshuPanel().setKogakuKyufuKonkyoPanel(KogakuKyufuKonkyoPanel);
    }

    @JsonIgnore
    public RadioButton getRdbTsukiOkure() {
        return this.getMeisaiGokeiHenshuPanel().getKogakuKyufuKonkyoPanel().getRdbTsukiOkure();
    }

    @JsonIgnore
    public void  setRdbTsukiOkure(RadioButton rdbTsukiOkure) {
        this.getMeisaiGokeiHenshuPanel().getKogakuKyufuKonkyoPanel().setRdbTsukiOkure(rdbTsukiOkure);
    }

    @JsonIgnore
    public RadioButton getRabSetaiShotokuKubun() {
        return this.getMeisaiGokeiHenshuPanel().getKogakuKyufuKonkyoPanel().getRabSetaiShotokuKubun();
    }

    @JsonIgnore
    public void  setRabSetaiShotokuKubun(RadioButton rabSetaiShotokuKubun) {
        this.getMeisaiGokeiHenshuPanel().getKogakuKyufuKonkyoPanel().setRabSetaiShotokuKubun(rabSetaiShotokuKubun);
    }

    @JsonIgnore
    public RadioButton getRdbShotokuKubun() {
        return this.getMeisaiGokeiHenshuPanel().getKogakuKyufuKonkyoPanel().getRdbShotokuKubun();
    }

    @JsonIgnore
    public void  setRdbShotokuKubun(RadioButton rdbShotokuKubun) {
        this.getMeisaiGokeiHenshuPanel().getKogakuKyufuKonkyoPanel().setRdbShotokuKubun(rdbShotokuKubun);
    }

    @JsonIgnore
    public RadioButton getRdbGassan() {
        return this.getMeisaiGokeiHenshuPanel().getKogakuKyufuKonkyoPanel().getRdbGassan();
    }

    @JsonIgnore
    public void  setRdbGassan(RadioButton rdbGassan) {
        this.getMeisaiGokeiHenshuPanel().getKogakuKyufuKonkyoPanel().setRdbGassan(rdbGassan);
    }

    @JsonIgnore
    public RadioButton getRdbRoreiFukushiNenkin() {
        return this.getMeisaiGokeiHenshuPanel().getKogakuKyufuKonkyoPanel().getRdbRoreiFukushiNenkin();
    }

    @JsonIgnore
    public void  setRdbRoreiFukushiNenkin(RadioButton rdbRoreiFukushiNenkin) {
        this.getMeisaiGokeiHenshuPanel().getKogakuKyufuKonkyoPanel().setRdbRoreiFukushiNenkin(rdbRoreiFukushiNenkin);
    }

    @JsonIgnore
    public RadioButton getRdbRiyoshafutanDai2dankai() {
        return this.getMeisaiGokeiHenshuPanel().getKogakuKyufuKonkyoPanel().getRdbRiyoshafutanDai2dankai();
    }

    @JsonIgnore
    public void  setRdbRiyoshafutanDai2dankai(RadioButton rdbRiyoshafutanDai2dankai) {
        this.getMeisaiGokeiHenshuPanel().getKogakuKyufuKonkyoPanel().setRdbRiyoshafutanDai2dankai(rdbRiyoshafutanDai2dankai);
    }

    @JsonIgnore
    public RadioButton getRdbGekihenkanwaKubun() {
        return this.getMeisaiGokeiHenshuPanel().getKogakuKyufuKonkyoPanel().getRdbGekihenkanwaKubun();
    }

    @JsonIgnore
    public void  setRdbGekihenkanwaKubun(RadioButton rdbGekihenkanwaKubun) {
        this.getMeisaiGokeiHenshuPanel().getKogakuKyufuKonkyoPanel().setRdbGekihenkanwaKubun(rdbGekihenkanwaKubun);
    }

    @JsonIgnore
    public Button getBtnTorikeshi() {
        return this.getMeisaiGokeiHenshuPanel().getBtnTorikeshi();
    }

    @JsonIgnore
    public void  setBtnTorikeshi(Button btnTorikeshi) {
        this.getMeisaiGokeiHenshuPanel().setBtnTorikeshi(btnTorikeshi);
    }

    @JsonIgnore
    public Button getBtnkakutei() {
        return this.getMeisaiGokeiHenshuPanel().getBtnkakutei();
    }

    @JsonIgnore
    public void  setBtnkakutei(Button btnkakutei) {
        this.getMeisaiGokeiHenshuPanel().setBtnkakutei(btnkakutei);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
