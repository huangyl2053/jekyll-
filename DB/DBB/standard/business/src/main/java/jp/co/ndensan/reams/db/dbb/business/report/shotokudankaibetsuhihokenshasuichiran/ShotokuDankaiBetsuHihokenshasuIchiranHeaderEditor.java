/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.shotokudankaibetsuhihokenshasuichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.shotokudankaibetsuhihokenshasuichiran.ShotokuDankaiBetsuHihokenshasuIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 段階別被保険者数一覧表帳票クラスです。
 *
 * @reamsid_L DBB-1820-060 zhouchuanlin
 */
public class ShotokuDankaiBetsuHihokenshasuIchiranHeaderEditor implements IShotokuDankaiBetsuHihokenshasuIchiranEditor {

    private final HokenshaDankaibetsuHihokenshasuGroup 保険者設定段階別被保険者数合計entity;
    private final RDate 資格基準日;
    private final RDate 調定基準日;

    /**
     * コンストラクタです.
     *
     * @param 保険者設定段階別被保険者数合計entity HokenshaDankaibetsuHihokenshasuGroup
     * @param 資格基準日 RDate
     * @param 調定基準日 RDate
     */
    public ShotokuDankaiBetsuHihokenshasuIchiranHeaderEditor(
            HokenshaDankaibetsuHihokenshasuGroup 保険者設定段階別被保険者数合計entity, RDate 資格基準日, RDate 調定基準日) {
        this.保険者設定段階別被保険者数合計entity = 保険者設定段階別被保険者数合計entity;
        this.資格基準日 = 資格基準日;
        this.調定基準日 = 調定基準日;
    }

    @Override
    public ShotokuDankaiBetsuHihokenshasuIchiranSource edit(ShotokuDankaiBetsuHihokenshasuIchiranSource source) {
        source.shikakuKijunYmd = this.資格基準日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.choteiKijunYmd = this.調定基準日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        if (this.保険者設定段階別被保険者数合計entity.get市町村コード() != null
                && !this.保険者設定段階別被保険者数合計entity.get市町村コード().isEmpty()) {
            source.hokenshaNo = new RString(this.保険者設定段階別被保険者数合計entity.get市町村コード().toString());
        }
        return source;
    }

}
