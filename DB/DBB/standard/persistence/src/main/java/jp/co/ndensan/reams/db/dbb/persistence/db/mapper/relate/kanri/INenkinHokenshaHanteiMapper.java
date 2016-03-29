/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.kanri;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年金保険者判定のマッパーインタフェースです。
 */
public interface INenkinHokenshaHanteiMapper {

    /**
     * 特別徴収グループコードを取得します。
     *
     * @param tokubetsuChoshuGimushaCode 特別徴収義務者コード
     * @return 特別徴収義務者グループコード
     */
    RString selectByKey(RString tokubetsuChoshuGimushaCode);
}
