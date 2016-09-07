/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.gassanjigyobunjikofutangakukeisankekkaichiran;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 事業高額合算・事業分自己負担額計算結果一覧表クラスです
 *
 * @reamsid_L DBC-4790-040 jiangwenkai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GassanJikofutangakuKeisanKekkaIchiranEntity implements Serializable {

    private HihokenshaNo 被保険者番号;
    private RString 被保険者氏名;
    private FlexibleYearMonth 生年月日;
    private RString 性別;
    private HihokenshaNo 申請書整理番号;
    private FlexibleYearMonth 申請年月日;
    private RString 申請対象年度;
    private RString 介護加入期間_開始;
    private RString 介護加入期間_終了;
    private Decimal 一_自己負担額;
    private Decimal 二_高額支給額;
    private Decimal 一_二;
    private Decimal 自己負担額_内数;
    private RString 備考_資格期間不正;
    private RString 備考_高額支給額確認データ;
    private RString 宛名ﾃﾞｰﾀ種別;
    private RString 一覧用確認区分;
    private RString 一覧用確認区分２;
}
