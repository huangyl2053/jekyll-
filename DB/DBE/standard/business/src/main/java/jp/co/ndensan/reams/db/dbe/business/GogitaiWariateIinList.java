/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiYukoKikanKaishiDate;

/**
 * 合議体割当委員のリストを扱うクラスです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiWariateIinList implements Iterable<GogitaiWariateIin> {

    private final List<GogitaiWariateIin> 合議体割当委員List;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 合議体割当委員List 合議体割当委員List
     */
    public GogitaiWariateIinList(List<GogitaiWariateIin> 合議体割当委員List) {
        this.合議体割当委員List = requireNonNull(合議体割当委員List,
                UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("合議体割当委員List", getClass().getName()));
    }

    /**
     * 合議体番号、合議体有効期間開始年月日、審査員コードを指定し、合議体割当委員リストから割当委員を一人取得します。
     *
     * @param 合議体番号 合議体番号
     * @param 合議体有効期間開始年月日 合議体有効期間開始年月日
     * @param 審査会委員コード 審査会委員コード
     * @return 合議体に割り当てられた審査会委員
     */
    public GogitaiWariateIin get合議体割当委員(GogitaiNo 合議体番号,
            GogitaiYukoKikanKaishiDate 合議体有効期間開始年月日, ShinsakaiIinCode 審査会委員コード) {
        for (GogitaiWariateIin 合議体割当委員 : 合議体割当委員List) {
            if (isキー項目が一致(合議体割当委員, 合議体番号, 合議体有効期間開始年月日, 審査会委員コード)) {
                return 合議体割当委員;
            }
        }
//        throw new IllegalArgumentException(UrErrorMessages.項目に対する制約.getMessage().replace("対応する合議体割当委員").evaluate());
        throw new IllegalArgumentException(UrErrorMessages.項目に対する制約.getMessage().replace("対応する合議体割当委員").getMessage());
    }

    private boolean isキー項目が一致(GogitaiWariateIin 割当委員, GogitaiNo 合議体番号,
            GogitaiYukoKikanKaishiDate 合議体有効期間開始年月日, ShinsakaiIinCode 審査会委員コード) {
        if (!審査会委員コード.equals(割当委員.get委員情報().get審査会委員コード())) {
            return false;
        }
        if (!合議体番号.equals(割当委員.get合議体情報().get合議体番号())) {
            return false;
        }
        if (!合議体有効期間開始年月日.equals(割当委員.get合議体情報().get有効期間開始年月日())) {
            return false;
        }
        return true;
    }

    /**
     * リストの要素数を返します。
     *
     * @return リストの要素数
     */
    public int size() {
        return 合議体割当委員List.size();
    }

    /**
     * リストが空か否かを真理値で返します。
     *
     * @return リストが空ならtrue
     */
    public boolean isEmpty() {
        return 合議体割当委員List.isEmpty();
    }

    @Override
    public Iterator<GogitaiWariateIin> iterator() {
        return 合議体割当委員List.iterator();
    }
}
