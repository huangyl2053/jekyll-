/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaikekkatoroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaikekkatoroku.ShinsakaiKekkaTorokuParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikekkatoroku.ShinsakaiKekkaTorokuIChiRanRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikekkatoroku.ShinsakaiKekkaTorokuRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity;
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
     * 介護認定審査会割当情報を取得します。
     *
     * @param param 審査会内容検索パラメータ
     * @return List<ShinsakaiKaisaiYoteiJohoRelateEntity>
     */
    List<DbT5502ShinsakaiWariateJohoEntity> get介護認定審査会割当情報(ShinsakaiKekkaTorokuParameter param);

    /**
     * 要介護認定申請情報を取得します。
     *
     * @param param 審査会内容検索パラメータ
     * @return List<NinteiShinseiJohoRelateEntity>
     */
    List<DbT5101NinteiShinseiJohoEntity> get要介護認定申請情報(ShinsakaiKekkaTorokuParameter param);

    /**
     * 要介護認定結果情報を取得します。
     *
     * @param param 審査会内容検索パラメータ
     * @return List<NinteiShinseiJohoRelateEntity>
     */
    List<DbT5102NinteiKekkaJohoEntity> get要介護認定結果情報(ShinsakaiKekkaTorokuParameter param);

    /**
     * 要介護認定完了情報を取得します。
     *
     * @param param 審査会内容検索パラメータ
     * @return List<NinteiShinseiJohoRelateEntity>
     */
    List<DbT5105NinteiKanryoJohoEntity> get要介護認定完了情報(ShinsakaiKekkaTorokuParameter param);

    /**
     * MAX履歴番号を取得します。
     *
     * @param 開催番号 開催番号
     * @return int
     */
    int get連番(RString 開催番号);
}
