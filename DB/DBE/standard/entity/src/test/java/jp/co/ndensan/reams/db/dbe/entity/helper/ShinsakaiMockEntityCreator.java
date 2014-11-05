/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiDummyKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiSeishinkaIshiSonzaiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiIinJokyo;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKyukaiKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.TimeString;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5014ShinsakaiIinJogaiJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5014ShinsakaiIinJogaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5101ShinsakaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5102ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5106ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.relate.JogaiShinsakaiIinEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;

/**
 * 審査会などのテストで使用されるEntityを生成するクラスです。
 *
 * @author n8178 城間篤人
 */
public final class ShinsakaiMockEntityCreator {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private ShinsakaiMockEntityCreator() {
    }

    /**
     * 審査会情報Entityを生成します。
     *
     * @param 開催番号 開催番号
     * @param 開催年月日 開催年月日
     * @return 審査会情報Entity
     */
    public static DbT5101ShinsakaiJohoEntity create審査会情報Entity(int 開催番号, String 開催年月日) {
        DbT5101ShinsakaiJohoEntity entity = new DbT5101ShinsakaiJohoEntity();
        entity.setShinsakaiKaisaiNo(開催番号);
        entity.setShinsakaiKaisaiYMD(new FlexibleDate(開催年月日));
        entity.setShinsakaiKaishiTime(new RString("0830"));
        entity.setShinsakaiShuryoTime(new RString("1720"));
        entity.setShinsakaiKaisaiBashoCode(new RString("A001"));
        entity.setGogitaiNo(12);
        entity.setShinsakaiYoteiTeiin(6);
        entity.setShinsakaiSaidaiTeiin(7);
        entity.setShinsakaiJidoWariateTeiin(8);
        entity.setShinsakaiIinTeiin(9);
        entity.setGogitaiSeishinkaiSonzaiFlag(true);
        entity.setGogitaiDummyFlag(false);
        entity.setShinsakaiShiryoSakuseiYMD(new FlexibleDate("20090101"));
        entity.setShinsakaiKyukaiFlag(false);
        entity.setShinsakaiWariateZumiNinzu(5);
        entity.setShiryoSakuseiKubun(new Code("0"));
        return entity;
    }

    /**
     * 審査会情報Entityを生成します。
     *
     * @param 開催番号 開催番号
     * @param 開催年月日 開催年月日
     * @param 開催場所番号 開催場所番号
     * @return 審査会情報Entity
     */
    public static DbT5101ShinsakaiJohoEntity create審査会情報Entity(int 開催番号, String 開催年月日, String 開催場所番号) {
        DbT5101ShinsakaiJohoEntity entity = create審査会情報Entity(開催番号, 開催年月日);
        entity.setShinsakaiKaisaiBashoCode(new RString(開催場所番号));
        return entity;
    }

    /**
     * すべてのキー項目＋開催場所番号を指定して、審査会情報Entityを生成します。
     *
     * @param 開催番号 開催番号
     * @param 開催年月日 開催年月日
     * @param 開始時間 開始時間
     * @param 合議体番号 合議体番号
     * @param 開催場所番号 開催場所番号
     * @return 審査会情報Entity
     */
    public static DbT5101ShinsakaiJohoEntity create審査会情報Entity(int 開催番号, String 開催年月日,
            int 合議体番号, String 開始時間, String 開催場所番号) {
        DbT5101ShinsakaiJohoEntity entity = create審査会情報Entity(開催番号, 開催年月日);
        entity.setGogitaiNo(合議体番号);
        entity.setShinsakaiKaishiTime(new RString(開始時間));
        entity.setShinsakaiKaisaiBashoCode(new RString(開催場所番号));
        return entity;
    }

