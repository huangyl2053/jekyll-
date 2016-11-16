/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigoservicehikyufutaishoshatoroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020010.KogakuKaigoServicehiKyufutaishoshaTorokuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehikyufutaishoshatoroku.UpdKogakuKokuhorenIFMstMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufutaishoshatoroku.InsKyufuJissekiKihonKogakuTmp4Param;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3110JigyoKogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3112KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.inskyufujissekichukankogakutmpprocess.InsKyufuJissekiChukanJigyoKogakuTmpProcess7Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.inskyufujissekichukankogakutmpprocess.InsKyufuJissekiChukanKogakuTmpProcess7Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKyufujissekiTyukannJigyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempSetaiinShotokuHanteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.HanteiEraaResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.HihokenSeikatsuRoreiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.InsSetaiinHaakuNyuryokuKogakuFlowEntity1;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.InsSetaiinHaakuNyuryokuKogakuTmpEntity1;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.KogakuFlowReturnEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.KogakuKaigoServicehiReportEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiChukanKogaku8Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.KyufujissekiTyukannInsertEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.SetaiHihokenshaResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.TyukannJigyoKogakuRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.TyukannKogakuRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.UpdKyufuJissekiChukanJigyoKogakuTmpProcessEntity2;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.UpdKyufuJissekiChukanJigyoKogakuTmpProcessEntity3;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;

/**
 * 高額介護サービス費給付額算出DB操作です。
 *
 * @reamsid_L DBC-2010-070 tianshuai
 */
public interface IKogakuKaigoServicehiKyufugakuSanshutsuMapper {

    /**
     * 高額介護サービス費関連のテーブルのデータを削除するためのキーを取得し、削除キー一時に格納する。
     *
     * @param param KyufuJissekiKihonKogakuMybatisParameter
     */
    void insert高額介護削除キー一時(KyufuJissekiKihonKogakuMybatisParameter param);

    /**
     * 事業高額介護サービス費関連のテーブルのデータを削除するためのキーを取得し、削除キー一時に格納する。
     *
     * @param param KyufuJissekiKihonKogakuMybatisParameter
     */
    void insert事業高額介護削除キー一時(KyufuJissekiKihonKogakuMybatisParameter param);

    /**
     * 前回処理高額介護サービス費支給申請の削除のメソッドです。
     *
     */
    void delete前回処理高額介護サービス費支給申請();

    /**
     * 前回処理高額介護サービス費支給判定結果の削除のメソッドです。
     *
     */
    void delete前回処理高額介護サービス費支給判定結果();

    /**
     * 前回処理高額介護サービス費支給審査決定の削除のメソッドです。
     *
     */
    void delete前回処理高額介護サービス費支給審査決定();

    /**
     * 前回処理高額介護サービス費給付対象者合計の削除のメソッドです。
     *
     */
    void delete前回処理高額介護サービス費給付対象者合計();

    /**
     * 前回処理高額介護サービス費給付対象者明細の削除のメソッドです。
     *
     */
    void delete前回処理高額介護サービス費給付対象者明細();

    /**
     * 前回処理高額介護サービス費支給申請の削除のメソッドです。
     *
     */
    void delete前回処理事業高額介護サービス費支給申請();

    /**
     * 前回処理事業高額介護サービス費支給判定結果の削除のメソッドです。
     *
     */
    void delete前回処理事業高額介護サービス費支給判定結果();

    /**
     * 前回処理事業高額介護サービス費支給審査決定の削除のメソッドです。
     *
     */
    void delete前回処理事業高額介護サービス費支給審査決定();

    /**
     * 前回処理高額介護サービス費給付対象者合計の削除のメソッドです。
     *
     */
    void delete前回処理事業高額介護サービス費給付対象者合計();

    /**
     * 前回処理高額介護サービス費給付対象者明細の削除のメソッドです。
     *
     */
    void delete前回処理事業高額介護サービス費給付対象者明細();

