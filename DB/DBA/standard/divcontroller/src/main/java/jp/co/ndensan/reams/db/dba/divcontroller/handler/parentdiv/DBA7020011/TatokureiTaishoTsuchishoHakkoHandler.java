/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA7010011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tajushochitokureisyakanri.TaJushochiTokureisyaKanriMaster;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7010011.ShikakuKihonJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7010011.dgJushochiTokureiRireki_Row;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 他市町村住所地特例者関連帳票発行のバリデーションチェッククラスです。
 *
 * @reamsid_L DBA-0380-020 houtianpeng
 */
public class ShikakuKihonJohoHandler {

    private final ShikakuKihonJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 他市町村住所地特例者関連帳票発行Div
     */
    public ShikakuKihonJohoHandler(ShikakuKihonJohoDiv div) {
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
        div.getTajutokuTekiyoJohoIchiran().getDgJushochiTokureiRireki().setDataSource(rowList);
    }

    private void 適用情報Gridの編集(TaJushochiTokureisyaKanriMaster master, dgJushochiTokureiRireki_Row row) {

        RString 保険者名 = master.getHokenjaName();
        row.setTekiyoJiyu(master.getTekiyoJiyuCode() == null ? RString.EMPTY : master.getTekiyoJiyuCode());
        row.getTekiyoDate().setValue(master.getTekiyoYMD() == null ? FlexibleDate.EMPTY : master.getTekiyoYMD());
        row.getTekiyoTodokedeDate().setValue(master.getTekiyoTodokedeYMD() == null ? FlexibleDate.EMPTY : master.getTekiyoTodokedeYMD());
        row.setKaijoJiyu(master.getKaijoJiyuCode() == null ? RString.EMPTY : master.getKaijoJiyuCode());
        row.getKaijoDate().setValue(master.getKaijoYMD() == null ? FlexibleDate.EMPTY : master.getKaijoYMD());
        row.getKaijoTodokedeDate().setValue(master.getKaijoTodokedeYMD() == null ? FlexibleDate.EMPTY : master.getKaijoTodokedeYMD());
        row.setSochiHokenshaNo(master.getSochiHokenshaNo() == null ? RString.EMPTY : master.getSochiHokenshaNo().value());
        row.setSochiHokenshaMeisho(保険者名 == null ? RString.EMPTY : 保険者名);
        row.setSochiHihokenshaNo(master.getSochiHihokenshaNo() == null ? RString.EMPTY : master.getSochiHihokenshaNo().value());
        row.getNyushoDate().setValue(master.getNyushoYMD() == null ? FlexibleDate.EMPTY : master.getNyushoYMD());
        row.getTaishoDate().setValue(master.getTaishoYMD() == null ? FlexibleDate.EMPTY : master.getTaishoYMD());
        row.setShisetsuShurui(master.getNyushoShisetsuShurui() == null ? RString.EMPTY : ShisetsuType.toValue(master.getNyushoShisetsuShurui()).getName());
        row.setNyushoShisetsu(master.getNyushoShisetsuCode() == null ? RString.EMPTY : master.getNyushoShisetsuCode().value());
        row.getRenrakuhyoHakkoDate().setValue(master.getTatokuRenrakuhyoHakkoYMD() == null ? FlexibleDate.EMPTY : master.getTatokuRenrakuhyoHakkoYMD());
        row.getShisetuTaishoTuchiHakkoDate().setValue(master.getShisetsuTaishoTsuchiHakkoYMD() == null ? FlexibleDate.EMPTY : master.getShisetsuTaishoTsuchiHakkoYMD());
        row.getShisetsuHenkoTuchiHakkoDate().setValue(master.getShisetsuHenkoTsuchiHakkoYMD() == null ? FlexibleDate.EMPTY : master.getShisetsuHenkoTsuchiHakkoYMD());
        row.getIdoYMD().setValue(master.getIdoYMD() == null ? FlexibleDate.EMPTY : master.getIdoYMD());
        row.setEdaNo(master.getEdaNo() == null ? RString.EMPTY : master.getEdaNo());
    }
    /**
     * 編集内容か表示され、編集ができる。
     *
     * @param 文書番号取得 文書番号取得
     */
    public void 適用情報の編集(RString 文書番号取得) {

        dgJushochiTokureiRireki_Row row = div.getTajutokuTekiyoJohoIchiran().getDgJushochiTokureiRireki().getActiveRow();
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getCcdZenkokuJushoInput().get郵便番号();
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getCcdZenkokuJushoInput().get全国住所コード();
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getCcdZenkokuJushoInput().get全国住所名称();

        div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtYakushoMeiOne().setValue(row.getSochiHokenshaMeisho());
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtYakushoMeiTwo().setValue(row.getSochiHokenshaMeisho());
        // TODO： QA1036役所名敬称
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtOnchu().setValue(RString.EMPTY);
        // TODO： QA1036担当課名
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtTantokamei().setValue(RString.EMPTY);
        // TODO： QA1036担当課名敬称
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtSam().setValue(RString.EMPTY);
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtBunshoBango().setValue(文書番号取得);
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().set他市町村住所地特例枝番(row.getEdaNo());
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().set他市町村住所地特例異動日(new RString(row.getIdoYMD().getValue().toString()));
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().set入所日(new RString(row.getNyushoDate().getValue().toString()));
    }
}
