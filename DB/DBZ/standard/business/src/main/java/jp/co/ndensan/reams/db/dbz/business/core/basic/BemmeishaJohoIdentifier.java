/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Value;

/**
 * 弁明者情報の識別子です。
 */
@Value
public class BemmeishaJohoIdentifier implements Serializable {

    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final ShikibetsuCode 識別コード;
    private final HihokenshaNo 原処分被保険者番号;
    private final FlexibleDate 審査請求届出日;
    private final FlexibleDate 弁明書作成日;
    private final Decimal 弁明者枝番;

    /**
     * コンストラクタです。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 識別コード 識別コード
     * @param 原処分被保険者番号 原処分被保険者番号
     * @param 審査請求届出日 審査請求届出日
     * @param 弁明書作成日 弁明書作成日
     * @param 弁明者枝番 弁明者枝番
     */
    public BemmeishaJohoIdentifier(ShoKisaiHokenshaNo 証記載保険者番号,
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日,
            FlexibleDate 弁明書作成日,
            Decimal 弁明者枝番) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.識別コード = 識別コード;
        this.原処分被保険者番号 = 原処分被保険者番号;
        this.審査請求届出日 = 審査請求届出日;
        this.弁明書作成日 = 弁明書作成日;
        this.弁明者枝番 = 弁明者枝番;
    }
}
