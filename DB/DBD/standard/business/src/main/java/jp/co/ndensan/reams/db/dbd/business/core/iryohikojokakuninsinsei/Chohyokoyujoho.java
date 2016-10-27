/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票固有情報クラスです。
 *
 * @reamsid_L DBD-5770-030 x_zhaowen
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class Chohyokoyujoho {

    private RString 文書番号;
    private RString 発行日;
    private RString 申請日;
    private RString 住所;
    private RString 住所１;
    private RString 住所２;
    private RString 氏名;
    private RString 氏名１;
    private RString 氏名２;
    private RString 被保険者番号;
    private RString 主治医意見書作成日;
    private RString 要介護認定の有効期間開始;
    private RString 要介護認定の有効期間終了;
    private RString 寝たきり度_B1;
    private RString 寝たきり度_B2;
    private RString 寝たきり度_C1;
    private RString 寝たきり度_C2;
    private RString 尿失禁の発生可能性;
    private RString 年;
}
