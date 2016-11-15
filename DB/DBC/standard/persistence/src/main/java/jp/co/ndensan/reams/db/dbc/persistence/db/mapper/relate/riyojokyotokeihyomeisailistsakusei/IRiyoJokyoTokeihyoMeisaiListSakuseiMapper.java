/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.riyojokyotokeihyomeisailistsakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc150010.AtenaJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc150010.CreateRiyojokyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc150010.KyufuJissekiKihonMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc150010.ShutsuRyokuDataSyotkuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc150010.TankinyushoShikyugendoGakuMybatisParamter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc150010.ToukeiJukyushaTaichoDataSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3022KyufujissekiShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3025KyufujissekiKyotakuServiceEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3026KyufujissekiFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3027KyufujissekiJutakuKaishuhiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1510KyufuJissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1512JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1513RiyoJokyoTokeihyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1514ShoriKekkaKakuninListEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.KyuhuJissekiMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用状況統計表（明細リスト）作成のマッパーインタフェースです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public interface IRiyoJokyoTokeihyoMeisaiListSakuseiMapper {

    /**
     * 処理結果確認リストを取得します。
     *
     * @param param 給付実績基本情報検索用パラメータ
     * @return 処理結果確認リスト
     */
    List<DbWT1514ShoriKekkaKakuninListEntity> select処理結果確認リスト(KyufuJissekiKihonMybatisParameter param);

    /**
     * 給付実績基本情報を取得します。
     *
     * @param param 給付実績基本情報検索用パラメータ
     * @return 給付実績基本情報
     */
    List<DbT3017KyufujissekiKihonEntity> select給付実績基本(KyufuJissekiKihonMybatisParameter param);

    /**
     * 受給者台帳を取得します。
     *
     * @param param 受給者台帳検索用パラメータ
     * @return 受給者台帳情報
     */
    List<DbT4001JukyushaDaichoEntity> select受給者台帳(ToukeiJukyushaTaichoDataSakuseiMybatisParameter param);

    /**
     * 出力対象データを作成します。
     *
     * @return 出力対象データ
     */
    List<DbWT1510KyufuJissekiKihonEntity> select出力対象データ();

    /**
     * 出力対象外データを作成します。
     *
     * @return 出力対象外データ
     */
    List<DbWT1510KyufuJissekiKihonEntity> select出力対象外データ();

    /**
     * 設定区分を取得します。
     *
     * @return 設定区分
     */
    List<DbWT1510KyufuJissekiKihonEntity> select設定区分();

    /**
     * 給付実績基本一時データを全件取得します。
     *
     * @return 給付実績基本一時情報
     */
    List<DbWT1510KyufuJissekiKihonEntity> selectAll();

    /**
     * 給付実績明細データを全件取得します。
     *
     * @return 給付実績明細情報
     */
    List<KyuhuJissekiMeisaiEntity> select給付実績明細();

    /**
     * 給付実績食事費用データを全件取得します。
     *
     * @return 給付実績食事費用情報
     */
    List<DbT3022KyufujissekiShokujiHiyoEntity> select給付実績食事費用();

    /**
     * 給付実績居宅サービス計画費データを全件取得します。
     *
     * @return 給付実績居宅サービス計画費情報
     */
    List<DbT3025KyufujissekiKyotakuServiceEntity> select給付実績居宅サービス計画費();

    /**
     * 給付実績福祉用具販売費データを全件取得します。
     *
     * @return 給付実績福祉用具販売費情報
     */
    List<DbT3026KyufujissekiFukushiYoguHanbaihiEntity> select給付実績福祉用具販売費();

    /**
     * 給付実績住宅改修費データを全件取得します。
     *
     * @return 給付実績住宅改修費情報
     */
    List<DbT3027KyufujissekiJutakuKaishuhiEntity> select給付実績住宅改修費();

    /**
     * 給付実績特定入所者介護サービス費用データを全件取得します。
     *
     * @return 給付実績特定入所者介護サービス費用情報
     */
    List<DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity> select給付実績特定入所者介護サービス費用();

    /**
     * 給付実績社会福祉法人軽減額データを全件取得します。
     *
     * @return 給付実績社会福祉法人軽減額情報
     */
    List<DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity> select給付実績社会福祉法人軽減額();

    /**
     * 給付実績集計データを全件取得します。
     *
     * @return 給付実績集計情報
     */
    List<DbT3033KyufujissekiShukeiEntity> select給付実績集計();

    /**
     * 最小サービス提供年月を取得します。
     *
     * @return 給付実績基本情報
     */
    FlexibleYearMonth selectMinサービス提供年月();

    /**
     * 最大サービス提供年月を取得します。
     *
     * @return 給付実績基本情報
     */
    FlexibleYearMonth selectMaxサービス提供年月();

    /**
     * 有効認定期間開始年月を取得します。
     *
     * @return 有効認定期間開始年月
     */
    List<DbWT1512JukyushaDaichoEntity> select有効認定期間開始年月();

    /**
     * 認定有効期間終了年月を取得します。
     *
     * @return 認定有効期間終了年月
     */
    List<DbWT1512JukyushaDaichoEntity> select認定有効期間終了年月();

    /**
     * 抽出範囲外データを取得します。
     *
     * @param param 抽出範囲外データ検索用パラメータ
     *
     * @return 抽出範囲外データ
     */
    List<DbWT1512JukyushaDaichoEntity> select抽出範囲外データ(ToukeiJukyushaTaichoDataSakuseiMybatisParameter param);

    /**
     * 受給者台帳一時データを取得します。
     *
     * @return 受給者台帳一時データ
     */
    List<DbWT1512JukyushaDaichoEntity> selectAll受給者台帳一時();

    /**
     * サービス提供年月＝EMPTYの受給者台帳一時データを検索します。
     *
     * @return 受給者台帳一時データ
     */
    List<DbWT1512JukyushaDaichoEntity> select削除元データ();

    /**
     * 被保険者台帳データを検索します。
     *
     * @return 被保険者台帳データ
     */
    List<DbWT1512JukyushaDaichoEntity> select被保険者台帳データ();

    /**
     * 被保険者台帳データ対象外データを検索します。
     *
     * @return 被保険者台帳データ対象外データ
     */
    List<DbWT1512JukyushaDaichoEntity> select被保険者台帳データ対象外データ();

    /**
     * 居宅サービス計画データを検索します。
     *
     * @return 居宅サービス計画データ
     */
    List<DbWT1512JukyushaDaichoEntity> select居宅サービス計画データ();

    /**
     * 受給者台帳情報登録を検索します。
     *
     * @return 受給者台帳情報登録情報
     */
    List<DbWT1513RiyoJokyoTokeihyoEntity> select受給者台帳情報();

    /**
     * 集計データ登録①を検索します。
     *
     * @return 集計データ登録①
     */
    List<DbWT1513RiyoJokyoTokeihyoEntity> select集計データ登録1();

    /**
     * 短期入所支給限度額情報を検索します。
     *
     * @param param DBU業務コンフィグ．制度改正施行日_支給限度額一本化　の値の先頭6桁
     * @return 短期入所支給限度額情報
     */
    List<DbWT1513RiyoJokyoTokeihyoEntity> select短期入所支給限度額情報(TankinyushoShikyugendoGakuMybatisParamter param);

    /**
     * 支給限度額改訂情報を検索します。
     *
     * @return 支給限度額改訂情報
     */
    List<DbWT1513RiyoJokyoTokeihyoEntity> select支給限度額改訂情報();

    /**
     * 在宅利用率、訪問利用率、短期利用率を検索します。
     *
     * @return 在宅利用率、訪問利用率、短期利用率情報
     */
    List<DbWT1513RiyoJokyoTokeihyoEntity> select利用率情報();

    // 以下TODO
    /**
     * 集計データ登録②を検索します。
     *
     * @return 集計データ登録②
     */
    List<DbWT1512JukyushaDaichoEntity> select集計データ登録2();

    /**
     * 処理市町村名を検索します。
     *
     * @return 処理市町村名
     */
    List<DbWT1513RiyoJokyoTokeihyoEntity> select処理市町村名();

    // 以下、TODO
    /**
     * 被保険者・宛名情報を検索します。
     *
     * @param parameter 被保険者宛名検索パラメータ
     * @return 被保険者・宛名情報
     */
    List<DbWT1513RiyoJokyoTokeihyoEntity> select被保険者宛名情報(AtenaJohoMybatisParameter parameter);

    /**
     * 被保険者・宛名情報が取得できなかった利用状況統計表一時データをエラー登録する。
     *
     * @return 被保険者番号
     */
    List<RString> select被保険者宛名エラー情報();

    /**
     * 統計表出力対象データを検索します。
     *
     * @param parameter 統計表出力対象データ検索パラメータ
     * @return 統計表出力対象データ
     */
    List<DbWT1513RiyoJokyoTokeihyoEntity> select統計表出力対象データ(CreateRiyojokyoMybatisParameter parameter);

    /**
     * 利用状況一覧表出力対象データを検索します。
     *
     * @param parameter 利用状況一覧表出力対象データ検索パラメータ
     * @return 利用状況一覧表出力対象データ
     */
    List<DbWT1513RiyoJokyoTokeihyoEntity> select利用状況一覧表出力対象データ(CreateRiyojokyoMybatisParameter parameter);

    /**
     * サービス提供年月を検索します。
     *
     * @return サービス提供年月
     */
    List<FlexibleYearMonth> selectサービス提供年月();

    /**
     * 事業者名称を検索します。
     *
     * @param parameter 事業者名称検索パラメータ
     * @return サービス提供年月
     */
    List<DbWT1513RiyoJokyoTokeihyoEntity> select事業者名称(CreateRiyojokyoMybatisParameter parameter);

    /**
     * 出力対象データを検索します。
     *
     * @param parameter 出力対象データ検索パラメータ
     * @return 帳票出力対象データ
     */
    List<DbWT1513RiyoJokyoTokeihyoEntity> select帳票出力対象データ(ShutsuRyokuDataSyotkuMybatisParameter parameter);
}
