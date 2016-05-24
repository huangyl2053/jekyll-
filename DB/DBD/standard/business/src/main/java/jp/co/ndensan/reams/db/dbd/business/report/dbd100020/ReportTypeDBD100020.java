package jp.co.ndensan.reams.db.dbd.business.report.dbd100020;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票タイプDBD100020を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum ReportTypeDBD100020 {

    /**
     * コード:0 名称:デザインシート 略称:定義なし
     */
    デザインシート("0", "デザインシート"),
    /**
     * コード:1 名称:オーバーレイ 略称:定義なし
     */
    オーバーレイ("1", "オーバーレイ");

    private final RString code;
    private final RString fullName;

    private ReportTypeDBD100020(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 帳票タイプDBD100020のコードを返します。
     *
     * @return 帳票タイプDBD100020のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 帳票タイプDBD100020の名称を返します。
     *
     * @return 帳票タイプDBD100020の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 帳票タイプDBD100020のコードと一致する内容を探します。
     *
     * @param code 帳票タイプDBD100020のコード
     * @return {@code code} に対応する帳票タイプDBD100020
     */
    public static ReportTypeDBD100020 toValue(RString code) {
        for (ReportTypeDBD100020 reportTypeDBD100020 : ReportTypeDBD100020.values()) {
            if (reportTypeDBD100020.code.equals(code)) {
                return reportTypeDBD100020;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("帳票タイプDBD100020"));
    }
}
