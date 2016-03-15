/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5250002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.hanteikekkajouhoushuturyoku.HanteiKekkaJouhouShuturyokuBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.hanteikekkajohoshutsuryoku.HanteiKekkaJohoShutsuryokuBatchParamter;
import jp.co.ndensan.reams.db.dbe.definition.core.hanteikekkajouhoushuturyoku.HanteiKekkaJouhouShuturyokuParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5250002.NijihanteiKekkaOutputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5250002.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.service.core.basic.hanteikekkajouhoushuturyoku.HanteiKekkaJouhouShuturyokuFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 判定結果情報出力(保険者)の取得するクラスです。
 */
public class NijihanteiKekkaOutputHandler {

    private final NijihanteiKekkaOutputDiv nijidiv;
    private final RString 男 = new RString("key0");
    private final RString 女 = new RString("key1");

    /**
     * コンストラクタです。
     *
     * @param nijidiv 判定結果情報出力(保険者)
     */
    public NijihanteiKekkaOutputHandler(NijihanteiKekkaOutputDiv nijidiv) {
        this.nijidiv = nijidiv;
    }

    /**
     * 判定結果情報出力(保険者)初期処理する。
     */
    public void initialize() {
        nijidiv.getKensakuJoken().getTxtNijihanteDateRange().setFromValue(RDate.getNowDate());
        nijidiv.getKensakuJoken().getTxtNijihanteDateRange().setToValue(RDate.getNowDate());
        nijidiv.getKensakuJoken().getTxtHyojiDataLimit().setValue(BusinessConfig.
                get(ConfigNameDBU.検索制御_最大取得件数, SubGyomuCode.DBU介護統計報告));
        List<dgTaishoshaIchiran_Row> dgKoufuKaishuList = new ArrayList<>();
        nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran().setDataSource(dgKoufuKaishuList);
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }

    /**
     * 判定結果情報出力(保険者)検索処理する。
     */
    public void kennsaku() {
        List<dgTaishoshaIchiran_Row> dgTaishoshaIchiranList = new ArrayList<>();
        RString fromtime = RString.EMPTY;
        if (nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getFromValue() != null) {
            fromtime = new RString(nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getFromValue().toString());
        }
        RString totime = RString.EMPTY;
        if (nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getToValue() != null) {
            totime = new RString(nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getToValue().toString());
        }
        boolean 性別男フラグ = false;
        boolean 性別女フラグ = false;
        List<KeyValueDataSource> 性別 = nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                getNinteiShinseishaFinderDiv().getChkSeibetsu().getSelectedItems();
        for (KeyValueDataSource keyValueDataSource : 性別) {
            if (男.equals(keyValueDataSource.getKey())) {
                性別男フラグ = true;
            }
            if (女.equals(keyValueDataSource.getKey())) {
                性別女フラグ = true;
            }
        }

        HanteiKekkaJouhouShuturyokuParameter hanteiParameter = HanteiKekkaJouhouShuturyokuParameter.
                createParam(fromtime,
                        totime,
                        nijidiv.getKensakuJoken().getRadDataShutsuryokuUmu().getSelectedValue(),
                        nijidiv.getKensakuJoken().getRadDataShutsuryokuUmu().getSelectedKey(),
                        nijidiv.getKensakuJoken().getCcdShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlHokenshaNumber().getSelectedItem().get証記載保険者番号().value(),
                        nijidiv.getKensakuJoken().getCcdShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtHihokenshaNumber().getValue(),
                        nijidiv.getKensakuJoken().getCcdShinseishaFinder().getNinteiShinseishaFinderDiv().getDdlShichosonCode().getSelectedKey(),
                        nijidiv.getKensakuJoken().getCcdShinseishaFinder().getNinteiShinseishaFinderDiv().getTxtHihokenshaName().getValue(),
                        !nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                        getNinteiShinseishaFinderDiv().getChkMinashiFlag().getSelectedItems().isEmpty(),
                        nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                        getNinteiShinseishaFinderDiv().getTxtNinteiShinseiDateFrom() == null ? RString.EMPTY
                        : new RString(nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                                getNinteiShinseishaFinderDiv().getTxtNinteiShinseiDateFrom().getValue().toString()),
                        nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                        getNinteiShinseishaFinderDiv().getTxtNinteiShinseiDateTo() == null ? RString.EMPTY
                        : new RString(nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                                getNinteiShinseishaFinderDiv().getTxtNinteiShinseiDateTo().getValue().toString()),
                        nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                        getNinteiShinseishaFinderDiv().getTxtBirthDateFrom() == null ? RString.EMPTY
                        : new RString(nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                                getNinteiShinseishaFinderDiv().getTxtBirthDateFrom().getValue().toString()),
                        nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                        getNinteiShinseishaFinderDiv().getTxtBirthDateTO() == null ? RString.EMPTY
                        : new RString(nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                                getNinteiShinseishaFinderDiv().getTxtBirthDateTO().getValue().toString()),
                        nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                        getNinteiShinseishaFinderDiv().getDdlShinseijiShinseiKubun().getSelectedKey(),
                        性別男フラグ,
                        性別女フラグ,
                        Decimal.ZERO,
                        nijidiv.getKensakuJoken().getCcdShinseishaFinder().
                        getNinteiShinseishaFinderDiv().getDdlHihokenshaNameMatchType().getSelectedKey()
                );
        List<HanteiKekkaJouhouShuturyokuBusiness> ninteiList = HanteiKekkaJouhouShuturyokuFinder.createInstance()
                .getHanteiKekka(hanteiParameter).records();
        if (ninteiList != null && !ninteiList.isEmpty()) {
            for (HanteiKekkaJouhouShuturyokuBusiness jigyoshaInput : ninteiList) {
                dgTaishoshaIchiran_Row dgFukushiyoguShohin = new dgTaishoshaIchiran_Row();
                dgFukushiyoguShohin.getHihokenshaNo().setValue(nullToEmpty(jigyoshaInput.get被保険者番号()));
                dgFukushiyoguShohin.setHihokenshaShimei(nullToEmpty(jigyoshaInput.get被保険者氏名()));
                dgFukushiyoguShohin.setHihokenshaKanaShimei(nullToEmpty(jigyoshaInput.get被保険者カナ氏名()));
                dgFukushiyoguShohin.setSeibetsu(Seibetsu.toValue(jigyoshaInput.get性別()).get名称());
                if (jigyoshaInput.get生年月日() != null) {
                    dgFukushiyoguShohin.getBirthYMD().setValue(new FlexibleDate(jigyoshaInput.get生年月日().toString()));
                }
                dgFukushiyoguShohin.getNinteiShinseiDay().
                        setValue(jigyoshaInput.get認定申請年月日() == null ? FlexibleDate.EMPTY
                                : new FlexibleDate(jigyoshaInput.get認定申請年月日().toString()));
                dgFukushiyoguShohin.setShinseiKubunShinseiji(NinteiShinseiShinseijiKubunCode.
                        toValue(jigyoshaInput.get認定申請区分_申請時コード()).get名称());
                if (jigyoshaInput.get二次判定要介護状態区分コード() != null) {
                    dgFukushiyoguShohin.setNijiHanteiKekka(YokaigoJotaiKubun09.toValue(jigyoshaInput.get二次判定要介護状態区分コード()).get名称());
                }
                RStringBuilder 審査会名称 = new RStringBuilder();
                審査会名称.append(new RString("第"));
                審査会名称.append(jigyoshaInput.get開催番号() == null ? RString.EMPTY : jigyoshaInput.get開催番号());
                審査会名称.append(new RString("回審査会"));
                dgFukushiyoguShohin.setKaigoNinteiShinsakaiName(審査会名称.toRString());
                if (jigyoshaInput.get開催予定日() != null) {
                    dgFukushiyoguShohin.getKaisaiYoteiDay().setValue(new FlexibleDate(jigyoshaInput.get開催予定日().toString()));
                }
                if (jigyoshaInput.get開催日() != null) {
                    dgFukushiyoguShohin.getKaisaiDay().setValue(new FlexibleDate(jigyoshaInput.get開催日().toString()));
                }
                if (jigyoshaInput.get審査会結果情報抽出年月日() == null) {
                    dgFukushiyoguShohin.setDataShutsuryoku(nullToEmpty(jigyoshaInput.get審査会結果情報抽出年月日()));
                } else {
                    dgFukushiyoguShohin.setDataShutsuryoku(new RString("済"));
                }
                dgTaishoshaIchiranList.add(dgFukushiyoguShohin);
            }
            nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran().setDataSource(dgTaishoshaIchiranList);
        }
    }

