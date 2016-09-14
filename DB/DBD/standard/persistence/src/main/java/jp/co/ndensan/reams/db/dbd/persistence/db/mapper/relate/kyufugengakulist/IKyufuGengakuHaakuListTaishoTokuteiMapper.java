/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.kyufugengakulist;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt32003.KyufuGengakuHaakuListTaishoTokuteiMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.KyufuGengakuHaakuListTaishoTokuteiEntity;

/**
 * 対象者把握情報リスト（バッチ）のマッパーインタフェースです。
 *
 * @reamsid_L DBD-3610-050 jinge
 */
public interface IKyufuGengakuHaakuListTaishoTokuteiMapper {

    /**
     * 対象者把握情報の取得
     *
     * @param parameter KyufuGengakuHaakuListTaishoTokuteiMybatisParameter
     * @return List<KyufuGengakuHaakuListTaishoTokuteiEntity>
     */
    List<KyufuGengakuHaakuListTaishoTokuteiEntity> get対象者把握情報(KyufuGengakuHaakuListTaishoTokuteiMybatisParameter parameter);
}
