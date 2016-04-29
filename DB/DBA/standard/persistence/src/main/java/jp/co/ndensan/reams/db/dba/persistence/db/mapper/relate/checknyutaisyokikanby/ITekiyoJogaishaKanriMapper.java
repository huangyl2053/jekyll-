/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.checknyutaisyokikanby;

import jp.co.ndensan.reams.db.dba.definition.mybatisprm.checknyutaisyokikanby.ShisetsuJouHouParamer;

/**
 * 介護保険適用除外者のマッパーインタフェースです。
 *
 * @reamsid_L DBA-0410-010 zhangzhiming
 */
public interface ITekiyoJogaishaKanriMapper {

    /**
     * 資格不整合一覧情報を取得する。
     *
     * @param param param
     * @return int
     */
    int get被保険者資格不整合一覧(ShisetsuJouHouParamer param);
}
