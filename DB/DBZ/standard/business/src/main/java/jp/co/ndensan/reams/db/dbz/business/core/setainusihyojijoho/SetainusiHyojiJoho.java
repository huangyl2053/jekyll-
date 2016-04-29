package jp.co.ndensan.reams.db.dbz.business.core.setainusihyojijoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯主名を格納するクラスです。
 *
 * @reamsid_L DBB-9040-130 wangxiaodong
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SetainusiHyojiJoho {

    private final RString 世帯主名;

    /**
     * インスタンスを生成します。
     *
     * @param 世帯主名 世帯主名
     */
    public SetainusiHyojiJoho(RString 世帯主名) {
        this.世帯主名 = 世帯主名;
    }

}
