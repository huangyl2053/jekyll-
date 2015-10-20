/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninteichosaitemno;

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
 * 要介護認定調査の調査項目番号を表すクラスです。
 *
 */
public class NinteichosaItemNo implements Comparable<NinteichosaItemNo>, IDbColumnMappable, IValidatable, IValueObject<RString> {

    private final RString 調査項目番号;

    public static final NinteichosaItemNo EMPTY;

    /**
     * {@link NinteichosaItemNo}のEMPTY値です。
     */
    static {
        EMPTY = new NinteichosaItemNo(RString.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param 調査項目番号 調査項目番号
     */
    public NinteichosaItemNo(RString 調査項目番号) throws NullPointerException {
        this.調査項目番号 = requireNonNull(調査項目番号, UrSystemErrorMessages.値がnull.getReplacedMessage("調査項目番号"));
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link NinteichosaItemNo}が持つ調査項目番号についてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new NinteichosaItemNoValidator(this).validate();
    }

    /**
     * {@link NinteichosaItemNo}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定の調査項目番号について、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param 調査項目番号 {@link NinteichosaItemNo}となる文字列{@link RString}
     * @return {@link NinteichosaItemNo}
     * @throws IllegalArgumentException {@link NinteichosaItemNoSpec}の仕様を満たさない場合
     */
    public static NinteichosaItemNo createCheckInstance(RString 調査項目番号) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new NinteichosaItemNoValidator(new NinteichosaItemNo(調査項目番号)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new NinteichosaItemNo(調査項目番号);
    }

    @Override
    public RString value() {
        return 調査項目番号;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || !(比較対象 instanceof NinteichosaItemNo)) {
            return false;
        }
        return ((NinteichosaItemNo) 比較対象).value().equals(調査項目番号);
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = 17 * hash + Objects.hashCode(調査項目番号);
        return hash;
    }

    @Override
    public int compareTo(NinteichosaItemNo 比較対象) {
        return 調査項目番号.compareTo(比較対象.value());
    }

    @Override
    public RString getColumnValue() {
        return this.調査項目番号;
    }

    @Override
    public String toString() {
        return this.調査項目番号 == null ? "" : this.調査項目番号.toString();
    }
}
