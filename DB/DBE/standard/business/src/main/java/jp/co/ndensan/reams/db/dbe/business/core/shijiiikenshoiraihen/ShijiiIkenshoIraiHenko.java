/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shijiiikenshoiraihen;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書作成依頼変更者一覧表のパラメータクラスです。
 *
 * @reamsid_L DBE-1390-140 suguangjun
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShijiiIkenshoIraiHenko {

    private RString 保険者番号;
    private RString 保険者名;
    private RString 氏名;
    private RString 被保険者番号;
    private FlexibleDate 生年月日;
    private RString 性別;
    private FlexibleDate 認定申請年月日;
    private RString 認定申請区分申請時コード;
    private int 変更回数;
    private RString 変更前医療機関;
    private RString 変更前主治医;
    private RString 変更後医療機関;
    private RString 変更後主治医;
    private FlexibleDate 変更日;
}
