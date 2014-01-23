/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.mapper;

import java.util.List;
import java.util.ArrayList;
import jp.co.ndensan.reams.db.dba.business.Hihokensha;
import jp.co.ndensan.reams.db.dba.business.HihokenshaList;
import jp.co.ndensan.reams.db.dba.definition.valueobject.JushochitokureiKaijoJiyu;
import jp.co.ndensan.reams.db.dba.definition.valueobject.JushochitokureiTekiyoJiyu;
import jp.co.ndensan.reams.db.dba.definition.valueobject.SaikofuJiyu;
import jp.co.ndensan.reams.db.dba.definition.valueobject.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dba.definition.valueobject.HihokenshaKubun;
import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.ShikakuIdoKubun;
import jp.co.ndensan.reams.db.dba.entity.basic.T1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urf.business.HokenShubetsu;
import jp.co.ndensan.reams.ur.urf.business.IKaigoShikaku;
import jp.co.ndensan.reams.ur.urz.business.KaigoShikakuFactory;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * T1001HihokenshaDaichoEntityをHihokenshaへ変換するクラスです。
 *
 * @author N3327 三浦 凌
 */
public final class HihokenshaMapper {

    private HihokenshaMapper() {
    }

    /**
     * T1001HihokenshaDaichoEntityをHihokensyaへ変換します。
     *
     * @param entity T1001HihokenshaDaichoEntity
     * @return T1001HihokenshaDaichoEntityと同じ値をもったHihokensya
     */
    public static Hihokensha toHihokensha(final T1001HihokenshaDaichoEntity entity) {
        IKaigoShikaku 介護保険資格 = toKaigoShikaku(entity);
        ShichosonCode 市町村コード = new ShichosonCode(entity.getShichosonCd());
        HihokenshaKubun 被保険者区分 = to被保険者区分(entity.getHihokenshaKubunCode());
        ShikakuHenkoJiyu 資格変更事由 = to資格変更事由(entity.getShikakuHenkoJiyuCode());
        JushochitokureiTekiyoJiyu 住所地特例適用事由 = to住所地特例適用事由(entity.getJushochitokureiTekiyoJiyuCode());
        JushochitokureiKaijoJiyu 住所地特例解除事由 = to住所地特例解除事由(entity.getJushochitokureiKaijoJiyuCode());
        ShichosonCode 広域内住所地特例措置元_市町村コード = new ShichosonCode(entity.getKoikinaiTokureiSochimotoShichosonCd());
        SaikofuJiyu 再交付事由 = to再交付事由(entity.getSaikofuJiyuCode());

        Hihokensha 被保険者 = new Hihokensha(
                介護保険資格, 市町村コード, ShikakuIdoKubun.toValue(entity.getShikakuIdouKubunCode()), 被保険者区分,
                資格変更事由, entity.getShikakuHenkoTodokedeDate(), entity.getShikakuHenkoDate(),
                住所地特例適用事由, entity.getJushochitokureiTekiyoTodokedeDate(), entity.getJushochitokureiTekiyoDate(),
                住所地特例解除事由, entity.getJushochitokureiKaijoTodokedeDate(), entity.getJushochitokureiKaijoDate(),
                entity.isJushochitokureisha(), entity.isKoikinaiJushochitokureisha(), 広域内住所地特例措置元_市町村コード,
                entity.hasSaikofu(), 再交付事由);

        return 被保険者;
    }

    /**
     * T1001HihokenshaDaichoEntityのリストをHihokenshaListへ変換します。
     *
     * @param entities T1001HihokenshaDaichoEntityのリスト
     * @return HihokenshaList
     */
    public static HihokenshaList toHihokenshaList(final List<T1001HihokenshaDaichoEntity> entities) {
        List<Hihokensha> 被保険者リスト = new ArrayList<>();
        for (T1001HihokenshaDaichoEntity entity : entities) {
            被保険者リスト.add(toHihokensha(entity));
        }
        return new HihokenshaList(被保険者リスト);
    }

    private static IKaigoShikaku toKaigoShikaku(final T1001HihokenshaDaichoEntity entity) {
        IShikibetsuCode 識別コード = entity.getShikibetsuCode();
        IKaigoShikaku 介護保険資格 = KaigoShikakuFactory.createInstance(
                識別コード, HokenShubetsu.介護保険,
                entity.getShikakuShutokuTodokedeDate(), entity.getShikakuShutokuDate(), entity.getShikakuShutokuJiyuCode(),
                entity.getShikakuSoshitsuTodokedeDate(), entity.getShikakuSoshitsuDate(), entity.getShikakuSoshitsuJiyuCode(),
                entity.getHihokenshaNo(), entity.getShichosonCd(), entity.getIchigoHihokenshaNenreiTotatsuDate());
        return 介護保険資格;
    }

//TODO N3327 三浦 凌 コードマスタからコードを取得できるならば、以下のコードを修正・削除する。
    private static HihokenshaKubun to被保険者区分(final RString code) {
        return new HihokenshaKubun(code, new RString("仮"));
    }

    private static ShikakuHenkoJiyu to資格変更事由(final RString code) {
        return new ShikakuHenkoJiyu(code, new RString("仮"));
    }

    private static JushochitokureiTekiyoJiyu to住所地特例適用事由(final RString code) {
        return new JushochitokureiTekiyoJiyu(code, new RString("仮"));
    }

    private static JushochitokureiKaijoJiyu to住所地特例解除事由(final RString code) {
        return new JushochitokureiKaijoJiyu(code, new RString("仮"));
    }

    private static SaikofuJiyu to再交付事由(final RString code) {
        return new SaikofuJiyu(code, new RString("仮"));
    }
}
