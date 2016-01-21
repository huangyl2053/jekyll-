/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.youkaigoninteikekktesuchi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChiMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.dbe090001.YouKaiGoNinTeiKekTesuChiMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChiRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;

/**
 * 要介護認定結果情報のマッパーインタフェースです。
 */
public interface IYouKaiGoNinTeiKekTesuChiMapper {

    /**
     * 主治医選択一覧情報取得します。
     *
     * @param param 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return YouKaiGoNinTeiKekTesuChiRelateEntity 要介護認定結果情報RelateEntityクラスです。
     */
    List<YouKaiGoNinTeiKekTesuChiRelateEntity> getSyuJiSenTakuYiChiRan(YouKaiGoNinTeiKekTesuChiMapperParameter param);

    /**
     * 結果通知出力対象申請者情報取得します。
     *
     * @param param 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return YouKaiGoNinTeiKekTesuChiRelateEntity 要介護認定結果情報RelateEntityクラスです。
     */
    List<YouKaiGoNinTeiKekTesuChiRelateEntity> getKeKaTsuChiSyuTsuRyoKuTaiSyou(YouKaiGoNinTeiKekTesuChiMapperParameter param);

    /**
     * 主治医への結果通知書を発行します。
     *
     * @param param 主治医への結果通知書のMyBatis用パラメータクラスです。
     * @return YouKaiGoNinTeiKekTesuChiRelateEntity 要介護認定結果情報RelateEntityクラスです。
     */
    List<YouKaiGoNinTeiKekTesuChiRelateEntity> getCyouHyouSyuTsuRyoKu(YouKaiGoNinTeiKekTesuChiMybitisParamter param);
    
    
    /**
     * 主治医意見書作成依頼情報を更新します。
     *
     * @param entity entity
     * @return 更新件数
     */
    int updateShuJiIkenSyoSaKuSeiIraiJyouHou (DbT5301ShujiiIkenshoIraiJohoEntity entity);
}
