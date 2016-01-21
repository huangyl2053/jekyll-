/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.core.kanri;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kanri.NenkinHokenshaHanteiParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年金保険者判定のマッパーインタフェースです。
 */
public interface INenkinHokenshaHanteiMapper {

    /**
     * 特別徴収グループコードを取得します。
     *
     * @param parameter 年金保険者判定パラメータ
     * @return 特別徴収義務者グループコード
     */
    RString selectByKey(NenkinHokenshaHanteiParameter parameter);
}
