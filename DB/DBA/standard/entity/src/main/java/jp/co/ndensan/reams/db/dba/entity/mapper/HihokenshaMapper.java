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
import jp.co.ndensan.reams.db.dba.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.HokenShubetsu;
import jp.co.ndensan.reams.ur.urz.business.IKaigoShikaku;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.ur.urz.business.IShikakuShutokuJiyu;
import jp.co.ndensan.reams.ur.urz.business.IShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.ur.urz.business.KaigoShikakuFactory;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
    public static Hihokensha toHihokensha(final DbT1001HihokenshaDaichoEntity entity) {
        if (entity == null) {
            return null;
        }

        ShichosonCode 市町村コード = new ShichosonCode(entity.getShichosonCd());
        HihokenshaKubun 被保険者区分 = to被保険者区分(entity.getHihokenshaKubunCode());
        ShikakuHenkoJiyu 資格変更事由 = to資格変更事由(entity.getShikakuHenkoJiyuCode());
        JushochitokureiTekiyoJiyu 住所地特例適用事由 = to住所地特例適用事由(entity.getJushochitokureiTekiyoJiyuCode());
        JushochitokureiKaijoJiyu 住所地特例解除事由 = to住所地特例解除事由(entity.getJushochitokureiKaijoJiyuCode());
        ShichosonCode 広域内住所地特例措置元_市町村コード = new ShichosonCode(entity.getKoikinaiTokureiSochimotoShichosonCd());
        SaikofuJiyu 再交付事由 = to再交付事由(entity.getSaikofuJiyuCode());
        IKaigoShikaku 介護保険資格 = toKaigoShikaku(entity);

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
    public static HihokenshaList toHihokenshaList(final List<DbT1001HihokenshaDaichoEntity> entities) {
        List<Hihokensha> 被保険者リスト = new ArrayList<>();
        for (DbT1001HihokenshaDaichoEntity entity : entities) {
            被保険者リスト.add(toHihokensha(entity));
        }
        return new HihokenshaList(被保険者リスト);
    }

    private static IKaigoShikaku toKaigoShikaku(final DbT1001HihokenshaDaichoEntity entity) {
        //TODO n3327 三浦凌 資格被保険者区分、住所地特例者区分　の設定について見直しを行う　　　　2014/03/14
        ShikakuHihokenshaKubun 資格被保険者区分 = toShiakuHihokenshaKubun(to被保険者区分(entity.getHihokenshaKubunCode()));
        JushochiTokureishaKubun 住所地特例者区分 = toJushochiTokureishaKubun(entity.isJushochitokureisha());

        ShikibetsuCode 識別コード = entity.getShikibetsuCode();
        IKaigoShikaku 介護保険資格 = KaigoShikakuFactory.createInstance(
                識別コード, HokenShubetsu.介護保険,
                entity.getShikakuShutokuTodokedeDate(), entity.getShikakuShutokuDate(),
                to資格取得事由(entity.getShikakuShutokuJiyuCode()),
                entity.getShikakuSoshitsuTodokedeDate(), entity.getShikakuSoshitsuDate(),
                to資格喪失事由(entity.getShikakuSoshitsuJiyuCode()),
                entity.getHihokenshaNo(), entity.getShichosonCd(), entity.getIchigoHihokenshaNenreiTotatsuDate(),
                資格被保険者区分, 住所地特例者区分);
        return 介護保険資格;
    }

    //TODO n3327 三浦 凌 ShikakuHihokenshaKubunとHihokenshaKubunの変換が複数箇所であるので、リファクタリングする。現状は仮実装。
    private static ShikakuHihokenshaKubun toShiakuHihokenshaKubun(final HihokenshaKubun 被保険者区分) {
        return ShikakuHihokenshaKubun.第１号被保険者;
    }

    private static JushochiTokureishaKubun toJushochiTokureishaKubun(boolean is住所地特例) {
        return is住所地特例 ? JushochiTokureishaKubun.住所地特例者 : JushochiTokureishaKubun.通常資格者;
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

    //TODO n3327 三浦凌 ShikakuShutokuJiyuの修正が完了したら、返り値等を修正する。
    private static IShikakuShutokuJiyu to資格取得事由(final RString code) {
        return new IShikakuShutokuJiyu() {
            @Override
            public RString getCode() {
                return code;
            }

            @Override
            public RString getName() {
                return new RString("資格取得事由");
            }

            @Override
            public RString getShortName() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }

    //TODO n3327 三浦凌 ShikakuSoshitsuJiyuの修正が完了したら、返り値等を修正する。
    private static IShikakuSoshitsuJiyu to資格喪失事由(final RString code) {
        return new IShikakuSoshitsuJiyu() {
            @Override
            public RString getCode() {
                return code;
            }

            @Override
            public RString getName() {
                return new RString("資格取得事由");
            }

            @Override
            public RString getShortName() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
}
