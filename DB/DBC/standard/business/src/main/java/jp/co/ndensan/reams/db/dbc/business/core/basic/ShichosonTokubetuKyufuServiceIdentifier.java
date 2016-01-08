/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Value;

/**
 * 市町村特別給付サービス内容の識別子です。
 */
@Value
public class ShichosonTokubetuKyufuServiceIdentifier implements Serializable {

    private final RString 市町村特別給付用サービスコード;
    private final FlexibleDate 市町村特別給付用サービス有効期間開始年月日;
    private final int 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 市町村特別給付用サービスコード 市町村特別給付用サービスコード
     * @param 市町村特別給付用サービス有効期間開始年月日 市町村特別給付用サービス有効期間開始年月日
     * @param 履歴番号 履歴番号
     */
    public ShichosonTokubetuKyufuServiceIdentifier(RString 市町村特別給付用サービスコード,
            FlexibleDate 市町村特別給付用サービス有効期間開始年月日,
            int 履歴番号) {
        this.市町村特別給付用サービスコード = 市町村特別給付用サービスコード;
        this.市町村特別給付用サービス有効期間開始年月日 = 市町村特別給付用サービス有効期間開始年月日;
        this.履歴番号 = 履歴番号;
    }
}
