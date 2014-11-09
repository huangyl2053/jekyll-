/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * 被保険者番号を採番するためのオブジェクトを取得できるクラスです。
 *
 * @author N3327 三浦 凌
 */
//TODO n3327 三浦凌 仮実装。採番APIの正しい利用方法がわかったら修正する。
public final class HihokenshaNoSaibanService {

    private static final NormalType NORMAL_TYPE;
    private static final ForMushikakushaType FOR_MUSHIKAKUSHA_TYPE;

    static {
        NORMAL_TYPE = new NormalType();
        FOR_MUSHIKAKUSHA_TYPE = new ForMushikakushaType();
    }

    private HihokenshaNoSaibanService() {
    }

    /**
     * 通常の被保険者番号を採番するためのオブジェクトを取得します。
     *
     * @return 通常の被保険者番号を採番するための{@link IKaigoSaiban オブジェクト}
     */
    public static IKaigoSaiban<HihokenshaNo> normalType() {
        return NORMAL_TYPE;
    }

    /**
     * 無資格者の被保険者番号を採番するためのオブジェクトを取得します。
     *
     * @return 無資格者の被保険者番号を採番するための{@link IKaigoSaiban オブジェクト}
     */
    public static IKaigoSaiban<HihokenshaNo> forMushikakushaType() {
        return FOR_MUSHIKAKUSHA_TYPE;
    }

    static IKaigoSaiban<HihokenshaNo> forTestType(RString next) {
        return new ForTestType(next);
    }

    /**
     * 通常の被保険者番号を採番します。
     */
    private static final class NormalType extends HihokenshaNoSaibanBase {

        private static final RString GENERIC_KEY = new RString("被保険者番号");
        private static final FlexibleYear NENDO = new FlexibleYear("0000");

        @Override
        protected RString nextRString() {
            return Saiban.get(SubGyomuCode.DBZ介護共通, GENERIC_KEY, NENDO).nextString();
        }
    }

    /**
     * 無資格者の被保険者番号(‘H’はじまり)を採番します。
     */
    private static final class ForMushikakushaType extends HihokenshaNoSaibanBase {

        private static final RString GENERIC_KEY = new RString("被保険者番号(無資格者)");
        private static final FlexibleYear NENDO = new FlexibleYear("0000");
        private static final RString INITIAL = new RString("H");

        @Override
        protected RString nextRString() {
            RString next = Saiban.get(SubGyomuCode.DBZ介護共通, GENERIC_KEY, NENDO).nextString();
            return new RStringBuilder(INITIAL).append(next).toRString();
        }
    }

    /**
     * テスト用のクラスです。
     */
    private static final class ForTestType extends HihokenshaNoSaibanBase {

        private RString next;

        public ForTestType(RString next) {
            this.next = next;
        }

        @Override
        protected RString nextRString() {
            return this.next;
        }
    }

    /**
     * 被保険者番号を採番をするクラスの抽象です。
     */
    private abstract static class HihokenshaNoSaibanBase implements IKaigoSaiban<HihokenshaNo> {

        @Override
        public HihokenshaNo number() {
            return new HihokenshaNo(nextRString());
        }

        /**
         * 採番した値をRString型で返します。
         *
         * @return 採番した値
         */
        protected abstract RString nextRString();
    }
}
