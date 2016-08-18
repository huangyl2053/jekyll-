/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.iraijohodatatorikomi;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 依頼情報データ受取（オルカ）のクラスです。
 *
 * @reamsid_L DBE-1600-010 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IraiJohoDataTorikomiParameter {

    private RString 保険者番号;
    private RString 被保険者番号;
    private FlexibleDate 認定申請年月日;
    private RString 処理状態区分_0;
    private RString 処理状態区分_3;
    private RString 申請書管理番号;
    private RString 厚労省IF識別コード;
    private RString 主治医意見書作成依頼履歴番号;
}
