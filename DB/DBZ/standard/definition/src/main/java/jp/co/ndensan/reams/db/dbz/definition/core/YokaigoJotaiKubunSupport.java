/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import static jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode.V02A;
import static jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode.V06A;
import static jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode.V09A;
import static jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode.V09B;
import static jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode.V99A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 要介護状態区分のサポートクラスです。
 *
 * @author N8156 宮本 康
 * @jpName
 * @bizDomain
 * @category
 * @subCategory
 * @mainClass
 * @reference
 */
public final class YokaigoJotaiKubunSupport {

    private final static IYokaigoJotaiKubun EMPTY;

    static {
        EMPTY = new Empty();
    }

    private static class Empty implements IYokaigoJotaiKubun {

        private final RString aCode;
        private final RString aName;

        private Empty() {
            this.aCode = RString.EMPTY;
            this.aName = RString.EMPTY;
        }

        @Override
        public RString getCode() {
            return this.aCode;
        }

        @Override
        public RString getName() {
            return this.aName;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 97 * hash + Objects.hashCode(this.aCode);
            hash = 97 * hash + Objects.hashCode(this.aName);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Empty other = (Empty) obj;
            if (!Objects.equals(this.aCode, other.aCode)) {
                return false;
            }
            if (!Objects.equals(this.aName, other.aName)) {
                return false;
            }
            return true;
        }
    }

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private YokaigoJotaiKubunSupport() {
    }

    /**
     * 厚労省インターフェース識別コードに対応する要介護状態区分の中からコードに対応する列挙型を返します。
     *
     * @param koroshoIfCode 厚労省インターフェース識別コード
     * @param code コード
     * @return 要介護状態区分
     */
    public static IYokaigoJotaiKubun toValueOrEmpty(KoroshoInterfaceShikibetsuCode koroshoIfCode, RString code) {
        try {
            switch (koroshoIfCode) {
                case V09B:
                    return YokaigoJotaiKubun09B.toValue(code);
                case V09A:
                    return YokaigoJotaiKubun09A.toValue(code);
                case V06A:
                    return YokaigoJotaiKubun06A.toValue(code);
                case V02A:
                    return YokaigoJotaiKubun02A.toValue(code);
                case V99A:
                    return YokaigoJotaiKubun99A.toValue(code);
                default:
                    return EMPTY;
            }
        } catch (IllegalArgumentException e) {
            return EMPTY;
        }
    }

    /**
     * 厚労省インターフェース識別コードに対応する要介護状態区分の中からコードに対応する列挙型を返します。
     *
     * @param koroshoIfCode 厚労省インターフェース識別コード
     * @param code コード
     * @return 要介護状態区分
     */
    public static IYokaigoJotaiKubun toValueOrEmpty(RString koroshoIfCode, RString code) {
        KoroshoInterfaceShikibetsuCode kisc = KoroshoInterfaceShikibetsuCode.toValueOrDefault(koroshoIfCode, null);
        return toValueOrEmpty(kisc, code);
    }

    /**
     * 厚労省インターフェース識別コードに対応する要介護状態区分の中からコードに対応する列挙型を返します。
     *
     * @param koroshoIfCode 厚労省インターフェース識別コード
     * @param code コード
     * @return 要介護状態区分
     * @throws IllegalArgumentException 変換不可の場合
     */
    public static IYokaigoJotaiKubun toValue(KoroshoInterfaceShikibetsuCode koroshoIfCode, RString code) throws IllegalArgumentException {
        // 各Enumでの変換で失敗する場合がある。例外発生個所を明確にするため、toValueOrEmptyとロジックを共有しない。
        switch (koroshoIfCode) {
            case V09B:
                return YokaigoJotaiKubun09B.toValue(code);
            case V09A:
                return YokaigoJotaiKubun09A.toValue(code);
            case V06A:
                return YokaigoJotaiKubun06A.toValue(code);
            case V02A:
                return YokaigoJotaiKubun02A.toValue(code);
            case V99A:
                return YokaigoJotaiKubun99A.toValue(code);
            default:
                throw new IllegalArgumentException(new RStringBuilder()
                        .append(UrSystemErrorMessages.変換不可.getReplacedMessage("要介護状態区分"))
                        .append(" 厚労省IF識別コード：???")
                        .append(" コード：").append(Objects.toString(code, "null"))
                        .toString());
        }
    }

    /**
     * 直近の要介護状態区分の中からコードに対応する列挙型を返します。
     *
     * @param code コード
     * @return 要介護状態区分
     */
    public static IYokaigoJotaiKubun toValueOrEmpty(RString code) {
        return toValueOrEmpty(FlexibleDate.getNowDate(), code);
    }

