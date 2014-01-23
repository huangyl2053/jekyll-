/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定申請情報テーブルから情報を取得するクラスのインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface INinteiShinseiJohoDac {

    /**
     * 申請書管理番号で指定された認定申請情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定申請情報エンティティ
     */
    @Transaction
    DbT5001NinteiShinseiJohoEntity select(ShinseishoKanriNo 申請書管理番号);

    /**
     * 市町村コードと認定申請年月日の範囲を指定し、指定された認定申請日の範囲で取下げされていない認定申請情報をすべて取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 認定申請年月日範囲 認定申請年月日範囲
     * @return 認定申請情報エンティティのList
     */
    @Transaction
    List<DbT5001NinteiShinseiJohoEntity> selectAllBy認定申請年月日(ShichosonCode 市町村コード, Range<FlexibleDate> 認定申請年月日範囲);

    /**
     * 市町村コードと取下げ年月日の範囲を指定し、指定された取下げ年月日の範囲で取下げされている認定申請情報をすべて取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 取下げ年月日範囲 取下げ年月日範囲
     * @return 認定申請情報エンティティのList
     */
    @Transaction
    List<DbT5001NinteiShinseiJohoEntity> selectAllBy取下げ年月日(ShichosonCode 市町村コード, Range<FlexibleDate> 取下げ年月日範囲);

    /**
     * 認定申請情報テーブルを更新します。
     *
     * @param entity 更新される情報を持つエンティティ
     * @return 更新件数
     */
    @Transaction
    int update(DbT5001NinteiShinseiJohoEntity entity);
}
