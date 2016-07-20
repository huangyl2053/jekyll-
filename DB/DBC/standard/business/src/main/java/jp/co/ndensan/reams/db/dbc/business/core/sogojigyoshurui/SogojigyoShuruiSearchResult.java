/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.sogojigyoshurui;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyoshuruishikyugendogaku.SogojigyoShuruiEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 総合事業種類支給限度額情報の取得結果です。
 *
 * @reamsid_L DBC-3364-010 xuxin
 */
public class SogojigyoShuruiSearchResult implements Serializable {

    private final SogojigyoShuruiEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity SogojigyoShuruiSearchResult
     */
    public SogojigyoShuruiSearchResult(SogojigyoShuruiEntity entity) {
        this.entity = entity;
    }

    /**
     * 適用開始年月を返します。
     *
     * @return 適用開始年月
     */
    public FlexibleYearMonth get適用開始年月() {
        return entity.get適用開始年月();
    }

    /**
     * サービス種類略称を返します。
     *
     * @return サービス種類略称
     */
    public RString getサービス種類コード() {
        return entity.getサービス種類略称();
    }

    /**
     * 適用終了年月を返します。
     *
     * @return 適用終了年月
     */
    public FlexibleYearMonth get適用終了年月() {
        return entity.get適用終了年月();
    }

    /**
     * 支給限度単位数(要支援1)を返します。
     *
     * @return 支給限度単位数(要支援1)
     */
    public Decimal get要支援1() {
        return entity.get要支援1();
    }

    /**
     * 支給限度単位数(要支援2)を返します。
     *
     * @return 支給限度単位数(要支援2)
     */
    public Decimal get要支援2() {
        return entity.get要支援2();
    }

    /**
     * 支給限度単位数(二次予防)を返します。
     *
     * @return 支給限度単位数(二次予防)
     */
    public Decimal get二次予防() {
        return entity.get二次予防();
    }

}
