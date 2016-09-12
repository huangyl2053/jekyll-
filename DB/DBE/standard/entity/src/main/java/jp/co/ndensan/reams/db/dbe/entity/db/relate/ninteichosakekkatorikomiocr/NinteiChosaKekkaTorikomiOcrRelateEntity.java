/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosakekkatorikomiocr;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * s認定調査結果取込み関連データRelateEntityクラスです。
 *
 * @reamsid_L DBE-1540-010 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosaKekkaTorikomiOcrRelateEntity {

    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private RString 保険者;
    private RString 申請区分;
    private RString 厚労省IF識別コード;
    private RString 申請書管理番号;
    private int 認定調査依頼履歴番号;
    private RDateTime イメージ共有ファイルID;
    private RString 認定調査委託先コード;
    private RString 認定調査員コード;
    private Code 認定調査依頼区分コード;
    private int 認定調査回数;
}
