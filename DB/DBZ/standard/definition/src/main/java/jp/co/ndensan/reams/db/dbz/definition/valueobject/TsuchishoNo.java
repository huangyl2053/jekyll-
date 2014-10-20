/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 通知書番号を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class TsuchishoNo implements IValueObject<RString>, Comparable<TsuchishoNo>, IDbColumnMappable {

    private final RString tsuchishoNo;

    /**
     * 引数から通知書番号を表す文字列を受け取り、インスタンスを生成します。
     *
     * @param tsuchishoNo 通知書番号
     */
    public TsuchishoNo(RString tsuchishoNo) {
        requireNonNull(tsuchishoNo, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("通知書番号", getClass().getName()));
        this.tsuchishoNo = tsuchishoNo;
    }

    @Override
    public RString value() {
        return tsuchishoNo;
    }

    @Override
    public int compareTo(TsuchishoNo target) {
        return this.value().compareTo(target.value());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.value());
        return hash;
    }

    @Override
    public boolean equals(Object target) {
        if (isNull(target) || isNotSameClass(target.getClass())) {
            return false;
        }
        return hasSameValue((TsuchishoNo) target);
    }

    private boolean isNull(Object target) {
        return target == null;
    }

    private boolean isNotSameClass(Class clazz) {
        return clazz != this.getClass();
    }

    private boolean hasSameValue(TsuchishoNo target) {
        return target.value().equals(this.value());
    }

    @Override
    public RString getColumnValue() {
        return tsuchishoNo;
    }

    @Override
    public String toString() {
        return tsuchishoNo.toString();
    }

}
