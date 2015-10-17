package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.KaigoNinteiShinchokuJokyoKojin;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.KaigoNinteiShinseishaInfo.IKaigoNinteiShinseishaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.KaigoNinteiShinseishaInfo.KaigoNinteiShinseishaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.NinteiChosaJokyoInput.INinteiChosaJokyoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.NinteiChosaJokyoInput.NinteiChosaJokyoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonBatchRegister;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * KaigoNinteiShinchokuJokyoKojin のクラスファイル
 *
 * @author 自動生成
 */
public class KaigoNinteiShinchokuJokyoKojinDiv extends Panel implements IKaigoNinteiShinchokuJokyoKojinDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("ccdKaigoNinteiShinseishaInfo")
    private KaigoNinteiShinseishaInfoDiv ccdKaigoNinteiShinseishaInfo;
    @JsonProperty("ShinchokuJokyo")
    private ShinchokuJokyoDiv ShinchokuJokyo;
    @JsonProperty("ccdNinteiChosaJokyoInput")
    private NinteiChosaJokyoInputDiv ccdNinteiChosaJokyoInput;
    @JsonProperty("btnModoru")
    private Button btnModoru;
    @JsonProperty("btnKojinShinchokuPrint")
    private ButtonBatchRegister btnKojinShinchokuPrint;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdKaigoNinteiShinseishaInfo")
    public IKaigoNinteiShinseishaInfoDiv getCcdKaigoNinteiShinseishaInfo() {
        return ccdKaigoNinteiShinseishaInfo;
    }

    @JsonProperty("ShinchokuJokyo")
    public ShinchokuJokyoDiv getShinchokuJokyo() {
        return ShinchokuJokyo;
    }

    @JsonProperty("ShinchokuJokyo")
    public void setShinchokuJokyo(ShinchokuJokyoDiv ShinchokuJokyo) {
        this.ShinchokuJokyo = ShinchokuJokyo;
    }

    @JsonProperty("ccdNinteiChosaJokyoInput")
    public INinteiChosaJokyoInputDiv getCcdNinteiChosaJokyoInput() {
        return ccdNinteiChosaJokyoInput;
    }

    @JsonProperty("btnModoru")
    public Button getBtnModoru() {
        return btnModoru;
    }

    @JsonProperty("btnModoru")
    public void setBtnModoru(Button btnModoru) {
        this.btnModoru = btnModoru;
    }

    @JsonProperty("btnKojinShinchokuPrint")
    public ButtonBatchRegister getBtnKojinShinchokuPrint() {
        return btnKojinShinchokuPrint;
    }

    @JsonProperty("btnKojinShinchokuPrint")
    public void setBtnKojinShinchokuPrint(ButtonBatchRegister btnKojinShinchokuPrint) {
        this.btnKojinShinchokuPrint = btnKojinShinchokuPrint;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tplShinchoKujokyoDiv getTplShinchoKujokyo() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo();
    }

    @JsonIgnore
    public void setTplShinchoKujokyo(tplShinchoKujokyoDiv tplShinchoKujokyo) {
        this.getShinchokuJokyo().setTplShinchoKujokyo(tplShinchoKujokyo);
    }

    @JsonIgnore
    public Label getLblShinseiToroku() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getLblShinseiToroku();
    }

    @JsonIgnore
    public Label getLblNinteiChosaIrai() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getLblNinteiChosaIrai();
    }

    @JsonIgnore
    public Label getLblNinteiChosaJisshi() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getLblNinteiChosaJisshi();
    }

    @JsonIgnore
    public Label getShujiIkenshoSakuseiIrai() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getShujiIkenshoSakuseiIrai();
    }

    @JsonIgnore
    public Label getLblShujiiIkenshoToroku() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getLblShujiiIkenshoToroku();
    }

    @JsonIgnore
    public Label getIblIchijiHantei() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getIblIchijiHantei();
    }

    @JsonIgnore
    public Label getLblMasking() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getLblMasking();
    }

    @JsonIgnore
    public Label getLblKaigoNinteiShinsakaiWaritsuke() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getLblKaigoNinteiShinsakaiWaritsuke();
    }

    @JsonIgnore
    public Label getLblKaigoNinteiShinsakaiJissi() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getLblKaigoNinteiShinsakaiJissi();
    }

    @JsonIgnore
    public Label getLblYoteiDay() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getLblYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiTorokuYoteiDay() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getTxtShinseiTorokuYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiChosaIraiYoteiDay() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getTxtNinteiChosaIraiYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiChosaJisshiYoteiDay() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getTxtNinteiChosaJisshiYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtShujiIkenshoSakuseiIraiYoteiDay() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getTxtShujiIkenshoSakuseiIraiYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtShujiiIkenshoTorokuYoteiDay() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getTxtShujiiIkenshoTorokuYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtIchijiHanteiYoteiDay() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getTxtIchijiHanteiYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtMaskingYoteiDay() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getTxtMaskingYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtKaigoNinteiShinsakaiWaritsukeYoteiDay() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getTxtKaigoNinteiShinsakaiWaritsukeYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtKaigoNinteiShinsakaiJissiYoteiDay() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getTxtKaigoNinteiShinsakaiJissiYoteiDay();
    }

    @JsonIgnore
    public Label getLblKanryoDay() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getLblKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiTorokuKanryoDay() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getTxtShinseiTorokuKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiChosaIraiKanryoDay() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getTxtNinteiChosaIraiKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiChosaJisshiKanryoDay() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getTxtNinteiChosaJisshiKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtShujiIkenshoSakuseiIraiKanryoDay() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getTxtShujiIkenshoSakuseiIraiKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtShujiiIkenshoTorokuKanryoDay() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getTxtShujiiIkenshoTorokuKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtIchijiHanteiKanryoDay() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getTxtIchijiHanteiKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtMaskingKanryo() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getTxtMaskingKanryo();
    }

    @JsonIgnore
    public TextBoxDate getTxtKaigoNinteiShinsakaiWaritsukeKanryoDay() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getTxtKaigoNinteiShinsakaiWaritsukeKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtKaigoNinteiShinsakaiJissiKanryoDay() {
        return this.getShinchokuJokyo().getTplShinchoKujokyo().getTxtKaigoNinteiShinsakaiJissiKanryoDay();
    }

    //--------------- この行より下にコードを追加してください -------------------
}