    /**
     * 判定結果情報出力(保険者)作成画面入力するデータより、バッチ用パラメータクラスを作成します。
     *
     * @return HanteiKekkaJohoShutsuryokuBatchParamter
     */
    public HanteiKekkaJohoShutsuryokuBatchParamter setBatchParameter() {
        List<RString> shinseishoKanriNo = new ArrayList<>();
        for (dgTaishoshaIchiran_Row row : nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran().getDataSource()) {
            if (row.getSelected()) {
                shinseishoKanriNo.add(row.getShinseishoKanriNo());
            }
        }
        HanteiKekkaJohoShutsuryokuBatchParamter hanteibatchParameter
                = new HanteiKekkaJohoShutsuryokuBatchParamter(shinseishoKanriNo,
                        new RString(nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getFromValue().toString()),
                        new RString(nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getToValue().toString()));
        return hanteibatchParameter;
    }

    /**
     * 判定結果情報出力(保険者)作成画面入力するデータより、バッチ用パラメータクラスを作成します。
     *
     * @return HanteiKekkaJohoShutsuryokuBatchParamter
     */
    public HanteiKekkaJohoShutsuryokuBatchParamter setCSVBatchParameter() {
        List<RString> shinseishoKanriNo = new ArrayList<>();
        for (dgTaishoshaIchiran_Row row : nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran().getDataSource()) {
            if (row.getSelected()) {
                shinseishoKanriNo.add(row.getShinseishoKanriNo());
            }
        }
        HanteiKekkaJohoShutsuryokuBatchParamter hanteibatchParameter
                = new HanteiKekkaJohoShutsuryokuBatchParamter(shinseishoKanriNo,
                        new RString(nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getFromValue().toString()),
                        new RString(nijidiv.getKensakuJoken().getTxtNijihanteDateRange().getToValue().toString()));
        return hanteibatchParameter;
    }
}