    /**
     *
     * 給付実績基本抽出02の内容
     *
     * @return List<InsSetaiinHaakuNyuryokuKogakuTmpEntity1>
     */
    List<InsSetaiinHaakuNyuryokuKogakuTmpEntity1> get給付実績基本情報高額一時3();

    /**
     *
     * 給付実績基本抽出02の内容
     *
     * @return List<InsSetaiinHaakuNyuryokuKogakuTmpEntity1>
     */
    List<InsSetaiinHaakuNyuryokuKogakuTmpEntity1> get給付実績基本情報事業高額一時3();

    /**
     *
     * 給付実績基本抽出02の内容
     *
     * @return InsSetaiinHaakuNyuryokuKogakuFlowEntity1
     */
    InsSetaiinHaakuNyuryokuKogakuFlowEntity1 getサービス提供年月_高額一時();

    /**
     *
     * 給付実績基本抽出02の内容
     *
     * @return InsSetaiinHaakuNyuryokuKogakuFlowEntity1
     */
    InsSetaiinHaakuNyuryokuKogakuFlowEntity1 getサービス提供年月_事業高額一時();

    /**
     *
     * 給付実績基本抽出03の内容
     *
     * @param param 検索パラメータ
     * @return List<DbT3017KyufujissekiKihonEntity>
     */
    List<DbT3017KyufujissekiKihonEntity> get給付実績基本(InsKyufuJissekiKihonKogakuTmp4Param param);

    /**
     *
     * 給付実績基本抽出03の内容
     *
     * @param param 検索パラメータ
     * @return List<DbT3017KyufujissekiKihonEntity>
     */
    List<DbT3017KyufujissekiKihonEntity> get給付実績基本2(InsKyufuJissekiKihonKogakuTmp4Param param);

    /**
     *
     * 給付実績基本抽出01の内容
     *
     * @return List<DbT3017KyufujissekiKihonEntity>
     */
    List<DbT3017KyufujissekiKihonEntity> get給付実績基本情報高額一時3リスト();

    /**
     *
     * 給付実績基本抽出01の内容
     *
     * @return List<DbT3017KyufujissekiKihonEntity>
     */
    List<DbT3017KyufujissekiKihonEntity> get給付実績基本情報事業高額一時3リスト();

    /**
     * select世帯員把握の結果
     *
     * @return SetaiHihokenshaResultEntity
     */
    List<SetaiHihokenshaResultEntity> select世帯員把握の結果();

    /**
     *
     * @return 世帯員所得情報一時
     */
    List<TempSetaiinShotokuHanteiEntity> select世帯員所得情報一時();

    /**
     * select被保生保老齢情報
     *
     * @return 被保生保老齢情報
     */
    List<HihokenSeikatsuRoreiRelateEntity> select被保生保老齢情報();

    /**
     * select世帯員所得判定明細一時
     *
     * @return TempSetaiinShotokuHanteiEntity
     */
    List<TempSetaiinShotokuHanteiEntity> select世帯員所得判定明細一時();

    /**
     * select続柄コード参照年
     *
     * @return KogakuFlowReturnEntity
     */
    KogakuFlowReturnEntity select続柄コード参照年();

    /**
     * select高額介護サービス費対象者一覧
     *
     * @param parameter KyufuJissekiKihonKogakuMybatisParameter
     * @return KogakuKaigoServicehiReportEntity
     */
    List<KogakuKaigoServicehiReportEntity> select高額介護サービス費対象者一覧(KyufuJissekiKihonKogakuMybatisParameter parameter);

    /**
     * select高額総合事業サービス費対象者一覧
     *
     * @param parameter KyufuJissekiKihonKogakuMybatisParameter
     * @return KogakuKaigoServicehiReportEntity
     */
    List<KogakuKaigoServicehiReportEntity> select高額総合事業サービス費対象者一覧(KyufuJissekiKihonKogakuMybatisParameter parameter);

