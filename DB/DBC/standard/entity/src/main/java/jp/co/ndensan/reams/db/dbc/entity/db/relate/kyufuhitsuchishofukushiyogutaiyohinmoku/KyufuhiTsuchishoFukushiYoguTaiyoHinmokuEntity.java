/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhitsuchishofukushiyogutaiyohinmoku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票設計_DBC100043_介護保険給付費通知書（福祉用具貸与品目）のEntityクラスです。
 *
 * @reamsid_L DBC-2280-060 lizhuoxuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity {

    private RString 被保険者氏名;
    private RString 被保険者番号;
    private RString サービス集計開始年月;
    private RString サービス集計終了年月;
    private RString 通知文1;
    private List<RString> サービス年月;
    private List<RString> サービス事業所;
    private List<RString> タイコード;
    private List<RString> 福祉用具商品名;
    private List<Decimal> 費用額;
    private RString 参考資料タイトル1;
    private List<RString> 費用額円_1;
    private List<Decimal> 件数件_1;
    private List<Decimal> 割合_1;
    private List<RString> あなたの位置1;
    private List<Decimal> 全国1;
    private List<Decimal> 都道府県1;
    private List<Decimal> 保険者1;
    private RString 参考資料タイトル2;
    private List<RString> 費用額円_2;
    private List<Decimal> 件数件_2;
    private List<Decimal> 割合_2;
    private List<RString> あなたの位置2;
    private List<Decimal> 全国2;
    private List<Decimal> 都道府県2;
    private List<Decimal> 保険者2;
    private RString 参考資料タイトル3;
    private List<RString> 費用額円_3;
    private List<Decimal> 件数件_3;
    private List<Decimal> 割合_3;
    private List<RString> あなたの位置3;
    private List<Decimal> 全国3;
    private List<Decimal> 都道府県3;
    private List<Decimal> 保険者3;
    private RString 通知文3;
    private int ページ分子;
    private int ページ分母;
    private int count;

    /**
     * コンストラクタです。
     */
    public KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity() {
        count = 0;
        サービス年月 = new ArrayList<>();
        サービス事業所 = new ArrayList<>();
        タイコード = new ArrayList<>();
        福祉用具商品名 = new ArrayList<>();
        費用額 = new ArrayList<>();
        費用額円_1 = new ArrayList<>();
        件数件_1 = new ArrayList<>();
        割合_1 = new ArrayList<>();
        あなたの位置1 = new ArrayList<>();
        全国1 = new ArrayList<>();
        都道府県1 = new ArrayList<>();
        保険者1 = new ArrayList<>();
        費用額円_2 = new ArrayList<>();
        件数件_2 = new ArrayList<>();
        割合_2 = new ArrayList<>();
        あなたの位置2 = new ArrayList<>();
        全国2 = new ArrayList<>();
        都道府県2 = new ArrayList<>();
        保険者2 = new ArrayList<>();
        費用額円_3 = new ArrayList<>();
        件数件_3 = new ArrayList<>();
        割合_3 = new ArrayList<>();
        あなたの位置3 = new ArrayList<>();
        全国3 = new ArrayList<>();
        都道府県3 = new ArrayList<>();
        保険者3 = new ArrayList<>();
    }

    /**
     * Entityクラスをクリアします。
     */
    public void clear() {
        count = 0;
        サービス年月.clear();
        サービス事業所.clear();
        タイコード.clear();
        福祉用具商品名.clear();
        費用額.clear();
        費用額円_1.clear();
        件数件_1.clear();
        割合_1.clear();
        あなたの位置1.clear();
        全国1.clear();
        都道府県1.clear();
        保険者1.clear();
        費用額円_2.clear();
        件数件_2.clear();
        割合_2.clear();
        あなたの位置2.clear();
        全国2.clear();
        都道府県2.clear();
        保険者2.clear();
        費用額円_3.clear();
        件数件_3.clear();
        割合_3.clear();
        あなたの位置3.clear();
        全国3.clear();
        都道府県3.clear();
        保険者3.clear();
        参考資料タイトル1 = RString.EMPTY;
        参考資料タイトル2 = RString.EMPTY;
        参考資料タイトル3 = RString.EMPTY;
    }

    /**
     * DBデータの数をセットします。
     */
    public void setSize() {
        this.count++;
    }

    /**
     * DBデータの数を取得 します。
     *
     * @return DBデータの数
     */
    public int size() {
        return this.count;
    }
}
