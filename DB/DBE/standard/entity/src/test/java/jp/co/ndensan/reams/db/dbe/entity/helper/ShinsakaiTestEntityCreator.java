/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5101ShinsakaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5106ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;

/**
 * 審査会などのテストで使用されるEntityを生成するクラスです。
 *
 * @author n8178 城間篤人
 */
public final class ShinsakaiTestEntityCreator {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private ShinsakaiTestEntityCreator() {
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
}
