/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.youkaigoninteikekktesuchi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChiMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChiRelateEntity;

/**
 * 要介護認定結果情報のマッパーインタフェースです。
 */
public interface YouKaiGoNinTeiKekTesuChiMapper {

    /**
     * 主治医選択一覧情報取得します。
     *
     * @param 主治医選択一覧情報検索条件 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return YouKaiGoNinTeiKekTesuChiRelateEntity 要介護認定結果情報RelateEntityクラスです。
     */
    List<YouKaiGoNinTeiKekTesuChiRelateEntity> getSyuJiSenTakuYiChiRan(YouKaiGoNinTeiKekTesuChiMapperParameter 主治医選択一覧情報検索条件);

    /**
     * 結果通知出力対象申請者情報取得します。
     *
     * @param 結果通知出力対象申請者情報検索条件 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return YouKaiGoNinTeiKekTesuChiRelateEntity 要介護認定結果情報RelateEntityクラスです。
     */
    List<YouKaiGoNinTeiKekTesuChiRelateEntity> 
        getKeKaTsuChiSyuTsuRyoKuTaiSyou(YouKaiGoNinTeiKekTesuChiMapperParameter 結果通知出力対象申請者情報検索条件);

}
