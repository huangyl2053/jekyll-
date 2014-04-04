/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.lib.util.IRStringConvertable;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会開始時間を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiKaishiTime implements IValueObject<TimeString>, Comparable<ShinsakaiKaishiTime>, IRStringConvertable {

    private final TimeString 審査会開始時間;

    /**
     * 引数から時間を表す文字列を受け取り、インスタンスを生成します。
     *
     * @param 時間 時間を表す4桁の文字列
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public ShinsakaiKaishiTime(TimeString 時間) throws NullPointerException {
        this.審査会開始時間 = requireNonNull(時間);
    }

    @Override
    public RString toRString() {
        return 審査会開始時間.value();
    }

    @Override
    public TimeString value() {
        return 審査会開始時間;
    }

    @Override
    public int compareTo(ShinsakaiKaishiTime 比較対象) {
        return this.value().compareTo(比較対象.value());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.value());
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }
        return ((ShinsakaiKaishiTime) 比較対象).value().equals(this.value());
    }
}
