/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ichijihanteisumidataif;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichijihanteisumidataif.IchijihanteiSumidataIftMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteisumidataif.IchijihanteiSumidataIDataShutsuryokuRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7211GaibuRenkeiDataoutputJohoEntity;

/**
 * 一次判定データ出力Mapperです。
 *
 * @reamsid_L DBE-1610-020 wanghui
 */
public interface IchijihanteiSumidataIDataShutsuryokuMapper {

    /**
     * 調査票（概況調査）サービスの状況一時テーブルをキー検索で取得します。
     *
     * @param paramter IchijiHanteizumIfOutputMybitisParamter
     * @return NinteichosahyoServiceJokyoRelateEntity
     */
    List<IchijihanteiSumidataIDataShutsuryokuRelateEntity> get一次判定結果票(IchijihanteiSumidataIftMybitisParamter paramter);

    /**
     * 認定調査票（基本調査）調査項目一時テーブルをキー検索で取得します。
     *
     * @param paramter IchijiHanteizumIfOutputMybitisParamter
     * @return NinteichosahyoServiceJokyoRelateEntity
     */
    List<DbT7211GaibuRenkeiDataoutputJohoEntity> get宛名連動介護保険更新(IchijihanteiSumidataIftMybitisParamter paramter);
}
