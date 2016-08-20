/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBDHanyoList;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd710110.DBD710110_HanyoListKokuhoParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd710120.DBD710120_HanyoListKokiKoreishaParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd710130.DBD710130_HanyoListJigyoTaishoshaParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd710140.DBD710140_HanyoListRiyoshaFutanwariaiParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbdbt13011.HanyoListShisetsuNyutaishoBatchParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbdhanyolist.DBDHanyoListParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyukyotsu.ChushutsuHohoKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2.SoshitsuKubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBDHanyoList.DBDHanyoListStateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBDHanyoList.HanyoListPanelDiv;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 *
 */
public class HanyoListPanel {

    public ResponseData<DBDHanyoListParameter> onClick_btnBatchRegister(HanyoListPanelDiv div) {

        RString batchKind = ResponseHolder.getState();

        DBDHanyoListParameter parameter = new DBDHanyoListParameter();
        parameter.setBatchKind(batchKind);

        if (DBDHanyoListStateName.汎用リスト_施設入退所.getName().equals(batchKind)) {
            HanyoListShisetsuNyutaishoBatchParameter shisetsuNyutaishoBatchParameter = new HanyoListShisetsuNyutaishoBatchParameter();
            shisetsuNyutaishoBatchParameter.set抽出方法区分(ChushutsuHohoKubun.toValue(div.getDdlCyusyutsuhohokubun1().getSelectedKey()));
            shisetsuNyutaishoBatchParameter.set抽出項目区分(div.getTxtCyusyutsukomokukubun1().getValue());
            shisetsuNyutaishoBatchParameter.set基準日(div.getTxtKizyunnichi1().getValue());
            shisetsuNyutaishoBatchParameter.set日付範囲From(div.getTxtHitsukehanifrom1().getValue());
            shisetsuNyutaishoBatchParameter.set日付範囲To(div.getTxtHitsukehanito1().getValue());
            shisetsuNyutaishoBatchParameter.set直近データ抽出(Boolean.parseBoolean(div.getDdlChokindatacyusyutsu1().getSelectedKey().toString()));
            shisetsuNyutaishoBatchParameter.set喪失区分(SoshitsuKubun.toValue(div.getDdlSoshitsukubun1().getSelectedKey()));
            shisetsuNyutaishoBatchParameter.set項目名付加(Boolean.parseBoolean(div.getDdlIsCsvkomokumeifuka1().getSelectedKey().toString()));
            shisetsuNyutaishoBatchParameter.set連番付加(Boolean.parseBoolean(div.getDdlIsCsvrenbanfuka1().getSelectedKey().toString()));
            shisetsuNyutaishoBatchParameter.set日付スラッシュ付加(Boolean.parseBoolean(div.getDdlIsCsvhitsukesurasyuhensyu1().getSelectedKey().toString()));
            shisetsuNyutaishoBatchParameter.set宛名抽出条件(toAtenaSelectBatchParameter(div));
            shisetsuNyutaishoBatchParameter.set出力順(getSyutsuryokujun(div));
            shisetsuNyutaishoBatchParameter.set出力項目(div.getTxtSyutsuryokukomoku1().getValue());
            parameter.setShisetsuNyutaishoBatchParameter(shisetsuNyutaishoBatchParameter);
        }

        if (DBDHanyoListStateName.汎用リスト_国保.getName().equals(batchKind)) {
            DBD710110_HanyoListKokuhoParameter kokuhoParameter = new DBD710110_HanyoListKokuhoParameter();
            kokuhoParameter.setCyusyutsuhohokubun(div.getDdlCyusyutsuhohokubun7().getSelectedKey());
            kokuhoParameter.setCyusyutsukomokukubun(div.getTxtCyusyutsukomokukubun7().getValue());
            kokuhoParameter.setKizyunnichi(div.getTxtKizyunnichi7().getValue());
            kokuhoParameter.setHitsukehanifrom(div.getTxtHitsukehanifrom7().getValue());
            kokuhoParameter.setHitsukehanito(div.getTxtHitsukehanito7().getValue());
            kokuhoParameter.setChokindatacyusyutsu(Boolean.parseBoolean(div.getDdlChokindatacyusyutsu7().getSelectedKey().toString()));
            kokuhoParameter.setSoshitsukubun(div.getDdlSoshitsukubun7().getSelectedKey());
            kokuhoParameter.setCsvkomokumeifuka(Boolean.parseBoolean(div.getDdlIsCsvkomokumeifuka7().getSelectedKey().toString()));
            kokuhoParameter.setCsvrenbanfuka(Boolean.parseBoolean(div.getDdlIsCsvrenbanfuka7().getSelectedKey().toString()));
            kokuhoParameter.setCsvhitsukesurasyuhensyu(Boolean.parseBoolean(div.getDdlIsCsvhitsukesurasyuhensyu7().getSelectedKey().toString()));
            kokuhoParameter.setCyohyoid(div.getTxtCyohyoid7().getValue());
            kokuhoParameter.setAtenacyusyutsujyoken(toAtenaSelectBatchParameter(div));
            kokuhoParameter.setSyutsuryokujun(getSyutsuryokujun(div));
            kokuhoParameter.setSyutsuryokukomoku(div.getTxtSyutsuryokukomoku7().getValue());
            parameter.setKokuhoParameter(kokuhoParameter);
        }

        if (DBDHanyoListStateName.汎用リスト_後期高齢者.getName().equals(batchKind)) {
            DBD710120_HanyoListKokiKoreishaParameter kokiKoreishaParameter = new DBD710120_HanyoListKokiKoreishaParameter();
            kokiKoreishaParameter.setCyusyutsuhohokubun(div.getDdlCyusyutsuhohokubun8().getSelectedKey());
            kokiKoreishaParameter.setCyusyutsukomokukubun(div.getTxtCyusyutsukomokukubun8().getValue());
            kokiKoreishaParameter.setKizyunnichi(div.getTxtKizyunnichi8().getValue());
            kokiKoreishaParameter.setHitsukehanifrom(div.getTxtHitsukehanifrom8().getValue());
            kokiKoreishaParameter.setHitsukehanito(div.getTxtHitsukehanito8().getValue());
            kokiKoreishaParameter.setChokindatacyusyutsu(Boolean.parseBoolean(div.getDdlChokindatacyusyutsu8().getSelectedKey().toString()));
            kokiKoreishaParameter.setSoshitsukubun(div.getDdlSoshitsukubun8().getSelectedKey());
            kokiKoreishaParameter.setCsvkomokumeifuka(Boolean.parseBoolean(div.getDdlIsCsvkomokumeifuka8().getSelectedKey().toString()));
            kokiKoreishaParameter.setCsvrenbanfuka(Boolean.parseBoolean(div.getDdlIsCsvrenbanfuka8().getSelectedKey().toString()));
            kokiKoreishaParameter.setCsvhitsukesurasyuhensyu(Boolean.parseBoolean(div.getDdlIsCsvhitsukesurasyuhensyu8().getSelectedKey().toString()));
            kokiKoreishaParameter.setCyohyoid(div.getTxtCyohyoid8().getValue());
            kokiKoreishaParameter.setAtenacyusyutsujyoken(toAtenaSelectBatchParameter(div));
            kokiKoreishaParameter.setSyutsuryokujun(getSyutsuryokujun(div));
            kokiKoreishaParameter.setSyutsuryokukomoku(div.getTxtSyutsuryokukomoku8().getValue());
            parameter.setKokiKoreishaParameter(kokiKoreishaParameter);

        }

        if (DBDHanyoListStateName.汎用リスト_事業対象者.getName().equals(batchKind)) {
            DBD710130_HanyoListJigyoTaishoshaParameter jigyoTaishoshaParameter = new DBD710130_HanyoListJigyoTaishoshaParameter();
            jigyoTaishoshaParameter.setCyusyutsuhohokubun(div.getDdlCyusyutsuhohokubun9().getSelectedKey());
            jigyoTaishoshaParameter.setCyusyutsukomokukubun(div.getTxtCyusyutsukomokukubun9().getValue());
            jigyoTaishoshaParameter.setKizyunnichi(div.getTxtKizyunnichi9().getValue());
            jigyoTaishoshaParameter.setHitsukehanifrom(div.getTxtHitsukehanifrom9().getValue());
            jigyoTaishoshaParameter.setHitsukehanito(div.getTxtHitsukehanito9().getValue());
            jigyoTaishoshaParameter.setJigyotaishoshacyusyutsu(Boolean.parseBoolean(div.getDdlIsJigyotaishoshacyusyutsu9().getSelectedKey().toString()));
            jigyoTaishoshaParameter.setSoshitsukubun(div.getDdlSoshitsukubun9().getSelectedKey());
            jigyoTaishoshaParameter.setCsvkomokumeifuka(Boolean.parseBoolean(div.getDdlIsCsvkomokumeifuka9().getSelectedKey().toString()));
            jigyoTaishoshaParameter.setCsvrenbanfuka(Boolean.parseBoolean(div.getDdlIsCsvrenbanfuka9().getSelectedKey().toString()));
            jigyoTaishoshaParameter.setCsvhitsukesurasyuhensyu(Boolean.parseBoolean(div.getDdlIsCsvhitsukesurasyuhensyu9().getSelectedKey().toString()));
            jigyoTaishoshaParameter.setCyohyoid(div.getTxtCyohyoid9().getValue());
            jigyoTaishoshaParameter.setAtenacyusyutsujyoken(toAtenaSelectBatchParameter(div));
            jigyoTaishoshaParameter.setSyutsuryokujun(getSyutsuryokujun(div));
            jigyoTaishoshaParameter.setSyutsuryokukomoku(div.getTxtSyutsuryokukomoku9().getValue());
            parameter.setJigyoTaishoshaParameter(jigyoTaishoshaParameter);
        }

        if (DBDHanyoListStateName.汎用リスト_利用者負担割合.getName().equals(batchKind)) {
            DBD710140_HanyoListRiyoshaFutanwariaiParameter riyoshaFutanwariaiParameter = new DBD710140_HanyoListRiyoshaFutanwariaiParameter();
            riyoshaFutanwariaiParameter.setCyusyutsuhohokubun(div.getDdlCyusyutsuhohokubun10().getSelectedKey());
            riyoshaFutanwariaiParameter.setNendo(div.getTxtNendo10().getDomain());
            riyoshaFutanwariaiParameter.setKizyunnichi(div.getTxtKizyunnichi10().getValue());
            riyoshaFutanwariaiParameter.setNendochokindatacyusyutsu(Boolean.parseBoolean(div.getDdlIsNendochokindatacyusyutsu10().getSelectedKey().toString()));
            riyoshaFutanwariaiParameter.setJigyotaishoshafutanichiwari(Boolean.parseBoolean(div.getDdlIsJigyotaishoshafutanichiwari10().getSelectedKey().toString()));
            riyoshaFutanwariaiParameter.setJigyotaishoshafutanniwari(Boolean.parseBoolean(div.getDdlIsJigyotaishoshafutanniwari10().getSelectedKey().toString()));
            riyoshaFutanwariaiParameter.setCsvkomokumeifuka(Boolean.parseBoolean(div.getDdlIsCsvkomokumeifuka10().getSelectedKey().toString()));
            riyoshaFutanwariaiParameter.setCsvrenbanfuka(Boolean.parseBoolean(div.getDdlIsCsvrenbanfuka10().getSelectedKey().toString()));
            riyoshaFutanwariaiParameter.setCsvhitsukesurasyuhensyu(Boolean.parseBoolean(div.getDdlIsCsvhitsukesurasyuhensyu10().getSelectedKey().toString()));
            riyoshaFutanwariaiParameter.setCyohyoid(div.getTxtCyohyoid10().getValue());
            riyoshaFutanwariaiParameter.setAtenacyusyutsujyoken(toAtenaSelectBatchParameter(div));
            riyoshaFutanwariaiParameter.setSyutsuryokujun(getSyutsuryokujun(div));
            riyoshaFutanwariaiParameter.setSyutsuryokukomoku(div.getTxtSyutsuryokukomoku10().getValue());
            parameter.setRiyoshaFutanwariaiParameter(riyoshaFutanwariaiParameter);
        }

        return ResponseData.of(parameter).respond();
    }

