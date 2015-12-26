/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyotokkijiko;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査票（特記情報）の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class NinteichosahyoTokkijikoIdentifier implements Serializable {

    private final ShinseishoKanriNo 申請書管理番号;
    private final int 認定調査依頼履歴番号;
    private final RString 認定調査特記事項番号;
    private final RString 認定調査特記事項連番;
    private final RString 特記事項テキスト_イメージ区分;
    private final Code 原本マスク区分;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @param 認定調査特記事項連番 認定調査特記事項連番
     * @param 特記事項テキスト_イメージ区分 特記事項テキスト_イメージ区分
     * @param 原本マスク区分 原本マスク区分
     */
    public NinteichosahyoTokkijikoIdentifier(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString 認定調査特記事項番号,
            RString 認定調査特記事項連番,
            RString 特記事項テキスト_イメージ区分,
            Code 原本マスク区分) {
        this.申請書管理番号 = 申請書管理番号;
        this.認定調査依頼履歴番号 = 認定調査依頼履歴番号;
        this.認定調査特記事項番号 = 認定調査特記事項番号;
        this.認定調査特記事項連番 = 認定調査特記事項連番;
        this.特記事項テキスト_イメージ区分 = 特記事項テキスト_イメージ区分;
        this.原本マスク区分 = 原本マスク区分;
    }
}
