/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連送付コンフィグ一覧
 *
 * @reamsid_L DBC-9999-022 wangxingpeng
 */
public enum ConfigKeysKokuhorenSofu {

    /**
     * コード:531 名称:受給者異動連絡票情報 略称:受給者異動連絡票情報 表示順:13 スケジュール設定有無:true
     */
    受給者異動連絡票情報("531", "受給者異動連絡票情報", "受給者異動連絡票情報", "13", true),
    /**
     * コード:5C1 名称:共同処理用受給者異動情報 略称:共同処理用受給者異動情報 表示順:14 スケジュール設定有無:true
     */
    共同処理用受給者異動情報("5C1", "共同処理用受給者異動情報", "共同処理用受給者異動情報", "14", true),
    /**
     * コード:821 名称:給付管理票 略称:給付管理票 表示順:15 スケジュール設定有無:true
     */
    給付管理票("821", "給付管理票", "給付管理票", "15", true),
    /**
     * コード:211 名称:償還連絡票情報 略称:償還連絡票情報 表示順:6 スケジュール設定有無:true
     */
    償還連絡票情報("211", "償還連絡票情報", "償還連絡票情報", "6", true),
    /**
     * コード:341 名称:高額介護サービス費給付判定結果情報 略称:高額介護サービス費給付判定結果情報 表示順:7 スケジュール設定有無:true
     */
    高額介護サービス費給付判定結果情報("341", "高額介護サービス費給付判定結果情報", "高額介護サービス費給付判定結果情報", "7", true),
    /**
     * コード:113 名称:給付実績情報 略称:給付実績情報 表示順:1 スケジュール設定有無:true
     */
    給付実績情報("113", "給付実績情報", "給付実績情報", "1", true),
    /**
     * コード:173 名称:過誤申立書情報 略称:過誤申立書情報 表示順:2 スケジュール設定有無:true
     */
    過誤申立書情報("173", "過誤申立書情報", "過誤申立書情報", "2", true),
    /**
     * コード:174 名称:再審査申立書情報 略称:再審査申立書情報 表示順:3 スケジュール設定有無:true
     */
    再審査申立書情報("174", "再審査申立書情報", "再審査申立書情報", "3", true),
    /**
     * コード:371 名称:高額合算支給申請書情報 略称:高額合算支給申請書情報 表示順:8 スケジュール設定有無:true
     */
    高額合算支給申請書情報("371", "高額合算支給申請書情報", "高額合算支給申請書情報", "8", true),
    /**
     * コード:37K 名称:高額合算補正済自己負担額情報 略称:高額合算補正済自己負担額情報 表示順:10 スケジュール設定有無:true
     */
    高額合算補正済自己負担額情報("37K", "高額合算補正済自己負担額情報", "高額合算補正済自己負担額情報", "10", true),
    /**
     * コード:37K1 名称:高額合算補正済自己負担額情報（国保分） 略称:高額合算補正済自己負担額情報（国保分） 表示順:10
     * スケジュール設定有無:true
     */
    高額合算補正済自己負担額情報_国保分("37K1", "高額合算補正済自己負担額情報（国保分）", "高額合算補正済自己負担額情報（国保分）", "10", true),
    /**
     * コード:37K2 名称:高額合算補正済自己負担額情報（後期分） 略称:高額合算補正済自己負担額情報（後期分） 表示順:11
     * スケジュール設定有無:true
     */
    高額合算補正済自己負担額情報_後期分("37K2", "高額合算補正済自己負担額情報（後期分）", "高額合算補正済自己負担額情報（後期分）", "11", true),
    /**
     * コード:381 名称:高額合算計算結果連絡票情報 略称:高額合算計算結果連絡票情報 表示順:9 スケジュール設定有無:true
     */
    高額合算計算結果連絡票情報("381", "高額合算計算結果連絡票情報", "高額合算計算結果連絡票情報", "9", true),
    /**
     * コード:38Q 名称:高額合算給付実績情報 略称:高額合算給付実績情報 表示順:12 スケジュール設定有無:true
     */
    高額合算給付実績情報("38Q", "高額合算給付実績情報", "高額合算給付実績情報", "12", true),
    /**
     * コード:176 名称:総合事業費経過措置過誤申立書情報 略称:総合事業費（経過措置）過誤申立書情報 表示順:4 スケジュール設定有無:false
     */
    総合事業費経過措置過誤申立書情報("176", "総合事業費経過措置過誤申立書情報", "総合事業費（経過措置）過誤申立書情報", "4", true),
    /**
     * コード:179 名称:総合事業費過誤申立書情報 略称:総合事業費過誤申立書情報 表示順:5 スケジュール設定有無:false
     */
    総合事業費過誤申立書情報("179", "総合事業費過誤申立書情報", "総合事業費過誤申立書情報", "5", true),
    /**
     * コード:536 名称:受給者突合情報 略称:受給者突合情報 表示順:0 スケジュール設定有無:true
     */
    受給者突合情報("536", "受給者突合情報", "受給者突合情報", "0", false),
    /**
     * コード:5H1 名称:総合事業分サービスコード異動連絡票情報 略称:受給者突合情報 表示順:0 スケジュール設定有無:false
     */
    総合事業分サービスコード異動連絡票情報("5H1", "総合事業分サービスコード異動連絡票情報", "総合事業分サービスコード異動連絡票情報", "0", false);

    private final RString code;
    private final RString fullName;
    private final RString shortName;
    private final RString hyoujiSunao;
    private final boolean sukejuruSetFlag;

    private ConfigKeysKokuhorenSofu(String code, String fullname, String shortName, String hyoujiSunao, boolean sukejuruSetFlag) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
        this.hyoujiSunao = new RString(hyoujiSunao);
        this.sukejuruSetFlag = sukejuruSetFlag;
    }

    /**
     * 国保連送付コンフィグ一覧のコードを返します。
     *
     * @return 国保連送付コンフィグ一覧のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 国保連送付コンフィグ一覧の名称を返します。
     *
     * @return 国保連送付コンフィグ一覧の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 国保連送付コンフィグ一覧の略称を返します。
     *
     * @return 国保連送付コンフィグ一覧の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 国保連送付コンフィグ一覧の一覧表示順を返します。
     *
     * @return 国保連送付コンフィグ一覧の一覧表示順
     */
    public RString get一覧表示順() {
        return hyoujiSunao;
    }

    /**
     * 国保連送付コンフィグ一覧のスケジュール設定有無を返します。
     *
     * @return 国保連送付コンフィグ一覧のスケジュール設定有無
     */
    public boolean isスケジュール設定有無() {
        return sukejuruSetFlag;
    }

    /**
     * 国保連送付コンフィグ一覧のコードと一致する内容を探します。
     *
     * @param code 国保連送付コンフィグ一覧のコード
     * @return {@code code} に対応する国保連送付コンフィグ一覧
     */
    public static ConfigKeysKokuhorenSofu toValue(RString code) {

        for (ConfigKeysKokuhorenSofu configKeysKokuhorenTorikomi : ConfigKeysKokuhorenSofu.values()) {
            if (configKeysKokuhorenTorikomi.code.equals(code)) {
                return configKeysKokuhorenTorikomi;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("国保連送付コンフィグ一覧"));
    }
}
