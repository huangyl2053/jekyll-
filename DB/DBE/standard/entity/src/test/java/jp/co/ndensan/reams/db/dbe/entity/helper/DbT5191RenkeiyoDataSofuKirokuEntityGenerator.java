/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5191RenkeiyoDataSofuKirokuEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 連携用データ送付記録エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5191RenkeiyoDataSofuKirokuEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("900001");
    public static final FlexibleDate DEFAULT_資料作成日 = new FlexibleDate("20141030");
    public static final RString DEFAULT_引渡し区分 = new RString("名称");
    public static final YMDHMS DEFAULT_引渡日時 = new YMDHMS("20140101123456");
    public static final RString DEFAULT_再送付区分 = new RString("名称");
    public static final RString DEFAULT_再調査送付区分 = new RString("名称");
    public static final RString DEFAULT_再意見書送付区分 = new RString("名称");
    public static final RString DEFAULT_再イメージ送付区分 = new RString("名称");
    public static final FlexibleDate DEFAULT_再送信年月日 = new FlexibleDate("20141030");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5191RenkeiyoDataSofuKirokuEntityGenerator() {
    }

    public static DbT5191RenkeiyoDataSofuKirokuEntity createDbT5191RenkeiyoDataSofuKirokuEntity() {
        DbT5191RenkeiyoDataSofuKirokuEntity entity = new DbT5191RenkeiyoDataSofuKirokuEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setShiryoSakuseiYMD(DEFAULT_資料作成日);
        entity.setHikiwatashiKubun(DEFAULT_引渡し区分);
        entity.setHikiwatashiTimeStamp(DEFAULT_引渡日時);
        entity.setSaiSoufuKubun(DEFAULT_再送付区分);
        entity.setSaiChousaSofuKubun(DEFAULT_再調査送付区分);
        entity.setSaiIkenshoSofuKubun(DEFAULT_再意見書送付区分);
        entity.setSaiImageSofuKubun(DEFAULT_再イメージ送付区分);
        entity.setSaiSoshinYMD(DEFAULT_再送信年月日);
        return entity;
    }
}
