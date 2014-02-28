/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.testhelper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbe.definition.IryoKikanKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7011ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business.IDoctors;
import jp.co.ndensan.reams.ur.urz.business.IIryoKikan;
import jp.co.ndensan.reams.ur.urz.business.IIryoKikanCode;
import jp.co.ndensan.reams.ur.urz.business.IKoza;
import jp.co.ndensan.reams.ur.urz.business._IryoKikanCode;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuCode;
import jp.co.ndensan.reams.ur.urz.entity.basic.UrT0516IryokikanEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static org.mockito.Mockito.*;

/**
 * 主治医医療機関関連のテストの補助クラスです。
 *
 * @author n8178 城間篤人
 */
public final class KaigoIryoKikanTestHelper {

    public static RString 識別コード = new RString("S02B00001");
    public static RString 医療機関名称 = new RString("介護病院");
    public static RString 医療機関カナ名称 = new RString("カイゴビョウイン");
    public static RString 医療機関略称 = new RString("介護病院");
    public static RString 医療機関カナ略称 = new RString("カイゴビョウイン");
    public static RString 郵便番号 = new RString("903-1111");
    public static RString 住所 = new RString("A町B1-12-123");
    public static RString カナ住所 = new RString("エーマチ");
    public static RString 会員区分 = new RString("会員");
    public static boolean 指定自立支援医療機関flag = true;
    public static RDate 新設年月日 = new RDate("19991212");
    public static RDate 廃止年月日 = new RDate("20091212");
    public static RString 休止区分 = new RString("休止");
    public static RString 異動事由 = new RString("疲れのため");
    public static RDate 異動年月日 = new RDate("20051212");
    public static ShichosonCode 市町村コード_A001 = new ShichosonCode(new RString("A001"));
    public static KaigoIryoKikanCode 介護医療機関コード = new KaigoIryoKikanCode(new RString("B001"));
    public static IIryoKikanCode 医療機関コード = new _IryoKikanCode(new RString("C00000001"));
    public static IryoKikanJokyo 医療機関状況 = IryoKikanJokyo.有効;
    public static IryoKikanKubun 医療機関区分 = new IryoKikanKubun(new RString("ABC"), new RString("名称"), new RString("略称"));

    private KaigoIryoKikanTestHelper() {
    }

    public static UrT0516IryokikanEntity create医療機関Entity() {
        UrT0516IryokikanEntity entity = new UrT0516IryokikanEntity(createIryoKikan());

        entity.setIryokikanCd(医療機関コード.getValue());
        entity.setShikibetsuCode(識別コード);
        entity.setIryokikanRyakusho(医療機関略称);
        entity.setIryokikanKanaRyakusho(医療機関カナ略称);
        entity.setYubinNo(郵便番号);
        entity.setJusho(住所);
        entity.setKanaJusho(カナ住所);
        entity.setKaiinKubunCode(new Code(会員区分));
        entity.setJiritsushienFlag(指定自立支援医療機関flag);
        entity.setShinsetsuYMD(new FlexibleDate(新設年月日.toDateString()));
        entity.setHaishiYMD(new FlexibleDate(廃止年月日.toDateString()));
        entity.setKyushiKubunCode(new Code(休止区分));
        entity.setIdoJiyuCode(new Code(異動事由));
        entity.setIdoYMD(new FlexibleDate(異動年月日.toDateString()));
        return entity;
    }

    //TODO n3327 三浦凌 UrT0516IryokikanEntityにIIryoKikanを引数にしたコンストラクタしかないことに対する暫定対応。見直しが必要。
    private static IIryoKikan createIryoKikan() {
        return new IIryoKikan() {
            @Override
            public IIryoKikanCode get医療機関コード() {
                return 医療機関コード;
            }

            @Override
            public IShikibetsuCode get識別コード() {
                return createShikibetsuCode(識別コード);
            }

            @Override
            public IName get医療機関名称() {
                return createName(医療機関名称, 医療機関カナ名称);

            }

            @Override
            public IName get医療機関略称() {
                return createName(医療機関略称, 医療機関カナ略称);
            }

            @Override
            public RString get所在地郵便番号() {
                return 郵便番号;
            }

            @Override
            public RString get所在地住所() {
                return 住所;
            }

            @Override
            public RString get所在地カナ住所() {
                return カナ住所;
            }

            @Override
            public Range<RDate> get開設期間() {
                return new Range<>(新設年月日, 廃止年月日);
            }

            @Override
            public IDoctors get所属医師() {
                return null;
            }

            @Override
            public List<IKoza> get口座() {
                return new ArrayList<>();
            }

            @Override
            public RDate get異動年月日() {
                return 異動年月日;
            }

            @Override
            public RString get休止区分() {
                return 休止区分;
            }

            @Override
            public RString get異動事由() {
                return 異動事由;
            }

            @Override
            public RString get会員区分() {
                return 会員区分;
            }

            @Override
            public RString get点数表() {
                return RString.EMPTY;
            }

            @Override
            public boolean is有効医療機関(RDate 基準日) {
                return true;
            }

            @Override
            public boolean is指定自立支援医療機関() {
                return 指定自立支援医療機関flag;
            }
        };
    }

    public static DbT7011ShujiiIryoKikanJohoEntity create主治医医療機関Entity() {
        DbT7011ShujiiIryoKikanJohoEntity entity = new DbT7011ShujiiIryoKikanJohoEntity();
        entity.setShichosonCode(市町村コード_A001);
        entity.setKaigoIryokikanCode(介護医療機関コード);
        entity.setIryokikanCode(医療機関コード.getValue());
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

    private static IShikibetsuCode createShikibetsuCode(RString 識別コード) {
        IShikibetsuCode shikibetsuCode = mock(IShikibetsuCode.class);
        when(shikibetsuCode.getValue()).thenReturn(識別コード);
        return shikibetsuCode;
    }

    private static IName createName(RString 名称, RString カナ名称) {
        IName name = mock(IName.class);
        when(name.getName()).thenReturn(名称);
        when(name.getKana()).thenReturn(カナ名称);
        return name;
    }
}
