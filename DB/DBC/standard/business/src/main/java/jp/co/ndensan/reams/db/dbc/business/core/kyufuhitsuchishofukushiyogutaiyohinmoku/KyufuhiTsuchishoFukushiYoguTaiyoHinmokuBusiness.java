/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufuhitsuchishofukushiyogutaiyohinmoku;

import jp.co.ndensan.reams.db.dbc.entity.db.kyufuhitsuchishofukushiyogutaiyohinmoku.KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC100043_介護保険給付費通知書（福祉用具貸与品目）の情報インターフェースです。
 *
 * @reamsid_L DBC-2280-060 lizhuoxuan
 */
public class KyufuhiTsuchishoFukushiYoguTaiyoHinmokuBusiness {

    private final KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 帳票設計_DBC100043_介護保険給付費通知書（福祉用具貸与品目）情報Entityクラス
     */
    public KyufuhiTsuchishoFukushiYoguTaiyoHinmokuBusiness(KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity entity) {
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
     * 通知文1を取得します。
     *
     * @return 通知文1
     */
    public RString get通知文1() {
        return entity.get通知文1();
    }

    /**
     * サービス年月を取得します。
     *
     * @return サービス年月
     */
    public RString getサービス年月() {
        return entity.getサービス年月();
    }

    /**
     * サービス事業所を取得します。
     *
     * @return サービス事業所
     */
    public RString getサービス事業所() {
        return entity.getサービス事業所();
    }

    /**
     * タイコードを取得します。
     *
     * @return タイコード
     */
    public RString getタイコード() {
        return entity.getタイコード();
    }

    /**
     * 福祉用具商品名を取得します。
     *
     * @return 福祉用具商品名
     */
    public RString get福祉用具商品名() {
        return entity.get福祉用具商品名();
    }

    /**
     * 費用額を取得します。
     *
     * @return 費用額
     */
    public RString get費用額() {
        return entity.get費用額();
    }

    /**
     * 参考資料タイトル1を取得します。
     *
     * @return 参考資料タイトル1
     */
    public RString get参考資料タイトル1() {
        return entity.get参考資料タイトル1();
    }

    /**
     * 費用額円_1を取得します。
     *
     * @return 費用額円_1
     */
    public RString get費用額円_1() {
        return entity.get費用額円_1();
    }

    /**
     * 件数件_1を取得します。
     *
     * @return 件数件_1
     */
    public RString get件数件_1() {
        return entity.get件数件_1();
    }

    /**
     * 割合_1を取得します。
     *
     * @return 割合_1
     */
    public RString get割合_1() {
        return entity.get割合_1();
    }

    /**
     * あなたの位置1を取得します。
     *
     * @return あなたの位置1
     */
    public RString getあなたの位置1() {
        return entity.getあなたの位置1();
    }

    /**
     * 全国1を取得します。
     *
     * @return 全国1
     */
    public RString get全国1() {
        return entity.get全国1();
    }

    /**
     * 都道府県1を取得します。
     *
     * @return 都道府県1
     */
    public RString get都道府県1() {
        return entity.get都道府県1();
    }

    /**
     * 保険者1を取得します。
     *
     * @return 保険者1
     */
    public RString get保険者1() {
        return entity.get保険者1();
    }

    /**
     * 参考資料タイトル2を取得します。
     *
     * @return 参考資料タイトル2
     */
    public RString get参考資料タイトル2() {
        return entity.get参考資料タイトル2();
    }

    /**
     * 費用額円_2を取得します。
     *
     * @return 費用額円_2
     */
    public RString get費用額円_2() {
        return entity.get費用額円_2();
    }

    /**
     * 件数件_2を取得します。
     *
     * @return 件数件_2
     */
    public RString get件数件_2() {
        return entity.get件数件_2();
    }

    /**
     * 割合_2を取得します。
     *
     * @return 割合_2
     */
    public RString get割合_2() {
        return entity.get割合_2();
    }

    /**
     * あなたの位置2を取得します。
     *
     * @return あなたの位置2
     */
    public RString getあなたの位置2() {
        return entity.getあなたの位置2();
    }

    /**
     * 全国2を取得します。
     *
     * @return 全国2
     */
    public RString get全国2() {
        return entity.get全国2();
    }

    /**
     * 都道府県2を取得します。
     *
     * @return 都道府県2
     */
    public RString get都道府県2() {
        return entity.get都道府県2();
    }

    /**
     * 保険者2を取得します。
     *
     * @return 保険者2
     */
    public RString get保険者2() {
        return entity.get保険者2();
    }

    /**
     * 参考資料タイトル3を取得します。
     *
     * @return 参考資料タイトル3
     */
    public RString get参考資料タイトル3() {
        return entity.get参考資料タイトル3();
    }

    /**
     * 費用額円_3を取得します。
     *
     * @return 費用額円_3
     */
    public RString get費用額円_3() {
        return entity.get費用額円_3();
    }

    /**
     * 件数件_3を取得します。
     *
     * @return 件数件_3
     */
    public RString get件数件_3() {
        return entity.get件数件_3();
    }

    /**
     * 割合_3を取得します。
     *
     * @return 割合_3
     */
    public RString get割合_3() {
        return entity.get割合_3();
    }

    /**
     * あなたの位置3を取得します。
     *
     * @return あなたの位置3
     */
    public RString getあなたの位置3() {
        return entity.getあなたの位置3();
    }

    /**
     * 全国3を取得します。
     *
     * @return 全国3
     */
    public RString get全国3() {
        return entity.get全国3();
    }

    /**
     * 都道府県3を取得します。
     *
     * @return 都道府県3
     */
    public RString get都道府県3() {
        return entity.get都道府県3();
    }

    /**
     * 保険者3を取得します。
     *
     * @return 保険者3
     */
    public RString get保険者3() {
        return entity.get保険者3();
    }

    /**
     * 通知文3を取得します。
     *
     * @return 通知文3
     */
    public RString get通知文3() {
        return entity.get通知文3();
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