    /**
     * キー項目以外も含む、すべての要素を指定して、審査会情報Entityを生成します。
     *
     * @param 開催番号 開催番号
     * @param 開催年月日 開催年月日
     * @param 合議体番号 合議体番号
     * @param 開始時間 開始時間
     * @param 終了時間 終了時間
     * @param 開催場所番号 開催場所番号
     * @param 審査会予定定員 審査会予定定員
     * @param 審査会最大定員 審査会最大定員
     * @param 審査会自動割当定員 審査会自動割当定員
     * @param 審査会委員定員 審査会委員定員
     * @param 精神科医存在区分 精神科医存在区分
     * @param 合議体ダミー区分 合議体ダミー区分
     * @param 休会区分 休会区分
     * @param 審査会資料作成年月日 審査会資料作成年月日
     * @param 審査会割当済み人数 審査会割当済み人数
     * @param 資料作成区分 資料作成区分
     * @return 審査会情報Entity
     */
    public static DbT5101ShinsakaiJohoEntity create審査会情報Entity(ShinsakaiKaisaiNo 開催番号, FlexibleDate 開催年月日,
            GogitaiNo 合議体番号, TimeString 開始時間, TimeString 終了時間, ShinsakaiKaisaiBashoCode 開催場所番号,
            int 審査会予定定員, int 審査会最大定員, int 審査会自動割当定員, int 審査会委員定員, GogitaiSeishinkaIshiSonzaiKubun 精神科医存在区分,
            GogitaiDummyKubun 合議体ダミー区分, ShinsakaiKyukaiKubun 休会区分, FlexibleDate 審査会資料作成年月日, int 審査会割当済み人数,
            Code 資料作成区分) {
        DbT5101ShinsakaiJohoEntity entity = new DbT5101ShinsakaiJohoEntity();
        entity.setShinsakaiKaisaiNo(開催番号.value());
        entity.setShinsakaiKaisaiYMD(開催年月日);
        entity.setShinsakaiKaishiTime(開始時間.value());
        entity.setShinsakaiShuryoTime(終了時間.value());
        entity.setShinsakaiKaisaiBashoCode(開催場所番号.value());
        entity.setGogitaiNo(合議体番号.value());
        entity.setShinsakaiYoteiTeiin(審査会予定定員);
        entity.setShinsakaiSaidaiTeiin(審査会最大定員);
        entity.setShinsakaiJidoWariateTeiin(審査会自動割当定員);
        entity.setShinsakaiIinTeiin(審査会委員定員);
        entity.setGogitaiSeishinkaiSonzaiFlag(精神科医存在区分.is存在());
        entity.setGogitaiDummyFlag(合議体ダミー区分.isダミー());
        entity.setShinsakaiShiryoSakuseiYMD(審査会資料作成年月日);
        entity.setShinsakaiKyukaiFlag(休会区分.is休会());
        entity.setShinsakaiWariateZumiNinzu(審査会割当済み人数);
        entity.setShiryoSakuseiKubun(資料作成区分);
        return entity;
    }

    /**
     * 審査会割当委員情報Entityを生成します。
     *
     * @param 開催番号 開催番号
     * @param 開催年月日 開催年月日
     * @param 審査会委員コード 審査会委員コード
     * @return 審査会割当委員Entity
     */
    public static DbT5106ShinsakaiWariateIinJohoEntity create審査会割当委員情報Entity(int 開催番号, String 開催年月日,
            String 審査会委員コード) {
        DbT5106ShinsakaiWariateIinJohoEntity entity = new DbT5106ShinsakaiWariateIinJohoEntity();
        entity.setShinsakaiKaisaiNo(開催番号);
        entity.setShinsakaiKaisaiYMD(new FlexibleDate(開催年月日));
        entity.setShinsakaiIinCode(new RString(審査会委員コード));
        entity.setShinsainKubunCode(new Code("shinsain01"));
        entity.setGogitaichoKubunCode(new Code("gogitaicho01"));
        entity.setShinsakaiIinShinsaKaishiTime(new RString("0830"));
        entity.setShinsakaiIinshinsaShuryoTime(new RString("1720"));
        entity.setShinsakaiIinShukketsuKubun(new RString("1"));
        return entity;
    }

    /**
     * 審査会割当委員情報Entityを生成します。(Spy)
     *
     * @param 開催番号 開催番号
     * @param 開催年月日 開催年月日
     * @param 審査会委員コード 審査会委員コード
     * @return 審査会割当委員Entity
     */
    public static DbT5106ShinsakaiWariateIinJohoEntity create審査会割当委員情報EntitySpy(int 開催番号, String 開催年月日,
            String 審査会委員コード) {
        DbT5106ShinsakaiWariateIinJohoEntity entity = create審査会割当委員情報Entity(開催番号, 開催年月日, 審査会委員コード);
        return spySet審査会割当委員Entity(entity);
    }

    /**
     * 割当委員の情報をすべて引数から設定して審査会割当委員情報Entityを生成します。(Spy)
     *
     * @param 開催番号 開催番号
     * @param 開催年月日 開催年月日
     * @param 審査会委員コード 審査会委員コード
     * @param 審査会区分 審査会区分
     * @param 合議体長区分 合議体長区分
     * @param 開始時間 開始時間
     * @param 終了時間 終了時間
     * @param 出欠区分 出欠区分
     * @return 審査会割当委員情報Entity
     */
    public static DbT5106ShinsakaiWariateIinJohoEntity create審査会割当委員情報EntitySpy(int 開催番号, FlexibleDate 開催年月日,
            RString 審査会委員コード, Code 審査会区分, Code 合議体長区分, RString 開始時間, RString 終了時間, RString 出欠区分) {
        DbT5106ShinsakaiWariateIinJohoEntity entity = new DbT5106ShinsakaiWariateIinJohoEntity();
        entity.setShinsakaiKaisaiNo(開催番号);
        entity.setShinsakaiKaisaiYMD(開催年月日);
        entity.setShinsakaiIinCode(審査会委員コード);
        entity.setShinsainKubunCode(審査会区分);
        entity.setGogitaichoKubunCode(合議体長区分);
        entity.setShinsakaiIinShinsaKaishiTime(開始時間);
        entity.setShinsakaiIinshinsaShuryoTime(終了時間);
        entity.setShinsakaiIinShukketsuKubun(出欠区分);
        return spySet審査会割当委員Entity(entity);
    }

