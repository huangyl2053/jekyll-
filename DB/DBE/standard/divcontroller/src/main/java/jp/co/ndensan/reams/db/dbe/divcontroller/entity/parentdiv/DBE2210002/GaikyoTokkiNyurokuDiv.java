package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.ChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.IChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseishaInfo.KaigoNinteiShinseishaInfo.IKaigoNinteiShinseishaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiKihon.NinteiShinseiRenrakusakiKihon.INinteiShinseiRenrakusakiKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * GaikyoTokkiNyuroku のクラスファイル
 *
 * @author 自動生成
 */
public class GaikyoTokkiNyurokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChosaTaisho")
    private ChosaTaishoDiv ChosaTaisho;
    @JsonProperty("GaikyoTokkiNyuryoku")
    private GaikyoTokkiNyuryokuDiv GaikyoTokkiNyuryoku;
    @JsonProperty("btnZenkaiCopy")
    private Button btnZenkaiCopy;
    @JsonProperty("ccdChosaJisshishaJoho")
    private ChosaJisshishaJohoDiv ccdChosaJisshishaJoho;
    @JsonProperty("hidden登録業務コード")
    private RString hidden登録業務コード;
    @JsonProperty("hidden登録グループコード")
    private RString hidden登録グループコード;
    @JsonProperty("hiddenサンプル文書")
    private RString hiddenサンプル文書;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChosaTaisho
     * @return ChosaTaisho
     */
    @JsonProperty("ChosaTaisho")
    public ChosaTaishoDiv getChosaTaisho() {
        return ChosaTaisho;
    }

    /*
     * setChosaTaisho
     * @param ChosaTaisho ChosaTaisho
     */
    @JsonProperty("ChosaTaisho")
    public void setChosaTaisho(ChosaTaishoDiv ChosaTaisho) {
        this.ChosaTaisho = ChosaTaisho;
    }

    /*
     * getGaikyoTokkiNyuryoku
     * @return GaikyoTokkiNyuryoku
     */
    @JsonProperty("GaikyoTokkiNyuryoku")
    public GaikyoTokkiNyuryokuDiv getGaikyoTokkiNyuryoku() {
        return GaikyoTokkiNyuryoku;
    }

    /*
     * setGaikyoTokkiNyuryoku
     * @param GaikyoTokkiNyuryoku GaikyoTokkiNyuryoku
     */
    @JsonProperty("GaikyoTokkiNyuryoku")
    public void setGaikyoTokkiNyuryoku(GaikyoTokkiNyuryokuDiv GaikyoTokkiNyuryoku) {
        this.GaikyoTokkiNyuryoku = GaikyoTokkiNyuryoku;
    }

    /*
     * getbtnZenkaiCopy
     * @return btnZenkaiCopy
     */
    @JsonProperty("btnZenkaiCopy")
    public Button getBtnZenkaiCopy() {
        return btnZenkaiCopy;
    }

    /*
     * setbtnZenkaiCopy
     * @param btnZenkaiCopy btnZenkaiCopy
     */
    @JsonProperty("btnZenkaiCopy")
    public void setBtnZenkaiCopy(Button btnZenkaiCopy) {
        this.btnZenkaiCopy = btnZenkaiCopy;
    }

    /*
     * getccdChosaJisshishaJoho
     * @return ccdChosaJisshishaJoho
     */
    @JsonProperty("ccdChosaJisshishaJoho")
    public IChosaJisshishaJohoDiv getCcdChosaJisshishaJoho() {
        return ccdChosaJisshishaJoho;
    }

    /*
     * gethidden登録業務コード
     * @return hidden登録業務コード
     */
    @JsonProperty("hidden登録業務コード")
    public RString getHidden登録業務コード() {
        return hidden登録業務コード;
    }

    /*
     * sethidden登録業務コード
     * @param hidden登録業務コード hidden登録業務コード
     */
    @JsonProperty("hidden登録業務コード")
    public void setHidden登録業務コード(RString hidden登録業務コード) {
        this.hidden登録業務コード = hidden登録業務コード;
    }

    /*
     * gethidden登録グループコード
     * @return hidden登録グループコード
     */
    @JsonProperty("hidden登録グループコード")
    public RString getHidden登録グループコード() {
        return hidden登録グループコード;
    }

    /*
     * sethidden登録グループコード
     * @param hidden登録グループコード hidden登録グループコード
     */
    @JsonProperty("hidden登録グループコード")
    public void setHidden登録グループコード(RString hidden登録グループコード) {
        this.hidden登録グループコード = hidden登録グループコード;
    }

    /*
     * gethiddenサンプル文書
     * @return hidden登録グループコード
     */
    @JsonProperty("hiddenサンプル文書")
    public RString getHiddenサンプル文書() {
        return hiddenサンプル文書;
    }

    /*
     * sethiddenサンプル文書
     * @param hiddenサンプル文書 hiddenサンプル文書
     */
    @JsonProperty("hiddenサンプル文書")
    public void setHiddenサンプル文書(RString hiddenサンプル文書) {
        this.hiddenサンプル文書 = hiddenサンプル文書;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RenrakusakiKihonDiv getRenrakusakiKihon() {
        return this.getChosaTaisho().getRenrakusakiKihon();
    }

    @JsonIgnore
    public void setRenrakusakiKihon(RenrakusakiKihonDiv RenrakusakiKihon) {
        this.getChosaTaisho().setRenrakusakiKihon(RenrakusakiKihon);
    }

    @JsonIgnore
    public INinteiShinseiRenrakusakiKihonDiv getCcdNinteiShinseiRenrakusakiKihon() {
        return this.getChosaTaisho().getRenrakusakiKihon().getCcdNinteiShinseiRenrakusakiKihon();
    }

    @JsonIgnore
    public IKaigoNinteiShinseishaInfoDiv getCcdKaigoNinteiShiseishaInfo() {
        return this.getChosaTaisho().getCcdKaigoNinteiShiseishaInfo();
    }

    @JsonIgnore
    public Label getLblGenzaiService() {
        return this.getGaikyoTokkiNyuryoku().getLblGenzaiService();
    }

    @JsonIgnore
    public void setLblGenzaiService(Label lblGenzaiService) {
        this.getGaikyoTokkiNyuryoku().setLblGenzaiService(lblGenzaiService);
    }

    @JsonIgnore
    public Label getLblJutakuKaishu() {
        return this.getGaikyoTokkiNyuryoku().getLblJutakuKaishu();
    }

    @JsonIgnore
    public void setLblJutakuKaishu(Label lblJutakuKaishu) {
        this.getGaikyoTokkiNyuryoku().setLblJutakuKaishu(lblJutakuKaishu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtJutakuKaishu() {
        return this.getGaikyoTokkiNyuryoku().getTxtJutakuKaishu();
    }

    @JsonIgnore
    public void setTxtJutakuKaishu(TextBoxMultiLine txtJutakuKaishu) {
        this.getGaikyoTokkiNyuryoku().setTxtJutakuKaishu(txtJutakuKaishu);
    }

    @JsonIgnore
    public ButtonDialog getBtnJutakuKaishuTeikeibun() {
        return this.getGaikyoTokkiNyuryoku().getBtnJutakuKaishuTeikeibun();
    }

    @JsonIgnore
    public void setBtnJutakuKaishuTeikeibun(ButtonDialog btnJutakuKaishuTeikeibun) {
        this.getGaikyoTokkiNyuryoku().setBtnJutakuKaishuTeikeibun(btnJutakuKaishuTeikeibun);
    }

    @JsonIgnore
    public Label getLblChosaTaishoTokkiJiko() {
        return this.getGaikyoTokkiNyuryoku().getLblChosaTaishoTokkiJiko();
    }

    @JsonIgnore
    public void setLblChosaTaishoTokkiJiko(Label lblChosaTaishoTokkiJiko) {
        this.getGaikyoTokkiNyuryoku().setLblChosaTaishoTokkiJiko(lblChosaTaishoTokkiJiko);
    }

    @JsonIgnore
    public Label getLblChosaTishoShuso() {
        return this.getGaikyoTokkiNyuryoku().getLblChosaTishoShuso();
    }

    @JsonIgnore
    public void setLblChosaTishoShuso(Label lblChosaTishoShuso) {
        this.getGaikyoTokkiNyuryoku().setLblChosaTishoShuso(lblChosaTishoShuso);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtChosaTaishoShuso() {
        return this.getGaikyoTokkiNyuryoku().getTxtChosaTaishoShuso();
    }

    @JsonIgnore
    public void setTxtChosaTaishoShuso(TextBoxMultiLine txtChosaTaishoShuso) {
        this.getGaikyoTokkiNyuryoku().setTxtChosaTaishoShuso(txtChosaTaishoShuso);
    }

    @JsonIgnore
    public ButtonDialog getBtnChosaTaishoShusoTeikeibun() {
        return this.getGaikyoTokkiNyuryoku().getBtnChosaTaishoShusoTeikeibun();
    }

    @JsonIgnore
    public void setBtnChosaTaishoShusoTeikeibun(ButtonDialog btnChosaTaishoShusoTeikeibun) {
        this.getGaikyoTokkiNyuryoku().setBtnChosaTaishoShusoTeikeibun(btnChosaTaishoShusoTeikeibun);
    }

    @JsonIgnore
    public Label getLblChosaTaishoKazokuJokyo() {
        return this.getGaikyoTokkiNyuryoku().getLblChosaTaishoKazokuJokyo();
    }

    @JsonIgnore
    public void setLblChosaTaishoKazokuJokyo(Label lblChosaTaishoKazokuJokyo) {
        this.getGaikyoTokkiNyuryoku().setLblChosaTaishoKazokuJokyo(lblChosaTaishoKazokuJokyo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtChosaTishoKazokuJokyo() {
        return this.getGaikyoTokkiNyuryoku().getTxtChosaTishoKazokuJokyo();
    }

    @JsonIgnore
    public void setTxtChosaTishoKazokuJokyo(TextBoxMultiLine txtChosaTishoKazokuJokyo) {
        this.getGaikyoTokkiNyuryoku().setTxtChosaTishoKazokuJokyo(txtChosaTishoKazokuJokyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnChosaTaishoKazokuJokyoTeikeibun() {
        return this.getGaikyoTokkiNyuryoku().getBtnChosaTaishoKazokuJokyoTeikeibun();
    }

    @JsonIgnore
    public void setBtnChosaTaishoKazokuJokyoTeikeibun(ButtonDialog btnChosaTaishoKazokuJokyoTeikeibun) {
        this.getGaikyoTokkiNyuryoku().setBtnChosaTaishoKazokuJokyoTeikeibun(btnChosaTaishoKazokuJokyoTeikeibun);
    }

    @JsonIgnore
    public Label getLblChosaTaishoKyojuKankyo() {
        return this.getGaikyoTokkiNyuryoku().getLblChosaTaishoKyojuKankyo();
    }

    @JsonIgnore
    public void setLblChosaTaishoKyojuKankyo(Label lblChosaTaishoKyojuKankyo) {
        this.getGaikyoTokkiNyuryoku().setLblChosaTaishoKyojuKankyo(lblChosaTaishoKyojuKankyo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtChosaTaishoKyojuKankyo() {
        return this.getGaikyoTokkiNyuryoku().getTxtChosaTaishoKyojuKankyo();
    }

    @JsonIgnore
    public void setTxtChosaTaishoKyojuKankyo(TextBoxMultiLine txtChosaTaishoKyojuKankyo) {
        this.getGaikyoTokkiNyuryoku().setTxtChosaTaishoKyojuKankyo(txtChosaTaishoKyojuKankyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnChosaTaishoKyojuKankyoTeikeibun() {
        return this.getGaikyoTokkiNyuryoku().getBtnChosaTaishoKyojuKankyoTeikeibun();
    }

    @JsonIgnore
    public void setBtnChosaTaishoKyojuKankyoTeikeibun(ButtonDialog btnChosaTaishoKyojuKankyoTeikeibun) {
        this.getGaikyoTokkiNyuryoku().setBtnChosaTaishoKyojuKankyoTeikeibun(btnChosaTaishoKyojuKankyoTeikeibun);
    }

    @JsonIgnore
    public Label getLblNichijoShiyoKikiUmu() {
        return this.getGaikyoTokkiNyuryoku().getLblNichijoShiyoKikiUmu();
    }

    @JsonIgnore
    public void setLblNichijoShiyoKikiUmu(Label lblNichijoShiyoKikiUmu) {
        this.getGaikyoTokkiNyuryoku().setLblNichijoShiyoKikiUmu(lblNichijoShiyoKikiUmu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtNichijoShiyoKikiUmu() {
        return this.getGaikyoTokkiNyuryoku().getTxtNichijoShiyoKikiUmu();
    }

    @JsonIgnore
    public void setTxtNichijoShiyoKikiUmu(TextBoxMultiLine txtNichijoShiyoKikiUmu) {
        this.getGaikyoTokkiNyuryoku().setTxtNichijoShiyoKikiUmu(txtNichijoShiyoKikiUmu);
    }

    @JsonIgnore
    public ButtonDialog getBtnNichijoShiyoKikiUmu() {
        return this.getGaikyoTokkiNyuryoku().getBtnNichijoShiyoKikiUmu();
    }

    @JsonIgnore
    public void setBtnNichijoShiyoKikiUmu(ButtonDialog btnNichijoShiyoKikiUmu) {
        this.getGaikyoTokkiNyuryoku().setBtnNichijoShiyoKikiUmu(btnNichijoShiyoKikiUmu);
    }

    // </editor-fold>
}
