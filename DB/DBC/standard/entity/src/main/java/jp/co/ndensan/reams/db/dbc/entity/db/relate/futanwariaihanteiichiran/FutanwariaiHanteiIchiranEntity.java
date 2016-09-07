/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaihanteiichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 負担割合判定一覧エンティティのクラスです。
 *
 * @reamsid_L DBC-4980-031 yuanzhenxia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanwariaiHanteiIchiranEntity {

    private HihokenshaNo 今回被保険者番号;
    private Code 今回更正事由;
    private FlexibleYear 今回年度;
    private RString 今回負担割合区分;
    private Decimal 今回本人合計所得金額;
    private int 今回世帯１号被保険者数;
    private FlexibleDate 今回有効開始日;
    private FlexibleDate 今回有効終了日;
    private Decimal 今回年金収入合計;
    private Decimal 今回その他の合計所得金額合計;
    private Code 前回更正事由;
    private RString 前回負担割合区分;
    private Decimal 前回本人合計所得金額;
    private int 前回世帯１号被保険者数;
    private FlexibleDate 前回有効開始日;
    private FlexibleDate 前回有効終了日;
    private Decimal 前回年金収入合計;
    private Decimal 前回その他の合計所得金額合計;
    private RString 被保険者区分コード;
    private FlexibleDate 資格取得年月日;
    private FlexibleDate 資格喪失年月日;
    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;
    private ShikibetsuCode 判定対象者識別コード;
    private RString 課税区分_減免前;
    private RString データ区分;
    private RString 要介護認定状態区分コード;
    private boolean 旧措置者フラグ;
    private RString 生活保護受給者識別コード;
    private RString 給付率;
    private AtenaMeisho 名称;

    private RString 地方公共団体コード;
    private RString 市町村名;
    private int 連番;

    /**
     * 旧措置者フラグ.
     *
     * @return 旧措置者フラグ
     */
    public boolean get旧措置者フラグ() {
        return 旧措置者フラグ;
    }

}
