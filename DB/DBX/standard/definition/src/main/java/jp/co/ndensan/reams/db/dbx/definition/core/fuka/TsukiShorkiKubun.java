/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.fuka;

import jp.co.ndensan.reams.db.dbx.definition.core.ITsukiShorkiKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 月処理区分のデフォルト値を表す列挙型です。
 *
 * @reamsid_L DBB-9020-080 sunhaidi
 */
public enum TsukiShorkiKubun implements ITsukiShorkiKubun {

    /**
     * コード:なし 名称:なし 略称:なし 期月生成時に月処理区分が設定されなかった場合に使用する。
     */
    デフォルト("", "");

    private final RString code;
    private final RString fullName;

    private TsukiShorkiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 過年度月処理区分のコードを返します。
     *
     * @return 過年度月処理区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 過年度月処理区分の名称を返します。
     *
     * @return 過年度月処理区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 過年度月処理区分のコードと一致する内容を探します。
     *
     * @param code 過年度月処理区分のコード
     * @return {@code code} に対応する過年度月処理区分
     */
    public static TsukiShorkiKubun toValue(RString code) {
        for (TsukiShorkiKubun tsukiShorkiKubun : TsukiShorkiKubun.values()) {
            if (tsukiShorkiKubun.code.equals(code)) {
                return tsukiShorkiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("過年度月処理区分"));
    }

    /**
     * 仮算定期処理です。
     *
     * @return 判断結果
     */
    @Override
    public boolean is仮算定期() {
        return false;
    }

    /**
     * 本算定期処理です。
     *
     * @return 判断結果
     */
    @Override
    public boolean is本算定期() {
        return false;
    }

    /**
     * 過年度月処理区分の名称を返します。
     *
     * @return 過年度月処理区分の名称
     */
    @Override
    public RString getName() {
        return RString.EMPTY;
    }

    /**
     * 区分を返します。
     *
     * @return 区分
     */
    @Override
    public RString get区分() {
        return fullName;
    }
}
