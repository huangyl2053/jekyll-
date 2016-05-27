package jp.co.ndensan.reams.db.dbd.business.report;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更通知書を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum ShiharaiHohoHenkoTsuchisho {

    /**
     * コード:なし 名称:支払方法変更予告通知書 略称:定義なし
     */
    支払方法変更予告通知書("支払方法変更予告通知書"),
    /**
     * コード:なし 名称:支払方法変更通知書 略称:定義なし
     */
    支払方法変更通知書("支払方法変更通知書"),
    /**
     * コード:なし 名称:支払一時差止通知書 略称:定義なし
     */
    支払一時差止通知書("支払一時差止通知書"),
    /**
     * コード:なし 名称:滞納保険料控除通知書 略称:定義なし
     */
    滞納保険料控除通知書("滞納保険料控除通知書"),
    /**
     * コード:なし 名称:給付額減額通知書 略称:定義なし
     */
    給付額減額通知書("給付額減額通知書"),
    /**
     * コード:なし 名称:差止予告通知書_２号用 略称:定義なし
     */
    差止予告通知書_２号用("差止予告通知書_２号用"),
    /**
     * コード:なし 名称:差止処分通知書_２号用 略称:定義なし
     */
    差止処分通知書_２号用("差止処分通知書_２号用");

    private final RString fullName;

    private ShiharaiHohoHenkoTsuchisho(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * 支払方法変更通知書の名称を返します。
     *
     * @return 支払方法変更通知書の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 支払方法変更通知書の名称と一致する内容を探します。
     *
     * @param fullname 支払方法変更通知書の名称
     * @return {@code fullname} に対応する支払方法変更通知書
     */
    public static ShiharaiHohoHenkoTsuchisho toValue(RString fullname) {
        for (ShiharaiHohoHenkoTsuchisho shiharaiHohoHenkoTsuchisho : ShiharaiHohoHenkoTsuchisho.values()) {
            if (shiharaiHohoHenkoTsuchisho.get名称().equals(fullname)) {
                return shiharaiHohoHenkoTsuchisho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支払方法変更通知書"));
    }
}
