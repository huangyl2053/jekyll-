/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugaku;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 基準収入額適用申請登録_基準収入額データ
 *
 * @reamsid_L DBC-4620-010 wangkanglei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KijunShunyuShinseiDate implements Serializable {

    private static final long serialVersionUID = 1L;
    private ShikibetsuCode 識別コード;
    private HihokenshaNo 被保険者番号;
    private RString 氏名;
    private RString 氏名カナ;
    private FlexibleDate 生年月日;
    private RString 性別;
    private RString 年齢;
    private RString 続柄;
    private Decimal 公的年金;
    private Decimal 給与;
    private Decimal 年金_給与以外の収入;
    private Boolean 宛先印字者;
    private RString 受給;
    private RString 事業対象;
    private RString 住民税;
    private Decimal 合計所得金額;
    private Decimal 年金等収入;
    private Decimal 年金等所得;
    private Decimal 課税所得_控除前;
    private Decimal 課税所得_控除後;
    private Boolean 前年12月31日時点の世帯主;
    private RString 状態;
}
