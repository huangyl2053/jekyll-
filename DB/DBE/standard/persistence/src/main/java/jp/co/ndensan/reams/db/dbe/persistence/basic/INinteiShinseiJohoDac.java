/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.IInsertable;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 認定申請情報テーブルから情報を取得するクラスのインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface INinteiShinseiJohoDac extends IInsertable<DbT5001NinteiShinseiJohoEntity> {

    /**
     * 申請書管理番号で指定された認定申請情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定申請情報エンティティ
     */
    @Transaction
    DbT5001NinteiShinseiJohoEntity select(ShinseishoKanriNo 申請書管理番号);

    /**
     * 証記載保険者番号と認定申請年月日の範囲を指定し、指定された認定申請日の範囲で取下げされていない認定申請情報をすべて取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 認定申請年月日範囲 認定申請年月日範囲
     * @return 認定申請情報エンティティのList
     */
    @Transaction
    List<DbT5001NinteiShinseiJohoEntity> selectAllBy認定申請年月日(ShoKisaiHokenshaNo 証記載保険者番号, Range<RDate> 認定申請年月日範囲);

    /**
     * 証記載保険者番号と取下げ年月日の範囲を指定し、指定された取下げ年月日の範囲で取下げされている認定申請情報をすべて取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 取下げ年月日範囲 取下げ年月日範囲
     * @return 認定申請情報エンティティのList
     */
    @Transaction
    List<DbT5001NinteiShinseiJohoEntity> selectAllBy取下げ年月日(ShoKisaiHokenshaNo 証記載保険者番号, Range<RDate> 取下げ年月日範囲);

    /**
     * 受け取った認定申請情報エンティティをDBへ登録します。
     *
     * @param entity 認定申請情報エンティティ
     * @return 登録に成功した数
     */
    @Transaction
    int insert(DbT5001NinteiShinseiJohoEntity entity);
}
