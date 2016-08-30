package jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * CSV出力設定を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum CSVSettings {

    /**
     * コード:1 名称:項目名付加 略称:定義なし
     */
    項目名付加("1", "項目名付加"),
    /**
     * コード:2 名称:連番付加 略称:定義なし
     */
    連番付加("2", "連番付加"),
    /**
     * コード:3 名称:日付’／’編集 略称:定義なし
     */
    日付スラッシュ編集("3", "日付’／’編集");

    private final RString code;
    private final RString fullName;

    private CSVSettings(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * CSV出力設定のコードを返します。
     *
     * @return CSV出力設定のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * CSV出力設定の名称を返します。
     *
     * @return CSV出力設定の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * CSV出力設定のコードと一致する内容を探します。
     *
     * @param code CSV出力設定のコード
     * @return {@code code} に対応するCSV出力設定
     */
    public static CSVSettings toValue(RString code) {
        for (CSVSettings cSVSettings : CSVSettings.values()) {
            if (cSVSettings.code.equals(code)) {
                return cSVSettings;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("CSV出力設定"));
    }
}
