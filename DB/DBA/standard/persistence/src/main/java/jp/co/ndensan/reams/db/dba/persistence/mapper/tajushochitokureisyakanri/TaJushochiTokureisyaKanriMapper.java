/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.mapper.tajushochitokureisyakanri;

import jp.co.ndensan.reams.db.dba.definition.mybatis.param.tajushochitokureisya.TaJushochiTokureisyaKanriParameter;

/**
 * 施設入退所情報のリストのデータを取得です。
 *
 */
public interface TaJushochiTokureisyaKanriMapper {

    /**
     * 施設入退所情報リスト件数取得の取得処理です。
     *
     * @param 施設入退所情報リスト件数取得 TaJushochiTokureisyaKanriParameter
     * @return 施設入退所情報リスト件数
     */
    int select施設入退所情報リスト件数取得(TaJushochiTokureisyaKanriParameter 施設入退所情報リスト件数取得);
}