    /**
     * select高額介護サービス費判定エラーリスト
     *
     * @return 判定エラーリストEntity
     */
    List<HanteiEraaResultEntity> select高額介護サービス費判定エラーリスト();

    /**
     * select高額総合事業サービス費判定エラーリスト
     *
     * @return 判定エラーリストEntity
     */
    List<HanteiEraaResultEntity> select高額総合事業サービス費判定エラーリスト();

    /**
     * select高額判定結果全件一時
     *
     * @return TyukannKogakuRelateEntity
     */
    List<TyukannKogakuRelateEntity> select高額判定結果全件一時();

    /**
     * select事業高額判定結果全件一時
     *
     * @return TyukannJigyoKogakuRelateEntity
     */
    List<TyukannJigyoKogakuRelateEntity> select事業高額判定結果全件一時();

    /**
     * 給付実績基本情報高額一時1テーブルを取得する。
     *
     * @param パラメータ パラメータ
     * @return List<DbT3017KyufujissekiKihonEntity> 給付実績基本情報高額一時1リスト
     */
    List<DbT3017KyufujissekiKihonEntity> select給付実績基本情報高額一時1(
            KogakuKaigoServicehiKyufutaishoshaTorokuMybatisParameter パラメータ);

    /**
     * 給付実績基本情報高額一時1テーブルを取得する。
     *
     * @param パラメータ パラメータ
     * @return List<DbT3017KyufujissekiKihonEntity> 給付実績基本情報高額一時1リスト
     */
    List<DbT3017KyufujissekiKihonEntity> select給付実績基本情報事業高額一時1(
            KogakuKaigoServicehiKyufutaishoshaTorokuMybatisParameter パラメータ);

    /**
     * 給付実績基本情報高額一時2テーブルを取得する。
     *
     * @param パラメータ パラメータ
     * @return List<DbT3017KyufujissekiKihonEntity> 給付実績基本情報高額一時2リスト
     */
    List<DbT3017KyufujissekiKihonEntity> select給付実績基本情報高額一時2(
            KogakuKaigoServicehiKyufutaishoshaTorokuMybatisParameter パラメータ);

    /**
     * 給付実績基本情報高額一時1テーブルを取得する。
     *
     * @param パラメータ パラメータ
     * @return List<DbT3017KyufujissekiKihonEntity> 給付実績基本情報高額一時2リスト
     */
    List<DbT3017KyufujissekiKihonEntity> select給付実績基本情報事業高額一時2(
            KogakuKaigoServicehiKyufutaishoshaTorokuMybatisParameter パラメータ);

    /**
     * 被保険者台帳情報一時1テーブルを取得する。
     *
     * @return List<DbT1001HihokenshaDaichoEntity> 被保険者台帳情報一時1リスト
     */
    List<DbT1001HihokenshaDaichoEntity> select被保険者台帳情報一時1();

    /**
     * 被保険者台帳情報一時2テーブルを取得する。
     *
     * @return List<DbT1001HihokenshaDaichoEntity> 被保険者台帳情報一時2リスト
     */
    List<DbT1001HihokenshaDaichoEntity> select被保険者台帳情報一時2();

    /**
     * 支払方法変更管理一時テーブルを取得する。
     *
     * @return List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更管理一時リスト
     */
    List<DbT4021ShiharaiHohoHenkoEntity> select支払方法変更管理();

    /**
     * 境界層管理一時テーブルを取得する。
     *
     * @return List<DbT1006KyokaisoGaitoshaEntity> 境界層管理一時リスト
     */
    List<DbT1006KyokaisoGaitoshaEntity> select境界層管理一時();

    /**
     * 給付実績中間高額一時の作成１テーブルを取得する。
     *
     * @return List<KyufujissekiTyukannInsertEntity> 給付実績基本情報高額一時リスト
     */
    List<KyufujissekiTyukannInsertEntity> select給付実績中間高額一時の作成１();

