/*
 * To change this license header;private RString choose License Headers in Project Properties.
 * To change this template file;private RString choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.iryohikojokakuninsinsei;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 医療費控除Entityクラスです。
 *
 * @reamsid_L DBD-5770-030 tz_chengpeng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class IryohiKojoEntity implements Serializable {

    private RString 被保険者番号;
    private RString 控除対象年;
    private RString データ区分;
    private FlexibleDate 登録年月日;
    private FlexibleDate 申請年月日;
    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;
    private FlexibleDate 主治医意見書受領年月日;
    private RString 日常生活自立度;
    private boolean 尿失禁の有無;
    private FlexibleDate 発行年月日;
}
