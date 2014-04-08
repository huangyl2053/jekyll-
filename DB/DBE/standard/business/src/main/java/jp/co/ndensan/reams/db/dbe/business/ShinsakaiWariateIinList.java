/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiDate;

/**
 * 審査会割当委員のリストです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiWariateIinList implements Iterable<ShinsakaiWariateIin> {

    private final List<ShinsakaiWariateIin> 審査会割当委員List;

    /**
     * 引数から審査会割当委員Listのリストを受け取り、インスタンスを生成します。
     *
     * @param 審査会割当委員List 審査会割当委員List
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public ShinsakaiWariateIinList(List<ShinsakaiWariateIin> 審査会割当委員List) throws NullPointerException {
        this.審査会割当委員List = requireNonNull(審査会割当委員List,
                Messages.E00003.replace("審査会割当委員List", getClass().getName()).getMessage());
    }

    /**
     * 審査会開催番号、審査会開催年月日、審査会委員コードを指定し、審査会に割り当てられた委員の情報を一件取得します。
     *
     * @param 審査会開催番号 審査会開催番号
     * @param 審査会開催年月日 審査会開催年月日
     * @param 審査会委員コード 審査会委員コード
     * @return 審査会割当委員
     * @throws IllegalArgumentException 対応する割当委員が存在しないとき
     */
    public ShinsakaiWariateIin get審査会割当委員(ShinsakaiKaisaiNo 審査会開催番号, ShinsakaiKaisaiDate 審査会開催年月日,
            ShinsakaiIinCode 審査会委員コード) throws IllegalArgumentException {
        for (ShinsakaiWariateIin 審査会割当委員 : 審査会割当委員List) {
            if (isキー項目が一致(審査会割当委員, 審査会開催番号, 審査会開催年月日, 審査会委員コード)) {
                return 審査会割当委員;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("対応する審査会割当委員").getMessage());
    }

    private boolean isキー項目が一致(ShinsakaiWariateIin 審査会割当委員, ShinsakaiKaisaiNo 審査会開催番号, ShinsakaiKaisaiDate 審査会開催年月日,
            ShinsakaiIinCode 審査会委員コード) {
        if (!審査会割当委員.get審査会情報().get審査会開催番号().equals(審査会開催番号)) {
            return false;
        }
        if (!審査会割当委員.get審査会情報().get審査会開催年月日().equals(審査会開催年月日)) {
            return false;
        }
        if (!審査会割当委員.get審査会委員情報().get審査会委員コード().equals(審査会委員コード)) {
            return false;
        }
        return true;
    }

    /**
     * リストが空であるか否かを返します。
     *
     * @return 空ならtrue
     */
    public boolean isEmpty() {
        return 審査会割当委員List.isEmpty();
    }

    /**
     * リストのサイズを返します。
     *
     * @return サイズ
     */
    public int size() {
        return 審査会割当委員List.size();
    }

    @Override
    public Iterator<ShinsakaiWariateIin> iterator() {
        return 審査会割当委員List.iterator();
    }
}
