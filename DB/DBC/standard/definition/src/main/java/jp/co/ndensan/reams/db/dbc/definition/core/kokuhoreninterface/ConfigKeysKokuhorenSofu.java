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
     * コード:531 名称:受給者異動連絡票情報 略称:受給者異動連絡票情報 表示順:12
     */
    受給者異動連絡票情報("531", "受給者異動連絡票情報", "受給者異動連絡票情報", "12"),
    /**
     * コード:5C1 名称:共同処理用受給者異動情報 略称:共同処理用受給者異動情報 表示順:14
     */
    共同処理用受給者異動情報("5C1", "共同処理用受給者異動情報", "共同処理用受給者異動情報", "14"),
    /**
     * コード:821 名称:給付管理票 略称:給付管理票 表示順:15
     */
    給付管理票("821", "給付管理票", "給付管理票", "15"),
    /**
     * コード:211 名称:償還連絡票情報 略称:償還連絡票情報 表示順:6
     */
    償還連絡票情報("211", "償還連絡票情報", "償還連絡票情報", "6"),
    /**
     * コード:341 名称:高額介護サービス費給付判定結果情報 略称:高額介護サービス費給付判定結果情報 表示順:7
     */
    受給者情報更新結果情報("341", "高額介護サービス費給付判定結果情報", "高額介護サービス費給付判定結果情報", "7"),
    /**
     * コード:113 名称:給付実績情報 略称:給付実績情報 表示順:1
     */
    給付実績情報("113", "給付実績情報", "給付実績情報", "1"),
    /**
     * コード:173 名称:過誤申立書情報 略称:過誤申立書情報 表示順:2
     */
    過誤申立書情報("173", "過誤申立書情報", "過誤申立書情報", "2"),
    /**
     * コード:174 名称:再審査申立書情報 略称:再審査申立書情報 表示順:3
     */
    再審査申立書情報("174", "再審査申立書情報", "再審査申立書情報", "3"),
    /**
     * コード:371 名称:高額合算支給申請書情報 略称:高額合算支給申請書情報 表示順:8
     */
    高額合算支給申請書情報("371", "高額合算支給申請書情報", "高額合算支給申請書情報", "8"),
    /**
     * コード:37K 名称:高額合算補正済自己負担額情報 略称:高額合算補正済自己負担額情報 表示順:10
     */
    高額合算補正済自己負担額情報("37K", "高額合算補正済自己負担額情報", "高額合算補正済自己負担額情報", "10"),
    /**
     * コード:381 名称:高額合算計算結果連絡票情報 略称:高額合算計算結果連絡票情報 表示順:9
     */
    高額合算計算結果連絡票情報("381", "高額合算計算結果連絡票情報", "高額合算計算結果連絡票情報", "9"),
    /**
     * コード:38Q 名称:高額合算給付実績情報 略称:高額合算給付実績情報 表示順:11
     */
    高額合算給付実績情報("38Q", "高額合算給付実績情報", "高額合算給付実績情報", "11"),
    /**
     * コード:176 名称:総合事業費経過措置過誤申立書情報 略称:総合事業費（経過措置）過誤申立書情報 表示順:4
     */
    総合事業費経過措置過誤申立書情報("176", "総合事業費経過措置過誤申立書情報", "総合事業費（経過措置）過誤申立書情報", "4"),
    /**
     * コード:179 名称:総合事業費過誤申立書情報 略称:総合事業費過誤申立書情報 表示順:5
     */
    総合事業費過誤申立書情報("179", "総合事業費過誤申立書情報", "総合事業費過誤申立書情報", "5"),
    /**
     * コード:536 名称:受給者突合情報 略称:受給者突合情報 表示順:13
     */
    受給者突合情報("536", "受給者突合情報", "受給者突合情報", "13");

    private final RString code;
    private final RString fullName;
    private final RString shortName;
    private final RString hyoujiSunao;

    private ConfigKeysKokuhorenSofu(String code, String fullname, String shortName, String hyoujiSunao) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
        this.hyoujiSunao = new RString(hyoujiSunao);
    }

    /**
     * 国保連取込コンフィグ一覧のコードを返します。
     *
     * @return 国保連取込コンフィグ一覧のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 国保連取込コンフィグ一覧の名称を返します。
     *
     * @return 国保連取込コンフィグ一覧の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 国保連取込コンフィグ一覧の略称を返します。
     *
     * @return 国保連取込コンフィグ一覧の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 国保連取込コンフィグ一覧の一覧表示順を返します。
     *
     * @return 国保連取込コンフィグ一覧の一覧表示順
     */
    public RString get一覧表示順() {
        return hyoujiSunao;
    }

    /**
     * 国保連取込コンフィグ一覧のコードと一致する内容を探します。
     *
     * @param code 国保連取込コンフィグ一覧のコード
     * @return {@code code} に対応する国保連取込コンフィグ一覧
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
