  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.DelSaishoriJigyoKogakuTmpProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.DelSaishoriKogakuTmpProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsHihokenshaDaichoTmpProcess1;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsHihokenshaDaichoTmpProcess2;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsJigyoKogakuKaigoServiceHiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsJigyoKogakuKaigoServiceHiTmpProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKijunShunyugakuTekiyoKanriTmpProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKogakuKaigoServiceHiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKogakuKaigoServiceHiTmpProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyokaisoGaitoshaTmpProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiChukanJigyoKogakuTmpProcess1;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiChukanJigyoKogakuTmpProcess2;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiChukanJigyoKogakuTmpProcess3;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiChukanJigyoKogakuTmpProcess5;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiChukanJigyoKogakuTmpProcess7;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiChukanJigyoKogakuTmpProcess8;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiChukanKogakuTmpProcess1;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiChukanKogakuTmpProcess2;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiChukanKogakuTmpProcess3;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiChukanKogakuTmpProcess5;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiChukanKogakuTmpProcess7;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiChukanKogakuTmpProcess8;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiKihonJigyoKogakuTmpProcess1;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiKihonJigyoKogakuTmpProcess2;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiKihonJigyoKogakuTmpProcess3;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiKihonJigyoKogakuTmpProcess4;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiKihonKogakuTmpProcess1;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiKihonKogakuTmpProcess2;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiKihonKogakuTmpProcess3;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiKihonKogakuTmpProcess4;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiShafukuKeigenTmpProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsKyufuJissekiShukeiTmpProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsSetaiinHaakuNyuryokuJigyoKogakuTmpProcess1;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsSetaiinHaakuNyuryokuJigyoKogakuTmpProcess2;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsSetaiinHaakuNyuryokuKogakuTmpProcess1;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsSetaiinHaakuNyuryokuKogakuTmpProcess2;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess1;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess2;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess3;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsSetaiinShotokuHanteiMeisaiKogakuTmpProcess1;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsSetaiinShotokuHanteiMeisaiKogakuTmpProcess2;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsSetaiinShotokuHanteiMeisaiKogakuTmpProcess3;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsSetaiinShotokuHanteiMeisaiTmpProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.InsShiharaiHohoHenkoKanriTmpProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.PrtErrorListJigyoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.PrtErrorListKogakuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.PrtTaishoshaIchiranJigyoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.PrtTaishoshaIchiranKogakuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.UpdJigyoKKogakuKokuhorenIFMstProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.UpdKogakuKokuhorenIFMstProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.UpdKyufuJissekiChukanJigyoKogakuTmpProcess5;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.UpdKyufuJissekiChukanJigyoKogakuTmpProcess5_2;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.UpdKyufuJissekiChukanJigyoKogakuTmpProcess5_3;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.UpdKyufuJissekiChukanKogakuTmpProcess5;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010.UpdSetaiinHaakuNyuryokuKogakuTmpProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC020010.DBC020010_KogakuKaigoServicehiKyufutaishoshaTorokuParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.shorijotaikubun.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020010.KogakuKaigoServicehiKyufutaishoshaTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigokyufuhitaishoshatoroku.KogakuKaigoKyufuhiTaishoshaTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufutaishoshatoroku.InsKyufuJissekiKihonKogakuTmpProcess4Param;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.InsSetaiinHaakuNyuryokuKogakuFlowEntity1;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.KogakuFlowReturnEntity;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.DBB002001.DBB002001_SetaiinHaakuParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 高額介護サービス費給付対象者登録のバッチフロークラスです。
 *
 * @reamsid_L DBC-2010-040 tianshuai
 */
public class DBC020010_KogakuKaigoServicehiKyufutaishoshaToroku extends BatchFlowBase<DBC020010_KogakuKaigoServicehiKyufutaishoshaTorokuParameter> {

