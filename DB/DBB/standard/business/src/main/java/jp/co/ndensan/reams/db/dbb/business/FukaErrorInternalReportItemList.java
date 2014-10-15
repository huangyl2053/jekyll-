/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 内部帳票、賦課エラー一覧情報のListを扱うクラスです。
 *
 * @author n8178 城間篤人
 */
public class FukaErrorInternalReportItemList implements Iterable<FukaErrorInternalReportItem> {

    private final List<FukaErrorInternalReportItem> itemList;

    /**
     * コンストラクタです。
     *
     * @param itemList 賦課エラー一覧EntityList
     */
    public FukaErrorInternalReportItemList(List<FukaErrorInternalReportItem> itemList) {
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
    public FukaErrorInternalReportItem get賦課エラー情報(FlexibleYear 賦課年度, TsuchishoNo 通知書番号) throws IllegalArgumentException {
        for (FukaErrorInternalReportItem item : itemList) {
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
    public List<FukaErrorInternalReportItem> toList() {
        return new ArrayList<>(itemList);
    }

    @Override
    public Iterator<FukaErrorInternalReportItem> iterator() {
        return itemList.iterator();
    }
}