    /**
     * キー項目と審査員区分を指定して、審査会割当委員情報Entityを生成します。
     *
     * @param 開催番号 開催番号
     * @param 開催年月日 開催年月日
     * @param 審査会委員コード 審査会委員コード
     * @return 審査会割当委員Entity
     */
    public static DbT5106ShinsakaiWariateIinJohoEntity create審査会割当委員情報Entity(int 開催番号, String 開催年月日,
            String 審査会委員コード, Code 審査員区分) {
        DbT5106ShinsakaiWariateIinJohoEntity entity = create審査会割当委員情報Entity(開催番号, 開催年月日, 審査会委員コード);
        entity.setShinsainKubunCode(審査員区分);
        return entity;
    }

    private static DbT5106ShinsakaiWariateIinJohoEntity spySet審査会割当委員Entity(DbT5106ShinsakaiWariateIinJohoEntity entity) {
        entity = spy(entity);
        doReturn(new RString("shinsain01")).when(entity).getShinsainKubunCodeMeisho();
        doReturn(new RString("shinsain01")).when(entity).getGogitaichoKubunCodeMeisho();
        doReturn(new RString("shinsain01")).when(entity).getShinsainKubunCodeRyakusho();
        doReturn(new RString("shinsain01")).when(entity).getGogitaichoKubunCodeRyakusho();
        return entity;
    }

    /**
     * 審査会割当委員情報EntityのListを生成します。(Spy)
     *
     * @param 開催番号 開催番号
     * @param 開催年月日 開催年月日
     * @param 審査会委員コードList 審査会委員コードList
     * @return 審査会割当委員EntityList
     */
    public static List<DbT5106ShinsakaiWariateIinJohoEntity> create審査会割当委員情報EntityListSpy(int 開催番号, String 開催年月日,
            String... 審査会委員コードList) {
        List<DbT5106ShinsakaiWariateIinJohoEntity> list = new ArrayList<>();
        for (String 委員コード : 審査会委員コードList) {
            list.add(create審査会割当委員情報EntitySpy(開催番号, 開催年月日, 委員コード));
        }
        return list;
    }

    /**
     * 審査会割当委員情報EntityのListを生成します。
     *
     * @param 開催番号 開催番号
     * @param 開催年月日 開催年月日
     * @param 審査会委員コードList 審査会委員コードList
     * @return 審査会割当委員EntityList
     */
    public static List<DbT5106ShinsakaiWariateIinJohoEntity> create審査会割当委員情報EntityList(int 開催番号, String 開催年月日,
            String... 審査会委員コードList) {
        List<DbT5106ShinsakaiWariateIinJohoEntity> list = new ArrayList<>();
        for (String 委員コード : 審査会委員コードList) {
            list.add(create審査会割当委員情報Entity(開催番号, 開催年月日, 委員コード));
        }
        return list;
    }

    /**
     * 審査会委員情報Entityを生成します。
     *
     * @param 審査会委員コード 審査会委員コード
     * @return 審査会委員Entity
     */
    public static DbT5102ShinsakaiIinJohoEntity create審査会委員Entity(String 審査会委員コード) {
        DbT5102ShinsakaiIinJohoEntity 委員Entity = new DbT5102ShinsakaiIinJohoEntity();
        委員Entity.setShinsakaiIinCode(new RString(審査会委員コード));
        委員Entity.setShinsakaiIinKaishiYMD(FlexibleDate.MIN);
        委員Entity.setShinsakaiIinShuryoYMD(FlexibleDate.MAX);
        委員Entity.setShinsakaiIinJokyo(true);
        委員Entity.setJigyoshaNo(new JigyoshaNo(new RString("0000000001")));
        委員Entity.setJigyoshaKubun(new RString("1"));
        委員Entity.setShinsakaiIinShimei(new AtenaMeisho(new RString("仮名")));
        委員Entity.setShinsakaiIinKanaShimei(new AtenaKanaMeisho(new RString("ｶﾅ")));
        委員Entity.setSeibetsu(Gender.MALE.getCode());
        委員Entity.setShinsakaiIinShikakuCode(new Code(new RString("1")));
        委員Entity.setShinsainYusoKubun(new RString("1"));
        委員Entity.setYubinNo(new YubinNo("000-0000"));
        委員Entity.setJusho(new AtenaJusho("test住所１１１１"));
        委員Entity.setTelNo(new TelNo("098-0987-0987"));
        委員Entity.setKinyuKikanCode(new KinyuKikanCode("1111"));
        委員Entity.setKinyuKikanShitenCode(new KinyuKikanShitenCode("111"));
        委員Entity.setKozaShubetsu(new RString("1"));
        委員Entity.setKozaMeigi(new RString("test"));
        委員Entity.setKozaMeigiKana(new RString("仮名"));
        委員Entity.setKozaNo(new RString("0120123"));
        return 委員Entity;
    }

