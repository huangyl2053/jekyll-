/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hanyolisttokubetsuchiikikasangemmen;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanyolisttokubetsuchiikikasangemmen.TokubetsuChiikiKasanGemmenMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyolisttokubetsuchiikikasangemmen.TokubetsuChiikiKasanGemmenEntity;

/**
 * 汎用リスト出力(特別地域加算減免)のマッパーインタフェースです。
 *
 * @reamsid_L DBD-3910-030 panxiaobo
 */
public interface IHanyoListTokubetsuChiikiKasanGemmenMapper {

    /**
     * 汎用リスト情報を取得します。
     *
     * @param parameter パラメータク
     * @return List<TokubetsuChiikiKasanGemmenEntity>
     */
    List<TokubetsuChiikiKasanGemmenEntity> get汎用リスト(TokubetsuChiikiKasanGemmenMybatisParameter parameter);
}
