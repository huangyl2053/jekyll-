/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;

/**
 * サービスの状況一時テーブルのProcessを編集するentityです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
public class ServiceJokyoTempTableEditorEntity {

    private static final int 項番3 = 3;
    private static final int 項番4 = 4;
    private static final int 項番5 = 5;
    private static final int 項番6 = 6;
    private static final int 項番7 = 7;
    private static final int 項番8 = 8;
    private static final int 項番9 = 9;
    private static final int 項番10 = 10;
    private static final int 項番11 = 11;
    private static final int 項番12 = 12;
    private static final int 項番13 = 13;
    private static final int 項番14 = 14;
    private static final int 項番15 = 15;
    private static final int 項番16 = 16;
    private static final int 項番17 = 17;
    private static final int 項番18 = 18;
    private static final int 項番19 = 19;
    private static final int 項番20 = 20;
    private final NinteichosahyoServiceJokyoTempEntity tempEntity;

    /**
     * コンストラクタです。
     *
     * @param entity NinteichosahyoServiceJokyoTempEntity
     */
    public ServiceJokyoTempTableEditorEntity(NinteichosahyoServiceJokyoTempEntity entity) {
        this.tempEntity = entity;
    }

    /**
     * 連番でサービスの状況を設定します。
     *
     * @param entity DbT5207NinteichosahyoServiceJokyoEntity
     */
    public void setサービスの状況(DbT5207NinteichosahyoServiceJokyoEntity entity) {
        if (entity.getRemban() == 1) {
            tempEntity.setKoban1(entity.getServiceJokyo());
        } else if (entity.getRemban() == 2) {
            tempEntity.setKoban2(entity.getServiceJokyo());
        } else if (entity.getRemban() == 項番3) {
            tempEntity.setKoban3(entity.getServiceJokyo());
        } else if (entity.getRemban() == 項番4) {
            tempEntity.setKoban4(entity.getServiceJokyo());
        } else if (entity.getRemban() == 項番5) {
            tempEntity.setKoban5(entity.getServiceJokyo());
        } else if (entity.getRemban() == 項番6) {
            tempEntity.setKoban6(entity.getServiceJokyo());
        } else if (entity.getRemban() == 項番7) {
            tempEntity.setKoban7(entity.getServiceJokyo());
        } else if (entity.getRemban() == 項番8) {
            tempEntity.setKoban8(entity.getServiceJokyo());
        } else if (entity.getRemban() == 項番9) {
            tempEntity.setKoban9(entity.getServiceJokyo());
        } else if (entity.getRemban() == 項番10) {
            tempEntity.setKoban10(entity.getServiceJokyo());
        } else {
            setサービスの状況By連番10以降(entity);
        }
    }

    private void setサービスの状況By連番10以降(DbT5207NinteichosahyoServiceJokyoEntity entity) {
        if (entity.getRemban() == 項番11) {
            tempEntity.setKoban11(entity.getServiceJokyo());
        } else if (entity.getRemban() == 項番12) {
            tempEntity.setKoban12(entity.getServiceJokyo());
        } else if (entity.getRemban() == 項番13) {
            tempEntity.setKoban13(entity.getServiceJokyo());
        } else if (entity.getRemban() == 項番14) {
            tempEntity.setKoban14(entity.getServiceJokyo());
        } else if (entity.getRemban() == 項番15) {
            tempEntity.setKoban15(entity.getServiceJokyo());
        } else if (entity.getRemban() == 項番16) {
            tempEntity.setKoban16(entity.getServiceJokyo());
        } else if (entity.getRemban() == 項番17) {
            tempEntity.setKoban17(entity.getServiceJokyo());
        } else if (entity.getRemban() == 項番18) {
            tempEntity.setKoban18(entity.getServiceJokyo());
        } else if (entity.getRemban() == 項番19) {
            tempEntity.setKoban19(entity.getServiceJokyo());
        } else if (entity.getRemban() == 項番20) {
            tempEntity.setKoban20(entity.getServiceJokyo());
        }
    }

}
