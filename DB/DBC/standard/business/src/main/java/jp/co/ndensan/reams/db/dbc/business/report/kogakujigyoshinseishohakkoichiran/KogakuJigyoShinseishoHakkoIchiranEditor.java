/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshinseishohakkoichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuservicetsuchisho.KogakuJigyoShinseishoHakkoIchiranOrder;
import jp.co.ndensan.reams.db.dbc.business.report.util.ReportKomokuEditorUtil;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyoshinseishohakkoichiransource.KogakuJigyoShinseishoHakkoIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBC200091_高額総合事業サービス費申請書発行一覧表Editor
 *
 * @reamsid_L DBC-4770-120 jianglaisheng
 */
public class KogakuJigyoShinseishoHakkoIchiranEditor implements IKogakuJigyoShinseishoHakkoIchiranEditor {

    private final IOutputOrder 出力順;
    private final ShinseiJohoChohyoTempEntity 帳票出力対象データ;
    private final RDateTime システム日付;
    private final RString count;
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_8 = 8;
    private static final RString 丸 = new RString("○");
    private static final RString 定値_措 = new RString("措");
    private static final RString 定値_時 = new RString("時");
    private static final RString 定値_分 = new RString("分");
    private static final RString 定値_秒 = new RString("秒");

    /**
     * コンストラクタです
     *
     * @param parameter KogakuJigyoShinseishoHakkoIchiranParamter
     */
    public KogakuJigyoShinseishoHakkoIchiranEditor(KogakuJigyoShinseishoHakkoIchiranParamter parameter) {
        this.出力順 = parameter.get出力順();
        this.帳票出力対象データ = parameter.get帳票出力対象データ();
        this.システム日付 = parameter.getシステム日付();
        this.count = parameter.get連番();
    }

