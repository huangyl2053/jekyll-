/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA7030011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tajushochitokureisyakanri.TaJushochiTokureisyaKanriMaster;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7030011.TatokureiHenkoTsuchishoHakkoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7030011.dgJushochiTokureiRireki_Row;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokurei;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokureiIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.ur.urz.business.core.hokenja.Hokenja;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.hokenja.HokenjaManagerFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 他特例施設変更通知書発行のバリデーションチェッククラスです。
 *
 * @reamsid_L DBA-0380-020 houtianpeng
 */
public class TatokureiHenkoTsuchishoHakkoHandler {

    private final TatokureiHenkoTsuchishoHakkoDiv div;
    private final HokenjaShubetsu 介護保険 = new HokenjaShubetsu(new RString("08"));
    private final RString 役場_役所名敬称 = new RString("役場・役所名敬称");
    private final RString 担当課名 = new RString("担当課名");
    private final RString 担当課名敬称 = new RString("担当課名敬称");
    private static final CodeShubetsu 介護他特適用理由 = new CodeShubetsu("0008");
    private static final CodeShubetsu 介護他特解除理由 = new CodeShubetsu("0011");

    /**
     * コンストラクタです。
     *
     * @param div 他特例施設変更通知書発行Div
     */
    public TatokureiHenkoTsuchishoHakkoHandler(TatokureiHenkoTsuchishoHakkoDiv div) {
        this.div = div;
    }

    /**
     * 適用情報Gridの設定。
     *
     * 
     * @param masterList 適用情報取得
     */
    public void 適用情報Gridの設定(List<TaJushochiTokureisyaKanriMaster> masterList) {
        List<dgJushochiTokureiRireki_Row> rowList = new ArrayList<>();
        for (TaJushochiTokureisyaKanriMaster master : masterList) {

            dgJushochiTokureiRireki_Row row = new dgJushochiTokureiRireki_Row();
            適用情報Gridの編集(master, row);
            rowList.add(row);
        }
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().setDisabled(true);
        div.getTajutokuTekiyoJohoIchiran().getDgJushochiTokureiRireki().setDataSource(rowList);
    }

    private void 適用情報Gridの編集(TaJushochiTokureisyaKanriMaster master, dgJushochiTokureiRireki_Row row) {

        Hokenja hokenja = 保険者情報取得(master.getSochiHokenshaNo() == null
                ? new HokenjaNo(RString.EMPTY) : new HokenjaNo(master.getSochiHokenshaNo().value()));
        row.setTekiyoJiyu(get適用事由(master.getTekiyoJiyuCode()));
        row.getTekiyoDate().setValue(master.getTekiyoYMD() == null ? FlexibleDate.EMPTY : master.getTekiyoYMD());
        row.getTekiyoTodokedeDate().setValue(master.getTekiyoTodokedeYMD() == null ? FlexibleDate.EMPTY : master.getTekiyoTodokedeYMD());
        row.setKaijoJiyu(get解除事由(master.getKaijoJiyuCode()));
        row.getKaijoDate().setValue(master.getKaijoYMD() == null ? FlexibleDate.EMPTY : master.getKaijoYMD());
        row.getKaijoTodokedeDate().setValue(master.getKaijoTodokedeYMD() == null ? FlexibleDate.EMPTY : master.getKaijoTodokedeYMD());
        row.setSochiHokenshaNo(master.getSochiHokenshaNo() == null ? RString.EMPTY : master.getSochiHokenshaNo().value());
        row.setSochiHokenshaMeisho(hokenja.get保険者名() == null ? RString.EMPTY : hokenja.get保険者名());
        row.setSochiHihokenshaNo(master.getSochiHihokenshaNo() == null ? RString.EMPTY : master.getSochiHihokenshaNo().value());
        row.getNyushoDate().setValue(master.getNyushoYMD() == null ? FlexibleDate.EMPTY : master.getNyushoYMD());
        row.getTaishoDate().setValue(master.getTaishoYMD() == null ? FlexibleDate.EMPTY : master.getTaishoYMD());
        row.setShisetsuShurui(master.getNyushoShisetsuShurui() == null ? RString.EMPTY
                : ShisetsuType.toValue(master.getNyushoShisetsuShurui()).getName());
        row.setNyushoShisetsu(master.getNyushoShisetsuCode() == null ? RString.EMPTY : master.getNyushoShisetsuCode().value());
        row.getRenrakuhyoHakkoDate().setValue(master.getTatokuRenrakuhyoHakkoYMD() == null
                ? FlexibleDate.EMPTY : master.getTatokuRenrakuhyoHakkoYMD());
        row.getShisetuTaishoTuchiHakkoDate().setValue(master.getShisetsuTaishoTsuchiHakkoYMD() == null
                ? FlexibleDate.EMPTY : master.getShisetsuTaishoTsuchiHakkoYMD());
        row.getShisetsuHenkoTuchiHakkoDate().setValue(master.getShisetsuHenkoTsuchiHakkoYMD() == null
                ? FlexibleDate.EMPTY : master.getShisetsuHenkoTsuchiHakkoYMD());
        row.getIdoYMD().setValue(master.getIdoYMD());
        row.setEdaNo(master.getEdaNo() == null ? RString.EMPTY : master.getEdaNo());
    }

