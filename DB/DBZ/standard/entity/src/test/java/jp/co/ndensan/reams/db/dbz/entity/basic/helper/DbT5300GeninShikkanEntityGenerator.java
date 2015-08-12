/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5300GeninShikkanEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 原因疾患エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5300GeninShikkanEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("900001");
    public static final int DEFAULT_連番 = 1;
    public static final boolean DEFAULT_主たる原因疾患フラグ = false;
    public static final Code DEFAULT_原因疾患コード = new Code("01");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5300GeninShikkanEntityGenerator() {
    }

    public static DbT5300GeninShikkanEntity createDbT5300GeninShikkanEntity() {
        DbT5300GeninShikkanEntity entity = new DbT5300GeninShikkanEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setRemban(DEFAULT_連番);
        entity.setIsShutaruGeninShikkan(DEFAULT_主たる原因疾患フラグ);
        entity.setGeninShikkanCode(DEFAULT_原因疾患コード);
        return entity;
    }
}
