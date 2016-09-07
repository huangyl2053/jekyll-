package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JukyuSikakuShomeishoHakko;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.jukyushikakushomeishohakko.JukyuShikakuShomeishoHakkoParameter;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * JukyuSikakuShomeishoHakko のクラスファイル
 *
 * @reamsid_L DBA-1090-010 wangkun
 */
public class JukyuSikakuShomeishoHakkoDiv extends Panel implements IJukyuSikakuShomeishoHakkoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("pnlJukyushaJoho1")
    private pnlJukyushaJoho1Div pnlJukyushaJoho1;
    @JsonProperty("pnlJukyushaJoho2")
    private pnlJukyushaJoho2Div pnlJukyushaJoho2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpnlJukyushaJoho1
     * @return pnlJukyushaJoho1
     */
    @JsonProperty("pnlJukyushaJoho1")
    public pnlJukyushaJoho1Div getPnlJukyushaJoho1() {
        return pnlJukyushaJoho1;
    }

    /*
     * setpnlJukyushaJoho1
     * @param pnlJukyushaJoho1 pnlJukyushaJoho1
     */
    @JsonProperty("pnlJukyushaJoho1")
    public void setPnlJukyushaJoho1(pnlJukyushaJoho1Div pnlJukyushaJoho1) {
        this.pnlJukyushaJoho1 = pnlJukyushaJoho1;
    }

    /*
     * getpnlJukyushaJoho2
     * @return pnlJukyushaJoho2
     */
    @JsonProperty("pnlJukyushaJoho2")
    public pnlJukyushaJoho2Div getPnlJukyushaJoho2() {
        return pnlJukyushaJoho2;
    }

    /*
     * setpnlJukyushaJoho2
     * @param pnlJukyushaJoho2 pnlJukyushaJoho2
     */
    @JsonProperty("pnlJukyushaJoho2")
    public void setPnlJukyushaJoho2(pnlJukyushaJoho2Div pnlJukyushaJoho2) {
        this.pnlJukyushaJoho2 = pnlJukyushaJoho2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtKofubi() {
        return this.getPnlJukyushaJoho1().getTxtKofubi();
    }

    @JsonIgnore
    public void  setTxtKofubi(TextBox txtKofubi) {
        this.getPnlJukyushaJoho1().setTxtKofubi(txtKofubi);
    }

    @JsonIgnore
    public TextBox getTxtIdoYotebi() {
        return this.getPnlJukyushaJoho1().getTxtIdoYotebi();
    }

    @JsonIgnore
    public void  setTxtIdoYotebi(TextBox txtIdoYotebi) {
        this.getPnlJukyushaJoho1().setTxtIdoYotebi(txtIdoYotebi);
    }

    @JsonIgnore
    public TextBox getTxtYokaigoJotaiKubun() {
        return this.getPnlJukyushaJoho1().getTxtYokaigoJotaiKubun();
    }

    @JsonIgnore
    public void  setTxtYokaigoJotaiKubun(TextBox txtYokaigoJotaiKubun) {
        this.getPnlJukyushaJoho1().setTxtYokaigoJotaiKubun(txtYokaigoJotaiKubun);
    }

    @JsonIgnore
    public TextBox getTxtShinsebi() {
        return this.getPnlJukyushaJoho1().getTxtShinsebi();
    }

    @JsonIgnore
    public void  setTxtShinsebi(TextBox txtShinsebi) {
        this.getPnlJukyushaJoho1().setTxtShinsebi(txtShinsebi);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtdrYukokikan() {
        return this.getPnlJukyushaJoho1().getTxtdrYukokikan();
    }

    @JsonIgnore
    public void  setTxtdrYukokikan(TextBoxDateRange txtdrYukokikan) {
        this.getPnlJukyushaJoho1().setTxtdrYukokikan(txtdrYukokikan);
    }

    @JsonIgnore
    public TextBox getTxtfutanWariaiKubun() {
        return this.getPnlJukyushaJoho1().getTxtfutanWariaiKubun();
    }

    @JsonIgnore
    public void  setTxtfutanWariaiKubun(TextBox txtfutanWariaiKubun) {
        this.getPnlJukyushaJoho1().setTxtfutanWariaiKubun(txtfutanWariaiKubun);
    }

    @JsonIgnore
    public TextBox getTxtfutanWariai() {
        return this.getPnlJukyushaJoho1().getTxtfutanWariai();
    }

    @JsonIgnore
    public void  setTxtfutanWariai(TextBox txtfutanWariai) {
        this.getPnlJukyushaJoho1().setTxtfutanWariai(txtfutanWariai);
    }

    @JsonIgnore
    public CheckBoxList getCblInji() {
        return this.getPnlJukyushaJoho1().getCblInji();
    }

    @JsonIgnore
    public void  setCblInji(CheckBoxList cblInji) {
        this.getPnlJukyushaJoho1().setCblInji(cblInji);
    }

    @JsonIgnore
    public Label getLblShinsakaiYikan() {
        return this.getPnlJukyushaJoho2().getLblShinsakaiYikan();
    }

    @JsonIgnore
    public void  setLblShinsakaiYikan(Label lblShinsakaiYikan) {
        this.getPnlJukyushaJoho2().setLblShinsakaiYikan(lblShinsakaiYikan);
    }

    @JsonIgnore
    public TextBoxMultiLine getTbmShinsakaiYikan() {
        return this.getPnlJukyushaJoho2().getTbmShinsakaiYikan();
    }

    @JsonIgnore
    public void  setTbmShinsakaiYikan(TextBoxMultiLine tbmShinsakaiYikan) {
        this.getPnlJukyushaJoho2().setTbmShinsakaiYikan(tbmShinsakaiYikan);
    }

    @JsonIgnore
    public Label getLblBiko() {
        return this.getPnlJukyushaJoho2().getLblBiko();
    }

    @JsonIgnore
    public void  setLblBiko(Label lblBiko) {
        this.getPnlJukyushaJoho2().setLblBiko(lblBiko);
    }

    @JsonIgnore
    public TextBoxMultiLine getTbmBiko() {
        return this.getPnlJukyushaJoho2().getTbmBiko();
    }

    @JsonIgnore
    public void  setTbmBiko(TextBoxMultiLine tbmBiko) {
        this.getPnlJukyushaJoho2().setTbmBiko(tbmBiko);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private JukyuSikakuShomeishoHakkoHandler getHandler() {
        return new JukyuSikakuShomeishoHakkoHandler(this);
    }
    private static final RString 有効区分 = new RString("1");

    /**
     * 共通子DIVの初期化処理です。
     *
     * @param 被保険者番号 被保険者番号
     */
    @Override
    public void initialize(RString 被保険者番号) {
        RString nendo;
        FlexibleDate now = FlexibleDate.getNowDate();
        if (now.getMonthValue() < 8) {
            nendo = now.getNendo().minusYear(1).toDateString();
        } else {
            nendo = now.getNendo().toDateString();
        }
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.未定義), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        List<JuminJotai> 住民状態 = new ArrayList();
        住民種別.add(JuminShubetsu.日本人);
        住民種別.add(JuminShubetsu.外国人);
        住民状態.add(JuminJotai.住民);
        住民状態.add(JuminJotai.住登外);
        住民状態.add(JuminJotai.消除者);
        住民状態.add(JuminJotai.転出者);
        key.set住民種別(住民種別);
        key.set住民状態(住民状態);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        getHandler().initialize(JukyuShikakuShomeishoHakkoParameter.createSelectBy被保険者番号(被保険者番号, 有効区分,
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()), nendo));
    }

    @Override
    public JukyuSikakuShomeishoHakkoDiv getJukyuSikakuShomeishoHakkoDiv() {
        return this;
    }
}
