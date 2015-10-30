/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.gogitaiyukokikankaishidate;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 合議体有効期間開始年月日を表すクラスです。
 *
 */
public class GogitaiYukoKikanKaishiDate implements IValueObject<FlexibleDate>, Comparable<GogitaiYukoKikanKaishiDate>, 
        IDbColumnMappable, IValidatable {

    private final FlexibleDate 開始年月日;

    /**
     * {@link GogitaiYukoKikanKaishiDate}のEMPTY値です。
     */
    public static final GogitaiYukoKikanKaishiDate EMPTY;

    static {
        EMPTY = new GogitaiYukoKikanKaishiDate(FlexibleDate.EMPTY);
    }

    /**
     * 引数から合議体有効期間開始年月日を受け取り、インスタンスを生成します。
     *
     * @param 開始年月日 開始年月日
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public GogitaiYukoKikanKaishiDate(FlexibleDate 開始年月日) throws NullPointerException {
        this.開始年月日 = requireNonNull(開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月日"));
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param 開始年月日 yyyyMMdd形式の年月日
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException 8桁以上の文字列が渡されたとき
     */
    public GogitaiYukoKikanKaishiDate(RString 開始年月日) throws IllegalArgumentException, NullPointerException {
        this(new FlexibleDate(開始年月日));
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param 開始年月日 yyyyMMdd形式の年月日
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException 8桁以上の文字列が渡されたとき
     */
    public GogitaiYukoKikanKaishiDate(String 開始年月日) throws IllegalArgumentException, NullPointerException {
        this(new FlexibleDate(開始年月日));
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param year 年
     * @param month 月
     * @param day 日
     * @throws IllegalArgumentException 日付と判断できない数値が渡されたとき
     */
    public GogitaiYukoKikanKaishiDate(int year, int month, int day) throws IllegalArgumentException {
        this(new FlexibleDate(year, month, day));
    }

    /**
     * DB等からコンストラクタを利用して直接マッピングされた、<br/>
     * {@link GogitaiYukoKikanKaishiDate}が持つ開始年月日についてバリデーションを実施します。
     *
     * @return {@link IValidationMessages}
     */
    @Override
    public IValidationMessages validate() {
        return new GogitaiYukoKikanKaishiDateValidator(this).validate();
    }

    /**
     * {@link GogitaiYukoKikanKaishiDate}のインスタンスをチェックロジックを用いて生成して返します。<br/>
     * 指定の開始年月日について、バリデーションを実施し、バリデーション実施結果としての、<br/>
     * {@link IValidationMessages}にメッセージが含まれていた場合に{@link IllegalArgumentException}をthrowします。<br/>
     *
     * @param 開始年月日 {@link GogitaiYukoKikanKaishiDate}となる開始年月日{@link 開始年月日}
     * @return {@link GogitaiYukoKikanKaishiDate}
     * @throws IllegalArgumentException
     * {@link GogitaiYukoKikanKaishiDateSpec}の仕様を満たさない場合
     */
    public static GogitaiYukoKikanKaishiDate createCheckInstance(RString 開始年月日) throws IllegalArgumentException {
        List<IValidationMessage> validResult
                = new GogitaiYukoKikanKaishiDateValidator(new GogitaiYukoKikanKaishiDate(開始年月日)).validate().getList();
        if (!validResult.isEmpty()) {
            throw new IllegalArgumentException(validResult.get(0).getMessage().evaluate());
        }
        return new GogitaiYukoKikanKaishiDate(開始年月日);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + 開始年月日.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }
        return ((GogitaiYukoKikanKaishiDate) 比較対象).value().equals(this.value());
    }

    @Override
    public FlexibleDate value() {
        return 開始年月日;
    }

    @Override
    public int compareTo(GogitaiYukoKikanKaishiDate 比較対象) {
        return 開始年月日.compareTo(比較対象.value());
    }

    @Override
    public FlexibleDate getColumnValue() {
        return this.開始年月日;
    }

    @Override
    public String toString() {
        return this.開始年月日 == null ? "" : this.開始年月日.toString();
    }
}
