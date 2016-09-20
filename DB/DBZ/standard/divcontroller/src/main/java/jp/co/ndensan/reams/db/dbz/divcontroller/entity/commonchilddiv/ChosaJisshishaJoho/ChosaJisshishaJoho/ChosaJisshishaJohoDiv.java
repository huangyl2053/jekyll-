package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbz.definition.core.chosajisshishajoho.ChosaJisshishaJohoModel;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * ChosaJisshishaJoho のクラスファイル 
 * 
 * @reamsid_L DBE-3000-100 dongyabin
 */
public class ChosaJisshishaJohoDiv extends Panel implements IChosaJisshishaJohoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChosaJisshiDate")
    private TextBoxDate txtChosaJisshiDate;
    @JsonProperty("ddlChosaJisshiBasho")
    private DropDownList ddlChosaJisshiBasho;
    @JsonProperty("txtJisshiBashoMeisho")
    private TextBox txtJisshiBashoMeisho;
    @JsonProperty("ddlShozokuKikan")
    private DropDownList ddlShozokuKikan;
    @JsonProperty("ddlKinyusha")
    private DropDownList ddlKinyusha;
    @JsonProperty("txtChosaKubun")
    private TextBox txtChosaKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChosaJisshiDate
     * @return txtChosaJisshiDate
     */
    @JsonProperty("txtChosaJisshiDate")
    public TextBoxDate getTxtChosaJisshiDate() {
        return txtChosaJisshiDate;
    }

    /*
     * settxtChosaJisshiDate
     * @param txtChosaJisshiDate txtChosaJisshiDate
     */
    @JsonProperty("txtChosaJisshiDate")
    public void setTxtChosaJisshiDate(TextBoxDate txtChosaJisshiDate) {
        this.txtChosaJisshiDate = txtChosaJisshiDate;
    }

    /*
     * getddlChosaJisshiBasho
     * @return ddlChosaJisshiBasho
     */
    @JsonProperty("ddlChosaJisshiBasho")
    public DropDownList getDdlChosaJisshiBasho() {
        return ddlChosaJisshiBasho;
    }

    /*
     * setddlChosaJisshiBasho
     * @param ddlChosaJisshiBasho ddlChosaJisshiBasho
     */
    @JsonProperty("ddlChosaJisshiBasho")
    public void setDdlChosaJisshiBasho(DropDownList ddlChosaJisshiBasho) {
        this.ddlChosaJisshiBasho = ddlChosaJisshiBasho;
    }

    /*
     * gettxtJisshiBashoMeisho
     * @return txtJisshiBashoMeisho
     */
    @JsonProperty("txtJisshiBashoMeisho")
    public TextBox getTxtJisshiBashoMeisho() {
        return txtJisshiBashoMeisho;
    }

    /*
     * settxtJisshiBashoMeisho
     * @param txtJisshiBashoMeisho txtJisshiBashoMeisho
     */
    @JsonProperty("txtJisshiBashoMeisho")
    public void setTxtJisshiBashoMeisho(TextBox txtJisshiBashoMeisho) {
        this.txtJisshiBashoMeisho = txtJisshiBashoMeisho;
    }

    /*
     * getddlShozokuKikan
     * @return ddlShozokuKikan
     */
    @JsonProperty("ddlShozokuKikan")
    public DropDownList getDdlShozokuKikan() {
        return ddlShozokuKikan;
    }

    /*
     * setddlShozokuKikan
     * @param ddlShozokuKikan ddlShozokuKikan
     */
    @JsonProperty("ddlShozokuKikan")
    public void setDdlShozokuKikan(DropDownList ddlShozokuKikan) {
        this.ddlShozokuKikan = ddlShozokuKikan;
    }

    /*
     * getddlKinyusha
     * @return ddlKinyusha
     */
    @JsonProperty("ddlKinyusha")
    public DropDownList getDdlKinyusha() {
        return ddlKinyusha;
    }

    /*
     * setddlKinyusha
     * @param ddlKinyusha ddlKinyusha
     */
    @JsonProperty("ddlKinyusha")
    public void setDdlKinyusha(DropDownList ddlKinyusha) {
        this.ddlKinyusha = ddlKinyusha;
    }

    /*
     * gettxtChosaKubun
     * @return txtChosaKubun
     */
    @JsonProperty("txtChosaKubun")
    public TextBox getTxtChosaKubun() {
        return txtChosaKubun;
    }

    /*
     * settxtChosaKubun
     * @param txtChosaKubun txtChosaKubun
     */
    @JsonProperty("txtChosaKubun")
    public void setTxtChosaKubun(TextBox txtChosaKubun) {
        this.txtChosaKubun = txtChosaKubun;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum State implements ICommonChildDivMode {

        Input("Input"),
        Shokai("Shokai");

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

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    
    /**
     * 調査実施者(記入者)Divの初期化します。
     * @param key 親画面から受け取ったパラメータ
     */
    @Override
    public void intialize(ChosaJisshishaJohoModel key) {
        getHandler(this).intialize(key);
    }
    
    private ChosaJisshishaJohoHandler getHandler(ChosaJisshishaJohoDiv div) {
        return new ChosaJisshishaJohoHandler(div);
    }
}
