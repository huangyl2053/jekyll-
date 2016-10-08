/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110050;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110050.ShokanRenrakuhyoOutMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110050.ShokanRenrakuhyoSofuIchiranParam;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2111ShokanShinseiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2112ShokanMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.HokenshaNoShutokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.HokenshaTorikomiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsFukushiYoguTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsJutakuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsKeikakuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsKihonTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsMeisaiJutokuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsShafukuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsShisetsuRyoyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsShokujiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsShoteiShikkanTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsShukeiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsTokubetsuRyoyohiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsTokuteiNyushoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.InsTokuteiShiryohiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.getpanteitodaisyou.GetPanTeiToDaiSyouEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanrenrakuhyooutputreport.ShokanRenrakuhyoOutputReportEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;

/**
 * 償還連絡票情報作成バッチのDB操作です。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
public interface IShokanRenrakuhyoOutMapper {

    /**
     * 償還払支給申請情報を取得する。
     *
     * @param parameter ShokanRenrakuhyoOutMybatisParameter
     * @return DbT3034ShokanShinseiEntity
     */
    DbT3034ShokanShinseiEntity get送付対象取得のデータ(ShokanRenrakuhyoOutMybatisParameter parameter);

    /**
     * 被保険者がないのデータを取得する。
     *
     * @return DbWT2111ShokanShinseiTempEntity
     */
    DbWT2111ShokanShinseiTempEntity get被保険者がないのデータ();

    /**
     * 保険者番号取込のデータを取得する。
     *
     * @return HokenshaTorikomiEntity
     */
    HokenshaTorikomiEntity get保険者番号取込データ();

    /**
     * 送付ファイル作成の保険者番号を取得する。
     *
     * @return HokenshaNoShutokuEntity
     */
    HokenshaNoShutokuEntity get保険者番号データ();

    /**
     * 償還払請求基本情報データを取得する。
     *
     * @param parameter ShokanRenrakuhyoOutMybatisParameter
     * @return InsKihonTempEntity
     */
    InsKihonTempEntity get償還払請求基本情報データ(ShokanRenrakuhyoOutMybatisParameter parameter);

    /**
     * 償還払請求明細情報データを取得する。
     *
     * @param parameter ShokanRenrakuhyoOutMybatisParameter
     * @return InsMeisaiTempEntity
     */
    InsMeisaiTempEntity get償還払請求明細情報データ(ShokanRenrakuhyoOutMybatisParameter parameter);

    /**
     * 償還払請求明細・住所地特例情報データを取得する。
     *
     * @param parameter ShokanRenrakuhyoOutMybatisParameter
     * @return InsMeisaiJutokuTempEntity
     */
    InsMeisaiJutokuTempEntity get償還払請求住所地特例情報データ(ShokanRenrakuhyoOutMybatisParameter parameter);

    /**
     * 償還払請求緊急時施設療養情報データを取得する。
     *
     * @param parameter ShokanRenrakuhyoOutMybatisParameter
     * @return InsShisetsuRyoyoTempEntity
     */
    InsShisetsuRyoyoTempEntity get緊急時施設療養情報データ(ShokanRenrakuhyoOutMybatisParameter parameter);

    /**
     * 償還払請求所定疾患施設療養費情報データを取得する。
     *
     * @param parameter ShokanRenrakuhyoOutMybatisParameter
     * @return InsShoteiShikkanTempEntity
     */
    InsShoteiShikkanTempEntity get所定疾患施設療養費情報データ(ShokanRenrakuhyoOutMybatisParameter parameter);

    /**
     * 償還払請求所定疾患施設療養費情報データを取得する。
     *
     * @param parameter ShokanRenrakuhyoOutMybatisParameter
     * @return InsTokuteiShiryohiTempEntity
     */
    InsTokuteiShiryohiTempEntity get特定診療費情報データ(ShokanRenrakuhyoOutMybatisParameter parameter);

    /**
     * 償還払請求償還払請求特定診療費・特別療養費情報データを取得する。
     *
     * @param parameter ShokanRenrakuhyoOutMybatisParameter
     * @return InsTokubetsuRyoyohiTempEntity
     */
    InsTokubetsuRyoyohiTempEntity get特定診療費_特別療養費情報データ(ShokanRenrakuhyoOutMybatisParameter parameter);

    /**
     * 償還払請求食事費用情報データを取得する。
     *
     * @param parameter ShokanRenrakuhyoOutMybatisParameter
     * @return InsShokujiTempEntity
     */
    InsShokujiTempEntity get償還払請求食事費用情報データ(ShokanRenrakuhyoOutMybatisParameter parameter);

    /**
     * 償還払請求サービス計画情報データを取得する。
     *
     * @param parameter ShokanRenrakuhyoOutMybatisParameter
     * @return InsKeikakuTempEntity
     */
    InsKeikakuTempEntity getサービス計画情報データ(ShokanRenrakuhyoOutMybatisParameter parameter);

    /**
     * 償還払請求福祉用具販売費情報データを取得する。
     *
     * @param parameter ShokanRenrakuhyoOutMybatisParameter
     * @return InsFukushiYoguTempEntity
     */
    InsFukushiYoguTempEntity get福祉用具販売費情報データ(ShokanRenrakuhyoOutMybatisParameter parameter);

    /**
     * 償還払請求住宅改修情報データを取得する。
     *
     * @param parameter ShokanRenrakuhyoOutMybatisParameter
     * @return InsJutakuTempEntity
     */
    InsJutakuTempEntity get住宅改修情報データ(ShokanRenrakuhyoOutMybatisParameter parameter);

    /**
     * 償還払請求集計情報データを取得する。
     *
     * @param parameter ShokanRenrakuhyoOutMybatisParameter
     * @return InsShukeiTempEntity
     */
    InsShukeiTempEntity get償還払請求集計情報データ(ShokanRenrakuhyoOutMybatisParameter parameter);

    /**
     * 償還払請求特定入所者介護サービス費用データを取得する。
     *
     * @param parameter ShokanRenrakuhyoOutMybatisParameter
     * @return InsTokuteiNyushoTempEntity
     */
    InsTokuteiNyushoTempEntity get特定入所者介護サービス費用データ(ShokanRenrakuhyoOutMybatisParameter parameter);

    /**
     * 償還払請求社会福祉法人軽減額データを取得する。
     *
     * @param parameter ShokanRenrakuhyoOutMybatisParameter
     * @return InsShafukuTempEntity
     */
    InsShafukuTempEntity get社会福祉法人軽減額データ(ShokanRenrakuhyoOutMybatisParameter parameter);

    /**
     * 送付ファイルデータの件数を取得する。
     *
     * @param parameter ShokanRenrakuhyoOutMybatisParameter
     * @return 件数
     */
    int get送付ファイルのレコード件数(ShokanRenrakuhyoOutMybatisParameter parameter);

    /**
     * 送付ファイルデータを取得する。
     *
     * @param parameter ShokanRenrakuhyoOutMybatisParameter
     * @return DbWT2112ShokanMeisaiTempEntity
     */
    DbWT2112ShokanMeisaiTempEntity get送付ファイルデータ(ShokanRenrakuhyoOutMybatisParameter parameter);

    /**
     * 受給者の判定と受給者台帳の取得。
     *
     * @return GetPanTeiToDaiSyouEntity
     */
    GetPanTeiToDaiSyouEntity get受給者の判定と受給者台帳();

    /**
     * 償還払支給申請一時の取得。
     *
     * @return DbWT2111ShokanShinseiTempEntity
     */
    DbWT2111ShokanShinseiTempEntity get償還払支給申請一時();

    /**
     * 送付一覧表出力対象データ取得。
     *
     * @param parameter ShokanRenrakuhyoSofuIchiranParam
     * @return ShokanRenrakuhyoOutputReportEntity
     */
    ShokanRenrakuhyoOutputReportEntity get送付一覧表出力対象データ(ShokanRenrakuhyoSofuIchiranParam parameter);

    /**
     * 償還払支給申請データの取得。
     *
     * @param parameter ShokanRenrakuhyoSofuIchiranParam
     * @return DbT3034ShokanShinseiEntity
     */
    DbT3034ShokanShinseiEntity get償還払支給申請データ(ShokanRenrakuhyoSofuIchiranParam parameter);

}
