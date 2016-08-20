/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;

/**
 * 要介護認定主治医意見書意見項目一時テーブルのProcessを編集するentityです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
public class IkenItemTempTableEditorEntity {

    private static final int 項番14 = 14;
    private static final int 項番15 = 15;
    private static final int 項番16 = 16;
    private static final int 項番17 = 17;
    private static final int 項番18 = 18;
    private static final int 項番19 = 19;
    private static final int 項番69 = 69;
    private final ShujiiIkenshoIkenItemTempEntity tempEntity;

    /**
     * コンストラクタです。
     *
     * @param entity ShujiiIkenshoIkenItemTempEntity
     */
    public IkenItemTempTableEditorEntity(ShujiiIkenshoIkenItemTempEntity entity) {
        this.tempEntity = entity;
    }

    /**
     * 連番でサービスの状況を設定します。
     *
     * @param entity DbT5304ShujiiIkenshoIkenItemEntity
     */
    public void set調査項目(DbT5304ShujiiIkenshoIkenItemEntity entity) {
        if (entity.getRemban() == 項番14) {
            tempEntity.setKoban14(entity.getIkenItem());
        } else if (entity.getRemban() == 項番15) {
            tempEntity.setKoban15(entity.getIkenItem());
        } else if (entity.getRemban() == 項番16) {
            tempEntity.setKoban16(entity.getIkenItem());
        } else if (entity.getRemban() == 項番17) {
            tempEntity.setKoban17(entity.getIkenItem());
        } else if (entity.getRemban() == 項番18) {
            tempEntity.setKoban18(entity.getIkenItem());
        } else if (entity.getRemban() == 項番19) {
            tempEntity.setKoban19(entity.getIkenItem());
        } else if (entity.getRemban() == 項番69) {
            tempEntity.setKoban69(entity.getIkenItem());
        }
    }

}
