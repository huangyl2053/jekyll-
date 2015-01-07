/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util;

import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 検索結果を保持します。
 *
 * @author N3327 三浦 凌
 * @param <E> 検索結果の要素の型
 */
public final class SearchResult<E> {

    private static final RString ARG_TOTAL_COUNT;
    private static final RString ARG_RECORDS;

    static {
        ARG_TOTAL_COUNT = new RString("totalCount");
        ARG_RECORDS = new RString("records");
    }
    private final int theTotalCount;
    private final IItemList<E> theRecords;
    private final boolean theExceedsLimit;

    private SearchResult(IItemList<E> records, int totalCount, boolean exceedsLimit) {
        this.theTotalCount = totalCount;
        this.theRecords = records;
        this.theExceedsLimit = exceedsLimit;
    }

    /**
     * {@link #totalCount() totalCount()}, {@link #exceedsLimit() exceedsLimit()}の戻り値を指定して{@link SearchResult}を生成します。
     *
     * @param <T> 検索結果として取得させる要素の型
     * @param totalCount {@link #totalCount() totalCount()}の戻り値
     * @param records 検索結果として取得させる要素の{@link IItemList}
     * @param exceesLimit 取得の上限を超えたかどうか
     * @return
     * 指定の{@link #totalCount() totalCount()}, {@link #exceedsLimit() exceedsLimit()}を返す{@link SearchResult}
     * @throws IllegalArgumentException 引数の{@code totalCount}が{@code 0}より小さい時
     * @throws NullPointerException 引数の{@code itemList}が{@code null}の時
     */
    public static <T> SearchResult of(IItemList<? extends T> records, int totalCount, boolean exceesLimit)
            throws IllegalArgumentException, NullPointerException {
        _requireZeroAndMore(totalCount, ARG_TOTAL_COUNT);
        _requireNonNull(records, ARG_RECORDS);
        return new SearchResult(ItemList.newItemList(records), totalCount, exceesLimit);
    }

    private static void _requireZeroAndMore(int intValue, RString name) {
        if (intValue < 0) {
            throw new IllegalArgumentException(UrErrorMessages.項目に対する制約.getMessage().replace(name.toString(), "0以上").evaluate());
        }
    }

    private static <T> void _requireNonNull(T obj, RString name) {
        Objects.requireNonNull(obj, UrSystemErrorMessages.値がnull.getReplacedMessage(name.toString()));
    }

    /**
     * {@link #totalCount() totalCount()}, {@link #exceedsLimit() exceedsLimit()}の戻り値を指定して{@link SearchResult}を生成します。
     *
     * @param <T> 検索結果として取得させる要素の型
     * @param records 検索結果として取得させる要素の{@link List}
     * @param totalCount {@link #totalCount() totalCount()}の戻り値
     * @param exceedsLimit 取得の上限を超えたかどうか
     * @return
     * 指定の{@link #totalCount() totalCount()}, {@link #exceedsLimit() exceedsLimit()}を返す{@link SearchResult}
     * @throws IllegalArgumentException 引数の{@code totalCount}が{@code 0}より小さい時
     * @throws NullPointerException 引数の{@code list}が{@code null}の時
     */
    public static <T> SearchResult of(List<? extends T> records, int totalCount, boolean exceedsLimit)
            throws IllegalArgumentException, NullPointerException {
        _requireZeroAndMore(totalCount, ARG_TOTAL_COUNT);
        _requireNonNull(records, ARG_RECORDS);
        return new SearchResult(ItemList.of(records), totalCount, exceedsLimit);
    }

    private SearchResult(IItemList<E> records, int totalCount) {
        this(records, totalCount, records.size() < totalCount);
    }

