/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.core.valueobject.jushochitokureikaijojiyu;

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
 * 住所地特例適用事由のクラスです。
 *
 */
public class JushochitokureiTekiyoJiyu implements IDbColumnMappable, IValidatable, IValueObject<RString> {

    private final RString code;
    private final RString name;

    /**
     * {@link JushochitokureiTekiyoJiyu}のEMPTY値です。
     */
    public static final JushochitokureiTekiyoJiyu EMPTY;

    static {
        EMPTY = new JushochitokureiTekiyoJiyu(RString.EMPTY, RString.EMPTY);
    }

    /**
     * 指定のコードと名称をもった住所地特例適用事由を生成します。
     *
     * @param code コード
     * @param name 名称
     */
    public JushochitokureiTekiyoJiyu(RString code, RString name) throws NullPointerException {
        this.code = Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例適用事由コード"));
        this.name = Objects.requireNonNull(name, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例適用事由名称"));
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link JushochitokureiTekiyoJiyu}が持つcodeについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new JushochitokureiTekiyoJiyuValidator(this).validate();
    }

    /**
     * {@link JushochitokureiTekiyoJiyu}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定のcodeについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param code {@link JushochitokureiTekiyoJiyu}となる文字列{@link RString}
     * @param name {@link JushochitokureiTekiyoJiyu}となる文字列{@link RString}
     * @return {@link JushochitokureiTekiyoJiyu}
     * @throws IllegalArgumentException
     * {@link JushochitokureiTekiyoJiyuSpec}の仕様を満たさない場合
     */
    public static JushochitokureiTekiyoJiyu createCheckInstance(RString code, RString name) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new JushochitokureiTekiyoJiyuValidator(new JushochitokureiTekiyoJiyu(code, name)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new JushochitokureiTekiyoJiyu(code, name);
    }

    @Override
    public RString value() {
        return code;
    }

    /**
     * コードを取得する。
     *
     * @return コード
     */
    public RString getCode() {
        return code;
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
    public RString getColumnValue() {
        return this.code;
    }

    @Override
    public String toString() {
        return this.code == null ? "" : this.code.toString();
    }
}
