/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakuserviceketteijohotorikomidatahenshu;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakuserviceketteijohotorikomidatahenshu.DbShoriDataParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakuserviceketteijohotorikomidatahenshu.HihokenshaNoDataParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakuserviceketteijohotorikomidatahenshu.SinBangoTempParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kagoketteikohifutanshain.PSMParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kagoketteikohifutanshain.ShichosonHihokenshaParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kagoketteikohifutanshain.ShikibetsuCodeTempParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufuketteiin.KogakuKyufuKetteiInPartEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufuketteiin.KogakuKyufuKetteiInTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufuketteiin.KogakuKyufuKetteiInYiLanEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufuketteiin.PSMEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7026ShinKyuHihokenshaNoHenkanEntity;

/**
 * 高額サービス費決定情報取込みのMapper
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
     * @param par SinBangoTempParameter
     * @return KogakuKyufuKetteiInTempTableEntity
     */
    KogakuKyufuKetteiInTempTableEntity update高額サービス費決定情報一時TBL1(SinBangoTempParameter par);

    /**
     * select被保険者情報の取得
     *
     * @return DbT1001HihokenshaDaichoEntity
     */
    DbT1001HihokenshaDaichoEntity select被保険者情報();

    /**
     * update高額サービス費決定情報一時TBLの更新
     *
     * @param par HihokenshaNoDataParameter
     * @return KogakuKyufuKetteiInTempTableEntity
     */
    KogakuKyufuKetteiInTempTableEntity update高額サービス費決定情報一時TBL2(HihokenshaNoDataParameter par);

    /**
     * select一時デーブルから識別コードを取得
     *
     * @return KogakuKyufuKetteiInTempTableEntity
     */
    KogakuKyufuKetteiInTempTableEntity select一時デーブルから識別コード();

    /**
     * update高額サービス費決定情報一時TBLの更新3
     *
     * @param par ShikibetsuCodeTempParameter
     * @return KogakuKyufuKetteiInTempTableEntity
     */
    KogakuKyufuKetteiInTempTableEntity update高額サービス費決定情報一時TBL3(ShikibetsuCodeTempParameter par);

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
