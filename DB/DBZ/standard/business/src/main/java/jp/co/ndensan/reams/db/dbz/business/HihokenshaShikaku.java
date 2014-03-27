/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.KoikinaiJushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuIdoKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.IKaigoShikaku;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険被保険者の資格(異動)を扱います。
 *
 * @author N3327 三浦 凌
 */
public class HihokenshaShikaku implements IHihokenshaShikaku {

    private final IKaigoShikaku kaigoShikaku;
    private final LasdecCode lasdecCode;
    private final ShikibetsuCode shikibetsuCode;
    private final KaigoHihokenshaNo hihokenshaNo;
    private final ShikakuIdoKubun shikakuIdoKubun;
    private final ShikakuHihokenshaKubun hihokenshaKubun;
    private final ShikakuHenko shikakuHenko;
    private final JushochitokureiTekiyo jutokuTekiyo;
    private final JushochitokureiKaijo jutokuKaijo;
    private final JushochiTokureishaKubun jutokushaKubun;
    private final KoikinaiJushochitokureishaKubun koikinaiJutokushaKubun;
    private final LasdecCode koikiJutokuOriginLasdecCode;
    private final LasdecCode oldLasdecCode;
    private final HihokenshashoSaikofu saikofu;

    /**
     * 新しい被保険者の資格(異動)を作成します。
     *
     * @param 介護資格得喪 介護資格の取得・喪失をもった{@link IKaigoShikaku IKaigoShikaku}
     * @param 地方公共団体コード {@link LasdecCode 地方公共団体コード}
     * @param 識別コード {@link ShikibetsuCode 識別コード}
     * @param 被保険者番号 {@link KaigoHihokenshaNo 被保険者番号}
     * @param 資格異動区分 {@link ShikakuIdoKubun 資格異動区分}
     * @param 被保険者区分 {@link ShikakuHihokenshaKubun 被保険者区分}
     * @param 資格変更 {@link ShikakuHenko 資格変更}
     * @param 住所地特例適用 {@link JushochitokureiTekiyo 住所地特例適用}
     * @param 住所地特例解除 {@link JushochitokureiKaijo 住所地特例解除}
     * @param 住所地特例者区分 {@link JushochiTokureishaKubun 住所地特例者区分}
     * @param 広域内住所地特例者区分 {@link KoikinaiJushochitokureishaKubun 広域内住所地特例者区分}
     * @param 広域内住所地特例措置元 広域内住所地特例措置元の{@link LasdecCode 地方公共団体コード}
     * @param 旧市町村 合併前の{@link LasdecCode 地方公共団体コード}
     * @param 被保険者証再交付 {@link HihokenshashoSaikofu 被保険者証再交付}
     * @throws NullPointerException IKaigoShikaku, ShikakuHenko,
     * JushochitokureiTekiyo, JushochitokureiKaijo, HihokenshashoSaikofu
     * のどれかがnullのとき。
     */
    public HihokenshaShikaku(IKaigoShikaku 介護資格得喪,
            LasdecCode 地方公共団体コード, ShikibetsuCode 識別コード, KaigoHihokenshaNo 被保険者番号,
            ShikakuIdoKubun 資格異動区分, ShikakuHihokenshaKubun 被保険者区分,
            ShikakuHenko 資格変更, JushochitokureiTekiyo 住所地特例適用, JushochitokureiKaijo 住所地特例解除,
            JushochiTokureishaKubun 住所地特例者区分, KoikinaiJushochitokureishaKubun 広域内住所地特例者区分, LasdecCode 広域内住所地特例措置元,
            LasdecCode 旧市町村, HihokenshashoSaikofu 被保険者証再交付) throws NullPointerException {

        this.kaigoShikaku = requireNonNull(介護資格得喪, errorMessageFor(IKaigoShikaku.class));
        this.lasdecCode = 地方公共団体コード;
        this.shikibetsuCode = 識別コード;
        this.hihokenshaNo = 被保険者番号;
        this.shikakuIdoKubun = 資格異動区分;
        this.hihokenshaKubun = 被保険者区分;
        this.shikakuHenko = requireNonNull(資格変更, errorMessageFor(ShikakuHenko.class));
        this.jutokuTekiyo = requireNonNull(住所地特例適用, errorMessageFor(JushochitokureiTekiyo.class));
        this.jutokuKaijo = requireNonNull(住所地特例解除, errorMessageFor(JushochitokureiKaijo.class));
        this.jutokushaKubun = 住所地特例者区分;
        this.koikinaiJutokushaKubun = 広域内住所地特例者区分;
        this.koikiJutokuOriginLasdecCode = 広域内住所地特例措置元;
        this.oldLasdecCode = 旧市町村;
        this.saikofu = requireNonNull(被保険者証再交付, errorMessageFor(HihokenshashoSaikofu.class));
    }

