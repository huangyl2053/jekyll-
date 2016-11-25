/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanketteitsuchishoikkatsusakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu.SelectMaxEdabanParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu.ShokanKetteiTsuchiShoIkkatsuSakuseiParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu.ShokanKetteiTsuchiShoKetteiTsuchiIchiranParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu.ShokanKetteiTsuchiShoUpdateParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu.ShokanShinseiUpdataParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanketteitsuchisho.ShokanKetteiTsuchiShoMeisaiItiranTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanketteitsuchisho.ShokanKetteiTsuchiShoMeisaiTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanketteitsuchisho.ShokanKetteiTsuchiShoTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharaiRelateEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

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
     */
    void get様式名称();

    /**
     * サービス種類を取得します。
     *
     */
    void getサービス種類();

    /**
     * サブ業務コード、市町村コード、処理名のグループ内での枝番の最大値を取得します。
     *
     * @param parameter 検索用パラメータ
     * @return DbT7022ShoriDateKanriの項目定義クラス
     */
    DbT7022ShoriDateKanriEntity get最大枝番(SelectMaxEdabanParameter parameter);

    /**
     * get償還払支給差止対象者一覧用帳票データ
     *
     * @param paramter 検索用パラメータ
     * @return 償還払支給差止対象者一覧用帳票データ
     */
    List<ShokanKetteiTsuchiShoShiharaiRelateEntity> get償還払支給差止対象者一覧用帳票データ(ShokanKetteiTsuchiShoKetteiTsuchiIchiranParameter paramter);
    
    /**
     * 通知書発行対象フラグの更新
     * @param 資格区分 資格区分
     */
    void upd通知書発行対象フラグ(@Param("資格区分") RString 資格区分);
    
    /**
     * 決定通知書明細情報一時TBL
     *
     * @param paramter 検索用パラメータ
     * @return 決定通知書明細情報一時TBL
     */
    List<ShokanKetteiTsuchiShoMeisaiItiranTempTableEntity> get決定通知書明細情報一時TBL(ShokanShinseiUpdataParameter paramter);
}
