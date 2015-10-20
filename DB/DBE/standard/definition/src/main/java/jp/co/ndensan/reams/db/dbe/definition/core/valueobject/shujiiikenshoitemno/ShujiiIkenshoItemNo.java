 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shujiiikenshoitemno;

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
 * 主治医意見書の項目番号を表すクラスです。
 *
 */
public class ShujiiIkenshoItemNo implements Comparable<ShujiiIkenshoItemNo>, IValueObject<RString>, IDbColumnMappable, IValidatable {

    private final RString 項目番号;

    public static final ShujiiIkenshoItemNo EMPTY;

    /**
     * {@link ShujiiIkenshoItemNo}のEMPTY値です。
     */
    static {
        EMPTY = new ShujiiIkenshoItemNo(RString.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param 項目番号 項目番号
     */
    public ShujiiIkenshoItemNo(RString 項目番号) throws NullPointerException {
        this.項目番号 = requireNonNull(項目番号, UrSystemErrorMessages.値がnull.getReplacedMessage("項目番号"));
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link ShujiiIkenshoItemNo}が持つ項目番号についてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new ShujiiIkenshoItemNoValidator(this).validate();
    }

    /**
     * {@link ShujiiIkenshoItemNo}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定の項目番号について、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param 項目番号 {@link ShujiiIkenshoItemNo}となる文字列{@link RString}
     * @return {@link ShujiiIkenshoItemNo}
     * @throws IllegalArgumentException {@link ShujiiIkenshoItemNo}の仕様を満たさない場合
     */
    public static ShujiiIkenshoItemNo createCheckInstance(RString 項目番号) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new ShujiiIkenshoItemNoValidator(new ShujiiIkenshoItemNo(項目番号)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new ShujiiIkenshoItemNo(項目番号);
    }

    @Override
    public RString value() {
        return 項目番号;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || !(比較対象 instanceof ShujiiIkenshoItemNo)) {
            return false;
        }
        return ((ShujiiIkenshoItemNo) 比較対象).value().equals(項目番号);
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = 17 * hash + Objects.hashCode(項目番号);
        return hash;
    }

    @Override
    public int compareTo(ShujiiIkenshoItemNo 比較対象) {
        return 項目番号.compareTo(比較対象.value());
    }

    @Override
    public RString getColumnValue() {
        return this.項目番号;
    }

    @Override
    public String toString() {
        return this.項目番号 == null ? "" : this.項目番号.toString();
    }
}
