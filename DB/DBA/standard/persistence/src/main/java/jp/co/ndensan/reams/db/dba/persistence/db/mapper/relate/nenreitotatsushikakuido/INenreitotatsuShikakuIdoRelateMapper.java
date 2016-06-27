/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.nenreitotatsushikakuido;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.nenreitotatsushikakuido.AtenaMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichokoshin.ShikakuIdoTaishoshaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * ６５歳年齢到達資格異動のマッパーインタフェースです。
 *
 * @reamsid_L DBA-0330-010 xuyue
 */
public interface INenreitotatsuShikakuIdoRelateMapper {

    /**
     * 識別コードを取得します。
     *
     * @param parameter 検索条件
     * @return List<UaFt200FindShikibetsuTaishoEntity>
     */
    List<UaFt200FindShikibetsuTaishoEntity> select識別コード(AtenaMybatisParameter parameter);

    /**
     * 資格異動対象者のデータを取得します。
     *
     * @param parameter 検索条件
     * @return 資格異動対象者リスト
     */
    List<ShikakuIdoTaishoshaEntity> select資格異動対象者(AtenaMybatisParameter parameter);

}
