/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 納付書共通です。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NofuShoKyotsu {

    private FlexibleYear 調定年度;
    private RString 調定年度表記;
    private FlexibleYear 賦課年度;
    private RString 賦課年度表記;
    private RString 年度年分表記;
    private TsuchishoNo 通知書番号;
    private SetaiCode 世帯コード;
    private HyojiCodes 表示コード;
    private RString 科目名称;
    private RDate 発行日;
    private RString 発行日表記;
    private RString 住所;
    private RString 郵便番号;
    private RString 行政区名;
    private RString 方書;
    private AtenaMeisho 代納人氏名;
    private AtenaMeisho 被保険者氏名;
    private RString 納付者氏名;
    private RString 被代納人氏名;
    private RString 被代納人敬称;
    private RString 納付書市町村名;

}
