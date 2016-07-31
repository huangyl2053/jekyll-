/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.tokubetsuchikikasangemmen;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.ninteishoketteitsuchishokobetsuhakko.NinteiJohoParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmenMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmenEntity;

/**
 * 特別地域加算減免のマッパーインタフェースです。
 *
 * @reamsid_L DBD-9999-013 huangh
 */
public interface ITokubetsuchiikiKasanGemmenMapper {

    /**
     * 特別地域加算減免情報をキー検索で１件取得します。
     *
     * @param 特別地域加算減免検索条件 特別地域加算減免検索条件
     * @return TokubetsuchiikiKasanGemmenEntity
     */
    TokubetsuchiikiKasanGemmenEntity select特別地域加算減免ByKey(TokubetsuchiikiKasanGemmenMapperParameter 特別地域加算減免検索条件);

    /**
     * 特別地域加算減免情報を取得します。
     *
     * @param 特別地域加算減免検索条件 特別地域加算減免検索条件
     * @return TokubetsuchiikiKasanGemmenEntity
     */
    List<TokubetsuchiikiKasanGemmenEntity> select特別地域加算減免By被保険者番号(TokubetsuchiikiKasanGemmenMapperParameter 特別地域加算減免検索条件);

    /**
     * 被保険者番号、減免減額種類、履歴番号により、特別地域加算減免情報を取得します。
     *
     * @param parameter 特別地域加算減免検索条件
     * @return TokubetsuchiikiKasanGemmenEntity
     */
    TokubetsuchiikiKasanGemmenEntity select特別地域加算減免(NinteiJohoParameter parameter);
}
