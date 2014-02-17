/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 認定調査依頼履歴番号を表すクラスです。
 *
 * @author N8187 久保田 英男
 */
public class NinteiChosaIraiRirekiNo implements IDbColumnMappable, IValueObject<RString> {

    private RString 認定調査依頼履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     */
    public NinteiChosaIraiRirekiNo(RString 認定調査依頼履歴番号) {
        this.認定調査依頼履歴番号 = 認定調査依頼履歴番号;
    }

    /**
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    @Override
    public RString getColumnValue() {
        return 認定調査依頼履歴番号;
    }

    @Override
    public RString value() {
        return 認定調査依頼履歴番号;
    }
}
