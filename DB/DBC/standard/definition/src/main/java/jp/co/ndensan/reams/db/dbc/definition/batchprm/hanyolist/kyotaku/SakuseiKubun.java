package jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kyotaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 作成区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum SakuseiKubun {

    /**
     * コード:0 名称:すべて 略称:定義なし
     */
    すべて("0", "すべて"),
    /**
     * コード:1 名称:居宅支援のみ 略称:定義なし
     */
    居宅支援のみ("1", "居宅支援のみ"),
    /**
     * コード:2 名称:基準該当のみ 略称:定義なし
     */
    基準該当のみ("2", "基準該当のみ"),
    /**
     * コード:3 名称:居宅支援・基準該当のみ 略称:定義なし
     */
    居宅支援_基準該当のみ("3", "居宅支援・基準該当のみ"),
    /**
     * コード:4 名称:自己作成のみ 略称:定義なし
     */
    自己作成のみ("4", "自己作成のみ"),
    /**
     * コード:5 名称:予防支援のみ 略称:定義なし
     */
    予防支援のみ("5", "予防支援のみ");

    private final RString code;
    private final RString fullName;

    private SakuseiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 作成区分のコードを返します。
     *
     * @return 作成区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 作成区分の名称を返します。
     *
     * @return 作成区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 作成区分のコードと一致する内容を探します。
     *
     * @param code 作成区分のコード
     * @return {@code code} に対応する作成区分
     */
    public static SakuseiKubun toValue(RString code) {
        for (SakuseiKubun sakuseiKubun : SakuseiKubun.values()) {
            if (sakuseiKubun.code.equals(code)) {
                return sakuseiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("作成区分"));
    }
}
