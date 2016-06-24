/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig;

import jp.co.ndensan.reams.db.dbx.definition.message.DbxErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfigInfo;

/**
 * DB介護の業務コンフィグ取得手段、業務コンフィグ変更手段を提供するクラスです。
 *
 * @reamsid_L DBX-9999-023 liangbc
 */
public final class DbBusinessConfig {

    private DbBusinessConfig() {
    }

    /**
     * 引数で指定したキー名称、適用基準日に対応するコンフィグ設定値を取得します。
     * <p>
     * 条件に該当するコンフィグが存在しない場合はnullを返す。<br/>
     * サブ業務コードには自業務のコードが指定されます。</p>
     *
     * @param key 列挙型で定義されたキー名称
     * @param effectiveDate 適用基準日
     * @return キー名に対応する設定値
     */
    public static RString get(Enum key, RDate effectiveDate) {
        return get(key, effectiveDate, null, null, null);
    }

    /**
     * 引数で指定したキー名称、地方公共団体コード、適用基準日に対応するコンフィグ設定値を取得します。
     * <p>
     * 条件に該当するコンフィグが存在しない場合はnullを返す。<br/>
     * サブ業務コードには自業務のコードが指定されます。</p>
     *
     * @param key 列挙型で定義されたキー名称
     * @param lasdecCode 地方公共団体コード
     * @param effectiveDate 適用基準日
     * @return キー名に対応する設定値
     */
    public static RString get(Enum key, RDate effectiveDate, LasdecCode lasdecCode) {
        return get(key, effectiveDate, null, lasdecCode, null);
    }

    /**
     * 引数で指定したキー名称、適用基準日、汎用キーワードで対応するコンフィグ設定値を取得します。
     * <p>
     * 条件に該当するコンフィグが存在しない場合はnullを返す。<br/>
     * サブ業務コードには自業務のコードが指定されます。</p>
     *
     * @param key 列挙型で定義されたキー名称
     * @param effectiveDate 適用基準日
     * @param optionValue 汎用キーワード
     * @return キー名に対応する設定値
     */
    public static RString get(Enum key, RDate effectiveDate, RString optionValue) {
        return get(key, effectiveDate, null, null, optionValue);
    }

    /**
     * 引数で指定したキー名称、適用基準日、地方公共団体コード、汎用キーワードに対応するコンフィグ設定値を取得します。
     * <p>
     * 条件に該当するコンフィグが存在しない場合はnullを返す。<br/>
     * サブ業務コードには自業務のコードが指定されます。</p>
     *
     * @param key 列挙型で定義されたキー名称
     * @param effectiveDate 適用基準日
     * @param lasdecCode 地方公共団体コード
     * @param optionValue 汎用キーワード
     * @return キー名に対応する設定値
     */
    public static RString get(Enum key, RDate effectiveDate, LasdecCode lasdecCode, RString optionValue) {
        return get(key, effectiveDate, null, lasdecCode, optionValue);
    }

    /**
     * 引数で指定したキー名称、適用基準日、サブ業務コードに対応するコンフィグ設定値を取得します。
     * <p>
     * 条件に該当するコンフィグが存在しない場合はnullを返す。</p>
     *
     * @param key 列挙型で定義されたキー名称
     * @param effectiveDate 適用基準日
     * @param subGyomu サブ業務コード
     * @return キー名に対応する設定値
     */
    public static RString get(Enum key, RDate effectiveDate, SubGyomuCode subGyomu) {
        return get(key, effectiveDate, subGyomu, null, null);
    }

    /**
     * 引数で指定したキー名称、適用基準日、サブ業務コード、地方公共団体コードに対応するコンフィグ設定値を取得します。
     * <p>
     * 条件に該当するコンフィグが存在しない場合はnullを返す。</p>
     *
     * @param key 列挙型で定義されたキー名称
     * @param effectiveDate 適用基準日
     * @param subGyomu サブ業務コード
     * @param lasdecCode 地方公共団体コード
     * @return キー名に対応する設定値
     */
    public static RString get(Enum key, RDate effectiveDate, SubGyomuCode subGyomu, LasdecCode lasdecCode) {
        return get(key, effectiveDate, subGyomu, lasdecCode, null);
    }

    /**
     * 引数で指定したキー名称、適用基準日、サブ業務コード、汎用キーワードに対応するコンフィグ設定値を取得します。
     * <p>
     * 条件に該当するコンフィグが存在しない場合はnullを返す。
     * <p/>
     *
     * @param key 列挙型で定義されたキー名称
     * @param effectiveDate 適用基準日
     * @param subGyomu サブ業務コード
     * @param optionValue 汎用キーワード
     * @return キー名に対応する設定値
     */
    public static RString get(Enum key, RDate effectiveDate, SubGyomuCode subGyomu, RString optionValue) {
        return get(key, effectiveDate, subGyomu, null, optionValue);
    }

