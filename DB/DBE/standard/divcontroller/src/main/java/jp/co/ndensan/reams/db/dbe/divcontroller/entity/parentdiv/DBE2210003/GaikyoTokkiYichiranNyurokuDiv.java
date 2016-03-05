package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.IChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseishaInfo.KaigoNinteiShinseishaInfo.IKaigoNinteiShinseishaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiKihon.NinteiShinseiRenrakusakiKihon.INinteiShinseiRenrakusakiKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.StaticImage;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * GaikyoTokkiYichiranNyuroku のクラスファイル
 *
 * @author 自動生成
 */
public class GaikyoTokkiYichiranNyurokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChosaTaisho")
    private ChosaTaishoDiv ChosaTaisho;
    @JsonProperty("TokkiNyuryoku")
    private TokkiNyuryokuDiv TokkiNyuryoku;

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
     * getTokkiNyuryoku
     * @return TokkiNyuryoku
     */
    @JsonProperty("TokkiNyuryoku")
    public TokkiNyuryokuDiv getTokkiNyuryoku() {
        return TokkiNyuryoku;
    }

    /*
     * setTokkiNyuryoku
     * @param TokkiNyuryoku TokkiNyuryoku
     */
    @JsonProperty("TokkiNyuryoku")
    public void setTokkiNyuryoku(TokkiNyuryokuDiv TokkiNyuryoku) {
        this.TokkiNyuryoku = TokkiNyuryoku;
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
    public IChosaJisshishaJohoDiv getCcdChosaJisshishaJoho() {
        return this.getChosaTaisho().getCcdChosaJisshishaJoho();
    }

    @JsonIgnore
    public IKaigoNinteiShinseishaInfoDiv getCcdKaigoNinteiShiseishaInfo() {
        return this.getChosaTaisho().getCcdKaigoNinteiShiseishaInfo();
    }

    @JsonIgnore
    public tblFirstTokkiJikoDiv getTblFirstTokkiJiko() {
        return this.getTokkiNyuryoku().getTblFirstTokkiJiko();
    }

    @JsonIgnore
    public void setTblFirstTokkiJiko(tblFirstTokkiJikoDiv tblFirstTokkiJiko) {
        this.getTokkiNyuryoku().setTblFirstTokkiJiko(tblFirstTokkiJiko);
    }

    @JsonIgnore
    public TextBox getTxtFirstChosaKomokuNo() {
        return this.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuNo();
    }

    @JsonIgnore
    public Label getLblFirstHyphen() {
        return this.getTokkiNyuryoku().getTblFirstTokkiJiko().getLblFirstHyphen();
    }

    @JsonIgnore
    public TextBoxNum getTxtFirstTokkiRenban() {
        return this.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiRenban();
    }

    @JsonIgnore
    public TextBox getTxtFirstChosaKomokuMeisho() {
        return this.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstChosaKomokuMeisho();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFirstTokkiJiko() {
        return this.getTokkiNyuryoku().getTblFirstTokkiJiko().getTxtFirstTokkiJiko();
    }

    @JsonIgnore
    public StaticImage getImgFirstTokkiJiko() {
        return this.getTokkiNyuryoku().getTblFirstTokkiJiko().getImgFirstTokkiJiko();
    }

    @JsonIgnore
    public Space getSpSpace1() {
        return this.getTokkiNyuryoku().getSpSpace1();
    }

    @JsonIgnore
    public void setSpSpace1(Space spSpace1) {
        this.getTokkiNyuryoku().setSpSpace1(spSpace1);
    }

    @JsonIgnore
    public ButtonDialog getBtnFirstTokkiJikoTeikeibun() {
        return this.getTokkiNyuryoku().getBtnFirstTokkiJikoTeikeibun();
    }

    @JsonIgnore
    public void setBtnFirstTokkiJikoTeikeibun(ButtonDialog btnFirstTokkiJikoTeikeibun) {
        this.getTokkiNyuryoku().setBtnFirstTokkiJikoTeikeibun(btnFirstTokkiJikoTeikeibun);
    }

    @JsonIgnore
    public Space getSpSpace11() {
        return this.getTokkiNyuryoku().getSpSpace11();
    }

    @JsonIgnore
    public void setSpSpace11(Space spSpace11) {
        this.getTokkiNyuryoku().setSpSpace11(spSpace11);
    }

    @JsonIgnore
    public ButtonDialog getBtnFirstImageMasking() {
        return this.getTokkiNyuryoku().getBtnFirstImageMasking();
    }

    @JsonIgnore
    public void setBtnFirstImageMasking(ButtonDialog btnFirstImageMasking) {
        this.getTokkiNyuryoku().setBtnFirstImageMasking(btnFirstImageMasking);
    }

    @JsonIgnore
    public tblSecondTokkiJikoDiv getTblSecondTokkiJiko() {
        return this.getTokkiNyuryoku().getTblSecondTokkiJiko();
    }

    @JsonIgnore
    public void setTblSecondTokkiJiko(tblSecondTokkiJikoDiv tblSecondTokkiJiko) {
        this.getTokkiNyuryoku().setTblSecondTokkiJiko(tblSecondTokkiJiko);
    }

    @JsonIgnore
    public TextBox getTxtSecondChosaKomokuNo() {
        return this.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondChosaKomokuNo();
    }

    @JsonIgnore
    public Label getLblSecondHyphen() {
        return this.getTokkiNyuryoku().getTblSecondTokkiJiko().getLblSecondHyphen();
    }

    @JsonIgnore
    public TextBoxNum getTxtSecondTokkiRenban() {
        return this.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiRenban();
    }

    @JsonIgnore
    public TextBox getTxtSecondTokkiJikoMeisho() {
        return this.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJikoMeisho();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtSecondTokkiJiko() {
        return this.getTokkiNyuryoku().getTblSecondTokkiJiko().getTxtSecondTokkiJiko();
    }

    @JsonIgnore
    public StaticImage getImgSecondTokkiJiko() {
        return this.getTokkiNyuryoku().getTblSecondTokkiJiko().getImgSecondTokkiJiko();
    }

    @JsonIgnore
    public Space getSpSpace2() {
        return this.getTokkiNyuryoku().getSpSpace2();
    }

    @JsonIgnore
    public void setSpSpace2(Space spSpace2) {
        this.getTokkiNyuryoku().setSpSpace2(spSpace2);
    }

    @JsonIgnore
    public ButtonDialog getBtnSecondTokkiJikoTeikeibun() {
        return this.getTokkiNyuryoku().getBtnSecondTokkiJikoTeikeibun();
    }

    @JsonIgnore
    public void setBtnSecondTokkiJikoTeikeibun(ButtonDialog btnSecondTokkiJikoTeikeibun) {
        this.getTokkiNyuryoku().setBtnSecondTokkiJikoTeikeibun(btnSecondTokkiJikoTeikeibun);
    }

    @JsonIgnore
    public Space getSpSpace21() {
        return this.getTokkiNyuryoku().getSpSpace21();
    }

    @JsonIgnore
    public void setSpSpace21(Space spSpace21) {
        this.getTokkiNyuryoku().setSpSpace21(spSpace21);
    }

    @JsonIgnore
    public ButtonDialog getBtnSecondImageMasking() {
        return this.getTokkiNyuryoku().getBtnSecondImageMasking();
    }

    @JsonIgnore
    public void setBtnSecondImageMasking(ButtonDialog btnSecondImageMasking) {
        this.getTokkiNyuryoku().setBtnSecondImageMasking(btnSecondImageMasking);
    }

    @JsonIgnore
    public tblThirdTokkiJikoDiv getTblThirdTokkiJiko() {
        return this.getTokkiNyuryoku().getTblThirdTokkiJiko();
    }

    @JsonIgnore
    public void setTblThirdTokkiJiko(tblThirdTokkiJikoDiv tblThirdTokkiJiko) {
        this.getTokkiNyuryoku().setTblThirdTokkiJiko(tblThirdTokkiJiko);
    }

    @JsonIgnore
    public TextBox getTxtThirdChosaKomokuNo() {
        return this.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdChosaKomokuNo();
    }

    @JsonIgnore
    public Label getLblThirdHyphen() {
        return this.getTokkiNyuryoku().getTblThirdTokkiJiko().getLblThirdHyphen();
    }

    @JsonIgnore
    public TextBoxNum getTxtThirdTokkiRenban() {
        return this.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiRenban();
    }

    @JsonIgnore
    public TextBox getTxtThirdTokkiJikoMeisho() {
        return this.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJikoMeisho();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtThirdTokkiJiko() {
        return this.getTokkiNyuryoku().getTblThirdTokkiJiko().getTxtThirdTokkiJiko();
    }

    @JsonIgnore
    public StaticImage getImgThirdTokkiJiko() {
        return this.getTokkiNyuryoku().getTblThirdTokkiJiko().getImgThirdTokkiJiko();
    }

    @JsonIgnore
    public Space getSpSpace3() {
        return this.getTokkiNyuryoku().getSpSpace3();
    }

    @JsonIgnore
    public void setSpSpace3(Space spSpace3) {
        this.getTokkiNyuryoku().setSpSpace3(spSpace3);
    }

    @JsonIgnore
    public ButtonDialog getBtnThirdTokkiJikoTeikeibun() {
        return this.getTokkiNyuryoku().getBtnThirdTokkiJikoTeikeibun();
    }

    @JsonIgnore
    public void setBtnThirdTokkiJikoTeikeibun(ButtonDialog btnThirdTokkiJikoTeikeibun) {
        this.getTokkiNyuryoku().setBtnThirdTokkiJikoTeikeibun(btnThirdTokkiJikoTeikeibun);
    }

    @JsonIgnore
    public Space getSpSpace31() {
        return this.getTokkiNyuryoku().getSpSpace31();
    }

    @JsonIgnore
    public void setSpSpace31(Space spSpace31) {
        this.getTokkiNyuryoku().setSpSpace31(spSpace31);
    }

    @JsonIgnore
    public ButtonDialog getBtnThirdImageMasking() {
        return this.getTokkiNyuryoku().getBtnThirdImageMasking();
    }

    @JsonIgnore
    public void setBtnThirdImageMasking(ButtonDialog btnThirdImageMasking) {
        this.getTokkiNyuryoku().setBtnThirdImageMasking(btnThirdImageMasking);
    }

    @JsonIgnore
    public tblFourthTokkiJikoDiv getTblFourthTokkiJiko() {
        return this.getTokkiNyuryoku().getTblFourthTokkiJiko();
    }

    @JsonIgnore
    public void setTblFourthTokkiJiko(tblFourthTokkiJikoDiv tblFourthTokkiJiko) {
        this.getTokkiNyuryoku().setTblFourthTokkiJiko(tblFourthTokkiJiko);
    }

    @JsonIgnore
    public TextBox getTxtFourthChosaKomokuNo() {
        return this.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthChosaKomokuNo();
    }

    @JsonIgnore
    public Label getLblFourthHyphen() {
        return this.getTokkiNyuryoku().getTblFourthTokkiJiko().getLblFourthHyphen();
    }

    @JsonIgnore
    public TextBoxNum getTxtFourthTokkiRenban() {
        return this.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiRenban();
    }

    @JsonIgnore
    public TextBox getTxtFourthTokkiJikoMeisho() {
        return this.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJikoMeisho();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFourthTokkiJiko() {
        return this.getTokkiNyuryoku().getTblFourthTokkiJiko().getTxtFourthTokkiJiko();
    }

    @JsonIgnore
    public StaticImage getImgFourthTokkiJiko() {
        return this.getTokkiNyuryoku().getTblFourthTokkiJiko().getImgFourthTokkiJiko();
    }

    @JsonIgnore
    public Space getSpSpace4() {
        return this.getTokkiNyuryoku().getSpSpace4();
    }

    @JsonIgnore
    public void setSpSpace4(Space spSpace4) {
        this.getTokkiNyuryoku().setSpSpace4(spSpace4);
    }

    @JsonIgnore
    public ButtonDialog getBtnFourthTokkiJikoTeikeibun() {
        return this.getTokkiNyuryoku().getBtnFourthTokkiJikoTeikeibun();
    }

    @JsonIgnore
    public void setBtnFourthTokkiJikoTeikeibun(ButtonDialog btnFourthTokkiJikoTeikeibun) {
        this.getTokkiNyuryoku().setBtnFourthTokkiJikoTeikeibun(btnFourthTokkiJikoTeikeibun);
    }

    @JsonIgnore
    public Space getSpSpace41() {
        return this.getTokkiNyuryoku().getSpSpace41();
    }

    @JsonIgnore
    public void setSpSpace41(Space spSpace41) {
        this.getTokkiNyuryoku().setSpSpace41(spSpace41);
    }

    @JsonIgnore
    public ButtonDialog getBtnFourthImageMasking() {
        return this.getTokkiNyuryoku().getBtnFourthImageMasking();
    }

    @JsonIgnore
    public void setBtnFourthImageMasking(ButtonDialog btnFourthImageMasking) {
        this.getTokkiNyuryoku().setBtnFourthImageMasking(btnFourthImageMasking);
    }

    @JsonIgnore
    public tblFifthTokkiJikoDiv getTblFifthTokkiJiko() {
        return this.getTokkiNyuryoku().getTblFifthTokkiJiko();
    }

    @JsonIgnore
    public void setTblFifthTokkiJiko(tblFifthTokkiJikoDiv tblFifthTokkiJiko) {
        this.getTokkiNyuryoku().setTblFifthTokkiJiko(tblFifthTokkiJiko);
    }

    @JsonIgnore
    public TextBox getTxtFifthChosaKomokuNo() {
        return this.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthChosaKomokuNo();
    }

    @JsonIgnore
    public Label getLblFifthHyphen() {
        return this.getTokkiNyuryoku().getTblFifthTokkiJiko().getLblFifthHyphen();
    }

    @JsonIgnore
    public TextBoxNum getTxtFifthTokkiRenban() {
        return this.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiRenban();
    }

    @JsonIgnore
    public TextBox getTxtFifthTokkiJikoMeisho() {
        return this.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJikoMeisho();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFifthTokkiJiko() {
        return this.getTokkiNyuryoku().getTblFifthTokkiJiko().getTxtFifthTokkiJiko();
    }

    @JsonIgnore
    public StaticImage getImgFifthTokkiJiko() {
        return this.getTokkiNyuryoku().getTblFifthTokkiJiko().getImgFifthTokkiJiko();
    }

    @JsonIgnore
    public Space getSpSpace5() {
        return this.getTokkiNyuryoku().getSpSpace5();
    }

    @JsonIgnore
    public void setSpSpace5(Space spSpace5) {
        this.getTokkiNyuryoku().setSpSpace5(spSpace5);
    }

    @JsonIgnore
    public ButtonDialog getBtnFifthTokkiJikoTeikeibun() {
        return this.getTokkiNyuryoku().getBtnFifthTokkiJikoTeikeibun();
    }

    @JsonIgnore
    public void setBtnFifthTokkiJikoTeikeibun(ButtonDialog btnFifthTokkiJikoTeikeibun) {
        this.getTokkiNyuryoku().setBtnFifthTokkiJikoTeikeibun(btnFifthTokkiJikoTeikeibun);
    }

    @JsonIgnore
    public Space getSpSpace51() {
        return this.getTokkiNyuryoku().getSpSpace51();
    }

    @JsonIgnore
    public void setSpSpace51(Space spSpace51) {
        this.getTokkiNyuryoku().setSpSpace51(spSpace51);
    }

    @JsonIgnore
    public ButtonDialog getBtnFifthImageMasking() {
        return this.getTokkiNyuryoku().getBtnFifthImageMasking();
    }

    @JsonIgnore
    public void setBtnFifthImageMasking(ButtonDialog btnFifthImageMasking) {
        this.getTokkiNyuryoku().setBtnFifthImageMasking(btnFifthImageMasking);
    }

    @JsonIgnore
    public Button getBtnBeforeTokkiJiko() {
        return this.getTokkiNyuryoku().getBtnBeforeTokkiJiko();
    }

    @JsonIgnore
    public void setBtnBeforeTokkiJiko(Button btnBeforeTokkiJiko) {
        this.getTokkiNyuryoku().setBtnBeforeTokkiJiko(btnBeforeTokkiJiko);
    }

    @JsonIgnore
    public Label getLblTokkiJikoPage() {
        return this.getTokkiNyuryoku().getLblTokkiJikoPage();
    }

    @JsonIgnore
    public void setLblTokkiJikoPage(Label lblTokkiJikoPage) {
        this.getTokkiNyuryoku().setLblTokkiJikoPage(lblTokkiJikoPage);
    }

    @JsonIgnore
    public Button getBtnAfterTokkiJiko() {
        return this.getTokkiNyuryoku().getBtnAfterTokkiJiko();
    }

    @JsonIgnore
    public void setBtnAfterTokkiJiko(Button btnAfterTokkiJiko) {
        this.getTokkiNyuryoku().setBtnAfterTokkiJiko(btnAfterTokkiJiko);
    }

    // </editor-fold>
}
