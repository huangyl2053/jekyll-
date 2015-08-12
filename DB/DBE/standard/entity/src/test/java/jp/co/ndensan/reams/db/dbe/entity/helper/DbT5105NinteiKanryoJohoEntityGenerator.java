/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 要介護認定完了情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5105NinteiKanryoJohoEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("900001");
    public static final FlexibleDate DEFAULT_認定申請情報登録完了年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_認定調査依頼完了年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_認定調査完了年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_主治医意見書作成依頼完了年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_主治医意見書登録完了年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_要介護認定一次判定完了年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_マスキング完了年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_認定審査会割当完了年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_認定審査会完了年月日 = new FlexibleDate("20141030");
    public static final FlexibleDate DEFAULT_センター送信年月日 = new FlexibleDate("20141030");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5105NinteiKanryoJohoEntityGenerator() {
    }

    public static DbT5105NinteiKanryoJohoEntity createDbT5105NinteiKanryoJohoEntity() {
        DbT5105NinteiKanryoJohoEntity entity = new DbT5105NinteiKanryoJohoEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setNinteiShinseiJohoTorokuKanryoYMD(DEFAULT_認定申請情報登録完了年月日);
        entity.setNinteichosaIraiKanryoYMD(DEFAULT_認定調査依頼完了年月日);
        entity.setNinteichosaKanryoYMD(DEFAULT_認定調査完了年月日);
        entity.setIkenshoSakuseiIraiKanryoYMD(DEFAULT_主治医意見書作成依頼完了年月日);
        entity.setIkenshoTorokuKanryoYMD(DEFAULT_主治医意見書登録完了年月日);
        entity.setIchijiHanteiKanryoYMD(DEFAULT_要介護認定一次判定完了年月日);
        entity.setMaskingKanryoYMD(DEFAULT_マスキング完了年月日);
        entity.setNinteiShinsakaiWariateKanryoYMD(DEFAULT_認定審査会割当完了年月日);
        entity.setNinteiShinsakaiKanryoYMD(DEFAULT_認定審査会完了年月日);
        entity.setCenterSoshinYMD(DEFAULT_センター送信年月日);
        return entity;
    }
}