    /**
     * 給付実績中間高額一時の作成2テーブルを取得する。
     *
     * @return List<KyufujissekiTyukannInsertEntity> 給付実績基本情報高額一時リスト
     */
    List<KyufujissekiTyukannInsertEntity> select給付実績中間高額一時の作成2();

    /**
     * 給付実績中間高額一時の作成3テーブルを登録する。
     */
    void insert給付実績中間高額一時の作成31();

    /**
     * 給付実績中間高額一時の作成3テーブルを登録する。
     */
    void insert給付実績中間高額一時の作成32();

    /**
     * 給付実績中間事業高額一時の作成１テーブルを取得する。
     *
     * @return List<KyufujissekiTyukannInsertEntity> 給付実績基本情報事業高額一時リスト
     */
    List<KyufujissekiTyukannInsertEntity> select給付実績中間事業高額一時の作成１();

    /**
     * 給付実績中間事業高額一時の作成2テーブルを取得する。
     *
     * @return List<KyufujissekiTyukannInsertEntity> 給付実績基本情報事業高額一時リスト
     */
    List<KyufujissekiTyukannInsertEntity> select給付実績中間事業高額一時の作成2();

    /**
     * 給付実績中間事業高額一時の作成3テーブルを登録する。
     */
    void insert給付実績中間事業高額一時の作成31();

    /**
     * 給付実績中間事業高額一時の作成3テーブルを登録する。
     */
    void insert給付実績中間事業高額一時の作成32();

    /**
     * 給付実績中間高額一時の作成5テーブルを登録する。
     */
    void insert給付実績中間高額一時の作成5();

    /**
     * 高額判定エラー一時テーブルを登録する。
     */
    void insert高額判定エラー一時();

    /**
     * 給付実績中間高額一時の更新１を登録する。
     */
    void update給付実績中間高額一時5の更新1();

    /**
     * 給付実績中間高額一時の更新１を登録する。
     */
    void update給付実績中間高額一時5の更新2();

    /**
     * 給付実績中間事業高額一時の作成5テーブルを登録する。
     */
    void insert給付実績中間事業高額一時の作成5();

    /**
     * 事業高額判定エラー一時テーブルを登録する。
     */
    void insert事業高額判定エラー一時();

    /**
     * 給付実績中間事業高額一時の更新１を登録する。
     */
    void update給付実績中間事業高額一時5の更新1();

    /**
     * 給付実績中間事業高額一時の更新１を登録する。
     */
    void update給付実績中間事業高額一時5の更新2();

    /**
     * 世帯員把握入力一時の更新する。
     */
    void 世帯員把握入力一時の更新1();

    /**
     * 世帯員把握入力一時の更新する。
     */
    void 世帯員把握入力一時の更新2();

    /**
     * 世帯員把握入力一時の更新する。
     */
    void 世帯員把握入力一時の更新3();

    /**
     * 世帯員把握入力一時の更新する。
     */
    void 世帯員把握入力一時の更新4();

    /**
     * データの取得（高額介護サービス費支給判定結果、高額介護サービス費支給審査決定）のメソッドです。
     *
     * @param param KyufuJissekiKihonKogakuMybatisParameter
     * @return {@link  List<UpdKyufuJissekiChukanJigyoKogakuTmpProcess5_2Entity>}
     */
    List<UpdKyufuJissekiChukanJigyoKogakuTmpProcessEntity2> select高額介護サービス費支給判定結果と支給審査決定(KyufuJissekiKihonKogakuMybatisParameter param);

    /**
     * データの取得（高額介護サービス費給付対象者合計）のメソッドです。
     *
     * @param param KyufuJissekiKihonKogakuMybatisParameter
     * @return {@link  List<UpdKyufuJissekiChukanJigyoKogakuTmpProcess5_3Entity>}
     */
    List<UpdKyufuJissekiChukanJigyoKogakuTmpProcessEntity3> select高額介護サービス費給付対象者合計(KyufuJissekiKihonKogakuMybatisParameter param);

