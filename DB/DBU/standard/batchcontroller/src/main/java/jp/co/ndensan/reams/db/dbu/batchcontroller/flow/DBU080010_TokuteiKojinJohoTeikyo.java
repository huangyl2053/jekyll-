/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010.TokuteiKojinJohoHanKaiteiNoHanteiProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU080010.DBU080010_TokuteiKojinJohoTeikyoParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定個人情報提供のバッチフ処理クラスです
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
public class DBU080010_TokuteiKojinJohoTeikyo extends BatchFlowBase<DBU080010_TokuteiKojinJohoTeikyoParameter> {

    private static final String 版改定の判定 = "TokuteiKojinJohoHanKaiteiNoHantei";
    private static final RString 使用する = new RString("0");
    private static final RString 稼働 = new RString("1");
//    private static final int 年最後の月 = 3;
//    private static final int 年開始の月 = 4;
//    private static final int 年最後の日 = 31;
//    private static final int 西暦年最後の月 = 12;
//    private static final int 五年 = 5;
//    private ShinkiIdoKubun 新規異動区分;
//    private YMDHMS 対象開始日時;
//    private YMDHMS 対象終了日時;

    @Override
    protected void defineFlow() {
        YMDHMS システム日付 = YMDHMS.now();
        if (使用する.equals(DbBusinessConfig.get(ConfigNameDBU.番号制度_使用制御, システム日付.getDate()))
                && 稼働.equals(DbBusinessConfig.get(ConfigNameDBU.番号制度_提供機能使用制御, システム日付.getDate()))
                && システム日付.getDate().isBeforeOrEquals(new RDate(
                                DbBusinessConfig.get(ConfigNameDBU.番号制度_利用開始日, システム日付.getDate()).toString()))) {
            executeStep(版改定の判定);
//            int count_版番号 = getResult(Integer.class, new RString(版改定の判定),
//                    TokuteiKojinJohoHanKaiteiNoHanteiProcess.TOKUTEIKOJINJOHOHANKANRICOUNT);
//            if (count_版番号 == 0) {
//                新規異動区分 = ShinkiIdoKubun.当初;
//            } else {
//                新規異動区分 = ShinkiIdoKubun.版改定;
//            }
//            対象開始日時 = new YMDHMS(new RString(get抽出開始日時(システム日付).toString()).concat("000000"));
//            // TODO 上記「3.1-③」で取得した処理日付管理マスタ（異動用).対象終了日時
//            対象終了日時 = get抽出終了日時(システム日付, システム日付);
        }

    }

    /**
     * 版改定を判定します。
     *
     * @return IBatchFlowCommand
     */
    @Step(版改定の判定)
    protected IBatchFlowCommand exeHanKanriNoHantei() {
        return simpleBatch(TokuteiKojinJohoHanKaiteiNoHanteiProcess.class).define();
    }
//
//    private RDate get抽出開始日時(YMDHMS システム日付) {
//        RDate 抽出開始日時;
//        if (年開始の月 <= システム日付.getMonthValue() || システム日付.getMonthValue() <= 西暦年最後の月) {
//            抽出開始日時 = new RDate(システム日付.getMonthValue() + 1, 年最後の月, 年最後の日);
//        } else {
//            抽出開始日時 = new RDate(システム日付.getMonthValue(), 年最後の月, 年最後の日);
//        }
//        return 抽出開始日時.minusYear(五年);
//    }
//
//    private YMDHMS get抽出終了日時(YMDHMS 異動用対象終了日時, YMDHMS システム日付) {
//        if (異動用対象終了日時 == null) {
//            return システム日付;
//        } else {
//            return 異動用対象終了日時;
//        }
//    }
}
