/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.helper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbe.definition.IryoKikanKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7011ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.ur.urz.business.IKoza;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.IryoKikanCode;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.IryoKikanIdoJiyu;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaiinKubun;
import jp.co.ndensan.reams.ur.urz.entity.basic.UrT0516IryokikanEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.*;

/**
 * 主治医医療機関関連のテストの補助クラスです。
 *
 * @author n8178 城間篤人
 */
public final class KaigoIryoKikanTestHelper {

    public static RString 医療機関名称 = new RString("介護病院");
    public static RString 医療機関カナ名称 = new RString("カイゴビョウイン");
    public static RString 医療機関略称 = new RString("介護病院");
    public static RString 医療機関カナ略称 = new RString("カイゴビョウイン");
    public static RString 郵便番号 = new RString("903-1111");
    public static RString 住所 = new RString("A町B1-12-123");
    public static RString カナ住所 = new RString("エーマチ");
    public static RString 会員区分 = new RString("会員");
    public static RString 医師区分 = new RString("医師");
    public static boolean 指定自立支援医療機関flag = true;
    public static boolean 休止flag = true;
    public static RDate 新設年月日 = new RDate("19991212");
    public static RDate 廃止年月日 = new RDate("20091212");
    public static RString 休止区分 = new RString("休止");
    public static RString 異動事由 = new RString("疲れのため");
    public static RDate 異動年月日 = new RDate("20051212");
    public static LasdecCode 市町村コード_000123 = new LasdecCode(new RString("000123"));
    public static KaigoIryoKikanCode 介護医療機関コード = new KaigoIryoKikanCode(new RString("B001"));
    public static IryoKikanCode 医療機関コード = new IryoKikanCode(new RString("C00000001"));
    public static IryoKikanJokyo 医療機関状況 = IryoKikanJokyo.有効;
    public static IryoKikanKubun 医療機関区分 = new IryoKikanKubun(new RString("100"), new RString("名称"), new RString("略称"));

    private KaigoIryoKikanTestHelper() {
    }

    public static UrT0516IryokikanEntity create医療機関Entity() {
        //TODO n1013 松本直樹 UrT0516IryokikanEntityにIIryoKikanの修正に伴う見直し。暫定対応
        //UrT0516IryokikanEntity entity = new UrT0516IryokikanEntity(createIryoKikan());
        UrT0516IryokikanEntity entity = new UrT0516IryokikanEntity();
        entity.setIryokikanCode(医療機関コード);
        entity.setIryokikanRyakusho(医療機関略称);
        entity.setIryokikanKanaRyakusho(医療機関カナ略称);
//        entity.setYubinNo(郵便番号);
//        entity.setJusho(住所);
//        entity.setKanaJusho(カナ住所);
        KaiinKubun kaiinKubun = mock(KaiinKubun.class);
        when(kaiinKubun.value()).thenReturn(new Code(会員区分));
        entity.setKaiinKubunCode(kaiinKubun);
        entity.setJiritsushienFlag(指定自立支援医療機関flag);
        entity.setShinsetsuYMD(new FlexibleDate(新設年月日.toDateString()));
        entity.setHaishiYMD(new FlexibleDate(廃止年月日.toDateString()));
        entity.setKyushiFlag(休止flag);
        IryoKikanIdoJiyu idoJiyu = mock(IryoKikanIdoJiyu.class);
        when(idoJiyu.value()).thenReturn(new Code(異動事由));
        entity.setIdoJiyuCode(idoJiyu);
        entity.setIdoYMD(new FlexibleDate(異動年月日.toDateString()));
        return entity;
    }

    public static DbT7011ShujiiIryoKikanJohoEntity create主治医医療機関Entity() {
        DbT7011ShujiiIryoKikanJohoEntity entity = new DbT7011ShujiiIryoKikanJohoEntity();
        entity.setShichosonCode(市町村コード_000123);
        entity.setKaigoIryokikanCode(介護医療機関コード);
        entity.setIryokikanCode(医療機関コード.value());
        entity.setIryokikanJokyo(医療機関状況.is有効());
        entity.setKikanKubunCode(医療機関区分.getCode());
        return entity;
    }

    public static List<IKoza> create口座List(int 口座件数) {
        List<IKoza> kozaList = new ArrayList<>();
        for (int i = 0; i < 口座件数; i++) {
            kozaList.add(mock(IKoza.class));
        }
        return kozaList;
    }
}
