/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.chosachikugroup;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.chosachikugroup.ChosaChikuGroupMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosachikugroup.ChosaChikuGroupRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5225ChosaChikuGroupEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査スケジュール登録8のマッパーインタフェースです。
 */
public interface IChosaChikuGroupRelateMapper {

    /**
     * 検索条件より、適当な条件を連結して、調査地区グループ調査地区一覧情報を検索する。
     *
     * @param parameter 調査地区グループ調査地区一覧情報検索条件
     * @return ChosaChikuGroupRelateEntity 検索結果の{@link ChosaChikuGroupRelateEntity}
     */
    List<ChosaChikuGroupRelateEntity> selectChosaChikuGroupChosaChiku(ChosaChikuGroupMapperParameter parameter);

    /**
     * 検索条件より、適当な条件を連結して、調査地区グループ調査地区一覧情報を検索する。
     *
     * @param parameter 調査地区グループ調査地区一覧情報検索条件
     * @return DbT5225ChosaChikuGroupEntity{@code list}
     */
    List<DbT5225ChosaChikuGroupEntity> selectChosaChikuGroup(ChosaChikuGroupMapperParameter parameter);

    /**
     * 調査地区グループ調査地区一覧情報件数検索処理。
     *
     * @param parameter 調査地区グループ調査地区一覧情報検索条件
     * @return 調査地区グループ調査地区一覧検索件数
     */
    int selectChosaChikuGroupCount(ChosaChikuGroupMapperParameter parameter);

    /**
     * 市町村名称検索処理。
     *
     * @param parameter 調査地区グループ調査地区一覧情報検索条件
     * @return 調査地区グループ調査地区一覧検索件数
     */
    RString selectShichosonMeisho(ChosaChikuGroupMapperParameter parameter);

    /**
     * 調査地区グループ調査地区一覧情報件数検索処理。
     *
     * @param parameter 調査地区グループ調査地区一覧情報検索条件
     * @return 調査地区コードと市町村コードがDBに登録済み件数
     */
    int selectChosaChikuGroupChosaChikuCount(ChosaChikuGroupMapperParameter parameter);

    /**
     * 調査地区グループ調査地区一覧情報件数検索処理。
     *
     * @param parameter 調査地区グループ調査地区一覧情報検索条件
     * @return 同一調査地区コードと市町村コードが複数の調査地区グループに登録件数
     */
    int selectChosaChikuGroupChosaChikuToroukuCount(ChosaChikuGroupMapperParameter parameter);
}
