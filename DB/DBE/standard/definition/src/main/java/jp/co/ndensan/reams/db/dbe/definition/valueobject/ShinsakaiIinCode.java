/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 審査会委員コードを表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiIinCode implements IValueObject<RString>, IDbColumnMappable {

    private final RString 審査会委員コード;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 審査会委員コード 審査会委員コード
     * @throws NullPointerException 引数にNullが渡されたとき
     */
    public ShinsakaiIinCode(RString 審査会委員コード) throws NullPointerException {
        this.審査会委員コード = requireNonNull(審査会委員コード,
                Messages.E00003.replace("審査会開催場所コード", getClass().getName()).getMessage());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.審査会委員コード);
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }
        return ((ShinsakaiIinCode) 比較対象).value().equals(審査会委員コード);
    }

    @Override
    public RString value() {
        return 審査会委員コード;
    }

    @Override
    public RString getColumnValue() {
        return 審査会委員コード;
    }
}
