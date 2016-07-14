package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020004;

/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;

/**
 * KyufugakuGengakuKanriList のクラスファイル
 *
 * @author 自動生成
 */
public class KyufugakuGengakuKanriListDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChushutuJoken")
    private ChushutuJokenDiv ChushutuJoken;
    @JsonProperty("BatchParameter")
    private BatchParameterDiv BatchParameter;
    @JsonProperty("KyufugakuGengakuKanriList")
    private KyufugakuGengakuKanriListDiv KyufugakuGengakuKanriList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
 /*
     * getChushutuJoken
     * @return ChushutuJoken
     */
    @JsonProperty("ChushutuJoken")
    public ChushutuJokenDiv getChushutuJoken() {
        return ChushutuJoken;
    }

    /*
     * setChushutuJoken
     * @param ChushutuJoken ChushutuJoken
     */
    @JsonProperty("ChushutuJoken")
    public void setChushutuJoken(ChushutuJokenDiv ChushutuJoken) {
        this.ChushutuJoken = ChushutuJoken;
    }

    /*
     * getBatchParameter
     * @return BatchParameter
     */
    @JsonProperty("BatchParameter")
    public BatchParameterDiv getBatchParameter() {
        return BatchParameter;
    }

    /*
     * setBatchParameter
     * @param BatchParameter BatchParameter
     */
    @JsonProperty("BatchParameter")
    public void setBatchParameter(BatchParameterDiv BatchParameter) {
        this.BatchParameter = BatchParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkTsuchishoMihakko() {
        return this.getChushutuJoken().getZenTorokushaIgai().getChkTsuchishoMihakko();
    }

    @JsonIgnore
    public void setChkTsuchishoMihakko(CheckBoxList chkTsuchishoMihakko) {
        this.getChushutuJoken().getZenTorokushaIgai().setChkTsuchishoMihakko(chkTsuchishoMihakko);
    }

    @JsonIgnore
    public CheckBoxList getChkGengakuTekiyochuSha() {
        return this.getChushutuJoken().getZenTorokushaIgai().getChkGengakuTekiyochuSha();
    }

    @JsonIgnore
    public void setChkGengakuTekiyochuSha(CheckBoxList chkGengakuTekiyochuSha) {
        this.getChushutuJoken().getZenTorokushaIgai().setChkGengakuTekiyochuSha(chkGengakuTekiyochuSha);
    }

    @JsonIgnore
    public TextBoxDate getTxtGengakuTekiyoChushaKijunDate() {
        return this.getChushutuJoken().getZenTorokushaIgai().getTxtGengakuTekiyoChushaKijunDate();
    }

    @JsonIgnore
    public void setTxtGengakuTekiyoChushaKijunDate(TextBoxDate txtGengakuTekiyoChushaKijunDate) {
        this.getChushutuJoken().getZenTorokushaIgai().setTxtGengakuTekiyoChushaKijunDate(txtGengakuTekiyoChushaKijunDate);
    }

    @JsonIgnore
    public CheckBoxList getChkGengakuShuryoDate() {
        return this.getChushutuJoken().getZenTorokushaIgai().getChkGengakuShuryoDate();
    }

    @JsonIgnore
    public void setChkGengakuShuryoDate(CheckBoxList chkGengakuShuryoDate) {
        this.getChushutuJoken().getZenTorokushaIgai().setChkGengakuShuryoDate(chkGengakuShuryoDate);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtGengakuShuryoRange() {
        return this.getChushutuJoken().getZenTorokushaIgai().getTxtGengakuShuryoRange();
    }

    @JsonIgnore
    public void setTxtGengakuShuryoRange(TextBoxDateRange txtGengakuShuryoRange) {
        this.getChushutuJoken().getZenTorokushaIgai().setTxtGengakuShuryoRange(txtGengakuShuryoRange);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return this.getBatchParameter().getCcdChohyoShutsuryokujun();
    }

    // </editor-fold>

    /*
     * getKyufugakuGengakuKanriList
     * @return KyufugakuGengakuKanriList
     */
    @JsonProperty("KyufugakuGengakuKanriList")
    public KyufugakuGengakuKanriListDiv getKyufugakuGengakuKanriList() {
        return KyufugakuGengakuKanriList;
    }

    /*
     * setKyufugakuGengakuKanriList
     * @param KyufugakuGengakuKanriList KyufugakuGengakuKanriList
     */
    @JsonProperty("KyufugakuGengakuKanriList")
    public void setKyufugakuGengakuKanriList(KyufugakuGengakuKanriListDiv KyufugakuGengakuKanriList) {
        this.KyufugakuGengakuKanriList = KyufugakuGengakuKanriList;
    }

}
