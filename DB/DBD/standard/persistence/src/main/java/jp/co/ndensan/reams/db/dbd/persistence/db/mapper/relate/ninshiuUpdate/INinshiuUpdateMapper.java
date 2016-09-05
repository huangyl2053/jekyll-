/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.ninshiuUpdate;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd511002.NinshiuUpdateMyBatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.NinshiuUpdateEntity;

/**
 * 認定更新お知らせ通知書発行のMapperです。
 *
 * @reamsid_L DBD-2030-020 x_miaocl
 */
public interface INinshiuUpdateMapper {

    List<NinshiuUpdateEntity> get帳票出力用情報取得(NinshiuUpdateMyBatisParameter parameter);

}
