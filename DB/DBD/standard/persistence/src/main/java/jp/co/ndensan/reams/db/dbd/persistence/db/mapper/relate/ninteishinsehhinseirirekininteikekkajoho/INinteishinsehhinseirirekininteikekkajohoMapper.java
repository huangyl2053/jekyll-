/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.ninteishinsehhinseirirekininteikekkajoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5610001.KoshinTaishoshaKanriMyBatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5610001.KoshinTaishoshaKanriEntity;

/**
 * 更新申請対象者情報を取得
 *
 * @reamsid_L DBD-1460-020 liuyl
 */
public interface INinteishinsehhinseirirekininteikekkajohoMapper {

    /**
     * 更新申請対象者情報を取得します。
     *
     * @param parameter KoshinTaishoshaKanriMyBatisParameter
     * @return List<KoshinTaishoshaKanriEntity>
     */
    List<KoshinTaishoshaKanriEntity> get更新申請対象者情報(KoshinTaishoshaKanriMyBatisParameter parameter);
}
