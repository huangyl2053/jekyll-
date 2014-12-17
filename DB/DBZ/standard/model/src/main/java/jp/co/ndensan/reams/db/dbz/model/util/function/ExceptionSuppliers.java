/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.function;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 * {@link Throwable Throwable}なオブジェクトを生成するsupplierを提供します。
 *
 * @author N3327 三浦 凌
 */
public final class ExceptionSuppliers {

    private ExceptionSuppliers() {
    }

    /**
     * {@link NullPointerException}のsupplierを返します。
     *
     * @return {@link NullPointerException}のsupplier
     */
    public static ISupplier<NullPointerException> nullPointerException() {
        return new ISupplier<NullPointerException>() {
            @Override
            public NullPointerException get() {
                return new NullPointerException();
            }
        };
    }

    /**
     * {@link NullPointerException}のsupplierを返します。
     *
     * @param message メッセージ
     * @return {@link NullPointerException}のsupplier
     */
    public static ISupplier<NullPointerException> nullPointerException(final String message) {
        Objects.requireNonNull(message, UrSystemErrorMessages.値がnull.getReplacedMessage("message"));
        return new ISupplier<NullPointerException>() {
            @Override
            public NullPointerException get() {
                return new NullPointerException(message);
            }
        };
    }

    /**
     * 指定のメッセージを持った{@link ApplicationException}を提供するsupplierを返します。
     *
     * @param message メッセージ
     * @return {@link ApplicationException}のsupplier
     */
    public static ISupplier<ApplicationException> applicationException(final String message) {
        Objects.requireNonNull(message, UrSystemErrorMessages.値がnull.getReplacedMessage("message"));
        return new ISupplier<ApplicationException>() {
            @Override
            public ApplicationException get() {
                return new ApplicationException(message);
            }
        };
    }

    /**
     * 指定のメッセージを持った{@link SystemException}を提供するsupplierを返します。
     *
     * @param message メッセージ
     * @return {@link SystemException}を提供するsupplier
     */
    public static ISupplier<SystemException> systemException(final String message) {
        Objects.requireNonNull(message, UrSystemErrorMessages.値がnull.getReplacedMessage("message"));
        return new ISupplier<SystemException>() {
            @Override
            public SystemException get() {
                return new SystemException(message);
            }
        };
    }
}