    /**
     * 引数で指定したキー名称、適用基準日、サブ業務コード、地方公共団体コード、汎用キーワードに対応するコンフィグ設定値を取得します。
     * <p>
     * 条件に該当するコンフィグが存在しない場合はnullを返す。
     * <p/>
     *
     * @param key 列挙型で定義されたキー名称
     * @param effectiveDate 適用基準日
     * @param subGyomuCode サブ業務コード
     * @param lasdecCode 地方公共団体コード
     * @param optionValue 汎用キーワード
     * @return キー名に対応する設定値
     */
    public static RString get(Enum key, RDate effectiveDate, SubGyomuCode subGyomuCode, LasdecCode lasdecCode, RString optionValue) {
        RString config = BusinessConfig.get(key, effectiveDate, subGyomuCode, lasdecCode, optionValue);
        if (config == null) {
            throw new SystemException(DbxErrorMessages.業務コンフィグなし.getMessage().replace(key.name()).evaluate());
        }
        return config;
    }

    /**
     * 引数で指定したキー名称、適用基準日に対応するコンフィグ設定値と説明を返します。<br />
     * <p>
     * 条件に該当するコンフィグが存在しない場合はnullを返す。<br/>
     * サブ業務コードには自業務のコードが指定されます。
     * <p/>
     *
     * @param key 列挙型で定義されたキー名称
     * @param effectiveDate 適用基準日
     * @return キー名に対応するコンフィグ設定値と説明
     */
    public static BusinessConfigInfo getConfigInfo(Enum key, RDate effectiveDate) {
        return getConfigInfo(key, effectiveDate, null, null, null);
    }

    /**
     * 引数で指定したキー名称、適用基準日、地方公共団体コードに対応するコンフィグ設定値と説明を返します。<br />
     * <p>
     * 条件に該当するコンフィグが存在しない場合はnullを返す。<br/>
     * サブ業務コードには自業務のコードが指定されます。
     * <p/>
     *
     * @param key 列挙型で定義されたキー名称
     * @param effectiveDate 適用基準日
     * @param lasdecCode 地方公共団体コード
     * @return キー名に対応するコンフィグ設定値と説明
     */
    public static BusinessConfigInfo getConfigInfo(Enum key, RDate effectiveDate, LasdecCode lasdecCode) {
        return getConfigInfo(key, effectiveDate, null, lasdecCode, null);
    }

    /**
     * 引数に指定したキー名称、適用基準日、汎用キーワードに対応するコンフィグ設定値と説明を取得します。<br />
     * <p>
     * 条件に該当するコンフィグが存在しない場合はnullを返す。<br/>
     * サブ業務コードには自業務のコードが指定されます。
     * <p/>
     *
     * @param key 列挙型で定義されたキー名称
     * @param effectiveDate 適用基準日
     * @param optionValue 汎用キーワード
     * @return キー名に対応するコンフィグ設定値と説明
     */
    public static BusinessConfigInfo getConfigInfo(Enum key, RDate effectiveDate, RString optionValue) {
        return getConfigInfo(key, effectiveDate, null, null, optionValue);
    }

    /**
     * 引数に指定したキー名称、適用基準日、地方公共団体コード、汎用キーワードに対応するコンフィグ設定値と説明を取得します。<br />
     * <p>
     * 条件に該当するコンフィグが存在しない場合はnullを返す。<br/>
     * サブ業務コードには自業務のコードが指定されます。
     * <p/>
     *
     * @param key 列挙型で定義されたキー名称
     * @param effectiveDate 適用基準日
     * @param lasdecCode 地方公共団体コード
     * @param optionValue 汎用キーワード
     * @return キー名に対応するコンフィグ設定値と説明
     */
    public static BusinessConfigInfo getConfigInfo(Enum key, RDate effectiveDate, LasdecCode lasdecCode, RString optionValue) {
        return getConfigInfo(key, effectiveDate, null, lasdecCode, optionValue);
    }

    /**
     *
     * 引数で指定したキー名称、サブ業務コードに対応するコンフィグ設定値と説明を運用日時点で取得します。<br />
     * <p>
     * 条件に該当するコンフィグが存在しない場合はnullを返す。
     * <p/>
     *
     * @param key 列挙型で定義されたキー名称
     * @param subGyomu サブ業務コード
     * @return キー名に対応するコンフィグ設定値と説明
     */
    public static BusinessConfigInfo getConfigInfo(Enum key, SubGyomuCode subGyomu) {
        return getConfigInfo(key, null, subGyomu, null, null);
    }

    /**
     *
     * 引数で指定したキー名称、サブ業務コード、地方公共団体コードに対応するコンフィグ設定値と説明を運用日時点で取得します。<br />
     * <p>
     * 条件に該当するコンフィグが存在しない場合はnullを返す。
     * <p/>
     *
     * @param key 列挙型で定義されたキー名称
     * @param subGyomu サブ業務コード
     * @param lasdecCode 地方公共団体コード
     * @return キー名に対応するコンフィグ設定値と説明
     */
    public static BusinessConfigInfo getConfigInfo(Enum key, SubGyomuCode subGyomu, LasdecCode lasdecCode) {
        return getConfigInfo(key, null, subGyomu, lasdecCode, null);
    }

