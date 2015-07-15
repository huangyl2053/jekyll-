package jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiChosaJokyoInput;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiChosaJokyoInput.INinteiChosaJokyoInputDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiChosaJokyoInput.EnkiTsuchiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiChosaJokyoInput.HomonChosasakiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiChosaJokyoInput.IchigoHanteiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiChosaJokyoInput.IchijiHanteiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiChosaJokyoInput.KaigoNinteiShinsakaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiChosaJokyoInput.NinteiChosaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiChosaJokyoInput.ShujiiAndShujiIryoKikanDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * NinteiChosaJokyoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaJokyoInputDiv extends Panel implements INinteiChosaJokyoInputDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblNinteiChosa")
    private Label lblNinteiChosa;
    @JsonProperty("NinteiChosa")
    private NinteiChosaDiv NinteiChosa;
    @JsonProperty("lblHomonSaki")
    private Label lblHomonSaki;
    @JsonProperty("HomonChosasaki")
    private HomonChosasakiDiv HomonChosasaki;
    @JsonProperty("lblShujii")
    private Label lblShujii;
    @JsonProperty("ShujiiAndShujiIryoKikan")
    private ShujiiAndShujiIryoKikanDiv ShujiiAndShujiIryoKikan;
    @JsonProperty("lblIchijiHantei")
    private Label lblIchijiHantei;
    @JsonProperty("IchijiHantei")
    private IchijiHanteiDiv IchijiHantei;
    @JsonProperty("lblIchigoHantei")
    private Label lblIchigoHantei;
    @JsonProperty("IchigoHantei")
    private IchigoHanteiDiv IchigoHantei;
    @JsonProperty("lblKaigoNinteiShinsakai")
    private Label lblKaigoNinteiShinsakai;
    @JsonProperty("KaigoNinteiShinsakai")
    private KaigoNinteiShinsakaiDiv KaigoNinteiShinsakai;
    @JsonProperty("lblEnkiTsuchi")
    private Label lblEnkiTsuchi;
    @JsonProperty("EnkiTsuchi")
    private EnkiTsuchiDiv EnkiTsuchi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblNinteiChosa")
    public Label getLblNinteiChosa() {
        return lblNinteiChosa;
    }

    @JsonProperty("lblNinteiChosa")
    public void setLblNinteiChosa(Label lblNinteiChosa) {
        this.lblNinteiChosa=lblNinteiChosa;
    }

    @JsonProperty("NinteiChosa")
    public NinteiChosaDiv getNinteiChosa() {
        return NinteiChosa;
    }

    @JsonProperty("NinteiChosa")
    public void setNinteiChosa(NinteiChosaDiv NinteiChosa) {
        this.NinteiChosa=NinteiChosa;
    }

    @JsonProperty("lblHomonSaki")
    public Label getLblHomonSaki() {
        return lblHomonSaki;
    }

    @JsonProperty("lblHomonSaki")
    public void setLblHomonSaki(Label lblHomonSaki) {
        this.lblHomonSaki=lblHomonSaki;
    }

    @JsonProperty("HomonChosasaki")
    public HomonChosasakiDiv getHomonChosasaki() {
        return HomonChosasaki;
    }

    @JsonProperty("HomonChosasaki")
    public void setHomonChosasaki(HomonChosasakiDiv HomonChosasaki) {
        this.HomonChosasaki=HomonChosasaki;
    }

    @JsonProperty("lblShujii")
    public Label getLblShujii() {
        return lblShujii;
    }

    @JsonProperty("lblShujii")
    public void setLblShujii(Label lblShujii) {
        this.lblShujii=lblShujii;
    }

    @JsonProperty("ShujiiAndShujiIryoKikan")
    public ShujiiAndShujiIryoKikanDiv getShujiiAndShujiIryoKikan() {
        return ShujiiAndShujiIryoKikan;
    }

    @JsonProperty("ShujiiAndShujiIryoKikan")
    public void setShujiiAndShujiIryoKikan(ShujiiAndShujiIryoKikanDiv ShujiiAndShujiIryoKikan) {
        this.ShujiiAndShujiIryoKikan=ShujiiAndShujiIryoKikan;
    }

    @JsonProperty("lblIchijiHantei")
    public Label getLblIchijiHantei() {
        return lblIchijiHantei;
    }

    @JsonProperty("lblIchijiHantei")
    public void setLblIchijiHantei(Label lblIchijiHantei) {
        this.lblIchijiHantei=lblIchijiHantei;
    }

    @JsonProperty("IchijiHantei")
    public IchijiHanteiDiv getIchijiHantei() {
        return IchijiHantei;
    }

    @JsonProperty("IchijiHantei")
    public void setIchijiHantei(IchijiHanteiDiv IchijiHantei) {
        this.IchijiHantei=IchijiHantei;
    }

    @JsonProperty("lblIchigoHantei")
    public Label getLblIchigoHantei() {
        return lblIchigoHantei;
    }

    @JsonProperty("lblIchigoHantei")
    public void setLblIchigoHantei(Label lblIchigoHantei) {
        this.lblIchigoHantei=lblIchigoHantei;
    }

    @JsonProperty("IchigoHantei")
    public IchigoHanteiDiv getIchigoHantei() {
        return IchigoHantei;
    }

    @JsonProperty("IchigoHantei")
    public void setIchigoHantei(IchigoHanteiDiv IchigoHantei) {
        this.IchigoHantei=IchigoHantei;
    }

    @JsonProperty("lblKaigoNinteiShinsakai")
    public Label getLblKaigoNinteiShinsakai() {
        return lblKaigoNinteiShinsakai;
    }

    @JsonProperty("lblKaigoNinteiShinsakai")
    public void setLblKaigoNinteiShinsakai(Label lblKaigoNinteiShinsakai) {
        this.lblKaigoNinteiShinsakai=lblKaigoNinteiShinsakai;
    }

    @JsonProperty("KaigoNinteiShinsakai")
    public KaigoNinteiShinsakaiDiv getKaigoNinteiShinsakai() {
        return KaigoNinteiShinsakai;
    }

    @JsonProperty("KaigoNinteiShinsakai")
    public void setKaigoNinteiShinsakai(KaigoNinteiShinsakaiDiv KaigoNinteiShinsakai) {
        this.KaigoNinteiShinsakai=KaigoNinteiShinsakai;
    }

    @JsonProperty("lblEnkiTsuchi")
    public Label getLblEnkiTsuchi() {
        return lblEnkiTsuchi;
    }

    @JsonProperty("lblEnkiTsuchi")
    public void setLblEnkiTsuchi(Label lblEnkiTsuchi) {
        this.lblEnkiTsuchi=lblEnkiTsuchi;
    }

    @JsonProperty("EnkiTsuchi")
    public EnkiTsuchiDiv getEnkiTsuchi() {
        return EnkiTsuchi;
    }

    @JsonProperty("EnkiTsuchi")
    public void setEnkiTsuchi(EnkiTsuchiDiv EnkiTsuchi) {
        this.EnkiTsuchi=EnkiTsuchi;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum ShoriType implements ICommonChildDivMode {

        InputMode("InputMode"),
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

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtNinteiChosainCode() {
        return this.getNinteiChosa().getTxtNinteiChosainCode();
    }

    @JsonIgnore
    public void  setTxtNinteiChosainCode(TextBoxCode txtNinteiChosainCode) {
        this.getNinteiChosa().setTxtNinteiChosainCode(txtNinteiChosainCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnChosainGuide() {
        return this.getNinteiChosa().getBtnChosainGuide();
    }

    @JsonIgnore
    public void  setBtnChosainGuide(ButtonDialog btnChosainGuide) {
        this.getNinteiChosa().setBtnChosainGuide(btnChosainGuide);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosainName() {
        return this.getNinteiChosa().getTxtNinteiChosainName();
    }

    @JsonIgnore
    public void  setTxtNinteiChosainName(TextBox txtNinteiChosainName) {
        this.getNinteiChosa().setTxtNinteiChosainName(txtNinteiChosainName);
    }

    @JsonIgnore
    public TextBoxCode getTxtNinteiChosaItakusakiCode() {
        return this.getNinteiChosa().getTxtNinteiChosaItakusakiCode();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaItakusakiCode(TextBoxCode txtNinteiChosaItakusakiCode) {
        this.getNinteiChosa().setTxtNinteiChosaItakusakiCode(txtNinteiChosaItakusakiCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnItakusakiGuide() {
        return this.getNinteiChosa().getBtnItakusakiGuide();
    }

    @JsonIgnore
    public void  setBtnItakusakiGuide(ButtonDialog btnItakusakiGuide) {
        this.getNinteiChosa().setBtnItakusakiGuide(btnItakusakiGuide);
    }

    @JsonIgnore
    public TextBox getTxtNinteiChosaItakusakiName() {
        return this.getNinteiChosa().getTxtNinteiChosaItakusakiName();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaItakusakiName(TextBox txtNinteiChosaItakusakiName) {
        this.getNinteiChosa().setTxtNinteiChosaItakusakiName(txtNinteiChosaItakusakiName);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtNinteiChosaYubinNo() {
        return this.getNinteiChosa().getTxtNinteiChosaYubinNo();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaYubinNo(TextBoxYubinNo txtNinteiChosaYubinNo) {
        this.getNinteiChosa().setTxtNinteiChosaYubinNo(txtNinteiChosaYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtNinteiChosaJusho() {
        return this.getNinteiChosa().getTxtNinteiChosaJusho();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaJusho(TextBoxJusho txtNinteiChosaJusho) {
        this.getNinteiChosa().setTxtNinteiChosaJusho(txtNinteiChosaJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtNinteiChosaTelNo() {
        return this.getNinteiChosa().getTxtNinteiChosaTelNo();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaTelNo(TextBoxTelNo txtNinteiChosaTelNo) {
        this.getNinteiChosa().setTxtNinteiChosaTelNo(txtNinteiChosaTelNo);
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiChosaIraiDay() {
        return this.getNinteiChosa().getTxtNinteiChosaIraiDay();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaIraiDay(TextBoxDate txtNinteiChosaIraiDay) {
        this.getNinteiChosa().setTxtNinteiChosaIraiDay(txtNinteiChosaIraiDay);
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiChosaJisshiYoteiDay() {
        return this.getNinteiChosa().getTxtNinteiChosaJisshiYoteiDay();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaJisshiYoteiDay(TextBoxDate txtNinteiChosaJisshiYoteiDay) {
        this.getNinteiChosa().setTxtNinteiChosaJisshiYoteiDay(txtNinteiChosaJisshiYoteiDay);
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiChosaJisshiDay() {
        return this.getNinteiChosa().getTxtNinteiChosaJisshiDay();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaJisshiDay(TextBoxDate txtNinteiChosaJisshiDay) {
        this.getNinteiChosa().setTxtNinteiChosaJisshiDay(txtNinteiChosaJisshiDay);
    }

    @JsonIgnore
    public DropDownList getDdlNinteiChosaItakusakiKubun() {
        return this.getNinteiChosa().getDdlNinteiChosaItakusakiKubun();
    }

    @JsonIgnore
    public void  setDdlNinteiChosaItakusakiKubun(DropDownList ddlNinteiChosaItakusakiKubun) {
        this.getNinteiChosa().setDdlNinteiChosaItakusakiKubun(ddlNinteiChosaItakusakiKubun);
    }

    @JsonIgnore
    public TextBox getTxtChosasakiName() {
        return this.getHomonChosasaki().getTxtChosasakiName();
    }

    @JsonIgnore
    public void  setTxtChosasakiName(TextBox txtChosasakiName) {
        this.getHomonChosasaki().setTxtChosasakiName(txtChosasakiName);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtChosasakiYubinNo() {
        return this.getHomonChosasaki().getTxtChosasakiYubinNo();
    }

    @JsonIgnore
    public void  setTxtChosasakiYubinNo(TextBoxYubinNo txtChosasakiYubinNo) {
        this.getHomonChosasaki().setTxtChosasakiYubinNo(txtChosasakiYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtChosasakiJusho() {
        return this.getHomonChosasaki().getTxtChosasakiJusho();
    }

    @JsonIgnore
    public void  setTxtChosasakiJusho(TextBoxJusho txtChosasakiJusho) {
        this.getHomonChosasaki().setTxtChosasakiJusho(txtChosasakiJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtChosasakiTelNo() {
        return this.getHomonChosasaki().getTxtChosasakiTelNo();
    }

    @JsonIgnore
    public void  setTxtChosasakiTelNo(TextBoxTelNo txtChosasakiTelNo) {
        this.getHomonChosasaki().setTxtChosasakiTelNo(txtChosasakiTelNo);
    }

    @JsonIgnore
    public TextBoxCode getTxtShujiiCode() {
        return this.getShujiiAndShujiIryoKikan().getTxtShujiiCode();
    }

    @JsonIgnore
    public void  setTxtShujiiCode(TextBoxCode txtShujiiCode) {
        this.getShujiiAndShujiIryoKikan().setTxtShujiiCode(txtShujiiCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnShujiiGuide() {
        return this.getShujiiAndShujiIryoKikan().getBtnShujiiGuide();
    }

    @JsonIgnore
    public void  setBtnShujiiGuide(ButtonDialog btnShujiiGuide) {
        this.getShujiiAndShujiIryoKikan().setBtnShujiiGuide(btnShujiiGuide);
    }

    @JsonIgnore
    public TextBox getTxtShujiiName() {
        return this.getShujiiAndShujiIryoKikan().getTxtShujiiName();
    }

    @JsonIgnore
    public void  setTxtShujiiName(TextBox txtShujiiName) {
        this.getShujiiAndShujiIryoKikan().setTxtShujiiName(txtShujiiName);
    }

    @JsonIgnore
    public TextBoxCode getTxtShujiiIryoKikanCode() {
        return this.getShujiiAndShujiIryoKikan().getTxtShujiiIryoKikanCode();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanCode(TextBoxCode txtShujiiIryoKikanCode) {
        this.getShujiiAndShujiIryoKikan().setTxtShujiiIryoKikanCode(txtShujiiIryoKikanCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnIryoKikanGuide() {
        return this.getShujiiAndShujiIryoKikan().getBtnIryoKikanGuide();
    }

    @JsonIgnore
    public void  setBtnIryoKikanGuide(ButtonDialog btnIryoKikanGuide) {
        this.getShujiiAndShujiIryoKikan().setBtnIryoKikanGuide(btnIryoKikanGuide);
    }

    @JsonIgnore
    public TextBox getTxtShujiiIryoKikanName() {
        return this.getShujiiAndShujiIryoKikan().getTxtShujiiIryoKikanName();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanName(TextBox txtShujiiIryoKikanName) {
        this.getShujiiAndShujiIryoKikan().setTxtShujiiIryoKikanName(txtShujiiIryoKikanName);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtShujiiIryoKikanYubinNo() {
        return this.getShujiiAndShujiIryoKikan().getTxtShujiiIryoKikanYubinNo();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanYubinNo(TextBoxYubinNo txtShujiiIryoKikanYubinNo) {
        this.getShujiiAndShujiIryoKikan().setTxtShujiiIryoKikanYubinNo(txtShujiiIryoKikanYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtShujiiIryoKikanJusho() {
        return this.getShujiiAndShujiIryoKikan().getTxtShujiiIryoKikanJusho();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanJusho(TextBoxJusho txtShujiiIryoKikanJusho) {
        this.getShujiiAndShujiIryoKikan().setTxtShujiiIryoKikanJusho(txtShujiiIryoKikanJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtShujiiIryoKikanTelNo() {
        return this.getShujiiAndShujiIryoKikan().getTxtShujiiIryoKikanTelNo();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanTelNo(TextBoxTelNo txtShujiiIryoKikanTelNo) {
        this.getShujiiAndShujiIryoKikan().setTxtShujiiIryoKikanTelNo(txtShujiiIryoKikanTelNo);
    }

    @JsonIgnore
    public TextBoxDate getTxtShujiiIryoKikanIraiDay() {
        return this.getShujiiAndShujiIryoKikan().getTxtShujiiIryoKikanIraiDay();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanIraiDay(TextBoxDate txtShujiiIryoKikanIraiDay) {
        this.getShujiiAndShujiIryoKikan().setTxtShujiiIryoKikanIraiDay(txtShujiiIryoKikanIraiDay);
    }

    @JsonIgnore
    public TextBoxDate getTxtShujiiIryoKikanNyushuYoteiDay() {
        return this.getShujiiAndShujiIryoKikan().getTxtShujiiIryoKikanNyushuYoteiDay();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanNyushuYoteiDay(TextBoxDate txtShujiiIryoKikanNyushuYoteiDay) {
        this.getShujiiAndShujiIryoKikan().setTxtShujiiIryoKikanNyushuYoteiDay(txtShujiiIryoKikanNyushuYoteiDay);
    }

    @JsonIgnore
    public TextBoxDate getTxtShujiiIryoKikanNyushuDay() {
        return this.getShujiiAndShujiIryoKikan().getTxtShujiiIryoKikanNyushuDay();
    }

    @JsonIgnore
    public void  setTxtShujiiIryoKikanNyushuDay(TextBoxDate txtShujiiIryoKikanNyushuDay) {
        this.getShujiiAndShujiIryoKikan().setTxtShujiiIryoKikanNyushuDay(txtShujiiIryoKikanNyushuDay);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiKubun() {
        return this.getShujiiAndShujiIryoKikan().getChkShujiiKubun();
    }

    @JsonIgnore
    public void  setChkShujiiKubun(CheckBoxList chkShujiiKubun) {
        this.getShujiiAndShujiIryoKikan().setChkShujiiKubun(chkShujiiKubun);
    }

    @JsonIgnore
    public DropDownList getDdlIchijiHanteiYokaigodo() {
        return this.getIchijiHantei().getDdlIchijiHanteiYokaigodo();
    }

    @JsonIgnore
    public void  setDdlIchijiHanteiYokaigodo(DropDownList ddlIchijiHanteiYokaigodo) {
        this.getIchijiHantei().setDdlIchijiHanteiYokaigodo(ddlIchijiHanteiYokaigodo);
    }

    @JsonIgnore
    public TextBoxDate getTxtIchijiHanteiDay() {
        return this.getIchijiHantei().getTxtIchijiHanteiDay();
    }

    @JsonIgnore
    public void  setTxtIchijiHanteiDay(TextBoxDate txtIchijiHanteiDay) {
        this.getIchijiHantei().setTxtIchijiHanteiDay(txtIchijiHanteiDay);
    }

    @JsonIgnore
    public DropDownList getDdlNinchishoKasangoIchijiHanteiYokaigodo() {
        return this.getIchijiHantei().getDdlNinchishoKasangoIchijiHanteiYokaigodo();
    }

    @JsonIgnore
    public void  setDdlNinchishoKasangoIchijiHanteiYokaigodo(DropDownList ddlNinchishoKasangoIchijiHanteiYokaigodo) {
        this.getIchijiHantei().setDdlNinchishoKasangoIchijiHanteiYokaigodo(ddlNinchishoKasangoIchijiHanteiYokaigodo);
    }

    @JsonIgnore
    public DropDownList getDdlIchigoHanteiYokaigodo() {
        return this.getIchigoHantei().getDdlIchigoHanteiYokaigodo();
    }

    @JsonIgnore
    public void  setDdlIchigoHanteiYokaigodo(DropDownList ddlIchigoHanteiYokaigodo) {
        this.getIchigoHantei().setDdlIchigoHanteiYokaigodo(ddlIchigoHanteiYokaigodo);
    }

    @JsonIgnore
    public TextBoxDate getTxtIchigoHanteiDay() {
        return this.getIchigoHantei().getTxtIchigoHanteiDay();
    }

    @JsonIgnore
    public void  setTxtIchigoHanteiDay(TextBoxDate txtIchigoHanteiDay) {
        this.getIchigoHantei().setTxtIchigoHanteiDay(txtIchigoHanteiDay);
    }

    @JsonIgnore
    public DropDownList getDdlNinchishoKasangoIchigoHanteiYokaigodo() {
        return this.getIchigoHantei().getDdlNinchishoKasangoIchigoHanteiYokaigodo();
    }

    @JsonIgnore
    public void  setDdlNinchishoKasangoIchigoHanteiYokaigodo(DropDownList ddlNinchishoKasangoIchigoHanteiYokaigodo) {
        this.getIchigoHantei().setDdlNinchishoKasangoIchigoHanteiYokaigodo(ddlNinchishoKasangoIchigoHanteiYokaigodo);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsakaiShiryoSakuseiDay() {
        return this.getKaigoNinteiShinsakai().getTxtShinsakaiShiryoSakuseiDay();
    }

    @JsonIgnore
    public void  setTxtShinsakaiShiryoSakuseiDay(TextBoxDate txtShinsakaiShiryoSakuseiDay) {
        this.getKaigoNinteiShinsakai().setTxtShinsakaiShiryoSakuseiDay(txtShinsakaiShiryoSakuseiDay);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsakaiKaisaiYoteiDay() {
        return this.getKaigoNinteiShinsakai().getTxtShinsakaiKaisaiYoteiDay();
    }

    @JsonIgnore
    public void  setTxtShinsakaiKaisaiYoteiDay(TextBoxDate txtShinsakaiKaisaiYoteiDay) {
        this.getKaigoNinteiShinsakai().setTxtShinsakaiKaisaiYoteiDay(txtShinsakaiKaisaiYoteiDay);
    }

    @JsonIgnore
    public TextBoxDate getTxtNijiHanteiDay() {
        return this.getKaigoNinteiShinsakai().getTxtNijiHanteiDay();
    }

    @JsonIgnore
    public void  setTxtNijiHanteiDay(TextBoxDate txtNijiHanteiDay) {
        this.getKaigoNinteiShinsakai().setTxtNijiHanteiDay(txtNijiHanteiDay);
    }

    @JsonIgnore
    public DropDownList getDdlNijiHanteiKekka() {
        return this.getKaigoNinteiShinsakai().getDdlNijiHanteiKekka();
    }

    @JsonIgnore
    public void  setDdlNijiHanteiKekka(DropDownList ddlNijiHanteiKekka) {
        this.getKaigoNinteiShinsakai().setDdlNijiHanteiKekka(ddlNijiHanteiKekka);
    }

    @JsonIgnore
    public TextBox getTxtNijiHanteiYukoKikan() {
        return this.getKaigoNinteiShinsakai().getTxtNijiHanteiYukoKikan();
    }

    @JsonIgnore
    public void  setTxtNijiHanteiYukoKikan(TextBox txtNijiHanteiYukoKikan) {
        this.getKaigoNinteiShinsakai().setTxtNijiHanteiYukoKikan(txtNijiHanteiYukoKikan);
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiYukoKikanFrom() {
        return this.getKaigoNinteiShinsakai().getTxtNinteiYukoKikanFrom();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoKikanFrom(TextBoxDate txtNinteiYukoKikanFrom) {
        this.getKaigoNinteiShinsakai().setTxtNinteiYukoKikanFrom(txtNinteiYukoKikanFrom);
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiYukoKikanTo() {
        return this.getKaigoNinteiShinsakai().getTxtNinteiYukoKikanTo();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoKikanTo(TextBoxDate txtNinteiYukoKikanTo) {
        this.getKaigoNinteiShinsakai().setTxtNinteiYukoKikanTo(txtNinteiYukoKikanTo);
    }

    @JsonIgnore
    public TextBoxDate getTxtEnkiTsuchiHakkoDay() {
        return this.getEnkiTsuchi().getTxtEnkiTsuchiHakkoDay();
    }

    @JsonIgnore
    public void  setTxtEnkiTsuchiHakkoDay(TextBoxDate txtEnkiTsuchiHakkoDay) {
        this.getEnkiTsuchi().setTxtEnkiTsuchiHakkoDay(txtEnkiTsuchiHakkoDay);
    }

    @JsonIgnore
    public TextBoxNum getTxtEnkiTsuchiHakkoCount() {
        return this.getEnkiTsuchi().getTxtEnkiTsuchiHakkoCount();
    }

    @JsonIgnore
    public void  setTxtEnkiTsuchiHakkoCount(TextBoxNum txtEnkiTsuchiHakkoCount) {
        this.getEnkiTsuchi().setTxtEnkiTsuchiHakkoCount(txtEnkiTsuchiHakkoCount);
    }

    //--------------- この行より下にコードを追加してください -------------------

}
