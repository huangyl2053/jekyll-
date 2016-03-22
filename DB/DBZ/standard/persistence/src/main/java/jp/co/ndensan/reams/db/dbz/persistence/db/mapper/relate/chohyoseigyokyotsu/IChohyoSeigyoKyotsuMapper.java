/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.chohyoseigyokyotsu;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate.ChohyoSeigyoKyotsuMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.ChohyoSeigyoKyotsuEntity;

/**
 * 帳票制御共通のマッパーインタフェースです。
 */
public interface IChohyoSeigyoKyotsuMapper {

    /**
     * 帳票制御共通情報をキー検索で１件取得します。
     *
     * @param 帳票制御共通検索条件 帳票制御共通検索条件
     * @return ChohyoSeigyoKyotsuEntity
     */
    ChohyoSeigyoKyotsuEntity select帳票制御共通ByKey(ChohyoSeigyoKyotsuMapperParameter 帳票制御共通検索条件);

    // TODO リスト一覧取得に使用する検索項目はテーブル構造に合わせて修正が必要になります。
    // TODO 個別に引き渡す必要があるパラメータがある場合、追加してください。
    /**
     * 主キー1に合致する帳票制御共通のリストを取得します。
     *
     * @param 帳票制御共通検索条件 帳票制御共通検索条件
     * @return ChohyoSeigyoKyotsuEntityの{@code list}
     */
    List<ChohyoSeigyoKyotsuEntity> select帳票制御共通リストBy主キー1(ChohyoSeigyoKyotsuMapperParameter 帳票制御共通検索条件);
}
