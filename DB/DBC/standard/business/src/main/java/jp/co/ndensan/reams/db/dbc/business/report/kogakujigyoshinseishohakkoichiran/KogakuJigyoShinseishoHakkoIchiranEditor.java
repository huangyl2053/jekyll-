/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshinseishohakkoichiran;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyoshinseishohakkoichiransource.KogakuJigyoShinseishoHakkoIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

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
    private final RString 市町村名;
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_8 = 8;
    private static final RString 丸 = new RString("○");

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
        this.市町村名 = parameter.get市町村名();
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
        if (帳票出力対象データ.getShoKisaiHokenshaNoChohyo() != null) {
            source.shichosonNo = 帳票出力対象データ.getShoKisaiHokenshaNoChohyo().getColumnValue();
        }
        source.shichosonName = 市町村名;
        editIOutputOrder(source);
        RTime time = システム日付.getTime();
        RString hour = new RString(time.toString()).substringReturnAsPossible(INDEX_0, INDEX_2);
        RString min = new RString(time.toString()).substringReturnAsPossible(INDEX_3, INDEX_5);
        RString sec = new RString(time.toString()).substringReturnAsPossible(INDEX_6, INDEX_8);
        RString timeFormat = hour.concat("時").concat(min).concat("分").concat(sec).concat("秒");
        source.printTimeStamp = システム日付.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(RString.FULL_SPACE).concat(timeFormat);
        source.listHakkoTaishosha_1 = count;
        if (帳票出力対象データ.getHihokenshaNoChohyo() != null) {
            source.listHakkoTaishosha_2 = 帳票出力対象データ.getHihokenshaNoChohyo().getColumnValue();
        }
        if (帳票出力対象データ.getServiceTeikyoYMChohyo() != null) {
            source.listHakkoTaishosha_3 = 帳票出力対象データ.getServiceTeikyoYMChohyo().wareki().toDateString();
        }
        if (帳票出力対象データ.getShinseishaShimeiChohyo() != null) {
            source.listHakkoTaishosha_4 = 帳票出力対象データ.getShinseishaShimeiChohyo().getColumnValue();
        }
        if (帳票出力対象データ.getYubinNo() != null) {
            source.listHakkoTaishosha_5 = 帳票出力対象データ.getYubinNo().getColumnValue();
        }
        if (帳票出力対象データ.getJusho() != null) {
            source.listHakkoTaishosha_6 = 帳票出力対象データ.getJusho().getColumnValue();
        }
        if (帳票出力対象データ.getGyoseikuCode() != null) {
            source.listHakkoTaishosha_7 = 帳票出力対象データ.getGyoseikuCode().getColumnValue();
        }
        source.listHakkoTaishosha_8 = 帳票出力対象データ.getGyoseikuName();
        source.listHakkoTaishosha_9 = new RString(String.valueOf(帳票出力対象データ.isKyuSochishaFlag()));
        if (帳票出力対象データ.getYokaigoJotaiKubunCode() != null) {
            source.listHakkoTaishosha_10 = 帳票出力対象データ.getYokaigoJotaiKubunCode().getColumnValue();
        }
        if (帳票出力対象データ.getNinteiYukoKikanKaishiYMD() != null) {
            source.listHakkoTaishosha_11 = 帳票出力対象データ.getNinteiYukoKikanKaishiYMD().wareki().toDateString();
        }
        if (帳票出力対象データ.getNinteiYukoKikanShuryoYMD() != null) {
            source.listHakkoTaishosha_12 = 帳票出力対象データ.getNinteiYukoKikanShuryoYMD().wareki().toDateString();
        }
        NumberFormat currency = NumberFormat.getNumberInstance();
        if (帳票出力対象データ.getHonninShiharaiGakuChohyo() != null) {
            source.listHakkoTaishosha_13 = new RString(currency.format(帳票出力対象データ.getHonninShiharaiGakuChohyo()));
        }
        if (帳票出力対象データ.getShikyuKingakuChohyo() != null) {
            source.listHakkoTaishosha_14 = new RString(currency.format(帳票出力対象データ.getShikyuKingakuChohyo()));
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
}
