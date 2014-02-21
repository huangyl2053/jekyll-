/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 審査会開催場所が存在する地区コードを表すクラスです。
 *
 * @author N1013 松本直樹
 */
public class ShinsakaiKaisaiBashoChikuCode implements IDbColumnMappable, IValueObject {

    private final RString shinsakaiKaisaiBashoChikuCode;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiBashoChikuCode shinsakaiKaisaiBashoChikuCode
     */
    public ShinsakaiKaisaiBashoChikuCode(RString 開催場所地区コード) {
        this.shinsakaiKaisaiBashoChikuCode = 開催場所地区コード;
    }

    /**
     * 開催場所地区コードを取得します。
     *
     * @return shinsakaiKaisaiBashoChikuCode
     */
    @Override
    public RString getColumnValue() {
        return shinsakaiKaisaiBashoChikuCode;
    }

    /**
     * 開催場所地区コードを取得します。
     *
     * @return shinsakaiKaisaiBashoChikuCode
     */
    @Override
    public RString value() {
        return shinsakaiKaisaiBashoChikuCode;
    }
}
