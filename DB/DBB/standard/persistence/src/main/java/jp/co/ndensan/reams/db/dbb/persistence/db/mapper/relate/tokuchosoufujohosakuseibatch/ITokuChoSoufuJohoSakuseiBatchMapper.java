/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchosoufujohosakuseibatch;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.DeleteTokuchoKaifuJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.InsTorikomiRirekiMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.SelectChoshuHohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.SelectFukaTempJouhouMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.SelectJushochiDataMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.SelectJushochiTempDataMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.SelectKariHenkoTempMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.SelectOutputDataMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.SelectShikakuSoshitsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.SelectTokuChoIraiDataMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.SelectTokuchoTeishiDataMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.SelectTokuchoTsuikaIraiTempMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.SelectTokuchoTsuikaIraiTsuikaTempMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.SelectTsuikaDataMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchosoufujohosakuseibatch.UpdateTableMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch.FukaTempJouhouEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch.KariHenkoTsuikaDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch.ShikakuSoshitsuDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch.TokuChoIraiIchiran;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch.TokuChoIraiKensu;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch.TokuChoYidoIchiran;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch.TokuChoYidoKensu;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch.TokuchoIraiDataEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch.TokuchoIraiInsertDataEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * DBB-1840-040バッチ設計_DBBBT82001_特徴送付情報作成のMapperクラスです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
public interface ITokuChoSoufuJohoSakuseiBatchMapper {

    /**
     * 年金特徴回付情報を削除です。
     *
     * @param parameter DeleteTokuchoKaifuJohoMyBatisParameter
     */
    void 年金特徴回付情報削除(DeleteTokuchoKaifuJohoMyBatisParameter parameter);

    /**
     * 特徴依頼のデータを取得です。
     *
     * @param parameter SelectTokuChoIraiDataMyBatisParameter
     * @return List<TokuchoIraiDataEntity>
     */
    List<TokuchoIraiDataEntity> 特徴依頼のデータを取得(SelectTokuChoIraiDataMyBatisParameter parameter);

    /**
     * 特徴依頼追加一時表による徴収方法情報を取得です。
     *
     * @return List<DbT2001ChoshuHohoEntity>
     */
    List<DbT2001ChoshuHohoEntity> get特徴依頼追加一時表による徴収方法情報();

    /**
     * 介護特別徴収情報のMAX連番を取得です。
     *
     * @return Integer
     */
    Integer getMAX連番();

    /**
     * 介護特別徴収情報取込履歴の登録です。
     *
     * @param parameter InsTorikomiRirekiMyBatisParameter
     */
    void 介護特別徴収情報取込履歴の登録(InsTorikomiRirekiMyBatisParameter parameter);

    /**
     * 介護保険年金特徴対象者情報追加用データを抽出する。
     *
     * @return List<TokuchoIraiInsertDataEntity>
     */
    List<TokuchoIraiInsertDataEntity> get対象者情報追加用データ();

    /**
     * 特徴依頼情報一覧表の発行する。
     *
     * @param parameter SelectOutputDataMyBatisParameter
     * @return List<TokuChoIraiIchiran>
     */
    List<TokuChoIraiIchiran> get依頼情報出力対象データ(SelectOutputDataMyBatisParameter parameter);

    /**
     * 特徴依頼情報一覧表の発行する。
     *
     * @return List<TokuChoIraiKensu>
     */
    List<TokuChoIraiKensu> get依頼情報件数表出力対象データ();

    /**
     * 資格喪失等データ抽出する。
     *
     * @param parameter SelectTokuchoTeishiDataMyBatisParameter
     * @return List<DbT2001ChoshuHohoEntity>
     */
    List<DbT2001ChoshuHohoEntity> get特徴停止のデータ(SelectTokuchoTeishiDataMyBatisParameter parameter);

    /**
     * （資格喪失等）追加用データ作成する。
     *
     * @param parameter SelectShikakuSoshitsuMyBatisParameter
     * @return List<ShikakuSoshitsuDataEntity>
     */
    List<ShikakuSoshitsuDataEntity> get年金特徴回付情報追加用データ(SelectShikakuSoshitsuMyBatisParameter parameter);

    /**
     * 住所地特例該当データ抽出する。
     *
     * @param parameter SelectJushochiTempDataMyBatisParameter
     * @return List<DbT1001HihokenshaDaichoEntity>
     */
    List<DbT1001HihokenshaDaichoEntity> get住所地特例該当データ(SelectJushochiTempDataMyBatisParameter parameter);

    /**
     * （住所地特例該当）追加用データ作成する。
     *
     * @param parameter SelectJushochiDataMyBatisParameter
     * @return List<ShikakuSoshitsuDataEntity>
     */
    List<ShikakuSoshitsuDataEntity> get住所地特例該当追加情報用データ(SelectJushochiDataMyBatisParameter parameter);

