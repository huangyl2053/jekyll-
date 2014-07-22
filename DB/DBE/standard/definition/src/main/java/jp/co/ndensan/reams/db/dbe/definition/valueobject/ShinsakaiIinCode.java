/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * 審査会委員コードを表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiIinCode implements IValueObject<RString>, Comparable<ShinsakaiIinCode> {

    private final RString 審査会委員コード;
    private final int コード長 = 8;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 審査会委員コード 審査会委員コード
     * @throws NullPointerException 引数にNullが渡されたとき
     * @throws IllegalArgumentException 引数の文字列が8桁で無いとき
     */
    public ShinsakaiIinCode(RString 審査会委員コード) throws NullPointerException, IllegalArgumentException {
        requireNonNull(審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会開催場所コード"));
        is8桁(審査会委員コード);
        this.審査会委員コード = 審査会委員コード;
    }

    private RString is8桁(RString 審査会委員コード) {
        if (審査会委員コード.length() != コード長) {
            //TODO n8178 城間篤人 メッセージの出力が可能になった後、修正を行う 2014年8月末
            throw new IllegalArgumentException(UrErrorMessages.桁数が不正.getMessage().toString());
        }
        return 審査会委員コード;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.審査会委員コード);
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }
        return ((ShinsakaiIinCode) 比較対象).value().equals(審査会委員コード);
    }

    @Override
    public RString value() {
        return 審査会委員コード;
    }

    @Override
    public int compareTo(ShinsakaiIinCode 比較対象) {
        return 審査会委員コード.compareTo(比較対象.value());
    }
}
