/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.relate.FukaMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.relate.FukaEntity;

/**
 * 介護賦課のマッパーインタフェースです。
 */
public interface IFukaMapper {

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
}
