/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hanteikekkajohoshuturyoku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hanteikekkajohoshuturyoku.HanteiKekkaJohoShuturyokuMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkaichirana3.HanteiKekkaIchiranA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kekkatsuchiichiranhyo.KekkatsuchiIchiranhyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.IinJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.ShinsakaiKaisaiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.ShinsakaiKekkaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5511ShinsakaiKaisaiKekkaJohoEntity;

/**
 * 判定結果情報出力(介護認定審査会)のマッパーインタフェースです。
 *
 * @reamsid_L DBE-0180-030 xuyannan
 */
public interface IHanteiKekkaJohoShuturyokuMapper {

    /**
     * 要介護認定判定結果一覧表の出力対象者一覧を取得します。
     *
     * @param parameter 判定結果情報出力(介護認定審査会)のMyBatisパラメータ
     * @return List<HanteiKekkaIchiranEntity>
     */
    List<HanteiKekkaIchiranA3Entity> getHanteiKekkaIchiranList(HanteiKekkaJohoShuturyokuMybatisParameter parameter);

    /**
     * 要介護認定判定結果一覧表の出力対象者一覧の総レコード数を返します。
     *
     * @param parameter 判定結果情報出力(介護認定審査会)のMyBatisパラメータ
     * @return int
     */
    int countHanteiKekkaIchiranList(HanteiKekkaJohoShuturyokuMybatisParameter parameter);

    /**
     * 要介護認定判定結果一覧表Ａ３版の出力対象者一覧を取得します。
     *
     * @param parameter 判定結果情報出力(介護認定審査会)のMyBatisパラメータ
     * @return List<HanteiKekkaIchiranA3Entity>
     */
    List<HanteiKekkaIchiranA3Entity> getHanteiKekkaIchiranA3List(HanteiKekkaJohoShuturyokuMybatisParameter parameter);

    /**
     * 要介護認定判定結果一覧表Ａ３版の総レコード数を返します。
     *
     * @param parameter 判定結果情報出力(介護認定審査会)のMyBatisパラメータ
     * @return int
     */
    int countHanteiKekkaIchiranA3List(HanteiKekkaJohoShuturyokuMybatisParameter parameter);

    /**
     * 介護認定審査判定結果（鑑）の出力対象者一覧を取得します。
     *
     * @param parameter 判定結果情報出力(介護認定審査会)のMyBatisパラメータ
     * @return DbT5511ShinsakaiKaisaiKekkaJohoEntity
     */
    DbT5511ShinsakaiKaisaiKekkaJohoEntity getShinsakaiKaisaiKekkaJoho(HanteiKekkaJohoShuturyokuMybatisParameter parameter);

    /**
     * 委員情報を取得します。
     *
     * @param parameter 判定結果情報出力(介護認定審査会)のMyBatisパラメータ
     * @return List<IinJohoRelateEntity>
     */
    List<IinJohoRelateEntity> getIinJoho(HanteiKekkaJohoShuturyokuMybatisParameter parameter);

    /**
     * 審査会情報を取得します。
     *
     * @param parameter 判定結果情報出力(介護認定審査会)のMyBatisパラメータ
     * @return ShinsakaiKaisaiKekkaJohoEntity
     */
    ShinsakaiKaisaiKekkaJohoEntity getShinsakaiJoho(HanteiKekkaJohoShuturyokuMybatisParameter parameter);

    /**
     * 未判定件数を検索します。
     *
     * @param parameter 判定結果情報出力(介護認定審査会)のMyBatisパラメータ
     * @return 未判定件数
     */
    int getMiHanteiKensu(HanteiKekkaJohoShuturyokuMybatisParameter parameter);

    /**
     * 未審査件数を検索します。
     *
     * @param parameter 判定結果情報出力(介護認定審査会)のMyBatisパラメータ
     * @return 未審査件数
     */
    int getMishinSaKensu(HanteiKekkaJohoShuturyokuMybatisParameter parameter);

    /**
     * 一次判定を変更した件数を検索します。
     *
     * @param parameter 判定結果情報出力(介護認定審査会)のMyBatisパラメータ
     * @return 一次判定を変更した件数
     */
    int getItiDoHanteiHenkoKensu(HanteiKekkaJohoShuturyokuMybatisParameter parameter);

    /**
     * 審査会意見を付した件数を検索します。
     *
     * @param parameter 判定結果情報出力(介護認定審査会)のMyBatisパラメータ
     * @return 審査会意見を付した件数
     */
    int getSinSakaiIkenTukeKensu(HanteiKekkaJohoShuturyokuMybatisParameter parameter);

    /**
     * 審査会審査結果等取得処理です。
     *
     * @param parameter 判定結果情報出力(介護認定審査会)のMyBatisパラメータ
     * @return List<ShinsakaiKekkaJohoRelateEntity>
     */
    List<ShinsakaiKekkaJohoRelateEntity> getShinsakaiKekkaJoho(HanteiKekkaJohoShuturyokuMybatisParameter parameter);

    /**
     * 要介護認定結果通知一覧表の出力対象者一覧を取得します。
     *
     * @param parameter 判定結果情報出力(介護認定審査会)のMyBatisパラメータ
     * @return List<KekkatsuchiIchiranhyoEntity>
     */
    List<KekkatsuchiIchiranhyoEntity> getKekkatsuchiIchiranList(HanteiKekkaJohoShuturyokuMybatisParameter parameter);
}