    @Override
    public LasdecCode get地方公共団体コード() {
        return this.lasdecCode;
    }

    @Override
    public ShikibetsuCode get識別コード() {
        return this.shikibetsuCode;
    }

    @Override
    public KaigoHihokenshaNo get被保険者番号() {
        return this.hihokenshaNo;
    }

    @Override
    public ShikakuIdoKubun get資格異動区分() {
        return this.shikakuIdoKubun;
    }

    @Override
    public ShikakuShutoku get資格取得() {
        ShikakuShutokuJiyu cause = to資格取得事由(this.kaigoShikaku.get資格取得事由().getCode());
        FlexibleDate noticeDate = toFlexibleDate(this.kaigoShikaku.get資格取得届出年月日());
        FlexibleDate actionDate = toFlexibleDate(this.kaigoShikaku.get資格取得年月日());
        return new ShikakuShutoku(cause, noticeDate, actionDate);
    }

    private ShikakuShutokuJiyu to資格取得事由(RString code) {
        return ShikakuShutokuJiyu.toValue(code);
    }

    @Override
    public FlexibleDate get第一号年齢到達日() {
        return toFlexibleDate(this.kaigoShikaku.get一号該当日());
    }

    @Override
    public ShikakuHihokenshaKubun get被保険者区分() {
        return this.hihokenshaKubun;
    }

    @Override
    public boolean has被保険者資格At(RDate baseDate) {
        return this.kaigoShikaku.is資格あり(baseDate);
    }

    @Override
    public ShikakuSoshitsu get資格喪失() {
        ShikakuSoshitsuJiyu cause = to資格喪失事由(this.kaigoShikaku.get資格喪失事由().getCode());
        FlexibleDate noticeDate = toFlexibleDate(this.kaigoShikaku.get資格喪失届出年月日());
        FlexibleDate actionDate = toFlexibleDate(this.kaigoShikaku.get資格喪失年月日());
        return new ShikakuSoshitsu(cause, noticeDate, actionDate);
    }

    private ShikakuSoshitsuJiyu to資格喪失事由(RString code) {
        return ShikakuSoshitsuJiyu.toValue(code);
    }

    @Override
    public ShikakuHenko get資格変更() {
        return this.shikakuHenko;
    }

    @Override
    public JushochitokureiTekiyo get住所地特例適用() {
        return this.jutokuTekiyo;
    }

    @Override
    public JushochitokureiKaijo get住所地特例解除() {
        return this.jutokuKaijo;
    }

    @Override
    public JushochiTokureishaKubun get住所地特例者区分() {
        return this.jutokushaKubun;
    }

    @Override
    public KoikinaiJushochitokureishaKubun get広域内住所地特例者区分() {
        return this.koikinaiJutokushaKubun;
    }

    @Override
    public LasdecCode get広域内住所地特例措置元市町村コード() {
        return this.koikiJutokuOriginLasdecCode;
    }

    @Override
    public LasdecCode get旧市町村コード() {
        return this.oldLasdecCode;
    }

    @Override
    public HihokenshashoSaikofu get被保険者証再交付() {
        return this.saikofu;
    }

    @Override
    public IKaigoShikaku toKaigoShikaku() {
        return this.kaigoShikaku;
    }

    /**
     * RDateをFlexibleDateへ変換します。
     *
     * @param date RDate
     * @return RDateから変換した、FlexibleDate
     */
    private FlexibleDate toFlexibleDate(RDate date) {
        return new FlexibleDate(date.toString());
    }

    private String errorMessageFor(Class clazz) {
        return Messages.E00003.replace("引数の" + clazz.getSimpleName(), getClass().getSimpleName()).getMessage();
    }
}
