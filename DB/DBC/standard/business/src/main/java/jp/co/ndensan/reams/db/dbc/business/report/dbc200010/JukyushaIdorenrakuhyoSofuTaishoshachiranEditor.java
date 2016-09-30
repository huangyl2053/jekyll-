/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200010;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200010.JukyushaIdorenrakuhyoSofuTaishoshachiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200010.JukyushaIdorenrakuhyoSofuTaishoshachiranSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票設計_DBCMNF1001_1_受給者異動連絡票情報送付対象者リストBodyEditor
 *
 * @reamsid_L DBC-2720-040 jiangxiaolong
 */
public class JukyushaIdorenrakuhyoSofuTaishoshachiranEditor
        implements IJukyushaIdorenrakuhyoSofuTaishoshachiranEditor {

    private final JukyushaIdorenrakuhyoSofuTaishoshachiranEntity entity;
    private final RString 市町村コード;
    private final RString 市町村名称;
    private static final RString 受給者異動連絡票情報送付対象者リスト = new RString("受給者異動連絡票情報送付対象者リスト");
    private static final RString SAKUSEI = new RString("作成");

    /**
     * コンストラクタです
     *
     * @param entity JukyushaIdorenrakuhyoSofuTaishoshachiranEntity
     * @param 市町村コード RString
     * @param 市町村名称 RString
     */
    public JukyushaIdorenrakuhyoSofuTaishoshachiranEditor(
            JukyushaIdorenrakuhyoSofuTaishoshachiranEntity entity,
            RString 市町村コード, RString 市町村名称) {
        this.entity = entity;
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
    }

    @Override
    public JukyushaIdorenrakuhyoSofuTaishoshachiranSource edit(
            JukyushaIdorenrakuhyoSofuTaishoshachiranSource source) {
        if (null == entity) {
            return source;
        }
        editSource(source);
        return source;
    }

    private void editSource(JukyushaIdorenrakuhyoSofuTaishoshachiranSource source) {
        RDateTime 作成日時 = RDateTime.now();
        RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        source.title = 受給者異動連絡票情報送付対象者リスト;
        source.shichosonCd = 市町村コード;
        source.shichosonName = 市町村名称;
        source.listTaishosha_1 = entity.get被保険者番号();
        source.listTaishosha_2 = entity.get氏名();
        source.listTaishosha_3 = entity.get区分();
        source.listTaishosha_4 = getパターン4(entity.get異動年月日());
        source.listTaishosha_5 = entity.get要介護度();
        source.listTaishosha_6 = getパターン4(entity.get開始認定日());
        source.listTaishosha_7 = getパターン4(entity.get終了認定日());
        source.listTaishosha_8 = entity.get変更項目();
    }

    private static RString getパターン4(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
    }
}
