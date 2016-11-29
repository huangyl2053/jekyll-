/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.shotokudankaibetsuhihokenshasuichiran;

import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.entity.report.shotokudankaibetsuhihokenshasuichiran.ShotokuDankaiBetsuHihokenshasuIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 段階別被保険者数一覧表帳票クラスです。
 *
 * @reamsid_L DBB-1820-060 zhouchuanlin
 */
public class ShotokuDankaiBetsuHihokenshasuIchiranBodyEditor implements IShotokuDankaiBetsuHihokenshasuIchiranEditor {

    private final HokenshaDankaibetsuHihokenshasuGroup 保険者設定段階別被保険者数合計entity;
    private final HyojunDankaibetsuHihokenshasuGroup 標準設定段階別被保険者数合計entity;
    private final YMDHMS 作成日時;
    private final FlexibleYear 年度;
    private final HokenryoDankaiList hokenryoDankaiList;
    private static final RString 作成 = new RString("作成");
    private static final RString 度 = new RString("度");
    private static final RString ゼロ = new RString("0");
    private static final RString 文字列_第 = new RString("第");
    private static final RString 文字列_段階 = new RString("段階");

    /**
     * コンストラクタです.
     *
     * @param 保険者設定段階別被保険者数合計entity HokenshaDankaibetsuHihokenshasuGroup
     * @param 標準設定段階別被保険者数合計entity HyojunDankaibetsuHihokenshasuGroup
     * @param 作成日時 YMDHMS
     * @param 年度 FlexibleYear
     * @param hokenryoDankaiList HokenryoDankaiList
     */
    public ShotokuDankaiBetsuHihokenshasuIchiranBodyEditor(
            HokenshaDankaibetsuHihokenshasuGroup 保険者設定段階別被保険者数合計entity,
            HyojunDankaibetsuHihokenshasuGroup 標準設定段階別被保険者数合計entity,
            YMDHMS 作成日時, FlexibleYear 年度,
            HokenryoDankaiList hokenryoDankaiList) {
        this.保険者設定段階別被保険者数合計entity = 保険者設定段階別被保険者数合計entity;
        this.標準設定段階別被保険者数合計entity = 標準設定段階別被保険者数合計entity;
        this.作成日時 = 作成日時;
        this.年度 = 年度;
        this.hokenryoDankaiList = hokenryoDankaiList;
    }

    @Override
    public ShotokuDankaiBetsuHihokenshasuIchiranSource edit(ShotokuDankaiBetsuHihokenshasuIchiranSource source) {
        RString 印刷時間_年月日 = this.作成日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 印刷時間_時 = RDate.getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        source.printTimeStamp = 印刷時間_年月日.concat(RString.HALF_SPACE).concat(印刷時間_時).concat(RString.HALF_SPACE).concat(作成);
        source.nendo = this.年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                separator(Separator.JAPANESE).toDateString().concat(度);
        setBody(source);
        return source;
    }

    private void setBody(ShotokuDankaiBetsuHihokenshasuIchiranSource source) {

        if (保険者設定段階別被保険者数合計entity != null && !RString.isNullOrEmpty(this.保険者設定段階別被保険者数合計entity.get市町村名称())) {
            source.hokenshaName = this.保険者設定段階別被保険者数合計entity.get市町村名称();
        }
        if (保険者設定段階別被保険者数合計entity != null && null != this.hokenryoDankaiList
                && !RString.isNullOrEmpty(this.保険者設定段階別被保険者数合計entity.get保険者設定段階())) {
            source.list_1 = this.hokenryoDankaiList.getBy段階区分(this.保険者設定段階別被保険者数合計entity.get保険者設定段階()).get表記();
        }
        if (保険者設定段階別被保険者数合計entity != null && null != this.保険者設定段階別被保険者数合計entity.get保険者設定人数()) {
            source.list_2 = doカンマ編集(this.保険者設定段階別被保険者数合計entity.get保険者設定人数());
        }
        if (this.標準設定段階別被保険者数合計entity != null && !RString.isNullOrEmpty(this.標準設定段階別被保険者数合計entity.get保険者設定段階())) {
            source.list_3
                    = 文字列_第.concat(this.標準設定段階別被保険者数合計entity.get保険者設定段階().replace(ゼロ, RString.EMPTY)).concat(文字列_段階);
        }
        if (this.標準設定段階別被保険者数合計entity != null && null != this.標準設定段階別被保険者数合計entity.get保険者設定人数()) {
            source.list_4 = doカンマ編集(this.標準設定段階別被保険者数合計entity.get保険者設定人数());
        }
        if (RString.isNullOrEmpty(source.hokenshaNo) && this.標準設定段階別被保険者数合計entity != null
                && this.標準設定段階別被保険者数合計entity.get市町村コード() != null) {
            source.hokenshaNo = new RString(this.標準設定段階別被保険者数合計entity.get市町村コード().toString());
        }
        if (RString.isNullOrEmpty(source.hokenshaName) && this.標準設定段階別被保険者数合計entity != null
                && this.標準設定段階別被保険者数合計entity.get市町村名称() != null) {
            source.hokenshaName = this.標準設定段階別被保険者数合計entity.get市町村名称();
        }
        if (source.hokenshaNo == null) {
            source.hokenshaNo = RString.EMPTY;
        }
    }

    private RString doカンマ編集(Decimal decimal) {
        if (null != decimal) {
            return DecimalFormatter.toコンマ区切りRString(decimal, 0);
        }
        return RString.EMPTY;
    }

}
