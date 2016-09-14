package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5110011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect.ChikuShichosonSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect.IChikuShichosonSelectDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RiyojokyoTokeihyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class RiyojokyoTokeihyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChushutsuJoken")
    private ChushutsuJokenDiv ChushutsuJoken;
    @JsonProperty("SeteJoken")
    private SeteJokenDiv SeteJoken;
    @JsonProperty("Tiku")
    private TikuDiv Tiku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChushutsuJoken
     * @return ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public ChushutsuJokenDiv getChushutsuJoken() {
        return ChushutsuJoken;
    }

    /*
     * setChushutsuJoken
     * @param ChushutsuJoken ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public void setChushutsuJoken(ChushutsuJokenDiv ChushutsuJoken) {
        this.ChushutsuJoken = ChushutsuJoken;
    }

    /*
     * getSeteJoken
     * @return SeteJoken
     */
    @JsonProperty("SeteJoken")
    public SeteJokenDiv getSeteJoken() {
        return SeteJoken;
    }

    /*
     * setSeteJoken
     * @param SeteJoken SeteJoken
     */
    @JsonProperty("SeteJoken")
    public void setSeteJoken(SeteJokenDiv SeteJoken) {
        this.SeteJoken = SeteJoken;
    }

    /*
     * getTiku
     * @return Tiku
     */
    @JsonProperty("Tiku")
    public TikuDiv getTiku() {
        return Tiku;
    }

    /*
     * setTiku
     * @param Tiku Tiku
     */
    @JsonProperty("Tiku")
    public void setTiku(TikuDiv Tiku) {
        this.Tiku = Tiku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadTaishoYM() {
        return this.getChushutsuJoken().getRadTaishoYM();
    }

    @JsonIgnore
    public void  setRadTaishoYM(RadioButton radTaishoYM) {
        this.getChushutsuJoken().setRadTaishoYM(radTaishoYM);
    }

    @JsonIgnore
    public TextBoxDate getTasyoNengetu() {
        return this.getChushutsuJoken().getTasyoNengetu();
    }

    @JsonIgnore
    public void  setTasyoNengetu(TextBoxDate TasyoNengetu) {
        this.getChushutsuJoken().setTasyoNengetu(TasyoNengetu);
    }

    @JsonIgnore
    public DropDownList getNenreSansyutuKijyun() {
        return this.getSeteJoken().getNenreSansyutuKijyun();
    }

    @JsonIgnore
    public void  setNenreSansyutuKijyun(DropDownList NenreSansyutuKijyun) {
        this.getSeteJoken().setNenreSansyutuKijyun(NenreSansyutuKijyun);
    }

    @JsonIgnore
    public IChikuShichosonSelectDiv getChikushichosonSelect() {
        return this.getTiku().getChikushichosonSelect();
    }

    // </editor-fold>
}
