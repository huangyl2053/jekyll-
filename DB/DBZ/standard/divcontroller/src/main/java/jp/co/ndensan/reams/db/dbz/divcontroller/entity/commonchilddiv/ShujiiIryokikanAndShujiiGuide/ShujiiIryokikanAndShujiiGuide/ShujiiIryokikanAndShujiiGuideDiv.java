package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuide;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujiiGuideHandler;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * ShujiiIryokikanAndShujiiGuide のクラスファイル
 *
 * @reamsid_L DBZ-1300-130 xuyannan
 */
public class ShujiiIryokikanAndShujiiGuideDiv extends Panel implements IShujiiIryokikanAndShujiiGuideDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakuJoken")
    private KensakuJokenDiv KensakuJoken;
    @JsonProperty("KensakuKekkaIchiran")
    private KensakuKekkaIchiranDiv KensakuKekkaIchiran;
    @JsonProperty("btnBack")
    private Button btnBack;
    @JsonProperty("hdnDatabaseSubGyomuCode")
    private RString hdnDatabaseSubGyomuCode;
    @JsonProperty("hdnShujiiIryoKikanCode")
    private RString hdnShujiiIryoKikanCode;
    @JsonProperty("hdnShujiiCode")
    private RString hdnShujiiCode;
    @JsonProperty("hdnDataPass")
    private RString hdnDataPass;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKensakuJoken
     * @return KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public KensakuJokenDiv getKensakuJoken() {
        return KensakuJoken;
    }

    /*
     * setKensakuJoken
     * @param KensakuJoken KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public void setKensakuJoken(KensakuJokenDiv KensakuJoken) {
        this.KensakuJoken = KensakuJoken;
    }

    /*
     * getKensakuKekkaIchiran
     * @return KensakuKekkaIchiran
     */
    @JsonProperty("KensakuKekkaIchiran")
    public KensakuKekkaIchiranDiv getKensakuKekkaIchiran() {
        return KensakuKekkaIchiran;
    }

    /*
     * setKensakuKekkaIchiran
     * @param KensakuKekkaIchiran KensakuKekkaIchiran
     */
    @JsonProperty("KensakuKekkaIchiran")
    public void setKensakuKekkaIchiran(KensakuKekkaIchiranDiv KensakuKekkaIchiran) {
        this.KensakuKekkaIchiran = KensakuKekkaIchiran;
    }

    /*
     * getbtnBack
     * @return btnBack
     */
    @JsonProperty("btnBack")
    public Button getBtnBack() {
        return btnBack;
    }

    /*
     * setbtnBack
     * @param btnBack btnBack
     */
    @JsonProperty("btnBack")
    public void setBtnBack(Button btnBack) {
        this.btnBack = btnBack;
    }

    /*
     * gethdnDatabaseSubGyomuCode
     * @return hdnDatabaseSubGyomuCode
     */
    @JsonProperty("hdnDatabaseSubGyomuCode")
    public RString getHdnDatabaseSubGyomuCode() {
        return hdnDatabaseSubGyomuCode;
    }

    /*
     * sethdnDatabaseSubGyomuCode
     * @param hdnDatabaseSubGyomuCode hdnDatabaseSubGyomuCode
     */
    @JsonProperty("hdnDatabaseSubGyomuCode")
    public void setHdnDatabaseSubGyomuCode(RString hdnDatabaseSubGyomuCode) {
        this.hdnDatabaseSubGyomuCode = hdnDatabaseSubGyomuCode;
    }

    /*
     * gethdnShujiiIryoKikanCode
     * @return hdnShujiiIryoKikanCode
     */
    @JsonProperty("hdnShujiiIryoKikanCode")
    public RString getHdnShujiiIryoKikanCode() {
        return hdnShujiiIryoKikanCode;
    }

    /*
     * sethdnShujiiIryoKikanCode
     * @param hdnShujiiIryoKikanCode hdnShujiiIryoKikanCode
     */
    @JsonProperty("hdnShujiiIryoKikanCode")
    public void setHdnShujiiIryoKikanCode(RString hdnShujiiIryoKikanCode) {
        this.hdnShujiiIryoKikanCode = hdnShujiiIryoKikanCode;
    }

    /*
     * gethdnShujiiCode
     * @return hdnShujiiCode
     */
    @JsonProperty("hdnShujiiCode")
    public RString getHdnShujiiCode() {
        return hdnShujiiCode;
    }

    /*
     * sethdnShujiiCode
     * @param hdnShujiiCode hdnShujiiCode
     */
    @JsonProperty("hdnShujiiCode")
    public void setHdnShujiiCode(RString hdnShujiiCode) {
        this.hdnShujiiCode = hdnShujiiCode;
    }

    /*
     * gethdnDataPass
     * @return hdnDataPass
     */
    @JsonProperty("hdnDataPass")
    public RString getHdnDataPass() {
        return hdnDataPass;
    }

    /*
     * sethdnDataPass
     * @param hdnDataPass hdnDataPass
     */
    @JsonProperty("hdnDataPass")
    public void setHdnDataPass(RString hdnDataPass) {
        this.hdnDataPass = hdnDataPass;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum TaishoMode implements ICommonChildDivMode {

        IryoKikanMode("IryoKikanMode"),
        ShujiiMode("ShujiiMode");

        private final String name;

        private TaishoMode(final String name) {
            this.name = name;
        }

        public static TaishoMode getEnum(String str) {
            TaishoMode[] enumArray = TaishoMode.values();

            for (TaishoMode enumStr : enumArray) {
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

    public TaishoMode getMode_TaishoMode() {
        return (TaishoMode) _CommonChildDivModeUtil.getMode( this.modes, TaishoMode.class );
    }

    public void setMode_TaishoMode( TaishoMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, TaishoMode.class , value );
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IHokenshaListDiv getHokenshaList() {
        return this.getKensakuJoken().getHokenshaList();
    }

    @JsonIgnore
    public TextBoxCode getTxtIryoKikanCodeFrom() {
        return this.getKensakuJoken().getTxtIryoKikanCodeFrom();
    }

    @JsonIgnore
    public void  setTxtIryoKikanCodeFrom(TextBoxCode txtIryoKikanCodeFrom) {
        this.getKensakuJoken().setTxtIryoKikanCodeFrom(txtIryoKikanCodeFrom);
    }

    @JsonIgnore
    public TextBoxCode getTxtIryoKikanCodeTo() {
        return this.getKensakuJoken().getTxtIryoKikanCodeTo();
    }

    @JsonIgnore
    public void  setTxtIryoKikanCodeTo(TextBoxCode txtIryoKikanCodeTo) {
        this.getKensakuJoken().setTxtIryoKikanCodeTo(txtIryoKikanCodeTo);
    }

    @JsonIgnore
    public RadioButton getRadIryoKikanJokyo() {
        return this.getKensakuJoken().getRadIryoKikanJokyo();
    }

    @JsonIgnore
    public void  setRadIryoKikanJokyo(RadioButton radIryoKikanJokyo) {
        this.getKensakuJoken().setRadIryoKikanJokyo(radIryoKikanJokyo);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanName() {
        return this.getKensakuJoken().getTxtIryoKikanName();
    }

    @JsonIgnore
    public void  setTxtIryoKikanName(TextBox txtIryoKikanName) {
        this.getKensakuJoken().setTxtIryoKikanName(txtIryoKikanName);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanKanaMeisho() {
        return this.getKensakuJoken().getTxtIryoKikanKanaMeisho();
    }

    @JsonIgnore
    public void  setTxtIryoKikanKanaMeisho(TextBox txtIryoKikanKanaMeisho) {
        this.getKensakuJoken().setTxtIryoKikanKanaMeisho(txtIryoKikanKanaMeisho);
    }

    @JsonIgnore
    public TextBoxCode getTxtShuijiiCodeFrom() {
        return this.getKensakuJoken().getTxtShuijiiCodeFrom();
    }

    @JsonIgnore
    public void  setTxtShuijiiCodeFrom(TextBoxCode txtShuijiiCodeFrom) {
        this.getKensakuJoken().setTxtShuijiiCodeFrom(txtShuijiiCodeFrom);
    }

    @JsonIgnore
    public TextBoxCode getTxtShujiiCodeTo() {
        return this.getKensakuJoken().getTxtShujiiCodeTo();
    }

    @JsonIgnore
    public void  setTxtShujiiCodeTo(TextBoxCode txtShujiiCodeTo) {
        this.getKensakuJoken().setTxtShujiiCodeTo(txtShujiiCodeTo);
    }

    @JsonIgnore
    public RadioButton getRadShujiiJokyo() {
        return this.getKensakuJoken().getRadShujiiJokyo();
    }

    @JsonIgnore
    public void  setRadShujiiJokyo(RadioButton radShujiiJokyo) {
        this.getKensakuJoken().setRadShujiiJokyo(radShujiiJokyo);
    }

    @JsonIgnore
    public TextBox getTxtShujiiShimei() {
        return this.getKensakuJoken().getTxtShujiiShimei();
    }

    @JsonIgnore
    public void  setTxtShujiiShimei(TextBox txtShujiiShimei) {
        this.getKensakuJoken().setTxtShujiiShimei(txtShujiiShimei);
    }

    @JsonIgnore
    public TextBox getTxtShujiiKanaShimei() {
        return this.getKensakuJoken().getTxtShujiiKanaShimei();
    }

    @JsonIgnore
    public void  setTxtShujiiKanaShimei(TextBox txtShujiiKanaShimei) {
        this.getKensakuJoken().setTxtShujiiKanaShimei(txtShujiiKanaShimei);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxKensu() {
        return this.getKensakuJoken().getTxtMaxKensu();
    }

    @JsonIgnore
    public void  setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.getKensakuJoken().setTxtMaxKensu(txtMaxKensu);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getKensakuJoken().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getKensakuJoken().setBtnClear(btnClear);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getKensakuJoken().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getKensakuJoken().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public DataGrid<dgKensakuKekkaIchiran_Row> getDgKensakuKekkaIchiran() {
        return this.getKensakuKekkaIchiran().getDgKensakuKekkaIchiran();
    }

    @JsonIgnore
    public void  setDgKensakuKekkaIchiran(DataGrid<dgKensakuKekkaIchiran_Row> dgKensakuKekkaIchiran) {
        this.getKensakuKekkaIchiran().setDgKensakuKekkaIchiran(dgKensakuKekkaIchiran);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private ShujiiIryokikanAndShujiiGuideHandler getHandler(ShujiiIryokikanAndShujiiGuideDiv requestDiv) {
        return new ShujiiIryokikanAndShujiiGuideHandler(requestDiv);
    }

    /**
     * 主治医医療機関＆主治医ガイドに初期化を設定します。
     */
    @Override
    public void initialize() {
        getHandler(this).intialize();
    }
}
