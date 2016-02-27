/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaikaisaiyoteijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.gogitaijoho.gogitaijoho.GogitaiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohoshinsakai.GogitaiJohoShinsaRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.shinsakaikaisaikekka.ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会開催予定情報のマッパーインタフェースです。
 */
public interface IShinsakaiKaisaiYoteiJohoMapper {

    /**
     * 介護認定審査会開催予定情報情報をキー検索で１件取得します。
     *
     * @param 介護認定審査会開催予定情報検索条件 介護認定審査会開催予定情報検索条件
     * @return ShinsakaiKaisaiYoteiJohoEntity
     */
    ShinsakaiKaisaiYoteiJohoRelateEntity getShinsakaiKaisaiYoteiJohoEntity(ShinsakaiKaisaiYoteiJohoMapperParameter 介護認定審査会開催予定情報検索条件);

    /**
     * 介護認定審査会開催予定情報の取得処理です。
     *
     * @param 表示年月 表示年月
     * @return 介護認定審査会開催予定情報Entityリスト List<ShinsakaiKaisaiYoteiJohoEntity>
     */
    List<ShinsakaiKaisaiYoteiJohoEntity> search審査会開催予定情報Of指定月(RString 表示年月);

    /**
     * 開催予定入力欄内容の取得処理です。
     *
     * @param 設定日 設定日
     * @return 開催予定入力欄内容情報Entityリスト List<ShinsakaiKaisaiYoteiJohoEntity>
     */
    List<ShinsakaiKaisaiYoteiJohoEntity> search審査会開催予定情報Of指定日(RString 設定日);

    /**
     * 合議体情報の取得処理です。
     *
     * @param parameter キー検索用のパラメータ
     * @return 合議体情報 GogitaiJohoShinsaRelateEntity
     */
    GogitaiJohoShinsaRelateEntity get合議体情報(GogitaiJohoMapperParameter parameter);

}
