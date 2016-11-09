/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokunenpoyoshiki1to2;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpoyoshiki1to2.JigyoHokokuTokeiMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpoyoshiki1to2.TempIchijiTable2MybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpoyoshiki1to2.TempIchijiTableMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpoyoshiki1to2.Yoshiki1To2ComMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpoyoshiki1to2.Yoshiki1To2ReportDataMybatisParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki1to2.JigyoHokokuReportDataRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki1to2.TempIchijiTable2Entity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki1to2.TempIchijiTableEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業状況報告年報　様式１・２のMapperクラスです。
 *
 * @reamsid_L DBU-5610-030 chengsanyuan
 */
public interface IJigyoHokokuNenpoYoshiki1To2Mapper {

    /**
     * 介護賦課・被保険者者台帳を取得する。
     *
     * @param param 事業状況報告年報　様式１・２のMyBatis用パラメータクラス
     * @return List<TempIchijiTableEntity>
     */
    List<TempIchijiTableEntity> get介護賦課被保険者者台帳(Yoshiki1To2ComMybatisParameter param);

    /**
     * 一時テーブルのデータを取得します。
     *
     * @return List<TempIchijiTableEntity>
     */
    List<TempIchijiTableEntity> get一時テーブル();

    /**
     * 事業報告統計データを削除する。
     *
     * @param param 事業状況報告年報　様式１・２のMyBatis用パラメータクラス
     */
    void delete事業報告統計データ(Yoshiki1To2ComMybatisParameter param);

    /**
     * 一時テーブルに、件数を取得する。
     *
     * @param param 事業状況報告年報　様式１・２のMyBatis用パラメータクラス
     * @return 件数
     */
    int get一時テーブルCount(TempIchijiTableMybatisParameter param);

    /**
     * 事業報告統計データにデータを追加する
     *
     * @param param 事業状況報告年報　様式１・２のMyBatis用パラメータクラス
     */
    void insert事業報告統計データ(Yoshiki1To2ComMybatisParameter param);

    /**
     * 所得第５段階の保険料率を取得する
     *
     * @param 集計年度 集計年度
     * @return 保険料率
     */
    Decimal get第５段階の保険料率(FlexibleYear 集計年度);

    /**
     * 介護賦課・被保険者者台帳を取得する。
     *
     * @return List<TempIchijiTable2Entity>
     */
    List<TempIchijiTable2Entity> get給付実績被保険者者台帳();

    /**
     * サービス項目コードの取得
     *
     * @param param 市町村コード
     * @return サービス項目コードリスト
     */
    List<ServiceKomokuCode> get一時テーブル2項目コード(TempIchijiTable2MybatisParameter param);

    /**
     * 一時テーブル2に、件数を取得する。
     *
     * @param param 事業状況報告年報　様式１・２のMyBatis用パラメータクラス
     * @return 件数
     */
    int get一時テーブル2Count(TempIchijiTable2MybatisParameter param);

    /**
     * サービス名の取得
     *
     * @param param 事業状況報告年報　様式１・２のMyBatis用パラメータクラス
     * @return サービス名
     */
    RString getサービス名(TempIchijiTable2MybatisParameter param);

    /**
     * 事業報告統計データからの集計結果値を取得します
     *
     * @param param 事業状況報告年報　様式１・２のMyBatis用パラメータクラス
     * @return 集計結果値
     */
    Decimal get集計結果値(JigyoHokokuTokeiMybatisParameter param);

    /**
     * 処理日付管理マスタの更新
     *
     * @param param MyBatis用パラメータクラス
     */
    void updateShoriDateKanri(JigyoHokokuTokeiMybatisParameter param);

    /**
     * 帳票作成のデータを取得します
     *
     * @param param MyBatis用パラメータクラス
     * @return JigyoHokokuReportDataRelateEntity
     */
    List<JigyoHokokuReportDataRelateEntity> getReportData(Yoshiki1To2ReportDataMybatisParameter param);
}