    /**
     * 初期化か表示され、編集ができる。
     *
     * @param reportId ReportId
     */
    public void 適用情報の名称編集(ReportId reportId) {

        if (帳票制御情報の取得(reportId, 役場_役所名敬称) != null) {

            div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtOnchu().
                    setValue(帳票制御情報の取得(reportId, 役場_役所名敬称).get設定値() == null
                            ? RString.EMPTY : 帳票制御情報の取得(reportId, 役場_役所名敬称).get設定値());
        }

        if (帳票制御情報の取得(reportId, 担当課名) != null) {
            div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtTantokamei().
                    setValue(帳票制御情報の取得(reportId, 担当課名).get設定値() == null
                            ? RString.EMPTY : 帳票制御情報の取得(reportId, 担当課名).get設定値());
        }

        if (帳票制御情報の取得(reportId, 担当課名敬称) != null) {
            div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtSam().
                    setValue(帳票制御情報の取得(reportId, 担当課名敬称).get設定値() == null
                            ? RString.EMPTY : 帳票制御情報の取得(reportId, 担当課名敬称).get設定値());
        }
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().setIsPublish(false);
    }

    /**
     * 編集内容か表示され、編集ができる。
     *
     * @param 文書番号取得 文書番号取得
     */
    public void 適用情報の編集(RString 文書番号取得) {

        dgJushochiTokureiRireki_Row row = div.getTajutokuTekiyoJohoIchiran().getDgJushochiTokureiRireki().getActiveRow();
        Hokenja hokenja = 保険者情報取得(new HokenjaNo(row.getSochiHokenshaNo()));
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().
                getTxtYubinNo().setValue(hokenja.get郵便番号() == null ? YubinNo.EMPTY : hokenja.get郵便番号());
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtJusho().
                setValue(hokenja.get住所() == null ? RString.EMPTY : hokenja.get住所());
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtYakushoMei().setValue(row.getSochiHokenshaMeisho());
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtBunshoBango().setValue(文書番号取得);
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().set枝番(row.getEdaNo());
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().
                set異動日(new RString(row.getIdoYMD().getValue().toString()));
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().set入所日(new RString(row.getNyushoDate().getValue().toString()));
        if (row.getShisetsuHenkoTuchiHakkoDate().getValue().isEmpty()) {
            div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().
                    getCcdPrintContentsSetting().initialize(true, RDate.getNowDate(), true, false, RDate.MAX, false);
        } else {
            div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().
                    getCcdPrintContentsSetting().initialize(true, new RDate(row.
                                    getShisetsuHenkoTuchiHakkoDate().getValue().toString()), true, false, RDate.MAX, false);
        }
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().setDisabled(false);
    }

    /**
     * 他特例施設変更通知書の編集。
     *
     * @param 他市町村住所地特例 他市町村住所地特例
     * @param 識別コード 識別コード
     * @return TashichosonJushochiTokurei
     */
    public TashichosonJushochiTokurei 他特例施設変更通知書の編集(Models<TashichosonJushochiTokureiIdentifier, TashichosonJushochiTokurei> 他市町村住所地特例,
            ShikibetsuCode 識別コード) {

        TashichosonJushochiTokureiIdentifier 更新前住所地特例
                = new TashichosonJushochiTokureiIdentifier(識別コード, new FlexibleDate(div.getTajutokuTekiyoJohoIchiran().
                                getReportPublish().getHenshuNaiyo().get異動日()), div.getTajutokuTekiyoJohoIchiran().
                        getReportPublish().getHenshuNaiyo().get枝番());
        TashichosonJushochiTokurei tashichosonJushochiTokurei = 他市町村住所地特例.get(更新前住所地特例);
        return tashichosonJushochiTokurei.createBuilderForEdit().set施設変更通知発行年月日(new FlexibleDate(div.
                getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().
                getCcdPrintContentsSetting().getIssueDate().toDateString())).build();
    }

    private Hokenja 保険者情報取得(HokenjaNo 措置元保険者番号) {

        return HokenjaManagerFactory.createInstance().get保険者(措置元保険者番号, 介護保険);
    }

    private ChohyoSeigyoHanyo 帳票制御情報の取得(ReportId reportId, RString 項目名) {

        ChohyoSeigyoHanyoManager 帳票制御汎用 = new ChohyoSeigyoHanyoManager();
        return 帳票制御汎用.get帳票制御汎用(SubGyomuCode.DBA介護資格, reportId, new FlexibleYear("0000"), 項目名);
    }

    private RString get適用事由(RString 適用事由コード) {
        if (適用事由コード == null || 適用事由コード.isEmpty()) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeMeisho(介護他特適用理由, new Code(適用事由コード)) == null
                ? RString.EMPTY : CodeMaster.getCodeMeisho(介護他特適用理由, new Code(適用事由コード));
    }

    private RString get解除事由(RString 解除事由コード) {
        if (解除事由コード == null || 解除事由コード.isEmpty()) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeMeisho(介護他特解除理由, new Code(解除事由コード)) == null
                ? RString.EMPTY : CodeMaster.getCodeMeisho(介護他特解除理由, new Code(解除事由コード));
    }
}
