/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.saishinsamoshitateshoout;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsamoshitateshoout.SaishinsaMoshitateMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.DbWT1741SaishinsaMoshitateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.DbWT1741SaishinsaMoshitateTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.SaishinsaMoshitateAndHihokenshaKanrenEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.SaishinsaMoshitateGetHokenshaNoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.SaishinsaMoshitateIchiranhyoTaisyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.SaishinsaMoshitateMeisyoKanrenEntity;

/**
 * 介護給付費再審査申立書情報作成のMapperです。
 *
 * @reamsid_L DBC-2540-030 liuhui
 */
public interface ISaishinsaMoshitateshoOutJohoMapper {

    /**
     * 再審査申立TBLからデータを取ります。
     *
     * @param parameter SaishinsaMoshitateGetSoufuDataProcessParameter
     * @return List<DbWT1741SaishinsaMoshitateTempEntity>
     */
    List<DbWT1741SaishinsaMoshitateTempEntity> select再審査申立データリスト(SaishinsaMoshitateMybatisParameter parameter);

    /**
     * 被保険者一時TBLと再審査申立一時TBLからデータを取ります。
     *
     * @return List<SaishinsaMoshitateAndHihokenshaKanrenEntity>
     */
    List<SaishinsaMoshitateAndHihokenshaKanrenEntity> select保険者番号取込関連リスト();

    /**
     * 再審査申立一時TBLからデータを取ります。
     *
     * @return List<SaishinsaMoshitateGetHokenshaNoEntity>
     */
    List<SaishinsaMoshitateGetHokenshaNoEntity> select保険者番号取得関連リスト();

    /**
     * 被保険者一時TBLと再審査申立一時TBLからデータを取ります。
     *
     * @param parameter SaishinsaMoshitateMybatisParameter
     * @return List<SaishinsaMoshitateAndHihokenshaKanrenEntity>
     */
    List<SaishinsaMoshitateAndHihokenshaKanrenEntity> select送付対象データ関連リスト(SaishinsaMoshitateMybatisParameter parameter);

    /**
     * 被保険者一時TBLと再審査申立一時TBLからデータを取ります。
     *
     * @return List<SaishinsaMoshitateAndHihokenshaKanrenEntity>
     */
    List<SaishinsaMoshitateAndHihokenshaKanrenEntity> select送付除外区分関連リスト();

    /**
     * 合併市町村TBLと再審査申立一時TBLからデータを取ります。
     *
     * @return List<SaishinsaMoshitateMeisyoKanrenEntity>
     */
    List<SaishinsaMoshitateMeisyoKanrenEntity> select旧市町村名称関連リスト();

    /**
     * 構成市町村マスタTBLと再審査申立一時TBLからデータを取ります。
     *
     * @return List<SaishinsaMoshitateMeisyoKanrenEntity>
     */
    List<SaishinsaMoshitateMeisyoKanrenEntity> select市町村名称関連リスト();

    /**
     * 介護事業者指定サービスTBLと再審査申立一時TBLからデータを取ります。
     *
     * @return List<SaishinsaMoshitateMeisyoKanrenEntity>
     */
    List<SaishinsaMoshitateMeisyoKanrenEntity> select介護事業者指定サービス名称関連リスト();

    /**
     * 介護事業者TBLと再審査申立一時TBLからデータを取ります。
     *
     * @return List<SaishinsaMoshitateMeisyoKanrenEntity>
     */
    List<SaishinsaMoshitateMeisyoKanrenEntity> select介護事業者名称取得関連リスト();

    /**
     * 再審査申立一時TBLからデータを取ります。
     *
     * @return List<DbWT1741SaishinsaMoshitateEntity>
     */
    List<DbWT1741SaishinsaMoshitateEntity> select事業者名称エラーデータ関連リスト();

    /**
     * 介護サービス種類TBLと再審査申立一時TBLからデータを取ります。
     *
     * @return List<SaishinsaMoshitateMeisyoKanrenEntity>
     */
    List<SaishinsaMoshitateMeisyoKanrenEntity> selectサービス種類名称関連リスト();

    /**
     * 介護サービス内容TBLと再審査申立一時TBLからデータを取ります。
     *
     * @return List<SaishinsaMoshitateMeisyoKanrenEntity>
     */
    List<SaishinsaMoshitateMeisyoKanrenEntity> select介護サービス内容名称関連リスト();

    /**
     * 特定診療サービスコードTBLと再審査申立一時TBLからデータを取ります。
     *
     * @return List<SaishinsaMoshitateMeisyoKanrenEntity>
     */
    List<SaishinsaMoshitateMeisyoKanrenEntity> select特定診療サービスコード名称関連リスト();

    /**
     * 再審査申立一時TBLからデータを取ります。
     *
     * @return List<DbWT1741SaishinsaMoshitateEntity>
     */
    List<DbWT1741SaishinsaMoshitateEntity> selectサービス名称エラーデータ関連リスト();

    /**
     * 帳票出力対象データを取得する。
     *
     * @param parameter KokuhorenIchiranhyoMybatisParameter
     * @return List<SaishinsaMoshitateIchiranhyoTaisyoEntity>
     */
    List<SaishinsaMoshitateIchiranhyoTaisyoEntity> get帳票出力対象データ(KokuhorenIchiranhyoMybatisParameter parameter);

    /**
     * DB更新データを取ります。
     *
     * @return List<SaishinsaMoshitateMeisyoKanrenEntity>
     */
    List<SaishinsaMoshitateMeisyoKanrenEntity> selectDB更新データ関連リスト();

}
