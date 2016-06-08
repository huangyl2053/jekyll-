/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5123NinteiKeikakuJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 要介護認定計画情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5123NinteiKeikakuJohoEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("900001");
    public static final FlexibleDate DEFAULT_認定調査依頼予定年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_認定調査予定年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_主治医意見書作成依頼予定年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_主治医意見書登録予定年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_要介護認定一次判定予定年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_認定審査会割当予定年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_認定審査会予定年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_センター送信予定年月日 = new FlexibleDate("20141030");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5123NinteiKeikakuJohoEntityGenerator() {
    }

    public static DbT5123NinteiKeikakuJohoEntity createDbT5123NinteiKeikakuJohoEntity() {
        DbT5123NinteiKeikakuJohoEntity entity = new DbT5123NinteiKeikakuJohoEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setNinteichosaIraiYoteiYMD(DEFAULT_認定調査依頼予定年月日);
        entity.setNinteichosaYoteiYMD(DEFAULT_認定調査予定年月日);
        entity.setIkenshoSakuseiIraiYoteiYMD(DEFAULT_主治医意見書作成依頼予定年月日);
        entity.setIkenshoTorokuYoteiYMD(DEFAULT_主治医意見書登録予定年月日);
        entity.setIchijiHanteiYoteiYMD(DEFAULT_要介護認定一次判定予定年月日);
        entity.setNinteiShinsakaiWariateYoteiYMD(DEFAULT_認定審査会割当予定年月日);
        entity.setNinteiShinsakaiYoteiYMD(DEFAULT_認定審査会予定年月日);
        entity.setCenterSoshinYoteiYMD(DEFAULT_センター送信予定年月日);
        return entity;
    }
}
