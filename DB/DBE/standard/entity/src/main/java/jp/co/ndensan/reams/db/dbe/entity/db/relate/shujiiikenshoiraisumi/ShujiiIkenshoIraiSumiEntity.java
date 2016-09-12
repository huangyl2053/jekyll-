/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshoiraisumi;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書依頼済み一覧表のEntityです。
 *
 * @reamsid_L DBE-1390-160 suguangjun
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiIkenshoIraiSumiEntity {

    private RString 保険者番号;
    private RString 保険者名;
    private RString 氏名;
    private RString 被保険者番号;
    private FlexibleDate 生年月日;
    private RString 性別;
    private FlexibleDate 認定申請年月日;
    private RString 認定申請区分申請時コード;
    private RString 医療機関;
    private RString 主治医;
    private FlexibleDate 依頼日;
    private FlexibleDate 作成期限;
    private FlexibleDate 依頼書出力年月日;
    private FlexibleDate 意見書出力年月日;
    private FlexibleDate 請求書出力年月日;
}
