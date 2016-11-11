/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010.CreateRiyojokyoIchiranHyoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010.CreateToukeiHyoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010.DbWT1510KyufuJissekiKihonDeleteProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010.DbWT1510KyufuJissekiKihonInsertProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010.DbWT1513SetaiCodeUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010.DbWT1513ShoriShichosonNameUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010.DbWT1513ShukeiDataInsert2Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010.DbWT1513ShutsuRyokuTaishoDataInsertProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010.OutPutDataUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010.ServiceTeikyoYMSelectProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150010.DBC150010_RiyojokyoTokeihyoMeisaiListParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.RiyojokyoTokeihyo_ShutsuryokuKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc150010.SedaiUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用状況統計表（明細リスト）作成のバッチ処理フロー
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public class DBC150010_RiyojokyoTokeihyoMeisaiList extends BatchFlowBase<DBC150010_RiyojokyoTokeihyoMeisaiListParameter> {

    private static final String 給付実績基本一時テーブル登録 = "INSERT_DBWT1510KYUFUJISSEKIKIHON";
    private static final String 出力対象データ判定 = "SELECT_OUTPUTDATE";
    private static final String 集計データ2登録 = "INSERT_SHUKEIDATA2";
    private static final String 処理市町村名更新 = "UPDATE_SHORISHICHOSONNAME";
    private static final String 統計表作成 = "TOUKEI_SAKUSEI";
    private static final String 利用状況一覧表作成 = "SHUTSURYOKUTAISHODATA_INSERT";
    private static final String 出力対象外データ削除 = "KYUFUJISSEKIKIHON_DELETE";
    private static final String 設定区分取得 = "SETTEIKUBUN_UPDATE";
    private static final String 統計用給付実績データ作成 = "TOKEIYOKYUHUJISSEKIDATA_SAKUSEI";
    private static final String 受給者台帳データ作成 = "JUKYUSHADAICHO_INSERT";
    private static final String 有効認定期間開始年月設定 = "KikanKaishiYM_Update";
    private static final String 認定有効期間終了年月設定 = "KikanShuryoYM_Update";
    private static final String 抽出範囲外データ削除 = "HAIIGAIDATA_DELETE";
    private static final String サービス提供年月単位登録 = "SERVICETEIKYOYM_SAKUSEI";
    private static final String 元データ削除 = "TAISHOGAIDATA_DELETE";
    private static final String 被保険者台帳データ取得 = "HIHOKENSHASAKUSEI_UPDATE";
    private static final String 被保険者台帳出力対象外データ削除 = "HIHOKENSHATAISHOUGAI_DELETE";
    private static final String 居宅サービス計画データ取得 = "KYOTAKU_UPDATE";
    private static final String 受給者台帳情報登録 = "JUKYUSHADAICHO_UPDATE";
    private static final String 集計データ登録1 = "SHUKEIDATA1_INSERT";
    private static final String 短期入所支給限度額情報作成 = "TANKINYUSHOSHIKYUGENDOGAKU_UPDATE";
    private static final String 支給限度額改訂情報作成 = "SHIKYUGENDOGAKUKAITEI_UPDATE";
    private static final String 利用率更新 = "RIYOURITU_UPDATE";
    private static final String 被保険者宛名情報更新 = "HOKENSHAATENA_UPDATE";
    private static final String 被保険者宛名情報エラー登録 = "HOKENSHANOERROR_INSERT";
    private static final String サービス提供年月取得 = "SERVICETEIKYOYM_SELECT";
    private static final String 世帯コード登録 = "SETAICODE_UPDATE";
    private static final String 事業者名取得 = "JIGYOSHANAME_UPDATE";
    private static final String 利用状況一覧表出力 = "CREATE_RIYOJOKYOICHIRANHYO";

    private static final RString 市町村コード_全て = new RString("000000");
    private static final RString 出力する = new RString("1");
    private static final RString 利用実績区分_集計 = new RString("1");
    private FlexibleYearMonth サービス提供年月;

    @Override
    protected void defineFlow() {
        DBC150010_RiyojokyoTokeihyoMeisaiListParameter parameter = getParameter();
        executeStep(給付実績基本一時テーブル登録);
        executeStep(出力対象データ判定);
        executeStep(出力対象外データ削除);
        //SetteiKubunUpdateProcess
        executeStep(設定区分取得);
        //TokeiyoKyuhuJissekiDataSakuseiProcess
        executeStep(統計用給付実績データ作成);
        //DbWT1512JukyushaDaichoInsertProcess
        executeStep(受給者台帳データ作成);
        //DbWT1512KikanKaishiYMUpdateProcess
        executeStep(有効認定期間開始年月設定);
        //DbWT1512KikanShuryoYMUpdateProcess
        executeStep(認定有効期間終了年月設定);
        //DbWT1512HaiigaiDataDeleteProcess
        executeStep(抽出範囲外データ削除);
        //ServiceTeikyoYMSakuseiProcess
        executeStep(サービス提供年月単位登録);
        //DbWT1512TaishogaiDataDeleteProcess
        executeStep(元データ削除);
        //DbWT1512HihokenshaSakuseiUpdateProcess
        executeStep(被保険者台帳データ取得);
        //DbWT1512HihokenshaTaishouGaiDeleteProcess
        executeStep(被保険者台帳出力対象外データ削除);
        //DbWT1512KyotakuUpdateProcess
        executeStep(居宅サービス計画データ取得);
        //DbWT1513JukyushaDaichoUpdateProcess
        executeStep(受給者台帳情報登録);
        //DbWT1513ShukeiDataInsert1Process
        executeStep(集計データ登録1);
        //DbWT1513TankinyushoShikyugendoGakuUpdateProcess
        executeStep(短期入所支給限度額情報作成);
        //DbWT1513ShikyuGendogakuKaiteiUpdateProcess
        executeStep(支給限度額改訂情報作成);
        //DbWT1513RiyourituUpdateProcess
        executeStep(利用率更新);
        if (!利用実績区分_集計.equals(parameter.get利用実績区分())) {
            executeStep(集計データ2登録);
        }
        if (DonyuKeitaiCode.toValue(parameter.get導入形態コード()).is単一()
                && 市町村コード_全て.equals(parameter.get旧市町村コード())) {
            executeStep(処理市町村名更新);
        }
        //DbWT1513HokenshaAtenaUpdateProcess
        executeStep(被保険者宛名情報更新);
        //DbWT1514HokenshaNoErrorInsertProcess
        executeStep(被保険者宛名情報エラー登録);
        if (RiyojokyoTokeihyo_ShutsuryokuKubun.出力する.getコード().equals(parameter.get統計表出力区分())) {
            executeStep(統計表作成);
        }
        if (出力する.equals(parameter.get明細リスト出力区分()) || 出力する.equals(parameter.get明細CSV出力区分())) {
            List<FlexibleYearMonth> outData
                    = getResult(List.class, new RString(サービス提供年月取得), ServiceTeikyoYMSelectProcess.データ有無);
            for (FlexibleYearMonth outサービス提供年月 : outData) {
                サービス提供年月 = outサービス提供年月;
                executeStep(世帯コード登録);
            }
            //DbWT1513JigyoshoNameUpdateProcess
            executeStep(事業者名取得);
            executeStep(利用状況一覧表作成);
        }
    }

    /**
     * 給付実績基本一時TBLを作成します。
     *
     * @return バッチコマンド
     */
    @Step(給付実績基本一時テーブル登録)
    protected IBatchFlowCommand insertDbWT1510KyufuJissekiKihon() {
        return loopBatch(DbWT1510KyufuJissekiKihonInsertProcess.class).define();
    }

    /**
     * 出力対象データを作成します。
     *
     * @return バッチコマンド
     */
    @Step(出力対象データ判定)
    protected IBatchFlowCommand updateOutPutData() {
        return loopBatch(OutPutDataUpdateProcess.class).define();
    }

    /**
     * 出力対象外データ削除を作成します。
     *
     * @return バッチコマンド
     */
    @Step(出力対象外データ削除)
    protected IBatchFlowCommand deleteKyufuJissekiKihon() {
        return loopBatch(DbWT1510KyufuJissekiKihonDeleteProcess.class).define();
    }

    /**
     * 集計データ2を登録します。
     *
     * @return バッチコマンド
     */
    @Step(集計データ2登録)
    protected IBatchFlowCommand insertShukeiData2() {
        return loopBatch(DbWT1513ShukeiDataInsert2Process.class).define();
    }

    /**
     * 処理市町村名を更新します。
     *
     * @return バッチコマンド
     */
    @Step(処理市町村名更新)
    protected IBatchFlowCommand updateShoriShichosonName() {
        return loopBatch(DbWT1513ShoriShichosonNameUpdateProcess.class).define();
    }

    /**
     * 統計表を作成します。
     *
     * @return バッチコマンド
     */
    @Step(統計表作成)
    protected IBatchFlowCommand createToukeiHyo() {
        return loopBatch(CreateToukeiHyoProcess.class).arguments(getParameter().createProcessParemter()).define();
    }

    /**
     * 利用状況一覧表を作成します。
     *
     * @return バッチコマンド
     */
    @Step(利用状況一覧表作成)
    protected IBatchFlowCommand insertShutsuRyokuTaishoData() {
        return loopBatch(DbWT1513ShutsuRyokuTaishoDataInsertProcess.class).arguments(getParameter().createProcessParemter()).define();
    }

    /**
     * 宛名から世帯コードを取得して一時TBLに更新します。
     *
     * @return バッチコマンド
     */
    @Step(世帯コード登録)
    protected IBatchFlowCommand createSetaiCodeUpdate() {
        SedaiUpdateProcessParameter parameter = new SedaiUpdateProcessParameter();
        parameter.setサービス提供年月(サービス提供年月);
        return loopBatch(DbWT1513SetaiCodeUpdateProcess.class).arguments(parameter).define();
    }

    /**
     * 利用状況一覧表を出力します。
     *
     * @return バッチコマンド
     */
    @Step(利用状況一覧表出力)
    protected IBatchFlowCommand createRiyojokyoIchiranHyo() {
        return loopBatch(CreateRiyojokyoIchiranHyoProcess.class).arguments(getParameter().createCreateRiyojokyoIchiranHyoProcessParameter()).define();
    }
}
