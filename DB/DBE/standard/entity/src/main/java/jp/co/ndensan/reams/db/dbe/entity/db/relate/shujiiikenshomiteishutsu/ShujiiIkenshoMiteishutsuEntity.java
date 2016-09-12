/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshomiteishutsu;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書未提出者一覧表のEntityです。
 *
 * @reamsid_L DBE-1390-150 suguangjun
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiIkenshoMiteishutsuEntity {

    private RString 保険者番号;
    private RString 保険者名;
    private RString 氏名;
    private RString 被保険者番号;
    private FlexibleDate 生年月日;
    private RString 性別;
    private FlexibleDate 申請日;
    private RString 申請区分;
    private RString 医療機関;
    private RString 主治医;
    private FlexibleDate 依頼日;
    private FlexibleDate 入手予定日;
    private FlexibleDate 直近督促日;
    private int 督促回数;
}
