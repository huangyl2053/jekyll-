/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.core.benmeisyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * 弁明情報検索用パラメータです。
 */
@java.lang.SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class BenmeisyoMapperParameter implements IMyBatisParameter {

    private final ShikibetsuCode 識別コード;
    private final HihokenshaNo 被保険者番号;
    private final FlexibleDate 審査請求届出日;

    private BenmeisyoMapperParameter(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, FlexibleDate 審査請求届出日) {
        this.識別コード = 識別コード;
        this.被保険者番号 = 被保険者番号;
        this.審査請求届出日 = 審査請求届出日;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 審査請求届出日 審査請求届出日
     * @return BenmeisyoMapperParameter 弁明情報検索用パラメータ
     */
    public static BenmeisyoMapperParameter createSelectByKeyParam(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, FlexibleDate 審査請求届出日) {
        return new BenmeisyoMapperParameter(識別コード, 被保険者番号, 審査請求届出日);
    }

}
