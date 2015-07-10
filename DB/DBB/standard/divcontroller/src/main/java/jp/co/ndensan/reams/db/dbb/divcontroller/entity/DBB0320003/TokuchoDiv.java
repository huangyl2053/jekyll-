package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.NenkinHokenshaTotsugoJohoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.TokuChoIdoAndIraiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.TokuChoKekkaDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * Tokucho のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuchoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radChoshu")
    private RadioButton radChoshu;
    @JsonProperty("txtKisoNenkinNo2")
    private TextBox txtKisoNenkinNo2;
    @JsonProperty("txtTokubetsuChoshuTaishoNenkin")
    private TextBox txtTokubetsuChoshuTaishoNenkin;
    @JsonProperty("txtNenkinCode2")
    private TextBox txtNenkinCode2;
    @JsonProperty("txtTokuChoGimusha")
    private TextBox txtTokuChoGimusha;
    @JsonProperty("txtHosokuYM")
    private TextBoxYearMonth txtHosokuYM;
    @JsonProperty("txtKaishiYM")
    private TextBoxYearMonth txtKaishiYM;
    @JsonProperty("NenkinHokenshaTotsugoJoho")
    private NenkinHokenshaTotsugoJohoDiv NenkinHokenshaTotsugoJoho;
    @JsonProperty("TokuChoIdoAndIrai")
    private TokuChoIdoAndIraiDiv TokuChoIdoAndIrai;
    @JsonProperty("TokuChoKekka")
    private TokuChoKekkaDiv TokuChoKekka;
    @JsonProperty("mode")
    private RString mode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radChoshu")
    public RadioButton getRadChoshu() {
        return radChoshu;
    }

    @JsonProperty("radChoshu")
    public void setRadChoshu(RadioButton radChoshu) {
        this.radChoshu=radChoshu;
    }

    @JsonProperty("txtKisoNenkinNo2")
    public TextBox getTxtKisoNenkinNo2() {
        return txtKisoNenkinNo2;
    }

    @JsonProperty("txtKisoNenkinNo2")
    public void setTxtKisoNenkinNo2(TextBox txtKisoNenkinNo2) {
        this.txtKisoNenkinNo2=txtKisoNenkinNo2;
    }

    @JsonProperty("txtTokubetsuChoshuTaishoNenkin")
    public TextBox getTxtTokubetsuChoshuTaishoNenkin() {
        return txtTokubetsuChoshuTaishoNenkin;
    }

    @JsonProperty("txtTokubetsuChoshuTaishoNenkin")
    public void setTxtTokubetsuChoshuTaishoNenkin(TextBox txtTokubetsuChoshuTaishoNenkin) {
        this.txtTokubetsuChoshuTaishoNenkin=txtTokubetsuChoshuTaishoNenkin;
    }

    @JsonProperty("txtNenkinCode2")
    public TextBox getTxtNenkinCode2() {
        return txtNenkinCode2;
    }

    @JsonProperty("txtNenkinCode2")
    public void setTxtNenkinCode2(TextBox txtNenkinCode2) {
        this.txtNenkinCode2=txtNenkinCode2;
    }

    @JsonProperty("txtTokuChoGimusha")
    public TextBox getTxtTokuChoGimusha() {
        return txtTokuChoGimusha;
    }

    @JsonProperty("txtTokuChoGimusha")
    public void setTxtTokuChoGimusha(TextBox txtTokuChoGimusha) {
        this.txtTokuChoGimusha=txtTokuChoGimusha;
    }

    @JsonProperty("txtHosokuYM")
    public TextBoxYearMonth getTxtHosokuYM() {
        return txtHosokuYM;
    }

    @JsonProperty("txtHosokuYM")
    public void setTxtHosokuYM(TextBoxYearMonth txtHosokuYM) {
        this.txtHosokuYM=txtHosokuYM;
    }

    @JsonProperty("txtKaishiYM")
    public TextBoxYearMonth getTxtKaishiYM() {
        return txtKaishiYM;
    }

    @JsonProperty("txtKaishiYM")
    public void setTxtKaishiYM(TextBoxYearMonth txtKaishiYM) {
        this.txtKaishiYM=txtKaishiYM;
    }

    @JsonProperty("NenkinHokenshaTotsugoJoho")
    public NenkinHokenshaTotsugoJohoDiv getNenkinHokenshaTotsugoJoho() {
        return NenkinHokenshaTotsugoJoho;
    }

    @JsonProperty("NenkinHokenshaTotsugoJoho")
    public void setNenkinHokenshaTotsugoJoho(NenkinHokenshaTotsugoJohoDiv NenkinHokenshaTotsugoJoho) {
        this.NenkinHokenshaTotsugoJoho=NenkinHokenshaTotsugoJoho;
    }

    @JsonProperty("TokuChoIdoAndIrai")
    public TokuChoIdoAndIraiDiv getTokuChoIdoAndIrai() {
        return TokuChoIdoAndIrai;
    }

    @JsonProperty("TokuChoIdoAndIrai")
    public void setTokuChoIdoAndIrai(TokuChoIdoAndIraiDiv TokuChoIdoAndIrai) {
        this.TokuChoIdoAndIrai=TokuChoIdoAndIrai;
    }

    @JsonProperty("TokuChoKekka")
    public TokuChoKekkaDiv getTokuChoKekka() {
        return TokuChoKekka;
    }

    @JsonProperty("TokuChoKekka")
    public void setTokuChoKekka(TokuChoKekkaDiv TokuChoKekka) {
        this.TokuChoKekka=TokuChoKekka;
    }

    @JsonProperty("mode")
    public RString getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(RString mode) {
        this.mode=mode;
    }

}
