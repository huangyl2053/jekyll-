/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.shinsakaiKaisaiKekka;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.shinsakaiKaisaiKekka.ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.shinsakaiKaisaiKekka.ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護認定審査会開催結果登録
 */
public interface IShinsakaiKaisaiKekkaMapper {

    /**
     * 介護認定審査会開催結果登録をgetヘッドエリア内容取得します。
     *
     * @param 開催番号 RString
     * @return ShinsakaiKaisaiYoteiJohoEntity
     */
    ShinsakaiKaisaiYoteiJohoEntity getヘッドエリア内容検索(RString 開催番号);

    /**
     * 介護認定審査会開催結果登録をgget審査会委員一覧検索取得します。
     *
     * @param 開催番号 RString
     * @return ShinsakaiKaisaiYoteiJohoEntity
     */
    List<ShinsakaiWariateIinJohoEntity> get審査会委員一覧検索(RString 開催番号);

    /**
     * 介護認定審査会開催予定情報情報をキー検索で１件取得します。
     *
     * @param 開催番号 RString
     * @return ShinsakaiKaisaiYoteiJohoEntity
     */
    ShinsakaiKaisaiYoteiJohoRelateEntity get開催予定情報更新(RString 開催番号);
}
