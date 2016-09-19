/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.saishinsamoshitatetouroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.saishinsamoshitatetouroku.SaishinsaMoshitateTourokuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitatetouroku.SaishinsaMoshitateTourokuRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費再審査申立書作成のDB操作です。
 *
 * @reamsid_L DBC-2230-030 chenxiangyu
 */
public interface ISaishinsaMoshitateTourokuMapper {

    /**
     * 給付実績該当者一覧を取得します。
     *
     * @param parameter 介護給付費再審査申立書作成のパラメタ
     * @return 給付実績該当者一覧
     */
    List<SaishinsaMoshitateTourokuRelateEntity> selectKyufuJissekiList(SaishinsaMoshitateTourokuMybatisParameter parameter);

    /**
     * 再審査申立情報一覧を取得します。
     *
     * @param parameter 介護給付費再審査申立書作成のパラメタ
     * @return 再審査申立情報一覧
     */
    List<SaishinsaMoshitateTourokuRelateEntity> selectSaishinsaMoshitateJohoList(SaishinsaMoshitateTourokuMybatisParameter parameter);

    /**
     * サービス種類リストを取得します。
     *
     * @param parameter 介護給付費再審査申立書作成のパラメタ
     * @return サービス種類リスト
     */
    List<SaishinsaMoshitateTourokuRelateEntity> selectSabisuShuruiList(SaishinsaMoshitateTourokuMybatisParameter parameter);

    /**
     * サービスコードリストを取得します。
     *
     * @param parameter 介護給付費再審査申立書作成のパラメタ
     * @return サービスコードリスト
     */
    List<SaishinsaMoshitateTourokuRelateEntity> selectSabisuKodoList(SaishinsaMoshitateTourokuMybatisParameter parameter);

    /**
     * 特定診療識別リストを取得します。
     *
     * @param parameter 介護給付費再審査申立書作成のパラメタ
     * @return 特定診療識別リスト
     */
    List<SaishinsaMoshitateTourokuRelateEntity> selectTokuteiShinryoShikibetsuList(SaishinsaMoshitateTourokuMybatisParameter parameter);

    /**
     * 再審査申立情報の最大連番取得を取得します。
     *
     * @param parameter 介護給付費再審査申立書作成のパラメタ
     * @return 再審査申立情報の最大連番取得
     */
    RString selectSaishinsaMoshitateJohoSidaiRenBan(SaishinsaMoshitateTourokuMybatisParameter parameter);
}