    private static final RString メニューID_高額介護サービス = new RString("DBCMN41002");
    private static final RString メニューID_事業高額介護サービス = new RString("DBCMNL1002");
    private static final RString 世帯員把握BATCHID = new RString("DBB002001_SetaiinHaaku");
    private static final String 高額介護サービス費支給申請のバックアップ = "backupKogakuShikyuShinsei";
    private static final String 高額介護サービス費支給判定結果のバックアップ = "backupKogakuShikyuHanteiKekka";
    private static final String 高額介護サービス費支給審査決定のバックアップ = "backupKogakuShikyuShinsaKettei";
    private static final String 高額介護サービス費給付対象者合計のバックアップ = "backupKogakuKyufuTaishoshaGokei";
    private static final String 高額介護サービス費給付対象者明細のバックアップ = "backupKogakuKyufuTaishoshaMeisai";
    private static final String 事業高額介護サービス費支給申請のバックアップ = "backupJigyoKogakuShikyuShinsei";
    private static final String 事業高額介護サービス費支給判定のバックアップ = "backupJigyoKogakuShikyuHanteiKekka";
    private static final String 事業高額介護サービス費支給審査決定のバックアップ = "backupJigyoKogakuShikyuShinsaKettei";
    private static final String 事業高額介護サービス費給付対象者合計のバックアップ = "backupJigyoKogakuKyufuTaishoshaGokei";
    private static final String 事業高額介護サービス費給付対象者明細のバックアップ = "backupJigyoKogakuKyufuTaishoshaMeisai";
    private static final String 給付実績基本データのバックアップ1 = "callInsKyufuJissekiKihonKogakuTmpProcess1";
    private static final String 給付実績基本データのバックアップ2 = "callInsKyufuJissekiKihonKogakuTmpProcess2";
    private static final String 事業給付実績基本データのバックアップ1 = "callInsKyufuJissekiKihonJigyoKogakuTmpProcess1";
    private static final String 事業給付実績基本データのバックアップ2 = "callInsKyufuJissekiKihonJigyoKogakuTmpProcess2";
    private static final String 被保険者台帳のバックアップ1 = "callInsHihokenshaDaichoTmpProcess1";
    private static final String 被保険者台帳のバックアップ2 = "callInsHihokenshaDaichoTmpProcess2";
    private static final String 支払方法変更管理のバックアップ = "callInsShiharaiHohoHenkoKanriTmpProcess";
    private static final String 境界層該当者のバックアップ = "callInsKyokaisoGaitoshaTmpProcess";
    private static final String 前回処理対象高額データの削除 = "callDelSaishoriKogakuTmpProcess";
    private static final String 前回処理対象事業高額データの削除 = "callDelSaishoriJigyoKogakuTmpProcess";
    private static final String 給付実績基本情報高額一時３の作成 = "callInsKyufuJissekiKihonKogakuTmpProcess3";
    private static final String 給付実績基本情報事業高額一時３の作成 = "callInsKyufuJissekiKihonJigyoKogakuTmpProcess3";
    private static final String 高額用世帯員把握入力一時の作成１ = "callInsSetaiinHaakuNyuryokuKogakuTmpProcess1";
    private static final String 事業高額用世帯員把握入力一時の作成１ = "callInsSetaiinHaakuNyuryokuJigyoKogakuTmpProcess1";
    private static final String 給付実績基本情報高額一時４の作成 = "callInsKyufuJissekiKihonKogakuTmpProcess4";
    private static final String 給付実績基本情報事業高額一時４の作成 = "callInsKyufuJissekiKihonJigyoKogakuTmpProcess4";
    private static final String 世帯員把握フロー = "callSetaiShotokuKazeiHanteiFlow";
    private static final String 世帯員把握入力高額一時の作成2 = "callInsSetaiinHaakuNyuryokuKogakuTmpProcess2";
    private static final String 世帯員把握入力事業高額一時の作成2 = "callInsSetaiinHaakuNyuryokuJigyoKogakuTmpProcess2";
    private static final String 世帯員所得判定明細一時の作成 = "callInsSetaiinShotokuHanteiMeisaiTmpProcess";
    private static final String 世帯員所得判定明細高額一時１の作成 = "callInsSetaiinShotokuHanteiMeisaiKogakuTmpProcess1";
    private static final String 世帯員所得判定明細事業高額一時１の作成 = "callInsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess1";
    private static final String 給付実績中間高額一時の作成１ = "callInsKyufuJissekiChukanKogakuTmpProcess1";
    private static final String 給付実績中間高額一時の作成2 = "callInsKyufuJissekiChukanKogakuTmpProcess2";
    private static final String 給付実績中間高額一時の作成3 = "callInsKyufuJissekiChukanKogakuTmpProcess3";
    private static final String 給付実績中間事業高額一時の作成１ = "callInsKyufuJissekiChukanJigyoKogakuTmpProcess1";
    private static final String 給付実績中間事業高額一時の作成2 = "callInsKyufuJissekiChukanJigyoKogakuTmpProcess2";
    private static final String 給付実績中間事業高額一時の作成3 = "callInsKyufuJissekiChukanJigyoKogakuTmpProcess3";
    private static final String 給付実績中間高額一時の作成5 = "callInsKyufuJissekiChukanKogakuTmpProcess5";
    private static final String 給付実績中間高額一時の更新１ = "callUpdKyufuJissekiChukanKogakuTmpProcess5";
    private static final String 給付実績中間事業高額一時の作成5 = "callInsKyufuJissekiChukanJigyoKogakuTmpProcess5";
    private static final String 給付実績中間事業高額一時の更新１ = "callUpdKyufuJissekiChukanJigyoKogakuTmpProcess5";
    private static final String 給付実績中間事業高額一時の更新２ = "callUpdKyufuJissekiChukanJigyoKogakuTmpProcess5_2";
    private static final String 給付実績中間事業高額一時の更新３ = "callUpdKyufuJissekiChukanJigyoKogakuTmpProcess5_3";
    private static final String 給付実績集計のバックアップ = "callInsKyufuJissekiShukeiTmpProcess";
    private static final String 給付実績社会福祉法人軽減額のバックアップ = "callInsKyufuJissekiShafukuKeigenTmpProcess";
    private static final String 基準収入額適用管理のバックアップ = "callInsKijunShunyugakuTekiyoKanriTmpProcess";
    private static final String 給付実績中間高額一時の作成7 = "callInsKyufuJissekiChukanKogakuTmpProcess7";
    private static final String 給付実績中間事業高額一時の作成7 = "callInsKyufuJissekiChukanJigyoKogakuTmpProcess7";
    private static final String 世帯員把握入力一時の更新 = "callUpdSetaiinHaakuNyuryokuKogakuTmpProcess";
    private static final String 世帯員所得判定明細高額一時の作成２ = "callInsSetaiinShotokuHanteiMeisaiKogakuTmpProcess2";
    private static final String 世帯員所得判定明細事業高額一時の作成２ = "callInsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess2";
    private static final String 世帯員所得判定明細高額一時の作成３ = "callInsSetaiinShotokuHanteiMeisaiKogakuTmpProcess3";
    private static final String 世帯員所得判定明細事業高額一時の作成３ = "callInsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess3";
    private static final String 給付実績中間高額一時の作成8 = "callInsKyufuJissekiChukanKogakuTmpProcess8";
    private static final String 給付実績中間事業高額一時の作成8 = "callInsKyufuJissekiChukanJigyoKogakuTmpProcess8";
    private static final String 高額介護サービス費一時の作成 = "callInsKogakuKaigoServiceHiTmpProcess";
    private static final String 事業高額介護サービス費一時の作成 = "callInsJigyoKogakuKaigoServiceHiTmpProcess";
    private static final String 高額対象者一覧表発行処理 = "callPrtTaishoshaIchiranJigyoProcess";
    private static final String 事業高額対象者一覧表発行処理 = "callPrtTaishoshaIchiranKogakuProcess";
    private static final String 高額エラーリストの発行 = "callPrtErrorListKogakuProcess";
    private static final String 事業高額エラーリストの発行 = "callPrtErrorListJigyoProcess";
    private static final String 高額国保連ＩＦマスタ更新 = "callUpdKogakuKokuhorenIFMstProcess";
    private static final String 事業高額国保連ＩＦマスタ更新 = "callUpdJigyoKKogakuKokuhorenIFMstProcess";
    private static final String 高額介護サービス費追加 = "callInsKogakuKaigoServiceHiProcess";
    private static final String 事業高額介護サービス費追加 = "callInsJigyoKogakuKaigoServiceHiProcess";
    private static final RString TABLE_高額介護サービス費支給申請 = new RString("DbT3056KogakuShikyuShinsei");
    private static final RString TABLE_高額介護サービス費支給判定結果 = new RString("DbT3057KogakuShikyuHanteiKekka");
    private static final RString TABLE_高額介護サービス費支給審査決定 = new RString("DbT3058KogakuShikyuShinsaKettei");
    private static final RString TABLE_高額介護サービス費給付対象者合計 = new RString("DbT3055KogakuKyufuTaishoshaGokei");
    private static final RString TABLE_高額介護サービス費給付対象者明細 = new RString("DbT3054KogakuKyufuTaishoshaMeisai");
    private static final RString TABLE_事業高額介護サービス費支給申請 = new RString("DbT3110JigyoKogakuShikyuShinsei");
    private static final RString TABLE_事業高額介護サービス費支給判定 = new RString("DbT3111JigyoKogakuShikyuHanteiKekka");
    private static final RString TABLE_事業高額介護サービス費支給審査決定 = new RString("DbT3112KogakuShikyuShinsaKettei");
    private static final RString TABLE_事業高額介護サービス費給付対象者合計 = new RString("DbT3109JigyoKogakuKyufuTaishoshaGokei");
    private static final RString TABLE_事業高額介護サービス費給付対象者明細 = new RString("DbT3108JigyoKogakuKyufuTaishoshaMeisai");
    private static final RString TABLE_高額介護サービス費支給申請全件一時 = new RString("TempKogakuShikyuShinseiZen");
    private static final RString TABLE_高額介護サービス費支給判定結果全件一時 = new RString("TempKogakuShikyuHanteiKekkaZen");
    private static final RString TABLE_高額介護サービス費支給審査決定全件一時 = new RString("TempKogakuShikyuShinsaKetteiZen");
    private static final RString TABLE_高額介護サービス費給付対象者合計全件一時 = new RString("TempKogakuKyufuTaishoshaGokeiZen");
    private static final RString TABLE_高額介護サービス費給付対象者明細全件一時 = new RString("TempKogakuKyufuTaishoshaMeisaiZen");
    private static final RString TABLE_事業高額介護サービス費支給申請全件一時 = new RString("TempJigyoKogakuShikyuShinseiZen");
    private static final RString TABLE_事業高額介護サービス費支給判定結果全件一時 = new RString("TempJigyoKogakuShikyuHanteiKekkaZen");
    private static final RString TABLE_事業高額介護サービス費支給審査決定全件一時 = new RString("TempJigyoKogakuShikyuShinsaKetteiZen");
    private static final RString TABLE_事業高額介護サービス費給付対象者合計全件一時 = new RString("TempJigyoKogakuKyufuTaishoshaGokeiZen");
    private static final RString TABLE_事業高額介護サービス費給付対象者明細全件一時 = new RString("TempJigyoKogakuKyufuTaishoshaMeisaiZen");
    private static final RString 日付_1231 = new RString("1231");

