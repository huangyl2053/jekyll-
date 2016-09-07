/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5110001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 更新未申請者把握リスト作成CSVEntityクラスです。
 *
 * @reamsid_L DBD-1420-020 wangjie2
 */
public class KoshinShinseishaHaakuListCSVEntity {

    @CsvField(order = 0, name = "連番")
    private final RString 連番;
    @CsvField(order = 10, name = "被保険者番号")
    private final RString 被保険者番号;
    @CsvField(order = 20, name = "氏名")
    private final RString 氏名;
    @CsvField(order = 30, name = "氏名カナ")
    private final RString 氏名カナ;
    @CsvField(order = 40, name = "郵便番号")
    private final RString 郵便番号;
    @CsvField(order = 50, name = "住所（番地方書まで）")
    private final RString 住所_番地方書まで;
    @CsvField(order = 60, name = "生年月日")
    private final RString 生年月日;
    @CsvField(order = 70, name = "処理日時点の年齢")
    private final RString 処理日時点の年齢;
    @CsvField(order = 80, name = "前回介護度")
    private final RString 前回介護度;
    @CsvField(order = 90, name = "前回申請日")
    private final RString 前回申請日;
    @CsvField(order = 100, name = "前回申請区分（申請時）")
    private final RString 前回申請区分_申請時;
    @CsvField(order = 110, name = "前回認定日")
    private final RString 前回認定日;
    @CsvField(order = 120, name = "前回認定有効開始日")
    private final RString 前回認定有効開始日;
    @CsvField(order = 130, name = "前回認定有効終了日")
    private final RString 前回認定有効終了日;
    @CsvField(order = 140, name = "前回認定有効月数")
    private final RString 前回認定有効月数;
    @CsvField(order = 150, name = "前回調査事業所コード")
    private final RString 前回調査事業所コード;
    @CsvField(order = 160, name = "前回調査事業所名称")
    private final RString 前回調査事業所名称;
    @CsvField(order = 170, name = "前回入所施設コード")
    private final RString 前回入所施設コード;
    @CsvField(order = 180, name = "前回入所施設名称")
    private final RString 前回入所施設名称;

    /**
     * コンストラクタ。
     *
     * @param 連番 連番
     * @param 被保険者番号 被保険者番号
     * @param 氏名 氏名
     * @param 氏名カナ 氏名カナ
     * @param 郵便番号 郵便番号
     * @param 生年月日 生年月日
     * @param 住所_番地方書まで 住所_番地方書まで
     * @param 処理日時点の年齢 処理日時点の年齢
     * @param 前回介護度 前回介護度
     * @param 前回申請区分_申請時 前回申請区分_申請時
     * @param 前回申請日 前回申請日
     * @param 前回認定日 前回認定日
     * @param 前回認定有効開始日 前回認定有効開始日
     * @param 前回認定有効終了日 前回認定有効終了日
     * @param 前回認定有効月数 前回認定有効月数
     * @param 前回調査事業所コード 前回調査事業所コード
     * @param 前回調査事業所名称 前回調査事業所名称
     * @param 前回入所施設コード 前回入所施設コード
     * @param 前回入所施設名称 前回入所施設名称
     */
    public KoshinShinseishaHaakuListCSVEntity(RString 連番, RString 被保険者番号, RString 氏名,
            RString 氏名カナ, RString 郵便番号, RString 住所_番地方書まで, RString 生年月日, RString 処理日時点の年齢,
            RString 前回介護度, RString 前回申請日, RString 前回申請区分_申請時, RString 前回認定日,
            RString 前回認定有効開始日, RString 前回認定有効終了日, RString 前回認定有効月数, RString 前回調査事業所コード,
            RString 前回調査事業所名称, RString 前回入所施設コード, RString 前回入所施設名称) {
        this.連番 = 連番;
        this.被保険者番号 = 被保険者番号;
        this.氏名 = 氏名;
        this.氏名カナ = 氏名カナ;
        this.郵便番号 = 郵便番号;
        this.住所_番地方書まで = 住所_番地方書まで;
        this.生年月日 = 生年月日;
        this.処理日時点の年齢 = 処理日時点の年齢;
        this.前回介護度 = 前回介護度;
        this.前回申請日 = 前回申請日;
        this.前回申請区分_申請時 = 前回申請区分_申請時;
        this.前回認定日 = 前回認定日;
        this.前回認定有効開始日 = 前回認定有効開始日;
        this.前回認定有効終了日 = 前回認定有効終了日;
        this.前回認定有効月数 = 前回認定有効月数;
        this.前回調査事業所コード = 前回調査事業所コード;
        this.前回調査事業所名称 = 前回調査事業所名称;
        this.前回入所施設コード = 前回入所施設コード;
        this.前回入所施設名称 = 前回入所施設名称;
    }

    /**
     * コンストラクタ。
     *
     */
    public KoshinShinseishaHaakuListCSVEntity() {
        this.連番 = RString.EMPTY;
        this.被保険者番号 = RString.EMPTY;
        this.氏名 = RString.EMPTY;
        this.氏名カナ = RString.EMPTY;
        this.郵便番号 = RString.EMPTY;
        this.住所_番地方書まで = RString.EMPTY;
        this.生年月日 = RString.EMPTY;
        this.処理日時点の年齢 = RString.EMPTY;
        this.前回介護度 = RString.EMPTY;
        this.前回申請日 = RString.EMPTY;
        this.前回申請区分_申請時 = RString.EMPTY;
        this.前回認定日 = RString.EMPTY;
        this.前回認定有効開始日 = RString.EMPTY;
        this.前回認定有効終了日 = RString.EMPTY;
        this.前回認定有効月数 = RString.EMPTY;
        this.前回調査事業所コード = RString.EMPTY;
        this.前回調査事業所名称 = RString.EMPTY;
        this.前回入所施設コード = RString.EMPTY;
        this.前回入所施設名称 = RString.EMPTY;
    }

}
