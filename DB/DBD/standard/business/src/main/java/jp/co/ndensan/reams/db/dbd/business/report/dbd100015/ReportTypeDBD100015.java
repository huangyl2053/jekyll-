package jp.co.ndensan.reams.db.dbd.business.report.dbd100015;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票タイプDBD100015を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum ReportTypeDBD100015 {

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

    private ReportTypeDBD100015(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 帳票タイプDBD100015のコードを返します。
     *
     * @return 帳票タイプDBD100015のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 帳票タイプDBD100015の名称を返します。
     *
     * @return 帳票タイプDBD100015の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 帳票タイプDBD100015のコードと一致する内容を探します。
     *
     * @param code 帳票タイプDBD100015のコード
     * @return {@code code} に対応する帳票タイプDBD100015
     */
    public static ReportTypeDBD100015 toValue(RString code) {
        for (ReportTypeDBD100015 reportTypeDBD100015 : ReportTypeDBD100015.values()) {
            if (reportTypeDBD100015.code.equals(code)) {
                return reportTypeDBD100015;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("帳票タイプDBD100015"));
    }
}
