package jp.co.ndensan.reams.db.dbz.definition.core.servicechushutsukbn;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービス種類抽出区分を表す列挙型です。
 *
 * @reamsid_L DBA-0140-030 houtianpeng
 */
public enum ServiceChushutsuKbn {

    /**
     * コード:1 名称:使用しない 略称:使用しない
     */
    使用しない("1", "使用しない", "使用しない"),
    /**
     * コード:2 名称:分類指定なし(全て) 略称:分類指定なし(全て)
     */
    分類指定なし_全て("2", "分類指定なし(全て)", "分類指定なし(全て)"),
    /**
     * コード:3 名称:保険給付 略称:保険給付
     */
    保険給付("3", "保険給付", "保険給付"),
    /**
     * コード:4 名称:総合事業費(経過措置) 略称:総合事業費(経過措置)
     */
    総合事業費_経過措置("4", "総合事業費(経過措置)", "総合事業費(経過措置)"),
    /**
     * コード:5 名称:総合事業費 略称:総合事業費
     */
    総合事業費("5", "総合事業費", "総合事業費"),
    /**
     * コード:6 名称:総合事業費(経過措置含む) 略称:総合事業費(経過措置含む)
     */
    総合事業費_経過措置含む("6", "総合事業費(経過措置含む)", "総合事業費(経過措置含む)"),
    /**
     * コード:7 名称:種類指定 略称:種類指定
     */
    種類指定("7", "種類指定", "種類指定");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private ServiceChushutsuKbn(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * サービス種類抽出区分のコードを返します。
     *
     * @return サービス種類抽出区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * サービス種類抽出区分の名称を返します。
     *
     * @return サービス種類抽出区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * サービス種類抽出区分の略称を返します。
     *
     * @return サービス種類抽出区分の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * サービス種類抽出区分のコードと一致する内容を探します。
     *
     * @param code サービス種類抽出区分のコード
     * @return {@code code} に対応するサービス種類抽出区分
     */
    public static ServiceChushutsuKbn toValue(RString code) {
        for (ServiceChushutsuKbn serviceChushutsuKbn : ServiceChushutsuKbn.values()) {
            if (serviceChushutsuKbn.code.equals(code)) {
                return serviceChushutsuKbn;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("サービス種類抽出区分"));
    }
}
