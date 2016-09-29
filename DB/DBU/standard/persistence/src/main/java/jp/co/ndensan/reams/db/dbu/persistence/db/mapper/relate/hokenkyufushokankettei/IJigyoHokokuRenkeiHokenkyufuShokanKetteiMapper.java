/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hokenkyufushokankettei;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.hokenkyufushokankettei.JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hokenkyufushokankettei.JigyoHokokuShiryouRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hokenkyufushokankettei.TempDwbTKyufujissekiShukeiKonkyo1Entity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hokenkyufushokankettei.TempDwbTKyufujissekiShukeiKonkyo2Entity;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 保険給付【償還_決定】のMapperクラスです。
 *
 * @reamsid_L DBU-5570-030 xuyannan
 */
public interface IJigyoHokokuRenkeiHokenkyufuShokanKetteiMapper {

    /**
     * 給付実績集計根拠一時テーブル（介護給付・予防給付用）の取得処理です。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     *
     * @return 介護給付・予防給付用情報
     */
    List<TempDwbTKyufujissekiShukeiKonkyo1Entity> getJigyouHokokuShiryou_KaigoKyufu(
            JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 一時テーブルのデータから前履歴を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     *
     * @return 介護給付・予防給付用情報
     */
    List<TempDwbTKyufujissekiShukeiKonkyo1Entity> getZenRireki(
            JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 特定入所者集計根拠一時テーブル（特定入所者介護用）の取得処理です。
     *
     * @return 特定入所者介護用情報
     */
    List<TempDwbTKyufujissekiShukeiKonkyo2Entity> getJigyouHokokuShiryou_TokuteiNyusyo();

    /**
     * 処理日付管理マスタへ登録します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     */
    void updateShoriDateKanri(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 一時テーブルより、後_点数の更新です。
     */
    void update後_点数();

    /**
     * 一時テーブルより、市町村コードと旧市町村コードの更新です。
     */
    void update市町村コードと旧市町村コード();

    /**
     * 一時テーブルより、負担割合区分と負担割合エラーフラグの更新です。
     */
    void update負担割合区分と負担割合エラーフラグ_一回目();

    /**
     * 一時テーブルより、負担割合区分と負担割合エラーフラグの更新です。
     */
    void update負担割合区分と負担割合エラーフラグ_二回目();

    /**
     * 一時テーブルより、利用者負担減免被保険者番号の更新です。
     */
    void update利用者負担減免被保険者番号();

    /**
     * 一時テーブルより、負担割合区分と作成区分エラーフラグの更新です。
     */
    void update負担割合区分と作成区分エラーフラグ();

    /**
     * 一時テーブルより、0x02-集計の更新です。
     */
    void update0x02_集計();

    /**
     * 一時テーブルより、0x03-集計の更新です。
     */
    void update0x03_集計();

    /**
     * 一時テーブルより、0x04-集計の更新です。
     */
    void update0x04_集計();

    /**
     * 一時テーブルより、0x04再掲-集計1の更新です。
     */
    void update0x04再掲_集計1();

    /**
     * 一時テーブルより、0x04再掲-集計2の更新です。
     */
    void update0x04再掲_集計2();

    /**
     * 一時テーブルより、0x04再掲-集計3の更新です。
     */
    void update0x04再掲_集計3();

    /**
     * 一時テーブルより、0x04再掲-集計4の更新です。
     */
    void update0x04再掲_集計4();

    /**
     * 一時テーブルより、給付マイナス対応の更新です。
     */
    void updateKyufuマイナス対応();

    /**
     * 一時テーブルより、不要データの削除です。
     */
    void delete不要データ();

    /**
     * 給付実績集計根拠一時テーブル（介護給付・予防給付用）全て情報を取得します。
     *
     * @return 介護給付・予防給付用情報
     */
    List<TempDwbTKyufujissekiShukeiKonkyo1Entity> getKaigoKyufu();

    /**
     * 一時テーブルより、特定マイナス対応の更新です。
     */
    void updateTokuteiマイナス対応();

    /**
     * 特定入所者集計根拠一時テーブル（特定入所者介護用）全て情報を取得します。
     *
     * @return 特定入所者介護用情報
     */
    List<TempDwbTKyufujissekiShukeiKonkyo2Entity> getTokuteiNyusyo();

    /**
     * 事業報告統計データの初期化です。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     */
    void delete事業報告統計データ(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 事業報告統計データの更新です。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     */
    void insert事業報告統計データ(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0101_1(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0101_2(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0102(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0103(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0104(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0107_1(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0107_2(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0108(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0109(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0110(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0201_1(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0201_2(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0202(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0203(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0204(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0301_1(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0301_2(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0302(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0303(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0304(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0401_1(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0401_2(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0402(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0403(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0404(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0105(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0106(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0205(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 集計番号による集計内容を取得します。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     * @return 集計結果値
     */
    Decimal get集計結果値_0206(JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 事業状況報告資料の取得処理です。
     *
     * @param parameter 保険給付【償還_決定】パラメータ
     *
     * @return 事業状況報告資料
     */
    List<JigyoHokokuShiryouRelateEntity> getJigyouHokoku_Hokensha(
            JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter parameter);

    /**
     * 作成区分エラーフラグ＝”1”の処理結果確認リストの取得処理です。
     *
     * @return 処理結果確認リスト
     */
    List<TempDwbTKyufujissekiShukeiKonkyo1Entity> getShoriKekkaKakuninListBySakuseiKubun();

    /**
     * 負担割合エラーフラグ＝”1”の処理結果確認リストの取得処理です。
     *
     * @return 処理結果確認リスト
     */
    List<TempDwbTKyufujissekiShukeiKonkyo1Entity> getShoriKekkaKakuninListByFutanWariai();

    /**
     * 前後給付率エラーフラグ＝”1”の処理結果確認リストの取得処理です。
     *
     * @return 処理結果確認リスト
     */
    List<TempDwbTKyufujissekiShukeiKonkyo1Entity> getShoriKekkaKakuninListByZengoKyufuritu();

    /**
     * 市町村コード IS NULLの処理結果確認リストの取得処理です。
     *
     * @return 処理結果確認リスト
     */
    List<TempDwbTKyufujissekiShukeiKonkyo1Entity> getShoriKekkaKakuninListByShichoson();
}
