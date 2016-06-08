/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.kaigodoctorcode;

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
 * 介護医師コードを表すクラスです。
 *
 */
public class KaigoDoctorCode implements Comparable<KaigoDoctorCode>, IDbColumnMappable, IValidatable, IValueObject<RString> {

    private final RString 介護医師コード;

    /**
     * {@link KaigoDoctorCode}のEMPTY格納用定数です。
     */
    public static final KaigoDoctorCode EMPTY;

    /**
     * {@link KaigoDoctorCode}のEMPTY値です。
     */
    static {
        EMPTY = new KaigoDoctorCode(RString.EMPTY);
    }

    /**
     * インスタンスを生成します。
     *
     * @param 介護医師コード 介護医師コード
     * @throws NullPointerException NullPointerException
     */
    public KaigoDoctorCode(RString 介護医師コード) throws NullPointerException {
        this.介護医師コード = requireNonNull(介護医師コード, UrSystemErrorMessages.値がnull.getReplacedMessage("契約番号"));
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link KaigoDoctorCode}が持つ介護医師コードについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new KaigoDoctorCodeValidator(this).validate();
    }

    /**
     * {@link KaigoDoctorCode}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定の介護医師コードについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param 介護医師コード {@link KaigoDoctorCode}となる文字列{@link RString}
     * @return {@link KaigoDoctorCode}
     * @throws IllegalArgumentException {@link KaigoDoctorCode}の仕様を満たさない場合
     */
    public static KaigoDoctorCode createCheckInstance(RString 介護医師コード) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new KaigoDoctorCodeValidator(new KaigoDoctorCode(介護医師コード)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new KaigoDoctorCode(介護医師コード);
    }

    @Override
    public RString value() {
        return 介護医師コード;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || !(比較対象 instanceof KaigoDoctorCode)) {
            return false;
        }
        return ((KaigoDoctorCode) 比較対象).value().equals(介護医師コード);
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = 17 * hash + Objects.hashCode(介護医師コード);
        return hash;
    }

    @Override
    public int compareTo(KaigoDoctorCode 比較対象) {
        return 介護医師コード.compareTo(比較対象.value());
    }

    @Override
    public RString getColumnValue() {
        return 介護医師コード;
    }

    @Override
    public String toString() {
        return this.介護医師コード == null ? "" : this.介護医師コード.toString();
    }
}
