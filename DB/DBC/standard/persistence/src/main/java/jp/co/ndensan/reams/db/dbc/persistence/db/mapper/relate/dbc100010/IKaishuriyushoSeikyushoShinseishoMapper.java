package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc100010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc100010.KaishuriyushoSeikyushoShinseishoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010.ChouhyouShuturyokuYouDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010.KaishuriyushoSeikyushoShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010.SeikyuMeisaiItiziDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010.SeikyuShukeiItiziDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010.TempSeikyuMeisaiItiziDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010.TempSeikyuShukeiItiziDataEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 住宅改修理由書作成手数料請求書兼申請書作成データ取得
 *
 * @reamsid_L DBC-2860-030 suguangjun
 */
public interface IKaishuriyushoSeikyushoShinseishoMapper {

    /**
     * 請求明細一時データを取得する。
     *
     * @param parameter KaishuriyushoSeikyushoShinseishoMybatisParameter
     * @return List<KaishuriyushoSeikyushoShinseishoEntity>
     */
    List<KaishuriyushoSeikyushoShinseishoEntity> get請求明細一時データ(KaishuriyushoSeikyushoShinseishoMybatisParameter parameter);

    /**
     * 請求明細データを取得する。
     *
     * @param parameter KaishuriyushoSeikyushoShinseishoMybatisParameter
     * @return List<SeikyuMeisaiItiziRelateEntity>
     */
    List<SeikyuMeisaiItiziDataEntity> get請求明細データ(KaishuriyushoSeikyushoShinseishoMybatisParameter parameter);

    /**
     * 採番件数を取得する。
     *
     * @return int
     */
    int select採番件数();

    /**
     * 請求集計一時データを取得する。
     *
     * @return List<SeikyuShukeiItiziDataEntity>
     */
    List<SeikyuShukeiItiziDataEntity> get請求集計一時用データ();

    /**
     * 帳票出力用データを取得する。
     *
     * @return List<SeikyuShukeiItiziDataEntity>
     */
    List<ChouhyouShuturyokuYouDataEntity> get帳票出力用データ();

    /**
     * 住宅改修理由書作成手数料請求明細の登録データを取得する。
     *
     * @return List<TempSeikyuMeisaiItiziDataEntity>
     */
    List<TempSeikyuMeisaiItiziDataEntity> get請求明細一時出力データ();

    /**
     * 住宅改修理由書作成手数料請求集計の登データを取得する。
     *
     * @return List<TempSeikyuShukeiItiziDataEntity>
     */
    List<TempSeikyuShukeiItiziDataEntity> get請求集計一時出力データ();

    /**
     * 処理日付管理マスタを取得する。
     *
     * @param parameter 処理日付管理マスタデータ
     * @return List<DbT7022ShoriDateKanriEntity>
     */
    List<DbT7022ShoriDateKanriEntity> get処理日付管理マスタデータ(KaishuriyushoSeikyushoShinseishoMybatisParameter parameter);
}
