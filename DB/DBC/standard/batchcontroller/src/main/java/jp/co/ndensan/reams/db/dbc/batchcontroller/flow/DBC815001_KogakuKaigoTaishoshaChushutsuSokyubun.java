/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiChukanJigyoKogakuTmpProcess1;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiChukanJigyoKogakuTmpProcess2;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiChukanJigyoKogakuTmpProcess3;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiChukanKogakuTmpProcess7;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsSetaiinHaakuNyuryokuKogakuTmpProcess2;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess1;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess2;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess3;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsSetaiinShotokuHanteiMeisaiTmpProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.PrtErrorListJigyoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.UpdSetaiinHaakuNyuryokuKogakuTmpProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC815001.GaibuRenkeiDataoutputJohoDBUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC815001.KakobunJissekiKihonProcess1;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC815001.KakobunJissekiKihonProcess2;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC815001.KakobunJissekiKihonProcess3;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC815001.KakobunJissekiKihonProcess4;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC815001.KakobunJissekiKihonProcess6;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC815001.KakobunJissekiKihonProcess7;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC815001.KakobunJissekiKihonProcess8;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC815001.KakobunJissekiKihonProcessKunben2;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC815001.TaishoushaitiranhyouhakkouShori;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC020010.DBC020010_KogakuKaigoServicehiKyufutaishoshaTorokuParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC815001.DBC815001_KogakuKaigoTaishoshaChushutsuSokyubunParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.KogakuFlowReturnEntity;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.DBB002001.DBB002001_SetaiinHaakuParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMN41003_高額介護対象者抽出（遡及分）の処理
 *
 * @reamsid_L DBC-5750-030 wanghui
 */
