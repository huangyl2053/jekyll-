/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link IValueObjectInfo IValueObjectInfo}の実装です。
 * {@link IValueObjectInfo IValueObjectInfo}のインスタンスを生成する{@link ValueObjectInfo._Builder Builder}を持ちます。
 *
 * @author N3327 三浦 凌
 */
public final class ValueObjectInfo {

    private ValueObjectInfo() {
    }

    /**
     * valueObjectの名前を指定し、{@link IValueObjectInfoBuilder Builder}を生成します。
     *
     * @param name valueObjectの名前
     * @return {@link IValueObjectInfoBuilder Builder}
     * @throws NullPointerException 引数が{@code null}のとき
     */
    public static IValueObjectInfoBuilder displayName(String name) throws NullPointerException {
        return new _Builder(name);
    }

    /**
     * valueObjectの名前を指定し、{@link IValueObjectInfoBuilder Builder}を生成します。
     *
     * @param name valueObjectの名前
     * @return {@link IValueObjectInfoBuilder Builder}
     * @throws NullPointerException 引数が{@code null}のとき
     */
    public static IValueObjectInfoBuilder displayName(RString name) throws NullPointerException {
        Objects.requireNonNull(name);
        return new _Builder(name.toString());
    }

    /**
     * valueObjectの名前と単位を指定して、{@link IValueObjectInfoBuilder Builder}を生成します。
     *
     * @param name valueObjectの名前
     * @param unit valueObjectの単位
     * @return {@link IValueObjectInfoBuilder Builder}
     * @throws NullPointerException 引数が{@code null}を含むとき
     */
    public static IValueObjectInfo of(String name, Unit unit) throws NullPointerException {
        return new _Builder(name).unit(unit).build();
    }

    /**
     * {@link IValueObjectInfo IValueObjectInfo}を生成する機能を持つことを表します。
     */
    public interface IValueObjectInfoBuilder {

        /**
         * valueObjectの単位を設定します。defaultは{@link Unit#桁 桁}です。
         * 変更の必要がある場合のみ、このメソッドを呼んでください。
         *
         * @param unit valueObjectの単位
         * @return {@link IValueObjectInfo IValueObjectInfo}を生成できるインスタンス
         * @throws NullPointerException 引数が{@code null}のとき
         */
        IValueObjectInfoBuilder unit(Unit unit) throws NullPointerException;

        /**
         * {@link IValueObjectInfo IValueObjectInfo}を生成します。
         *
         * @return {@link IValueObjectInfo IValueObjectInfo}
         */
        IValueObjectInfo build();
    }

    private static final class _Builder implements IValueObjectInfoBuilder {

        private final RString theName;
        private Unit theUnit = Unit.桁;

        private _Builder(String name) {
            Objects.requireNonNull(name);
            this.theName = new RString(name);
        }

        @Override
        public IValueObjectInfoBuilder unit(Unit unit) {
            Objects.requireNonNull(unit);
            this.theUnit = unit;
            return this;
        }

        @Override
        public IValueObjectInfo build() {
            return new _ValueObjectInfo(theName, theUnit);
        }
    }

    private static final class _ValueObjectInfo implements IValueObjectInfo {

        private final RString theName;
        private final Unit theUnit;

        private _ValueObjectInfo(RString name, Unit unit) {
            this.theName = name;
            this.theUnit = unit;
        }

        @Override
        public RString getDisplayName() {
            return this.theName;
        }

        @Override
        public Unit getUnit() {
            return this.theUnit;
        }
    }
}
