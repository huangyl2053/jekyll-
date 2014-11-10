/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.function.common;

import jp.co.ndensan.reams.db.dbz.model.util.function.ISupplier;

/**
 * {@link Throwable Throwable}なオブジェクトを生成するsupplierを提供します。<br/>
 * 他のexceptionを追加する場合は、{@link #nullPointerException() nullPointerException()}を参考にしてください。
 *
 * @author N3327 三浦 凌
 */
public final class ExceptionSuppliers {

    private ExceptionSuppliers() {
    }

    /**
     * {@link Throwable Throwable}用のsupplierを生成できます。
     *
     * @param <X> 生成するexceptionの型
     */
    public interface IExceptionSupplier<X extends Throwable> extends ISupplier<X> {

        /**
         * 指定のメッセージを出力するexceptionを生成します。
         *
         * @param message exceptionが出力するメッセージ
         * @return 指定のメッセージを出力するexception
         */
        ISupplier<X> withMessage(String message);
    }

    /**
     * NullPointerExceptionのsupplierを返します。
     *
     * @return NullPointerExceptionのsupplier
     */
    public static IExceptionSupplier<NullPointerException> nullPointerException() {
        //<editor-fold defaultstate="collapsed" desc="return supplier for NullPointerException">
        return new IExceptionSupplier<NullPointerException>() {
            @Override
            public NullPointerException get() {
                return new NullPointerException();
            }

            @Override
            public ISupplier<NullPointerException> withMessage(final String message) {
                return new ISupplier<NullPointerException>() {
                    @Override
                    public NullPointerException get() {
                        return new NullPointerException(message);
                    }
                };
            }
        };
        //</editor-fold>
    }
}
