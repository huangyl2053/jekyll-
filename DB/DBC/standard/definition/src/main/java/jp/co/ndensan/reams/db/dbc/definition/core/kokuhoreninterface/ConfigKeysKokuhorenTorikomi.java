package jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連取込コンフィグ一覧を表す列挙型です。
 *
 * @author LDNS
 */
public enum ConfigKeysKokuhorenTorikomi {

    /**
     * コード:111 名称:受給者情報更新結果情報 略称:定義なし
     */
    受給者情報更新結果情報("111", "受給者情報更新結果情報"),
    /**
     * コード:112 名称:共同処理用受給者情報更新結果 略称:定義なし
     */
    共同処理用受給者情報更新結果("112", "共同処理用受給者情報更新結果"),
    /**
     * コード:114 名称:給付実績情報 略称:定義なし
     */
    給付実績情報("114", "給付実績情報"),
    /**
     * コード:121 名称:給付管理票情報 略称:定義なし
     */
    給付管理票情報("121", "給付管理票情報"),
    /**
     * コード:122 名称:給付実績更新結果情報 略称:定義なし
     */
    給付実績更新結果情報("122", "給付実績更新結果情報"),
    /**
     * コード:151 名称:介護給付費等審査決定請求明細表情報 略称:定義なし
     */
    介護給付費等審査決定請求明細表情報("151", "介護給付費等審査決定請求明細表情報"),
    /**
     * コード:152 名称:介護給付費過誤決定通知書情報 略称:定義なし
     */
    介護給付費過誤決定通知書情報("152", "介護給付費過誤決定通知書情報"),
    /**
     * コード:161 名称:介護給付費再審査決定通知書情報 略称:定義なし
     */
    介護給付費再審査決定通知書情報("161", "介護給付費再審査決定通知書情報"),
    /**
     * コード:162 名称:介護給付費等請求額通知書情報 略称:定義なし
     */
    介護給付費等請求額通知書情報("162", "介護給付費等請求額通知書情報"),
    /**
     * コード:171 名称:介護給付費過誤決定通知書公費情報 略称:定義なし
     */
    介護給付費過誤決定通知書公費情報("171", "介護給付費過誤決定通知書公費情報"),
    /**
     * コード:172 名称:介護給付費再審査決定通知書公費情報 略称:定義なし
     */
    介護給付費再審査決定通知書公費情報("172", "介護給付費再審査決定通知書公費情報"),
    /**
     * コード:175 名称:介護給付費等請求額通知書公費情報 略称:定義なし
     */
    介護給付費等請求額通知書公費情報("175", "介護給付費等請求額通知書公費情報"),
    /**
     * コード:221 名称:介護給付費公費受給者別一覧表情報 略称:定義なし
     */
    介護給付費公費受給者別一覧表情報("221", "介護給付費公費受給者別一覧表情報"),
    /**
     * コード:222 名称:償還払支給決定者一覧情報 略称:定義なし
     */
    償還払支給決定者一覧情報("222", "償還払支給決定者一覧情報"),
    /**
     * コード:331 名称:償還払不支給決定者一覧情報 略称:定義なし
     */
    償還払不支給決定者一覧情報("331", "償還払不支給決定者一覧情報"),
    /**
     * コード:351 名称:高額介護サービス費給付対象者一覧表情報 略称:定義なし
     */
    高額介護サービス費給付対象者一覧表情報("351", "高額介護サービス費給付対象者一覧表情報"),
    /**
     * コード:386 名称:高額介護サービス費支給不支給決定者一覧表情報 略称:定義なし
     */
    高額介護サービス費支給不支給決定者一覧表情報("386", "高額介護サービス費支給不支給決定者一覧表情報"),
    /**
     * コード:533 名称:受給者台帳情報一覧 略称:定義なし
     */
    受給者台帳情報一覧("533", "受給者台帳情報一覧"),
    /**
     * コード:534 名称:受給者台帳突合結果情報随時 略称:定義なし
     */
    受給者台帳突合結果情報随時("534", "受給者台帳突合結果情報随時"),
    /**
     * コード:537 名称:共同処理用受給者情報一覧 略称:定義なし
     */
    共同処理用受給者情報一覧("537", "共同処理用受給者情報一覧"),
    /**
     * コード:631 名称:高額合算自己負担額確認情報 略称:定義なし
     */
    高額合算自己負担額確認情報("631", "高額合算自己負担額確認情報"),
    /**
     * コード:641 名称:高額合算自己負担額証明書情報 略称:定義なし
     */
    高額合算自己負担額証明書情報("641", "高額合算自己負担額証明書情報"),
    /**
     * コード:651 名称:高額合算支給額計算結果連絡票情報 略称:定義なし
     */
    高額合算支給額計算結果連絡票情報("651", "高額合算支給額計算結果連絡票情報"),
    /**
     * コード:652 名称:高額合算支給不支給決定通知書情報 略称:定義なし
     */
    高額合算支給不支給決定通知書情報("652", "高額合算支給不支給決定通知書情報"),
    /**
     * コード:741 名称:高額合算給付実績情報 略称:定義なし
     */
    高額合算給付実績情報("741", "高額合算給付実績情報"),
    /**
     * コード:37H 名称:総合事業費過誤決定通知書情報 略称:定義なし
     */
    総合事業費過誤決定通知書情報("37H", "総合事業費過誤決定通知書情報"),
    /**
     * コード:37J 名称:総合事業費請求額通知書情報 略称:定義なし
     */
    総合事業費請求額通知書情報("37J", "総合事業費請求額通知書情報"),
    /**
     * コード:38B 名称:総合事業費審査決定請求明細表情報 略称:定義なし
     */
    総合事業費審査決定請求明細表情報("38B", "総合事業費審査決定請求明細表情報"),
    /**
     * コード:38P 名称:請求明細給付管理票返戻保留一覧表情報 略称:定義なし
     */
    請求明細給付管理票返戻保留一覧表情報("38P", "請求明細給付管理票返戻保留一覧表情報"),
    /**
     * コード:5C3 名称:資格照合表情報 略称:定義なし
     */
    資格照合表情報("5C3", "資格照合表情報"),
    /**
     * コード:5C4 名称:総合事業費資格照合表情報 略称:定義なし
     */
    総合事業費資格照合表情報("5C4", "総合事業費資格照合表情報");

    private final RString code;
    private final RString fullName;

    private ConfigKeysKokuhorenTorikomi(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
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
     * 国保連取込コンフィグ一覧のコードと一致する内容を探します。
     *
     * @param code 国保連取込コンフィグ一覧のコード
     * @return {@code code} に対応する国保連取込コンフィグ一覧
     */
    public static ConfigKeysKokuhorenTorikomi toValue(RString code) {

        for (ConfigKeysKokuhorenTorikomi configKeysKokuhorenTorikomi : ConfigKeysKokuhorenTorikomi.values()) {
            if (configKeysKokuhorenTorikomi.code.equals(code)) {
                return configKeysKokuhorenTorikomi;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("国保連取込コンフィグ一覧"));
    }
}
