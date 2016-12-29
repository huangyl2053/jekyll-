/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査票_概況特記の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class GaikyoTokkiIdentifier implements Serializable {

    private final ShinseishoKanriNo 申請書管理番号;
    private final int 認定調査依頼履歴番号;
    private final RString 概況特記テキストイメージ区分;
    private final Code 原本マスク区分;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 概況特記テキストイメージ区分 概況特記テキストイメージ区分
     * @deprecated 原本マスク区分の主キーが追加になったことによりこのコンストラクタは不要
     */
    public GaikyoTokkiIdentifier(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString 概況特記テキストイメージ区分) {
        this.申請書管理番号 = 申請書管理番号;
        this.認定調査依頼履歴番号 = 認定調査依頼履歴番号;
        this.概況特記テキストイメージ区分 = 概況特記テキストイメージ区分;
        this.原本マスク区分 = Code.EMPTY;
    }

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 概況特記テキストイメージ区分 概況特記テキストイメージ区分
     * @param 原本マスク区分 原本マスク区分
     */
    public GaikyoTokkiIdentifier(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString 概況特記テキストイメージ区分,
            Code 原本マスク区分) {
        this.申請書管理番号 = 申請書管理番号;
        this.認定調査依頼履歴番号 = 認定調査依頼履歴番号;
        this.概況特記テキストイメージ区分 = 概況特記テキストイメージ区分;
        this.原本マスク区分 = 原本マスク区分;
    }

}
