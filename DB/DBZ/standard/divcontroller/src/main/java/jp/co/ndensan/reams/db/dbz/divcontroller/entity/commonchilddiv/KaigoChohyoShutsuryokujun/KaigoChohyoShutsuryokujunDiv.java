package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoChohyoShutsuryokujun;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv.DisplayNone;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
public class KaigoChohyoShutsuryokujunDiv extends Panel implements IKaigoChohyoShutsuryokujunDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public ChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
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