    /**
     * 帳票設計_DBC200091_高額総合事業サービス費申請書発行一覧表の項目編集です
     *
     * @param source KogakuJigyoShinseishoHakkoIchiranSource
     * @return KogakuJigyoShinseishoHakkoIchiranSource
     */
    @Override
    public KogakuJigyoShinseishoHakkoIchiranSource edit(
            KogakuJigyoShinseishoHakkoIchiranSource source) {
        source.shichosonNo = DbBusinessConfig
                .get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        source.shichosonName = DbBusinessConfig
                .get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (帳票出力対象データ.getShoKisaiHokenshaNoChohyo() != null) {
            source.証記載保険者番号 = 帳票出力対象データ.getShoKisaiHokenshaNoChohyo().getColumnValue();
        }
        source.tsuchishoNo = 帳票出力対象データ.getTsuchishoNoChohyo();
        RTime time = システム日付.getTime();
        RString hour = new RString(time.toString()).substringReturnAsPossible(INDEX_0, INDEX_2);
        RString min = new RString(time.toString()).substringReturnAsPossible(INDEX_3, INDEX_5);
        RString sec = new RString(time.toString()).substringReturnAsPossible(INDEX_6, INDEX_8);
        RString timeFormat = hour.concat(定値_時).concat(min).concat(定値_分).concat(sec).concat(定値_秒);
        source.printTimeStamp = システム日付.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(RString.FULL_SPACE).concat(timeFormat);
        source.listHakkoTaishosha_1 = count;
        if (帳票出力対象データ.getHihokenshaNoChohyo() != null) {
            source.listHakkoTaishosha_2 = 帳票出力対象データ.getHihokenshaNoChohyo().getColumnValue();
        }
        if (帳票出力対象データ.getServiceTeikyoYMChohyo() != null) {
            source.listHakkoTaishosha_3 = 帳票出力対象データ.getServiceTeikyoYMChohyo().wareki().toDateString();
        }
        if (帳票出力対象データ.getMeishoChohyo() != null) {
            source.listHakkoTaishosha_4 = 帳票出力対象データ.getMeishoChohyo().getColumnValue();
        }
        if (帳票出力対象データ.getYubinNoChohyo() != null) {
            source.listHakkoTaishosha_5 = 帳票出力対象データ.getYubinNoChohyo().getColumnValue();
        }
        source.listHakkoTaishosha_6 = 帳票出力対象データ.getEditJusho();
        if (帳票出力対象データ.getGyoseikuCodeChohyo() != null) {
            source.listHakkoTaishosha_7 = 帳票出力対象データ.getGyoseikuCodeChohyo().getColumnValue();
        }
        source.listHakkoTaishosha_8 = 帳票出力対象データ.getGyoseikuNameChohyo();
        if (帳票出力対象データ.isKyuSochishaFlagChohyo()) {
            source.listHakkoTaishosha_9 = 定値_措;
        }
        if (帳票出力対象データ.getYokaigoJotaiKubunCodeChohyo() != null) {
            source.listHakkoTaishosha_10 = 帳票出力対象データ.getYokaigoJotaiKubunCodeChohyo().getColumnValue();
        }
        if (帳票出力対象データ.getNinteiYukoKikanKaishiYMDChohyo() != null) {
            source.listHakkoTaishosha_11 = 帳票出力対象データ.getNinteiYukoKikanKaishiYMDChohyo().wareki().toDateString();
        }
        if (帳票出力対象データ.getNinteiYukoKikanShuryoYMDChohyo() != null) {
            source.listHakkoTaishosha_12 = 帳票出力対象データ.getNinteiYukoKikanShuryoYMDChohyo().wareki().toDateString();
        }
        if (帳票出力対象データ.getHonninShiharaiGakuChohyo() != null) {
            source.listHakkoTaishosha_13 = DecimalFormatter.toコンマ区切りRString(帳票出力対象データ.getHonninShiharaiGakuChohyo(), INDEX_0);
        }
        if (帳票出力対象データ.getShikyuKingakuChohyo() != null) {
            source.listHakkoTaishosha_14 = DecimalFormatter.toコンマ区切りRString(帳票出力対象データ.getShikyuKingakuChohyo(), INDEX_0);
        }
        if (帳票出力対象データ.isHojinKeigenTaishoFlagChohyo()) {
            source.listHakkoTaishosha_15 = 丸;
        }
        if (帳票出力対象データ.isJidoShokanTaishoFlagChohyo()) {
            source.listHakkoTaishosha_16 = 丸;
        }
        if (帳票出力対象データ.getShikakuSoshitsuJiyuCodeChohyo() != null) {
            source.listHakkoTaishosha_17 = 丸;
        }
        source.識別コード = 帳票出力対象データ.getShikibetsuCodeChohyo();
        source.拡張情報 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                ReportKomokuEditorUtil.get非空文字列(source.listHakkoTaishosha_2));
        editIOutputOrder(source);
        return source;
    }

    /**
     * 帳票設計_DBC200091_高額総合事業サービス費申請書発行一覧表の項目編集です
     *
     * @param source KogakuJigyoShinseishoHakkoIchiranSource
     */
    public void editIOutputOrder(KogakuJigyoShinseishoHakkoIchiranSource source) {
        List<ISetSortItem> list = null;
        if (出力順 != null) {
            list = 出力順.get設定項目リスト();
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        List<RString> list改頁項目ID = new ArrayList();
        if (list.size() > INDEX_0 && list.get(INDEX_0).is改頁項目()) {
            list改頁項目ID.add(list.get(INDEX_0).get項目ID());
        }
        if (list.size() > INDEX_1 && list.get(INDEX_1).is改頁項目()) {
            list改頁項目ID.add(list.get(INDEX_1).get項目ID());
        }
        if (list.size() > INDEX_2 && list.get(INDEX_2).is改頁項目()) {
            list改頁項目ID.add(list.get(INDEX_2).get項目ID());
        }
        if (list.size() > INDEX_3 && list.get(INDEX_3).is改頁項目()) {
            list改頁項目ID.add(list.get(INDEX_3).get項目ID());
        }
        if (list.size() > INDEX_4 && list.get(INDEX_4).is改頁項目()) {
            list改頁項目ID.add(list.get(INDEX_4).get項目ID());
        }
        set改頁項目1(list改頁項目ID, source);
        set改頁項目2(list改頁項目ID, source);
        set改頁項目3(list改頁項目ID, source);
        set改頁項目4(list改頁項目ID, source);
        set改頁項目5(list改頁項目ID, source);

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

    private void set改頁項目1(List<RString> list改頁項目ID, KogakuJigyoShinseishoHakkoIchiranSource source) {
        if (list改頁項目ID.size() > INDEX_0) {
            RString 項目ID = list改頁項目ID.get(INDEX_0);
            if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.証記載保険者番号.get項目ID())) {
                source.kaipage1 = source.証記載保険者番号;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.郵便番号.get項目ID())) {
                source.kaipage1 = source.listHakkoTaishosha_5;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.行政区コード.get項目ID())) {
                source.kaipage1 = source.listHakkoTaishosha_7;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.氏名５０音カナ.get項目ID())) {
                source.kaipage1 = source.listHakkoTaishosha_4;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.被保険者番号.get項目ID())) {
                source.kaipage1 = source.listHakkoTaishosha_2;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.サービス提供年月.get項目ID())) {
                source.kaipage1 = source.listHakkoTaishosha_3;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.通知書番号.get項目ID())) {
                source.kaipage1 = source.tsuchishoNo;
            }
        }
    }

    private void set改頁項目2(List<RString> list改頁項目ID, KogakuJigyoShinseishoHakkoIchiranSource source) {
        if (list改頁項目ID.size() > INDEX_1) {
            RString 項目ID = list改頁項目ID.get(INDEX_1);
            if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.証記載保険者番号.get項目ID())) {
                source.kaipage2 = source.証記載保険者番号;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.郵便番号.get項目ID())) {
                source.kaipage2 = source.listHakkoTaishosha_5;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.行政区コード.get項目ID())) {
                source.kaipage2 = source.listHakkoTaishosha_7;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.氏名５０音カナ.get項目ID())) {
                source.kaipage2 = source.listHakkoTaishosha_4;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.被保険者番号.get項目ID())) {
                source.kaipage2 = source.listHakkoTaishosha_2;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.サービス提供年月.get項目ID())) {
                source.kaipage2 = source.listHakkoTaishosha_3;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.通知書番号.get項目ID())) {
                source.kaipage2 = source.tsuchishoNo;
            }
        }
    }

    private void set改頁項目3(List<RString> list改頁項目ID, KogakuJigyoShinseishoHakkoIchiranSource source) {
        if (list改頁項目ID.size() > INDEX_2) {
            RString 項目ID = list改頁項目ID.get(INDEX_2);
            if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.証記載保険者番号.get項目ID())) {
                source.kaipage3 = source.証記載保険者番号;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.郵便番号.get項目ID())) {
                source.kaipage3 = source.listHakkoTaishosha_5;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.行政区コード.get項目ID())) {
                source.kaipage3 = source.listHakkoTaishosha_7;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.氏名５０音カナ.get項目ID())) {
                source.kaipage3 = source.listHakkoTaishosha_4;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.被保険者番号.get項目ID())) {
                source.kaipage3 = source.listHakkoTaishosha_2;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.サービス提供年月.get項目ID())) {
                source.kaipage3 = source.listHakkoTaishosha_3;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.通知書番号.get項目ID())) {
                source.kaipage3 = source.tsuchishoNo;
            }
        }
    }

    private void set改頁項目4(List<RString> list改頁項目ID, KogakuJigyoShinseishoHakkoIchiranSource source) {
        if (list改頁項目ID.size() > INDEX_3) {
            RString 項目ID = list改頁項目ID.get(INDEX_3);
            if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.証記載保険者番号.get項目ID())) {
                source.kaipage4 = source.証記載保険者番号;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.郵便番号.get項目ID())) {
                source.kaipage4 = source.listHakkoTaishosha_5;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.行政区コード.get項目ID())) {
                source.kaipage4 = source.listHakkoTaishosha_7;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.氏名５０音カナ.get項目ID())) {
                source.kaipage4 = source.listHakkoTaishosha_4;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.被保険者番号.get項目ID())) {
                source.kaipage4 = source.listHakkoTaishosha_2;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.サービス提供年月.get項目ID())) {
                source.kaipage4 = source.listHakkoTaishosha_3;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.通知書番号.get項目ID())) {
                source.kaipage4 = source.tsuchishoNo;
            }
        }
    }

    private void set改頁項目5(List<RString> list改頁項目ID, KogakuJigyoShinseishoHakkoIchiranSource source) {
        if (list改頁項目ID.size() > INDEX_4) {
            RString 項目ID = list改頁項目ID.get(INDEX_4);
            if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.証記載保険者番号.get項目ID())) {
                source.kaipage5 = source.証記載保険者番号;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.郵便番号.get項目ID())) {
                source.kaipage5 = source.listHakkoTaishosha_5;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.行政区コード.get項目ID())) {
                source.kaipage5 = source.listHakkoTaishosha_7;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.氏名５０音カナ.get項目ID())) {
                source.kaipage5 = source.listHakkoTaishosha_4;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.被保険者番号.get項目ID())) {
                source.kaipage5 = source.listHakkoTaishosha_2;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.サービス提供年月.get項目ID())) {
                source.kaipage5 = source.listHakkoTaishosha_3;
            } else if (項目ID.equals(KogakuJigyoShinseishoHakkoIchiranOrder.通知書番号.get項目ID())) {
                source.kaipage5 = source.tsuchishoNo;
            }
        }
    }
}
