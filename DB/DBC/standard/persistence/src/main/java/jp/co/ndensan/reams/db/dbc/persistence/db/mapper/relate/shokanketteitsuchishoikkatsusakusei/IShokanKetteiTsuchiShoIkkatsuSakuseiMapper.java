/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanketteitsuchishoikkatsusakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu.SelectMaxEdabanParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu.ShokanKetteiTsuchiShoIkkatsuSakuseiParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu.ShokanKetteiTsuchiShoUpdateParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanketteitsuchisho.ShokanKetteiTsuchiShoMeisaiTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanketteitsuchisho.ShokanKetteiTsuchiShoTempTableEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * 償還払い支給（不支給）決定通知書一括作成のマッパーインタフェースです。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
public interface IShokanKetteiTsuchiShoIkkatsuSakuseiMapper {

    /**
     * 償還払い支給（不支給）決定通知書情報一時リストを取得します。
     *
     * @param parameter 決定通知書情報取得パラメータ
     * @return 償還払い支給（不支給）決定通知書情報一時リスト
     */
    List<ShokanKetteiTsuchiShoTempTableEntity> get決定通知書情報(ShokanKetteiTsuchiShoIkkatsuSakuseiParameter parameter);

    /**
     * 償還払い支給（不支給）決定通知書情報一時詳細リストを取得します。
     *
     * @param parameter 決定通知書情報取得パラメータ
     * @return 償還払い支給（不支給）決定通知書情報一時詳細リスト
     */
    List<ShokanKetteiTsuchiShoMeisaiTempTableEntity> get決定通知書明細情報(ShokanKetteiTsuchiShoIkkatsuSakuseiParameter parameter);

    /**
     * 金融機関と預金種別を取得します。
     *
     * @param sysData システム年月日
     * @return List<ShokanKetteiTsuchiShoMeisaiTempTableEntity>
     */
    List<ShokanKetteiTsuchiShoMeisaiTempTableEntity> get金融機関と預金種別(ShokanKetteiTsuchiShoUpdateParameter sysData);

    /**
     * 支店名称を取得します。
     *
     * @param sysData システム年月日
     * @return List<ShokanKetteiTsuchiShoMeisaiTempTableEntity>
     */
    List<ShokanKetteiTsuchiShoMeisaiTempTableEntity> get支店名称(ShokanKetteiTsuchiShoUpdateParameter sysData);

    /**
     * 様式名称を取得します。
     *
     * @return List<ShokanKetteiTsuchiShoMeisaiTempTableEntity>
     */
    List<ShokanKetteiTsuchiShoMeisaiTempTableEntity> get様式名称();

    /**
     * サービス種類を取得します。
     *
     * @return List<ShokanKetteiTsuchiShoMeisaiTempTableEntity>
     */
    List<ShokanKetteiTsuchiShoMeisaiTempTableEntity> getサービス種類();

    /**
     * サブ業務コード、市町村コード、処理名のグループ内での枝番の最大値を取得します。
     *
     * @param parameter 検索用パラメータ
     * @return DbT7022ShoriDateKanriの項目定義クラス
     */
    DbT7022ShoriDateKanriEntity get最大枝番(SelectMaxEdabanParameter parameter);
}
