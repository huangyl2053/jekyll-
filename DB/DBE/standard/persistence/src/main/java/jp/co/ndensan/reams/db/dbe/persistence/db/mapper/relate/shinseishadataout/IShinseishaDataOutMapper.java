/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinseishadataout;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinseishadataout.ShinseishaDataOutMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseishadataout.ChosahyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseishadataout.IkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseishadataout.KihonJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5209NinteichosahyoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5303ShujiiIkenshoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;

/**
 * 申請データ出力のマッパーインタフェースです。
 *
 * @author N3212 竹内 和紀
 */
public interface IShinseishaDataOutMapper {

    /**
     * 基本情報を抽出します。
     *
     * @return KihonJohoEntityのリスト
     */
    List<KihonJohoEntity> select基本情報();

    /**
     * 調査票情報を抽出します。
     *
     * @return ChosahyoEntityのリスト
     */
    List<ChosahyoEntity> select調査票情報();

    /**
     * 意見書情報を抽出します。
     *
     * @return IkenshoJohoEntityのリスト
     */
    List<IkenshoJohoEntity> select意見書情報();

    /**
     * 認定調査票サービスの状況を抽出します。
     *
     * @param parameter ShinseishaDataOutMybatisParameter
     * @return DbT5207NinteichosahyoServiceJokyoEntityのリスト
     */
    List<DbT5207NinteichosahyoServiceJokyoEntity> select認定調査票サービスの状況(ShinseishaDataOutMybatisParameter parameter);

    /**
     * 認定調査票サービスの状況フラグを抽出します。
     *
     * @param parameter ShinseishaDataOutMybatisParameter
     * @return DbT5208NinteichosahyoServiceJokyoFlagEntityのリスト
     */
    List<DbT5208NinteichosahyoServiceJokyoFlagEntity> select認定調査票サービスの状況フラグ(ShinseishaDataOutMybatisParameter parameter);

    /**
     * 認定調査票記入項目を抽出します。
     *
     * @param parameter ShinseishaDataOutMybatisParameter
     * @return DbT5209NinteichosahyoKinyuItemEntityのリスト
     */
    List<DbT5209NinteichosahyoKinyuItemEntity> select認定調査票記入項目(ShinseishaDataOutMybatisParameter parameter);

    /**
     * 施設利用を抽出します。
     *
     * @param parameter ShinseishaDataOutMybatisParameter
     * @return DbT5210NinteichosahyoShisetsuRiyoEntityのリスト
     */
    List<DbT5210NinteichosahyoShisetsuRiyoEntity> select施設利用(ShinseishaDataOutMybatisParameter parameter);

    /**
     * 認定調査票調査項目を抽出します。
     *
     * @param parameter ShinseishaDataOutMybatisParameter
     * @return DbT5211NinteichosahyoChosaItemEntityのリスト
     */
    List<DbT5211NinteichosahyoChosaItemEntity> select認定調査票調査項目(ShinseishaDataOutMybatisParameter parameter);

    /**
     * 要介護認定主治医意見書記入項目を抽出します。
     *
     * @param parameter ShinseishaDataOutMybatisParameter
     * @return DbT5303ShujiiIkenshoKinyuItemEntityのリスト
     */
    List<DbT5303ShujiiIkenshoKinyuItemEntity> select要介護認定主治医意見書記入項目(ShinseishaDataOutMybatisParameter parameter);

    /**
     * 要介護認定主治医意見書意見項目を抽出します。
     *
     * @param parameter ShinseishaDataOutMybatisParameter
     * @return DbT5304ShujiiIkenshoIkenItemEntityのリスト
     */
    List<DbT5304ShujiiIkenshoIkenItemEntity> select要介護認定主治医意見書意見項目(ShinseishaDataOutMybatisParameter parameter);
}
