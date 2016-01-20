/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanjutakukaishu;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3049ShokanJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 住宅改修内容一覧を取得するクラスです。
 */
public class ShokanJutakuKaishuBusiness {

    private final DbT3049ShokanJutakuKaishuEntity shokanJutakuKaishuEntity;

    /**
     * コンストラクタです。
     *
     * @param shokanJutakuKaishuEntity DbT3049ShokanJutakuKaishuEntity
     */
    public ShokanJutakuKaishuBusiness(DbT3049ShokanJutakuKaishuEntity shokanJutakuKaishuEntity) {
        this.shokanJutakuKaishuEntity = shokanJutakuKaishuEntity;
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return shokanJutakuKaishuEntity.getHiHokenshaNo();
    }

    /**
     * サービス提供年月のgetメソッドです。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return shokanJutakuKaishuEntity.getServiceTeikyoYM();
    }

    /**
     * 整理番号のgetメソッドです。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return shokanJutakuKaishuEntity.getSeiriNo();
    }

    /**
     * 事業者番号のgetメソッドです。
     *
     * @return 事業者番号
     */
    public JigyoshaNo get事業者番号() {
        return shokanJutakuKaishuEntity.getJigyoshaNo();
    }

    /**
     * 様式番号のgetメソッドです。
     *
     * @return 様式番号
     */
    public RString get様式番号() {
        return shokanJutakuKaishuEntity.getYoshikiNo();
    }

    /**
     * 明細番号のgetメソッドです。
     * <br/>
     * <br/>複数レコード対応のため
     *
     * @return 明細番号
     */
    public RString get明細番号() {
        return shokanJutakuKaishuEntity.getMeisaiNo();
    }

    /**
     * 連番のgetメソッドです。
     *
     * @return 連番
     */
    public RString get連番() {
        return shokanJutakuKaishuEntity.getRenban();
    }

    /**
     * サービスコードのgetメソッドです。
     *
     * @return サービスコード
     */
    public ServiceCode getサービスコード() {
        return shokanJutakuKaishuEntity.getServiceCode();
    }

    /**
     * 住宅改修着工年月日のgetメソッドです。
     *
     * @return 住宅改修着工年月日
     */
    public FlexibleDate get住宅改修着工年月日() {
        return shokanJutakuKaishuEntity.getJutakuKaishuChakkoYMD();
    }

    /**
     * 住宅改修内容のgetメソッドです。
     *
     * @return 住宅改修内容
     */
    public RString get住宅改修内容() {
        return shokanJutakuKaishuEntity.getJutakuKaishuNaiyo();
    }

    /**
     * 住宅改修事業者名のgetメソッドです。
     *
     * @return 住宅改修事業者名
     */
    public RString get住宅改修事業者名() {
        return shokanJutakuKaishuEntity.getJutakuKaishuJigyoshaName();
    }

    /**
     * 住宅改修住宅住所のgetメソッドです。
     *
     * @return 住宅改修住宅住所
     */
    public RString get住宅改修住宅住所() {
        return shokanJutakuKaishuEntity.getJutakuKaishuJutakuAddress();
    }

    /**
     * 改修金額のgetメソッドです。
     *
     * @return 改修金額
     */
    public int get改修金額() {
        return shokanJutakuKaishuEntity.getKaishuKingaku();
    }

    /**
     * 審査方法区分コードのgetメソッドです。
     *
     * @return 審査方法区分コード
     */
    public RString get審査方法区分コード() {
        return shokanJutakuKaishuEntity.getShinsaHohoKubunCode();
    }

    /**
     * 住宅改修完成年月日のgetメソッドです。
     *
     * @return 住宅改修完成年月日
     */
    public FlexibleDate get住宅改修完成年月日() {
        return shokanJutakuKaishuEntity.getJutakuKaishuKanseiYMD();
    }

    /**
     * 差額金額のgetメソッドです。
     *
     * @return 差額金額
     */
    public int get差額金額() {
        return shokanJutakuKaishuEntity.getSagakuKingaku();
    }

    /**
     * 事前申請サービス提供年月のgetメソッドです。
     *
     * @return 事前申請サービス提供年月
     */
    public FlexibleYearMonth get事前申請サービス提供年月() {
        return shokanJutakuKaishuEntity.getJizenServiceTeikyoYM();
    }

    /**
     * 事前申請整理番号のgetメソッドです。
     *
     * @return 事前申請整理番号
     */
    public RString get事前申請整理番号() {
        return shokanJutakuKaishuEntity.getJizenSeiriNo();
    }

}
