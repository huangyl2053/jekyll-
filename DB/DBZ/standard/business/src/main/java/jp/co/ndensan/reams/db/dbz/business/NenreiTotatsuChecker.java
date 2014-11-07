/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.config.NenreiTotatsuKijunConfig;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ConfigKeysNenreiTotatsuKijunJoho;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.model.DateOfBirthFactory;
import jp.co.ndensan.reams.ur.urz.model.IDateOfBirth;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 資格取得可能な年齢に到達しているかの判定を行うクラスです。<br/>
 *
 * <pre>
 * //使用例
 * NenreiTotatsuChecker checker = new NenreiTotatsuChecker(
 *      ConfigKeysNenreiTotatsuKijunJoho.年齢到達基準_第１号被保険者到達基準年齢, RDate.getNowDate());
 * checker.bornOn(dateOfBirth).isValid();
 * </pre>
 *
 * @author n8178 城間篤人
 */
public final class NenreiTotatsuChecker {

    private final NenreiTotatsuKijunConfig config;
    private final ConfigKeysNenreiTotatsuKijunJoho nenreiTotatsuKijun;
    private final RDate kijunDate;

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
        requireNonNull基準日(kijunDate);
        requireNonNull年齢到達基準(nenreiTotatsuKijun);

        this.nenreiTotatsuKijun = nenreiTotatsuKijun;
        this.kijunDate = kijunDate;
        this.config = new NenreiTotatsuKijunConfig();
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
        requireNonNull基準日(kijunDate);
        requireNonNull年齢到達基準(nenreiTotatsuKijun);
        requireNonNull年齢到達業務コンフィグ(config);

        this.nenreiTotatsuKijun = nenreiTotatsuKijun;
        this.kijunDate = kijunDate;
        this.config = config;
    }

    private ConfigKeysNenreiTotatsuKijunJoho requireNonNull年齢到達基準(ConfigKeysNenreiTotatsuKijunJoho nenreiTotatsuKijun) {
        return requireNonNull(nenreiTotatsuKijun, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("年齢到達基準", getClass().getSimpleName()));
    }

    private RDate requireNonNull基準日(RDate kijunDate) {
        return requireNonNull(kijunDate, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("基準日", getClass().getSimpleName()));
    }

    private NenreiTotatsuKijunConfig requireNonNull年齢到達業務コンフィグ(NenreiTotatsuKijunConfig config) {
        return requireNonNull(config, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("年齢到達の業務コンフィグ取得クラス", getClass().getSimpleName()));
    }

    /**
     * 年齢到達チェック対象の生年月日を設定します。
     *
     * @param dateOfBirth チェック対象の生年月日
     * @return 判定を行うインターフェース
     */
    public INenreiTotatsuValider bornOn(IDateOfBirth dateOfBirth) {
        return new _NenreiTotatsuChecker(nenreiTotatsuKijun, kijunDate, config, dateOfBirth);
    }

    /**
     * 年齢到達チェック対象の生年月日を設定します。
     *
     * @param dateOfBirth チェック対象の生年月日(暦上日)
     * @return 判定を行うインターフェース
     */
    public INenreiTotatsuValider bornOn(RDate dateOfBirth) {
        return new _NenreiTotatsuChecker(nenreiTotatsuKijun, kijunDate, config,
                DateOfBirthFactory.createInstance(dateOfBirth));
    }

    /**
     * 年齢到達チェック対象の生年月日を設定します。
     *
     * @param dateOfBirth チェック対象の生年月日(非暦上日)
     * @return 判定を行うインターフェース
     */
    public INenreiTotatsuValider bornOn(FlexibleDate dateOfBirth) {
        return new _NenreiTotatsuChecker(nenreiTotatsuKijun, kijunDate, config,
                DateOfBirthFactory.createInstance(dateOfBirth));
    }

    public interface INenreiTotatsuValider {

        /**
         * 年齢到達の基準を満たしているかの判定を行います。
         *
         * @return 年齢到達基準を満たしている場合はtrue
         */
        boolean isValid();
    }

    private class _NenreiTotatsuChecker implements INenreiTotatsuValider {

        private final NenreiTotatsuKijunConfig config;
        private final ConfigKeysNenreiTotatsuKijunJoho nenreiTotatsuKijun;
        private final RDate kijunDate;
        private final IDateOfBirth dateOfBirth;

        /**
         * コンストラクタです。
         *
         * @param nenreiTotatsuKijun 使用する年齢到達基準
         * @param kijunDate 基準日
         * @param config 判定に使用する、年齢到達情報の業務コンフィグ取得クラス
         * @param dateOfBirth 判定対象の生年月日
         */
        public _NenreiTotatsuChecker(ConfigKeysNenreiTotatsuKijunJoho nenreiTotatsuKijun, RDate kijunDate,
                NenreiTotatsuKijunConfig config, IDateOfBirth dateOfBirth) {

            this.nenreiTotatsuKijun = nenreiTotatsuKijun;
            this.kijunDate = kijunDate;
            this.config = config;
            this.dateOfBirth = dateOfBirth;
        }

        @Override
        public boolean isValid() {
            RDate nenreiTotatsuDate = dateOfBirth.get年齢到達日(config.get(nenreiTotatsuKijun));
            return kijunDate.isBeforeOrEquals(nenreiTotatsuDate);
        }
    }

}
