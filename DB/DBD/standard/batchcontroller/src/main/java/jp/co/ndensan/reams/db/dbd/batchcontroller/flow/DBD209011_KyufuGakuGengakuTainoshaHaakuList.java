/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD209011.KyufuGengakuHaakuListSakuseiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD209011.KyufuGengakuHaakuListTaishoTokuteiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD209011.ShunoJokyoHaakuProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD209011.ShunoTainoJokyoHaakuProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD209011.DBD209011_KyufuGakuGengakuTainoshaHaakuListParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 給付額減額滞納者把握リスト（バッチ）フロークラスです．
 *
 * @reamsid_L DBD-3610-030 x_lilh
 */
public class DBD209011_KyufuGakuGengakuTainoshaHaakuList extends BatchFlowBase<DBD209011_KyufuGakuGengakuTainoshaHaakuListParameter> {

    private static final String 収納状況把握情報の取得 = "shunoJokyoHaaku";
    private static final String 対象者把握情報の取得 = "kyufuGengakuHaakuListTaishoTokutei";
    private static final String 収納滞納状況把握情報の取得 = "shunoTainoJokyoHaaku";
    private static final String 給付額減額滞納者把握情報取得 = "kyufuGengakuHaakuListSakusei";

    private RString バッチ起動時処理日時;
    private static final int INDEX_0 = 0;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_8 = 8;

    @Override
    protected void initialize() {
        RTime time = RDate.getNowTime();
        RString hour = new RString(time.toString()).substring(INDEX_0, INDEX_2);
        RString min = new RString(time.toString()).substring(INDEX_3, INDEX_5);
        RString sec = new RString(time.toString()).substring(INDEX_6, INDEX_8);
        RString timeFormat = hour.concat("時").concat(min).concat("分").concat(sec).concat("秒");
        バッチ起動時処理日時 = new RString(RDate.getNowDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString().toString() + RString.HALF_SPACE + timeFormat);
    }

    @Override
    protected void defineFlow() {
        executeStep(収納状況把握情報の取得);
        executeStep(対象者把握情報の取得);
        executeStep(収納滞納状況把握情報の取得);
        executeStep(給付額減額滞納者把握情報取得);
    }

    /**
     * 収納状況把握情報の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(収納状況把握情報の取得)
    protected IBatchFlowCommand shunoJokyoHaakuProcess() {
        return loopBatch(ShunoJokyoHaakuProcess.class)
                .arguments(getParameter().toShunoJokyoHaakuProcessParameter()).define();
    }

    /**
     * 対象者把握情報の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(対象者把握情報の取得)
    protected IBatchFlowCommand kyufuGengakuHaakuListTaishoTokuteiProcess() {
        return loopBatch(KyufuGengakuHaakuListTaishoTokuteiProcess.class)
                .arguments(getParameter().toKyufuGengakuHaakuListTaishoTokuteiProcessParameter()).define();
    }

    /**
     * 収納滞納状況把握情報の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(収納滞納状況把握情報の取得)
    protected IBatchFlowCommand shunoTainoJokyoHaaku() {
        return loopBatch(ShunoTainoJokyoHaakuProcess.class)
                .arguments(getParameter().toShunoTainoJokyoHaakuProcessParameter()).define();
    }

    /**
     * 給付額減額滞納者把握情報取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(給付額減額滞納者把握情報取得)
    protected IBatchFlowCommand kyufuGengakuHaakuListSakusei() {
        return loopBatch(KyufuGengakuHaakuListSakuseiProcess.class)
                .arguments(getParameter().toKyufuGengakuHaakuListSakuseiProcessParameter(バッチ起動時処理日時)).define();
    }
}
