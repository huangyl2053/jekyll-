/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 申請書管理番号を表すクラスです
 *
 * @author N8187 久保田 英男
 */
public class ShinseishoKanriNo implements IDbColumnMappable, IValueObject<RString> {

    private RString 申請書管理番号;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public ShinseishoKanriNo(RString 申請書管理番号) {
        this.申請書管理番号 = 申請書管理番号;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    @Override
    public RString getColumnValue() {
        return 申請書管理番号;
    }

    @Override
    public RString value() {
        return 申請書管理番号;
    }
}
