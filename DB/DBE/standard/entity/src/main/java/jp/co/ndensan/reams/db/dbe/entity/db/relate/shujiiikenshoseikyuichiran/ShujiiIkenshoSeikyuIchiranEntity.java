/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshoseikyuichiran;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書作成料請求一覧表のEntityです。
 *
 * @reamsid_L DBE-1390-180 suguangjun
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiIkenshoSeikyuIchiranEntity {

    private RString 保険者番号;
    private RString 保険者名;
    private RString 氏名;
    private RString 被保険者番号;
    private FlexibleDate 生年月日;
    private RString 性別;
    private FlexibleDate 認定申請年月日;
    private RString 認定申請区分申請時コード;
    private RString 医療機関;
    private FlexibleDate 主治医意見書受領年月日;
    private FlexibleDate 主治医意見書記入年月日;
    private FlexibleDate 主治医意見書読取年月日;
    private RString 主治医意見書作成料;
    private RString 主治医意見書別途診療費;
    private FlexibleDate 報酬支払年月日;
}
