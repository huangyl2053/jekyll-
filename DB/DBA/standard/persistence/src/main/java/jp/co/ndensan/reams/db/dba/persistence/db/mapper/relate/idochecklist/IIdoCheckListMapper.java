/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.idochecklist;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.idochecklist.IdoCheckListGetDataParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.idochecklist.IdoInfoEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.idochecklist.ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動チェックリストのマッパーインタフェースです。
 *
 * @reamsid_L DBA-0530-010 chengsanyuan
 */
public interface IIdoCheckListMapper {

    /**
     * 被保険者台帳リストを取得します
     *
     * @param param パラメータ
     * @return IdoInfoEntity
     */
    List<IdoInfoEntity> getHihokenshaDaichouList(IdoCheckListGetDataParameter param);

    /**
     * 異動事由がコード種別：0008のコード、他市町村住所地特例者を取得します
     *
     * @param param パラメータ
     * @return List<ShisetsuNyutaishoEntity>
     */
    List<ShisetsuNyutaishoEntity> getJushochiTokureiListByCode08(IdoCheckListGetDataParameter param);

    /**
     * 異動事由がコード種別：0011のコード、他市町村住所地特例者を取得します
     *
     * @param param パラメータ
     * @return List<ShisetsuNyutaishoEntity>
     */
    List<ShisetsuNyutaishoEntity> getJushochiTokureiListByCode11(IdoCheckListGetDataParameter param);

    /**
     * 介護保険施設入退所情報を取得します
     *
     * @param param パラメータ
     * @return List<ShisetsuNyutaishoEntity>
     */
    List<ShisetsuNyutaishoEntity> getShisetsuNyutaishoList(IdoCheckListGetDataParameter param);

    /**
     * 異動事由がコード種別：0009のコード、適用除外者を取得します
     *
     * @param param パラメータ
     * @return List<ShisetsuNyutaishoEntity>
     */
    List<ShisetsuNyutaishoEntity> getTekiyoJogaishaDaichouListByCode09(IdoCheckListGetDataParameter param);

    /**
     * 異動事由がコード種別：0012のコード、適用除外者を取得します
     *
     * @param param パラメータ
     * @return List<ShisetsuNyutaishoEntity>
     */
    List<ShisetsuNyutaishoEntity> getTekiyoJogaishaDaichouListByCode12(IdoCheckListGetDataParameter param);

    /**
     * 老齢福祉年金リストを取得します
     *
     * @param param パラメータ
     * @return List<IdoInfoEntity>
     */
    List<IdoInfoEntity> getRoreiFukushiNenkinList(IdoCheckListGetDataParameter param);

    /**
     * 生活保護受給者情報を取得します
     *
     * @param param パラメータ
     * @return List<UrT0508SeikatsuHogoJukyushaEntity>
     */
    List<UrT0508SeikatsuHogoJukyushaEntity> getSeikatsuHogoList(IdoCheckListGetDataParameter param);

    /**
     * 扶助種類コードリストを取得します
     *
     * @param param パラメータ
     * @return List<RString>
     */
    List<RString> getFujoShuruiCodeList(IdoCheckListGetDataParameter param);

    /**
     * 宛名識別対象を取得します
     *
     * @param param パラメータ
     * @return UaFt200FindShikibetsuTaishoEntity
     */
    UaFt200FindShikibetsuTaishoEntity getShikibetsuTaishoPsm(IdoCheckListGetDataParameter param);

    /**
     * 処理日付管理マスタ更新処理
     *
     * @param entity パラメータ
     * @return int
     */
    int updDbt7022ShoriDateKanri(DbT7022ShoriDateKanriEntity entity);

    /**
     * バッチプロセス用
     *
     * @return List<RString>
     */
    List<RString> getListForProcess();
}
