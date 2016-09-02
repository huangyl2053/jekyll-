/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakuhaakuichiran;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者情報Entity
 *
 * @reamsid_L DBD-3610-060 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaJohoEntity {

    private RString 被保険者番号;
    private RString 識別コード;
    private RString 被保険者氏名カナ;
    private RString 被保険者氏名;
    private RString 世帯番号;
    private RString 行政区ｺｰﾄﾞ;
    private RString 行政区;
    private RString 住所コード;
    private RString 郵便番号;
    private RString 住所;

    private FlexibleDate 資格取得日;
    private FlexibleDate 資格喪失日;
    private RString 喪失事由;
    private RString 資格区分;
    private RString 住特フラグ;
    private boolean 生保フラグ;

    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;
    private RString 厚労省IF識別コード;
    private RString 要介護状態区分コード;
    private FlexibleDate 認定日;
    private boolean 申請中フラグ;
    private FlexibleDate 申請日;

    private RString 徴収権消滅期間;
    private RString 納付済み期間;
    private RString 給付額減額期間;

}
