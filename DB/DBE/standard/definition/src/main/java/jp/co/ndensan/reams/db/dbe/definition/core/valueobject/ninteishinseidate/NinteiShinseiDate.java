/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninteishinseidate;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 認定申請年月日を表すクラスです。
 *
 */
public class NinteiShinseiDate implements IDbColumnMappable, IValidatable, IValueObject<FlexibleDate> {

    private final FlexibleDate 認定申請年月日;

    public static final NinteiShinseiDate EMPTY;

    /**
     * {@link NinteiShinseiDate}のEMPTY値です。
     */
    static {
        EMPTY = new NinteiShinseiDate(FlexibleDate.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param 認定申請年月日 認定申請年月日
     */
    public NinteiShinseiDate(FlexibleDate 認定申請年月日) throws NullPointerException {
        this.認定申請年月日 = requireNonNull(認定申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請年月日"));
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link NinteiShinseiDate}が持つ認定申請年月日についてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new NinteiShinseiDateValidator(this).validate();
    }

    /**
     * {@link NinteiShinseiDate}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定の認定申請年月日について、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param 認定申請年月日 {@link NinteiShinseiDate}となる{@link FlexibleDate}
     * @return {@link NinteiShinseiDate}
     * @throws IllegalArgumentException {@link NinteiShinseiDateSpec}の仕様を満たさない場合
     */
    public static NinteiShinseiDate createCheckInstance(FlexibleDate 認定申請年月日) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new NinteiShinseiDateValidator(new NinteiShinseiDate(認定申請年月日)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new NinteiShinseiDate(認定申請年月日);
    }

    @Override
    public FlexibleDate getColumnValue() {
        return 認定申請年月日;
    }

    @Override
    public FlexibleDate value() {
        return 認定申請年月日;
    }

    @Override
    public String toString() {
        return this.認定申請年月日 == null ? "" : this.認定申請年月日.toString();
    }
}
