package jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoChohyoShutsuryokujun;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv.DisplayNone;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * 介護帳票出力順の共有子Divのコントロールクラスです。
 *
 * @author 自動生成
 */
public class KaigoChohyoShutsuryokujunDiv extends Panel implements IKaigoChohyoShutsuryokujunDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("kaigoChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv kaigoChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("kaigoChohyoShutsuryokujun")
    public ChohyoShutsuryokujunDiv getKaigoChohyoShutsuryokujun() {
        return kaigoChohyoShutsuryokujun;
    }

    @JsonProperty("kaigoChohyoShutsuryokujun")
    public void setKaigoChohyoShutsuryokujun(ChohyoShutsuryokujunDiv kaigoChohyoShutsuryokujun) {
        this.kaigoChohyoShutsuryokujun = kaigoChohyoShutsuryokujun;
    }

    /**
     * 共有子Div情報を全てクリアします。
     */
    public void clear() {
        //createHandler().clear();
    }

    /**
     * 共有子Div情報(CSV)をロードします。
     *
     * @param subGyomuCode サブ業務コード
     * @param reportId 帳票ID
     */
    @Override
    public void loadCSVMode(SubGyomuCode subGyomuCode, ReportId reportId) {
        createHandler().load(subGyomuCode, reportId, DisplayNone.SORT_ONLY);
    }

    /**
     * 共有子Div情報(帳票)をロードします。
     *
     * @param subGyomuCode サブ業務コード
     * @param reportId 帳票ID
     */
    @Override
    public void loadChohyoMode(SubGyomuCode subGyomuCode, ReportId reportId) {
        createHandler().load(subGyomuCode, reportId, DisplayNone.SHUKEI_NONE);
    }

    @JsonIgnore
    private KaigoChohyoShutsuryokujunHandler createHandler() {
        return new KaigoChohyoShutsuryokujunHandler(this);
    }

    /**
     * 入力データチェックです。
     */
    @Override
    public void checkInput() {
        createHandler().checkInput();
    }
}
