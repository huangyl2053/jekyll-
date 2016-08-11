/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugaku;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 対象世帯員クラスです
 *
 * @reamsid_L DBC-4640-080 liuxiaoyu
 */
@Getter
@Setter
public class TaishoSetaiin {

    private RString 世帯コード;
    private FlexibleYear 処理年度;
    private RString 世帯課税区分;
    private RString 課税所得区分;
    private Decimal 総収入額;
    private RString メッセージ;
    private RString 出力有無;
    private Integer 年少扶養控除_16歳未満人数;
    private Integer 年少扶養控除_16歳から18歳人数;
    private RString ランク市町村コード;
    private FlexibleDate 世帯員把握基準日;
    private FlexibleDate 世帯員把握基準日2;
    private Integer 更新時履歴番号;
    private Boolean 印字文字欠け区分;
    private List<Shotai> 世帯員情報;

    public TaishoSetaiin clone(TaishoSetaiin 対象世帯員クラス) {
        TaishoSetaiin 対象世帯員クラス_1 = new TaishoSetaiin();
        対象世帯員クラス_1.set世帯コード(対象世帯員クラス.get世帯コード());
        対象世帯員クラス_1.set処理年度(対象世帯員クラス.get処理年度());
        対象世帯員クラス_1.set世帯課税区分(対象世帯員クラス.get世帯課税区分());
        対象世帯員クラス_1.set課税所得区分(対象世帯員クラス.get課税所得区分());
        対象世帯員クラス_1.set総収入額(対象世帯員クラス.get総収入額());
        対象世帯員クラス_1.setメッセージ(対象世帯員クラス.getメッセージ());
        対象世帯員クラス_1.set出力有無(対象世帯員クラス.get出力有無());
        対象世帯員クラス_1.set年少扶養控除_16歳未満人数(対象世帯員クラス.get年少扶養控除_16歳未満人数());
        対象世帯員クラス_1.set年少扶養控除_16歳から18歳人数(対象世帯員クラス.get年少扶養控除_16歳から18歳人数());
        対象世帯員クラス_1.setランク市町村コード(対象世帯員クラス.getランク市町村コード());
        対象世帯員クラス_1.set世帯員把握基準日(対象世帯員クラス.get世帯員把握基準日());
        対象世帯員クラス_1.set世帯員把握基準日2(対象世帯員クラス.get世帯員把握基準日2());
        対象世帯員クラス_1.set更新時履歴番号(対象世帯員クラス.get更新時履歴番号());
        対象世帯員クラス_1.set印字文字欠け区分(対象世帯員クラス.get印字文字欠け区分());
        対象世帯員クラス_1.set世帯員情報(対象世帯員クラス.get世帯員情報());
        return 対象世帯員クラス_1;
    }

}
