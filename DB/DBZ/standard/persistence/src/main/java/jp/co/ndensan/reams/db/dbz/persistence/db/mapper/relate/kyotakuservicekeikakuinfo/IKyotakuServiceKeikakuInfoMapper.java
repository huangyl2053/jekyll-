/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.kyotakuservicekeikakuinfo;

import jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikakuinfo.KyotakuServiceKeikakuInfoRelateParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kyotakuservicekeikakuinfo.KyotakuServiceKeikakuInfoRelateEntity;

/**
 *
 * 居宅サービス計画情報のマッパーインタフェースです。
 */
public interface IKyotakuServiceKeikakuInfoMapper {

    /**
     * 居宅サービス計画情報取得処理します。
     *
     * @param parameter 居宅サービス計画情報のParameterクラス
     * @return KyotakuServiceKeikakuInfoRelateEntity
     */
    KyotakuServiceKeikakuInfoRelateEntity getKyotakuServiceKeikaku(KyotakuServiceKeikakuInfoRelateParameter parameter);
}
