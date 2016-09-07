/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.kojinirainaiyoukoshin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 個人依頼内容更新(認定調査票・主治医意見書編集)のEntityです。
 *
 * @reamsid_L DBE-1590-020 zhangzhiming
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KojinIraiNaiyouRelateEntity {

    private Code 認定調査依頼区分コード;
    private Code 認定調査実施場所コード;
    private FlexibleDate 認定調査実施年月日;
    private RString 地区コード;
    private RString 名称;
    private RString 認定調査委託先コード;
    private RString 事業者名称;
    private RString 調査委託区分;
    private RString 認定調査員コード;
    private RString 調査員氏名;
    private RString 調査員資格;
    private TelNo 電話番号;
    private TelNo 番号;
    private boolean 家庭訪問の有無;
    private ShinseishoKanriNo 申請書管理番号;
    private int 主治医意見書作成依頼履歴番号;
    private RString 主治医意見書依頼区分;
    private int 主治医意見書作成回数;
    private Code 医師区分コード;
    private FlexibleDate 主治医意見書作成依頼年月日;
    private FlexibleDate 主治医意見書記入年月日;
    private boolean 認定情報提供希望フラグ;
    private RString 主治医コード;
    private RString 主治医氏名;
    private RString 主治医医療機関コード;
    private RString 医療機関名称;
    private YubinNo 郵便番号;
    private RString 住所;
    private RString 代表者名;
}