    /**
     * 基準日時点の要介護状態区分の中からコードに対応する列挙型を返します。
     *
     * @param 基準日 基準日
     * @param code コード
     * @return 要介護状態区分
     */
    public static IYokaigoJotaiKubun toValueOrEmpty(FlexibleDate 基準日, RString code) {
        try {
            if (KoroshoInterfaceShikibetsuCode.V09B.isValidOn(基準日)) {
                return YokaigoJotaiKubun09B.toValue(code);
            } else if (KoroshoInterfaceShikibetsuCode.V09A.isValidOn(基準日)) {
                return YokaigoJotaiKubun09A.toValue(code);
            } else if (KoroshoInterfaceShikibetsuCode.V06A.isValidOn(基準日)) {
                return YokaigoJotaiKubun06A.toValue(code);
            } else if (KoroshoInterfaceShikibetsuCode.V02A.isValidOn(基準日)) {
                return YokaigoJotaiKubun02A.toValue(code);
            } else if (KoroshoInterfaceShikibetsuCode.V99A.isValidOn(基準日)) {
                return YokaigoJotaiKubun99A.toValue(code);
            } else {
                return EMPTY;
            }
        } catch (IllegalArgumentException e) {
            return EMPTY;
        }
    }

    /**
     * 基準日時点の要介護状態区分の中からコードに対応する列挙型を返します。
     *
     * @param 基準日 基準日
     * @param code コード
     * @return 要介護状態区分
     * @throws IllegalArgumentException 変換不可の場合
     */
    public static IYokaigoJotaiKubun toValue(FlexibleDate 基準日, RString code) throws IllegalArgumentException {
        // 各Enumでの変換で失敗する場合がある。例外発生個所を明確にするため、toValueOrEmptyとロジックを共有しない。
        if (KoroshoInterfaceShikibetsuCode.V09B.isValidOn(基準日)) {
            return YokaigoJotaiKubun09B.toValue(code);
        } else if (KoroshoInterfaceShikibetsuCode.V09A.isValidOn(基準日)) {
            return YokaigoJotaiKubun09A.toValue(code);
        } else if (KoroshoInterfaceShikibetsuCode.V06A.isValidOn(基準日)) {
            return YokaigoJotaiKubun06A.toValue(code);
        } else if (KoroshoInterfaceShikibetsuCode.V02A.isValidOn(基準日)) {
            return YokaigoJotaiKubun02A.toValue(code);
        } else if (KoroshoInterfaceShikibetsuCode.V99A.isValidOn(基準日)) {
            return YokaigoJotaiKubun99A.toValue(code);
        } else {
            throw new IllegalArgumentException(new RStringBuilder()
                    .append(UrSystemErrorMessages.変換不可.getReplacedMessage("要介護状態区分"))
                    .append(" 基準日：").append(Objects.toString(基準日, "null"))
                    .append(" コード：").append(Objects.toString(code, "null"))
                    .toString());
        }
    }

    /**
     * 基準年月時点の要介護状態区分の中からコードに対応する列挙型を返します。
     *
     * @param 基準年月 基準年月
     * @param code コード
     * @return 要介護状態区分
     * @throws IllegalArgumentException 変換不可の場合
     */
    public static IYokaigoJotaiKubun toValue(FlexibleYearMonth 基準年月, RString code) throws IllegalArgumentException {
        return toValue(new FlexibleDate(基準年月.toDateString()), code);
    }

    /**
     * 指定の厚労省IF識別コードに該当する要介護状態区分をすべて返却します。
     *
     * @param koroshoIfCode 厚労省IF識別コード
     * @return 該当する要介護状態区分すべて
     */
    public static List<IYokaigoJotaiKubun> values(KoroshoIfShikibetsuCode koroshoIfCode) {
        switch (koroshoIfCode) {
            case 認定ｿﾌﾄ2009_SP3:
                return Arrays.<IYokaigoJotaiKubun>asList(YokaigoJotaiKubun09B.values());
            case 認定ｿﾌﾄ2009:
                return Arrays.<IYokaigoJotaiKubun>asList(YokaigoJotaiKubun09A.values());
            case 認定ｿﾌﾄ2006_新要介護認定適用区分が未適用:
                return Arrays.<IYokaigoJotaiKubun>asList(YokaigoJotaiKubun06A.values());
            case 認定ｿﾌﾄ2002:
                return Arrays.<IYokaigoJotaiKubun>asList(YokaigoJotaiKubun02A.values());
            case 認定ｿﾌﾄ99:
                return Arrays.<IYokaigoJotaiKubun>asList(YokaigoJotaiKubun99A.values());
            default:
                return Collections.emptyList();
        }
    }
}
