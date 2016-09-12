/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.tokubetsuchiikikasangemmen;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmen;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmenMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmenEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.tokubetsuchikikasangemmen.ITokubetsuchiikiKasanGemmenMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 【共有子Div】特別地域加算減免Finderです。
 *
 * @reamsid_L DBD-3560-070 wangjie2
 */
public class TokubetsuChiikiKasanGemmenFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    TokubetsuChiikiKasanGemmenFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 【共有子Div】特別地域加算減免FinderのIntanceを作成します。
     *
     * @return TokubetsuChiikiKasanGemmenFinder
     */
    public static TokubetsuChiikiKasanGemmenFinder createIntance() {
        return InstanceProvider.create(TokubetsuChiikiKasanGemmenFinder.class);
    }

    /**
     * 被保険者番号を使用して減免減額申請テーブルと特別地域加算減免テーブルより特別地域加算減免の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<利用者負担額減額の情報>
     */
    @Transaction
    public List<TokubetsuchiikiKasanGemmen> get申請一覧_特別地域加算減免情報(HihokenshaNo 被保険者番号) {
        ITokubetsuchiikiKasanGemmenMapper mapper = mapperProvider.create(ITokubetsuchiikiKasanGemmenMapper.class);
        List<TokubetsuchiikiKasanGemmenEntity> 申請一覧情報 = mapper.
                select特別地域加算減免By被保険者番号(TokubetsuchiikiKasanGemmenMapperParameter.createSelectByKeyParam(被保険者番号, 0));

        List<TokubetsuchiikiKasanGemmen> list = new ArrayList<>();
        for (TokubetsuchiikiKasanGemmenEntity entity : 申請一覧情報) {
            list.add(new TokubetsuchiikiKasanGemmen(entity));
        }
        return list;
    }

}
