package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5710001;
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
 * JyukyushaDaicho のクラスファイル 
 * 
 * @author 自動生成
 */
public class JyukyushaDaichoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChushutsuJyouken")
    private ChushutsuJyoukenDiv ChushutsuJyouken;
    @JsonProperty("ShutsuryokuOption")
    private ShutsuryokuOptionDiv ShutsuryokuOption;
    @JsonProperty("ShutsuryokuSort")
    private ChohyoShutsuryokujunDiv ShutsuryokuSort;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChushutsuJyouken
     * @return ChushutsuJyouken
     */
    @JsonProperty("ChushutsuJyouken")
    public ChushutsuJyoukenDiv getChushutsuJyouken() {
        return ChushutsuJyouken;
    }

    /*
     * setChushutsuJyouken
     * @param ChushutsuJyouken ChushutsuJyouken
     */
    @JsonProperty("ChushutsuJyouken")
    public void setChushutsuJyouken(ChushutsuJyoukenDiv ChushutsuJyouken) {
        this.ChushutsuJyouken = ChushutsuJyouken;
    }

    /*
     * getShutsuryokuOption
     * @return ShutsuryokuOption
     */
    @JsonProperty("ShutsuryokuOption")
    public ShutsuryokuOptionDiv getShutsuryokuOption() {
        return ShutsuryokuOption;
    }

    /*
     * setShutsuryokuOption
     * @param ShutsuryokuOption ShutsuryokuOption
     */
    @JsonProperty("ShutsuryokuOption")
    public void setShutsuryokuOption(ShutsuryokuOptionDiv ShutsuryokuOption) {
        this.ShutsuryokuOption = ShutsuryokuOption;
    }

    /*
     * getShutsuryokuSort
     * @return ShutsuryokuSort
     */
    @JsonProperty("ShutsuryokuSort")
    public IChohyoShutsuryokujunDiv getShutsuryokuSort() {
        return ShutsuryokuSort;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadChushutsuJyouken() {
        return this.getChushutsuJyouken().getRadChushutsuJyouken();
    }

    @JsonIgnore
    public void  setRadChushutsuJyouken(RadioButton radChushutsuJyouken) {
        this.getChushutsuJyouken().setRadChushutsuJyouken(radChushutsuJyouken);
    }

    @JsonIgnore
    public TaishouShaDiv getTaishouSha() {
        return this.getChushutsuJyouken().getTaishouSha();
    }

    @JsonIgnore
    public void  setTaishouSha(TaishouShaDiv TaishouSha) {
        this.getChushutsuJyouken().setTaishouSha(TaishouSha);
    }

    @JsonIgnore
    public TaishouKikanDiv getTaishouKikan() {
        return this.getChushutsuJyouken().getTaishouKikan();
    }

    @JsonIgnore
    public void  setTaishouKikan(TaishouKikanDiv TaishouKikan) {
        this.getChushutsuJyouken().setTaishouKikan(TaishouKikan);
    }

    @JsonIgnore
    public RadioButton getRadShutsuryokuOption() {
        return this.getShutsuryokuOption().getRadShutsuryokuOption();
    }

    @JsonIgnore
    public void  setRadShutsuryokuOption(RadioButton radShutsuryokuOption) {
        this.getShutsuryokuOption().setRadShutsuryokuOption(radShutsuryokuOption);
    }

    // </editor-fold>
}
