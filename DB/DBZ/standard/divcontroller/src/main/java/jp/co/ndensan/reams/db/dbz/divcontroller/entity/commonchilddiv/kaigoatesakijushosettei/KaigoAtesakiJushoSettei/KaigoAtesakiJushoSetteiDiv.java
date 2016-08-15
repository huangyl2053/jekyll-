package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatesakijushosettei.KaigoAtesakiJushoSettei;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * KaigoAtesakiJushoSettei のクラスファイル
 *
 * @reamsid_L DBU-3990-030 wanghui
 */
public class KaigoAtesakiJushoSetteiDiv extends Panel implements IKaigoAtesakiJushoSetteiDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radJushoSettei")
    private RadioButton radJushoSettei;
    @JsonProperty("btnAtesakiJushoSettei")
    private ButtonDialog btnAtesakiJushoSettei;
    @JsonProperty("txtAtesakiJushoSettei")
    private TextBox txtAtesakiJushoSettei;
    @JsonProperty("hdnChohyoDokujiTodofukenMei")
    private RString hdnChohyoDokujiTodofukenMei;
    @JsonProperty("hdnChohyoDokujiGunMei")
    private RString hdnChohyoDokujiGunMei;
    @JsonProperty("hdnChohyoDokujiShichosonMei")
    private RString hdnChohyoDokujiShichosonMei;
    @JsonProperty("hdnChohyoDokujiHensyuHoho")
    private RString hdnChohyoDokujiHensyuHoho;
    @JsonProperty("hdnChohyoDokujiKatagaki")
    private RString hdnChohyoDokujiKatagaki;
    @JsonProperty("hdnサブ業務コード")
    private RString hdnサブ業務コード;
    @JsonProperty("hdn帳票分類ID")
    private RString hdn帳票分類ID;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradJushoSettei
     * @return radJushoSettei
     */
    @JsonProperty("radJushoSettei")
    public RadioButton getRadJushoSettei() {
        return radJushoSettei;
    }

    /*
     * setradJushoSettei
     * @param radJushoSettei radJushoSettei
     */
    @JsonProperty("radJushoSettei")
    public void setRadJushoSettei(RadioButton radJushoSettei) {
        this.radJushoSettei = radJushoSettei;
    }

    /*
     * getbtnAtesakiJushoSettei
     * @return btnAtesakiJushoSettei
     */
    @JsonProperty("btnAtesakiJushoSettei")
    public ButtonDialog getBtnAtesakiJushoSettei() {
        return btnAtesakiJushoSettei;
    }

    /*
     * setbtnAtesakiJushoSettei
     * @param btnAtesakiJushoSettei btnAtesakiJushoSettei
     */
    @JsonProperty("btnAtesakiJushoSettei")
    public void setBtnAtesakiJushoSettei(ButtonDialog btnAtesakiJushoSettei) {
        this.btnAtesakiJushoSettei = btnAtesakiJushoSettei;
    }

    /*
     * gettxtAtesakiJushoSettei
     * @return txtAtesakiJushoSettei
     */
    @JsonProperty("txtAtesakiJushoSettei")
    public TextBox getTxtAtesakiJushoSettei() {
        return txtAtesakiJushoSettei;
    }

    /*
     * settxtAtesakiJushoSettei
     * @param txtAtesakiJushoSettei txtAtesakiJushoSettei
     */
    @JsonProperty("txtAtesakiJushoSettei")
    public void setTxtAtesakiJushoSettei(TextBox txtAtesakiJushoSettei) {
        this.txtAtesakiJushoSettei = txtAtesakiJushoSettei;
    }

    /*
     * gethdnChohyoDokujiTodofukenMei
     * @return hdnChohyoDokujiTodofukenMei
     */
    @JsonProperty("hdnChohyoDokujiTodofukenMei")
    public RString getHdnChohyoDokujiTodofukenMei() {
        return hdnChohyoDokujiTodofukenMei;
    }

    /*
     * sethdnChohyoDokujiTodofukenMei
     * @param hdnChohyoDokujiTodofukenMei hdnChohyoDokujiTodofukenMei
     */
    @JsonProperty("hdnChohyoDokujiTodofukenMei")
    public void setHdnChohyoDokujiTodofukenMei(RString hdnChohyoDokujiTodofukenMei) {
        this.hdnChohyoDokujiTodofukenMei = hdnChohyoDokujiTodofukenMei;
    }

    /*
     * gethdnChohyoDokujiGunMei
     * @return hdnChohyoDokujiGunMei
     */
    @JsonProperty("hdnChohyoDokujiGunMei")
    public RString getHdnChohyoDokujiGunMei() {
        return hdnChohyoDokujiGunMei;
    }

    /*
     * sethdnChohyoDokujiGunMei
     * @param hdnChohyoDokujiGunMei hdnChohyoDokujiGunMei
     */
    @JsonProperty("hdnChohyoDokujiGunMei")
    public void setHdnChohyoDokujiGunMei(RString hdnChohyoDokujiGunMei) {
        this.hdnChohyoDokujiGunMei = hdnChohyoDokujiGunMei;
    }

    /*
     * gethdnChohyoDokujiShichosonMei
     * @return hdnChohyoDokujiShichosonMei
     */
    @JsonProperty("hdnChohyoDokujiShichosonMei")
    public RString getHdnChohyoDokujiShichosonMei() {
        return hdnChohyoDokujiShichosonMei;
    }

    /*
     * sethdnChohyoDokujiShichosonMei
     * @param hdnChohyoDokujiShichosonMei hdnChohyoDokujiShichosonMei
     */
    @JsonProperty("hdnChohyoDokujiShichosonMei")
    public void setHdnChohyoDokujiShichosonMei(RString hdnChohyoDokujiShichosonMei) {
        this.hdnChohyoDokujiShichosonMei = hdnChohyoDokujiShichosonMei;
    }

    /*
     * gethdnChohyoDokujiHensyuHoho
     * @return hdnChohyoDokujiHensyuHoho
     */
    @JsonProperty("hdnChohyoDokujiHensyuHoho")
    public RString getHdnChohyoDokujiHensyuHoho() {
        return hdnChohyoDokujiHensyuHoho;
    }

    /*
     * sethdnChohyoDokujiHensyuHoho
     * @param hdnChohyoDokujiHensyuHoho hdnChohyoDokujiHensyuHoho
     */
    @JsonProperty("hdnChohyoDokujiHensyuHoho")
    public void setHdnChohyoDokujiHensyuHoho(RString hdnChohyoDokujiHensyuHoho) {
        this.hdnChohyoDokujiHensyuHoho = hdnChohyoDokujiHensyuHoho;
    }

    /*
     * gethdnChohyoDokujiKatagaki
     * @return hdnChohyoDokujiKatagaki
     */
    @JsonProperty("hdnChohyoDokujiKatagaki")
    public RString getHdnChohyoDokujiKatagaki() {
        return hdnChohyoDokujiKatagaki;
    }

    /*
     * sethdnChohyoDokujiKatagaki
     * @param hdnChohyoDokujiKatagaki hdnChohyoDokujiKatagaki
     */
    @JsonProperty("hdnChohyoDokujiKatagaki")
    public void setHdnChohyoDokujiKatagaki(RString hdnChohyoDokujiKatagaki) {
        this.hdnChohyoDokujiKatagaki = hdnChohyoDokujiKatagaki;
    }

    /*
     * gethdnサブ業務コード
     * @return hdnサブ業務コード
     */
    @JsonProperty("hdnサブ業務コード")
    public RString getHdnサブ業務コード() {
        return hdnサブ業務コード;
    }

    /*
     * sethdnサブ業務コード
     * @param hdnサブ業務コード hdnサブ業務コード
     */
    @JsonProperty("hdnサブ業務コード")
    public void setHdnサブ業務コード(RString hdnサブ業務コード) {
        this.hdnサブ業務コード = hdnサブ業務コード;
    }

    /*
     * gethdn帳票分類ID
     * @return hdn帳票分類ID
     */
    @JsonProperty("hdn帳票分類ID")
    public RString getHdn帳票分類ID() {
        return hdn帳票分類ID;
    }

    /*
     * sethdn帳票分類ID
     * @param hdn帳票分類ID hdn帳票分類ID
     */
    @JsonProperty("hdn帳票分類ID")
    public void setHdn帳票分類ID(RString hdn帳票分類ID) {
        this.hdn帳票分類ID = hdn帳票分類ID;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DisplayJushoSetteiRad implements ICommonChildDivMode {

        NotDisplay("NotDisplay"),
        Display("Display");

        private final String name;

        private DisplayJushoSetteiRad(final String name) {
            this.name = name;
        }

        public static DisplayJushoSetteiRad getEnum(String str) {
            DisplayJushoSetteiRad[] enumArray = DisplayJushoSetteiRad.values();

            for (DisplayJushoSetteiRad enumStr : enumArray) {
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

    public DisplayJushoSetteiRad getMode_DisplayJushoSetteiRad() {
        return (DisplayJushoSetteiRad) _CommonChildDivModeUtil.getMode(this.modes, DisplayJushoSetteiRad.class);
    }

    public void setMode_DisplayJushoSetteiRad(DisplayJushoSetteiRad value) {
        _CommonChildDivModeUtil.setMode(this.modes, DisplayJushoSetteiRad.class, value);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    @JsonIgnore
    public void initialize(RString サブ業務コード, RString 帳票分類ID) {
        createHandler().initialize(サブ業務コード, 帳票分類ID);
    }

    @Override
    @JsonIgnore
    public boolean is帳票独自() {
        return createHandler().is帳票独自();
    }

    @Override
    @JsonIgnore
    public boolean is都道府県名表示() {
        return createHandler().is都道府県名表示();
    }

    @Override
    @JsonIgnore
    public boolean is郡名表示() {
        return createHandler().is郡名表示();
    }

    @Override
    @JsonIgnore
    public boolean is市町村名表示() {
        return createHandler().is市町村名表示();
    }

    @Override
    @JsonIgnore
    public RString get町域編集方法() {
        return createHandler().get町域編集方法();
    }

    @Override
    @JsonIgnore
    public boolean is方書表示() {
        return createHandler().is方書表示();
    }

    @Override
    @JsonIgnore
    public void initialize_systemKanri(boolean 住所設定使用可,
            boolean 宛先住所編集ボタン使用可,
            RString 都道府県名称表示有無,
            RString 郡名称表示有無,
            RString 市町村名称表示有無,
            RString 住所編集方法,
            RString 方書表示有無) {
        createHandler().initialize_systemKanri(住所設定使用可,
                宛先住所編集ボタン使用可,
                都道府県名称表示有無,
                郡名称表示有無,
                市町村名称表示有無,
                住所編集方法,
                方書表示有無);
    }

    @JsonIgnore
    private KaigoAtesakiJushoSetteiHandler createHandler() {
        return new KaigoAtesakiJushoSetteiHandler(this);
    }
}
