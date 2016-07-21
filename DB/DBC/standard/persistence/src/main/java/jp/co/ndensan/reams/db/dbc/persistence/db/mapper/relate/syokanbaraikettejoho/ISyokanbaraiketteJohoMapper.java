/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.syokanbaraikettejoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.syokanbaraikettejoho.SyokanbaraiketteJohoMapperParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.syokanbaraikettejoho.SyokanbaraiketteJohoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraiketejoho.SyokanbaraiketeJohoDekidakaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraiketejoho.SyokanbaraiketeJohoEntity;

/**
 * 償還払決定一覧情報を取得するマッパーインタフェースです。
 *
 * @reamsid_L DBC-0950-010 zuotao
 */
public interface ISyokanbaraiketteJohoMapper {

    /**
     * 被保険者番号、サービス提供年月、整理番号より、福祉用具販売費に関する償還払決定一覧取得を取得します。
     *
     * @param 福祉検索条件 償還払決定一覧取得（償還払い費）検索条件
     * @return 償還払決定一覧情報
     */
    List<SyokanbaraiketeJohoEntity> getSyokanbaraiketteFukushiList(SyokanbaraiketteJohoParameter 福祉検索条件);

    /**
     * 被保険者番号、サービス提供年月、整理番号より、住宅改修費に関する償還払決定一覧取得を取得します。
     *
     * @param 住宅改修費検索条件 償還払決定一覧取得（住宅改修費）検索条件
     * @return 償還払決定一覧情報
     */
    List<SyokanbaraiketeJohoEntity> getSyokanbaraiketteJyutakuList(SyokanbaraiketteJohoParameter 住宅改修費検索条件);

    /**
     * 集計情報決定データを取得します。
     *
     * @param param 集計情報決定データ取得検索条件
     * @return 集計情報決定データ
     */
    List<SyokanbaraiketeJohoDekidakaEntity> get集計情報決定データ(SyokanbaraiketteJohoParameter param);

    /**
     * サービス計画費を取得します。
     *
     * @param param サービス計画費取得検索条件
     * @return 償還払決定一覧
     */
    List<SyokanbaraiketeJohoEntity> get償還払決定一覧(SyokanbaraiketteJohoMapperParameter param);
}
