/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.honnsanteifuka;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * 共同処理基本送付全件一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2770-060 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class KyodoShoriKihonSofuTempEntity extends DbTableEntityBase<KyodoShoriKihonSofuTempEntity> implements IDbAccessable {

    private FlexibleDate 異動年月日;
    private RString 異動区分コード;
    private RString 受給者異動事由;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private int 履歴番号;
    private RString 被保険者氏名;
    private YubinNo 郵便番号;
    private RString 住所カナ;
    private RString 住所;
    private TelNo 電話番号;
    private RString 帳票出力順序コード;
    private boolean 訂正連絡票フラグ;
    private FlexibleYearMonth 送付年月;
    private RString 訂正区分コード;
    private FlexibleDate 訂正年月日;
    private boolean 論理削除フラグ;
}
