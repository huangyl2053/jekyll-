package jp.co.ndensan.reams.db.dbd.definition.core.jikokisanbikanri;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 時効起算日区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum JikoKisanbiKubun {

    /**
     * コード:1 名称:納期限翌日 略称:定義なし 記号:納
     */
    納期限翌日("1", "納期限翌日", "納"),
    /**
     * コード:2 名称:督促状発行日 略称:定義なし 記号:督
     */
    督促状発行日("2", "督促状発行日", "督"),
    /**
     * コード:3 名称:収入日 略称:定義なし 記号:収
     */
    収入日("3", "収入日", "収"),
    /**
     * コード:4 名称:債務者の債務の承認 略称:定義なし 記号:債
     */
    債務者の債務の承認("4", "債務者の債務の承認", "債"),
    /**
     * コード:5 名称:差押 略称:定義なし 記号:差
     */
    差押("5", "差押", "差"),
    /**
     * コード:6 名称:仮差押 略称:定義なし 記号:仮
     */
    仮差押("6", "仮差押", "仮"),
    /**
     * コード:7 名称:仮処分 略称:定義なし 記号:処
     */
    仮処分("7", "仮処分", "処"),
    /**
     * コード:8 名称:裁判上の請求等_被保険者に対する請求 略称:定義なし 記号:裁
     */
    裁判上の請求等_被保険者に対する請求("8", "裁判上の請求等_被保険者に対する請求", "裁"),
    /**
     * コード:9 名称:不明_調定無し 略称:定義なし 記号:不
     */
    不明_調定無し("9", "不明_調定無し", "不"),
    /**
     * コード:A 名称:その他 略称:定義なし 記号:そ
     */
    その他("A", "その他", "そ"),
    /**
     * コード:B 名称:分納契約日 略称:定義なし 記号:分
     */
    分納契約日("B", "分納契約日", "分");

    private final RString code;
    private final RString fullName;
    private final RString kigou;

    private JikoKisanbiKubun(String code, String fullname, String kigou) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.kigou = new RString(kigou);
    }

    /**
     * 時効起算日区分のコードを返します。
     *
     * @return 時効起算日区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 時効起算日区分の名称を返します。
     *
     * @return 時効起算日区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 時効起算日区分の記号を返します。
     *
     * @return 時効起算日区分の記号
     */
    public RString get記号() {
        return kigou;
    }

    /**
     * 時効起算日区分のコードと一致する内容を探します。
     *
     * @param code 時効起算日区分のコード
     * @return {@code code} に対応する時効起算日区分
     */
    public static JikoKisanbiKubun toValue(RString code) {
        for (JikoKisanbiKubun jikoKisanbiKubun : JikoKisanbiKubun.values()) {
            if (jikoKisanbiKubun.code.equals(code)) {
                return jikoKisanbiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("時効起算日区分"));
    }
}
