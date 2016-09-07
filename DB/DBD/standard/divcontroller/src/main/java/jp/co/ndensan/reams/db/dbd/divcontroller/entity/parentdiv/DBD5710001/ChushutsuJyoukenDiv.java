package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5710001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuJyouken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJyoukenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radChushutsuJyouken")
    private RadioButton radChushutsuJyouken;
    @JsonProperty("TaishouSha")
    private TaishouShaDiv TaishouSha;
    @JsonProperty("TaishouKikan")
    private TaishouKikanDiv TaishouKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradChushutsuJyouken
     * @return radChushutsuJyouken
     */
    @JsonProperty("radChushutsuJyouken")
    public RadioButton getRadChushutsuJyouken() {
        return radChushutsuJyouken;
    }

    /*
     * setradChushutsuJyouken
     * @param radChushutsuJyouken radChushutsuJyouken
     */
    @JsonProperty("radChushutsuJyouken")
    public void setRadChushutsuJyouken(RadioButton radChushutsuJyouken) {
        this.radChushutsuJyouken = radChushutsuJyouken;
    }

    /*
     * getTaishouSha
     * @return TaishouSha
     */
    @JsonProperty("TaishouSha")
    public TaishouShaDiv getTaishouSha() {
        return TaishouSha;
    }

    /*
     * setTaishouSha
     * @param TaishouSha TaishouSha
     */
    @JsonProperty("TaishouSha")
    public void setTaishouSha(TaishouShaDiv TaishouSha) {
        this.TaishouSha = TaishouSha;
    }

    /*
     * getTaishouKikan
     * @return TaishouKikan
     */
    @JsonProperty("TaishouKikan")
    public TaishouKikanDiv getTaishouKikan() {
        return TaishouKikan;
    }

    /*
     * setTaishouKikan
     * @param TaishouKikan TaishouKikan
     */
    @JsonProperty("TaishouKikan")
    public void setTaishouKikan(TaishouKikanDiv TaishouKikan) {
        this.TaishouKikan = TaishouKikan;
    }

    // </editor-fold>
}
