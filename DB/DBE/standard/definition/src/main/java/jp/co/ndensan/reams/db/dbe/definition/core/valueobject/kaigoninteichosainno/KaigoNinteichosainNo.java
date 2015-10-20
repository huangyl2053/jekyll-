/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.kaigoninteichosainno;

import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 介護独自の認定調査員番号を表すクラスです。
 *
 */
public class KaigoNinteichosainNo implements Comparable<KaigoNinteichosainNo>, IDbColumnMappable, IValidatable, IValueObject<RString> {

    private final RString 介護調査員番号;

    public static final KaigoNinteichosainNo EMPTY;

    /**
     * {@link KeiyakuNo}のEMPTY値です。
     */
    static {
        EMPTY = new KaigoNinteichosainNo(RString.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param 介護調査員番号 介護調査員番号
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public KaigoNinteichosainNo(RString 介護調査員番号) throws NullPointerException {
        this.介護調査員番号 = requireNonNull(介護調査員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護調査員番号"));
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link KaigoNinteichosainNo}が持つ介護調査員番号についてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new KaigoNinteichosainNoValidator(this).validate();
    }

    /**
     * {@link KaigoNinteichosainNo}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定の介護調査員番号について、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param 介護調査員番号 {@link KaigoNinteichosainNo}となる文字列{@link RString}
     * @return {@link KaigoNinteichosainNo}
     * @throws IllegalArgumentException
     * {@link KaigoNinteichosainNoSpec}の仕様を満たさない場合
     */
    public static KaigoNinteichosainNo createCheckInstance(RString 介護調査員番号) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new KaigoNinteichosainNoValidator(new KaigoNinteichosainNo(介護調査員番号)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new KaigoNinteichosainNo(介護調査員番号);
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

    @Override
    public RString getColumnValue() {
        return this.介護調査員番号;
    }

    @Override
    public String toString() {
        return this.介護調査員番号 == null ? "" : this.介護調査員番号.toString();
    }
}
