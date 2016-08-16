/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyukyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 抽出項目区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 mawy
 */
public enum ChushutsuKomokuKubun {

    /**
     * コード:1 名称:申請日 略称:定義なし
     */
    申請日("1", "申請日"),
    /**
     * コード:2 名称:適用年月日 略称:定義なし
     */
    適用年月日("2", "適用年月日"),
    /**
     * コード3 名称:有効期限 略称:定義なし
     */
    有効期限("3", "有効期限"),
    /**
     * コード:4 名称:決定日 略称:定義なし
     */
    決定日("4", "決定日"),
    /**
     * コード:5 名称:入所日 略称:定義なし
     */
    入所日("5", "入所日"),
    /**
     * コード:6 名称:退所日 略称:定義なし
     */
    退所日("6", "退所日"),
    /**
     * コード:7 名称:資格取得日 略称:定義なし
     */
    取得日("7", "資格取得日"),
    /**
     * コード:8 名称:資格喪失日 略称:定義なし
     */
    喪失日("8", "資格喪失日"),
    /**
     * コード:9 名称:適用開始日 略称:定義なし
     */
    適用開始日("9", "適用開始日"),
    /**
     * コード:10 名称:適用終了日 略称:定義なし
     */
    適用終了日("10", "適用終了日"),
    /**
     * コード:11 名称:チェックリスト実施日 略称:定義なし
     */
    チェックリスト実施日("11", "チェックリスト実施日");

    private final RString code;
    private final RString fullName;

    private ChushutsuKomokuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 抽出項目区分のコードを返します。
     *
     * @return 抽出項目区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 抽出項目区分の名称を返します。
     *
     * @return 抽出項目区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 抽出項目区分のコードと一致する内容を探します。
     *
     * @param code 抽出項目区分のコード
     * @return {@code code} に対応する抽出項目区分
     */
    public static ChushutsuKomokuKubun toValue(RString code) {
        for (ChushutsuKomokuKubun chushutsuKoumokuKubun : ChushutsuKomokuKubun.values()) {
            if (chushutsuKoumokuKubun.code.equals(code)) {
                return chushutsuKoumokuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("対応する抽出項目区分"));
    }
}