    /**
     * 審査会委員情報Entityを生成します。
     *
     * @param 審査会委員コード 審査会委員コード
     * @return 審査会委員Entity
     */
    public static DbT5102ShinsakaiIinJohoEntity create審査会委員Entity(String 審査会委員コード, boolean 有効区分) {
        DbT5102ShinsakaiIinJohoEntity entity = create審査会委員Entity(審査会委員コード);
        entity.setShinsakaiIinJokyo(有効区分);
        return entity;
    }

    /**
     * 審査会委員Entityを生成して返します。（Spy)
     *
     * @param 委員コード 委員コード
     * @return 審査会委員Entity
     */
    public static DbT5102ShinsakaiIinJohoEntity create審査会委員EntitySpy(String 委員コード, boolean 有効区分) {
        DbT5102ShinsakaiIinJohoEntity entity = create審査会委員EntitySpy(委員コード);
        entity.setShinsakaiIinJokyo(有効区分);
        return entity;
    }

    /**
     * 審査会委員Entityを生成して返します。（Spy)
     *
     * @param 委員コード 委員コード
     * @param 開始年月日 開始年月日
     * @return 審査会委員Entity
     */
    public static DbT5102ShinsakaiIinJohoEntity create審査会委員EntitySpy(String 委員コード) {
        DbT5102ShinsakaiIinJohoEntity entity = spy(create審査会委員Entity(委員コード));
        doReturn(new RString("meisho")).when(entity).getShinsakaiIinShikakuCodeMeisho();
        doReturn(new RString("ryakusho")).when(entity).getShinsakaiIinShikakuCodeRyakusho();
        return entity;
    }

    /**
     * 審査会委員Entityを生成して返します。
     *
     * @param 審査会委員コード 審査会委員コード
     * @param 開始年月日 開始年月日
     * @return 審査会委員Entity
     */
    public static DbT5102ShinsakaiIinJohoEntity create審査会委員Entity(String 審査会委員コード, String 開始年月日) {
        DbT5102ShinsakaiIinJohoEntity entity = create審査会委員Entity(審査会委員コード);
        entity.setShinsakaiIinKaishiYMD(new FlexibleDate(開始年月日));
        return entity;
    }

    /**
     * 審査会委員除外情報Entityを作成して返します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 管理番号 管理番号
     * @param 除外対象審査会委員コード 除外対象審査会委員コード
     * @return 審査会委員除外情報Entity
     */
    public static DbT5014ShinsakaiIinJogaiJohoEntity create審査会委員除外情報Entity(ShoKisaiHokenshaNo 証記載保険者番号,
            KaigoHihokenshaNo 被保険者番号, int 管理番号, ShinsakaiIinCode 除外対象審査会委員コード) {
        DbT5014ShinsakaiIinJogaiJohoEntity entity = new DbT5014ShinsakaiIinJogaiJohoEntity();
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        entity.setHihokenshaNo(被保険者番号);
        entity.setKanriNo(管理番号);
        entity.setJogaiTaishoShinsakaiIinCode(除外対象審査会委員コード.value());
        return entity;
    }

    public static JogaiShinsakaiIinEntity create除外対象審査会委員EntitySpy() {
        return new JogaiShinsakaiIinEntity(create審査会委員EntitySpy("00000001"),
                create審査会委員除外情報Entity(new ShoKisaiHokenshaNo(new RString("000001")),
                        new KaigoHihokenshaNo(new RString("0000000001")), 1, new ShinsakaiIinCode(new RString("00001111"))));
    }

    public static List<JogaiShinsakaiIinEntity> create除外対象審査会委員EntityListSpy(int 件数) {
        List<JogaiShinsakaiIinEntity> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(create除外対象審査会委員EntitySpy());
        }
        return list;
    }
}
