/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;

/**
 * 審査会委員リストです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiIinList implements Iterable<ShinsakaiIin> {
    //TODO n8178 城間篤人　審査会チケットで必要な分を実装。後の審査会委員チケットで修正される可能性がある 2014年4月

    private final List<ShinsakaiIin> 審査会委員List;

    /**
     * 引数から審査会委員のリストを受け取り、インスタンスを生成します。
     *
     * @param 審査会委員List 審査会委員List
     */
    public ShinsakaiIinList(List<ShinsakaiIin> 審査会委員List) {
        this.審査会委員List = 審査会委員List;
    }

    /**
     * 審査会委員コードを指定して、対応する審査会委員を一件取得します。
     *
     * @param 審査会委員コード 審査会委員コード
     * @return 審査会委員
     */
    public ShinsakaiIin get審査会委員(ShinsakaiIinCode 審査会委員コード) {
        for (ShinsakaiIin 委員 : 審査会委員List) {
            if (委員.get審査会委員コード().equals(審査会委員コード)) {
                return 委員;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("指定した委員コードに対応した委員").evaluate());
    }

    /**
     * リストが空であるか否かを返します。
     *
     * @return 空ならtrue
     */
    public boolean isEmpty() {
        return 審査会委員List.isEmpty();
    }

    /**
     * リストのサイズを整数値で返します。
     *
     * @return サイズ
     */
    public int size() {
        return 審査会委員List.size();
    }

    @Override
    public Iterator<ShinsakaiIin> iterator() {
        return 審査会委員List.iterator();
    }
}
