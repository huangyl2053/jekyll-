/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kyufukanrihyoin;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票のCSVファイル作成のヘッダエンティティです。
 *
 * @reamsid_L DBC-2450-030 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufukanrihyoIchiranCSVEntity {

    @CsvField(order = 10, name = "取込年月")
    private RString 取込年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 40, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 50, name = "No.")
    private RString no;
    @CsvField(order = 60, name = "対象年月")
    private RString 対象年月;
    @CsvField(order = 70, name = "支援事業者番号")
    private RString 支援事業者番号;
    @CsvField(order = 80, name = "支援事業者名")
    private RString 支援事業者名;
    @CsvField(order = 90, name = "計画作成区分")
    private RString 計画作成区分;
    @CsvField(order = 100, name = "作成区分")
    private RString 作成区分;
    @CsvField(order = 110, name = "作成区分名")
    private RString 作成区分名;
    @CsvField(order = 120, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 130, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 140, name = "作成種別区分")
    private RString 作成種別区分;
    @CsvField(order = 150, name = "作成種別区分名")
    private RString 作成種別区分名;
    @CsvField(order = 160, name = "要介護状態区分")
    private RString 要介護状態区分;
    @CsvField(order = 170, name = "要介護度")
    private RString 要介護度;
    @CsvField(order = 180, name = "限度額管理期間（開始）")
    private RString 限度額管理期間_開始;
    @CsvField(order = 190, name = "限度額管理期間（終了）")
    private RString 限度額管理期間_終了;
    @CsvField(order = 200, name = "区分支給限度基準額")
    private RString 区分支給限度基準額;
    @CsvField(order = 210, name = "指定サービス単位")
    private RString 指定サービス単位;
    @CsvField(order = 220, name = "基準該当サービス単位")
    private RString 基準該当サービス単位;
    @CsvField(order = 230, name = "合計単位")
    private RString 合計単位;
    @CsvField(order = 240, name = "備考")
    private RString 備考;
    @CsvField(order = 250, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 260, name = "訪問通所件数")
    private RString 訪問通所件数;
    @CsvField(order = 270, name = "短期入所件数")
    private RString 短期入所件数;
    @CsvField(order = 280, name = "居宅件数")
    private RString 居宅件数;
    @CsvField(order = 290, name = "合計件数")
    private RString 合計件数;

    /**
     *
     * 証記載保険者番号列を出力しない
     *
     * @return KyufukanrihyoIchiranTanitsuCSVEntity
     */
    public KyufukanrihyoIchiranTanitsuCSVEntity to単一() {
        KyufukanrihyoIchiranTanitsuCSVEntity 単一 = new KyufukanrihyoIchiranTanitsuCSVEntity();
        単一.set取込年月(this.取込年月);
        単一.set作成日時(this.作成日時);
        単一.set保険者番号(this.保険者番号);
        単一.set保険者名(this.保険者名);
        単一.setNo(this.no);
        単一.set対象年月(this.対象年月);
        単一.set支援事業者番号(this.支援事業者番号);
        単一.set支援事業者名(this.支援事業者名);
        単一.set計画作成区分(this.計画作成区分);
        単一.set作成区分(this.作成区分);
        単一.set作成区分名(this.作成区分名);
        単一.set被保険者番号(this.被保険者番号);
        単一.set被保険者氏名(this.被保険者氏名);
        単一.set作成種別区分(this.作成種別区分);
        単一.set作成種別区分名(this.作成種別区分名);
        単一.set要介護状態区分(this.要介護状態区分);
        単一.set要介護度(this.要介護度);
        単一.set限度額管理期間_開始(this.限度額管理期間_開始);
        単一.set限度額管理期間_終了(this.限度額管理期間_終了);
        単一.set区分支給限度基準額(this.区分支給限度基準額);
        単一.set指定サービス単位(this.指定サービス単位);
        単一.set基準該当サービス単位(this.基準該当サービス単位);
        単一.set合計単位(this.合計単位);
        単一.set備考(this.備考);
        単一.set訪問通所件数(this.訪問通所件数);
        単一.set短期入所件数(this.短期入所件数);
        単一.set居宅件数(this.居宅件数);
        単一.set合計件数(this.合計件数);
        return 単一;
    }
}
