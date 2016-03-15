/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会割当情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5502ShinsakaiWariateJohoEntityGenerator {

    public static final RString DEFAULT_介護認定審査会開催番号 = new RString("1");
    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("1");
    public static final FlexibleDate DEFAULT_介護認定審査会開催年月日 = new FlexibleDate("20150402");
    public static final FlexibleDate DEFAULT_介護認定審査会割当年月日 = new FlexibleDate("20150402");
    public static final int DEFAULT_介護認定審査会審査順 = 1;
    public static final boolean DEFAULT_介護認定審査会審査順確定フラグ = false;
    public static final boolean DEFAULT_審査会自動割付フラグ = false;
    public static final FlexibleDate DEFAULT_審査会資料作成年月日 = new FlexibleDate("20150402");
    public static final FlexibleDate DEFAULT_審査会資料送付年月日 = new FlexibleDate("20150402");
    public static final Code DEFAULT_判定結果コード = new Code("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5502ShinsakaiWariateJohoEntityGenerator() {
    }

    public static DbT5502ShinsakaiWariateJohoEntity createDbT5502ShinsakaiWariateJohoEntity() {
        DbT5502ShinsakaiWariateJohoEntity entity = new DbT5502ShinsakaiWariateJohoEntity();
        entity.setShinsakaiKaisaiNo(DEFAULT_介護認定審査会開催番号);
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setShinsakaiKaisaiYMD(DEFAULT_介護認定審査会開催年月日);
        entity.setShinsakaiWariateYMD(DEFAULT_介護認定審査会割当年月日);
        entity.setShinsakaiOrder(DEFAULT_介護認定審査会審査順);
        entity.setShinsakaiOrderKakuteiFlag(DEFAULT_介護認定審査会審査順確定フラグ);
        entity.setShinsakaiJidoWaritsukeFlag(DEFAULT_審査会自動割付フラグ);
        entity.setShinsakaiShiryoSakuseiYMD(DEFAULT_審査会資料作成年月日);
        entity.setShinsakaiShiryoSofuYMD(DEFAULT_審査会資料送付年月日);
        entity.setHanteiKekkaCode(DEFAULT_判定結果コード);
        return entity;
    }
}
