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
 * {@link IValueObjectInfo IValueObjectInfo}のインスタンスを生成する{@link ValueObjectInfo.Builder Builder}を持ちます。
 *
 * @author N3327 三浦 凌
 */
public final class ValueObjectInfo implements IValueObjectInfo {

    private final RString theName;
    private final Unit theUnit;

    /**
     * ValueObjectの名前と、1文字を数える単位から、インスタンスを生成します。
     *
     * @param name 名前
     * @param unit 単位
     */
    private ValueObjectInfo(RString name, Unit unit) {
        this.theName = name;
        this.theUnit = unit;
    }

    @Override
    public RString getName() {
        return this.theName;
    }

    @Override
    public Unit getUnit() {
        return this.theUnit;
    }

    /**
     * {@link IValueObjectInfo IValueObjectInfo}を生成します。
     */
    public static final class Builder {

        private final RString theName;
        private Unit theUnit = Unit.桁;

        /**
         * valueObjectの名前を指定し、Builderを生成します。
         *
         * @param name valueObjectの名前
         * @throws NullPointerException 引数が{@code null}のとき
         */
        public Builder(String name) throws NullPointerException {
            this(new RString(Objects.requireNonNull(name)));
        }

        /**
         * valueObjectの名前を指定し、Builderを生成します。
         *
         * @param name valueObjectの名前
         * @throws NullPointerException 引数が{@code null}のとき
         */
        public Builder(RString name) throws NullPointerException {
            Objects.requireNonNull(name);
            this.theName = name;
        }

        /**
         * valueObjectの単位を設定します。defaultは{@link Unit#桁 桁}です。
         * 変更の必要がある場合のみ、このメソッドを呼んでください。
         *
         * @param unit valueObjectの単位
         * @return {@link IValueObjectInfo IValueObjectInfo}を生成できるインスタンス
         * @throws NullPointerException 引数が{@code null}のとき
         */
        public Builder setUnit(Unit unit) throws NullPointerException {
            Objects.requireNonNull(unit);
            this.theUnit = unit;
            return this;
        }

        /**
         * {@link IValueObjectInfo IValueObjectInfo}を生成します。
         *
         * @return {@link IValueObjectInfo IValueObjectInfo}
         */
        public IValueObjectInfo build() {
            return new ValueObjectInfo(theName, theUnit);
        }
    }
}
