package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HakkoChohyoSentaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class HakkoChohyoSentakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnOutputSetaiJoho")
    private Button btnOutputSetaiJoho;
    @JsonProperty("TsuchishoSakuseiKobetsu")
    private TsuchishoSakuseiKobetsuDiv TsuchishoSakuseiKobetsu;
    @JsonProperty("GemmenRireki")
    private GemmenRirekiDiv GemmenRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnOutputSetaiJoho
     * @return btnOutputSetaiJoho
     */
    @JsonProperty("btnOutputSetaiJoho")
    public Button getBtnOutputSetaiJoho() {
        return btnOutputSetaiJoho;
    }

    /*
     * setbtnOutputSetaiJoho
     * @param btnOutputSetaiJoho btnOutputSetaiJoho
     */
    @JsonProperty("btnOutputSetaiJoho")
    public void setBtnOutputSetaiJoho(Button btnOutputSetaiJoho) {
        this.btnOutputSetaiJoho = btnOutputSetaiJoho;
    }

    /*
     * getTsuchishoSakuseiKobetsu
     * @return TsuchishoSakuseiKobetsu
     */
    @JsonProperty("TsuchishoSakuseiKobetsu")
    public TsuchishoSakuseiKobetsuDiv getTsuchishoSakuseiKobetsu() {
        return TsuchishoSakuseiKobetsu;
    }

    /*
     * setTsuchishoSakuseiKobetsu
     * @param TsuchishoSakuseiKobetsu TsuchishoSakuseiKobetsu
     */
    @JsonProperty("TsuchishoSakuseiKobetsu")
    public void setTsuchishoSakuseiKobetsu(TsuchishoSakuseiKobetsuDiv TsuchishoSakuseiKobetsu) {
        this.TsuchishoSakuseiKobetsu = TsuchishoSakuseiKobetsu;
    }

    /*
     * getGemmenRireki
     * @return GemmenRireki
     */
    @JsonProperty("GemmenRireki")
    public GemmenRirekiDiv getGemmenRireki() {
        return GemmenRireki;
    }

    /*
     * setGemmenRireki
     * @param GemmenRireki GemmenRireki
     */
    @JsonProperty("GemmenRireki")
    public void setGemmenRireki(GemmenRirekiDiv GemmenRireki) {
        this.GemmenRireki = GemmenRireki;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RiyoshaFutangakuGenmenDiv getRiyoshaFutangakuGenmen() {
        return this.getGemmenRireki().getRiyoshaFutangakuGenmen();
    }

    @JsonIgnore
    public void  setRiyoshaFutangakuGenmen(RiyoshaFutangakuGenmenDiv RiyoshaFutangakuGenmen) {
        this.getGemmenRireki().setRiyoshaFutangakuGenmen(RiyoshaFutangakuGenmen);
    }

    @JsonIgnore
    public FutanGendogakuNinteiDiv getFutanGendogakuNintei() {
        return this.getGemmenRireki().getFutanGendogakuNintei();
    }

    @JsonIgnore
    public void  setFutanGendogakuNintei(FutanGendogakuNinteiDiv FutanGendogakuNintei) {
        this.getGemmenRireki().setFutanGendogakuNintei(FutanGendogakuNintei);
    }

    @JsonIgnore
    public HomonKaigoRiyoshaFutangakuGengakuDiv getHomonKaigoRiyoshaFutangakuGengaku() {
        return this.getGemmenRireki().getHomonKaigoRiyoshaFutangakuGengaku();
    }

    @JsonIgnore
    public void  setHomonKaigoRiyoshaFutangakuGengaku(HomonKaigoRiyoshaFutangakuGengakuDiv HomonKaigoRiyoshaFutangakuGengaku) {
        this.getGemmenRireki().setHomonKaigoRiyoshaFutangakuGengaku(HomonKaigoRiyoshaFutangakuGengaku);
    }

    @JsonIgnore
    public ShafukuHojinToRiyushaFutanKeigenDiv getShafukuHojinToRiyushaFutanKeigen() {
        return this.getGemmenRireki().getShafukuHojinToRiyushaFutanKeigen();
    }

    @JsonIgnore
    public void  setShafukuHojinToRiyushaFutanKeigen(ShafukuHojinToRiyushaFutanKeigenDiv ShafukuHojinToRiyushaFutanKeigen) {
        this.getGemmenRireki().setShafukuHojinToRiyushaFutanKeigen(ShafukuHojinToRiyushaFutanKeigen);
    }

    @JsonIgnore
    public TokubetsuChilkiKasanGenmenDiv getTokubetsuChilkiKasanGenmen() {
        return this.getGemmenRireki().getTokubetsuChilkiKasanGenmen();
    }

    @JsonIgnore
    public void  setTokubetsuChilkiKasanGenmen(TokubetsuChilkiKasanGenmenDiv TokubetsuChilkiKasanGenmen) {
        this.getGemmenRireki().setTokubetsuChilkiKasanGenmen(TokubetsuChilkiKasanGenmen);
    }

    @JsonIgnore
    public Button getBtnOutputAtoRireki() {
        return this.getGemmenRireki().getBtnOutputAtoRireki();
    }

    @JsonIgnore
    public void  setBtnOutputAtoRireki(Button btnOutputAtoRireki) {
        this.getGemmenRireki().setBtnOutputAtoRireki(btnOutputAtoRireki);
    }

    @JsonIgnore
    public Button getBtnOutputMaeRireki() {
        return this.getGemmenRireki().getBtnOutputMaeRireki();
    }

    @JsonIgnore
    public void  setBtnOutputMaeRireki(Button btnOutputMaeRireki) {
        this.getGemmenRireki().setBtnOutputMaeRireki(btnOutputMaeRireki);
    }

    // </editor-fold>
}
