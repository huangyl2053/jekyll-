/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninteichosajisshibashokubuncode;

import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 要介護認定調査の実施場所区分コードを扱うクラスです。
 *
 */
public class NinteichosaJisshibashoKubunCode implements Comparable<NinteichosaJisshibashoKubunCode>, IDbColumnMappable, IValidatable, IValueObject<Code> {

    private final Code code;

    public static final NinteichosaJisshibashoKubunCode EMPTY;

    /**
     * {@link NinteichosaJisshibashoKubunCode}のEMPTY値です。
     */
    static {
        EMPTY = new NinteichosaJisshibashoKubunCode(Code.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param code コード
     */
    public NinteichosaJisshibashoKubunCode(Code code) throws NullPointerException {
        this.code = requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査の実施場所区分コード"));
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link NinteichosaJisshibashoKubunCode}が持つcodeについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new NinteichosaJisshibashoKubunCodeValidator(this).validate();
    }

    /**
     * {@link NinteichosaJisshibashoKubunCode}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定のcodeについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param code {@link NinteichosaJisshibashoKubunCode}となるコード{@link Code}
     * @return {@link NinteichosaJisshibashoKubunCode}
     * @throws IllegalArgumentException
     * {@link NinteichosaJisshibashoKubunCodeSpec}の仕様を満たさない場合
     */
    public static NinteichosaJisshibashoKubunCode createCheckInstance(Code code) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new NinteichosaJisshibashoKubunCodeValidator(new NinteichosaJisshibashoKubunCode(code)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new NinteichosaJisshibashoKubunCode(code);
    }

    public Code asCode() {
        return this.code;
    }

    @Override
    public Code value() {
        return this.code;
    }

    @Override
    public int compareTo(NinteichosaJisshibashoKubunCode target) {
        return this.code.compareTo(target.asCode());
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((NinteichosaJisshibashoKubunCode) target);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.code);
        return hash;
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(NinteichosaJisshibashoKubunCode target) {
        return target.asCode().equals(this.code);
    }

    @Override
    public Code getColumnValue() {
        return this.code;
    }

    @Override
    public String toString() {
        return this.code == null ? "" : this.code.toString();
    }
}
