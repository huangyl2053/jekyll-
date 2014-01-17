/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.Hihokensha;
import jp.co.ndensan.reams.db.dba.business.JushochitokureiKaijoJiyu;
import jp.co.ndensan.reams.db.dba.business.JushochitokureiTekiyoJiyu;
import jp.co.ndensan.reams.db.dba.business.SaikofuJiyu;
import jp.co.ndensan.reams.db.dba.business.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dba.business.HihokenshaKubun;
import jp.co.ndensan.reams.db.dba.business.HihokenshaList;
import jp.co.ndensan.reams.db.dba.definition.ShikakuIdoKubun;
import jp.co.ndensan.reams.db.dba.entity.T1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.business.ShichosonCode;
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
     * @return Hihokensya
     */
    public static Hihokensha toHihokensha(final T1001HihokenshaDaichoEntity entity) {
        IKaigoShikaku 介護保険資格 = toKaigoShikaku(entity);
        ShichosonCode 市町村コード = new ShichosonCode(entity.getShichosonCd());
        HihokenshaKubun 被保険者区分 = to被保険者区分(entity.getHihokenshaKubunCode());
        ShikakuHenkoJiyu 資格変更事由 = to資格変更事由(entity.getShikakuHenkoJiyuCode());
        JushochitokureiTekiyoJiyu 住所地特例適用事由 = to住所地特例適用事由(entity.getJushochiTokureiTekiyoJiyuCode());
        JushochitokureiKaijoJiyu 住所地特例解除事由 = to住所地特例解除事由(entity.getJushochiTokureikaijoJiyuCode());
        ShichosonCode 広域内住所地特例措置元_市町村コード = new ShichosonCode(entity.getKoikinaiTokureiSochimotoShichosonCd());
        SaikofuJiyu 再交付事由 = to再交付事由(entity.getSaikofuJiyuCode());

        Hihokensha 被保険者 = new Hihokensha(
                // 介護保険資格
                介護保険資格,
                // 市町村コード
                市町村コード,
                // 資格異動区分
                ShikakuIdoKubun.toValue(entity.getShikakuIdouKubunCode()),
                // 被保険者区分
                被保険者区分,
                // 資格変更事由
                資格変更事由,
                // 資格変更届出年月日
                entity.getShikakuHenkoTodokedeDate(),
                // 資格変更年月日
                entity.getShikakuHenkoDate(),
                // 住所地特例適用事由
                住所地特例適用事由,
                // 住所地特例適用届出年月日
                entity.getTekiyoTodokedeDate(),
                // 住所地特例適用年月日
                entity.getTekiyoDate(),
                // 住所地特例解除事由
                住所地特例解除事由,
                // 住所地特例解除届出年月日
                entity.getKaijoTodokedeDate(),
                // 住所地特例解除年月日
                entity.getKaijoDate(),
                // 住所地特例有無
                entity.isJushochiTokurei(),
                // 広域内_住所地特例有無
                entity.isKoikinaiJushochiTokurei(),
                // 広域内住所地特例措置元_市町村コード
                広域内住所地特例措置元_市町村コード,
                // 再交付有無
                entity.hasSaikofu(),
                // 再交付事由
                再交付事由);

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
