package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJoho;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * IchijiHanteiKekkaJoho のクラスファイル
 *
 * @author 自動生成
 */
public class IchijiHanteiKekkaJohoDiv extends Panel implements IIchijiHanteiKekkaJohoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnIchijiHantei")
    private Button btnIchijiHantei;
    @JsonProperty("btnAfterIchijiHantei")
    private Button btnAfterIchijiHantei;
    @JsonProperty("txtIchijiHanteibi")
    private TextBoxFlexibleDate txtIchijiHanteibi;
    @JsonProperty("ddlIchijiHanteiKekka")
    private DropDownList ddlIchijiHanteiKekka;
    @JsonProperty("ddlIchijiHanteiKekkaNinchishoKasan")
    private DropDownList ddlIchijiHanteiKekkaNinchishoKasan;
    @JsonProperty("txtKijunJikan")
    private TextBoxNum txtKijunJikan;
    @JsonProperty("lblChukanHyokaKomokuTokuten")
    private Label lblChukanHyokaKomokuTokuten;
    @JsonProperty("tblKijunJikan")
    private tblKijunJikanDiv tblKijunJikan;
    @JsonProperty("tblTyukanHyokaKomokuTokuten")
    private tblTyukanHyokaKomokuTokutenDiv tblTyukanHyokaKomokuTokuten;
    @JsonProperty("lblNichiJyotaiHyokaKekka")
    private Label lblNichiJyotaiHyokaKekka;
    @JsonProperty("lblNinchiNichijyoSeikatsuJiritsudo")
    private Label lblNinchiNichijyoSeikatsuJiritsudo;
    @JsonProperty("txtGaizensei")
    private TextBoxNum txtGaizensei;
    @JsonProperty("ddlJiritsudoChosa")
    private DropDownList ddlJiritsudoChosa;
    @JsonProperty("ddlJyotaiAnteisei")
    private DropDownList ddlJyotaiAnteisei;
    @JsonProperty("ddlJiritsudoIkensho")
    private DropDownList ddlJiritsudoIkensho;
    @JsonProperty("ddlKyufuKbn")
    private DropDownList ddlKyufuKbn;
    @JsonProperty("lblIchijiHanteiKeikokuCode")
    private Label lblIchijiHanteiKeikokuCode;
    @JsonProperty("dgIchijiHanteiKeikokuCode")
    private DataGrid<dgIchijiHanteiKeikokuCode_Row> dgIchijiHanteiKeikokuCode;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnModoru")
    private Button btnModoru;
    @JsonProperty("hanteiArgument")
    private RString hanteiArgument;
    @JsonProperty("hanteiResult")
    private RString hanteiResult;
    @JsonProperty("shinseishoKanriNo")
    private RString shinseishoKanriNo;
    @JsonProperty("modeType")
    private RString modeType;
    @JsonProperty("ichijiHanteiKekka")
    private RString ichijiHanteiKekka;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnIchijiHantei
     * @return btnIchijiHantei
     */
    @JsonProperty("btnIchijiHantei")
    public Button getBtnIchijiHantei() {
        return btnIchijiHantei;
    }

    /*
     * setbtnIchijiHantei
     * @param btnIchijiHantei btnIchijiHantei
     */
    @JsonProperty("btnIchijiHantei")
    public void setBtnIchijiHantei(Button btnIchijiHantei) {
        this.btnIchijiHantei = btnIchijiHantei;
    }

    /*
     * getbtnAfterIchijiHantei
     * @return btnAfterIchijiHantei
     */
    @JsonProperty("btnAfterIchijiHantei")
    public Button getBtnAfterIchijiHantei() {
        return btnAfterIchijiHantei;
    }

    /*
     * setbtnAfterIchijiHantei
     * @param btnAfterIchijiHantei btnAfterIchijiHantei
     */
    @JsonProperty("btnAfterIchijiHantei")
    public void setBtnAfterIchijiHantei(Button btnAfterIchijiHantei) {
        this.btnAfterIchijiHantei = btnAfterIchijiHantei;
    }

    /*
     * gettxtIchijiHanteibi
     * @return txtIchijiHanteibi
     */
    @JsonProperty("txtIchijiHanteibi")
    public TextBoxFlexibleDate getTxtIchijiHanteibi() {
        return txtIchijiHanteibi;
    }

    /*
     * settxtIchijiHanteibi
     * @param txtIchijiHanteibi txtIchijiHanteibi
     */
    @JsonProperty("txtIchijiHanteibi")
    public void setTxtIchijiHanteibi(TextBoxFlexibleDate txtIchijiHanteibi) {
        this.txtIchijiHanteibi = txtIchijiHanteibi;
    }

    /*
     * getddlIchijiHanteiKekka
     * @return ddlIchijiHanteiKekka
     */
    @JsonProperty("ddlIchijiHanteiKekka")
    public DropDownList getDdlIchijiHanteiKekka() {
        return ddlIchijiHanteiKekka;
    }

    /*
     * setddlIchijiHanteiKekka
     * @param ddlIchijiHanteiKekka ddlIchijiHanteiKekka
     */
    @JsonProperty("ddlIchijiHanteiKekka")
    public void setDdlIchijiHanteiKekka(DropDownList ddlIchijiHanteiKekka) {
        this.ddlIchijiHanteiKekka = ddlIchijiHanteiKekka;
    }

    /*
     * getddlIchijiHanteiKekkaNinchishoKasan
     * @return ddlIchijiHanteiKekkaNinchishoKasan
     */
    @JsonProperty("ddlIchijiHanteiKekkaNinchishoKasan")
    public DropDownList getDdlIchijiHanteiKekkaNinchishoKasan() {
        return ddlIchijiHanteiKekkaNinchishoKasan;
    }

    /*
     * setddlIchijiHanteiKekkaNinchishoKasan
     * @param ddlIchijiHanteiKekkaNinchishoKasan ddlIchijiHanteiKekkaNinchishoKasan
     */
    @JsonProperty("ddlIchijiHanteiKekkaNinchishoKasan")
    public void setDdlIchijiHanteiKekkaNinchishoKasan(DropDownList ddlIchijiHanteiKekkaNinchishoKasan) {
        this.ddlIchijiHanteiKekkaNinchishoKasan = ddlIchijiHanteiKekkaNinchishoKasan;
    }

    /*
     * gettxtKijunJikan
     * @return txtKijunJikan
     */
    @JsonProperty("txtKijunJikan")
    public TextBoxNum getTxtKijunJikan() {
        return txtKijunJikan;
    }

    /*
     * settxtKijunJikan
     * @param txtKijunJikan txtKijunJikan
     */
    @JsonProperty("txtKijunJikan")
    public void setTxtKijunJikan(TextBoxNum txtKijunJikan) {
        this.txtKijunJikan = txtKijunJikan;
    }

    /*
     * getlblChukanHyokaKomokuTokuten
     * @return lblChukanHyokaKomokuTokuten
     */
    @JsonProperty("lblChukanHyokaKomokuTokuten")
    public Label getLblChukanHyokaKomokuTokuten() {
        return lblChukanHyokaKomokuTokuten;
    }

    /*
     * setlblChukanHyokaKomokuTokuten
     * @param lblChukanHyokaKomokuTokuten lblChukanHyokaKomokuTokuten
     */
    @JsonProperty("lblChukanHyokaKomokuTokuten")
    public void setLblChukanHyokaKomokuTokuten(Label lblChukanHyokaKomokuTokuten) {
        this.lblChukanHyokaKomokuTokuten = lblChukanHyokaKomokuTokuten;
    }

    /*
     * gettblKijunJikan
     * @return tblKijunJikan
     */
    @JsonProperty("tblKijunJikan")
    public tblKijunJikanDiv getTblKijunJikan() {
        return tblKijunJikan;
    }

    /*
     * settblKijunJikan
     * @param tblKijunJikan tblKijunJikan
     */
    @JsonProperty("tblKijunJikan")
    public void setTblKijunJikan(tblKijunJikanDiv tblKijunJikan) {
        this.tblKijunJikan = tblKijunJikan;
    }

    /*
     * gettblTyukanHyokaKomokuTokuten
     * @return tblTyukanHyokaKomokuTokuten
     */
    @JsonProperty("tblTyukanHyokaKomokuTokuten")
    public tblTyukanHyokaKomokuTokutenDiv getTblTyukanHyokaKomokuTokuten() {
        return tblTyukanHyokaKomokuTokuten;
    }

    /*
     * settblTyukanHyokaKomokuTokuten
     * @param tblTyukanHyokaKomokuTokuten tblTyukanHyokaKomokuTokuten
     */
    @JsonProperty("tblTyukanHyokaKomokuTokuten")
    public void setTblTyukanHyokaKomokuTokuten(tblTyukanHyokaKomokuTokutenDiv tblTyukanHyokaKomokuTokuten) {
        this.tblTyukanHyokaKomokuTokuten = tblTyukanHyokaKomokuTokuten;
    }

    /*
     * getlblNichiJyotaiHyokaKekka
     * @return lblNichiJyotaiHyokaKekka
     */
    @JsonProperty("lblNichiJyotaiHyokaKekka")
    public Label getLblNichiJyotaiHyokaKekka() {
        return lblNichiJyotaiHyokaKekka;
    }

    /*
     * setlblNichiJyotaiHyokaKekka
     * @param lblNichiJyotaiHyokaKekka lblNichiJyotaiHyokaKekka
     */
    @JsonProperty("lblNichiJyotaiHyokaKekka")
    public void setLblNichiJyotaiHyokaKekka(Label lblNichiJyotaiHyokaKekka) {
        this.lblNichiJyotaiHyokaKekka = lblNichiJyotaiHyokaKekka;
    }

    /*
     * getlblNinchiNichijyoSeikatsuJiritsudo
     * @return lblNinchiNichijyoSeikatsuJiritsudo
     */
    @JsonProperty("lblNinchiNichijyoSeikatsuJiritsudo")
    public Label getLblNinchiNichijyoSeikatsuJiritsudo() {
        return lblNinchiNichijyoSeikatsuJiritsudo;
    }

    /*
     * setlblNinchiNichijyoSeikatsuJiritsudo
     * @param lblNinchiNichijyoSeikatsuJiritsudo lblNinchiNichijyoSeikatsuJiritsudo
     */
    @JsonProperty("lblNinchiNichijyoSeikatsuJiritsudo")
    public void setLblNinchiNichijyoSeikatsuJiritsudo(Label lblNinchiNichijyoSeikatsuJiritsudo) {
        this.lblNinchiNichijyoSeikatsuJiritsudo = lblNinchiNichijyoSeikatsuJiritsudo;
    }

    /*
     * gettxtGaizensei
     * @return txtGaizensei
     */
    @JsonProperty("txtGaizensei")
    public TextBoxNum getTxtGaizensei() {
        return txtGaizensei;
    }

    /*
     * settxtGaizensei
     * @param txtGaizensei txtGaizensei
     */
    @JsonProperty("txtGaizensei")
    public void setTxtGaizensei(TextBoxNum txtGaizensei) {
        this.txtGaizensei = txtGaizensei;
    }

    /*
     * getddlJiritsudoChosa
     * @return ddlJiritsudoChosa
     */
    @JsonProperty("ddlJiritsudoChosa")
    public DropDownList getDdlJiritsudoChosa() {
        return ddlJiritsudoChosa;
    }

    /*
     * setddlJiritsudoChosa
     * @param ddlJiritsudoChosa ddlJiritsudoChosa
     */
    @JsonProperty("ddlJiritsudoChosa")
    public void setDdlJiritsudoChosa(DropDownList ddlJiritsudoChosa) {
        this.ddlJiritsudoChosa = ddlJiritsudoChosa;
    }

    /*
     * getddlJyotaiAnteisei
     * @return ddlJyotaiAnteisei
     */
    @JsonProperty("ddlJyotaiAnteisei")
    public DropDownList getDdlJyotaiAnteisei() {
        return ddlJyotaiAnteisei;
    }

    /*
     * setddlJyotaiAnteisei
     * @param ddlJyotaiAnteisei ddlJyotaiAnteisei
     */
    @JsonProperty("ddlJyotaiAnteisei")
    public void setDdlJyotaiAnteisei(DropDownList ddlJyotaiAnteisei) {
        this.ddlJyotaiAnteisei = ddlJyotaiAnteisei;
    }

    /*
     * getddlJiritsudoIkensho
     * @return ddlJiritsudoIkensho
     */
    @JsonProperty("ddlJiritsudoIkensho")
    public DropDownList getDdlJiritsudoIkensho() {
        return ddlJiritsudoIkensho;
    }

    /*
     * setddlJiritsudoIkensho
     * @param ddlJiritsudoIkensho ddlJiritsudoIkensho
     */
    @JsonProperty("ddlJiritsudoIkensho")
    public void setDdlJiritsudoIkensho(DropDownList ddlJiritsudoIkensho) {
        this.ddlJiritsudoIkensho = ddlJiritsudoIkensho;
    }

    /*
     * getddlKyufuKbn
     * @return ddlKyufuKbn
     */
    @JsonProperty("ddlKyufuKbn")
    public DropDownList getDdlKyufuKbn() {
        return ddlKyufuKbn;
    }

    /*
     * setddlKyufuKbn
     * @param ddlKyufuKbn ddlKyufuKbn
     */
    @JsonProperty("ddlKyufuKbn")
    public void setDdlKyufuKbn(DropDownList ddlKyufuKbn) {
        this.ddlKyufuKbn = ddlKyufuKbn;
    }

    /*
     * getlblIchijiHanteiKeikokuCode
     * @return lblIchijiHanteiKeikokuCode
     */
    @JsonProperty("lblIchijiHanteiKeikokuCode")
    public Label getLblIchijiHanteiKeikokuCode() {
        return lblIchijiHanteiKeikokuCode;
    }

    /*
     * setlblIchijiHanteiKeikokuCode
     * @param lblIchijiHanteiKeikokuCode lblIchijiHanteiKeikokuCode
     */
    @JsonProperty("lblIchijiHanteiKeikokuCode")
    public void setLblIchijiHanteiKeikokuCode(Label lblIchijiHanteiKeikokuCode) {
        this.lblIchijiHanteiKeikokuCode = lblIchijiHanteiKeikokuCode;
    }

    /*
     * getdgIchijiHanteiKeikokuCode
     * @return dgIchijiHanteiKeikokuCode
     */
    @JsonProperty("dgIchijiHanteiKeikokuCode")
    public DataGrid<dgIchijiHanteiKeikokuCode_Row> getDgIchijiHanteiKeikokuCode() {
        return dgIchijiHanteiKeikokuCode;
    }

    /*
     * setdgIchijiHanteiKeikokuCode
     * @param dgIchijiHanteiKeikokuCode dgIchijiHanteiKeikokuCode
     */
    @JsonProperty("dgIchijiHanteiKeikokuCode")
    public void setDgIchijiHanteiKeikokuCode(DataGrid<dgIchijiHanteiKeikokuCode_Row> dgIchijiHanteiKeikokuCode) {
        this.dgIchijiHanteiKeikokuCode = dgIchijiHanteiKeikokuCode;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * getbtnModoru
     * @return btnModoru
     */
    @JsonProperty("btnModoru")
    public Button getBtnModoru() {
        return btnModoru;
    }

    /*
     * setbtnModoru
     * @param btnModoru btnModoru
     */
    @JsonProperty("btnModoru")
    public void setBtnModoru(Button btnModoru) {
        this.btnModoru = btnModoru;
    }

    /*
     * gethanteiArgument
     * @return hanteiArgument
     */
    @JsonProperty("hanteiArgument")
    public RString getHanteiArgument() {
        return hanteiArgument;
    }

    /*
     * sethanteiArgument
     * @param hanteiArgument hanteiArgument
     */
    @JsonProperty("hanteiArgument")
    public void setHanteiArgument(RString hanteiArgument) {
        this.hanteiArgument = hanteiArgument;
    }

    /*
     * gethanteiResult
     * @return hanteiResult
     */
    @JsonProperty("hanteiResult")
    public RString getHanteiResult() {
        return hanteiResult;
    }

    /*
     * sethanteiResult
     * @param hanteiResult hanteiResult
     */
    @JsonProperty("hanteiResult")
    public void setHanteiResult(RString hanteiResult) {
        this.hanteiResult = hanteiResult;
    }

    /*
     * getshinseishoKanriNo
     * @return shinseishoKanriNo
     */
    @JsonProperty("shinseishoKanriNo")
    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /*
     * setshinseishoKanriNo
     * @param shinseishoKanriNo shinseishoKanriNo
     */
    @JsonProperty("shinseishoKanriNo")
    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /*
     * getmodeType
     * @return modeType
     */
    @JsonProperty("modeType")
    public RString getModeType() {
        return modeType;
    }

    /*
     * setmodeType
     * @param modeType modeType
     */
    @JsonProperty("modeType")
    public void setModeType(RString modeType) {
        this.modeType = modeType;
    }

    /*
     * getichijiHanteiKekka
     * @return ichijiHanteiKekka
     */
    @JsonProperty("ichijiHanteiKekka")
    public RString getIchijiHanteiKekka() {
        return ichijiHanteiKekka;
    }

    /*
     * setichijiHanteiKekka
     * @param ichijiHanteiKekka ichijiHanteiKekka
     */
    @JsonProperty("ichijiHanteiKekka")
    public void setIchijiHanteiKekka(RString ichijiHanteiKekka) {
        this.ichijiHanteiKekka = ichijiHanteiKekka;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum State implements ICommonChildDivMode {

        shokai("shokai"),
        touroku("touroku");

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
    public Label getLblShokuji() {
        return this.getTblKijunJikan().getLblShokuji();
    }

    @JsonIgnore
    public Label getLblHaisetsu() {
        return this.getTblKijunJikan().getLblHaisetsu();
    }

    @JsonIgnore
    public Label getLblIdo() {
        return this.getTblKijunJikan().getLblIdo();
    }

    @JsonIgnore
    public Label getLblSeiketsuhoji() {
        return this.getTblKijunJikan().getLblSeiketsuhoji();
    }

    @JsonIgnore
    public Label getLblKansetsuCare() {
        return this.getTblKijunJikan().getLblKansetsuCare();
    }

    @JsonIgnore
    public Label getLblBpsdKanren() {
        return this.getTblKijunJikan().getLblBpsdKanren();
    }

    @JsonIgnore
    public Label getLblKinoKunren() {
        return this.getTblKijunJikan().getLblKinoKunren();
    }

    @JsonIgnore
    public Label getLblIryoKanren() {
        return this.getTblKijunJikan().getLblIryoKanren();
    }

    @JsonIgnore
    public Label getLblNinchishoKasan() {
        return this.getTblKijunJikan().getLblNinchishoKasan();
    }

    @JsonIgnore
    public TextBoxNum getTxtShokuji() {
        return this.getTblKijunJikan().getTxtShokuji();
    }

    @JsonIgnore
    public TextBoxNum getTxtHaisetsu() {
        return this.getTblKijunJikan().getTxtHaisetsu();
    }

    @JsonIgnore
    public TextBoxNum getTxtIdo() {
        return this.getTblKijunJikan().getTxtIdo();
    }

    @JsonIgnore
    public TextBoxNum getTxtSeiketsuHoji() {
        return this.getTblKijunJikan().getTxtSeiketsuHoji();
    }

    @JsonIgnore
    public TextBoxNum getTxtKansetsuCare() {
        return this.getTblKijunJikan().getTxtKansetsuCare();
    }

    @JsonIgnore
    public TextBoxNum getTxtBpsdKanren() {
        return this.getTblKijunJikan().getTxtBpsdKanren();
    }

    @JsonIgnore
    public TextBoxNum getTxtKinoKunren() {
        return this.getTblKijunJikan().getTxtKinoKunren();
    }

    @JsonIgnore
    public TextBoxNum getTxtIryoKanren() {
        return this.getTblKijunJikan().getTxtIryoKanren();
    }

    @JsonIgnore
    public TextBoxNum getTxtNinchishoKasan() {
        return this.getTblKijunJikan().getTxtNinchishoKasan();
    }

    @JsonIgnore
    public Label getLblDai1gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getLblDai1gun();
    }

    @JsonIgnore
    public Label getLblDai2gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getLblDai2gun();
    }

    @JsonIgnore
    public Label getLblDai3gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getLblDai3gun();
    }

    @JsonIgnore
    public Label getLblDai4gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getLblDai4gun();
    }

    @JsonIgnore
    public Label getLblDai5gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getLblDai5gun();
    }

    @JsonIgnore
    public Label getLblDai6gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getLblDai6gun();
    }

    @JsonIgnore
    public Label getLblDai7gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getLblDai7gun();
    }

    @JsonIgnore
    public TextBoxNum getTxtDai1gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getTxtDai1gun();
    }

    @JsonIgnore
    public TextBoxNum getTxtDai2gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getTxtDai2gun();
    }

    @JsonIgnore
    public TextBoxNum getTxtDai3gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getTxtDai3gun();
    }

    @JsonIgnore
    public TextBoxNum getTxtDai4gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getTxtDai4gun();
    }

    @JsonIgnore
    public TextBoxNum getTxtDai5gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getTxtDai5gun();
    }

    @JsonIgnore
    public TextBoxNum getTxtDai6gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getTxtDai6gun();
    }

    @JsonIgnore
    public TextBoxNum getTxtDai7gun() {
        return this.getTblTyukanHyokaKomokuTokuten().getTxtDai7gun();
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