public class DBC815001_KogakuKaigoTaishoshaChushutsuSokyubun
        extends BatchFlowBase<DBC815001_KogakuKaigoTaishoshaChushutsuSokyubunParameter> {

    private static final String 過去分実績基本抽出1 = "KakobunJissekiKihonProcess1";
    private static final String 過去分実績基本抽出2 = "KakobunJissekiKihonProcess2";
    private static final String 過去分実績基本抽出3 = "KakobunJissekiKihonProcess3";
    private static final String 過去分実績基本抽出4 = "KakobunJissekiKihonProcess4";
    private static final String 過去分実績基本抽出6 = "KakobunJissekiKihonProcess6";
    private static final String 過去分実績基本抽出7 = "KakobunJissekiKihonProcess7";
    private static final String 過去分実績基本抽出8 = "KakobunJissekiKihonProcessKunben2";
    private static final String 給付実績基本データ抽出 = "KakobunJissekiKihonProcess8";
    private static final String 世帯員把握フロー = "callSetaiShotokuKazeiHanteiFlow";
    private static final RString 世帯員把握BATCHID = new RString("DBB002001_SetaiinHaaku");
    private static final String 世帯員把握入力高額一時の作成2 = "callInsSetaiinHaakuNyuryokuKogakuTmpProcess2";
    private static final String 世帯員所得判定明細一時の作成 = "callInsSetaiinShotokuHanteiMeisaiTmpProcess";
    private static final String 世帯員所得判定明細事業高額一時１の作成 = "callInsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess1";
    private static final String 給付実績中間事業高額一時の作成１ = "callInsKyufuJissekiChukanJigyoKogakuTmpProcess1";
    private static final String 給付実績中間事業高額一時の作成2 = "callInsKyufuJissekiChukanJigyoKogakuTmpProcess2";
    private static final String 給付実績中間事業高額一時の作成3 = "callInsKyufuJissekiChukanJigyoKogakuTmpProcess3";
    private static final String 給付実績中間高額一時の作成7 = "callInsKyufuJissekiChukanKogakuTmpProcess7";
    private static final String 世帯員把握入力一時の更新 = "callUpdSetaiinHaakuNyuryokuKogakuTmpProcess";
    private static final String 世帯員所得判定明細事業高額一時の作成２ = "callInsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess2";
    private static final String 世帯員所得判定明細事業高額一時の作成３ = "callInsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess3";
    private static final String 事業高額エラーリストの発行 = "callPrtErrorListJigyoProcess";
    private static final String 給付実績中間事業高額一時の作成8 = "callInsKyufuJissekiChukanJigyoKogakuTmpProcess8";
    private static final String 事業高額介護サービス費追加 = "callInsJigyoKogakuKaigoServiceHiProcess";
    private static final String 事業高額介護サービス費一時の作成 = "callInsJigyoKogakuKaigoServiceHiTmpProcess";
    private static final String 処理日付管理マスタ更新 = "GaibuRenkeiDataoutputJohoDBUpdateProcess";
    private static final String 対象者一覧表発行処理 = "TaishoushaitiranhyouhakkouShori";
    private static final String 高額介護サービス費支給申請のバックアップ = "backupKogakuShikyuShinsei";
    private static final String 高額介護サービス費支給判定結果のバックアップ = "backupKogakuShikyuHanteiKekka";
    private static final String 高額介護サービス費支給審査決定のバックアップ = "backupKogakuShikyuShinsaKettei";
    private static final String 高額介護サービス費給付対象者合計のバックアップ = "backupKogakuKyufuTaishoshaGokei";
    private static final String 高額介護サービス費給付対象者明細のバックアップ = "backupKogakuKyufuTaishoshaMeisai";
    private static final RString TABLE_高額介護サービス費支給申請 = new RString("DbT3056KogakuShikyuShinsei");
    private static final RString TABLE_高額介護サービス費支給判定結果 = new RString("DbT3057KogakuShikyuHanteiKekka");
    private static final RString TABLE_高額介護サービス費支給審査決定 = new RString("DbT3058KogakuShikyuShinsaKettei");
    private static final RString TABLE_高額介護サービス費給付対象者合計 = new RString("DbT3055KogakuKyufuTaishoshaGokei");
    private static final RString TABLE_高額介護サービス費給付対象者明細 = new RString("DbT3054KogakuKyufuTaishoshaMeisai");
    private static final RString TABLE_事業高額介護サービス費支給申請全件一時 = new RString("TempJigyoKogakuShikyuShinseiZen");
    private static final RString TABLE_事業高額介護サービス費支給判定結果全件一時 = new RString("TempJigyoKogakuShikyuHanteiKekkaZen");
    private static final RString TABLE_事業高額介護サービス費支給審査決定全件一時 = new RString("TempJigyoKogakuShikyuShinsaKetteiZen");
    private static final RString TABLE_事業高額介護サービス費給付対象者合計全件一時 = new RString("TempJigyoKogakuKyufuTaishoshaGokeiZen");
    private static final RString TABLE_事業高額介護サービス費給付対象者明細全件一時 = new RString("TempJigyoKogakuKyufuTaishoshaMeisaiZen");
    private static final String 高額介護サービス費給付対象者登録フロー = "ShotokuKazeiHanteiFlow";
    private static final RString 高額介護サービス費給付対象者登録BATCHID = new RString("DBC020010_KogakuKaigoServicehiKyufutaishoshaToroku");
    private static final RString メニューID_高額介護サービス = new RString("DBCMN41002");
    private KogakuFlowReturnEntity kogakuFlowReturnEntity;
    private int カウントアップ;
    private static final RString 日付_1231 = new RString("1231");

    @Override
    protected void defineFlow() {
        executeStep(高額介護サービス費支給申請のバックアップ);
        executeStep(高額介護サービス費支給判定結果のバックアップ);
        executeStep(高額介護サービス費支給審査決定のバックアップ);
        executeStep(高額介護サービス費給付対象者合計のバックアップ);
        executeStep(高額介護サービス費給付対象者明細のバックアップ);
        executeStep(過去分実績基本抽出1);
        executeStep(過去分実績基本抽出2);
        executeStep(過去分実績基本抽出3);
        executeStep(過去分実績基本抽出4);
        executeStep(過去分実績基本抽出6);
        executeStep(過去分実績基本抽出7);
        executeStep(過去分実績基本抽出8);
        executeStep(給付実績基本データ抽出);
        executeStep(高額介護サービス費給付対象者登録フロー);
        executeStep(世帯員把握フロー);
        executeStep(世帯員把握入力高額一時の作成2);
        executeStep(世帯員把握フロー);
        executeStep(世帯員所得判定明細一時の作成);
        executeStep(世帯員所得判定明細事業高額一時１の作成);
        kogakuFlowReturnEntity = getResult(KogakuFlowReturnEntity.class, new RString(世帯員所得判定明細事業高額一時１の作成),
                InsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess1.FLOWENTITY);
        executeStep(給付実績中間事業高額一時の作成１);
        executeStep(給付実績中間事業高額一時の作成2);
        executeStep(給付実績中間事業高額一時の作成3);
        executeStep(給付実績中間高額一時の作成7);
        executeStep(世帯員把握入力一時の更新);
        executeStep(世帯員把握フロー);
        executeStep(世帯員所得判定明細一時の作成);
        executeStep(世帯員所得判定明細事業高額一時の作成２);
        if (kogakuFlowReturnEntity != null && !RString.isNullOrEmpty(kogakuFlowReturnEntity.get最小続柄コード参照年())
                && !RString.isNullOrEmpty(kogakuFlowReturnEntity.get最大続柄コード参照年())) {
            int 最小続柄コード参照年 = Integer.valueOf(kogakuFlowReturnEntity.get最小続柄コード参照年().toString().trim());
            int 最大続柄コード参照年 = Integer.valueOf(kogakuFlowReturnEntity.get最大続柄コード参照年().toString().trim());
            for (int i = 最小続柄コード参照年; i <= 最大続柄コード参照年; i++) {
                カウントアップ = i;
                executeStep(世帯員所得判定明細事業高額一時の作成３);
            }
        }
        executeStep(給付実績中間事業高額一時の作成8);
        executeStep(事業高額介護サービス費一時の作成);

        if (getParameter().isテスト出力()) {
            executeStep(対象者一覧表発行処理);
        }
        executeStep(事業高額エラーリストの発行);
        executeStep(事業高額介護サービス費追加);

        executeStep(処理日付管理マスタ更新);
    }

    /**
     * 事業高額介護サービス費支給申請のバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step(高額介護サービス費支給申請のバックアップ)
    protected IBatchFlowCommand backupJigyoKogakuShikyuShinsei() {
        return backupToTemporaryTable(TABLE_高額介護サービス費支給申請, TABLE_事業高額介護サービス費支給申請全件一時).
                define();
    }

    /**
     * 事業高額介護サービス費支給判定のバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step(高額介護サービス費支給判定結果のバックアップ)
    protected IBatchFlowCommand backupJigyoKogakuShikyuHanteiKekka() {
        return backupToTemporaryTable(TABLE_高額介護サービス費支給判定結果, TABLE_事業高額介護サービス費支給判定結果全件一時).
                define();
    }

    /**
     * 事業高額介護サービス費支給審査決定のバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step(高額介護サービス費支給審査決定のバックアップ)
    protected IBatchFlowCommand backupJigyoKogakuShikyuShinsaKettei() {
        return backupToTemporaryTable(TABLE_高額介護サービス費支給審査決定, TABLE_事業高額介護サービス費支給審査決定全件一時).
                define();
    }

    /**
     * 事業高額介護サービス費給付対象者合計のバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step(高額介護サービス費給付対象者合計のバックアップ)
    protected IBatchFlowCommand backupJigyoKogakuKyufuTaishoshaGokei() {
        return backupToTemporaryTable(TABLE_高額介護サービス費給付対象者合計, TABLE_事業高額介護サービス費給付対象者合計全件一時).
                define();
    }

    /**
     * 事業高額介護サービス費給付対象者明細のバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step(高額介護サービス費給付対象者明細のバックアップ)
    protected IBatchFlowCommand backupJigyoKogakuKyufuTaishoshaMeisai() {
        return backupToTemporaryTable(TABLE_高額介護サービス費給付対象者明細, TABLE_事業高額介護サービス費給付対象者明細全件一時).
                define();
    }

    @Step(過去分実績基本抽出1)
    IBatchFlowCommand kakobunJissekiKihonProcess1() {
        return loopBatch(KakobunJissekiKihonProcess1.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(過去分実績基本抽出2)
    IBatchFlowCommand kakobunJissekiKihonProcess2() {
        return loopBatch(KakobunJissekiKihonProcess2.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(過去分実績基本抽出3)
    IBatchFlowCommand kakobunJissekiKihonProcess3() {
        return loopBatch(KakobunJissekiKihonProcess3.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(過去分実績基本抽出4)
    IBatchFlowCommand kakobunJissekiKihonProcess4() {
        return loopBatch(KakobunJissekiKihonProcess4.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(過去分実績基本抽出6)
    IBatchFlowCommand kakobunJissekiKihonProcess6() {
        return loopBatch(KakobunJissekiKihonProcess6.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(過去分実績基本抽出7)
    IBatchFlowCommand kakobunJissekiKihonProcess7() {
        return loopBatch(KakobunJissekiKihonProcess7.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(過去分実績基本抽出8)
    IBatchFlowCommand kakobunJissekiKihonProcessKunben2() {
        return loopBatch(KakobunJissekiKihonProcessKunben2.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(給付実績基本データ抽出)
    IBatchFlowCommand kakobunJissekiKihonProcess8() {
        return loopBatch(KakobunJissekiKihonProcess8.class).arguments(getParameter().toProcessParameter()).define();
    }

    /**
     * 世帯員把握バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(高額介護サービス費給付対象者登録フロー)
    protected IBatchFlowCommand setaiShotokuKazeiHanteiFlow() {
        return otherBatchFlow(高額介護サービス費給付対象者登録BATCHID, SubGyomuCode.DBC介護給付,
                setparameter()).define();
    }

    /**
     * 世帯員把握バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(世帯員把握フロー)
    protected IBatchFlowCommand callSetaiShotokuKazeiHanteiFlow() {
        return otherBatchFlow(世帯員把握BATCHID, SubGyomuCode.DBB介護賦課,
                getSetaiShotokuKazeiHanteiBatchParameter()).define();
    }

    /**
     * 世帯員把握入力高額一時の作成2を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(世帯員把握入力高額一時の作成2)
    protected IBatchFlowCommand callInsSetaiinHaakuNyuryokuKogakuTmpProcess2() {
        return loopBatch(InsSetaiinHaakuNyuryokuKogakuTmpProcess2.class).define();
    }

    /**
     * 世帯員所得判定明細一時の作成を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(世帯員所得判定明細一時の作成)
    protected IBatchFlowCommand callInsSetaiinShotokuHanteiMeisaiTmpProcess() {
        return loopBatch(InsSetaiinShotokuHanteiMeisaiTmpProcess.class).define();
    }

    /**
     * 世帯員所得判定明細事業高額一時１の作成を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(世帯員所得判定明細事業高額一時１の作成)
    protected IBatchFlowCommand callInsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess1() {
        return loopBatch(InsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess1.class).define();
    }

    /**
     * 給付実績中間事業高額一時の作成１のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step(給付実績中間事業高額一時の作成１)
    protected IBatchFlowCommand callInsKyufuJissekiChukanJigyoKogakuTmpProcess1() {
        return loopBatch(InsKyufuJissekiChukanJigyoKogakuTmpProcess1.class).define();
    }

    /**
     * 給付実績中間事業高額一時の作成2のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step(給付実績中間事業高額一時の作成2)
    protected IBatchFlowCommand callInsKyufuJissekiChukanJigyoKogakuTmpProcess2() {
        return loopBatch(InsKyufuJissekiChukanJigyoKogakuTmpProcess2.class).define();
    }

    /**
     * 給付実績中間事業高額一時の作成3のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step(給付実績中間事業高額一時の作成3)
    protected IBatchFlowCommand callInsKyufuJissekiChukanJigyoKogakuTmpProcess3() {
        return simpleBatch(InsKyufuJissekiChukanJigyoKogakuTmpProcess3.class).define();
    }

    /**
     * 給付実績中間高額一時の作成7のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step(給付実績中間高額一時の作成7)
    protected IBatchFlowCommand callInsKyufuJissekiChukanKogakuTmpProcess7() {
        return loopBatch(InsKyufuJissekiChukanKogakuTmpProcess7.class).define();
    }

    /**
     * 世帯員把握入力一時の更新のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step(世帯員把握入力一時の更新)
    protected IBatchFlowCommand callUpdSetaiinHaakuNyuryokuKogakuTmpProcess() {
        return simpleBatch(UpdSetaiinHaakuNyuryokuKogakuTmpProcess.class).define();
    }

    /**
     * 世帯員所得判定明細事業高額一時の作成２のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step(世帯員所得判定明細事業高額一時の作成２)
    protected IBatchFlowCommand callInsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess2() {
        return loopBatch(InsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess2.class).define();
    }

    /**
     * 世帯員所得判定明細事業高額一時の作成３のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step(世帯員所得判定明細事業高額一時の作成３)
    protected IBatchFlowCommand callInsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess3() {
        return loopBatch(InsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess3.class).
                arguments(getKyufuJissekiKihonKogakuProcessParameter()).define();
    }

    /**
     * 事業高額エラーリストの発行のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step(事業高額エラーリストの発行)
    protected IBatchFlowCommand callPrtErrorListJigyoProcess() {
        return loopBatch(PrtErrorListJigyoProcess.class).arguments(getReportParameter()).define();
    }

    @Step(処理日付管理マスタ更新)
    IBatchFlowCommand gaibuRenkeiDataoutputJohoDBUpdateProcess() {
        return loopBatch(GaibuRenkeiDataoutputJohoDBUpdateProcess.class).arguments(getParameter().toProcessParameter()).define();
    }

    @Step(対象者一覧表発行処理)
    IBatchFlowCommand taishoushaitiranhyouhakkouShori() {
        return loopBatch(TaishoushaitiranhyouhakkouShori.class).arguments(getParameter().toProcessParameter()).define();
    }

    private KyufuJissekiKihonKogakuProcessParameter getKyufuJissekiKihonKogakuProcessParameter() {
        KyufuJissekiKihonKogakuProcessParameter proparameter = new KyufuJissekiKihonKogakuProcessParameter();
        proparameter.set続柄コード参照年(new FlexibleYear(new RString(カウントアップ)));
        proparameter.set処理年月日(new FlexibleDate(new RString(カウントアップ).concat(日付_1231)));
        return proparameter;
    }

    private DBB002001_SetaiinHaakuParameter getSetaiShotokuKazeiHanteiBatchParameter() {
        return new DBB002001_SetaiinHaakuParameter(SetaiinHaakuKanriShikibetsuKubun.賦課.getコード());
    }

    private DBC020010_KogakuKaigoServicehiKyufutaishoshaTorokuParameter setparameter() {
        DBC020010_KogakuKaigoServicehiKyufutaishoshaTorokuParameter toroparameter = new DBC020010_KogakuKaigoServicehiKyufutaishoshaTorokuParameter();
        toroparameter.setMenuId(メニューID_高額介護サービス);
        return toroparameter;
    }

    private KyufuJissekiKihonKogakuProcessParameter getReportParameter() {
        KyufuJissekiKihonKogakuProcessParameter kyuparameter = new KyufuJissekiKihonKogakuProcessParameter();
        kyuparameter.set出力順ID(new RString(getParameter().get出力順ID()));
        return kyuparameter;
    }
}
