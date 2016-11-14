/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import lombok.Getter;
import lombok.Setter;

/**
 * 送付エラー一時エンティティ。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SoufuErrorTblEntity extends DbTableEntityBase<SoufuErrorTblEntity> implements IDbAccessable {

    private HihokenshaNo 被保険者番号;
    private RString 氏名カナ;
    private RString 氏名;
    private FlexibleDate 資格取得日;
    private FlexibleDate 資格喪失日;
    private Code 要介護状態区分コード;
    private FlexibleDate 要介護認定申請日;
    private FlexibleDate 認定開始日;
    private FlexibleDate 認定終了日;
    private JigyoshaNo 居宅事業者番号;
    private FlexibleDate 居宅適用開始日;
    private FlexibleDate 特定申請日;
    private FlexibleDate 特定適用開始日;
    private FlexibleDate 特定適用終了日;
    private FlexibleDate 利用者負担申請日;
    private FlexibleDate 利用者負担適用開始日;
    private FlexibleDate 利用者負担適用終了日;
    private FlexibleDate 社会福祉適用開始日;
    private FlexibleDate 社会福祉適用終了日;
    private FlexibleDate 標準負担適用開始日;
    private FlexibleDate 標準負担適用終了日;
    private FlexibleDate 償還払化開始日;
    private FlexibleDate 給付率引下げ開始日;
    private FlexibleDate 作成年月日;
    private RString 処理年月;
    private RString エラーコード;
    private RString エラー内容;
}