    /**
     * {@link #totalCount() totalCount()}の戻り値を指定して{@link SearchResult}を生成します。
     * DB上の該当数と実際に取得したレコードの数に違いがある場合は、このメソッドを使用して下さい。
     * 生成された{@link SearchResult}は、{@code totalCount}と{@code itemList}の{@code size}を比較して{@code totalCount}が大きい場合、
     * {@link #exceedsLimit() exceedsLimit()}で{@code true}を返します。
     *
     * @param <T> 検索結果の要素の型
     * @param records 検索結果として取得させる要素の{@link IItemList}
     * @param totalCount {@link #totalCount() totalCount()}の戻り値
     * @return 指定の{@link #totalCount()}を返す{@link SearchResult}
     * @throws IllegalArgumentException 引数の{@code totalCount}が{@code 0}より小さい時
     * @throws NullPointerException 引数の{@code itemList}が{@code null}の時
     */
    public static <T> SearchResult of(IItemList<? extends T> records, int totalCount) throws IllegalArgumentException, NullPointerException {
        _requireZeroAndMore(totalCount, ARG_TOTAL_COUNT);
        _requireNonNull(records, ARG_RECORDS);
        return new SearchResult(ItemList.newItemList(records), totalCount);
    }

    /**
     * {@link #totalCount() totalCount()}の戻り値を指定して{@link SearchResult}を生成します。
     * DB上の該当数と実際に取得したレコードの数に違いがある場合は、このメソッドを使用して下さい。
     * 生成された{@link SearchResult}は、{@code totalCount}と{@code list}の{@code size}を比較して{@code totalCount}が大きい場合、
     * {@link #exceedsLimit() exceedsLimit()}で{@code true}を返します。
     *
     * @param <T> 検索結果として取得させる要素の型
     * @param records 検索結果として取得させる要素の{@link List}
     * @param totalCount {@link #totalCount() totalCount()}の戻り値
     * @return 指定の{@link #totalCount()}を返す{@link SearchResult}
     * @throws IllegalArgumentException 引数の{@code totalCount}が{@code 0}より小さい時
     * @throws NullPointerException 引数の{@code list}が{@code null}の時
     */
    public static <T> SearchResult of(List<? extends T> records, int totalCount) throws IllegalArgumentException, NullPointerException {
        _requireNonNull(records, ARG_RECORDS);
        return SearchResult.of(ItemList.of(records), totalCount);
    }

    private SearchResult(IItemList<E> records) {
        this(records, records.size(), false);
    }

    /**
     * 検索結果のレコードから{@link SearchResult}を生成します。
     * {@link #totalCount()}は、引数のItemListの{@link ItemList#size() size()}と同じ値を返します。
     *
     * @param <T> 検索結果として取得させる要素の型
     * @param records 検索結果として取得させる要素の{@link IItemList}
     * @return {@link SearchResult}
     * @throws NullPointerException 引数の{@code itemList}が{@code null}の時
     */
    public static <T> SearchResult of(IItemList<? extends T> records) throws NullPointerException {
        _requireNonNull(records, ARG_RECORDS);
        return new SearchResult(ItemList.newItemList(records));
    }

    /**
     * 検索結果のレコードから{@link SearchResult}を生成します。
     * {@link #totalCount()}は、引数のListの{@link List#size() size()}と同じ値を返します。
     *
     * @param <T> 検索結果として取得させる要素の型
     * @param records 検索結果として取得させる要素の{@link List}
     * @return {@link SearchResult}
     * @throws NullPointerException 引数の{@code list}が{@code null}の時
     */
    public static <T> SearchResult of(List<? extends T> records) throws NullPointerException {
        _requireNonNull(records, ARG_RECORDS);
        return SearchResult.of(ItemList.of(records));
    }

    /**
     * 該当する要素数を返します。
     *
     * @return 該当する要素数
     */
    public int totalCount() {
        return this.theTotalCount;
    }

    /**
     * 検索結果として取得した要素を返します。
     *
     * @return 検索結果として取得した要素
     */
    public IItemList<E> records() {
        return this.theRecords;
    }

    /**
     * 取得の上限を超えたかどうかを返します。
     *
     * @return 取得の最大数を超えたかどうか、超えている場合は{@code true}
     */
    public boolean exceedsLimit() {
        return theExceedsLimit;
    }
}
