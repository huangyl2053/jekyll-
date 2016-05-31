/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.fuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.fuka.FukaMapperParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.fuka.FukaEntity;

/**
 * 介護賦課のマッパーインタフェースです。
 */
public interface IFukaMapper {

    /**
     * 介護賦課情報をキー検索で１件取得します。
     *
     * @param 賦課検索条件 賦課検索条件
     * @return FukaEntity
     */
    FukaEntity getFukaEntity(FukaMapperParameter 賦課検索条件);

    /**
     * 介護賦課情報をキー検索で１件取得します。
     *
     * @param 介護賦課検索条件 介護賦課検索条件
     * @return FukaEntity
     */
    FukaEntity select介護賦課ByKey(FukaMapperParameter 介護賦課検索条件);

    // TODO リスト一覧取得に使用する検索項目はテーブル構造に合わせて修正が必要になります。
    // TODO 個別に引き渡す必要があるパラメータがある場合、追加してください。
    /**
     * 主キー1に合致する介護賦課のリストを取得します。
     *
     * @param 介護賦課検索条件 介護賦課検索条件
     * @return FukaEntityの{@code list}
     */
    List<FukaEntity> select介護賦課リストBy主キー1(FukaMapperParameter 介護賦課検索条件);

    /**
     * 主キー1に合致するデータ以前の介護賦課のリストを取得します。
     *
     * @param 介護賦課検索条件 介護賦課検索条件
     * @return FukaEntityの{@code list}
     */
    List<DbT2002FukaEntity> get前賦課履歴(FukaMapperParameter 介護賦課検索条件);

}
