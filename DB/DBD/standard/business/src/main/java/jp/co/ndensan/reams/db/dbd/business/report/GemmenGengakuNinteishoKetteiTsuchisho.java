package jp.co.ndensan.reams.db.dbd.business.report;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 減免減額認定証決定通知書を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum GemmenGengakuNinteishoKetteiTsuchisho {

    /**
     * コード:なし 名称:利用者負担額減額_免除等認定証 略称:定義なし
     */
    利用者負担額減額_免除等認定証("利用者負担額減額_免除等認定証"),
    /**
     * コード:なし 名称:利用者負担額減額_免除決定通知書 略称:定義なし
     */
    利用者負担額減額_免除決定通知書("利用者負担額減額_免除決定通知書"),
    /**
     * コード:なし 名称:訪問介護利用者負担額減額認定証 略称:定義なし
     */
    訪問介護利用者負担額減額認定証("訪問介護利用者負担額減額認定証"),
    /**
     * コード:なし 名称:訪問介護等利用者負担額減額決定通知書 略称:定義なし
     */
    訪問介護等利用者負担額減額決定通知書("訪問介護等利用者負担額減額決定通知書"),
    /**
     * コード:なし 名称:負担限度額認定証 略称:定義なし
     */
    負担限度額認定証("負担限度額認定証"),
    /**
     * コード:なし 名称:負担限度額決定通知書 略称:定義なし
     */
    負担限度額決定通知書("負担限度額決定通知書"),
    /**
     * コード:なし 名称:社会福祉法人等利用者負担軽減対象確認証 略称:定義なし
     */
    社会福祉法人等利用者負担軽減対象確認証("社会福祉法人等利用者負担軽減対象確認証"),
    /**
     * コード:なし 名称:社会福祉法人等利用者負担軽減決定通知書 略称:定義なし
     */
    社会福祉法人等利用者負担軽減決定通知書("社会福祉法人等利用者負担軽減決定通知書"),
    /**
     * コード:なし 名称:特別地域加算に係る訪問介護利用者負担減額確認証 略称:定義なし
     */
    特別地域加算に係る訪問介護利用者負担減額確認証("特別地域加算に係る訪問介護利用者負担減額確認証"),
    /**
     * コード:なし 名称:特別地域加算減免・訪問介護利用者負担減額決定通知書 略称:定義なし
     */
    特別地域加算減免_訪問介護利用者負担減額決定通知書("特別地域加算減免・訪問介護利用者負担減額決定通知書");

    private final RString fullName;

    private GemmenGengakuNinteishoKetteiTsuchisho(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * 減免減額認定証決定通知書の名称を返します。
     *
     * @return 減免減額認定証決定通知書の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 減免減額認定証決定通知書の名称と一致する内容を探します。
     *
     * @param fullname 減免減額認定証決定通知書の名称
     * @return {@code fullname} に対応する減免減額認定証決定通知書
     */
    public static GemmenGengakuNinteishoKetteiTsuchisho toValue(RString fullname) {
        for (GemmenGengakuNinteishoKetteiTsuchisho value : GemmenGengakuNinteishoKetteiTsuchisho.values()) {
            if (value.get名称().equals(fullname)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("減免減額認定証決定通知書"));
    }
}
