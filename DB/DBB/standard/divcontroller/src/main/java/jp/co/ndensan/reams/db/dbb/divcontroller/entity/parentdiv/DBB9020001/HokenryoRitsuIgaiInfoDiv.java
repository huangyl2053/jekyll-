package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * HokenryoRitsuIgaiInfo のクラスファイル
 *
 * @reamsid_L DBB-1770-010 wangkanglei
 */
public class HokenryoRitsuIgaiInfoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Mishinkoku")
    private MishinkokuDiv Mishinkoku;
    @JsonProperty("ShotokuChosaChu")
    private ShotokuChosaChuDiv ShotokuChosaChu;
    @JsonProperty("KazeiTorikeshi")
    private KazeiTorikeshiDiv KazeiTorikeshi;
    @JsonProperty("NengakuHokenryo")
    private NengakuHokenryoDiv NengakuHokenryo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getMishinkoku
     * @return Mishinkoku
     */
    @JsonProperty("Mishinkoku")
    public MishinkokuDiv getMishinkoku() {
        return Mishinkoku;
    }

    /*
     * setMishinkoku
     * @param Mishinkoku Mishinkoku
     */
    @JsonProperty("Mishinkoku")
    public void setMishinkoku(MishinkokuDiv Mishinkoku) {
        this.Mishinkoku = Mishinkoku;
    }

    /*
     * getShotokuChosaChu
     * @return ShotokuChosaChu
     */
    @JsonProperty("ShotokuChosaChu")
    public ShotokuChosaChuDiv getShotokuChosaChu() {
        return ShotokuChosaChu;
    }

    /*
     * setShotokuChosaChu
     * @param ShotokuChosaChu ShotokuChosaChu
     */
    @JsonProperty("ShotokuChosaChu")
    public void setShotokuChosaChu(ShotokuChosaChuDiv ShotokuChosaChu) {
        this.ShotokuChosaChu = ShotokuChosaChu;
    }

    /*
     * getKazeiTorikeshi
     * @return KazeiTorikeshi
     */
    @JsonProperty("KazeiTorikeshi")
    public KazeiTorikeshiDiv getKazeiTorikeshi() {
        return KazeiTorikeshi;
    }

    /*
     * setKazeiTorikeshi
     * @param KazeiTorikeshi KazeiTorikeshi
     */
    @JsonProperty("KazeiTorikeshi")
    public void setKazeiTorikeshi(KazeiTorikeshiDiv KazeiTorikeshi) {
        this.KazeiTorikeshi = KazeiTorikeshi;
    }

    /*
     * getNengakuHokenryo
     * @return NengakuHokenryo
     */
    @JsonProperty("NengakuHokenryo")
    public NengakuHokenryoDiv getNengakuHokenryo() {
        return NengakuHokenryo;
    }

    /*
     * setNengakuHokenryo
     * @param NengakuHokenryo NengakuHokenryo
     */
    @JsonProperty("NengakuHokenryo")
    public void setNengakuHokenryo(NengakuHokenryoDiv NengakuHokenryo) {
        this.NengakuHokenryo = NengakuHokenryo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadMishinkokuKyoseiSettei() {
        return this.getMishinkoku().getRadMishinkokuKyoseiSettei();
    }

    @JsonIgnore
    public void setRadMishinkokuKyoseiSettei(RadioButton radMishinkokuKyoseiSettei) {
        this.getMishinkoku().setRadMishinkokuKyoseiSettei(radMishinkokuKyoseiSettei);
    }

    @JsonIgnore
    public DropDownList getDdlMishinkokuKyoseiSettei() {
        return this.getMishinkoku().getDdlMishinkokuKyoseiSettei();
    }

    @JsonIgnore
    public void setDdlMishinkokuKyoseiSettei(DropDownList ddlMishinkokuKyoseiSettei) {
        this.getMishinkoku().setDdlMishinkokuKyoseiSettei(ddlMishinkokuKyoseiSettei);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getMishinkoku().getLin1();
    }

    @JsonIgnore
    public void setLin1(HorizontalLine lin1) {
        this.getMishinkoku().setLin1(lin1);
    }

    @JsonIgnore
    public RadioButton getRadtMishinkokuKazeiKbn() {
        return this.getMishinkoku().getRadtMishinkokuKazeiKbn();
    }

    @JsonIgnore
    public void setRadtMishinkokuKazeiKbn(RadioButton radtMishinkokuKazeiKbn) {
        this.getMishinkoku().setRadtMishinkokuKazeiKbn(radtMishinkokuKazeiKbn);
    }

    @JsonIgnore
    public RadioButton getRadShotokuChosaChuKyoseiSettei() {
        return this.getShotokuChosaChu().getRadShotokuChosaChuKyoseiSettei();
    }

    @JsonIgnore
    public void setRadShotokuChosaChuKyoseiSettei(RadioButton radShotokuChosaChuKyoseiSettei) {
        this.getShotokuChosaChu().setRadShotokuChosaChuKyoseiSettei(radShotokuChosaChuKyoseiSettei);
    }

    @JsonIgnore
    public DropDownList getDdlShotokuChosaChuKyoseiSettei() {
        return this.getShotokuChosaChu().getDdlShotokuChosaChuKyoseiSettei();
    }

    @JsonIgnore
    public void setDdlShotokuChosaChuKyoseiSettei(DropDownList ddlShotokuChosaChuKyoseiSettei) {
        this.getShotokuChosaChu().setDdlShotokuChosaChuKyoseiSettei(ddlShotokuChosaChuKyoseiSettei);
    }

    @JsonIgnore
    public HorizontalLine getLin2() {
        return this.getShotokuChosaChu().getLin2();
    }

    @JsonIgnore
    public void setLin2(HorizontalLine lin2) {
        this.getShotokuChosaChu().setLin2(lin2);
    }

    @JsonIgnore
    public RadioButton getRadShotokuChosaChuKazeiKbn() {
        return this.getShotokuChosaChu().getRadShotokuChosaChuKazeiKbn();
    }

    @JsonIgnore
    public void setRadShotokuChosaChuKazeiKbn(RadioButton radShotokuChosaChuKazeiKbn) {
        this.getShotokuChosaChu().setRadShotokuChosaChuKazeiKbn(radShotokuChosaChuKazeiKbn);
    }

    @JsonIgnore
    public RadioButton getRadKazeiTorikeshiKyoseiSettei() {
        return this.getKazeiTorikeshi().getRadKazeiTorikeshiKyoseiSettei();
    }

    @JsonIgnore
    public void setRadKazeiTorikeshiKyoseiSettei(RadioButton radKazeiTorikeshiKyoseiSettei) {
        this.getKazeiTorikeshi().setRadKazeiTorikeshiKyoseiSettei(radKazeiTorikeshiKyoseiSettei);
    }

    @JsonIgnore
    public DropDownList getDdlKazeiTorikeshiKyoseiSettei() {
        return this.getKazeiTorikeshi().getDdlKazeiTorikeshiKyoseiSettei();
    }

    @JsonIgnore
    public void setDdlKazeiTorikeshiKyoseiSettei(DropDownList ddlKazeiTorikeshiKyoseiSettei) {
        this.getKazeiTorikeshi().setDdlKazeiTorikeshiKyoseiSettei(ddlKazeiTorikeshiKyoseiSettei);
    }

    @JsonIgnore
    public HorizontalLine getLin5() {
        return this.getKazeiTorikeshi().getLin5();
    }

    @JsonIgnore
    public void setLin5(HorizontalLine lin5) {
        this.getKazeiTorikeshi().setLin5(lin5);
    }

    @JsonIgnore
    public RadioButton getRadKazeiTorikeshiKazeiKbn() {
        return this.getKazeiTorikeshi().getRadKazeiTorikeshiKazeiKbn();
    }

    @JsonIgnore
    public void setRadKazeiTorikeshiKazeiKbn(RadioButton radKazeiTorikeshiKazeiKbn) {
        this.getKazeiTorikeshi().setRadKazeiTorikeshiKazeiKbn(radKazeiTorikeshiKazeiKbn);
    }

    @JsonIgnore
    public DropDownList getDdlHasu() {
        return this.getNengakuHokenryo().getDdlHasu();
    }

    @JsonIgnore
    public void setDdlHasu(DropDownList ddlHasu) {
        this.getNengakuHokenryo().setDdlHasu(ddlHasu);
    }

    @JsonIgnore
    public DropDownList getDdlMarumeKata() {
        return this.getNengakuHokenryo().getDdlMarumeKata();
    }

    @JsonIgnore
    public void setDdlMarumeKata(DropDownList ddlMarumeKata) {
        this.getNengakuHokenryo().setDdlMarumeKata(ddlMarumeKata);
    }

    // </editor-fold>
}
