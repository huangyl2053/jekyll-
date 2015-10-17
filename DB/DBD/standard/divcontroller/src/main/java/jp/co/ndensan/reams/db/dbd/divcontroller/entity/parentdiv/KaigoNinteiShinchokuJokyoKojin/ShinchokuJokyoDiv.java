package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.KaigoNinteiShinchokuJokyoKojin;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.KaigoNinteiShinchokuJokyoKojin.tplShinchoKujokyoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinchokuJokyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinchokuJokyoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplShinchoKujokyo")
    private tplShinchoKujokyoDiv tplShinchoKujokyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplShinchoKujokyo")
    public tplShinchoKujokyoDiv getTplShinchoKujokyo() {
        return tplShinchoKujokyo;
    }

    @JsonProperty("tplShinchoKujokyo")
    public void setTplShinchoKujokyo(tplShinchoKujokyoDiv tplShinchoKujokyo) {
        this.tplShinchoKujokyo=tplShinchoKujokyo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblShinseiToroku() {
        return this.getTplShinchoKujokyo().getLblShinseiToroku();
    }

    @JsonIgnore
    public Label getLblNinteiChosaIrai() {
        return this.getTplShinchoKujokyo().getLblNinteiChosaIrai();
    }

    @JsonIgnore
    public Label getLblNinteiChosaJisshi() {
        return this.getTplShinchoKujokyo().getLblNinteiChosaJisshi();
    }

    @JsonIgnore
    public Label getShujiIkenshoSakuseiIrai() {
        return this.getTplShinchoKujokyo().getShujiIkenshoSakuseiIrai();
    }

    @JsonIgnore
    public Label getLblShujiiIkenshoToroku() {
        return this.getTplShinchoKujokyo().getLblShujiiIkenshoToroku();
    }

    @JsonIgnore
    public Label getIblIchijiHantei() {
        return this.getTplShinchoKujokyo().getIblIchijiHantei();
    }

    @JsonIgnore
    public Label getLblMasking() {
        return this.getTplShinchoKujokyo().getLblMasking();
    }

    @JsonIgnore
    public Label getLblKaigoNinteiShinsakaiWaritsuke() {
        return this.getTplShinchoKujokyo().getLblKaigoNinteiShinsakaiWaritsuke();
    }

    @JsonIgnore
    public Label getLblKaigoNinteiShinsakaiJissi() {
        return this.getTplShinchoKujokyo().getLblKaigoNinteiShinsakaiJissi();
    }

    @JsonIgnore
    public Label getLblYoteiDay() {
        return this.getTplShinchoKujokyo().getLblYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiTorokuYoteiDay() {
        return this.getTplShinchoKujokyo().getTxtShinseiTorokuYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiChosaIraiYoteiDay() {
        return this.getTplShinchoKujokyo().getTxtNinteiChosaIraiYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiChosaJisshiYoteiDay() {
        return this.getTplShinchoKujokyo().getTxtNinteiChosaJisshiYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtShujiIkenshoSakuseiIraiYoteiDay() {
        return this.getTplShinchoKujokyo().getTxtShujiIkenshoSakuseiIraiYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtShujiiIkenshoTorokuYoteiDay() {
        return this.getTplShinchoKujokyo().getTxtShujiiIkenshoTorokuYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtIchijiHanteiYoteiDay() {
        return this.getTplShinchoKujokyo().getTxtIchijiHanteiYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtMaskingYoteiDay() {
        return this.getTplShinchoKujokyo().getTxtMaskingYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtKaigoNinteiShinsakaiWaritsukeYoteiDay() {
        return this.getTplShinchoKujokyo().getTxtKaigoNinteiShinsakaiWaritsukeYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtKaigoNinteiShinsakaiJissiYoteiDay() {
        return this.getTplShinchoKujokyo().getTxtKaigoNinteiShinsakaiJissiYoteiDay();
    }

    @JsonIgnore
    public Label getLblKanryoDay() {
        return this.getTplShinchoKujokyo().getLblKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiTorokuKanryoDay() {
        return this.getTplShinchoKujokyo().getTxtShinseiTorokuKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiChosaIraiKanryoDay() {
        return this.getTplShinchoKujokyo().getTxtNinteiChosaIraiKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiChosaJisshiKanryoDay() {
        return this.getTplShinchoKujokyo().getTxtNinteiChosaJisshiKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtShujiIkenshoSakuseiIraiKanryoDay() {
        return this.getTplShinchoKujokyo().getTxtShujiIkenshoSakuseiIraiKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtShujiiIkenshoTorokuKanryoDay() {
        return this.getTplShinchoKujokyo().getTxtShujiiIkenshoTorokuKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtIchijiHanteiKanryoDay() {
        return this.getTplShinchoKujokyo().getTxtIchijiHanteiKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtMaskingKanryo() {
        return this.getTplShinchoKujokyo().getTxtMaskingKanryo();
    }

    @JsonIgnore
    public TextBoxDate getTxtKaigoNinteiShinsakaiWaritsukeKanryoDay() {
        return this.getTplShinchoKujokyo().getTxtKaigoNinteiShinsakaiWaritsukeKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtKaigoNinteiShinsakaiJissiKanryoDay() {
        return this.getTplShinchoKujokyo().getTxtKaigoNinteiShinsakaiJissiKanryoDay();
    }

}
