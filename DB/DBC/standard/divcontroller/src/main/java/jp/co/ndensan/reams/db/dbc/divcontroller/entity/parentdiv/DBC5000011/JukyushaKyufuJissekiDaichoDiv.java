package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5000011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaKyufuJissekiDaicho のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaKyufuJissekiDaichoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabChushutsuJoken")
    private tabChushutsuJokenDiv tabChushutsuJoken;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabChushutsuJoken
     * @return tabChushutsuJoken
     */
    @JsonProperty("tabChushutsuJoken")
    public tabChushutsuJokenDiv getTabChushutsuJoken() {
        return tabChushutsuJoken;
    }

    /*
     * settabChushutsuJoken
     * @param tabChushutsuJoken tabChushutsuJoken
     */
    @JsonProperty("tabChushutsuJoken")
    public void setTabChushutsuJoken(tabChushutsuJokenDiv tabChushutsuJoken) {
        this.tabChushutsuJoken = tabChushutsuJoken;
    }

    /*
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tplChushutsuJoken1Div getTplChushutsuJoken1() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken1();
    }

    @JsonIgnore
    public void  setTplChushutsuJoken1(tplChushutsuJoken1Div tplChushutsuJoken1) {
        this.getTabChushutsuJoken().setTplChushutsuJoken1(tplChushutsuJoken1);
    }

    @JsonIgnore
    public RadioButton getRadKonkaiTaishoYM() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken1().getRadKonkaiTaishoYM();
    }

    @JsonIgnore
    public void  setRadKonkaiTaishoYM(RadioButton radKonkaiTaishoYM) {
        this.getTabChushutsuJoken().getTplChushutsuJoken1().setRadKonkaiTaishoYM(radKonkaiTaishoYM);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtRangeYM() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken1().getTxtRangeYM();
    }

    @JsonIgnore
    public void  setTxtRangeYM(TextBoxDateRange txtRangeYM) {
        this.getTabChushutsuJoken().getTplChushutsuJoken1().setTxtRangeYM(txtRangeYM);
    }

    @JsonIgnore
    public TextBoxCode getTxtRangeHihokenshaNoFrom() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken1().getTxtRangeHihokenshaNoFrom();
    }

    @JsonIgnore
    public void  setTxtRangeHihokenshaNoFrom(TextBoxCode txtRangeHihokenshaNoFrom) {
        this.getTabChushutsuJoken().getTplChushutsuJoken1().setTxtRangeHihokenshaNoFrom(txtRangeHihokenshaNoFrom);
    }

    @JsonIgnore
    public TextBoxCode getTxtRangeHihokenshaNoTo() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken1().getTxtRangeHihokenshaNoTo();
    }

    @JsonIgnore
    public void  setTxtRangeHihokenshaNoTo(TextBoxCode txtRangeHihokenshaNoTo) {
        this.getTabChushutsuJoken().getTplChushutsuJoken1().setTxtRangeHihokenshaNoTo(txtRangeHihokenshaNoTo);
    }

    @JsonIgnore
    public Button getBtnHihokenshaNoFromSearch() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken1().getBtnHihokenshaNoFromSearch();
    }

    @JsonIgnore
    public void  setBtnHihokenshaNoFromSearch(Button btnHihokenshaNoFromSearch) {
        this.getTabChushutsuJoken().getTplChushutsuJoken1().setBtnHihokenshaNoFromSearch(btnHihokenshaNoFromSearch);
    }

    @JsonIgnore
    public Button getBtnHihokenshaNoToSearch() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken1().getBtnHihokenshaNoToSearch();
    }

    @JsonIgnore
    public void  setBtnHihokenshaNoToSearch(Button btnHihokenshaNoToSearch) {
        this.getTabChushutsuJoken().getTplChushutsuJoken1().setBtnHihokenshaNoToSearch(btnHihokenshaNoToSearch);
    }

    @JsonIgnore
    public RadioButton getRadKyufuJissekiKubun() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken1().getRadKyufuJissekiKubun();
    }

    @JsonIgnore
    public void  setRadKyufuJissekiKubun(RadioButton radKyufuJissekiKubun) {
        this.getTabChushutsuJoken().getTplChushutsuJoken1().setRadKyufuJissekiKubun(radKyufuJissekiKubun);
    }

    @JsonIgnore
    public CheckBoxList getChkYokaigodo() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken1().getChkYokaigodo();
    }

    @JsonIgnore
    public void  setChkYokaigodo(CheckBoxList chkYokaigodo) {
        this.getTabChushutsuJoken().getTplChushutsuJoken1().setChkYokaigodo(chkYokaigodo);
    }

    @JsonIgnore
    public HorizontalLine getLinYokaigoShutrsuryokuYoshiki() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken1().getLinYokaigoShutrsuryokuYoshiki();
    }

    @JsonIgnore
    public void  setLinYokaigoShutrsuryokuYoshiki(HorizontalLine linYokaigoShutrsuryokuYoshiki) {
        this.getTabChushutsuJoken().getTplChushutsuJoken1().setLinYokaigoShutrsuryokuYoshiki(linYokaigoShutrsuryokuYoshiki);
    }

    @JsonIgnore
    public tblchkShutsuryokuYoshikiDiv getTblchkShutsuryokuYoshiki() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken1().getTblchkShutsuryokuYoshiki();
    }

    @JsonIgnore
    public void  setTblchkShutsuryokuYoshiki(tblchkShutsuryokuYoshikiDiv tblchkShutsuryokuYoshiki) {
        this.getTabChushutsuJoken().getTplChushutsuJoken1().setTblchkShutsuryokuYoshiki(tblchkShutsuryokuYoshiki);
    }

    @JsonIgnore
    public Label getLblShutsuryokuYoshiki() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken1().getTblchkShutsuryokuYoshiki().getLblShutsuryokuYoshiki();
    }

    @JsonIgnore
    public Button getBtnShutsuryokuYoshikiAllCheck() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken1().getTblchkShutsuryokuYoshiki().getBtnShutsuryokuYoshikiAllCheck();
    }

    @JsonIgnore
    public CheckBoxList getChkShutsuryokuYoshiki1() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken1().getTblchkShutsuryokuYoshiki().getChkShutsuryokuYoshiki1();
    }

    @JsonIgnore
    public CheckBoxList getChkShutsuryokuYoshiki2() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken1().getTblchkShutsuryokuYoshiki().getChkShutsuryokuYoshiki2();
    }

    @JsonIgnore
    public Space getYoboSpace1() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken1().getTblchkShutsuryokuYoshiki().getYoboSpace1();
    }

    @JsonIgnore
    public CheckBoxList getChkShutsuryokuYoshiki3() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken1().getTblchkShutsuryokuYoshiki().getChkShutsuryokuYoshiki3();
    }

    @JsonIgnore
    public Space getYoboSpace2() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken1().getTblchkShutsuryokuYoshiki().getYoboSpace2();
    }

    @JsonIgnore
    public Space getYoboSpace3() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken1().getTblchkShutsuryokuYoshiki().getYoboSpace3();
    }

    @JsonIgnore
    public Space getYoboSpace4() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken1().getTblchkShutsuryokuYoshiki().getYoboSpace4();
    }

    @JsonIgnore
    public CheckBoxList getChkShutsuryokuYoshiki4() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken1().getTblchkShutsuryokuYoshiki().getChkShutsuryokuYoshiki4();
    }

    @JsonIgnore
    public CheckBoxList getChkShutsuryokuYoshiki5() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken1().getTblchkShutsuryokuYoshiki().getChkShutsuryokuYoshiki5();
    }

    @JsonIgnore
    public tplChushutsuJoken2Div getTplChushutsuJoken2() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2();
    }

    @JsonIgnore
    public void  setTplChushutsuJoken2(tplChushutsuJoken2Div tplChushutsuJoken2) {
        this.getTabChushutsuJoken().setTplChushutsuJoken2(tplChushutsuJoken2);
    }

    @JsonIgnore
    public RadioButton getRadKyuSochiTokureiUmu() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getRadKyuSochiTokureiUmu();
    }

    @JsonIgnore
    public void  setRadKyuSochiTokureiUmu(RadioButton radKyuSochiTokureiUmu) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setRadKyuSochiTokureiUmu(radKyuSochiTokureiUmu);
    }

    @JsonIgnore
    public HorizontalLine getLinKyuSochiTokureiUmuRojinhokenShikuchosonNoUmu() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getLinKyuSochiTokureiUmuRojinhokenShikuchosonNoUmu();
    }

    @JsonIgnore
    public void  setLinKyuSochiTokureiUmuRojinhokenShikuchosonNoUmu(HorizontalLine linKyuSochiTokureiUmuRojinhokenShikuchosonNoUmu) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setLinKyuSochiTokureiUmuRojinhokenShikuchosonNoUmu(linKyuSochiTokureiUmuRojinhokenShikuchosonNoUmu);
    }

    @JsonIgnore
    public RadioButton getRadRojinHokenShikuchosonNoUmu() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getRadRojinHokenShikuchosonNoUmu();
    }

    @JsonIgnore
    public void  setRadRojinHokenShikuchosonNoUmu(RadioButton radRojinHokenShikuchosonNoUmu) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setRadRojinHokenShikuchosonNoUmu(radRojinHokenShikuchosonNoUmu);
    }

    @JsonIgnore
    public TextBoxCode getTxtRojinhokenShikuchosonNoRangeFrom() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getTxtRojinhokenShikuchosonNoRangeFrom();
    }

    @JsonIgnore
    public void  setTxtRojinhokenShikuchosonNoRangeFrom(TextBoxCode txtRojinhokenShikuchosonNoRangeFrom) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setTxtRojinhokenShikuchosonNoRangeFrom(txtRojinhokenShikuchosonNoRangeFrom);
    }

    @JsonIgnore
    public TextBoxCode getTxtRojinhokenShikuchosonNoRangeTo() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getTxtRojinhokenShikuchosonNoRangeTo();
    }

    @JsonIgnore
    public void  setTxtRojinhokenShikuchosonNoRangeTo(TextBoxCode txtRojinhokenShikuchosonNoRangeTo) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setTxtRojinhokenShikuchosonNoRangeTo(txtRojinhokenShikuchosonNoRangeTo);
    }

    @JsonIgnore
    public HorizontalLine getLinRojinHokenShikuchosonNoUmuRojinHokenJukyushaNoUmu() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getLinRojinHokenShikuchosonNoUmuRojinHokenJukyushaNoUmu();
    }

    @JsonIgnore
    public void  setLinRojinHokenShikuchosonNoUmuRojinHokenJukyushaNoUmu(HorizontalLine linRojinHokenShikuchosonNoUmuRojinHokenJukyushaNoUmu) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setLinRojinHokenShikuchosonNoUmuRojinHokenJukyushaNoUmu(linRojinHokenShikuchosonNoUmuRojinHokenJukyushaNoUmu);
    }

    @JsonIgnore
    public RadioButton getRadRojinHokenJukyushaNoUmu() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getRadRojinHokenJukyushaNoUmu();
    }

    @JsonIgnore
    public void  setRadRojinHokenJukyushaNoUmu(RadioButton radRojinHokenJukyushaNoUmu) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setRadRojinHokenJukyushaNoUmu(radRojinHokenJukyushaNoUmu);
    }

    @JsonIgnore
    public TextBoxCode getTxtRojinHokenJukyushaNoFrom() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getTxtRojinHokenJukyushaNoFrom();
    }

    @JsonIgnore
    public void  setTxtRojinHokenJukyushaNoFrom(TextBoxCode txtRojinHokenJukyushaNoFrom) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setTxtRojinHokenJukyushaNoFrom(txtRojinHokenJukyushaNoFrom);
    }

    @JsonIgnore
    public TextBoxCode getTxtRojinHokenJukyushaNoTo() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getTxtRojinHokenJukyushaNoTo();
    }

    @JsonIgnore
    public void  setTxtRojinHokenJukyushaNoTo(TextBoxCode txtRojinHokenJukyushaNoTo) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setTxtRojinHokenJukyushaNoTo(txtRojinHokenJukyushaNoTo);
    }

    @JsonIgnore
    public HorizontalLine getLinRojinhokenJukyushaNoUmu() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getLinRojinhokenJukyushaNoUmu();
    }

    @JsonIgnore
    public void  setLinRojinhokenJukyushaNoUmu(HorizontalLine linRojinhokenJukyushaNoUmu) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setLinRojinhokenJukyushaNoUmu(linRojinhokenJukyushaNoUmu);
    }

    @JsonIgnore
    public TextBoxCode getTxtKohiFutanshaNo() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getTxtKohiFutanshaNo();
    }

    @JsonIgnore
    public void  setTxtKohiFutanshaNo(TextBoxCode txtKohiFutanshaNo) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setTxtKohiFutanshaNo(txtKohiFutanshaNo);
    }

    @JsonIgnore
    public HorizontalLine getLinKohiFutanshaNo() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getLinKohiFutanshaNo();
    }

    @JsonIgnore
    public void  setLinKohiFutanshaNo(HorizontalLine linKohiFutanshaNo) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setLinKohiFutanshaNo(linKohiFutanshaNo);
    }

    @JsonIgnore
    public TextBoxCode getTxtKohiJukyushaNo() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getTxtKohiJukyushaNo();
    }

    @JsonIgnore
    public void  setTxtKohiJukyushaNo(TextBoxCode txtKohiJukyushaNo) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setTxtKohiJukyushaNo(txtKohiJukyushaNo);
    }

    @JsonIgnore
    public HorizontalLine getLinKohiJukyushaNoJigyoshaNo() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getLinKohiJukyushaNoJigyoshaNo();
    }

    @JsonIgnore
    public void  setLinKohiJukyushaNoJigyoshaNo(HorizontalLine linKohiJukyushaNoJigyoshaNo) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setLinKohiJukyushaNoJigyoshaNo(linKohiJukyushaNoJigyoshaNo);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaNoFrom() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getTxtJigyoshaNoFrom();
    }

    @JsonIgnore
    public void  setTxtJigyoshaNoFrom(TextBox txtJigyoshaNoFrom) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setTxtJigyoshaNoFrom(txtJigyoshaNoFrom);
    }

    @JsonIgnore
    public ButtonDialog getBtnJigyoshaNoFrom() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getBtnJigyoshaNoFrom();
    }

    @JsonIgnore
    public void  setBtnJigyoshaNoFrom(ButtonDialog btnJigyoshaNoFrom) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setBtnJigyoshaNoFrom(btnJigyoshaNoFrom);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaNoTo() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getTxtJigyoshaNoTo();
    }

    @JsonIgnore
    public void  setTxtJigyoshaNoTo(TextBox txtJigyoshaNoTo) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setTxtJigyoshaNoTo(txtJigyoshaNoTo);
    }

    @JsonIgnore
    public ButtonDialog getBtnJigyoshaNoTo() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getBtnJigyoshaNoTo();
    }

    @JsonIgnore
    public void  setBtnJigyoshaNoTo(ButtonDialog btnJigyoshaNoTo) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setBtnJigyoshaNoTo(btnJigyoshaNoTo);
    }

    @JsonIgnore
    public HorizontalLine getLinJigyoshaNoKeikakuSakuseiJigyoshaNo() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getLinJigyoshaNoKeikakuSakuseiJigyoshaNo();
    }

    @JsonIgnore
    public void  setLinJigyoshaNoKeikakuSakuseiJigyoshaNo(HorizontalLine linJigyoshaNoKeikakuSakuseiJigyoshaNo) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setLinJigyoshaNoKeikakuSakuseiJigyoshaNo(linJigyoshaNoKeikakuSakuseiJigyoshaNo);
    }

    @JsonIgnore
    public TextBoxCode getTxtKeikakuSakuseiJigyoshoNo() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getTxtKeikakuSakuseiJigyoshoNo();
    }

    @JsonIgnore
    public void  setTxtKeikakuSakuseiJigyoshoNo(TextBoxCode txtKeikakuSakuseiJigyoshoNo) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setTxtKeikakuSakuseiJigyoshoNo(txtKeikakuSakuseiJigyoshoNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnKeikakuSakuseiJigyoshoNo() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getBtnKeikakuSakuseiJigyoshoNo();
    }

    @JsonIgnore
    public void  setBtnKeikakuSakuseiJigyoshoNo(ButtonDialog btnKeikakuSakuseiJigyoshoNo) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setBtnKeikakuSakuseiJigyoshoNo(btnKeikakuSakuseiJigyoshoNo);
    }

    @JsonIgnore
    public HorizontalLine getLinKeikakuSakuseiJigyoshoNoKyufuritsu() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getLinKeikakuSakuseiJigyoshoNoKyufuritsu();
    }

    @JsonIgnore
    public void  setLinKeikakuSakuseiJigyoshoNoKyufuritsu(HorizontalLine linKeikakuSakuseiJigyoshoNoKyufuritsu) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setLinKeikakuSakuseiJigyoshoNoKyufuritsu(linKeikakuSakuseiJigyoshoNoKyufuritsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyufuritsu() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getTxtKyufuritsu();
    }

    @JsonIgnore
    public void  setTxtKyufuritsu(TextBoxNum txtKyufuritsu) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setTxtKyufuritsu(txtKyufuritsu);
    }

    @JsonIgnore
    public RadioButton getRadKyufuritsu() {
        return this.getTabChushutsuJoken().getTplChushutsuJoken2().getRadKyufuritsu();
    }

    @JsonIgnore
    public void  setRadKyufuritsu(RadioButton radKyufuritsu) {
        this.getTabChushutsuJoken().getTplChushutsuJoken2().setRadKyufuritsu(radKyufuritsu);
    }

    // </editor-fold>
}
