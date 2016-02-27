/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.fukaerror;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課エラー一覧情報CSVのリストクラスです。
 *
 */
public class FukaErrorListCsvItemList implements Iterable<FukaErrorListCsvItem> {

    private final List<FukaErrorListCsvItem> itemList;

    /**
     * コンストラクタです。
     *
     * @param itemList 賦課エラー一覧EntityList
     */
    public FukaErrorListCsvItemList(List<FukaErrorListCsvItem> itemList) {
        requireNonNull(itemList, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("賦課エラー一覧EntityList", "getClass().getName()"));

        this.itemList = itemList;
    }

    /**
     * 賦課年度と通知書番号を指定し、該当する賦課エラー情報を1件取得します。<br/>
     * 対応する引数が存在しない場合、例外が発生します。
     *
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @return 賦課エラー情報
     * @throws IllegalArgumentException 指定した引数に該当する、賦課エラー情報がList内に存在しないとき
     */
    public FukaErrorListCsvItem get賦課エラー情報(RString 賦課年度, RString 通知書番号) throws IllegalArgumentException {
        for (FukaErrorListCsvItem item : itemList) {
            if (item.get賦課年度().equals(賦課年度) && item.get通知書番号().equals(通知書番号)) {
                return item;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない
                .getMessage().replace("引数に対応する賦課エラー情報").evaluate());
    }

    /**
     * Listの大きさを返します。
     *
     * @return ListSize
     */
    public int size() {
        return itemList.size();
    }

    /**
     * Listが空か否かを返します。
     *
     * @return 空ならtrue
     */
    public boolean isEmpty() {
        return itemList.isEmpty();
    }

    /**
     * 自身が持つ賦課エラー情報のListと、同じデータを持つListを新規に生成して返します。
     *
     * @return 賦課エラーList
     */
    public List<FukaErrorListCsvItem> toList() {
        return new ArrayList<>(itemList);
    }

    @Override
    public Iterator<FukaErrorListCsvItem> iterator() {
        return itemList.iterator();
    }
}
