/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.shinsahoshuichiran;

import jp.co.ndensan.reams.db.dbe.definition.processprm.shinsahoshuichiran.ShinsaHoshuIchiranProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会委員報酬一覧表_バッチフロークラスパラメータクラスです。
 *
 * @reamsid_L DBE-1920-020 zhaoyao
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsaHoshuIchiranBatchParameter extends BatchParameterBase {

    private static final String SYOHYO_SYUTURYOKU = "syohyoSyuturyoku";
    private static final String SHINSAKAI_KAISAI_YMD = "shinsakaiKaisaiYMD";

    @BatchParameter(key = SYOHYO_SYUTURYOKU, name = "帳票出力区分")
    private RString syohyoSyuturyoku;
    @BatchParameter(key = SHINSAKAI_KAISAI_YMD, name = "出席日")
    private RString shinsakaiKaisaiYMD;

    /**
     * コンストラクタです。
     */
    public ShinsaHoshuIchiranBatchParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param syohyoSyuturyoku 帳票出力区分
     * @param shinsakaiKaisaiYMD 審査会開催年月
     */
    public ShinsaHoshuIchiranBatchParameter(RString syohyoSyuturyoku,
            RString shinsakaiKaisaiYMD) {
        this.syohyoSyuturyoku = syohyoSyuturyoku;
        this.shinsakaiKaisaiYMD = shinsakaiKaisaiYMD;
    }

    /**
     * 介護認定審査会委員報酬一覧表のProcessParameterを作成します
     *
     * @return 介護認定審査会委員報酬一覧表のProcessParameter
     */
    public ShinsaHoshuIchiranProcessParameter toProcessParamter() {
        return new ShinsaHoshuIchiranProcessParameter(syohyoSyuturyoku,
                shinsakaiKaisaiYMD);
    }
}
