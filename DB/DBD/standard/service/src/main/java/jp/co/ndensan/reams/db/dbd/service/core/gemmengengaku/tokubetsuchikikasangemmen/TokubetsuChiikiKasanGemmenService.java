/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.tokubetsuchikikasangemmen;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmen;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuChiikiKasanGemmenParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmenEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.tokubetsuchikikasangemmen.ITokubetsuchiikiKasanGemmenMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 特別地域加算減免申請（画面）です。
 *
 * @reamsid_L DBD-3680-030 miaojin
 */
public class TokubetsuChiikiKasanGemmenService {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    TokubetsuChiikiKasanGemmenService() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 特別地域加算減免申請（画面）のIntanceを作成します。
     *
     * @return TokubetsuChiikiKasanGemmenService
     */
    public static TokubetsuChiikiKasanGemmenService createIntance() {
        return InstanceProvider.create(TokubetsuChiikiKasanGemmenService.class);
    }

    /**
     * 特別地域加算減免申請情報の取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<TokubetsuchiikiKasanGemmen>
     */
    @Transaction
    public List<TokubetsuchiikiKasanGemmen> get特別地域加算減免申請の情報(HihokenshaNo 被保険者番号) {
        List<TokubetsuchiikiKasanGemmen> 特別地域加算減免申請の情報List = new ArrayList<>();
        TokubetsuChiikiKasanGemmenParameter 検索条件 = new TokubetsuChiikiKasanGemmenParameter(
                被保険者番号, GemmenGengakuShurui.特別地域加算減免.getコード());
        ITokubetsuchiikiKasanGemmenMapper mapper = mapperProvider.create(ITokubetsuchiikiKasanGemmenMapper.class);
        List<TokubetsuchiikiKasanGemmenEntity> entityList = mapper.select特別地域加算減免申請情報の取得(検索条件);
        if (entityList != null && !entityList.isEmpty()) {
            for (TokubetsuchiikiKasanGemmenEntity entity : entityList) {
                特別地域加算減免申請の情報List.add(new TokubetsuchiikiKasanGemmen(entity));
            }
        }
        return 特別地域加算減免申請の情報List;
    }
}
