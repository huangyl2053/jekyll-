/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 異動中間高額送付一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2770-050 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class IdouChuukannKooGakuTempEntity extends DbTableEntityBase<IdouChuukannKooGakuTempEntity> implements IDbAccessable {

    @PrimaryKey
    private FlexibleDate 異動年月日;
    private RString 異動区分コード;
    private RString 受給者異動事由;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    @PrimaryKey
    private HihokenshaNo 被保険者番号;
    private RString 被保険者氏名;
    private int 履歴番号;
    private HihokenshaNo 世帯集約番号;
    private RString 世帯所得区分コード;
    private RString 所得区分コード;
    private boolean 老齢福祉年金受給有フラグ;
    private boolean 利用者負担第２段階有フラグ;
    private boolean 支給申請書出力有フラグ;
    private boolean 訂正連絡票フラグ;
    private FlexibleYearMonth 送付年月;
    private RString 訂正区分コード;
    private FlexibleDate 訂正年月日;
    private LasdecCode 市町村コード;
    private FlexibleDate 資格取得年月日;
    private FlexibleDate 資格喪失年月日;
    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;
    private RString 激変緩和境界層区分;
    private boolean 論理削除フラグ;
    private FlexibleDate 基準年月日;
    private FlexibleYear 世帯把握用所得年度;
}
