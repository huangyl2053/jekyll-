/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.servicekeikakuHi;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanServicePlan200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanServicePlan200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanServicePlan200904Entity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 */
public class ServiceKeikakuHiRealtEntity {

    private final ShokanServicePlan200904Entity entity200904;
    private final ShokanServicePlan200604Entity entity200604;
    private final ShokanServicePlan200004Entity entity200004;

    /**
     * コンストラクタです。
     *
     * @param entity200904 ShokanServicePlan200904Entity
     * @param entity200604 ShokanServicePlan200604Entity
     * @param entity200004 ShokanServicePlan200004Entity
     */
    public ServiceKeikakuHiRealtEntity(
            ShokanServicePlan200904Entity entity200904,
            ShokanServicePlan200604Entity entity200604,
            ShokanServicePlan200004Entity entity200004) {
        this.entity200904 = entity200904;
        this.entity200604 = entity200604;
        this.entity200004 = entity200004;
    }

    /**
     * 指定_基準該当事業者区分コードを取得します。
     *
     * @return 指定_基準該当事業者区分コード
     */
    public RString get指定_基準該当事業者区分コード200904() {
        return entity200904.getEntity().getShiteiKijunGaitoJigyoshaKubunCode();
    }
    
    /**
     * 審査方法区分コードを取得します。
     *
     * @return 審査方法区分コード
     */
    public RString get審査方法区分コード() {
        return entity200904.getEntity().getShinsaHohoKubunCode();
    }
    
   /**
     * 担当介護支給専門員番号を取得します。
     *
     * @return 担当介護支給専門員番号
     */ 
    public RString get担当介護支給専門員番号() {
        return entity200904.getEntity().getTantokangoshienSemmoninNo();
    }

    /**
     * 届出日を取得します。
     *
     * @return 届出日
     */
    public FlexibleDate get届出日200904() {
        return entity200904.getEntity().getKyotakuServiceSakuseiIraiYMD();
    }

    /**
     * 償還払請求サービス計画200004を取得します。
     *
     * @return 償還払請求サービス計画200004
     */
    public ShokanServicePlan200004Entity get償還払請求サービス計画200004() {
        return entity200004;
    }

    /**
     * 償還払請求サービス計画200604を取得します。
     *
     * @return 償還払請求サービス計画200604
     */
    public ShokanServicePlan200604Entity get償還払請求サービス計画200604() {
        return entity200604;
    }

    /**
     * 償還払請求サービス計画200904を取得します。
     *
     * @return 償還払請求サービス計画200904
     */
    public ShokanServicePlan200904Entity get償還払請求サービス計画200904() {
        return entity200904;
    }

    /**
     * 単位数単価を取得します。
     *
     * @return 単位数単価
     */
    public Decimal get単位数単価() {
        return entity200904.getEntity().getTanisuTanka();
    }

    /**
     * サービスコードを取得します。
     *
     * @return サービスコード
     */
    public ServiceCode getサービスコード() {
        return entity200904.getEntity().getServiceCode();
    }

    /**
     * サービス名称を取得します。
     *
     * @return サービス名称
     */
    public RString getサービス名称200904() {
        return entity200904.getServiceName();
    }

    /**
     * 単位数を取得します。
     *
     * @return 単位数
     */
    public int get単位数() {
        return entity200904.getEntity().getTanisu();
    }

    /**
     * 回数を取得します。
     *
     * @return 回数
     */
    public int get回数() {
        return entity200904.getEntity().getKaisu();
    }

    /**
     * 連番を取得します。
     *
     * @return 連番
     */
    public RString get連番() {
        return entity200904.getEntity().getRenban();
    }

    /**
     * サービス単位数を取得します。
     *
     * @return サービス単位数
     */
    public int getサービス単位数() {
        return entity200904.getEntity().getServiceTanisu();
    }

    /**
     * 摘要を取得します。
     *
     * @return 摘要
     */
    public RString get摘要() {
        return entity200904.getEntity().getTekiyo();
    }

    /**
     * 審査年月を取得します。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get審査年月() {
        return entity200904.getEntity().getShinsaYM();
    }

    /**
     * 支給区分を取得します。
     *
     * @return 支給区分
     */
    public RString get支給区分() {
        return entity200904.getEntity().getShikyuKubunCode();
    }

    /**
     * 支払金額を取得します。
     *
     * @return 支払金額
     */
    public int get支払金額() {
        return entity200904.getEntity().getShikyuKingaku();
    }

    /**
     * 増減点を取得します。
     *
     * @return 増減点
     */
    public int get増減点() {
        return entity200904.getEntity().getZougenTen();
    }

    /**
     * 備考1を取得します。
     *
     * @return 備考1
     */
    public RString get備考1() {
        return entity200904.getEntity().getZougenRiyu();
    }

    /**
     * 備考2を取得します。
     *
     * @return 備考2
     */
    public RString get備考2() {
        return entity200904.getEntity().getFushikyuRiyu();
    }

    /**
     * 備考3を取得します。
     *
     * @return 備考3
     */
    public RString get備考3() {
        return entity200904.getEntity().getKounyuKaishuRireki();
    }

    /**
     * 指定_基準該当事業者区分コードを取得します。
     *
     * @return 指定_基準該当事業者区分コード
     */
    public RString get指定_基準該当事業者区分コード200604() {
        return entity200604.getEntity().getShiteiKijunGaitoJigyoshaKubunCode();
    }

    /**
     * 届出日を取得します。
     *
     * @return 届出日
     */
    public FlexibleDate get届出日200604() {
        return entity200604.getEntity().getKyotakuServiceSakuseiIraiYMD();
    }

