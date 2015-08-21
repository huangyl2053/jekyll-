/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5103GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5104ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5107GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

/**
 * 合議体関連のテストで必要なインスタンスを生成するクラスです。
 *
 * @author n8178 城間篤人
 */
public final class GogitaiMockEntityCreator {

    /**
     * 合議体情報Entityを生成します。（Spy）
     *
     * @param 合議体番号 合議体番号
     * @param 開始年月日 開始年月日
     * @param 終了年月日 終了年月日
     * @param 開催場所 開催場所
     * @return 合議体情報Entity
     */
    public static DbT5103GogitaiJohoEntity create合議体情報EntitySpy(int 合議体番号, String 開始年月日, String 終了年月日, String 開催場所) {
        return spy(create合議体情報Entity(合議体番号, 開始年月日, 終了年月日, 開催場所));
    }

    /**
     * 合議体情報Entityを生成します。
     *
     * @param 合議体番号 合議体番号
     * @param 開始年月日 開始年月日
     * @param 終了年月日 終了年月日
     * @param 開催場所 開催場所
     * @return 合議体情報Entity
     */
    public static DbT5103GogitaiJohoEntity create合議体情報Entity(int 合議体番号, String 開始年月日, String 終了年月日, String 開催場所) {
        DbT5103GogitaiJohoEntity entity = new DbT5103GogitaiJohoEntity();
        entity.setGogitaiNo(合議体番号);
        entity.setGogitaiMei(new RString("合議体A"));
        entity.setGogitaiYukoKikanKaishiYMD(new FlexibleDate(開始年月日));
        entity.setGogitaiYukoKikanShuryoYMD(new FlexibleDate(終了年月日));
        entity.setGogitaiKaishiYoteiTime(new RString("0930"));
        entity.setGogitaiShuryoYoteiTime(new RString("1730"));
        entity.setShinsakaiKaisaiBashoCode(new RString(開催場所));
        entity.setShinsakaiYoteiTeiin(5);
        entity.setShinsakaiJidoWariateTeiin(6);
        entity.setShinsakaiIinTeiin(7);
        entity.setGogitaiSeishinkaSonzaiFlag(false);
        entity.setGogitaiDummyFlag(false);
        return entity;
    }

    /**
     * 合議体割当情報Entityを生成して返します。（Spy)
     *
     * @param 合議体番号 合議体番号
     * @param 割当委員コード 割当委員コード
     * @param 開始年月日 開始年月日
     * @param 終了年月日 終了年月日
     * @return 合議体割当情報Entity
     */
    public static DbT5107GogitaiWariateIinJohoEntity create合議体割当EntitySpy(int 合議体番号, String 割当委員コード,
            String 開始年月日, String 終了年月日) {
        DbT5107GogitaiWariateIinJohoEntity entity = create合議体割当Entity(合議体番号, 割当委員コード, 開始年月日, 終了年月日);
        entity = spy(entity);

        doReturn(new RString("meisho")).when(entity).getGogitaichoKubunCodeMeisho();
        doReturn(new RString("meisho")).when(entity).getShinsainKubunCodeMeisho();
        doReturn(new RString("ryakusho")).when(entity).getGogitaichoKubunCodeRyakusho();
        doReturn(new RString("ryakusho")).when(entity).getShinsainKubunCodeRyakusho();
        return entity;
    }

    /**
     * 合議体割当情報Entityを生成して返します。
     *
     * @param 合議体番号 合議体番号
     * @param 割当委員コード 割当委員コード
     * @param 開始年月日 開始年月日
     * @param 終了年月日 終了年月日
     * @return 合議体割当情報Entity
     */
    public static DbT5107GogitaiWariateIinJohoEntity create合議体割当Entity(int 合議体番号, String 割当委員コード,
            String 開始年月日, String 終了年月日) {
        DbT5107GogitaiWariateIinJohoEntity entity = new DbT5107GogitaiWariateIinJohoEntity();
        entity.setGogitaiNo(合議体番号);
        entity.setShinsakaiIinCode(new RString(割当委員コード));
        entity.setGogitaiYukoKikanKaishiYMD(new FlexibleDate(開始年月日));
        entity.setGogitaiYukoKikanShuryoYMD(new FlexibleDate(終了年月日));
        entity.setGogitaichoKubunCode(new Code(new RString("1")));
        entity.setShinsainKubunCode(new Code(new RString("1")));
        return entity;
    }

    /**
     * 審査会開催場所Entityを生成して返します。（Spy)
     *
     * @param 審査会開催場所 審査会開催場所
     * @return 審査会開催場所Entity
     */
    public static DbT5104ShinsakaiKaisaiBashoJohoEntity create開催場所EntitySpy(String 審査会開催場所) {
        DbT5104ShinsakaiKaisaiBashoJohoEntity entity = spy(create開催場所Entity(審査会開催場所));
        doReturn(new RString("meisho")).when(entity).getShinsakaiKaisaiChikuCodeMeisho();
        doReturn(new RString("meisho")).when(entity).getShinsakaiKaisaiChikuCodeRyakusho();
        return entity;
    }

    /**
     * 審査会開催場所Entityを生成して返します。
     *
     * @param 審査会開催場所 審査会開催場所
     * @return 審査会開催場所Entity
     */
    public static DbT5104ShinsakaiKaisaiBashoJohoEntity create開催場所Entity(String 審査会開催場所) {
        DbT5104ShinsakaiKaisaiBashoJohoEntity entity = new DbT5104ShinsakaiKaisaiBashoJohoEntity();
        entity.setShinsakaiKaisaiBashoCode(new RString(審査会開催場所));
        entity.setShinsakaiKaisaiBashoMei(new RString("山田家"));
        entity.setShinsakaiKaisaiChikuCode(new Code("code"));
        entity.setShinsakaiKaisaiBashoJusho(new AtenaJusho("山田市"));
        entity.setShinsakaiKaisaiBashoTelNo(new TelNo("0989301569"));
        entity.setShinsakaiKaisaiBashoJokyo(false);
        return entity;
    }
}