    private InsSetaiinHaakuNyuryokuKogakuFlowEntity1 returnEntity;
    private KogakuFlowReturnEntity kogakuFlowReturnEntity;
    private YMDHMS 処理日時;
    private int カウントアップ;

    @Override
    protected void initialize() {
        処理日時 = YMDHMS.now();
    }

    @Override
    protected void defineFlow() {
        if (is高額介護サービス(getParameter().getMenuId())) {
            executeStep(高額介護サービス費支給申請のバックアップ);
            executeStep(高額介護サービス費支給判定結果のバックアップ);
            executeStep(高額介護サービス費支給審査決定のバックアップ);
            executeStep(高額介護サービス費給付対象者合計のバックアップ);
            executeStep(高額介護サービス費給付対象者明細のバックアップ);
            executeStep(給付実績基本データのバックアップ1);
            executeStep(給付実績基本データのバックアップ2);
            executeStep(被保険者台帳のバックアップ1);
            executeStep(被保険者台帳のバックアップ2);
            executeStep(支払方法変更管理のバックアップ);
            executeStep(境界層該当者のバックアップ);
            if (ShoriJotaiKubun.再処理前.getコード().equals(getParameter().getShoriStateKubun())) {
                executeStep(前回処理対象高額データの削除);
            }
            executeStep(給付実績基本情報高額一時３の作成);
            executeStep(高額用世帯員把握入力一時の作成１);
            returnEntity = getResult(InsSetaiinHaakuNyuryokuKogakuFlowEntity1.class, new RString(高額用世帯員把握入力一時の作成１),
                    InsSetaiinHaakuNyuryokuKogakuTmpProcess1.PARAMETER_OUT_RETURNENTITY);
            if (returnEntity == null) {
                return;
            }
            executeStep(給付実績基本情報高額一時４の作成);
            executeStep(世帯員把握フロー);
            executeStep(世帯員把握入力高額一時の作成2);
            executeStep(世帯員把握フロー);
            executeStep(世帯員所得判定明細一時の作成);
            executeStep(世帯員所得判定明細高額一時１の作成);
            kogakuFlowReturnEntity = getResult(KogakuFlowReturnEntity.class, new RString(世帯員所得判定明細高額一時１の作成),
                    InsSetaiinShotokuHanteiMeisaiKogakuTmpProcess1.FLOWENTITY);
            executeStep(給付実績中間高額一時の作成１);
            executeStep(給付実績中間高額一時の作成2);
            executeStep(給付実績中間高額一時の作成3);
            executeStep(給付実績中間高額一時の作成5);
            executeStep(給付実績中間高額一時の更新１);
            executeStep(給付実績集計のバックアップ);
            executeStep(給付実績社会福祉法人軽減額のバックアップ);
            executeStep(基準収入額適用管理のバックアップ);
            executeStep(給付実績中間高額一時の作成7);
            executeStep(世帯員把握入力一時の更新);
            executeStep(世帯員把握フロー);
            executeStep(世帯員所得判定明細一時の作成);
            executeStep(世帯員所得判定明細高額一時の作成２);
            if (kogakuFlowReturnEntity != null
                    && !RString.isNullOrEmpty(kogakuFlowReturnEntity.get最小続柄コード参照年())
                    && !RString.isNullOrEmpty(kogakuFlowReturnEntity.get最大続柄コード参照年())) {
                int 最小続柄コード参照年 = Integer.valueOf(kogakuFlowReturnEntity.get最小続柄コード参照年().toString().trim());
                int 最大続柄コード参照年 = Integer.valueOf(kogakuFlowReturnEntity.get最大続柄コード参照年().toString().trim());
                for (int i = 最小続柄コード参照年; i <= 最大続柄コード参照年; i++) {
                    カウントアップ = i;
                    executeStep(世帯員所得判定明細高額一時の作成３);
                }
            }
            executeStep(給付実績中間高額一時の作成8);
            executeStep(高額介護サービス費一時の作成);
            if (getParameter().isShuturyokuFlg()) {
                executeStep(高額対象者一覧表発行処理);
            }
            executeStep(高額エラーリストの発行);
            executeStep(高額国保連ＩＦマスタ更新);
            executeStep(高額介護サービス費追加);
        } else if (is事業高額介護サービス(getParameter().getMenuId())) {
            executeStep(事業高額介護サービス費支給申請のバックアップ);
            executeStep(事業高額介護サービス費支給判定のバックアップ);
            executeStep(事業高額介護サービス費支給審査決定のバックアップ);
            executeStep(事業高額介護サービス費給付対象者合計のバックアップ);
            executeStep(事業高額介護サービス費給付対象者明細のバックアップ);
            executeStep(事業給付実績基本データのバックアップ1);
            executeStep(事業給付実績基本データのバックアップ2);
            executeStep(被保険者台帳のバックアップ1);
            executeStep(被保険者台帳のバックアップ2);
            executeStep(支払方法変更管理のバックアップ);
            executeStep(境界層該当者のバックアップ);
            if (ShoriJotaiKubun.再処理前.getコード().equals(getParameter().getShoriStateKubun())) {
                executeStep(前回処理対象事業高額データの削除);
            }
            executeStep(給付実績基本情報事業高額一時３の作成);
            executeStep(事業高額用世帯員把握入力一時の作成１);
            returnEntity = getResult(InsSetaiinHaakuNyuryokuKogakuFlowEntity1.class, new RString(事業高額用世帯員把握入力一時の作成１),
                    InsSetaiinHaakuNyuryokuJigyoKogakuTmpProcess1.PARAMETER_OUT_RETURNENTITY);
            if (returnEntity == null) {
                return;
            }
            executeStep(給付実績基本情報事業高額一時４の作成);
            executeStep(世帯員把握フロー);
            executeStep(世帯員把握入力事業高額一時の作成2);
            executeStep(世帯員把握フロー);
            executeStep(世帯員所得判定明細一時の作成);
            executeStep(世帯員所得判定明細事業高額一時１の作成);
            kogakuFlowReturnEntity = getResult(KogakuFlowReturnEntity.class, new RString(世帯員所得判定明細事業高額一時１の作成),
                    InsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess1.FLOWENTITY);
            executeStep(給付実績中間事業高額一時の作成１);
            executeStep(給付実績中間事業高額一時の作成2);
            executeStep(給付実績中間事業高額一時の作成3);
            executeStep(給付実績中間事業高額一時の作成5);
            executeStep(給付実績中間事業高額一時の更新１);
            executeStep(給付実績中間事業高額一時の更新２);
            executeStep(給付実績中間事業高額一時の更新３);
            executeStep(給付実績集計のバックアップ);
            executeStep(給付実績社会福祉法人軽減額のバックアップ);
            executeStep(基準収入額適用管理のバックアップ);
            executeStep(給付実績中間事業高額一時の作成7);
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
            if (getParameter().isShuturyokuFlg()) {
                executeStep(事業高額対象者一覧表発行処理);
            }
            executeStep(事業高額エラーリストの発行);
            executeStep(事業高額国保連ＩＦマスタ更新);
            executeStep(事業高額介護サービス費追加);
        }
    }

