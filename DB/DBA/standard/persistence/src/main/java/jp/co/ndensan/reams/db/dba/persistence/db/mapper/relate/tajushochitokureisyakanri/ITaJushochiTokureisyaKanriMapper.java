/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tajushochitokureisyakanri;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.tajushochitokureisyakanri.TaJushochiTokureisyaKanriParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.TaJushochiTokureisyaKan.TaJushochiTokureisyaKanRirelateEntity;

/**
 * 他住所地特例者管理のマッパーインタフェースです。
 */
public interface ITaJushochiTokureisyaKanriMapper {

    /**
     * 他市町村住所地特例情報取得します。
     *
     * @param parameter TaJushochiTokureisyaKanriParameter
     * @return TaJushochiTokureisyaKanRirelateEntity
     */
    List<TaJushochiTokureisyaKanRirelateEntity> selct他市町村住所地特例(TaJushochiTokureisyaKanriParameter parameter);

    /**
     * 入所施設種類がDBZ介護共通基盤Enum.施設種類.介護保険施設の場合に事業者名称取得します。
     *
     * @param parameter TaJushochiTokureisyaKanriParameter
     * @return AtenaMeisho
     */
    TaJushochiTokureisyaKanRirelateEntity get事業者名称_介護保険施設(TaJushochiTokureisyaKanriParameter parameter);

    /**
     * 入所施設種類がDBZ介護共通基盤Enum.施設種類.住所地特例対象施設の場合に事業者名称取得します。
     *
     * @param parameter TaJushochiTokureisyaKanriParameter
     * @return AtenaMeisho
     */
    TaJushochiTokureisyaKanRirelateEntity get事業者名称_住所地特例対象施設(TaJushochiTokureisyaKanriParameter parameter);

    /**
     * 宛名情報PSMで取得します。
     *
     * @param 宛名情報PSM検索条件 TaJushochiTokureisyaKanriParameter
     * @return TaJushochiTokureisyaKanRirelateEntity
     */
    TaJushochiTokureisyaKanRirelateEntity select宛名情報(TaJushochiTokureisyaKanriParameter 宛名情報PSM検索条件);
}
