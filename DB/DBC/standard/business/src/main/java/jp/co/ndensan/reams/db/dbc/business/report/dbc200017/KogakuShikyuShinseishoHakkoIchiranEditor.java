/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200017;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshinseishohakkoichiran.KogakuJigyoShinseishoHakkoIchiranParamter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200017.KogakuShikyuShinseishoHakkoIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBC200017_高額介護サービス費支給申請書発行一覧表BodyEditor
 *
 * @reamsid_L DBC-4770-130 jiangxiaolong
 */
public class KogakuShikyuShinseishoHakkoIchiranEditor
        implements IKogakuShikyuShinseishoHakkoIchiranEditor {

    private final ShinseiJohoChohyoTempEntity entity;
    private final IOutputOrder 出力順;
    private final RDateTime システム日付;
    private final RString count;
    private static final RString 措 = new RString("措");
    private static final RString 丸 = new RString("○");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_8 = 8;

    /**
     * コンストラクタです
     *
     * @param parameter KogakuJigyoShinseishoHakkoIchiranParamter
     */
    public KogakuShikyuShinseishoHakkoIchiranEditor(
            KogakuJigyoShinseishoHakkoIchiranParamter parameter) {
        this.entity = parameter.get帳票出力対象データ();
        this.出力順 = parameter.get出力順();
        this.システム日付 = parameter.getシステム日付();
        this.count = parameter.get連番();
    }

    @Override
    public KogakuShikyuShinseishoHakkoIchiranSource edit(
            KogakuShikyuShinseishoHakkoIchiranSource source) {
        editSource(source);
        source.拡張情報 = new ExpandedInformation(Code.EMPTY, RString.EMPTY, source.listHakkoTaishosha_2);
        return source;
    }

    private void editSource(KogakuShikyuShinseishoHakkoIchiranSource source) {
        source.shichosonNo = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        source.shichosonName = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        editIOutputOrder(source);
        RTime time = システム日付.getTime();
        RString hour = new RString(time.toString()).substringReturnAsPossible(INDEX_0, INDEX_2);
        RString min = new RString(time.toString()).substringReturnAsPossible(INDEX_3, INDEX_5);
        RString sec = new RString(time.toString()).substringReturnAsPossible(INDEX_6, INDEX_8);
        RString timeFormat = hour.concat("時").concat(min).concat("分").concat(sec).concat("秒");
        source.printTimeStamp = システム日付.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(RString.FULL_SPACE).concat(timeFormat);
        source.listHakkoTaishosha_1 = count;
        source.listHakkoTaishosha_2 = getColumnValue(entity.getHihokenshaNoChohyo());
        source.listHakkoTaishosha_3 = getパターン51(entity.getServiceTeikyoYMChohyo());
        source.listHakkoTaishosha_4 = getColumnValue(entity.getMeishoChohyo());
        source.listHakkoTaishosha_5 = getColumnValue(entity.getYubinNoChohyo());
        source.listHakkoTaishosha_6 = getColumnValue(entity.getJushoChohyo());
        source.listHakkoTaishosha_7 = getColumnValue(entity.getGyoseikuCodeChohyo());
        source.listHakkoTaishosha_8 = entity.getGyoseikuNameChohyo();
        if (entity.isKyuSochishaFlagChohyo()) {
            source.listHakkoTaishosha_9 = 措;
        } else {
            source.listHakkoTaishosha_9 = RString.EMPTY;
        }
        source.listHakkoTaishosha_10 = getColumnValue(entity.getYokaigoJotaiKubunCodeChohyo());
        source.listHakkoTaishosha_11 = getパターン1(entity.getNinteiYukoKikanKaishiYMDChohyo());
        source.listHakkoTaishosha_12 = getパターン1(entity.getNinteiYukoKikanShuryoYMDChohyo());
        source.listHakkoTaishosha_13 = get共通ポリシー金額1(entity.getHonninShiharaiGakuChohyo());
        source.listHakkoTaishosha_14 = get共通ポリシー金額1(entity.getShikyuKingakuChohyo());
        if (entity.isHojinKeigenTaishoFlagChohyo()) {
            source.listHakkoTaishosha_15 = 丸;
        } else {
            source.listHakkoTaishosha_15 = RString.EMPTY;
        }
        if (entity.isJidoShokanTaishoFlagChohyo()) {
            source.listHakkoTaishosha_16 = 丸;
        } else {
            source.listHakkoTaishosha_16 = RString.EMPTY;
        }
        if (entity.getShikakuSoshitsuJiyuCodeChohyo() != null) {
            source.listHakkoTaishosha_17 = 丸;
        }
        source.氏名カナ = entity.getShimeikanaChohyo() == null ? RString.EMPTY : entity.getShimeikanaChohyo().value();
        source.shikibetsuCode = getColumnValue(entity.getShikibetsuCodeChohyo());
        source.choikiCode = getColumnValue(entity.getChoikiCodeChohyo());
        source.市町村コード = getColumnValue(entity.getShichosonCodeChohyo());
        source.証記載保険者番号 = getColumnValue(entity.getShoKisaiHokenshaNoChohyo());
        source.自動償還対象フラグ = entity.isJidoShokanTaishoFlagChohyo();
    }

    private void editIOutputOrder(KogakuShikyuShinseishoHakkoIchiranSource source) {
        List<ISetSortItem> list = null;
        if (出力順 != null) {
            list = 出力順.get設定項目リスト();
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        if (list.size() > INDEX_0 && list.get(INDEX_0).is改頁項目()) {
            source.kaipage1 = list.get(INDEX_0).get項目名();
        }
        if (list.size() > INDEX_1 && list.get(INDEX_1).is改頁項目()) {
            source.kaipage2 = list.get(INDEX_1).get項目名();
        }
        if (list.size() > INDEX_2 && list.get(INDEX_2).is改頁項目()) {
            source.kaipage3 = list.get(INDEX_2).get項目名();
        }
        if (list.size() > INDEX_3 && list.get(INDEX_3).is改頁項目()) {
            source.kaipage4 = list.get(INDEX_3).get項目名();
        }
        if (list.size() > INDEX_4 && list.get(INDEX_4).is改頁項目()) {
            source.kaipage5 = list.get(INDEX_4).get項目名();
        }

        if (list.size() > INDEX_0) {
            source.shutsuryokujun1 = list.get(INDEX_0).get項目名();
        }
        if (list.size() > INDEX_1) {
            source.shutsuryokujun2 = list.get(INDEX_1).get項目名();
        }
        if (list.size() > INDEX_2) {
            source.shutsuryokujun3 = list.get(INDEX_2).get項目名();
        }
        if (list.size() > INDEX_3) {
            source.shutsuryokujun4 = list.get(INDEX_3).get項目名();
        }
        if (list.size() > INDEX_4) {
            source.shutsuryokujun5 = list.get(INDEX_4).get項目名();
        }
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private RString getパターン51(FlexibleYearMonth 年月) {
        if (年月 != null && !年月.isEmpty()) {
            return 年月.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    private RString getパターン1(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return 年月日.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    private RString get共通ポリシー金額1(Decimal 金額) {
        if (null == 金額) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(金額, 0);
    }

}
