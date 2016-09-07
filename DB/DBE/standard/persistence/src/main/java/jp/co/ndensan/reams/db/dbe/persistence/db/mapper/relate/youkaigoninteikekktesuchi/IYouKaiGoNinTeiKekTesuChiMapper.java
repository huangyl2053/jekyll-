/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.youkaigoninteikekktesuchi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.dbe090001.YouKaiGoNinTeiKekTesuChiMybitisParamter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChiMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChiRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定結果情報のマッパーインタフェースです。
 *
 * @reamsid_L DBE-0220-010 wangkun
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
     * KEYより主治医意見書作成依頼情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @return DbT5301ShujiiIkenshoIraiJohoEntity
     */
    DbT5301ShujiiIkenshoIraiJohoEntity get主治医意見書作成依頼情報ByKey(RString 申請書管理番号, int 主治医意見書作成依頼履歴番号);
}
