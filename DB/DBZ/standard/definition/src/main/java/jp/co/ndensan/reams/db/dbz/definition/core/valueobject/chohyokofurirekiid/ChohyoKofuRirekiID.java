/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.chohyokofurirekiid;

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
 * 帳票交付履歴IDです。
 *
 */
public class ChohyoKofuRirekiID implements IValueObject<RString>, Comparable<ChohyoKofuRirekiID>, IDbColumnMappable, IValidatable {

    private final RString 帳票交付履歴ID;

    /**
     * {@link ChohyoKofuRirekiID}のEMPTY格納用定数です。
     */
    public static final ChohyoKofuRirekiID EMPTY;

    /**
     * {@link ChohyoKofuRirekiID}のEMPTY値です。
     */
    static {
        EMPTY = new ChohyoKofuRirekiID(RString.EMPTY);
    }

    /**
     * 指定の値をもった、ChohyoKofuRirekiIDを生成します。
     *
     * @param 帳票交付履歴ID 帳票交付履歴IDに相当するRString
     * @throws NullPointerException 指定のRStringがnullのとき。
     */
    public ChohyoKofuRirekiID(RString 帳票交付履歴ID) throws NullPointerException {
        requireNonNull(帳票交付履歴ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票交付履歴ID"));
        this.帳票交付履歴ID = 帳票交付履歴ID;
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link ChohyoKofuRirekiID}が持つ帳票交付履歴IDについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new ChohyoKofuRirekiIDValidator(this).validate();
    }

    /**
     * {@link ChohyoKofuRirekiID}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定の帳票交付履歴IDについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param 帳票交付履歴ID {@link ChohyoKofuRirekiID}となる文字列{@link RString}
     * @return {@link ChohyoKofuRirekiID}
     * @throws IllegalArgumentException {@link ChohyoKofuRirekiID}の仕様を満たさない場合
     */
    public static ChohyoKofuRirekiID createCheckInstance(RString 帳票交付履歴ID) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new ChohyoKofuRirekiIDValidator(new ChohyoKofuRirekiID(帳票交付履歴ID)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new ChohyoKofuRirekiID(帳票交付履歴ID);
    }

    @Override
    public RString value() {
        return this.帳票交付履歴ID;
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((ChohyoKofuRirekiID) target);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.帳票交付履歴ID);
        return hash;
    }

    @Override
    public int compareTo(ChohyoKofuRirekiID target) {
        return this.帳票交付履歴ID.compareTo(target.value());
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(ChohyoKofuRirekiID target) {
        return target.value().equals(this.帳票交付履歴ID);
    }

    @Override
    public RString getColumnValue() {
        return this.帳票交付履歴ID;
    }

    @Override
    public String toString() {
        return this.帳票交付履歴ID == null ? "" : this.帳票交付履歴ID.toString();
    }
}
