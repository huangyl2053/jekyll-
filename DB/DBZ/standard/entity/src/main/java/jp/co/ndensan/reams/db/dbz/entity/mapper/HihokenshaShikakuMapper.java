/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.mapper;

import jp.co.ndensan.reams.db.dbz.business.HihokenshaShikaku;
import jp.co.ndensan.reams.db.dbz.business.HihokenshashoSaikofu;
import jp.co.ndensan.reams.db.dbz.business.IHihokenshaShikaku;
import jp.co.ndensan.reams.db.dbz.business.JushochitokureiKaijo;
import jp.co.ndensan.reams.db.dbz.business.JushochitokureiTekiyo;
import jp.co.ndensan.reams.db.dbz.business.ShikakuHenko;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureiKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureiTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.KoikinaiJushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuIdoKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChohyoKofuRirekiID;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.business.IKaigoShikaku;
import jp.co.ndensan.reams.ur.urz.business.IShikakuShutokuJiyu;
import jp.co.ndensan.reams.ur.urz.business.IShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.ur.urz.business.KaigoShikakuFactory;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * HihokenshaShikakuとDbT1001HihokenshaDaichoEntityの変換をします。
 *
 * @author N3327 三浦 凌
 */
public final class HihokenshaShikakuMapper {

    private HihokenshaShikakuMapper() {
    }

    /**
     * {@link IHihokenshaShikaku IHihokenshaShikaku}を
     * {@link DbT1001HihokenshaDaichoEntity DbT1001HihokenshaDaichoEntity}へ変換します。
     *
     * @param shikaku {@link IHihokenshaShikaku IHihokenshaShikaku}
     * @return
     * {@link DbT1001HihokenshaDaichoEntity DbT1001HihokenshaDaichoEntity}
     */
    public static DbT1001HihokenshaDaichoEntity toHihokenshaDaichoEntity(IHihokenshaShikaku shikaku) {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setShichosonCode(shikaku.get地方公共団体コード());
        entity.setHihokenshaNo(shikaku.get被保険者番号());
        entity.setShikibetsuCode(shikaku.get識別コード());
        entity.setHihokennshaKubunCode(shikaku.get被保険者区分().getコード());
        entity.setIchigoHihokenshaNenreiTotatsuYMD(shikaku.get第一号年齢到達日());
        entity.setShikakuIdouKubunCode(shikaku.get資格異動区分().getCode());
        entity.setShikakuShutokuJiyuCode(shikaku.get資格取得().getReason().getCode());
        entity.setShikakuShutokuTodokedeYMD(shikaku.get資格取得().getNoticeDate());
        entity.setShikakuShutokuYMD(shikaku.get資格取得().getActionDate());
        entity.setShikakuSoshitsuJiyuCode(shikaku.get資格喪失().getReason().getCode());
        entity.setShikakuSoshitsuTodokedeYMD(shikaku.get資格喪失().getNoticeDate());
        entity.setShikakuSoshitsuYMD(shikaku.get資格喪失().getActionDate());
        entity.setShikakuHenkoJiyuCode(shikaku.get資格変更().getReason().getCode());
        entity.setShikakuHenkoTodokedeYMD(shikaku.get資格変更().getActionDate());
        entity.setShikakuHenkoYMD(shikaku.get資格変更().getNoticeDate());
        entity.setJushochitokureiTekiyoJiyuCode(shikaku.get住所地特例適用().getReason().getCode());
        entity.setJushochitokureiTekiyoTodokedeYMD(shikaku.get住所地特例適用().getNoticeDate());
        entity.setJushochitokureiTekiyoYMD(shikaku.get住所地特例適用().getActionDate());
        entity.setJushochitokureiKaijoJiyuCode(shikaku.get住所地特例解除().getReason().getCode());
        entity.setJushochitokureiKaijoTodokedeYMD(shikaku.get住所地特例解除().getNoticeDate());
        entity.setJushochitokureiKaijoYMD(shikaku.get住所地特例解除().getActionDate());
        entity.setJushochiTokureiFlag(shikaku.get住所地特例者区分().getコード());
        entity.setKoikinaiJushochiTokureiFlag(shikaku.get広域内住所地特例者区分().getCode());
        entity.setKoikinaiTokureiSochimotoShichosonCode(shikaku.get広域内住所地特例措置元市町村コード());
        entity.setKyuShichosonCode(shikaku.get旧市町村コード());
        entity.setSaikofuKubun(shikaku.get被保険者証再交付().get有無区分().getCode());
        entity.setSaikofuJiyuCode(shikaku.get被保険者証再交付().getReason().getCode());
        entity.setChohyoKofuRirekiID(toValue(shikaku.get被保険者証再交付().getChohyoKofuRirekiID()));

        return entity;
    }

