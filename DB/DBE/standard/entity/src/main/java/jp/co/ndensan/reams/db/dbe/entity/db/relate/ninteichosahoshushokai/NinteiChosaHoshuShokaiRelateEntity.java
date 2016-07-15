/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahoshushokai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査報酬照会のRelateEntityクラスです。
 *
 * @reamsid_L DBE-1940-010 jinjue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosaHoshuShokaiRelateEntity {

    private RString 認定調査委託先コード;
    private RString 事業者名称;
    private RString 認定調査員コード;
    private RString 調査員氏名;
    private FlexibleDate 認定調査依頼年月日;
    private FlexibleDate 認定調査実施年月日;
    private FlexibleDate 認定調査受領年月日;
    private Code 認定調査依頼区分コード;
    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private AtenaMeisho 被保険者氏名;
    private Code 認定調査区分コード;
    private Code 認定調査実施場所コード;
    private int 認定調査委託料;
    private ShinseishoKanriNo 申請書管理番号;
    private int 認定調査依頼履歴番号;
    private int 件数;
    private int 在宅初回;
    private int 在宅再調査;
    private int 施設初回;
    private int 施設再調査;
    private int 委託料合計;
}
