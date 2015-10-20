/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.valueobject.keiyakuno;

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
 * 受領委任契約番号を表すクラスです。
 *
 */
public class KeiyakuNo implements IValueObject<RString>, Comparable<KeiyakuNo>, IDbColumnMappable, IValidatable {

    private final RString 契約番号;

    public static final KeiyakuNo EMPTY;

    /**
     * {@link KeiyakuNo}のEMPTY値です。
     */
    static {
        EMPTY = new KeiyakuNo(RString.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param 契約番号 契約番号
     * @throws NullPointerException nullの場合
     *
     */
    public KeiyakuNo(RString 契約番号) throws NullPointerException {
        requireNonNull(契約番号, UrSystemErrorMessages.値がnull.getReplacedMessage("契約番号"));
        this.契約番号 = 契約番号;
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link KeiyakuNo}が持つvalueについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new KeiyakuNoValidator(this).validate();
    }

    /**
     * {@link KeiyakuNo}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定の契約番号について、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param 契約番号 {@link KeiyakuNo}となる文字列{@link RString}
     * @return {@link KeiyakuNo}
     * @throws IllegalArgumentException {@link KeiyakuNo}の仕様を満たさない場合
     */
    public static KeiyakuNo createCheckInstance(RString 契約番号) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new KeiyakuNoValidator(new KeiyakuNo(契約番号)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new KeiyakuNo(契約番号);
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null) {
            return false;
        }
        if (!(比較対象 instanceof KeiyakuNo)) {
            return false;
        }
        return ((KeiyakuNo) 比較対象).value().equals(契約番号);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.契約番号);
        return hash;
    }

    @Override
    public int compareTo(KeiyakuNo 比較対象) {
        return value().compareTo(比較対象.value());
    }

    @Override
    public RString value() {
        return this.契約番号;
    }

    @Override
    public RString getColumnValue() {
        return this.契約番号;
    }

    @Override
    public String toString() {
        return this.契約番号 == null ? "" : this.契約番号.toString();
    }
}
