package jp.co.ndensan.reams.db.dbx.definition.core.tokucho;

import jp.co.ndensan.reams.db.dbx.definition.core.ITsukiShorkiKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴期情報月処理区分を表す列挙型です。
 *
 * @reamsid_L DBB-9020-080 sunhaidi
 */
public enum TokuchokiJohoTsukiShoriKubun implements ITsukiShorkiKubun {

    /**
     * コード:0 名称:なし 略称:定義なし
     */
    なし("0", "なし"),
    /**
     * コード:1 名称:特徴仮算定 略称:定義なし
     */
    特徴仮算定("1", "特徴仮算定"),
    /**
     * コード:2 名称:特徴仮算定異動 略称:定義なし
     */
    特徴仮算定異動("2", "特徴仮算定異動"),
    /**
     * コード:3 名称:未使用 略称:定義なし
     */
    未使用("3", "未使用"),
    /**
     * コード:4 名称:本算定 略称:定義なし
     */
    本算定("4", "本算定"),
    /**
     * コード:5 名称:本算定異動 略称:定義なし
     */
    本算定異動("5", "本算定異動"),
    /**
     * コード:6 名称:随時 略称:定義なし
     */
    随時("6", "随時");

    private final RString code;
    private final RString fullName;

    private TokuchokiJohoTsukiShoriKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 特徴期情報月処理区分のコードを返します。
     *
     * @return 特徴期情報月処理区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特徴期情報月処理区分の名称を返します。
     *
     * @return 特徴期情報月処理区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特徴期情報月処理区分のコードと一致する内容を探します。
     *
     * @param code 特徴期情報月処理区分のコード
     * @return {@code code} に対応する特徴期情報月処理区分
     */
    public static TokuchokiJohoTsukiShoriKubun toValue(RString code) {
        for (TokuchokiJohoTsukiShoriKubun tokuchokiJohoTsukiShoriKubun : TokuchokiJohoTsukiShoriKubun.values()) {
            if (tokuchokiJohoTsukiShoriKubun.code.equals(code)) {
                return tokuchokiJohoTsukiShoriKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特徴期情報月処理区分"));
    }

    /**
     * 仮算定期処理です。
     *
     * @return 判断結果
     */
    @Override
    public boolean is仮算定期() {
        if (new RString("0").equals(code)) {
            return false;
        } else if (new RString("1").equals(code)) {
            return true;
        } else if (new RString("2").equals(code)) {
            return true;
        } else if (new RString("3").equals(code)) {
            return false;
        } else if (new RString("4").equals(code)) {
            return false;
        } else if (new RString("5").equals(code)) {
            return false;
        } else if (new RString("6").equals(code)) {
            return false;
        }
        return false;
    }

    /**
     * 本算定期処理です。
     *
     * @return 判断結果
     */
    @Override
    public boolean is本算定期() {
        if (new RString("0").equals(code)) {
            return false;
        } else if (new RString("1").equals(code)) {
            return false;
        } else if (new RString("2").equals(code)) {
            return false;
        } else if (new RString("3").equals(code)) {
            return false;
        } else if (new RString("4").equals(code)) {
            return true;
        } else if (new RString("5").equals(code)) {
            return true;
        } else if (new RString("6").equals(code)) {
            return true;
        }
        return false;
    }

    /**
     * 特徴期情報月処理区分の名称を返します。
     *
     * @return 特徴期情報月処理区分の名称
     */
    @Override
    public RString getName() {
        return fullName;
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
