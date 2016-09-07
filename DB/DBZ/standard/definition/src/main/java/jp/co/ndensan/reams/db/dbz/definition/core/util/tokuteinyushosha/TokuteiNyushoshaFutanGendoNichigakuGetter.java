/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.util.tokuteinyushosha;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定入所者負担限度額のクラスです。
 *
 * @reamsid_L DBA-1290-050 lishengli
 */
public class TokuteiNyushoshaFutanGendoNichigakuGetter {

    private static final FlexibleDate 年月日_20150401 = new FlexibleDate("20150401");
    private static final FlexibleDate 年月日_20120401 = new FlexibleDate("20120401");
    private static final RString MESSAGES_基準日 = new RString("基準日");
    private static final RString MESSAGES_旧措置区分 = new RString("旧措置区分");

    private static final Code 旧措置 = new Code("1");

    /**
     * コンストラクタです。
     */
    public TokuteiNyushoshaFutanGendoNichigakuGetter() {
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get食費１(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_食費１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_食費１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_食費１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get食費２(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_食費２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_食費２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_食費２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get食費３(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_食費３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_食費３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_食費３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措置食費１(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置食費１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置食費１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措置食費１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措置食費２(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置食費２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置食費２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措置食費２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措置食費３(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置食費３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置食費３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措置食費３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措軽減食費１(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減食費１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減食費１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措軽減食費１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措軽減食費２(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減食費２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減食費２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措軽減食費２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措軽減食費３(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減食費３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減食費３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措軽減食費３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString getユニット型個室１(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_ユニット型個室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_ユニット型個室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_ユニット型個室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString getユニット型個室２(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_ユニット型個室２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_ユニット型個室２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_ユニット型個室２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString getユニット型個室３(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_ユニット型個室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_ユニット型個室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_ユニット型個室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措置ユニット型個室１(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置ユニット型個室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置ユニット型個室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措置ユニット型個室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措置ユニット型個室２(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置ユニット型個室２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置ユニット型個室２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措置ユニット型個室２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措置ユニット型個室３(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置ユニット型個室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置ユニット型個室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措置ユニット型個室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措軽減ユニット型個室１(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減ユニット型個室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減ユニット型個室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措軽減ユニット型個室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措軽減ユニット型個室２(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減ユニット型個室２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減ユニット型個室２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措軽減ユニット型個室２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措軽減ユニット型個室３(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減ユニット型個室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減ユニット型個室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措軽減ユニット型個室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString getユニット型準個室１(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_ユニット型準個室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_ユニット型準個室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_ユニット型準個室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString getユニット型準個室２(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_ユニット型準個室２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_ユニット型準個室２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_ユニット型準個室２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString getユニット型準個室３(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_ユニット型準個室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_ユニット型準個室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_ユニット型準個室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措置ユニット型準個室１(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置ユニット型準個室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置ユニット型準個室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措置ユニット型準個室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措置ユニット型準個室２(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置ユニット型準個室２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置ユニット型準個室２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措置ユニット型準個室２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措置ユニット型準個室３(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置ユニット型準個室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置ユニット型準個室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措置ユニット型準個室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措軽減ユニット型準個室１(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減ユニット型準個室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減ユニット型準個室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措軽減ユニット型準個室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措軽減ユニット型準個室２の１(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減ユニット型準個室２の１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減ユニット型準個室２の１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措軽減ユニット型準個室２の１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措軽減ユニット型準個室２の２(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減ユニット型準個室２の２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減ユニット型準個室２の２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措軽減ユニット型準個室２の２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措軽減ユニット型準個室３(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減ユニット型準個室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減ユニット型準個室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措軽減ユニット型準個室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get従個特養１(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_従個特養１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_従個特養１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_従個特養１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get従個特養２(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_従個特養２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_従個特養２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_従個特養２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get従個特養３(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_従個特養３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_従個特養３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_従個特養３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措置従個特養１(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置従個特養１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置従個特養１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措置従個特養１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措置従個特養２(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置従個特養２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置従個特養２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措置従個特養２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措置従個特養３(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置従個特養３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置従個特養３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措置従個特養３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措軽減従個特養１(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減従個特養１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減従個特養１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措軽減従個特養１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措軽減従個特養２の１(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減従個特養２の１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減従個特養２の１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措軽減従個特養２の１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措軽減従個特養２の２(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減従個特養２の２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減従個特養２の２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措軽減従個特養２の２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措軽減従個特養２の３(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減従個特養２の３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減従個特養２の３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措軽減従個特養２の３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措軽減従個特養３(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減従個特養３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減従個特養３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措軽減従個特養３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get従個老健１(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_従個老健１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_従個老健１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_従個老健１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get従個老健２(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_従個老健２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_従個老健２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_従個老健２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get従個老健３(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_従個老健３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_従個老健３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_従個老健３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get多床室１(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_多床室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_多床室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_多床室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get多床室２(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_多床室２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_多床室２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_多床室２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get多床室３(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_多床室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_多床室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_多床室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措置多床室１(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置多床室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置多床室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措置多床室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措置多床室２(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置多床室２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置多床室２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措置多床室２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措置多床室３(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置多床室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置多床室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措置多床室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措軽減多床室１(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減多床室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減多床室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措軽減多床室１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措軽減多床室２の１(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減多床室２の１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減多床室２の１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措軽減多床室２の１,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措軽減多床室２の２(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減多床室２の２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減多床室２の２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措軽減多床室２の２,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get旧措軽減多床室３(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減多床室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else if (年月日_20120401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減多床室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_旧措軽減多床室３,
                    new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString getユニット型個室_基準費用額(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_ユニット型個室_基準費用額, new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_ユニット型個室_基準費用額, new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString getユニット型準個室_基準費用額(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_ユニット型準個室_基準費用額, new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_ユニット型準個室_基準費用額, new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get従個特養_基準費用額(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_従個特養_基準費用額, new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_従個特養_基準費用額, new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get従個老健_基準費用額(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_従個老健_基準費用額, new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_従個老健_基準費用額, new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get多床室_基準費用額(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_多床室_基準費用額, new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_多床室_基準費用額, new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get食費_基準費用額(FlexibleDate 基準日) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        if (基準日.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (年月日_20150401.isBeforeOrEquals(基準日)) {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_201504改正_食費_基準費用額, new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        } else {
            return DbBusinessConfig.get(ConfigNameDBD.特定入所者負担限度額_食費_基準費用額, new RDate(基準日.toString()), SubGyomuCode.DBD介護受給);
        }
    }

    /**
     * 旧措置者区分によるコンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @param 旧措置区分 旧措置区分
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get食費１(FlexibleDate 基準日, Code 旧措置区分) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        requireNonNull(旧措置区分, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_旧措置区分.toString()));
        if (旧措置区分.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (旧措置.equals(旧措置区分)) {
            return get旧措置食費１(基準日);
        } else {
            return get食費１(基準日);
        }
    }

    /**
     * 旧措置者区分によるコンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @param 旧措置区分 旧措置区分
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get食費２(FlexibleDate 基準日, Code 旧措置区分) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        requireNonNull(旧措置区分, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_旧措置区分.toString()));
        if (旧措置区分.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (旧措置.equals(旧措置区分)) {
            return get旧措置食費２(基準日);
        } else {
            return get食費２(基準日);
        }
    }

    /**
     * 旧措置者区分によるコンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @param 旧措置区分 旧措置区分
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get食費３(FlexibleDate 基準日, Code 旧措置区分) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        requireNonNull(旧措置区分, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_旧措置区分.toString()));
        if (旧措置区分.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (旧措置.equals(旧措置区分)) {
            return get旧措置食費３(基準日);
        } else {
            return get食費３(基準日);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @param 旧措置区分 旧措置区分
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString getユニット型個室１(FlexibleDate 基準日, Code 旧措置区分) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        requireNonNull(旧措置区分, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_旧措置区分.toString()));
        if (旧措置区分.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (旧措置.equals(旧措置区分)) {
            return get旧措置ユニット型個室１(基準日);
        } else {
            return getユニット型個室１(基準日);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @param 旧措置区分 旧措置区分
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString getユニット型個室２(FlexibleDate 基準日, Code 旧措置区分) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        requireNonNull(旧措置区分, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_旧措置区分.toString()));
        if (旧措置区分.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (旧措置.equals(旧措置区分)) {
            return get旧措置ユニット型個室２(基準日);
        } else {
            return getユニット型個室２(基準日);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @param 旧措置区分 旧措置区分
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString getユニット型個室３(FlexibleDate 基準日, Code 旧措置区分) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        requireNonNull(旧措置区分, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_旧措置区分.toString()));
        if (旧措置区分.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (旧措置.equals(旧措置区分)) {
            return get旧措置ユニット型個室３(基準日);
        } else {
            return getユニット型個室３(基準日);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @param 旧措置区分 旧措置区分
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString getユニット型準個室１(FlexibleDate 基準日, Code 旧措置区分) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        requireNonNull(旧措置区分, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_旧措置区分.toString()));
        if (旧措置区分.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (旧措置.equals(旧措置区分)) {
            return get旧措置ユニット型準個室１(基準日);
        } else {
            return getユニット型準個室１(基準日);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @param 旧措置区分 旧措置区分
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString getユニット型準個室２(FlexibleDate 基準日, Code 旧措置区分) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        requireNonNull(旧措置区分, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_旧措置区分.toString()));
        if (旧措置区分.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (旧措置.equals(旧措置区分)) {
            return get旧措置ユニット型準個室２(基準日);
        } else {
            return getユニット型準個室２(基準日);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @param 旧措置区分 旧措置区分
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString getユニット型準個室３(FlexibleDate 基準日, Code 旧措置区分) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        requireNonNull(旧措置区分, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_旧措置区分.toString()));
        if (旧措置区分.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (旧措置.equals(旧措置区分)) {
            return get旧措置ユニット型準個室３(基準日);
        } else {
            return getユニット型準個室３(基準日);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @param 旧措置区分 旧措置区分
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get従個特養１(FlexibleDate 基準日, Code 旧措置区分) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        requireNonNull(旧措置区分, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_旧措置区分.toString()));
        if (旧措置区分.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (旧措置.equals(旧措置区分)) {
            return get旧措置従個特養１(基準日);
        } else {
            return get従個特養１(基準日);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @param 旧措置区分 旧措置区分
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get従個特養２(FlexibleDate 基準日, Code 旧措置区分) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        requireNonNull(旧措置区分, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_旧措置区分.toString()));
        if (旧措置区分.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (旧措置.equals(旧措置区分)) {
            return get旧措置従個特養２(基準日);
        } else {
            return get従個特養２(基準日);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @param 旧措置区分 旧措置区分
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get従個特養３(FlexibleDate 基準日, Code 旧措置区分) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        requireNonNull(旧措置区分, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_旧措置区分.toString()));
        if (旧措置区分.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (旧措置.equals(旧措置区分)) {
            return get旧措置従個特養３(基準日);
        } else {
            return get従個特養３(基準日);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @param 旧措置区分 旧措置区分
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get多床室１(FlexibleDate 基準日, Code 旧措置区分) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        requireNonNull(旧措置区分, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_旧措置区分.toString()));
        if (旧措置区分.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (旧措置.equals(旧措置区分)) {
            return get旧措置多床室１(基準日);
        } else {
            return get多床室１(基準日);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @param 旧措置区分 旧措置区分
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get多床室２(FlexibleDate 基準日, Code 旧措置区分) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        requireNonNull(旧措置区分, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_旧措置区分.toString()));
        if (旧措置区分.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (旧措置.equals(旧措置区分)) {
            return get旧措置多床室２(基準日);
        } else {
            return get多床室２(基準日);
        }
    }

    /**
     * 基準日指定による、コンフィグの取り分けの処理。
     *
     * @param 基準日 基準日
     * @param 旧措置区分 旧措置区分
     * @return 業務コンフィグに対応したenumクラス
     */
    public RString get多床室３(FlexibleDate 基準日, Code 旧措置区分) {
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_基準日.toString()));
        requireNonNull(旧措置区分, UrSystemErrorMessages.値がnull.getReplacedMessage(MESSAGES_旧措置区分.toString()));
        if (旧措置区分.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (旧措置.equals(旧措置区分)) {
            return get旧措置多床室３(基準日);
        } else {
            return get多床室３(基準日);
        }
    }
}
