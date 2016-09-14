/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.koshinoshirasetsuchi;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd511002.KoshinOshiraseTsuchiMyBatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.KoshinOshiraseTsuchiUpdateEntity;

/**
 * 認定更新お知らせ通知書発行のMapperです。
 *
 * @reamsid_L DBD-2030-020 x_miaocl
 */
public interface IKoshinOshiraseTsuchiMapper {

    List<KoshinOshiraseTsuchiUpdateEntity> get帳票出力用情報取得(KoshinOshiraseTsuchiMyBatisParameter parameter);

}
