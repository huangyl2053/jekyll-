/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.core.valueobject.saikofujiyu;

import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 被保険者証の再交付事由のクラスです。
 *
 */
public class SaikofuJiyu implements IValueObject<RString>, IDbColumnMappable, IValidatable {

    private final RString code;
    private final RString name;

    /**
     * {@link SaikofuJiyu}のEMPTY値です。
     */
    public static final SaikofuJiyu EMPTY;

    static {
        EMPTY = new SaikofuJiyu(RString.EMPTY, RString.EMPTY);
    }

    /**
     * 指定のコードと名称をもった再交付事由を生成します。
     *
     * @param code コード
     * @param name 名称
     */
    public SaikofuJiyu(RString code, RString name) throws NullPointerException {
        this.code = Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("再交付事由コード"));
        this.name = Objects.requireNonNull(name, UrSystemErrorMessages.値がnull.getReplacedMessage("再交付事由名称"));
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link SaikofuJiyu}が持つcodeについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new SaikofuJiyuValidator(this).validate();
    }

    /**
     * {@link SaikofuJiyu}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定のcodeについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param code {@link SaikofuJiyu}となる文字列{@link RString}
     * @param name {@link SaikofuJiyu}となる文字列{@link RString}
     * @return {@link SaikofuJiyu}
     * @throws IllegalArgumentException {@link SaikofuJiyuSpec}の仕様を満たさない場合
     */
    public static SaikofuJiyu createCheckInstance(RString code, RString name) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new SaikofuJiyuValidator(new SaikofuJiyu(code, name)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new SaikofuJiyu(code, name);
    }

    /**
     * 名称を取得する。
     *
     * @return 名称
     */
    public RString getName() {
        return name;
    }

    @Override
    public RString value() {
        return code;
    }

    @Override
    public RString getColumnValue() {
        return code;
    }

    @Override
    public String toString() {
        return this.code == null ? "" : this.code.toString();
    }
}
