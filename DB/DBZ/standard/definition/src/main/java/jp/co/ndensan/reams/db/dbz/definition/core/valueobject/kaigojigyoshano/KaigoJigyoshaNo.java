/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.kaigojigyoshano;

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
 * 認定調査委託先コードを表すクラスです。
 *
 */
public class KaigoJigyoshaNo implements IValueObject<RString>, IDbColumnMappable, IValidatable {

    private final RString 介護事業者番号;

    /**
     * {@link KaigoJigyoshaNo}のEMPTY格納用定数です。
     */
    public static final KaigoJigyoshaNo EMPTY;

    /**
     * {@link KaigoJigyoshaNo}のEMPTY値です。
     */
    static {
        EMPTY = new KaigoJigyoshaNo(RString.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param 介護事業者番号 認定調査委託先コード
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public KaigoJigyoshaNo(RString 介護事業者番号) throws NullPointerException {
        this.介護事業者番号 = requireNonNull(介護事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者番号"));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.介護事業者番号);
        return hash;
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link KaigoJigyoshaNo}が持つ介護事業者番号についてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new KaigoJigyoshaNoValidator(this).validate();
    }

    /**
     * {@link KaigoJigyoshaNo}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定の介護事業者番号について、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param 介護事業者番号 {@link KaigoJigyoshaNo}となる文字列{@link RString}
     * @return {@link KaigoJigyoshaNo}
     * @throws IllegalArgumentException {@link KaigoJigyoshaNo}の仕様を満たさない場合
     */
    public static KaigoJigyoshaNo createCheckInstance(RString 介護事業者番号) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new KaigoJigyoshaNoValidator(new KaigoJigyoshaNo(介護事業者番号)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new KaigoJigyoshaNo(介護事業者番号);
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }
        return ((KaigoJigyoshaNo) 比較対象).getColumnValue().equals(介護事業者番号);
    }

    @Override
    public RString getColumnValue() {
        return 介護事業者番号;
    }

    @Override
    public RString value() {
        return 介護事業者番号;
    }

    @Override
    public String toString() {
        return this.介護事業者番号 == null ? "" : this.介護事業者番号.toString();
    }
}
