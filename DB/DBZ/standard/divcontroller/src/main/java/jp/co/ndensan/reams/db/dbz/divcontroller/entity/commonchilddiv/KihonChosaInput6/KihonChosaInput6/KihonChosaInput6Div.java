package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput6.KihonChosaInput6;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;

/**
 * KihonChosaInput6 のクラスファイル
 *
 * @reamsid_L DBE-3000-095 wangjie2
 */
public class KihonChosaInput6Div extends Panel implements IKihonChosaInput6Div {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ZenkaiHyojiTeiji")
    private Label ZenkaiHyojiTeiji;
    @JsonProperty("TokubetsuIryo")
    private TokubetsuIryoDiv TokubetsuIryo;
    @JsonProperty("btnConfirm")
    private Button btnConfirm;
    @JsonProperty("btnBack")
    private Button btnBack;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getZenkaiHyojiTeiji
     * @return ZenkaiHyojiTeiji
     */
    @JsonProperty("ZenkaiHyojiTeiji")
    public Label getZenkaiHyojiTeiji() {
        return ZenkaiHyojiTeiji;
    }

    /*
     * setZenkaiHyojiTeiji
     * @param ZenkaiHyojiTeiji ZenkaiHyojiTeiji
     */
    @JsonProperty("ZenkaiHyojiTeiji")
    public void setZenkaiHyojiTeiji(Label ZenkaiHyojiTeiji) {
        this.ZenkaiHyojiTeiji = ZenkaiHyojiTeiji;
    }

    /*
     * getTokubetsuIryo
     * @return TokubetsuIryo
     */
    @JsonProperty("TokubetsuIryo")
    public TokubetsuIryoDiv getTokubetsuIryo() {
        return TokubetsuIryo;
    }

    /*
     * setTokubetsuIryo
     * @param TokubetsuIryo TokubetsuIryo
     */
    @JsonProperty("TokubetsuIryo")
    public void setTokubetsuIryo(TokubetsuIryoDiv TokubetsuIryo) {
        this.TokubetsuIryo = TokubetsuIryo;
    }

    /*
     * getbtnConfirm
     * @return btnConfirm
     */
    @JsonProperty("btnConfirm")
    public Button getBtnConfirm() {
        return btnConfirm;
    }

    /*
     * setbtnConfirm
     * @param btnConfirm btnConfirm
     */
    @JsonProperty("btnConfirm")
    public void setBtnConfirm(Button btnConfirm) {
        this.btnConfirm = btnConfirm;
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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ShochiNaiyoDiv getShochiNaiyo() {
        return this.getTokubetsuIryo().getShochiNaiyo();
    }

    @JsonIgnore
    public void  setShochiNaiyo(ShochiNaiyoDiv ShochiNaiyo) {
        this.getTokubetsuIryo().setShochiNaiyo(ShochiNaiyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnShochiNaiyo() {
        return this.getTokubetsuIryo().getShochiNaiyo().getBtnShochiNaiyo();
    }

    @JsonIgnore
    public void  setBtnShochiNaiyo(ButtonDialog btnShochiNaiyo) {
        this.getTokubetsuIryo().getShochiNaiyo().setBtnShochiNaiyo(btnShochiNaiyo);
    }

    @JsonIgnore
    public CheckBoxList getChkShochiNaiyo() {
        return this.getTokubetsuIryo().getShochiNaiyo().getChkShochiNaiyo();
    }

    @JsonIgnore
    public void  setChkShochiNaiyo(CheckBoxList chkShochiNaiyo) {
        this.getTokubetsuIryo().getShochiNaiyo().setChkShochiNaiyo(chkShochiNaiyo);
    }

    @JsonIgnore
    public TokiTaiouDiv getTokiTaiou() {
        return this.getTokubetsuIryo().getTokiTaiou();
    }

    @JsonIgnore
    public void  setTokiTaiou(TokiTaiouDiv TokiTaiou) {
        this.getTokubetsuIryo().setTokiTaiou(TokiTaiou);
    }

    @JsonIgnore
    public ButtonDialog getBtnTokiTaiou() {
        return this.getTokubetsuIryo().getTokiTaiou().getBtnTokiTaiou();
    }

    @JsonIgnore
    public void  setBtnTokiTaiou(ButtonDialog btnTokiTaiou) {
        this.getTokubetsuIryo().getTokiTaiou().setBtnTokiTaiou(btnTokiTaiou);
    }

    @JsonIgnore
    public CheckBoxList getChkTokiTaiou() {
        return this.getTokubetsuIryo().getTokiTaiou().getChkTokiTaiou();
    }

    @JsonIgnore
    public void  setChkTokiTaiou(CheckBoxList chkTokiTaiou) {
        this.getTokubetsuIryo().getTokiTaiou().setChkTokiTaiou(chkTokiTaiou);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void onLoad(ShinseishoKanriNo 申請書管理番号, RString 認定調査依頼履歴番号, List<KihonChosaInput> 認定調査基本情報リスト) {
        KihonChosaInputHandler6 handler = new KihonChosaInputHandler6(this);
        handler.onLoad(申請書管理番号, 認定調査依頼履歴番号, 認定調査基本情報リスト);
    }

}
