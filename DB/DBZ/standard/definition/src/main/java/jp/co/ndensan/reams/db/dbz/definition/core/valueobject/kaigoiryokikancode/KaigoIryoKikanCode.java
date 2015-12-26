/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.valueobject.kaigoiryokikancode;

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
 * 介護医療機関コードを表すクラスです。
 *
 */
public class KaigoIryoKikanCode implements Comparable<KaigoIryoKikanCode>, IDbColumnMappable, IValidatable, IValueObject<RString> {

    private final RString 介護医療機関コード;

    /**
     * {@link KaigoIryoKikanCode}のEMPTY格納用定数です。
     */
    public static final KaigoIryoKikanCode EMPTY;

    /**
     * {@link KaigoIryoKikanCode}のEMPTY値です。
     */
    static {
        EMPTY = new KaigoIryoKikanCode(RString.EMPTY);
    }

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 介護医療機関コード 介護医療機関コード
     * @throws NullPointerException NullPointerException
     */
    public KaigoIryoKikanCode(RString 介護医療機関コード) throws NullPointerException {
        this.介護医療機関コード = requireNonNull(介護医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護医療機関コード"));
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link KaigoIryoKikanCode}が持つ介護医療機関コードについてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new KaigoIryoKikanCodeValidator(this).validate();
    }

    /**
     * {@link KaigoIryoKikanCode}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定の介護医療機関コードについて、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param 介護医療機関コード {@link KaigoIryoKikanCode}となる文字列{@link RString}
     * @return {@link KaigoIryoKikanCode}
     * @throws IllegalArgumentException {@link KaigoIryoKikanCode}の仕様を満たさない場合
     */
    public static KaigoIryoKikanCode createCheckInstance(RString 介護医療機関コード) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new KaigoIryoKikanCodeValidator(new KaigoIryoKikanCode(介護医療機関コード)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new KaigoIryoKikanCode(介護医療機関コード);
    }

    /**
     * 介護医療機関コードを返します。
     *
     * @return 介護医療機関コード
     */
    public RString getValue() {
        return 介護医療機関コード;
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = 17 * hash + Objects.hashCode(介護医療機関コード);
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || !(比較対象 instanceof KaigoIryoKikanCode)) {
            return false;
        }
        return ((KaigoIryoKikanCode) 比較対象).getValue().equals(介護医療機関コード);
    }

    @Override
    public int compareTo(KaigoIryoKikanCode 比較対象) {
        return 介護医療機関コード.compareTo(比較対象.getValue());
    }

    @Override
    public RString getColumnValue() {
        return 介護医療機関コード;
    }

    @Override
    public RString value() {
        return 介護医療機関コード;
    }

    @Override
    public String toString() {
        return this.介護医療機関コード == null ? "" : this.介護医療機関コード.toString();
    }
}
