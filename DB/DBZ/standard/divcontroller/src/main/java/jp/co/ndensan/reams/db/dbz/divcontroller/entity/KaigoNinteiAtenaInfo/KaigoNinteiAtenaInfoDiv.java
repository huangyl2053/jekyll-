package jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoNinteiAtenaInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoNinteiAtenaInfo.IKaigoNinteiAtenaInfoDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.TestKaigoNinteiAtenaInfo.TestKaigoNinteiAtenaInfoDiv;

/**
 * KaigoNinteiAtenaInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoNinteiAtenaInfoDiv extends Panel implements IKaigoNinteiAtenaInfoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
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
    @JsonProperty("txtSetaiCode")
    private TextBoxSetaiCode txtSetaiCode;
    @JsonProperty("btnSetaiMemo")
    private ButtonDialog btnSetaiMemo;
    @JsonProperty("hdnKaigoDonyuKeitai")
    private RString hdnKaigoDonyuKeitai;
    @JsonProperty("hdnShoriType")
    private RString hdnShoriType;
    @JsonProperty("MemoShikibetsuKubun")
    private RString MemoShikibetsuKubun;
    @JsonProperty("hdnSubGyomuCode")
    private RString hdnSubGyomuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei=txtShimei;
    }

    @JsonProperty("txtBirthYMD")
    public TextBoxDate getTxtBirthYMD() {
        return txtBirthYMD;
    }

    @JsonProperty("txtBirthYMD")
    public void setTxtBirthYMD(TextBoxDate txtBirthYMD) {
        this.txtBirthYMD=txtBirthYMD;
    }

    @JsonProperty("txtNenrei")
    public TextBox getTxtNenrei() {
        return txtNenrei;
    }

    @JsonProperty("txtNenrei")
    public void setTxtNenrei(TextBox txtNenrei) {
        this.txtNenrei=txtNenrei;
    }

    @JsonProperty("txtSeibetsu")
    public TextBox getTxtSeibetsu() {
        return txtSeibetsu;
    }

    @JsonProperty("txtSeibetsu")
    public void setTxtSeibetsu(TextBox txtSeibetsu) {
        this.txtSeibetsu=txtSeibetsu;
    }

    @JsonProperty("imgJuminShubetsu")
    public StaticImage getImgJuminShubetsu() {
        return imgJuminShubetsu;
    }

    @JsonProperty("imgJuminShubetsu")
    public void setImgJuminShubetsu(StaticImage imgJuminShubetsu) {
        this.imgJuminShubetsu=imgJuminShubetsu;
    }

    @JsonProperty("txtJuminShubetsu")
    public TextBox getTxtJuminShubetsu() {
        return txtJuminShubetsu;
    }

    @JsonProperty("txtJuminShubetsu")
    public void setTxtJuminShubetsu(TextBox txtJuminShubetsu) {
        this.txtJuminShubetsu=txtJuminShubetsu;
    }

    @JsonProperty("txtShikiBetsuCode")
    public TextBox getTxtShikiBetsuCode() {
        return txtShikiBetsuCode;
    }

    @JsonProperty("txtShikiBetsuCode")
    public void setTxtShikiBetsuCode(TextBox txtShikiBetsuCode) {
        this.txtShikiBetsuCode=txtShikiBetsuCode;
    }

    @JsonProperty("btnKojinMemo")
    public ButtonDialog getBtnKojinMemo() {
        return btnKojinMemo;
    }

    @JsonProperty("btnKojinMemo")
    public void setBtnKojinMemo(ButtonDialog btnKojinMemo) {
        this.btnKojinMemo=btnKojinMemo;
    }

    @JsonProperty("txtKojinNo")
    public TextBox getTxtKojinNo() {
        return txtKojinNo;
    }

    @JsonProperty("txtKojinNo")
    public void setTxtKojinNo(TextBox txtKojinNo) {
        this.txtKojinNo=txtKojinNo;
    }

    @JsonProperty("imgYubinNo")
    public StaticImage getImgYubinNo() {
        return imgYubinNo;
    }

    @JsonProperty("imgYubinNo")
    public void setImgYubinNo(StaticImage imgYubinNo) {
        this.imgYubinNo=imgYubinNo;
    }

    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo=txtYubinNo;
    }

    @JsonProperty("txtJusho")
    public TextBoxJusho getTxtJusho() {
        return txtJusho;
    }

    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBoxJusho txtJusho) {
        this.txtJusho=txtJusho;
    }

    @JsonProperty("txtTelNo")
    public TextBoxTelNo getTxtTelNo() {
        return txtTelNo;
    }

    @JsonProperty("txtTelNo")
    public void setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.txtTelNo=txtTelNo;
    }

    @JsonProperty("txtGyoseiku")
    public TextBox getTxtGyoseiku() {
        return txtGyoseiku;
    }

    @JsonProperty("txtGyoseiku")
    public void setTxtGyoseiku(TextBox txtGyoseiku) {
        this.txtGyoseiku=txtGyoseiku;
    }

    @JsonProperty("txtSetaiCode")
    public TextBoxSetaiCode getTxtSetaiCode() {
        return txtSetaiCode;
    }

    @JsonProperty("txtSetaiCode")
    public void setTxtSetaiCode(TextBoxSetaiCode txtSetaiCode) {
        this.txtSetaiCode=txtSetaiCode;
    }

    @JsonProperty("btnSetaiMemo")
    public ButtonDialog getBtnSetaiMemo() {
        return btnSetaiMemo;
    }

    @JsonProperty("btnSetaiMemo")
    public void setBtnSetaiMemo(ButtonDialog btnSetaiMemo) {
        this.btnSetaiMemo=btnSetaiMemo;
    }

    @JsonProperty("hdnKaigoDonyuKeitai")
    public RString getHdnKaigoDonyuKeitai() {
        return hdnKaigoDonyuKeitai;
    }

    @JsonProperty("hdnKaigoDonyuKeitai")
    public void setHdnKaigoDonyuKeitai(RString hdnKaigoDonyuKeitai) {
        this.hdnKaigoDonyuKeitai=hdnKaigoDonyuKeitai;
    }

    @JsonProperty("hdnShoriType")
    public RString getHdnShoriType() {
        return hdnShoriType;
    }

    @JsonProperty("hdnShoriType")
    public void setHdnShoriType(RString hdnShoriType) {
        this.hdnShoriType=hdnShoriType;
    }

    @JsonProperty("MemoShikibetsuKubun")
    public RString getMemoShikibetsuKubun() {
        return MemoShikibetsuKubun;
    }

    @JsonProperty("MemoShikibetsuKubun")
    public void setMemoShikibetsuKubun(RString MemoShikibetsuKubun) {
        this.MemoShikibetsuKubun=MemoShikibetsuKubun;
    }

    @JsonProperty("hdnSubGyomuCode")
    public RString getHdnSubGyomuCode() {
        return hdnSubGyomuCode;
    }

    @JsonProperty("hdnSubGyomuCode")
    public void setHdnSubGyomuCode(RString hdnSubGyomuCode) {
        this.hdnSubGyomuCode=hdnSubGyomuCode;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum ShoriType implements ICommonChildDivMode {

        NormalAddMode("NormalAddMode"),
        NormalUpdateMode("NormalUpdateMode"),
        SeihoAddMode("SeihoAddMode"),
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
        return (ShoriType) _CommonChildDivModeUtil.getMode( this.modes, ShoriType.class );
    }

    public void setMode_ShoriType( ShoriType value ) {
        _CommonChildDivModeUtil.setMode( this.modes, ShoriType.class , value );
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
        return (AtenaType) _CommonChildDivModeUtil.getMode( this.modes, AtenaType.class );
    }

    public void setMode_AtenaType( AtenaType value ) {
        _CommonChildDivModeUtil.setMode( this.modes, AtenaType.class , value );
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    // 以下のメソッドはインタフェースに定義していないので業務には公開されません。
    
  @Override
   public void initialize() {
       getHandler().initialize();
   }

  @Override
   public void onLoad(TestKaigoNinteiAtenaInfoDiv div){ 
       getHandler().load(div);
   }
   
   @JsonIgnore
    private KaigoNinteiAtenaInfoHandler getHandler() {
        return new KaigoNinteiAtenaInfoHandler(this);
    }

}
