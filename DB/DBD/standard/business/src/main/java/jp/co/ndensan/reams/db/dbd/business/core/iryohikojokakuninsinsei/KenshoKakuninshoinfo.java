/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書確認書情報クラスです。
 *
 * @reamsid_L DBD-5770-030 x_zhaowen
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KenshoKakuninshoinfo {

    private ShikibetsuCode 識別コード;
    private RString 被保険者番号;
    private RString 帳票分類ID;
    private RDate 作成日;
    private RString 文書番号;
    private RString 対象年;
    private RDate 申請日;
    private RDate 主治医意見書作成日;
    private RDate 認定期間開始日;
    private RDate 認定期間終了日;
    private RString 日常生活自立度;
    private RString 尿失禁の有無;

}
