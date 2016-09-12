package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.kaigoninteiatenainfo.KaigoNinteiAtenaInfoBusiness;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.StaticImage;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxJusho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxSetaiCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * KaigoNinteiAtenaInfo のクラスファイル
 *
 * @reamsid_L DBZ-1300-050 lizhuoxuan
 */
public class KaigoNinteiAtenaInfoDiv extends Panel implements IKaigoNinteiAtenaInfoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShimei")
    private TextBox txtShimei;
    @JsonProperty("txtBirthYMD")
    private TextBoxDate txtBirthYMD;
    @JsonProperty("txtNenrei")
    private TextBox txtNenrei;
    @JsonProperty("txtSeibetsu")
    private TextBox txtSeibetsu;
    @JsonProperty("imgJuminShubetsu")
    private StaticImage imgJuminShubetsu;
    @JsonProperty("txtJuminShubetsu")
    private TextBox txtJuminShubetsu;
    @JsonProperty("txtShikiBetsuCode")
    private TextBox txtShikiBetsuCode;
    @JsonProperty("btnKojinMemo")
    private ButtonDialog btnKojinMemo;
    @JsonProperty("txtSetaiCode")
    private TextBoxSetaiCode txtSetaiCode;
    @JsonProperty("btnSetaiMemo")
    private ButtonDialog btnSetaiMemo;
    @JsonProperty("txtKojinNo")
    private TextBox txtKojinNo;
    @JsonProperty("imgYubinNo")
    private StaticImage imgYubinNo;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtJusho")
    private TextBoxJusho txtJusho;
    @JsonProperty("txtTelNo")
    private TextBoxTelNo txtTelNo;
    @JsonProperty("txtGyoseiku")
    private TextBox txtGyoseiku;
    @JsonProperty("hdnKaigoDonyuKeitai")
    private RString hdnKaigoDonyuKeitai;
    @JsonProperty("hdnShoriType")
    private RString hdnShoriType;
    @JsonProperty("SetaiMemoShikibetsuKubun")
    private RString SetaiMemoShikibetsuKubun;
    @JsonProperty("KojinMemoShikibetsuKubun")
    private RString KojinMemoShikibetsuKubun;
    @JsonProperty("hdnSubGyomuCode")
    private RString hdnSubGyomuCode;
    @JsonProperty("MemoShikibetsuCode")
    private RString MemoShikibetsuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShimei
     * @return txtShimei
     */
    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    /*
     * settxtShimei
     * @param txtShimei txtShimei
     */
    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei = txtShimei;
    }

    /*
     * gettxtBirthYMD
     * @return txtBirthYMD
     */
    @JsonProperty("txtBirthYMD")
    public TextBoxDate getTxtBirthYMD() {
        return txtBirthYMD;
    }

    /*
     * settxtBirthYMD
     * @param txtBirthYMD txtBirthYMD
     */
    @JsonProperty("txtBirthYMD")
    public void setTxtBirthYMD(TextBoxDate txtBirthYMD) {
        this.txtBirthYMD = txtBirthYMD;
    }

    /*
     * gettxtNenrei
     * @return txtNenrei
     */
    @JsonProperty("txtNenrei")
    public TextBox getTxtNenrei() {
        return txtNenrei;
    }

    /*
     * settxtNenrei
     * @param txtNenrei txtNenrei
     */
    @JsonProperty("txtNenrei")
    public void setTxtNenrei(TextBox txtNenrei) {
        this.txtNenrei = txtNenrei;
    }

    /*
     * gettxtSeibetsu
     * @return txtSeibetsu
     */
    @JsonProperty("txtSeibetsu")
    public TextBox getTxtSeibetsu() {
        return txtSeibetsu;
    }

    /*
     * settxtSeibetsu
     * @param txtSeibetsu txtSeibetsu
     */
    @JsonProperty("txtSeibetsu")
    public void setTxtSeibetsu(TextBox txtSeibetsu) {
        this.txtSeibetsu = txtSeibetsu;
    }

    /*
     * getimgJuminShubetsu
     * @return imgJuminShubetsu
     */
    @JsonProperty("imgJuminShubetsu")
    public StaticImage getImgJuminShubetsu() {
        return imgJuminShubetsu;
    }

    /*
     * setimgJuminShubetsu
     * @param imgJuminShubetsu imgJuminShubetsu
     */
    @JsonProperty("imgJuminShubetsu")
    public void setImgJuminShubetsu(StaticImage imgJuminShubetsu) {
        this.imgJuminShubetsu = imgJuminShubetsu;
    }

    /*
     * gettxtJuminShubetsu
     * @return txtJuminShubetsu
     */
    @JsonProperty("txtJuminShubetsu")
    public TextBox getTxtJuminShubetsu() {
        return txtJuminShubetsu;
    }

    /*
     * settxtJuminShubetsu
     * @param txtJuminShubetsu txtJuminShubetsu
     */
    @JsonProperty("txtJuminShubetsu")
    public void setTxtJuminShubetsu(TextBox txtJuminShubetsu) {
        this.txtJuminShubetsu = txtJuminShubetsu;
    }

    /*
     * gettxtShikiBetsuCode
     * @return txtShikiBetsuCode
     */
    @JsonProperty("txtShikiBetsuCode")
    public TextBox getTxtShikiBetsuCode() {
        return txtShikiBetsuCode;
    }

    /*
     * settxtShikiBetsuCode
     * @param txtShikiBetsuCode txtShikiBetsuCode
     */
    @JsonProperty("txtShikiBetsuCode")
    public void setTxtShikiBetsuCode(TextBox txtShikiBetsuCode) {
        this.txtShikiBetsuCode = txtShikiBetsuCode;
    }

    /*
     * getbtnKojinMemo
     * @return btnKojinMemo
     */
    @JsonProperty("btnKojinMemo")
    public ButtonDialog getBtnKojinMemo() {
        return btnKojinMemo;
    }

    /*
     * setbtnKojinMemo
     * @param btnKojinMemo btnKojinMemo
     */
    @JsonProperty("btnKojinMemo")
    public void setBtnKojinMemo(ButtonDialog btnKojinMemo) {
        this.btnKojinMemo = btnKojinMemo;
    }

    /*
     * gettxtSetaiCode
     * @return txtSetaiCode
     */
    @JsonProperty("txtSetaiCode")
    public TextBoxSetaiCode getTxtSetaiCode() {
        return txtSetaiCode;
    }

    /*
     * settxtSetaiCode
     * @param txtSetaiCode txtSetaiCode
     */
    @JsonProperty("txtSetaiCode")
    public void setTxtSetaiCode(TextBoxSetaiCode txtSetaiCode) {
        this.txtSetaiCode = txtSetaiCode;
    }

    /*
     * getbtnSetaiMemo
     * @return btnSetaiMemo
     */
    @JsonProperty("btnSetaiMemo")
    public ButtonDialog getBtnSetaiMemo() {
        return btnSetaiMemo;
    }

    /*
     * setbtnSetaiMemo
     * @param btnSetaiMemo btnSetaiMemo
     */
    @JsonProperty("btnSetaiMemo")
    public void setBtnSetaiMemo(ButtonDialog btnSetaiMemo) {
        this.btnSetaiMemo = btnSetaiMemo;
    }

    /*
     * gettxtKojinNo
     * @return txtKojinNo
     */
    @JsonProperty("txtKojinNo")
    public TextBox getTxtKojinNo() {
        return txtKojinNo;
    }

    /*
     * settxtKojinNo
     * @param txtKojinNo txtKojinNo
     */
    @JsonProperty("txtKojinNo")
    public void setTxtKojinNo(TextBox txtKojinNo) {
        this.txtKojinNo = txtKojinNo;
    }

    /*
     * getimgYubinNo
     * @return imgYubinNo
     */
    @JsonProperty("imgYubinNo")
    public StaticImage getImgYubinNo() {
        return imgYubinNo;
    }

    /*
     * setimgYubinNo
     * @param imgYubinNo imgYubinNo
     */
    @JsonProperty("imgYubinNo")
    public void setImgYubinNo(StaticImage imgYubinNo) {
        this.imgYubinNo = imgYubinNo;
    }

    /*
     * gettxtYubinNo
     * @return txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    /*
     * settxtYubinNo
     * @param txtYubinNo txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo = txtYubinNo;
    }

    /*
     * gettxtJusho
     * @return txtJusho
     */
    @JsonProperty("txtJusho")
    public TextBoxJusho getTxtJusho() {
        return txtJusho;
    }

    /*
     * settxtJusho
     * @param txtJusho txtJusho
     */
    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBoxJusho txtJusho) {
        this.txtJusho = txtJusho;
    }

    /*
     * gettxtTelNo
     * @return txtTelNo
     */
    @JsonProperty("txtTelNo")
    public TextBoxTelNo getTxtTelNo() {
        return txtTelNo;
    }

    /*
     * settxtTelNo
     * @param txtTelNo txtTelNo
     */
    @JsonProperty("txtTelNo")
    public void setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.txtTelNo = txtTelNo;
    }

    /*
     * gettxtGyoseiku
     * @return txtGyoseiku
     */
    @JsonProperty("txtGyoseiku")
    public TextBox getTxtGyoseiku() {
        return txtGyoseiku;
    }

    /*
     * settxtGyoseiku
     * @param txtGyoseiku txtGyoseiku
     */
    @JsonProperty("txtGyoseiku")
    public void setTxtGyoseiku(TextBox txtGyoseiku) {
        this.txtGyoseiku = txtGyoseiku;
    }

    /*
     * gethdnKaigoDonyuKeitai
     * @return hdnKaigoDonyuKeitai
     */
    @JsonProperty("hdnKaigoDonyuKeitai")
    public RString getHdnKaigoDonyuKeitai() {
        return hdnKaigoDonyuKeitai;
    }

    /*
     * sethdnKaigoDonyuKeitai
     * @param hdnKaigoDonyuKeitai hdnKaigoDonyuKeitai
     */
    @JsonProperty("hdnKaigoDonyuKeitai")
    public void setHdnKaigoDonyuKeitai(RString hdnKaigoDonyuKeitai) {
        this.hdnKaigoDonyuKeitai = hdnKaigoDonyuKeitai;
    }

    /*
     * gethdnShoriType
     * @return hdnShoriType
     */
    @JsonProperty("hdnShoriType")
    public RString getHdnShoriType() {
        return hdnShoriType;
    }

    /*
     * sethdnShoriType
     * @param hdnShoriType hdnShoriType
     */
    @JsonProperty("hdnShoriType")
    public void setHdnShoriType(RString hdnShoriType) {
        this.hdnShoriType = hdnShoriType;
    }

    /*
     * getSetaiMemoShikibetsuKubun
     * @return SetaiMemoShikibetsuKubun
     */
    @JsonProperty("SetaiMemoShikibetsuKubun")
    public RString getSetaiMemoShikibetsuKubun() {
        return SetaiMemoShikibetsuKubun;
    }

    /*
     * setSetaiMemoShikibetsuKubun
     * @param SetaiMemoShikibetsuKubun SetaiMemoShikibetsuKubun
     */
    @JsonProperty("SetaiMemoShikibetsuKubun")
    public void setSetaiMemoShikibetsuKubun(RString SetaiMemoShikibetsuKubun) {
        this.SetaiMemoShikibetsuKubun = SetaiMemoShikibetsuKubun;
    }

    /*
     * getKojinMemoShikibetsuKubun
     * @return KojinMemoShikibetsuKubun
     */
    @JsonProperty("KojinMemoShikibetsuKubun")
    public RString getKojinMemoShikibetsuKubun() {
        return KojinMemoShikibetsuKubun;
    }

    /*
     * setKojinMemoShikibetsuKubun
     * @param KojinMemoShikibetsuKubun KojinMemoShikibetsuKubun
     */
    @JsonProperty("KojinMemoShikibetsuKubun")
    public void setKojinMemoShikibetsuKubun(RString KojinMemoShikibetsuKubun) {
        this.KojinMemoShikibetsuKubun = KojinMemoShikibetsuKubun;
    }

    /*
     * gethdnSubGyomuCode
     * @return hdnSubGyomuCode
     */
    @JsonProperty("hdnSubGyomuCode")
    public RString getHdnSubGyomuCode() {
        return hdnSubGyomuCode;
    }

    /*
     * sethdnSubGyomuCode
     * @param hdnSubGyomuCode hdnSubGyomuCode
     */
    @JsonProperty("hdnSubGyomuCode")
    public void setHdnSubGyomuCode(RString hdnSubGyomuCode) {
        this.hdnSubGyomuCode = hdnSubGyomuCode;
    }

    /*
     * getMemoShikibetsuCode
     * @return MemoShikibetsuCode
     */
    @JsonProperty("MemoShikibetsuCode")
    public RString getMemoShikibetsuCode() {
        return MemoShikibetsuCode;
    }

    /*
     * setMemoShikibetsuCode
     * @param MemoShikibetsuCode MemoShikibetsuCode
     */
    @JsonProperty("MemoShikibetsuCode")
    public void setMemoShikibetsuCode(RString MemoShikibetsuCode) {
        this.MemoShikibetsuCode = MemoShikibetsuCode;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum ShoriType implements ICommonChildDivMode {

//        NormalAddMode("NormalAddMode"),
//        NormalUpdateMode("NormalUpdateMode"),
//        SeihoAddMode("SeihoAddMode"),
        SeihoUpdateMode("SeihoUpdateMode"),
        ShokaiMode("ShokaiMode");

        private final String name;

        private ShoriType(final String name) {
            this.name = name;
        }

        public static ShoriType getEnum(String str) {
            ShoriType[] enumArray = ShoriType.values();

            for (ShoriType enumStr : enumArray) {
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

    public ShoriType getMode_ShoriType() {
        return (ShoriType) _CommonChildDivModeUtil.getMode(this.modes, ShoriType.class);
    }

    public void setMode_ShoriType(ShoriType value) {
        _CommonChildDivModeUtil.setMode(this.modes, ShoriType.class, value);
    }

    public static enum AtenaType implements ICommonChildDivMode {

        AtenaMode("AtenaMode"),
        AtenaNonMode("AtenaNonMode");

        private final String name;

        private AtenaType(final String name) {
            this.name = name;
        }

        public static AtenaType getEnum(String str) {
            AtenaType[] enumArray = AtenaType.values();

            for (AtenaType enumStr : enumArray) {
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

    public AtenaType getMode_AtenaType() {
        return (AtenaType) _CommonChildDivModeUtil.getMode(this.modes, AtenaType.class);
    }

    public void setMode_AtenaType(AtenaType value) {
        _CommonChildDivModeUtil.setMode(this.modes, AtenaType.class, value);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize() {
        getHandler().initialize();
    }

    @Override
    public void setShinseishaJohoByShikibetsuCode(ShinseishoKanriNo shinseishoKanriNo, ShikibetsuCode shikibetsuCode) {
        getHandler().setShinseishaJohoByShikibetsuCode(shinseishoKanriNo, shikibetsuCode);
    }

    private KaigoNinteiAtenaInfoHandler getHandler() {
        return new KaigoNinteiAtenaInfoHandler(this);
    }

    @Override
    public void setShoriType(RString shoriType) {
        this.setHdnShoriType(shoriType);
    }

    @Override
    public void setKaigoDonyuKeitai(RString hdnKaigoDonyuKeitai) {
        this.setHdnKaigoDonyuKeitai(hdnKaigoDonyuKeitai);
    }

    @Override
    public void set介護認定宛名情報(KaigoNinteiAtenaInfoBusiness business) {
        getHandler().set介護認定宛名情報(business);
    }

    @Override
    public RDate get生年月日() {
        return this.getTxtBirthYMD().getValue();
    }

    @Override
    public RString get年齢() {
        return this.getTxtNenrei().getValue();
    }

    @Override
    public RString get性別() {
        return this.getTxtSeibetsu().getValue();
    }

    @Override
    public RString get被保険者氏名() {
        return this.getTxtShimei().getValue();
    }

    @Override
    public YubinNo get郵便番号() {
        return this.getTxtYubinNo().getValue();
    }

    @Override
    public RString get住所() {
        return this.getTxtJusho().getDomain().value();
    }

    @Override
    public RString get電話番号() {
        return this.getTxtTelNo().getDomain().value();
    }

    @Override
    public RString get識別コード() {
        return this.getTxtShikiBetsuCode().getValue();
    }

}
