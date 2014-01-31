/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;

/**
 * 介護医療機関コードを表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class KaigoIryoKikanCode implements Comparable<KaigoIryoKikanCode>, IDbColumnMappable {

    private final RString 介護医療機関コード;

    public KaigoIryoKikanCode(RString 介護医療機関コード) {
        this.介護医療機関コード = requireNonNull(介護医療機関コード);
    }

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
}
