/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.futanwariaihanteiichiran;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * ＣＳＶを定義したEntityクラスです。
 *
 * @reamsid_L DBC-4980-031 yuanzhenxia
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class FutanWariaiHanteiIchiranCsvEntity {

    @CsvField(order = 1, name = "市町村コード")
    private final RString 市町村コード;
    @CsvField(order = 2, name = "市町村名")
    private final RString 市町村名;
    @CsvField(order = 3, name = "年度")
    private final RString 年度;
    @CsvField(order = 4, name = "処理名")
    private final RString 処理名;
    @CsvField(order = 5, name = "基準日")
    private final RString 基準日;
    @CsvField(order = 6, name = "No.")
    private final RString no;
    @CsvField(order = 7, name = "被保険者番号")
    private final RString 被保険者番号;
    @CsvField(order = 8, name = "氏名")
    private final RString 氏名;
    @CsvField(order = 9, name = "資格")
    private final RString 資格;
    @CsvField(order = 10, name = "要介護度")
    private final RString 要介護度;
    @CsvField(order = 11, name = "資格取得日")
    private final RString 資格取得日;
    @CsvField(order = 12, name = "資格喪失日")
    private final RString 資格喪失日;
    @CsvField(order = 13, name = "認定有効開始日")
    private final RString 認定有効開始日;
    @CsvField(order = 14, name = "認定有効終了日")
    private final RString 認定有効終了日;
    @CsvField(order = 15, name = "【今回判定結果】負担割合")
    private final RString 今回判定結果_負担割合;
    @CsvField(order = 16, name = "【今回判定結果】適用開始日")
    private final RString 今回判定結果_適用開始日;
    @CsvField(order = 17, name = "【今回判定結果】適用終了日")
    private final RString 今回判定結果_適用終了日;
    @CsvField(order = 18, name = "【今回判定結果】本人合計所得金額合計")
    private final RString 今回判定結果_本人合計所得金額合計;
    @CsvField(order = 19, name = "【今回判定結果】世帯１号被保険者数")
    private final RString 今回判定結果_世帯１号被保険者数;
    @CsvField(order = 20, name = "【今回判定結果】年金収入合計")
    private final RString 今回判定結果_年金収入合計;
    @CsvField(order = 21, name = "【今回判定結果】その他の合計所得金額合計")
    private final RString 今回判定結果_その他の合計所得金額合計;
    @CsvField(order = 22, name = "【今回判定結果】更正事由")
    private final RString 今回判定結果_更正事由;
    @CsvField(order = 23, name = "【前回判定結果】負担割合")
    private final RString 前回判定結果_負担割合;
    @CsvField(order = 24, name = "【前回判定結果】適用開始日")
    private final RString 前回判定結果_適用開始日;
    @CsvField(order = 25, name = "【前回判定結果】適用終了日")
    private final RString 前回判定結果_適用終了日;
    @CsvField(order = 26, name = "【前回判定結果】本人合計所得金額合計")
    private final RString 前回判定結果_本人合計所得金額合計;
    @CsvField(order = 27, name = "【前回判定結果】世帯１号被保険者数")
    private final RString 前回判定結果_世帯１号被保険者数;
    @CsvField(order = 28, name = "【前回判定結果】年金収入合計")
    private final RString 前回判定結果_年金収入合計;
    @CsvField(order = 29, name = "【前回判定結果】その他の合計所得金額合計")
    private final RString 前回判定結果_その他の合計所得金額合計;
    @CsvField(order = 30, name = "【前回判定結果】更正事由")
    private final RString 前回判定結果_更正事由;
    @CsvField(order = 31, name = "【判定備考】住民税課税区分")
    private final RString 判定備考_住民税課税区分;
    @CsvField(order = 32, name = "【判定備考】減免")
    private final RString 判定備考_減免;
    @CsvField(order = 33, name = "【判定備考】その他")
    private final RString 判定備考_その他;
    @CsvField(order = 34, name = "処理日")
    private final RString 処理日;

    /**
     * コンストラクタのメソッドです。
     *
     * @param 市町村コード 市町村コード
     * @param 市町村名 市町村名
     * @param 年度 年度
     * @param 処理名 処理名
     * @param 基準日 基準日
     * @param No No
     * @param 被保険者番号 被保険者番号
     * @param 氏名 氏名
     * @param 資格 資格
     * @param 要介護度 要介護度
     * @param 資格取得日 資格取得日
     * @param 資格喪失日 資格喪失日
     * @param 認定有効開始日 認定有効開始日
     * @param 認定有効終了日 認定有効終了日
     * @param 今回判定結果_負担割合 今回判定結果_負担割合
     * @param 今回判定結果_適用開始日 今回判定結果_適用開始日
     * @param 今回判定結果_適用終了日 今回判定結果_適用終了日
     * @param 今回判定結果_本人合計所得金額合計 今回判定結果_本人合計所得金額合計
     * @param 今回判定結果_世帯１号被保険者数 今回判定結果_世帯１号被保険者数
     * @param 今回判定結果_年金収入合計 今回判定結果_年金収入合計
     * @param 今回判定結果_その他の合計所得金額合計 今回判定結果_その他の合計所得金額合計
     * @param 今回判定結果_更正事由 今回判定結果_更正事由
     * @param 前回判定結果_負担割合 前回判定結果_負担割合
     * @param 前回判定結果_適用開始日 前回判定結果_適用開始日
     * @param 前回判定結果_適用終了日 前回判定結果_適用終了日
     * @param 前回判定結果_本人合計所得金額合計 前回判定結果_本人合計所得金額合計
     * @param 前回判定結果_世帯１号被保険者数 前回判定結果_世帯１号被保険者数
     * @param 前回判定結果_年金収入合計 前回判定結果_年金収入合計
     * @param 前回判定結果_その他の合計所得金額合計 前回判定結果_その他の合計所得金額合計
     * @param 前回判定結果_更正事由 前回判定結果_更正事由
     * @param 判定備考_住民税課税区分 判定備考_住民税課税区分
     * @param 判定備考_減免 判定備考_減免
     * @param 判定備考_その他 判定備考_その他
     * @param 処理日 処理日
     */
    public FutanWariaiHanteiIchiranCsvEntity(RString 市町村コード, RString 市町村名, RString 年度, RString 処理名, RString 基準日, RString no,
            RString 被保険者番号, RString 氏名, RString 資格, RString 要介護度, RString 資格取得日, RString 資格喪失日, RString 認定有効開始日,
            RString 認定有効終了日, RString 今回判定結果_負担割合, RString 今回判定結果_適用開始日, RString 今回判定結果_適用終了日,
            RString 今回判定結果_本人合計所得金額合計, RString 今回判定結果_世帯１号被保険者数, RString 今回判定結果_年金収入合計,
            RString 今回判定結果_その他の合計所得金額合計, RString 今回判定結果_更正事由, RString 前回判定結果_負担割合, RString 前回判定結果_適用開始日,
            RString 前回判定結果_適用終了日, RString 前回判定結果_本人合計所得金額合計, RString 前回判定結果_世帯１号被保険者数,
            RString 前回判定結果_年金収入合計, RString 前回判定結果_その他の合計所得金額合計, RString 前回判定結果_更正事由,
            RString 判定備考_住民税課税区分, RString 判定備考_減免, RString 判定備考_その他, RString 処理日) {
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
        this.年度 = 年度;
        this.処理名 = 処理名;
        this.基準日 = 基準日;
        this.no = no;
        this.被保険者番号 = 被保険者番号;
        this.氏名 = 氏名;
        this.資格 = 資格;
        this.要介護度 = 要介護度;
        this.資格取得日 = 資格取得日;
        this.資格喪失日 = 資格喪失日;
        this.認定有効開始日 = 認定有効開始日;
        this.認定有効終了日 = 認定有効終了日;
        this.今回判定結果_負担割合 = 今回判定結果_負担割合;
        this.今回判定結果_適用開始日 = 今回判定結果_適用開始日;
        this.今回判定結果_適用終了日 = 今回判定結果_適用終了日;
        this.今回判定結果_本人合計所得金額合計 = 今回判定結果_本人合計所得金額合計;
        this.今回判定結果_世帯１号被保険者数 = 今回判定結果_世帯１号被保険者数;
        this.今回判定結果_年金収入合計 = 今回判定結果_年金収入合計;
        this.今回判定結果_その他の合計所得金額合計 = 今回判定結果_その他の合計所得金額合計;
        this.今回判定結果_更正事由 = 今回判定結果_更正事由;
        this.前回判定結果_負担割合 = 前回判定結果_負担割合;
        this.前回判定結果_適用開始日 = 前回判定結果_適用開始日;
        this.前回判定結果_適用終了日 = 前回判定結果_適用終了日;
        this.前回判定結果_本人合計所得金額合計 = 前回判定結果_本人合計所得金額合計;
        this.前回判定結果_世帯１号被保険者数 = 前回判定結果_世帯１号被保険者数;
        this.前回判定結果_年金収入合計 = 前回判定結果_年金収入合計;
        this.前回判定結果_その他の合計所得金額合計 = 前回判定結果_その他の合計所得金額合計;
        this.前回判定結果_更正事由 = 前回判定結果_更正事由;
        this.判定備考_住民税課税区分 = 判定備考_住民税課税区分;
        this.判定備考_減免 = 判定備考_減免;
        this.判定備考_その他 = 判定備考_その他;
        this.処理日 = 処理日;
    }

}
