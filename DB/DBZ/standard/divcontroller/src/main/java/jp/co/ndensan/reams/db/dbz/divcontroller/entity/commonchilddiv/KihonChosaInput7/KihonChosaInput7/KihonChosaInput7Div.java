package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput7.KihonChosaInput7;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * KihonChosaInput7 のクラスファイル
 *
 * @reamsid_L DBE-3000-096 wangjie2
 */
public class KihonChosaInput7Div extends Panel implements IKihonChosaInput7Div {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ZenkaiHyojiTeiji")
    private Label ZenkaiHyojiTeiji;
    @JsonProperty("Jiritsudo")
    private JiritsudoDiv Jiritsudo;
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
     * getJiritsudo
     * @return Jiritsudo
     */
    @JsonProperty("Jiritsudo")
    public JiritsudoDiv getJiritsudo() {
        return Jiritsudo;
    }

    /*
     * setJiritsudo
     * @param Jiritsudo Jiritsudo
     */
    @JsonProperty("Jiritsudo")
    public void setJiritsudo(JiritsudoDiv Jiritsudo) {
        this.Jiritsudo = Jiritsudo;
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
    public ShogaiKoreishaDiv getShogaiKoreisha() {
        return this.getJiritsudo().getShogaiKoreisha();
    }

    @JsonIgnore
    public void  setShogaiKoreisha(ShogaiKoreishaDiv ShogaiKoreisha) {
        this.getJiritsudo().setShogaiKoreisha(ShogaiKoreisha);
    }

    @JsonIgnore
    public ButtonDialog getBtnShogaiKoreisha() {
        return this.getJiritsudo().getShogaiKoreisha().getBtnShogaiKoreisha();
    }

    @JsonIgnore
    public void  setBtnShogaiKoreisha(ButtonDialog btnShogaiKoreisha) {
        this.getJiritsudo().getShogaiKoreisha().setBtnShogaiKoreisha(btnShogaiKoreisha);
    }

    @JsonIgnore
    public RadioButton getRadShogaiKoreisha() {
        return this.getJiritsudo().getShogaiKoreisha().getRadShogaiKoreisha();
    }

    @JsonIgnore
    public void  setRadShogaiKoreisha(RadioButton radShogaiKoreisha) {
        this.getJiritsudo().getShogaiKoreisha().setRadShogaiKoreisha(radShogaiKoreisha);
    }

    @JsonIgnore
    public NinchishaJiritsudoDiv getNinchishaJiritsudo() {
        return this.getJiritsudo().getNinchishaJiritsudo();
    }

    @JsonIgnore
    public void  setNinchishaJiritsudo(NinchishaJiritsudoDiv NinchishaJiritsudo) {
        this.getJiritsudo().setNinchishaJiritsudo(NinchishaJiritsudo);
    }

    @JsonIgnore
    public ButtonDialog getBtnNinchishaJiritsudo() {
        return this.getJiritsudo().getNinchishaJiritsudo().getBtnNinchishaJiritsudo();
    }

    @JsonIgnore
    public void  setBtnNinchishaJiritsudo(ButtonDialog btnNinchishaJiritsudo) {
        this.getJiritsudo().getNinchishaJiritsudo().setBtnNinchishaJiritsudo(btnNinchishaJiritsudo);
    }

    @JsonIgnore
    public RadioButton getRadNinchishaJiritsudo() {
        return this.getJiritsudo().getNinchishaJiritsudo().getRadNinchishaJiritsudo();
    }

    @JsonIgnore
    public void  setRadNinchishaJiritsudo(RadioButton radNinchishaJiritsudo) {
        this.getJiritsudo().getNinchishaJiritsudo().setRadNinchishaJiritsudo(radNinchishaJiritsudo);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void onLoad(ShinseishoKanriNo 申請書管理番号, RString 認定調査依頼履歴番号, List<KihonChosaInput> 認定調査基本情報リスト) {
        KihonChosaInputHandler7 handler = new KihonChosaInputHandler7(this);
        handler.onLoad(申請書管理番号, 認定調査依頼履歴番号, 認定調査基本情報リスト);
    }

}
