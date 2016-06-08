package jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.shokan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理状況を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum ShoriJokyo {

    /**
     * コード:0 名称:すべて 略称:処理状況を抽出条件としない
     */
    すべて("0", "すべて", "処理状況を抽出条件としない"),
    /**
     * コード:1 名称:申請入力のみ 略称:申請情報入力のみされていて、支給・不支給決定入力されていないデータを抽出
     */
    申請入力("1", "申請入力のみ", "申請情報入力のみされていて、支給・不支給決定入力されていないデータを抽出"),
    /**
     * コード:2 名称:国保連送付済み 略称:共同処理を委託している場合：国保連合会に申請情報が送付されていて、 支給・不支給決定待ちのデータを抽出共同処理を委託していない場合：データは抽出されない
     */
    国保連送付済("2", "国保連送付済み", "共同処理を委託している場合：国保連合会に申請情報が送付されていて、"
            + "支給・不支給決定待ちのデータを抽出共同処理を委託していない場合：データは抽出されない"),
    /**
     * コード:3 名称:不給不支給決定済み 略称:共同処理を委託している場合：国保連合会からの支給不支給決定情報を取込済みで、決定通知書の発行がされていないデータを抽出共同処理を委託していない場合：保険者で支給・不支給が決定されていて、決定通知書の発行されていないデータを抽出
     */
    不給不支給決定済("3", "不給不支給決定済み", "共同処理を委託している場合：国保連合会からの支給不支給決定情報を取込済みで、"
            + "決定通知書の発行がされていないデータを抽出共同処理を委託していない場合：保険者で支給・不支給が決定されていて、"
            + "決定通知書の発行されていないデータを抽出"),
    /**
     * コード:4 名称:通知書発行済み 略称:決定通知書が発行されていて、振込明細書が作成されていないデータを抽出
     */
    通知書発行済("4", "通知書発行済み", "決定通知書が発行されていて、振込明細書が作成されていないデータを抽出"),
    /**
     * コード:5 名称:振込明細発行済み 略称:吹き込み明細書が発行されているデータを抽出
     */
    振込明細発行済("5", "振込明細発行済み", "吹き込み明細書が発行されているデータを抽出");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private ShoriJokyo(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 処理状況のコードを返します。
     *
     * @return 処理状況のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 処理状況の名称を返します。
     *
     * @return 処理状況の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 処理状況の略称を返します。
     *
     * @return 処理状況の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 処理状況のコードと一致する内容を探します。
     *
     * @param code 処理状況のコード
     * @return {@code code} に対応する処理状況
     */
    public static ShoriJokyo toValue(RString code) {
        for (ShoriJokyo shoriJokyo : ShoriJokyo.values()) {
            if (shoriJokyo.code.equals(code)) {
                return shoriJokyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("処理状況"));
    }
}