    /**
     * 高額介護サービス費支給申請のバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (高額介護サービス費支給申請のバックアップ)
    protected IBatchFlowCommand backupKogakuShikyuShinsei() {
        return backupToTemporaryTable(TABLE_高額介護サービス費支給申請, TABLE_高額介護サービス費支給申請全件一時).
                define();
    }

    /**
     * 高額介護サービス費支給判定結果のバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (高額介護サービス費支給判定結果のバックアップ)
    protected IBatchFlowCommand backupKogakuShikyuHanteiKekka() {
        return backupToTemporaryTable(TABLE_高額介護サービス費支給判定結果, TABLE_高額介護サービス費支給判定結果全件一時).
                define();
    }

    /**
     * 高額介護サービス費支給審査決定のバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (高額介護サービス費支給審査決定のバックアップ)
    protected IBatchFlowCommand backupKogakuShikyuShinsaKettei() {
        return backupToTemporaryTable(TABLE_高額介護サービス費支給審査決定, TABLE_高額介護サービス費支給審査決定全件一時).
                define();
    }

    /**
     * 高額介護サービス費給付対象者合計のバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (高額介護サービス費給付対象者合計のバックアップ)
    protected IBatchFlowCommand backupKogakuKyufuTaishoshaGokei() {
        return backupToTemporaryTable(TABLE_高額介護サービス費給付対象者合計, TABLE_高額介護サービス費給付対象者合計全件一時).
                define();
    }

    /**
     * 高額介護サービス費給付対象者明細のバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (高額介護サービス費給付対象者明細のバックアップ)
    protected IBatchFlowCommand backupKogakuKyufuTaishoshaMeisai() {
        return backupToTemporaryTable(TABLE_高額介護サービス費給付対象者明細, TABLE_高額介護サービス費給付対象者明細全件一時).
                define();
    }

    /**
     * 事業高額介護サービス費支給申請のバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (事業高額介護サービス費支給申請のバックアップ)
    protected IBatchFlowCommand backupJigyoKogakuShikyuShinsei() {
        return backupToTemporaryTable(TABLE_事業高額介護サービス費支給申請, TABLE_事業高額介護サービス費支給申請全件一時).
                define();
    }

    /**
     * 事業高額介護サービス費支給判定のバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (事業高額介護サービス費支給判定のバックアップ)
    protected IBatchFlowCommand backupJigyoKogakuShikyuHanteiKekka() {
        return backupToTemporaryTable(TABLE_事業高額介護サービス費支給判定, TABLE_事業高額介護サービス費支給判定結果全件一時).
                define();
    }

    /**
     * 事業高額介護サービス費支給審査決定のバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (事業高額介護サービス費支給審査決定のバックアップ)
    protected IBatchFlowCommand backupJigyoKogakuShikyuShinsaKettei() {
        return backupToTemporaryTable(TABLE_事業高額介護サービス費支給審査決定, TABLE_事業高額介護サービス費支給審査決定全件一時).
                define();
    }

    /**
     * 事業高額介護サービス費給付対象者合計のバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (事業高額介護サービス費給付対象者合計のバックアップ)
    protected IBatchFlowCommand backupJigyoKogakuKyufuTaishoshaGokei() {
        return backupToTemporaryTable(TABLE_事業高額介護サービス費給付対象者合計, TABLE_事業高額介護サービス費給付対象者合計全件一時).
                define();
    }

    /**
     * 事業高額介護サービス費給付対象者明細のバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (事業高額介護サービス費給付対象者明細のバックアップ)
    protected IBatchFlowCommand backupJigyoKogakuKyufuTaishoshaMeisai() {
        return backupToTemporaryTable(TABLE_事業高額介護サービス費給付対象者明細, TABLE_事業高額介護サービス費給付対象者明細全件一時).
                define();
    }

    /**
     * 給付実績基本データのバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績基本データのバックアップ1)
    protected IBatchFlowCommand callInsKyufuJissekiKihonKogakuTmpProcess1() {
        return loopBatch(InsKyufuJissekiKihonKogakuTmpProcess1.class).arguments(setParameter()).define();
    }

    /**
     * 給付実績基本データのバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績基本データのバックアップ2)
    protected IBatchFlowCommand callInsKyufuJissekiKihonKogakuTmpProcess2() {
        return loopBatch(InsKyufuJissekiKihonKogakuTmpProcess2.class).arguments(setParameter()).define();
    }

    /**
     * 給付実績基本データのバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (事業給付実績基本データのバックアップ1)
    protected IBatchFlowCommand callInsKyufuJissekiKihonJigyoKogakuTmpProcess1() {
        return loopBatch(InsKyufuJissekiKihonJigyoKogakuTmpProcess1.class).arguments(setParameter()).define();
    }

    /**
     * 給付実績基本データのバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (事業給付実績基本データのバックアップ2)
    protected IBatchFlowCommand callInsKyufuJissekiKihonJigyoKogakuTmpProcess2() {
        return loopBatch(InsKyufuJissekiKihonJigyoKogakuTmpProcess2.class).arguments(setParameter()).define();
    }

    /**
     * 被保険者台帳のバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (被保険者台帳のバックアップ1)
    protected IBatchFlowCommand callInsHihokenshaDaichoTmpProcess1() {
        return loopBatch(InsHihokenshaDaichoTmpProcess1.class).define();
    }

    /**
     * 被保険者台帳のバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (被保険者台帳のバックアップ2)
    protected IBatchFlowCommand callInsHihokenshaDaichoTmpProcess2() {
        return loopBatch(InsHihokenshaDaichoTmpProcess2.class).define();
    }

    /**
     * 支払方法変更管理のバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (支払方法変更管理のバックアップ)
    protected IBatchFlowCommand callInsShiharaiHohoHenkoKanriTmpProcess() {
        return loopBatch(InsShiharaiHohoHenkoKanriTmpProcess.class).define();
    }

    /**
     * 境界層該当者のバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (境界層該当者のバックアップ)
    protected IBatchFlowCommand callInsKyokaisoGaitoshaTmpProcess() {
        return loopBatch(InsKyokaisoGaitoshaTmpProcess.class).define();
    }

    /**
     * 前回処理対象高額データの削除のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (前回処理対象高額データの削除)
    protected IBatchFlowCommand callDelSaishoriKogakuTmpProcess() {
        return simpleBatch(DelSaishoriKogakuTmpProcess.class).
                arguments(getDelSaishoriKogakuTmpProcessParameter()).define();
    }

    /**
     * 前回処理対象事業高額データの削除のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (前回処理対象事業高額データの削除)
    protected IBatchFlowCommand callDelSaishoriJigyoKogakuTmpProcess() {
        return simpleBatch(DelSaishoriJigyoKogakuTmpProcess.class).
                arguments(getDelSaishoriKogakuTmpProcessParameter()).define();
    }

    /**
     * 給付実績基本情報高額一時３の作成のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績基本情報高額一時３の作成)
    protected IBatchFlowCommand callInsKyufuJissekiKihonKogakuTmpProcess3() {
        return loopBatch(InsKyufuJissekiKihonKogakuTmpProcess3.class).define();
    }

    /**
     * 給付実績基本情報高額一時３の作成のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績基本情報事業高額一時３の作成)
    protected IBatchFlowCommand callInsKyufuJissekiKihonJigyoKogakuTmpProcess3() {
        return loopBatch(InsKyufuJissekiKihonJigyoKogakuTmpProcess3.class).define();
    }

    /**
     * 高額用世帯員把握入力一時の作成１の作成のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (高額用世帯員把握入力一時の作成１)
    protected IBatchFlowCommand callInsSetaiinHaakuNyuryokuKogakuTmpProcess1() {
        return loopBatch(InsSetaiinHaakuNyuryokuKogakuTmpProcess1.class).define();
    }

    /**
     * 事業高額用世帯員把握入力一時の作成１の作成のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (事業高額用世帯員把握入力一時の作成１)
    protected IBatchFlowCommand callInsJigyoKogakuSetaiinHaakuNyuryokuTmpProcess() {
        return loopBatch(InsSetaiinHaakuNyuryokuJigyoKogakuTmpProcess1.class).define();
    }

    /**
     * 給付実績基本情報高額一時４の作成のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績基本情報高額一時４の作成)
    protected IBatchFlowCommand callInsKyufuJissekiKihonKogakuTmpProcess4() {
        return loopBatch(InsKyufuJissekiKihonKogakuTmpProcess4.class)
                .arguments(get給付実績基本情報高額一時４バッチパラメータ())
                .define();
    }

    /**
     * 給付実績基本情報事業高額一時４の作成のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績基本情報事業高額一時４の作成)
    protected IBatchFlowCommand callInsKyufuJissekiKihonJigyoKogakuTmpProcess4() {
        return loopBatch(InsKyufuJissekiKihonJigyoKogakuTmpProcess4.class)
                .arguments(get給付実績基本情報高額一時４バッチパラメータ())
                .define();
    }

    /**
     * 世帯員把握バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step (世帯員把握フロー)
    protected IBatchFlowCommand callSetaiShotokuKazeiHanteiFlow() {
        return otherBatchFlow(世帯員把握BATCHID, SubGyomuCode.DBB介護賦課,
                getSetaiShotokuKazeiHanteiBatchParameter()).define();
    }

    /**
     * 世帯員把握入力高額一時の作成2を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step (世帯員把握入力高額一時の作成2)
    protected IBatchFlowCommand callInsSetaiinHaakuNyuryokuKogakuTmpProcess2() {
        return loopBatch(InsSetaiinHaakuNyuryokuKogakuTmpProcess2.class).define();
    }

    /**
     * 世帯員把握入力事業高額一時の作成2を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step (世帯員把握入力事業高額一時の作成2)
    protected IBatchFlowCommand callInsSetaiinHaakuNyuryokuJigyoKogakuTmpProcess2() {
        return loopBatch(InsSetaiinHaakuNyuryokuJigyoKogakuTmpProcess2.class).define();
    }

    /**
     * 世帯員所得判定明細一時の作成を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step (世帯員所得判定明細一時の作成)
    protected IBatchFlowCommand callInsSetaiinShotokuHanteiMeisaiTmpProcess() {
        return loopBatch(InsSetaiinShotokuHanteiMeisaiTmpProcess.class).define();
    }

    /**
     * 世帯員所得判定明細高額一時１の作成を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step (世帯員所得判定明細高額一時１の作成)
    protected IBatchFlowCommand callInsSetaiinShotokuHanteiMeisaiKogakuTmpProcess1() {
        return loopBatch(InsSetaiinShotokuHanteiMeisaiKogakuTmpProcess1.class).define();
    }

    /**
     * 世帯員所得判定明細事業高額一時１の作成を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step (世帯員所得判定明細事業高額一時１の作成)
    protected IBatchFlowCommand callInsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess1() {
        return loopBatch(InsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess1.class).define();
    }

    /**
     * 給付実績中間高額一時の作成１のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績中間高額一時の作成１)
    protected IBatchFlowCommand callInsKyufuJissekiChukanKogakuTmpProcess1() {
        return loopBatch(InsKyufuJissekiChukanKogakuTmpProcess1.class).define();
    }

    /**
     * 給付実績中間高額一時の作成2のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績中間高額一時の作成2)
    protected IBatchFlowCommand callInsKyufuJissekiChukanKogakuTmpProcess2() {
        return loopBatch(InsKyufuJissekiChukanKogakuTmpProcess2.class).define();
    }

    /**
     * 給付実績中間高額一時の作成2のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績中間高額一時の作成3)
    protected IBatchFlowCommand callInsKyufuJissekiChukanKogakuTmpProcess3() {
        return simpleBatch(InsKyufuJissekiChukanKogakuTmpProcess3.class).define();
    }

    /**
     * 給付実績中間事業高額一時の作成１のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績中間事業高額一時の作成１)
    protected IBatchFlowCommand callInsKyufuJissekiChukanJigyoKogakuTmpProcess1() {
        return loopBatch(InsKyufuJissekiChukanJigyoKogakuTmpProcess1.class).define();
    }

    /**
     * 給付実績中間事業高額一時の作成2のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績中間事業高額一時の作成2)
    protected IBatchFlowCommand callInsKyufuJissekiChukanJigyoKogakuTmpProcess2() {
        return loopBatch(InsKyufuJissekiChukanJigyoKogakuTmpProcess2.class).define();
    }

    /**
     * 給付実績中間事業高額一時の作成3のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績中間事業高額一時の作成3)
    protected IBatchFlowCommand callInsKyufuJissekiChukanJigyoKogakuTmpProcess3() {
        return simpleBatch(InsKyufuJissekiChukanJigyoKogakuTmpProcess3.class).define();
    }

    /**
     * 給付実績中間高額一時の作成5のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績中間高額一時の作成5)
    protected IBatchFlowCommand callInsKyufuJissekiChukanKogakuTmpProcess5() {
        return simpleBatch(InsKyufuJissekiChukanKogakuTmpProcess5.class).define();
    }

    /**
     * 給付実績中間高額一時の作成5のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績中間高額一時の更新１)
    protected IBatchFlowCommand callUpdKyufuJissekiChukanKogakuTmpProcess5() {
        return simpleBatch(UpdKyufuJissekiChukanKogakuTmpProcess5.class).define();
    }

    /**
     * 給付実績中間事業高額一時の作成5のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績中間事業高額一時の作成5)
    protected IBatchFlowCommand callInsKyufuJissekiChukanJigyoKogakuTmpProcess5() {
        return simpleBatch(InsKyufuJissekiChukanJigyoKogakuTmpProcess5.class).define();
    }

    /**
     * 給付実績中間事業高額一時の更新１のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績中間事業高額一時の更新１)
    protected IBatchFlowCommand callUpdKyufuJissekiChukanJigyoKogakuTmpProcess5() {
        return simpleBatch(UpdKyufuJissekiChukanJigyoKogakuTmpProcess5.class).define();
    }

    /**
     * 給付実績中間事業高額一時の更新２のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績中間事業高額一時の更新２)
    protected IBatchFlowCommand callUpdKyufuJissekiChukanJigyoKogakuTmpProcess5_2() {
        KyufuJissekiKihonKogakuProcessParameter processParameter = new KyufuJissekiKihonKogakuProcessParameter();
        processParameter.set最古のサービス高額提供年月(returnEntity.get最古のサービス提供年月());
        processParameter.set最新のサービス高額提供年月(returnEntity.get最新のサービス提供年月());
        return loopBatch(UpdKyufuJissekiChukanJigyoKogakuTmpProcess5_2.class).arguments(processParameter).define();
    }

    /**
     * 給付実績中間事業高額一時の更新３のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績中間事業高額一時の更新３)
    protected IBatchFlowCommand callUpdKyufuJissekiChukanJigyoKogakuTmpProcess5_3() {
        KyufuJissekiKihonKogakuProcessParameter processParameter = new KyufuJissekiKihonKogakuProcessParameter();
        processParameter.set最古のサービス高額提供年月(returnEntity.get最古のサービス提供年月());
        processParameter.set最新のサービス高額提供年月(returnEntity.get最新のサービス提供年月());
        return loopBatch(UpdKyufuJissekiChukanJigyoKogakuTmpProcess5_3.class).arguments(processParameter).define();
    }

    /**
     * 給付実績集計のバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績集計のバックアップ)
    protected IBatchFlowCommand callInsKyufuJissekiShukeiTmpProcess() {
        return loopBatch(InsKyufuJissekiShukeiTmpProcess.class).
                arguments(getKogakuKaigoKyufuhiTaishoshaTorokuProcessParameter()).define();
    }

    /**
     * 給付実績社会福祉法人軽減額のバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績社会福祉法人軽減額のバックアップ)
    protected IBatchFlowCommand callInsKyufuJissekiShafukuKeigenTmpProcess() {
        return loopBatch(InsKyufuJissekiShafukuKeigenTmpProcess.class).
                arguments(getKogakuKaigoKyufuhiTaishoshaTorokuProcessParameter()).define();
    }

    /**
     * 基準収入額適用管理のバックアップのメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (基準収入額適用管理のバックアップ)
    protected IBatchFlowCommand callInsKijunShunyugakuTekiyoKanriTmpProcess() {
        return loopBatch(InsKijunShunyugakuTekiyoKanriTmpProcess.class).define();
    }

    /**
     * 給付実績中間高額一時の作成7のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績中間高額一時の作成7)
    protected IBatchFlowCommand callInsKyufuJissekiChukanKogakuTmpProcess7() {
        return loopBatch(InsKyufuJissekiChukanKogakuTmpProcess7.class).define();
    }

    /**
     * 給付実績中間事業高額一時の作成7のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績中間事業高額一時の作成7)
    protected IBatchFlowCommand callInsKyufuJissekiChukanJigyoKogakuTmpProcess7() {
        return loopBatch(InsKyufuJissekiChukanJigyoKogakuTmpProcess7.class).define();
    }

    /**
     * 世帯員把握入力一時の更新のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (世帯員把握入力一時の更新)
    protected IBatchFlowCommand callUpdSetaiinHaakuNyuryokuKogakuTmpProcess() {
        return simpleBatch(UpdSetaiinHaakuNyuryokuKogakuTmpProcess.class).define();
    }

    /**
     * 世帯員所得判定明細高額一時の作成２のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (世帯員所得判定明細高額一時の作成２)
    protected IBatchFlowCommand callInsSetaiinShotokuHanteiMeisaiKogakuTmpProcess2() {
        return loopBatch(InsSetaiinShotokuHanteiMeisaiKogakuTmpProcess2.class).define();
    }

    /**
     * 世帯員所得判定明細事業高額一時の作成２のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (世帯員所得判定明細事業高額一時の作成２)
    protected IBatchFlowCommand callInsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess2() {
        return loopBatch(InsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess2.class).define();
    }

    /**
     * 世帯員所得判定明細高額一時の作成３のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (世帯員所得判定明細高額一時の作成３)
    protected IBatchFlowCommand callInsSetaiinShotokuHanteiMeisaiKogakuTmpProcess3() {
        return loopBatch(InsSetaiinShotokuHanteiMeisaiKogakuTmpProcess3.class).
                arguments(getKyufuJissekiKihonKogakuProcessParameter()).define();
    }

    /**
     * 世帯員所得判定明細事業高額一時の作成３のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (世帯員所得判定明細事業高額一時の作成３)
    protected IBatchFlowCommand callInsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess3() {
        return loopBatch(InsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess3.class).
                arguments(getKyufuJissekiKihonKogakuProcessParameter()).define();
    }

    /**
     * 給付実績中間高額一時の作成8のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績中間高額一時の作成8)
    protected IBatchFlowCommand callInsKyufuJissekiChukanJigyoKogakuTmpProcess8() {
        return loopBatch(InsKyufuJissekiChukanKogakuTmpProcess8.class).define();
    }

    /**
     * 給付実績中間事業高額一時の作成8のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (給付実績中間事業高額一時の作成8)
    protected IBatchFlowCommand callInsKyufuJissekiChukanKogakuTmpProcess8() {
        return loopBatch(InsKyufuJissekiChukanJigyoKogakuTmpProcess8.class).define();
    }

    /**
     * 高額介護サービス費一時の作成のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (高額介護サービス費一時の作成)
    protected IBatchFlowCommand callInsKogakuKaigoServiceHiTmpProcess() {
        return loopBatch(InsKogakuKaigoServiceHiTmpProcess.class).arguments(getInsKogakuKaigoServiceHiTmpProcessParameter()).define();
    }

    /**
     * 事業高額介護サービス費一時の作成のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (事業高額介護サービス費一時の作成)
    protected IBatchFlowCommand callInsJigyoKogakuKaigoServiceHiTmpProcess() {
        return loopBatch(InsJigyoKogakuKaigoServiceHiTmpProcess.class).arguments(getInsKogakuKaigoServiceHiTmpProcessParameter()).define();
    }

    /**
     * 高額対象者一覧表発行処理のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (高額対象者一覧表発行処理)
    protected IBatchFlowCommand callPrtTaishoshaIchiranKogakuProcess() {
        return loopBatch(PrtTaishoshaIchiranKogakuProcess.class).arguments(getReportParameter()).define();
    }

    /**
     * 事業高額対象者一覧表発行処理のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (事業高額対象者一覧表発行処理)
    protected IBatchFlowCommand callPrtTaishoshaIchiranJigyoProcess() {
        return loopBatch(PrtTaishoshaIchiranJigyoProcess.class).arguments(getReportParameter()).define();
    }

    /**
     * 高額エラーリストの発行のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (高額エラーリストの発行)
    protected IBatchFlowCommand callPrtErrorListKogakuProcess() {
        return loopBatch(PrtErrorListKogakuProcess.class).arguments(getReportParameter()).define();
    }

    /**
     * 事業高額エラーリストの発行のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (事業高額エラーリストの発行)
    protected IBatchFlowCommand callPrtErrorListJigyoProcess() {
        return loopBatch(PrtErrorListJigyoProcess.class).arguments(getReportParameter()).define();
    }

    /**
     * 高額国保連ＩＦマスタ更新のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (高額国保連ＩＦマスタ更新)
    protected IBatchFlowCommand callUpdKogakuKokuhorenIFMstProcess() {
        return simpleBatch(UpdKogakuKokuhorenIFMstProcess.class).
                arguments(getUpdKogakuKokuhorenIFMstProcessParameter()).define();
    }

    /**
     * 事業高額国保連ＩＦマスタ更新のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (事業高額国保連ＩＦマスタ更新)
    protected IBatchFlowCommand callUpdJigyoKKogakuKokuhorenIFMstProcess() {
        return simpleBatch(UpdJigyoKKogakuKokuhorenIFMstProcess.class).
                arguments(getUpdKogakuKokuhorenIFMstProcessParameter()).define();
    }

    /**
     * 高額介護サービス費追加のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (高額介護サービス費追加)
    protected IBatchFlowCommand callInsKogakuKaigoServiceHiProcess() {
        return simpleBatch(InsKogakuKaigoServiceHiProcess.class).define();
    }

    /**
     * 事業高額介護サービス費追加のメソッドです。
     *
     * @return IBatchFlowCommand
     */
    @Step (事業高額介護サービス費追加)
    protected IBatchFlowCommand callInsJigyoKogakuKaigoServiceHiProcess() {
        return simpleBatch(InsJigyoKogakuKaigoServiceHiProcess.class).define();
    }