    /**
     * DB出力(給付実績中間事業高額一時）の更新メッソドです。
     *
     * @param entity TempKyufujissekiTyukannJigyoEntity
     */
    void update給付実績中間事業高額一時(TempKyufujissekiTyukannJigyoEntity entity);

    /**
     * select給付実績集計メソッドです。
     *
     * @param parameter KyufuJissekiKihonKogakuMybatisParameter
     * @return List<DbT3033KyufujissekiShukeiEntity>
     */
    List<DbT3033KyufujissekiShukeiEntity> select給付実績集計(KyufuJissekiKihonKogakuMybatisParameter parameter);

    /**
     * select給付実績社会福祉法人軽減額メソッドです。
     *
     * @param parameter KyufuJissekiKihonKogakuMybatisParameter
     * @return List<DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity>
     */
    List<DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity> select給付実績社会福祉法人軽減額(KyufuJissekiKihonKogakuMybatisParameter parameter);

    /**
     * select境界層管理一時メソッドです。
     *
     * @return List<DbT3116KijunShunyugakuTekiyoKanriEntity>
     */
    List<DbT3116KijunShunyugakuTekiyoKanriEntity> select基準収入額適用管理一時();

    /**
     * update高額介護国保連IFマスタメソッドです。
     *
     * @param parameter UpdKogakuKokuhorenIFMstParameter
     */
    void update高額介護国保連IFマスタ(UpdKogakuKokuhorenIFMstMybatisParameter parameter);

    /**
     * update事業高額介護国保連IFマスタメソッドです。
     *
     * @param parameter UpdKogakuKokuhorenIFMstParameter
     */
    void update事業高額介護国保連IFマスタ(UpdKogakuKokuhorenIFMstMybatisParameter parameter);

    /**
     * select高額介護サービス費支給申請メソッドです。
     *
     * @return 高額介護サービス費支給申請 DbT3056KogakuShikyuShinseiEntity
     */
    List<DbT3056KogakuShikyuShinseiEntity> get高額介護サービス費支給申請();

    /**
     * select高額介護サービス費支給判定結果メソッドです。
     *
     * @return 高額介護サービス費支給判定結果 DbT3057KogakuShikyuHanteiKekkaEntity
     */
    List<DbT3057KogakuShikyuHanteiKekkaEntity> get高額介護サービス費支給判定結果();

    /**
     * select高額介護サービス費支給審査決定メソッドです。
     *
     * @return 高額介護サービス費支給審査決定 DbT3058KogakuShikyuShinsaKetteiEntity
     */
    List<DbT3058KogakuShikyuShinsaKetteiEntity> get高額介護サービス費支給審査決定();

    /**
     * select高額介護サービス費支給審査決定メソッドです。
     *
     * @return 高額介護サービス費給付対象者合計 DbT3055KogakuKyufuTaishoshaGokeiEntity
     */
    List<DbT3055KogakuKyufuTaishoshaGokeiEntity> get高額介護サービス費給付対象者合計();

    /**
     * select高額介護サービス費給付対象者明細全件更新一時メソッドです。
     *
     * @return 高額介護サービス費給付対象者明細全件更新一時 TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity
     */
    List<TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity> get高額介護サービス費給付対象者明細全件更新一時();

    /**
     * select事業高額介護サービス費給付対象者明細全件更新一時メソッドです。
     *
     * @return 事業高額介護サービス費給付対象者明細全件更新一時 TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity
     */
    List<TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity> get事業高額介護サービス費給付対象者明細全件更新一時();

    /**
     * update高額介護サービス費給付対象者合計メソッドです。
     *
     */
    void update高額介護サービス費給付対象者合計();

