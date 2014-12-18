package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IKogakuServicehiJudgementResultDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KogakuServicehiJudgementResultDetail1Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KogakuServicehiJudgementResultDetail2Div;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgJudgementResult_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KogakuServicehiJudgementResult のクラスファイル 
 * 
 * @author 自動生成
 */
public class KogakuServicehiJudgementResultDiv extends Panel implements IKogakuServicehiJudgementResultDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgJudgementResult")
    private DataGrid<dgJudgementResult_Row> dgJudgementResult;
    @JsonProperty("KogakuServicehiJudgementResultDetail1")
    private KogakuServicehiJudgementResultDetail1Div KogakuServicehiJudgementResultDetail1;
    @JsonProperty("KogakuServicehiJudgementResultDetail2")
    private KogakuServicehiJudgementResultDetail2Div KogakuServicehiJudgementResultDetail2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgJudgementResult")
    public DataGrid<dgJudgementResult_Row> getDgJudgementResult() {
        return dgJudgementResult;
    }

    @JsonProperty("dgJudgementResult")
    public void setDgJudgementResult(DataGrid<dgJudgementResult_Row> dgJudgementResult) {
        this.dgJudgementResult=dgJudgementResult;
    }

    @JsonProperty("KogakuServicehiJudgementResultDetail1")
    public KogakuServicehiJudgementResultDetail1Div getKogakuServicehiJudgementResultDetail1() {
        return KogakuServicehiJudgementResultDetail1;
    }

    @JsonProperty("KogakuServicehiJudgementResultDetail1")
    public void setKogakuServicehiJudgementResultDetail1(KogakuServicehiJudgementResultDetail1Div KogakuServicehiJudgementResultDetail1) {
        this.KogakuServicehiJudgementResultDetail1=KogakuServicehiJudgementResultDetail1;
    }

    @JsonProperty("KogakuServicehiJudgementResultDetail2")
    public KogakuServicehiJudgementResultDetail2Div getKogakuServicehiJudgementResultDetail2() {
        return KogakuServicehiJudgementResultDetail2;
    }

    @JsonProperty("KogakuServicehiJudgementResultDetail2")
    public void setKogakuServicehiJudgementResultDetail2(KogakuServicehiJudgementResultDetail2Div KogakuServicehiJudgementResultDetail2) {
        this.KogakuServicehiJudgementResultDetail2=KogakuServicehiJudgementResultDetail2;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