    private boolean is高額介護サービス(RString メニューID) {
        return メニューID_高額介護サービス.equals(メニューID);
    }

    private boolean is事業高額介護サービス(RString メニューID) {
        return メニューID_事業高額介護サービス.equals(メニューID);
    }

    private KogakuKaigoServicehiKyufutaishoshaTorokuProcessParameter setParameter() {
        KogakuKaigoServicehiKyufutaishoshaTorokuProcessParameter parameter
                = new KogakuKaigoServicehiKyufutaishoshaTorokuProcessParameter();
        parameter.set処理年月(getParameter().getShoriYM());
        return parameter;
    }

    private DBB002001_SetaiinHaakuParameter getSetaiShotokuKazeiHanteiBatchParameter() {
        return new DBB002001_SetaiinHaakuParameter(SetaiinHaakuKanriShikibetsuKubun.賦課.getコード());
    }

    private InsKyufuJissekiKihonKogakuTmpProcess4Param get給付実績基本情報高額一時４バッチパラメータ() {
        InsKyufuJissekiKihonKogakuTmpProcess4Param param = new InsKyufuJissekiKihonKogakuTmpProcess4Param(
                returnEntity.get最古のサービス提供年月(),
                returnEntity.get最新のサービス提供年月(),
                getParameter().getShoriYM());
        return param;
    }

