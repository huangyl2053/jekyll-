/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.servicekeikakuHi;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3045ShokanServicePlan200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3046ShokanServicePlan200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3047ShokanServicePlan200904Entity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 */
public class ServiceKeikakuHiRealtEntity {

    private final DbT3047ShokanServicePlan200904Entity entity200904;
    private final DbT3046ShokanServicePlan200604Entity entity200604;
    private final DbT3045ShokanServicePlan200004Entity entity200004;

    /**
     * コンストラクタです。
     *
     * @param entity200904 DbT3047ShokanServicePlan200904Entity
     * @param entity200604 DbT3046ShokanServicePlan200604Entity
     * @param entity200004 DbT3045ShokanServicePlan200004Entity
     */
    public ServiceKeikakuHiRealtEntity(
            DbT3047ShokanServicePlan200904Entity entity200904,
            DbT3046ShokanServicePlan200604Entity entity200604,
            DbT3045ShokanServicePlan200004Entity entity200004) {
        this.entity200904 = entity200904;
        this.entity200604 = entity200604;
        this.entity200004 = entity200004;
    }
    // TODO 凌護行 事業者区分コードがない、QA回答まち、
//    public XXX get事業者区分コード() {
//        return entity200904.getXXX();
//    }
    // TODO 凌護行 審査方法がない、QA回答まち、
//    public XXX get審査方法() {
//    return entity200904.getXXX();
//    }
    // TODO 凌護行 担当介護支給専門員番号がない、QA回答まち、
//    public XXX get担当介護支給専門員番号() {
//    return entity200904.get担当介護支給専門員番号();
//    }
    /**
     * 単位数単価を取得します。
     *
     * @return 単位数単価
     */
    public Decimal get単位数単価() {
        return entity200904.getTanisuTanka();
    }

    /**
     * サービスコードを取得します。
     *
     * @return サービスコード
     */
    public ServiceCode getサービスコード() {
        return entity200904.getServiceCode();
    }

    // TODO 凌護行 サービス名称がない
//    public XXX get名称() {
//    return
//    }
    /**
     * 単位数を取得します。
     *
     * @return 単位数
     */
    public int get単位数() {
        return entity200904.getTanisu();
    }

    /**
     * 回数を取得します。
     *
     * @return 回数
     */
    public int get回数() {
        return entity200904.getKaisu();
    }

    /**
     * 連番を取得します。
     *
     * @return 連番
     */
    public RString get連番() {
        return entity200904.getRenban();
    }

    /**
     * サービス単位数を取得します。
     *
     * @return サービス単位数
     */
    public int getサービス単位数() {
        return entity200904.getServiceTanisu();
    }

    /**
     * 摘要を取得します。
     *
     * @return 摘要
     */
    public RString get摘要() {
        return entity200904.getTekiyo();
    }

    /**
     * 審査年月を取得します。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get審査年月() {
        return entity200904.getShinsaYM();
    }

    /**
     * 支給区分を取得します。
     *
     * @return 支給区分
     */
    public RString get支給区分() {
        return entity200904.getShikyuKubunCode();
    }

    /**
     * 支払金額を取得します。
     *
     * @return 支払金額
     */
    public int get支払金額() {
        return entity200904.getShikyuKingaku();
    }

    /**
     * 増減点を取得します。
     *
     * @return 増減点
     */
    public int get増減点() {
        return entity200904.getZougenTen();
    }

    /**
     * 備考1を取得します。
     *
     * @return 備考1
     */
    public RString get備考1() {
        return entity200904.getZougenRiyu();
    }

    /**
     * 備考2を取得します。
     *
     * @return 備考2
     */
    public RString get備考2() {
        return entity200904.getFushikyuRiyu();
    }

    /**
     * 備考3を取得します。
     *
     * @return 備考3
     */
    public RString get備考3() {
        return entity200904.getKounyuKaishuRireki();
    }

    /**
     * 指定_基準該当事業者区分コードを取得します。
     *
     * @return 指定_基準該当事業者区分コード
     */
    public RString get指定_基準該当事業者区分コード200604() {
        return entity200604.getShiteiKijunGaitoJigyoshaKubunCode();
    }

    // TODO 凌護行 届出日がない、QA回答まち、
//    public get届出日() {
//    return entity200604.getxxx();
//    }
    // TODO 凌護行 審査方法がない、QA回答まち、
//    public RString get審査方法200604() {
//    return entity200604.getShiteiKijunGaitoJigyoshaKubunCode();
//    }
    /**
     * サービスコードを取得します。
     *
     * @return サービスコード
     */
    public ServiceCode getサービスコード200604() {
        return entity200604.getServiceCode();
    }

