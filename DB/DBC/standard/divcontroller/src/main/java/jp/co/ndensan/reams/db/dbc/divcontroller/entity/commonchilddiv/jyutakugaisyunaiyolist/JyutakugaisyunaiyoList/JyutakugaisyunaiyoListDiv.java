package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jyutakugaisyunaiyolist.JyutakugaisyunaiyoListDataPassModel;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoListHandler;

/**
 * JyutakugaisyunaiyoList のクラスファイル
 *
 * @reamsid_L DBC-0940-010 yaodongsheng
 */
public class JyutakugaisyunaiyoListDiv extends Panel implements IJyutakugaisyunaiyoListDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("PnlGaisyuListArea")
    private PnlGaisyuListAreaDiv PnlGaisyuListArea;
    @JsonProperty("PnlNyuryokuArea")
    private PnlNyuryokuAreaDiv PnlNyuryokuArea;
    @JsonProperty("hiddenPass")
    private RString hiddenPass;
    @JsonProperty("jushoData")
    private RString jushoData;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getPnlGaisyuListArea
     * @return PnlGaisyuListArea
     */
    @JsonProperty("PnlGaisyuListArea")
    public PnlGaisyuListAreaDiv getPnlGaisyuListArea() {
        return PnlGaisyuListArea;
    }

    /*
     * setPnlGaisyuListArea
     * @param PnlGaisyuListArea PnlGaisyuListArea
     */
    @JsonProperty("PnlGaisyuListArea")
    public void setPnlGaisyuListArea(PnlGaisyuListAreaDiv PnlGaisyuListArea) {
        this.PnlGaisyuListArea = PnlGaisyuListArea;
    }

    /*
     * getPnlNyuryokuArea
     * @return PnlNyuryokuArea
     */
    @JsonProperty("PnlNyuryokuArea")
    public PnlNyuryokuAreaDiv getPnlNyuryokuArea() {
        return PnlNyuryokuArea;
    }

    /*
     * setPnlNyuryokuArea
     * @param PnlNyuryokuArea PnlNyuryokuArea
     */
    @JsonProperty("PnlNyuryokuArea")
    public void setPnlNyuryokuArea(PnlNyuryokuAreaDiv PnlNyuryokuArea) {
        this.PnlNyuryokuArea = PnlNyuryokuArea;
    }

    /*
     * gethiddenPass
     * @return hiddenPass
     */
    @JsonProperty("hiddenPass")
    public RString getHiddenPass() {
        return hiddenPass;
    }

    /*
     * sethiddenPass
     * @param hiddenPass hiddenPass
     */
    @JsonProperty("hiddenPass")
    public void setHiddenPass(RString hiddenPass) {
        this.hiddenPass = hiddenPass;
    }

    /*
     * getjushoData
     * @return jushoData
     */
    @JsonProperty("jushoData")
    public RString getJushoData() {
        return jushoData;
    }

    /*
     * setjushoData
     * @param jushoData jushoData
     */
    @JsonProperty("jushoData")
    public void setJushoData(RString jushoData) {
        this.jushoData = jushoData;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum State implements ICommonChildDivMode {

        touroku("touroku"),
        teisei("teisei"),
        sansyo("sansyo");

        private final String name;

        private State(final String name) {
            this.name = name;
        }

        public static State getEnum(String str) {
            State[] enumArray = State.values();

            for (State enumStr : enumArray) {
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

    public State getMode_State() {
        return (State) _CommonChildDivModeUtil.getMode( this.modes, State.class );
    }

    public void setMode_State( State value ) {
        _CommonChildDivModeUtil.setMode( this.modes, State.class , value );
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnDetailAdd() {
        return this.getPnlGaisyuListArea().getBtnDetailAdd();
    }

    @JsonIgnore
    public void  setBtnDetailAdd(Button btnDetailAdd) {
        this.getPnlGaisyuListArea().setBtnDetailAdd(btnDetailAdd);
    }

    @JsonIgnore
    public DataGrid<dgGaisyuList_Row> getDgGaisyuList() {
        return this.getPnlGaisyuListArea().getDgGaisyuList();
    }

    @JsonIgnore
    public void  setDgGaisyuList(DataGrid<dgGaisyuList_Row> dgGaisyuList) {
        this.getPnlGaisyuListArea().setDgGaisyuList(dgGaisyuList);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKaisyunaiyo() {
        return this.getPnlNyuryokuArea().getTxtKaisyunaiyo();
    }

    @JsonIgnore
    public void  setTxtKaisyunaiyo(TextBoxMultiLine txtKaisyunaiyo) {
        this.getPnlNyuryokuArea().setTxtKaisyunaiyo(txtKaisyunaiyo);
    }

    @JsonIgnore
    public TextBox getTxtJigyosya() {
        return this.getPnlNyuryokuArea().getTxtJigyosya();
    }

    @JsonIgnore
    public void  setTxtJigyosya(TextBox txtJigyosya) {
        this.getPnlNyuryokuArea().setTxtJigyosya(txtJigyosya);
    }

    @JsonIgnore
    public Label getLblTaisyojyutakujyusyo() {
        return this.getPnlNyuryokuArea().getLblTaisyojyutakujyusyo();
    }

    @JsonIgnore
    public void  setLblTaisyojyutakujyusyo(Label lblTaisyojyutakujyusyo) {
        this.getPnlNyuryokuArea().setLblTaisyojyutakujyusyo(lblTaisyojyutakujyusyo);
    }

    @JsonIgnore
    public Button getBtnHonnijyusyoCopy() {
        return this.getPnlNyuryokuArea().getBtnHonnijyusyoCopy();
    }

    @JsonIgnore
    public void  setBtnHonnijyusyoCopy(Button btnHonnijyusyoCopy) {
        this.getPnlNyuryokuArea().setBtnHonnijyusyoCopy(btnHonnijyusyoCopy);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJyusyo() {
        return this.getPnlNyuryokuArea().getTxtJyusyo();
    }

    @JsonIgnore
    public void  setTxtJyusyo(TextBoxJusho txtJyusyo) {
        this.getPnlNyuryokuArea().setTxtJyusyo(txtJyusyo);
    }

    @JsonIgnore
    public TextBoxDate getTxtTyakkoyotebi() {
        return this.getPnlNyuryokuArea().getTxtTyakkoyotebi();
    }

    @JsonIgnore
    public void  setTxtTyakkoyotebi(TextBoxDate txtTyakkoyotebi) {
        this.getPnlNyuryokuArea().setTxtTyakkoyotebi(txtTyakkoyotebi);
    }

    @JsonIgnore
    public TextBoxDate getTxtKanseyotebi() {
        return this.getPnlNyuryokuArea().getTxtKanseyotebi();
    }

    @JsonIgnore
    public void  setTxtKanseyotebi(TextBoxDate txtKanseyotebi) {
        this.getPnlNyuryokuArea().setTxtKanseyotebi(txtKanseyotebi);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaisyukingaku() {
        return this.getPnlNyuryokuArea().getTxtKaisyukingaku();
    }

    @JsonIgnore
    public void  setTxtKaisyukingaku(TextBoxNum txtKaisyukingaku) {
        this.getPnlNyuryokuArea().setTxtKaisyukingaku(txtKaisyukingaku);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getPnlNyuryokuArea().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getPnlNyuryokuArea().setBtnClear(btnClear);
    }

    @JsonIgnore
    public Button getBtnDetailConfirm() {
        return this.getPnlNyuryokuArea().getBtnDetailConfirm();
    }

    @JsonIgnore
    public void  setBtnDetailConfirm(Button btnDetailConfirm) {
        this.getPnlNyuryokuArea().setBtnDetailConfirm(btnDetailConfirm);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private JyutakugaisyunaiyoListHandler getHandler() {
        return new JyutakugaisyunaiyoListHandler(this);
    }

    @Override
    public void initialize(JyutakugaisyunaiyoListDataPassModel model) {
        getHandler().initialize(model);
    }

    @Override
    public List<dgGaisyuList_Row> get住宅改修内容一覧() {
        return getHandler().get住宅改修内容一覧();
    }

}
