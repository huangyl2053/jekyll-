/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufuhitsuchishodetail;

import jp.co.ndensan.reams.db.dbc.entity.db.kyufuhitsuchishodetail.KyufuhiTsuchishoDetailEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険給付費通知書(２ページ目以降)の情報インターフェースです。
 *
 * @reamsid_L DBC-2280-050 lizhuoxuan
 */
public class KyufuhiTsuchishoDetailBusiness {

    private final KyufuhiTsuchishoDetailEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 介護保険給付費通知書(２ページ目以降)情報Entityクラス
     */
    public KyufuhiTsuchishoDetailBusiness(KyufuhiTsuchishoDetailEntity entity) {
        this.entity = entity;
    }

    /**
     * 被保険者氏名を取得します。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        return entity.get被保険者氏名();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.get被保険者番号();
    }

    /**
     * サービス集計開始年月を取得します。
     *
     * @return サービス集計開始年月
     */
    public RString getサービス集計開始年月() {
        return entity.getサービス集計開始年月();
    }

    /**
     * サービス集計終了年月を取得します。
     *
     * @return サービス集計終了年月
     */
    public RString getサービス集計終了年月() {
        return entity.getサービス集計終了年月();
    }

    /**
     * サービス提供年月を取得します。
     *
     * @return サービス提供年月
     */
    public RString getサービス提供年月() {
        return entity.getサービス提供年月();
    }

    /**
     * サービス事業者を取得します。
     *
     * @return サービス事業者
     */
    public RString getサービス事業者() {
        return entity.getサービス事業者();
    }

    /**
     * サービス種類_サービス略称を取得します。
     *
     * @return サービス種類_サービス略称
     */
    public RString getサービス種類_サービス略称() {
        return entity.getサービス種類_サービス略称();
    }

    /**
     * サービス日数_回数を取得します。
     *
     * @return サービス日数_回数
     */
    public RString getサービス日数_回数() {
        return entity.getサービス日数_回数();
    }

    /**
     * サービス費用合計額_円を取得します。
     *
     * @return サービス費用合計額_円
     */
    public RString getサービス費用合計額_円() {
        return entity.getサービス費用合計額_円();
    }

    /**
     * 利用者負担額合計額_円を取得します。
     *
     * @return 利用者負担額合計額_円
     */
    public RString get利用者負担額合計額_円() {
        return entity.get利用者負担額合計額_円();
    }

    /**
     * サービス事業者1を取得します。
     *
     * @return サービス事業者1
     */
    public RString getサービス事業者1() {
        return entity.getサービス事業者1();
    }

    /**
     * サービス種類_サービス略称1を取得します。
     *
     * @return サービス種類_サービス略称1
     */
    public RString getサービス種類_サービス略称1() {
        return entity.getサービス種類_サービス略称1();
    }

    /**
     * 通知文1を取得します。
     *
     * @return 通知文1
     */
    public RString get通知文1() {
        return entity.get通知文1();
    }

    /**
     * 通知文2を取得します。
     *
     * @return 通知文2
     */
    public RString get通知文2() {
        return entity.get通知文2();
    }

    /**
     * ページ分子を取得します。
     *
     * @return ページ分子
     */
    public int getページ分子() {
        return entity.getページ分子();
    }

    /**
     * ページ分子を取得します。
     *
     * @return ページ分子
     */
    public int getページ分母() {
        return entity.getページ分母();
    }

    /**
     * Countを取得します。
     *
     * @return Count
     */
    public int getCount() {
        return entity.getCount();
    }
}
