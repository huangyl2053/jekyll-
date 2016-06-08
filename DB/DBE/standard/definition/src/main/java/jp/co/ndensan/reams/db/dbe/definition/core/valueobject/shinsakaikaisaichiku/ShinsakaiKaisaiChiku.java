/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shinsakaikaisaichiku;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 介護認定審査会の開催地区を表すクラスです。
 *
 */
public class ShinsakaiKaisaiChiku extends Code implements IValueObject<RString>, IDbColumnMappable, IValidatable {

    private RString name;

    /**
     * {@link ShinsakaiKaisaiChiku}のEMPTY値です。
     */
    public static final ShinsakaiKaisaiChiku EMPTY;

    static {
        EMPTY = new ShinsakaiKaisaiChiku(RString.EMPTY, RString.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param code コードを表す文字列
     * @param name 名称
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException コードが20桁以内で無い場合
     */
    public ShinsakaiKaisaiChiku(RString code, RString name) throws NullPointerException, IllegalArgumentException {
        super(code);
        this.name = requireNonNull(name, UrSystemErrorMessages.値がnull.getReplacedMessage("名称"));
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param code コード
     * @param name 名称
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException コードが20桁以内で無い場合
     */
    public ShinsakaiKaisaiChiku(Code code, RString name) throws NullPointerException, IllegalArgumentException {
        this(code.value(), name);
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link ShinsakaiKaisaiChiku}が持つRStringについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new ShinsakaiKaisaiChikuValidator(this).validate();
    }

    /**
     * {@link ShinsakaiKaisaiChiku}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定のRStringについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param code {@link Code}となるコード{@link Code}
     * @param name {@link RString}となる文字列{@link RString}
     * @return {@link ShinsakaiKaisaiChiku}
     * @throws IllegalArgumentException
     * {@link ShinsakaiKaisaiChikuSpec}の仕様を満たさない場合
     */
    public static ShinsakaiKaisaiChiku createCheckInstance(Code code, RString name) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new ShinsakaiKaisaiChikuValidator(new ShinsakaiKaisaiChiku(code, name)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new ShinsakaiKaisaiChiku(code, name);
    }

    @Override
    public RString value() {
        return this.name;
    }

    /**
     * 審査会開催地区のコードを表す文字列を返します。
     *
     * @return コードを表す文字列
     */
    public RString getCode() {
        return super.value();
    }

    /**
     * 審査会開催地区の名称を返します。
     *
     * @return 名称
     */
    public RString getName() {
        return name;
    }

    @Override
    public RString getColumnValue() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name == null ? "" : this.name.toString();
    }
}
