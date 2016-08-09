/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ichijipanteisyori;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ichijipanteisyori.IChiJiPanTeiSyoRiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijipanteisyori.IChiJiPanTeiSyoRiRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;

/**
 *
 * 認定調査データ取込（モバイル）Mapperクラスです。
 *
 * @reamsid_L DBE-1870-010 houtianpeng
 */
public interface IIChiJiPanTeiSyoRiMapper {

    /**
     * 対象者一覧の検索。
     *
     * @param parameter IChiJiPanTeiSyoRiParameter
     * @return IChiJiPanTeiSyoRiRelateEntity 対象者一覧
     */
    List<IChiJiPanTeiSyoRiRelateEntity> get対象者一覧(IChiJiPanTeiSyoRiParameter parameter);

    /**
     * 要介護認定一次判定結果情報の検索。
     *
     * @param parameter IChiJiPanTeiSyoRiParameter
     * @return DbT5116IchijiHanteiKekkaJohoEntity 要介護認定一次判定結果情報
     */
    List<DbT5116IchijiHanteiKekkaJohoEntity> get要介護認定一次判定結果情報(IChiJiPanTeiSyoRiParameter parameter);
}
