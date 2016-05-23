/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaikekkatoroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaikekkatoroku.ShinsakaiKekkaTorokuParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinseijoho.ninteishinseijoho.NinteiShinseiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikekkatoroku.ShinsakaiKekkaTorokuIChiRanRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikekkatoroku.ShinsakaiKekkaTorokuRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会開催結果登録
 *
 * @reamsid_L DBE-0170-010 wangkun
 */
public interface IShinsakaiKekkaTorokuMapper {

    /**
     * 介護認定審査会開催結果登録をgetヘッドエリア内容取得します。
     *
     * @param 開催番号 RString
     * @return ShinsakaiKekkaTorokuRelateEntity 介護認定審査会審査結果登録のヘッドエリア内容検索情報RelateEntity
     */
    ShinsakaiKekkaTorokuRelateEntity getヘッドエリア内容検索(RString 開催番号);

    /**
     * 介護認定審査会開催結果登録をget審査会委員一覧検索取得します。
     *
     * @param param 審査会内容検索パラメータ
     * @return List<ShinsakaiKekkaTorokuIChiRanRelateEntity> 介護認定審査会審査結果登録の対象者一覧内容検索情報RelateEntityリスト
     */
    List<ShinsakaiKekkaTorokuIChiRanRelateEntity> get審査会委員一覧検索(ShinsakaiKekkaTorokuParameter param);

    /**
     * 介護認定審査会開催予定情報情報をキー検索で１件取得します。
     *
     * @param param 審査会内容検索パラメータ
     * @return List<ShinsakaiKaisaiYoteiJohoRelateEntity>
     */
    List<ShinsakaiKaisaiYoteiJohoRelateEntity> get審査会委員一覧更新_1(ShinsakaiKekkaTorokuParameter param);

    /**
     * 介護認定審査会開催予定情報情報をキー検索で１件取得します。
     *
     * @param param 審査会内容検索パラメータ
     * @return List<NinteiShinseiJohoRelateEntity>
     */
    List<NinteiShinseiJohoRelateEntity> get審査会委員一覧情報更新_2(ShinsakaiKekkaTorokuParameter param);

    /**
     * MAX履歴番号を取得します。
     *
     * @param 開催番号 開催番号
     * @return int
     */
    int get連番(RString 開催番号);
}
