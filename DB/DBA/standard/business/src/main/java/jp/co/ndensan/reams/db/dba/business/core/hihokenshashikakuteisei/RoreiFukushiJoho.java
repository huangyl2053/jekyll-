/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokenshashikakuteisei;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 老齢福祉年金情報
 *
 * @reamsid_L DBA-0521-030 zhengshukai
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RoreiFukushiJoho implements Serializable {

    private ShikibetsuCode 識別コード;
    private RString 状態;
    private FlexibleDate 受給開始年月日;
    private FlexibleDate 受給廃止年月日;

    /**
     * 老福年金チェック処理用。
     *
     * @return 老齢福祉年金情報
     */
    public RString toRString() {
        StringBuilder builder = new StringBuilder();
        builder.append(識別コード.toString());
        builder.append(状態);
        builder.append(受給開始年月日.toString());
        builder.append(受給廃止年月日.toString());
        return new RString(builder.toString());
    }
}