    /**
     * {@link DbT1001HihokenshaDaichoEntity DbT1001HihokenshaDaichoEntity}を
     * {@link IHihokenshaShikaku IHihokenshaShikaku}へ変換します。
     *
     * @param entity
     * {@link DbT1001HihokenshaDaichoEntity DbT1001HihokenshaDaichoEntity}
     * @return {@link IHihokenshaShikaku IHihokenshaShikaku}
     */
    public static IHihokenshaShikaku toHihokenshaShikaku(DbT1001HihokenshaDaichoEntity entity) {
        IKaigoShikaku kaigoShikaku = toKaigoShikaku(entity);
        ShikakuHenko 資格変更 = toShikakuHenko(
                entity.getShikakuHenkoJiyuCode(),
                entity.getShikakuHenkoTodokedeYMD(),
                entity.getShikakuHenkoYMD());
        JushochitokureiTekiyo 住所地特例適用 = toJushochitokureiTekiyo(
                entity.getJushochitokureiTekiyoJiyuCode(),
                entity.getJushochitokureiTekiyoTodokedeYMD(),
                entity.getJushochitokureiTekiyoYMD());
        JushochitokureiKaijo 住所地特例解除 = toJushochitokureiKaijo(
                entity.getJushochitokureiKaijoJiyuCode(),
                entity.getJushochitokureiKaijoTodokedeYMD(),
                entity.getJushochitokureiKaijoYMD());
        HihokenshashoSaikofu 被保険者証再交付 = toHihokenshashoSaikofu(
                entity.getHihokennshaKubunCode(),
                entity.getSaikofuJiyuCode(),
                entity.getChohyoKofuRirekiID());

        HihokenshaShikaku shikaku = new HihokenshaShikaku(
                kaigoShikaku,
                entity.getShichosonCode(),
                entity.getShikibetsuCode(),
                entity.getHihokenshaNo(),
                ShikakuIdoKubun.toValue(entity.getShikakuIdouKubunCode()),
                ShikakuHihokenshaKubun.toValue(entity.getHihokennshaKubunCode()),
                資格変更, 住所地特例適用, 住所地特例解除,
                JushochiTokureishaKubun.toValue(entity.getJushochiTokureiFlag()),
                KoikinaiJushochitokureishaKubun.toValue(entity.getKoikinaiJushochiTokureiFlag()),
                entity.getKoikinaiTokureiSochimotoShichosonCode(),
                entity.getKyuShichosonCode(),
                被保険者証再交付);

        return shikaku;
    }

    private static IKaigoShikaku toKaigoShikaku(DbT1001HihokenshaDaichoEntity entity) {
        IKaigoShikaku kaigoShikaku = KaigoShikakuFactory.createInstance(
                entity.getShikibetsuCode(),
                jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.HokenShubetsu.介護保険,
                toRDateOrMin(entity.getShikakuShutokuTodokedeYMD()),
                toRDateOrMin(entity.getShikakuShutokuYMD()),
                toShikakuShutokuJiyu(entity.getShikakuShutokuJiyuCode()),
                toRDateOrMax(entity.getShikakuSoshitsuTodokedeYMD()),
                toRDateOrMax(entity.getShikakuSoshitsuYMD()),
                toShikakuSoshitsuJiyu(entity.getShikakuSoshitsuJiyuCode()),
                toValue(entity.getHihokenshaNo()),
                toValue(entity.getShichosonCode()),
                toRDateOrMax(entity.getIchigoHihokenshaNenreiTotatsuYMD()),
                ShikakuHihokenshaKubun.toValue(entity.getHihokennshaKubunCode()),
                JushochiTokureishaKubun.toValue(entity.getJushochiTokureiFlag()));

        return kaigoShikaku;
    }

    private static RDate toRDateOrMin(FlexibleDate date) {
        if (date.isValid()) {
            return new RDate(date.toString());
        }
        return RDate.MIN;
    }

    private static RDate toRDateOrMax(FlexibleDate date) {
        if (date.isValid()) {
            return new RDate(date.toString());
        }
        return RDate.MAX;
    }

    private static <T> T toValue(IValueObject<T> source) {
        return isNull(source) ? null : source.value();
    }

    private static IShikakuShutokuJiyu toShikakuShutokuJiyu(RString code) {
        final ShikakuShutokuJiyu reason = ShikakuShutokuJiyu.toValue(code);
        return new IShikakuShutokuJiyu() {
            @Override
            public RString getCode() {
                return reason.getCode();
            }

            @Override
            public RString getName() {
                return reason.getName();
            }

            @Override
            public RString getShortName() {
                return reason.getShortName();
            }
        };
    }

    private static IShikakuSoshitsuJiyu toShikakuSoshitsuJiyu(RString code) {
        final ShikakuSoshitsuJiyu reason = ShikakuSoshitsuJiyu.toValue(code);
        return new IShikakuSoshitsuJiyu() {
            @Override
            public RString getCode() {
                return reason.getCode();
            }

            @Override
            public RString getName() {
                return reason.getName();
            }

            @Override
            public RString getShortName() {
                return reason.getShortName();
            }
        };
    }

    private static ShikakuHenko toShikakuHenko(RString code, FlexibleDate noticeDate, FlexibleDate actionDate) {
        return new ShikakuHenko(ShikakuHenkoJiyu.toValue(code), noticeDate, actionDate);
    }

    private static JushochitokureiTekiyo toJushochitokureiTekiyo(RString code, FlexibleDate noticeDate, FlexibleDate actionDate) {
        return new JushochitokureiTekiyo(JushochitokureiTekiyoJiyu.toValue(code), noticeDate, actionDate);
    }

    private static JushochitokureiKaijo toJushochitokureiKaijo(RString code, FlexibleDate noticeDate, FlexibleDate actionDate) {
        return new JushochitokureiKaijo(JushochitokureiKaijoJiyu.toValue(code), noticeDate, actionDate);
    }

    private static HihokenshashoSaikofu toHihokenshashoSaikofu(RString kubunCode, RString reasonCode, RString chohyoID) {
        return new HihokenshashoSaikofu(
                HihokenshashoSaikofuKubun.toValue(kubunCode),
                HihokenshashoSaikofuJiyu.toValue(reasonCode),
                isNull(chohyoID) ? null : new ChohyoKofuRirekiID(chohyoID));
    }

    private static boolean isNull(Object target) {
        return target == null;
    }
}
