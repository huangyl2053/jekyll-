/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokubetsuchoshuiraijohoichiran;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBBPR82001_1_特別徴収依頼情報一覧表
 *
 * @reamsid_L DBB-1840-060 chenyadong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChoshuIraiJohoIchiranEntity implements Serializable {

    private RString 年金保険者名称;
    private RString 市町村コード;
    private RString 市町村名称;
    private RString 保険者番号;
    private RString 被保険者氏名;
    private RString 町域コード;
    private RString 保険者名称;
    private RString 表示コード名称1;
    private RString 表示コード名称2;
    private RString 表示コード名称3;
    private RString 被保険者番号;
    private RString 年金番号;
    private RString カナ氏名;
    private RString 生年月日;
    private RString 行政区コード;
    private RString 表示コード1;
    private RString 表示コード2;
    private RString 表示コード3;
    private RString 金額1;
    private RString 金額2;
    private RString 金額3;
    private RString 識別コード;
    private RString 年金コード;
    private RString 漢字氏名;
    private RString 性別;
    private RString 郵便番号;
    private RString 住所;
}
