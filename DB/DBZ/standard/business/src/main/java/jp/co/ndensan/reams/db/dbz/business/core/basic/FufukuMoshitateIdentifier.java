/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Value;

/**
 * 不服審査申立情報の識別子です。
 */
@Value
public class FufukuMoshitateIdentifier implements Serializable {

    private final ShikibetsuCode 識別コード;
    private final HihokenshaNo 原処分被保険者番号;
    private final FlexibleDate 審査請求届出日;

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     * @param 原処分被保険者番号 原処分被保険者番号
     * @param 審査請求届出日 審査請求届出日
     */
    public FufukuMoshitateIdentifier(ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日) {
        this.識別コード = 識別コード;
        this.原処分被保険者番号 = 原処分被保険者番号;
        this.審査請求届出日 = 審査請求届出日;
    }

    /**
     * get識別コード
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return 識別コード;
    }

    /**
     * get原処分被保険者番号
     *
     * @return 原処分被保険者番号
     */
    public HihokenshaNo get原処分被保険者番号() {
        return 原処分被保険者番号;
    }

    /**
     * get審査請求届出日
     *
     * @return 審査請求届出日
     */
    public FlexibleDate get審査請求届出日() {
        return 審査請求届出日;
    }
}
