/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.kaigojyuminhyokoukiu;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kaigojyuminhyokoukiu.KaiGoJuminHyokouKiuMapperParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojuminhyo.KaigoJuminhyoRelateEntity;

/**
 * 介護住民票個別事項連携情報作成【広域運用】のバッチのパラメータです。
 *
 * @reamsid_L DBU-0550-020 wanghui
 *
 */
public interface IkaigojyuminhyokoukiuMapper {

    /**
     * 介護住民票個別事項連携情報を条件指定検索で複数件取得します。
     *
     * @param mapperParameter 介護住民票個別事項連携情報を特定するためのMyBatis用パラメータ
     * @return List<KaigoJuminhyoRelateEntity>
     */
    List<KaigoJuminhyoRelateEntity> getKaigoJuminhyoEntity(KaiGoJuminHyokouKiuMapperParameter mapperParameter);

}
