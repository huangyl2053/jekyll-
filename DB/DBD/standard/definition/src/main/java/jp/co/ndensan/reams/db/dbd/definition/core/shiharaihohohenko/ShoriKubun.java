package jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更処理区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 xuyue
 */
public enum ShoriKubun {

    /**
     * コード:01 名称:１号予告者登録 略称:定義なし
     */
    _1号予告者登録("01", "１号予告者登録"),
    /**
     * コード:02 名称:１号弁明書受理 略称:定義なし
     */
    _1号弁明書受理("02", "１号弁明書受理"),
    /**
     * コード:03 名称:償還払い化登録 略称:定義なし
     */
    償還払い化登録("03", "償還払い化登録"),
    /**
     * コード:04 名称:償還払い化終了申請 略称:定義なし
     */
    償還払い化終了申請("04", "償還払い化終了申請"),
    /**
     * コード:05 名称:給付一時差止登録 略称:定義なし
     */
    給付一時差止登録("05", "給付一時差止登録"),
    /**
     * コード:06 名称:保険料控除登録 略称:定義なし
     */
    保険料控除登録("06", "保険料控除登録"),
    /**
     * コード:11 名称:給付額減額登録 略称:定義なし
     */
    給付額減額登録("11", "給付額減額登録"),
    /**
     * コード:12 名称:減額免除申請 略称:定義なし
     */
    減額免除申請("12", "減額免除申請"),
    /**
     * コード:13 名称:免除解除／再転入 略称:定義なし
     */
    免除解除_再転入("13", "免除解除／再転入"),
    /**
     * コード:21 名称:２号予告者登録 略称:定義なし
     */
    _2号予告者登録("21", "２号予告者登録"),
    /**
     * コード:22 名称:２号弁明書受理 略称:定義なし
     */
    _2号弁明書受理("22", "２号弁明書受理"),
    /**
     * コード:23 名称:２号一時差止登録 略称:定義なし
     */
    _2号一時差止登録("23", "２号一時差止登録"),
    /**
     * コード:24 名称:２号一時差止解除 略称:定義なし
     */
    _2号一時差止解除("24", "２号一時差止解除");

    private final RString code;
    private final RString fullName;

    private ShoriKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 支払方法変更処理区分のコードを返します。
     *
     * @return 支払方法変更処理区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 支払方法変更処理区分の名称を返します。
     *
     * @return 支払方法変更処理区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 支払方法変更処理区分のコードと一致する内容を探します。
     *
     * @param code 支払方法変更処理区分のコード
     * @return {@code code} に対応する支払方法変更処理区分
     */
    public static ShoriKubun toValue(RString code) {
        for (ShoriKubun jikoGoShunyuKubun : ShoriKubun.values()) {
            if (jikoGoShunyuKubun.code.equals(code)) {
                return jikoGoShunyuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支払方法変更処理区分"));
    }
}