    /**
     * 最新の賦課の情報を取得する。
     *
     * @param parameter SelectFukaTempJouhouMyBatisParameter
     * @return List<FukaTempJouhouEntity>
     */
    List<FukaTempJouhouEntity> get最新の賦課の情報(SelectFukaTempJouhouMyBatisParameter parameter);

    /**
     * 仮徴収額変更の賦課情報の取得する。
     *
     * @param parameter SelectKariHenkoTempMyBatisParameter
     * @return List<DbT2002FukaJohoTempTableEntity>
     */
    List<DbT2002FukaJohoTempTableEntity> get仮徴収額変更の賦課情報(SelectKariHenkoTempMyBatisParameter parameter);

    /**
     * （仮徴収額変更）追加用データ作成する。
     *
     * @param parameter SelectTsuikaDataMyBatisParameter
     * @return List<KariHenkoTsuikaDataEntity>
     */
    List<KariHenkoTsuikaDataEntity> get仮徴収額変更追加用データ(SelectTsuikaDataMyBatisParameter parameter);

    /**
     * 特徴追加依頼データ抽出する。
     *
     * @param parameter SelectTokuchoTsuikaIraiTempMyBatisParameter
     * @return List<UeT0511NenkinTokuchoKaifuJohoEntity>
     */
    List<UeT0511NenkinTokuchoKaifuJohoEntity> get特徴追加依頼データ(SelectTokuchoTsuikaIraiTempMyBatisParameter parameter);

    /**
     * （特徴追加依頼）追加用データ作成する。
     *
     * @param parameter SelectTokuchoTsuikaIraiTsuikaTempMyBatisParameter
     * @return List<ShikakuSoshitsuDataEntity>
     */
    List<ShikakuSoshitsuDataEntity> get特徴追加依頼追加用データ(SelectTokuchoTsuikaIraiTsuikaTempMyBatisParameter parameter);

    /**
     * 特徴異動追加Tempの追加用データ(入力．処理対象月が4月、6月の場合)作成する。
     *
     * @return List<UeT0511NenkinTokuchoKaifuJohoEntity>
     */
    List<UeT0511NenkinTokuchoKaifuJohoEntity> get追加用データ_4月_6月();

    /**
     * 特徴異動追加Tempの追加用データ(入力．処理対象月が5月の場合)作成する。
     *
     * @return List<UeT0511NenkinTokuchoKaifuJohoEntity>
     */
    List<UeT0511NenkinTokuchoKaifuJohoEntity> get追加用データ_5月();

    /**
     * 特徴異動追加Tempの追加用データ(入力．処理対象月が8月、9月、11月、1月、3月の場合)作成する。
     *
     * @return List<UeT0511NenkinTokuchoKaifuJohoEntity>
     */
    List<UeT0511NenkinTokuchoKaifuJohoEntity> get追加用データ_8_9_11_1_3月();

    /**
     * 特徴異動追加Tempの追加用データ(入力．処理対象月が10月、12月、2月の場合)作成する。
     *
     * @return List<UeT0511NenkinTokuchoKaifuJohoEntity>
     */
    List<UeT0511NenkinTokuchoKaifuJohoEntity> get追加用データ_10_12_2月();

    /**
     * （特徴異動）徴収方法の追加する。
     *
     * @param parameter SelectChoshuHohoMyBatisParameter
     * @return List<DbT2001ChoshuHohoEntity>
     */
    List<DbT2001ChoshuHohoEntity> get特徴異動_徴収方法の追加情報(SelectChoshuHohoMyBatisParameter parameter);

    /**
     * （特徴異動）年金特徴対象者情報の登録する。
     *
     * @return List<TokuchoIraiInsertDataEntity>
     */
    List<TokuchoIraiInsertDataEntity> get対象者情報追加用データ_特徴異動();

    /**
     * 特別徴収異動情報一覧表の発行する。
     *
     * @param parameter SelectOutputDataMyBatisParameter
     * @return List<TokuChoYidoIchiran>
     */
    List<TokuChoYidoIchiran> get異動情報出力対象データ(SelectOutputDataMyBatisParameter parameter);

    /**
     * 特徴異動情報一覧表の発行する。
     *
     * @return List<TokuChoYidoKensu>
     */
    List<TokuChoYidoKensu> get異動情報件数表出力対象データ();

    /**
     * 処理日付管理テーブル更新する。
     *
     * @param parameter UpdateTableMyBatisParameter
     */
    void 処理日付管理テーブル更新(UpdateTableMyBatisParameter parameter);

    /**
     * 処理日付管理テーブルから基準日時を取得する。
     *
     * @param parameter UpdateTableMyBatisParameter
     * @return YMDHMS 基準日時
     */
    YMDHMS get基準日時(UpdateTableMyBatisParameter parameter);

}
