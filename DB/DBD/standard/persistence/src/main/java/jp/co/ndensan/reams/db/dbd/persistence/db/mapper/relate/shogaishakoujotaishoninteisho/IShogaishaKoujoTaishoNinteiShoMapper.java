/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shogaishakoujotaishoninteisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd4030011.ShogaishaKojoTaishoshaListMyBatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd4030011.NinteishoJohoEntity;

/**
 * バッチ設計_障がい者控除対象者認定証のMapperです。
 *
 * @reamsid_L DBD-3860-030 donghj
 */
public interface IShogaishaKoujoTaishoNinteiShoMapper {

    List<NinteishoJohoEntity> 控除対象者データの取得(ShogaishaKojoTaishoshaListMyBatisParameter parameter);

}