    /**
     * 審査方法を取得します。
     *
     * @return 審査方法
     */
    public RString get審査方法200604() {
        return entity200604.getEntity().getShinsaHohoKubunCode();
    }

    /**
     * サービスコードを取得します。
     *
     * @return サービスコード
     */
    public ServiceCode getサービスコード200604() {
        return entity200604.getEntity().getServiceCode();
    }

    /**
     * サービス名称を取得します。
     *
     * @return サービス名称
     */
    public RString getサービス名称200604() {
        return entity200604.getServiceName();
    }
    /**
     * 単位数を取得します。
     *
     * @return 単位数
     */
    public int get単位数200604() {
        return entity200604.getEntity().getTanisu();
    }

    /**
     * 単位数単価を取得します。
     *
     * @return 単位数単価
     */
    public Decimal get単位数単価200604() {
        return entity200604.getEntity().getTanisuTanka();
    }

    /**
     * 請求金額を取得します。
     *
     * @return 請求金額
     */
    public int get請求金額200604() {
        return entity200604.getEntity().getSeikyuKingaku();
    }

    /**
     * 担当介護支援専門員番号を取得します。
     *
     * @return 担当介護支援専門員番号
     */
    public RString get担当介護支援専門員番号200604() {
        return entity200604.getEntity().getTantokangoshienSemmoninNo();
    }

    /**
     * 摘要を取得します。
     *
     * @return 摘要
     */
    public RString get摘要200604() {
        return entity200604.getEntity().getTekiyo();
    }

    /**
     * 審査年月を取得します。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get審査年月200604() {
        return entity200604.getEntity().getShinsaYM();
    }

    /**
     * 支給区分を取得します。
     *
     * @return 支給区分
     */
    public RString get支給区分200604() {
        return entity200604.getEntity().getShikyuKubunCode();
    }

    /**
     * サービス単位を取得します。
     *
     * @return サービス単位
     */
//    public int getサービス単位200604() {
//        return entity200604.getEntity().getServiceTanisu();
//    }

    /**
     * 支払金額を取得します。
     *
     * @return 支払金額
     */
    public int get支払金額200604() {
        return entity200604.getEntity().getShikyuKingaku();
    }

    /**
     * 増減点を取得します。
     *
     * @return 増減点
     */
    public int get増減点200604() {
        return entity200604.getEntity().getZougenTen();
    }

    /**
     * 備考1を取得します。
     *
     * @return 備考1
     */
    public RString get備考1200604() {
        return entity200604.getEntity().getZougenRiyu();
    }

    /**
     * 備考2を取得します。
     *
     * @return 備考2
     */
    public RString get備考2200604() {
        return entity200604.getEntity().getFushikyuRiyu();
    }

    /**
     * 備考3を取得します。
     *
     * @return 備考3
     */
    public RString get備考3200604() {
        return entity200604.getEntity().getKounyuKaishuRireki();
    }

    /**
     * 届出日
     *
     * @return 届出日
     */
    public FlexibleDate get届出日200004() {
        return entity200004.getEntity().getKyotakuServiceSakuseiIraiYMD();
    }

    /**
     * 指定_基準該当事業者区分コードを取得します。
     *
     * @return 指定_基準該当事業者区分コード
     */
    public RString get指定_基準該当事業者区分コード200004() {
        return entity200004.getEntity().getShiteiKijunGaitoJigyoshaKubunCode();
    }
 
     /**
     * 審査方法
     *
     * @return 審査方法
     */
    public RString get審査方法200004() {
        return entity200004.getEntity().getShinsaHohoKubunCode();
    }

    /**
     * サービスコードを取得します。
     *
     * @return サービスコード
     */
    public ServiceCode getサービスコード200004() {
        return entity200004.getEntity().getServiceCode();
    }

    /**
     * サービス名称を取得します。
     *
     * @return サービス名称
     */
    public RString getサービス名称200004() {
        return entity200004.getServiceName();
    }
    /**
     * 単位数を取得します。
     *
     * @return 単位数
     */
    public int get単位数200004() {
        return entity200004.getEntity().getTanisu();
    }

    /**
     * 単位数単価を取得します。
     *
     * @return 単位数単価
     */
    public Decimal get単位数単価200004() {
        return entity200004.getEntity().getTanisuTanka();
    }

    /**
     * 請求金額を取得します。
     *
     * @return 請求金額
     */
    public int get請求金額200004() {
        return entity200004.getEntity().getSeikyuKingaku();
    }

    /**
     * 審査年月を取得します。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get審査年月200004() {
        return entity200004.getEntity().getShinsaYM();
    }

    /**
     * 支給区分を取得します。
     *
     * @return 支給区分
     */
    public RString get支給区分200004() {
        return entity200004.getEntity().getShikyuKubunCode();
    }

    /**
     * 支払金額を取得します。
     *
     * @return 支払金額
     */
    public int get支払金額200004() {
        return entity200004.getEntity().getShikyuKingaku();
    }

    /**
     * 増減点を取得します。
     *
     * @return 増減点
     */
    public int get増減点200004() {
        return entity200004.getEntity().getZougenTen();
    }

    /**
     * 備考1を取得します。
     *
     * @return 備考1
     */
    public RString get備考1200004() {
        return entity200004.getEntity().getZougenRiyu();
    }

    /**
     * 備考2を取得します。
     *
     * @return 備考2
     */
    public RString get備考2200004() {
        return entity200004.getEntity().getFushikyuRiyu();
    }

    /**
     * 備考3を取得します。
     *
     * @return 備考3
     */
    public RString get備考3200004() {
        return entity200004.getEntity().getKounyuKaishuRireki();
    }
}
