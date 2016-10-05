/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakusogojigyoservice;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.InsertKetteiTsuchishoInfoTempMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.JigyoKogakuKetteiTsuchishoReportParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.KogakukaigoKetteiTsuchishoInfoTempParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.DbWT0203ShoriKekkaKakuninListTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempResultEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 * 高額総合事業サービス費支給（不支給）決定通知書作成する用マッパーインタフェースです。
 *
 * @reamsid_L DBC-2000-030 xicongwang
 */
public interface IKogakuJigyoServicehiShikyuKetteiTsuchishoMapper {

    /**
     * 事業高額決定通知書情報取得するメソッドです。
     *
     * @param parameter InsertKetteiTsuchishoInfoTempMybatisParameter
     * @return KetteiTsuchishoInfoTempResultEntity 通知書情報エンティティ
     */
    KetteiTsuchishoInfoTempResultEntity select事業高額決定通知書情報(InsertKetteiTsuchishoInfoTempMybatisParameter parameter);

    /**
     * 高額介護サービス費支給判定結果データ取得するメソッドです。
     *
     * @param parameter KogakukaigoKetteiTsuchishoInfoTempParameter
     * @return DbT3111JigyoKogakuShikyuHanteiKekkaEntity 判定結果エンティティ
     */
    DbT3111JigyoKogakuShikyuHanteiKekkaEntity get更新の判定結果データ(KogakukaigoKetteiTsuchishoInfoTempParameter parameter);

    /**
     * 処理日付管理マスタのMAX年度内連番取得するメソッドです。
     *
     * @param サブ業務コード サブ業務コード
     * @param 市町村コード 市町村コード
     * @param 処理名 処理名
     * @param 処理枝番 処理枝番
     * @param 年度 年度
     * @return 年度内連番
     */
    int select最大年度内連番(@Param("サブ業務コード") RString サブ業務コード, @Param("市町村コード") RString 市町村コード,
            @Param("処理名") RString 処理名, @Param("処理枝番") RString 処理枝番, @Param("年度") RString 年度);

    /**
     * 事業高額決定通知書出力データを取得します。
     *
     * @param parameter JigyoKogakuKetteiTsuchishoReportParameter
     * @return KetteiTsuchishoInfoTempEntity
     */
    KetteiTsuchishoInfoTempResultEntity get事業高額決定通知書出力データ(JigyoKogakuKetteiTsuchishoReportParameter parameter);

    /**
     * 事業高額決定通知書出力データを取得します。
     *
     * @return KetteiTsuchishoInfoTempEntity
     */
    DbWT0203ShoriKekkaKakuninListTempEntity select処理結果リスト一時TBL();

}
