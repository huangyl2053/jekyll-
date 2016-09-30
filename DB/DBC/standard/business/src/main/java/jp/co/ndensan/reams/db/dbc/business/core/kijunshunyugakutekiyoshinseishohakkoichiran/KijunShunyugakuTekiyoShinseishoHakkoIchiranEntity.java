/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugakutekiyoshinseishohakkoichiran;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票設計_DBC200088_基準収入額適用申請書一覧表
 *
 * @reamsid_L DBC-4640-060 lijian
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity {

    private RString 通番;
    private FlexibleYear 年度;
    private RString 世帯番号;
    private RString 世帯課税;
    private Decimal 総合計;
    private RString 被保番号;
    private RString 氏名;
    private ShikibetsuCode 識別コード;
    private RString 年齢;
    private FlexibleDate 生年月日;
    private Decimal 課税所得;
    private Decimal 課税所得_控除後;
    private Decimal 年金収入;
    private Decimal その他合計所得;
    private Decimal 合計;
    private RString 要介護度;
    private FlexibleDate 認定開始日;
    private FlexibleDate 認定終了日;

}
