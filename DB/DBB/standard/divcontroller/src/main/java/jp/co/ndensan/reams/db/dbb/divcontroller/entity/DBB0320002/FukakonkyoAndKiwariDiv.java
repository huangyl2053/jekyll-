package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320002;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320002.FukakonkyoNengakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320002.tblFukaKonkyoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320002.tblFukakonkyoMeisaiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320002.tblKikanDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kiwarigaku.KiwarigakuDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FukakonkyoAndKiwari のクラスファイル
 *
 * @author 自動生成
 */
public class FukakonkyoAndKiwariDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("tblFukaKonkyo")
    private tblFukaKonkyoDiv tblFukaKonkyo;
    @JsonProperty("mode")
    private RString mode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblFukaKonkyo")
    public tblFukaKonkyoDiv getTblFukaKonkyo() {
        return tblFukaKonkyo;
    }

    @JsonProperty("tblFukaKonkyo")
    public void setTblFukaKonkyo(tblFukaKonkyoDiv tblFukaKonkyo) {
        this.tblFukaKonkyo = tblFukaKonkyo;
    }

    @JsonProperty("mode")
    public RString getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(RString mode) {
        this.mode = mode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tblFukakonkyoMeisaiDiv getTblFukakonkyoMeisai() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai();
    }

    @JsonIgnore
    public Label getLblFukakonkyoMidashi() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblFukakonkyoMidashi();
    }

    @JsonIgnore
    public Label getLblFukakonkyo11() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblFukakonkyo11();
    }

    @JsonIgnore
    public Label getLblFukakijunYMD() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblFukakijunYMD();
    }

    @JsonIgnore
    public Label getLblHonninKazei() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblHonninKazei();
    }

    @JsonIgnore
    public Label getLblZenHokenryoDankai() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblZenHokenryoDankai();
    }

    @JsonIgnore
    public Label getLblHonninKazeiValue() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblHonninKazeiValue();
    }

    @JsonIgnore
    public Label getLblZenHokenryoDankaiValue() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblZenHokenryoDankaiValue();
    }

    @JsonIgnore
    public Label getLblFukakonkyo12() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblFukakonkyo12();
    }

    @JsonIgnore
    public Label getLblShikakuShutokuYMD() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblShikakuShutokuYMD();
    }

    @JsonIgnore
    public Label getLblSetaiKazei() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblSetaiKazei();
    }

    @JsonIgnore
    public Label getLblZenHokenryoritsu() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblZenHokenryoritsu();
    }

    @JsonIgnore
    public Label getLblSetaiKazeiValue() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblSetaiKazeiValue();
    }

    @JsonIgnore
    public Label getLblZenHokenryoritsuValue() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblZenHokenryoritsuValue();
    }

    @JsonIgnore
    public Label getLblFukakonkyo13() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblFukakonkyo13();
    }

    @JsonIgnore
    public Label getLblShikakuSoshitsuYMD() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblShikakuSoshitsuYMD();
    }

    @JsonIgnore
    public Label getLblShotokuSum() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblShotokuSum();
    }

    @JsonIgnore
    public Label getLblZenNengakuHokenryo() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblZenNengakuHokenryo();
    }

    @JsonIgnore
    public Label getLblShotokuSumValue() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblShotokuSumValue();
    }

    @JsonIgnore
    public Label getLblZenNengakuHokenryoValue() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblZenNengakuHokenryoValue();
    }

    @JsonIgnore
    public Label getLblFukakonkyo14() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblFukakonkyo14();
    }

    @JsonIgnore
    public Label getLblSeihoKaishiYMD() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblSeihoKaishiYMD();
    }

    @JsonIgnore
    public Label getLblNenkinShunyu() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblNenkinShunyu();
    }

    @JsonIgnore
    public Label getLblNenkinShunyuValue() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblNenkinShunyuValue();
    }

    @JsonIgnore
    public Label getLblFukakonkyo15() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblFukakonkyo15();
    }

    @JsonIgnore
    public Label getLblSeihoShuryoYMD() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblSeihoShuryoYMD();
    }

    @JsonIgnore
    public Label getLblHokenryoDankai() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblHokenryoDankai();
    }

    @JsonIgnore
    public Label getLblHokenryoDankaiValue() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblHokenryoDankaiValue();
    }

    @JsonIgnore
    public Label getLblFukakonkyo16() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblFukakonkyo16();
    }

    @JsonIgnore
    public Label getLblRonenKaishiYMD() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblRonenKaishiYMD();
    }

    @JsonIgnore
    public Label getLbldamy1() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLbldamy1();
    }

    @JsonIgnore
    public Label getLblFukakonkyo17() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblFukakonkyo17();
    }

    @JsonIgnore
    public Label getLblRonenShuryoYMD() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblRonenShuryoYMD();
    }

    @JsonIgnore
    public Label getLblFukakonkyo18() {
        return this.getTblFukaKonkyo().getTblFukakonkyoMeisai().getLblFukakonkyo18();
    }

    @JsonIgnore
    public KiwarigakuDiv getFukaShokaiKiwarigaku() {
        return this.getTblFukaKonkyo().getFukaShokaiKiwarigaku();
    }

    @JsonIgnore
    public tblKikanDiv getTblKikan() {
        return this.getTblFukaKonkyo().getTblKikan();
    }

    @JsonIgnore
    public Label getLblKikan() {
        return this.getTblFukaKonkyo().getTblKikan().getLblKikan();
    }

    @JsonIgnore
    public Label getLblTsukiSu() {
        return this.getTblFukaKonkyo().getTblKikan().getLblTsukiSu();
    }

    @JsonIgnore
    public Label getLblShotokuDankai() {
        return this.getTblFukaKonkyo().getTblKikan().getLblShotokuDankai();
    }

    @JsonIgnore
    public Label getLblHokenryoritsu() {
        return this.getTblFukaKonkyo().getTblKikan().getLblHokenryoritsu();
    }

    @JsonIgnore
    public Label getLblHokenryoSansyutsu() {
        return this.getTblFukaKonkyo().getTblKikan().getLblHokenryoSansyutsu();
    }

    @JsonIgnore
    public Label getLblHokenryo() {
        return this.getTblFukaKonkyo().getTblKikan().getLblHokenryo();
    }

    @JsonIgnore
    public Label getLblKikan1() {
        return this.getTblFukaKonkyo().getTblKikan().getLblKikan1();
    }

    @JsonIgnore
    public Label getLblTsukiSu1() {
        return this.getTblFukaKonkyo().getTblKikan().getLblTsukiSu1();
    }

    @JsonIgnore
    public Label getLblHokenryoDankai1() {
        return this.getTblFukaKonkyo().getTblKikan().getLblHokenryoDankai1();
    }

    @JsonIgnore
    public Label getLblHokenryoritsu1() {
        return this.getTblFukaKonkyo().getTblKikan().getLblHokenryoritsu1();
    }

    @JsonIgnore
    public Label getLblHokenryoSansyutsu1() {
        return this.getTblFukaKonkyo().getTblKikan().getLblHokenryoSansyutsu1();
    }

    @JsonIgnore
    public Label getLblHokenryo1() {
        return this.getTblFukaKonkyo().getTblKikan().getLblHokenryo1();
    }

    @JsonIgnore
    public FukakonkyoNengakuDiv getFukakonkyoNengaku() {
        return this.getTblFukaKonkyo().getFukakonkyoNengaku();
    }

    @JsonIgnore
    public TextBox getTxtFukashokaiChoteiJiyu1() {
        return this.getTblFukaKonkyo().getTxtFukashokaiChoteiJiyu1();
    }

    @JsonIgnore
    public TextBox getTxtFukashokaiChoteiJiyu2() {
        return this.getTblFukaKonkyo().getTxtFukashokaiChoteiJiyu2();
    }

    @JsonIgnore
    public TextBox getTxtFukashokaiChoteiJiyu3() {
        return this.getTblFukaKonkyo().getTxtFukashokaiChoteiJiyu3();
    }

    @JsonIgnore
    public TextBox getTxtFukashokaiChoteiJiyu4() {
        return this.getTblFukaKonkyo().getTxtFukashokaiChoteiJiyu4();
    }

}