    private AtenaSelectBatchParameter toAtenaSelectBatchParameter(HanyoListPanelDiv div) {
        AtenaSelectBatchParameter parameter = new AtenaSelectBatchParameter();
        parameter.setAgeSelectKijun(NenreiSoChushutsuHoho.toValue(div.getDdlAgeSelectKijun().getSelectedKey()));
        Range<Decimal> nenreiRange = new Range(div.getTxtNenreiRange().getFromValue(), div.getTxtNenreiRange().getToValue());
        parameter.setNenreiRange(nenreiRange);
        parameter.setNenreiKijunbi(div.getTxtNenreiKijunbi().getValue());
        Range<RDate> seinengappiRange = new Range(div.getTxtSeinengappiRange().getFromValue(), div.getTxtSeinengappiRange().getToValue());
        parameter.setSeinengappiRange(seinengappiRange);
        parameter.setShichoson_Code(new LasdecCode(div.getTxtShichosonCode().getValue()));
        parameter.setShichoson_Mesho(div.getTxtShichosonMesho().getValue());
        parameter.setChiku_Kubun(Chiku.toValue(div.getDdlChikuKubun().getSelectedKey()));
        parameter.setJusho_From(div.getTxtJushoFrom().getValue());
        parameter.setJusho_FromMesho(div.getTxtJushoFromMesho().getValue());
        parameter.setJusho_To(div.getTxtJushoTo().getValue());
        parameter.setJusho_ToMesho(div.getTxtJushoToMesho().getValue());
        parameter.setGyoseiku_From(div.getTxtGyoseikuFrom().getValue());
        parameter.setGyoseiku_FromMesho(div.getTxtGyoseikuFromMesho().getValue());
        parameter.setGyoseiku_To(div.getTxtGyoseikuTo().getValue());
        parameter.setGyoseiku_ToMesho(div.getTxtGyoseikuToMesho().getValue());
        parameter.setChiku1_From(div.getTxtChiku1From().getValue());
        parameter.setChiku1_FromMesho(div.getTxtChiku1FromMesho().getValue());
        parameter.setChiku1_To(div.getTxtChiku1To().getValue());
        parameter.setChiku1_ToMesho(div.getTxtChiku1ToMesho().getValue());
        parameter.setChiku2_From(div.getTxtChiku2From().getValue());
        parameter.setChiku2_FromMesho(div.getTxtChiku2FromMesho().getValue());
        parameter.setChiku2_To(div.getTxtChiku2To().getValue());
        parameter.setChiku2_ToMesho(div.getTxtChiku2ToMesho().getValue());
        parameter.setChiku3_From(div.getTxtChiku3From().getValue());
        parameter.setChiku3_FromMesho(div.getTxtChiku3FromMesho().getValue());
        parameter.setChiku3_To(div.getTxtChiku3To().getValue());
        parameter.setChiku3_ToMesho(div.getTxtChiku3ToMesho().getValue());
        return parameter;
    }

