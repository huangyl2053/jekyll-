/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連送付交換情報識別番号を表す列挙型です。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
public enum KokuhorenSofuKokanJohoShikibetsuBango {

    /**
     * コード:1113 名称:保険者保有給付実績情報 略称:保険者保有給付実績情報
     */
    保険者保有給付実績情報("1113", "保険者保有給付実績情報", "保険者保有給付実績情報"),
    /**
     * コード:1731 名称:介護給付過誤申立書情報 略称:介護給付過誤申立書情報
     */
    介護給付過誤申立書情報("1731", "介護給付過誤申立書情報", "介護給付過誤申立書情報"),
    /**
     * コード:1741 名称:介護給付費再審査申立書情報 略称:介護給付費再審査申立書情報
     */
    介護給付費再審査申立書情報("1741", "介護給付費再審査申立書情報", "介護給付費再審査申立書情報"),
    /**
     * コード:1742 名称:介護給付費再審査申立書情報_平成15年4月以降 略称:介護給付費再審査申立書情報
     */
    介護給付費再審査申立書情報_平成15年4月以降("1742", "介護給付費再審査申立書情報_平成15年4月以降", "介護給付費再審査申立書情報"),
    /**
     * コード:1761 名称:総合事業費経過措置過誤申立書情報 略称:総合事業費経過措置過誤申立書情報
     */
    総合事業費経過措置過誤申立書情報("1761", "総合事業費経過措置過誤申立書情報", "総合事業費経過措置過誤申立書情報"),
    /**
     * コード:1791 名称:総合事業費過誤申立書情報 略称:総合事業費過誤申立書情報
     */
    総合事業費過誤申立書情報("1791", "総合事業費過誤申立書情報", "総合事業費過誤申立書情報"),
    /**
     * コード:2111 名称:償還連絡票情報 略称:償還連絡票情報
     */
    償還連絡票情報("2111", "償還連絡票情報", "償還連絡票情報"),
    /**
     * コード:3711 名称:高額合算支給申請書情報 略称:高額合算支給申請書情報
     */
    高額合算支給申請書情報("3711", "高額合算支給申請書情報", "高額合算支給申請書情報"),
    /**
     * コード:37K1 名称:高額合算補正済自己負担額情報 略称:高額合算補正済自己負担額情報
     */
    高額合算補正済自己負担額情報("37K1", "高額合算補正済自己負担額情報", "高額合算補正済自己負担額情報"),
    /**
     * コード:3811 名称:高額合算計算結果連絡票情報 略称:高額合算計算結果連絡票情報
     */
    高額合算計算結果連絡票情報("3811", "高額合算計算結果連絡票情報", "高額合算計算結果連絡票情報"),
    /**
     * コード:38Q1 名称:高額合算給付実績情報 略称:高額合算給付実績情報
     */
    高額合算給付実績情報("38Q1", "高額合算給付実績情報", "高額合算給付実績情報"),
    /**
     * コード:8222 名称:給付管理票情報 略称:給付管理票情報
     */
    給付管理票情報("8222", "給付管理票情報", "給付管理票情報"),
    /**
     * コード:5361 名称:受給者突合依頼情報 略称:受給者突合依頼情報
     */
    受給者突合依頼情報("5361", "受給者突合依頼情報", "受給者突合依頼情報"),
    /**
     * コード:3411 名称:高額介護サービス費給付判定結果情報 略称:高額介護サービス費給付判定結果情報
     */
    高額介護サービス費給付判定結果情報("3411", "高額介護サービス費給付判定結果情報", "高額介護サービス費給付判定結果情報");
    private final RString code;
    private final RString shortName;
    private final RString fullName;

    private KokuhorenSofuKokanJohoShikibetsuBango(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 国保連送付交換情報識別番号のコードを返します。
     *
     * @return 国保連送付交換情報識別番号のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 国保連送付交換情報識別番号の名称を返します。
     *
     * @return 国保連送付交換情報識別番号の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 国保連送付交換情報識別番号の名称を返します。
     *
     * @return 国保連送付交換情報識別番号の名称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 国保連送付交換情報識別番号のコードと一致する内容を探します。
     *
     * @param code 国保連送付交換情報識別番号のコード
     * @return {@code code} に対応する国保連送付交換情報識別番号
     */
    public static KokuhorenSofuKokanJohoShikibetsuBango toValue(RString code) {

        for (KokuhorenSofuKokanJohoShikibetsuBango dataSaisoFlag : KokuhorenSofuKokanJohoShikibetsuBango.values()) {
            if (dataSaisoFlag.code.equals(code)) {
                return dataSaisoFlag;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("国保連送付交換情報識別番号"));
    }
}
