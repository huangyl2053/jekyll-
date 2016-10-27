/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futangenogakuninteisha;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbz00001.NinteishaListSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbz00001.TaishoshaIchijiTokuteiMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbz00001.NinteishaListSakuseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbz00001.TaishoshaIchijiTokuteiEntity;

/**
 * 負担限度額認定者リストのMapperクラスです。
 *
 * @reamsid_L DBD-3960-050 x_liuwei
 */
public interface IRiyoshafutangakuGengakuNinteiMapper {

    /**
     * 対象者作成データ。
     *
     * @param parameter parameter
     * @return 対象者作成データ
     */
    List<TaishoshaIchijiTokuteiEntity> get被保険者番号(TaishoshaIchijiTokuteiMybatisParameter parameter);

    /**
     * 負担限度額認定者リスト。
     *
     * @param parameter parameter
     * @return 訪問介護利用者負担額減額認定者リスト
     */
    List<NinteishaListSakuseiEntity> get負担限度額認定者リスト(NinteishaListSakuseiMybatisParameter parameter);
}
