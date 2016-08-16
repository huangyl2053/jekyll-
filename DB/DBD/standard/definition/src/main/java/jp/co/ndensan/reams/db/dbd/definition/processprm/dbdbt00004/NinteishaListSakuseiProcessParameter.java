/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00004;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票・CSV作成バッチProcess用パラメータクラスです
 *
 * @reamsid_L DBD-3830-030 tianyh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class NinteishaListSakuseiProcessParameter implements IBatchProcessParameter {

    private RString 対象リスト;
    private RString 対象期間指定;
    private FlexibleDate 対象年度の開始年月日;
    private FlexibleDate 対象年度の終了年月日;
    private RString 旧措置者区分;
    private RString 世帯表示;
    private FlexibleYear 所得年度;
    private FlexibleDate 基準日;
    private FlexibleDate 課税判定等基準日;
    private RString 受給者区分;
    private List<RString> 世帯非課税等;
    private RString 抽出対象;
    private List<RString> CSV出力設定;
    private long 改頁出力順ID;
    private RString 帳票ID;
    private YMDHMS 帳票作成日時;

    public NinteishaListSakuseiProcessParameter(
            RString 対象リスト,
            RString 対象期間指定,
            FlexibleDate 対象年度の開始年月日,
            FlexibleDate 対象年度の終了年月日,
            RString 旧措置者区分,
            RString 世帯表示,
            FlexibleYear 所得年度,
            FlexibleDate 基準日,
            FlexibleDate 課税判定等基準日,
            RString 受給者区分,
            List<RString> 世帯非課税等,
            RString 抽出対象,
            List<RString> CSV出力設定,
            long 改頁出力順ID,
            RString 帳票ID,
            YMDHMS 帳票作成日時) {
        this.対象リスト = 対象リスト;
        this.対象期間指定 = 対象期間指定;
        this.対象年度の開始年月日 = 対象年度の開始年月日;
        this.対象年度の終了年月日 = 対象年度の終了年月日;
        this.旧措置者区分 = 旧措置者区分;
        this.世帯表示 = 世帯表示;
        this.所得年度 = 所得年度;
        this.基準日 = 基準日;
        this.課税判定等基準日 = 課税判定等基準日;
        this.受給者区分 = 受給者区分;
        this.世帯非課税等 = 世帯非課税等;
        this.抽出対象 = 抽出対象;
        this.CSV出力設定 = CSV出力設定;
        this.改頁出力順ID = 改頁出力順ID;
        this.帳票ID = 帳票ID;
        this.帳票作成日時 = 帳票作成日時;
    }

}