    /**
     * insert事業高額介護サービス費支給申請メソッドです。
     *
     * @return 事業高額介護サービス費支給申請 DbT3110JigyoKogakuShikyuShinseiEntity
     */
    List<DbT3110JigyoKogakuShikyuShinseiEntity> get事業高額介護サービス費支給申請();

    /**
     * insert事業高額介護サービス費支給判定結果メソッドです。
     *
     * @return 事業高額介護サービス費支給判定結果 DbT3111JigyoKogakuShikyuHanteiKekkaEntity
     */
    List<DbT3111JigyoKogakuShikyuHanteiKekkaEntity> get事業高額介護サービス費支給判定結果();

    /**
     * insert事業高額介護サービス費支給審査決定メソッドです。
     *
     * @return 事業高額介護サービス費支給審査決定 DbT3112KogakuShikyuShinsaKetteiEntity
     */
    List<DbT3112KogakuShikyuShinsaKetteiEntity> get事業高額介護サービス費支給審査決定();

    /**
     * insert事業高額介護サービス費給付対象者合計メソッドです。
     *
     * @return 事業高額介護サービス費給付対象者合計 DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity
     */
    List<DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity> get事業高額介護サービス費給付対象者合計();

    /**
     * update事業高額介護サービス費給付対象者合計メソッドです。
     *
     */
    void update事業高額介護サービス費給付対象者合計();

    /**
     * 高額介護サービス世帯員所得判定明細高額一時２と宛名情報の抽出メソッドです。
     *
     * @param param KyufuJissekiKihonKogakuMybatisParameter
     * @return {@link  List<TempSetaiinShotokuHanteiEntity>}
     */
    List<TempSetaiinShotokuHanteiEntity> select高額介護サービス世帯員所得判定明細高額一時２と宛名情報(KyufuJissekiKihonKogakuMybatisParameter param);

    /**
     * 事業高額介護サービス世帯員所得判定明細高額一時２と宛名情報の抽出メソッドです。
     *
     * @param param KyufuJissekiKihonKogakuMybatisParameter
     * @return {@link  List<TempSetaiinShotokuHanteiEntity>}
     */
    List<TempSetaiinShotokuHanteiEntity> select事業高額介護サービス世帯員所得判定明細高額一時２と宛名情報(KyufuJissekiKihonKogakuMybatisParameter param);

    /**
     * select給付実績中間高額一時の作成7メソッドです。
     *
     * @return List<InsKyufuJissekiChukanKogakuTmpProcess7Entity>
     */
    List<InsKyufuJissekiChukanKogakuTmpProcess7Entity> select給付実績中間高額一時の作成7();

    /**
     * select給付実績中間事業高額一時の作成7メソッドです。
     *
     * @return List<InsKyufuJissekiChukanJigyoKogakuTmpProcess7Entity>
     */
    List<InsKyufuJissekiChukanJigyoKogakuTmpProcess7Entity> select給付実績中間事業高額一時の作成7();

    /**
     * update世帯員所得判定明細一時
     *
     * @param entity TempSetaiinShotokuHanteiEntity
     */
    void update世帯員所得判定明細一時(TempSetaiinShotokuHanteiEntity entity);

    /**
     * select給付実績中間高額一時の作成8メソッドです。
     *
     * @return List<KyufuJissekiChukanKogaku8Entity>
     */
    List<KyufuJissekiChukanKogaku8Entity> select給付実績中間高額一時の作成8();

    /**
     * select給付実績中間事業高額一時の作成8メソッドです。
     *
     * @return List<KyufuJissekiChukanKogaku8Entity>
     */
    List<KyufuJissekiChukanKogaku8Entity> select給付実績中間事業高額一時の作成8();

    /**
     * insert世帯員所得判定明細一時メソッドです。
     *
     * @param entity TempSetaiinShotokuHanteiEntity
     */
    void insert世帯員所得判定明細一時(TempSetaiinShotokuHanteiEntity entity);
}
