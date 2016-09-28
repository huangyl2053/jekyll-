/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.kyufugakugengakukanririsutosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt32004.KyufuGakuGengakuTainoShaMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt32004.TaishoShaKanriJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt32004.KyufuGakuGengakuTainoShaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt32004.TaishoShaKanriJohoEntity;

/**
 * 給付額減額管理リスト作成のマッパーインタフェースです。
 *
 * @reamsid_L DBD-3800-050 x_xuliang
 */
public interface IKyufuGakuGengakuKanriRisutoSakuseiMapper {

    /**
     * 対象者管理情報の取得
     *
     * @param parameter parameter
     * @return 対象者管理情報の取得
     */
    List<TaishoShaKanriJohoEntity> get対象者管理情報の取得(TaishoShaKanriJohoMybatisParameter parameter);

    /**
     * 給付額減額滞納者把握情報取得
     *
     * @param parameter parameter
     * @return 給付額減額滞納者把握情報取得
     */
    List<KyufuGakuGengakuTainoShaEntity> get給付額減額滞納者把握情報取得(KyufuGakuGengakuTainoShaMybatisParameter parameter);

}
