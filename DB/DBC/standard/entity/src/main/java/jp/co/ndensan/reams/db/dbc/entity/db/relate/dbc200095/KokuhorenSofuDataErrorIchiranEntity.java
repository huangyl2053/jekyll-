/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200095;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票設計_DBCMNF1001_1_国保連送付データエラーリストのEntityクラスです
 *
 * @reamsid_L DBC-2720-060 jiangxiaolong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KokuhorenSofuDataErrorIchiranEntity {

    private HihokenshaNo 被保険者番号;
    private RString 氏名カナ;
    private RString 氏名;
    private FlexibleDate 資格取得日;
    private RString 認定要介護度;
    private FlexibleDate 認定申請日;
    private RString 居宅事業者番号;
    private FlexibleDate 特定申請日;
    private FlexibleDate 特定開始日;
    private FlexibleDate 特定終了日;
    private FlexibleDate 社福開始日;
    private FlexibleDate 社福終了日;
    private FlexibleDate 償還開始日;
    private RString エラー情報コード;
    private RString エラー情報内容;
    private FlexibleDate 資格喪失日;
    private FlexibleDate 認定開始日;
    private FlexibleDate 認定終了日;
    private FlexibleDate 居宅開始日;
    private FlexibleDate 利用申請日;
    private FlexibleDate 利用開始日;
    private FlexibleDate 利用終了日;
    private FlexibleDate 標準開始日;
    private FlexibleDate 標準終了日;
    private FlexibleDate 引下開始日;
    private FlexibleDate 作成年月日;
    private FlexibleYearMonth 処理年月;

}
