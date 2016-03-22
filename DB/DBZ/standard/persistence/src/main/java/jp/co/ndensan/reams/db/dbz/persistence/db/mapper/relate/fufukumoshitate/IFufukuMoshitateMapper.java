/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.fufukumoshitate;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate.FufukuMoshitateMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.FufukuMoshitateEntity;

/**
 * 不服審査申立情報のマッパーインタフェースです。
 */
public interface IFufukuMoshitateMapper {

    /**
     * 不服審査申立情報情報をキー検索で１件取得します。
     *
     * @param 不服審査申立情報検索条件 不服審査申立情報検索条件
     * @return FufukuMoshitateEntity
     */
    FufukuMoshitateEntity select不服審査申立情報ByKey(FufukuMoshitateMapperParameter 不服審査申立情報検索条件);

    // TODO リスト一覧取得に使用する検索項目はテーブル構造に合わせて修正が必要になります。
    // TODO 個別に引き渡す必要があるパラメータがある場合、追加してください。
    /**
     * 主キー1に合致する不服審査申立情報のリストを取得します。
     *
     * @param 不服審査申立情報検索条件 不服審査申立情報検索条件
     * @return FufukuMoshitateEntityの{@code list}
     */
    List<FufukuMoshitateEntity> select不服審査申立情報リストBy主キー1(FufukuMoshitateMapperParameter 不服審査申立情報検索条件);
}
