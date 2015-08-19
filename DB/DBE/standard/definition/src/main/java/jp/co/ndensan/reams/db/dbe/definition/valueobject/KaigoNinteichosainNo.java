/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護独自の認定調査員番号を表すクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KaigoNinteichosainNo implements Comparable<KaigoNinteichosainNo>, IValueObject {

    private final RString 介護調査員番号;

    /**
     * コンストラクタです。
     *
     * @param 介護調査員番号 介護調査員番号
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public KaigoNinteichosainNo(RString 介護調査員番号) throws NullPointerException {
        this.介護調査員番号 = requireNonNull(介護調査員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護調査員番号"));
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = 17 * hash + Objects.hashCode(介護調査員番号);
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }
        return ((KaigoNinteichosainNo) 比較対象).value().equals(介護調査員番号);
    }

    @Override
    public int compareTo(KaigoNinteichosainNo 比較対象) {
        return 介護調査員番号.compareTo(比較対象.value());
    }

    @Override
    public RString value() {
        return 介護調査員番号;
    }
}