    private KogakuKaigoKyufuhiTaishoshaTorokuProcessParameter getKogakuKaigoKyufuhiTaishoshaTorokuProcessParameter() {
        KogakuKaigoKyufuhiTaishoshaTorokuProcessParameter param = new KogakuKaigoKyufuhiTaishoshaTorokuProcessParameter(
                returnEntity.get最古のサービス提供年月(),
                returnEntity.get最新のサービス提供年月());
        return param;
    }

    private KyufuJissekiKihonKogakuProcessParameter getKyufuJissekiKihonKogakuProcessParameter() {
        KyufuJissekiKihonKogakuProcessParameter parameter = new KyufuJissekiKihonKogakuProcessParameter();
        parameter.set続柄コード参照年(new FlexibleYear(new RString(カウントアップ)));
        parameter.set処理年月日(new FlexibleDate(new RString(カウントアップ).concat(日付_1231)));
        return parameter;
    }

    private KyufuJissekiKihonKogakuProcessParameter getDelSaishoriKogakuTmpProcessParameter() {
        KyufuJissekiKihonKogakuProcessParameter parameter = new KyufuJissekiKihonKogakuProcessParameter();
        parameter.set処理年月(new FlexibleYearMonth(処理日時.getDate().getYearMonth().toDateString()));
        return parameter;
    }

    private KyufuJissekiKihonKogakuProcessParameter getReportParameter() {
        KyufuJissekiKihonKogakuProcessParameter parameter = new KyufuJissekiKihonKogakuProcessParameter();
        parameter.set出力順ID(new RString(getParameter().getShuturyokuJunn()));
        parameter.set処理年月(getParameter().getShoriYM());
        return parameter;
    }

    private KogakuKaigoKyufuhiTaishoshaTorokuProcessParameter getUpdKogakuKokuhorenIFMstProcessParameter() {
        KogakuKaigoKyufuhiTaishoshaTorokuProcessParameter parameter = new KogakuKaigoKyufuhiTaishoshaTorokuProcessParameter();
        parameter.setSysDate(処理日時);
        parameter.setSysYearMonth(getParameter().getShoriYM());
        return parameter;
    }

    private KyufuJissekiKihonKogakuProcessParameter getInsKogakuKaigoServiceHiTmpProcessParameter() {
        KyufuJissekiKihonKogakuProcessParameter parameter = new KyufuJissekiKihonKogakuProcessParameter();
        parameter.set処理年月日(new FlexibleDate(処理日時.getDate().toDateString()));
        return parameter;
    }
}
