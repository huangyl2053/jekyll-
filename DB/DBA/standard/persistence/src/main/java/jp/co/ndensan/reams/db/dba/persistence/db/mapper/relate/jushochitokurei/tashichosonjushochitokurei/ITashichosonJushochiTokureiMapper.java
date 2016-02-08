/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.jushochitokurei.tashichosonjushochitokurei;

import jp.co.ndensan.reams.db.dba.definition.mybatisprm.jushochitokurei.tashichosonjushochitokurei.TashichosonJushochiTokureiMapperParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.jushochitokurei.tashichosonjushochitokurei.TashichosonJushochiTokureiEntity;

/**
 * 他市町村住所地特例のマッパーインタフェースです。
 */
public interface ITashichosonJushochiTokureiMapper {

    /**
     * 他市町村住所地特例情報をキー検索で１件取得します。
     *
     * @param 他市町村住所地特例検索条件 他市町村住所地特例検索条件
     * @return TashichosonJushochiTokureiEntity
     */
    TashichosonJushochiTokureiEntity select他市町村住所地特例ByKey(TashichosonJushochiTokureiMapperParameter 他市町村住所地特例検索条件);
}
