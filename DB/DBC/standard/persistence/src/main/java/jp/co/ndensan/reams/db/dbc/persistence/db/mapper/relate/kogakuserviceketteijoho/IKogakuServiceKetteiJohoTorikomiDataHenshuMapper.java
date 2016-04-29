/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakuserviceketteijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakuserviceketteijohotorikomidatahenshu.DbShoriDataParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kagoketteikohifutanshain.PSMParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kagoketteikohifutanshain.ShichosonHihokenshaParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufuketteiin.KogakuKyufuKetteiInPartEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufuketteiin.KogakuKyufuKetteiInTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufuketteiin.KogakuKyufuKetteiInYiLanEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufuketteiin.PSMEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7026ShinKyuHihokenshaNoHenkanEntity;

/**
 * 高額サービス費決定情報取込みのMapper
 *
 * @reamsid_L DBC-0980-400 lijunjun
 */
public interface IKogakuServiceKetteiJohoTorikomiDataHenshuMapper {

    /**
     * select一時TBLデータ
     *
     * @param parameter DbShoriDataParameter
     * @return List<KogakuKyufuKetteiInPartEntity>
     */
    List<KogakuKyufuKetteiInPartEntity> select一時TBLデータ(DbShoriDataParameter parameter);

    /**
     * 一時デーブルから被保険者番号を取得する
     *
     * @return List<KogakuKyufuKetteiInTempTableEntity>
     */
    List<KogakuKyufuKetteiInTempTableEntity> select被保険者番号();

    /**
     * 市町村コードの取得
     *
     * @param par ShichosonHihokenshaParameter
     * @return DbT1001HihokenshaDaichoEntity
     */
    DbT1001HihokenshaDaichoEntity select市町村コード(ShichosonHihokenshaParameter par);

    /**
     * 新番号の取得
     *
     * @param par SinBangoTempParameter
     * @return DbT7026ShinKyuHihokenshaNoHenkanEntity
     */
    DbT7026ShinKyuHihokenshaNoHenkanEntity select新番号(ShichosonHihokenshaParameter par);

    /**
     * 新旧被保険者番号を変換する
     *
     * @param henkanEntity DbT7026ShinKyuHihokenshaNoHenkanEntity
     * @return KogakuKyufuKetteiInTempTableEntity
     */
    KogakuKyufuKetteiInTempTableEntity update高額サービス費決定情報一時TBL1(DbT7026ShinKyuHihokenshaNoHenkanEntity henkanEntity);

    /**
     * select被保険者情報の取得
     *
     * @return DbT1001HihokenshaDaichoEntity
     */
    DbT1001HihokenshaDaichoEntity select被保険者情報();

    /**
     * update高額サービス費決定情報一時TBLの更新
     *
     * @param 被保険者台帳管理Entity DbT1001HihokenshaDaichoEntity
     * @return KogakuKyufuKetteiInTempTableEntity
     */
    KogakuKyufuKetteiInTempTableEntity update高額サービス費決定情報一時TBL2(DbT1001HihokenshaDaichoEntity 被保険者台帳管理Entity);

    /**
     * select一時デーブルから識別コードを取得
     *
     * @return List<KogakuKyufuKetteiInTempTableEntity>
     */
    List<KogakuKyufuKetteiInTempTableEntity> select一時デーブルから識別コード();

    /**
     * update高額サービス費決定情報一時TBLの更新3
     *
     * @param 宛名識別対象PSM PSMEntity
     * @return KogakuKyufuKetteiInTempTableEntity
     */
    KogakuKyufuKetteiInTempTableEntity update高額サービス費決定情報一時TBL3(PSMEntity 宛名識別対象PSM);

    /**
     * creat高額サービス費決定情報一時テーブル
     */
    void creat高額サービス費決定情報一時テーブル();

    /**
     * insert高額サービス費決定情報一時テーブル
     *
     * @param entity KogakuKyufuKetteiInTempTableEntity
     */
    void insert高額サービス費決定情報一時テーブル(KogakuKyufuKetteiInTempTableEntity entity);

    /**
     * get宛名識別対象PSM
     *
     * @param parameter PSMParameter
     * @return PSMEntity
     */
    PSMEntity select宛名識別対象PSM(PSMParameter parameter);

    /**
     * 一時TBLから高額サービス費決定情報一覧リストを取得する
     *
     * @return List<KogakuKyufuKetteiInYiLanEntity>
     */
    List<KogakuKyufuKetteiInYiLanEntity> select一時TBLから高額サービス費決定情報一覧リスト();
}
