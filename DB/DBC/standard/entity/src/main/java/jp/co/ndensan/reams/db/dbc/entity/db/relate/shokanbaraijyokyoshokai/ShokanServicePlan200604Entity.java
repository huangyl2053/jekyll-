/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3046ShokanServicePlan200604Entity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * サービス提供証明書のオブジェクトクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanServicePlan200604Entity implements Cloneable, Serializable {

    private DbT3046ShokanServicePlan200604Entity entity;
    private RString serviceName;

    /**
     * 指定_基準該当事業者区分コードを取得します。
     *
     * @return 指定_基準該当事業者区分コード
     */
    public RString get指定_基準該当事業者区分コード200604() {
        return entity.getShiteiKijunGaitoJigyoshaKubunCode();
    }

    /**
     * 届出日を取得します。
     *
     * @return 届出日
     */
    public FlexibleDate get届出日200604() {
        return entity.getKyotakuServiceSakuseiIraiYMD();
    }

    /**
     * 審査方法を取得します。
     *
     * @return 審査方法
     */
    public RString get審査方法200604() {
        return entity.getShinsaHohoKubunCode();
    }

    /**
     * サービスコードを取得します。
     *
     * @return サービスコード
     */
    public ServiceCode getサービスコード200604() {
        return entity.getServiceCode();
    }

    /**
     * 単位数を取得します。
     *
     * @return 単位数
     */
    public int get単位数200604() {
        return entity.getTanisu();
    }

    /**
     * 単位数単価を取得します。
     *
     * @return 単位数単価
     */
    public Decimal get単位数単価200604() {
        return entity.getTanisuTanka();
    }

    /**
     * 請求金額を取得します。
     *
     * @return 請求金額
     */
    public int get請求金額200604() {
        return entity.getSeikyuKingaku();
    }

    /**
     * 担当介護支援専門員番号を取得します。
     *
     * @return 担当介護支援専門員番号
     */
    public RString get担当介護支援専門員番号200604() {
        return entity.getTantokangoshienSemmoninNo();
    }

    /**
     * 摘要を取得します。
     *
     * @return 摘要
     */
    public RString get摘要200604() {
        return entity.getTekiyo();
    }

    /**
     * 審査年月を取得します。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get審査年月200604() {
        return entity.getShinsaYM();
    }

    /**
     * 支給区分を取得します。
     *
     * @return 支給区分
     */
    public RString get支給区分200604() {
        return entity.getShikyuKubunCode();
    }

    /**
     * サービス単位を取得します。
     *
     * @return サービス単位
     */
//    public int getサービス単位200604() {
//        return entity.getServiceTanisu();
//    }
    /**
     * 支払金額を取得します。
     *
     * @return 支払金額
     */
    public int get支払金額200604() {
        return entity.getShikyuKingaku();
    }

    /**
     * 増減点を取得します。
     *
     * @return 増減点
     */
    public int get増減点200604() {
        return entity.getZougenTen();
    }

    /**
     * 備考1を取得します。
     *
     * @return 備考1
     */
    public RString get備考1200604() {
        return entity.getZougenRiyu();
    }

    /**
     * 備考2を取得します。
     *
     * @return 備考2
     */
    public RString get備考2200604() {
        return entity.getFushikyuRiyu();
    }

    /**
     * 備考3を取得します。
     *
     * @return 備考3
     */
    public RString get備考3200604() {
        return entity.getKounyuKaishuRireki();
    }
}
