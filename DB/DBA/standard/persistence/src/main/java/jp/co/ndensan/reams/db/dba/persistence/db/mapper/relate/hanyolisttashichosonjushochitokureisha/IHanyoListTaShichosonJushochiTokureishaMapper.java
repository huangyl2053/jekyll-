/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hanyolisttashichosonjushochitokureisha;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hanyolisttashichosonjushochitokureisha.HanyoListTaShichosonJushochiTokureishaMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolisttashichosonjushochitokureisha.HanyoListTaShichosonJushochiTokureishaRelateEntity;

/**
 * 汎用リスト_他市町村住所地特例者のマッパーインタフェースです。
 *
 * @reamsid_L DBA-1590-030 yaodongsheng
 */
public interface IHanyoListTaShichosonJushochiTokureishaMapper {

    /**
     * 他市町村住所地特例者情報を取得します。
     *
     * @param parameter HanyoListTaShichosonJushochiTokureishaMybatisParameter
     * @return List<HanyoListTaShichosonJushochiTokureishaRelateEntity>
     */
    List<HanyoListTaShichosonJushochiTokureishaRelateEntity> getTaShichoson(HanyoListTaShichosonJushochiTokureishaMybatisParameter parameter);
}
