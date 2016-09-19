/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ichijihanteizumidatashutsuryoku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataShutsuryokuMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataShutsuryokuRelateEntity;

/**
 *
 * @author soft863
 */
public interface IchijiHanteizumiDataShutsuryokuMapper {

    /**
     * 一次判定済みデータの取得します。
     *
     * @param paramter IchijiHanteizumiDataShutsuryokuMybitisParamter
     * @return IchijiHanteizumiDataShutsuryokuRelateEntity
     */
    List<IchijiHanteizumiDataShutsuryokuRelateEntity> get一次判定済みデータ(IchijiHanteizumiDataShutsuryokuMybitisParamter paramter);

    /**
     * 一次判定済みデータの取得します。
     *
     * @param paramter IchijiHanteizumiDataShutsuryokuMybitisParamter
     * @return IchijiHanteizumiDataShutsuryokuRelateEntity
     */
    List<IchijiHanteizumiDataRelateEntity> get一次判定結果票(IchijiHanteizumiDataShutsuryokuMybitisParamter paramter);

}