    /**
     * 引数で指定したキー名称、適用基準日、サブ業務コードに対応するコンフィグ設定値と説明を取得します。<br />
     * <p>
     * 条件に該当するコンフィグが存在しない場合はnullを返す。
     * <p/>
     *
     * @param key 列挙型で定義されたキー名称
     * @param effectiveDate 適用基準日
     * @param subGyomu サブ業務コード
     * @return キー名に対応するコンフィグ設定値と説明
     */
    public static BusinessConfigInfo getConfigInfo(Enum key, RDate effectiveDate, SubGyomuCode subGyomu) {
        return getConfigInfo(key, effectiveDate, subGyomu, null, null);
    }

    /**
     * 引数で指定したキー名称、適用基準日、サブ業務コード、地方公共団体コードに対応するコンフィグ設定値と説明を取得します。<br />
     * <p>
     * 条件に該当するコンフィグが存在しない場合はnullを返す。
     * <p/>
     *
     * @param key 列挙型で定義されたキー名称
     * @param effectiveDate 適用基準日
     * @param subGyomu サブ業務コード
     * @param lasdecCode 地方公共団体コード
     * @return キー名に対応するコンフィグ設定値と説明
     */
    public static BusinessConfigInfo getConfigInfo(Enum key, RDate effectiveDate, SubGyomuCode subGyomu, LasdecCode lasdecCode) {
        return getConfigInfo(key, effectiveDate, subGyomu, lasdecCode, null);
    }

    /**
     * 引数に指定したキー名称、サブ業務コード、汎用キーワードに対応するコンフィグ設定値と説明を運用日時点で取得します。<br />
     * <p>
     * 条件に該当するコンフィグが存在しない場合はnullを返す。
     * <p/>
     *
     * @param key 列挙型で定義されたキー名称
     * @param subGyomu サブ業務コード
     * @param optionValue 汎用キーワード
     * @return キー名に対応するコンフィグ設定値と説明
     */
    public static BusinessConfigInfo getConfigInfo(Enum key, SubGyomuCode subGyomu, RString optionValue) {
        return getConfigInfo(key, null, subGyomu, null, optionValue);
    }

    /**
     * 引数に指定したキー名称、サブ業務コード、地方公共団体コード、汎用キーワードに対応するコンフィグ設定値と説明を運用日時点で取得します。
     * <p>
     * 条件に該当するコンフィグが存在しない場合はnullを返す。
     * <p/>
     *
     * @param key 列挙型で定義されたキー名称
     * @param subGyomu サブ業務コード
     * @param lasdecCode 地方公共団体コード
     * @param optionValue 汎用キーワード
     * @return キー名に対応するコンフィグ設定値と説明
     */
    public static BusinessConfigInfo getConfigInfo(Enum key, SubGyomuCode subGyomu, LasdecCode lasdecCode, RString optionValue) {
        return getConfigInfo(key, null, subGyomu, lasdecCode, optionValue);
    }

    /**
     * 引数に指定したキー名称、適用基準日、サブ業務コード、汎用キーワードに対応するコンフィグ設定値と説明を取得します。<br />
     * <p>
     * 条件に該当するコンフィグが存在しない場合はnullを返す。
     * <p/>
     *
     * @param key 列挙型で定義されたキー名称
     * @param effectiveDate 適用基準日
     * @param subGyomu サブ業務コード
     * @param optionValue 汎用キーワード
     * @return キー名に対応するコンフィグ設定値と説明
     */
    public static BusinessConfigInfo getConfigInfo(Enum key, RDate effectiveDate,
            SubGyomuCode subGyomu, RString optionValue) {
        return getConfigInfo(key, effectiveDate, subGyomu, null, optionValue);
    }

    /**
     * 引数に指定したキー名称、適用基準日、サブ業務コード、地方公共団体コード、汎用キーワードに対応するコンフィグ設定値と説明を取得します。
     * <p>
     * 条件に該当するコンフィグが存在しない場合はnullを返す。
     * <p/>
     *
     * @param key 列挙型で定義されたキー名称
     * @param effectiveDate 適用基準日
     * @param subGyomuCode サブ業務コード
     * @param lasdecCode 地方公共団体コード
     * @param optionValue 汎用キーワード
     * @return キー名に対応するコンフィグ設定値と説明
     */
    public static BusinessConfigInfo getConfigInfo(Enum key, RDate effectiveDate,
            SubGyomuCode subGyomuCode, LasdecCode lasdecCode, RString optionValue) {
        BusinessConfigInfo config = BusinessConfig.getConfigInfo(key, effectiveDate, subGyomuCode, lasdecCode, optionValue);
        if (config == null) {
            throw new SystemException(DbxErrorMessages.業務コンフィグなし.getMessage().replace(key.name()).evaluate());
        }
        return config;
    }
}