    // TODO 凌護行 サービス名称がない
//                public RString getサービス名称200604() {
//    return entity200604.getXXX();
//    }
    /**
     * 単位数を取得します。
     *
     * @return 単位数
     */
    public int get単位数200604() {
        return entity200604.getTanisu();
    }

    /**
     * 単位数単価を取得します。
     *
     * @return 単位数単価
     */
    public Decimal get単位数単価200604() {
        return entity200604.getTanisuTanka();
    }

    /**
     * 請求金額を取得します。
     *
     * @return 請求金額
     */
    public int get請求金額200604() {
        return entity200604.getSeikyuKingaku();
    }

    /**
     * 担当介護支援専門員番号を取得します。
     *
     * @return 担当介護支援専門員番号
     */
    public RString get担当介護支援専門員番号200604() {
        return entity200604.getTantokangoshienSemmoninNo();
    }

    /**
     * 摘要を取得します。
     *
     * @return 摘要
     */
    public RString get摘要200604() {
        return entity200604.getTekiyo();
    }

    /**
     * 審査年月を取得します。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get審査年月200604() {
        return entity200604.getShinsaYM();
    }

    /**
     * 支給区分を取得します。
     *
     * @return 支給区分
     */
    public RString get支給区分200604() {
        return entity200604.getShikyuKubunCode();
    }

    /**
     * サービス単位を取得します。
     *
     * @return サービス単位
     */
    public int getサービス単位200604() {
        return entity200604.getTanisu();
    }

    /**
     * 支払金額を取得します。
     *
     * @return 支払金額
     */
    public int get支払金額200604() {
        return entity200604.getShikyuKingaku();
    }

    /**
     * 増減点を取得します。
     *
     * @return 増減点
     */
    public int get増減点200604() {
        return entity200604.getZougenTen();
    }

    /**
     * 備考1を取得します。
     *
     * @return 備考1
     */
    public RString get備考1200604() {
        return entity200604.getZougenRiyu();
    }

    /**
     * 備考2を取得します。
     *
     * @return 備考2
     */
    public RString get備考2200604() {
        return entity200604.getFushikyuRiyu();
    }

    /**
     * 備考3を取得します。
     *
     * @return 備考3
     */
    public RString get備考3200604() {
        return entity200604.getKounyuKaishuRireki();
    }

    // TODO 凌護行 届出日がない、QA回答まち、
//    public get届出日() {
//    return entity200004.getxxx();
//    }
    // TODO 凌護行 審査方法がない、QA回答まち、
//    public RString get審査方法200004() {
//    return entity200004.getShiteiKijunGaitoJigyoshaKubunCode();
//    }
    /**
     * サービスコードを取得します。
     *
     * @return サービスコード
     */
    public ServiceCode getサービスコード200004() {
        return entity200004.getServiceCode();
    }

    // TODO 凌護行 サービス名称がない
//                public RString getサービス名称200004() {
//    return entity200004.getXXX();
//    }
    /**
     * 単位数を取得します。
     *
     * @return 単位数
     */
    public int get単位数200004() {
        return entity200004.getTanisu();
    }

    /**
     * 単位数単価を取得します。
     *
     * @return 単位数単価
     */
    public Decimal get単位数単価200004() {
        return entity200004.getTanisuTanka();
    }

    /**
     * 請求金額を取得します。
     *
     * @return 請求金額
     */
    public int get請求金額200004() {
        return entity200004.getSeikyuKingaku();
    }

    /**
     * 審査年月を取得します。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get審査年月200004() {
        return entity200004.getShinsaYM();
    }

    /**
     * 支給区分を取得します。
     *
     * @return 支給区分
     */
    public RString get支給区分200004() {
        return entity200004.getShikyuKubunCode();
    }

    /**
     * 支払金額を取得します。
     *
     * @return 支払金額
     */
    public int get支払金額200004() {
        return entity200004.getShikyuKingaku();
    }

    /**
     * 増減点を取得します。
     *
     * @return 増減点
     */
    public int get増減点200004() {
        return entity200004.getZougenTen();
    }

    /**
     * 備考1を取得します。
     *
     * @return 備考1
     */
    public RString get備考1200004() {
        return entity200004.getZougenRiyu();
    }

    /**
     * 備考2を取得します。
     *
     * @return 備考2
     */
    public RString get備考2200004() {
        return entity200004.getFushikyuRiyu();
    }

    /**
     * 備考3を取得します。
     *
     * @return 備考3
     */
    public RString get備考3200004() {
        return entity200004.getKounyuKaishuRireki();
    }
}
