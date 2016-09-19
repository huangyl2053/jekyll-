/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBDHanyoList;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710150.DBD710150_HanyoListShisetsuNyutaishoParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd710040.DBD710040_HanyoListRiyoshaFutanGakuGengakuParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd710060.DBD710060_HanyoListShakaiFukushiHojinKeigenParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd710070.DBD710070_HanyoListTokubetsuChiikiKasanGemmenParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd710110.DBD710110_HanyoListKokuhoParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd710120.DBD710120_HanyoListKokiKoreishaParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd710130.DBD710130_HanyoListJigyoTaishoshaParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd710140.DBD710140_HanyoListRiyoshaFutanwariaiParameter;
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

    public ResponseData<HanyoListPanelDiv> onLoad(HanyoListPanelDiv div) {

        RString batchKind = ResponseHolder.getState();

        if (DBDHanyoListStateName.汎用リスト_社会福祉法人軽減.getName().equals(batchKind)
                || DBDHanyoListStateName.汎用リスト_特別地域加算減免.getName().equals(batchKind)
                || DBDHanyoListStateName.汎用リスト_利用者負担額減免.getName().equals(batchKind)) {
            div.getBtnShutsuryokujun().setDisplayNone(true);
        } else {
            div.getBtnShutsuryokujun().setDisplayNone(false);
        }

        return ResponseData.of(div).respond();
    }

    public ResponseData<DBDHanyoListParameter> onClick_btnBatchRegister(HanyoListPanelDiv div) {

        RString batchKind = ResponseHolder.getState();

        DBDHanyoListParameter parameter = new DBDHanyoListParameter();
        parameter.setBatchKind(batchKind);

        if (DBDHanyoListStateName.汎用リスト_施設入退所.getName().equals(batchKind)) {
            DBD710150_HanyoListShisetsuNyutaishoParameter shisetsuNyutaishoBatchParameter = new DBD710150_HanyoListShisetsuNyutaishoParameter();
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

        if (DBDHanyoListStateName.汎用リスト_利用者負担額減免.getName().equals(batchKind)) {
            DBD710040_HanyoListRiyoshaFutanGakuGengakuParameter riyoshaFutanGakuGengakuParameter = new DBD710040_HanyoListRiyoshaFutanGakuGengakuParameter();
            riyoshaFutanGakuGengakuParameter.setHyoudai(div.getTxtHyoudai2().getValue());
            riyoshaFutanGakuGengakuParameter.setDetasyubetsumesyo(div.getTxtDetasyubetsumesyo2().getValue());
            riyoshaFutanGakuGengakuParameter.setSyutsuryoku(div.getTxtSyutsuryoku2().getValue());
            riyoshaFutanGakuGengakuParameter.setCyusyutsuhohokubun(div.getDdlCyusyutsuhohokubun2().getSelectedKey());
            riyoshaFutanGakuGengakuParameter.setCyusyutsukomokukubun(div.getTxtCyusyutsukomokukubun2().getValue());
            riyoshaFutanGakuGengakuParameter.setKizyunnichi(div.getTxtKizyunnichi2().getValue());
            riyoshaFutanGakuGengakuParameter.setHitsukehanifrom(div.getTxtHitsukehanifrom2().getValue());
            riyoshaFutanGakuGengakuParameter.setHitsukehanito(div.getTxtHitsukehanito2().getValue());
            riyoshaFutanGakuGengakuParameter.setChokindatacyusyutsu(Boolean.parseBoolean(div.getDdlChokindatacyusyutsu2().getSelectedKey().toString()));
            riyoshaFutanGakuGengakuParameter.setShinseishadatacyushutsu(Boolean.parseBoolean(div.getDdlIsShinseishadatacyushutsu2().getSelectedKey().toString()));
            riyoshaFutanGakuGengakuParameter.setKyusochisha(div.getTxtKyusochisha2().getValue());
            riyoshaFutanGakuGengakuParameter.setKyakasha(div.getTxtKyakasha2().getValue());
            riyoshaFutanGakuGengakuParameter.setSoshitsukubun(div.getDdlSoshitsukubun2().getSelectedKey());
            riyoshaFutanGakuGengakuParameter.setCsvkomokumeifuka(Boolean.parseBoolean(div.getDdlIsCsvkomokumeifuka2().getSelectedKey().toString()));
            riyoshaFutanGakuGengakuParameter.setCsvrenbanfuka(Boolean.parseBoolean(div.getDdlIsCsvrenbanfuka2().getSelectedKey().toString()));
            riyoshaFutanGakuGengakuParameter.setCsvhitsukesurasyuhensyu(Boolean.parseBoolean(div.getDdlIsCsvhitsukesurasyuhensyu2().getSelectedKey().toString()));
            riyoshaFutanGakuGengakuParameter.setAtenacyusyutsujyoken(toAtenaSelectBatchParameter(div));
            riyoshaFutanGakuGengakuParameter.setCyohyoid(div.getTxtCyohyoid2().getValue());
            riyoshaFutanGakuGengakuParameter.setSyutsuryokujunparameter(div.getTxtSyutsuryokujunparameter2().getValue());
            riyoshaFutanGakuGengakuParameter.setSyutsuryokukomoku(div.getTxtSyutsuryokukomoku2().getValue());
            parameter.setRiyoshaFutanGakuGengakuParameter(riyoshaFutanGakuGengakuParameter);
        }

        if (DBDHanyoListStateName.汎用リスト_社会福祉法人軽減.getName().equals(batchKind)) {
            DBD710060_HanyoListShakaiFukushiHojinKeigenParameter shakaiFukushiHojinKeigenParameter = new DBD710060_HanyoListShakaiFukushiHojinKeigenParameter();
            shakaiFukushiHojinKeigenParameter.setHyoudai(div.getTxtHyoudai4().getValue());
            shakaiFukushiHojinKeigenParameter.setCyusyutsuhohokubun(div.getDdlCyusyutsuhohokubun4().getSelectedKey());
            shakaiFukushiHojinKeigenParameter.setCyusyutsukomokukubun(div.getTxtCyusyutsukomokukubun4().getValue());
            shakaiFukushiHojinKeigenParameter.setNendo(div.getTxtNendo4().getDomain());
            shakaiFukushiHojinKeigenParameter.setKizyunnichi(div.getTxtKizyunnichi4().getValue());
            shakaiFukushiHojinKeigenParameter.setHitsukehanifrom(div.getTxtHitsukehanifrom4().getValue());
            shakaiFukushiHojinKeigenParameter.setHitsukehanito(div.getTxtHitsukehanito4().getValue());
            shakaiFukushiHojinKeigenParameter.setNendochokindatacyusyutsu(Boolean.parseBoolean(div.getDdlIsNendochokindatacyusyutsu4().getSelectedKey().toString()));
            shakaiFukushiHojinKeigenParameter.setChokindatacyusyutsu(Boolean.parseBoolean(div.getDdlChokindatacyusyutsu4().getSelectedKey().toString()));
            shakaiFukushiHojinKeigenParameter.setShinseishadatacyushutsu(Boolean.parseBoolean(div.getDdlIsShinseishadatacyushutsu4().getSelectedKey().toString()));
            shakaiFukushiHojinKeigenParameter.setJigyotaisyoshadatacyushutsu(Boolean.parseBoolean(div.getDdlIsJigyotaishoshacyusyutsu4().getSelectedKey().toString()));
            shakaiFukushiHojinKeigenParameter.setKyusochisha(div.getTxtKyusochisha4().getValue());
            shakaiFukushiHojinKeigenParameter.setHobetsukubun(div.getTxtHobetsukubun4().getValue());
            shakaiFukushiHojinKeigenParameter.setKyakasha(div.getTxtKyakasha4().getValue());
            shakaiFukushiHojinKeigenParameter.setSoshitsukubun(div.getDdlSoshitsukubun4().getSelectedKey());
            shakaiFukushiHojinKeigenParameter.setShiteinyushoshakyusochisha(Boolean.parseBoolean(div.getDdlShiteinyushoshakyusochisha4().getSelectedKey().toString()));
            shakaiFukushiHojinKeigenParameter.setShiteinyushoshafutankeigensha(Boolean.parseBoolean(div.getDdlShiteinyushoshafutankeigensha4().getSelectedKey().toString()));
            shakaiFukushiHojinKeigenParameter.setShiteinyushoshasonota(Boolean.parseBoolean(div.getDdlShiteinyushoshasonota4().getSelectedKey().toString()));
            shakaiFukushiHojinKeigenParameter.setShiteinyushoshadaiichidankai(Boolean.parseBoolean(div.getDdlShiteinyushoshadaiichidankai4().getSelectedKey().toString()));
            shakaiFukushiHojinKeigenParameter.setShiteinyushoshadainidankai(Boolean.parseBoolean(div.getDdlShiteinyushoshadainidankai4().getSelectedKey().toString()));
            shakaiFukushiHojinKeigenParameter.setShiteinyushoshadaisandankai(Boolean.parseBoolean(div.getDdlShiteinyushoshadaisandankai4().getSelectedKey().toString()));
            shakaiFukushiHojinKeigenParameter.setShiteinyushoshakazeisou(Boolean.parseBoolean(div.getDdlShiteinyushoshakazeisou4().getSelectedKey().toString()));
            shakaiFukushiHojinKeigenParameter.setJigyotaishoshafutanichiwari(Boolean.parseBoolean(div.getDdlIsJigyotaishoshafutanichiwari4().getSelectedKey().toString()));
            shakaiFukushiHojinKeigenParameter.setJigyotaishoshafutanniwari(Boolean.parseBoolean(div.getDdlIsJigyotaishoshafutanniwari4().getSelectedKey().toString()));
            shakaiFukushiHojinKeigenParameter.setCsvkomokumeifuka(Boolean.parseBoolean(div.getDdlIsCsvkomokumeifuka4().getSelectedKey().toString()));
            shakaiFukushiHojinKeigenParameter.setCsvrenbanfuka(Boolean.parseBoolean(div.getDdlIsCsvrenbanfuka4().getSelectedKey().toString()));
            shakaiFukushiHojinKeigenParameter.setCsvhitsukesurasyuhensyu(Boolean.parseBoolean(div.getDdlIsCsvhitsukesurasyuhensyu4().getSelectedKey().toString()));
            shakaiFukushiHojinKeigenParameter.setChizubunpuzusakusei(Boolean.parseBoolean(div.getDdlIsChizubunpuzusakusei4().getSelectedKey().toString()));
            shakaiFukushiHojinKeigenParameter.setAtenacyusyutsujyoken(toAtenaSelectBatchParameter(div));
            shakaiFukushiHojinKeigenParameter.setCyohyoid(div.getTxtCyohyoid4().getValue());
            shakaiFukushiHojinKeigenParameter.setCyohyomei(div.getTxtCyohyomei4().getValue());
            shakaiFukushiHojinKeigenParameter.setSyutsuryokujunparameter(div.getTxtSyutsuryokujunparameter4().getValue());
            shakaiFukushiHojinKeigenParameter.setSyutsuryokukomoku(div.getTxtSyutsuryokukomoku4().getValue());
            shakaiFukushiHojinKeigenParameter.setDounyudantaicode(div.getTxtDounyudantaicode4().getValue());
            shakaiFukushiHojinKeigenParameter.setShichosonmei(div.getTxtShichosonmei4().getValue());
            shakaiFukushiHojinKeigenParameter.setJobno(div.getTxtJobno4().getValue());
            shakaiFukushiHojinKeigenParameter.setSyutsuryokupagesu(div.getTxtSyutsuryokupagesu4().getValue());
            shakaiFukushiHojinKeigenParameter.setCsvsyutsuryokuumu(div.getTxtCsvsyutsuryokuumu4().getValue());
            shakaiFukushiHojinKeigenParameter.setCsvfilename(div.getTxtCsvfilename4().getValue());
            shakaiFukushiHojinKeigenParameter.setSyutsuryokujyoken(div.getTxtSyutsuryokujyoken4().getValue());
            parameter.setShakaiFukushiHojinKeigenParameter(shakaiFukushiHojinKeigenParameter);
        }

        if (DBDHanyoListStateName.汎用リスト_特別地域加算減免.getName().equals(batchKind)) {
            DBD710070_HanyoListTokubetsuChiikiKasanGemmenParameter tokubetsuChiikiKasanGemmenParameter = new DBD710070_HanyoListTokubetsuChiikiKasanGemmenParameter();
            tokubetsuChiikiKasanGemmenParameter.setHyoudai(div.getTxtHyoudai5().getValue());
            tokubetsuChiikiKasanGemmenParameter.setDetasyubetsumesyo(div.getTxtDetasyubetsumesyo5().getValue());
            tokubetsuChiikiKasanGemmenParameter.setSyutsuryoku(div.getTxtSyutsuryoku5().getValue());
            tokubetsuChiikiKasanGemmenParameter.setCyusyutsuhohokubun(div.getDdlCyusyutsuhohokubun5().getSelectedKey());
            tokubetsuChiikiKasanGemmenParameter.setCyusyutsukomokukubun(div.getTxtCyusyutsukomokukubun5().getValue());
            tokubetsuChiikiKasanGemmenParameter.setKizyunnichi(div.getTxtKizyunnichi5().getValue());
            tokubetsuChiikiKasanGemmenParameter.setHitsukehanifrom(div.getTxtHitsukehanifrom5().getValue());
            tokubetsuChiikiKasanGemmenParameter.setHitsukehanito(div.getTxtHitsukehanito5().getValue());
            tokubetsuChiikiKasanGemmenParameter.setChokindatacyusyutsu(Boolean.parseBoolean(div.getDdlChokindatacyusyutsu5().getSelectedKey().toString()));
            tokubetsuChiikiKasanGemmenParameter.setShinseishadatacyushutsu(Boolean.parseBoolean(div.getDdlIsShinseishadatacyushutsu5().getSelectedKey().toString()));
            tokubetsuChiikiKasanGemmenParameter.setKyakasha(div.getTxtKyakasha5().getValue());
            tokubetsuChiikiKasanGemmenParameter.setSoshitsukubun(div.getDdlSoshitsukubun5().getSelectedKey());
            tokubetsuChiikiKasanGemmenParameter.setCsvkomokumeifuka(Boolean.parseBoolean(div.getDdlIsCsvkomokumeifuka5().getSelectedKey().toString()));
            tokubetsuChiikiKasanGemmenParameter.setCsvrenbanfuka(Boolean.parseBoolean(div.getDdlIsCsvrenbanfuka5().getSelectedKey().toString()));
            tokubetsuChiikiKasanGemmenParameter.setCsvhitsukesurasyuhensyu(Boolean.parseBoolean(div.getDdlIsCsvhitsukesurasyuhensyu5().getSelectedKey().toString()));
            tokubetsuChiikiKasanGemmenParameter.setAtenacyusyutsujyoken(toAtenaSelectBatchParameter(div));
            tokubetsuChiikiKasanGemmenParameter.setCyohyoid(div.getTxtCyohyoid5().getValue());
            tokubetsuChiikiKasanGemmenParameter.setSyutsuryokujunparameter(div.getTxtSyutsuryokujunparameter5().getValue());
            tokubetsuChiikiKasanGemmenParameter.setSyutsuryokukomoku(div.getTxtSyutsuryoku5().getValue());
            parameter.setTokubetsuChiikiKasanGemmenParameter(tokubetsuChiikiKasanGemmenParameter);
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
