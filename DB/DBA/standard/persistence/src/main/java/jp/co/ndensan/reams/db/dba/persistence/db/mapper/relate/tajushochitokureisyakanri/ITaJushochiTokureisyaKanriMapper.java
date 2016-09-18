/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tajushochitokureisyakanri;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tajushochitokureisyakanri.TaJushochiTokureisyaKanriParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.otheraddressledger.OtherAddressInfFromDBEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tajushochitokureisyakan.TaJushochiTokureisyaKanriRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tajushochitokureisyakan.TashichosonRelateEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 他住所地特例者管理のマッパーインタフェースです。
 *
 * @reamsid_L DBA-0200-020 linghuhang
 */
public interface ITaJushochiTokureisyaKanriMapper {

    /**
     * 他市町村住所地特例情報取得します。
     *
     * @param parameter TaJushochiTokureisyaKanriParameter
     * @return TaJushochiTokureisyaKanriRelateEntity
     */
    List<TaJushochiTokureisyaKanriRelateEntity> selct他市町村住所地特例(TaJushochiTokureisyaKanriParameter parameter);

    /**
     * 入所施設種類がDBZ介護共通基盤Enum.施設種類.介護保険施設の場合に事業者名称取得します。
     *
     * @param parameter TaJushochiTokureisyaKanriParameter
     * @return TaJushochiTokureisyaKanriRelateEntity
     */
    TaJushochiTokureisyaKanriRelateEntity get事業者名称_介護保険施設(TaJushochiTokureisyaKanriParameter parameter);

    /**
     * 入所施設種類がDBZ介護共通基盤Enum.施設種類.住所地特例対象施設の場合に事業者名称取得します。
     *
     * @param parameter TaJushochiTokureisyaKanriParameter
     * @return TaJushochiTokureisyaKanriRelateEntity
     */
    TaJushochiTokureisyaKanriRelateEntity get事業者名称_住所地特例対象施設(TaJushochiTokureisyaKanriParameter parameter);

    /**
     * 入所施設種類がDBZ介護共通基盤Enum.施設種類.介護保険施設の場合に事業者取得します。
     *
     * @param parameter TaJushochiTokureisyaKanriParameter
     * @return OtherAddressInfFromDBEntity
     */
    OtherAddressInfFromDBEntity get事業者_介護保険施設(TaJushochiTokureisyaKanriParameter parameter);

    /**
     * 入所施設種類がDBZ介護共通基盤Enum.施設種類.住所地特例対象施設の場合に事業者取得します。
     *
     * @param parameter TaJushochiTokureisyaKanriParameter
     * @return OtherAddressInfFromDBEntity
     */
    OtherAddressInfFromDBEntity get事業者_住所地特例対象施設(TaJushochiTokureisyaKanriParameter parameter);

    /**
     * 宛名情報PSMで取得します。
     *
     * @param 宛名情報PSM検索条件 TaJushochiTokureisyaKanriParameter
     * @return UaFt200FindShikibetsuTaishoEntity
     */
    UaFt200FindShikibetsuTaishoEntity select宛名情報(TaJushochiTokureisyaKanriParameter 宛名情報PSM検索条件);

    /**
     * 施設入退所情報リスト件数取得の取得処理です。
     *
     * @param 施設入退所情報リスト件数取得 TaJushochiTokureisyaKanriParameter
     * @return 施設入退所情報リスト件数
     */
    int select施設入退所情報リスト件数取得(
            jp.co.ndensan.reams.db.dba.definition.mybatisprm.tajushochitokureisya.TaJushochiTokureisyaKanriParameter 施設入退所情報リスト件数取得);

    /**
     * 他市町村住所地特例情報取得します。
     *
     * @param parameter TaJushochiTokureisyaKanriParameter
     * @return TashichosonRelateEntity
     */
    List<TashichosonRelateEntity> get他市町村住所地特例(TaJushochiTokureisyaKanriParameter parameter);
}
