/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.relate.ninteishalistsakusei;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票・CSV作成のパラメータ
 *
 * @reamsid_L DBD-3830-040 tianyh
 */
@Getter
@Setter
public class NinteishaListSakuseiParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private int 対象期間指定;
    private int 世帯表示;
    private FlexibleDate 課税判定等基準日;
    private List<RString> 世帯非課税等;
    private int 抽出対象;
    private RString 出力順;
    private int 対象リスト;
    private FlexibleDate 対象年度の開始日;
    private FlexibleDate 対象年度の終了日;
    private FlexibleDate 基準日;

    /**
     * コンストラクタです。
     *
     * @param 世帯表示 世帯表示
     * @param 対象期間指定 対象期間指定
     * @param 世帯非課税等 世帯非課税等
     * @param 課税判定等基準日 課税判定等基準日
     * @param 抽出対象 抽出対象
     * @param 出力順 出力順
     * @param 対象リスト
     * @param 対象年度の開始日
     * @param 対象年度の終了日
     * @param 基準日
     * @param searchKey
     */
    public NinteishaListSakuseiParameter(int 対象期間指定, int 世帯表示, FlexibleDate 課税判定等基準日, List<RString> 世帯非課税等,
            int 抽出対象, RString 出力順, int 対象リスト, FlexibleDate 対象年度の開始日, FlexibleDate 対象年度の終了日, FlexibleDate 基準日, IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        this.世帯表示 = 世帯表示;
        this.世帯非課税等 = 世帯非課税等;
        this.出力順 = 出力順;
        this.抽出対象 = 抽出対象;
        this.課税判定等基準日 = 課税判定等基準日;
        this.対象期間指定 = 対象期間指定;
        this.対象リスト = 対象リスト;
        this.対象年度の開始日 = 対象年度の開始日;
        this.対象年度の終了日 = 対象年度の終了日;
        this.基準日 = 基準日;
    }

    /**
     * パラメータを取得します。
     *
     * @param 世帯表示 世帯表示
     * @param 対象期間指定 対象期間指定
     * @param 世帯非課税等 世帯非課税等
     * @param 課税判定等基準日 課税判定等基準日
     * @param 抽出対象 抽出対象
     * @param 出力順 出力順
     * @param 対象リスト
     * @param 対象年度の開始日
     * @param 対象年度の終了日
     * @param 基準日
     * @param searchKey
     * @return NinteishaListSakuseiParameter
     */
    public NinteishaListSakuseiParameter getNinteishaListSakuseiParameter(int 対象期間指定, int 世帯表示, FlexibleDate 課税判定等基準日,
            List<RString> 世帯非課税等, int 抽出対象, RString 出力順, int 対象リスト, FlexibleDate 対象年度の開始日, FlexibleDate 対象年度の終了日,
            FlexibleDate 基準日, IShikibetsuTaishoPSMSearchKey searchKey) {
        return new NinteishaListSakuseiParameter(対象期間指定, 世帯表示, 課税判定等基準日, 世帯非課税等, 抽出対象, 出力順, 対象リスト, 対象年度の開始日,
                対象年度の終了日, 基準日, searchKey);
    }

}
