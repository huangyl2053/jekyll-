/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 共同処理用受給者異動連絡票作成Entity
 *
 * @reamsid_L DBC-1952-020 chenaoqi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyodoshoriyoJukyushaIdoRenrakuhyoSakuseiParam {

    private FlexibleDate 日付;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private RString 異動区分コード;
    private RString 異動事由コード;
    private FlexibleDate 基本送付情報エリアの異動年月日;
    private FlexibleDate 償還送付情報エリアの異動年月日;
    private FlexibleDate 高額送付情報エリアの異動年月日;
    private RString 被保険者氏名;
    private TelNo 電話番号;
    private YubinNo 郵便番号;
    private RString 住所;
    private RString 住所カナ;
    private RString 帳票出力順序コード;
    private FlexibleDate 一時差止開始年月日;
    private FlexibleDate 一時差止終了年月日;
    private RString 一時差止区分;
    private Decimal 一時差止金額;
    private HihokenshaNo 世帯集約番号;
    private RString 世帯所得区分;
    private RString 所得区分;
    private boolean 利用者負担第２段階;
    private boolean 老齢福祉年金;
    private boolean 支給申請書出力;
    private RString 訂正区分;
    private FlexibleDate 訂正年月日;
}
