/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.kyufugengakulist;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.KyufuGengakuHaakuListSakuseiEntity;

/**
 * 給付額減額滞納者把握リスト（バッチ）のマッパーインタフェースです。
 *
 * @reamsid_L DBD-3610-050 jinge
 */
public interface IKyufuGengakuHaakuListSakuseiMapper {

    /**
     * 給付額減額滞納者把握情報取得
     *
     * @return List<KyufuGengakuHaakuListSakuseiEntity>
     */
    List<KyufuGengakuHaakuListSakuseiEntity> get給付額減額滞納者把握情報();
}
