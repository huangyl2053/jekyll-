/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.furikomimeisaiichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.furikaego.FurikaeGoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiran.FurikomiMeisaiIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票設計_DBC200003_振込明細一覧表（高額合算） HeaderEditorクラスです。
 *
 * @reamsid_L DBC-4870-060 lijian
 */
public class FurikomiMeisaiIchiranHeaderEditor implements IFurikomiMeisaiIchiranEditor {

    private final FurikaeGoMeisaiEntity 振込明細一覧Entity;
    private final IOutputOrder 出力順情報;
    private static final RString 日時作成 = new RString("作成");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    /**
     * コンストラクタです。
     *
     * @param 振込明細一覧Entity FurikaeGoMeisaiEntity
     * @param 出力順情報 IOutputOrder
     */
    public FurikomiMeisaiIchiranHeaderEditor(FurikaeGoMeisaiEntity 振込明細一覧Entity, IOutputOrder 出力順情報) {
        this.振込明細一覧Entity = 振込明細一覧Entity;
        this.出力順情報 = 出力順情報;
    }

    @Override
    public FurikomiMeisaiIchiranSource edit(FurikomiMeisaiIchiranSource source) {

        source.printTimeStamp = get印刷日時(YMDHMS.now());
        source.title = 振込明細一覧Entity.get帳票タイトル();
        source.hokenshaNo = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        source.hokenshaName = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);

        RString 並び順１ = RString.EMPTY;
        RString 並び順２ = RString.EMPTY;
        RString 並び順３ = RString.EMPTY;
        RString 並び順４ = RString.EMPTY;
        RString 並び順５ = RString.EMPTY;

        List<ISetSortItem> list;
        if (出力順情報 != null) {
            list = 出力順情報.get設定項目リスト();
        } else {
            list = null;
        }
        if (list == null) {
            list = new ArrayList<>();
        }

        if (list.size() > INDEX_0) {
            並び順１ = list.get(INDEX_0).get項目名();
        }
        if (list.size() > INDEX_1) {
            並び順２ = list.get(INDEX_1).get項目名();
        }
        if (list.size() > INDEX_2) {
            並び順３ = list.get(INDEX_2).get項目名();
        }
        if (list.size() > INDEX_3) {
            並び順４ = list.get(INDEX_3).get項目名();
        }
        if (list.size() > INDEX_4) {
            並び順５ = list.get(INDEX_4).get項目名();
        }

        source.shutsuryokujun1 = 並び順１;
        source.shutsuryokujun2 = 並び順２;
        source.shutsuryokujun3 = 並び順３;
        source.shutsuryokujun4 = 並び順４;
        source.shutsuryokujun5 = 並び順５;

        return source;
    }

    private RString get印刷日時(YMDHMS datetime) {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(datetime.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK)
                .toDateString());
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(datetime.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(日時作成);
        return sakuseiYMD.toRString();
    }

}
