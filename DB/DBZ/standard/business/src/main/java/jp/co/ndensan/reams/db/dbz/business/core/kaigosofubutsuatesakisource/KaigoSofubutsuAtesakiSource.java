package jp.co.ndensan.reams.db.dbz.business.core.kaigosofubutsuatesakisource;

import jp.co.ndensan.reams.db.dbz.business.core.setainusihyojijoho.SetainusiHyojiJoho;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;

/**
 * 介護用送付物宛先ソースを格納するクラスです。
 *
 * @reamsid_L DBB-9040-130 wangxiaodong
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoSofubutsuAtesakiSource {

    private final SofubutsuAtesakiSource 送付物宛先ソース;
    private final SetainusiHyojiJoho 世帯主表示用情報;

    /**
     * インスタンスを生成します。
     *
     * @param 送付物宛先ソース
     * @param 世帯主表示用情報
     */
    public KaigoSofubutsuAtesakiSource(SofubutsuAtesakiSource 送付物宛先ソース, SetainusiHyojiJoho 世帯主表示用情報) {
        this.送付物宛先ソース = 送付物宛先ソース;
        this.世帯主表示用情報 = 世帯主表示用情報;
    }
}
