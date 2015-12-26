/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.shisetsucode;

import java.io.Serializable;
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
 * 施設コードを表すクラスです。
 *
 */
public final class ShisetsuCode implements IValueObject<RString>, Comparable<ShisetsuCode>, Serializable, IDbColumnMappable, IValidatable {

    private final RString 施設コード;

    /**
     * {@link ShisetsuCode}のEMPTY格納用定数です。
     */
    public static final ShisetsuCode EMPTY;

    /**
     * {@link ShisetsuCode}のEMPTY値です。
     */
    static {
        EMPTY = new ShisetsuCode(RString.EMPTY);
    }

    /**
     * 指定の値を持った、ShisetsuCodeを生成します。
     *
     * @param 施設コード 施設コードの値
     * @throws NullPointerException NullPointerException
     */
    public ShisetsuCode(RString 施設コード) throws NullPointerException {
        requireNonNull(施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage("施設コード"));
        this.施設コード = 施設コード;
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link ShisetsuCode}が持つvalueについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new ShisetsuCodeValidator(this).validate();
    }

    /**
     * {@link ShisetsuCode}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定の施設コードについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param 施設コード {@link ShisetsuCode}となる文字列{@link RString}
     * @return {@link ShisetsuCode}
     * @throws IllegalArgumentException {@link ShisetsuCode}の仕様を満たさない場合
     */
    public static ShisetsuCode createCheckInstance(RString 施設コード) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new ShisetsuCodeValidator(new ShisetsuCode(施設コード)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new ShisetsuCode(施設コード);
    }

    @Override
    public RString value() {
        return this.施設コード;
    }

    @Override
    public int compareTo(ShisetsuCode target) {
        return this.施設コード.compareTo(target.value());
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((ShisetsuCode) target);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.施設コード);
        return hash;
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(ShisetsuCode target) {
        return target.value().equals(this.施設コード);
    }

    @Override
    public RString getColumnValue() {
        return this.施設コード;
    }

    @Override
    public String toString() {
        return this.施設コード == null ? "" : this.施設コード.toString();
    }
}
