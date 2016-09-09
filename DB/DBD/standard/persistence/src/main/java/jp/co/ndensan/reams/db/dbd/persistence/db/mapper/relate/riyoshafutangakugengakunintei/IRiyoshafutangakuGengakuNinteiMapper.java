/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.riyoshafutangakugengakunintei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt00003.NinteishaListSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt00003.TaishoshaIchijiTokuteiMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00003.NinteishaListSakuseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00003.TaishoshaIchijiTokuteiEntity;

/**
 * 訪問介護利用者負担額減額認定者リストのMapperクラスです。
 *
 * @reamsid_L DBD-3970-050 x_xuliang
 */
public interface IRiyoshafutangakuGengakuNinteiMapper {

    /**
     * 対象者作成データ
     *
     * @param parameter parameter
     * @return 対象者作成データ
     */
    List<TaishoshaIchijiTokuteiEntity> get減免減額(TaishoshaIchijiTokuteiMybatisParameter parameter);

    /**
     * 訪問介護利用者負担額減額認定者リスト．
     *
     * @param parameter parameter
     * @return 訪問介護利用者負担額減額認定者リスト
     */
    List<NinteishaListSakuseiEntity> get訪問介護利用者負担額減額認定者リスト(NinteishaListSakuseiMybatisParameter parameter);
}
