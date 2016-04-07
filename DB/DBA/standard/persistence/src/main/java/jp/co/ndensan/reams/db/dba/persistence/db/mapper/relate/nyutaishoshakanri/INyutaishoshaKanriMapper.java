/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.nyutaishoshakanri;

import jp.co.ndensan.reams.db.dba.definition.mybatisprm.nyutaishoshakanri.NyutaishoshaKanriMapperParameter;

/**
 * 介護保険施設入退所者管理のマッパーインタフェースです。
 *
 * @reamsid_L DBA-0360-010 duanzhanli
 *
 */
public interface INyutaishoshaKanriMapper {

    /**
     * 介護保険施設情報件数を取得します。
     *
     * @param 入退所者情報検索条件 入退所者情報検索条件
     * @return 介護保険施設情報件数
     */
    int getHihokenshaDaichoCount(NyutaishoshaKanriMapperParameter 入退所者情報検索条件);

    /**
     * 適用除外施設情報件数を取得します。
     *
     * @param 入退所者情報検索条件 入退所者情報検索条件
     * @return 適用除外施設情報件数
     */
    int getTekiyoJogaishaCount(NyutaishoshaKanriMapperParameter 入退所者情報検索条件);

    /**
     * 住所地特例対象施設情報件数を取得します。
     *
     * @param 入退所者情報検索条件 入退所者情報検索条件
     * @return 住所地特例対象施設情報件数
     */
    int getTashichosonJushochiTokureiCount(NyutaishoshaKanriMapperParameter 入退所者情報検索条件);
}
