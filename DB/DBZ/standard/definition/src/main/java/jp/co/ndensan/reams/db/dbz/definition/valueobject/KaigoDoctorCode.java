/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.message.Messages;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import static java.util.Objects.requireNonNull;

/**
 * 介護医師コードを表すクラスです。
 *
 * @author N8156 宮本 康
 */
public class KaigoDoctorCode implements Comparable<KaigoDoctorCode>, IDbColumnMappable, IValueObject {

    private final RString 介護医師コード;

    /**
     * インスタンスを生成します。
     *
     * @param 介護医師コード 介護医師コード
     */
    public KaigoDoctorCode(RString 介護医師コード) {
        this.介護医師コード = requireNonNull(介護医師コード, Messages.E00001.getMessage());
    }

    @Override
    public RString value() {
        return 介護医師コード;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || !(比較対象 instanceof KaigoDoctorCode)) {
            return false;
        }
        return ((KaigoDoctorCode) 比較対象).value().equals(介護医師コード);
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = 17 * hash + Objects.hashCode(介護医師コード);
        return hash;
    }

    @Override
    public int compareTo(KaigoDoctorCode 比較対象) {
        return 介護医師コード.compareTo(比較対象.value());
    }

    @Override
    public RString getColumnValue() {
        return 介護医師コード;
    }
}
