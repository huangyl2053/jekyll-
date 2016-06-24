/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.config.ConfigKeysNenreiTotatsuKijunJoho;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 資格取得可能な年齢に到達しているかの判定を行うクラスです。<br/>
 *
 * <pre>
 * //使用例
 * NenreiTotatsuChecker checker = new NenreiTotatsuChecker(
 *      ConfigKeysNenreiTotatsuKijunJoho.年齢到達基準_第１号被保険者到達基準年齢, RDate.getNowDate());
 * checker.personBornOn(dateOfBirth).has年齢到達();
 * </pre>
 *
 * @author n8178 城間篤人
 */
public final class NenreiTotatsuChecker {

    private final _NenreiTotatsuChecker checker;

    /**
     * コンストラクタです。<br/>
     * 年齢到達に関する業務コンフィグ取得クラスを内部で生成します。
     *
     * @param nenreiTotatsuKijun 年齢到達基準
     * @param kijunDate 年齢到達判定の基準日
     * @throws NullPointerException 引数のいずれかにnullが渡された場合
     */
    public NenreiTotatsuChecker(ConfigKeysNenreiTotatsuKijunJoho nenreiTotatsuKijun, RDate kijunDate)
            throws NullPointerException {

        checker = new _NenreiTotatsuChecker(nenreiTotatsuKijun, kijunDate, new NenreiTotatsuKijunConfig());
    }

    /**
     * テスト用のコンストラクタです。引数から業務コンフィグ取得クラスのMockを受け取ります。
     *
     * @param nenreiTotatsuKijun 年齢到達基準
     * @param kijunDate 年齢到達判定の基準日
     * @param config 年齢到達の業務コンフィグ取得クラス
     * @throws NullPointerException 引数のいずれかにnullが渡された場合
     */
    NenreiTotatsuChecker(ConfigKeysNenreiTotatsuKijunJoho nenreiTotatsuKijun, RDate kijunDate,
            NenreiTotatsuKijunConfig config) throws NullPointerException {

        checker = new _NenreiTotatsuChecker(nenreiTotatsuKijun, kijunDate, config);
    }

    /**
     * 年齢到達チェック対象の生年月日を設定します。
     *
     * @param dateOfBirth チェック対象の生年月日
     * @return 判定を行うインターフェース
     */
    public INenreiTotatsuJudicative personBornOn(IDateOfBirth dateOfBirth) {
        return checker.setDateOfBirth(dateOfBirth);
    }

    /**
     * 年齢到達チェック対象の生年月日を設定します。
     *
     * @param dateOfBirth チェック対象の生年月日(非暦上日)
     * @return 判定を行うインターフェース
     */
    public INenreiTotatsuJudicative personBornOn(FlexibleDate dateOfBirth) {
        return checker.setDateOfBirth(DateOfBirthFactory.createInstance(dateOfBirth));
    }

    /**
     * 年齢到達の要件を満たしているかどうかを判断する機能を提供するインターフェースです。
     */
    public interface INenreiTotatsuJudicative {

        /**
         * 年齢到達の基準を満たしているかの判定を行います。
         *
         * @return 年齢到達基準を満たしている場合はtrue
         */
        boolean has年齢到達();
    }

    private static class _NenreiTotatsuChecker implements INenreiTotatsuJudicative {

        private final NenreiTotatsuKijunConfig config;
        private final ConfigKeysNenreiTotatsuKijunJoho nenreiTotatsuKijun;
        private final RDate kijunDate;
        private IDateOfBirth dateOfBirth;

        /**
         * コンストラクタです。
         *
         * @param nenreiTotatsuKijun 使用する年齢到達基準
         * @param kijunDate 基準日
         * @param config 判定に使用する、年齢到達情報の業務コンフィグ取得クラス
         * @param dateOfBirth 判定対象の生年月日
         */
        public _NenreiTotatsuChecker(ConfigKeysNenreiTotatsuKijunJoho nenreiTotatsuKijun, RDate kijunDate,
                NenreiTotatsuKijunConfig config) {
            requireNonNull(nenreiTotatsuKijun, UrSystemErrorMessages.引数がnullのため生成不可
                    .getReplacedMessage("年齢到達基準", getClass().getSimpleName()));
            requireNonNull(kijunDate, UrSystemErrorMessages.引数がnullのため生成不可
                    .getReplacedMessage("基準日", getClass().getSimpleName()));
            requireNonNull(config, UrSystemErrorMessages.引数がnullのため生成不可
                    .getReplacedMessage("年齢到達の業務コンフィグ取得クラス", getClass().getSimpleName()));

            this.config = config;
            this.kijunDate = kijunDate;
            this.nenreiTotatsuKijun = nenreiTotatsuKijun;
        }

        public _NenreiTotatsuChecker setDateOfBirth(IDateOfBirth dateOfBirth) {
            requireNonNull(dateOfBirth, UrSystemErrorMessages.引数がnullのため生成不可
                    .getReplacedMessage("生年月日", getClass().getSimpleName()));
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        @Override
        public boolean has年齢到達() {
            FlexibleDate 消除異動年月日 = FlexibleDate.EMPTY;
            AgeCalculator ageCalculator = new AgeCalculator(dateOfBirth, JuminJotai.未定義, 消除異動年月日);
            FlexibleDate nenreiTotatsuDate = ageCalculator.get年齢到達日(config.get(nenreiTotatsuKijun));
            return nenreiTotatsuDate.isBeforeOrEquals(new FlexibleDate(kijunDate.toDateString()));
        }
    }
}