    private long getSyutsuryokujun(HanyoListPanelDiv div) {
        return div.getCcdShutsuryokujun().get出力順ID();
    }

    public ResponseData<HanyoListPanelDiv> onClick_btnShutsuryokujun(HanyoListPanelDiv div) {

        RString batchKind = ResponseHolder.getState();

        if (DBDHanyoListStateName.汎用リスト_施設入退所.getName().equals(batchKind)) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBD介護受給, new ReportId(div.getTxtCyohyoid1().getValue()));
        }

        if (DBDHanyoListStateName.汎用リスト_国保.getName().equals(batchKind)) {

            div.getCcdShutsuryokujun().load(SubGyomuCode.DBD介護受給, new ReportId(div.getTxtCyohyoid7().getValue()));
        }

        if (DBDHanyoListStateName.汎用リスト_後期高齢者.getName().equals(batchKind)) {

            div.getCcdShutsuryokujun().load(SubGyomuCode.DBD介護受給, new ReportId(div.getTxtCyohyoid8().getValue()));
        }

        if (DBDHanyoListStateName.汎用リスト_事業対象者.getName().equals(batchKind)) {

            div.getCcdShutsuryokujun().load(SubGyomuCode.DBD介護受給, new ReportId(div.getTxtCyohyoid9().getValue()));
        }

        if (DBDHanyoListStateName.汎用リスト_利用者負担割合.getName().equals(batchKind)) {

            div.getCcdShutsuryokujun().load(SubGyomuCode.DBD介護受給, new ReportId(div.getTxtCyohyoid10().getValue()));
        }
        return ResponseData.of(div).respond();
    }
}
