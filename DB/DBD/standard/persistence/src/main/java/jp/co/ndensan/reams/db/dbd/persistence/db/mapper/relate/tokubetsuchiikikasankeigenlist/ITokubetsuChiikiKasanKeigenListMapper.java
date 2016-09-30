/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.tokubetsuchiikikasankeigenlist;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd204010.TaishoKyufuJissekiTokuteiMybatisprmParamter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd204010.TokuchiJissekiKanriListSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd204010.KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tokubetsuchiikikasankeigenjissekikanri.TokubetsuChiikiKasanKeigenJissekiKanri;

/**
 * 審査年月最大の給付実績基本レコードを取得
 *
 * @reamsid_L DBD-3880-050 jinge
 */
public interface ITokubetsuChiikiKasanKeigenListMapper {

    /**
     * 給付実績参照キー作成情報を取得します．
     *
     * @param parameter 給付実績参照キー作成情報パラメター
     * @return 給付実績参照キー作成情報
     */
    List<KyufujissekiKihonEntity> get給付実績参照キー作成情報(TaishoKyufuJissekiTokuteiMybatisprmParamter parameter);

    /**
     * 給付実績参照キー作成情報を取得します．
     *
     * @param parameter 給付実績参照キー作成情報パラメター
     * @return 給付実績参照キー作成情報
     */
    List<TokubetsuChiikiKasanKeigenJissekiKanri> select特別地域加算軽減実績管理情報(TokuchiJissekiKanriListSakuseiMybatisParameter parameter);
}
