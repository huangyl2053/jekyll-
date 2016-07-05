package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * ShotokuDankai のクラスファイル
 *
 * @reamsid_L DBB-1770-010 wangkanglei
 */
public class ShotokuDankaiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShotokuDankaiTo2014")
    private ShotokuDankaiTo2014Div ShotokuDankaiTo2014;
    @JsonProperty("HokenryoDankaiFrom2015")
    private HokenryoDankaiFrom2015Div HokenryoDankaiFrom2015;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShotokuDankaiTo2014
     * @return ShotokuDankaiTo2014
     */
    @JsonProperty("ShotokuDankaiTo2014")
    public ShotokuDankaiTo2014Div getShotokuDankaiTo2014() {
        return ShotokuDankaiTo2014;
    }

    /*
     * setShotokuDankaiTo2014
     * @param ShotokuDankaiTo2014 ShotokuDankaiTo2014
     */
    @JsonProperty("ShotokuDankaiTo2014")
    public void setShotokuDankaiTo2014(ShotokuDankaiTo2014Div ShotokuDankaiTo2014) {
        this.ShotokuDankaiTo2014 = ShotokuDankaiTo2014;
    }

    /*
     * getHokenryoDankaiFrom2015
     * @return HokenryoDankaiFrom2015
     */
    @JsonProperty("HokenryoDankaiFrom2015")
    public HokenryoDankaiFrom2015Div getHokenryoDankaiFrom2015() {
        return HokenryoDankaiFrom2015;
    }

    /*
     * setHokenryoDankaiFrom2015
     * @param HokenryoDankaiFrom2015 HokenryoDankaiFrom2015
     */
    @JsonProperty("HokenryoDankaiFrom2015")
    public void setHokenryoDankaiFrom2015(HokenryoDankaiFrom2015Div HokenryoDankaiFrom2015) {
        this.HokenryoDankaiFrom2015 = HokenryoDankaiFrom2015;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HokenryoRitsuShotokuDankai12Div getHokenryoRitsuShotokuDankai12() {
        return this.getShotokuDankaiTo2014().getHokenryoRitsuShotokuDankai12();
    }

    @JsonIgnore
    public void setHokenryoRitsuShotokuDankai12(HokenryoRitsuShotokuDankai12Div HokenryoRitsuShotokuDankai12) {
        this.getShotokuDankaiTo2014().setHokenryoRitsuShotokuDankai12(HokenryoRitsuShotokuDankai12);
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenryoRitsuDai1Dankai() {
        return this.getShotokuDankaiTo2014().getHokenryoRitsuShotokuDankai12().getTxtHokenryoRitsuDai1Dankai();
    }

    @JsonIgnore
    public void setTxtHokenryoRitsuDai1Dankai(TextBoxNum txtHokenryoRitsuDai1Dankai) {
        this.getShotokuDankaiTo2014().getHokenryoRitsuShotokuDankai12().setTxtHokenryoRitsuDai1Dankai(txtHokenryoRitsuDai1Dankai);
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenryoRitsuDai2Dankai() {
        return this.getShotokuDankaiTo2014().getHokenryoRitsuShotokuDankai12().getTxtHokenryoRitsuDai2Dankai();
    }

    @JsonIgnore
    public void setTxtHokenryoRitsuDai2Dankai(TextBoxNum txtHokenryoRitsuDai2Dankai) {
        this.getShotokuDankaiTo2014().getHokenryoRitsuShotokuDankai12().setTxtHokenryoRitsuDai2Dankai(txtHokenryoRitsuDai2Dankai);
    }

    @JsonIgnore
    public KijunShotokuKingakuDankai2Div getKijunShotokuKingakuDankai2() {
        return this.getShotokuDankaiTo2014().getKijunShotokuKingakuDankai2();
    }

    @JsonIgnore
    public void setKijunShotokuKingakuDankai2(KijunShotokuKingakuDankai2Div KijunShotokuKingakuDankai2) {
        this.getShotokuDankaiTo2014().setKijunShotokuKingakuDankai2(KijunShotokuKingakuDankai2);
    }

    @JsonIgnore
    public Label getLblKijunShotokuKingaku() {
        return this.getShotokuDankaiTo2014().getKijunShotokuKingakuDankai2().getLblKijunShotokuKingaku();
    }

    @JsonIgnore
    public void setLblKijunShotokuKingaku(Label lblKijunShotokuKingaku) {
        this.getShotokuDankaiTo2014().getKijunShotokuKingakuDankai2().setLblKijunShotokuKingaku(lblKijunShotokuKingaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtKijunShotokuKingakuDankai2() {
        return this.getShotokuDankaiTo2014().getKijunShotokuKingakuDankai2().getTxtKijunShotokuKingakuDankai2();
    }

    @JsonIgnore
    public void setTxtKijunShotokuKingakuDankai2(TextBoxNum txtKijunShotokuKingakuDankai2) {
        this.getShotokuDankaiTo2014().getKijunShotokuKingakuDankai2().setTxtKijunShotokuKingakuDankai2(txtKijunShotokuKingakuDankai2);
    }

    @JsonIgnore
    public HokenryoRitsuDai3DankaiDiv getHokenryoRitsuDai3Dankai() {
        return this.getShotokuDankaiTo2014().getHokenryoRitsuDai3Dankai();
    }

    @JsonIgnore
    public void setHokenryoRitsuDai3Dankai(HokenryoRitsuDai3DankaiDiv HokenryoRitsuDai3Dankai) {
        this.getShotokuDankaiTo2014().setHokenryoRitsuDai3Dankai(HokenryoRitsuDai3Dankai);
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenryoRitsuDai3Dankai() {
        return this.getShotokuDankaiTo2014().getHokenryoRitsuDai3Dankai().getTxtHokenryoRitsuDai3Dankai();
    }

    @JsonIgnore
    public void setTxtHokenryoRitsuDai3Dankai(TextBoxNum txtHokenryoRitsuDai3Dankai) {
        this.getShotokuDankaiTo2014().getHokenryoRitsuDai3Dankai().setTxtHokenryoRitsuDai3Dankai(txtHokenryoRitsuDai3Dankai);
    }

    @JsonIgnore
    public HokenryoRitsuDai4DankaiFrom2008To2010Div getHokenryoRitsuDai4DankaiFrom2008To2010() {
        return this.getShotokuDankaiTo2014().getHokenryoRitsuDai4DankaiFrom2008To2010();
    }

    @JsonIgnore
    public void setHokenryoRitsuDai4DankaiFrom2008To2010(HokenryoRitsuDai4DankaiFrom2008To2010Div HokenryoRitsuDai4DankaiFrom2008To2010) {
        this.getShotokuDankaiTo2014().setHokenryoRitsuDai4DankaiFrom2008To2010(HokenryoRitsuDai4DankaiFrom2008To2010);
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenryoRitsuDai4Dankai() {
        return this.getShotokuDankaiTo2014().getHokenryoRitsuDai4DankaiFrom2008To2010().getTxtHokenryoRitsuDai4Dankai();
    }

    @JsonIgnore
    public void setTxtHokenryoRitsuDai4Dankai(TextBoxNum txtHokenryoRitsuDai4Dankai) {
        this.getShotokuDankaiTo2014().getHokenryoRitsuDai4DankaiFrom2008To2010().setTxtHokenryoRitsuDai4Dankai(txtHokenryoRitsuDai4Dankai);
    }

    @JsonIgnore
    public GekihenKanwaDiv getGekihenKanwa() {
        return this.getShotokuDankaiTo2014().getHokenryoRitsuDai4DankaiFrom2008To2010().getGekihenKanwa();
    }

    @JsonIgnore
    public void setGekihenKanwa(GekihenKanwaDiv GekihenKanwa) {
        this.getShotokuDankaiTo2014().getHokenryoRitsuDai4DankaiFrom2008To2010().setGekihenKanwa(GekihenKanwa);
    }

    @JsonIgnore
    public ButtonDialog getBtnGekihenKanwa() {
        return this.getShotokuDankaiTo2014().getHokenryoRitsuDai4DankaiFrom2008To2010().getGekihenKanwa().getBtnGekihenKanwa();
    }

    @JsonIgnore
    public void setBtnGekihenKanwa(ButtonDialog btnGekihenKanwa) {
        this.getShotokuDankaiTo2014().getHokenryoRitsuDai4DankaiFrom2008To2010().getGekihenKanwa().setBtnGekihenKanwa(btnGekihenKanwa);
    }

    @JsonIgnore
    public SetaiHikazeiDankaiDiv getSetaiHikazeiDankai() {
        return this.getShotokuDankaiTo2014().getSetaiHikazeiDankai();
    }

    @JsonIgnore
    public void setSetaiHikazeiDankai(SetaiHikazeiDankaiDiv SetaiHikazeiDankai) {
        this.getShotokuDankaiTo2014().setSetaiHikazeiDankai(SetaiHikazeiDankai);
    }

    @JsonIgnore
    public HorizontalLine getLin3() {
        return this.getShotokuDankaiTo2014().getSetaiHikazeiDankai().getLin3();
    }

    @JsonIgnore
    public void setLin3(HorizontalLine lin3) {
        this.getShotokuDankaiTo2014().getSetaiHikazeiDankai().setLin3(lin3);
    }

    @JsonIgnore
    public Label getLblSetaiHikazeiDankai() {
        return this.getShotokuDankaiTo2014().getSetaiHikazeiDankai().getLblSetaiHikazeiDankai();
    }

    @JsonIgnore
    public void setLblSetaiHikazeiDankai(Label lblSetaiHikazeiDankai) {
        this.getShotokuDankaiTo2014().getSetaiHikazeiDankai().setLblSetaiHikazeiDankai(lblSetaiHikazeiDankai);
    }

    @JsonIgnore
    public RadioButton getRadKeigenSochiDankai2Gai() {
        return this.getShotokuDankaiTo2014().getSetaiHikazeiDankai().getRadKeigenSochiDankai2Gai();
    }

    @JsonIgnore
    public void setRadKeigenSochiDankai2Gai(RadioButton radKeigenSochiDankai2Gai) {
        this.getShotokuDankaiTo2014().getSetaiHikazeiDankai().setRadKeigenSochiDankai2Gai(radKeigenSochiDankai2Gai);
    }

    @JsonIgnore
    public RadioButton getRadDankaiHyokiDankai2Gai() {
        return this.getShotokuDankaiTo2014().getSetaiHikazeiDankai().getRadDankaiHyokiDankai2Gai();
    }

    @JsonIgnore
    public void setRadDankaiHyokiDankai2Gai(RadioButton radDankaiHyokiDankai2Gai) {
        this.getShotokuDankaiTo2014().getSetaiHikazeiDankai().setRadDankaiHyokiDankai2Gai(radDankaiHyokiDankai2Gai);
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenryoRitsuDai3DankaiKeigenTaisho() {
        return this.getShotokuDankaiTo2014().getSetaiHikazeiDankai().getTxtHokenryoRitsuDai3DankaiKeigenTaisho();
    }

    @JsonIgnore
    public void setTxtHokenryoRitsuDai3DankaiKeigenTaisho(TextBoxNum txtHokenryoRitsuDai3DankaiKeigenTaisho) {
        this.getShotokuDankaiTo2014().getSetaiHikazeiDankai().setTxtHokenryoRitsuDai3DankaiKeigenTaisho(txtHokenryoRitsuDai3DankaiKeigenTaisho);
    }

    @JsonIgnore
    public TextBoxNum getTxKijunShotokuKingakuDankai3() {
        return this.getShotokuDankaiTo2014().getSetaiHikazeiDankai().getTxKijunShotokuKingakuDankai3();
    }

    @JsonIgnore
    public void setTxKijunShotokuKingakuDankai3(TextBoxNum txKijunShotokuKingakuDankai3) {
        this.getShotokuDankaiTo2014().getSetaiHikazeiDankai().setTxKijunShotokuKingakuDankai3(txKijunShotokuKingakuDankai3);
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenryoRitsuDai3DankaiKeigenTaishoGai() {
        return this.getShotokuDankaiTo2014().getSetaiHikazeiDankai().getTxtHokenryoRitsuDai3DankaiKeigenTaishoGai();
    }

    @JsonIgnore
    public void setTxtHokenryoRitsuDai3DankaiKeigenTaishoGai(TextBoxNum txtHokenryoRitsuDai3DankaiKeigenTaishoGai) {
        this.getShotokuDankaiTo2014().getSetaiHikazeiDankai().setTxtHokenryoRitsuDai3DankaiKeigenTaishoGai(txtHokenryoRitsuDai3DankaiKeigenTaishoGai);
    }

    @JsonIgnore
    public SetaikazeiHonninHikazeiDankaiDiv getSetaikazeiHonninHikazeiDankai() {
        return this.getShotokuDankaiTo2014().getSetaikazeiHonninHikazeiDankai();
    }

    @JsonIgnore
    public void setSetaikazeiHonninHikazeiDankai(SetaikazeiHonninHikazeiDankaiDiv SetaikazeiHonninHikazeiDankai) {
        this.getShotokuDankaiTo2014().setSetaikazeiHonninHikazeiDankai(SetaikazeiHonninHikazeiDankai);
    }

    @JsonIgnore
    public HorizontalLine getLin4() {
        return this.getShotokuDankaiTo2014().getSetaikazeiHonninHikazeiDankai().getLin4();
    }

    @JsonIgnore
    public void setLin4(HorizontalLine lin4) {
        this.getShotokuDankaiTo2014().getSetaikazeiHonninHikazeiDankai().setLin4(lin4);
    }

    @JsonIgnore
    public Label getLblSetaikazeiDankai() {
        return this.getShotokuDankaiTo2014().getSetaikazeiHonninHikazeiDankai().getLblSetaikazeiDankai();
    }

    @JsonIgnore
    public void setLblSetaikazeiDankai(Label lblSetaikazeiDankai) {
        this.getShotokuDankaiTo2014().getSetaikazeiHonninHikazeiDankai().setLblSetaikazeiDankai(lblSetaikazeiDankai);
    }

    @JsonIgnore
    public RadioButton getRadKeigenSochiDankai4() {
        return this.getShotokuDankaiTo2014().getSetaikazeiHonninHikazeiDankai().getRadKeigenSochiDankai4();
    }

    @JsonIgnore
    public void setRadKeigenSochiDankai4(RadioButton radKeigenSochiDankai4) {
        this.getShotokuDankaiTo2014().getSetaikazeiHonninHikazeiDankai().setRadKeigenSochiDankai4(radKeigenSochiDankai4);
    }

    @JsonIgnore
    public RadioButton getRadDankaiHyokiDankai4() {
        return this.getShotokuDankaiTo2014().getSetaikazeiHonninHikazeiDankai().getRadDankaiHyokiDankai4();
    }

    @JsonIgnore
    public void setRadDankaiHyokiDankai4(RadioButton radDankaiHyokiDankai4) {
        this.getShotokuDankaiTo2014().getSetaikazeiHonninHikazeiDankai().setRadDankaiHyokiDankai4(radDankaiHyokiDankai4);
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenryoRitsuDai4DankaiTaisho() {
        return this.getShotokuDankaiTo2014().getSetaikazeiHonninHikazeiDankai().getTxtHokenryoRitsuDai4DankaiTaisho();
    }

    @JsonIgnore
    public void setTxtHokenryoRitsuDai4DankaiTaisho(TextBoxNum txtHokenryoRitsuDai4DankaiTaisho) {
        this.getShotokuDankaiTo2014().getSetaikazeiHonninHikazeiDankai().setTxtHokenryoRitsuDai4DankaiTaisho(txtHokenryoRitsuDai4DankaiTaisho);
    }

    @JsonIgnore
    public TextBoxNum getTxKijunShotokuKingakuDankai4() {
        return this.getShotokuDankaiTo2014().getSetaikazeiHonninHikazeiDankai().getTxKijunShotokuKingakuDankai4();
    }

    @JsonIgnore
    public void setTxKijunShotokuKingakuDankai4(TextBoxNum txKijunShotokuKingakuDankai4) {
        this.getShotokuDankaiTo2014().getSetaikazeiHonninHikazeiDankai().setTxKijunShotokuKingakuDankai4(txKijunShotokuKingakuDankai4);
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenryoRitsuDai4DankaiTaishoGai() {
        return this.getShotokuDankaiTo2014().getSetaikazeiHonninHikazeiDankai().getTxtHokenryoRitsuDai4DankaiTaishoGai();
    }

    @JsonIgnore
    public void setTxtHokenryoRitsuDai4DankaiTaishoGai(TextBoxNum txtHokenryoRitsuDai4DankaiTaishoGai) {
        this.getShotokuDankaiTo2014().getSetaikazeiHonninHikazeiDankai().setTxtHokenryoRitsuDai4DankaiTaishoGai(txtHokenryoRitsuDai4DankaiTaishoGai);
    }

    @JsonIgnore
    public RadioButton getRadDankaihyokiNinisettei() {
        return this.getHokenryoDankaiFrom2015().getRadDankaihyokiNinisettei();
    }

    @JsonIgnore
    public void setRadDankaihyokiNinisettei(RadioButton radDankaihyokiNinisettei) {
        this.getHokenryoDankaiFrom2015().setRadDankaihyokiNinisettei(radDankaihyokiNinisettei);
    }

    @JsonIgnore
    public DataGrid<dgHokenryoDankai_Row> getDgHokenryoDankai() {
        return this.getHokenryoDankaiFrom2015().getDgHokenryoDankai();
    }

    @JsonIgnore
    public void setDgHokenryoDankai(DataGrid<dgHokenryoDankai_Row> dgHokenryoDankai) {
        this.getHokenryoDankaiFrom2015().setDgHokenryoDankai(dgHokenryoDankai);
    }

    // </editor-fold>
}
