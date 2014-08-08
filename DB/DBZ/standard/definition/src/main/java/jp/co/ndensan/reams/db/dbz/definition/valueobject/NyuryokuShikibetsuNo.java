/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * 入力識別番号を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class NyuryokuShikibetsuNo implements IDbColumnMappable, IValueObject, Comparable<NyuryokuShikibetsuNo> {

    private final RString 入力識別番号;

    /**
     * 文字列を受け取り、インスタンスを生成します。
     *
     * @param 入力識別番号 入力識別番号
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public NyuryokuShikibetsuNo(RString 入力識別番号) throws NullPointerException {
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        this.入力識別番号 = 入力識別番号;
    }

    @Override
    public RString getColumnValue() {
        return 入力識別番号;
    }

    @Override
    public RString value() {
        return 入力識別番号;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.value());
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }
        return Objects.equals(this.value(), ((NyuryokuShikibetsuNo) 比較対象).value());
    }

    @Override
    public int compareTo(NyuryokuShikibetsuNo 比較対象) {
        return value().compareTo(比較対象.value());
    }
}
