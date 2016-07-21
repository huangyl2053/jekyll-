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
    private static final String SHISAKAISU = "shisakaisu";
    private static final String HOSYUSOGAKU = "hosyusogaku";
    private static final String SEGAKUKOJYO = "segakukojyo";
    private static final String HOSYUGOKE = "hosyugoke";

    @BatchParameter(key = SYOHYO_SYUTURYOKU, name = "帳票出力区分")
    private RString syohyoSyuturyoku;
    @BatchParameter(key = SHINSAKAI_KAISAI_YMD, name = "出席日")
    private RString shinsakaiKaisaiYMD;
    @BatchParameter(key = SHISAKAISU, name = "審査回数")
    private RString shisakaisu;
    @BatchParameter(key = HOSYUSOGAKU, name = "報酬総額")
    private RString hosyusogaku;
    @BatchParameter(key = SEGAKUKOJYO, name = "税額控除")
    private RString segakukojyo;
    @BatchParameter(key = HOSYUGOKE, name = "報酬合計")
    private RString hosyugoke;

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
     * @param shisakaisu 審査回数
     * @param hosyusogaku 報酬総額
     * @param segakukojyo 税額控除
     * @param hosyugoke 報酬合計
     */
    public ShinsaHoshuIchiranBatchParameter(RString syohyoSyuturyoku,
            RString shinsakaiKaisaiYMD, RString shisakaisu, RString hosyusogaku,
            RString segakukojyo, RString hosyugoke) {
        this.syohyoSyuturyoku = syohyoSyuturyoku;
        this.shinsakaiKaisaiYMD = shinsakaiKaisaiYMD;
        this.shisakaisu = shisakaisu;
        this.hosyusogaku = hosyusogaku;
        this.segakukojyo = segakukojyo;
        this.hosyugoke = hosyugoke;
    }

    /**
     * 介護認定審査会委員報酬一覧表のProcessParameterを作成します
     *
     * @return 介護認定審査会委員報酬一覧表のProcessParameter
     */
    public ShinsaHoshuIchiranProcessParameter toProcessParamter() {
        return new ShinsaHoshuIchiranProcessParameter(syohyoSyuturyoku,
                shinsakaiKaisaiYMD, shisakaisu, hosyusogaku, segakukojyo, hosyugoke);
    }
}
