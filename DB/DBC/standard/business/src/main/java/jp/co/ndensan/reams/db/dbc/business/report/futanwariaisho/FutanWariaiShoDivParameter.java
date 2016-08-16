/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC100065_負担割合証parameterEntity
 *
 * @reamsid_L DBC-5010-030 surun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanWariaiShoDivParameter {

    private FlexibleDate 交付年月日;
    private RString 被保険者番号;
    private RString 住所;
    private RString カナ氏名;
    private RString 氏名;
    private FlexibleDate 生年月日;
    private RString 性別;
    private RString 負担割合上段;
    private FlexibleDate 適用期間開始日上段;
    private FlexibleDate 適用期間終了日上段;
    private RString 負担割合下段;
    private FlexibleDate 適用期間開始日下段;
    private FlexibleDate 適用期間終了日下段;
    private List<RiyoshaFutanWariaiMeisai> 利用者負担割合明細;

}
